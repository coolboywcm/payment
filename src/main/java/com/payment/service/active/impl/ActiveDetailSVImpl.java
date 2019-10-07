package com.payment.service.active.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.payment.dao.PyActiveDetailMapper;
import com.payment.dto.common.Page;
import com.payment.frame.dynasql.SqlCondition;
import com.payment.frame.dynasql.SqlRepo;
import com.payment.model.PyActiveDetail;
import com.payment.model.PyActiveDetailExample;
import com.payment.service.active.IActiveDetailSV;
import com.payment.service.bonus.IBonusSV;
import com.payment.util.DateUtil;
import com.payment.util.UuidUtil;
@Service
@Transactional
public class ActiveDetailSVImpl implements IActiveDetailSV {
	@Autowired
	private PyActiveDetailMapper mapper;
	@Autowired
	private SqlRepo sqlRepo;
	@Override
	public PyActiveDetail getById(String id) throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public void add(PyActiveDetail record) throws Exception {
		record.setId(UuidUtil.get32UUID());
		record.setCreateTime(DateUtil.getTime());
		record.setState("1");
		mapper.insert(record);
	}

	@Override
	public void mod(PyActiveDetail record) throws Exception {
		mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Map<String, Object>> list(Page page) throws Exception {
		StringBuilder sql = new StringBuilder();
		Map<String,Object> params = new HashMap<String,Object>();
		SqlCondition cond = new SqlCondition();
		sql.append(" select * from py_active_detail where state='1' ");
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
		PyActiveDetail record = mapper.selectByPrimaryKey(id);
		record.setState("0");
		mapper.updateByPrimaryKeySelective(record);
	}
	
	@Override
	public void del(String[] ids) throws Exception {
		for(String id : ids){
			this.del(id);
		}
	}
	@Override
	public List<PyActiveDetail> getList(PyActiveDetailExample ex) throws Exception {
		return mapper.selectByExample(ex);
	}
}
