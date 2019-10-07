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
		if($("#id").val()!=""){
			$("#code").attr("readonly","readonly");
			$("#code").css("color","gray");
			$("#orgId").attr("readonly","readonly");
			$("#orgId").css("color","gray");
		}
	});
	
	//保存
	function save(){
		if($("#name").val()=="" || $("#name").val()=="此商户名已存在!"){
			
			$("#name").tips({
				side:3,
	            msg:'输入商户名',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#name").focus();
			$("#name").val('');
			$("#name").css("background-color","white");
			return false;
		}else{
			$("#name").val(jQuery.trim($('#name').val()));
		}
		
		if($("#code").val()==""){
			
			$("#code").tips({
				side:3,
	            msg:'输入编号',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#code").focus();
			return false;
		}else{
			$("#code").val($.trim($("#code").val()));
		}
		
		
		if($("#name").val()==""){
			
			$("#name").tips({
				side:3,
	            msg:'输入商户名称',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#name").focus();
			return false;
		}
		
		var myreg = /^(((13[0-9]{1})|159)+\d{8})$/;
		if($("#contactNum").val()==""){
			
			$("#contactNum").tips({
				side:3,
	            msg:'输入手机号',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#contactNum").focus();
			return false;
		}/* else if($("#contactNum").val().length != 11 && !myreg.test($("#contactNum").val())){
			$("#contactNum").tips({
				side:3,
	            msg:'手机号格式不正确',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#contactNum").focus();
			return false;
		} */
		
		if($("#email").val()==""){
			
			/* $("#email").tips({
				side:3,
	            msg:'输入邮箱',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#email").focus();
			return false; */
		}else if(!ismail($("#email").val())){
			$("#email").tips({
				side:3,
	            msg:'邮箱格式不正确',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#email").focus();
			return false;
		}
		
		$("#dataForm").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();

	}
	
	function ismail(mail){
		return(new RegExp(/^(?:[a-zA-Z0-9]+[_\-\+\.]?)*[a-zA-Z0-9]+@(?:([a-zA-Z0-9]+[_\-]?)*[a-zA-Z0-9]+\.)+([a-zA-Z]{2,})+$/).test(mail));
		}
	
	//判断商户名是否存在
	function hasU(){
		var USERNAME = $.trim($("#name").val());
		$.ajax({
			type: "POST",
			url: '<%=basePath%>user/hasU',
	    	data: {userName:USERNAME,tm:new Date().getTime()},
			dataType:'json',
			cache: false,
			success: function(data){
				 if("success" == data.result){
					$("#dataForm").submit();
					$("#zhongxin").hide();
					$("#zhongxin2").show();
				 }else{
					$("#name").css("background-color","#D16E6C");
					setTimeout("$('#name').val('此商户名已存在!')",500);
				 }
			}
		});
	}
	
	//判断邮箱是否存在
	function hasE(USERNAME){
		var email = $.trim($("#email").val());
		$.ajax({
			type: "POST",
			url: '<%=basePath%>user/hasE',
	    	data: {email:email,USERNAME:USERNAME,tm:new Date().getTime()},
			dataType:'json',
			cache: false,
			success: function(data){
				 if("success" != data.result){
					 $("#email").tips({
							side:3,
				            msg:'邮箱已存在',
				            bg:'#AE81FF',
				            time:3
				        });
					setTimeout("$('#email').val('')",2000);
				 }
			}
		});
	}
	
	//判断编码是否存在
	function hasN(USERNAME){
		var code = $.trim($("#code").val());
		$.ajax({
			type: "POST",
			url: '<%=basePath%>user/hasN',
	    	data: {number:code,USERNAME:USERNAME,tm:new Date().getTime()},
			dataType:'json',
			cache: false,
			success: function(data){
				 if("success" != data.result){
					 $("#code").tips({
							side:3,
				            msg:'编号已存在',
				            bg:'#AE81FF',
				            time:3
				        });
					setTimeout("$('#code').val('')",2000);
				 }
			}
		});
	}
	
</script>
	</head>
<body>
<form action="shop/${action}" name="dataForm" id="dataForm" method="post">
		<input type="hidden" name="id" id="id" value="${shop.id }"/>
		<div id="zhongxin" style="padding: 20px auto 10px auto;width: 100%;margin-top: 15px;">
		<table style="margin-left: 20px;">
			
			<tr>
			    <td style="text-align: right;">归属机构：</td>
				<td>
				   	<select class="chzn-select" name="orgId" id="role_id" data-placeholder="请选择机构" style="vertical-align:top;"  title="类型">
								<option value=""></option>
								<c:forEach items="${orgList}" var="org">
									<option value="${org.id }" <c:if test="${shop.orgId == org.id }">selected</c:if>>${org.name }</option>
								</c:forEach>
				     </select>
				</td>
			</tr>
			<tr>
			   <td style="text-align: right;padding-top: 10px;">商户编号：</td>
				<td style="padding-top: 10px;"><input type="text" name="code" id="code" value="${shop.code }" maxlength="32" placeholder="这里输入编号" title="编号" onblur="hasN('${shop.code }')"/></td>
			</tr>
			<tr>
			<td style="text-align: right;">商户名称：</td>
				<td><input type="text" name="name" id="name" value="${shop.name}"  maxlength="32" placeholder="商户名称" title="商户名称"/></td>
			</tr>
			<tr>
			<td style="text-align: right;">商户简称：</td>
				<td><input type="text" name="shortName" id="shortName" value="${shop.shortName}"   maxlength="32" placeholder="商户简称" title="商户简称" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">商户类型：</td>
				<td>
				   	<select class="chzn-select" name="type" id="type" data-placeholder="请选择商户类型" style="vertical-align:top;"  title="类型">
						    <option value="">请选择商户类型</option>
							<option value="1" <c:if test="${shop.type == '1' }">selected</c:if>>餐饮类</option>
							<option value="2" <c:if test="${shop.type == '2' }">selected</c:if>>电影娱乐</option>
							<option value="3" <c:if test="${shop.type == '3' }">selected</c:if>>大型商超</option>
							<option value="4" <c:if test="${shop.type == '4' }">selected</c:if>>小型商超</option>
				     </select>
				</td>
			</tr>
			<tr>
			<td style="text-align: right;padding-top: 10px;">详细地址：</td>
				<td style="text-align: right;padding-top: 10px;"><input type="text" name="address" id="address"  value="${shop.address }"  maxlength="32" placeholder="这里输入详细地址" title="详细地址"/></td>
			</tr>
			<tr>
			<td style="text-align: right;">联系人：</td>
				<td><input type="text" name="contactName" id="contactName"  value="${shop.contactName }"  maxlength="32" placeholder="这里输入联系人号" title="联系人"/></td>
			</tr>
			<tr>
			<td style="text-align: right;">联系电话：</td>
				<td><input type="tel" name="contactNum" id="contactNum"  value="${shop.contactNum }" maxlength="32" placeholder="这里输入联系电话" title="联系电话" onblur="hasE('${org.USERNAME }')"/></td>
			</tr>
			<tr>
			<td style="text-align: right;">EMAIL：</td>
				<td><input type="text" name="email" id="email"value="${shop.email }" placeholder="这里输入邮箱" maxlength="64" title="邮箱"/></td>
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