package com.payment.controller.adimg;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.payment.controller.base.BaseController;
import com.payment.dto.User;
import com.payment.dto.common.Page;
import com.payment.frame.annotation.SetUserInfo;
import com.payment.model.PyAdimg;
import com.payment.model.PyShopInfo;
import com.payment.model.PyShopInfoExample;
import com.payment.model.PyTerminal;
import com.payment.model.PyTerminalExample;
import com.payment.model.SysOrg;
import com.payment.model.SysOrgExample;
import com.payment.service.adimg.IAdimgSV;
import com.payment.service.common.ISysFileSV;
import com.payment.service.org.IOrgSV;
import com.payment.service.shop.IShopSV;
import com.payment.service.terminal.ITerminalSV;
import com.payment.util.AppUtil;
import com.payment.util.PageData;

@Controller
@RequestMapping("/adimg")
public class AdimgController extends BaseController {
	@Autowired
	private IAdimgSV sv;
	@Autowired
	private IOrgSV orgSv;
	@Autowired
	private IShopSV shopSv;
	@Autowired
	private ITerminalSV tSv;
	@Autowired
	private ISysFileSV sysFileSv;
	
	@RequestMapping(value="/edit")
	public ModelAndView edit(String id,String type,@SetUserInfo Page page)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String action = "add".equals(type) ? "add" : "mod";
		if("edit".equals(type)){
			PyAdimg	bean = sv.getById(id);
			mv.addObject("bean", bean);
			mv.addObject("shopId", bean.getShopId());
		}
		mv.setViewName("system/adimg/adimg_edit");
		mv.addObject("type", type);
		mv.addObject("pd", pd);
		mv.addObject("action", action);

		PyShopInfoExample ex1 = new PyShopInfoExample();
		PyShopInfoExample.Criteria c1 = ex1.createCriteria();
		c1.andStateEqualTo("1");
		ex1.setOrderByClause(" create_time  ");
		List<PyShopInfo> shopList = shopSv.getList(ex1);
		mv.addObject("shopList", JSONArray.toJSONString(shopList));
		
		SysOrgExample ex = new SysOrgExample();
		SysOrgExample.Criteria c = ex.createCriteria();
		c.andStateEqualTo("1");
		ex.setOrderByClause(" create_time  ");
		List<SysOrg> orgList = orgSv.getOrgList(ex);
		mv.addObject("orgList", orgList);
		return mv;
	}
	
	@RequestMapping(value="/add")
	public ModelAndView add(PyAdimg	bean,MultipartFile file1,MultipartFile file2,MultipartFile file3)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		User user = this.getCurUser();
		bean.setCreateUserId(user.getUSER_ID());
		try{
			bean.setFileId1(sysFileSv.saveFile(file1));
			bean.setFileId2(sysFileSv.saveFile(file2));
			bean.setFileId3(sysFileSv.saveFile(file3));
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
	public ModelAndView mod(PyAdimg	bean,MultipartFile file1,MultipartFile file2,MultipartFile file3)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		try{
			if(file1!=null && file1.getSize() > 0){
				bean.setFileId1(sysFileSv.saveFile(file1));
			}
			if(file2!=null && file2.getSize() > 0){
				bean.setFileId2(sysFileSv.saveFile(file2));
			}
			if(file3!=null && file2.getSize() > 0){
				bean.setFileId3(sysFileSv.saveFile(file3));
			}
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
	@RequestMapping(value="/listAdimg")
	public ModelAndView listAdimg(Page page)throws Exception{
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
		
		mv.setViewName("system/adimg/adimg_list");
		mv.addObject("list", list);
		mv.addObject("pd", pd);
		return mv;
	}
	
	/**
	 * 获取终端列表
	 */
	@RequestMapping(value="/getShopTerminal")
	@ResponseBody
	public Object getShopTerminal(String shopId) {
		PageData pd = new PageData();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", "0");
		try {
			PyTerminalExample ex = new PyTerminalExample();
			PyTerminalExample.Criteria c = ex.createCriteria();
			c.andShopIdEqualTo(shopId);
			List<PyTerminal> tList = tSv.getList(ex);
			map.put("data", tList);
		} catch (Exception e) {
			map.put("code", "-1");
			logger.error(e.toString(), e);
		} finally {
			logAfter(logger);  
		}
		return map;
	}
}
