<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	 $(document).ready(function() {
		$('#begin_created_time').datetimebox({
			value : '3/4/2010 00:00:00',
			required : false,
			showSeconds : true
		});
		$('#end_created_time').datetimebox({
			value : '3/4/2010 23:59:59',
			required : false,
			showSeconds : true
		});
	});
	
    function showOrHide(){
        if($("#WorkorderResult_search_form").is(":hidden")){
            $("#WorkorderResult_search_form").show();
        }else{
            $("#WorkorderResult_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
    	var line = $('#line_spec_s').checkbox('options').checked;
    	var material = $('#material_spec_s').checkbox('options').checked;
    	if(line == true && material == true){
            $("#workorderresult_dg").datagrid("options").url="building/productionManagement/weightOkRateByCode/searchInit1";
    		ext.easyui.grid.search("workorderresult_dg","WorkorderResult_search_form");
    		$('#workorderresult_dg').datagrid({ 
    			columns:[[
                	{field:'atr_key',checkbox:true},
                    {field:'equip_code_s',title:'产线编码',width:70},
                    {field:'material_code_s',title:'物料编码',width:70},
                    {field:'material_name_s',title:'物料描述',width:70},
                    {field:'production_ver_s',title:'版本号',width:70},
                    {field:'add_flag_s',title:'产出类型',formatter:codeFormatter,url:'dict/code/105',width:70},
                    {field:'standard_weight_s',title:'标准重量',width:70},
                    {field:'max_weight_s',title:'胎胚上限重量',width:70},
                    {field:'min_weight_s',title:'胎胚下限重量',width:70},
                    {field:'total_number_s',title:'总数',width:75},
                    {field:'weight_ok_s',title:'重量合格数量',width:80},
                    {field:'weight_small_s',title:'重量超轻数量',width:80},
                    {field:'weight_big_s',title:'重量超重数量',width:80},
                    {field:'ok_rate_s',title:'合格率',width:80}
                ]]
            });
    	}
    	if(line == true && material == false){
            $("#workorderresult_dg").datagrid("options").url="building/productionManagement/weightOkRateByCode/searchInit2";
    		ext.easyui.grid.search("workorderresult_dg","WorkorderResult_search_form");
    		$('#workorderresult_dg').datagrid({
                columns:[[
                	{field:'atr_key',checkbox:true},
                    {field:'equip_code_s',title:'产线编码',width:95},
                    {field:'add_flag_s',title:'产出类型',formatter:codeFormatter,url:'dict/code/105',width:95},
                    {field:'standard_weight_s',title:'标准重量',width:95},
                    {field:'max_weight_s',title:'胎胚上限重量',width:95},
                    {field:'min_weight_s',title:'胎胚下限重量',width:95},
                    {field:'total_number_s',title:'总数',width:95},
                    {field:'weight_ok_s',title:'重量合格数量',width:95},
                    {field:'weight_small_s',title:'重量超轻数量',width:95},
                    {field:'weight_big_s',title:'重量超重数量',width:95},
                    {field:'ok_rate_s',title:'合格率',width:95}
                ]]
            });
    	}
    	if(line == false && material == true){
            $("#workorderresult_dg").datagrid("options").url="building/productionManagement/weightOkRateByCode/searchInit3";
    		ext.easyui.grid.search("workorderresult_dg","WorkorderResult_search_form");
    		$('#workorderresult_dg').datagrid({
                columns:[[
                	{field:'atr_key',checkbox:true},
                    {field:'material_code_s',title:'物料编码',width:80},
                    {field:'material_name_s',title:'物料描述',width:80},
                    {field:'production_ver_s',title:'版本号',width:80},
                    {field:'add_flag_s',title:'产出类型',formatter:codeFormatter,url:'dict/code/105',width:80},
                    {field:'standard_weight_s',title:'标准重量',width:80},
                    {field:'max_weight_s',title:'胎胚上限重量',width:80},
                    {field:'min_weight_s',title:'胎胚下限重量',width:80},
                    {field:'total_number_s',title:'总数',width:75},
                    {field:'weight_ok_s',title:'重量合格数量',width:80},
                    {field:'weight_small_s',title:'重量超轻数量',width:80},
                    {field:'weight_big_s',title:'重量超重数量',width:80},
                    {field:'ok_rate_s',title:'合格率',width:80}
                ]]
            });
    	}
    	if(line == false && material == false) {
    		ext.tip.error("统计方式不能为空");
    	}
    };
	
	function codeFormatter(v, r, i){
		return dictFormat(v);
	} 
</script>