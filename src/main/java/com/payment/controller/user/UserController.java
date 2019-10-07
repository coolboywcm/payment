package com.payment.controller.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.payment.controller.base.BaseController;
import com.payment.dto.common.Page;
import com.payment.model.SysOrg;
import com.payment.model.SysOrgExample;
import com.payment.model.SysRole;
import com.payment.model.SysRoleExample;
import com.payment.model.SysUser;
import com.payment.model.SysUserExample;
import com.payment.service.org.IOrgSV;
import com.payment.service.role.IRoleSV;
import com.payment.service.user.IUserSV;
import com.payment.util.AppUtil;
import com.payment.util.PageData;

@Controller  
@RequestMapping("/user")  
public class UserController  extends BaseController {
	@Autowired
	private IUserSV userSV;
	@Autowired
	private IRoleSV roleSV;
	@Autowired
	private IOrgSV orgSv;
	/**
	 * 显示用户列表(用户组)
	 */
	@RequestMapping(value="/listUsers")
	public ModelAndView listUsers(Page page)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		
		String USERNAME = pd.getString("USERNAME");
		
		if(null != USERNAME && !"".equals(USERNAME)){
			USERNAME = USERNAME.trim();
			pd.put("USERNAME", USERNAME);
		}
		
		String lastLoginStart = pd.getString("lastLoginStart");
		String lastLoginEnd = pd.getString("lastLoginEnd");
		
		if(lastLoginStart != null && !"".equals(lastLoginStart)){
			lastLoginStart = lastLoginStart+" 00:00:00";
			pd.put("lastLoginStart", lastLoginStart);
		}
		if(lastLoginEnd != null && !"".equals(lastLoginEnd)){
			lastLoginEnd = lastLoginEnd+" 00:00:00";
			pd.put("lastLoginEnd", lastLoginEnd);
		} 
		
		page.setPd(pd);
		List<Map<String, Object>>	userList = userSV.listUser(page);			//列出用户列表
		
