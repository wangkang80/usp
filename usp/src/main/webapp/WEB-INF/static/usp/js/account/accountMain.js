/**
 * 
 */
$(function() {

	// 是否激活
	$('#userActivateSearch').combobox({
		data : [ {
			label : '全部',
			value : ''
		}, {
			label : '已激活',
			value : '1'
		}, {
			label : '未激活',
			value : '2'
		} ],
		valueField : 'value',
		textField : 'label',
		editable : false,
		onSelect : function(record) {
			$('#accountTable_search_btn').click();
		},
		onLoadSuccess : function() { // 加载完成后,设置选中第一项
			var val = $(this).combobox("getData");
			for ( var item in val[0]) {
				if (item == "value") {
					$(this).combobox("select", val[0][item]);
					break;
				}
			}
		}
	});

	// 通道列表
	$('#smsChannelSearch').combobox({
		url : basePath + 'accountController/loadSmsChannelListSearch',
		method : 'get',
		valueField : 'channelCode',
		textField : 'channelName',
		editable : false,
		onSelect : function(record) {
			$('#accountTable_search_btn').click();
		},
		onLoadSuccess : function() { // 加载完成后,设置选中第一项
			var val = $(this).combobox("getData");
			for ( var item in val[0]) {
				if (item == "channelCode") {
					$(this).combobox("select", val[0][item]);
					break;
				}
			}
		}
	});

	// 分页条数
	var accountTablePageSize = getServerParam(basePath, 'PAGE_SIZE');

	// 构造表格
	$('#accountTable').datagrid({
		title : '账户列表',
		url : basePath + 'accountController/loadAccountList',
		method : 'post',
		fit : true,
		rownumbers : true,
		singleSelect : true,
		pagination : true,
		pageSize : accountTablePageSize / 2,
		pageList : [ accountTablePageSize / 2, accountTablePageSize ],
		toolbar : '#accountTable_param',
		queryParams : {},
		columns : [ [ {
			title : '登录名',
			field : 'LOGIN_NAME',
			align : 'left',
			width : 100
		}, {
			title : '用户名',
			field : 'USER_NAME',
			align : 'left',
			width : 100
		}, {
			title : '是否激活',
			field : 'TU_LOGIN_NAME',
			align : 'left',
			width : 100,
			formatter : function(value, row, index) {
				if (value) {
					return '是';
				} else {
					return '否';
				}
			}
		}, {
			title : '短信通道名称',
			field : 'CHANNEL_NAME',
			align : 'left',
			width : 100
		}, {
			title : '剩余短信条数',
			field : 'LAST_SMS_COUNT',
			align : 'left',
			width : 100
		}, {
			title : '激活人',
			field : 'CREATE_BY',
			align : 'left',
			width : 100
		}, {
			title : '激活时间',
			field : 'CREATE_DATE',
			align : 'left',
			width : 100,
			formatter : function(value, row, index) {
				if (value) {
					var unixTimestamp = new Date(value);
					return unixTimestamp.toLocaleDateString();
				}
			}
		} ] ],
		onLoadError : function() {
			showErrorWindow('数据加载失败!');
		}
	});

	// 查询按钮
	$('#accountTable_search_btn').click(function() {
		$('#accountTable').datagrid('load', {
			loginName : $('#loginNameSearch').val(),
			userName : $('#userNameSearch').val(),
			userActivateSearch : $('#userActivateSearch').combobox('getValue'),
			smsChannelSearch : $('#smsChannelSearch').combobox('getValue'),
		});
	});

	// 绑定查询按钮
	$('#loginNameSearch,#userNameSearch').keydown(function(e) {
		if (e.keyCode == 13) {
			$('#accountTable_search_btn').click();
		}
	});

	// 变更短信通道
	$('#accountTable_change_sms_channel_btn').click(function() {
		var row = $('#accountTable').datagrid('getSelected');
		if (row) {
			if (row.TU_LOGIN_NAME) {
				$('#user_change_sms_channel_combox').combobox('reload', basePath + 'accountController/loadSmsChannelList');
				$('#user_change_sms_channel_combox').combobox("select", row.CHANNEL_CODE);
				$('#accountChangeSmsChannelWindow').window({
					title : '激活账户[' + row.USER_NAME + '(' + row.LOGIN_NAME + ')]',
					collapsible : false,
					minimizable : false,
					maximizable : false,
					resizable : false,
					modal : true,
					width : 370,
					height : 150
				});
			} else {
				showErrorMsg('账户未激活');
			}
		} else {
			showErrorMsg('请选择要激活的用户');
		}
	});

	// 通道列表
	$('#user_change_sms_channel_combox').combobox({
		required : true,
		method : 'get',
		valueField : 'channelCode',
		textField : 'channelName',
		editable : false,
		onLoadSuccess : function() { // 加载完成后,设置选中第一项
			var val = $(this).combobox("getData");
			for ( var item in val[0]) {
				if (item == "channelCode") {
					$(this).combobox("select", val[0][item]);
					break;
				}
			}
		}
	});

	// 确认变更
	$('#accountTable_change_sms_channel_save_btn').click(function() {
		// 收集数据
		var loginName = $('#accountTable').datagrid('getSelected').LOGIN_NAME;
		var channelCode = $('#user_change_sms_channel_combox').combobox('getValue');
		if (!loginName) {
			showErrorMsg('请选择用户');
			return;
		}
		if (!channelCode) {
			showErrorMsg('请选择短信通道');
			return;
		}
		// 开始激活
		$.ajax({
			type : 'POST',
			url : basePath + 'accountController/changeUserSmsChannel?loginName=' + loginName + '&channelCode=' + channelCode,
			success : function(data) {
				// 解析数据
				var datas = strToJson(data);
				if (datas.returnCode == '1') {
					$('#accountChangeSmsChannelWindow').window('close');
					$('#accountTable').datagrid('load');
				} else {
					showErrorMsg('变更失败');
				}
			}
		});
	});

	// 激活
	$('#accountTable_activate_btn').click(function() {
		var row = $('#accountTable').datagrid('getSelected');
		if (row) {
			if (!row.TU_LOGIN_NAME) {
				$('#user_sms_channel_combox').combobox('reload', basePath + 'accountController/loadSmsChannelList');
				$('#accountActivateWindow').window({
					title : '激活账户[' + row.USER_NAME + '(' + row.LOGIN_NAME + ')]',
					collapsible : false,
					minimizable : false,
					maximizable : false,
					resizable : false,
					modal : true,
					width : 370,
					height : 150
				});
			} else {
				showErrorMsg('账户已经激活');
			}
		} else {
			showErrorMsg('请选择要激活的用户');
		}
	});

	// 通道列表
	$('#user_sms_channel_combox').combobox({
		required : true,
		method : 'get',
		valueField : 'channelCode',
		textField : 'channelName',
		editable : false,
		onLoadSuccess : function() { // 加载完成后,设置选中第一项
			var val = $(this).combobox("getData");
			for ( var item in val[0]) {
				if (item == "channelCode") {
					$(this).combobox("select", val[0][item]);
					break;
				}
			}
		}
	});

	// 确认激活
	$('#accountTable_activate_save_btn').click(function() {
		// 收集数据
		var loginName = $('#accountTable').datagrid('getSelected').LOGIN_NAME;
		var channelCode = $('#user_sms_channel_combox').combobox('getValue');
		if (!loginName) {
			showErrorMsg('请选择要激活的用户');
			return;
		}
		if (!channelCode) {
			showErrorMsg('请选择短信通道');
			return;
		}
		// 开始激活
		$.ajax({
			type : 'POST',
			url : basePath + 'accountController/userActivate?loginName=' + loginName + '&channelCode=' + channelCode,
			success : function(data) {
				// 解析数据
				var datas = strToJson(data);
				if (datas.returnCode == '1') {
					$('#accountActivateWindow').window('close');
					$('#accountTable').datagrid('load');
				} else {
					showErrorMsg('激活失败');
				}
			}
		});
	});

	// 冻结
	$('#accountTable_freeze_btn').click(function() {
		var row = $('#accountTable').datagrid('getSelected');
		if (row) {
			if (row.TU_LOGIN_NAME) {
				$.messager.confirm('警告', '冻结用户将会清空剩余短信条数,请确认是否要操作?', function(r) {
					if (r) {
						$.ajax({
							type : 'POST',
							url : basePath + 'accountController/userFreeze?loginName=' + row.LOGIN_NAME,
							success : function(data) {
								// 解析数据
								var datas = strToJson(data);
								if (datas.returnCode == '1') {
									$('#accountTable').datagrid('reload');
								} else {
									showErrorMsg("删除失败");
								}
							}
						});
					}
				});
			} else {
				showErrorMsg('账户已经冻结');
			}
		} else {
			showErrorMsg('请选择要冻结的用户');
		}
	});

});