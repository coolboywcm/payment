package com.payment.dao;

import com.payment.model.PyOrder;
import com.payment.model.PyOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PyOrderMapper {
    long countByExample(PyOrderExample example);

    int deleteByExample(PyOrderExample example);

    int deleteByPrimaryKey(String id);

    int insert(PyOrder record);

    int insertSelective(PyOrder record);

    List<PyOrder> selectByExampleWithBLOBs(PyOrderExample example);

    List<PyOrder> selectByExample(PyOrderExample example);

    PyOrder selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PyOrder record, @Param("example") PyOrderExample example);

    int updateByExampleWithBLOBs(@Param("record") PyOrder record, @Param("example") PyOrderExample example);

    int updateByExample(@Param("record") PyOrder record, @Param("example") PyOrderExample example);

    int updateByPrimaryKeySelective(PyOrder record);

    int updateByPrimaryKeyWithBLOBs(PyOrder record);

    int updateByPrimaryKey(PyOrder record);
}