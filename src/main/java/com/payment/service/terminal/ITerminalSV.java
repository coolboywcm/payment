package com.payment.service.terminal;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.payment.dto.common.Page;
import com.payment.model.PyTerminal;
import com.payment.model.PyTerminalExample;

public interface ITerminalSV {
	public List<PyTerminal> getList(PyTerminalExample ex) throws Exception;

	public PyTerminal getById(String id) throws Exception;

	public void add(PyTerminal record) throws Exception;

	public void del(String id) throws Exception;

	public void mod(PyTerminal record) throws Exception;

	public List<Map<String, Object>> getPageList(Page page) throws Exception;

	public void batch(int count, PyTerminal record) throws Exception;
	
	public void del(String[] ids) throws Exception;

	public void batch(PyTerminal record, MultipartFile file) throws Exception;
}
