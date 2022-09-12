package com.example.springbootenable;

import com.example.springbootenableother.config.EnableUser;
import com.example.springbootenableother.config.MyImportBeanDefinitionRegistrar;
import com.example.springbootenableother.config.MyImportSelector;
import com.example.springbootenableother.config.UserConfig;
import com.example.springbootenableother.domain.Role;
import com.example.springbootenableother.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import redis.clients.jedis.Jedis;

import java.util.Map;


/**
 * Import --4种用法
 * 1.导入Bean---//@Import(User.class)
 * 2.导入配置类----//@Import(UserConfig.class)
 * 3.导入 ImportSelector 实现类-----//@Import(MyImportSelector.class)
 * 4.ImportBeanDefinitionRegistrar 实现类 ---- //@Import(MyImportBeanDefinitionRegistrar.class)
 */


//@ComponentScan("com.example.springbootenableother.config")//扫描当前引导类所在包及子包
//@Import(UserConfig.class)
//@EnableUser//----@Enable ”注释从@Configuration类中启用和配置。


//@Import(User.class)
//@Import(UserConfig.class)
//@Import(MyImportSelector.class)
//@Import(MyImportBeanDefinitionRegistrar.class)

@SpringBootApplication
public class SpringbootEnableApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootEnableApplication.class, args);


        //获取Bean---不能直接获取外部Bean----
        //1.通过注解@ComponentScan("com.example.springbootenableother.config")---扫描当前引导类所在包及子包
        //2.@Import()注解 加载类,这些类都会被Spring创建,并放入IOC容器
        //3.对Import注解进行封装
//        Object user = context.getBean("user");
//        System.out.println(user);


//        User user = context.getBean(User.class);
//        System.out.println(user);
//
//        Role role = context.getBean(Role.class);
//        System.out.println(role);


//        Object user = context.getBean("user");
//        System.out.println(user);
//
//
//        Map<String, User> map = context.getBeansOfType(User.class);
//        System.out.println(map);


        Jedis jedis = context.getBean(Jedis.class);
        System.out.println(jedis);

        jedis.set("name", "lingnian");
        String name = jedis.get("name");
        System.out.println(name);

    }

    @Bean
    public Jedis jedis(){
        System.out.println("@ConditionalOnMissingBean(name = \"jedis\")------的使用");
        return new Jedis("127.0.0.1", 6379);
    }

}
