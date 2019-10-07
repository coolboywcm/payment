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
		
<div class="container-fluid" id="main-container">


<div id="page-content" class="clearfix">
						
  <div class="row-fluid">


	<div class="row-fluid">
	
			<!-- 检索  -->
			<form action="activeDetail/listActiveDetail" method="post" name="qryForm" id="qryForm">
			<input type="hidden" name="activeId" value="${pd.activeId }" />
			<div id="zhongxin">
			<table>
				<tr>
					<td>
						<span class="input-icon">
							<input autocomplete="off" id="nav-search-input" type="text" name="qryName" value="${pd.qryName }" placeholder="这里输入关键词" />
							<i id="nav-search-icon" class="icon-search"></i>
						</span>
					</td>

					<td style="vertical-align:top;">&nbsp;<button class="btn btn-mini btn-light" onclick="search();" title="检索"><i id="nav-search-icon" class="icon-search" style="line-height: 20px;"></i></button></td>

                    <td style="vertical-align:top;">
						&nbsp;<a class="btn btn-mini btn-success" onclick="add();">新增</a>
						<a title="批量删除" class="btn btn-mini btn-danger" onclick="makeAll('确定要删除选中的数据吗?');" ><i class='icon-trash'></i>批量删除</a>
					</td>
				</tr>
			</table>
			<!-- 检索  -->
		
		
			<table id="table_report" class="table table-striped table-bordered table-hover">
				
				<thead>
					<tr>
						<th class="center">
						<label><input type="checkbox" id="zcheckbox" /><span class="lbl"></span></label>
						</th>
						<th>序号</th>
						<th>明细标题</th>
						<c:if test="${pd.activeType == 'dehd'}">	
						<th>原价(元)</th>
						<th>优惠金额(元)</th>
						<th>单次消费最大购买份数</th>
						</c:if>
						<c:if test="${pd.activeType == 'zkyh'}">	
						<th>优惠起点金额(元)</th>
						<th>优惠折扣</th>
						<th>优惠封顶金额(元)</th>
						</c:if>
						<c:if test="${pd.activeType == 'sjyh'}">	
						<th>达标金额(元)</th>
						<th>随机优惠额度</th>
						</c:if>
						<c:if test="${pd.activeType == 'ljyh'}">	
						<th>达标金额(元)</th>
						<th>立减金额(元)</th>
						<th>单次消费最大购买数</th>
						</c:if>
						<th>描述</th>
						<th class="center">操作</th>
					</tr>
				</thead>
										
				<tbody>
					
				<!-- 开始循环 -->	
				<c:choose>
					<c:when test="${not empty list}">
						<c:forEach items="${list}" var="record" varStatus="vs">
									
							<tr>
								<td class='center' style="width: 30px;">
									<c:if test="${record.name != 'admin'}"><label><input type='checkbox' name='ids' value="${record.id }" id="${record.id }" alt="${record.name }"/><span class="lbl"></span></label></c:if>
									<c:if test="${record.name == 'admin'}"><label><input type='checkbox' disabled="disabled" /><span class="lbl"></span></label></c:if>
								</td>
								<td class='center' style="width: 30px;">${vs.index+1}</td>
								<td>${record.title }</td>
								<c:if test="${pd.activeType == 'dehd'}">	
								<td>${record.hdyj }</td>
								<td>${record.yhje }</td>
								<td>${record.dcxfzdgmfs }</td>
								</c:if>
								<c:if test="${pd.activeType == 'zkyh'}">	
								<td>${record.yhqdje }</td>
								<td>${record.yhzk }</td>
								<td>${record.yhfdje }</td>
								</c:if>
								<c:if test="${pd.activeType == 'sjyh'}">	
								<td>${record.dbje }</td>
								<td>${record.sjyhzxz }(元)至${record.sjyhzddz }(元)</td>
								</c:if>
								<c:if test="${pd.activeType == 'ljyh'}">	
								<td>${record.dbje }</td>
								<td>${record.ljje }</td>
								<td>${record.dcxfzdgms }</td>
								</c:if>
								<td>${record.detailDesc}</td>
								<td style="width: 60px;">
									<div class='btn-group'>
										    <a class='btn btn-mini btn-info' title="编辑" onclick="edit('${record.id }');"><i class='icon-edit'></i></a>
											<a class='btn btn-mini btn-danger' title="删除" onclick="del('${record.id }','${record.title }');"><i class='icon-trash'></i></a>
									</div>
								</td>
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
		</div>
		</form>
		<table style="width: 100%;">
		  <tr>
				<td colspan="2" style="text-align: center;">
				    <button onclick="top.Dialog.close();" class="btn btn-small btn-danger">关&nbsp;&nbsp;闭 </i></button>
				</td>
			</tr>
		<table>
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
		

		//新增
		function add(){
			 top.jzts();
			 var diag = new top.Dialog();
			 diag.Drag=true;
			 diag.Title ="新增活动明细";
			 diag.URL = "<%=basePath%>activeDetail/edit?type=add&activeId=${pd.activeId}&activeType=${pd.activeType}";
			 diag.Width = 450;
			 diag.Height = 350;
			 diag.CancelEvent = function(){ //关闭事件
				 if(diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none'){
					 if('${page.currentPage}' == '0'){
						 top.jzts();
						 setTimeout("self.location=self.location",100);
					 }else{
						 nextPage(${page.currentPage});
					 }
				}
				diag.close();
			 };
			 diag.show();
		}
		
		//修改
		function edit(id){
			 top.jzts();
			 var diag = new top.Dialog();
			 diag.Drag=true;
			 diag.Title ="编辑活动明细";
			 diag.URL = '<%=basePath%>activeDetail/edit?type=edit&activeType=${pd.activeType}&id='+id;
			 diag.Width = 450;
			 diag.Height = 350;
			 diag.CancelEvent = function(){ //关闭事件
				 if(diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none'){
					nextPage(${page.currentPage});
				}
				diag.close();
			 };
			 diag.show();
		}
		
		//删除
		function del(id,msg){
			bootbox.confirm("确定要删除["+msg+"]吗?", function(result) {
				if(result) {
					top.jzts();
					var url = "<%=basePath%>activeDetail/del?id="+id+"&tm="+new Date().getTime();
					$.get(url,function(data){
						nextPage(${page.currentPage});
					});
				}
			});
		}
		
		//批量操作
		function makeAll(msg){
			bootbox.confirm(msg, function(result) {
				if(result) {
					var str = '';
					var emstr = '';
					var phones = '';
					for(var i=0;i < document.getElementsByName('ids').length;i++)
					{
						  if(document.getElementsByName('ids')[i].checked){
						  	if(str=='') str += document.getElementsByName('ids')[i].value;
						  	else str += ',' + document.getElementsByName('ids')[i].value;
						  	
						  	if(emstr=='') emstr += document.getElementsByName('ids')[i].id;
						  	else emstr += ';' + document.getElementsByName('ids')[i].id;
						  	
						  	if(phones=='') phones += document.getElementsByName('ids')[i].alt;
						  	else phones += ';' + document.getElementsByName('ids')[i].alt;
						  }
					}
					if(str==''){
						bootbox.dialog("您没有选择任何内容!", 
							[
							  {
								"label" : "关闭",
								"class" : "btn-small btn-success",
								"callback": function() {
									//Example.show("great success");
									}
								}
							 ]
						);
						
						$("#zcheckbox").tips({
							side:3,
				            msg:'点这里全选',
				            bg:'#AE81FF',
				            time:8
				        });
						
						return;
					}else{
						if(msg == '确定要删除选中的数据吗?'){
							top.jzts();
							$.ajax({
								type: "POST",
								url: '<%=basePath%>activeDetail/deleteAll?tm='+new Date().getTime(),
						    	data: {ids:str},
								dataType:'json',
								//beforeSend: validateData,
								cache: false,
								success: function(data){
										nextPage(${page.currentPage});
								}
							});
						}
						
						
					}
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

