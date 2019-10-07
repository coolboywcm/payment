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
     margin-bottom: 10px;
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
   .formTable td{
     font-size: 14px;
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
			<input type="hidden" name="id" value="${bean.id }">
			<input type="hidden" name="type" value="${bean.type}">
				<div class="row-fluid">
							<table style="margin-left: 20px;" class="formTable">
								<tr>
								    <td style="text-align: right;font-weight: bold;"><span>活动机构：</span></td>
									<td>
									   	${bean.orgName }
									</td>
								</tr>

								<tr>
								    <td style="text-align: right;font-weight: bold;"><span>活动名称：</span></td>
									<td>
									   	${bean.name }
									</td>
								</tr>
								<tr>
								    <td style="text-align: right;font-weight: bold;"><span>有效期：</span></td>
									<td>
									   	${bean.beginDate }&nbsp;至&nbsp;${bean.endDate }
									</td>
								</tr>
								<tr>
								    <td style="text-align: right;font-weight: bold;"><span>活动周期：</span></td>
									<td>
									   	每周${bean.week }  &nbsp;&nbsp; ${bean.beginTime } 到 ${bean.endTime }
									</td>
								</tr>
								<tr>
								    <td style="text-align: right;font-weight: bold;"><span>规则类型：</span></td>
									<td>
									   <c:if test="${bean.cardIdentifyType == '1' }">卡BIN识别</c:if>
									   <c:if test="${bean.cardIdentifyType == '2' }">卡号识别</c:if>
									</td>
								</tr>
							<c:if test="${bean.type == 'dehd' }">
							    <tr>
								    <td style="text-align: right;font-weight: bold;"><span>优惠总次数：</span></td>
									<td>
									   ${bean.yhzcs }
									</td>
								</tr>
								<tr>
								    <td style="text-align: right;font-weight: bold;"><span>单日最多次数：</span></td>
									<td>
									   ${bean.drzdcs }
									</td>
								</tr>
								<tr>
								    <td style="text-align: right;font-weight: bold;"><span>活动原价：</span></td>
									<td>
									   ${bean.hdyj }
									</td>
								</tr>
								<tr>
								    <td style="text-align: right;font-weight: bold;"><span>优惠单价：</span></td>
									<td>
									   ${bean.yhdj }
									</td>
								</tr>
								<tr>
								    <td style="text-align: right;font-weight: bold;"><span>单卡可参与次数：</span></td>
									<td>
									   ${bean.dkkcycs }
									</td>
								</tr>
							</c:if>
							<c:if test="${bean.type == 'zkyh' }">
							    <tr>
								    <td style="text-align: right;font-weight: bold;"><span>奖金池：</span></td>
									<td>
									   ${bean.bonusName }
									</td>
								</tr>
								<tr>
								    <td style="text-align: right;font-weight: bold;"><span>每日最高活动金额：</span></td>
									<td>
									   ${bean.mrzghdje}
									</td>
								</tr>
								<tr>
								    <td style="text-align: right;font-weight: bold;"><span>最低消费金额：</span></td>
									<td>
									   ${bean.zdxfje }
									</td>
								</tr>
								<tr>
								    <td style="text-align: right;font-weight: bold;"><span>折扣：</span></td>
									<td>
									   ${bean.zk }
									</td>
								</tr>
								<tr>
								    <td style="text-align: right;font-weight: bold;"><span>单笔优惠限额：</span></td>
									<td>
									   ${bean.dbyhje}
									</td>
								</tr>
								<tr>
								    <td style="text-align: right;font-weight: bold;"><span>单卡最高优惠金额：</span></td>
									<td>
									   ${bean.dkzgyhje }
									</td>
								</tr>
							</c:if>
							<c:if test="${bean.type == 'sjyh' }">
							    <tr>
								    <td style="text-align: right;font-weight: bold;"><span>奖金池：</span></td>
									<td>
									   ${bean.bonusName }
									</td>
								</tr>
								<tr>
								    <td style="text-align: right;font-weight: bold;"><span>每日最高活动金额：</span></td>
									<td>
									   ${bean.mrzghdje}
									</td>
								</tr>
								<tr>
								    <td style="text-align: right;font-weight: bold;"><span>最低消费金额：</span></td>
									<td>
									   ${bean.zdxfje }
									</td>
								</tr>
								<tr>
								    <td style="text-align: right;font-weight: bold;"><span>单笔最低优惠：</span></td>
									<td>
									   ${bean.dbzdyh }
									</td>
								</tr>
								<tr>
								    <td style="text-align: right;font-weight: bold;"><span>单笔最高优惠：</span></td>
									<td>
									   ${bean.dbzgyh}
									</td>
								</tr>
								<tr>
								    <td style="text-align: right;font-weight: bold;"><span>单卡合计优惠限额：</span></td>
									<td>
									   ${bean.dkhjyhxe }
									</td>
								</tr>
							</c:if>
							<c:if test="${bean.type == 'ljyh' }">
							    <tr>
								    <td style="text-align: right;font-weight: bold;"><span>奖金池：</span></td>
									<td>
									   ${bean.bonusName }
									</td>
								</tr>
								<tr>
								    <td style="text-align: right;font-weight: bold;"><span>每日最高活动金额：</span></td>
									<td>
									   ${bean.mrzghdje}
									</td>
								</tr>
								<tr>
								    <td style="text-align: right;font-weight: bold;"><span>最低消费金额：</span></td>
									<td>
									   ${bean.zdxfje }
									</td>
								</tr>
								<tr>
								    <td style="text-align: right;font-weight: bold;"><span>立减金额：</span></td>
									<td>
									   ${bean.ljje }
									</td>
								</tr>
								<tr>
								    <td style="text-align: right;font-weight: bold;"><span>单卡合计优惠限额：</span></td>
									<td>
									   ${bean.dkhjyhxe }
									</td>
								</tr>
							</c:if>
								<tr>
								    <td style="text-align: right;font-weight: bold;"><span>创建时间：</span></td>
									<td>
									   ${bean.createTime }
									</td>
								</tr>
								<tr>
								    <td style="text-align: right;font-weight: bold;"><span>广告信息：</span></td>
									<td>
									   ${bean.adInfo }
									</td>
								</tr>
							</table>
					
				</div>
	</form>
					<table style="width: 100%;">
					  <tr>
							<td colspan="2" style="text-align: center;">
							    <button onclick="top.Dialog.close();" class="btn btn-small btn-danger">关&nbsp;&nbsp;闭 <i class="icon-arrow-right icon-on-right"></i></button>
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
