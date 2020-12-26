<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"halfpart/plateinoutrecord/plateinoutrecords/saveChanges";
      $(document).ready(function() {
		$('#start_time').datetimebox({
			value : '3/4/2010 00:00:00',
			required : false,
			showSeconds : true
		});
		$('#end_time').datetimebox({
			value : '3/4/2010 23:59:59',
			required : false,
			showSeconds : true
		});
	    filter();
	});
    function showOrHide(){
        if($("#PlateinoutRecords_search_form").is(":hidden")){
            $("#PlateinoutRecords_search_form").show();
        }else{
            $("#PlateinoutRecords_search_form").hide();
        }
    }
    
    var materialList=[];
    $.ajax({
        url:"sap/materials/getMaterialList",
        type:"get",
        dataType:"json",
        async:false,
        success:function(data){
        	materialList=data;
        }
    });
    
	/**
	 *数据字典传值
	 *
	 */
	function codeFormatter(v, r, i) {
 		return dictFormat(v);
	}
	
  // 接收combtree数据
	
	 
	var DICT_308=[];
	
	$.ajax({
		url:"dict/code/308",
		type:"get",
		dataType:"json",
		async:false,
		success:function(data){
			DICT_308=data;
		}
	});
     
    
    
    /**
     * 查询方法
     */
    var filter=function(){
     var opts = $("#plateinoutrecords_dg").datagrid("options");
		opts.url = 'halfpart/plateinoutrecord/plateinoutrecords/datagrid';
        ext.easyui.grid.search("plateinoutrecords_dg","PlateinoutRecords_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("plateinoutrecords_dg",{});
    }

    function edit() {
        var rows = $("#plateinoutrecords_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#plateinoutrecords_dg").datagrid("getRowIndex", rows[i]);
            $("#plateinoutrecords_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#plateinoutrecords_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#plateinoutrecords_dg").datagrid("getRowIndex", rows[i]);
            $("#plateinoutrecords_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#plateinoutrecords_dg");

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
            $("#plateinoutrecords_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#plateinoutrecords_dg").datagrid("rejectChanges");
    }
   
/* function onSelectMaterialCode(materialGroup){
       	$.ajax({
	   		url:'sap/materials/getMaterialByMaterialGroupList?materialGroup='+materialGroup.DICTCODE_S,
	   		type:"get",
	 		dataType:"json",
	   		success:function(data){
		        $('#materielcode_s').combobox('clear');
		        $('#materielcode_s').combobox('setValue',null);
		        $('#materielcode_s').combobox('loadData',data);
	 		 }
   		 }); 
     } */
</script>