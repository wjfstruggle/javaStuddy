package cn.springboot.service.simple;

import cn.springboot.model.simple.Account;
import cn.springboot.model.simple.Demo;
import com.github.pagehelper.PageInfo;

/**
 * @author billy
 * @date 2019/7/29 18:39
 * @Description
 */
public interface AccountService {

    public boolean addAccount(Account account);

    public boolean deleteAccountById(Long id);

    public boolean editAccount(Account account);

    public Account findAccountById(Long id);

    public PageInfo<Account> findAccountByPage(Integer pageNum, String keywords);

    public Account findAccountByIdentity(String identity);

}
