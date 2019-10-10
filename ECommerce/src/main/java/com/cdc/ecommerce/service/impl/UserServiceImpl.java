package com.cdc.ecommerce.service.impl;

import com.cdc.ecommerce.mapper.RolesMapper;
import com.cdc.ecommerce.mapper.UserMapper;
import com.cdc.ecommerce.model.Roles;
import com.cdc.ecommerce.model.User;
import com.cdc.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

/**
 * @Author wujf
 * @ClassName UserServiceImpl
 * @Description
 * @Date $ $
 * @Param $
 * @return $
 **/
@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired(required = false)
    private UserMapper userMapper;

    @Autowired(required = false)
    private RolesMapper rolesMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.loadUserByUsername(username);
        if (user == null) {
            //避免返回null，这里返回一个不含有任何值的User对象，在后期的密码比对过程中一样会验证失败
            return (UserDetails) new User();
        }
        //查询用户的角色信息，并返回存入user中
        List<Roles> roles = rolesMapper.getRolesByUid(user.getId());
        user.setRoles(roles);
        return (UserDetails) new User();
    }

    @Override
    public int reg(User user) {
        User loadUserByUsername = userMapper.loadUserByUsername(user.getUsername());
        if (loadUserByUsername != null) {
            return 1;
        }
        //插入用户,插入之前先对密码进行加密
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        user.setEnabled(true);//用户可用
        long result = userMapper.reg(user);
        //配置用户的角色，默认都是普通用户
        String[] roles = new String[]{"2"};
        int i = rolesMapper.addRoles(roles, user.getId());
        boolean b = i == roles.length && result == 1;
        if (b) {
            return 0;
        } else {
            return 2;
        }
    }
}
