package cn.springboot.controller;

import cn.springboot.model.simple.Account;
import cn.springboot.service.simple.AccountService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author billy
 * @date 2019/7/31 16:37
 * @Description
 */
@Api(value = "用户Controller", tags = {"用户操作接口"})
@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @ApiOperation(value = "添加用户")
    @RequestMapping(value = "/account/add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> add(@ApiParam(name = "用户对象", value = "传入json格式,只需传入wxName，wxPhoto，identity微信唯一标识") @RequestBody Account account) {
        boolean flag = accountService.addAccount(account);
        Map<String, String> result = new HashMap<>();
        if (flag) {
            result.put("status", "1");
            result.put("msg", "发布成功");
        } else {
            result.put("status", "0");
            result.put("msg", "发布失败");
        }
        return result;
    }

    @ApiOperation(value = "根据ID删除用户")
    @RequestMapping(value = "/account/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, String> delete(@PathVariable Long id) {
        boolean flag = accountService.deleteAccountById(id);
        Map<String, String> result = new HashMap<>();
        if (flag) {
            result.put("status", "1");
            result.put("msg", "删除成功");
        } else {
            result.put("status", "0");
            result.put("msg", "删除失败");
        }
        return result;
    }

    @ApiOperation(value = "根据ID修改用户")
    @RequestMapping(value = "/account/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Map<String, String> edit(@ApiParam(name = "id", value = "用户id", required = true) @PathVariable Long id, @RequestBody Account account) {
        account.setPkId(id);
        boolean flag = accountService.editAccount(account);
        Map<String, String> result = new HashMap<>();
        if (flag) {
            result.put("status", "1");
            result.put("msg", "修改成功");
        } else {
            result.put("status", "0");
            result.put("msg", "修改失败");
        }
        return result;
    }

    @ApiOperation(value = "根据ID查询用户")
    @RequestMapping(value = "/account/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Account selectById(@PathVariable Long id) {
        Account account = accountService.findAccountById(id);
        if (account != null) {
            return account;
        } else {
            return null;
        }
    }

    @ApiOperation(value = "分页查询用户列表")
    @RequestMapping(value = {"/account/list/{pageNum}", "/account/list"}, method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<Account> list(@PathVariable(required = false) Integer pageNum) {
        PageInfo<Account> page = accountService.findAccountByPage(pageNum, null);
        return page;
    }

    @ApiOperation(value = "根据identity查询用户")
    @RequestMapping(value = "/account/identity/{identity}", method = RequestMethod.GET)
    @ResponseBody
    public Account findByIdentity(@PathVariable String identity) {
        Account account = accountService.findAccountByIdentity(identity);
        if (account != null) {
            return account;
        } else {
            return null;
        }
    }
}
