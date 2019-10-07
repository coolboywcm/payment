package com.payment.dao;

import com.payment.model.PyBonusPool;
import com.payment.model.PyBonusPoolExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PyBonusPoolMapper {
    long countByExample(PyBonusPoolExample example);

    int deleteByExample(PyBonusPoolExample example);

    int deleteByPrimaryKey(String id);

    int insert(PyBonusPool record);

    int insertSelective(PyBonusPool record);

    List<PyBonusPool> selectByExample(PyBonusPoolExample example);

    PyBonusPool selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PyBonusPool record, @Param("example") PyBonusPoolExample example);

    int updateByExample(@Param("record") PyBonusPool record, @Param("example") PyBonusPoolExample example);

    int updateByPrimaryKeySelective(PyBonusPool record);

    int updateByPrimaryKey(PyBonusPool record);
}