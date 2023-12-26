package com.example.service.luncher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@EnableTransactionManagement
@ComponentScan(basePackages = "com.example")
@EntityScan(basePackages = "com.example")
@EnableJpaRepositories(basePackages = "com.example")
@EnableCaching
@EnableWebMvc
@EnableAspectJAutoProxy
@EnableAsync
@EnableMongoRepositories("com.example")

public class ApApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApApplication.class, args);
    }


}

