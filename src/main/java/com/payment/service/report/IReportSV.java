package com.payment.service.report;

import java.util.List;
import java.util.Map;

import com.payment.dto.common.Page;

public interface IReportSV {
	/**
	 * 按月统计优惠金额
	 * @param month
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> monthDiscountReport(String month) throws Exception;
	/**
	 * 最近一年优惠金额（月份为维度）
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> curYearDiscountReport(Page page) throws Exception;
	/**
	 * 昨日订单、实收、优惠统计
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> yesterdayReport(Page page) throws Exception;
	/**
	 * 周期优惠统计(去年，今年，当前月)
	 * @param type 1:去年，2:今年，3:当前月
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> discountReport(String type) throws Exception;
	/**
	 * 当前活动统计
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> curActiveReport(Page page) throws Exception;
	/**
	 * 昨日订单、实收、优惠统计
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> beforeYesterdayReport(Page page) throws Exception;
	/**
	 * 业务汇总报表
	 * @param page
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> busCollectReport(Page page,String type) throws Exception;
	/**
	 * 活动汇总报表
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> activeCollectReport(Page page) throws Exception;
	/**
	 * 分润报表
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> cashierShareReport(Page page) throws Exception;
}
