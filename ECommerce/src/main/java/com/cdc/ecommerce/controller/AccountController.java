package com.cdc.ecommerce.controller;

import com.cdc.ecommerce.model.Account;
import com.cdc.ecommerce.service.AccountService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author wujf
 * @ClassName UserConroller
 * @Description 用户操作接口
 * @Date $ $
 * @Param map
 * @return $
 **/
@Api(value = "用户controller", tags = {"用户操作接口"})
@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    @ApiOperation(value = "添加用户")
    @RequestMapping(value = "/account/add", method = RequestMethod.POST)
    public Map<String, String> add(@ApiParam(name = "用户对象", value = "传入json格式,只需传入wxName，wxPhoto，identity微信唯一标识")
                                   @RequestParam(name = "wxName") String wxName,
                                   @RequestParam(name = "wxPhoto") String wxPhoto,
                                   @RequestParam(name = "identity") String identity) {
        Account account = new Account();
        account.setWxName(wxName);
        account.setWxPhoto(wxPhoto);
        account.setIdentity(identity);
        boolean flag = accountService.addAccount(account);
        Map<String, String> result = new HashMap<>();
        if (flag) {
            result.put("status", "1");
            result.put("msg","添加成功");
        } else {
            result.put("status", "0");
            result.put("msg","添加失败");
        }
        return result;
    }
    @ApiOperation(value = "删除用户")
    @RequestMapping(value = "/account/{id}", method = RequestMethod.DELETE)
    public Map<String, String> deleteById(@ApiParam(name = "用户对象", value = "传入用户id")
                                          @PathVariable Long id) {
        boolean flag = accountService.deleteAccountById(id);
        Map<String, String> result = new HashMap<>();
        if (flag) {
            result.put("status", "1");
            result.put("msg","删除成功");
        } else {
            result.put("status", "0");
            result.put("msg","删除失败");
        }
        return result;
    }
    @ApiOperation(value = "查找用户")
    @RequestMapping(value = "/account/{id}", method = RequestMethod.GET)
    public Account SelectById(@ApiParam(name = "用户对象", value = "传入用户id")
                                          @PathVariable Long id) {
        Account account = accountService.findAccountById(id);
        if (account != null) {
            return account;
        } else {
            return null;
        }
    }
    // 分页
    @ApiOperation(value = "分页查询用户列表")
    @RequestMapping(value = {"/account/list/{pageNum}","/account/list"}, method = RequestMethod.GET)
    public PageInfo<Account> list(@ApiParam(name = "分页查询用户列表")
                              @PathVariable(required = false) Integer pageNum) {
        PageInfo<Account> page = accountService.findAccountByPage(pageNum, null);
        return page;
    }
    @ApiOperation(value = "根据identity查询用户")
    @RequestMapping(value = "/account/identity/{identity}", method = RequestMethod.GET)
    public Account findByIdentity(@PathVariable String identity) {
        Account account = accountService.findAccountByIdentity(identity);
        if (account != null) {
            return account;
        } else {
            return null;
        }
    }
}
