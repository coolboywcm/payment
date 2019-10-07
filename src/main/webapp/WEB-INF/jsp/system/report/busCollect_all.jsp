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
	<!-- jsp文件头和头部 -->
	<%@ include file="../admin/top.jsp"%> 
	<style>
	   .qryTable{
	      margin-left: 5px; table-layout:fixed;margin-top: 10px;margin-bottom: 15px;
	   }
	   .qryTable select{
	      margin-bottom: 0px;
	   }
	   .qryTable input{
	      margin-bottom: 0px;
	   }
	   .qryTable .splitDiv{
	     width: 15px;
	   }
	</style>
	</head> 
<body>
		
<div class="container-fluid" id="main-container" style="padding: 10px;">
<div class="tabbable">
            <ul class="nav nav-tabs" id="myTab">
              <li class="active"><a data-toggle="tab" href="#rpType1"> 日报表</a></li>
              <li class=""><a data-toggle="tab" href="#rpType2"> 月报表</a></li>
              <li class=""><a data-toggle="tab" href="#rpType3"> 季报表</a></li>
              <li class=""><a data-toggle="tab" href="#rpType4"> 年报表</a></li>
            </ul>
            <div class="tab-content" style="width: 100%;height: 700px;padding: 0px;overflow: hidder;">
			  <div id="rpType1" class="tab-pane active" style="width: 100%;height: 100%;padding: 0px;">
				<iframe id="ifRpType1" style="width: 100%;height: 690px;border: none;" src="<%=basePath%>report/busCollectList?type=1"></iframe>
			  </div>
			  <div id="rpType2" class="tab-pane" style="width: 100%;height: 100%;padding: 0px;">
				<iframe id="ifRpType2" style="width: 100%;height: 690px;border: none;" src="<%=basePath%>report/busCollectList?type=2"></iframe>
			  </div>
			  <div id="rpType3" class="tab-pane" style="width: 100%;height: 100%;padding: 0px;">
				<iframe id="ifRpType3" style="width: 100%;height: 690px;border: none;" src="<%=basePath%>report/busCollectList?type=3"></iframe>
			  </div>
			  <div id="rpType4" class="tab-pane" style="width: 100%;height: 100%;padding: 0px;">
				<iframe id="ifRpType4" style="width: 100%;height: 690px;border: none;" src="<%=basePath%>report/busCollectList?type=4"></iframe>
			  </div>
            </div>
	</div>


</div><!--/.fluid-container#main-container-->
		
		
		<!-- 引入 -->
		<script type="text/javascript">window.jQuery || document.write("<script src='static/js/jquery-1.9.1.min.js'>\x3C/script>");</script>
		<script src="static/js/bootstrap.min.js"></script>
		<script src="static/js/ace-elements.min.js"></script>
		<script src="static/js/ace.min.js"></script>
		
		<script type="text/javascript" src="static/js/chosen.jquery.min.js"></script><!-- 下拉框 -->
		<script type="text/javascript" src="static/js/bootstrap-datepicker.min.js"></script><!-- 日期框 -->
		<script type="text/javascript" src="static/js/bootbox.min.js"></script><!-- 确认窗口 -->
		<!-- 引入 -->
		
		
		<script type="text/javascript" src="static/js/jquery.tips.js"></script><!--提示框-->
		<script type="text/javascript" src="static/js/common/common.js"></script>
		<script type="text/javascript">
		
		$(top.hangge());
		
		//检索
		function search(){
			top.jzts();
			$("#qryForm").submit();
		}
		
		</script>
		
		<script type="text/javascript">
		
		$(function() {
			
			//日期框
			$('.date-picker').datepicker({autoclose : true,todayHighlight : true});
			
			//下拉框
			$(".chzn-select").chosen(); 
			$(".chzn-select-deselect").chosen({allow_single_deselect:true}); 
			
			$("#ifRpType1").load(function(){
			   //alert(1);
			   //iFrameHeight("ifRpType1");
			})
		});
		
		//导出excel
		function toExcel(){
			var USERNAME = $("#nav-search-input").val();
			var lastLoginStart = $("#lastLoginStart").val();
			var lastLoginEnd = $("#lastLoginEnd").val();
			var ROLE_ID = $("#role_id").val();
			window.location.href='<%=basePath%>bonus/excel.do?USERNAME='+USERNAME+'&lastLoginStart='+lastLoginStart+'&lastLoginEnd='+lastLoginEnd+'&ROLE_ID='+ROLE_ID;
		}
		
		
		
		</script>
		
	</body>
</html>

