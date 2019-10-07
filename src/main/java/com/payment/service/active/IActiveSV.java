package com.payment.service.active;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.payment.dto.common.Page;
import com.payment.model.PyActive;
import com.payment.model.PyActiveCard;
import com.payment.model.PyActiveExample;
import com.payment.model.PyActiveShop;
import com.payment.model.PyActiveWithBLOBs;

public interface IActiveSV {
	public List<PyActive> getList(PyActiveExample ex) throws Exception;

	public PyActiveWithBLOBs getById(String id) throws Exception;

	public void add(PyActiveWithBLOBs record) throws Exception;

	public void del(String id) throws Exception;

	public void mod(PyActiveWithBLOBs record) throws Exception;

	public List<Map<String, Object>> listActive(Page page) throws Exception;

	public void del(String[] ids) throws Exception;
	
	public void add(PyActiveWithBLOBs record,MultipartFile file) throws Exception;
	
	public void add(PyActiveWithBLOBs record,String cardStr) throws Exception;
	
	public void setShop(String activeId,String shopId,String userId)throws Exception;
	
	public void delShop(String shopId)throws Exception;
	
	public List<PyActiveShop> getShopList(String activeId)throws Exception;

	public void mod(PyActiveWithBLOBs active, List<PyActiveCard> cardList)
			throws Exception;

	public void mod(PyActiveWithBLOBs record, String str) throws Exception;

	public void mod(PyActiveWithBLOBs record, MultipartFile file) throws Exception;

	public void add(PyActiveWithBLOBs active, List<PyActiveCard> cardList)
			throws Exception;

	public List<Map<String, Object>> listCard(Page page,String activeId) throws Exception;
	
	public void delCard(String id) throws Exception;
}
