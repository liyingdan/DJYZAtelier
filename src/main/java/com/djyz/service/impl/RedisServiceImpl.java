package com.djyz.service.impl;

import com.djyz.service.RedisService;
import com.djyz.util.AjaxRes;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author liyingdan
 * @date 2020/3/29
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /*
    * 将字符串类型的键值对保存到Redis时调用
    * */
    @Override
    public Boolean saveNormalStringKeyValue(String normalKey, String normalValue, Integer timeoutMinute) {
        // 获取字符串操作器对象
        ValueOperations<String, String> operator = redisTemplate.opsForValue();
        // 判断timeoutMinute值：是否为无效值
        if(timeoutMinute == null || timeoutMinute == 0) {
            return false;
        }
        // 判断timeoutMinute值：是否为不设置过期时间
        if(timeoutMinute == -1) {
            // 按照不设置过期时间的方式执行保存
            try {
                operator.set(normalKey, normalValue);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
            // 返回结果
            return true;
        }
        // 按照设置过期时间的方式执行保存
        try {
            operator.set(normalKey, normalValue, timeoutMinute, TimeUnit.MINUTES);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 根据key查询对应value时调用
     */
    @Override
    public String retrieveStringValueByStringKey(String normalKey) {
        try {
            return redisTemplate.opsForValue().get(normalKey);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 根据key删除对应value时调用
     */
    @Override
    public Boolean removeByKey(String key) {
        try {
            redisTemplate.delete(key);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /*
    * hash 类型保存
    * */
    @Override
    public Boolean saveHashValue(String hashId, Map<String, Object> keyAndValue) {
        System.out.println("---------------------"+keyAndValue);
//    public Boolean saveHashValue(String hashId, String key, Object value) {
        HashOperations<String, String, Object> sooho = redisTemplate.opsForHash();
        try {
//            sooho.put(hashId,key,value);
            Set<String> set = keyAndValue.keySet();
            Iterator<String> iterator = set.iterator();
            while (iterator.hasNext()){
                String next = iterator.next();
                System.out.println("保存到redis 的key值--------------"+next);
                sooho.put(hashId,next,keyAndValue.get(next));
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /*
     * 获取hash 类型值
     * */
    @Override
    public Map<Object, Object> getHashValve(String key) {
//        HashOperations<String, Object, Object> sooho = redisTemplate.opsForHash();
//        return sooho.entries(key);
        return redisTemplate.boundHashOps(key).entries();

    }

}
