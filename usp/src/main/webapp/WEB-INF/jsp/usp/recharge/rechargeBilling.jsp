<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath}/static/usp/js/recharge/rechargeBilling.js"></script>
<form id="recharge_billing_form_add" name="recharge_billing_form_add" method="post">
	<input type="hidden" id="recharge_billing_recharge_code" name="rechargeCode" value="${r.rechargeCode}" />
	<table style="width: 100%">
		<tr>
			<td align="left">
				<strong>充值代码:</strong>
				${r.rechargeCode}

			</td>
			<td align="left">
				<strong>创建时间:</strong>
				<fmt:formatDate value="${r.createDate}" type="both" />
			</td>
		</tr>
		<tr>
			<td align="left">
				<strong>充值账号:</strong>
				${r.rechargeMan}
			</td>
			<td align="left">
				<strong>转账时间:</strong>
				<fmt:formatDate value="${r.bankTransferDate}" type="both" />
			</td>
		</tr>
		<tr>
			<td align="left">
				<strong>转账凭证:</strong>
				<a href="${pageContext.request.contextPath}/rechargeController/toRechargeBillPageDownload/${r.rechargeCode}">
					<font color="blue" style="text-decoration: underline">查看</font>
				</a>

			</td>
			<td align="left">
				<strong>清单金额:</strong>
				<label id="itemSumCount"></label>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<table id="recharge_billing_item_add_table"></table>
				<input id="rechargeBillingItemData" name="rechargeBillingItemData" type="hidden" />
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<a id="recharge_billing_item_add_btn" href="#">确认充值</a>
			</td>
		</tr>
	</table>
</form>