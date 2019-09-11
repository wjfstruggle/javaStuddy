package cn.springboot.controller;

import cn.springboot.common.result.ResponseData;
import cn.springboot.common.result.ResponseDataUtils;
import cn.springboot.model.simple.Review;
import cn.springboot.service.simple.impl.ReviewServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "评论Controller",tags = {"评论操作接口"})
@Controller
public class ReviewController {
    @Autowired
    ReviewServiceImpl reviewServiceImpl;

    @ApiOperation("发布评论1")
    @RequestMapping(value = "/publishComment1",method = RequestMethod.POST)
    public String publishComment1(Review review){
        //验证用户已经登陆
        //根据表单中input的name属性（name属性的名称必须和数据库的字段名一致），自动匹配形参
        //获取用户id以及厕所的id
        if(review.getFrAccount()==null||review.getFrToilet()==null){//如果取不到用户id以及厕所id
            return "fail";
        }else if(review.getContent().equals("")){//如果输入的内容为空
            return "The content could not be empty.";
        }else{
            if(reviewServiceImpl.insertSelective(review)>0){//发布评论成功
                return "success";//跳转至评论成功发布页面
            }
        }
        return "fail";
    }

    @ApiOperation("发布评论2")
    @RequestMapping(value = "/review/add",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> publishComment2(@RequestBody Review review){
        Map<String ,Object> result = new HashMap<>();
        //验证用户已经登陆
        //根据表单中input的name属性（name属性的名称必须和数据库的字段名一致），自动匹配形参
        //获取用户id以及厕所的id
        if(review.getFrAccount()==null||review.getFrToilet()==null){//如果取不到用户id以及厕所id
            result.put("status","0");
            result.put("msg","发布失败");
            return result;
        }else if("".equals(review.getContent())){//如果输入的内容为空
            result.put("status","0");
            result.put("msg","评论不能为空");
            return result;
        }else{
            if(reviewServiceImpl.insertSelective(review)>0){//发布评论成功
                result.put("status","1");
                result.put("msg","发布成功");
                return result;//跳转至评论成功发布页面
            }else{//插入数据库失败
                result.put("status","0");
                result.put("msg","发布失败");
                return result;//
            }
        }
    }
    @ApiOperation("显示某厕所的所有评论")
    @RequestMapping(value = "/review/toilet/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> showCmtList(@ApiParam(name = "id",value = "厕所id") @PathVariable String id){
        Map<String ,Object> result = new HashMap<>();
        List<Review> reviewList = new ArrayList<>();
        reviewList = reviewServiceImpl.showCmtListByFr_toilet(id);
        int i = 0;
        if(reviewList!=null){
            result.put("status","1");
            System.out.println(reviewList);
            result.put("list",reviewList);
        }else{
            result.put("status", "0");
            result.put("msg", "获取列表失败");
        }
        return result;
    }

    @ApiOperation("点赞厕所相关操作")
    @RequestMapping(value = "/review/updateLikeNumber",method = RequestMethod.GET)
//    @RequestMapping(value = "/review/updateLikeNumber/{Tid}/{Uid}/{num}",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> updateLikeNumber(String frToilet, String frAccount,int likeCount){
        Map<String ,Object> result = new HashMap<>();
        if(likeCount==1){//点赞操作
            if(reviewServiceImpl.updateLikeNumber(frToilet,frAccount,likeCount)==1){
                int likeNumber = reviewServiceImpl.getLikeNumber(frToilet);
                result.put("status", "1");
                result.put("msg", "点赞成功");
                result.put("likeNumber", likeNumber);
                return result;
            }
        }else if(likeCount==0){//取消点赞操作
            if(reviewServiceImpl.updateLikeNumber(frToilet,frAccount,likeCount)==1){
                int likeNumber = reviewServiceImpl.getLikeNumber(frToilet);
                result.put("status", "2");
                result.put("msg", "取消点赞成功");
                result.put("likeNumber", likeNumber);
                return result;
            }
        }
        result.put("status", "0");
        result.put("msg", "点赞失败");
        return result;
    }

    @ApiOperation("厕所打分相关操作")
    @RequestMapping(value = "/review/updateScore",method = RequestMethod.GET)
//    @RequestMapping(value = "/review/updateScore/{Tid}/{Uid}/{score}",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> updateScore(String frToilet,String frAccount,Integer score){
        System.out.println(score);
        Map<String,Object> result = new HashMap<>();
        if(reviewServiceImpl.updateScore(frToilet,frAccount,score)==1){
            result.put("status", "1");
            result.put("msg", "评分成功");
            return result;
        }else{
            result.put("status", "0");
            result.put("msg", "评分失败，您已经评过了！");
            return result;
        }
    }

    @ApiOperation("查询所有评论信息")
    @RequestMapping(value = "/review/list",method = RequestMethod.GET)
    @ResponseBody
    public ResponseData findAll(){
        List<Review> list = reviewServiceImpl.findAllList();
        if (list != null) {
            return ResponseDataUtils.buildSuccess(list);
        } else {
            return ResponseDataUtils.buildError("查无数据");
        }
    }

    @ApiOperation("根据id删除评论")
    @RequestMapping(value = "/review/delete/{pkId}/{status}",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> deleteById(@PathVariable("pkId") Long pkId,@PathVariable("status")String status){
        Map<String,Object> result = new HashMap<>();
        if(status.equals("true")){
            if(reviewServiceImpl.deleteById(pkId, (byte) 1)>0){
                result.put("status", "1");
                result.put("msg", "评论已经屏蔽！");
            }else{
                result.put("status", "0");
                result.put("msg", "操作失败");
            }
        }else if(status.equals("false")){
            if(reviewServiceImpl.deleteById(pkId, (byte) 0)>0){
                result.put("status", "2");
                result.put("msg", "评论已取消屏蔽！");
            }else{
                result.put("status", "0");
                result.put("msg", "操作失败");
            }
        }
        return result;
    }
}
