package cn.springboot.service.simple.impl;

import cn.springboot.common.constants.Constants;
import cn.springboot.mapper.simple.AccountMapper;
import cn.springboot.mapper.simple.WasteBinMapper;
import cn.springboot.model.simple.Account;
import cn.springboot.model.simple.WasteBin;
import cn.springboot.service.simple.AccountService;
import cn.springboot.service.simple.WasteBinService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author billy
 * @date 2019/7/29 17:03
 * @Description
 */
@Service("wasteBinService")
public class WasteBinServiceImpl implements WasteBinService {

    @Autowired
    private WasteBinMapper wasteBinMapper;


    @Override
    public boolean addWasteBin(WasteBin wasteBin) {
        if (wasteBin != null) {
            wasteBin.setCreateTime(new Date());
            wasteBin.setModifyTime(new Date());
            wasteBin.setDeleteStatus(0);
            wasteBin.setCheckStatus(0);
            int flag = wasteBinMapper.insertSelective(wasteBin);
            if (flag == 1) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteWasteBinById(Long id) {
        int flag = wasteBinMapper.deleteByPrimaryKey(id);
        if (flag == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean editWasteBin(WasteBin wasteBin) {
        int flag = wasteBinMapper.updateByPrimaryKeySelective(wasteBin);
        if (flag == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public WasteBin findWasteBinById(Long id) {
        WasteBin wasteBin = wasteBinMapper.selectByPrimaryKey(id);
        if (wasteBin != null) {
            return wasteBin;
        }else {
            return null;
        }
    }

    @Override
    public PageInfo<WasteBin> findWasteBinByPage(Integer pageNum, String keywords) {
        if(pageNum == null) {
            pageNum = 1;
        }
        PageHelper.startPage(pageNum,Constants.PAGE_SIZE);
        List<WasteBin> list = wasteBinMapper.findWasteBinByPage(keywords);
        if (list != null) {
            PageInfo<WasteBin> page = new PageInfo<>(list);
            return page;
        }else {
            return null;
        }
    }
}
