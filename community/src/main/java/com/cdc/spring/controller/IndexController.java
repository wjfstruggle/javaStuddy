package com.cdc.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @program: spring
 * @description: 首页
 * @author: wujf
 * @create: 2019-09-03 17:44
 **/
@RestController
public class IndexController {
    private static final Logger log = LoggerFactory.getLogger(IndexController.class);

    @GetMapping(value = "/index")
    public String index() {
        log.info("# 进入默认首页");
        return "index";
    }
}
