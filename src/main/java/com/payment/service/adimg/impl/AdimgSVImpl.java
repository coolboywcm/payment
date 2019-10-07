package com.payment.service.adimg.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.payment.dao.PyAdimgMapper;
import com.payment.dao.PyTerminalAdimgMapper;
import com.payment.dto.common.Page;
import com.payment.frame.dynasql.SqlCondition;
import com.payment.frame.dynasql.SqlRepo;
import com.payment.model.PyAdimg;
import com.payment.model.PyAdimgExample;
import com.payment.model.PyTerminalAdimg;
import com.payment.model.PyTerminalAdimgExample;
import com.payment.service.adimg.IAdimgSV;
import com.payment.util.DateUtil;
import com.payment.util.UuidUtil;
@Service
@Transactional
public class AdimgSVImpl implements IAdimgSV {
	@Autowired
	private PyAdimgMapper mapper;
	@Autowired
	private PyTerminalAdimgMapper tMapper;
	@Autowired
	private SqlRepo sqlRepo;
	@Override
	public PyAdimg getById(String id) throws Exception {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public void add(PyAdimg record) throws Exception {
		record.setId(UuidUtil.get32UUID());
		record.setCreateTime(DateUtil.getTime());
		if(StringUtils.isEmpty(record.getShopId())){
			record.setType("1");
			List<Map<String, Object>> tList = this.getOrgTerminal(record.getOrgId());
			for(Map<String, Object> item : tList){
				PyTerminalAdimg data = new PyTerminalAdimg();
				data.setAdimgId(record.getId());
				data.setTerminalId((String)item.get("id"));
				data.setId(UuidUtil.get32UUID());
				tMapper.insert(data);
			}
		}else {
			record.setType("2");
			String[] tList = record.getTerminalId().split(",");
			for(String t : tList){
				PyTerminalAdimg data = new PyTerminalAdimg();
				data.setAdimgId(record.getId());
				data.setTerminalId(t);
				data.setId(UuidUtil.get32UUID());
				tMapper.insert(data);
			}
		}
		mapper.insert(record);
	}
	
	private List<Map<String, Object>> getOrgTerminal(String orgId) throws Exception {
		StringBuilder sql = new StringBuilder();
		Map<String,Object> params = new HashMap<String,Object>();
		SqlCondition cond = new SqlCondition();
		sql.append(" select a.*  "
				+ "        from py_terminal a where a.shop_id in ( select id from py_shop_info where org_id =  :orgId )  ");
		params.put("orgId", orgId);
		List<Map<String, Object>> result = sqlRepo.fetchBySql(sql.toString(), params, cond);
		return result;
	}

	private void delTerminal(PyAdimg record) throws Exception {
		PyTerminalAdimgExample e = new PyTerminalAdimgExample();
		PyTerminalAdimgExample.Criteria c = e.createCriteria();
		c.andAdimgIdEqualTo(record.getId());
		tMapper.deleteByExample(e);
	}
	
	@Override
	public void mod(PyAdimg record) throws Exception {
		delTerminal(record);
		if(StringUtils.isEmpty(record.getShopId())){
			record.setType("1");
			List<Map<String, Object>> tList = this.getOrgTerminal(record.getOrgId());
			for(Map<String, Object> item : tList){
				PyTerminalAdimg data = new PyTerminalAdimg();
				data.setAdimgId(record.getId());
				data.setTerminalId((String)item.get("id"));
				data.setId(UuidUtil.get32UUID());
				tMapper.insert(data);
			}
		}else {
			record.setType("2");
			String[] tList = record.getTerminalId().split(",");
			for(String t : tList){
				PyTerminalAdimg data = new PyTerminalAdimg();
				data.setAdimgId(record.getId());
				data.setTerminalId(t);
				data.setId(UuidUtil.get32UUID());
				tMapper.insert(data);
			}
		}
		mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Map<String, Object>> list(Page page) throws Exception {
		StringBuilder sql = new StringBuilder();
		Map<String,Object> params = new HashMap<String,Object>();
		SqlCondition cond = new SqlCondition();
		sql.append(" select a.*,o.name org_name,s.name shop_name "
				+ "        from py_adimg a left join sys_org o on a.org_id = o.id left join py_shop_info s on a.shop_id = s.id ");
		String activeId = page.getPd().getString("activeId");
		if(!StringUtils.isEmpty(activeId)){
			sql.append(" and active_id = :activeId ");
			params.put("activeId", activeId);
		}
		List<Map<String, Object>> userList = sqlRepo.fetchBySql(sql.toString(), params, cond,page);
		return userList;
	}

	@Override
	public void del(String id) throws Exception {
		this.delTerminal(this.getById(id));
		mapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public void del(String[] ids) throws Exception {
		for(String id : ids){
			this.del(id);
		}
	}
	@Override
	public List<PyAdimg> getList(PyAdimgExample ex) throws Exception {
		return mapper.selectByExample(ex);
	}
}
