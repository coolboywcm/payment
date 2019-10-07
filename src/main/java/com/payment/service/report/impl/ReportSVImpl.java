package com.payment.service.report.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.payment.common.Const;
import com.payment.dto.User;
import com.payment.dto.common.Page;
import com.payment.frame.dynasql.SqlCondition;
import com.payment.frame.dynasql.SqlRepo;
import com.payment.service.org.IOrgSV;
import com.payment.service.report.IReportSV;
import com.payment.util.DateUtil;
@Service
@Transactional
public class ReportSVImpl implements IReportSV {
	@Autowired
	private SqlRepo sqlRepo;
	@Autowired
	private IOrgSV orgSv;
	@Override
	public List<Map<String, Object>> monthDiscountReport(String month)
			throws Exception {
		StringBuilder sql = new StringBuilder();
		Map<String,Object> params = new HashMap<String,Object>();
		SqlCondition cond = new SqlCondition();
		sql.append(" select FORMAT(ifnull(AMOUNT_TOTAL,0)/100,2) AMOUNT_TOTAL, '"+month+"' ym from " );
		sql.append(" ( " );
		sql.append(" select sum(o.DISCOUNT_AMOUNT_TOTAL) AMOUNT_TOTAL,DATE_FORMAT(o.pay_time,'%Y-%m') ym  from py_order o where DATE_FORMAT(o.pay_time,'%Y-%m') = :month            ");  
		sql.append(" ) a " );
		params.put("month", month);
		Page page = null;
		List<Map<String, Object>> list = sqlRepo.fetchBySql(sql.toString(), params, cond,page);
		return list;
	}
	
	@Override
	public List<Map<String, Object>> curYearDiscountReport(Page page)
			throws Exception {
		List<Map<String, Object>> list = new ArrayList();
		String[] yms = DateUtil.getLast12Months();
		for(String ym : yms){
			List<Map<String, Object>> subList = this.monthDiscountReport(ym);
			list.add(subList.get(0));
		}
		return list;
	}

	@Override
	public Map<String, Object> yesterdayReport(Page page) throws Exception {
		StringBuilder sql = new StringBuilder();
		Map<String,Object> params = new HashMap<String,Object>();
		SqlCondition cond = new SqlCondition();
		sql.append(" select ifnull(order_count,0) order_count,ifnull(AMOUNT_TOTAL,0) AMOUNT_TOTAL,                               ");
		sql.append("   ifnull(REAL_AMOUNT_TOTAL,0) REAL_AMOUNT_TOTAL,ifnull(DISCOUNT_AMOUNT_TOTAL,0) DISCOUNT_AMOUNT_TOTAL       ");
		sql.append(" from (                                                                                                      ");
		sql.append(" select count(*) order_count, sum(o.ORDER_AMOUNT) AMOUNT_TOTAL,                                              ");
		sql.append("      sum(o.REAL_AMOUNT) REAL_AMOUNT_TOTAL,sum(o.DISCOUNT_AMOUNT_TOTAL) DISCOUNT_AMOUNT_TOTAL                ");
		sql.append(" from py_order o                                                                                             ");
		sql.append(" where  DATEDIFF(PAY_TIME,now()) = -1                                                                        ");
		User user = page.getUser();
		String condition = orgSv.getOrgCondtion(user, "o.org_id", "o.shop_id",true);
		sql.append(condition);
		sql.append(" ) a                                                                                                         ");
		List<Map<String, Object>> list = sqlRepo.fetchBySql(sql.toString(), params, cond,page);
		return list.get(0);
	}
	
