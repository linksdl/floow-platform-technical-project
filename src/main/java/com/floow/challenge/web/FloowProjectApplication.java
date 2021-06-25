package com.floow.challenge.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class FloowProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(FloowProjectApplication.class, args);
    }

}
