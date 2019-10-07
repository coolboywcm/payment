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
		<script type="text/javascript" src="static/js/common/common.js"></script>
<script type="text/javascript">
	$(top.hangge());
	$(document).ready(function(){
		if($("#id").val()!=""){
			$("#orgId").attr("readonly","readonly");
			$("#orgId").css("color","gray");
		}
	});
	function validForm(formObj){
	  var objList = $('[need]',formObj);
	  if(!objList || !objList.length){
	     return true;
	  }
	  for(var i = 0;i<objList.length;i++){
	    var obj = $(objList[i]);
	    var validTip = obj.attr('validTip');
	    if(obj.val() == ""){
	       showTip(obj,validTip);
	       return false;
	    }
	  }
	  return true;
	}
	function showTip(obj,tip,bTrim){
	   obj.tips({
			side : 3,
			msg : tip ? tip :'必填',
			bg : '#AE81FF',
			time : 2
		});
		obj.focus();
		obj.css("background-color", "white");
	}
	//保存
	function save(){
		if(!validForm($("#dataForm"))){
		   return false;
		}
		$("#dataForm").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();

	}


	
</script>
	</head>
<body>
<form action="bonus/${action}" name="dataForm" id="dataForm" method="post">
		<input type="hidden" name="id" id="id" value="${bonus.id }"/>
		<div id="zhongxin" style="padding: 20px auto 10px auto;width: 100%;margin-top: 15px;">
		<table style="margin-left: 20px;">
			
			<tr>
			    <td style="text-align: right;">归属机构：</td>
				<td>
				   	<select class="chzn-select" name="orgId" id="orgId" data-placeholder="请选择机构" style="vertical-align:top;"  title="机构" need>
								<option value=""></option>
								<c:forEach items="${orgList}" var="org">
									<option value="${org.id }" <c:if test="${bonus.orgId == org.id }">selected</c:if>>${org.name }</option>
								</c:forEach>
				     </select>
				</td>
			</tr>
			<tr>
			    <td style="text-align: right;padding-top: 30px;">奖金池名称：</td>
				<td style="padding-top: 30px;">
				   <input type="text" name="name" id="name" value="${bonus.name}"  maxlength="32" placeholder="奖金池名称" title="奖金池名称" need/>
				</td>
			</tr>
			<tr>
				<td style="text-align: right;padding-top: 20px;">奖金池总额：</td>
				<td style="padding-top: 20px;">
					<span class="input-icon">
						   <input type="text" dataType="num" maxlength="10" name="total" id="total" style="width: 190px;" value="${bonus.total }"  placeholder="奖金池总额" need>
						   <i class="icon-cash">￥</i>
					 </span>	
				 </td>
			</tr>	
			<tr>
				<td style="text-align: right;padding-top: 20px;">商户分润占比：</td>
				<td style="padding-top: 20px;">
					<span class="input-icon">
						   <input type="text" dataType="dec" maxlength="5" name="shareRatio" id="shareRatio" style="width: 190px;"  value="${bonus.shareRatio }"  placeholder="商户分润占比" need>
						   <i class="icon-cash">%</i>
					 </span>	
				 </td>
			</tr>	
			<tr>
				<td style="text-align: right;padding-top: 20px;">收银员分润占比：</td>
				<td style="padding-top: 20px;">
					<span class="input-icon">
						   <input type="text" dataType="dec" maxlength="5"  id="shareRatio2" readonly="readonly" style="width: 190px;" value=""  placeholder="收银员分润占比" need>
						   <i class="icon-cash">%</i>
					 </span>	
				 </td>
			</tr>					   
			<tr>
			<td style="text-align: right;padding-top: 20px;">详细描述：</td>
				<td style="text-align: right;padding-top: 20px;">
				   <input type="text" name="detailDesc" id="detailDesc" value="${bonus.detailDesc}"  maxlength="100" placeholder="这里输入详细信息" title="详细信息"/>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;padding-top: 20px;">
					<a class="btn btn-mini btn-primary" onclick="save();">&nbsp;保&nbsp;&nbsp;存&nbsp;</a>
					<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">&nbsp;取&nbsp;&nbsp;消&nbsp;</a>
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
		function changeShareRatio(){
			var f = parseFloat($("#shareRatio").val());
			if(f > 100){
				commonFun.showTip($("#shareRatio"),'占比不能大于100');
				$("#shareRatio").focus();
				return false;
			}
			$("#shareRatio2").val(100 - parseFloat($("#shareRatio").val()));
			$("#shareRatio2").val(toDecimal2($("#shareRatio2").val()));
		}
		$(function() {
			
			//单选框
			$(".chzn-select").chosen(); 
			$(".chzn-select-deselect").chosen({allow_single_deselect:true}); 
			
			//日期框
			//$('.date-picker').datepicker({autoclose : true,todayHighlight : true});
			$("#shareRatio").change(function(){
				changeShareRatio();
			});
			$("#shareRatio").bind('change blur', function(){
				changeShareRatio();
			});
			if('${action}'=='modBonus'){
				$("#shareRatio").trigger('change');
			}
		});
		
		</script>
	
</body>
</html>