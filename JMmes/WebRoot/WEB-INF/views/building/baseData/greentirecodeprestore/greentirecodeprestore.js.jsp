<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"building/basedata/greentirecodeprestore/saveChanges";
    
    function showOrHide(){
        if($("#GreenTireCodePrestore_search_form").is(":hidden")){
            $("#GreenTireCodePrestore_search_form").show();
        }else{
            $("#GreenTireCodePrestore_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("greentirecodeprestore_dg","GreenTireCodePrestore_search_form");
    };
    
    function add() {
        ext.easyui.grid.appendAndEdit("greentirecodeprestore_dg",
        		{
        	     status_s:new Calendar().format("01")
        	    });
    }

    function edit() {
        var rows = $("#greentirecodeprestore_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#greentirecodeprestore_dg").datagrid("getRowIndex", rows[i]);
            $("#greentirecodeprestore_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#greentirecodeprestore_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#greentirecodeprestore_dg").datagrid("getRowIndex", rows[i]);
            $("#greentirecodeprestore_dg").datagrid("deleteRow", index);
        }
    }

    function save() {
        var dg = $("#greentirecodeprestore_dg");

        var rows = dg.datagrid("getRows");
        for (var i = 0; i < rows.length; i++) {
            if (!dg.datagrid("validateRow", i)) {
                ext.tip.error("<spring:message code="tip.invalid" />");
                return;
            }
        }

        var inserted = dg.datagrid("getChanges", "inserted");
        var updated = dg.datagrid("getChanges", "updated");
        var deleted = dg.datagrid("getChanges", "deleted");

        for (var i = 0; i < rows.length; i++) {
            dg.datagrid("endEdit", i);
        }
		Utils.each(updated, function(i, d) {
			delete d.createdname;
		});
		Utils.each(deleted, function(i, d) {
			delete d.createdname;
		});
        
        
        ext.ajax.sendJson(saveChanges,{inserted : inserted,updated : updated,deleted : deleted}, 
		          function(data) {
        	    
                                  if(data.data!="操作成功"){
  	                                  ext.tip.error(data.data);
  	                                  saveFilter();
  	                                  return ;
                                  }
  	                                 ext.tip.suc(data.data);
  	                                 saveFilter();
                                  $("#greentirecodeprestore_dg").datagrid("reload");//重新加载界面数据
                                });
    }

    function cancel() {
        $("#greentirecodeprestore_dg").datagrid("rejectChanges");
    }
    //查询栏按时间查询
  $(function(){
  	$("#start_time").datetimebox({
  	    value:'3/4/2010 00:00:00',
  	    required: false,
  	    showSeconds: true
  	});
  	$("#end_time").datetimebox({
  	    value:'3/4/2010 23:59:59',
  	    required: false,
  	    showSeconds: true
  	});
  	var opts = $("#greentirecodeprestore_dg").datagrid("options");
    opts.url = 'building/basedata/greentirecodeprestore/datagrid';
  	filter();
  });
	function saveFilter(){
		var opts = $("#greentirecodeprestore_dg").datagrid("options");
	    opts.url = 'building/basedata/greentirecodeprestore/datagrid';
	    ext.easyui.grid.search("greentirecodeprestore_dg","GreenTireCodePrestore_search_form");
	}
	//批量导入弹出框打开
    function BatchAdd() {
		$("#Batch_dg").dialog("open");
	}
	function onBatchDlgOpen(){
		$("#batchstatus").textbox('textbox').css("color", "red");
		$('#batchstatus').textbox("setValue","编制中。。。");
	}
	//批量导入弹出框关闭
	function BatchCancel() {
		$("#Batch_dg").dialog("close");
	}
	
	
	//批量导入弹出框传数据到后台
	function BatchSave(){
		var equipCode=$('#equipCode').textbox("getValue");
    	var barcodeFrom= $('#barcodeFrom').textbox("getValue");
    	var batchNum = $('#batchNum').numberspinner('getValue');
    	if(equipCode==""||barcodeFrom==""||batchNum==""){
    		 ext.tip.error("输入信息不完整，请检查");
    		 return;
    	}
    	if(barcodeFrom.length!=10){
    		ext.tip.error("起始条码不符合规范:要求为10位");
   		    return;
    	}
    	var isnum = /^\d+$/.test(barcodeFrom.slice(1));
  	    if (isnum==false) {
  	    	ext.tip.error("起始条码不符合规范:要求后九位不允许出现字母");
  	    	$('#barcodeFrom').textbox("clear");
  	    	return;
  	    }
  	    $('#batchstatus').textbox("setValue","保存中，请等待。。。");
  	    
    	  $.ajax({
	 		url:"building/basedata/greentirecodeprestore/BatchAdd?equipCode="+equipCode+"&greenTireCode="+barcodeFrom+"&batchNum="+batchNum,
	 		type:"get",
	 		dataType:"json",
	 		async:true,
	 		success:function(data){
	 			if(data.data=="批量导入条码成功"){
             	      ext.tip.suc(data.data);
                }
                else{
                	  $.messager.confirm("操作失败", data.data, function (data) {
              			
          			});
                }
	 			$('#batchstatus').textbox("setValue","导入完成");
	 			$('#equipCode').textbox("setValue","");
	 	    	$('#barcodeFrom').textbox("setValue","");
	 	    	$('#batchNum').numberspinner("setValue","");
	 	    	$('#endcode').textbox("setValue","");
                $("#greentirecodeprestore_dg").datagrid("reload");//重新加载界面数据
	 		}
        });
    	  
  } 
	//数量下拉框事件
	function batchNumChange(){
		var barcodeFrom= $('#barcodeFrom').textbox("getValue");
		if(barcodeFrom==""){
			return;
		}
    	var batchNum = $('#batchNum').numberspinner('getValue');
    	if(batchNum==""){
    		return;
    	}
    	setEndCode(barcodeFrom,batchNum);
	}
	//设置终止条码文本框
	function setEndCode(startCdoe,batchnum){
		if(startCdoe.length!=10){
    		ext.tip.error("起始条码不符合规范:要求为10位");
   		    return;
    	}
    	var isnum = /^\d+$/.test(startCdoe.slice(1));
  	    if (isnum==false) {
  	    	ext.tip.error("起始条码不符合规范:要求后九位不允许出现字母");
  	    	$('#barcodeFrom').textbox("clear");
  	    	return;
  	    }
  	    var preString=startCdoe.substring(0,1);
  	    var endString=startCdoe.substring(1,startCdoe.length);
  	    var endInt=parseInt(endString);
  	    var endText=endInt+parseInt(batchnum-1);
  	    $('#endcode').textbox("setValue",preString+PrefixInteger(endText,9));
	}
	function PrefixInteger(num, n) {
        return (Array(n).join(0) + num).slice(-n);
    }
	//显示值转换
    function codeFormatter(v,r,i) {
		if(v=='01'){
			return "未使用";
		}
		else if(v=='02'){
			return "已使用";
		}
	}
	function clearStatus(){
		$('#status_s').combobox('clear');
	}
	//批量编辑页面打开事件
	function onBatchEditDlgOpen(){
		$("#batchstatusEdit").textbox('textbox').css("color", "red");
		$('#batchstatusEdit').textbox("setValue","编制中。。。");
	}
	//批量修改按钮
	function BatchEdit(){
		$("#BatchEdit_dg").dialog("open");
	}
	//关闭批量编辑页面
	function BatchEditCancel(){
		$("#BatchEdit_dg").dialog("close");
	}
	//批量更改--数量下拉框事件
	function batchNumEditChange(){
		var barcodeFrom= $('#barcodeFromEdit').textbox("getValue");
		if(barcodeFrom==""){
			return;
		}
    	var batchNum = $('#batchNumEdit').numberspinner('getValue');
    	if(batchNum==""){
    		return;
    	}
    	setEditEndCode(barcodeFrom,batchNum);
	}
	//批量更改--设置终止条码文本框
	function setEditEndCode(startCdoe,batchnum){
		if(startCdoe.length!=10){
    		ext.tip.error("起始条码不符合规范:要求为10位");
   		    return;
    	}
    	var isnum = /^\d+$/.test(startCdoe.slice(1));
  	    if (isnum==false) {
  	    	ext.tip.error("起始条码不符合规范:要求后九位不允许出现字母");
  	    	$('#barcodeFromEdit').textbox("clear");
  	    	return;
  	    }
  	    var preString=startCdoe.substring(0,1);
  	    var endString=startCdoe.substring(1,startCdoe.length);
  	    var endInt=parseInt(endString);
  	    var endText=endInt+parseInt(batchnum-1);
  	    $('#endcodeEdit').textbox("setValue",preString+PrefixInteger(endText,9));
	}
	//批量编辑保存按钮
	function BatchEditSave(){
        var equipCode=$('#equipCodeEdit').textbox("getValue");
    	var barcodeFrom= $('#barcodeFromEdit').textbox("getValue");
    	var batchNum = $('#batchNumEdit').numberspinner('getValue');
    	var barcodeEnd=$('#endcodeEdit').textbox('getValue');
    	if(equipCode==""||barcodeFrom==""||batchNum==""||barcodeEnd==""){
    		 ext.tip.error("输入信息不完整，请检查");
    		 return;
    	}
    	if(barcodeFrom.length!=10){
    		ext.tip.error("起始条码不符合规范:要求为10位");
   		    return;
    	}
    	var isnum = /^\d+$/.test(barcodeFrom.slice(1));
  	    if (isnum==false) {
  	    	ext.tip.error("起始条码不符合规范:要求后九位不允许出现字母");
  	    	$('#barcodeFromEdit').textbox("clear");
  	    	return;
  	    }
  	    $('#batchstatusEdit').textbox("setValue","修改中，请等待。。。");
    	  $.ajax({
	 		url:"building/basedata/greentirecodeprestore/BatchEdit?equipCode="+equipCode+"&greenTireCode="+barcodeFrom+"&greenTireCodeEnd="+barcodeEnd+"&batchNum="+batchNum,
	 		type:"get",
	 		dataType:"json",
	 		async:true,
	 		success:function(data){
	 			if(data.data=="批量编辑条码成功"){
             	      ext.tip.suc(data.data);
                }
                else{
                	  $.messager.confirm("部分操作失败", data.data, function (data) {
          			});
                }
	 			$('#batchstatusEdit').textbox("setValue","修改完成");
	 			$('#equipCodeEdit').textbox("setValue","");
	 			$('#endcodeEdit').textbox("setValue","");
	 	    	$('#barcodeFromEdit').textbox("setValue","");
	 	    	$('#batchNumEdit').numberspinner("setValue","");
                $("#greentirecodeprestore_dg").datagrid("reload");//重新加载界面数据
	 		}
        });
	}
	
</script>