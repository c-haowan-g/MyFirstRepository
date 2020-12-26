<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"mix/report/mixplananalysis/saveChanges";
    
    function showOrHide(){
        if($("#MixPlanAnalysis_search_form").is(":hidden")){
            $("#MixPlanAnalysis_search_form").show();
        }else{
            $("#MixPlanAnalysis_search_form").hide();
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
	
	   /**
    * 获取机台
    */
    var materialnameList=[];
    $.ajax({
        url:"mix/basedata/rockwellFactoryModel/getplmByPlinename",
        type:"get",
        dataType:"json",
        async:false,
        success:function(data){
        	materialnameList=data;
        }
    });
	
	  //表格加载前事件
	function dlg1BeforeLoad(param) {
		if ($("#plan_date_s").datebox("getValue") == "") {
			return false;
		}
		
		param["filter[plan_date_s]"] = $("#plan_date_s").datebox(
				"getValue");	
	}
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("mixplananalysis_dg","MixPlanAnalysis_search_form");
    }
    
      function doExport(){
        var param=ext.form.getFormAsJson("MixPlanAnalysis_search_form");
        console.log(param)
        var param_get="";

        for(var k in param){
            param_get=param_get+"&"+k.replace("filter[","").replace("]","")+"="+param[k];
        }
        window.open(path+"mix/report/mixplananalysis/exportCSV?s_factory_s="+factory+param_get);
    }
    
    function completionrateFormatter(v,r,i){
        if(v=="undefined"||v==null||v==""){
             return "";        	 
        }else{
       	     return v+"%";  
        }
   } 
    
    function add() {
        ext.easyui.grid.appendAndEdit("mixplananalysis_dg",{});
    }

    function edit() {
        var rows = $("#mixplananalysis_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#mixplananalysis_dg").datagrid("getRowIndex", rows[i]);
            $("#mixplananalysis_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#mixplananalysis_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#mixplananalysis_dg").datagrid("getRowIndex", rows[i]);
            $("#mixplananalysis_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#mixplananalysis_dg");

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
            $("#mixplananalysis_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#mixplananalysis_dg").datagrid("rejectChanges");
    }


</script>