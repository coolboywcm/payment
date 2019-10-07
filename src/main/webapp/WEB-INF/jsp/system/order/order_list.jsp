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
			<form action="order/listOrder" method="post" name="qryForm" id="qryForm">
			<table style="" class="qryTable">
								<tbody><tr>

									<td><label>活动名称：</label></td>
									<td>
										<select id="activeId" name="activeId" class="form-control" style="">
											<option value="">请选择...</option>
													<c:forEach items="${activeList}"  var="active">
														<option value="${active.id }" >${active.name }</option>
													</c:forEach>
											
										</select>
									</td>
									<td><div class="splitDiv">&nbsp;</div></td>
									
									<td><label>交易结果：</label></td>
									<td colspan="1">
										<select id="status" name="state" class="form-control" style="">
											<option value="">请选择...</option>
											<option value="0">未知</option>
											<option value="1">成功</option>
											<option value="2">失败</option>
											<option value="3">已冲正</option>
											<option value="4">已撤销</option>
										</select>
									</td>
									<td><div class="splitDiv">&nbsp;</div></td>
									
									<td><label>交易名称：</label></td>
									<td colspan="1"><input style="" id="tradeName" name="tradeName" value="" type="text" class="form-control" placeholder="支持模糊查询"></td>
									<td><div class="splitDiv">&nbsp;</div></td>

									<td><label>交易卡号：</label></td>
									<td colspan="1"><input style="" id="cardNo" name="orderNo" value="" type="text" class="form-control" placeholder=""></td>
									<td><div class="splitDiv">&nbsp;</div></td>
								</tr>
								
								<tr style="height: 20px;">
								</tr>
								
								<tr>
									<td><label>商户名称：</label></td>
									<td colspan="1"><input style="" id="shopName" name="shopName" value="" type="text" class="form-control" placeholder="支持模糊查询"></td>
									<td><div class="splitDiv">&nbsp;</div></td>
									
									<td><label>商户编号：</label></td>
									<td colspan="1"><input style="" id="shopCode" name="shopCode" value="" type="text" class="form-control"></td>
									<td><div class="splitDiv">&nbsp;</div></td>
									
									<td><label>终端编号：</label></td>
									<td colspan="1"><input style="" id="posCode" name="posCode" value="" type="text" class="form-control"></td>
									<td><div class="splitDiv">&nbsp;</div></td>

									<!-- <td><label>系统参考号：</label></td>
									<td colspan="1"><input style="" id="refnum" name=".refnum" value="" type="text" class="form-control"></td>
									<td><div class="splitDiv">&nbsp;</div></td> -->
									

									<td><label>平台订单号：</label></td>
									<td colspan="1"><input style="" id="ptOrderId" name="s_promotionDetail.ptOrderId" value="" type="text" class="form-control"></td>
									<td><div class="splitDiv">&nbsp;</div></td>
								</tr>
								
								<tr style="height: 20px;">
								</tr>
								
								<tr>
									
									<td><label>交易日期：</label></td>
									<td>
										<div class="form-group" id="dateRange">
											<div class="input-daterange input-group" id="datepicker">
				                                <input type="text" class="input-sm form-control  date-picker" style="margin-left: 0px; width: 88px;" name="beginDate" id="beginDate" data-date-format="yyyy-mm-dd"  readonly="readonly" >
				                                <span class="input-group-addon">到</span>
				                                <input type="text" class="input-sm form-control  date-picker" style="margin-right:15px; width: 88px;" name="endDate" id="endDate" data-date-format="yyyy-mm-dd"  readonly="readonly">
				                            </div>
			                           	</div> 
                            		</td>
                            		<td colspan="3">
                            		      &nbsp;<button class="btn btn-purple btn-small" onclick="search();" >搜索<i class="icon-search icon-on-right"></i></i></button>
										  &nbsp;<button class="btn  btn-small" type="reset">重置<i class="icon-undo icon-on-right"></i> </button>
										  &nbsp;<div class="btn btn-info  btn-small" onclick="toExcel();">导出<i class=" icon-download-alt icon-on-right"></i></div>
								    </td>
                            		
                            		<td colspan="4">
                            			  
                            		</td>
								</tr>	
							</tbody></table>
			<%-- <table>
				<tr>
					<td>
						<span class="input-icon">
							<input autocomplete="off" id="nav-search-input" type="text" name="qryName" value="${pd.qryName }" placeholder="这里输入关键词" />
							<i id="nav-search-icon" class="icon-search"></i>
						</span>
					</td>

					<td style="vertical-align:top;">
					  &nbsp;<button class="btn btn-purple btn-small" onclick="search();" >搜索<i class="icon-search icon-on-right"></i></i></button>
					  &nbsp;<button class="btn  btn-small" type="reset">重置<i class="icon-undo icon-on-right"></i> </button>
					  &nbsp;<button class="btn btn-info  btn-small">导出<i class=" icon-download-alt icon-on-right"></i></button>
					  </td>
				</tr>
			</table> --%>
			<!-- 检索  -->
		
		
			<table id="table_report" class="table table-striped table-bordered table-hover">
				
				<thead>
					<tr>
						<th>序号</th>
						<th>结果</th>
						<th>商户名称</th>
						<th>商户终端</th>
						<th>交易日期</th>
						<th>交易名称</th>
						<th>卡号</th>
						<th>活动名称</th>
						<th>订单金额</th>
						<th>实收金额</th>
						<th>优惠金额</th>
						<th>优惠份数</th>
					</tr>
				</thead>
										
				<tbody>
					
				<!-- 开始循环 -->	
				<c:choose>
					<c:when test="${not empty list}">
						<c:forEach items="${list}" var="item" varStatus="vs">
									
							<tr>
								
								<td class='center' style="width: 30px;">${vs.index+1}</td>
								<td>${item.orderStateName }</td>
								<td>${item.shopName }</td>
								<td>${item.posCode }</td>
								<td>${item.payTime }</td>
								<td>${item.tradeName }</td>
								<td>${item.cardNo}</td>
								<td>${item.activeName}</td>
								<td><fmt:formatNumber type="number" value="${item.orderAmount/100}" pattern="0.00" maxFractionDigits="2"/></td>
								<td><fmt:formatNumber type="number" value="${item.realAmount/100}" pattern="0.00" maxFractionDigits="2"/></td>
								<td><fmt:formatNumber type="number" value="${item.discountAmount/100}" pattern="0.00" maxFractionDigits="2"/></td>
								<td>${item.isDiscount}</td>
							</tr>
						
						</c:forEach>


					</c:when>
					<c:otherwise>
						<tr class="main_info">
							<td colspan="12" class="center">没有相关数据</td>
						</tr>
					</c:otherwise>
				</c:choose>
					
				
				</tbody>
			</table>
			
		<div class="page-header position-relative">
		<table style="width:100%;">
			<tr>
				<td style="vertical-align:top;">
					<!-- <a class="btn btn-small btn-success" onclick="add();">新增</a> -->
					<!-- <a title="批量发送电子邮件" class="btn btn-small btn-info" onclick="makeAll('确定要给选中的用户发送邮件吗?');"><i class="icon-envelope-alt"></i></a>
					<a title="批量发送短信" class="btn btn-small btn-warning" onclick="makeAll('确定要给选中的用户发送短信吗?');"><i class="icon-envelope"></i></a> -->
					<!-- <a title="批量删除" class="btn btn-small btn-danger" onclick="makeAll('确定要删除选中的数据吗?');" ><i class='icon-trash'></i></a> -->
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
		
		//导出excel
		function toExcel(){
			/* $("#qryForm").attr("action","order/excel");
			$("#qryForm").submit(); */
			window.location.href='<%=basePath%>order/excel?'+$("#qryForm").serialize();
		}
		
		
		
		</script>
		
	</body>
</html>

