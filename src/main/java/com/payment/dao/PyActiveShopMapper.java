package com.payment.dao;

import com.payment.model.PyActiveShop;
import com.payment.model.PyActiveShopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PyActiveShopMapper {
    long countByExample(PyActiveShopExample example);

    int deleteByExample(PyActiveShopExample example);

    int deleteByPrimaryKey(String id);

    int insert(PyActiveShop record);

    int insertSelective(PyActiveShop record);

    List<PyActiveShop> selectByExample(PyActiveShopExample example);

    PyActiveShop selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PyActiveShop record, @Param("example") PyActiveShopExample example);

    int updateByExample(@Param("record") PyActiveShop record, @Param("example") PyActiveShopExample example);

    int updateByPrimaryKeySelective(PyActiveShop record);

    int updateByPrimaryKey(PyActiveShop record);
}