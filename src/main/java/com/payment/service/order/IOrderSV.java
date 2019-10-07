package com.payment.service.order;

import java.util.List;
import java.util.Map;

import com.payment.dto.common.Page;
import com.payment.model.PyOrder;
import com.payment.model.PyOrderExample;

public interface IOrderSV {
	public PyOrder getById(String id) throws Exception;

	public void add(PyOrder record) throws Exception;

	public void mod(PyOrder record) throws Exception;

	public List<Map<String, Object>> list(Page page) throws Exception;

	public void del(String id) throws Exception;

	public void del(String[] ids) throws Exception;
	
	public List<PyOrder> getList(PyOrderExample ex) throws Exception;
}
