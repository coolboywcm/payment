package com.payment.controller.active;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.payment.controller.base.BaseController;
import com.payment.dto.User;
import com.payment.dto.common.Page;
import com.payment.model.PyActiveDetail;
import com.payment.model.SysOrg;
import com.payment.model.SysOrgExample;
import com.payment.service.active.IActiveDetailSV;
import com.payment.service.org.IOrgSV;
import com.payment.util.AppUtil;
import com.payment.util.PageData;

@Controller
@RequestMapping("/activeDetail")
public class ActiveDetailController extends BaseController {
	@Autowired
	private IActiveDetailSV sv;
	@Autowired
	private IOrgSV orgSv;

	@RequestMapping(value="/edit")
	public ModelAndView edit(String id,String type)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String action = "add".equals(type) ? "add" : "mod";
		if("edit".equals(type)){
			PyActiveDetail	bean = sv.getById(id);
			mv.addObject("bean", bean);
			pd.put("activeId", bean.getActiveId());
		}
		mv.setViewName("system/active/active_detail_edit");
		mv.addObject("type", type);
		mv.addObject("pd", pd);
		mv.addObject("action", action);
		return mv;
	}
	
	@RequestMapping(value="/add")
	public ModelAndView add(PyActiveDetail	bean)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		User user = this.getCurUser();
		bean.setCreateUserId(user.getUSER_ID());
		try{
			sv.add(bean);
			mv.addObject("code","0");
			mv.addObject("msg","success");
		}catch(Exception e){
			logger.error(e.toString(), e);
			mv.addObject("code","-1");
			mv.addObject("msg","操作失败："+e.getMessage());
		}
		mv.setViewName("save_result");
		mv.addObject("bean", bean);
		mv.addObject("type", "edit");
		mv.addObject("pd", pd);
		mv.addObject("action", "mod");
		return mv;
	}
	
	@RequestMapping(value="/mod")
	public ModelAndView mod(PyActiveDetail	bean)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		try{
			sv.mod(bean);
			mv.addObject("code","0");
			mv.addObject("msg","success");
		}catch(Exception e){
			logger.error(e.toString(), e);
			mv.addObject("code","-1");
			mv.addObject("msg","操作失败："+e.getMessage());
		}
		mv.setViewName("save_result");
		mv.addObject("bean", bean);
		mv.addObject("type", "edit");
		mv.addObject("pd", pd);
		mv.addObject("action", "mod");
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
	@RequestMapping(value="/listActiveDetail")
	public ModelAndView listActiveDetail(Page page)throws Exception{
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
		List<Map<String, Object>>	list = sv.list(page);			//列出列表
		
		mv.setViewName("system/active/active_detail_list");
		mv.addObject("list", list);
		mv.addObject("pd", pd);
		return mv;
	}
}
