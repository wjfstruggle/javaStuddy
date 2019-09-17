package cn.springboot.controller;

import cn.springboot.model.simple.Demo;
import cn.springboot.service.simple.DemoService;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author billy
 * @date 2019/7/29 18:55
 * @Description
 */
@Api("Demo接口")
@Controller
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @ApiOperation(value = "添加Demo")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> add(@RequestBody Demo demo) {
        boolean flag = demoService.addDemo(demo);
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

    @ApiOperation(value = "根据ID删除Demo")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> delete(String id) {
        boolean flag = demoService.deleteDemoById(id);
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

    @ApiOperation(value = "根据ID修改Demo")
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> edit(@RequestBody Demo demo) {
        boolean flag = demoService.editDemo(demo);
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

    @ApiOperation(value = "根据ID查询Demo")
    @RequestMapping(value = "/selectById", method = RequestMethod.GET)
    @ResponseBody
    public Demo selectById(String id) {
        if (StringUtil.isNotEmpty(id)) {
            Demo demo = demoService.findDemoById(id);
            if (demo != null) {
                return demo;
            } else
                return null;
        } else
            return null;
    }

    @ApiOperation(value = "查询Demo列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<Demo> list() {
        PageInfo<Demo> page = demoService.findNewsByPage(null, null);
        return page;
    }
}
