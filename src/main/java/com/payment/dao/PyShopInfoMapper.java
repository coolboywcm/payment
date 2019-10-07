package com.payment.dao;

import com.payment.model.PyShopInfo;
import com.payment.model.PyShopInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PyShopInfoMapper {
    long countByExample(PyShopInfoExample example);

    int deleteByExample(PyShopInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(PyShopInfo record);

    int insertSelective(PyShopInfo record);

    List<PyShopInfo> selectByExample(PyShopInfoExample example);

    PyShopInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PyShopInfo record, @Param("example") PyShopInfoExample example);

    int updateByExample(@Param("record") PyShopInfo record, @Param("example") PyShopInfoExample example);

    int updateByPrimaryKeySelective(PyShopInfo record);

    int updateByPrimaryKey(PyShopInfo record);
}