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
			title : '接口秘钥',
			field : 'interfaceSecretKey',
			align : 'left',
			width : 100,
			formatter : function(value, row, index) {
				return "●●●●●●●●●●";
			}
		}, {
			title : '剩余短信数量',
			field : 'lastSmsCount',
			align : 'left',
			width : 100
		} ] ],
		onLoadSuccess : function(data) {
			// 如果已经有数据了,则隐藏掉[激活]按钮,如果没有数据,则显示[激活]按钮
			initActivateBtn(data);
		},
		onLoadError : function() {
			showErrorWindow('数据加载失败!');
		}
	});

	// 刷新按钮
	$('#userInfoTable_search_refresh').click(function() {
		$('#userInfoTable').datagrid('reload');
	});

	// 初始化[激活用户]按钮
	function initActivateBtn(data) {
		$("#userInfoTable_search_activate").unbind("click");
		$("#userInfoTable_search_displaySecretKey").unbind("click");
		if (data.rows.length > 0) {
			$('#userInfoTable_search_activate').linkbutton({
				disabled : true
			});
			$('#userInfoTable_search_displaySecretKey').linkbutton({
				disabled : false
			});
			$('#userInfoTable_search_displaySecretKey').click(displaySecretKeyClick);

		} else {
			$('#userInfoTable_search_displaySecretKey').linkbutton({
				disabled : true
			});
			$('#userInfoTable_search_activate').linkbutton({
				disabled : false
			});
			$('#userInfoTable_search_activate').click(activateClick);
		}
	}

	// 查看秘钥
	function displaySecretKeyClick() {
		$('#displaySecretKey_window').window({
			title : '查看秘钥',
			collapsible : false,
			minimizable : false,
			maximizable : false,
			resizable : false,
			modal : true,
			width : 250,
			height : 120,
			href : basePath + 'uspMainController/toChangeSecretKey'
		});
	}

	// 激活按钮click事件
	function activateClick() {
		// 提交
		$('#user_info_form_activate').attr('action', basePath + 'uspMainController/userInfoActivate');
		$('#user_info_form_activate').form('submit', {
			onSubmit : function() {// 提交前置事件
				var isValid = $(this).form('validate');
				if (isValid) {// 验证通过,弹出遮罩
					$.messager.progress({
						text : '激活中...',
						interval : 200
					});
				}
				return isValid; // return false will stop the form submission
			},
			success : function(data) {
				try {
					// 关闭遮罩
					$.messager.progress('close');

					// 解析数据
					var datas = strToJson(data);
					if (datas.returnCode == '1') {
						$('#userInfoTable_search_refresh').click();
						showInfoMsg(datas.result);
					} else {
						// 弹出提示
						showErrorMsg(datas.result);
					}
				} catch (e) {
					showErrorWindow(data);
				}
			}
		});
	}
});