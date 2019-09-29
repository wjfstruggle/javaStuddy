package com.cdc.ecommerce.service.impl;

import com.cdc.ecommerce.common.Constants;
import com.cdc.ecommerce.mapper.ToiletMapper;
import com.cdc.ecommerce.model.Toilet;
import com.cdc.ecommerce.service.ToiletService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author wujf
 * @ClassName ToiletServiceImpl
 * @Description
 * @Date $ $
 * @Param $
 * @return $
 **/
@Service("toiletService")
public class ToiletServiceImpl implements ToiletService {
    @Autowired(required = false)
    private ToiletMapper toiletMapper;
    @Override
    public boolean addToilet(Toilet toilet) {
        if (toilet != null) {
            toilet.setCreateTime(new Date());
            toilet.setModifyTime(new Date());
            toilet.setDeleteStatus(false);
            toilet.setCheckStatus(false);
            toilet.setFixStatus(false);
            toilet.setLikeNumber(null);
            toilet.setScore(null);
            if (toiletMapper.insert(toilet) > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Toilet selectAllToiletById(Long id) {
        Toilet toilet = toiletMapper.selectByPrimaryKey(id);
        if (toilet != null) {
            return toilet;
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteToiletById(Long id) {
        int flag = toiletMapper.deleteByPrimaryKey(id);
        if (flag > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public PageInfo<Toilet> findToiletByPage(Integer pageNum, String keywords) {
        if (pageNum == null) {
            pageNum = 1;
        }
        PageHelper.startPage(pageNum, Constants.PAGE_SIZE);
        List<Toilet> list = toiletMapper.findToiletPage(keywords);
        if (list != null) {
            PageInfo<Toilet> page = new PageInfo<>(list);
            return page;
        } else {
            return null;
        }
    }

    @Override
    public int updateCheckStatus(Long id, byte checkStatus) {
        return toiletMapper.updateCheckStatus(id, checkStatus);
    }
}
