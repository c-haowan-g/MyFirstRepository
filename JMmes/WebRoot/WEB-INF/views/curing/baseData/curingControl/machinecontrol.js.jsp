<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

	/**
	 *数据字典传值
	 *
	 */
	function codeFormatter(v, r, i) {
		return dictFormat(v);
	}

	/**
	 *查询栏
	 *
	 */
	function showOrHide() {

		if ($("#MachineControl_search_form").is(":hidden")) {
			$("#MachineControl_search_form").show();
		} else {
			$("#MachineControl_search_form").hide();
		}
	}

	/**
	 * 查询方法
	 */
	var filter = function() {
		ext.easyui.grid.search("machinecontrol_dg",
				"MachineControl_search_form");
	}
	
	/**
     * 查询方法
     */
    function filter1(){
    	var opts = $("#controldetail_dg").datagrid("options");
        opts.url = 'curing/baseData/curingControl/machinecontrol/searchByLine';
        ext.easyui.grid.search("controldetail_dg","LineControl_search_form");
    }

	/**
	 * 导出
	 */
	function importCallback(data) {
		$("#machinecontrol_dg").datagrid("reload");
	}

	/**
	 *点击A标签然后赋值
	 *
	 */
	var onOff = "curing/baseData/curingControl/machinecontrol/onOff";
	function on_off(dataOn) {
		var updated = $("#machinecontrol_dg").datagrid("getSelections");
		 if(updated.length!=0){
			ext.ajax.sendJson(onOff, {
				dataOnOff:dataOn,
				updated : updated
			}, function(data) {
				
				 if(data.data!="error"){
					if (data.message != "ok") {
						$("#machinecontrol_dg").datagrid("reload");
						ext.tip.error("<spring:message code="tip.error" />");
					}else{
						$("#machinecontrol_dg").datagrid("reload");
						ext.tip.suc("<spring:message code="tip.success" />");
					}
						
				}else{
					$("#machinecontrol_dg").datagrid("reload");
					ext.tip.error(data.message);
				} 
			});
		}else{
			ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
		} 
	}
	//打开模态框
	function openWindow(){
		$('#w').window('open');
		$("#controldetail_dg").datagrid("reload");
	}
	 
</script>