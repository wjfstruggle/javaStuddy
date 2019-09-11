package com.cdc.springmybastis.mapper;

import com.cdc.springmybastis.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: spring-mybastis
 * @description: 是
 * @author: wujf
 * @create: 2019-09-02 11:47
 **/
@Mapper
public interface UserMapper {
  // 添加用户
  int addUser(User user);
  // 删除
  int deleteUser(User user);
  // 更新修改
  int updateUser(User user);
  // 根据ID获取
  User getUserById(User user);
  // 获取所有用户
  List<User> selectAllUser();
}
