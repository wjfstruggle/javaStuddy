package com.cdc.ecommerce.mapper;

import com.cdc.ecommerce.model.Toilet;
import com.cdc.ecommerce.model.ToiletExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ToiletMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table toilet
     *
     * @mbg.generated
     */
    long countByExample(ToiletExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table toilet
     *
     * @mbg.generated
     */
    int deleteByExample(ToiletExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table toilet
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long pkId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table toilet
     *
     * @mbg.generated
     */
    int insert(Toilet record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table toilet
     *
     * @mbg.generated
     */
    int insertSelective(Toilet record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table toilet
     *
     * @mbg.generated
     */
    List<Toilet> selectByExample(ToiletExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table toilet
     *
     * @mbg.generated
     */
    Toilet selectByPrimaryKey(Long pkId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table toilet
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Toilet record, @Param("example") ToiletExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table toilet
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Toilet record, @Param("example") ToiletExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table toilet
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Toilet record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table toilet
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Toilet record);

    List<Toilet> findToiletPage(String keywords);

    int updateCheckStatus(Long id, byte checkStatus);
}