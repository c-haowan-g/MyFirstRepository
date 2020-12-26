<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"mix/storageManagement/mixStoragePlanJob/saveChanges";
    
    function showOrHide(){
        if($("#MixStoragePlanJob_search_form").is(":hidden")){
            $("#MixStoragePlanJob_search_form").show();
        }else{
            $("#MixStoragePlanJob_search_form").hide();
        }
    }
    /**
	 * 日期格式化
	 */
	function dateFormat(date) {
		return new Calendar(date).format("yyyyMMdd");
	}

	/**
	 * 解析指定格式日期
	 */
	function dateParser(s) {
		if (!s)
			return new Date();
		return new Date(s.substring(0, 4), parseInt(s.substring(4, 6)) - 1, s
				.substring(6, 8));
	}

	//表格加载前事件
	function dlg1BeforeLoad(param) {
		if ($("#job_date_s").datebox("getValue") == "") {
			return false;
		}

		param["filter[job_date_s]"] = $("#job_date_s").datebox("getValue");

	}
		var job_shift_s = null;
	var inventory_area_s = null;

	//行点击事件
	function oninventoryselect(record) {
		inventory_area_s = record.code;

	}

	//行点击事件
	function onshiftselect(record) {
		job_shift_s = record.code;

	}

	//显示操作结果
	function showConfirm(msg) {
		$.messager.confirm({
			width : 700,
			height : 350,
			title : '提示',
			msg : msg,
			fn : function(r) {
			}
		});
	}
    /**
	 *将数据库得值转换为数据字典与对应值域
	 */
	function codeFormatter(v, r, i) {

		return dictFormat(v);
	}

	//0-未处理、1-已处理、2-处理失败
	function flagformatter(v,r,i){
		if(v==0){
    		return "未处理";
    	}
    	if(v==1){
    		return "已处理";
    	}
    	if(v==2){
    		return "处理失败";
    	}
	}
	//计划添加
	function addbyplan() {
		var editors = $('#mixstorageplanjob_dg').datagrid('getEditors', 0);
		if (editors.length == 0) {
			ext.tip
					.error("请先点击编制计划，编辑计划信息！");
			return;
		}

		var ids = [];
		ids.push(job_shift_s);
		ids.push(inventory_area_s);

		ext.ajax.post("mix/storageManagement/mixStoragePlanJob/down", {
			ids : ids.toString()
		}, function(data) {
			if (data.code != OK) {
				ext.tip.error(data.message);
			}
			showConfirm(data.data);
			filter();
		});
	}
	
    //计划删除
    function deletes() {
		var editors = $('#mixstorageplanjob_dg').datagrid('getChecked');
		if (editors.length == 0) {
			ext.tip.warn(tipSelectAtLeastOne);
			return;
		}

		$.messager.confirm("删除确认", "确认删除所选计划?", function(r) {
			if (r) {

				var ids = [];
				ids.push(editors[0].job_no_s.toString());
				ext.ajax.post(
						"mix/storageManagement/mixStoragePlanJob/deletes", {
							ids : ids.toString()
						}, function(data) {
							if (data.code != OK) {
								ext.tip.error(data.message);
							}
							showConfirm(data.data);
							filter();
						});

			}
		});
	}
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("mixstorageplanjob_dg","MixStoragePlanJob_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("mixstorageplanjob_dg",{});
    }

    function edit() {
        var rows = $("#mixstorageplanjob_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#mixstorageplanjob_dg").datagrid("getRowIndex", rows[i]);
            $("#mixstorageplanjob_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#mixstorageplanjob_dg").datagrid("getSelections");
        if (rows.length == 0) {
			ext.tip.warn(tipSelectAtLeastOne);
			return;
		}
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#mixstorageplanjob_dg").datagrid("getRowIndex", rows[i]);
            $("#mixstorageplanjob_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#mixstorageplanjob_dg");

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
            $("#mixstorageplanjob_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#mixstorageplanjob_dg").datagrid("rejectChanges");
    }


</script>