<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"common/plm/CarWash/saveChanges";
    
    function showOrHide(){
        if($("#CarWash_search_form").is(":hidden")){
            $("#CarWash_search_form").show();
        }else{
            $("#CarWash_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("carwash_dg","CarWash_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("carwash_dg",{});
    }

    function edit() {
        var rows = $("#carwash_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#carwash_dg").datagrid("getRowIndex", rows[i]);
            $("#carwash_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#carwash_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#carwash_dg").datagrid("getRowIndex", rows[i]);
            $("#carwash_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#carwash_dg");

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
        
        	if (data.code == 1) {
				ext.tip.error(data.message);
				return;
			}

            if (data.code!=OK) {
                ext.tip.error("<spring:message code="tip.error" />");
                return;
            }
            $("#carwash_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#carwash_dg").datagrid("rejectChanges");
    }
	function codeFormatter(v, r, i) {

		return dictFormat(v);
	}
	function sendstateFormatter(v, r, i) {
		if (v == 0) {
			return "启用";
		} else if (v == 1) {
			return "停用";
		} else {
			return v;
		}
	}
	
	var signContent = [];
	$.ajax({
		url : "dict/code/-342",
		type : "get",
		dataType : "json",
		async : false,
		success : function(data) {
			signContent = data;
		}
	});
	function getEditor(index, field) {
		return $("#carwash_dg").datagrid("getEditor", {
			index : index,
			field : field
		});
	};

	function onCarWash(value) {
		console.info(value);
		var index = $(this).parents("[datagrid-row-index]").attr(
				"datagrid-row-index");
		if ('0' == value.value) {
			$(getEditor(index, "recipe_name_carwash_s").target).textbox(
					'setValue', "");
			$(getEditor(index, "carwash_num_i").target).textbox('setValue', "");
			$(getEditor(index, "recipe_code_carwash_s").target).textbox(
					'setValue', "");
		}
		var carwash_num_i = $(getEditor(index, "carwash_num_i").target)
				.textbox('getValue');
		if (('1' == value.value || '2' == value.value) && ("" == carwash_num_i)) {
			$(getEditor(index, "carwash_num_i").target).textbox('setValue', 2);
		}

	}

	var washRecipeName = [];

	function onRecipeName(value) {
		console.info(value);
		var index = $(this).parents("[datagrid-row-index]").attr(
				"datagrid-row-index");
		if ('' != value.RECIPE_CODE_S) {
			$(getEditor(index, "recipe_code_s").target).textbox('setValue',
					value.RECIPE_CODE_S);
			//            $(getEditor(index, "RECIPE_NAME_CARWASH_S").target).textbox('setValue',value.RECIPE_NAME_CARWASH_S);
			purl = 'common/plm/CarWash/getWashRecipeInfo?mater_type_s='
					+ value.MATER_TYPE_S + "&recipe_code_s="
					+ value.RECIPE_CODE_S;
			if ("" != value.MATER_TYPE_S && "" != value.RECIPE_CODE_S) {
				$.ajax({
					url : purl,
					type : "get",
					dataType : "json",
					async : false,
					success : function(data) {
						/*      washRecipeName=data;
						//                        var washValue=[];
						      var washValue=[];
						      for(var i=0;i<washRecipeName.length;i++){
						          washValue.push(washRecipeName[i].RECIPE_CODE_NAME_S);
						      }
						      console.info("值来");
						      console.info(washValue);*/
						/* $(getEditor(index, "recipe_name_carwash_s").target)
								.combobox('loadData', data); */
					}
				});
			}
		}
	}
	function onWashRecipeName(value) {
		console.info(value);
		var index = $(this).parents("[datagrid-row-index]").attr(
				"datagrid-row-index");
		if ('' != value.RECIPE_CODE_S) {
			$(getEditor(index, "recipe_code_carwash_s").target).textbox(
					'setValue', value.RECIPE_CODE_S);
		}
	}

	purl = 'common/plm/CarWash/getRecipeInfo';
	var recipeName = [];
	$.ajax({
		url : purl,
		type : "get",
		dataType : "json",
		async : false,
		success : function(data) {
			recipeName = data;
		}
	});

	//启用
	function start() {

		var row = $("#carwash_dg").datagrid('getSelections');

		if (row.length <= 0) {
			ext.tip.error("请至少选择一行数据");
			return;
		}

		for (var i = 0; i < row.length; i++) {
			row[i].carwash_status_s = "0";

		}

		var gzwhurl = path + "common/plm/CarWash/saveChanges";
		ext.ajax.sendJson(gzwhurl, {
			updated : row,
		}, function(data) {
			if (data.code != OK) {
				ext.tip.error("<spring:message code="tip.error" />");
				return;
			}
			$("#carwash_dg").datagrid("reload");
			ext.tip.suc("<spring:message code="tip.success" />");

		});

	}
	//停用
	function stop() {

		var row = $("#carwash_dg").datagrid('getSelections');

		if (row.length <= 0) {
			ext.tip.error("请至少选择一行数据");
			return;
		}

		for (var i = 0; i < row.length; i++) {
			row[i].carwash_status_s = "1";

		}

		var gzwhurl = path + "common/plm/CarWash/saveChanges";
		ext.ajax.sendJson(gzwhurl, {
			updated : row,
		}, function(data) {
			if (data.code != OK) {
				ext.tip.error("<spring:message code="tip.error" />");
				return;
			}
			$("#carwash_dg").datagrid("reload");
			ext.tip.suc("<spring:message code="tip.success" />");

		});

	}

</script>