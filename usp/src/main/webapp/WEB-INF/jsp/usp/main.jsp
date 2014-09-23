<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath}/static/usp/js/main.js"></script>
<div id="userInfoTable_search">
	<a id="userInfoTable_search_activate" href="#" data-options="plain:true" class="easyui-linkbutton">激活账户</a>
	<a id="userInfoTable_search_displaySecretKey" href="#" data-options="plain:true" class="easyui-linkbutton">查看秘钥</a>
	<a id="userInfoTable_search_refresh" href="#" data-options="plain:true" class="easyui-linkbutton">刷新</a>
</div>
<table id="userInfoTable"></table>
<div id="displaySecretKey_window"></div>
<form style="display: none;" id="user_info_form_activate" name="user_info_form_activate" method="post"></form>