<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"material/plans/materialApply/rmMaterial/saveChanges";
    
    $(document).ready(function() {
		filter();
	});
    function showOrHide(){
        if($("#RmMaterialApply_search_form").is(":hidden")){
            $("#RmMaterialApply_search_form").show();
        }else{
            $("#RmMaterialApply_search_form").hide();
        }
    }
    
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("rmmaterialapply_dg","RmMaterialApply_search_form");
    }
    
    function create(){
    	var dateTimeboxData = $("#prod_date_s").datebox("getValue");
    	var date1 = dateTimeboxData;
    	var date2 = new Calendar().format("yyyyMMdd");
    	if(date1 < date2){
    		ext.tip.error("不能生成当前日期之前的计划");
    		return;
    	}
    	
    	var planDate = date1;
    	var sfactory=$("#s_factory_s").combobox("getValue");
    	$.ajax({
    		url : "material/plans/materialApply/rmMaterial/createTodayPlan?planDate="
    				+planDate+"&sfactory="+sfactory,
    		type : "get",
    		dataType : "json",
    		success : function(data) {
    			ext.tip.error("生成计划结束");
    			
    			//jobnamelist = data;
    		}
    	});
    	
        	/* 
             var planDate = date1;
            var url = path+"material/plans/materialApply/rmMaterial/createTodayPlan?planDate="+planDate;
            
            window.location.href=url;  */
        
    }
    
    function add() {
    	var dateTimeboxData = $("#prod_date_s").datebox("getValue");
    	var date1 = dateTimeboxData;
    	var date2 = new Calendar().format("yyyyMMdd");
    	if(date1 < date2){
    		ext.tip.error("不能添加当前日期之前的计划");
    		return;
    	}
    	
    	/* 设置默认值 */
		ext.easyui.grid.appendAndEdit("rmmaterialapply_dg",	
				{prod_date_s:dateTimeboxData,
		    		qty_receive_f:"0.0"});
    	
    	
    	
        
    }

    function edit() {
        var rows = $("#rmmaterialapply_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#rmmaterialapply_dg").datagrid("getRowIndex", rows[i]);
            $("#rmmaterialapply_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#rmmaterialapply_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#rmmaterialapply_dg").datagrid("getRowIndex", rows[i]);
            $("#rmmaterialapply_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#rmmaterialapply_dg");

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
		//inserted.
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
            $("#rmmaterialapply_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#rmmaterialapply_dg").datagrid("rejectChanges");
    }
	//日期格式❀
    function dateFormat(date) {
		return new Calendar(date).format("yyyyMMdd");
	}

    /**
	 * 解析指定格式日期
	 */
	function dateParserStart(s) {
		debugger
		if (!s)
			return new Date();
		return new Date(s.substring(0, 4), parseInt(s.substring(4, 6)) - 1, s
				.substring(6, 8));
	}
    
    //数据字典
	function codeFormatter(v, r, i) {

		return dictFormat(v);
	}
    //工厂
	function is_factory(v, r, i) {

    	if(v == '1'){
            return "全钢";
        }else if(v=='2'){
            return"半钢";
        }
        return "";
    }
    
	function areaCodechanged(value,oldvalue) {
		
    	var k = $(this).parents('[datagrid-row-index]').attr('datagrid-row-index');
        var name_td = $('.datagrid-body td[field=\'store_type_s\']')[k];
        var name_input = $(name_td).find('input')[0];
        
        var areaName="";
        if(value=='012001'){
        	$(name_input).textbox('setValue','炭黑库');
        }else if(value=='012002'){
        	$(name_input).textbox('setValue','烘胶房-线边库');
        }else if(value=='012003'){
        	$(name_input).textbox('setValue','A区钢丝库');
        }else if(value=='012004'){
        	$(name_input).textbox('setValue','自动配料-1#');
        }else if(value=='012005'){
        	$(name_input).textbox('setValue','自动配料-2#');
        }
       
    }
</script>