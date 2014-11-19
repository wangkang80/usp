<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/WEB-INF/jsp/llsfw/base/head.jsp" />
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath}/static/usp/js/smschannel/smsChannelMain.js"></script>
<title>短信通道配置</title>
</head>
<body>
	<div id="smsChannelTable_param" style="padding: 5px; height: auto;">
		<a id="smsChannelTable_search_btn" href="#" data-options="plain:true" class="easyui-linkbutton">查询</a>
		<a id="smsChannelTable_add_btn" href="#" data-options="plain:true" class="easyui-linkbutton">新增</a>
		<a id="smsChannelTable_edit_btn" href="#" data-options="plain:true" class="easyui-linkbutton">修改</a>
		<a id="smsChannelTable_delete_btn" href="#" data-options="plain:true" class="easyui-linkbutton">删除</a>
		<a id="userSmsCount" href="#" data-options="plain:true" class="easyui-linkbutton"></a>
	</div>
	<table id="smsChannelTable"></table>
	<div id="smsChannel_add_window"></div>
	<div id="smsChannel_edit_window"></div>
</body>
</html>