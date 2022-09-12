package com.example.springbootenableother.config;

import com.example.springbootenableother.domain.Role;
import com.example.springbootenableother.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration//---@Enable ”注释从@Configuration类中启用和配置。
public class UserConfig {
    @Bean
    public User user() {
        return new User();
    }

    @Bean
    public Role role() {
        return new Role();
    }
}
