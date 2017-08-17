package com.sda.springcourse.config;

import com.sda.springcourse.service.ReverseService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public ReverseService lowerCaseService() {
        ReverseService reverseService = new ReverseService();
        reverseService.setLowerCase(true);
        reverseService.setUpperCase(false); //opcjonalne
        return reverseService;
    }
}
