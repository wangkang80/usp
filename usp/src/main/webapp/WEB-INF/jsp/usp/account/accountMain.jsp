<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/WEB-INF/jsp/llsfw/base/head.jsp" />
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath}/static/usp/js/account/accountMain.js"></script>
<title>账户管理</title>
</head>
<body>
	<div id="accountTable_param" style="padding: 5px; height: auto;">
		<a id="accountTable_search_btn" href="#" data-options="plain:true" class="easyui-linkbutton">查询</a>
		<a id="accountTable_activate_btn" href="#" data-options="plain:true" class="easyui-linkbutton">激活</a>
		<a id="accountTable_freeze_btn" href="#" data-options="plain:true" class="easyui-linkbutton">冻结</a>
		<a id="accountTable_change_sms_channel_btn" href="#" data-options="plain:true" class="easyui-linkbutton">变更短信通道</a>
		<br />
		登陆名:
		<input type="text" id="loginNameSearch" name="loginNameSearch" size="15" />
		用户名:
		<input type="text" id="userNameSearch" name="userNameSearch" size="15" />
		是否激活:
		<input id="userActivateSearch" name="userActivateSearch" size="15" />
		短信通道:
		<input id="smsChannelSearch" name="smsChannelSearch" size="15" />
	</div>
	<table id="accountTable"></table>
	<div id="accountActivateWindow" style="padding: 15px;">
		<center>
			选择短信通道:
			<input id="user_sms_channel_combox" name="userSmsChannelCode" style="width: 230px;" />
			<p />
			<a id="accountTable_activate_save_btn" href="#" style="width: 150px;" class="easyui-linkbutton">确 认 激 活</a>
		</center>
	</div>
	<div id="accountChangeSmsChannelWindow" style="padding: 15px;">
		<center>
			选择短信通道:
			<input id="user_change_sms_channel_combox" name="userSmsChannelCode" style="width: 230px;" />
			<p />
			<a id="accountTable_change_sms_channel_save_btn" href="#" style="width: 150px;" class="easyui-linkbutton">确 认 变 更</a>
		</center>
	</div>
</body>
</html>