package com.payment.dao;

import com.payment.model.PyAdimg;
import com.payment.model.PyAdimgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PyAdimgMapper {
    long countByExample(PyAdimgExample example);

    int deleteByExample(PyAdimgExample example);

    int deleteByPrimaryKey(String id);

    int insert(PyAdimg record);

    int insertSelective(PyAdimg record);

    List<PyAdimg> selectByExample(PyAdimgExample example);

    PyAdimg selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PyAdimg record, @Param("example") PyAdimgExample example);

    int updateByExample(@Param("record") PyAdimg record, @Param("example") PyAdimgExample example);

    int updateByPrimaryKeySelective(PyAdimg record);

    int updateByPrimaryKey(PyAdimg record);
}