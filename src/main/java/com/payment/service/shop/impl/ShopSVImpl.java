package com.payment.service.shop.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.payment.dao.PyShopInfoMapper;
import com.payment.dto.User;
import com.payment.dto.common.Page;
import com.payment.frame.dynasql.SqlCondition;
import com.payment.frame.dynasql.SqlRepo;
import com.payment.model.PyShopInfo;
import com.payment.model.PyShopInfoExample;
import com.payment.service.org.IOrgSV;
import com.payment.service.shop.IShopSV;
import com.payment.util.DateUtil;
import com.payment.util.UuidUtil;
@Service
@Transactional
public class ShopSVImpl implements IShopSV {
	@Autowired
	private SqlRepo sqlRepo;
	@Autowired
	private PyShopInfoMapper mapper;
	@Autowired
	private IOrgSV orgSv;
	@Override
	public List<PyShopInfo> getList(PyShopInfoExample ex) throws Exception {
		return mapper.selectByExample(ex);
	}

	@Override
	public PyShopInfo getById(String id) throws Exception {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public void add(PyShopInfo record) throws Exception {
		record.setId(UuidUtil.get32UUID());
		record.setCreateTime(DateUtil.getTime());
		record.setState("1");
		mapper.insert(record);
	}

	@Override
	public void del(String id) throws Exception {
		PyShopInfo record = mapper.selectByPrimaryKey(id);
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
	public void mod(PyShopInfo record) throws Exception {
		mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Map<String, Object>> listShop(Page page) throws Exception {
		StringBuilder sql = new StringBuilder();
		Map<String,Object> params = new HashMap<String,Object>();
		SqlCondition cond = new SqlCondition();
		sql.append(" select a.*,t.terminal_count,b.name org_name from py_shop_info a" +
		        " left join (select count(*) terminal_count ,shop_id from py_terminal where state='1' group by shop_id) t on a.id = t.shop_id " +
				" , sys_org b where a.state ='1' and a.org_id = b.id ");
		String qryName = page.getPd().getString("qryName");
		if(!StringUtils.isEmpty(qryName)){
			sql.append(" and (a.name like :qryName) ");
			params.put("qryName", "%" + qryName + "%");
		}
		String qryCode = page.getPd().getString("qryCode");
		if(!StringUtils.isEmpty(qryCode)){
			sql.append(" and (a.code like :qryCode ) ");
			params.put("qryCode", "%" + qryCode + "%");
		}
		/*User user = page.getUser();
		String condition = orgSv.getOrgCondtion(user, "a.org_id", "a.id");
		sql.append(condition);*/
		List<Map<String, Object>> userList = sqlRepo.fetchBySql(sql.toString(), params, cond,page);
		return userList;
	}
}
