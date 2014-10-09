<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath}/static/usp/js/recharge/rechargeApply.js"></script>
<form id="recharge_apply_form_add" name="recharge_apply_form_add" method="post" enctype="multipart/form-data">
	<table style="width: 100%">
		<tr>
			<td>转账凭证:</td>
			<td>
				<input id="recharge_apply_btc_add" name="btc" type="file" style="width: 340px;" />
			</td>
		</tr>
		<tr>
			<td>转账时间:</td>
			<td>
				<input id="recharge_apply_btd_add" name="btd" type="text" style="width: 340px;" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<table id="recharge_apply_item_add_table"></table>
				<input id="rechargeApplyItemData" name="rechargeApplyItemData" type="hidden" />
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<a id="recharge_apply_item_add_btn" href="#">提交充值</a>
			</td>
		</tr>
	</table>
</form>