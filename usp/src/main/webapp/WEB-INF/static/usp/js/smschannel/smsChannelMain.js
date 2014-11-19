/**
 * 
 */
$(function() {

	// 构造表格
	$('#smsChannelTable').datagrid({
		title : '短信通道配置',
		url : basePath + 'smsChannelController/loadSmsChannel',
		method : 'post',
		fit : true,
		rownumbers : true,
		singleSelect : true,
		pagination : false,
		toolbar : '#smsChannelTable_param',
		queryParams : {},
		columns : [ [ {
			title : '通道代码',
			field : 'channelCode',
			align : 'left',
			width : 100
		}, {
			title : '通道名称',
			field : 'channelName',
			align : 'left',
			width : 100
		}, {
			title : '通道地址',
			field : 'channelHost',
			align : 'left',
			width : 300
		}, {
			title : '用户名',
			field : 'channelUserName',
			align : 'left',
			width : 100
		}, {
			title : '密码',
			field : 'channelPassword',
			align : 'left',
			width : 100
		}, {
			title : '秘钥',
			field : 'channelSecretKey',
			align : 'left',
			width : 100
		}, {
			title : '单价',
			field : 'channelPrice',
			align : 'left',
			width : 60
		}, {
			title : '创建人',
			field : 'createBy',
			align : 'left',
			width : 100
		}, {
			title : '创建日期',
			field : 'createDate',
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
			field : 'updateBy',
			align : 'left',
			width : 100
		}, {
			title : '修改日期',
			field : 'updateDate',
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
			$.ajax({
				type : 'POST',
				url : basePath + 'smsChannelController/loadChannelSmsCount?channelCode=' + rowData.channelCode,
				success : function(data) {
					// 解析数据
					var datas = strToJson(data);
					if (datas.returnCode == '1') {
						$('#userSmsCount').html('剩余短信' + datas.result.split(',')[1] + '条');
					} else {
						$('#userSmsCount').html('查询失败');
					}
				}
			});
		},
		onLoadError : function() {
			showErrorWindow('数据加载失败!');
		}
	});

	// 查询按钮
	$('#smsChannelTable_search_btn').click(function() {
		$('#smsChannelTable').datagrid('reload');
	});

	// 新增
	$('#smsChannelTable_add_btn').click(function() {
		$('#smsChannel_add_window').window({
			title : '新增短信通道',
			collapsible : false,
			minimizable : false,
			maximizable : false,
			resizable : false,
			modal : true,
			width : 350,
			height : 300,
			href : basePath + 'smsChannelController/toSmsChannelAdd'
		});
	});

	// 修改
	$('#smsChannelTable_edit_btn').click(function() {
		var row = $('#smsChannelTable').datagrid('getSelected');
		if (row) {
			$('#smsChannel_edit_window').window({
				title : '修改短信通道',
				collapsible : false,
				minimizable : false,
				maximizable : false,
				resizable : false,
				modal : true,
				width : 350,
				height : 300,
				href : basePath + 'smsChannelController/toSmsChannelEdit?channelCode=' + row.channelCode
			});
		} else {
			showErrorMsg('请选择要修改的数据');
		}
	});

	// 删除
	$('#smsChannelTable_delete_btn').click(function() {
		var row = $('#smsChannelTable').datagrid('getSelected');
		if (row) {
			$.messager.confirm('警告', '请确认是否删除?', function(r) {
				if (r) {
					$.ajax({
						type : 'POST',
						url : basePath + 'smsChannelController/deleteChannel?channelCode=' + row.channelCode,
						success : function(data) {
							// 解析数据
							var datas = strToJson(data);
							if (datas.returnCode == '1') {
								$('#smsChannelTable_search_btn').click();
							} else {
								showErrorMsg(datas.result);
							}
						}
					});
				}
			});
		} else {
			showErrorMsg('请选择要删除的数据');
		}
	});
});