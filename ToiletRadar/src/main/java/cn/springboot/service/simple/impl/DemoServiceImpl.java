package cn.springboot.service.simple.impl;

import cn.springboot.common.constants.Constants;
import cn.springboot.config.db.pk.FactoryAboutKey;
import cn.springboot.config.db.pk.TableEnum;
import cn.springboot.mapper.simple.DemoMapper;
import cn.springboot.model.simple.Demo;
import cn.springboot.model.simple.DemoExample;
import cn.springboot.service.simple.DemoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author billy
 * @date 2019/7/29 17:03
 * @Description
 */
@Service("demoService")
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoMapper demoMapper;

    @Override
    public boolean addDemo(Demo demo) {
        if (demo != null) {
            demo.setId(FactoryAboutKey.getPK(TableEnum.Demo));//找主键自增策略
            int flag = demoMapper.insert(demo);
            if (flag == 1)
                return true;
            else
                return false;
        } else
            return false;
    }

    @Override
    public boolean deleteDemoById(String id) {
        if (StringUtil.isNotEmpty(id)) {
            int flag = demoMapper.deleteByPrimaryKey(id);
            if (flag == 1)
                return true;
            else
                return false;
        } else
            return false;
    }

    @Override
    public boolean editDemo(Demo demo) {
        if (demo != null) {
            int flag = demoMapper.updateByPrimaryKey(demo);
            if (flag == 1)
                return true;
            else
                return false;
        } else
            return false;
    }

    @Override
    public Demo findDemoById(String id) {
        if (StringUtil.isNotEmpty(id)) {
            Demo demo = demoMapper.selectByPrimaryKey(id);
            if (demo != null) {
                return demo;
            } else
                return null;
        } else
            return null;
    }

    @Override
    public PageInfo<Demo> findNewsByPage(Integer pageNum, String keywords) {
        if (pageNum == null) {
            pageNum = 1;
        }
        PageHelper.startPage(pageNum, Constants.PAGE_SIZE);
        List<Demo> demos = demoMapper.findNewsByPage(keywords);
        PageInfo<Demo> page = new PageInfo<>(demos);
        return page;
    }
}
