package com.payment.controller.active;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.payment.common.Const;
import com.payment.controller.base.BaseController;
import com.payment.dto.common.Page;
import com.payment.frame.annotation.SetUserInfo;
import com.payment.model.PyActive;
import com.payment.model.PyActiveShop;
import com.payment.model.PyActiveWithBLOBs;
import com.payment.model.PyBonusPool;
import com.payment.model.PyBonusPoolExample;
import com.payment.model.PyShopInfo;
import com.payment.model.PyShopInfoExample;
import com.payment.model.SysOrg;
import com.payment.model.SysOrgExample;
import com.payment.service.active.IActiveSV;
import com.payment.service.bonus.IBonusSV;
import com.payment.service.org.IOrgSV;
import com.payment.service.shop.IShopSV;
import com.payment.util.AppUtil;
import com.payment.util.FileDownload;
import com.payment.util.PageData;
import com.payment.util.PathUtil;

@Controller
@RequestMapping("/active")
public class ActiveController extends BaseController {
	@Autowired
	private IActiveSV sv;
	@Autowired
	private IOrgSV orgSv;
	@Autowired
	private IBonusSV bonusSv;
	@Autowired
	private IShopSV shopSv;
	/**
	 * 显示商户列表(商户组)
	 */
	@RequestMapping(value="/listShops")
	public ModelAndView listShops(@SetUserInfo Page page)throws Exception{
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
		List<Map<String, Object>>	shopList = shopSv.listShop(page);			//列出商户列表
		
		mv.setViewName("system/active/active_shop");
		List<PyActiveShop> ckedShopList = sv.getShopList(pd.getString("id"));
		mv.addObject("ckedShopList", ckedShopList);
		mv.addObject("shopList", shopList);
		mv.addObject("pd", pd);
		return mv;
	}
	
	/**
	 * 显示已选中商户列表(商户组)
	 */
	@RequestMapping(value="/listCkedShops")
	public ModelAndView listCkedShops(@SetUserInfo Page page)throws Exception{
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
		List<Map<String, Object>>	shopList = shopSv.listShop(page);			//列出商户列表
		
		mv.setViewName("system/active/active_shop_cked");
		List<PyActiveShop> ckedShopList = sv.getShopList(pd.getString("id"));
		mv.addObject("ckedShopList", ckedShopList);
		mv.addObject("shopList", shopList);
		mv.addObject("pd", pd);
		return mv;
	}
	
	/**
	 * 显示已选中商户列表(商户组)
	 */
	@RequestMapping(value="/listCards")
	public ModelAndView listCards(Page page)throws Exception{
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
		List<Map<String, Object>>	cardList = sv.listCard(page,pd.getString("activeId"));			//列出卡列表
		
		mv.setViewName("system/active/active_card_edit");
		mv.addObject("cardList", cardList);
		mv.addObject("pd", pd);
		return mv;
	}
	
	/**
	 * 新增卡规则
	 */
	@RequestMapping(value="/addCards")
	public ModelAndView addCards(Page page)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		
		page.setPd(pd);
		PyActive	active = sv.getById(pd.getString("activeId"));			
		
