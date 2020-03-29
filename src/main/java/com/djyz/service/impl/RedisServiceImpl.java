package com.djyz.service.impl;

import com.djyz.service.RedisService;
import com.djyz.util.AjaxRes;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

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
            String value = redisTemplate.opsForValue().get(normalKey);

            return value;

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
}
