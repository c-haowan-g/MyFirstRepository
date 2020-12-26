<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
var i=1;
    /* var saveChanges=path+"mix/digitalSignage/mixsmallmaterial/saveChanges";
    
    function showOrHide(){
        if($("#MixSmallMaterial_search_form").is(":hidden")){
            $("#MixSmallMaterial_search_form").show();
        }else{
            $("#MixSmallMaterial_search_form").hide();
        }
    } */

  //表格数据滚动
function runTable() {
    var tr = $("table.datagrid-btable tbody").find("tr").html();
    $("table.datagrid-btable tbody tr:first").remove();
    $("table.datagrid-btable tbody").append("<tr>" + tr + "</tr>"); 
    /* var rows=$("#mixsmallmaterial_dg").datagrid("getRows");
    //通过跳转到指定行来实现滚动效果
    $("#mixsmallmaterial_dg").datagrid("scrollTo",i);
    i++;
    if(i>rows.length){
    i=0;}
     */
}
var cellStyler=function (value,row,index){
		if (value=="0"){
			return 'background-color:#ccff99;';
		}else if (value=="1"){
			return 'background-color:#ffcc99;';
		}
	}
$(function () {  
    setInterval("runTable()", 1000);  
   /*  $("#mixsmallmaterial_dg").datagrid({
		rowStyler:function(index,row){
			if((typeof row.outofdateflag_s) != "undefined"){
				var rate = row.outofdateflag_s;
				if (rate=='0'){
					return "background-color:lime;font-weight:bold;";
				}
				else if (rate=='1'){
					return "background-color:red;font-weight:bold;";
				}
			
			}
		}
	}); */
});  
function codeFormatter(v, r, i) {

    return dictFormat(v);
}  
   

</script>