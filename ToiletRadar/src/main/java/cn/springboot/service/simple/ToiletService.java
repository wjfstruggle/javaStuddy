package cn.springboot.service.simple;


import cn.springboot.model.simple.Toilet;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

/**
 * 卫生间信息接口
 */
public interface ToiletService {

    public boolean addToilet(Toilet toilet);

    public boolean deleteToiletById(String id);

    public boolean editToilet(Toilet toilet);

    public Toilet findToiletById(Integer id);

    public PageInfo<Toilet> findToiletsByPage(Integer pageNum, String keywords);

    int updateByPrimaryKey(Toilet record);

    int updateCheckStatus(Long pkId, byte checkStatus);//修改卫生间审核状态

}
