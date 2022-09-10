package com.example.springredis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SpringRedisApplicationTests {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void testSet(){
        redisTemplate.boundValueOps("name").set("lingnian");
    }

    @Test
    public void testGet(){
        Object name = redisTemplate.boundValueOps("name").get();
        System.out.println(name);
    }

}
