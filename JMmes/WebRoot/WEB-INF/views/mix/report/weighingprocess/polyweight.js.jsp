<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"mix/report/weighingprocess/saveChanges";
    
    function showOrHide(){
        if($("#PolyWeight_search_form").is(":hidden")){
            $("#PolyWeight_search_form").show();
        }else{
            $("#PolyWeight_search_form").hide();
        }
    }
    
    /**
	 * 日期格式化
	 */
	function dateFormat(date) {
		return new Calendar(date).format("yyyyMMdd");
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
     *将数据库得值转换为数据字典与对应值域
     */           	
     function codeFormatter(v, r, i) {

     		return dictFormat(v);
     }
     	
    /**
     * 查询方法
     */
    var filter=function(){
    	var startTime= $('#receive_time_t').datebox("getValue");
	    var endTime= $('#end_time_t').datebox("getValue");
	    var wweight_type_s = $("#wweight_type_s").combobox("getText");
	    if((startTime!=""&&endTime=="")||(startTime==""&&endTime!="")){
	    	ext.tip.error("时间输入范围不完整");
	    	return;
	    }
    	var opts = $("#polyweight_dg").datagrid("options");
        opts.url = 'mix/report/weighingprocess/filter';
    	ext.easyui.grid.search("polyweight_dg","PolyWeight_search_form");
    	
    	
	    
    	var optss = $("#polyweight_dg3").datagrid("options");
        optss.url = 'mix/report/weighingprocess/filterpass';
    	ext.easyui.grid.search("polyweight_dg3","PolyWeight_search_form");
        //ext.easyui.grid.search("polyweight_dg","PolyWeight_search_form");
    }
    
     var equiplist=[];
    //加载胶料机台信息
    $.ajax({
        url:"mix/report/mixmonthlyreport/mixmonthlyreport/getMixProductionInfo?plantype="+"051003051001",
        type:"get",
        dataType:"json",
        async:false,
        success:function(data){
            equiplist=data;
        }
    });
    
    
    var wweightCodeContent=[];
    $.ajax({
        url:"dict/code/324",
        type:"get",
        dataType:"json",
        async:false,
        success:function(data){
        	wweightCodeContent=data;
        }
    });
    
    
    var shiftCodeContent=[];
    $.ajax({
        url:"dict/code/302",
        type:"get",
        dataType:"json",
        async:false,
        success:function(data){
            shiftCodeContent=data;
        }
    });
    
    function searchProductionLine(q, row) {
        var opts = $(this).combobox('options');
        return row[opts.textField].toUpperCase().indexOf(q.toUpperCase()) >= 0;
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("polyweight_dg",{});
    }

    function edit() {
        var rows = $("#polyweight_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#polyweight_dg").datagrid("getRowIndex", rows[i]);
            $("#polyweight_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#polyweight_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#polyweight_dg").datagrid("getRowIndex", rows[i]);
            $("#polyweight_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#polyweight_dg");

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
            $("#polyweight_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#polyweight_dg").datagrid("rejectChanges");
    }
    function exportExcel(){
    	var receive_time_t= $('#receive_time_t').datebox("getValue");
	    var end_time_t= $('#end_time_t').datebox("getValue");
	    var shift_code_s=$('#shift_code_s').combotree("getValue") ;
	    var equip_code_s=$('#equip_code_s').combobox("getValue") ;
	    var wweight_type_s=$('#wweight_type_s').combotree("getValue") ;
	    var warning_sgn_s=$('#warning_sgn_s').combobox("getValue") ;
	    var material_name_s=$('#material_name_s').textbox("getValue") ;
 			window.open(path+"mix/report/weighingprocess/exprot?s_factory_s=2&receive_time_t="+receive_time_t+"&end_time_t="+end_time_t+"&shift_code_s="+shift_code_s+"&equip_code_s="+equip_code_s+"&wweight_type_s="+wweight_type_s+"&warning_sgn_s="+warning_sgn_s+"&material_name_s="+material_name_s+"&type=export");	
  }

</script>