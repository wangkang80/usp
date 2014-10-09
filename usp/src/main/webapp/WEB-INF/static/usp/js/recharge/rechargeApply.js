/**
 * 
 */

$(function() {

	// 转账凭证
	$('#recharge_apply_btc_add').validatebox({
		required : true,
		validType : [ "length[1,250]", "not_chinese" ]
	});

	// 转账凭证
	$('#recharge_apply_btd_add').datetimebox({
		required : true,
		validType : [ "yyyymmddhhmiss" ],
		showSeconds : true
	});

	// 保存按钮
	$('#recharge_apply_item_add_btn').linkbutton({});
	$('#recharge_apply_item_add_btn').click(function() {

		// 获得数据
		endEditing();
		var dataArr = $('#recharge_apply_item_add_table').datagrid('getData').rows;

		// 计算总金额
		var totlesum = 0;
		for (var i = 0; i < dataArr.length; i++) {
			totlesum += parseInt(dataArr[i].SMS_TOTAL_PRICE);
		}

		// 如果单据金额为0,则不允许做后续操作
		if (totlesum <= 0) {
			showErrorMsg("单据金额为0");
			return;
		}

		// 填充数据
		var jsonData = JSON.stringify(dataArr);
		$('#rechargeApplyItemData').val(jsonData);

		$.messager.confirm('提示', '总金额为:' + totlesum + ',确认后点击确定提交.', function(r) {
			if (r) {
				// 表单操作
				$('#recharge_apply_form_add').attr('action', basePath + 'rechargeController/saveRechargeApply');
				$('#recharge_apply_form_add').form('submit', {
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
								$('#rechargeTable_apply_window').window('close');
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
	$('#recharge_apply_item_add_table').datagrid({
		title : '充值清单',
		url : basePath + 'rechargeController/loadBePrepaidList',
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
			width : 150
		}, {
			title : '当前短信数量',
			field : 'CURR_SMS_COUNT',
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
		} ] ],
		onClickRow : onClickRow,
		onEndEdit : function(rowIndex, rowData, changes) {
			// 计算预计数量,四舍五入
			rowData.SMS_PLAN_COUNT = Math.round(rowData.SMS_TOTAL_PRICE / rowData.SMS_UNIT_PRICE);
			$('#recharge_apply_item_add_table').datagrid('refreshRow', rowIndex);
		},
		onLoadError : function() {
			showErrorWindow('数据加载失败!');
		}
	});
	function endEditing() {
		if (editIndex == undefined) {
			return true;
		}
		if ($('#recharge_apply_item_add_table').datagrid('validateRow', editIndex)) {
			$('#recharge_apply_item_add_table').datagrid('endEdit', editIndex);
			editIndex = undefined;
			return true;
		} else {
			return false;
		}
	}
	function onClickRow(index) {
		if (editIndex != index) {
			if (endEditing()) {
				$('#recharge_apply_item_add_table').datagrid('selectRow', index).datagrid('beginEdit', index);
				editIndex = index;
			} else {
				$('#recharge_apply_item_add_table').datagrid('selectRow', editIndex);
			}
		}
	}
});