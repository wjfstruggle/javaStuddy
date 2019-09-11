package cn.springboot.service.simple;

import cn.springboot.model.simple.Demo;
import com.github.pagehelper.PageInfo;

/**
 * @author billy
 * @date 2019/7/29 18:39
 * @Description
 */
public interface DemoService {

    public boolean addDemo(Demo demo);

    public boolean deleteDemoById(String id);

    public boolean editDemo(Demo demo);

    public Demo findDemoById(String id);

    public PageInfo<Demo> findNewsByPage(Integer pageNum, String keywords);
}
