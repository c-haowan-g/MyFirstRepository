<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"halfpart/productionManagement/qualityinfo/saveChanges";
    
    function showOrHide(){
        if($("#Qualityinfo_search_form").is(":hidden")){
            $("#Qualityinfo_search_form").show();
        }else{
            $("#Qualityinfo_search_form").hide();
        }
    }
    
    $(function(){
    	
    });
    
    /**
     * 物料组显示转化
     * 兰颖慧
     * 2019-05-24
     */
    var materialGroupList = [];
    $.ajax({
        url: "sap/materials/getMaterialGroupList",
        type: "get",
        dataType: "json",
        async: true,
        success: function (data) {
            materialGroupList = data;
        }
    });

    /**
     * 物料组显示转化
     * 2019-05-20
     * 兰颖慧
     */
    function materialGroupFormatter(v, r, i) {
        for (var i = 0; i < materialGroupList.length; i++) {
            if (v == materialGroupList[i].DICTCODE_S) {
                return materialGroupList[i].DICTNAME_S;
            }
        }
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
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("qualityinfo_dg","Qualityinfo_search_form");
    }
    
    /**
     * 物料组显示转化
     * 2020-11-26
     * gyx
     */
    function materialGroupFormatter(v, r, i) {
        for (var i = 0; i < materialGroupList.length; i++) {
            if (v == materialGroupList[i].DICTCODE_S) {
                return materialGroupList[i].DICTNAME_S;
            }
        }
    }
    
    var number = null;
    function add() {
    	var urlPlanNo = 'halfpart/productionManagement/qualityinfo/getMaxNo'; //获取最大病象编号
    	var rows = {};
        $.ajax({
            url: urlPlanNo,
            type: 'get',
            dataType: 'json',
            async: true,
            success: function (data) {
            	if(number >= data){
            		++number;
            	}else{
	            	number = parseInt(data, 10);
	            	++number;
            	}
                rows.sickelephants_no_s = number,
                ext.easyui.grid.appendAndEdit("qualityinfo_dg", rows);
            }
        });
    }

    function edit() {
        var rows = $("#qualityinfo_dg").datagrid("getSelections");
        var index = -1;
        if(rows.length == 0){
        	ext.tip.error("请选择一条数据!");
            return;
        }
        for (var i = 0; i < rows.length; i++) {
            index = $("#qualityinfo_dg").datagrid("getRowIndex", rows[i]);
            $("#qualityinfo_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#qualityinfo_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#qualityinfo_dg").datagrid("getRowIndex", rows[i]);
            $("#qualityinfo_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#qualityinfo_dg");

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
            if (data.code == 'no') {
                ext.tip.error("该编号已存在，请勿重复添加");
                $("#qualityinfo_dg").datagrid("reload");
                return;
            }
            $("#qualityinfo_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#qualityinfo_dg").datagrid("rejectChanges");
    }


</script>