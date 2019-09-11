package com.cdc.springmybastis.controller;

import com.cdc.springmybastis.model.User;
import com.cdc.springmybastis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: spring-mybastis
 * @description: 控制层
 * @author: wujf
 * @create: 2019-09-02 11:51
 **/
@RestController
@RequestMapping(value = "/user")
public class UserController {
  /**
   *
   */
  @Autowired
  private UserService userService;
  @RequestMapping(value = "/getAllUsers", produces = {"application/json;charset=UTF-8"})
  public List<User> findAll() {
    return userService.findAllUser();
  }
  @RequestMapping(value = "/addUser", produces = {"application/json;charset=UTF-8"} )
  public int addUser(User user) {
    return userService.addUser(user);
  }
  @RequestMapping(value = "/getUserById", produces = {"application/json;charset=UTF-8"} )
  public User getUserById(User user) {
    return userService.getUserById(user);
  }
  @RequestMapping(value = "/deleteUser", produces = {"application/json;charset=UTF-8"})
  public int deleteUser(User user) {
    return userService.deleteUser(user);
  }
  @RequestMapping(value = "/updateUser", produces = {"application/json;charset=UTF-8"})
  public int updateUser(User user) {
    return userService.updateUser(user);
  }
}
