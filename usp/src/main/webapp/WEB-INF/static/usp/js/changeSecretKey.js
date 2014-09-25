/**
 * 
 */
$(function() {
	$('#interface_SecretKey_form_edit').form({
		onLoadSuccess : function(data) { // 加载完毕后在格式化表单
			// 加载数据
			$('#interface_pswd_edit').val(data.interfacePassword);
			$('#interface_SecretKey_edit').val(data.interfaceSecretKey);

			// 格式化表单------------------------------------

			// 接口密码
			$('#interface_pswd_edit').validatebox({
				required : true,
				validType : [ "length[8,17]", "not_chinese" ]
			});

			// 接口秘钥
			$('#interface_SecretKey_edit').validatebox({
				required : true,
				validType : [ "length[8,17]", "not_chinese" ]
			});

			// 保存按钮
			$('#interface_SecretKey_edit_btn').linkbutton({});

			// 绑定保存按钮事件
			$('#interface_SecretKey_edit_btn').click(function() {
				save();
			});
		}
	});

	// 加载表单数据
	$('#interface_SecretKey_form_edit').form('load', basePath + 'uspMainController/loadTuUser');

	// 保存方法
	function save() {
		$('#interface_SecretKey_form_edit').attr('action', basePath + 'uspMainController/editSecretKey');
		// 提交
		$('#interface_SecretKey_form_edit').form('submit', {
			onSubmit : function() {// 提交前置事件
				var isValid = $(this).form('validate');
				if (isValid) {// 验证通过,弹出遮罩
					$.messager.progress({
						text : '保存中...',
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
						$('#displaySecretKey_window').window('close');
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