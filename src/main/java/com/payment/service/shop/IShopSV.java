package com.payment.service.shop;

import java.util.List;
import java.util.Map;

import com.payment.dto.common.Page;
import com.payment.model.PyShopInfo;
import com.payment.model.PyShopInfoExample;

public interface IShopSV {
	public List<PyShopInfo> getList(PyShopInfoExample ex) throws Exception;

	public PyShopInfo getById(String id) throws Exception;

	public void add(PyShopInfo record) throws Exception;

	public void del(String id) throws Exception;

	public void mod(PyShopInfo record) throws Exception;

	public List<Map<String, Object>> listShop(Page page) throws Exception;

	public void del(String[] ids) throws Exception;
}
