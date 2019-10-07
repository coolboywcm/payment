package com.payment.dao;

import com.payment.model.PyTerminal;
import com.payment.model.PyTerminalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PyTerminalMapper {
    long countByExample(PyTerminalExample example);

    int deleteByExample(PyTerminalExample example);

    int deleteByPrimaryKey(String id);

    int insert(PyTerminal record);

    int insertSelective(PyTerminal record);

    List<PyTerminal> selectByExample(PyTerminalExample example);

    PyTerminal selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PyTerminal record, @Param("example") PyTerminalExample example);

    int updateByExample(@Param("record") PyTerminal record, @Param("example") PyTerminalExample example);

    int updateByPrimaryKeySelective(PyTerminal record);

    int updateByPrimaryKey(PyTerminal record);
}