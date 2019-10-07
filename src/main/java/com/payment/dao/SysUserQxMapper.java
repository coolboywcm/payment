package com.payment.dao;

import com.payment.model.SysUserQx;
import com.payment.model.SysUserQxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserQxMapper {
    long countByExample(SysUserQxExample example);

    int deleteByExample(SysUserQxExample example);

    int deleteByPrimaryKey(String uId);

    int insert(SysUserQx record);

    int insertSelective(SysUserQx record);

    List<SysUserQx> selectByExample(SysUserQxExample example);

    SysUserQx selectByPrimaryKey(String uId);

    int updateByExampleSelective(@Param("record") SysUserQx record, @Param("example") SysUserQxExample example);

    int updateByExample(@Param("record") SysUserQx record, @Param("example") SysUserQxExample example);

    int updateByPrimaryKeySelective(SysUserQx record);

    int updateByPrimaryKey(SysUserQx record);
}