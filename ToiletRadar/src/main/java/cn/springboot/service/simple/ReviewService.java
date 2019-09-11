package cn.springboot.service.simple;

import cn.springboot.model.simple.Review;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
该接口用于编写评论评分相关的方法
 */
public interface ReviewService {
    int insertSelective(Review record);//添加一条新的评论
    List<Review> showCmtListByFr_toilet(String frToilet);//根据厕所id显示该厕所的所有评论
    int updateLikeNumber(String frToilet, String frAccount, int likeCount);//根据厕所id以及用户id更新厕所信息的点赞状态
    int getLikeNumber(String frToilet); //根据厕所的id获取该厕所具体的点赞数
    int updateScore(String frToilet,String frAccount,int score);    //给该具体id厕所评分
    boolean isExistCmt(String frToilet,String frAccount);//判断用户是否对该厕所发表过评论
    int isPublishScore(String frToilet,String frAccount);//判断某用户是否给过厕所打分
    float getAverageScore(String frToilet);//根据厕所的id计算该厕所的综合平均分

    List<Review> findAllList();
    int deleteById(Long pkId,byte status);//根据id修改评论的删除状态

}
