package com.payment.service.adimg;

import java.util.List;
import java.util.Map;

import com.payment.dto.common.Page;
import com.payment.model.PyAdimg;
import com.payment.model.PyAdimgExample;

public interface IAdimgSV {
	public PyAdimg getById(String id) throws Exception;

	public void add(PyAdimg record) throws Exception;

	public void mod(PyAdimg record) throws Exception;

	public List<Map<String, Object>> list(Page page) throws Exception;

	public void del(String id) throws Exception;

	public void del(String[] ids) throws Exception;
	
	public List<PyAdimg> getList(PyAdimgExample ex) throws Exception;
}
