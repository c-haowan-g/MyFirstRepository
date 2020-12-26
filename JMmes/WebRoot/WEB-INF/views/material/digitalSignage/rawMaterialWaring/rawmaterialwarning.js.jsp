<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    //表格数据滚动
function runTable() {

    var rows=$('#dg').datagrid('getRows');//获得全部行
  	
  	$('#dg').datagrid('appendRow',rows[0]);//将第一行添加到最后一行
  	$('#dg').datagrid('deleteRow',0);//删除第一行
    	$("table.datagrid-btable tbody tr").css('height','30px');
	$('.datagrid-header .datagrid-cell span').css('font-size','20px');
    	$('.datagrid-header .datagrid-cell span').css('font-weight','bold');
    	$('.datagrid-header .datagrid-cell span').css('color','blue');
	$('.datagrid-header .datagrid-cell').css('height','40px');
    	$('.datagrid-header .datagrid-cell').css('line-height','40px');
    /* var tr = $("table.datagrid-btable tbody").find("tr").html();
    $("table.datagrid-btable tbody tr:first").remove();
    $("table.datagrid-btable tbody").append("<tr>" + tr + "</tr>"); */
}
$(function () {  
    setInterval("runTable()", 1000);  
});  
function codeFormatter(v, r, i) {

    return dictFormat(v);
}
 //对过期时间字体增加颜色标
  
    function setRowBgColor(index,row){
        var time=new Date();
        //t1=new Date(time.toLocaleString());
        var t2=new Date(row.expiry_date_t);
        
        
        /* t1=Date.parse(time.toLocaleString());
        t2=Date.parse(row.expiry_date_t); */
       
        if(time>t2){
        
           return 'color:red;';
        }
        
    }
    
    /**
     * 查询方法
     */
    /* var filter=function(){
        ext.easyui.grid.search("rawmaterialwarning_dg","RawMaterialWarning_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("rawmaterialwarning_dg",{});
    }

    function edit() {
        var rows = $("#rawmaterialwarning_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#rawmaterialwarning_dg").datagrid("getRowIndex", rows[i]);
            $("#rawmaterialwarning_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#rawmaterialwarning_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#rawmaterialwarning_dg").datagrid("getRowIndex", rows[i]);
            $("#rawmaterialwarning_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#rawmaterialwarning_dg");

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
            $("#rawmaterialwarning_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#rawmaterialwarning_dg").datagrid("rejectChanges");
    } */


</script>