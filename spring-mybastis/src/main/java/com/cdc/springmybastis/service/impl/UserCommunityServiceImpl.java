package com.cdc.springmybastis.service.impl;

import com.cdc.springmybastis.mapper.UserCommunityMapper;
import com.cdc.springmybastis.model.UserCommunity;
import com.cdc.springmybastis.service.UserCommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: spring-mybastis
 * @description: impl类
 * @author: wujf
 * @create: 2019-09-06 16:42
 **/
@Service
public class UserCommunityServiceImpl implements UserCommunityService {
  @Autowired(required = false)
  private UserCommunityMapper userCommunityMapper;

  // 添加用户信息
  @Override
  public int insert(UserCommunity userCommunity) {
    return userCommunityMapper.insert(userCommunity);
  }
  // 查找token
  @Override
  public UserCommunity findByToken(String token) {
    return userCommunityMapper.findByToken(token);
  }
}
