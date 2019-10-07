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
			<form action="report/activeCollectList" method="post" name="qryForm" id="qryForm">
			<table style="" class="qryTable">
								<tbody>
								<tr>
								    <td><label>活动名称：</label></td>
									<td>
										<select id="activeId" name="activeId" class="form-control" style="width: 120px;">
											<option value="">请选择...</option>
													<c:forEach items="${activeList}"  var="active">
														<option value="${active.id }"  <c:if test="${active.id == pd.activeId }">selected</c:if>>${active.name }</option>
													</c:forEach>
											
										</select>
									</td>
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
                            		<td><label>统计维度：</label></td>
									<td>
										<select name="range" id="range" style="width: 120px;" onchange="changeRange()">
										    <option value="">无</option>
										    <option value="shop" <c:if test="${pd.range == 'shop'}">selected</c:if> >按商户统计</option>
										    <option value="terminal" <c:if test="${pd.range == 'terminal'}">selected</c:if> >按终端统计</option>
										</select>
                            		</td>
                            		<td><label sign="shop">&nbsp;&nbsp;&nbsp;&nbsp;商户门店：</label></td>
                            		<td>
	                            		<select sign="shop" name="shopId" id="shopId" style="vertical-align:top;width: 120px;"  >
													<option value="">所有门店</option>
													<c:forEach items="${shopList}"  var="shop">
															<option value="${shop.id }" <c:if test="${pd.shopId == shop.id}">selected</c:if>  >${shop.name }</option>
													</c:forEach>
									     </select>
								     </td>
                            		<td colspan="3">
                            		      &nbsp;&nbsp;&nbsp;&nbsp;<button class="btn btn-purple btn-small" onclick="search();" >查询<i class="icon-search icon-on-right"></i></i></button>
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
						<c:if test="${pd.range == 'shop'}">
						   <th>商户</th>
						</c:if>
						<c:if test="${pd.range == 'terminal'}">
						   <th>终端编号</th>
						</c:if>
						<th>活动名称</th>
						<th>订单原金额</th>
						<th>订单笔数</th>
						<th>实收金额</th>
						<th>优惠金额</th>
					</tr>
				</thead>
										
				<tbody>
					
				<!-- 开始循环 -->	
				<c:choose>
					<c:when test="${not empty list}">
						<c:forEach items="${list}" var="item" varStatus="vs">
							<tr>
								<td class='center' style="width: 30px;">${vs.index+1}</td>
								<c:if test="${pd.range == 'shop'}">
								   <td>${item.shopName }</td>
								</c:if>
								<c:if test="${pd.range == 'terminal'}">
								   <td>${item.code }</td>
								</c:if>
								<td>${item.activeName }</td>
								<td><fmt:formatNumber type="number" value="${item.amountTotal/100}" pattern="0.00" maxFractionDigits="2"/></td>
								<td>${item.orderCount}</td>
								<td><fmt:formatNumber type="number" value="${item.realAmountTotal/100}" pattern="0.00" maxFractionDigits="2"/></td>
								<td><fmt:formatNumber type="number" value="${item.discountAmountTotal/100}" pattern="0.00" maxFractionDigits="2"/></td>
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
        function changeRange(){
        	var range = $("#range").val();
        	if(range != 'terminal'){
        		$("[sign='shop']").hide();
        		$("#shopId").val("");
        	}else{
        		$("[sign='shop']").show();
        	}
        }
        
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
			$("#range").trigger("change");
			
		});
		
		//导出excel
		function toExcel(){
			window.location.href='<%=basePath%>report/activeExcel?'+$("#qryForm").serialize();
		}
		
		
		
		
		</script>
		
	</body>
</html>