	@Override
	public Map<String, Object> beforeYesterdayReport(Page page) throws Exception {
		StringBuilder sql = new StringBuilder();
		Map<String,Object> params = new HashMap<String,Object>();
		SqlCondition cond = new SqlCondition();
		sql.append(" select ifnull(order_count,0) order_count,ifnull(AMOUNT_TOTAL,0) AMOUNT_TOTAL,                               ");
		sql.append("   ifnull(REAL_AMOUNT_TOTAL,0) REAL_AMOUNT_TOTAL,ifnull(DISCOUNT_AMOUNT_TOTAL,0) DISCOUNT_AMOUNT_TOTAL       ");
		sql.append(" from (                                                                                                      ");
		sql.append(" select count(*) order_count, sum(o.ORDER_AMOUNT) AMOUNT_TOTAL,                                              ");
		sql.append("      sum(o.REAL_AMOUNT) REAL_AMOUNT_TOTAL,sum(o.DISCOUNT_AMOUNT_TOTAL) DISCOUNT_AMOUNT_TOTAL                ");
		sql.append(" from py_order o                                                                                             ");
		sql.append(" where  DATEDIFF(PAY_TIME,now()) = -2                                                                        ");
		User user = page.getUser();
		String condition = orgSv.getOrgCondtion(user, "o.org_id", "o.shop_id",true);
		sql.append(condition);
		sql.append(" ) a                                                                                                         ");
		List<Map<String, Object>> list = sqlRepo.fetchBySql(sql.toString(), params, cond,page);
		return list.get(0);
	}

