package com.cdc.springmybastis.controller;

import com.cdc.springmybastis.model.UserCommunity;
import com.cdc.springmybastis.service.UserCommunityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @program: spring-mybastis
 * @description: 首页
 * @author: wujf
 * @create: 2019-09-03 17:44
 **/
@Controller
public class IndexController {
  private static final Logger log = LoggerFactory.getLogger(IndexController.class);
  @Autowired(required = false)
  private UserCommunityService userCommunityService;
  @RequestMapping(value = "/")
  public String index(HttpServletRequest request) {
    log.info("# 进入默认首页");
    Cookie[] cookies = request.getCookies();
    for (Cookie cookie : cookies) {
      if (cookie.getName().equals("token")) {
        String token = cookie.getValue();
        UserCommunity userCommunity = userCommunityService.findByToken(token);
        // 前端
        if (userCommunity != null) {
          request.getSession().setAttribute("userCommunity", userCommunity);
        }
        break;
      }
    }
    return "index";
  }
}
