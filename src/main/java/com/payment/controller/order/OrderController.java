package com.payment.controller.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.payment.controller.base.BaseController;
import com.payment.dto.common.Page;
import com.payment.frame.annotation.SetUserInfo;
import com.payment.model.PyActiveExample;
import com.payment.service.active.IActiveSV;
import com.payment.service.order.IOrderSV;
import com.payment.service.org.IOrgSV;
import com.payment.util.ObjectExcelView;
import com.payment.util.PageData;

@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {
	@Autowired
	private IOrderSV sv;
	@Autowired
	private IOrgSV orgSv;
	@Autowired
	private IActiveSV activeSv;
	
	
	/**
	 * 显示订单列表
	 */
	@RequestMapping(value="/listOrder")
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
		PyActiveExample ex = new PyActiveExample();
		PyActiveExample.Criteria c = ex.createCriteria();
		c.andStateEqualTo("1");
		List<Map<String, Object>>	list = sv.list(page);
		mv.setViewName("system/order/order_list");
		mv.addObject("list", list);
		mv.addObject("activeList", activeSv.getList(ex));
		mv.addObject("pd", pd);
		return mv;
	}
	
	@RequestMapping(value="/excel")
	public ModelAndView exportExcel(@SetUserInfo Page page){
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		try{	
				Map<String,Object> dataMap = new HashMap<String,Object>();
				List<String> titles = new ArrayList<String>();
				
				titles.add("序号"); 		//1
				titles.add("结果");  		//2
				titles.add("商户名称");  		//3
				titles.add("商户终端");			//4
				titles.add("交易日期");		//5
				titles.add("交易名称");		//6
				titles.add("卡号");			//7
				titles.add("活动名称");			//8
				titles.add("订单金额");		//9
				titles.add("实收金额");		//10
				titles.add("优惠金额");	//11
				titles.add("优惠份数");	//12
				
				dataMap.put("titles", titles);
				page.setShowCount(1000000);
				page.setPd(pd);
				List<Map<String, Object>> list = sv.list(page);
				List<PageData> varList = new ArrayList<PageData>();
				for(int i=0;i<list.size();i++){
					PageData vpd = new PageData();
					vpd.put("var1", i+1);		//1
					vpd.put("var2", list.get(i).get("orderStateName"));		//2
					vpd.put("var3", list.get(i).get("shopName"));			//3
					vpd.put("var4", list.get(i).get("posCode"));		//4
					vpd.put("var5", list.get(i).get("payTime"));			//5
					vpd.put("var6", list.get(i).get("tradeName"));	//6
					vpd.put("var7", list.get(i).get("cardNo"));		//7
					vpd.put("var8", list.get(i).get("activeName"));	//8
					vpd.put("var9", list.get(i).get("orderAmount"));		//9
					vpd.put("var10", list.get(i).get("realAmount"));			//10
					vpd.put("var11", list.get(i).get("discountAmount"));			//11
					vpd.put("var12", list.get(i).get("isDiscount"));			//12
					varList.add(vpd);
				}
				
				dataMap.put("varList", varList);
				
				ObjectExcelView erv = new ObjectExcelView();
				erv.setFileName("交易流水统计");
				mv = new ModelAndView(erv,dataMap);
			
		} catch(Exception e){
			e.printStackTrace();
			logger.error(e.toString(), e);
		}
		return mv;
	}
}
