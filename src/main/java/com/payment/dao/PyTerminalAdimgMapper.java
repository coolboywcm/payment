package com.payment.dao;

import com.payment.model.PyTerminalAdimg;
import com.payment.model.PyTerminalAdimgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PyTerminalAdimgMapper {
    long countByExample(PyTerminalAdimgExample example);

    int deleteByExample(PyTerminalAdimgExample example);

    int deleteByPrimaryKey(String id);

    int insert(PyTerminalAdimg record);

    int insertSelective(PyTerminalAdimg record);

    List<PyTerminalAdimg> selectByExample(PyTerminalAdimgExample example);

    PyTerminalAdimg selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PyTerminalAdimg record, @Param("example") PyTerminalAdimgExample example);

    int updateByExample(@Param("record") PyTerminalAdimg record, @Param("example") PyTerminalAdimgExample example);

    int updateByPrimaryKeySelective(PyTerminalAdimg record);

    int updateByPrimaryKey(PyTerminalAdimg record);
}