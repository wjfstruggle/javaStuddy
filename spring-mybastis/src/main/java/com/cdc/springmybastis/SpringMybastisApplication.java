package com.cdc.springmybastis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.cdc.springmybastis.mapper")
@ServletComponentScan("com.cdc.springmybastis.service")
@ComponentScan(basePackages = "com.cdc.springmybastis.*")
public class SpringMybastisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMybastisApplication.class, args);
    }
}
