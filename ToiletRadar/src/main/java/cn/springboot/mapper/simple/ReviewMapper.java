package cn.springboot.mapper.simple;

import cn.springboot.model.simple.Review;
import cn.springboot.model.simple.ReviewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReviewMapper {
    long countByExample(ReviewExample example);

    int deleteByExample(ReviewExample example);

    int insert(Review record);

    int insertSelective(Review record);//添加一条新的评论

    List<Review> selectByExample(ReviewExample example);

    int updateByExampleSelective(@Param("record") Review record, @Param("example") ReviewExample example);

    int updateByExample(@Param("record") Review record, @Param("example") ReviewExample example);

    //以下非工程自动生成
    List<Review> showCmtListByFr_toilet(@Param("frToilet")String frToilet);//显示某厕所所有评论列表

    //int toiletLikeNumberById(@Param("frToilet")Long frToilet);//获取该厕所信息的点赞数，这个需要从厕所信息实体获取

    //判断用户是否对该厕所发表过评论
    Integer isExistCmt(@Param("frToilet")String frToilet,@Param("frAccount")String frAccount);

    //根据厕所id以及用户id更新厕所信息的点赞状态
    //其中字段like_count=0表示该用户尚没有点赞，like_count=1表示该用户已对该厕所点赞
    int updateLikeNumber(@Param("frToilet")String frToilet,@Param("frAccount")String frAccount,@Param("likeCount")int likeCount);

    //根据厕所的id获取该厕所具体的点赞数
    int getLikeNumber(@Param("frToilet")String frToilet);

    //判断某用户是否给过厕所打分
    int isPublishScore(@Param("frToilet")String frToilet,@Param("frAccount")String frAccount);

    //给该具体id厕所评分
    int updateScore(@Param("frToilet")String frToilet,@Param("frAccount")String frAccount,@Param("score")int score);

    //给某厕所计算平均打分
    float getAverageScore(@Param("frToilet")String frToilet);

    //查询所有评论信息按评论的厕所排序
    List<Review> findAllList();

    //修改评论的删除状态
    int deleteById(@Param("pkId")Long pkId,@Param("status")byte status);
}