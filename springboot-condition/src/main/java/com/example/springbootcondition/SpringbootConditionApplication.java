package com.example.springbootcondition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootConditionApplication {
    //Condition
    public static void main(String[] args) {
        //启动SpringBoot的应用,返回Spring的IOC容器
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootConditionApplication.class, args);

        //获取Bean,redisTemplate
        Object redisTemplate = context.getBean("redisTemplate");
        System.out.println(redisTemplate);


        //获取Bean
        Object user = context.getBean("user");
        System.out.println(user);
        System.out.println("-----");
        //获取Bean
        Object user2 = context.getBean("user2");
        System.out.println(user2);

    }

}
