package com.cdc.ecommerce.service;

import com.cdc.ecommerce.model.Account;
import com.github.pagehelper.PageInfo;
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
public interface AccountService {
    // 添加用户
    public boolean addAccount(Account account);
    // 删除用户
    public boolean deleteAccountById(Long id);
    // 查找用户
    public Account findAccountById(Long id);
    // 分页
    public PageInfo<Account> findAccountByPage(Integer pageNum, String keywords);
    // 根据identity查找用户
    public Account findAccountByIdentity(String identity);
}
