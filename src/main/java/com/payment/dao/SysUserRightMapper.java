package com.payment.dao;

import com.payment.model.SysUserRight;
import com.payment.model.SysUserRightExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserRightMapper {
    long countByExample(SysUserRightExample example);

    int deleteByExample(SysUserRightExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysUserRight record);

    int insertSelective(SysUserRight record);

    List<SysUserRight> selectByExample(SysUserRightExample example);

    SysUserRight selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysUserRight record, @Param("example") SysUserRightExample example);

    int updateByExample(@Param("record") SysUserRight record, @Param("example") SysUserRightExample example);

    int updateByPrimaryKeySelective(SysUserRight record);

    int updateByPrimaryKey(SysUserRight record);
}