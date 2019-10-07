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
<%@ include file="../admin/top.jsp"%>

<link rel="stylesheet" href="plugins/zTree/3.5/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="plugins/zTree/3.5/jquery.ztree.core-3.5.js"></script>
<!--提示框-->
<script type="text/javascript" src="static/js/jquery.tips.js"></script>
<script type="text/javascript" src="static/js/bootbox.min.js"></script><!-- 确认窗口 -->
</head>	
<body>
	<div class="container-fluid" id="page-content">
	<form class="form-horizontal" action="org/${action}?parentId=${pd.parentId}&type=${pd.type}" name="dataForm" id="dataForm" method="post">
	    <input type="hidden" name = "id" value ="${org.id }" />
		<div class="control-group">
			<label class="control-label" for="form-field-1">上级机构</label>
			<div class="controls">
				<input type="text" id="parentOrgName" value="${parent.name}" readonly="readonly">
			</div>
		</div>
		<div class="control-group">	
			<label class="control-label" for="form-field-1">机构名称</label>
			<div class="controls">
				<input type="text" id="name" name="name" maxlength="32" placeholder="机构名称" value="${org.name }">
			</div>
		</div>	
		<div class="control-group">	
			<label class="control-label" for="form-field-1">机构简称</label>
			<div class="controls">
				<input type="text" id="shortName" name="shortName" maxlength="32" placeholder="机构简称"  value="${org.shortName }">
			</div>
		</div>
		<c:if test="${QX.edit == 1 ||  QX.del == 1}">
		    <c:if test="${pd.id != null || type=='add'}">
				<div class="form-actions">
				    <c:if test="${type == 'edit'}">
				    	<a onclick="add();" class="btn btn-success">增加下级机构 <i class="icon-arrow-right icon-on-right"></i></a>
				    </c:if>
				    &nbsp; &nbsp; &nbsp;
					<a class="btn btn-info"  onclick="save();"><i class="icon-ok"></i> 保&nbsp;&nbsp;存</a>
					 &nbsp; &nbsp; &nbsp;
					<a class="btn" onclick="reset();"><i class="icon-undo"></i> 重&nbsp;&nbsp;置</a>
					<c:if test="${pd.id != '0'}">
						&nbsp; &nbsp; &nbsp;
						<a class="btn btn-danger" onclick="del();"><i class="icon-trash"></i> 删&nbsp;&nbsp;除</a>
					</c:if>
				</div>
			</c:if>
		</c:if>
	 </form>
	</div>
	<!--/.fluid-container#main-container-->

	<script src="static/js/bootstrap.min.js"></script>
	<script src="static/js/ace-elements.min.js"></script>
	<!-- 引入 -->
	<script type="text/javascript">
		$(function() {
			<c:if test="${msg != null}">
			bootbox.dialog("${msg}",  
									[{
										"label" : "关闭",
										"class" : "btn btn-primary",
										"callback": function() {
										       <c:if test="${code == '0'}">
													parent.location.href = "<%=basePath%>org/index?curId=${org.id }";  
											   </c:if>
											}
									  }]
								);
			</c:if>					
		});
		function del(){
		   bootbox.confirm("确定要删除机构[${org.name }]吗?", function(result) {
				if(result) {
					submitDel();
				}
			});
		}
		function submitDel(){
		   $("#dataForm").attr("action","<%=basePath%>org/delOrg");
		   $("#dataForm").submit();
		}
		function add(){
		   window.location.href ="<%=basePath%>org/edit?parentId=${org.id}&type=add";
		}
		function reset(){
		   $("#name").val("");
		   $("#shortName").val("");
		}
		//保存
		function save() {

			if ($("#name").val() == "") {
				$("#name").tips({
					side : 3,
					msg : '输入机构名称',
					bg : '#AE81FF',
					time : 3
				});
				$("#name").focus();
				return false;
			}

			if ($("#shortName").val() == "") {
				$("#shortName").tips({
					side : 3,
					msg : '输入机构名称',
					bg : '#AE81FF',
					time : 3
				});
				$("#name").focus();
				return false;
			}

            $("#dataForm").submit();
		}
	</script>
</body>
</html>

