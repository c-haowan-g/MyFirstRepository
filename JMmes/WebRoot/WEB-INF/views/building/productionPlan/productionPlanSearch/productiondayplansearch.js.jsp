<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var jtxx=[];
    var action = "";
    /**
	 * 基础数据text显示
	 */
	function codeFormatter(v, r, i) {
	  if(v==null){
		  return "";
	  }
		return dictFormat(v);
	}
	/**
	 * 解析指定格式日期
	 */
	function dateParser(s) {
		if (!s)
			return new Date();
		return new Date(s.substring(0, 4), parseInt(s.substring(4, 6)) - 1, s
				.substring(6, 8));
	}
	/**
     * 接收combtree数据
     */
     var DICT_307=[];
 	
 	$.ajax({
 		url:"building/productionPlan/productiondayplan/get307BaseData",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			DICT_307=data;
 		}
 	});
 	 /**
     * 接收combtree数据
     */
     var DICT_328=[];
 	
	 	$.ajax({
	 		url:"building/productionPlan/productiondayplan/get328BaseData",
	 		type:"get",
	 		dataType:"json",
	 		async:false,
	 		success:function(data){
	 			DICT_328=data;
	 		}
	 	});
 	
    
  //加载产线信息
    $.ajax({
        url : 'building/basedata/productline/getProductlineByProcess?process='+'252005',
        type : 'get',
        dataType : 'json',
        async : false,
        success : function(data) {
        	for(var i=0;i<data.length;i++){
        		jtxx.push({value:data[i].p_line_name,text:data[i].p_line_name});
        	}
        }
    });
    
    function showOrHide(){
        if($("#CxProductionDayPlan_search_form").is(":hidden")){
            $("#CxProductionDayPlan_search_form").show();
        }else{
            $("#CxProductionDayPlan_search_form").hide();
        }
    }
    //表格加载前事件
	function onDgBeforeLoad(param) {
		if ($("#production_date_s").datebox("getValue") == "") {
			return false;
		}
		
		param["filter[production_date_s]"] = $("#production_date_s").datebox(
				"getValue");
		
	}
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("cxproductiondayplan_dg","CxProductionDayPlan_search_form");
    }
    
   
    
    
    /**
	 * 日期格式化
	 */
	function dateFormat(date) {
		return new Calendar(date).format("yyyyMMdd");
	}
    
	/**
     * 设置datagrid进度条
     */
    function progressFormatter(value,rowData,rowIndex){
    	//日计划完成进度
    	if(this.field=="quantity_dayproduct_finishbl"){
    		if(rowData.quantity_dayproduct_i=="0"||rowData.quantity_dayplan_i=="0"
    				||rowData.quantity_dayproduct_i==null||rowData.quantity_dayplan_i==null){
        		value=0;
        	}else{
        	   value=rowData.quantity_dayproduct_i/rowData.quantity_dayplan_i;
        	}
    		
    	}
    	//早班完成进度
    	if(this.field=="planamount_mor_finishbl"){
    		if(rowData.output_morclass_i=="0"||rowData.planamount_mor_i=="0"
    			||rowData.output_morclass_i==null||rowData.planamount_mor_i==null){
        		value=0;
        	}else{
        	   value=rowData.output_morclass_i/rowData.planamount_mor_i;
        	}
    		
    	}
    	//中班完成进度
    	if(this.field=="planamount_mid_finishbl"){
    		if(rowData.output_midclass_i=="0"||rowData.planamount_mid_i=="0"
    			||rowData.output_midclass_i==null||rowData.planamount_mid_i==null){
        		value=0;
        	}else{
        	   value=rowData.output_midclass_i/rowData.planamount_mid_i;
        	}
    		
    	}
    	//晚班完成进度
    	if(this.field=="planamount_nig_finishbl"){
    		if(rowData.output_nigclass_i=="0"||rowData.planamount_nig_i=="0"
    			||rowData.quantity_dayplan_i==null||rowData.planamount_nig_i==null){
        		value=0;
        	}else{
        	   value=rowData.output_nigclass_i/rowData.planamount_nig_i;
        	}
    		
    	}
    	
    	return "<div class='easyui-progressbar progressbar easyui-fluid' style='width:100px'><div class='progressbar-text' style='width:100px;z-index:100'>"+ (value*100).toFixed(2) + "%</div> <div class='progressbar-value'  style='width:"+ (value*100).toFixed(2) + "%;background-color:#00FF99'>&nbsp;&nbsp;</div></div>"; 
    	
    }
	/**
	 *combobox下拉框清除选择内容
	 *
	 */
	function clearMaterial(){
		$('#material_code_s').combobox('clear');
	}
	function clearEquipCode(){
		$('#equip_code_s').combobox('clear');
	}
	function clearPlanStatus(){
		$('#status_s').combobox('clear');
	}

</script>