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
		<script type="text/javascript" src="static/js/common/common.js"></script>
		<style>
		  #div_t label{
		     display: inline;
		     margin-right: 15px;
		  }
		</style>
<script type="text/javascript">
	$(top.hangge());
	$(document).ready(function(){
		if($("#id").val()!=""){
			$("#orgId").attr("readonly","readonly");
			$("#orgId").css("color","gray");
		}
	});
	function validForm(formObj){
	  var objList = $('[need]',formObj);
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
	//保存
	function save(){
		if(!validForm($("#dataForm"))){
		   return false;
		}
		$("#dataForm").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();

	}

	var shopList = ${shopList};
	var shopId = '${shopId}';
	function refShopSelByOrgId(){
		var orgId = $("#orgId").val();
		console.log('orgId',orgId);
		console.log('shopList.length',shopList.length);
		$("#shopId").html('<option value="">请选择...</option>');
		for(var i = 0; i<shopList.length;i++){
			if(shopList[i].orgId == orgId){
				$("#shopId").append('<option value="'+shopList[i].id+'">'+shopList[i].name+'</option>');
			}
		}
	}
	$(function() {
		$("#orgId").trigger("change");
		if(shopId){
			$("#shopId").val(shopId);
			$("#shopId").trigger("change");
		}
	})
	
</script>
	</head>
<body>
<form action="adimg/${action}" name="dataForm" id="dataForm" method="post"  enctype="multipart/form-data">
		<input type="hidden" name="id" id="id" value="${bean.id }"/>
		<input type="hidden" name="fileId1" id="fileId1" value="${bean.fileId1 }"/>
		<input type="hidden" name="fileId2" id="fileId2" value="${bean.fileId2 }"/>
		<input type="hidden" name="fileId3" id="fileId3" value="${bean.fileId3 }"/>
		<div id="zhongxin" style="padding: 20px auto 10px auto;width: 100%;margin-top: 15px;">
		<table style="width: 100%;">
			<tr>
			    <td style="text-align: right;padding-top: 0px;">广告名称：</td>
				<td style="padding-top: 10px;">
				   <input type="text" name="name" id="name" value="${bean.name}"  maxlength="32" placeholder="广告名称"  need/>
				</td>
			</tr>
			<tr>
			    <td style="text-align: right;">归属机构：</td>
				<td>
				   	<select class="chzn-select" name="orgId" id="orgId" data-placeholder="请选择机构" onchange="refShopSelByOrgId()"  style="vertical-align:top;"  title="机构" need>
								<option value=""></option>
								<c:forEach items="${orgList}" var="org">
									<option value="${org.id }" <c:if test="${bean.orgId == org.id }">selected</c:if>>${org.name }</option>
								</c:forEach>
				     </select>
				</td>
			</tr>
			<tr>
			    <td style="text-align: right;padding-top: 0px;"><span>商户门店：</span></td>
				<td style="padding-top: 10px;">
				   	<select  name="shopId" id="shopId"   validTip="请选择门店"  onchange="getTerminalByShopId()" need>
								<option value="">请选择...</option>
				     </select>
				</td>
			</tr>
			<tr>
			    <td style="text-align: right;vertical-align: top;">终端编号：</td>
				<td style="">
				   <div>
						   <label>
								<input name="form-field-checkbox" type="checkbox" onclick="ckAllTerminal(this)"><span class="lbl"> 全选</span>
							</label>
					</div>
				   <div id="div_t" style="width: 450px;"></div>
				</td>
			</tr>
			<tr>
			   <td style="text-align: right;"><span>广告图片1：</span></td>
				<td style="padding-top: 10px;">
				    <table  style="width: 100%;">
				        <tr>
				           <td   style="width: 40%;"><input type="file" id="id-input-file-1" style="width: 200px;" name="file1" <c:if test="${action == 'add' }">need</c:if> style="width:100px;" onchange="fileType(this)" validTip="请选择图片"/></td>
				           <td style="width: 60%;"><span>&nbsp;&nbsp;图片提示：</span> <input type="text" style="width: 100px;margin-top: 10px;" name="tip1" id="tip1" value="${bean.tip1}"  maxlength="32"  /></td>
				         </tr>
				    </table>
				</td>
			</tr>
			<tr>
			   <td style="text-align: right;"><span>广告图片2：</span></td>
				<td style="padding-top: 10px;">
				    <table  style="width: 100%;">
				        <tr>
				           <td   style="width: 40%;"><input type="file" id="id-input-file-2" style="width: 200px;"  name="file2" <c:if test="${action == 'add' }">need</c:if> style="width:100px;" onchange="fileType(this)" validTip="请选择图片"/></td>
				           <td style="width: 60%;"><span>&nbsp;&nbsp;图片提示：</span> <input type="text" style="width: 100px;margin-top: 10px;" name="tip2" id="tip2" value="${bean.tip2}"  maxlength="32"  /></td>
				         </tr>
				    </table>
				</td>
			</tr>
			<tr>
			   <td style="text-align: right;"><span>广告图片3：</span></td>
				<td style="padding-top: 10px;">
				    <table  style="width: 100%;">
				        <tr>
				           <td   style="width: 40%;"><input type="file" id="id-input-file-3" style="width: 200px;"  name="file3" <c:if test="${action == 'add' }">need</c:if> style="width:100px;" onchange="fileType(this)" validTip="请选择图片"/></td>
				           <td style="width: 60%;"><span>&nbsp;&nbsp;图片提示：</span> <input type="text" style="width: 100px;margin-top: 10px;" name="tip3" id="tip3" value="${bean.tip3}"  maxlength="32"  /></td>
				         </tr>
				    </table>
				</td>
			</tr>
			<!-- <tr><td colspan="2"><button class="btn  btn-small"><font style="font-size: 16px;font-weight: bold;">+</font>&nbsp;增加图片 </button></td></tr> -->
			<tr>
				<td colspan="2" style="text-align: center;padding-top: 20px;">
					<a class="btn btn-mini btn-primary" onclick="save();">&nbsp;保&nbsp;&nbsp;存&nbsp;</a>
					<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">&nbsp;取&nbsp;&nbsp;消&nbsp;</a>
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
		function ckAllTerminal(obj){
		   console.log('length',$('input:checkbox[name="terminalId"]').length);
		   console.log($(obj).is(':checked'));
		   $('input:checkbox[name="terminalId"]').prop("checked",$(obj).is(':checked') ==true );
		}
		function getTerminalByShopId(){
			$.ajax({
						type: "POST",
						url: '<%=basePath%>adimg/getShopTerminal?tm='+new Date().getTime(),
				    	data: {shopId : $("#shopId").val()},
						dataType:'json',
						//beforeSend: validateData,
						cache: false,
						success: function(data){
						        console.log(data);
						         $("#div_t").html('');
						        if(data.code == '0'){
						           var list = data.data;
						           var tList = '${bean.terminalId}';
						           for(var i=0; i<list.length;i++){
						              var checked = '';
						              console.log(tList.indexOf(list[i].id));
						              if(tList.indexOf(list[i].id) >= 0){
						                 checked = 'checked';
						              }
						              $("#div_t").append('<label><input name="terminalId" value="'+list[i].id+'" type="checkbox"  '+checked+'><span class="lbl"> '+list[i].code+'</span></label>');
						           }
						        }
						}
					});
		}
		function fileType(obj){
			var fileType=obj.value.substr(obj.value.lastIndexOf(".")).toLowerCase();//获得文件后缀名
		    if(fileType != '.png'){
		    	$(obj).tips({
					side:3,
		            msg:'请上传png格式的图片',
		            bg:'#AE81FF',
		            time:3
		        });
		    	$(obj).val('');
		    }
		}
		
		$(function() {
			
			//单选框
			$(".chzn-select").chosen(); 
			$(".chzn-select-deselect").chosen({allow_single_deselect:true}); 
			
			//日期框
			//$('.date-picker').datepicker({autoclose : true,todayHighlight : true});
			/* $("#id-input-file-1 , #id-input-file-2 , #id-input-file-3").ace_file_input({
		        width:'50px',
				no_file:'请选择图片 ...',
				btn_choose:'选择',
				btn_change:'更改',
				droppable:false,
				onchange:null,
				thumbnail:false, //| true | large
				whitelist:'png|PNG'
				//onchange:''
				//
			}); */
			
			/* $("#id-input-file-1 , #id-input-file-2 , #id-input-file-3").fileinput({
		        theme: 'fa',
		        language: 'zh',
		        uploadUrl: '#',
		        allowedFileExtensions: ['jpg', 'png', 'gif']
		    }); */
		});
		
		</script>
	
</body>
</html>