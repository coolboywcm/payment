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
	</head> 
<body>
		



<div id="page-content">
						
  <div class="row-fluid">


	<div  id="zhongxin">
	
			<!-- 检索  -->
			<form action="active/listCards?id=${pd.activeId}" method="post" name="cardQryForm" id="cardQryForm">
			<input type="hidden" name="activeId" value="${pd.activeId}">
			<table>
				<tr>
				   <td>卡号(卡BIN)：&nbsp;</td>
					<td>
							<input autocomplete="off"  type="text" name="qryCardNo" value="${pd.qryName }" placeholder="这里输入关键词" />
					</td>
					<td style="vertical-align:top;">&nbsp;
						<button  class="btn btn-purple btn-small">搜&nbsp;索 <i class="icon-search icon-on-right"></i></button>
					</td>
					<td style="vertical-align:top;">&nbsp;
					</td>
				</tr>
			</table>
			<!-- 检索  -->
			<table id="table_report" class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th>序号</th>
						<th>活动名称</th>
						<th>匹配规则</th>
						<th>卡号/卡BIN</th>
						<th>操作</th>
					</tr>
				</thead>
										
				<tbody>
					
				<!-- 开始循环 -->	
				<c:choose>
					<c:when test="${not empty cardList}">
						<c:forEach items="${cardList}" var="card" varStatus="vs">
									
							<tr>
								<td class='center' style="width: 30px;">${vs.index+1}</td>
								<td>${card.activeName }</td>
								<td>${card.cardTypeName }</td>
								<td>${card.cardNo }</td>
								<td><div style="padding: 3px;" onclick="del('${card.id}','${card.cardNo}');" class="btn btn-minier btn-danger">删除 <i class="icon-trash"></i></div></td>
								
							</tr>
						
						</c:forEach>


					</c:when>
					<c:otherwise>
						<tr class="main_info">
							<td colspan="10" class="center">没有相关数据</td>
						</tr>
					</c:otherwise>
				</c:choose>
					
					
				
				</tbody>
			</table>
			
		<div class="page-header position-relative">
		<table style="width:100%;">
			<tr>
				<td style="vertical-align:top;">
				</td>
				<td style="vertical-align:top;"><div class="pagination" style="float: right;padding-top: 0px;margin-top: 0px;">${page.pageStr}</div></td>
			</tr>
		</table>
		</div>
		</form>
		<table style="width: 100%;">
		  <tr>
				<td colspan="2" style="text-align: center;">
				    <button onclick="save();" class="btn btn-small btn-primary">保&nbsp;&nbsp;存 <i class="icon-ok"></i></button>
				    <button onclick="top.Dialog.close();" class="btn btn-small btn-danger">取&nbsp;&nbsp;消 <i class="icon-arrow-right icon-on-right"></i></button>
				</td>
			</tr>
		<table>	
	</div>
 
 
   
 
	<!-- PAGE CONTENT ENDS HERE -->
  </div><!--/row-->
	
</div><!--/#page-content-->

		
		<!-- 返回顶部  -->
		<a href="#" id="btn-scroll-up" class="btn btn-small btn-inverse">
			<i class="icon-double-angle-up icon-only"></i>
		</a>
		
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
		<script type="text/javascript">
		
		$(top.hangge());
		
		//检索
		function search(){
			top.jzts();
			$("#cardQryForm").submit();
		}
		
		//批量操作
		function del(id,cardNo){
			bootbox.confirm("确定要删除["+cardNo+"]吗?", function(result) {	
				  if(result) {	
					top.jzts();
					$.ajax({
							type: "POST",
							url: '<%=basePath%>active/delCard?tm='+new Date().getTime(),
					    	data: {id:id},
							dataType:'json',
							cache: false,
							success: function(data){
									$("#cardQryForm").submit();
							}
						});
				}		
		  });	
		}
		
		</script>
		
		<script type="text/javascript">
		
		$(function() {
			
			//日期框
			$('.date-picker').datepicker({autoclose : true,todayHighlight : true});
			
			//下拉框
			$(".chzn-select").chosen(); 
			$(".chzn-select-deselect").chosen({allow_single_deselect:true}); 
			
			//复选框
			$('table th input:checkbox').on('click' , function(){
				var that = this;
				$(this).closest('table').find('tr > td:first-child input:checkbox')
				.each(function(){
					this.checked = that.checked;
					$(this).closest('tr').toggleClass('selected');
				});
					
			});
			
		});
		
		</script>
		
	</body>
</html>

