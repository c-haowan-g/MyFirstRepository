<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	var saveChanges = path + "mix/baseData/feedSwitch/saveChanges";

	function showOrHide() {
		if ($("#FeedSwitch_search_form").is(":hidden")) {
			$("#FeedSwitch_search_form").show();
		} else {
			$("#FeedSwitch_search_form").hide();
		}
	}
	
	function equipCodeFormatter(v, r, i) {
		for (var i = 0; i < plinedata.length; i++) {
			if (v == plinedata[i].p_line_name) {
				return plinedata[i].description;
			}
		}
	}

	var plinedata = [];
	$.ajax({
		url : 'mix/planManagement/dayPlan/getplmByPlinenameall',
		type : "get",
		dataType : "json",
		async : false,
		success : function(data) {
			plinedata = data;
		}
	});
	
	var plineadddata = [];
	
	$.ajax({
		url : 'mix/baseData/feedSwitch/getfeedswitchequipall',
		type : "get",
		dataType : "json",
		async : false,
		success : function(data) {
		    plineadddata = data;
		}
	});
	
 	function filterequipcode() {
		$.ajax({
			url : 'mix/baseData/feedSwitch/getfeedswitchequipall',
			type : "get",
			dataType : "json",
			async : false,
			success : function(data) {
			    var tt=$('#feedswitch_dg').datagrid('getColumnOption', 'equip_code_s');
                tt.editor={type:'combobox',options:{
     				valueField:'p_line_name',
           			textField:'description',
                    required:true,
                    data:data,
					method: 'get',
				    editable:'true',
				    limitToList:false,
				    panelHeight:200
     			}};
			}
		});
	}
	

	/**
	 * 查询方法
	 */
	var filter = function() {
		var opts = $("#feedswitch_dg").datagrid("options");
		opts.url = 'mix/baseData/feedSwitch/datagrid';
		ext.easyui.grid.search("feedswitch_dg", "FeedSwitch_search_form");
		filterequipcode();
	};

	function add() {
		var row = {
			spare3_s : '0',
			send_state_s : '0',
			is_equal_switch_s : '0',
			is_master_switch_s : '0',
			is_inorder_exec_switch_s : '0',
			is_carwash_switch_s : '0',
			is_autosp_switch_s : '0'
		};
		ext.easyui.grid.appendAndEdit("feedswitch_dg", row);
	}

	function edit() {
		var rows = $("#feedswitch_dg").datagrid("getSelections");
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#feedswitch_dg").datagrid("getRowIndex", rows[i]);
			$("#feedswitch_dg").datagrid("beginEdit", index);
		}
	}

	function remove() {
		var rows = $("#feedswitch_dg").datagrid("getSelections");
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#feedswitch_dg").datagrid("getRowIndex", rows[i]);
			$("#feedswitch_dg").datagrid("deleteRow", index);
		}
	}

	function save() {
		var dg = $("#feedswitch_dg");
		var rows = dg.datagrid("getRows");
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
		if (inserted.length == 0 && updated.length == 0 && deleted.length == 0) {
			ext.tip.error("<spring:message code="tip.nosave" />");
		} else {
			ext.ajax.sendJson(saveChanges, {
			inserted : inserted,
			updated : updated,
			deleted : deleted
		}, function(data) {
			if (data.code != OK) {
					ext.tip.error("<spring:message code="tip.error" />");
					return;
			}
			filter();
			ext.tip.suc("<spring:message code="tip.success" />");
			});
		}
	}

	function save2() {
		var row = $("#feedswitch_dg").datagrid('getSelections');
		var rows = $("#groupname_dg").datagrid('getSelections');
		if (row.length <= 0) {
			ext.tip.error("请选择左侧机台");
			return;
		}
		var groupname = "";
		var groupcode = "";
		if (rows.length > 0) {
			for (var i = 0; i < rows.length; i++) {
				if(rows[i].dictname_s == null || rows[i].materialgroup_s == null) {
					continue;
				}
				groupname += rows[i].dictname_s + ",";
				groupcode += rows[i].materialgroup_s + ",";
			}
			groupname = groupname.substr(0, groupname.length - 1);
			groupcode = groupcode.substr(0, groupcode.length - 1);
			row[0].spare3_s = "1";
		} else {
			row[0].spare3_s = "0";
		}
		if(groupname == null || groupcode == null || groupname == "" || groupcode == "") {
			row[0].spare3_s = "0";
		}
		row[0].material_groupname_s = groupname;
		row[0].material_group_s = groupcode;
		var gzwhurl = path + "mix/baseData/feedSwitch/saveChanges";
		ext.ajax.sendJson(gzwhurl, {
			updated : row
		}, function(data) {
			if (data.code != OK) {
				ext.tip.error("<spring:message code="tip.error" />");
				return;
			}
			$("#feedswitch_dg").datagrid("reload");
			ext.tip.suc("<spring:message code="tip.success" />");
		});
	}

	function formatOper(v, r, i) {
		if (v == "0") {
			return "关闭";
		}
		if (v == "1") {
			return "开启";
		}
	}

	function planStatusColorSetting(value, row, index) {
		if (value == "0") {
			return 'background-color:#FF0000;text-align: center;';
		} else if (value == "1") {
			return 'background-color:#00FF00;text-align: center;';
		}
	}

	function openOrclose(type) {
		var openOrclose = "mix/baseData/feedSwitch/openOrclose";
		var updated = $("#feedswitch_dg").datagrid("getSelections");
		console.log(updated);
		if (updated.length != 0) {
			ext.ajax.sendJson(openOrclose, {
				type : type,
				updated : updated
			}, function(data) {
				if (data.data != "error") {
					if (data.message != "ok") {
						$("#feedswitch_dg").datagrid("reload");
						ext.tip.error("<spring:message code="tip.error" />");
					} else {
						$("#feedswitch_dg").datagrid("reload");
						ext.tip.suc("<spring:message code="tip.success" />");
					}
				} else {
					$("#feedswitch_dg").datagrid("reload");
					ext.tip.error(data.message);
				}
			});
		} else {
			ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
		}
		;
	}

	function issue() {
		var rows = $("#feedswitch_dg").datagrid("getSelections");
		if (rows.length <= 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		var recipecodelist = [];
		for (var i = 0; i < rows.length; i++) {
			recipecodelist.push(rows[i].equip_code_s);
		}
		ext.ajax.post("mix/baseData/feedSwitch/downward", {
			recipecodelist : recipecodelist.toString()
		}, function(data) {
			$("#feedswitch_dg").datagrid("reload");
			showConfirm(data.data);
		});
	}

	//右上方表格行单击事件   
	function selectrow() {
		var rows = $("#feedswitch_dg").datagrid('getSelected');
		var equip_code_s = rows.equip_code_s;
		var mater_type_s = rows.spare1_s;
		var url = "mix/baseData/feedSwitch/getGroupName?equip_code_s="
				+ equip_code_s + "&mater_type_s=" + mater_type_s;
		ext.ajax.get(url, function(data) {
			$('#groupname_dg').datagrid('loadData', data);
			var groupname = rows.material_groupname_s;
			var m = groupname.split(",");
			for (var i = 0; i < data.length; i++) {
				indexs = i;
				for (var j = 0; j < m.length; j++) {
					if (data[i].dictname_s == m[j])
						$("#groupname_dg").datagrid("selectRow", indexs);
				}
			}
		});

		$("#sp_wo_no_s_sp").html(rows.sp_wo_no_s);
		$("#sp_netheart_i_sp").html(rows.sp_netheart_i);
		$("#sp_carriermovein_s_sp").html(
				spcarriermoveinFormatter(rows.sp_carriermovein_s, null, null));

		$("#spare5_s_sp").html(rows.spare5_s);
		$("#sp_shelf_num_i_sp").html(rows.sp_shelf_num_i);
		$("#sp_carriermovein_loc_s_sp").html(
				spcarriermoveinlocFormatter(rows.sp_carriermovein_loc_s, null,
						null));

		$("#sp_curaction_s_sp").html(
				spcuractionFormatter(rows.sp_curaction_s, null, null));
		$("#sp_standweight_d_sp").html(rows.sp_standweight_d);
		$("#sp_carrierweight_d_sp").html(rows.sp_carrierweight_d);

		if (rows.spare4_s != null) {
			$("#spare4_s_sp").html(
					'<a href="javascript:void(0)" onclick="displayContent(this.innerHTML)" >'
							+ rows.spare4_s + '</a>');
		}
		$("#sp_slowdownweight_d_sp").html(rows.sp_slowdownweight_d);
		$("#sp_carriermoveout_s_sp")
				.html(
						spcarriermoveoutFormatter(rows.sp_carriermoveout_s,
								null, null));

		$("#sp_runmode_s_sp").html(
				sprunmodeFormatter(rows.sp_runmode_s, null, null));
		$("#sp_cutpolyweight_d_sp").html(rows.sp_cutpolyweight_d);
		$("#sp_carriermove_loc_s_sp")
				.html(
						spcarriermovelocFormatter(rows.sp_carriermove_loc_s,
								null, null));

		$("#sp_onlineoffline_sp").html(
				sponlineofflineFormatter(rows.sp_onlineoffline_s, null, null));
		$("#sp_prodweight_d_sp").html(rows.sp_prodweight_d);
	}

	function sendstateFormatter(v, r, i) {
		if (v == 0) {
			return "未下发";
		} else if (v == 1) {
			return "已下发";
		} else if (v == 2) {
			return "下发失败";
		} else {
			return v;
		}
	}

	function spcarriermoveinFormatter(v, r, i) {
		if (v == 1) {
			return v + "-胶案架移入";
		} else if (v == 0) {
			return v + "-MES读取后复位";
		} else {
			return v;
		}
	}

	function spcarriermoveinlocFormatter(v, r, i) {
		if (v == 0) {
			return v + "-摆片";
		} else if (v == 1) {
			return v + "-卷曲位";
		} else if (v == 2) {
			return v + "-卷曲位";
		} else {
			return v;
		}
	}

	function spcarriermovelocFormatter(v, r, i) {
		if (v == 0) {
			return v + "-摆片";
		} else if (v == 1) {
			return v + "-卷曲位";
		} else if (v == 2) {
			return v + "-卷曲位";
		} else {
			return v;
		}
	}

	function spcuractionFormatter(v, r, i) {
		if (v == 1) {
			return v + "-完成胶案移入,胶案称量中";
		} else if (v == 2) {
			return v + "-完成胶案称重,标准下发中";
		} else if (v == 3) {
			return v + "-RFID未读取到,请手动移出";
		} else if (v == 4) {
			return v + "-未选择工单,请选择工单;";
		} else if (v == 6) {
			return v + "-完成标准下发,摆片中";
		} else if (v == 7) {
			return v + "-产出重量为零,不允许移出";
		} else if (v == 8) {
			return v + "-产出重量正常,卡片打印中";
		} else if (v == 0) {
			return v + "-胶案待移入";
		} else if (v == 11) {
			return v + "-收胶完成";
		} else {
			return v;
		}
	}

	function spcarriermoveoutFormatter(v, r, i) {
		if (v == 1) {
			return v + "-胶案架移入";
		} else if (v == 0) {
			return v + "-MES读取后复位";
		} else {
			return v;
		}
	}

	function sprunmodeFormatter(v, r, i) {
		if (v == 1) {
			return v + "-单击运行";
		} else if (v == 0) {
			return v + "-联网运行";
		} else {
			return v;
		}
	}

	function sponlineofflineFormatter(v, r, i) {
		if (v == 1) {
			return v + "-手动";
		} else if (v == 0) {
			return v + "-自动";
		} else {
			return v;
		}
	}

	function toUserName(v, r, i) {
		if (v == null) {
			return v;
		}
		$.ajax({
			url : 'mix/baseData/siloMaterial/toUserName',
			type : 'get',
			dataType : 'json',
			data : {
				usercode : v
			},
			async : false,
			success : function(data) {
				if (data.length == 0) {
					return v;
				}
				v = v + data[0].username;
			}
		});
		return v;
	}

	function closeOropen(v, r, i) {
		if (v == null) {
			return v;
		}
		if (v == "0") {
			return "关闭";
		}
		if (v == "1") {
			return "打开";
		}
	}

	function sendstatus(v, r, i) {
		if (v == null) {
			return v;
		}
		if (v == "0") {
			return "未下发";
		}
		if (v == "1") {
			return "已下发";
		}
		if (v == "3") {
			return "下发失败";
		}
	}
	
	function codeformattermat(v, r, i) {
		if (v == null) {
			return "";
		}
		$.ajax({
			url : 'mix/baseData/feedSwitch/getDictName',
			type : "get",
			dataType : "json",
			data: {
				erpcodestring : v
			},
			async : false,
			success : function(data) {
				v =  data[0].str;
			}
		});
		return v;
	}

	//显示操作结果
	function showConfirm(msg) {
		$.messager.confirm({
			width : 300,
			height : 200,
			title : '提示',
			msg : msg,
			fn : function(r) {

			}
		});
	}
	
/* 	function onsparechange(n, o) {
		var tt=$('#feedswitch_dg').datagrid('getColumnOption', 'material_group_s');
		if (n == null || n == "") {
			tt.editor={type:'combobox',options:{
            	required:false,
                data:[]
    		}};
    		return;
		}
		var str = "";
		for(var i = 0;i < n.length;i++) {
			str = str + n[i] + ",";
		}
		str = str.substring(0, str.length - 1);
		$.ajax({
			url : 'mix/baseData/feedSwitch/getMaterialGroupBySpare',
			type : "get",
			dataType : "json",
			data: {
				sparestring : str
			},
			async : false,
			success : function(data) {
			    console.log(data);
				tt.editor={type:'combobox',options:{
     				valueField:'materialgroup_s',
           			textField:'dictname_s',
                    required:true,
                    data:data,
					method: 'get',
				    editable:'true',
				    limitToList:false,
				    panelHeight:150
     			}};
			}
		});
	} */
	
	//获取指定行、指定列的编辑器
	function getEditor1(index, field) {
		return $("#feedswitch_dg").datagrid("getEditor", {
			index : index,
			field : field
		});
	}

	function cancel() {
		$("#feedswitch_dg").datagrid("rejectChanges");
	}
</script>