		mv.setViewName("system/active/active_card_add");
		mv.addObject("active", active);
		mv.addObject("pd", pd);
		return mv;
	}
	
	
	/**
	 * 显示商户列表(商户组)
	 */
	@RequestMapping(value="/listActives")
	public ModelAndView listUsers(@SetUserInfo Page page)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String type = this.getRequest().getParameter("type");
		String title = "定额优惠";
		if("zkyh".equals(type)){
			title = "折扣优惠";
		}
		if("sjyh".equals(type)){
			title = "随机优惠";
		}	
		if("ljyh".equals(type)){
			title = "立减优惠";
		}
		pd.put("title", title);
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
		List<Map<String, Object>>	activeList = sv.listActive(page);			//列出商户列表
		
		mv.setViewName("system/active/active_list");
		mv.addObject("activeList", activeList);
		mv.addObject("pd", pd);
		return mv;
	}
	
	/**
	 * 显示商户列表(商户组)
	 */
	@RequestMapping(value="/mainListActives")
	public ModelAndView mainListActives(Page page)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		
		page.setPd(pd);
		List<Map<String, Object>>	activeList = sv.listActive(page);			//列出商户列表
		
		mv.setViewName("system/active/active_main_list");
		mv.addObject("activeList", activeList);
		mv.addObject("pd", pd);
		return mv;
	}
	
	/**
	 * 批量删除
	 */
	@RequestMapping(value="/delCard")
	@ResponseBody
	public Object delCard(String id) {
		PageData pd = new PageData();
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			pd = this.getPageData();
            sv.delCard(id);
		} catch (Exception e) {
			logger.error(e.toString(), e);
		} finally {
			logAfter(logger);  
		}
		return AppUtil.returnObject(pd, map);
	}
	
	@RequestMapping(value="/goEdit")
	public ModelAndView goEdit(String id,String type)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		PyActiveWithBLOBs active = new PyActiveWithBLOBs();
		if(id!=null && !"".equals(id)){
			active = sv.getById(id);
			mv.addObject("shopId", active.getShopId());
			type = active.getType();
		}
		SysOrgExample ex = new SysOrgExample();
		SysOrgExample.Criteria c = ex.createCriteria();
		c.andStateEqualTo("1");
		ex.setOrderByClause(" create_time  ");
		List<SysOrg> orgList = orgSv.getOrgList(ex);
		mv.addObject("orgList", orgList);
		PyBonusPoolExample ex2 = new PyBonusPoolExample();
		PyBonusPoolExample.Criteria c2 = ex2.createCriteria();
		c2.andStateEqualTo("1");
		ex2.setOrderByClause(" create_time  ");
		List<PyBonusPool> bonusList = bonusSv.getList(ex2);
		mv.addObject("bonusList", bonusList);
		
		PyShopInfoExample ex1 = new PyShopInfoExample();
		PyShopInfoExample.Criteria c1 = ex1.createCriteria();
		c1.andStateEqualTo("1");
		ex1.setOrderByClause(" create_time  ");
		List<PyShopInfo> shopList = shopSv.getList(ex1);
		mv.addObject("shopList", JSONArray.toJSONString(shopList));
		
		mv.setViewName("system/active/active_edit_"+type);
		mv.addObject("active", active);
		mv.addObject("pd", pd);
		if(StringUtils.isEmpty(id)){
			mv.addObject("action", "addActive");
		}else{
			mv.addObject("action", "modActive");
		}
		return mv;
	}
	/**
	 * 查看
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goView")
	public ModelAndView goView(@SetUserInfo Page page)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		page.setPd(pd);
		List<Map<String, Object>>	activeList = sv.listActive(page);
		
		mv.setViewName("system/active/active_view");
		mv.addObject("bean", activeList.get(0));
		mv.addObject("pd", pd);
		return mv;
	}
	
	/**
	 * 新增商户
	 */
	@RequestMapping(value="/addActive")
	public ModelAndView addActive(PyActiveWithBLOBs active,MultipartFile file) throws Exception{
		ModelAndView mv = this.getModelAndView();
		String id = this.get32UUID();
		PageData pd = new PageData();
		try {
			active.setCreateUserId(this.getCurUser().getUSER_ID());
			if("1".equals(active.getCardAddType())){
				if("2".equals(active.getCardIdentifyType())){
					sv.add(active,active.getCardNo());
				}else if("1".equals(active.getCardIdentifyType())){
					sv.add(active,active.getCardBin());
				}else{
					throw new Exception("未知的卡识别类型");
				}
			}else if("2".equals(active.getCardAddType())){
				sv.add(active,file);
			}else{
				throw new Exception("未知的卡添加方式");
			}
			mv.addObject("msg","success");
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
			mv.addObject("msg",e.getMessage());
		}
		mv.setViewName("save_result");
		return mv;
	}
	
	/**
	 * 下载模版
	 */
	@RequestMapping(value="/downExcel")
	public void downExcel(HttpServletResponse response,String type)throws Exception{
		if("1".equals(type)){
			FileDownload.fileDownload(response, PathUtil.getClasspath() + Const.FILEPATHFILE + "CardBinImportTemplate.xls", "CardBinImportTemplate.xls");
		}
		if("2".equals(type)){
			FileDownload.fileDownload(response, PathUtil.getClasspath() + Const.FILEPATHFILE + "CardNoImportTemplate.xls", "CardNoImportTemplate.xls");
		}
	}
	
	/**
	 * 新增卡规则
	 */
	@RequestMapping(value="/modActiveCard")
	public ModelAndView modActiveCard(PyActiveWithBLOBs active,MultipartFile file) throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		String id = this.get32UUID();
		pd = this.getPageData();
		try {
			String cardNo = active.getCardNo();
			String cardBin = active.getCardBin();
			String cardAddType = active.getCardAddType();
			String cardIdentifyType = active.getCardIdentifyType();
			active = sv.getById(active.getId());
			active.setCardAddType(cardAddType);
			active.setCardIdentifyType(cardIdentifyType);
			if("1".equals(active.getCardAddType())){
				if("2".equals(active.getCardIdentifyType())){
					active.setCardNo(cardNo);
					sv.mod(active,active.getCardNo());
				}else if("1".equals(active.getCardIdentifyType())){
					active.setCardBin(cardBin);
					sv.mod(active,active.getCardBin());
				}else{
					throw new Exception("未知的卡识别类型");
				}
			}else if("2".equals(active.getCardAddType())){
				sv.mod(active,file);
			}else{
				throw new Exception("未知的卡添加方式");
			}
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
	@RequestMapping(value="/modActive")
	public ModelAndView modActive(PyActiveWithBLOBs active,MultipartFile file) throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		String id = this.get32UUID();
		pd = this.getPageData();
		try {
			sv.mod(active);
			/*if("1".equals(active.getCardAddType())){
				if("2".equals(active.getCardIdentifyType())){
					sv.mod(active,active.getCardNo());
				}else if("1".equals(active.getCardIdentifyType())){
					sv.mod(active,active.getCardBin());
				}else{
					throw new Exception("未知的卡识别类型");
				}
			}else if("2".equals(active.getCardAddType())){
				sv.mod(active,file);
			}else{
				throw new Exception("未知的卡添加方式");
			}*/
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
	
	/**
	 * 设置商户
	 */
	@RequestMapping(value="/setShop")
	@ResponseBody
	public Object setShop(String ids,String activeId) {
		PageData pd = new PageData();
		ModelAndView mv = this.getModelAndView();
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			pd = this.getPageData();
            sv.setShop(activeId, ids, this.getCurUser().getUSER_ID());
            mv.addObject("msg","success");
		} catch (Exception e) {
			logger.error(e.toString(), e);
			mv.addObject("msg","failed:"+e.getMessage());
		} finally {
			logAfter(logger);  
		}
		return AppUtil.returnObject(pd, map);
	}
	
	/**
	 * 删除商户
	 */
	@RequestMapping(value="/delShop")
	@ResponseBody
	public Object delShop(String id) {
		PageData pd = new PageData();
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			pd = this.getPageData();
            sv.delShop(id);
		} catch (Exception e) {
			logger.error(e.toString(), e);
		} finally {
			logAfter(logger);  
		}
		return AppUtil.returnObject(pd, map);
	}
	
}
