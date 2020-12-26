$.extend($.fn.textbox.defaults.rules, {
    number : {
        validator : function(value, param) {
            return /^[0-9]*$/.test(value);
        },
        message : "请输入数字"
    },
    chinese : {
        validator : function(value, param) {
            var reg = /^[\u4e00-\u9fa5]+$/i;
            return reg.test(value);
        },
        message : "请输入中文"
    },
    checkLength: {
        validator: function(value, param){
            return param[0] >= get_length(value);
        },
        message: '请输入最大{0}位字符'
    },
    specialChar: {
        validator: function(value, param){
            var reg = new RegExp("[`~!@#$^&*()=|{}':;'\\[\\]<>~！@#￥……&*（）——|{}【】‘；：”“'、？]");
            return !reg.test(value);
        },
        message: '不允许输入特殊字符'
    },
    englishLowerCase  : {// 验证英语小写
        validator : function(value) {
            return /^[a-z]+$/.test(value);
        },
        message : '请输入小写字母'
    },
    ip:{
    	validator:function(value){
    		var reg = /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])(\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])){3}$/;
    		return reg.test(value);
    	},
    	message:'请输入有效的IP地址'
    }
});