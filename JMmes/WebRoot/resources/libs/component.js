/**
 * 获取序列号
 * @param model
 * @param callback
 */
function getSerial(model,callback){
	ext.ajax.get("serial/"+model,function(data){
		callback(data);
	});
}

/**
 * 获取指定日期的序列号
 * @param model
 * @param date
 * @param callback
 */
function getSerialByDate(model,date,callback){
	ext.ajax.get("serial/"+model+"/"+date,function(data){
		callback(data);
	});
}