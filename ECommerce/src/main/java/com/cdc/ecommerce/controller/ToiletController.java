package com.cdc.ecommerce.controller;

import com.cdc.ecommerce.model.Toilet;
import com.cdc.ecommerce.service.ToiletService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public Map<String, String> addToilet(@ApiParam(name = "信息对象",value = "传入json对象, address,longitude,latitude,description,pictureUrl,label,publisher，likeNumber")
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
        Map<String,String> result = new HashMap<>();
        if (flag) {
            result.put("status","1");
            result.put("msg","发布成功");
        } else {
            result.put("status","0");
            result.put("msg","发布失败");
        }
        return result;
    }
}
