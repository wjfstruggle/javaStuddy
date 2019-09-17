package cn.springboot.service.simple.impl;

import cn.springboot.mapper.simple.ReviewMapper;
import cn.springboot.mapper.simple.ToiletMapper;
import cn.springboot.model.simple.Review;
import cn.springboot.model.simple.Toilet;
import cn.springboot.service.simple.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service("reviewService")
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    ReviewMapper reviewDao;

    @Autowired
    ToiletMapper toiletDao;

    @Override
    public int insertSelective(Review record) {
        return reviewDao.insertSelective(record);
    }

    @Override
    public List<Review> showCmtListByFr_toilet(String frToilet) {
        return reviewDao.showCmtListByFr_toilet(frToilet);
    }

    @Override
    public int updateLikeNumber(String frToilet, String frAccount, int likeCount) {
        if (!isExistCmt(frToilet, frAccount)) {//如果用户还没有发布评论就点赞
            Review review = new Review();
            review.setContent("点赞了该厕所");
            review.setFrAccount(frAccount);
            review.setFrToilet(frToilet);
            int insertResult = insertSelective(review);
            if (insertResult > 0) {//发布点赞评论成功
                //点赞或者取消点赞
                //likeCount==1为点赞操作
                //likeCount==0为取消点赞操作
                if (reviewDao.updateLikeNumber(frToilet, frAccount, likeCount) > 0) {//点赞成功
                    long likeNumber = getLikeNumber(frToilet);//获取点赞数
                    Toilet toilet = new Toilet();
                    toilet = toiletDao.selectByPrimaryKey(Long.parseLong(frToilet));
                    toilet.setLikeNumber(likeNumber);
                    if (toiletDao.updateByPrimaryKey(toilet) > 0) {
                        return 1;
                    }
                }
            }
        } else {//用户已经发布过评论
            //点赞或者取消点赞
            //likeCount==1为点赞操作
            //likeCount==0为取消点赞操作
            if (reviewDao.updateLikeNumber(frToilet, frAccount, likeCount) > 0) {//点赞成功
                long likeNumber = getLikeNumber(frToilet);//获取点赞数
                Toilet toilet = new Toilet();
                toilet = toiletDao.selectByPrimaryKey(Long.parseLong(frToilet));
                toilet.setLikeNumber(likeNumber);
                if (toiletDao.updateByPrimaryKey(toilet) > 0) {
                    return 1;
                }
            }
        }
        return 0;
    }

    @Override
    public int getLikeNumber(String frToilet) {
        return reviewDao.getLikeNumber(frToilet);
    }

    @Override
    public int updateScore(String frToilet, String frAccount, int score) {
        if (isPublishScore(frToilet, frAccount) > 0) {
            return 0;//说明用户已经评过分，无法重复评分
        } else {
            if (reviewDao.updateScore(frToilet, frAccount, score) > 0) {//用户个人评分成功
                float avgScore = getAverageScore(frToilet);//计算获得某厕所的综合平均分
                BigDecimal bigDAvgScore = new BigDecimal(Float.toString(avgScore));
                System.out.println(bigDAvgScore);
                Toilet toilet = new Toilet();
                toilet = toiletDao.selectByPrimaryKey(Long.parseLong(frToilet));
                toilet.setScore(bigDAvgScore);
                if (toiletDao.updateByPrimaryKey(toilet) > 0) {
                    return 1;//厕所综合评分成功
                }
            }
        }
        return 0;
    }

    @Override
    public boolean isExistCmt(String frToilet, String frAccount) {
        if (reviewDao.isExistCmt(frToilet, frAccount) != null) {
            return true;
        }
        return false;
    }

    @Override
    public int isPublishScore(String frToilet, String frAccount) {
        return reviewDao.isPublishScore(frToilet, frAccount);
    }

    @Override
    public float getAverageScore(String frToilet) {
        return reviewDao.getAverageScore(frToilet);
    }

    @Override
    public List<Review> findAllList() {
        return reviewDao.findAllList();
    }

    @Override
    public int deleteById(Long pkId, byte status) {
        return reviewDao.deleteById(pkId, status);
    }
}
