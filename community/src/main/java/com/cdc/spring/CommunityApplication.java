package com.cdc.spring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.cdc.spring.mapper")
@ServletComponentScan("com.cdc.spring.service")
@ComponentScan(basePackages = "com.cdc.spring.*")
public class CommunityApplication {

    public static void main(String[] args){
        SpringApplication.run(CommunityApplication.class, args);
    }

}
