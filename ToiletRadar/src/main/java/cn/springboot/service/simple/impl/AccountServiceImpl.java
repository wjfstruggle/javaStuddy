package cn.springboot.service.simple.impl;

import cn.springboot.common.constants.Constants;
import cn.springboot.config.db.pk.FactoryAboutKey;
import cn.springboot.config.db.pk.TableEnum;
import cn.springboot.mapper.simple.AccountMapper;
import cn.springboot.mapper.simple.DemoMapper;
import cn.springboot.model.simple.Account;
import cn.springboot.model.simple.Demo;
import cn.springboot.service.simple.AccountService;
import cn.springboot.service.simple.DemoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author billy
 * @date 2019/7/29 17:03
 * @Description
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;


    @Override
    public boolean addAccount(Account account) {
        if (account != null) {
            account.setCreateTime(new Date());
            account.setModifyTime(new Date());
            account.setPassword("123456");
            account.setDeleteStatus(false);
            int flag = accountMapper.insert(account);
            if (flag == 1)
                return true;
            else
                return false;
        } else
            return false;
    }

    @Override
    public boolean deleteAccountById(Long id) {
        int flag = accountMapper.deleteByPrimaryKey(id);
        if (flag == 1)
            return true;
        else
            return false;
    }

    @Override
    public boolean editAccount(Account account) {
        if (account != null) {
            int flag = accountMapper.updateByPrimaryKeySelective(account);
            if (flag == 1)
                return true;
            else
                return false;
        } else
            return false;
    }

    @Override
    public Account findAccountById(Long id) {
        Account account = accountMapper.selectByPrimaryKey(id);
        if (account != null)
            return account;
        else
            return null;
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
