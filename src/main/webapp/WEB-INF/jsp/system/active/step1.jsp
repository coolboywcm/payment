<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">

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
	}
})
</script>
<div class="step-pane active" id="step1">
	<h3 class="lighter block green">必填信息</h3>
	
	<table style="margin-left: 20px;" class="formTable">
		<tr>
		    <td style="text-align: right;"><span>活动机构：</span></td>
			<td>
			   	<select class="chzn-select" name="orgId" id="orgId" style="vertical-align:top;width: 315px;" need="true"  onchange="refShopSelByOrgId()" validTip="请选择机构">
							<option value="">请选择...</option>
							<c:forEach items="${orgList}" var="org">
								<option value="${org.id }" <c:if test="${active.orgId == org.id }">selected</c:if>>${org.name }</option>
							</c:forEach>
			     </select>
			     <span class="red">*</span>
			</td>
		</tr>
		<tr>
		    <td style="text-align: right;padding-top: 20px;"><span>商户门店：</span></td>
			<td style="padding-top: 20px;">
			   	<select name="shopId" id="shopId" style="vertical-align:top;width: 315px;"  validTip="请选择门店">
							<option value="">请选择...</option>
							
			     </select>
			     <span class="red">*</span>
			</td>
		</tr>
		<tr>
		   <td style="text-align: right;padding-top: 15px;"><span>活动名称：</span></td>
			<td style="padding-top: 15px;"><input type="text" name="name" id="name" value="${active.name }" maxlength="32" placeholder="9.9大片随便看" title="活动名称" need onblur="hasN('${active.name }')"/><span class="red">*</span></td>
		</tr>
		<tr>
		   <td style="text-align: right;padding-top: 15px;"><span>广告信息：</span></td>
			<td style="padding-top: 15px;"><input type="text" name="adInfo" id="name" value="${active.adInfo }" maxlength="32" placeholder="华彩人生，银联相伴，刷**信用卡享受9.9优惠特权" title="活动名称" need/><span class="red">*</span></td>
		</tr>
	</table>

	
	
</div>