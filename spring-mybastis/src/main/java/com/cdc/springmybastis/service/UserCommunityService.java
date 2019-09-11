package com.cdc.springmybastis.service;

import com.cdc.springmybastis.model.UserCommunity;

public interface UserCommunityService {
  int insert(UserCommunity userCommunity);

  UserCommunity findByToken(String token);
}
