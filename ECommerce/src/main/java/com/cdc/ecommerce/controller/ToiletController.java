package com.cdc.ecommerce.controller;

import com.cdc.ecommerce.model.Toilet;
import com.cdc.ecommerce.service.ToiletService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author wujf
 * @ClassName ToiletController
 * @Description
 * @Date $ $
 * @Param $
 * @return $
 **/
@Api(value = "信息发布controller", tags = {"信息操作接口"})
@RestController
public class ToiletController {

    @Autowired(required = false)
    private ToiletService toiletService;

    @ApiOperation(value = "添加信息")
    @RequestMapping(value = "toilet/add", method = RequestMethod.POST)
    public Map<String, String> addToilet(@ApiParam(name = "信息对象", value = "传入json对象, address,longitude,latitude,description,pictureUrl,label,publisher，likeNumber")
             @RequestParam(name = "address") String address,
             @RequestParam(name = "longitude") String longitude,
             @RequestParam(name = "latitude") String latitude,
             @RequestParam(name = "description") String description,
             @RequestParam(name = "pictureUrl") String pictureUrl,
             @RequestParam(name = "label") String label,
             @RequestParam(name = "publisher") String publisher) {
        Toilet toilet = new Toilet();
        toilet.setAddress(address);
        toilet.setLongitude(longitude);
        toilet.setLatitude(latitude);
        toilet.setDescription(description);
        toilet.setPictureUrl(pictureUrl);
        toilet.setLabel(label);
        toilet.setPublisher(publisher);
        boolean flag = toiletService.addToilet(toilet);
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

    @RequestMapping("/toilet/{id}")
    @ApiOperation(value = "查询信息")
    public Toilet findToiletById(@PathVariable(name = "id") Long id) {
        Toilet toilet = toiletService.selectAllToiletById(id);
        if (toilet != null) {
            return toilet;
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/toilet/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除信息")
    public Map<String, String> deleteToilet(@ApiParam(name = "信息对象", value = "传入需要删除的id") @PathVariable(name = "id") Long id) {
        boolean flag = toiletService.deleteToiletById(id);
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

    @ApiOperation(value = "分页查询")
    @RequestMapping(value = {"toilet/list/{pageNum}", "toilet/list"}, method = RequestMethod.GET)
    public PageInfo<Toilet> list(@ApiParam(value = "信息分页查询") @PathVariable(required = false) Integer pageNum) {
        PageInfo<Toilet> page = toiletService.findToiletByPage(pageNum, null);
        return page;
    }

    @ApiOperation(value = "更改信息状态")
    @RequestMapping(value = {"toilet/updateCheckStatus/{id}/{checkStatus}"}, method = RequestMethod.GET)
    public Map<String, String> updateCheckStatus(@PathVariable(name = "id") Long id, @PathVariable(name = "checkStatus") Byte checkStatus) {
        Map<String, String> result = new HashMap<>();
        if (checkStatus.equals("true")) {
            if (toiletService.updateCheckStatus(id, (byte) 1) > 0) {
                result.put("status", "1");
                result.put("msg", "审核通过");
            } else {
                result.put("status", "-1");
                result.put("msg", "审核操作失败");
            }
        } else if (checkStatus.equals("false")) {
            if (toiletService.updateCheckStatus(id, (byte) 0) > 0) {
                result.put("status", "0");
                result.put("msg", "审核不通过");
            } else {
                result.put("status", "-1");
                result.put("msg", "审核操作失败");
            }
        }
        return result;
    }
}
