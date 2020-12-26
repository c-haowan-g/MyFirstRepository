<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"halfpart/productionManagement/qualitycheck/saveChanges";
    
    function showOrHide(){
        if($("#QualityCheck_search_form").is(":hidden")){
            $("#QualityCheck_search_form").show();
        }else{
            $("#QualityCheck_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("qualitycheck_dg","QualityCheck_search_form");
    }
    
    /**
	 * 半部件等级格式转换（1：合格  0：不合格）
	 */
	function gradeFormatter(v, r, i) {
	  if(v==0) {
		  return "不合格";
	  } else if(v==1) {
		  return "合格";
	  }
		return "";
	}
    
	/**
	 * 合并单元格
	 */
	function onLoadSuccess(data) {
		var mark = 1; //这里涉及到简单的运算，mark是计算每次需要合并的格子数
		for (var i = 1; i < data.rows.length; i++) { //这里循环表格当前的数据
			if ((data.rows[i]['materialcode_s'] == data.rows[i - 1]['materialcode_s'])) { //后一行的值与前一行的值做比较，相同就需要合并
				mark += 1;
				$(this).datagrid('mergeCells', { //判断合并复选框
					index : i + 1 - mark,
					field : 'atr_key',
					rowspan : mark
				});
				$(this).datagrid('mergeCells', { //这是判断机台号
					index : i + 1 - mark,
					field : 'materialcode_s',
					rowspan : mark
				});
			} else {
				mark = 1;
			}
		}
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


</script>