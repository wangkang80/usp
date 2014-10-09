/**
 * 
 */

$(function() {

	//

	// 计算总金额
	function sumCount() {
		var dataArr = $('#recharge_billing_item_add_table').datagrid('getData').rows;

		// 计算总金额
		var totlesum = 0;
		for (var i = 0; i < dataArr.length; i++) {
			totlesum += parseInt(dataArr[i].SMS_TOTAL_PRICE);
		}
		$('#itemSumCount').text(totlesum);
	}

	// 保存按钮
	$('#recharge_billing_item_add_btn').linkbutton({});
	$('#recharge_billing_item_add_btn').click(function() {

		// 获得数据
		endEditing();
		var dataArr = $('#recharge_billing_item_add_table').datagrid('getData').rows;

		// 计算总金额
		var totlesum = 0;
		for (var i = 0; i < dataArr.length; i++) {
			totlesum += parseInt(dataArr[i].SMS_TOTAL_PRICE);
			if (dataArr[i].SMS_REAL_COUNT) {
				if (dataArr[i].SMS_REAL_COUNT < dataArr[i].SMS_PLAN_COUNT) {
					$('#recharge_billing_item_add_table').datagrid('selectRow', i);
					showErrorMsg("实际短信条数不能小于预计短信条数");
					return;
				}
			}
		}

		// 如果单据金额为0,则不允许做后续操作
		if (totlesum <= 0) {
			showErrorMsg("单据金额为0");
			return;
		}

		// 填充数据
		var jsonData = JSON.stringify(dataArr);
		$('#rechargeBillingItemData').val(jsonData);

		$.messager.confirm('提示', '总金额为:' + totlesum + ',如果无误的话请点击确定.', function(r) {
			if (r) {
				// 表单操作
				$('#recharge_billing_form_add').attr('action', basePath + 'rechargeController/saveRechargeBilling');
				$('#recharge_billing_form_add').form('submit', {
					onSubmit : function() {// 提交前置事件
						var isValid = $(this).form('validate');
						if (isValid) {// 验证通过,弹出遮罩
							$.messager.progress({
								text : '保存中...',
								interval : 200
							});
						}
						return isValid; // return false will stop the form
						// submission
					},
					success : function(data) {
						try {
							// 关闭遮罩
							$.messager.progress('close');

							// 解析数据
							var datas = strToJson(data);

							if (datas.returnCode == '1') {
								$('#rechargeTable_bill_window').window('close');
								$('#rechargeTable_search_btn').click();
								showInfoMsg(datas.result);
							} else if (datas.returnCode == '-1') {
								showErrorMsg(datas.result);
							}
						} catch (e) {
							showErrorWindow(data);
						}
					}
				});
			}
		});
	});

	// 构造表格
	var editIndex = undefined;
	$('#recharge_billing_item_add_table').datagrid({
		title : '充值清单',
		url : basePath + 'rechargeController/loadRechargeItem?rechargeCode=' + $('#recharge_billing_recharge_code').val(),
		method : 'post',
		height : '340px',
		rownumbers : false,
		singleSelect : true,
		pagination : false,
		queryParams : {},
		columns : [ [ {
			title : '被充值人',
			field : 'BE_PREPAID_NAME',
			align : 'left',
			width : 100
		}, {
			title : '金额',
			field : 'SMS_TOTAL_PRICE',
			align : 'left',
			width : 100,
			editor : {
				type : 'numberbox',
				options : {
					min : 0,
					required : true
				}
			}
		}, {
			title : '单价',
			field : 'SMS_UNIT_PRICE',
			align : 'left',
			width : 40
		}, {
			title : '预计短信条数',
			field : 'SMS_PLAN_COUNT',
			align : 'left',
			width : 100
		}, {
			title : '实际短信条数',
			field : 'SMS_REAL_COUNT',
			align : 'left',
			width : 100,
			editor : {
				type : 'numberbox',
				options : {
					min : 0,
					required : false
				}
			}
		} ] ],
		onLoadSuccess : function(data) {
			sumCount();
		},
		onClickRow : onClickRow,
		onEndEdit : function(rowIndex, rowData, changes) {
			// 计算预计数量,四舍五入
			rowData.SMS_PLAN_COUNT = Math.round(rowData.SMS_TOTAL_PRICE / rowData.SMS_UNIT_PRICE);
			$('#recharge_billing_item_add_table').datagrid('refreshRow', rowIndex);
			sumCount();
		},
		onLoadError : function() {
			showErrorWindow('数据加载失败!');
		}
	});
	function endEditing() {
		if (editIndex == undefined) {
			return true;
		}
		if ($('#recharge_billing_item_add_table').datagrid('validateRow', editIndex)) {
			$('#recharge_billing_item_add_table').datagrid('endEdit', editIndex);
			editIndex = undefined;
			return true;
		} else {
			return false;
		}
	}
	function onClickRow(index) {
		if (editIndex != index) {
			if (endEditing()) {
				$('#recharge_billing_item_add_table').datagrid('selectRow', index).datagrid('beginEdit', index);
				editIndex = index;
			} else {
				$('#recharge_billing_item_add_table').datagrid('selectRow', editIndex);
			}
		}
	}
});