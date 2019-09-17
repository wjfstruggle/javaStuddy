package cn.springboot.mapper.simple;

import cn.springboot.model.simple.WasteBin;
import cn.springboot.model.simple.WasteBinExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface WasteBinMapper {
    long countByExample(WasteBinExample example);

    int deleteByExample(WasteBinExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WasteBin record);

    int insertSelective(WasteBin record);

    List<WasteBin> selectByExample(WasteBinExample example);

    int updateByExampleSelective(@Param("record") WasteBin record, @Param("example") WasteBinExample example);

    int updateByExample(@Param("record") WasteBin record, @Param("example") WasteBinExample example);

    int updateByPrimaryKeySelective(WasteBin wasteBin);

    WasteBin selectByPrimaryKey(Long id);

    List<WasteBin> findWasteBinByPage(String keywords);

}