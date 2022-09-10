package com.example.springbootjunittest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//对应子包-包名不同----参数(classes = SpringbootJunitTestApplication.class)
//@SpringBootTest(classes = SpringbootJunitTestApplication.class)

//对应子包--包名相同这样写
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void add() {
        userService.add();
    }
}