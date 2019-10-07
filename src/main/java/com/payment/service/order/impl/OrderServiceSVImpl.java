package com.payment.service.order.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.payment.dao.PyOrderMapper;
import com.payment.dto.User;
import com.payment.dto.common.Page;
import com.payment.frame.dynasql.SqlCondition;
import com.payment.frame.dynasql.SqlRepo;
import com.payment.model.PyOrder;
import com.payment.model.PyOrderExample;
import com.payment.service.order.IOrderSV;
import com.payment.service.org.IOrgSV;
import com.payment.util.DateUtil;
import com.payment.util.UuidUtil;
@Service
@Transactional
public class OrderServiceSVImpl implements IOrderSV {

	@Autowired
	private PyOrderMapper mapper;
	@Autowired
	private SqlRepo sqlRepo;
	@Autowired
	private IOrgSV orgSv;
	@Override
	public PyOrder getById(String id) throws Exception {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public void add(PyOrder record) throws Exception {
		record.setId(UuidUtil.get32UUID());
		record.setCreateTime(DateUtil.getTime());
		record.setState("1");
		mapper.insert(record);
	}

	@Override
	public void mod(PyOrder record) throws Exception {
		mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Map<String, Object>> list(Page page) throws Exception {
		StringBuilder sql = new StringBuilder();
		Map<String,Object> params = new HashMap<String,Object>();
		SqlCondition cond = new SqlCondition();
		sql.append(" select sd.value order_state_name,o.*,a.name active_name,s.name shop_name " +
						"   from py_order o left join sys_dict sd on o.state=sd.key, py_active a, py_shop_info s " +
						" where  o.active_id = a.id and o.shop_code = s.code and sd.group = 'ORDER_PAY_STATE' ");
		String activeId = page.getPd().getString("activeId");
		if(!StringUtils.isEmpty(activeId)){
			sql.append(" and o.active_id = :activeId ");
			params.put("activeId", activeId);
		}
		String state = page.getPd().getString("state");
		if(!StringUtils.isEmpty(activeId)){
			sql.append(" and state = :state ");
			params.put("state", state);
		}
		User user = page.getUser();
		String condition = orgSv.getOrgCondtion(user, "o.org_id", "o.shop_id",true);
		sql.append(condition);
		List<Map<String, Object>> userList = sqlRepo.fetchBySql(sql.toString(), params, cond,page);
		return userList;
	}

	@Override
	public void del(String id) throws Exception {
		PyOrder record = mapper.selectByPrimaryKey(id);
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
	public List<PyOrder> getList(PyOrderExample ex) throws Exception {
		return mapper.selectByExample(ex);
	}

}
