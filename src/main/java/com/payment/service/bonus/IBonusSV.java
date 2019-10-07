package com.payment.service.bonus;

import java.util.List;
import java.util.Map;

import com.payment.dto.common.Page;
import com.payment.model.PyBonusPool;
import com.payment.model.PyBonusPoolExample;

public interface IBonusSV {
	public PyBonusPool getById(String id) throws Exception;

	public void add(PyBonusPool record) throws Exception;

	public void mod(PyBonusPool record) throws Exception;

	public List<Map<String, Object>> list(Page page) throws Exception;

	public void del(String id) throws Exception;

	public void del(String[] ids) throws Exception;
	
	public List<PyBonusPool> getList(PyBonusPoolExample ex) throws Exception;
}
