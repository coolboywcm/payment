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
		$("#id-input-file-1").ace_file_input({
					no_file:'请选择EXCEL ...',
					btn_choose:'选择',
					btn_change:'更改',
					droppable:false,
					onchange:null,
					thumbnail:false, //| true | large
					whitelist:'xls|xls',
					blacklist:'gif|png|jpg|jpeg'
					//onchange:''
					//
				});
	});
	function hasN(){
	
	}
	function fileType(obj){
		var fileType=obj.value.substr(obj.value.lastIndexOf(".")).toLowerCase();//获得文件后缀名
	    if(fileType != '.xls'){
	    	$(obj).tips({
				side:3,
	            msg:'请上传xls格式的文件',
	            bg:'#AE81FF',
	            time:3
	        });
	    	$(obj).val('');
	    	document.getElementById(obj.attr("id")).files[0] = '请选择xls格式的文件';
	    }
	}
	//保存
	function save(){
		
		if($("#id-input-file-1").val()==""){
			$("#id-input-file-1").tips({
				side:3,
	            msg:'请选择EXCEL',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#id-input-file-1").focus();
			return false;
		}

		
		
		
		$("#dataForm").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();

	}
	
	
</script>
	</head>
<body>
<form action="terminal/${action}" name="dataForm" id="dataForm" method="post" method="post" enctype="multipart/form-data">
		<div id="zhongxin" >
		<table style="margin-left: 10px;width: 90%;">
			<tr>
				<td style="padding-top: 30px;">
						<input type="file" id="id-input-file-1" name="file" style="width:50px;" onchange="fileType(this)" validTip="请选择EXCEL"/>
				     	<a class="btn btn-mini btn-success" onclick="window.location.href='<%=basePath%>/terminal/downExcel'">下载模版</a>
				     	<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
				     	<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a>
				</td>
			</tr>
			
			<tr>
				<td colspan="2" style="text-align: center;">
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