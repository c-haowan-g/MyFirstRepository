<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"common/PlmQuickCheckLog/saveChanges";
    
    function showOrHide(){
        if($("#PlmQuickCheckLog_search_form").is(":hidden")){
            $("#PlmQuickCheckLog_search_form").show();
        }else{
            $("#PlmQuickCheckLog_search_form").hide();
        }
    }
    function codeFormatter(v, r, i) {
    	return dictFormat(v);
    }
  //审核状态
    function stateFormatter(v,r,i){
    	if(v==0){
    		return "未审核";
    	}else if(v==1){
    		return "已审核";
    	}else{
    		return v;
    	}
    }
  //是否启用颜色处理
	var cellStyler=function (value,row,index){
		if (value=="1"){
			return 'background-color:#ccff99;';
		}else if (value=="0"){
			return 'background-color:#ffcc99;';
		}
	};
	//配方阶段
    function stageFormatter(v,r,y){
    	if(v=="ZC")
    		return "正常";
    	else if(v=="SY")
    		return "不正常";
    	else
    		return v;
    }
    /*检验标准类型显示转换*/
	var inspectionstandardnameText=function (value, rowData, rowIndex){
		if(value=="327001"){
			return "考核标准";
		}else if(value=="327002"){
			return "检验标准";
		}
	};
	/*检验类型显示转换*/
	var typeforText=function (value, rowData, rowIndex){
		if(value=="329001"){
			return "门尼类";
		}else if(value=="329002"){
			return "硫变类";
		}else if(value=="329003"){
			return "硬度类";
		}else if(value=="329004"){
			return "比重类";
		}else if(value=="329005"){
			return "物性";
		}else if(value=="329006"){
			return "VMA";
		}else if(value=="329007"){
			return "其他";
		}
	};
	/*上下限值符号显示转换*/
	var limitforText=function (value, rowData, rowIndex){
		if(value=="0"){
			return "不包含";
		}else if(value=="1"){
			return "包含";
		}
	};
//点击左边一行时，展示右边数据
    
	var ISOneRow = 1;//判断是否是 datagrid的一行被触发  1表示是一行被点击，0表示超链接被点击
	$(function() {
		$("#plmquickchecklog_dg").datagrid({
			//单击事件
			onClickRow : function(index, row) {
				if (ISOneRow == 1) {
					ClikRow(row.recipe_code_s);
				} else {
					ISOneRow = 1;
				}
			}
		});

	});
    
	//点击行方法
	function ClikRow(value) {
		$("#recipe_code").textbox("setValue", value);
        
        var urlDetail="quickcheck/para/datagrid";
        
		$("#para_dg").datagrid("options").url = urlDetail;
		ext.easyui.grid.search("para_dg",
				"para_search_form");
		$("#para_dg").datagrid("reload");
	}
	
    /**
     * 查询方法
     */
    var filter=function(){
    	
        ext.easyui.grid.search("plmquickchecklog_dg","PlmQuickCheckLog_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("plmquickchecklog_dg",{});
    }

    function edit() {
        var rows = $("#plmquickchecklog_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#plmquickchecklog_dg").datagrid("getRowIndex", rows[i]);
            $("#plmquickchecklog_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#plmquickchecklog_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#plmquickchecklog_dg").datagrid("getRowIndex", rows[i]);
            $("#plmquickchecklog_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#plmquickchecklog_dg");

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
            $("#plmquickchecklog_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#plmquickchecklog_dg").datagrid("rejectChanges");
    }


</script>