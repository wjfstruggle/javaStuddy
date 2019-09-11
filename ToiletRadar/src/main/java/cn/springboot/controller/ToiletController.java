package cn.springboot.controller;

import cn.springboot.common.result.ResponseData;
import cn.springboot.common.result.ResponseDataUtils;
import cn.springboot.common.util.UploadUtils;
import cn.springboot.model.simple.Toilet;
import cn.springboot.service.simple.ToiletService;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Api(value = "厕所Controller",tags = "厕所操作接口")
@Controller
@RequestMapping("/toilet")
public class ToiletController {

    @Autowired
    private ToiletService toiletService;

    @ApiOperation(value = "添加厕所")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData add(@RequestBody Toilet toilet) {
        boolean flag = toiletService.addToilet(toilet);
        if (flag) {
            return ResponseDataUtils.buildSuccess();
        } else {
            return ResponseDataUtils.buildError();
        }
    }

    /*@ApiOperation(value = "添加厕所")
    @RequestMapping(value = "/add2",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> add2(@RequestBody Toilet toilet, HttpServletRequest request) {
        String base64 = toilet.getPictureUrl();
        System.out.println(toilet.getPictureUrl());
        String[] strings = base64.split(",,");
        String url = "";
        for (String i:strings) {
            url += UploadUtils.base64UpLoad(i, request)+";";
        }
        toilet.setPictureUrl(url);
        boolean flag = toiletService.addToilet(toilet);
        Map<String ,String > result = new HashMap<>();
        if (flag) {
            result.put("status", "1");
            result.put("msg", "发布成功");
        } else {
            result.put("status", "0");
            result.put("msg", "发布失败");
        }
        return result;
    }*/

    @ApiOperation(value = "根据ID删除厕所")
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String,String> delete(@PathVariable String id) {
        boolean flag = toiletService.deleteToiletById(id);
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

    @ApiOperation(value = "根据ID修改厕所")
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public Map<String,String> edit(@ApiParam(name = "id",value = "厕所id",required = true) @PathVariable Long id, @RequestBody Toilet toilet) {
        toilet.setPkId(id);
        boolean flag = toiletService.editToilet(toilet);
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

    @ApiOperation(value = "根据ID查询厕所")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Toilet selectById(@PathVariable String id) {
        if (StringUtil.isNotEmpty(id)) {
            Toilet toilet = toiletService.findToiletById(Integer.valueOf(id));
            if (toilet != null) {
                return toilet;
            } else
                return null;
        } else
            return null;
    }

    @ApiOperation(value = "分页查询厕所列表")
    @RequestMapping(value = {"/list/{pageNum}","/list"}, method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<Toilet> list(@PathVariable(required = false) Integer pageNum) {
        System.out.println("id="+pageNum);
        PageInfo<Toilet> page = toiletService.findToiletsByPage(pageNum,null);
        return page;
    }


    @ApiOperation(value = "修改厕所的审核状态")
    @RequestMapping(value = {"/updateCheckStatus/{pkId}/{checkStatus}"}, method = RequestMethod.GET)
    @ResponseBody
    public Map<String,String> updateCheckStatus(@PathVariable("pkId") Long pkId, @PathVariable("checkStatus") String checkStatus){
        Map<String ,String > result = new HashMap<>();
        if(checkStatus.equals("true")){
            if(toiletService.updateCheckStatus(pkId, (byte) 1)>0){
                result.put("status", "1");
                result.put("msg", "审核通过");
            }else{
                result.put("status", "-1");
                result.put("msg", "审核操作失败");
            }
        }else if(checkStatus.equals("false")){
            if(toiletService.updateCheckStatus(pkId, (byte) 0)>0){
                result.put("status", "0");
                result.put("msg", "审核不通过");
            }else{
                result.put("status", "-1");
                result.put("msg", "审核操作失败");
            }
        }
        return result;
    }
}
