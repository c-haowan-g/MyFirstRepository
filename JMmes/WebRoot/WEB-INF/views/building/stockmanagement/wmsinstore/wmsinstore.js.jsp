<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"building/stockmanagement/wmsinstore/saveChanges";
    /**
    *初始加载
    */
    
    
    /**
	 *数据字典传值
	 *
	 */
	function codeFormatter(v, r, i) {

		return dictFormat(v);
	}
    
    function showOrHide(){
        if($("#WmsinStore_search_form").is(":hidden")){
            $("#WmsinStore_search_form").show();
        }else{
            $("#WmsinStore_search_form").hide();
        }
    }
   /**
   * 数据校验
   */
    function checktime(){
        var time1=$("#begin_created_time").val();
        var time2=$("#end_created_time").val();
        if(time1>time2){
            return false;
        }
        return true;
    }
    /**
     * 查询方法
     */
    var filter=function(){
        if(!checktime()){
            ext.tip.error("<spring:message code="tip.date" />");
            return false;
        }
        var opts = $("#wmsinstore_dg").datagrid("options");
        opts.url = 'building/stockmanagement/wmsinstore/datagrid';
        ext.easyui.grid.search("wmsinstore_dg","WmsinStore_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("wmsinstore_dg",{});
    }

    function edit() {
        var rows = $("#wmsinstore_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#wmsinstore_dg").datagrid("getRowIndex", rows[i]);
            $("#wmsinstore_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#wmsinstore_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#wmsinstore_dg").datagrid("getRowIndex", rows[i]);
            $("#wmsinstore_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#wmsinstore_dg");

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
            $("#wmsinstore_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }
    //装换重量
    function wightFormatter(v, r, i){
    
        if(v=='1')return '是';
        if(v=='0')return '否';
    
    }
    //是否合格
    function qualifiedFormatter(v, r, i){
    
        if(v=='1')return '是';
        if(v=='0')return '否';
    
    }
    function cancel() {
        $("#wmsinstore_dg").datagrid("rejectChanges");
    }
    //设定时间初始值从当前时间00:00:00至23:59:59
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
		filter();
		
	});

</script>