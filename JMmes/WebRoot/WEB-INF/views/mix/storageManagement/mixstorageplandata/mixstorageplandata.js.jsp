<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"mix/storageManagement/mixStoragePlanData/saveChanges";
    
    function showOrHide(){
        if($("#MixStoragePlanData_search_form").is(":hidden")){
            $("#MixStoragePlanData_search_form").show();
        }else{
            $("#MixStoragePlanData_search_form").hide();
        }
    }
    var jobnamelist = [];
	var date = new Calendar().format("yyyyMMdd");
	//加载计划名称
	$.ajax({
		url : "mix/storageManagement/mixStoragePlanData/getJobName?date="
				+date,
		type : "get",
		dataType : "json",
		async : false,
		success : function(data) {
			jobnamelist = data;
		}
	});
	/**
	 * 点击获取jobname
	 */
	var getJobName = function() {
		var dates=$("#in_date_s1").datebox("getValue");
		$("#job_name_s")
				.combobox(
						{
							url : "mix/storageManagement/mixStoragePlanData/getJobName?date="
									+ dates,
							method : "post",
							valueField : 'JOB_NAME_S',
							textField : 'JOB_NAME_S',
							selected : 'selected'
						});

	};

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
		if ($("#in_date_s").datebox("getValue") == "") {
			return false;
		}

		param["filter[in_date_s]"] = $("#in_date_s").datebox("getValue");

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
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("mixstorageplandata_dg","MixStoragePlanData_search_form");
    }
    //锁定盘库
    function lock() {
		var rows = $("#mixstorageplandata_dg").datagrid("getChecked");
		if (rows.length == 0) {
			ext.tip.warn(tipSelectAtLeastOne);
			return;
		}

		var ids = [];

		ids.push(rows[0].job_no_s);

		ext.ajax.post("mix/storageManagement/mixStoragePlanData/lock", {
			ids : ids.toString()
		}, function(data) {
			if (data.code != OK) {
				ext.tip.error(data.message);
			}
			showConfirm(data.data);
			filter();
		});
	}

	//解锁盘库
	function unlock() {
		var rows = $("#mixstorageplandata_dg").datagrid("getChecked");
		if (rows.length == 0) {
			ext.tip.warn(tipSelectAtLeastOne);
			return;
		}

		var ids = [];

		ids.push(rows[0].job_no_s);

		ext.ajax.post("mix/storageManagement/mixStoragePlanData/unlock", {
			ids : ids.toString()
		}, function(data) {
			if (data.code != OK) {
				ext.tip.error(data.message);
			}
			showConfirm(data.data);
			filter();
		});
	}

	//扫描对库
	function scanning() {
		var rows = $("#mixstorageplandata_dg").datagrid("getChecked");
		if (rows.length == 0) {
			ext.tip.warn(tipSelectAtLeastOne);
			return;
		}

		var ids = [];

		ids.push(rows[0].job_no_s);

		ext.ajax.post("mix/storageManagement/mixStoragePlanData/scanning", {
			ids : ids.toString()
		}, function(data) {
			if (data.code != OK) {
				ext.tip.error(data.message);
			}
			showConfirm(data.data);
			filter();
		});
	}

	//无效删除
	function deletes() {
		var rows = $("#mixstorageplandata_dg").datagrid("getChecked");
		if (rows.length == 0) {
			ext.tip.warn(tipSelectAtLeastOne);
			return;
		}

		var ids = [];

		ids.push(rows[0].job_no_s);
		ids.push(rows[0].lot_no_s);
		ids.push(rows[0].inventory_result_s);

		ext.ajax.post("mix/storageManagement/mixStoragePlanData/deletes", {
			ids : ids.toString()
		}, function(data) {
			if (data.code != OK) {
				ext.tip.error(data.message);
			}
			showConfirm(data.data);
			filter();
		});
	}
	/**
	 *盘库扫描数据
	 */

	// 查询方法
	var filter1 = function() {
		ext.easyui.grid.search("mixstorageplandatascan_dg","MixStoragePlanDataScan_search_form");
	}
	
	/**
	 * 点击获取jobname
	 */
	var getJobName1 = function() {
		var dates=$("#in_date_s2").datebox("getValue");
		$("#job_name_s")
				.combobox(
						{
							url : "mix/storageManagement/mixStoragePlanData/getJobName?date="
									+ dates,
							method : "post",
							valueField : 'JOB_NAME_S',
							textField : 'JOB_NAME_S',
							selected : 'selected'
						});

	};

	//锁定盘库
	function lock1() {
		var rows = $("#mixstorageplandatascan_dg").datagrid("getChecked");
		if (rows.length == 0) {
			ext.tip.warn(tipSelectAtLeastOne);
			return;
		}

		var ids = [];

		ids.push(rows[0].job_no_s);

		ext.ajax.post("mix/storageManagement/mixStoragePlanData/lock", {
			ids : ids.toString()
		}, function(data) {
			if (data.code != OK) {
				ext.tip.error(data.message);
			}
			showConfirm(data.data);
			filter();
		});
	}

	//解锁盘库
	function unlock1() {
		var rows = $("#mixstorageplandatascan_dg").datagrid("getChecked");
		if (rows.length == 0) {
			ext.tip.warn(tipSelectAtLeastOne);
			return;
		}

		var ids = [];

		ids.push(rows[0].job_no_s);

		ext.ajax.post("mix/storageManagement/mixStoragePlanData/unlock", {
			ids : ids.toString()
		}, function(data) {
			if (data.code != OK) {
				ext.tip.error(data.message);
			}
			showConfirm(data.data);
			filter();
		});
	}

	//扫描对库
	function scanning1() {
		var rows = $("#mixstorageplandatascan_dg").datagrid("getChecked");
		if (rows.length == 0) {
			ext.tip.warn(tipSelectAtLeastOne);
			return;
		}

		var ids = [];

		ids.push(rows[0].job_no_s);

		ext.ajax.post("mix/storageManagement/mixStoragePlanData/scanning", {
			ids : ids.toString()
		}, function(data) {
			if (data.code != OK) {
				ext.tip.error(data.message);
			}
			showConfirm(data.data);
			filter();
		});
	}
	/**
	 *盘库生产数据
	 */

	// 查询方法
	var filter2 = function() {
		ext.easyui.grid.search("mixstorageplandataprod_dg","MixStoragePlanDataProd_search_form");
	}
	
	/**
	 * 点击获取jobname
	 */
	var getJobName2 = function() {
		var dates=$("#in_date_s3").datebox("getValue");
		$("#job_name_s")
				.combobox(
						{
							url : "mix/storageManagement/mixStoragePlanData/getJobName?date="
									+ dates,
							method : "post",
							valueField : 'JOB_NAME_S',
							textField : 'JOB_NAME_S',
							selected : 'selected'
						});

	};
	

	//锁定盘库
	function lock2() {
		var rows = $("#mixstorageplandataprod_dg").datagrid("getChecked");
		if (rows.length == 0) {
			ext.tip.warn(tipSelectAtLeastOne);
			return;
		}

		var ids = [];

		ids.push(rows[0].job_no_s);

		ext.ajax.post("mix/storageManagement/mixStoragePlanData/lock", {
			ids : ids.toString()
		}, function(data) {
			if (data.code != OK) {
				ext.tip.error(data.message);
			}
			showConfirm(data.data);
			filter();
		});
	}

	//解锁盘库
	function unlock2() {
		var rows = $("#mixstorageplandataprod_dg").datagrid("getChecked");
		if (rows.length == 0) {
			ext.tip.warn(tipSelectAtLeastOne);
			return;
		}

		var ids = [];

		ids.push(rows[0].job_no_s);

		ext.ajax.post("mix/storageManagement/mixStoragePlanData/unlock", {
			ids : ids.toString()
		}, function(data) {
			if (data.code != OK) {
				ext.tip.error(data.message);
			}
			showConfirm(data.data);
			filter();
		});
	}

	//扫描对库
	function scanning2() {
		var rows = $("#mixstorageplandataprod_dg").datagrid("getChecked");
		if (rows.length == 0) {
			ext.tip.warn(tipSelectAtLeastOne);
			return;
		}

		var ids = [];

		ids.push(rows[0].job_no_s);

		ext.ajax.post("mix/storageManagement/mixStoragePlanData/scanning", {
			ids : ids.toString()
		}, function(data) {
			if (data.code != OK) {
				ext.tip.error(data.message);
			}
			showConfirm(data.data);
			filter();
		});
	}
	/**
	 *盘库出库数据
	 */
    // 查询方法
	var filter3 = function() {
		ext.easyui.grid.search("mixstorageplandataout_dg","MixStoragePlanDataOut_search_form");
	}
	
	
	/**
	 * 点击获取jobname
	 */
	var getJobName3 = function() {
		var dates=$("#in_date_s4").datebox("getValue");
		$("#job_name_s")
				.combobox(
						{
							url : "mix/storageManagement/mixStoragePlanData/getJobName?date="
									+ dates,
							method : "post",
							valueField : 'JOB_NAME_S',
							textField : 'JOB_NAME_S',
							selected : 'selected'
						});

	};

	//锁定盘库
	function lock3() {
		var rows = $("#mixstorageplandataout_dg").datagrid("getChecked");
		if (rows.length == 0) {
			ext.tip.warn(tipSelectAtLeastOne);
			return;
		}

		var ids = [];

		ids.push(rows[0].job_no_s);

		ext.ajax.post("mix/storageManagement/mixStoragePlanData/lock", {
			ids : ids.toString()
		}, function(data) {
			if (data.code != OK) {
				ext.tip.error(data.message);
			}
			showConfirm(data.data);
			filter();
		});
	}

	//解锁盘库
	function unlock3() {
		var rows = $("#mixstorageplandataout_dg").datagrid("getChecked");
		if (rows.length == 0) {
			ext.tip.warn(tipSelectAtLeastOne);
			return;
		}

		var ids = [];

		ids.push(rows[0].job_no_s);

		ext.ajax.post("mix/storageManagement/mixStoragePlanData/unlock", {
			ids : ids.toString()
		}, function(data) {
			if (data.code != OK) {
				ext.tip.error(data.message);
			}
			showConfirm(data.data);
			filter();
		});
	}

	//扫描对库
	function scanning3() {
		var rows = $("#mixstorageplandataout_dg").datagrid("getChecked");
		if (rows.length == 0) {
			ext.tip.warn(tipSelectAtLeastOne);
			return;
		}

		var ids = [];

		ids.push(rows[0].job_no_s);

		ext.ajax.post("mix/storageManagement/mixStoragePlanData/scanning", {
			ids : ids.toString()
		}, function(data) {
			if (data.code != OK) {
				ext.tip.error(data.message);
			}
			showConfirm(data.data);
			filter();
		});
	}
	
    function add() {
        ext.easyui.grid.appendAndEdit("mixstorageplandata_dg",{});
    }

    function edit() {
        var rows = $("#mixstorageplandata_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#mixstorageplandata_dg").datagrid("getRowIndex", rows[i]);
            $("#mixstorageplandata_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#mixstorageplandata_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#mixstorageplandata_dg").datagrid("getRowIndex", rows[i]);
            $("#mixstorageplandata_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#mixstorageplandata_dg");

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
            $("#mixstorageplandata_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#mixstorageplandata_dg").datagrid("rejectChanges");
    }


</script>