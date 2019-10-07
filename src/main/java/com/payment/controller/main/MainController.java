package com.payment.controller.main;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.payment.common.Const;
import com.payment.common.model.Qx;
import com.payment.controller.base.BaseController;
import com.payment.dto.Menu;
import com.payment.dto.User;
import com.payment.dto.common.Page;
import com.payment.service.menu.IMenuSV;
import com.payment.service.report.IReportSV;
import com.payment.service.role.IRoleSV;
import com.payment.util.AppUtil;
import com.payment.util.DateUtil;
import com.payment.util.PageData;
import com.payment.util.Tools;

@Controller  
@RequestMapping("/main")  
public class MainController  extends BaseController  {
	private static final Logger log = LoggerFactory
			.getLogger(MainController.class);
	@Autowired
	private IMenuSV menuSV;
	@Autowired
	private IReportSV reportSV;
	@Autowired
	private IRoleSV roleSV;
	
	@RequestMapping("/index")  
    public String index(HttpServletRequest request,Model model){  
        //int userId = Integer.parseInt(request.getParameter("id"));  
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
        List<Menu> menuList;
		try {
			Subject currentUser = SecurityUtils.getSubject();  
			Session session = currentUser.getSession();
			Qx qx = (Qx)session.getAttribute(Const.SESSION_QX);//权限
			menuList = menuSV.getMenuTreeByRoleId(roleSV.getById(qx.getId()));
			request.getSession().setAttribute("menuList", menuList);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		pd.put("SYSNAME", Tools.readTxtFile(Const.SYSNAME)); //读取系统名称
		mv.addObject("pd",pd);
		request.setAttribute("pd",pd);
        return "system/admin/index";  
    }  
	
	/**
	 * 进入tab标签
	 * @return
	 */
	@RequestMapping(value="/tab")
	public String tab(HttpServletRequest request,Model model){
		model.addAttribute("userId", "11");  
		return "system/admin/tab";
	}
	
	/**
	 * 进入首页后的默认页面
	 * @return
	 */
	@RequestMapping(value="/login_default")
	public String defaultPage(HttpServletRequest request,Model model){
		Page page = new Page();
		try {
			User user = (User)request.getSession().getAttribute(Const.SESSION_USER);
			page.setUser(user);
			List<Map<String, Object>> curYearDiscountData = reportSV.curYearDiscountReport(page);
			List<Map<String, Object>> curActiveData = reportSV.curActiveReport(page);
			String[] ym = DateUtil.getLast12Months();
			model.addAttribute("ym", ym);
			model.addAttribute("curYearDiscountData", curYearDiscountData);
			model.addAttribute("curActiveData", curActiveData);
			//1:去年，2:今年，3:当前月
			String discount_1 = (String)reportSV.discountReport("1").get("amountTotal");
			model.addAttribute("discount_1", discount_1);
			String discount_2 = (String)reportSV.discountReport("2").get("amountTotal");
			model.addAttribute("discount_2", discount_2);
			String discount_3 = (String)reportSV.discountReport("3").get("amountTotal");
			model.addAttribute("discount_3", discount_3);
			
			Map<String, Object>  yesterdayData = reportSV.yesterdayReport(page);
			model.addAttribute("yesterdayData", yesterdayData);
			Map<String, Object>  beforeYesterdayData = reportSV.beforeYesterdayReport(page);
			
			model.addAttribute("yesterdayData", yesterdayData);
			Map<String, Object>  yesterdayRate = new HashMap<String, Object>();
			yesterdayRate.put("amountTotalRate", this.getRate(Double.parseDouble((String)yesterdayData.get("amountTotal")),Double.parseDouble((String)beforeYesterdayData.get("amountTotal"))));
			yesterdayRate.put("orderCountRate", this.getRate(Double.parseDouble((String)yesterdayData.get("orderCount")),Double.parseDouble((String)beforeYesterdayData.get("orderCount"))));
			yesterdayRate.put("realAmountTotalRate", this.getRate(Double.parseDouble((String)yesterdayData.get("realAmountTotal")),Double.parseDouble((String)beforeYesterdayData.get("realAmountTotal"))));
			yesterdayRate.put("discountAmountTotalRate", this.getRate(Double.parseDouble((String)yesterdayData.get("discountAmountTotal")),Double.parseDouble((String)beforeYesterdayData.get("discountAmountTotal"))));
			model.addAttribute("yesterdayRate", yesterdayRate);
		} catch (Exception e) {
			log.error("首页获取统计数据失败：",e);
			e.printStackTrace();
		}
		return "system/admin/default";
	}
	
	private double getRate(double d1,double d2){
		double result = 0.00;
		if(d2 !=0){
			DecimalFormat df = new DecimalFormat("#.00");
			result = Double.parseDouble(df.format(d1*100/d2));
		}
		return result;
	}
	/**
	 * 获取最近一年优惠金额（月份为维度）
	 */
	@RequestMapping(value="/getCurYearDiscountData")
	@ResponseBody
	public Object getCurYearDiscountData() {
		Page page = new Page();
		PageData pd = new PageData();
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			map.put("xAxis", DateUtil.getLast12Months());//月份维度
			map.put("data", reportSV.curYearDiscountReport(page));
		} catch (Exception e) {
			logger.error(e.toString(), e);
		} finally {
			logAfter(logger);  
		}
		return AppUtil.returnObject(pd, map);
	}
	
	/**
	 * 进入首页后的默认页面
	 * @return
	 */
	@RequestMapping(value="/login_default1")
	public String demoMain(HttpServletRequest request,Model model){
		Page page = new Page();
		
		model.addAttribute("userId", "11");  
		
		return "system/admin/default";
	}

}
