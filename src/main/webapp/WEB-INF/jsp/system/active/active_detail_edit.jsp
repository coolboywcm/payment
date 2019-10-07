<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<base href="<%=basePath%>">
		<meta charset="utf-8" />
		<title></title>
		<meta name="description" content="overview & stats" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link href="static/css/bootstrap.min.css" rel="stylesheet" />
		<link href="static/css/bootstrap-responsive.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="static/css/font-awesome.min.css" />
		<!-- 下拉框 -->
		<link rel="stylesheet" href="static/css/chosen.css" />
		<link rel="stylesheet" href="static/css/ace.min.css" />
		<link rel="stylesheet" href="static/css/ace-responsive.min.css" />
		<link rel="stylesheet" href="static/css/ace-skins.min.css" />
		<script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>
		<script type="text/javascript" src="static/js/common/common.js"></script>
		<!--提示框-->
		<script type="text/javascript" src="static/js/jquery.tips.js"></script>
		
<script type="text/javascript">
	$(top.hangge());
	$(document).ready(function(){
		if($("#id").val()!=""){
			$("#code").attr("readonly","readonly");
			$("#code").css("color","gray");
			$("#orgId").attr("readonly","readonly");
			$("#orgId").css("color","gray");
		}
	});
	
	//保存
	function save(){
		if(!commonFun.validForm("#dataForm")){
			return false;
		}
		$("#dataForm").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();

	}
	
	
	
	
</script>
	</head>
