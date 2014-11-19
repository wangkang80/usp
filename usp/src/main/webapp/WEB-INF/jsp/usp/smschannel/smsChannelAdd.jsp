<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath}/static/usp/js/smschannel/smsChannelAdd.js"></script>
<form id="sms_channel_form_add" name="sms_channel_form_add" method="post">
	<table>
		<tr>
			<td width="60px" align="right">通道代码:</td>
			<td>
				<input id="sms_channel_code_add" name="channelCode" style="width: 250px;" />
			</td>
		</tr>
		<tr>
			<td align="right">通道名称:</td>
			<td>
				<input id="sms_channel_name_add" name="channelName" style="width: 250px;" />
			</td>
		</tr>
		<tr>
			<td align="right">通道地址:</td>
			<td>
				<input id="sms_channel_host_add" name="channelHost" style="width: 250px;" />
			</td>
		</tr>
		<tr>
			<td align="right">用户名:</td>
			<td>
				<input id="sms_channel_user_name_add" name="channelUserName" style="width: 250px;" />
			</td>
		</tr>
		<tr>
			<td align="right">密码:</td>
			<td>
				<input id="sms_channel_password_add" name="channelPassword" style="width: 250px;" />
			</td>
		</tr>
		<tr>
			<td align="right">秘钥:</td>
			<td>
				<input id="sms_channel_secret_key_add" name="channelSecretKey" style="width: 250px;" />
			</td>
		</tr>
		<tr>
			<td align="right">单价:</td>
			<td>
				<input id="sms_channel_price_add" name="channelPrice" style="width: 250px;" />
			</td>
		</tr>
	</table>
	<center style="margin: 5px;">
		<a id="sms_channel_add_btn" href="#">保存</a>
	</center>
</form>