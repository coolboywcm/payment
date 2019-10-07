<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
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
		<style>
		   #type_chzn{
		      margin-top: -10px;
		   }
		</style>
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
<form action="role/${action}" name="dataForm" id="dataForm" method="post">
		<input type="hidden" name="roleId" id="roleId" value="${role.roleId }"/>
		<div id="zhongxin" style="padding: 20px auto 10px auto;width: 100%;margin-top: 15px;">
		<table style="margin-left: 20px;">
			
			<tr>
			    <td style="text-align: right;">角色名称：</td>
				<td>
				   <input type="text" name="roleName" id="roleName" value="${role.roleName}"  maxlength="32" placeholder="角色名称" title="角色名称" need/>
				</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
			    <td style="text-align: right;">角色类型：</td>
				<td>
				   	<select class="chzn-select" name="type" id="type" data-placeholder="请选择角色类型" style="vertical-align:top;"   need>
				   	     <option value=""></option>
						<option value="1" <c:if test="${role.type == '1' }">selected</c:if>>支付运营商</option>
						<option value="2" <c:if test="${role.type == '2' }">selected</c:if>>下级运营商</option>
						<option value="3" <c:if test="${role.type == '3' }">selected</c:if>>商户</option>
						<option value="4" <c:if test="${role.type == '4' }">selected</c:if>>收银员</option>
				     </select>
				</td>
				<td style="text-align: left;">
				   <span id="type1" tip style="display: none;">
				       可看到并操作所有下级运营商、商户、操作员信息
				   </span>
				   <span id="type2" tip style="display: none;">
				       依赖上级支付运营商管理员，除无法设置最上级机构外，其他权限均有
				   </span>
				   <span id="type3" tip style="display: none;">
				       可以查看当前各门店信息（无操作权限）
				   </span>
				   <span id="type4" tip style="display: none;">
				       可看到并操作所有下级运营商、商户、操作员信息
				   </span>
				</td>
			</tr>
		</table>
		<h4 class="header smaller lighter blue" style="width: 750px;margin-left: 20px;margin-top: 3px;margin-bottom: 3px;">可见菜单配置<small></small></h4>
		<table style="margin: 10px;width: 780px;" class="table  table-bordered table-hover">
			<thead>
				<tr>
					<th style="width: 200px;">上级菜单</th>
					<th style="width: 300px;">菜单名称</th>
					<th  style="width: 200px;">是否可见</th>					
				</tr>
			</thead>
			<!-- 开始循环 -->	
				<c:choose>
					<c:when test="${not empty menuList}">
					    
						<c:forEach items="${menuList}" var="menu">
							<c:if test="${menu.subMenuList!= null && fn:length(menu.subMenuList) > 0}">		
									<tr>
										<td class='center' rowspan="${fn:length(menu.subMenuList)}" style="vertical-align: middle;">${menu.menuName}</td>
									<c:forEach items="${menu.subMenuList}" var="subMenu" varStatus="vs">
									   <c:if test="${vs.index > 0}">
									       <tr>
									   </c:if>
									       <td class='center' >${subMenu.menuName}</td>
									       <td>
									          <div class="span3">
													<label><input value="${subMenu.menuId}" name="ckMenu" class="ace-switch ace-switch-3" type="checkbox" 
													  <c:if test="${rightList!= null && fn:length(rightList) > 0}">		
														   <c:forEach items="${rightList}" var="right" >
														     <c:if test="${right.rightId == subMenu.menuId}">		
														      	checked
														      </c:if>	
														    </c:forEach>
													   </c:if>	    
													/><span class="lbl"></span></label>
												</div>
									       </td>
									   </tr>
									</c:forEach>
						   </c:if>
						</c:forEach>


					</c:when>
					<c:otherwise>
						<tr class="main_info">
							<td colspan="10" class="center">没有相关数据</td>
						</tr>
					</c:otherwise>
				</c:choose>
		</table>
		<table style="width: 100%;">
				<tr>
					<td colspan="3" style="text-align: center;">
						<a class="btn btn-small  btn-primary" onclick="save();">保&nbsp;&nbsp;存</a>
						<a class="btn btn-small btn-danger" onclick="top.Dialog.close();">取&nbsp;&nbsp;消</a>
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