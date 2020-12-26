<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"curing/baseData/moldChangePlan/saveChanges";
    var editIndex=undefined;
    function showOrHide(){
        if($("#MoldChangePlan_search_form").is(":hidden")){
            $("#MoldChangePlan_search_form").show();
        }else{
            $("#MoldChangePlan_search_form").hide();
        }
    }
    //根据计划号带出相关规格信息
    function getInfoByPlanNo(){
			var planno_s =  $(this).combobox("getValue");
			var rowIndex=$(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
			  $.ajax({
			 		url:"curing/baseData/moldChangePlan/getThSpecByPlanNo?planNo="+planno_s,
			 		type:"get",
			 		dataType:"json",
			 		async:false,
			 		success:function(data){
			 			setFieldValue(rowIndex,"material_code_left_s",data["0"].MATERIAL_CODE_LEFT_S); 
			 			setFieldValue(rowIndex,"material_code_right_s",data["0"].MATERIAL_CODE_RIGHT_S);
			 			
			 			setFieldValue(rowIndex,"material_name_left_s",data["0"].MATERIAL_DESC_LEFT_S); 
			 			setFieldValue(rowIndex,"material_name_right_s",data["0"].MATERIAL_DESC_RIGHT_S); 
			 			
			 			setFieldValue(rowIndex,"speccode_left_s",data["0"].SPECCODE_LEFT_S); 
			 			setFieldValue(rowIndex,"speccode_right_s",data["0"].SPECCODE_RIGHT_S); 
			 		}
			 	});
    }
    
    //根据计划号设置其他列值
    function setFieldValue(index,field,value){
    	var editor=$(getEditor(index, field).target);
    	try{
            editor.textbox("setValue",value);
        }catch (e) {}
    }
    /**
     * 获取指定行、指定列的编辑器
     */
    function getEditor(index,field){
    	return $("#moldchangeplan_dg").datagrid("getEditor",{index:index,field:field});
    }  
    
    function dateParse(dateString){
        return new Date(dateString.substring(0,4),dateString.substring(4,6)-1,dateString.substring(6,8));
    }
    
    function myformatter(date){
        return new Calendar(date).format("yyyyMMdd");
    }
    
    
    //执行情况
   function executiveFormatter(v,r,i){
    	
    	if(r.executive_s==0){
			return "未执行";
		}else if(r.executive_s==1){
			return "已执行";
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
	function dateParserStart(s) {
		debugger
		if (!s)
			return new Date();
		return new Date(s.substring(0, 4), parseInt(s.substring(4, 6)) - 1, s
				.substring(6, 8));
	}
	/**
	 * 解析指定格式日期
	 */
	function dateParserEnd(s) {
		debugger
		if (!s)
			return new Date();
		return new Date(s.substring(0, 4), parseInt(s.substring(4, 6)) - 1, s
				.substring(6, 8));
	}
	 //表格加载前事件
	function onDgBeforeLoad(param) {
		if ($("#begin_mold_changetime").datebox("getValue") == "") {
			return false;
		}
		
		param["filter[begin_mold_changetime]"] = $("#begin_mold_changetime").datebox(
				"getValue");
		if ($("#end_mold_changetime").datebox("getValue") == "") {
			return false;
		}
		
		param["filter[end_mold_changetime]"] = $("#end_mold_changetime").datebox(
				"getValue");
		
	}
    /**
     * 查询方法
     */
    var filter=function(){
    	var startTime= $('#begin_mold_changetime').datebox("getValue");
    	var endTime= $('#end_mold_changetime').datebox("getValue");
    	if(startTime!=""&&endTime==""){
    		ext.tip.error("时间输入范围不完整");
    		return;
    	}
    	if(startTime==""&&endTime!=""){
    		ext.tip.error("时间输入范围不完整");
    		return;
    	}
    	
        ext.easyui.grid.search("moldchangeplan_dg","MoldChangePlan_search_form");
    };
    
    function searchBarcode(q, row){
    	var opts = $(this).combobox('options');
        return row[opts.textField].toUpperCase().indexOf(q.toUpperCase()) >= 0;
    }
    
    
    function add() {
    	var planDate=new Calendar().format("yyyyMMdd");
        
        $("#moldchangeplan_dg").datagrid('insertRow', {
			index : 0,
			row : {plan_status_s:"219001",mold_changetime_s:planDate}
		});
        var rows = $("#moldchangeplan_dg").datagrid("getRows");
        $("#moldchangeplan_dg").datagrid("beginEdit", 0);
    
    
    }

    function edit() {
        var rows = $("#moldchangeplan_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#moldchangeplan_dg").datagrid("getRowIndex", rows[i]);
            if(rows[i].plan_status_s!='219001'){
            	ext.tip.error(rows[i].planno_changemold_s+"<spring:message code='tip.notAllow'/>");
            	continue;
            }
            $("#moldchangeplan_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {
        var rows = $("#moldchangeplan_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#moldchangeplan_dg").datagrid("getRowIndex", rows[i]);
            
            if(rows[i].plan_status_s!='219001'){
            	ext.tip.error(rows[i].planno_changemold_s+"<spring:message code='tip.notAllow'/>");
            	continue;
            }
            
            $("#moldchangeplan_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#moldchangeplan_dg");

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
        Utils.each(deleted, function(i, d) {
			delete d.capsule;
			delete d.lineColor;
			delete d.capsuler;
			delete d.lineColorr;
		});
        Utils.each(updated, function(i, d) {
        	delete d.capsule;
			delete d.lineColor;
			delete d.capsuler;
			delete d.lineColorr;
		});
		Utils.each(inserted, function(i, d) {
			delete d.capsule;
			delete d.lineColor;
			delete d.capsuler;
			delete d.lineColorr;
		});
        ext.ajax.sendJson(saveChanges, {
            inserted : inserted,
            updated : updated,
            deleted : deleted
        }, function(data) {
            if (data.status != 1) {
                ext.tip.error("<spring:message code='tip.error' />");
            }
            $("#moldchangeplan_dg").datagrid("reload");
            ext.tip.suc("<spring:message code='tip.success' />");
        });
    }

    function cancel() {
        $("#moldchangeplan_dg").datagrid("rejectChanges");
    }
    
    //处理审核、取消审核操作
    function dealAudit(action){
    	var rows=$("#moldchangeplan_dg").datagrid('getSelections');
    	if(rows.length==0){
    		ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
    		return;
    	}
    	var ids=[];
    	
    	Utils.each(rows,function(i,r){
    		//审核操作
    		if(r.plan_status_s=='219001'&&action=='219003'){
    			ids.push(r.atr_key);
    		}
    		//取消审核操作
    		if(r.plan_status_s=='219003'&&action=='219001'){
    			
    			/*这里模具进行管控的时候要记得放开
    			if(r.status_s!='0'){
    				 ext.tip.error(r.planno_changemold_s+"<spring:message code="tip.moldStatusNotFit" />");
    			}
    			else{ */
    			if(r.status_s=='1'){
    				return;
    			}else{
    				ids.push(r.atr_key);
    			}
    	

    		}
    	});
    	
    	
    	 if(ids.length==0){
    		for(var i=0; i<rows.length; i++){
	    		if(rows[i].status_s=='1'){
	    			if(rows[i].plan_status_s)
	    			ext.tip.error("<spring:message code='tip.notAllowRemove'/>");
	    		}else{
	    			ext.tip.warn("<spring:message code="tip.noItemData" />");
	    		}
    		}
    		return;
    	} 
    	
    	$.ajax({
            url: "curing/baseData/moldChangePlan/auditplan?ids="+ids.join(",")+"&isAudit="+action,
            type:"get",
            dataType:"json",
            async:false,
            success: function(data){
                if(data.code!=OK){
                	ext.tip.error();
                	return;
                }
                ext.tip.suc();
                filter();
            },
            error: function(){
                error.apply(this, arguments);
            }
        });
    	
    }
    
    //计划状态显示格式化
	function codeFormatter(v,r,i){
    	return dictFormat(v);
    }
	
    //是否热模格式化
	function heatMoldFormatter(v,r,i){
		if (r.heat_mold_s == 0) {
			return "<spring:message code='tip.exchangemold.heatmold.no'/>";
		} else if (r.heat_mold_s == 1) {
			return "<spring:message code='tip.exchangemold.heatmold.yes'/>";
		}
	}
	
    //获取换模计划所对应的硫化日计划
	function getDayPlannoData(){
		editIndex=$(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
		var ed = $("#moldchangeplan_dg").datagrid("getEditor", {index:editIndex,field:"mold_changetime_s"});
		var vMold=$(ed.target).combobox("getValue");
		var ed = $("#moldchangeplan_dg").datagrid("getEditor", {index:editIndex,field:"equip_code_s"});
		var equip=$(ed.target).combobox("getValue");
		if (vMold!='' && equip!=''){
			var url="curing/baseData/moldChangePlan/dayplanno?d="+vMold+"&m="+equip;
			$(this).combobox("reload",url);
		}
		else{
			ext.tip.error("换模日期或机台条码不完整");
		}
	}
    
    //关闭订单
    function closePlan(){
        var rowdata=$("#moldchangeplan_dg").datagrid('getSelected');
        var planstatus=rowdata.plan_status_s;
        if (!(planstatus=='219004' && planstatus=='219005' && planstatus=='219006')){
        	var url="curing/baseData/moldChangePlan/closeplan?iD="+rowdata.atr_key+"&status=219007";
        	var ret=updatePlanStatus(url);
        	console.log("1:"+ret);
            if (ret ==true){
            	ext.tip.suc("<spring:message code='tip.success' />");
            	$("#moldchangeplan_dg").datagrid("reload");
            } else {
            	ext.tip.error("<spring:message code='tip.error' />");
            };
        };
    }
    
</script>