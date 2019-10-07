package com.payment.controller.terminal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.payment.common.Const;
import com.payment.controller.base.BaseController;
import com.payment.dto.User;
import com.payment.dto.common.Page;
import com.payment.frame.annotation.SetUserInfo;
import com.payment.model.PyShopInfo;
import com.payment.model.PyShopInfoExample;
import com.payment.model.PyTerminal;
import com.payment.service.org.IOrgSV;
import com.payment.service.shop.IShopSV;
import com.payment.service.terminal.ITerminalSV;
import com.payment.util.AppUtil;
import com.payment.util.FileDownload;
import com.payment.util.PageData;
import com.payment.util.PathUtil;

@Controller
@RequestMapping("/terminal")
public class TerminalController extends BaseController {
	@Autowired
	private ITerminalSV sv;
	@Autowired
	private IOrgSV orgSv;
	@Autowired
	private IShopSV shopSv;

	@RequestMapping(value="/edit")
	public ModelAndView edit(String id,String type)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String action = "add".equals(type) ? "addTerminal" : "modTerminal";
		if("edit".equals(type)){
			PyTerminal	 bean = sv.getById(id);
			mv.addObject("bean", bean);
		}
		PyShopInfoExample ex = new PyShopInfoExample();
		PyShopInfoExample.Criteria c = ex.createCriteria();
		c.andStateEqualTo("1");
		ex.setOrderByClause(" create_time  ");
		List<PyShopInfo> shopList = shopSv.getList(ex);
		mv.addObject("shopList", shopList);
		mv.setViewName("system/terminal/terminal_edit");
		mv.addObject("type", type);
		mv.addObject("pd", pd);
		mv.addObject("action", action);
		return mv;
	}
	
	@RequestMapping(value="/editBatch")
	public ModelAndView editBatch(String id,String type)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String action =  "addTerminalBatch";
		PyShopInfoExample ex = new PyShopInfoExample();
		PyShopInfoExample.Criteria c = ex.createCriteria();
		c.andStateEqualTo("1");
		ex.setOrderByClause(" create_time  ");
		List<PyShopInfo> shopList = shopSv.getList(ex);
		mv.addObject("shopList", shopList);
		mv.setViewName("system/terminal/terminal_edit_batch");
		mv.addObject("type", type);
		mv.addObject("pd", pd);
		mv.addObject("action", action);
		return mv;
	}
	
	@RequestMapping(value="/editExcel")
	public ModelAndView editExcel()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String action =  "addTerminalExcel";
		mv.setViewName("system/terminal/terminal_edit_excel");
		mv.addObject("pd", pd);
		mv.addObject("action", action);
		return mv;
	}
	
	@RequestMapping(value="/addTerminalBatch")
	public ModelAndView addTerminal(PyTerminal bean,@RequestParam(value="addNum", required = true) String addNum)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		User user = this.getCurUser();
		bean.setCreateUserId(user.getUSER_ID());
		try{
			sv.batch(Integer.parseInt(addNum),bean);
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
		mv.addObject("action", "modTerminal");
		return mv;
	}
	/**
	 * 下载模版
	 */
	@RequestMapping(value="/downExcel")
	public void downExcel(HttpServletResponse response,String type)throws Exception{
		FileDownload.fileDownload(response, PathUtil.getClasspath() + Const.FILEPATHFILE + "TerminalImportTemplate.xls", "TerminalImportTemplate.xls");
	}
	
	@RequestMapping(value="/addTerminalExcel")
	public ModelAndView addTerminal(PyTerminal bean,MultipartFile file)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		User user = this.getCurUser();
		bean.setCreateUserId(user.getUSER_ID());
		try{
			sv.batch(bean,file);
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
		mv.addObject("action", "modTerminal");
		return mv;
	}
	
	@RequestMapping(value="/addTerminal")
	public ModelAndView addTerminal(PyTerminal	bean)throws Exception{
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
		mv.addObject("action", "modTerminal");
		return mv;
	}
	
	@RequestMapping(value="/modTerminal")
	public ModelAndView modTerminal(PyTerminal	bean)throws Exception{
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
		mv.addObject("action", "modTerminal");
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
	 * 显示列表(组)
	 */
	@RequestMapping(value="/listTerminal")
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
		List<Map<String, Object>>	list = sv.getPageList(page);			//列出列表
		
		mv.setViewName("system/terminal/terminal_list");
		mv.addObject("list", list);
		mv.addObject("pd", pd);
		return mv;
	}
}
