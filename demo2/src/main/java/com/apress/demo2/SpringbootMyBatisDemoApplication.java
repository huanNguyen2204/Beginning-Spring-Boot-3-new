package com.apress.demo2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.apress.demo2.mappers")
public class SpringbootMyBatisDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootMyBatisDemoApplication.class, args);
    }
}
