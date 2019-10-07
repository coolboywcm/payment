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
		<!--提示框-->
		<script type="text/javascript" src="static/js/jquery.tips.js"></script>
		
<script type="text/javascript">
	$(top.hangge());
	$(document).ready(function(){
		
	});
	function hasN(){
	
	}
	//保存
	function save(){
		
		if($("#shopId").val()==""){
			$("#shopId").tips({
				side:3,
	            msg:'请选择归属商户',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#shopId").focus();
			return false;
		}

		
		if($("#name").val()==""){
			$("#name").tips({
				side:3,
	            msg:'输入编号',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#name").focus();
			return false;
		}else{
			$("#name").val($.trim($("#name").val()));
		}
		
		
		
		$("#dataForm").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();

	}
	
	
</script>
	</head>
<body>
<form action="cashier/${action}" name="dataForm" id="dataForm" method="post">
		<input type="hidden"  name="userId" id="userId"  value="${bean.userId }"/>
		<div id="zhongxin" style="padding: 20px auto 10px auto;width: 100%;margin-top: 15px;">
		<table style="margin-left: 10px;height: 180px;">
			<tr>
			    <td style="text-align: right;padding-top: 10px;">归属商户：</td>
				<td style="padding-top: 10px;">
				   	<select class="chzn-select" name="shopId" id="shopId" data-placeholder="请选择归属商户" style="vertical-align:top;"  title="类型">
								<option value=""></option>
								<c:forEach items="${shopList}" var="shop">
									<option value="${shop.id }" <c:if test="${bean.shopId == shop.id }">selected</c:if>>${shop.name }</option>
								</c:forEach>
				     </select>
				</td>
			</tr>
			<tr>
			   <td style="text-align: right;padding-top: 20px;">收银员编号：</td>
				<td style="padding-top: 20px;"><input type="text" name="name" id="name" value="${bean.name }" maxlength="32" placeholder="这里输入编号" title="编号" /></td>
			</tr>
			<tr>
			   <td style="text-align: right;padding-top: 10px;">登陆密码：</td>
				<td style="padding-top: 10px;"><input type="text" name="password" id="password"  maxlength="32" placeholder="输入密码" title="密码"/></td>
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