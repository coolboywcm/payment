package com.payment.service.bonus.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.payment.common.Const;
import com.payment.dao.PyBonusPoolMapper;
import com.payment.dto.User;
import com.payment.dto.common.Page;
import com.payment.frame.dynasql.SqlCondition;
import com.payment.frame.dynasql.SqlRepo;
import com.payment.model.PyBonusPool;
import com.payment.model.PyBonusPoolExample;
import com.payment.service.bonus.IBonusSV;
import com.payment.service.org.IOrgSV;
import com.payment.util.DateUtil;
import com.payment.util.UuidUtil;
@Service
@Transactional
public class BounsSVImpl implements IBonusSV {
	@Autowired
	private PyBonusPoolMapper mapper;
	@Autowired
	private SqlRepo sqlRepo;
	@Autowired
	private IOrgSV orgSv;
	@Override
	public PyBonusPool getById(String id) throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public void add(PyBonusPool record) throws Exception {
		record.setId(UuidUtil.get32UUID());
		record.setCreateTime(DateUtil.getTime());
		record.setState("1");
		record.setUsedTotal(BigDecimal.ZERO);
		mapper.insert(record);
	}

	@Override
	public void mod(PyBonusPool record) throws Exception {
		mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Map<String, Object>> list(Page page) throws Exception {
		StringBuilder sql = new StringBuilder();
		Map<String,Object> params = new HashMap<String,Object>();
		SqlCondition cond = new SqlCondition();
		sql.append(" select a.*,b.name as org_name,case  when a.state = '1' then '正常' else '未知' end as state_name  from py_bonus_pool a, sys_org b where a.state ='1' and a.org_id = b.id ");
		User user = page.getUser();
		if(user!=null && Const.ROLE_ID_CASHIER.equals(user.getROLE_ID())){
			sql.append("and a.org_id in (select org_id from py_shop_info s where s.id = '"+user.getShopId()+"')");
		}
		String qryName = page.getPd().getString("qryName");
		if(!StringUtils.isEmpty(qryName)){
			sql.append(" and (a.name like :qryName) ");
			params.put("qryName", "%" + qryName + "%");
		}
		String condition = orgSv.getOrgCondtion(user, "b.id", null);
		sql.append(condition);
		List<Map<String, Object>> userList = sqlRepo.fetchBySql(sql.toString(), params, cond,page);
		return userList;
	}

	@Override
	public void del(String id) throws Exception {
		PyBonusPool record = mapper.selectByPrimaryKey(id);
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
	public List<PyBonusPool> getList(PyBonusPoolExample ex) throws Exception {
		return mapper.selectByExample(ex);
	}
}
