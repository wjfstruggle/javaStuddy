package com.cdc.springmybastis.service;

import com.cdc.springmybastis.model.User;

import java.util.List;

public interface UserService {
  // 添加用户
  int addUser(User user);
  // 删除
  int deleteUser(User user);
  // 更新修改
  int updateUser(User user);
  // 根据ID获取
  User getUserById(User user);
  // 获取所有用户
  List<User> findAllUser();
}
