<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"building/productionManagement/machine_Formula/saveChanges";
    
    function showOrHide(){
        if($("#Machine_Formula_search_form").is(":hidden")){
            $("#Machine_Formula_search_form").show();
        }else{
            $("#Machine_Formula_search_form").hide();
        }
    }
	/**
	 * 接收combtree数据
	 */
	var DICT_189=[];
	
	$.ajax({
		url:"dict/code/189",
		type:"get",
		dataType:"json",
		async:false,
		success:function(data){
			DICT_189=data;
		}
	});
    function codematter(v,r,i){
    	if(v==01){
    		return "试制";
    	}else if(v==02){
    		return "试产";
    	}else if(v==03){
    		return "投产";
    	}
    }
    //隐藏显示查询栏
    function queryBar(){
    	$("#Machine_Formula_search_form").toggle(500);
    }
    
    //导出
	function exportExcel(){
		var s_factory_s = getQueryString("factory");
		var url = "building/productionManagement/machine_Formula/export?s_factory_s="+s_factory_s;
		window.location.href=url;
	}
    
    //获取url上的参数
	function getQueryString(name) {
	    var result = window.location.search.match(new RegExp("[\?\&]" + name + "=([^\&]+)", "i"));
	    if (result == null || result.length < 1) {
	        return "";
	    }
	    return result[1];
	}
    
    //点击左边一行时，展示右边数据
    function selectrow() {
		var rows = $("#machine_formula_dg").datagrid('getSelected');
		var equipcode_s = rows.equip_code_s;
		var materialcode_s = rows.material_code_s;
		var productionstep_s = rows.production_step_s;
		var versions = rows.version_s;
		var url = "building/productionManagement/machine_Formula/datagrid2?equipcode_s="+equipcode_s
					+"&materialcode_s=" + materialcode_s+"&productionstep_s="+productionstep_s+
					"&versions="+versions;
		ext.ajax.get(url, function(data) {
			$('#machine_formula_dg2').datagrid('loadData', data);
		});
	}
    
    /**
     * 查询方法
     */
    var filter=function(){
    	var opts = $("#machine_formula_dg").datagrid("options");
		opts.url = 'building/productionManagement/machine_Formula/datagrid';
        ext.easyui.grid.search("machine_formula_dg","Machine_Formula_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("machine_formula_dg",{});
    }

    function edit() {
        var rows = $("#machine_formula_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#machine_formula_dg").datagrid("getRowIndex", rows[i]);
            $("#machine_formula_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#machine_formula_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#machine_formula_dg").datagrid("getRowIndex", rows[i]);
            $("#machine_formula_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#machine_formula_dg");

        var rows = dg.datagrid("getRows");
        var valid = false;
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
        ext.ajax.sendJson(saveChanges, {
            inserted : inserted,
            updated : updated,
            deleted : deleted
        }, function(data) {

            if (data.code!=OK) {
                ext.tip.error("<spring:message code="tip.error" />");
                return;
            }
            $("#machine_formula_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#machine_formula_dg").datagrid("rejectChanges");
    }

	$(document).ready(function() {
		filter();
	});

</script>