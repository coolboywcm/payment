package com.payment.service.user;

import java.util.List;
import java.util.Map;

import com.payment.dto.common.Page;
import com.payment.model.SysUser;
import com.payment.model.SysUserExample;
import com.payment.util.PageData;

public interface IUserSV {
	/**
	 * 查询用户列表
	 * 
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<PageData> listPdPageUser(Page page) throws Exception;

	/**
	 * 查询用户列表
	 * 
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> listUser(Page page) throws Exception;

	/**
	 * 校验用户密码
	 * 
	 * @param account
	 * @param pwd
	 * @return
	 * @throws Exception
	 */
	public SysUser getUserByAccountAndPwd(String account, String pwd)
			throws Exception;

	/**
	 * 更新用户最后登录时间
	 * 
	 * @param userId
	 * @param loginTIme
	 * @throws Exception
	 */
	public void updateLastLogin(String userId, String loginTIme)
			throws Exception;

	/**
	 * 根据ID查询user
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public SysUser findByUId(String userId) throws Exception;

	/**
	 * 根据条件查询user
	 * 
	 * @param example
	 * @return
	 * @throws Exception
	 */
	public SysUser findUserByExample(SysUserExample example) throws Exception;
	
	/**
	 * 根据条件查询userList
	 * 
	 * @param example
	 * @return
	 * @throws Exception
	 */
	public List<SysUser> findUserListByExample(SysUserExample example) throws Exception;
	
	/**
	 * 保存用户
	 * @param user
	 * @throws Exception
	 */
	public void saveUser(SysUser user) throws Exception;
	
	/**
	 * 保存用户
	 * @param user
	 * @throws Exception
	 */
	public void modUser(SysUser user) throws Exception;
	
	/**
	 * 保存用户
	 * @param user
	 * @throws Exception
	 */
	public void saveU(PageData pd)throws Exception;
	
	/**
	 * 
	 * 批量删除用户
	 * @param USER_IDS
	 * @throws Exception
	 */
	public void deleteAllU(String[] USER_IDS)throws Exception;
	/**
	 * 通过ID获取
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public PageData findByUId(PageData pd)throws Exception;
	/**
	 * 修改用户
	 * @param pd
	 * @throws Exception
	 */
	public void editU(PageData pd)throws Exception;
}
