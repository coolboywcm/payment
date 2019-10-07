package com.payment.service.menu.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.payment.common.Const;
import com.payment.dao.DaoSupport;
import com.payment.dao.SysMenuMapper;
import com.payment.dao.SysRoleRightMapper;
import com.payment.dto.Menu;
import com.payment.frame.dynasql.SqlCondition;
import com.payment.frame.dynasql.SqlRepo;
import com.payment.model.SysMenu;
import com.payment.model.SysMenuExample;
import com.payment.model.SysRole;
import com.payment.model.SysRoleRightExample;
import com.payment.service.menu.IMenuSV;

@Service
@Transactional
public class MenuSVImpl implements IMenuSV {
	@Autowired
	SysMenuMapper sysMenuMapper;
	@Autowired
	private SysRoleRightMapper roleRightMapper;
	@Autowired
	private SqlRepo sqlRepo;
	@Autowired
	private DaoSupport dao;
	
	@Override
	public List<SysMenu> getAllMenu() {
		SysMenuExample example = new SysMenuExample();
		example.createCriteria().andMenuTypeEqualTo("2");
		return sysMenuMapper.selectByExample(example);
	}
	@Override
	public List<SysMenu> getParentMenu() {
		SysMenuExample example = new SysMenuExample();
		example.createCriteria().andParentIdEqualTo("0");
		example.setOrderByClause("menuOrder");
		return sysMenuMapper.selectByExample(example);
	}
	@Override
	public List<Menu> getSubMenu(String parentId) throws Exception {
		StringBuilder sql = new StringBuilder();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("parentId", parentId);
		SqlCondition cond = new SqlCondition();
		sql.append(" select * from sys_menu where parent_id = :parentId order by menu_order ");
		List<Menu> subMenuList = sqlRepo.fetchBySql(sql.toString(), param, cond, Menu.class);
		return subMenuList;
	}
	@Override
	public List<Menu> getMenuTree(String qx) throws Exception{
		StringBuilder sql = new StringBuilder();
		Map<String,Object> param = new HashMap<String,Object>();
		SqlCondition cond = new SqlCondition();
		/*if(Const.ROLE_ID_CASHIER.equals(qx)){//收银员只能看到奖金池
			sql.append(" select * from sys_menu where menu_id = '9' order by menu_order ");
		}else{
			sql.append(" select * from sys_menu where parent_id = '0' order by menu_order ");
		}*/
		sql.append(" select * from sys_menu where parent_id = '0' order by menu_order ");
		List<Menu> parentMenuList = sqlRepo.fetchBySql(sql.toString(), param, cond, Menu.class);
		for(Menu menu : parentMenuList){
			List<Menu> subMenuList = this.getSubMenu(menu.getMenuId()+"");
			menu.setSubMenuList(subMenuList);
		}
		return parentMenuList;
	}
	
	@Override
	public List<Menu> getMenuTreeByRoleId(SysRole role) throws Exception{
		StringBuilder sql = new StringBuilder();
		Map<String,Object> param = new HashMap<String,Object>();
		SqlCondition cond = new SqlCondition();
		SysRoleRightExample ex = new SysRoleRightExample();
		SysRoleRightExample.Criteria c = ex.createCriteria();
		c.andRoleIdEqualTo(role.getRoleId());
		
		if(Const.ROLE_ID_CASHIER.equals(role.getType())){//收银员只能看到奖金池
			sql.append(" select * from sys_menu where menu_id = '9' order by menu_order ");
		}else{
			sql.append(" select * from sys_menu where parent_id = '0' order by menu_order ");
		}
		List<Menu> parentMenuList = sqlRepo.fetchBySql(sql.toString(), param, cond, Menu.class);
		List<Menu> result = new ArrayList<Menu>();
		for(Menu menu : parentMenuList){
			List<Menu> subMenuList = this.getSubMenu(menu.getMenuId()+"",role.getRoleId());
			if(subMenuList!=null && !subMenuList.isEmpty()){
				menu.setSubMenuList(subMenuList);
				result.add(menu);
			}
		}
		return result;
	}
	
	private List<Menu> getSubMenu(String parentId,String roleId) throws Exception {
		StringBuilder sql = new StringBuilder();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("parentId", parentId);
		param.put("roleId", roleId);
		SqlCondition cond = new SqlCondition();
		sql.append(" select * from sys_menu where parent_id = :parentId and menu_id in (select right_id from sys_role_right where role_id = :roleId ) order by menu_order ");
		List<Menu> subMenuList = sqlRepo.fetchBySql(sql.toString(), param, cond, Menu.class);
		return subMenuList;
	}
}
