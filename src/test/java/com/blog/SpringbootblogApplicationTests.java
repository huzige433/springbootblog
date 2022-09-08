package com.blog;

import com.blog.Domain.User;
import com.blog.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class SpringbootblogApplicationTests {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() throws InterruptedException {
        //插入单条数据
        redisTemplate.opsForValue().set("key1", "我是新信息");
        System.out.println(redisTemplate.opsForValue().get("key1"));
//插入单条数据（存在有效期）
        System.out.println("-----------------");
        redisTemplate.opsForValue().set("key2", "这是一条会过期的信息", 1, TimeUnit.MINUTES);//向redis里存入数据和设置缓存时间
        System.out.println(redisTemplate.hasKey("key2"));//检查key是否存在，返回boolean值
        System.out.println(redisTemplate.opsForValue().get("key2"));
        Thread.sleep(2000);
        System.out.println(redisTemplate.hasKey("key2"));//检查key是否存在，返回boolean值
        System.out.println(redisTemplate.opsForValue().get("key2"));
        System.out.println("-----------------");

    }
    @Test
    void mysqltest(){
        User user=new User();
        user.setUsername("test1");
        user.setPassword("test2");
        user.setType(1);
        userDao.insert(user);
    }
}
