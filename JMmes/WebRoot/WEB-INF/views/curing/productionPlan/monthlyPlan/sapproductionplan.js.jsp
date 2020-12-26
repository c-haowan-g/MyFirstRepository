<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"curing/productionPlan/monthlyPlan/saveChanges";
    var editIndex=undefined;
    function showOrHide(){
        if($("#SapProductionPlan_search_form").is(":hidden")){
            $("#SapProductionPlan_search_form").show();
        }else{
            $("#SapProductionPlan_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("sapproductionplan_dg","SapProductionPlan_search_form");
    }
    
    function add() {
    	if (editIndex!=undefined) {
    		ext.tip.error('该行正在编辑，请保存或者放弃');
    		$("#sapproductionplan_dg").datagrid("selectRow",editIndex);
    		return;
		}
    	var d=$("#month_i").datetimespinner("getValue");
        /* $("#sapproductionplan_dg").datagrid("appendRow", {"month_i":vM,"plan_status_s":"217001"});
        var rows = $("#sapproductionplan_dg").datagrid("getRows");
        $("#sapproductionplan_dg").datagrid("beginEdit", rows.length - 1);
        editIndex=rows.length - 1;
        $("#sapproductionplan_dg").datagrid("selectRow",editIndex); */
        
        getSerialByDate("LHYJH",d.replace("-",""), function(data){
        	if(factory==2){
        		ext.easyui.grid.appendAndEdit("sapproductionplan_dg",{"s_factory_s":factory,"month_i":d.replace("-",""),"planno_month_s":data.data,"plan_status_s":"217001","overproduction_percent_s":"${applicationScope.SYS_CONFIG_KEY.LH_YJH_OVERSTEP_PERCENT}"})
        	}else if(factory==1){
        		ext.easyui.grid.appendAndEdit("sapproductionplan_dg",{"s_factory_s":factory,"month_i":d.replace("-",""),"planno_month_s":data.data,"plan_status_s":"217001","overproduction_percent_s":"${applicationScope.SYS_CONFIG_KEY.LH_YJH_OVERSTEP_PERCENT_Q}"})
        	}
        });
        
    }

    function edit() {
        var rows = $("#sapproductionplan_dg").datagrid("getSelections");
        if (rows.length==1){
        	index = $("#sapproductionplan_dg").datagrid("getRowIndex", rows[0]);
            $("#sapproductionplan_dg").datagrid("beginEdit", index);
            editIndex=index;
        }
        else {
        	ext.tip.error(tipSelectOnlyOne);
        }
        
    }
	
    function remove() {
        var rows = $("#sapproductionplan_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#sapproductionplan_dg").datagrid("getRowIndex", rows[i]);
            	$("#sapproductionplan_dg").datagrid("deleteRow", index);
        }

    }
    
    var indexedMinCount={};
    
    
    function onBeforeEdit(index,row){
    	editIndex=index;
    	if(row.atr_key){
    		   ext.ajax.post("curing/productionPlan/monthlyPlan/checkDailyPlan",{month:row.month_i,materialCode:row.material_code_s},function(data){
    			   
    			   if(data.data){
    				   indexedMinCount[index]=row.quantity_plan_f;
    			   }else{
    				   indexedMinCount[index]=undefined;
    			   }
    		   });
    	}
    }
    
    /**
     * 获取指定行、指定列的编辑器
     */
    function getEditor(index,field){
        return $("#sapproductionplan_dg").datagrid("getEditor",{index:index,field:field});
    }
    
    function getFieldValue(index,field){
        
        var v="";
        if(getEditor(index, field)==null){
            return getRowByIndex(index)[field];
        }
        try{
            v=$(getEditor(index, field).target).combobox("getValue");
        }catch (e) {}
        try{
            v=$(getEditor(index, field).target).numberspinner("getValue");
        }catch (e) {}
        try{
            v=$(getEditor(index, field).target).textbox("getValue");
        }catch (e) {}
        try{
            v=$(getEditor(index, field).target).combobox("getValue");
        }catch (e) {}
        
        return v;
    }
    
    function getRowByIndex(index){
        return $("#sapproductionplan_dg").datagrid("getRows")[index];
    }
    
    function validDate(){
    	var index=$(this).parents("[datagrid-row-index]").attr("datagrid-row-index"); 
    	
    	var start=getFieldValue(index, "plan_starttime_t");
    	var end=getFieldValue(index, "plan_endtime_t");
    	
    	start=start.replace("-","").replace("-","");
    	end=end.replace("-","").replace("-","");
    	
    	var month=getFieldValue(index, "month_i");
    	
    	if(start.indexOf(month)!=0){
    		$(getEditor(index, "plan_starttime_t").target).datebox("setValue","");
    	}
    	if(end.indexOf(month)!=0){
            $(getEditor(index, "plan_endtime_t").target).datebox("setValue","");
        }
    	if(start==""||end==""){
    		return;
    	}
    	if(start>end){
    		$(this).datebox("setValue","");
    	}
    	
    }
    
    var flag;//验证标志位
   // 验证月计划数量更改状态
    function onChange(nv,ov){
    	
    	var index=$(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
    	
    	var row=$("#sapproductionplan_dg").datagrid("getRows")[index];
    	  $.ajax({
	 		url:"curing/productionPlan/monthlyPlan/checkdayplan?month_i="+row.month_i+"&material_code_s="+row.material_code_s,
	 		type:"get",
	 		dataType:"json",
	 		async:false,
	 		success:function(data){
	 			flag=data;
	 		} }); 
    	  if(flag==-1){
				if(indexedMinCount[index]){
		    		var min=indexedMinCount[index];
		    		if(nv<min){
		    			ext.tip.error("当前月计划在产，只能向上添加数量，不允许减少");
		    			$(this).numberspinner("setValue",min);
		    			console.log(111)
		    		}
		    	}
			}else{
				$(this).numberspinner("setValue",nv);
			}
    }

    function save() {
        var dg = $("#sapproductionplan_dg");

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
            rows[i].plan_starttime_t+=" 00:00:00";
            rows[i].plan_endtime_t+=" 23:59:59";
        }
      	

        ext.ajax.sendJson(saveChanges, {
            inserted : inserted,
            updated : updated,
            deleted : deleted
        }, function(data) {
            if (data.code != OK) {
                ext.tip.error(data.message);
                return;
            }
            $("#sapproductionplan_dg").datagrid("reload");
            ext.tip.suc(successTip);
            editIndex=undefined;
        });
    }

    function cancel() {
        $("#sapproductionplan_dg").datagrid("rejectChanges");
        editIndex=undefined;
    }
	
    function formatter2(date){
		return date==null?"":new Calendar(date).format('yyyy-MM');
	}
    
    function dateFormatter(v,r,i){
    	if(!v)return "";
    	return v.substring(0,10);
    }
    
	function parser2(s){
		if (!s){return null;}
		var ss = s.split('-');
		var y = parseInt(ss[0],10);
		var m = parseInt(ss[1],10);
		if (!isNaN(y) && !isNaN(m)){
			return new Date(y,m-1,1);
		} else {
			return new Date();
		}
	}
	$(document).ready(function(){
		$("#month_i").datetimespinner("setValue",formatter2(new Date()));
		filter();
	});
	
	
	function onBeforeLoad(param){
		
		if($("#month_i").datetimespinner("getValue")==""){
            return false;
        }
        
        param["filter[month_i]"]=$("#month_i").datetimespinner("getValue");
		
		if(param["filter[month_i]"]!=undefined){
			param["filter[month_i]"]=param["filter[month_i]"].replace("-","");
		}
		
	}
	
	
	
	var materials={};
	
	var onMaterialSelect=function(r){
		var ed;
        editIndex=$(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
        
        ed = $("#sapproductionplan_dg").datagrid("getEditor", {index:editIndex,field:"material_name_s"});
        $(ed.target).textbox("setValue", r.part_number);
        ed = $("#sapproductionplan_dg").datagrid("getEditor", {index:editIndex,field:"layclass_s"});
        $(ed.target).textbox("setValue", r.cj_s);
        ed = $("#sapproductionplan_dg").datagrid("getEditor", {index:editIndex,field:"flowershape_s"});
        $(ed.target).textbox("setValue", r.pattern_s);
        ed = $("#sapproductionplan_dg").datagrid("getEditor", {index:editIndex,field:"material_name_s"});
        $(ed.target).textbox("setValue", r.description);
        console.log(r.description);
	}
	
	function onMaterialChange(nv,ov){
		$(this).combobox("reload");
	}
	 
	 function onMaterialBeforeLoad(param){
		 var row=$("#sapproductionplan_dg").datagrid("getRows")[editIndex];
		 if($(this).combobox("getValue")==""){
			 if(row.material_code_s){
				 param.code=row.material_code_s;
			 }
		 }else{
			 param.code=$(this).combobox("getValue");
		 }
		 
	 }
	 
	 function codeFormatter(v, r, i) {
			return dictFormat(v);
		}
</script>