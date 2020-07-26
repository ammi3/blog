package com.ammi3.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

@MapperScan("com.ammi3.blog.dao")
@Configuration
@ComponentScan({"com.ammi3.blog.service", "com.ammi3.blog.controller"})
@SpringBootApplication(scanBasePackages = "com.ammi3.blog.controller")
public class BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }

}
