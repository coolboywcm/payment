package com.payment.controller.report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.payment.controller.base.BaseController;
import com.payment.dto.common.Page;
import com.payment.frame.annotation.SetUserInfo;
import com.payment.model.PyActive;
import com.payment.model.PyActiveExample;
import com.payment.model.PyShopInfo;
import com.payment.model.PyShopInfoExample;
import com.payment.service.active.IActiveSV;
import com.payment.service.menu.IMenuSV;
import com.payment.service.report.IReportSV;
import com.payment.service.shop.IShopSV;
import com.payment.util.ObjectExcelView;
import com.payment.util.PageData;

@Controller  
@RequestMapping("/report")  
public class ReportController  extends BaseController  {
	private static final Logger log = LoggerFactory
			.getLogger(ReportController.class);
	@Autowired
	private IMenuSV menuSV;
	@Autowired
	private IReportSV reportSV;
	@Autowired
	private IActiveSV activeSv;
	@Autowired
	private IShopSV shopSv;
	@RequestMapping("/busCollectList")  
	public ModelAndView listShops(@SetUserInfo Page page,String type)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		page.setPd(pd);
		try {
			List<Map<String, Object>> list = reportSV.busCollectReport(page, type);
			mv.addObject("list",list);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		mv.addObject("pd",pd);
		mv.setViewName("system/report/busCollect_list");
		
		PyShopInfoExample ex1 = new PyShopInfoExample();
		PyShopInfoExample.Criteria c1 = ex1.createCriteria();
		c1.andStateEqualTo("1");
		ex1.setOrderByClause(" create_time  ");
		List<PyShopInfo> shopList = shopSv.getList(ex1);
		mv.addObject("shopList",shopList);
        return mv;  
    }  
	
	@RequestMapping("/busCollectAll")  
    public String busCollectAll(String type,@SetUserInfo Page page,HttpServletRequest request,Model model){  
        //int userId = Integer.parseInt(request.getParameter("id"));  
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		mv.addObject("pd",pd);
		request.setAttribute("pd",pd);
        return "system/report/busCollect_all";  
    }  
	
