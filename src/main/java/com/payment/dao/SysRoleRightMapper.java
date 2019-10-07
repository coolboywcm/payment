package com.payment.dao;

import com.payment.model.SysRoleRight;
import com.payment.model.SysRoleRightExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleRightMapper {
    long countByExample(SysRoleRightExample example);

    int deleteByExample(SysRoleRightExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysRoleRight record);

    int insertSelective(SysRoleRight record);

    List<SysRoleRight> selectByExample(SysRoleRightExample example);

    SysRoleRight selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysRoleRight record, @Param("example") SysRoleRightExample example);

    int updateByExample(@Param("record") SysRoleRight record, @Param("example") SysRoleRightExample example);

    int updateByPrimaryKeySelective(SysRoleRight record);

    int updateByPrimaryKey(SysRoleRight record);
}