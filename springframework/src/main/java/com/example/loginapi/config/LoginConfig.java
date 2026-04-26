package com.example.loginapi.config;

import com.example.loginapi.repository.LoginRepository;
import com.example.loginapi.service.LoginService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoginConfig {

    @Bean
    public LoginService loginService(LoginRepository loginRepository) {
        return new LoginService(loginRepository);
    }
}
