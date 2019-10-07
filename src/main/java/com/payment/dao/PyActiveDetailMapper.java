package com.payment.dao;

import com.payment.model.PyActiveDetail;
import com.payment.model.PyActiveDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PyActiveDetailMapper {
    long countByExample(PyActiveDetailExample example);

    int deleteByExample(PyActiveDetailExample example);

    int deleteByPrimaryKey(String id);

    int insert(PyActiveDetail record);

    int insertSelective(PyActiveDetail record);

    List<PyActiveDetail> selectByExample(PyActiveDetailExample example);

    PyActiveDetail selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PyActiveDetail record, @Param("example") PyActiveDetailExample example);

    int updateByExample(@Param("record") PyActiveDetail record, @Param("example") PyActiveDetailExample example);

    int updateByPrimaryKeySelective(PyActiveDetail record);

    int updateByPrimaryKey(PyActiveDetail record);
}