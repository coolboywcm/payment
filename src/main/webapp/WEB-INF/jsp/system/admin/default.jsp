<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">

<!-- jsp文件头和头部 -->
<%@ include file="top.jsp"%>
<style type="text/css">
.progress-bar {
    background-color: #1ab394;
}
.ibox.ui-sortable-placeholder
{
	margin:0 0 23px!important;
}
.ibox-content.text-box
{
	padding-bottom:0;
	padding-top:15px;
}
.ibox
{
	clear:both;
	margin-bottom:25px;
	margin-top:0;
	padding:0;
}

.ibox.collapsed .fa.fa-chevron-up:before
{
	content:"\f078";
}

.ibox.collapsed .fa.fa-chevron-down:before
{
	content:"\f077";
}

.ibox:after,.ibox:before
{
	display:table;
}

.ibox-title
{
	-moz-border-bottom-colors:none;
	-moz-border-left-colors:none;
	-moz-border-right-colors:none;
	-moz-border-top-colors:none;
	background-color:#fff;
	-webkit-border-image:none;
	-o-border-image:none;
	border-image:none;
	color:inherit;
	margin-bottom:0;
	min-height:48px;
	padding:14px 15px 7px;
}

.ibox-content
{
	background-color:#fff;
	color:inherit;
	-webkit-border-image:none;
	-o-border-image:none;
	border-image:none;
	clear:both;
	border-color:#e7eaec;
	border-style:solid solid none;
	border-width:1px 0;
	padding:15px 20px 12px;
}
</style>
</head>
<body >

	<div class="container-fluid" id="main-container">
		

			<div id="page-content" class="clearfix">

				<div class="page-header position-relative">
					<h1>
						首页 <small><i class="icon-double-angle-right"></i> </small>
					</h1>
				</div>
				<!--/page-header-->

				<div class="row-fluid" style="background-color: #f3f3f4;padding: 10px;">
				 <div class="span12">  
					<div class="span3" style="background-color: #f3f3f4;">
						<div class="widget-box">
							<div class="widget-header">
								<h5 class="smaller">昨日订单金额</h5>
								<div class="widget-toolbar">
								    <c:if test="${yesterdayRate.amountTotalRate < 0}">
								    	<span class="label label-important">${yesterdayRate.amountTotalRate}% <i class="icon-arrow-down"></i></span>
									</c:if>
									<c:if test="${yesterdayRate.amountTotalRate > 0}">
								    	<span class="label label-success">${yesterdayRate.amountTotalRate}%<i class="icon-arrow-up"></i></span>
									</c:if>
									<c:if test="${yesterdayRate.amountTotalRate == 0}">
								    	<span class="label label-success">${yesterdayRate.amountTotalRate}%</span>
									</c:if>
								</div>
							</div>
							<div class="widget-body">
							 <div class="widget-main padding-5">
								<div class="alert alert-info">
									<h1>¥ <fmt:formatNumber type="number" value="${yesterdayData.amountTotal/100}" pattern="0.00" maxFractionDigits="2"/></h1>
								</div>
							 </div>
							</div>
						</div>
					</div>
					<div class="span3">
						<div class="widget-box">
							<div class="widget-header">
								<h5 class="smaller">昨日订单量</h5>
								<div class="widget-toolbar">
									    <c:if test="${yesterdayRate.orderCountRate < 0}">
									    	<span class="label label-important">${yesterdayRate.orderCountRate}% <i class="icon-arrow-down"></i></span>
										</c:if>
										<c:if test="${yesterdayRate.orderCountRate > 0}">
									    	<span class="label label-success">${yesterdayRate.orderCountRate}%<i class="icon-arrow-up"></i></span>
										</c:if>
										<c:if test="${yesterdayRate.orderCountRate == 0}">
									    	<span class="label label-success">${yesterdayRate.orderCountRate}%</span>
										</c:if>
								</div>
							</div>
							<div class="widget-body">
							 <div class="widget-main padding-5">
								<div class="alert alert-info">
									<h1>${yesterdayData.orderCount }</h1>
								</div>
							 </div>
							</div>
						</div>
					</div>
					<div class="span3">
						<div class="widget-box">
							<div class="widget-header">
								<h5 class="smaller">昨日实收金额</h5>
								<div class="widget-toolbar">
									<c:if test="${yesterdayRate.realAmountTotalRate < 0}">
								    	<span class="label label-important">${yesterdayRate.realAmountTotalRate}% <i class="icon-arrow-down"></i></span>
									</c:if>
									<c:if test="${yesterdayRate.realAmountTotalRate > 0}">
								    	<span class="label label-success">${yesterdayRate.realAmountTotalRate}%<i class="icon-arrow-up"></i></span>
									</c:if>
									<c:if test="${yesterdayRate.realAmountTotalRate == 0}">
								    	<span class="label label-success">${yesterdayRate.realAmountTotalRate}%</span>
									</c:if>
								</div>
							</div>
							<div class="widget-body">
							 <div class="widget-main padding-5">
								<div class="alert alert-info">
									<h1>¥ <fmt:formatNumber type="number" value="${yesterdayData.realAmountTotal/100}" pattern="0.00" maxFractionDigits="2"/></h1>
								</div>
							 </div>
							</div>
						</div>
					</div>
					<div class="span3">
						<div class="widget-box">
							<div class="widget-header">
								<h5 class="smaller">昨日优惠金额</h5>
								<div class="widget-toolbar">
									<c:if test="${yesterdayRate.discountAmountTotalRate < 0}">
								    	<span class="label label-important">${yesterdayRate.discountAmountTotalRate}% <i class="icon-arrow-down"></i></span>
									</c:if>
									<c:if test="${yesterdayRate.discountAmountTotalRate > 0}">
								    	<span class="label label-success">${yesterdayRate.discountAmountTotalRate}%<i class="icon-arrow-up"></i></span>
									</c:if>
									<c:if test="${yesterdayRate.discountAmountTotalRate == 0}">
								    	<span class="label label-success">${yesterdayRate.discountAmountTotalRate}%</span>
									</c:if>								
								</div>
							</div>
							<div class="widget-body">
							 <div class="widget-main padding-5">
								<div class="alert alert-info">
									<h1>¥ <fmt:formatNumber type="number" value="${yesterdayData.discountAmountTotal/100}" pattern="0.00" maxFractionDigits="2"/></h1>
								</div>
							 </div>
							</div>
						</div>
					</div>
				</div>
				 <div class="span12" style="margin-left: 0px;margin-top: 15px;">  
				    <div class="span8" style="background-color: white;">
				        <div class="span12">
				        	<div class="span9"  id="chart1" style="height:400px;margin: 10px;"></div>
				        	<div class="span3" style="margin-top: 50px;margin-left: 0px;">
				        			<ul class="stat-list m-t-lg" style="list-style-type: none;padding-left: 20px;margin-left: 0px;">
										<li>
											<h2 class="no-margins"><font id="lastYearTotalPromotionAmt">¥&nbsp;<fmt:formatNumber type="number" value="${discount_1/100}" pattern="0.00" maxFractionDigits="2"/></font></h2> <small>去年优惠总金额</small>
											<div class="progress progress-mini">
                                                     <div class="progress-bar" style="width: 100%;"></div>
                                            </div>
										</li>
										<li>
											<h2 class="no-margins"><font id="currentYearTotalPromotionAmt">¥&nbsp;<fmt:formatNumber type="number" value="${discount_2/100}" pattern="0.00" maxFractionDigits="2"/></font></h2> <small>今年优惠总金额</small>
											<div class="progress progress-mini">
                                                     <div class="progress-bar" style="width: 100%;"></div>
                                            </div>
										</li>
										<li>
											<h2 class="no-margins"><font id="currentMonTotalPromotionAmt">¥&nbsp;<fmt:formatNumber type="number" value="${discount_3/100}" pattern="0.00" maxFractionDigits="2"/></font></h2> <small>当前月优惠总金额</small>
											<div class="progress progress-mini">
                                                     <div class="progress-bar" style="width: 100%;"></div>
                                            </div>
										</li>
									</ul>
				        	</div>
				        </div>
				    </div>
				    <div class="span4" style="">
						  <div class="ibox float-e-margins" style="height: 420px;margin-bottom: 0px;">
							<div class="ibox-title">
								<span class="label label-info pull-right">昨日</span>
								<h5>当前活动</h5>
							</div>
							<c:forEach var="item" items="${curActiveData}" varStatus="vStatus">
								<div class="ibox-content">
									<div class="row-fluid">
										<div class="span4">
											<small class="stats-label">${item.typeName } / 活动数</small>
											<h4><font id="customOfferNum">${item.activeCount } </font></h4>
										</div>
			
										<div class="span4">
											<small class="stats-label">参与商户</small>
											<h4><font id="customOfferMerchantNum">${item.shopCount } </font></h4>
										</div>
										<div class="span4">
											<small class="stats-label">优惠笔数</small>
											<h4><font id="customOfferOrderNum">${item.discountCount }</font></h4>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
				    </div>
				 </div>	
				<!--/row-->
                <div class="span12" style="margin-left: 0px;margin-top: 15px;"> 
					<div class="widget-box">
						<div class="widget-header">
							<h5>活动列表</h5>
							<div class="widget-toolbar">
								<a href="#" data-action="reload"><i class="icon-refresh"></i></a>
								<a href="#" data-action="collapse"><i class="icon-chevron-up"></i></a>
							</div>
						</div>
						
						<div class="widget-body">
						 <div class="widget-main">
							<iframe style="width: 100%;border: none;height: 300px;" src="active/mainListActives?type=all"></iframe>
						 </div>
						</div>
					</div>
			</div>









		</div>
		<!-- #main-content -->
	</div>
	<!--/.fluid-container#main-container-->
	<a href="#" id="btn-scroll-up" class="btn btn-small btn-inverse"> <i
		class="icon-double-angle-up icon-only"></i>
	</a>
	<!-- basic scripts -->
	<script src="static/1.9.1/jquery.min.js"></script>
	<script type="text/javascript">
		window.jQuery
				|| document
						.write("<script src='static/js/jquery-1.9.1.min.js'>\x3C/script>");
	</script>

	<script src="static/js/bootstrap.min.js"></script>
	<!-- page specific plugin scripts -->

	<!--[if lt IE 9]>
		<script type="text/javascript" src="static/js/excanvas.min.js"></script>
		<![endif]-->
	<script type="text/javascript" src="static/js/jquery-ui-1.10.2.custom.min.js"></script>
	<script type="text/javascript" src="static/js/jquery.ui.touch-punch.min.js"></script>
	<script type="text/javascript" src="static/js/jquery.slimscroll.min.js"></script>
	<script type="text/javascript" src="static/js/jquery.easy-pie-chart.min.js"></script>
	<script type="text/javascript" src="static/js/jquery.sparkline.min.js"></script>
	<script type="text/javascript" src="static/js/jquery.flot.min.js"></script>
	<script type="text/javascript" src="static/js/jquery.flot.pie.min.js"></script>
	<script type="text/javascript" src="static/js/jquery.flot.resize.min.js"></script>
	<!-- ace scripts -->
	<script src="static/js/ace-elements.min.js"></script>
	<script src="static/js/ace.min.js"></script>
	<!-- inline scripts related to this page -->


	<script type="text/javascript">

		$(top.hangge());
	    var ym = '${ym}';
		
		$(function() {
		   var url = "<%=basePath%>main/getCurYearDiscountData?tm="+new Date().getTime();
		   var myChart = echarts.init(document.getElementById('chart1'));
		   $.get(url,function(data){
					console.log(data);
					if(data && data.data){
					   var xAxisData = data.xAxis;
					   var lineData = new Array();
					   for(var i = 0;i<data.data.length;i++){
					      lineData.push(data.data[i].amountTotal);
					   }
					}
					
					option = {
						title : {
							text : '最近一年优惠金额',
						},
						tooltip : {
							trigger : 'axis'
						},
						legend : {
							data : [ '优惠金额',  ]
						},
						toolbox : {
							show : false,
							feature : {
								mark : {
									show : true
								},
								dataView : {
									show : true,
									readOnly : false
								},
								magicType : {
									show : true,
									type : [ 'line', 'bar' ]
								},
								restore : {
									show : true
								},
								saveAsImage : {
									show : true
								}
							}
						},
						calculable : true,
						xAxis : [ {
						    axisLabel: {
				        	  interval:0,
				        	  formatter:function(value)  
				        	    {  
				        	        return value.split("-")[0].substr(2,2)+"年"+("\n")+value.split("-")[1]+"月";  
				        	 },
				        	},   
							type : 'category',
							boundaryGap : false,
							data :xAxisData
						} ],
						yAxis : [ {
							type : 'value',
							axisLabel : {
								formatter : '{value}'
							}
						} ],
						series : [ {
							name : '优惠金额',
							type : 'line',
							data : lineData,
							markPoint : {
								data : [ {
									type : 'max',
									name : '最大值'
								}, {
									type : 'min',
									name : '最小值'
								} ]
							},
							markLine : {
								data : [ {
									type : 'average',
									name : '平均值'
								} ]
							}
						} ]
					};
					myChart.setOption(option);
			});
			
		})
	</script>
</body>
</html>
