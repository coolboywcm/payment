package com.payment.service.active;

import java.util.List;
import java.util.Map;

import com.payment.dto.common.Page;
import com.payment.model.PyActiveDetail;
import com.payment.model.PyActiveDetailExample;
import com.payment.model.PyBonusPool;
import com.payment.model.PyBonusPoolExample;

public interface IActiveDetailSV {
	public PyActiveDetail getById(String id) throws Exception;

	public void add(PyActiveDetail record) throws Exception;

	public void mod(PyActiveDetail record) throws Exception;

	public List<Map<String, Object>> list(Page page) throws Exception;

	public void del(String id) throws Exception;

	public void del(String[] ids) throws Exception;
	
	public List<PyActiveDetail> getList(PyActiveDetailExample ex) throws Exception;
}
