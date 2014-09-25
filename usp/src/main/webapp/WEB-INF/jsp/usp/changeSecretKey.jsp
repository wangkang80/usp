<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath}/static/usp/js/changeSecretKey.js"></script>
<form id="interface_SecretKey_form_edit" name="interface_SecretKey_form_edit" method="post">
	<table>
		<tr>
			<td>接口密码:</td>
			<td colspan="3">
				<input id="interface_pswd_edit" name="interfacePswd" style="width: 150px;" />
			</td>
		</tr>
		<tr>
			<td>接口秘钥:</td>
			<td colspan="3">
				<input id="interface_SecretKey_edit" name="secretKey" style="width: 150px;" />
			</td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<a id="interface_SecretKey_edit_btn" href="#">保存</a>
			</td>
		</tr>
	</table>
</form>