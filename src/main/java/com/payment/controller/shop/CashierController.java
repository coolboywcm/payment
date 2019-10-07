package com.payment.controller.shop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.payment.controller.base.BaseController;
import com.payment.dto.User;
import com.payment.dto.common.Page;
import com.payment.frame.annotation.SetUserInfo;
import com.payment.model.PyShopInfo;
import com.payment.model.PyShopInfoExample;
import com.payment.model.SysUser;
import com.payment.service.org.IOrgSV;
import com.payment.service.shop.IShopSV;
import com.payment.service.user.IUserSV;
import com.payment.util.AppUtil;
import com.payment.util.DateUtil;
import com.payment.util.PageData;

@Controller
@RequestMapping("/cashier")
public class CashierController extends BaseController {
	@Autowired
	private IUserSV sv;
	@Autowired
	private IOrgSV orgSv;
	@Autowired
	private IShopSV shopSv;

	@RequestMapping(value="/edit")
	public ModelAndView edit(String id,String type)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String action = "add".equals(type) ? "addCashier" : "modCashier";
		if("edit".equals(type)){
			SysUser	 bean = sv.findByUId(id);
			mv.addObject("bean", bean);
		}
		PyShopInfoExample ex = new PyShopInfoExample();
		PyShopInfoExample.Criteria c = ex.createCriteria();
		c.andStateEqualTo("1");
		ex.setOrderByClause(" create_time  ");
		List<PyShopInfo> shopList = shopSv.getList(ex);
		mv.addObject("shopList", shopList);
		mv.setViewName("system/cashier/cashier_edit");
		mv.addObject("type", type);
		mv.addObject("pd", pd);
		mv.addObject("action", action);
		return mv;
	}
	
	
	@RequestMapping(value="/addCashier")
	public ModelAndView addCashier(SysUser	bean)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		User user = this.getCurUser();
		bean.setCreateUserId(user.getUSER_ID());
		bean.setCreateTime(DateUtil.getTime());
		try{
			String userId = this.get32UUID();
			bean.setUserId(userId);
			bean.setUsername(bean.getName());
			bean.setRoleId("4");//固定收银员
			bean.setPassword( new SimpleHash("SHA-1", bean.getName(),bean.getPassword()).toString());
			sv.saveUser(bean);
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
		mv.addObject("action", "modCashier");
		return mv;
	}
	
	@RequestMapping(value="/modCashier")
	public ModelAndView modCashier(SysUser	bean)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		String userId = bean.getUserId();
		pd = this.getPageData();
		
		pd.put("USER_ID", userId);	//ID
		pd.put("RIGHTS", "");					//权限
		pd.put("LAST_LOGIN", "");				//最后登录时间
		pd.put("IP", "");						//IP
		pd.put("STATUS", "0");					//状态
		pd.put("SKIN", "default");				//默认皮肤
		pd.put("SHOP_ID", bean.getShopId());
		SysUser record = sv.findByUId(userId);
		if(record!=null){
			record.setName(bean.getName());
			record.setUsername(bean.getName());
			String newPwd = new SimpleHash("SHA-1", bean.getName(),bean.getPassword()).toString();
			record.setPassword(newPwd);
			record.setShopId(bean.getShopId());
			sv.modUser(record);
			mv.addObject("msg","success");
		}else{
			mv.addObject("msg","failed");
		}
		mv.addObject("bean", bean);
		mv.addObject("type", "edit");
		mv.addObject("pd", pd);
		mv.addObject("action", "modCashier");
		mv.setViewName("save_result");
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
            sv.deleteAllU(ids.split(","));
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
            sv.deleteAllU(id.split(","));
		} catch (Exception e) {
			logger.error(e.toString(), e);
		} finally {
			logAfter(logger);  
		}
		return AppUtil.returnObject(pd, map);
	}
	
	/**
	 * 显示列表(组)
	 */
	@RequestMapping(value="/listCashier")
	public ModelAndView listCashier(@SetUserInfo Page page)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();	
		page.setPd(pd);
		pd.put("isOnlyCashier", "1");
		List<Map<String, Object>>	list = sv.listUser(page);			//列出列表
		
		mv.setViewName("system/cashier/cashier_list");
		mv.addObject("list", list);
		mv.addObject("pd", pd);
		return mv;
	}
}
