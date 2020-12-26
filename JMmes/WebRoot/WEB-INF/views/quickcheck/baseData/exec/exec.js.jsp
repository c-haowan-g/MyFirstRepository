<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"quickcheck/plmexec/saveChanges";
    
    function showOrHide(){
        if($("#exec_search_form").is(":hidden")){
            $("#exec_search_form").show();
        }else{
            $("#exec_search_form").hide();
        }
    }
    
    var DICT_332=[];
 	
 	$.ajax({
 		url:"dict/code/332",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			DICT_332=data;
 		}
 	});
 	
    var DICT_327=[];
 	
 	$.ajax({
 		url:"dict/code/327",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			DICT_327=data;
 		}
 	});
 	/*审核转换*/
	var recordflagText=function (value, rowData, rowIndex){
		if(value=="0"){
			return "已审核";
		}else if(value=="1"){
			return "未审核";
		}
	};
	/*配方阶段转换*/
	var prescriptionstageText=function (value, rowData, rowIndex){
		if(value=="332001"){
			return "正常";
		}else if(value=="332002"){
			return "不正常";
		}else if(value=="332003"){
			return "实验";
		}
	};
	/*检验标准类型显示转换*/
	var inspectionstandardnameText=function (value, rowData, rowIndex){
		if(value=="327001"){
			return "考核标准";
		}else if(value=="327002"){
			return "检验标准";
		}
	};
	
	/*配方状态显示转换*/
	var recipestatusText=function (value, rowData, rowIndex){
		if(value=="323001"){
			return "待用";
		}else if(value=="323002"){
			return "正用";
		}else if(value=="323003"){
			return "停用";
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
	//是否启用颜色处理
	var cellStyler=function (value,row,index){
		if (value=="0"){
			return 'background-color:#ccff99;';
		}else if (value=="1"){
			return 'background-color:#ffcc99;';
		}
	};
 	
	//审核
    function audit() {
    	var dg = $("#exec_dg");
		var rows = dg.datagrid("getSelections");
		
		
		if(rows.length==0){
    		ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
    		return;
    	}
		Utils.each(rows,function(i,r){
			
				if(r.check_state_s=="0"){
					 ext.tip.error("<spring:message code="已审核，无需再次审核" />");
				}if(r.check_state_s=="1"){
					 for (var i = 0; i < rows.length; i++) {
						 rows[i]["check_state_s"]="0";
						}
					
					ext.ajax.sendJson(saveChanges, {
						updated:rows
					}, function(data) {
						if (data.message != 'ok') {
							 ext.tip.error("<spring:message code="tip.error" />");
						}else{
							 $("#exec_dg").datagrid("reload"); 
							 ext.tip.suc("<spring:message code="tip.success" />");
						}
			
					});
				}
			
			
		});
		
	
		 
    }
  //撤销审核
    function cancelaudit() {
    	var dg = $("#exec_dg");
		var rows = dg.datagrid("getSelections");
		if(rows.length==0){
    		ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
    		return;
    	}
		Utils.each(rows,function(i,r){
			if(r.send_state_s=="1"){
				ext.tip.error("<spring:message code="该审核已下发，不能继续操作" />");
			}if(r.send_state_s=="0"){
				if(r.check_state_s=="1"){
					 ext.tip.error("<spring:message code="未审核，审核无需取消" />");
				}if(r.check_state_s=="0"){
					 for (var i = 0; i < rows.length; i++) {
						 rows[i]["check_state_s"]="1";
						}
					
					ext.ajax.sendJson(saveChanges, {
						updated:rows
					}, function(data) {
						if (data.message != 'ok') {
							 ext.tip.error("<spring:message code="tip.error" />");
						}else{
							 $("#exec_dg").datagrid("reload"); 
							 ext.tip.suc("<spring:message code="tip.success" />");
						}
			
					});
				}
			}
			
	
		});
    }
  //下发操作
 	function issue(){
 		var dg = $("#exec_dg");
		var rows = dg.datagrid("getSelections");
		if(rows.length==0){
    		ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
    		return;
    	}
		Utils.each(rows,function(i,r){
			if(r.check_state_s=="1"){
				ext.tip.error("<spring:message code="未审核，请审核后再发" />");
			}if(r.check_state_s=="0"){
				if(r.send_state_s=="1"){
					 ext.tip.error("<spring:message code="已下发，不能继续操作" />");
				}if(r.send_state_s=="0"){
					for (var i = 0; i < rows.length; i++) {
						 rows[i]["send_state_s"]="1";
						}
					
					ext.ajax.sendJson(saveChanges, {
						updated:rows
					}, function(data) {
						if (data.message != 'ok') {
							 ext.tip.error("<spring:message code="tip.error" />");
						}else{
							 $("#exec_dg").datagrid("reload"); 
							 ext.tip.suc("<spring:message code="tip.success" />");
						}
			
					});
				}
			}
			
			

			
	     
		});  
  }
  
  //点击左边一行时，展示右边数据
    
	var ISOneRow = 1;//判断是否是 datagrid的一行被触发  1表示是一行被点击，0表示超链接被点击
	$(function() {
		$("#exec_dg").datagrid({
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
		$("#recipe_code_s").textbox("setValue", value);
        
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
        ext.easyui.grid.search("exec_dg","exec_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("exec_dg",{});
    }

    function edit() {
        var rows = $("#exec_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#exec_dg").datagrid("getRowIndex", rows[i]);
            $("#exec_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#exec_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#exec_dg").datagrid("getRowIndex", rows[i]);
            $("#exec_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#exec_dg");

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
            $("#exec_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#exec_dg").datagrid("rejectChanges");
    }


</script>