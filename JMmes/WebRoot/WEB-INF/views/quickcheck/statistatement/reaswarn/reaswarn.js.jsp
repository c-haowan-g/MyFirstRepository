<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"quickcheck/statistatement/reaswarn/saveChanges";
    
    function showOrHide(){
        if($("#reaswarn_search_form").is(":hidden")){
            $("#reaswarn_search_form").show();
        }else{
            $("#reaswarn_search_form").hide();
        }
    }
    //开关控制
    function formatOper(val, row, index) {

		var rows = $("#reaswarn_dg").datagrid("getRows");
		var row = rows[index];
		var unfold = row.dw_is_warm_s + "unfold";
		var shut = row.dw_is_warm_s + "shut";
	
		if (row.dw_is_warm_s == "0") {

			return '<a id='
			+ unfold
			+ ' style="background-color: #aaaa7f" href="javascript:void(0)" onclick="unfold('
			+ index
			+ ')">打开</a>&nbsp;&nbsp;&nbsp;<a id='
			+ shut
			+ ' background: #aaaa7f href="javascript:void(0)" onclick="shut('
			+ index + ')">关闭</a>';
			
		} else {

			return '<a id='
			+ unfold
			+ ' href="javascript:void(0)" onclick="unfold('
			+ index
			+ ')">打开</a>&nbsp;&nbsp;&nbsp;<a id='
			+ shut
			+ ' style="background-color: #aaaa7f"  href="javascript:void(0)" onclick="shut('
			+ index + ')">关闭</a>';
		}

	}
    //打开状态
    function unfold(index) {
    
		var dg = $("#reaswarn_dg");
		var rows = dg.datagrid("getSelections");
		Utils.each(rows,function(i,r){
			
				if(r.dw_is_warm_s=="0"){
					 ext.tip.error("<spring:message code="开关已打开" />");
				}if(r.dw_is_warm_s=="1"){
					 for (var i = 0; i < rows.length; i++) {
						 rows[i]["dw_is_warm_s"]="0";
						}
					
					ext.ajax.sendJson(saveChanges, {
						updated:rows
					}, function(data) {
						if (data.message != 'ok') {
							 ext.tip.error("<spring:message code="tip.error" />");
						}else{
							 $("#reaswarn_dg").datagrid("reload"); 
							 ext.tip.suc("<spring:message code="tip.success" />");
						}
			
					});
				}
			
			
		});
		
    }
    //关闭状态
    function shut(index) {

    	var dg = $("#reaswarn_dg");
		var rows = dg.datagrid("getSelections");
		Utils.each(rows,function(i,r){
			
				if(r.dw_is_warm_s=="1"){
					 ext.tip.error("<spring:message code="开关已关闭" />");
				}if(r.dw_is_warm_s=="0"){
					 for (var i = 0; i < rows.length; i++) {
						 rows[i]["dw_is_warm_s"]="1";
						}
					
					ext.ajax.sendJson(saveChanges, {
						updated:rows
					}, function(data) {
						if (data.message != 'ok') {
							 ext.tip.error("<spring:message code="tip.error" />");
						}else{
							 $("#reaswarn_dg").datagrid("reload"); 
							 ext.tip.suc("<spring:message code="tip.success" />");
						}
			
					});
				}
			
			
		});
    }	
    
    /**
     * 接收combtree数据
     */
     var DICT_261=[];
 	
 	$.ajax({
 		url:"dict/code/261",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			DICT_261=data;
 		}
 	});
 	function codeFormatter(v, r, i) {
		return dictFormat(v);
	}
 	
    /**
     * 接收combtree数据
     */
     var DICT_262=[];
 	
 	$.ajax({
 		url:"dict/code/262",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			DICT_262=data;
 		}
 	});
 	
 	/*停机条件转换*/
	var dwforText=function (value, rowData, rowIndex){
		if(value=="1"){
			return "同规格,同机台,同班次";
		}else if(value=="2"){
			return "不同机台，同一病象";
		}
	}
 	
	
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("reaswarn_dg","reaswarn_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("reaswarn_dg",{});
    }

    function edit() {
        var rows = $("#reaswarn_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#reaswarn_dg").datagrid("getRowIndex", rows[i]);
            $("#reaswarn_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#reaswarn_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#reaswarn_dg").datagrid("getRowIndex", rows[i]);
            $("#reaswarn_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#reaswarn_dg");

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
            $("#reaswarn_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#reaswarn_dg").datagrid("rejectChanges");
    }


</script>