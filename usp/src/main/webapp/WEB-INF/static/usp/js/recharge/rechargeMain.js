/**
 * 
 */
$(function() {

	// 分页条数
	var rechargeTablePageSize = getServerParam(basePath, 'PAGE_SIZE');

	// 判断账户是否激活
	var checkActivate = false;
	$.ajax({
		type : 'POST',
		url : basePath + 'rechargeController/checkActivate',
		success : function(data) {
			// 解析数据
			var datas = strToJson(data);
			if (datas.returnCode == '1') {
				checkActivate = true;
			} else {
				checkActivate = false;
			}
		}
	});

	// 构造表格
	$('#rechargeTable').datagrid({
		title : '账户充值',
		url : basePath + 'rechargeController/loadRecharge',
		method : 'post',
		fit : true,
		rownumbers : true,
		singleSelect : true,
		pagination : true,
		pageSize : rechargeTablePageSize / 2,
		pageList : [ rechargeTablePageSize / 2, rechargeTablePageSize ],
		toolbar : '#rechargeTable_param',
		queryParams : {},
		columns : [ [ {
			title : '充值代码',
			field : 'RECHARGE_CODE',
			align : 'left',
			width : 60
		}, {
			title : '充值人',
			field : 'USER_NAME',
			align : 'left',
			width : 100
		}, {
			title : '所属机构',
			field : 'RECHARGE_MAN_ORG',
			align : 'left',
			width : 100
		}, {
			title : '转账凭证',
			field : 'BANK_TRANSFER_CERTIFICATE',
			align : 'left',
			width : 65,
			formatter : function(value, row, index) {
				var data = '<a href="' + basePath + 'rechargeController/toRechargeBillPageDownload/' + row.RECHARGE_CODE + '">';
				data += '<font color="blue" style="text-decoration: underline">查看</font>';
				data += '</a>';
				return data;
			}
		}, {
			title : '转账时间',
			field : 'BANK_TRANSFER_DATE',
			align : 'left',
			width : 100,
			formatter : function(value, row, index) {
				if (value) {
					var unixTimestamp = new Date(value);
					return unixTimestamp.toLocaleDateString();
				}
			}
		}, {
			title : '充值状态',
			field : 'RECHARGE_STATUS',
			align : 'left',
			width : 100,
			formatter : function(value, row, index) {
				if (value == 1) {
					return "待充值";
				} else if (value == 2) {
					return "已充值";
				} else {
					return "未知";
				}
			}
		}, {
			title : '总金额',
			field : 'SMS_TOTAL_PRICE',
			align : 'left',
			width : 100
		}, {
			title : '预计短信条数',
			field : 'SMS_PLAN_COUNT',
			align : 'left',
			width : 100
		}, {
			title : '实际短信条数',
			field : 'SMS_REAL_COUNT',
			align : 'left',
			width : 100
		}, {
			title : '确认人',
			field : 'RECHARGE_CHECK_MAN',
			align : 'left',
			width : 100
		}, {
			title : '确认时间',
			field : 'RECHARGE_CHECK_TIME',
			align : 'left',
			width : 100,
			formatter : function(value, row, index) {
				if (value) {
					var unixTimestamp = new Date(value);
					return unixTimestamp.toLocaleDateString();
				}
			}
		}, {
			title : '创建人',
			field : 'CREATE_BY',
			align : 'left',
			width : 100
		}, {
			title : '创建日期',
			field : 'CREATE_DATE',
			align : 'left',
			width : 100,
			formatter : function(value, row, index) {
				if (value) {
					var unixTimestamp = new Date(value);
					return unixTimestamp.toLocaleDateString();
				}
			}
		}, {
			title : '修改人',
			field : 'UPDATE_BY',
			align : 'left',
			width : 100
		}, {
			title : '修改日期',
			field : 'UPDATE_DATE',
			align : 'left',
			width : 100,
			formatter : function(value, row, index) {
				if (value) {
					var unixTimestamp = new Date(value);
					return unixTimestamp.toLocaleDateString();
				}
			}
		} ] ],
		onClickRow : function(rowIndex, rowData) {
			loadRechargeItemTable(rowData.RECHARGE_CODE);
		},
		onLoadSuccess : function(data) {
			loadRechargeItemTable('');
		},
		onLoadError : function() {
			showErrorWindow('数据加载失败!');
		}
	});

	// 查询按钮
	$('#rechargeTable_search_btn').click(function() {
		$('#rechargeTable').datagrid('reload');
	});

	// 充值按钮
	$('#rechargeTable_apply_btn').click(function() {
		if (checkActivate) {
			showInfoMsg("此账号未激活,请前往主页激活");
		} else {
			$('#rechargeTable_apply_window').window({
				title : '充值',
				collapsible : false,
				minimizable : false,
				maximizable : false,
				resizable : false,
				modal : true,
				width : 550,
				height : 500,
				href : basePath + 'rechargeController/toRechargeApplyPage',
				tools : [ {
					iconCls : 'icon-reload',
					handler : function() {
						$('#rechargeTable_apply_window').panel('refresh');
					}
				} ]
			});
		}
	});

	// 删除
	$('#rechargeTable_delete_btn').click(function() {
		var row = $('#rechargeTable').datagrid('getSelected');
		if (row) {
			if (row.RECHARGE_STATUS != "1") {
				showErrorMsg('只能删除为待充值的单据');
			} else {
				$.messager.confirm('提示', '是否要删除此单据?', function(r) {
					if (r) {
						$.ajax({
							type : 'POST',
							url : basePath + 'rechargeController/deleteRechargeItem?rechargeCode=' + row.RECHARGE_CODE,
							success : function(data) {
								// 解析数据
								var datas = strToJson(data);
								if (datas.returnCode == '1') {
									$('#rechargeTable_search_btn').click();
									showInfoMsg(datas.result);
								} else {
									showErrorMsg("删除失败");
								}
							}
						});
					}
				});
			}
		} else {
			showErrorMsg('请选择要删除的单据');
		}
	});

	// 确认按钮
	$('#rechargeTable_bill_btn').click(function() {
		if (checkActivate) {
			showInfoMsg("此账号未激活,请前往主页激活");
		} else {
			var row = $('#rechargeTable').datagrid('getSelected');
			if (row) {
				if (row.RECHARGE_STATUS != "1") {
					showErrorMsg('只能确认为待充值的单据');
				} else {
					$('#rechargeTable_bill_window').window({
						title : '确认',
						collapsible : false,
						minimizable : false,
						maximizable : false,
						resizable : false,
						modal : true,
						width : 550,
						height : 500,
						href : basePath + 'rechargeController/toRechargeBillPage?rechargeCode=' + row.RECHARGE_CODE,
						tools : [ {
							iconCls : 'icon-reload',
							handler : function() {
								$('#rechargeTable_bill_window').panel('refresh');
							}
						} ]
					});
				}
			} else {
				showErrorMsg('请选择要确认的单据');
			}
		}
	});

	// 加载明细表格
	function loadRechargeItemTable(rechargeCode) {
		$('#rechargeItemTable').datagrid({
			url : basePath + 'rechargeController/loadRechargeItem?rechargeCode=' + rechargeCode
		});
	}

	// 构造表格
	$('#rechargeItemTable').datagrid({
		title : '明细',
		method : 'post',
		fit : true,
		rownumbers : true,
		singleSelect : true,
		pagination : false,
		queryParams : {},
		columns : [ [ {
			title : '充值代码',
			field : 'RECHARGE_CODE',
			align : 'left',
			width : 60
		}, {
			title : '被充值人',
			field : 'BE_PREPAID_NAME',
			align : 'left',
			width : 100
		}, {
			title : '充值状态',
			field : 'RECHARGE_STATUS',
			align : 'left',
			width : 100,
			formatter : function(value, row, index) {
				if (value == 1) {
					return "待充值";
				} else if (value == 2) {
					return "已充值";
				} else {
					return "未知";
				}
			}
		}, {
			title : '金额',
			field : 'SMS_TOTAL_PRICE',
			align : 'left',
			width : 100
		}, {
			title : '单价',
			field : 'SMS_UNIT_PRICE',
			align : 'left',
			width : 100
		}, {
			title : '预计短信条数',
			field : 'SMS_PLAN_COUNT',
			align : 'left',
			width : 100
		}, {
			title : '实际短信条数',
			field : 'SMS_REAL_COUNT',
			align : 'left',
			width : 100
		}, {
			title : '充值前数量',
			field : 'SMS_BFORE_COUNT',
			align : 'left',
			width : 100
		}, {
			title : '充值后数量',
			field : 'SMS_AFTER_COUNT',
			align : 'left',
			width : 100
		}, {
			title : '充值时间',
			field : 'SMS_RECHARGE_DATE',
			align : 'left',
			width : 100,
			formatter : function(value, row, index) {
				if (value) {
					var unixTimestamp = new Date(value);
					return unixTimestamp.toLocaleDateString();
				}
			}
		}, {
			title : '创建人',
			field : 'CREATE_BY',
			align : 'left',
			width : 100
		}, {
			title : '创建日期',
			field : 'CREATE_DATE',
			align : 'left',
			width : 100,
			formatter : function(value, row, index) {
				if (value) {
					var unixTimestamp = new Date(value);
					return unixTimestamp.toLocaleDateString();
				}
			}
		}, {
			title : '修改人',
			field : 'UPDATE_BY',
			align : 'left',
			width : 100
		}, {
			title : '修改日期',
			field : 'UPDATE_DATE',
			align : 'left',
			width : 100,
			formatter : function(value, row, index) {
				if (value) {
					var unixTimestamp = new Date(value);
					return unixTimestamp.toLocaleDateString();
				}
			}
		} ] ],
		onClickRow : function(rowIndex, rowData) {

		},
		onLoadError : function() {
			showErrorWindow('数据加载失败!');
		}
	});
});