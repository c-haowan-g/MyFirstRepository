<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"finalcheck/reportCenter/JudgeNumber/saveChanges";
    var saveChangesGrade=path+"finalcheck/reportCenter/JudgeNumberGrade/saveChanges";
    var saveChangesItem=path+"finalcheck/reportCenter/JudgeNumberItem/saveChanges";
    /**
     * 接收combox数据
     */
     var DICT_253=[];
 	
 	$.ajax({
 		url:"dict/code/253",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			DICT_253=data;
 		}
 	});
 	
 	  /**
     * 接收左下角的等级信息
     */
     var DICT_Grade=[];
 	
 	/* $.ajax({
 		url:"finalcheck/reportCenter/JudgeNumberGrade/comboxGrade",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			DICT_Grade=data;
 		}
 	}); */
 	
    /**
     * 接收combox数据
     */
     var DICT_254=[];
 	
 	$.ajax({
 		url:"dict/code/254",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			DICT_254=data;
 		}
 	});
     function codeFormatter(v,r,i){
    	
    	return dictFormat(v);
     }
     
    function entTypeFormatter(v,r,i){
        if(v==254004){
        	return "动平衡";
        }else if(v==254005){
        	return "均匀性";
        }else{
        	return "";
        }
    }
    function showOrHide(){
        if($("#JudgeNumber_search_form").is(":hidden")){
            $("#JudgeNumber_search_form").show();
        }else{
            $("#JudgeNumber_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
    	var enttype_s = $("#enttype_s").val();
		if (enttype_s == "" || enttype_s == null) {
			ext.tip.error("<spring:message code="tip.selectEntType" />");
			return;
		}
    	var opts = $("#judgenumber_dg").datagrid("options");
		opts.url = 'finalcheck/reportCenter/JudgeNumber/datagrid';
        ext.easyui.grid.search("judgenumber_dg","JudgeNumber_search_form");
        $("#judgenumbergrade_dg").datagrid("loadData",[]);
        $("#judgenumberitem_dg").datagrid("loadData",[]);
    }
    
    function add() {
    	var dg = $("#judgenumber_dg");
        var rows = dg.datagrid("getRows");
        var judgeNo="";
        if(rows.length==0){
        	judgeNo=1;
        }else{
        	judgeNo=rows.length+1;
        }
        console.log(rows.length);
    	var row={enttype_s:254004,
    			judgeno_s:judgeNo,
    			itemcount_s:0};
        ext.easyui.grid.appendAndEdit("judgenumber_dg",row);
    }

    function edit() {
        var rows = $("#judgenumber_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#judgenumber_dg").datagrid("getRowIndex", rows[i]);
            $("#judgenumber_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#judgenumber_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#judgenumber_dg").datagrid("getRowIndex", rows[i]);
            $("#judgenumber_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#judgenumber_dg");

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
            	debugger
                ext.tip.error(data.message);
            	$("#judgenumber_dg").datagrid("reload");
                return;
            }
            $("#judgenumber_dg").datagrid("reload");
            $("#judgenumbergrade_dg").datagrid("reload");
            $("#judgenumberitem_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#judgenumber_dg").datagrid("rejectChanges");
    }

    
    //以上为上方页面的相关操作
     /**
     * 查询方法
     */
    var filterNumberRow=function(){
    	var rowNumber = $("#judgenumber_dg").datagrid('getSelected');
    	var judgeNumber = rowNumber.judgeno_s;
    	var enttype_s=rowNumber.enttype_s;
    	//查询左下方
    	var opts = $("#judgenumbergrade_dg").datagrid("options");
		opts.url = 'finalcheck/reportCenter/JudgeNumberGrade/datagrid1?judgeno_s=' + judgeNumber+ "&enttype_s="+ enttype_s;
        ext.easyui.grid.search("judgenumbergrade_dg","JudgeNumberGrade_search_form");
        //查询右下方
        var opts = $("#judgenumberitem_dg").datagrid("options");
		opts.url = 'finalcheck/reportCenter/JudgeNumberItem/datagrid1?judgeno_s=' + judgeNumber+ "&enttype_s="+ enttype_s;
        ext.easyui.grid.search("judgenumberitem_dg","JudgeNumberItem_search_form");
    }
    
    function addgrade() {
        var rowNumber = $("#judgenumber_dg").datagrid('getSelected');
		if (rowNumber == null) {
			ext.tip.error("<spring:message code='tip.selectJudgeNum'/>");
			return;
		}
        ext.easyui.grid.appendAndEdit("judgenumbergrade_dg",{});
    }

    function editgrade() {
        var rows = $("#judgenumbergrade_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#judgenumbergrade_dg").datagrid("getRowIndex", rows[i]);
            $("#judgenumbergrade_dg").datagrid("beginEdit", index);
        }
    }

    function removegrade() {

        var rows = $("#judgenumbergrade_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#judgenumbergrade_dg").datagrid("getRowIndex", rows[i]);
            $("#judgenumbergrade_dg").datagrid("deleteRow", index);
        }

    }

    function savegrade() {
        var dg = $("#judgenumbergrade_dg");

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
        var rowNumber = $("#judgenumber_dg").datagrid('getSelected');
        
		if (rowNumber == null) {
			ext.tip.error("<spring:message code='tip.selectJudgeNum'/>");
			return;
		}
        Utils.each(inserted, function(i, d) {
			d.judgeno_s = rowNumber.judgeno_s;
			d.enttype_s=rowNumber.enttype_s;
		});
        ext.ajax.sendJson(saveChangesGrade, {
            inserted : inserted,
            updated : updated,
            deleted : deleted
        }, function(data) {
        	if (data.code!=OK) {
        		$("#judgenumber_dg").datagrid("reload");
        		filterNumberRow();
                ext.tip.error("<spring:message code="tip.dynamicGradeError" />");
                return;
            }
        	 $("#judgenumbergrade_dg").datagrid("reload");
             $("#judgenumber_dg").datagrid("reload");
             ext.tip.suc("<spring:message code="tip.success" />");
             
        	/* var rowNumber = $("#judgenumber_dg").datagrid('getSelected');
        	var judgeNumber = rowNumber.judgeno_s;
        	var enttype_s=rowNumber.enttype_s;
        	//查询左下方
        	var opts = $("#judgenumbergrade_dg").datagrid("options");
    		opts.url = 'finalcheck/reportCenter/JudgeNumberGrade/datagrid1?judgeno_s=' + judgeNumber+ "&enttype_s="+ enttype_s;
            ext.easyui.grid.search("judgenumbergrade_dg","JudgeNumberGrade_search_form"); */

        });
    }

    function cancelgrade() {
        $("#judgenumbergrade_dg").datagrid("rejectChanges");
    }
    
    //以上为下方左侧页面的操作
     /**
     * 查询方法
     */
    var filterItem=function(){
        ext.easyui.grid.search("judgenumberitem_dg","JudgeNumberItem_search_form");
    }
    
    function addItem() {
    	 var rowNumber = $("#judgenumber_dg").datagrid('getSelected');
 		if (rowNumber == null) {
 			ext.tip.error("<spring:message code='tip.selectJudgeNum'/>");
 			return;
 		}
	    var entType = rowNumber.enttype_s;
 		//查询右下方
    	var opts = $("#material_dg").datagrid("options");
		opts.url =  "finalcheck/reportCenter/JudgeNumberItem/getJudgeItems?entType="+entType;
    	$("#menu_dlg").dialog("open");
    }

    function editItem() {
        var rows = $("#judgenumberitem_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#judgenumberitem_dg").datagrid("getRowIndex", rows[i]);
            $("#judgenumberitem_dg").datagrid("beginEdit", index);
        }
    }

    function removeItem() {

        var rows = $("#judgenumberitem_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#judgenumberitem_dg").datagrid("getRowIndex", rows[i]);
            $("#judgenumberitem_dg").datagrid("deleteRow", index);
        }

    }

    function saveItem() {
        var dg = $("#judgenumberitem_dg");
       
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
        var rowNumber = $("#judgenumber_dg").datagrid('getSelected');
        var judgeNumber=null;
        var judgeEnttype=null;
        if(rowNumber!=null){
    	judgeNumber = rowNumber.judgeno_s;
    	judgeEnttype = rowNumber.enttype_s;
        }
		Utils.each(inserted, function(i, d) {
			d.judgeno_s = judgeNumber;
			d.enttype_s=judgeEnttype;
			delete d.recipeno_s;
		});
		Utils.each(deleted, function(i, d) {
			delete d.recipeno_s;
		});
        ext.ajax.sendJson(saveChangesItem, {
            inserted : inserted,
            updated : updated,
            deleted : deleted
        }, function(data) {

            if (data.code!=OK) {
                ext.tip.error("<spring:message code="tip.error" />");
                return;
            }
            $("#judgenumberitem_dg").datagrid("reload");
            
            $("#judgenumber_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />");
        });
    }
    function cancelToItem() {
		$("#menu_dlg").dialog("close");
	}
    //右下弹窗弹出时，清除掉过滤条件
    function load() {
		$("#material_dg").datagrid("removeFilterRule","materialcode_s");
		$("#material_dg").datagrid('reload');
	}
    //保存数据至judgeitem表
    function saveToItem() {
		dosaveToItemDlg();//将选择得物料信息追加到主界面得右下角得table
		$("#menu_dlg").dialog("close");//关掉弹出得选择物料界面
		//saveItem();
		
	}
    
    //将选择得物料信息追加到主界面得右下角得table
    function dosaveToItemDlg() {
		var rows = $("#material_dg").datagrid('getSelections');
		if (rows.length == 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		var Srows = $("#judgenumberitem_dg").datagrid('getRows');

		for (var i = 0; i < rows.length; i++) {
			var flag = true;
			for (var j = 0; j < Srows.length; j++) {
				if (Srows[j].itemid_s == rows[i].MATERIALCODE_S) {
					flag = false;
				}
			}
			if (flag) {
				$('#judgenumberitem_dg').datagrid('appendRow', {
					recipeno_s:rows[i].RECIPENO_S,
					itemid_s : rows[i].MATERIALCODE_S,
					itemdesc_s : rows[i].MATERIALDESC_S
				});
			}
		}
	}
    
    //初始化弹出界面
	$(function(){
		$("#material_dg").datagrid({
			fit:true,
            fitColumns:true,
            singleSelect:false,
            method:'get',
            emptyMsg:'<span><spring:message code='tip.noData'/></span>',
            striped:true,
			onLoadSuccess : function(data) {
				$(this).datagrid('enableFilter');
			}
		});
		filter();
	});
    

</script>