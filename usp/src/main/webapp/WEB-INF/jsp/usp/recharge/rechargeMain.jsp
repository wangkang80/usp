<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/WEB-INF/jsp/llsfw/base/head.jsp" />
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath}/static/usp/js/recharge/rechargeMain.js"></script>
<title>账户充值</title>
</head>
<body class="easyui-layout" data-options="fit:true">
	<div data-options="region:'center'">
		<div id="rechargeTable_param" style="padding: 5px; height: auto;">
			<a id="rechargeTable_search_btn" href="#" data-options="plain:true" class="easyui-linkbutton">查询</a>
			<shiro:hasPermission name="rechargeController:apply">
				<a id="rechargeTable_apply_btn" href="#" data-options="plain:true" class="easyui-linkbutton">充值</a>
			</shiro:hasPermission>
			<shiro:hasPermission name="rechargeController:billing">
				<a id="rechargeTable_bill_btn" href="#" data-options="plain:true" class="easyui-linkbutton">确认</a>
			</shiro:hasPermission>
			<shiro:hasPermission name="rechargeController:delete">
				<a id="rechargeTable_delete_btn" href="#" data-options="plain:true" class="easyui-linkbutton">删除</a>
			</shiro:hasPermission>
		</div>
		<table id="rechargeTable"></table>
		<div id="rechargeTable_apply_window"></div>
		<div id="rechargeTable_bill_window"></div>
	</div>
	<div data-options="region:'south',split:true" style="height: 40%;">
		<table id="rechargeItemTable"></table>
	</div>
</body>
</html>