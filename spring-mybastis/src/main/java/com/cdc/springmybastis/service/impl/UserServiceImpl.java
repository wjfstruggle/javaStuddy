package com.cdc.springmybastis.service.impl;

import com.cdc.springmybastis.mapper.UserMapper;
import com.cdc.springmybastis.model.User;
import com.cdc.springmybastis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: spring-mybastis
 * @description: 逻辑
 * @author: wujf
 * @create: 2019-09-02 15:39
 **/
@Service
public class UserServiceImpl implements UserService {
  @Autowired(required = false)
  private UserMapper userMapper;

  // 查询所有用户信息
  @Override
  public List<User> findAllUser() {
    return userMapper.selectAllUser();
  }
  // 添加用户信息
  @Override
  public int addUser(User user) {
    return userMapper.addUser(user);
  }
  // 删除
  @Override
  public int deleteUser(User user) {
    return userMapper.deleteUser(user);
  }
  // 修改
  @Override
  public int updateUser(User user) {
    return userMapper.updateUser(user);
  }
  // 根据id查询
  @Override
  public User getUserById(User user) {
    return userMapper.getUserById(user);
  }
}
