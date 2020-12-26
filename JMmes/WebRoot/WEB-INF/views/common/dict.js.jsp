<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	function typeFormatter(node) {
		return node["typeName" + getLanguageSuffix()];
	}

	  /**
     * 查询方法
     */
    var filter=function(){
    	var opts = $("#dict_dg").datagrid("options");
        opts.url = 'dict/datagrid?all=1';
        ext.easyui.grid.search("dict_dg","CoreDictionary_search_form");
    }
	
	
	
	$(function() {
		var dg = $("#dict_dg").datagrid({
			//fit : true,
			//fitColumns : true,
			pagination : false,
			rownumbers : true,
			singleSelect : true,
			method : 'get',
			emptyMsg : '暂无数据',
			striped : true,
			toolbar : '#dict_dg_toolbar',
			onBeforeLoad : onBeforeLoad,
			rowStyler : styler,
			onLoadSuccess : function(data) {
				$("#dict_dg").datagrid("enableFilter");
			}
		});
	});
	
	function onSelect(node){
		
		$("#dictTree").tree("expand",node.target);
		$('#dictcode_s').textbox("setValue","");
		$('#dictname_s').textbox("setValue","");
		$("#dict_dg").datagrid("reload");
		
	}


	function formatter(node) {
		if (node.id == -1) {
			return node.text;
		}
		return node.code + "|" + node["text"];

	}

	function add() {

		var row = $("#dictTree").tree("getSelected");

		var _row = {
			deleted_i : 0
		};

		if (row.id == -1) {
			_row.pid_i = null;
		} else {
			_row.pid_i = row.id;
		}

		ext.easyui.grid.appendAndEdit("dict_dg", _row);

		/* $("#dict_dg").datagrid("appendRow", _row);

		var rows = $("#dict_dg").datagrid("getRows");
		$("#dict_dg").datagrid("beginEdit", rows.length - 1); */

	}

	function edit() {

		var rows = $("#dict_dg").datagrid("getSelections");
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			if (rows[i].deleted == 1) {
				ext.tip.warn("无效字典数据无法更改");
				continue;
			}
			index = $("#dict_dg").datagrid("getRowIndex", rows[i]);
			$("#dict_dg").datagrid("beginEdit", index);
		}
	}

	function remove() {

		var rows = $("#dict_dg").datagrid("getSelections");
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#dict_dg").datagrid("getRowIndex", rows[i]);
			$("#dict_dg").datagrid("deleteRow", index);
		}
	}

	function getLevel(node, level) {
		if ($("#dictTree").tree("getParent", node.target) == null) {
			return level;
		} else {
			return getLevel($("#dictTree").tree("getParent", node.target),
					++level);
		}
	}

	function save() {
		var dg = $("#dict_dg");

		var rows = dg.datagrid("getRows");
		var valid = false;
		for (var i = 0; i < rows.length; i++) {
			if (!dg.datagrid("validateRow", i)) {
				ext.tip.error("请输入正确的数据");
				return;
			}
		}
		
		var currentNode = $("#dictTree").tree("getSelected");
		var level=null;
		if(currentNode!=null){
			level = getLevel(currentNode, 0);
		}
		
		var inserted = dg.datagrid("getChanges", "inserted");
		var updated = dg.datagrid("getChanges", "updated");
		var deleted = dg.datagrid("getChanges", "deleted");

		var repeat = {};
		var dictCodeEditor;
		var val;

		for (var i = 0; i < rows.length; i++) {

			dictCodeEditor = dg.datagrid("getEditor", {
				index : i,
				field : 'dictcode_s'
			});
			if (level == 1) {
				if (dictCodeEditor != null) {
					val = $(dictCodeEditor.target).textbox("getValue");
					if (val.length != 3) {
						ext.tip.error("字典规则不合法");
						return;
					}
				}
			}
			if (level > 1) {
				if (dictCodeEditor != null) {
					val = $(dictCodeEditor.target).textbox("getValue");

					if (val.length <= currentNode.code.length) {
						ext.tip.error("字典规则不合法");
						return;
					}

					val = val.replace(currentNode.code, "");

					if (val.length != 3) {
						ext.tip.error("字典规则不合法");
						return;
					}
				}
			}

			dg.datagrid("endEdit", i);
			if (!repeat[rows[i].code]) {
				repeat[rows[i].code] = rows[i].code;
			} else {
				ext.tip.warn('代码重复：' + rows[i].code);
				return;
			}
		}

		ext.ajax.sendJson("dict/saveChanges", {
			inserted : inserted,
			updated : updated,
			deleted : deleted
		}, function(data) {

			if (data.code == ERROR) {
				ext.tip.error(data.message + ":" + data.data);
				return;
			}

			if (data.code != OK) {
				ext.tip.error("保存失败");
				return;
			}
			
			$("#dictTree").tree("reload",currentNode.target);
			$("#dict_dg").datagrid("reload");
			ext.tip.suc("保存成功")

		});
	}


	function cancel() {
		$("#dict_dg").datagrid("rejectChanges");
	}

	function onBeforeLoad(param) {
	
		try {
			var row = $("#dictTree").tree("getSelected");
			if (row == null||row.id==-1) {
				return;
			}
			var dictcode= $('#dictcode_s').textbox("getValue");
			var dictname= $('#dictname_s').textbox("getValue");
			if( !dictcode==""||!dictname==""){
				return;
			}
			delete param["filter[dictcode_s]"];
			delete param["filter[dictname_s]"];
			param["filter[pid_i]"] = row.id;
			var opts = $("#dict_dg").datagrid("options");
	        opts.url = 'dict/datagrid?all=1';
		} catch (e) {
			return false;
		}
	}

	function deleted(v, r, i) {
		var text = {
			0 : "有效",
			1 : "无效"
		};
		if (v == 0) {
			return "<font color='green'>" + text[v] + "</font>";
		}
		return "<font color='red'>" + text[v] + "</font>";
	}

	function styler(index, row) {
		if (row.deleted_i == 1) {
			return "text-decoration:line-through";
		}
		return "";
	}
</script>