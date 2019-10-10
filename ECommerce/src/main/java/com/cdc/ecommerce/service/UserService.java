package com.cdc.ecommerce.service;

import com.cdc.ecommerce.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

/**
 * @Author wujf
 * @ClassName UserService
 * @Description
 * @Date $ $
 * @Param $
 * @return $
 **/
@Repository
public interface UserService {
    public UserDetails loadUserByUsername(String username);
    public int reg(User user);
}
