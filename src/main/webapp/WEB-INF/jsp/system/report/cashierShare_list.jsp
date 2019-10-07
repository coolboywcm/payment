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
		
<div class="container-fluid" id="main-container">


<div id="page-content" class="clearfix">
						
  <div class="row-fluid">


	<div class="row-fluid">
	
			<!-- 检索  -->
			<form action="report/cashierShareList" method="post" name="qryForm" id="qryForm">
			<table style="" class="qryTable">
								<tbody>
								<tr>
									<td><label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;交易日期：</label></td>
									<td>
										<div class="form-group" id="dateRange">
											<div class="input-daterange input-group" id="datepicker">
				                                <input type="text" class="input-sm form-control  date-picker" style="margin-left: 0px; width: 88px;" name="beginDate" id="beginDate" value="${pd.beginDate}" data-date-format="yyyy-mm-dd"  readonly="readonly" >
				                                <span class="input-group-addon">到</span>
				                                <input type="text" class="input-sm form-control  date-picker" style="margin-right:15px; width: 88px;" name="endDate" id="endDate" value="${pd.endDate}" data-date-format="yyyy-mm-dd"  readonly="readonly">
				                            </div>
			                           	</div> 
                            		</td>
                            		<td colspan="3">
                            		      &nbsp;<button class="btn btn-purple btn-small" onclick="search();" >搜索<i class="icon-search icon-on-right"></i></i></button>
										  &nbsp;<button class="btn  btn-small" type="reset" onclick="$('#activeId').val('');$('#beginDate').val('');$('#endDate').val('');window.location.reload()">重置<i class="icon-undo icon-on-right"></i> </button>
										  &nbsp;<div class="btn btn-info  btn-small" onclick="toExcel();">导出<i class=" icon-download-alt icon-on-right"></i></div>
								    </td>

								</tr>	
							</tbody></table>
			<!-- 检索  -->
		
		
			<input type="hidden" name="type" value="${pd.type}">
			<table id="table_report" class="table table-striped table-bordered table-hover">
				
				<thead>
					<tr>
						<th>序号</th>
						<th>支付运营商</th>
						<th>商户号</th>
						<th>收银员号</th>
						<th>时间</th>
						<th>交易笔数</th>
						<th>商户分润金额(元)</th>
						<th>收银员分润金额(元)</th>
					</tr>
				</thead>
										
				<tbody>
					
				<!-- 开始循环 -->	
				<c:choose>
					<c:when test="${not empty list}">
						<c:forEach items="${list}" var="item" varStatus="vs">
							<tr>
								<td class='center' style="width: 30px;">${vs.index+1}</td>
								<td>${item.orgName }</td>
								<td>${item.shopName }</td>
								<td>${item.cashierCode }</td>
								<td>
								   <c:if test="${not empty pd.beginDate && not empty pd.endDate}">${pd.beginDate}&nbsp;至&nbsp;${pd.endDate}</c:if>
								   <c:if test="${not empty pd.beginDate && empty pd.endDate}">${pd.beginDate}&nbsp;至今</c:if>
								   <c:if test="${empty pd.beginDate && not empty pd.endDate}">&nbsp;${pd.endDate}&nbsp;之前</c:if>
								   <c:if test="${empty pd.beginDate && empty pd.endDate}">--</c:if>
								</td>
								<td>${item.orderCount }</td>
								<td><fmt:formatNumber type="number" value="${item.shopShare/100}" pattern="0.00" maxFractionDigits="2"/></td>
								<td><fmt:formatNumber type="number" value="${item.cashierShare/100}" pattern="0.00" maxFractionDigits="2"/></td>
							</tr>
						
						</c:forEach>


					</c:when>
					<c:otherwise>
						<tr class="main_info">
							<td colspan="8" class="center">没有相关数据</td>
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
	</div>
 
 
 
 
	<!-- PAGE CONTENT ENDS HERE -->
  </div><!--/row-->
	
</div><!--/#page-content-->
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
			
			
		});
		
		//导出excel
		function toExcel(){
			window.location.href='<%=basePath%>report/cashierShareExcel?'+$("#qryForm").serialize();
		}
		
		
		
		
		</script>
		
	</body>
</html>

