package com.example.demo3;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.data.redis.core.StringRedisTemplate;


@RunWith(SpringRunner.class)
@SpringBootTest
class Demo3ApplicationTests {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Test
    void contextLoads() {
        stringRedisTemplate.opsForValue().set("test","redis");
        Assert.assertEquals("redis", stringRedisTemplate.opsForValue().get("test"));
//        Assert.assertEquals("1","1");
    }

}
