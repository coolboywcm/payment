package com.payment.service.role.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.payment.common.model.Qx;
import com.payment.dao.SysMenuMapper;
import com.payment.dao.SysRoleMapper;
import com.payment.dao.SysRoleRightMapper;
import com.payment.dto.common.Page;
import com.payment.frame.dynasql.SqlCondition;
import com.payment.frame.dynasql.SqlRepo;
import com.payment.model.SysRole;
import com.payment.model.SysRoleExample;
import com.payment.model.SysRoleRight;
import com.payment.model.SysRoleRightExample;
import com.payment.service.role.IRoleSV;
import com.payment.util.DateUtil;
import com.payment.util.UuidUtil;
@Service
@Transactional
public class RoleSVImpl implements IRoleSV {
	@Autowired
	private SysRoleMapper mapper;
	@Autowired
	private SysRoleRightMapper roleRightMapper;
	@Autowired
	private SysMenuMapper menuMapper;
	@Autowired
	private SqlRepo sqlRepo;
	@Override
	public SysRole getById(String id) throws Exception {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public void add(SysRole record,String[] ckMenu) throws Exception {
		record.setRoleId(UuidUtil.get32UUID());
		record.setCreateTime(DateUtil.getTime());
		record.setState("1");
		if(ckMenu!=null && ckMenu.length >0){
			for(String menuId : ckMenu){
				SysRoleRight roleRight = new SysRoleRight();
				roleRight.setId(UuidUtil.get32UUID());
				roleRight.setRightId(menuId);
				roleRight.setRoleId(record.getRoleId());
				roleRight.setCreateTime(DateUtil.getTime());
				roleRight.setCreateUserId(record.getCreateUserId());
				roleRightMapper.insert(roleRight);
			}
		}
		mapper.insert(record);
	}

	@Override
	public void mod(SysRole record,String[] ckMenu) throws Exception {
		SysRole oldData = mapper.selectByPrimaryKey(record.getRoleId());
		oldData.setRoleName(record.getRoleName());
		oldData.setType(record.getType());
		SysRoleRightExample ex = new SysRoleRightExample();
		SysRoleRightExample.Criteria c = ex.createCriteria();
		c.andRoleIdEqualTo(record.getRoleId());
		roleRightMapper.deleteByExample(ex);
		if(ckMenu!=null && ckMenu.length >0){
			for(String menuId : ckMenu){
				SysRoleRight roleRight = new SysRoleRight();
				roleRight.setId(UuidUtil.get32UUID());
				roleRight.setRightId(menuId);
				roleRight.setRoleId(record.getRoleId());
				roleRight.setCreateTime(DateUtil.getTime());
				roleRight.setCreateUserId(record.getCreateUserId());
				roleRightMapper.insert(roleRight);
			}
		}
		mapper.updateByPrimaryKeySelective(oldData);
	}
	
	@Override
	public List<SysRoleRight> getRoleRight(String roleId) throws Exception {
		SysRoleRightExample ex = new SysRoleRightExample();
		SysRoleRightExample.Criteria c = ex.createCriteria();
		c.andRoleIdEqualTo(roleId);
		return roleRightMapper.selectByExample(ex);
	}

	@Override
	public List<Map<String, Object>> list(Page page) throws Exception {
		StringBuilder sql = new StringBuilder();
		Map<String,Object> params = new HashMap<String,Object>();
		SqlCondition cond = new SqlCondition();
		sql.append(" select a.*,s.value type_name from sys_role a left join sys_dict s on a.type = s.key and s.group = 'ROLE_TYPE'   where state = '1' ");
		String qryName = page.getPd().getString("qryName");
		if(!StringUtils.isEmpty(qryName)){
			sql.append(" and (a.name like :qryName) ");
			params.put("qryName", "%" + qryName + "%");
		}
		List<Map<String, Object>> userList = sqlRepo.fetchBySql(sql.toString(), params, cond,page);
		return userList;
	}

	@Override
	public void del(String id) throws Exception {
		SysRole record = mapper.selectByPrimaryKey(id);
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
	public List<SysRole> getList(SysRoleExample ex) throws Exception {
		return mapper.selectByExample(ex);
	}

}
