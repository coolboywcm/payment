package com.payment.dao;

import com.payment.model.SysGlQx;
import com.payment.model.SysGlQxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysGlQxMapper {
    long countByExample(SysGlQxExample example);

    int deleteByExample(SysGlQxExample example);

    int deleteByPrimaryKey(String glId);

    int insert(SysGlQx record);

    int insertSelective(SysGlQx record);

    List<SysGlQx> selectByExample(SysGlQxExample example);

    SysGlQx selectByPrimaryKey(String glId);

    int updateByExampleSelective(@Param("record") SysGlQx record, @Param("example") SysGlQxExample example);

    int updateByExample(@Param("record") SysGlQx record, @Param("example") SysGlQxExample example);

    int updateByPrimaryKeySelective(SysGlQx record);

    int updateByPrimaryKey(SysGlQx record);
}