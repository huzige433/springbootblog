package com.blog.manager;

import com.blog.Domain.User;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class RedisManger {

    @Resource
    private RedisTemplate redisTemplate;


    @SuppressWarnings("unchecked")
    public  Object getKeyValue(String key) {
        ValueOperations<String, String> valueops = redisTemplate.opsForValue();
        return valueops.get(key);
    }

    @SuppressWarnings("unchecked")
    public void setKeyValue(String key, String value,long timeout) {
        ValueOperations<String, String> valueops = redisTemplate.opsForValue();
        valueops.set(key, value,timeout);
    }

    public void setKeyValue(String key, String value, int expire) {
        ValueOperations<String, String> valueops = redisTemplate.opsForValue();
        valueops.set(key, value, expire, TimeUnit.SECONDS);
    }
}
