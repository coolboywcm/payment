package com.payment.controller.role;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.payment.controller.base.BaseController;
import com.payment.dto.Menu;
import com.payment.dto.User;
import com.payment.dto.common.Page;
import com.payment.frame.annotation.SetUserInfo;
import com.payment.model.SysOrg;
import com.payment.model.SysOrgExample;
import com.payment.model.SysRole;
import com.payment.model.SysRoleRight;
import com.payment.service.menu.IMenuSV;
import com.payment.service.org.IOrgSV;
import com.payment.service.role.IRoleSV;
import com.payment.util.AppUtil;
import com.payment.util.PageData;

@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {
	@Autowired
	private IRoleSV sv;
	@Autowired
	private IOrgSV orgSv;
	@Autowired
	private IMenuSV menuSv;

	@RequestMapping(value="/edit")
	public ModelAndView edit(String id,String type)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String action = "add".equals(type) ? "addRole" : "modRole";
		if("edit".equals(type)){
			SysRole	role = sv.getById(id);
			mv.addObject("role", role);
			List<SysRoleRight> rightList = sv.getRoleRight(id);
			mv.addObject("rightList", rightList);
		}
		SysOrgExample ex = new SysOrgExample();
		SysOrgExample.Criteria c = ex.createCriteria();
		c.andStateEqualTo("1");
		ex.setOrderByClause(" create_time  ");
		List<SysOrg> orgList = orgSv.getOrgList(ex);
		mv.addObject("orgList", orgList);
		mv.setViewName("system/role/role_edit");
		mv.addObject("type", type);
		mv.addObject("pd", pd);
		mv.addObject("action", action);
		 List<Menu> menuList  = menuSv.getMenuTree("1");
		 mv.addObject("menuList", menuList);
		return mv;
	}
	
	@RequestMapping(value="/addRole")
	public ModelAndView addRole(SysRole	record,String[] ckMenu)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		User user = this.getCurUser();
		record.setCreateUserId(user.getUSER_ID());
		try{
			sv.add(record,ckMenu);
			mv.addObject("code","0");
			mv.addObject("msg","success");
		}catch(Exception e){
			logger.error(e.toString(), e);
			mv.addObject("code","-1");
			mv.addObject("msg","操作失败："+e.getMessage());
		}
		mv.setViewName("save_result");
		mv.addObject("record", record);
		mv.addObject("type", "edit");
		mv.addObject("pd", pd);
		mv.addObject("action", "modRole");
		return mv;
	}
	
	@RequestMapping(value="/modRole")
	public ModelAndView modRole(SysRole	record,String[] ckMenu)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		try{
			sv.mod(record,ckMenu);
			mv.addObject("code","0");
			mv.addObject("msg","success");
		}catch(Exception e){
			logger.error(e.toString(), e);
			mv.addObject("code","-1");
			mv.addObject("msg","操作失败："+e.getMessage());
		}
		mv.setViewName("save_result");
		mv.addObject("record", record);
		mv.addObject("type", "edit");
		mv.addObject("pd", pd);
		mv.addObject("action", "modRole");
		return mv;
	}
	
	/**
	 * 批量删除
	 */
	@RequestMapping(value="/deleteAll")
	@ResponseBody
	public Object deleteAll(String ids) {
		PageData pd = new PageData();
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			pd = this.getPageData();
            sv.del(ids.split(","));
		} catch (Exception e) {
			logger.error(e.toString(), e);
		} finally {
			logAfter(logger);  
		}
		return AppUtil.returnObject(pd, map);
	}
	
	/**
	 * 批量删除
	 */
	@RequestMapping(value="/del")
	@ResponseBody
	public Object del(String id) {
		PageData pd = new PageData();
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			pd = this.getPageData();
            sv.del(id);
		} catch (Exception e) {
			logger.error(e.toString(), e);
		} finally {
			logAfter(logger);  
		}
		return AppUtil.returnObject(pd, map);
	}
	
	/**
	 * 显示奖金池列表(奖金池组)
	 */
	@RequestMapping(value="/listRole")
	public ModelAndView listUsers(@SetUserInfo Page page)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		
		
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
		List<Map<String, Object>>	recordList = sv.list(page);			//列出奖金池列表
		mv.setViewName("system/role/role_list");
		mv.addObject("list", recordList);
		mv.addObject("pd", pd);
		return mv;
	}
}