		mv.setViewName("system/user/user_list");
		mv.addObject("userList", userList);
		mv.addObject("pd", pd);
		return mv;
	}

	/**
	 * 保存用户
	 */
	@RequestMapping(value="/saveU")
	public ModelAndView saveU(SysUser user) throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		String userId = this.get32UUID();
		pd = this.getPageData();
		
		pd.put("USER_ID", userId);	//ID
		pd.put("RIGHTS", "");					//权限
		pd.put("LAST_LOGIN", "");				//最后登录时间
		pd.put("IP", "");						//IP
		pd.put("STATUS", "0");					//状态
		pd.put("SKIN", "default");				//默认皮肤
		
		pd.put("PASSWORD", new SimpleHash("SHA-1", pd.getString("USERNAME"), pd.getString("PASSWORD")).toString());
		user.setPassword(new SimpleHash("SHA-1", pd.getString("USERNAME"), pd.getString("PASSWORD")).toString());
		if(null == userSV.findByUId(userId)){
			userSV.saveU(pd);
			mv.addObject("msg","success");
		}else{
			mv.addObject("msg","failed");
		}
		mv.setViewName("save_result");
		return mv;
	}
	
	/**
	 * 判断用户名是否存在
	 */
	@RequestMapping(value="/hasU")
	@ResponseBody
	public Object hasU(String userName){
		Map<String,String> map = new HashMap<String,String>();
		String errInfo = "success";
		try{
			SysUserExample example = new SysUserExample();
			SysUserExample.Criteria c = example.createCriteria();
			c.andUsernameEqualTo(userName);
			if(userSV.findUserByExample(example) != null){
				errInfo = "error";
			}
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		map.put("result", errInfo);				//返回结果
		return AppUtil.returnObject(new PageData(), map);
	}
	
	/**
	 * 判断邮箱是否存在
	 */
	@RequestMapping(value="/hasE")
	@ResponseBody
	public Object hasE(String email){
		Map<String,String> map = new HashMap<String,String>();
		String errInfo = "success";
		try{
			
			SysUserExample example = new SysUserExample();
			SysUserExample.Criteria c = example.createCriteria();
			c.andEmailEqualTo(email);
			if(userSV.findUserByExample(example) != null){
				errInfo = "error";
			}
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		map.put("result", errInfo);				//返回结果
		return AppUtil.returnObject(new PageData(), map);
	}
	
	/**
	 * 判断编码是否存在
	 */
	@RequestMapping(value="/hasN")
	@ResponseBody
	public Object hasN(String number){
		Map<String,String> map = new HashMap<String,String>();
		String errInfo = "success";
		try{
			
			SysUserExample example = new SysUserExample();
			SysUserExample.Criteria c = example.createCriteria();
			c.andNumberEqualTo(number);
			if(userSV.findUserByExample(example) != null){
				errInfo = "error";
			}
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		map.put("result", errInfo);				//返回结果
		return AppUtil.returnObject(new PageData(), map);
	}
	
	/**
	 * 修改用户
	 */
	@RequestMapping(value="/editU")
	public ModelAndView editU() throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		if(pd.getString("PASSWORD") != null && !"".equals(pd.getString("PASSWORD"))){
			pd.put("PASSWORD", new SimpleHash("SHA-1", pd.getString("USERNAME"), pd.getString("PASSWORD")).toString());
		}
		userSV.editU(pd);
		//if(Jurisdiction.buttonJurisdiction(menuUrl, "edit")){userSV.editU(pd);}
		//userSV.editU(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**
	 * 去修改用户页面
	 */
	@RequestMapping(value="/goEditU")
	public ModelAndView goEditU(String userId) throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		
		//顶部修改个人资料
		String fx = pd.getString("fx");
		
		//System.out.println(fx);
		
		if("head".equals(fx)){
			mv.addObject("fx", "head");
			pd.put("userId", this.getCurUser().getUSER_ID());
		}else{
			mv.addObject("fx", "user");
		}
		SysRoleExample ex = new SysRoleExample();
		SysRoleExample.Criteria c = ex.createCriteria();
		List<SysRole> roleList = roleSV.getList(ex);
		mv.addObject("roleList", roleList);
		//List<Role> roleList = roleService.listAllERRoles();			//列出所有二级角色
		pd = userSV.findByUId(pd);							//根据ID读取
		mv.setViewName("system/user/user_edit");
		mv.addObject("msg", "editU");
		mv.addObject("pd", pd);
		//mv.addObject("roleList", roleList);
		SysOrgExample ex1 = new SysOrgExample();
		SysOrgExample.Criteria c1 = ex1.createCriteria();
		c1.andStateEqualTo("1");
		ex1.setOrderByClause(" create_time  ");
		List<SysOrg> orgList = orgSv.getOrgList(ex1);
		mv.addObject("orgList", orgList);
		return mv;
	}
	
	/**
	 * 去新增用户页面
	 */
	@RequestMapping(value="/goAddU")
	public ModelAndView goAddU()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		
		//roleList = roleService.listAllERRoles();			//列出所有二级角色ok
		SysRoleExample ex = new SysRoleExample();
		SysRoleExample.Criteria c = ex.createCriteria();
		List<SysRole> roleList = roleSV.getList(ex);
		mv.addObject("roleList", roleList);
		SysOrgExample ex1 = new SysOrgExample();
		SysOrgExample.Criteria c1 = ex1.createCriteria();
		c1.andStateEqualTo("1");
		ex1.setOrderByClause(" create_time  ");
		List<SysOrg> orgList = orgSv.getOrgList(ex1);
		mv.addObject("orgList", orgList);
		mv.setViewName("system/user/user_edit");
		mv.addObject("msg", "saveU");
		mv.addObject("pd", pd);
		//mv.addObject("roleList", roleList);

		return mv;
	}
	
	/**
	 * 批量删除
	 */
	@RequestMapping(value="/deleteAllU")
	@ResponseBody
	public Object deleteAllU() {
		PageData pd = new PageData();
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			pd = this.getPageData();
			List<PageData> pdList = new ArrayList<PageData>();
			String USER_IDS = pd.getString("USER_IDS");
			
			if(null != USER_IDS && !"".equals(USER_IDS)){
				String ArrayUSER_IDS[] = USER_IDS.split(",");
				userSV.deleteAllU(ArrayUSER_IDS);
				pd.put("msg", "ok");
			}else{
				pd.put("msg", "no");
			}
			
			pdList.add(pd);
			map.put("list", pdList);
		} catch (Exception e) {
			logger.error(e.toString(), e);
		} finally {
			logAfter(logger);  
		}
		return AppUtil.returnObject(pd, map);
	}
}
