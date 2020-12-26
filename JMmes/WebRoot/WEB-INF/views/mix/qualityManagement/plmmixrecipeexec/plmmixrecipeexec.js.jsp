<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">


	$(document).ready(function() {
		$('#begin_created_time').datetimebox({
			value : '3/4/2010 00:00:00',
			required : true,
			showSeconds : true
		});
		$('#end_created_time').datetimebox({
			value : '3/4/2010 23:59:59',
			required : true,
			showSeconds : true
		});
		filter();
	});
	
     //加载密炼机台信息
  	var equiplist=[];
 	$.ajax({
 		url:"mix/productionManagement/drrecord/getMixProductionInfo?plantype="+"051003",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			equiplist=data;
 		}
 	});
    
     function searchProductionLine(q, row) {
	 	var opts = $(this).combobox('options');
		return row[opts.textField].toUpperCase().indexOf(q.toUpperCase()) >= 0;
	}
    
    /**
     * 查询方法
     */
    var filter=function(){
    	var value = $('input[name="histaryradio"]:checked').val();
    	var opts = $("#plmmixrecipeexec_dg").datagrid("options");
    	opts.url = 'mix/qualityManagement/plmmixrecipeexec/datagrid';
    	if ("his_time" == value) {
			opts.url = 'mix/qualityManagement/plmmixrecipeexechis/datagrid';
		}
        
        ext.easyui.grid.search("plmmixrecipeexec_dg","PlmMixRecipeExec_search_form");
    }
    
    function selectrow(){
     
      var rows=$("#plmmixrecipeexec_dg").datagrid('getSelected');
      		
      	//加载配方详细信息	
		$("#slowdown_weight_d").html(rows.slowdown_weight_d);

		$("#cutpoly_weight_d").html(rows.cutpoly_weight_d);

		$("#mes_equip_code_s_sp").html(rows.mes_equip_code_s);

		$("#mes_equip_name_s").html(rows.mes_equip_name_s);

		$("#equip_code_s_sp").html(rows.equip_code_s);

		$("#edt_code_s_sp").html(rows.edt_code_s);
		
		$("#recipe_status_s_sp").html(codeFormatter(rows.recipe_status_s,null,null));

		$("#max_inploytemp_i_sp").html(rows.max_inploytemp_i);

		$("#mater_code_s_sp").html(rows.mater_code_s);

		$("#set_weigh_d_sp").html(rows.set_weigh_d);

		$("#dischangetime_i_sp").html(codeFormatter(rows.dischangetime_i, null, null));//加硫限制

		$("#mater_type_s_sp").html(codeFormatter(rows.mater_type_s, null, null));

		$("#cb_recycletype_s_sp").html(codeFormatter(rows.cb_recycletype_s, null, null));

		$("#plant_s_sp").html(rows.plant_s);

		$("#mater_name_s_sp").html(rows.mater_name_s);

		$("#cb_recycletime_i_sp").html(rows.cb_recycletime_i);

		$("#receive_time_t_sp").html(rows.receive_time_t);

		$("#b_version_s_sp").html(rows.b_version_s);

		$("#overtemp_mintime_i_sp").html(rows.overtemp_mintime_i);

		$("#overtime_time_i_sp").html(rows.overtime_time_i);

		$("#r_version_s_sp").html(rows.r_version_s);

		$("#overtemp_temp_i_sp").html(rows.overtemp_temp_i);

		$("#dummy1_s_sp").html(codeFormatter(rows.dummy1_s, null, null));

		$("#min_inploytemp_i_sp").html(rows.min_inploytemp_i);

		$("#ismixed_s_sp").html(codeFormatter(rows.ismixed_s, null, null));

		$("#makeup_temp_i_sp").html(rows.makeup_temp_i);

		$("#matchingcode_s_sp").html(rows.matchingcode_s);

		$("#is_useareatemp_s_sp").html(isuseareatempformatter(rows.is_useareatemp_s));//是否使用三区温度

		$("#dummy2_s_sp").html(rows.dummy2_s);

		$("#shelf_num_i_sp").html(rows.shelf_num_i);

		$("#side_temp_i_sp").html(rows.side_temp_i);

		$("#dummy3_s_sp").html(rows.dummy3_s);

		$("#routing_type_s_sp").html(codeFormatter(rows.routing_type_s, null, null));//工艺类型321

		$("#roll_temp_i_sp").html(rows.roll_temp_i);

		$("#dummy4_s_sp").html(rows.dummy4_s);

		$("#prescriptionstage_s_sp").html(codeFormatter(rows.prescriptionstage_s, null, null));// 配方阶段332

		$("#ddoor_temp_i_sp").html(rows.ddoor_temp_i);

		$("#dummy5_s_sp").html(rows.dummy5_s);
      
      	var value = $('input[name="histaryradio"]:checked').val();
		//如果是历史的
		if ("his_time" == value) {
      	//加载历史信息
      		ext.ajax.post("mix/qualityManagement/plmmixweightexechis/datagrid",{"filter[recipe_code_s]":rows.recipe_code_s,all:1 },function(data){
    			$('#plmmixweight_dg').datagrid('loadData', data);  		
    		}); 
    	 	ext.ajax.post("mix/qualityManagement/plmmixmixexechis/datagrid",{"filter[recipe_code_s]":rows.recipe_code_s,all:1},function(data){  	 
    		 	$('#plmmixmix_dg').datagrid('loadData', data);  		
    		});  
    	}else{
    		ext.ajax.post("mix/qualityManagement/plmmixweightexec/datagrid",{"filter[recipe_code_s]":rows.recipe_code_s,all:1 },function(data){
    			$('#plmmixweight_dg').datagrid('loadData', data);  		
    		}); 
    	 	ext.ajax.post("mix/qualityManagement/plmmixmixexec/datagrid",{"filter[recipe_code_s]":rows.recipe_code_s,all:1},function(data){  	 
    		 	$('#plmmixmix_dg').datagrid('loadData', data);  		
    		});  
    	}
    }
    
     /**
    *将数据库得值转换为数据字典与对应值域
    */           	
    function codeFormatter(v, r, i) {

    		return dictFormat(v);
    	}

    // 数据同步处理：A-新增、U-修改、D-删除
	function syncflagformatter(v, r, i) {
		if (v == 'A') {
			return "新增";
		}
		if (v == 'U') {
			return "修改";
		}
		if (v == 'D') {
			return "删除";
		}
	}
	
	//0-未处理、1-已处理、2-处理失败
	function equipsynchandflagformatter(v, r, i) {
		if (v == 0) {
			return "未处理";
		}
		if (v == 1) {
			return "已处理";
		}
		if (v == 2) {
			return "处理失败";
		}
	}
	
	function checkstateformatter(v, r, i) {

		if (v == '0') {
			return "未审核";
		} else if (v == '1') {
			return "已审核";
		}
		return "更正数量清零";
	}
	
	//下发标识（下发成功后置逻辑删除）：0-未下发、1-已下发
	function sendstateformatter(v, r, i) {
		if (v == 0) {
			return "未下发";
		}
		if (v == 1) {
			return "已下发";
		}
		if (v == 2){
			return "重新下发"
		}
	}
	
	function isuseareatempformatter(v, r, i) {

		if (v == '0') {
			return "不使用";
		} else if (v == '1') {
			return "使用";
		}
		return "更正数量清零";
	}
	
	

</script>