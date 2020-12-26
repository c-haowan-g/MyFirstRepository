<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"building/stockmanagement/storagearea/saveChanges";
    
    function showOrHide(){
        if($("#Storagearea_search_form").is(":hidden")){
            $("#Storagearea_search_form").show();
        }else{
            $("#Storagearea_search_form").hide();
        }
    }
     //设定时间初始值从当前时间00:00:00至23:59:59
	$(document).ready(function() {
		$('#start_time').datetimebox({
			value : '3/4/2010 00:00:00',
			required : true,
			showSeconds : true
		});
		$('#end_time').datetimebox({
			value : '3/4/2010 23:59:59',
			required : true,
			showSeconds : true
		});
		filter();
	});
	
	 /* 获取参数类型 */
     var basetypesList=[];
   	$.ajax({
	        url:'building/stockmanagement/storagearea/searchUsercode',
	        type:'get',
	        dataType:'json',
	        async:false,
	        success:function(data){
	        	basetypesList=data;
	        }});
	   /**
    * 参数显示显示转化
    * ldx
    */
    function operatorFormatter(v, r, i){
         for(var i=0;i<basetypesList.length;i++){
            if (v == basetypesList[i].USERCODE) {
                return basetypesList[i].USERNAME;
            }
          }
    } 
	 function isprimary_material(v, r, i) {
		if(v == "106001" ){
			return "合格"; 
		}else if(v == "106002"){
			return "不合格"; 
		}
	}
	function stocktype_sformatter(v, r, i) {
		if(v == "112001" ){
			return "投入线边库"; 
		}else if(v == "112002"){
			return "产出线边库"; 
		}else if(v == "112003"){
			return "正式库"; 
		}else if(v == "112004"){
			return "产出虚拟库"; 
		}else if(v == "112005"){
			return "投入虚拟库"; 
		}else if(v == "112006"){
			return "盘库虚拟库"; 
		}else if(v == "112007"){
			return "不合格区"; 
		}
	}
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("storagearea_dg","Storagearea_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("storagearea_dg",{});
    }

    function edit() {
        var rows = $("#storagearea_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#storagearea_dg").datagrid("getRowIndex", rows[i]);
            $("#storagearea_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#storagearea_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#storagearea_dg").datagrid("getRowIndex", rows[i]);
            $("#storagearea_dg").datagrid("deleteRow", index);
        }

    }
function codeFormatter(v, r, i) {

		return dictFormat(v);
	}
    function save() {
        var dg = $("#storagearea_dg");

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
            $("#storagearea_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#storagearea_dg").datagrid("rejectChanges");
    }


</script>