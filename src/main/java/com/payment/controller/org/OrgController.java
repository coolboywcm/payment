package com.payment.controller.org;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.payment.common.Const;
import com.payment.controller.base.BaseController;
import com.payment.dto.User;
import com.payment.dto.common.Page;
import com.payment.model.SysOrg;
import com.payment.model.SysOrgExample;
import com.payment.service.org.IOrgSV;
import com.payment.util.PageData;

@Controller
@RequestMapping("/org")
public class OrgController extends BaseController {
	@Autowired
	private IOrgSV sv;
	@RequestMapping(value="/index")
	public ModelAndView index(Page page)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		SysOrgExample ex = new SysOrgExample();
		SysOrgExample.Criteria c = ex.createCriteria();
		c.andStateEqualTo("1");
		List<SysOrg>	list = sv.getOrgList(ex);
		JSONArray arr = JSONArray.parseArray(JSON.toJSONString(list));
		String json = arr.toString();
		json = json.replaceAll("parentId", "pId").replaceAll("MENU_NAME", "name").replaceAll("subMenu", "nodes").replaceAll("hasMenu", "checked");
		mv.addObject("zTreeNodes", json);
		mv.setViewName("system/org/orgIndex");
		mv.addObject("list", list);
		mv.addObject("pd", pd);
		return mv;
	}
	
	@RequestMapping(value="/edit")
	public ModelAndView edit(String id,String type)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String action = "add".equals(type) ? "addOrg" : "modOrg";
		if("edit".equals(type)){
			SysOrg	org = sv.getOrgById(id);
			mv.addObject("org", org);
		}
		String parentId = pd.getString("parentId");
		if(!StringUtils.isEmpty(parentId)){
			SysOrg parent = sv.getOrgById(parentId);
			mv.addObject("parent", parent);
		}
		mv.setViewName("system/org/orgEdit");
		mv.addObject("type", type);
		mv.addObject("pd", pd);
		mv.addObject("action", action);
		List<SysOrg> orgList = sv.getOrgTree(id);
		return mv;
	}
	
	@RequestMapping(value="/addOrg")
	public ModelAndView addOrg(SysOrg	org)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		User user = this.getCurUser();
		org.setCreateUserId(user.getUSER_ID());
		try{
			sv.addOrg(org);
			mv.addObject("code","0");
			mv.addObject("msg","操作成功");
		}catch(Exception e){
			logger.error(e.toString(), e);
			mv.addObject("code","-1");
			mv.addObject("msg","操作失败："+e.getMessage());
		}
		mv.setViewName("system/org/orgEdit");
		mv.addObject("org", org);
		mv.addObject("type", "edit");
		mv.addObject("pd", pd);
		mv.addObject("action", "modOrg");
		return mv;
	}
	
	@RequestMapping(value="/modOrg")
	public ModelAndView modOrg(SysOrg	org)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		try{
			sv.modOrg(org);
			mv.addObject("code","0");
			mv.addObject("msg","操作成功");
		}catch(Exception e){
			logger.error(e.toString(), e);
			mv.addObject("code","-1");
			mv.addObject("msg","操作失败："+e.getMessage());
		}
		mv.setViewName("system/org/orgEdit");
		mv.addObject("org", org);
		mv.addObject("type", "edit");
		mv.addObject("pd", pd);
		mv.addObject("action", "modOrg");
		return mv;
	}
	
	@RequestMapping(value="/delOrg")
	public ModelAndView delOrg(String 	id)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		try{
			sv.delById(id);
			mv.addObject("code","0");
			mv.addObject("msg","操作成功");
		}catch(Exception e){
			logger.error(e.toString(), e);
			mv.addObject("code","-1");
			mv.addObject("msg","操作失败："+e.getMessage());
		}
		mv.setViewName("system/org/orgEdit");
		return mv;
	}
}
