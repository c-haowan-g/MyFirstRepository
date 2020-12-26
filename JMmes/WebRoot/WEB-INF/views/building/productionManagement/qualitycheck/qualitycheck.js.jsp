<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"building/productionManagement/qualitycheck/saveChanges";
    
    function showOrHide(){
        if($("#Qualitycheck_search_form").is(":hidden")){
            $("#Qualitycheck_search_form").show();
        }else{
            $("#Qualitycheck_search_form").hide();
        }
    }
    
    function isrcks(v,r,i){
		if(v=='0')
			return '未复检'
		else if(v=='1')
			return '已复检过'
	
		else
			return ''
	}
    
    
    /**
     * 查询方法
     */
    var filter=function(){
    	var opts = $("#qualitycheck_dg").datagrid("options");
    	opts.url= 'building/productionManagement/qualitycheck/datagrid';
        ext.easyui.grid.search("qualitycheck_dg","Qualitycheck_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("qualitycheck_dg",{});
    }

    function edit() {
        var rows = $("#qualitycheck_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#qualitycheck_dg").datagrid("getRowIndex", rows[i]);
            $("#qualitycheck_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#qualitycheck_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#qualitycheck_dg").datagrid("getRowIndex", rows[i]);
            $("#qualitycheck_dg").datagrid("deleteRow", index);
        }

    }

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
		//filter();
	});

    function save() {
        var dg = $("#qualitycheck_dg");

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
            $("#qualitycheck_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#qualitycheck_dg").datagrid("rejectChanges");
    }

	
     var DICT_194=[];
   
    	$.ajax({
    		url:"dict/code/194",
    		type:"get",
    		dataType:"json",
    		async:false,
    		success:function(data){
    			DICT_194=data;
    		}
    	});
    	
    
    	
    	function codeFormatter(v, r, i) {

    		return dictFormat(v);
    	}

</script>