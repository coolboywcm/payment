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
		<link rel="stylesheet" href="static/css/bootstrap-timepicker.css" />
		<script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>
		<script type="text/javascript" src="static/js/common/common.js"></script>
<style type="text/css">
   .tabBtn {
     text-align: left;
     width: 120px;
     border-radius:10px;
   }
   .tabBtn_bg1 {
     background-color:  #EFEEEC;
   }
   .tabBtn_bg2 {
     background-color:  #32D4BB;
   }
   .tabBtn_bg3 {
     background-color:  #00B590;
   }
   .formTable {
     
   }
   .formTable td span{
     font-size: 15px;
   }
   .formTable .red{
     font-size: 18px;
     color: red;
     font-weight: bold;
   }
   .formTable input{
     width: 300px;
   }
   .formTable select{
     width: 300px;
   }
   h3{
     margin-top:0px;
     font-size: 20px;
   }
   .formTable label{
     display: inline;
   }
   .formTable .lbl{
     padding-right: 10px;
   }
</style>		
<script type="text/javascript">
	top.hangge();
	//保存
	function save(){
			$("#form1").submit();
			$("#zhongxin").hide();
			$("#zhongxin2").show();
	}
	
	
</script>
	</head>
<body>
		
		<form action="active/modActiveCard" name="activeFrom" id="activeForm" method="post" enctype="multipart/form-data">
			<div id="zhongxin" style="padding: 10px;">
			<input type="hidden" name="id" value="${active.id }">
			<input type="hidden" name="type" value="${pd.type}">
			<input type="hidden" name="cardNo"  id="cardNo" value="">
			<input type="hidden" name="cardBin"  id="cardBin" value="">	
				
				<div class="row-fluid">
					
					<hr />
					
					<div class="step-content row-fluid position-relative" id="step5">
						    <h3 class="lighter block green">必填信息</h3>
							<table style="margin-left: 20px;" class="formTable">
								<tr>
								    <td style="text-align: right;"><span>活动名称：</span></td>
									<td>
									   	<input type="text"  value="${active.name }" maxlength="32" disabled="disabled" title="活动名称"/>
									</td>
								</tr>
								<tr>
								    <td style="text-align: right;padding-top: 20px;"><span>卡识别：</span></td>
									<td style="padding-top: 20px;">
									   	<select  name="cardIdentifyType" id="cardIdentifyType" style="vertical-align:top;width: 315px;" need validTip="请选择卡识别方式" need>
													<option value="">请选择...</option>
													<option value="1" <c:if test="${active.cardIdentifyType == '1' }">selected</c:if>>卡BIN识别</option>
													<option value="2" <c:if test="${active.cardIdentifyType == '2' }">selected</c:if>>卡号识别</option>
									     </select>
									     <span class="red">*</span>
									</td>
								</tr>
								<tr id="addTypeTr" style="display: none;">
								   <td style="text-align: right;padding-top: 30px;"><span>添加方式：</span></td>
									<td style="padding-top: 30px;">
									   	<select  id="cardAddType" name="cardAddType" style="vertical-align:top;width: 315px;" validTip="请选择卡添加方式" need>
													<option value="">请选择...</option>
													<option value="1" <c:if test="${active.cardAddType == '1' }">selected</c:if>>直接添加</option>
													<option value="2" <c:if test="${active.cardAddType == '2' }">selected</c:if>>Excel导入</option>
									     </select>
									     <span class="red">*</span>
									</td>
								</tr>
								<tr id="handTr1" style="display: none;">
								   <td style="text-align: right;padding-top: 30px;vertical-align: top;"><span>卡BIN：</span><span class="red">*</span></td>
									<td style="padding-top: 30px;">
									    <textarea validTip="请输入卡BIN"   name="taCardBin" id="taCardBin" rows="5" cols="50" style="width:97.5%;" placeholder="请将参加该活动的卡BIN一一例举出来，用|分割。例如 622901|6229002|62290003|"></textarea>
									</td>
								</tr>
								<tr id="handTr2" style="display: none;">
								   <td style="text-align: right;padding-top: 30px;vertical-align: top;"><span>卡号 </span><span class="red">*</span></td>
									<td style="padding-top: 30px;">
									    <textarea validTip="请输入卡号"   name="taCardNo" id="taCardNo" rows="5" cols="50" style="width:97.5%;" placeholder="请将参加该活动的卡号一一例举出来，用|分割。例如 6228108888888888|6228109999999999"></textarea>
									</td>
								</tr>
								<tr id="excelTr1" style="display: none;">
								   <td style="text-align: right;padding-top: 30px;vertical-align: top;"><span>卡BIN：</span></td>
									<td style="padding-top: 30px;">
									    <input type="file" id="id-input-file-1" name="file" style="width:50px;" onchange="fileType(this)" validTip="请选择EXCEL"/>
									     <a class="btn btn-mini btn-success" onclick="window.location.href='<%=basePath%>/active/downExcel?type=1'">下载模版</a>
									</td>
								</tr>
								<tr id="excelTr2" style="display: none;">
								   <td style="text-align: right;padding-top: 30px;vertical-align: top;"><span>卡号 </span></td>
									<td style="padding-top: 30px;">
											<input type="file" id="id-input-file-2" name="file" style="width:50px;" onchange="fileType(this)" validTip="请选择EXCEL"/>
									     	<a class="btn btn-mini btn-success" onclick="window.location.href='<%=basePath%>/active/downExcel?type=2'">下载模版</a>
									</td>
								</tr>
							</table>
					</div>
					
					<hr />
					
				</div>
			</div>
	</form>
					<table style="width: 100%;">
					  <tr>
							<td colspan="2" style="text-align: center;">
							    <button onclick="save();" class="btn btn-small btn-primary">提&nbsp;&nbsp;交<i class="icon-ok"></i></button>
							    <button onclick="top.Dialog.close();" class="btn btn-small btn-danger">取&nbsp;&nbsp;消 <i class="icon-arrow-right icon-on-right"></i></button>
							</td>
						</tr>
					<table>	
	<div id="zhongxin2" class="center" style="display:none"><img src="static/images/jzx.gif" style="width: 50px;" /><br/><h4 class="lighter block green"></h4></div>
		<!-- 引入 -->
		<script src="static/1.9.1/jquery.min.js"></script>
		<script type="text/javascript" src="static/js/fuelux.wizard.js"></script>
		<script src="static/js/bootstrap.min.js"></script>
		<script src="static/js/ace-elements.min.js"></script>
		<script src="static/js/ace.min.js"></script>
		<script type="text/javascript" src="static/js/chosen.jquery.min.js"></script><!-- 下拉框 -->
		<script type="text/javascript" src="static/js/bootstrap-datepicker.min.js"></script><!-- 日期框 -->
		<script type="text/javascript" src="static/js/bootstrap-timepicker.min.js"></script><!-- 时间框 -->
		<!--提示框-->
		<script type="text/javascript" src="static/js/jquery.tips.js"></script>
		<script type="text/javascript">
		    var action = "${action}";
		    var initDone =false;
		    function init(){
			       $("#cardIdentifyType").trigger('change');
			       $("#cardAddType").trigger('change');
			       //$("#taCardBin").val("${active.cardBin}");
			       //$("#taCardNo").val("${active.cardNo}");
		      	    initDone = true;
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
			function validStep(stepObj){
			  //return true;
			  var objList = $('[need]',stepObj);
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
			function save(){
				if(!validStep($("#step5"))){
				        return false;
				    }
				    if($("#cardAddType").val() =="1"){
						var val = $("#cardIdentifyType").val();
						 if(val=="1"){//卡BNI
					        $("#cardBin").val($("#taCardBin").val());
				        }else{//卡号
					        $("#cardNo").val($("#taCardNo").val());
				        }
					}
					$("#activeForm").submit();	
			}	
			$(function() {
				//单选框
				$(".chzn-select").chosen();
				$(".chzn-select-deselect").chosen({
					allow_single_deselect : true
				});
				$("#id-input-file-1 , #id-input-file-2").ace_file_input({
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
				$("#cardIdentifyType").on('change',function(){
				   var val = $("#cardIdentifyType").val();
				   $("[id^='handTr']").hide();
				   $("[id^='excelTr']").hide();
				   $("#addTypeTr").show();
				   if(initDone){
					   	$("#cardAddType").val("");
					   }
				});
				$("#cardAddType").on('change',function(){
				   var val = $("#cardIdentifyType").val();
				   $("[id^='excelTr']").hide();
				   $("[id^='handTr']").hide();
				   $("[id^='id-input-file-']").removeAttr("name");
				   $("[id^='id-input-file-']").removeAttr("need");
				   $("[id^='id-input-file-']").val("");
				   $("[id^='taCard']").removeAttr("name");
				   $("[id^='taCard']").removeAttr("need");
				   //$("[id^='taCard']").val("");
				   if($("#cardAddType").val() =="1"){//手动添加
				   		$("#handTr"+val).show();
				   		 if(val=="1"){//卡BNI
					        $("#taCardBin").attr("need","true");;
				        }else{//卡号
					        $("#taCardNo").attr("need","true");;
				        }
				   }else if($("#cardAddType").val() =="2"){//excel导入
				        $("#excelTr"+val).show();
				        if(val=="1"){//卡BNI
					        $("#id-input-file-1").attr("name","file");
					   		$("#id-input-file-1").attr("need","true");
				        }else{//卡号
					        $("#id-input-file-2").attr("name","file");
					        $("#id-input-file-2").attr("need","true");
				        }
				   }
				});
				init();
			});
			
		</script>
</body>
</html>
