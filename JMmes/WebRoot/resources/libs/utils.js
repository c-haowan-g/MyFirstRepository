var Utils = Utils = Utils || {};

/**
 * 判断字符串是否为空
 * 
 * @param str
 * @returns {Boolean}
 */
Utils.isEmpty = function(str) {
	if (str == null || str == "" || str == undefined)
		return true;
	return false;
};

/**
 * 判断对象是否为空，undefined也是为空
 */
Utils.isNull=function(obj){
	if(obj==undefined||obj==null)return true;
	return false;
}


/**
 * 随机数-整数
 * @param {Object} min 最小值
 * @param {Object} max 最大值
 */
Utils.randomInt=function(min,max){
	//因为floor是向下取整，所以max+1才能取到Max的最大值
	return Math.floor(min+Math.random()*((max+1)-min));
}

/**
 * 随机数-浮点数
 * @param {Object} min 最小值
 * @param {Object} max 最大值
 * @param {Object} precision 精度
 */
Utils.randomFloat=function(min,max,precision){
	return new Number(min+Math.random()*(max-min)).toFixed(precision);
}

/**
 * 生成随机字符串
 * @param {Object} length 长度
 * @param {Object} containNumber 是否包含数字
 * @param {Object} upperCase 转大写？
 */
Utils.randomString=function(length,containNumber,upperCase){
	var chars=['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'];
	var target=[];
	var min=0,max=61;
	
	if(!containNumber)min=10;
	for(var i=0;i<length;i++){
		target[i]=chars[Math.floor(min+Math.random()*((max+1)-min))];
	}
	
	return upperCase?target.join("").toUpperCase():target.join("");
}

/**
 * 判断是否是数字,数字类型或者数字字符串
 * @param {Object} str
 */
Utils.isNumber=function(val){
	if(+val===val)return true;
	if(typeof val=='string'){
		if(val.indexOf("-")==0)val=val.replace("-","");
		return val.match(/\d*/i)==val;
	}
	return false;
}

/**
 * 判断是否是数字,数字类型或者数字字符串
 * @param {Object} str
 */
Utils.isFloat=function(val){
	if(+val===val)return true;
	if(typeof val=='string'){
		if(val.indexOf("-")==0)val=val.replace("-","");
		return /^\d+(\.\d+)?$/.test(val);
	}
	return false;
}

/**
 * 判断对象是否是数组
 */
Utils.isArray=function(value){
	return value&&value.constructor == Array;
}

/**
 * 判断对象是否是某个类型
 * @param {Object} value
 * @param {Object} type
 */
Utils.isTypeOf=function(value,type){
	return (typeof value==type);
}

/**
 * 判断对象是否是某个类型的实例
 * @param {Object} value
 * @param {Object} type
 */
Utils.isInstanceOf=function(value,type){
	return value instanceof type;
}

/**
 * 去除字符串两端空格
 * @param {Object} str
 */
Utils.trim=function(str){
	return str.replace(/(^\s*)|(\s*$)/g,"");
}

/**
 * 去除字符串左边的空格
 * @param {String}  str 进行处理的字符串
 * @return          处理过的字符串
 * @type String
 * @version 1.0 
 */
Utils.lTrim=function(str){
    return str.replace(/(^[\s]*)/g, "");
}
/**
 * 去除字符串右边的空格
 * @param {String}  str 进行处理的字符串
 * @return          处理过的字符串
 * @type String
 * @version 1.0 
 */
Utils.rTrim=function(str){
    return str.replace(/([\s]*$)/g, "");
}

/**
 * 字符串替换
 * @param {Object} src 源字符串
 * @param {Object} str1 替换前的字符串
 * @param {Object} str2  替换后的字符串
 */
Utils.replaceAll=function(src,str1,str2){
	return src.replace(new RegExp(str1,"gm"),str2);
}

/**
 * 长度限制
 * @param {string} str
 */
Utils.length=function(str){
	 return str.replace(/[^\x00-\xff]/g,"**").length;
}

/**
 * 加法
 */
Utils.add = function(n1, n2, precision) {
	var baseNum, baseNum1, baseNum2;
	try {
		baseNum1 = n1.toString().split(".")[1].length;
	} catch (e) {
		baseNum1 = 0;
	}
	try {
		baseNum2 = n2.toString().split(".")[1].length;
	} catch (e) {
		baseNum2 = 0;
	}
	baseNum = Math.pow(10, Math.max(baseNum1, baseNum2));
	var n = (n1 * baseNum + n2 * baseNum) / baseNum;
	if (precision == undefined)
		return n;
	return new Number(n).toFixed(precision);
}

/**
 * 减法
 */
Utils.sub = function(n1, n2, precision) {
	var baseNum, baseNum1, baseNum2;
	var _precision;// 精度
	try {
		baseNum1 = n1.toString().split(".")[1].length;
	} catch (e) {
		baseNum1 = 0;
	}
	try {
		baseNum2 = n2.toString().split(".")[1].length;
	} catch (e) {
		baseNum2 = 0;
	}
	baseNum = Math.pow(10, Math.max(baseNum1, baseNum2));
	_precision = (baseNum1 >= baseNum2) ? baseNum1 : baseNum2;
	var n = ((n1 * baseNum - n2 * baseNum) / baseNum).toFixed(_precision);
	if (precision == undefined)
		return n;
	return new Number(n).toFixed(precision);
}
/**
 * 乘法
 */
Utils.mul = function(n1, n2, precision) {
	var baseNum = 0;
	try {
		baseNum += n1.toString().split(".")[1].length;
	} catch (e) {
		baseNum+= 0;
	}
	try {
		baseNum += n2.toString().split(".")[1].length;
	} catch (e) {
		baseNum+=0;
	}
	var n = Number(n1.toString().replace(".", "")) * Number(n2.toString().replace(".", "")) / Math.pow(10, baseNum);
	if (precision == undefined)
		return n;
	return new Number(n).toFixed(precision);

}
/**
 * 除法
 */
Utils.div = function(n1, n2, precision) {

	var baseNum1 = 0, baseNum2 = 0;
	var baseNum3, baseNum4;
	try {
		baseNum1 = n1.toString().split(".")[1].length;
	} catch (e) {
		baseNum1 = 0;
	}
	try {
		baseNum2 = n2.toString().split(".")[1].length;
	} catch (e) {
		baseNum2 = 0;
	}
	with (Math) {
		baseNum3 = Number(n1.toString().replace(".", ""));
		baseNum4 = Number(n2.toString().replace(".", ""));
		var n = (baseNum3 / baseNum4) * pow(10, baseNum2 - baseNum1);
		if (precision == undefined)
			return n;
		return new Number(n).toFixed(precision);
	}
};

/**
 * 数组遍历器
 */
Utils.each=function(array,callback){
	for(var i=0;i<array.length;i++){
		callback(i,array[i]);
	}
};

Utils.toTree=function(array,idKey,textKey,parentKey,state){
	
	function getChildren(data, idValue) {
		var children = [];
		for (var i = 0; i < data.length; i++) {
			if (data[i][parentKey] == idValue) {
				data[i].text = data[i][textKey];
				data[i].id = data[i][idKey];
				data[i].state =state;
				data[i].children = getChildren(data, data[i][idKey]);
				children.push(data[i]);
			}
		}
		return children;
	}
	
	return getChildren(array, null);
}