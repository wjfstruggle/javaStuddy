package com.cdc.ecommerce.service.impl;

import com.cdc.ecommerce.common.Constants;
import com.cdc.ecommerce.common.utils.StringRandom;
import com.cdc.ecommerce.mapper.AccountMapper;
import com.cdc.ecommerce.model.Account;
import com.cdc.ecommerce.service.AccountService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author wujf
 * @ClassName AccountServiceImpl
 * @Description
 * @Date $ $
 * @Param $
 * @return $
 **/
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired(required = false)
    private AccountMapper accountMapper;

    @Override
    public boolean addAccount(Account account) {
        StringRandom stringRandom = new StringRandom();
        if (account != null) {
            account.setCreateTime(new Date());
            account.setModifyTime(new Date());
            account.setDeleteStatus(false);
            account.setPassword("123456");
            account.setIdentity(stringRandom.getStringRandom(20));
            int flag = accountMapper.insertSelective(account);
            if (flag == 1) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteAccountById(Long id) {
        int flag = accountMapper.deleteByPrimaryKey(id);
        if (flag == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Account findAccountById(Long id) {
        Account account = accountMapper.selectByPrimaryKey(id);
        if (account != null) {
            return account;
        } else {
            return null;
        }
    }

    @Override
    public PageInfo<Account> findAccountByPage(Integer pageNum, String keywords) {
        if (pageNum == null) {
            pageNum = 1;
        }
        PageHelper.startPage(pageNum, Constants.PAGE_SIZE);
        List<Account> list = accountMapper.findAccountByPage(keywords);
        if (list != null) {
            PageInfo<Account> page = new PageInfo<>(list);
            return page;
        } else {
            return null;
        }
    }

    @Override
    public Account findAccountByIdentity(String identity) {
        return accountMapper.findAccountByIdentity(identity);
    }
}