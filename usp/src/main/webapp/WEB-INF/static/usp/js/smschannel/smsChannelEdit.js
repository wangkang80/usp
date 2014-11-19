/**
 * 
 */
$(function() {

	$('#sms_channel_form_edit').form({
		onLoadSuccess : function(data) { // 加载完毕后在格式化表单

			// 加载数据
			$('#sms_channel_name_edit').val(data.channelName);
			$('#sms_channel_host_edit').val(data.channelHost);
			$('#sms_channel_user_name_edit').val(data.channelUserName);
			$('#sms_channel_password_edit').val(data.channelPassword);
			$('#sms_channel_secret_key_edit').val(data.channelSecretKey);
			$('#sms_channel_price_edit').val(data.channelPrice);

			// 格式化表单------------------------------------

			// 通道名称
			$('#sms_channel_name_edit').validatebox({
				required : true,
				validType : [ "length[1,30]" ]
			});

			// 通道地址
			$('#sms_channel_host_edit').validatebox({
				required : true,
				validType : [ "length[1,800]" ]
			});

			// 用户名
			$('#sms_channel_user_name_edit').validatebox({
				required : true,
				validType : [ "length[1,100]", "not_chinese" ]
			});

			// 密码
			$('#sms_channel_password_edit').validatebox({
				required : true,
				validType : [ "length[1,100]", "not_chinese" ]
			});

			// 秘钥
			$('#sms_channel_secret_key_edit').validatebox({
				required : true,
				validType : [ "length[1,100]", "not_chinese" ]
			});

			// 单价
			$('#sms_channel_price_edit').numberbox({
				required : true,
				min : 0,
				max : 9999,
				precision : 4
			});

			// 保存按钮
			$('#sms_channel_edit_btn').linkbutton({});

			// 绑定保存按钮事件
			$('#sms_channel_edit_btn').click(function() {
				save();
			});
		}
	});

	// 加载表单数据
	$('#sms_channel_form_edit')
			.form('load', basePath + 'smsChannelController/loadChannel?channelCode=' + $('#sms_channel_code_edit').val());

	// 保存方法
	function save() {
		$('#sms_channel_form_edit').attr('action', basePath + 'smsChannelController/editSmsChannel');
		// 提交
		$('#sms_channel_form_edit').form('submit', {
			onSubmit : function() {// 提交前置事件
				var isValid = $(this).form('validate');
				if (isValid) {// 验证通过,弹出遮罩
					$.messager.progress({
						text : '保存中...',
						interval : 200
					});
				}
				return isValid;
			},
			success : function(data) {
				try {
					// 关闭遮罩
					$.messager.progress('close');

					// 解析数据
					var datas = strToJson(data);

					if (datas.returnCode == '1') {
						$('#smsChannel_edit_window').window('close');
						$('#smsChannelTable_search_btn').click();
					} else {
						showErrorMsg(datas.result);
					}
				} catch (e) {
					showErrorWindow(data);
				}

			}
		});
	}
});
