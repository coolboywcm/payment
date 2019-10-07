package com.payment.dao;

import com.payment.model.SysDictionaries;
import com.payment.model.SysDictionariesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysDictionariesMapper {
    long countByExample(SysDictionariesExample example);

    int deleteByExample(SysDictionariesExample example);

    int deleteByPrimaryKey(String zdId);

    int insert(SysDictionaries record);

    int insertSelective(SysDictionaries record);

    List<SysDictionaries> selectByExample(SysDictionariesExample example);

    SysDictionaries selectByPrimaryKey(String zdId);

    int updateByExampleSelective(@Param("record") SysDictionaries record, @Param("example") SysDictionariesExample example);

    int updateByExample(@Param("record") SysDictionaries record, @Param("example") SysDictionariesExample example);

    int updateByPrimaryKeySelective(SysDictionaries record);

    int updateByPrimaryKey(SysDictionaries record);
}