	/**
	 * 周期优惠统计(去年，今年，当前月)
	 * @param type 1:去年，2:今年，3:当前月
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> discountReport(String type) throws Exception {
		StringBuilder sql = new StringBuilder();
		Map<String,Object> params = new HashMap<String,Object>();
		SqlCondition cond = new SqlCondition();
		sql.append(" select ifnull(sum(o.DISCOUNT_AMOUNT_TOTAL),0) AMOUNT_TOTAL from py_order o where 1=1");
		if("1".equals(type)){//去年
			sql.append(" and  year(o.pay_time)=year(date_sub(now(),interval 1 year))            ");  
		}
		if("1".equals(type)){//今年
			sql.append(" and YEAR(o.pay_time)=YEAR(NOW())          ");  
		}
		if("1".equals(type)){//当前月
			sql.append(" and date_format(o.pay_time, '%Y %m') = date_format(DATE_SUB(now(), INTERVAL 0 MONTH),'%Y %m')        ");  
		}
		HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
		User user = (User)request.getSession().getAttribute(Const.SESSION_USER);
		String condition = orgSv.getOrgCondtion(user, "o.org_id", "o.shop_id",true);
		sql.append(condition);
		List<Map<String, Object>> list = sqlRepo.fetchBySql(sql.toString(), params, cond);
		return list.get(0);
	}

	@Override
	public List<Map<String, Object>> curActiveReport(Page page) throws Exception {
		User user = page.getUser();
		String condition = orgSv.getOrgCondtion(user, "o.org_id", "o.shop_id",true);
		StringBuilder sql = new StringBuilder();
		Map<String,Object> params = new HashMap<String,Object>();
		SqlCondition cond = new SqlCondition();
		sql.append(" select                                                                                                                                            ");
		sql.append(" ifnull(count(*),0) active_count,                                                                                                                                            ");
		sql.append("   case                                                                                                                                            ");
		sql.append("   when a.type = 'dehd' then '定额优惠'                                                                                                            ");
		sql.append("   when a.type = 'zkyh' then '折扣优惠'                                                                                                            ");
		sql.append("   when a.type = 'sjyh' then '随机优惠'                                                                                                            ");
		sql.append("   when a.type = 'ljyh' then '立减优惠'                                                                                                            ");
		sql.append("   end type_name, sum(ifnull(a.shop_count,0)) shop_count, sum(ifnull(a.DISCOUNT_count,0)) DISCOUNT_count                                                     ");
		sql.append(" from                                                                                                                                              ");
		sql.append(" (                                                                                                                                                 ");
		sql.append("   select a.id,a.type,c.shop_count,o.DISCOUNT_count                                                                                                     ");
		sql.append("   from py_active a                                                                                                                                ");
		sql.append("    LEFT JOIN (select active_id,count(*) shop_count from py_active_shop group by active_id) c on a.id=c.active_id                                  ");
		sql.append("    LEFT JOIN (select active_id,count(*) DISCOUNT_count from py_order o "
														+ "     where 1=1 and IS_DISCOUNT = '1'"  + condition
														+ " group by active_id) o on a.id=o.active_id    ");
		sql.append(" ) a       group by a.type                                                                                                                                        ");
		List<Map<String, Object>> list = sqlRepo.fetchBySql(sql.toString(), params, cond);
		return list;
	}
	
	@Override
	public List<Map<String, Object>> busCollectReport(Page page,String type) throws Exception {
		//type: 1:日  2:月 3:季 4:年
		StringBuilder sql = new StringBuilder();
		String beginDate = page.getPd().getString("beginDate");
		String endDate = page.getPd().getString("endDate");
		String range = page.getPd().getString("range");
		String shopId = page.getPd().getString("shopId");
		Map<String,Object> params = new HashMap<String,Object>();
		SqlCondition cond = new SqlCondition();
		sql.append(" select PAY_TIME,                                                 ");
		if("terminal".equals(range)){
			sql.append(" code,                                                ");
		}
		if("shop".equals(range)){
			sql.append(" shop_name,                                                ");
		}
		sql.append("        ifnull(AMOUNT_TOTAL,0) AMOUNT_TOTAL,                                                      ");
		sql.append("        ifnull(order_count,0) order_count,ifnull(REAL_AMOUNT_TOTAL,0) REAL_AMOUNT_TOTAL,                   ");
		sql.append("        ifnull(DISCOUNT_AMOUNT_TOTAL,0) DISCOUNT_AMOUNT_TOTAL,ifnull(refund_count,0) refund_count,ifnull(REFUND_AMOUNT_TOTAL,0) REFUND_AMOUNT_TOTAL          ");
		sql.append(" FROM                                                                                                      ");
		sql.append(" (                                                                                                         ");
		sql.append(" 	select                                                                                                   ");
		if("terminal".equals(range)){
			sql.append(" t.code,                                                ");
		}
		if("shop".equals(range)){
			sql.append(" s.name shop_name,                                                ");
		}
		if("2".equals(type)){//按月
			sql.append(" 		DATE_FORMAT(PAY_TIME,'%Y%m') PAY_TIME,                                                                 ");
		}else if ("3".equals(type)){//季度
			sql.append(" 		CONCAT(DATE_FORMAT(PAY_TIME,'%Y'),'年',QUARTER(PAY_TIME),'季度') PAY_TIME,                                                   ");
		}else if ("4".equals(type)){//年
			sql.append(" 		DATE_FORMAT(PAY_TIME,'%Y') PAY_TIME,                                              ");
		}else{//默认为天
			sql.append(" 		DATE(o.PAY_TIME) PAY_TIME,                                                                             ");
		}
		sql.append(" 		sum(case when o.IS_REFUND ='1' then 0 else o.ORDER_AMOUNT end ) AMOUNT_TOTAL,                          ");
		sql.append(" 		sum(case when o.IS_REFUND ='1' then 0 else 1 end) order_count,                                         ");
		sql.append(" 		sum(case when o.IS_REFUND ='1' then 0 else o.REAL_AMOUNT end ) REAL_AMOUNT_TOTAL,                      ");
		sql.append(" 		sum(case when o.IS_REFUND ='1' then 0 else o.DISCOUNT_AMOUNT_TOTAL end ) DISCOUNT_AMOUNT_TOTAL,        ");
		sql.append(" 		sum(case when o.IS_REFUND ='1' then 1 else 0 end) refund_count,                                         ");
		sql.append(" 		sum(case when o.IS_REFUND ='1' then o.REAL_REFUND_AMOUNT else 0 end) REFUND_AMOUNT_TOTAL                                         ");
		sql.append(" 	 from py_order o LEFT JOIN py_shop_info s on o.SHOP_CODE = s.CODE                                                                                  ");
		sql.append("   	LEFT JOIN (select a.*,b.code shop_code from py_terminal a, py_shop_info b where a.shop_id = b.id ) t on o.POS_CODE = t.CODE and o.SHOP_CODE = t.shop_code                                                                                           ");
		sql.append("   where 1 = 1                                                                                             ");
		
		if(!StringUtils.isEmpty(beginDate)){
			sql.append(" and o.pay_time >= STR_TO_DATE(:beginDate,'%Y-%m-%d') ");
			params.put("beginDate", beginDate);
		}
		
		if(!StringUtils.isEmpty(endDate)){
			sql.append(" and o.pay_time <= STR_TO_DATE(:endDate,'%Y-%m-%d') ");
			params.put("endDate", endDate);
		}
		
		if("2".equals(type)){//按月
			sql.append(" 	GROUP BY DATE_FORMAT(PAY_TIME,'%Y%m')                                 ");
		}else if ("3".equals(type)){//季度
			sql.append(" 	GROUP BY CONCAT(DATE_FORMAT(PAY_TIME,'%Y'),'年',QUARTER(PAY_TIME),'季度')                                                                      ");
		}else if ("4".equals(type)){//年
			sql.append(" 	GROUP BY DATE_FORMAT(PAY_TIME,'%Y')                                                ");
		}else{//默认为天
			sql.append(" 	GROUP BY DATE(o.PAY_TIME)                                                                                ");
		}
		if("terminal".equals(range)){
			sql.append(" ,t.code                                           ");
		}
		if("shop".equals(range)){
			sql.append(" ,s.name                                           ");
		}
		if(!StringUtils.isEmpty(shopId)){
			sql.append(" and t.shop_id = :shopId ");
			params.put("shopId", shopId);
		}

		User user = page.getUser();
		String condition = orgSv.getOrgCondtion(user, "o.org_id", "o.shop_id",true);
		sql.append(condition);
		sql.append(" ) a                                                                                                       ");
		List<Map<String, Object>> list = sqlRepo.fetchBySql(sql.toString(), params, cond,page);
		return list;
	}
	
	
	@Override
	public List<Map<String, Object>> activeCollectReport(Page page) throws Exception {
		//type: 1:日  2:月 3:季 4:年
		StringBuilder sql = new StringBuilder();
		String beginDate = page.getPd().getString("beginDate");
		String endDate = page.getPd().getString("endDate");
		String activeId = page.getPd().getString("activeId");
		String range = page.getPd().getString("range");
		String shopId = page.getPd().getString("shopId");
		Map<String,Object> params = new HashMap<String,Object>();
		SqlCondition cond = new SqlCondition();
		sql.append(" select a.name active_name ,                                                 ");
		if("terminal".equals(range)){
			sql.append(" code,                                                ");
		}
		if("shop".equals(range)){
			sql.append(" shop_name,                                                ");
		}
		sql.append("        ifnull(AMOUNT_TOTAL,0) AMOUNT_TOTAL,                                                      ");
		sql.append("        ifnull(order_count,0) order_count,ifnull(REAL_AMOUNT_TOTAL,0) REAL_AMOUNT_TOTAL,                   ");
		sql.append("        ifnull(DISCOUNT_AMOUNT_TOTAL,0) DISCOUNT_AMOUNT_TOTAL,ifnull(refund_count,0) refund_count,ifnull(REFUND_AMOUNT_TOTAL,0) REFUND_AMOUNT_TOTAL          ");
		sql.append(" FROM                                                                                                      ");
		sql.append(" (                                                                                                         ");
		sql.append("   select a.name,                                                                                                       ");
		if("terminal".equals(range)){
			sql.append(" t.code,                                                ");
		}
		if("shop".equals(range)){
			sql.append(" s.name shop_name,                                                ");
		}
		sql.append(" 		sum(case when o.IS_REFUND ='1' then 0 else o.ORDER_AMOUNT end ) AMOUNT_TOTAL,                          ");
		sql.append(" 		sum(case when o.IS_REFUND ='1' then 0 else 1 end) order_count,                                         ");
		sql.append(" 		sum(case when o.IS_REFUND ='1' then 0 else o.REAL_AMOUNT end ) REAL_AMOUNT_TOTAL,                      ");
		sql.append(" 		sum(case when o.IS_REFUND ='1' then 0 else o.DISCOUNT_AMOUNT_TOTAL end ) DISCOUNT_AMOUNT_TOTAL,        ");
		sql.append(" 		sum(case when o.IS_REFUND ='1' then 1 else 0 end) refund_count,                                         ");
		sql.append(" 		sum(case when o.IS_REFUND ='1' then o.REAL_REFUND_AMOUNT else 0 end) REFUND_AMOUNT_TOTAL                                         ");
		sql.append(" 	 from py_order o  LEFT JOIN py_shop_info s on o.SHOP_CODE = s.CODE                                                                                         ");
		sql.append("    LEFT JOIN (select a.*,b.code shop_code from py_terminal a, py_shop_info b where a.shop_id = b.id ) t on o.POS_CODE = t.CODE and o.SHOP_CODE = t.shop_code                                                                               ");
		sql.append("    ,py_active  a                                                                                     ");
		sql.append("   where 1 = 1     and o.active_id =  a.id                                                                                       ");
		
		if(!StringUtils.isEmpty(beginDate)){
			sql.append(" and o.pay_time >= STR_TO_DATE(:beginDate,'%Y-%m-%d') ");
			params.put("beginDate", beginDate);
		}
		
		if(!StringUtils.isEmpty(endDate)){
			sql.append(" and o.pay_time <= STR_TO_DATE(:endDate,'%Y-%m-%d') ");
			params.put("endDate", endDate);
		}
		
		if(!StringUtils.isEmpty(activeId)){
			sql.append(" and o.active_id = :activeId ");
			params.put("activeId", activeId);
		}
		
		if(!StringUtils.isEmpty(shopId)){
			sql.append(" and t.shop_id = :shopId ");
			params.put("shopId", shopId);
		}

		User user = page.getUser();
		String condition = orgSv.getOrgCondtion(user, "o.org_id", "o.shop_id",true);
		sql.append(condition);
		
		sql.append(" 	GROUP BY a.name                                                                               ");
		if("terminal".equals(range)){
			sql.append(" ,t.code                                           ");
		}
		if("shop".equals(range)){
			sql.append(" ,s.name                                           ");
		}
		sql.append(" ) a                                                                                                       ");
		List<Map<String, Object>> list = sqlRepo.fetchBySql(sql.toString(), params, cond,page);
		return list;
	}
	
	@Override
	public List<Map<String, Object>> cashierShareReport(Page page) throws Exception {
		StringBuilder sql = new StringBuilder();
		String beginDate = page.getPd().getString("beginDate");
		String endDate = page.getPd().getString("endDate");
		Map<String,Object> params = new HashMap<String,Object>();
		SqlCondition cond = new SqlCondition();
		sql.append("	SELECT                                                                                      ");     
		sql.append("		so.NAME org_name,                                                                         ");
		sql.append("	  s.NAME shop_name,                                                                         ");
		sql.append("	  s.code shop_code,                                                                         ");
		sql.append("	  u.NUMBER  CASHIER_code,                                                                   ");
		sql.append("	  count(*)  order_count,                                                                    ");
		sql.append("	  FORMAT(sum(ifnull(o.DISCOUNT_AMOUNT,0) ) * b.SHARE_RATIO /100,2) SHOP_SHARE,              ");
		sql.append("	  FORMAT(sum(ifnull(o.DISCOUNT_AMOUNT,0) ) * (1-b.SHARE_RATIO /100),2) CASHIER_SHARE        ");
		sql.append("	FROM                                                                                        ");
		sql.append("		py_order o,                                                                               ");
		sql.append("		sys_user u,                                                                               ");
		sql.append("		py_active a,                                                                              ");
		sql.append("		py_bonus_pool b,                                                                          ");
		sql.append("		py_shop_info s,                                                                           ");
		sql.append("	  sys_org so                                                                                ");
		sql.append("	WHERE                                                                                       ");
		sql.append("		o.CASHIER_ID = u.USER_ID                                                                  ");
		sql.append("	AND o.ACTIVE_ID = a.ID                                                                      ");
		sql.append("	AND a.BONUS_ID = b.ID                                                                       ");
		sql.append("  and o.SHOP_CODE = s.CODE                                                                    ");
		sql.append("  and s.ORG_ID = so.ID                                                                      ");
		
		User user = page.getUser();
		String condition = orgSv.getOrgCondtion(user, "s.org_id", "s.id",true);
		sql.append(condition);
		
		sql.append(" group by so.NAME,s.NAME,s.code,u.NUMBER ");
		if(!StringUtils.isEmpty(beginDate)){
			sql.append(" and o.pay_time >= STR_TO_DATE(:beginDate,'%Y-%m-%d') ");
			params.put("beginDate", beginDate);
		}
		
		if(!StringUtils.isEmpty(endDate)){
			sql.append(" and o.pay_time <= STR_TO_DATE(:endDate,'%Y-%m-%d') ");
			params.put("endDate", endDate);
		}
		
		
		List<Map<String, Object>> list = sqlRepo.fetchBySql(sql.toString(), params, cond,page);
		return list;
	}
}
