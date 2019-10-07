package com.payment.service.user.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.payment.dao.DaoSupport;
import com.payment.dao.SysUserMapper;
import com.payment.dto.User;
import com.payment.dto.common.Page;
import com.payment.frame.dynasql.SqlCondition;
import com.payment.frame.dynasql.SqlRepo;
import com.payment.model.SysUser;
import com.payment.model.SysUserExample;
import com.payment.service.org.IOrgSV;
import com.payment.service.user.IUserSV;
import com.payment.util.PageData;
@Service
@Transactional
public class UserSVImpl implements IUserSV{
	@Autowired
	private SqlRepo sqlRepo;
	@Autowired
	private SysUserMapper mapper;
	@Autowired
	private IOrgSV orgSv;
	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	@Override
	public List<PageData> listPdPageUser(Page page) throws Exception {
		StringBuilder sql = new StringBuilder();
		Map<String,Object> params = new HashMap<String,Object>();
		//param.put("parentId", parentId);
		SqlCondition cond = new SqlCondition();
		sql.append(" select * from sys_user where 1 =1 ");
		List<PageData> userList = sqlRepo.fetchBySql(sql.toString(), params, cond, PageData.class);
		return userList;
	}
	
	@Override
	public List<Map<String, Object>> listUser(Page page) throws Exception {
		StringBuilder sql = new StringBuilder();
		Map<String,Object> params = new HashMap<String,Object>();
		//param.put("parentId", parentId);
		SqlCondition cond = new SqlCondition();
		sql.append(" select a.*,s.name shop_name from sys_user a left join py_shop_info s on a.shop_id = s.id where 1 =1 ");
		/*int total = sqlRepo.fetchTotalBySql(sql.toString(), params, cond);
		page.setTotalResult(total);
		cond.page(page.getCurrentPage(), page.getShowCount());*/
		String USERNAME = page.getPd().getString("USERNAME");
		if(!StringUtils.isEmpty(USERNAME)){
			sql.append(" and a.name like :USERNAME ");
			params.put("USERNAME", "%"+USERNAME+"%");
		}
		String isOnlyCashier = page.getPd().getString("isOnlyCashier");
		if(!StringUtils.isEmpty(isOnlyCashier) && "1".equals(isOnlyCashier)){
			sql.append(" and a.ROLE_ID = '4' ");
			User user = page.getUser();
			String condition = orgSv.getOrgCondtion(user, "a.org_id", "a.shop_id",true);
			sql.append(condition);
		}
		String shopId = page.getPd().getString("shopId");
		if(!StringUtils.isEmpty(shopId)){
			sql.append(" and a.SHOP_ID = :shopId ");
			params.put("shopId", shopId);
		}
		List<Map<String, Object>> userList = sqlRepo.fetchBySql(sql.toString(), params, cond,page);
		return userList;
	}

	@Override
	public SysUser getUserByAccountAndPwd(String account, String pwd)
			throws Exception {
		StringBuilder sql = new StringBuilder();
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("account", account);
		params.put("pwd", pwd);
		
		SqlCondition cond = new SqlCondition();
		sql.append(" select * from sys_user where 1 =1 ");
		sql.append(" and ( ");
		sql.append("     (USERNAME = :account  and PASSWORD = :pwd) ");
		sql.append(" or (EMAIL = :account  and PASSWORD = :pwd) ");
		sql.append(" or (NUMBER = :account  and PASSWORD = :pwd) ");
		sql.append(" ) ");
		List<SysUser> userList = sqlRepo.fetchBySql(sql.toString(), params, cond, SysUser.class);
		if(userList!=null && !userList.isEmpty()){
			return userList.get(0);
		}
		return null;
	}

	@Override
	public void updateLastLogin(String userId, String loginTIme)
			throws Exception {
		SysUser user = mapper.selectByPrimaryKey(userId);
		user.setLastLogin(loginTIme);
		mapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public SysUser findByUId(String userId) throws Exception {
		return mapper.selectByPrimaryKey(userId);
	}

	@Override
	public SysUser findUserByExample(SysUserExample example) throws Exception {
		List<SysUser> list = this.findUserListByExample(example);
		if(list!=null &&!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<SysUser> findUserListByExample(SysUserExample example)
			throws Exception {
		return mapper.selectByExample(example);
	}

	@Override
	public void saveUser(SysUser user) throws Exception {
		mapper.insert(user);
	}

	/*
	* 保存用户
	*/
	@Override
	public void saveU(PageData pd)throws Exception{
		dao.save("com.payment.dao.UserXMapper.saveU", pd); 
	}
	
	/*
	* 批量删除用户
	*/
	public void deleteAllU(String[] USER_IDS)throws Exception{
		dao.delete("com.payment.dao.UserXMapper.deleteAllU", USER_IDS);
	}
	
	/*
	* 通过id获取数据
	*/
	public PageData findByUId(PageData pd)throws Exception{
		return (PageData)dao.findForObject("com.payment.dao.UserXMapper.findByUiId", pd);
	}
	
	/*
	* 修改用户
	*/
	public void editU(PageData pd)throws Exception{
		dao.update("com.payment.dao.UserXMapper.editU", pd);
	}

	@Override
	public void modUser(SysUser user) throws Exception {
		mapper.updateByPrimaryKeySelective(user);
	}
}
