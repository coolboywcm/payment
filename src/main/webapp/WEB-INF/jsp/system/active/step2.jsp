<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="step-pane" id="step2">
	<h3 class="lighter block green">必填信息</h3>
	<input type="hidden" id="bonusType" name="bonusType" value="1"/>
	<table style="margin-left: 20px;" class="formTable">
		<tr trType="1" >
		    <td style="text-align: right;padding-top: 20px;"><span>奖金池：</span></td>
			<td style="padding-top: 20px;">
			   	<select class="chzn-select" name="bonusId" id="bonusId" data-placeholder="请选择奖金池" style="vertical-align:top;width: 315px;"  title="类型" need>
							<option value=""></option>
							<c:forEach items="${bonusList}" var="bonus">
								<option value="${bonus.id }" <c:if test="${active.bonusId == bonus.id }">selected</c:if>>${bonus.name }</option>
							</c:forEach>
			     </select>
			     <span class="red">*</span>
			</td>
		</tr>
		<tr>
		   <td style="text-align: right;padding-top: 30px;"><span>每日最高活动金额 ：</span></td>
			<td style="padding-top: 30px;">
			    <span class="input-icon">
				   <input type="text" dataType="dec" name="mrzghdje" id="mrzghdje" value="${active.mrzghdje}"  style="width: 280px;" placeholder="[本活动每日可使用的最高优惠金额]例如: 66666666" need>
				   <i class="icon-cash">￥</i>
			   </span>
			   <span class="red">*</span>
			 </td>
		</tr>
	</table>
</div>