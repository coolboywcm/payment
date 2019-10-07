package com.payment.dao;

import com.payment.model.PyActiveCard;
import com.payment.model.PyActiveCardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PyActiveCardMapper {
    long countByExample(PyActiveCardExample example);

    int deleteByExample(PyActiveCardExample example);

    int deleteByPrimaryKey(String id);

    int insert(PyActiveCard record);

    int insertSelective(PyActiveCard record);

    List<PyActiveCard> selectByExample(PyActiveCardExample example);

    PyActiveCard selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PyActiveCard record, @Param("example") PyActiveCardExample example);

    int updateByExample(@Param("record") PyActiveCard record, @Param("example") PyActiveCardExample example);

    int updateByPrimaryKeySelective(PyActiveCard record);

    int updateByPrimaryKey(PyActiveCard record);
}