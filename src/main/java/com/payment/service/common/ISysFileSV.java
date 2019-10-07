package com.payment.service.common;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.payment.dto.common.Page;
import com.payment.model.SysFile;
import com.payment.model.SysFileExample;

public interface ISysFileSV {
	public SysFile getById(String id) throws Exception;

	public void add(SysFile record) throws Exception;

	public void mod(SysFile record) throws Exception;

	public List<Map<String, Object>> list(Page page) throws Exception;

	public void del(String id) throws Exception;

	public void del(String[] ids) throws Exception;
	
	public List<SysFile> getList(SysFileExample ex) throws Exception;
	
	public String saveFile(MultipartFile file) throws Exception;
}
