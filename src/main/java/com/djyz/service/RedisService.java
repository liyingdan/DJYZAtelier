package com.djyz.service;

/**
 * @author liyingdan
 * @date 2020/3/29
 */
public interface RedisService {
    /**
     * 将字符串类型的键值对保存到Redis时调用
     * @param normalKey
     * @param normalValue
     * @param timeoutMinute	超时时间（单位：分钟）
     * 		-1表示无过期时间
     * 		正数表示过期时间分钟数
     * 		0和null值不接受
     * @return
     */
    Boolean saveNormalStringKeyValue(String normalKey, String normalValue, Integer timeoutMinute);

    /**
     * 根据key查询对应value时调用
     */
    String retrieveStringValueByStringKey(String normalKey);

    /**
     * 根据key删除对应value时调用
     */
    Boolean removeByKey(String key);
}
