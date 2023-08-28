package com.dykj.webApi.service.common;



import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Author: 张景川
 * Description: redisService工具类
 */
@Service(value = "redisUtilService")
public class RedisUtilServiceImpl {

    private final StringRedisTemplate redisTemplate;

    public RedisUtilServiceImpl(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public Set<String> getKeys(String pre) {
        return redisTemplate.keys(pre);
    }

    /**
     * 判断key是否存在0
     * @param key 待判断的key
     * @return 存在返回true
     */
    public boolean hasKey(String key) {
        return this.redisTemplate.hasKey(key);
    }

    /**
     * 删除key和value
     * @param key 待删除的key
     */
    public void delete(String key) {
        if (this.hasKey(key)){
            redisTemplate.delete(key);
        }
    }

    /**
     * 根据key获取value
     * @param key redis-key
     * @return String
     */
    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 将key和value存入redis，并设置有效时间，单位：秒
     * @param key     redis-key
     * @param value   redis-value
     * @param timeout 过期时间，秒
     */
    public void set(String key, String value, long timeout) {
        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }

    /**
     * 将key和value存入redis，并设置有效时间，单位：秒
     * @param key     redis-key
     * @param value   redis-value
     * @param timeout 过期时间，秒
     */
    public void set(String key, int value, long timeout) {
        redisTemplate.opsForValue().set(key, String.valueOf(value), timeout, TimeUnit.SECONDS);
    }

    /**
     * 将key和value存入redis
     * @param key   redis-key
     * @param value redis-value
     */
    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 从redis中获取map
     * @param key redis-key
     * @return Map
     */
    public Map<String, Object> getMap(String key) {
        HashOperations<String, String, Object> hash = redisTemplate.opsForHash();
        return hash.entries(key);
    }

    /**
     * 将map存入redis，并设置时效 单位:秒
     * @param key     redis-key
     * @param map     带保存的map
     * @param timeout 过期时间  单位：秒
     */
    public void set(String key, Map<? extends String, ? extends Object> map, long timeout) {
        redisTemplate.opsForHash().putAll(key, map);
        redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }

    /**
     * 获取10秒内的自增数据
     * @param key 带获取值的键
     * @return 自动数据
     */
    public long incr(String key) {
        Long increment = redisTemplate.opsForValue().increment(key);
        Long expire = redisTemplate.getExpire(key);
        if (expire == null || expire == -1) {
            this.redisTemplate.expire(key, 10, TimeUnit.SECONDS);
        }
        return increment;
    }

    /**
     * 递增
     * @param key   键
     * @param delta 要增加几(大于0)
     * @return
     */
    public long incr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递增因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * 递减
     * @param key   键
     * @param delta 要减少几(小于0)
     * @return
     */
    public long decr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递减因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, -delta);
    }
}
