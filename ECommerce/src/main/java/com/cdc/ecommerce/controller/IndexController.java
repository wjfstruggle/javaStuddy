package com.cdc.ecommerce.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wujf
 * @ClassName IndexController
 * @Description 登录页
 * @Date $ $
 * @Param $
 * @return $
 **/
@Api(value = "首页展示", tags = {"用户访问首页"})
@RestController
public class IndexController {
    @RequestMapping(value = "/login")
    public String index() {
        return "index";
    }
}
