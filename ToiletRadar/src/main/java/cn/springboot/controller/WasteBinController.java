package cn.springboot.controller;

import cn.springboot.model.simple.Account;
import cn.springboot.model.simple.WasteBin;
import cn.springboot.service.simple.AccountService;
import cn.springboot.service.simple.WasteBinService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
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
@Api(value = "垃圾通Controller",tags = {"垃圾通操作接口"})
@Controller
public class WasteBinController {

    @Autowired
    private WasteBinService wasteBinService;

    @ApiOperation(value = "添加用户")
    @RequestMapping(value = "/wasteBin/add",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> add(@ApiParam(name = "用户对象",value = "传入json格式")@RequestBody WasteBin wasteBin) {
        boolean flag = wasteBinService.addWasteBin(wasteBin);
        Map<String ,String > result = new HashMap<>();
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
    @RequestMapping(value = "/wasteBin/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String,String> delete(@PathVariable Long id) {
        boolean flag = wasteBinService.deleteWasteBinById(id);
        Map<String ,String > result = new HashMap<>();
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
    @RequestMapping(value = "/wasteBin/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public Map<String,String> edit(@ApiParam(name = "id",value = "用户id",required = true) @PathVariable Long id, @RequestBody WasteBin wasteBin) {
        wasteBin.setPkId(id);
        boolean flag = wasteBinService.editWasteBin(wasteBin);
        Map<String ,String > result = new HashMap<>();
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
    @RequestMapping(value = "/wasteBin/{id}",method = RequestMethod.GET)
    @ResponseBody
    public WasteBin selectById(@PathVariable Long id) {
        WasteBin wasteBin = wasteBinService.findWasteBinById(id);
        if (wasteBin != null) {
            return wasteBin;
        }else {
            return null;
        }
    }

    @ApiOperation(value = "分页查询用户列表")
    @RequestMapping(value = "/wasteBin/list", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<WasteBin> list() {
        PageInfo<WasteBin> page = wasteBinService.findWasteBinByPage(null,null);
        return page;
    }
}
