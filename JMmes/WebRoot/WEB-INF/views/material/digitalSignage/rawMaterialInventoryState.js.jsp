<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
//表格数据滚动
function runTable() {
    var tr = $("table.datagrid-btable tbody").find("tr").html();
    $("table.datagrid-btable tbody tr:first").remove();
    $("table.datagrid-btable tbody").append("<tr>" + tr + "</tr>");
}

$(function () {  
    setInterval("runTable()", 1000);  
});  
function codeFormatter(v, r, i) {

    return dictFormat(v);
}

function isQualified(v,r,i){
    if("0"==r.send_state_s){
        return "未下发";
    }else if("1"==r.send_state_s){
        return "已下发";
    }else if("2"==r.send_state_s){
        return "下发失败";
    }else{
        return "";
    }
}
</script>