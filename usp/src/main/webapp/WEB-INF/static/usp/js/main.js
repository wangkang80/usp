/**
 * 
 */
$(function() {
	// 构造表格
	$('#userInfoTable').datagrid({
		title : '用户信息',
		url : basePath + 'uspMainController/loadUserInfo',
		method : 'post',
		fit : true,
		singleSelect : true,
		toolbar : '#userInfoTable_search',
		columns : [ [ {
			title : '接口密码',
			field : 'INTERFACE_PASSWORD',
			align : 'left',
			width : 100,
			formatter : function(value, row, index) {
				return "●●●●●●●●●●";
			}
		}, {
			title : '接口秘钥',
			field : 'INTERFACE_SECRET_KEY',
			align : 'left',
			width : 100,
			formatter : function(value, row, index) {
				return "●●●●●●●●●●";
			}
		}, {
			title : '所属短信通道',
			field : 'CHANNEL_NAME',
			align : 'left',
			width : 100
		}, {
			title : '剩余短信数量',
			field : 'LAST_SMS_COUNT',
			align : 'left',
			width : 100
		} ] ],
		onLoadSuccess : function(data) {
		},
		onLoadError : function() {
			showErrorWindow('数据加载失败!');
		}
	});

	// 刷新按钮
	$('#userInfoTable_search_refresh').click(function() {
		$('#userInfoTable').datagrid('reload');
	});

	// 查看秘钥
	$('#userInfoTable_search_displaySecretKey').click(function() {
		if ($('#userInfoTable').datagrid('getRows').length <= 0) {
			showErrorMsg('账号还未激活');
		} else {
			$('#displaySecretKey_window').window({
				title : '查看秘钥',
				collapsible : false,
				minimizable : false,
				maximizable : false,
				resizable : false,
				modal : true,
				width : 250,
				height : 150,
				href : basePath + 'uspMainController/toChangeSecretKey'
			});
		}
	});
});