/**
 * 
 */
$(function() {

	// 通道代码
	$('#sms_channel_code_add').validatebox({
		required : true,
		validType : [ "length[1,100]", "not_chinese", "remote[basePath + 'smsChannelController/channelCodeUniqueCheck', 'channelCode']" ]
	});

	// 通道名称
	$('#sms_channel_name_add').validatebox({
		required : true,
		validType : [ "length[1,30]" ]
	});

	// 通道地址
	$('#sms_channel_host_add').validatebox({
		required : true,
		validType : [ "length[1,800]" ]
	});

	// 用户名
	$('#sms_channel_user_name_add').validatebox({
		required : true,
		validType : [ "length[1,100]", "not_chinese" ]
	});

	// 密码
	$('#sms_channel_password_add').validatebox({
		required : true,
		validType : [ "length[1,100]", "not_chinese" ]
	});

	// 秘钥
	$('#sms_channel_secret_key_add').validatebox({
		required : true,
		validType : [ "length[1,100]", "not_chinese" ]
	});

	// 单价
	$('#sms_channel_price_add').numberbox({
		required : true,
		min : 0,
		max : 9999,
		precision : 4
	});

	// 保存按钮
	$('#sms_channel_add_btn').linkbutton({});

	// 绑定保存按钮事件
	$('#sms_channel_add_btn').click(function() {
		save();
	});

	// 保存方法
	function save() {
		$('#sms_channel_form_add').attr('action', basePath + 'smsChannelController/addSmsChannel');
		// 提交
		$('#sms_channel_form_add').form('submit', {
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
						$('#smsChannel_add_window').window('close');
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
