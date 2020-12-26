<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"halfpart/productionManagement/shifthandoverRecord/saveChanges";
    
    function showOrHide(){
        if($("#ShifthandoverRecord_search_form").is(":hidden")){
            $("#ShifthandoverRecord_search_form").show();
        }else{
            $("#ShifthandoverRecord_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
    	var opts = $("#shifthandoverrecord_dg").datagrid("options");
		opts.url = 'halfpart/productionManagement/shifthandoverRecord/datagrid';
		ext.easyui.grid.search("shifthandoverrecord_dg","ShifthandoverRecord_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("shifthandoverrecord_dg",{});
    }

    function edit() {
        var rows = $("#shifthandoverrecord_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#shifthandoverrecord_dg").datagrid("getRowIndex", rows[i]);
            $("#shifthandoverrecord_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#shifthandoverrecord_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#shifthandoverrecord_dg").datagrid("getRowIndex", rows[i]);
            $("#shifthandoverrecord_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#shifthandoverrecord_dg");

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
            $("#shifthandoverrecord_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#shifthandoverrecord_dg").datagrid("rejectChanges");
    }
    /**
     * 班次显示转化
     * 兰颖慧
     * 2019-08-01
     */
    var classList=[];
    $.ajax({
        url:"dict/code/118",
        type:"get",
        dataType:"json",
        async:false,
        success:function(data){
        	classList=data;
        }
        });
    function classCodeFormatter(v, r, i) {
    	for(var i=0;i<classList.length;i++){
    		 if (v == classList[i].code) {
    	          return classList[i].text;
    	     }
    	}
       
      }
    
    var productLineList = [];
    $.ajax({
        url: "halfpart/basedata/productlinemanager/getHalfPartProductionLine",
        type: "get",
        dataType: "json",
        async: false,
        success: function (data) {
            productLineList = data;
        }
    });
    function equipCodeFormatter(v, r, i) {
    	for(var i=0;i<productLineList.length;i++){
    		 if (v == productLineList[i].P_LINE_NAME) {
    	          return productLineList[i].DESCRIPTION;
    	     }
    	}
       
      }
    
    
    $(document).ready(function() {
		$('#planstarttime_t').datetimebox({
			value : '3/4/2010 00:00:00',
			required : false,
			showSeconds : true
		});
		$('#planfinishtime_t').datetimebox({
			value : '3/4/2010 23:59:59',
			required : false,
			showSeconds : true
		});
	    filter();
	});

</script>