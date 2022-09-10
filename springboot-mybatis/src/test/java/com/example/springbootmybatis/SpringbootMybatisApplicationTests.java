package com.example.springbootmybatis;

import com.example.springbootmybatis.mapper.UserMapper;
import com.example.springbootmybatis.mapper.UserXmlMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootMybatisApplicationTests {



    @Autowired
    private UserMapper userMapper;


    @Autowired
    private UserXmlMapper userXmlMapper;

    @Test
    void testFindAll() {
        userMapper.findAll().forEach(System.out::println);
    }

    @Test
    void testFindAll2() {
        userXmlMapper.findAll().forEach(System.out::println);
    }

}
