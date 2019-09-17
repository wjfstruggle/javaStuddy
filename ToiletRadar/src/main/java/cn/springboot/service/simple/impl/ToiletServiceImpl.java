package cn.springboot.service.simple.impl;


import cn.springboot.common.constants.Constants;
import cn.springboot.mapper.simple.ToiletMapper;
import cn.springboot.model.simple.Toilet;
import cn.springboot.service.simple.ToiletService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("ToiletService")
public class ToiletServiceImpl implements ToiletService {

    @Autowired
    private ToiletMapper toiletMapper;

    @Override
    public boolean addToilet(Toilet toilet) {
        if (toilet != null) {
            toilet.setCheckStatus(false);
            toilet.setCreateTime(new Date());
            toilet.setDeleteStatus(false);
            toilet.setFixStatus(false);
            toilet.setModifyTime(new Date());
            if (toiletMapper.insert(toilet) > 0) {
                return true;
            }
        }
        return false;

    }

    @Override
    public boolean deleteToiletById(String id) {
        Long tid = Long.parseLong(id);
        int i = toiletMapper.deleteByPrimaryKey(tid);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean editToilet(Toilet toilet) {
        toilet.setModifyTime(new Date());
        if (toiletMapper.updateByPrimaryKey(toilet) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Toilet findToiletById(Integer id) {
        long tid = (long) id;
        return toiletMapper.selectByPrimaryKey(tid);
    }

    @Override
    public PageInfo<Toilet> findToiletsByPage(Integer pageNum, String keywords) {
        if (pageNum == null) {
            pageNum = 1;
        }
        PageHelper.startPage(pageNum, Constants.PAGE_SIZE);
        List<Toilet> list = toiletMapper.findToiletByPage(keywords);
        if (list != null) {
            PageInfo<Toilet> page = new PageInfo<>(list);
            return page;
        } else {
            return null;
        }


    }

    @Override
    public int updateByPrimaryKey(Toilet record) {
        return toiletMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateCheckStatus(Long pkId, byte checkStatus) {
        return toiletMapper.updateCheckStatus(pkId, checkStatus);
    }
}

