<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	
	<link rel="stylesheet" href="plugins/zTree/3.5/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="plugins/zTree/3.5/jquery.ztree.core-3.5.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
	<script src="static/js/ace-elements.min.js"></script>
<body>

<div class="container-fluid" id="main-container">
<table style="width:100%;" border="0">
	<tr>
		<td style="width:15%;" valign="top" bgcolor="#F9F9F9">
			<div style="width:15%;">
				<ul id="leftTree" class="ztree"></ul>
			</div>
		</td>
		<td style="width:85%;" valign="top" >
			<iframe name="treeFrame" id="treeFrame" frameborder="0" src="<%=basePath%>org/edit" style="margin:0 auto;width:100%;height:100%;"></iframe>
		</td>
	</tr>
</table>	
</div>
<SCRIPT type="text/javascript">
		$(top.hangge());
		var curId = "${pd.curId}";
		var zTreeOb;
		var zTreeNodes = ${zTreeNodes};
		var setting = {
			view: {
				showIcon: showIconForTree
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				onClick: zTreeOnClick
			}
		};

		var zNodes =[
			{ id:0, name:"机构",shortName:"机构", open:true},
		];
		
		function zTreeOnClick(event, treeId, treeNode) {
		    console.log(treeNode.id + ", " +treeNode.tId + ", " + treeNode.name);
		    var pNode = treeNode.getParentNode();
		    if(!pNode){
		        pNode = { id:"", name:"",shortName:""};
		    }
		    console.log(pNode.id + ", " +pNode.tId + ", " + pNode.name);
		    var url = '<%=basePath%>org/edit?id='+treeNode.id
		                   +'&parentId='+pNode.id
		                   +'&type=edit'
		                   +"&guid="+new Date().getTime();
		    console.log(url);
		    $("#treeFrame").attr("src",url);
		    treeFrameT();
		};

		function showIconForTree(treeId, treeNode) {
			return !treeNode.isParent;
		};

		$(document).ready(function(){
			zTreeObj = $.fn.zTree.init($("#leftTree"), setting, zNodes.concat(zTreeNodes));
			zTreeObj.expandAll(true);
			if(curId){
				var curNode = zTreeObj.getNodeByParam("id", curId, null);
				zTreeObj.selectNode(curNode);
				$(".curSelectedNode",$("#leftTree")).trigger("click");
			}
		});
		
		function treeFrameT(){
			var hmainT = document.getElementById("treeFrame");
			var bheightT = document.documentElement.clientHeight;
			hmainT .style.width = '100%';
			hmainT .style.height = (bheightT-7) + 'px';
		}
		treeFrameT();
		window.onresize=function(){  
			treeFrameT();
		};
	</SCRIPT>
</body>
</html>

