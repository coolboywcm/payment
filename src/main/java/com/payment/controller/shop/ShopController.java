package com.payment.controller.shop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.payment.controller.base.BaseController;
import com.payment.dto.common.Page;
import com.payment.frame.annotation.SetUserInfo;
import com.payment.model.PyShopInfo;
import com.payment.model.SysOrg;
import com.payment.model.SysOrgExample;
import com.payment.service.org.IOrgSV;
import com.payment.service.shop.IShopSV;
import com.payment.util.AppUtil;
import com.payment.util.PageData;

@Controller
@RequestMapping("/shop")
public class ShopController extends BaseController {
	@Autowired
	private IShopSV sv;
	@Autowired
	private IOrgSV orgSv;
	@RequestMapping(value="/index")
	public ModelAndView index(Page page)throws Exception{
		ModelAndView mv = this.getModelAndView();
		return mv;
	}
	
	/**
	 * 显示商户列表(商户组)
	 */
	@RequestMapping(value="/listShops")
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
		List<Map<String, Object>>	shopList = sv.listShop(page);			//列出商户列表
		
		mv.setViewName("system/shop/shop_list");
		mv.addObject("shopList", shopList);
		mv.addObject("pd", pd);
		return mv;
	}
	
	@RequestMapping(value="/goEdit")
	public ModelAndView goEdit(String id)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		PyShopInfo shop = sv.getById(id);
		SysOrgExample ex = new SysOrgExample();
		SysOrgExample.Criteria c = ex.createCriteria();
		c.andStateEqualTo("1");
		ex.setOrderByClause(" create_time  ");
		List<SysOrg> orgList = orgSv.getOrgList(ex);
		mv.setViewName("system/shop/shop_edit");
		mv.addObject("shop", shop);
		mv.addObject("pd", pd);
		mv.addObject("orgList", orgList);
		if(StringUtils.isEmpty(id)){
			mv.addObject("action", "addShop");
		}else{
			mv.addObject("action", "modShop");
		}
		return mv;
	}
	
	/**
	 * 新增商户
	 */
	@RequestMapping(value="/addShop")
	public ModelAndView addShop(PyShopInfo shop) throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		String id = this.get32UUID();
		pd = this.getPageData();
		try {
			shop.setCreateUserId(this.getCurUser().getUSER_ID());
			sv.add(shop);
			mv.addObject("msg","success");
		} catch (Exception e) {
			logger.error(e);
			mv.addObject("msg","failed:"+e.getMessage());
		}
		mv.setViewName("save_result");
		return mv;
	}
	
	/**
	 * 新增商户
	 */
	@RequestMapping(value="/modShop")
	public ModelAndView modShop(PyShopInfo shop) throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		String id = this.get32UUID();
		pd = this.getPageData();
		try {
			shop.setCreateUserId(this.getCurUser().getUSER_ID());
			sv.mod(shop);
			mv.addObject("msg","success");
		} catch (Exception e) {
			logger.error(e);
			mv.addObject("msg","failed:"+e.getMessage());
		}
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
}