<body>
<form action="activeDetail/${action}" name="dataForm" id="dataForm" method="post">
		<input type="hidden" name="id" id="id" value="${bean.id }"/>
		<input type="hidden" name="activeId" id="activeId" value="${pd.activeId }"/>
		<div id="zhongxin" style="padding: 20px auto 10px auto;width: 100%;margin-top: 15px;">
		<table style="margin-left: 20px;">
			

			<tr>
			   <td style="text-align: right;padding-top: 10px;">明细标题：</td>
				<td style="padding-top: 10px;">
				       <input type="text" name="title" id="title" value="${bean.title}" maxlength="126" placeholder=""  need />
				       <span class="red">*</span>
				</td>
			</tr>
		<c:if test="${pd.activeType == 'dehd'}">	
			<tr>
			  <td style="text-align: right;padding-top: 10px;">活动原价：</td>
			  <td style="padding-top: 10px;">
					<span class="input-icon">
					   <input type="text" dataType="dec"   name="hdyj" id="hdyj"  value="${bean.hdyj}"  style="width: 190px;" need >
					   <i class="icon-cash">￥</i>
				   </span>
				   <span class="red">*</span>
				</td>  
			</tr>
			<tr>
			  <td style="text-align: right;padding-top: 10px;">优惠金额：</td>
			  <td style="padding-top: 10px;">
					<span class="input-icon">
					   <input type="text" dataType="dec"   name="yhje" id="yhje"  value="${bean.yhje}"  style="width: 190px;" need >
					   <i class="icon-cash">￥</i>
				   </span>
				   <span class="red">*</span>
				</td>  
			</tr>
            <tr>
				<td style="text-align: right;padding-top: 10px;">单次消费最大购买份数：</td>
				<td style="padding-top: 10px;">
					<input type="text" dataType="num" name="dcxfzdgmfs" id="dcxfzdgmfs"  value="${bean.dcxfzdgmfs}"   maxlength="5" placeholder="" need />
					<span class="red">*</span>
				</td>
			</tr>
		</c:if>	
		<c:if test="${pd.activeType == 'zkyh'}">	
			<tr>
			  <td style="text-align: right;padding-top: 10px;">优惠起点金额：</td>
			  <td style="padding-top: 10px;">
					<span class="input-icon">
					   <input type="text" dataType="dec"   name="yhqdje" id="yhqdje"  value="${bean.yhqdje}"  style="width: 190px;" need >
					   <i class="icon-cash">￥</i>
				   </span>
				   <span class="red">*</span>
				</td>  
			</tr>
			<tr>
			  <td style="text-align: right;padding-top: 10px;">优惠封顶金额：</td>
			  <td style="padding-top: 10px;">
					<span class="input-icon">
					   <input type="text" dataType="dec"   name="yhfdje" id="yhfdje"  value="${bean.yhfdje}"  style="width: 190px;" need >
					   <i class="icon-cash">￥</i>
				   </span>
				   <span class="red">*</span>
				</td>  
			</tr>
            <tr>
				<td style="text-align: right;padding-top: 10px;">优惠折扣：</td>
				<td style="padding-top: 10px;">
					<input type="text" dataType="dec" name="yhzk" id="yhzk"  value="${bean.yhzk}" placeholder="[优惠折扣] 列如：8.5折输入8.5"  maxlength="32" placeholder="" need />
					<span class="red">*</span>
				</td>
			</tr>
		</c:if>	
		<c:if test="${pd.activeType == 'sjyh'}">	
			<tr>
			  <td style="text-align: right;padding-top: 10px;">达标金额：</td>
			  <td style="padding-top: 10px;">
					<span class="input-icon">
					   <input type="text" dataType="dec"   name="dbje" id="dbje"  value="${bean.dbje}"  style="width: 190px;" need >
					   <i class="icon-cash">￥</i>
				   </span>
				   <span class="red">*</span>
				</td>  
			</tr>
			<tr>
			  <td style="text-align: right;padding-top: 10px;">随机优惠最低值：</td>
			  <td style="padding-top: 10px;">
					<span class="input-icon">
					   <input type="text" dataType="dec"   name="sjyhzxz" id="sjyhzxz"  value="${bean.sjyhzxz}"  style="width: 190px;" need >
					   <i class="icon-cash">￥</i>
				   </span>
				   <span class="red">*</span>
				</td>  
			</tr>
            <tr>
				<td style="text-align: right;padding-top: 10px;">随机优惠最大值：</td>
				<td style="padding-top: 10px;">
					<span class="input-icon">
						<input type="text" dataType="dec" name="sjyhzddz" id="sjyhzddz"  value="${bean.sjyhzddz}" style="width: 190px;"  placeholder="" need />
						<i class="icon-cash">￥</i>
					</span>
					<span class="red">*</span>
				</td>
			</tr>
		</c:if>
		<c:if test="${pd.activeType == 'ljyh'}">	
			<tr>
			  <td style="text-align: right;padding-top: 10px;">达标金额：</td>
			  <td style="padding-top: 10px;">
					<span class="input-icon">
					   <input type="text" dataType="dec"   name="dbje" id="dbje"  value="${bean.dbje}"  style="width: 190px;" need >
					   <i class="icon-cash">￥</i>
				   </span>
				   <span class="red">*</span>
				</td>  
			</tr>
			<tr>
			  <td style="text-align: right;padding-top: 10px;">立减金额：</td>
			  <td style="padding-top: 10px;">
					<span class="input-icon">
					   <input type="text" dataType="dec"   name="ljje" id="ljje"  value="${bean.ljje}"  style="width: 190px;" need >
					   <i class="icon-cash">￥</i>
				   </span>
				   <span class="red">*</span>
				</td>  
			</tr>
            <tr>
				<td style="text-align: right;padding-top: 10px;">单次消费最大购买数：</td>
				<td style="padding-top: 10px;">
					<input type="text" dataType="num" name="dcxfzdgms" id="dcxfzdgms"  value="${bean.dcxfzdgms}" placeholder="" need />
					<span class="red">*</span>
				</td>
			</tr>
		</c:if>
			<tr>
				<td style="text-align: right;padding-top: 10px;">描述：</td>
				<td style="padding-top: 10px;">
				    <input type="text" name="detailDesc" id="detailDesc"  value="${bean.detailDesc }"  maxlength="128" need/>
				    <span class="red">*</span>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;">
					<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
					<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a>
				</td>
			</tr>
		</table>
		</div>
		
		<div id="zhongxin2" class="center" style="display:none"><br/><br/><br/><br/><img src="static/images/jiazai.gif" /><br/><h4 class="lighter block green"></h4></div>
		
	</form>
	
		<!-- 引入 -->
		<script type="text/javascript">window.jQuery || document.write("<script src='static/js/jquery-1.9.1.min.js'>\x3C/script>");</script>
		<script src="static/js/bootstrap.min.js"></script>
		<script src="static/js/ace-elements.min.js"></script>
		<script src="static/js/ace.min.js"></script>
		<script type="text/javascript" src="static/js/chosen.jquery.min.js"></script><!-- 下拉框 -->
		
		<script type="text/javascript">
		
		$(function() {
			
			//单选框
			$(".chzn-select").chosen(); 
			$(".chzn-select-deselect").chosen({allow_single_deselect:true}); 
			
			//日期框
			//$('.date-picker').datepicker({autoclose : true,todayHighlight : true});
			
		});
		
		</script>
	
</body>
</html>