package cn.springboot.mapper.simple;

import cn.springboot.model.simple.Account;
import cn.springboot.model.simple.Toilet;
import cn.springboot.model.simple.ToiletExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ToiletMapper {
    long countByExample(ToiletExample example);

    int deleteByExample(ToiletExample example);

    int deleteByPrimaryKey(Long pkId);

    int insert(Toilet record);

    int insertSelective(Toilet record);

    List<Toilet> selectByExample(ToiletExample example);

    Toilet selectByPrimaryKey(Long pkId);

    int updateByExampleSelective(@Param("record") Toilet record, @Param("example") ToiletExample example);

    int updateByExample(@Param("record") Toilet record, @Param("example") ToiletExample example);

    int updateByPrimaryKeySelective(Toilet record);

    int updateByPrimaryKey(Toilet record);

    List<Toilet> findToiletByPage(String keywords);

    int updateCheckStatus(@Param("pkId") Long pkId,@Param("checkStatus") byte checkStatus);
}