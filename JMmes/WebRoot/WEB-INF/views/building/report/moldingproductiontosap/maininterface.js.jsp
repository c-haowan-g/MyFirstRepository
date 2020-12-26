<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"lh/scgl/mesapproduction/saveChanges"; 
    
    function showOrHide(){
        if($("#MainInterface_search_form").is(":hidden")){
            $("#MainInterface_search_form").show();
        }else{
            $("#MainInterface_search_form").hide();
        }
    }
    function codeFormatter(v, r, i) {
		return dictFormat(v);
	}
    //固化标识转换
    function ghFormatter(v,r,i){
    	if(v=='1'){
    		return '已固化';
    	}
    	else {
    		return '未固化';
    	}
    }
    //报产方式
    function bcTypeFormatter(v,r,i){
    	if(v=='01'){
    		return '报产';
    	}
    	else if (v=='02') {
    		return '冲产';
    	}
    }
    //更改SAP读取状态的显示值
    function rsFormatter(v,r,i){
    	if(v=='0'){
    		return 'SAP未读取';
    	}else if (v=='1') {
    		return '已读取';
    	}else if (v=='2') {
    		return '正常';
    	}else if (v=='3') {
    		return '错误';
    	}else {
    		return v;
    	}
    }
    //更改上报状态的颜色列
    var cellSapRecordStyler=function (value,row,index){
    	if (value=="0"){
    		return 'background-color:#caf0b5;';
    	}else if (value=="1"){
    		return 'background-color:#f2e1b7;';
    	}
    	else if (value=="2"){
    		return 'background-color:#06fa01;';
    	}
    	else if (value=="3"){
    		return 'background-color:#fa3101;';
    	}
    }
    //固化标识颜色转换
    var solidflagStyler=function(value,row,index){
    	if (value=="0"){
    		return 'background-color:#caf0b5;';
    	}
    }
    $(function(){
    	$('#process_s').textbox("setValue","252005");
		$("#process_s").next().hide();
		filter();
	});
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("MainInterface_dg","MainInterface_search_form");
    }

	//报产
	function curing(){
		 $("#curingdlg").dialog("open");
	} 
	
	//报产上报
    function reporttosap(){
        var rows= $("#MainInterface_dg").datagrid("getChecked");
    	if(rows.length==0){
    		ext.tip.warn(tipSelectAtLeastOne);
    		return;
    	}
    	var batchidlist=[];
    	for(var i=0;i<rows.length;i++){
    		if(rows[i].record_sap_flag_s=='1'){
    			ext.tip.warn(rows[i].batch_id_s+'-----'+"数据已经上报");
    			continue;
    		}
    		batchidlist.push(rows[i].batch_id_s);
    	}
    	ext.ajax.post("building/productionManagement/workOrderResult/reporttosapBySelectRow",{batchidlist:batchidlist.toString()},function(data){
    		if(data.code==OK){
    			ext.tip.suc();
    			filter();
    			return;
    		}
    		ext.tip.error(data.message);
    	});
    }
	 
	//冲产
    function updatesolid(){
		 $("#moldingdlg").dialog("open");
	} 
   
    //冲产上报
    function reflushtosap(){
        var rows= $("#MainInterface_dg").datagrid("getChecked");
    	if(rows.length==0){
    		ext.tip.warn(tipSelectAtLeastOne);
    		return;
    	}
    	var batchidlist=[];
    	for(var i=0;i<rows.length;i++){
    		if(rows[i].record_sap_flag_s=='1'){
    			ext.tip.warn(rows[i].batch_id_s+'-----'+"数据已经上报");
    			continue;
    		}
    		batchidlist.push(rows[i].batch_id_s);
    	}
    	ext.ajax.post("building/productionManagement/workOrderResult/reflushtosapBySelectRow",{batchidlist:batchidlist.toString()},function(data){
    		if(data.code==OK){
    			ext.tip.suc();
    			filter();
    			return;
    		}
    		ext.tip.error(data.message);
    	});
    }
    
    /*---------------------------------  报产/冲产明细 --------------------------------------------- */
	//明细按钮(第五个按钮)
    function productionDetail(){
    	var selectrows=$("#MainInterface_dg").datagrid("getChecked");
        
        if(selectrows.length==0){
            ext.tip.warn(tipSelectAtLeastOne);
            return;
        }
        if(selectrows.length>1){
            ext.tip.error("<spring:message code="tip.OneSelectedToDetail" />");
            return;
        }
    	//弹出明细窗口
    	$("#workorderresult_detail_dg").dialog("open");
    	ext.ajax.sendJson("building/productionManagement/workOrderResult/productionDetail2",{
    		   selectedrows:selectrows
    	}, function(data){
    		  $('#detail_dg').datagrid('loadData', data);
    	}); 
    }
    
  
    //更改冲产报产颜色
    var cellStyler=function (value,row,index){
    	if (value=="01"){
    		return 'background-color:#d4f5d7;';
    	}else if (value=="02"){
    		return 'background-color:#f5dbdb;';
    	}
    }

</script>