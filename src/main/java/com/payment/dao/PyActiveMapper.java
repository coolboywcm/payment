package com.payment.dao;

import com.payment.model.PyActive;
import com.payment.model.PyActiveExample;
import com.payment.model.PyActiveWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PyActiveMapper {
    long countByExample(PyActiveExample example);

    int deleteByExample(PyActiveExample example);

    int deleteByPrimaryKey(String id);

    int insert(PyActiveWithBLOBs record);

    int insertSelective(PyActiveWithBLOBs record);

    List<PyActiveWithBLOBs> selectByExampleWithBLOBs(PyActiveExample example);

    List<PyActive> selectByExample(PyActiveExample example);

    PyActiveWithBLOBs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PyActiveWithBLOBs record, @Param("example") PyActiveExample example);

    int updateByExampleWithBLOBs(@Param("record") PyActiveWithBLOBs record, @Param("example") PyActiveExample example);

    int updateByExample(@Param("record") PyActive record, @Param("example") PyActiveExample example);

    int updateByPrimaryKeySelective(PyActiveWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PyActiveWithBLOBs record);

    int updateByPrimaryKey(PyActive record);
}