	@RequestMapping("/activeCollectList")  
    public ModelAndView activeCollectList(@SetUserInfo Page page,HttpServletRequest request,Model model){  
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		page.setPd(pd);
		try {
			PyActiveExample ex = new PyActiveExample();
			PyActiveExample.Criteria c = ex.createCriteria();
			c.andStateEqualTo("1");
			List<PyActive>	activeList = activeSv.getList(ex);
			mv.addObject("activeList", activeList);
			List<Map<String, Object>> list = reportSV.activeCollectReport(page);
			mv.addObject("list",list);
			PyShopInfoExample ex1 = new PyShopInfoExample();
			PyShopInfoExample.Criteria c1 = ex1.createCriteria();
			c1.andStateEqualTo("1");
			ex1.setOrderByClause(" create_time  ");
			List<PyShopInfo> shopList = shopSv.getList(ex1);
			mv.addObject("shopList",shopList);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		mv.addObject("pd",pd);
		mv.setViewName("system/report/activeCollect_list");
        return mv;  
    } 

	@RequestMapping("/cashierShareList")  
    public ModelAndView cashierShareList(@SetUserInfo Page page,HttpServletRequest request,Model model){  
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		page.setPd(pd);
		try {
			PyActiveExample ex = new PyActiveExample();
			PyActiveExample.Criteria c = ex.createCriteria();
			c.andStateEqualTo("1");
			List<PyActive>	activeList = activeSv.getList(ex);
			mv.addObject("activeList", activeList);
			List<Map<String, Object>> list = reportSV.cashierShareReport(page);
			mv.addObject("list",list);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		mv.addObject("pd",pd);
		mv.setViewName("system/report/cashierShare_list");
        return mv;  
    } 
	
	@RequestMapping(value="/excel")
	public ModelAndView exportExcel(@SetUserInfo Page page,String type){
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String range = pd.getString("range");
		try{	
				Map<String,Object> dataMap = new HashMap<String,Object>();
				List<String> titles = new ArrayList<String>();
				
				titles.add("序号"); 		//1
				if("shop".equals(range)){
					titles.add("商户");
				}
				if("terminal".equals(range)){
					titles.add("终端编号");
				}
				titles.add("报表日期");  		//2
				titles.add("订单金额");  		//3
				titles.add("订单笔数");			//4
				titles.add("实收金额");		//5
				titles.add("优惠金额");		//6
				titles.add("退货笔数");			//7
				titles.add("退货金额");			//8

				
				dataMap.put("titles", titles);
				page.setShowCount(1000000);
				page.setPd(pd);
				List<Map<String, Object>> list = reportSV.busCollectReport(page, type);
				List<PageData> varList = new ArrayList<PageData>();
				for(int i=0;i<list.size();i++){
					PageData vpd = new PageData();
					vpd.put("var1", i+1);		//1
					if("terminal".equals(range)){
						vpd.put("var2", list.get(i).get("code"));	
						vpd.put("var3", list.get(i).get("payTime"));		//2
						vpd.put("var4", this.formatValue(list.get(i).get("amountTotal")));				//3
						vpd.put("var5", list.get(i).get("orderCount"));		//4
						vpd.put("var6", this.formatValue(list.get(i).get("realAmountTotal")));			//5
						vpd.put("var7", this.formatValue(list.get(i).get("discountAmountTotal")));		//6
						vpd.put("var8", list.get(i).get("refundCount"));		//7
						vpd.put("var9", this.formatValue(list.get(i).get("refundAmountTotal")));		//8
					}else if("shop".equals(range)){
						vpd.put("var2", list.get(i).get("shopName"));
						vpd.put("var3", list.get(i).get("payTime"));		//2
						vpd.put("var4", this.formatValue(list.get(i).get("amountTotal")));				//3
						vpd.put("var5", list.get(i).get("orderCount"));		//4
						vpd.put("var6", this.formatValue(list.get(i).get("realAmountTotal")));			//5
						vpd.put("var7", this.formatValue(list.get(i).get("discountAmountTotal")));		//6
						vpd.put("var8", list.get(i).get("refundCount"));		//7
						vpd.put("var9", this.formatValue(list.get(i).get("refundAmountTotal")));		//8
					}else{
						vpd.put("var2", list.get(i).get("payTime"));		//2
						vpd.put("var3", this.formatValue(list.get(i).get("amountTotal")));			//3
						vpd.put("var4", list.get(i).get("orderCount"));		//4
						vpd.put("var5", this.formatValue(list.get(i).get("realAmountTotal")));		//5
						vpd.put("var6", this.formatValue(list.get(i).get("discountAmountTotal")));		//6
						vpd.put("var7", list.get(i).get("refundCount"));		//7
						vpd.put("var8", this.formatValue(list.get(i).get("refundAmountTotal")));	//8
					}
					varList.add(vpd);
				}
				
				dataMap.put("varList", varList);
				
				ObjectExcelView erv = new ObjectExcelView();
				erv.setFileName("业务汇总报表");
				mv = new ModelAndView(erv,dataMap);
			
		} catch(Exception e){
			e.printStackTrace();
			logger.error(e.toString(), e);
		}
		return mv;
	}
	
	private String formatValue(Object s){
		String result = "0";
		if(s!=null && !StringUtils.isEmpty((String)s)){
			result = Float.parseFloat((String)s)/100+"";
		}
		return result;
	}
	@RequestMapping(value="/activeExcel")
	public ModelAndView activeExcel(@SetUserInfo Page page,String type){
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String range = pd.getString("range");
		try{	
				Map<String,Object> dataMap = new HashMap<String,Object>();
				List<String> titles = new ArrayList<String>();
				
				titles.add("序号"); 		//1
				if("shop".equals(range)){
					titles.add("商户");
				}
				if("terminal".equals(range)){
					titles.add("终端编号");
				}
				titles.add("活动名称");  		//2
				titles.add("订单原金额");  		//3
				titles.add("订单笔数");			//4
				titles.add("实收金额");		//5
				titles.add("优惠金额");		//6

				
				dataMap.put("titles", titles);
				page.setShowCount(1000000);
				page.setPd(pd);
				List<Map<String, Object>> list = reportSV.activeCollectReport(page);
				List<PageData> varList = new ArrayList<PageData>();
				for(int i=0;i<list.size();i++){
					PageData vpd = new PageData();
					vpd.put("var1", i+1);		//1
					if("terminal".equals(range)){
						vpd.put("var2", list.get(i).get("code"));	
						vpd.put("var3", list.get(i).get("activeName"));		//3
						vpd.put("var4", this.formatValue(list.get(i).get("amountTotal")));			//4
						vpd.put("var5", list.get(i).get("orderCount"));		//5
						vpd.put("var6", this.formatValue(list.get(i).get("realAmountTotal")));			//6
						vpd.put("var7", this.formatValue(list.get(i).get("discountAmountTotal")));	//7
					}else if("shop".equals(range)){
						vpd.put("var2", list.get(i).get("shopName"));
						vpd.put("var3", list.get(i).get("activeName"));		//3
						vpd.put("var4", this.formatValue(list.get(i).get("amountTotal")));			//4
						vpd.put("var5", list.get(i).get("orderCount"));		//5
						vpd.put("var6", this.formatValue(list.get(i).get("realAmountTotal")));			//6
						vpd.put("var7", this.formatValue(list.get(i).get("discountAmountTotal")));	//7
					}else{
						vpd.put("var2", list.get(i).get("activeName"));		//3
						vpd.put("var3", this.formatValue(list.get(i).get("amountTotal")));			//4
						vpd.put("var4", list.get(i).get("orderCount"));		//5
						vpd.put("var5", this.formatValue(list.get(i).get("realAmountTotal")));			//6
						vpd.put("var6", this.formatValue(list.get(i).get("discountAmountTotal")));	//7
					}
					varList.add(vpd);
				}
				
				dataMap.put("varList", varList);
				
				ObjectExcelView erv = new ObjectExcelView();
				erv.setFileName("活动汇总报表");
				mv = new ModelAndView(erv,dataMap);
			
		} catch(Exception e){
			e.printStackTrace();
			logger.error(e.toString(), e);
		}
		return mv;
	}
	
	@RequestMapping(value="/cashierShareExcel")
	public ModelAndView cashierShareExcel(@SetUserInfo Page page,String type){
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		try{	
				Map<String,Object> dataMap = new HashMap<String,Object>();
				List<String> titles = new ArrayList<String>();
				
				titles.add("序号"); 		//1
				titles.add("支付运营商");  		//2
				titles.add("商户号");  		//3
				titles.add("收银员号");			//4
				titles.add("时间");		//5
				titles.add("交易笔数");		//6
				titles.add("商户分润金额(元)");		//7
				titles.add("收银员分润金额(元)");		//8
				
				dataMap.put("titles", titles);
				page.setShowCount(1000000);
				page.setPd(pd);
				List<Map<String, Object>> list = reportSV.cashierShareReport(page);
				List<PageData> varList = new ArrayList<PageData>();
				for(int i=0;i<list.size();i++){
					PageData vpd = new PageData();
					vpd.put("var1", i+1);		//1
					vpd.put("var2", list.get(i).get("orgName"));		//2
					vpd.put("var3", list.get(i).get("shopName"));			//3
					vpd.put("var4", list.get(i).get("cashierCode"));		//4
					if(StringUtils.isEmpty(pd.getString("beginDate")) && StringUtils.isEmpty(pd.getString("endDate")) ){
						vpd.put("var5","--");			//5
					}
					if(StringUtils.isEmpty(pd.getString("beginDate")) && !StringUtils.isEmpty(pd.getString("endDate")) ){
						vpd.put("var5",pd.getString("endDate")+"之前");			//5
					}
					if(!StringUtils.isEmpty(pd.getString("beginDate")) && StringUtils.isEmpty(pd.getString("endDate")) ){
						vpd.put("var5",pd.getString("beginDate")+"至今");			//5
					}
					if(StringUtils.isEmpty(pd.getString("beginDate")) && !StringUtils.isEmpty(pd.getString("endDate")) ){
						vpd.put("var5",pd.getString("beginDate")+"--"+pd.getString("endDate"));			//5
					}
					vpd.put("var6", list.get(i).get("orderCount"));	//6
					vpd.put("var7", list.get(i).get("shopShare"));	//7
					vpd.put("var8", list.get(i).get("cashierShare"));	//8
					varList.add(vpd);
				}
				
				dataMap.put("varList", varList);
				
				ObjectExcelView erv = new ObjectExcelView();
				erv.setFileName("收银员分润报表");
				mv = new ModelAndView(erv,dataMap);
			
		} catch(Exception e){
			e.printStackTrace();
			logger.error(e.toString(), e);
		}
		return mv;
	}
}
