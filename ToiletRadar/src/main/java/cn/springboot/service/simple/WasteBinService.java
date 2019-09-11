package cn.springboot.service.simple;

import cn.springboot.model.simple.Account;
import cn.springboot.model.simple.WasteBin;
import com.github.pagehelper.PageInfo;

/**
 * @author billy
 * @date 2019/7/29 18:39
 * @Description
 */
public interface WasteBinService {

    public boolean addWasteBin(WasteBin wasteBin);

    public boolean deleteWasteBinById(Long id);

    public boolean editWasteBin(WasteBin wasteBin);

    public WasteBin findWasteBinById(Long id);

    public PageInfo<WasteBin> findWasteBinByPage(Integer pageNum, String keywords);
}
