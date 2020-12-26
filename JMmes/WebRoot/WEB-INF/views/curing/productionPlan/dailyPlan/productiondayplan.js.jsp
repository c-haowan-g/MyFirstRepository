<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"lh/scjh/rjh/saveChanges";
    
    var action="";
    
    var code="LHRJH";
    
    var jtxx=[];
    
    var editingIndex=-1;
    
    function onBeginEdit(index,row){
    	editingIndex=index;
    }
    
    function onEndEdit(index,row){
    	editingIndex=-1;
    }
    
    //加载产线信息
    $.ajax({
    	url:'curing/baseData/curingProductionLineInfo/comboxProductlineEqu',
    	type:'get',
    	dataType:'json',
    	async:false,
    	success:function(data){
    		console.log(data);
    		jtxx=data;
    	}
    });
    
    function onDgBeforeLoad(param){
    	if($("#production_date_s").datebox("getValue")==""){
    		return false;
    	}
    	
    	param["filter[production_date_s]"]=$("#production_date_s").datebox("getValue");
    	param["filter[production_line_s]"]=$("#production_line_s").combobox("getValue");
    }
    
    function showOrHide(){
        if($("#ProductionDayPlan_search_form").is(":hidden")){
            $("#ProductionDayPlan_search_form").show();
        }else{
            $("#ProductionDayPlan_search_form").hide();
        }
    }
    
    /**
     * 选择完日期，加载序列号
     */
    function onDateSelect(date){
    	
    	var index=$(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
    	
    	
    	var ed = $("#productiondayplan_dg").datagrid('getEditor', {index:index,field:"plan_no_s"});
    	
    	
    	getSerialByDate(code,new Calendar(date).format("yyyyMMdd"),function(data){
    		$(ed.target).textbox("setValue",data.data);
    		loadYesterdayPlan(index);
    	});
    	
    	var fields=[
    	            "production_line_s",
    	            "plan_queue_s",
    	            "equip_code_left_s",
    	            "equip_code_right_s",
    	            "material_code_left_s",
    	            "material_code_right_s",
    	            "material_desc_left_s",
    	            "material_desc_right_s",
                    "productionver_left_s",
                    "productionver_right_s",
                    "production_step_left_s",
                    "production_step_right_s",
                    "specification_left_s",
                    "specification_right_s",
                    "childbom_ver_left_s",
                    "childbom_ver_right_s",
                    "processbom_index_build_s",
                    "processbom_index_curing_s",
                    "planamount_mor_left_i",
                    "planamount_mor_right_i",
                    "planamount_mid_left_i",
                    "planamount_mid_right_i",
                    "planamount_nig_left_i",
                    "planamount_nig_right_i",
                    "quantity_dayplan_left_i",
                    "quantity_dayplan_right_i",
                    "reason_midclass_left_s",
                    "reason_midclass_right_s",
                    "reason_morclass_left_s",
                    "reason_morclass_right_s",
                    "reason_nigclass_left_s",
                    "reason_nigclass_right_s",
                    "memo_left_s",
                    "memo_right_s"
                  ];
    	for(var k in fields){
            clearFieldValue(index, fields[k]);
        }
    }
    
    /**
     * 日期格式化
     */
    function dateFormat(date){
    	return new Calendar(date).format("yyyyMMdd");
    }
    
    /**
     * 解析指定格式日期
     */
    function dateParser(s){
    	if(!s)return new Date();
    	return new Date(s.substring(0,4),parseInt(s.substring(4,6))-1,s.substring(6,8));
    }
    
    /**
     * 加载昨天的计划，
     * 触发条件：产线或者计划日期发生变化，且二者都不为空
     */
    function loadYesterdayPlan(index,lineCode){
    	var dateEditor=$("#productiondayplan_dg").datagrid('getEditor', {index:index,field:"production_date_s"});
    	var lineCodeEditor=$("#productiondayplan_dg").datagrid('getEditor', {index:index,field:"production_line_s"});
    	
    	var dateValue=$(dateEditor.target).textbox("getValue");
    	var codeValue=$(lineCodeEditor.target).textbox("getValue");
    	
    	if(lineCode){
    		codeValue=lineCode;
    	}
    	
    	if(dateValue==""||codeValue==""){
    		return;
    	}
    	
    	var date=new Date(dateValue.substring(0,4),parseInt(dateValue.substring(5,6))-1,dateValue.substring(7,8));
    	
    	var cal=new Calendar(date);
    	cal.add(Calendar.field.DAY_OF_MONTH,-1);
    	
    	//加载昨日计划
    	ext.ajax.get("curing/productionPlan/dailyPlan/daily/"+cal.format("yyyyMMdd")+"/"+codeValue,function(data){
    		$(getEditor(index,"plan_queue_s").target).textbox("setValue",data.data.index);
    		if(data.data.lastPlan==null){
    			// 找不到昨日的日计划，这里要从后台查询左右摸条码，用户去完善计划其他信息
    			ext.ajax.get("curing/productionPlan/dailyPlan/machines/"+codeValue,function(machines){
    				log(machines)
    				if(machines.data==null||machines.data.length==0){
    					return;
    				}
    				var ms=machines.data;
    				for(var i=0;i<ms.length;i++){
    					if(ms[i].equip_code_s.replace(codeValue,"")=="1"){
    						$(getEditor(index,"equip_code_left_s").target).textbox("setValue",ms[i].equip_code_s);
    					}else{
    						$(getEditor(index,"equip_code_right_s").target).textbox("setValue",ms[i].equip_code_s);
    					}
    				}
    				
    			});
    			return;
    		}
    		
    		// TODO 自动填充日计划内容
    		
    		
    	});
    	
    	
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("productiondayplan_dg","ProductionDayPlan_search_form");
    }
    
    function add() {
        $("#dlg").dialog("open");
    }
    
    function copy(){
    	$("#dlg-copy").dialog("open");
    }
    
    function copySuc(date){
    	$("#dlg-copy").dialog("close");
    	$("#production_date_s").datebox("setValue",date);
    	filter();
    }
    
    function edit() {
    	if(editingIndex!=-1){
            ext.tip.warn("请先保存");
            return;
        }
        var rows = $("#productiondayplan_dg").datagrid("getSelections");
        var index = -1;
        action="EDIT";
        for (var i = 0; i < rows.length; i++) {
            index = $("#productiondayplan_dg").datagrid("getRowIndex", rows[i]);
            if(rows[i].status_s!='218001'){
            	ext.tip.warn("tip.forbiddenDeleteOrEdit");
            	break;
            }
            $("#productiondayplan_dg").datagrid("beginEdit", index);
        }
    }
    
    function getRowValues(index){
        var cs=$("#productiondayplan_dg").datagrid('getColumnFields');
        var fcs=$("#productiondayplan_dg").datagrid('getColumnFields', true);
        
        var rows=$("#productiondayplan_dg").datagrid("getRows");
        
        var row=rows[index];
        
        for(var i=0;i<cs.length;i++){
            if(cs[i]=="atr_key")continue;
            row[cs[i]]=getFieldValue(index,cs[i]);
        }
        for(var j=0;j<fcs.length;j++){
            if(fcs[j]=="atr_key")continue;
            row[fcs[j]]=getFieldValue(index,fcs[j]);
        }
        
        return row;
    }
    
    function getDg(){
    	return $("#productiondayplan_dg");
    }

    /**
     * 获取指定行、指定列的编辑器
     */
    function getEditor(index,field){
    	return $("#productiondayplan_dg").datagrid("getEditor",{index:index,field:field});
    }
    /**
    * 审核
    */
    function audit(){
    	var rows=getDg().datagrid("getChecked");
    	
    	if(rows.length==0){
    		ext.tip.warn(tipSelectAtLeastOne);
    		return;
    	}
    	
    	var ids=[];
    	
    	for(var i=0;i<rows.length;i++){
    		if(rows[i].status_s!='218001'){
    			ext.tip.warn((i+1)+"<spring:message code="tip.row" /><spring:message code="tip.audited" />");
    			return;
    		}
    		ids.push(rows[i].atr_key);
    	}
    	
    	ext.ajax.post("curing/productionPlan/dailyPlan/audit",{ids:ids.toString()},function(data){
    		if(data.code==OK){
    			ext.tip.suc();
    			filter();
    			return;
    		}
    		ext.tip.error(data.message);
    	});
    }
    

    function cancelAudit(){
        var rows=getDg().datagrid("getChecked");
        
        if(rows.length==0){
            ext.tip.warn(tipSelectAtLeastOne);
            return;
        }
        
        var ids=[];
        
        for(var i=0;i<rows.length;i++){
        	if(rows[i].status_s!='218002'){
                ext.tip.warn((i+1)+"<spring:message code="tip.row" /><spring:message code="tip.canNotCancelAudit" />");
                return;
            }
            ids.push(rows[i].atr_key);
        }
        
        ext.ajax.post("curing/productionPlan/dailyPlan/cancelAudit",{ids:ids.toString()},function(data){
            if(data.code!=OK){
            	ext.tip.error(data.message);
            	return;
            }
            ext.tip.suc();
            filter();
        });
    }
    
    /**
     * 物料编码加载前
     */
    function onMaterialBeforeLoad(param){
    	var index=$(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
    	var row=$("#productiondayplan_dg").datagrid("getRows")[index];
    	param.date=row.production_date_s;
    }
    
    /**
     * 左模物料编码选择事件
     */
    function onMaterialSelect_left(record){
    	
    	var index=$(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
    	//选择左模，之后要情况的列值
    	var fields=[
					"productionver_left_s",
					"productionver_right_s",
					"production_step_left_s",
					"production_step_right_s",
					"specification_left_s",
					"specification_right_s",
					"childbom_ver_left_s",
					"childbom_ver_right_s",
					"processbom_index_build_s",
					"processbom_index_curing_s",
					"planamount_mor_left_i",
					"planamount_mor_right_i",
					"planamount_mid_left_i",
                    "planamount_mid_right_i",
                    "planamount_nig_left_i",
                    "planamount_nig_right_i",
                    "quantity_dayplan_left_i",
                    "quantity_dayplan_right_i",
                    "reason_midclass_left_s",
                    "reason_midclass_right_s",
                    "reason_morclass_left_s",
                    "reason_morclass_right_s",
                    "reason_nigclass_left_s",
                    "reason_nigclass_right_s",
                    "memo_left_s",
                    "memo_right_s"
    	          ];
    	
    	for(var k in fields){
    		clearFieldValue(index, fields[k]);
    	}
    	
    	ext.ajax.get("curing/productionPlan/dailyPlan/greenTire?code="+record.MATERIAL_CODE_S,function(data){
    		
    		$(getEditor(index, "production_step_left_s").target).combobox("loadData",data.data);
    		$(getEditor(index, "production_step_right_s").target).combobox("loadData",data.data);
    		
    		//map.put("productionver_left_s", costCollector(code));
            //map.put("productionver_right_s", costCollector(code));
            
            $(getEditor(index, "productionver_left_s").target).textbox("setValue",data.data[0].productionver_left_s);
            $(getEditor(index, "productionver_right_s").target).textbox("setValue",data.data[0].productionver_right_s);
    		
    		$(getEditor(index,"material_code_right_s").target).textbox("setValue",record.MATERIAL_CODE_S);
            $(getEditor(index,"material_desc_right_s").target).textbox("setValue",record.MATERIAL_NAME_S);
            $(getEditor(index,"material_desc_left_s").target).textbox("setValue",record.MATERIAL_NAME_S);//
    	});
    	
    }
    
    /**
     * 清空指定行指定列的值
     */
    function clearFieldValue(index,field){
    	if(action=="EDIT"){
    		return;
    	}
    	try{
    		$(getEditor(index, field).target).combobox("clear")
    	}catch (e) {}
    	try{
            $(getEditor(index, field).target).numberspinner("clear")
        }catch (e) {}
        try{
            $(getEditor(index, field).target).textbox("clear")
        }catch (e) {}
        try{
            $(getEditor(index, field).target).combobox("clear")
        }catch (e) {}
    	
    }
    
    function onMaterialChage_left(nv,ov){
        if(nv==""){
        	var fields=[
        	            "material_code_right_s",
        	            "material_desc_left_s",
        	            "material_desc_right_s",
                        "productionver_left_s",
                        "productionver_right_s",
                        "production_step_left_s",
                        "production_step_right_s",
                        "specification_left_s",
                        "specification_right_s",
                        "childbom_ver_left_s",
                        "childbom_ver_right_s",
                        "processbom_index_build_s",
                        "processbom_index_curing_s",
                        "planamount_mor_left_i",
                        "planamount_mor_right_i",
                        "planamount_mid_left_i",
                        "planamount_mid_right_i",
                        "planamount_nig_left_i",
                        "planamount_nig_right_i",
                        "quantity_dayplan_left_i",
                        "quantity_dayplan_right_i",
                        "reason_midclass_left_s",
                        "reason_midclass_right_s",
                        "reason_morclass_left_s",
                        "reason_morclass_right_s",
                        "reason_nigclass_left_s",
                        "reason_nigclass_right_s",
                        "memo_left_s",
                        "memo_right_s"
                      ];
            
            for(var k in fields){
                clearFieldValue(index, fields[k]);
            }
        }
    }
    
    function onMaterialChage_right(nv,ov){
    	if(nv==""){
            var fields=[
                        "material_desc_right_s",
                        "productionver_right_s",
                        "production_step_right_s",
                        "specification_right_s",
                        "childbom_ver_right_s",
                        "planamount_mor_right_i",
                        "planamount_mid_right_i",
                        "planamount_nig_right_i",
                        "quantity_dayplan_right_i",
                        "reason_midclass_right_s",
                        "reason_morclass_right_s",
                        "reason_nigclass_right_s",
                        "memo_right_s"
                      ];
            
            for(var k in fields){
                clearFieldValue(index, fields[k]);
            }
        }
    }
    
    function onMaterialSelect_right(record){
    	var index=$(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
    	
    	var fields=[
                    "productionver_right_s",
                    "production_step_right_s",
                    "specification_right_s",
                    "childbom_ver_right_s",
                    "processbom_index_build_s",
                    "processbom_index_curing_s",
                    "reason_midclass_right_s",
                    "reason_morclass_right_s",
                    "reason_nigclass_right_s",
                    "memo_left_s",
                    "memo_right_s"
                  ];
        
        for(var k in fields){
            clearFieldValue(index, fields[k]);
        }
        ext.ajax.get("curing/productionPlan/dailyPlan/greenTire?code="+record.MATERIAL_CODE_S,function(data){
            
            $(getEditor(index, "production_step_right_s").target).combobox("loadData",data.data);
            $(getEditor(index, "productionver_right_s").target).textbox("setValue",data.data[0].productionver_right_s);
            
            $(getEditor(index,"material_code_right_s").target).textbox("setValue",record.MATERIAL_CODE_S);
            $(getEditor(index,"material_desc_right_s").target).textbox("setValue",record.MATERIAL_NAME_S);
        })
    }
    
	function onStageSelect_left(record){
	        
	        var index=$(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
	        $(getEditor(index,"production_step_right_s").target).combobox("setValue",record.production_step_left_s);
	        $(getEditor(index,"production_step_right_s").target).combobox("setText",record.production_step_left_s_text);
	        
	        $(getEditor(index, "specification_left_s").target).textbox("setValue",record.specification_left_s);
	        $(getEditor(index, "childbom_ver_left_s").target).textbox("setValue",record.childbom_ver_left_s);
	        $(getEditor(index, "specification_left_s").target).textbox("setValue",record.specification_left_s);
	        $(getEditor(index, "processbom_index_build_s").target).textbox("setValue",record.processbom_index_build_s);
	        $(getEditor(index, "processbom_index_curing_s").target).textbox("setValue",record.processbom_index_curing_s);
	}
    
    function onStageSelect_right(record){
        
        var index=$(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
        
        $(getEditor(index, "childbom_ver_right_s").target).textbox("setValue",record.childbom_ver_left_s);
        $(getEditor(index, "specification_right_s").target).textbox("setValue",record.specification_left_s);
        $(getEditor(index, "processbom_index_build_s").target).textbox("setValue",record.processbom_index_build_s);
        
        var bomId1=$(getEditor(index, "processbom_index_curing_s").target).textbox("getValue");
        var bomId2=record.processbom_index_curing_s;
        
        validCuringBom(index,bomId1,bomId2);
       
    }
    
    /**
     * 校验左右摸工艺参数是否一致
     */
    function validCuringBom(index,bomId1,bomId2){
    	if(bomId1==undefined||bomId1==""){
    		return;
    	}
    	if(bomId1!=bomdId2){
    		ext.ajax.get("curing/productionPlan/dailyPlan/validBom?bomId1="+bomId1+"&bomId2="+bomId2,function(data){
                if(data.data==false){
                    ext.tip.warn("<spring:message code="curingprocess.notuniform" />");
                    clearFieldValue(index, "production_step_right_s");
                    clearFieldValue(index, "specification_right_s");
                    clearFieldValue(index, "childbom_ver_right_s");
                }
            });
    	}
    }
    
    /**
     * 计划量联动
     */
    function onCountChange(nv,ov){

    	var index=$(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
    	
    	var field=$(this).parents("td[field]").attr("field");
    	
        if(field.indexOf("left")!=-1){
            $(getEditor(index, field.replace("left","right")).target).numberspinner("setValue",nv);
        }
    	
    	var zao_left=getNumberSpinnerValue(index, "planamount_mor_left_i");
    	var zhong_left=getNumberSpinnerValue(index, "planamount_mid_left_i");
    	var wan_left=getNumberSpinnerValue(index, "planamount_nig_left_i");
    	var leftCount=zao_left+zhong_left+wan_left;
    	
    	var zao_right=getNumberSpinnerValue(index, "planamount_mor_right_i");
    	var zhong_right=getNumberSpinnerValue(index, "planamount_mid_right_i");
    	var wan_right=getNumberSpinnerValue(index, "planamount_nig_right_i");
    	
    	var rightCount=zao_right+zhong_right+wan_right;
    	
    	$(getEditor(index, "quantity_dayplan_left_i").target).textbox("setValue",leftCount);
    	$(getEditor(index, "quantity_dayplan_right_i").target).textbox("setValue",rightCount);
    	
    }
    
    function getNumberSpinnerValue(index,field){
    	return parseInt($(getEditor(index, field).target).numberspinner("getValue"))||0;
    }
    
    function onEndEdit(index,row){
    	editingIndex=-1;
    }
    
    function getRowByIndex(index){
        return $("#productiondayplan_dg").datagrid("getRows")[index];
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
    
    /* function save2(){
    	ocument.getElementById("addOrEditWin").contentWindow.save();
    } */

    function save() {
    	
    	if(editingIndex==-1){
    		return;
    	}
    	
    	/* 
    	1. 同一天，分机台的顺序号不能重复
		2. 同一天，统机台，物料编码不能重复（是否区分左右摸）  不区分
		                                                    左模：A,右：B
		                                                    左：B，右：A
		3. 校验左右摸月计划量
    	*/
    	
    	var dg = $("#productiondayplan_dg");

        var rows = dg.datagrid("getRows");
        
        //数据有效性校验
        if (!dg.datagrid("validateRow", i)) {
            ext.tip.error("<spring:message code="tip.invalid" />");
            return;
        }
    	
        
        //顺序号校验,左右摸校验
        //var queue={},material_left={},material_right={};
        var order=getFieldValue(editingIndex, "plan_queue_s");
        var mtcode_left=getFieldValue(editingIndex,"material_code_left_s");
        var mtcode_right=getFieldValue(editingIndex,"material_code_right_s");
        
        for (var i = 0; i < rows.length; i++) {
        	
        	if(editingIndex==i){
        		continue;
        	}
        	
        	if(order==rows[i].plan_queue_s){
        		ext.tip.warn("顺序号重复");
        		return;
        	}
        	
        	if(mtcode_left==rows[i].material_code_left_s||mtcode_left==rows[i].material_code_right_s){
        		ext.tip.warn("物料编码重复:"+mtcode_left);
        		return;
        	}
        	if(mtcode_right==rows[i].material_code_left_s||mtcode_right==rows[i].material_code_right_s){
        		ext.tip.warn("物料编码重复:"+mtcode_right);
        		return;
        	}
        }
        
        var row=rows[editingIndex];
        
        dg.datagrid("endEdit", editingIndex);
        
        ext.ajax.post("curing/productionPlan/dailyPlan/save",row,function(data){
        	if(data.code==OK){
        		ext.tip.suc();
        		filter();
        		return;
        	}
        });
    }
        
    
    

    function cancel() {
    	editingIndex=-1;
        $("#productiondayplan_dg").datagrid("rejectChanges");
    }
    
    function searchProductionLine(q, row){
    	var opts = $(this).combobox('options');
        return row[opts.textField].toUpperCase().indexOf(q.toUpperCase()) >= 0;
    }
    
    function setFieldValue(index,field,value){
    	var editor=$(getEditor(index, field).target);
    	try{
    		editor.numberspinner("setValue",value);
    	}catch (e) {}
    	try{
            editor.textbox("setValue",value);
        }catch (e) {}
        try{
            editor.combobox("setValue",value);
        }catch (e) {}
        try{
            editor.datebox("setValue",value);
        }catch (e) {}
        try{
            editor.numberbox("setValue",value);
        }catch (e) {}
    }


    function remove() {
		var rows = $("#productiondayplan_dg").datagrid("getSelections");
		if (rows.length == 0) {
			ext.tip.warn(tipSelectAtLeastOne);
			return;
		}
	
		for (var i = 0; i < rows.length; i++) {
			index = $("#productiondayplan_dg").datagrid("getRowIndex", rows[i]);
			log(rows[i].status_s)
			if (rows[i].status_s != '218001') {
				ext.tip.warn("<spring:message code="tip.forbiddenDeleteOrEdit" />");
				return;
			}
		}
		
		$.messager.confirm('<spring:message code="tip.confirmDelete" />',
				'<spring:message code="tip.confirmDelete" />?', function(r) {
					if (r) {
						
						//获取界面选择的ID
				    	var ids=[];
				    	for(var i=0;i<rows.length;i++){
				    		ids.push(rows[i].atr_key);
				    	}
						
						ext.ajax.get("curing/productionPlan/dailyPlan/delete3?ids="
								+ ids, function(data) {
							if (data.code == OK) {
								ext.tip.suc();
								filter();
								return;
							} else {
								ext.tip.error(data.message);
							}
						});
					}
				});

	}
  //根据胎胚条码查询规格信息
	function specFormatter1(value,row,index){
		//console.log(row);
		debugger;
		var code=row.specification_left_s;
		if(code.length>=9){
			code=code.substring(0,9);
		}
		var spec="";
		  $.ajax({
		 		url:"Part/searchByMaterialCode?partNumber="+code,
		 		type:"get",
		 		dataType:"json",
		 		async:false,
		 		success:function(data){
		 			spec= data.MatDescFull;
		 		}
		 	});
		  var lastIndex=spec.lastIndexOf(' ');
		  spec= spec.substring(lastIndex+1);
		  return spec;
	}
	

</script>