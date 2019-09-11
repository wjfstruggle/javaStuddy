package com.cdc.springmybastis.mapper;

import com.cdc.springmybastis.model.UserCommunity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: spring-mybastis
 * @description: mapper类
 * @author: wujf
 * @create: 2019-09-06 16:19
 **/
@Mapper
public interface UserCommunityMapper {
  int insert(UserCommunity userCommunity);
  UserCommunity findByToken(String token);
}
