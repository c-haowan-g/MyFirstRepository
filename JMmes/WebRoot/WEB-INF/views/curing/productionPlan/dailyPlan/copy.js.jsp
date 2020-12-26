<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"curing/productionPlan/dailyPlan/saveChanges";
    
    var action="";
    var isCopy=false;
    
    var code="LHRJH";
   // 机台信息
    var jtxx=[];
   //物料信息
    var materialList=[];
    
    var editingIndex=-1;
    
    /* $(function(){
    	
    	var date=parent.$("#production_date_s").datebox("getValue");
    	var line=parent.$("#production_line_s").combobox("getValue");
    	
    	var row=parent.$("#productiondayplan_dg").datagrid("getChecked");
    	
    	if(date!=""){
    		$("#production_date_s").datebox("setValue",date);
    	}
    	
    	if(line!=""){
    		$("#production_line_s").combobox("setValue",line);
    	}
    	
    	if(row.length!=0){
    		$("#production_date_s").datebox("setValue",row[0].production_date_s);
    		$("#production_line_s").combobox("setValue",row[0].production_line_s);
    	}
    	
    }); */
    
    function grid(){
    	return $("#productiondayplan_dg");
    }
    var testFlagList=[];//试验胎参数的计划列表
    function copy(){
    	
    	var from=$("#from").datebox("getValue");
    	var to=$("#to").datebox("getValue");
    	
    	// 被复制的日期计划不能为空
    	// 要复制的日期不能已经安排计划
    	if(from==""||from==null||to==null||to==""){
    		 ext.tip.warn("请先选择时间");
             return;
    	}
    	//grid().datagrid("reload",filter);
    	var productvererrorlist=[];//无生产版本的物料列表
    	var materialoutdatelist=[];//失效物料列表
    	
    	var materialoutdatelistarray=new Array(); 
        ext.ajax.post("curing/productionPlan/dailyPlan/copy",{"filter[production_date_s]":from,to:to,all:1},function(data){
        	
        	
        	if(data.code==OK){
        		
        		productvererrorlist=data.data[1];
       		    materialoutdatelist=data.data[2];
       		    for(var j=0;j<materialoutdatelist.length;j++){
       			  materialoutdatelistarray.push(materialoutdatelist[j].material_code_left_s);
				}
       		    changebackcolor(materialoutdatelistarray,productvererrorlist);//修改背景色
       		   
       		    for(var i = 0; i < data.data[0].length; i++){
       			   if(data.data[0][i].equip_code_left_s==data.data[0][i].equip_code_right_s){
       				ext.tip.error(data.data[0][i].equip_code_left_s+'机台的前日计划左右模条码一样，不允许添加');
			        return;
       			   }
       			   data.data[0][i].memo_left_s='复制';
       			   data.data[0][i].memo_right_s='复制';
       		    }
       		    debugger
        	 	grid().datagrid("loadData",data.data[0]);//复制页面加载数据
        		//grid().datagrid('selectAll');
        		//openEdit();
        		testFlagList=data.data[3];//form日期是试验胎参数
        		if(testFlagList==null||testFlagList==[]||testFlagList==""){
        			return;
        		}
        		
        		$("#testparameter_dlg").dialog("open");
        		
        	}else{
        		ext.tip.error(data.message);
        	}
        });
    }
    var testParameterPlanNoList=new Array(); 
    //加载试验胎参数的列表
    function loadtestparameter(){
    	 testParameterPlanNoList=new Array(); 
    	$("#testparameter_dg").datagrid("loadData",testFlagList);
    }
    //试验胎参数选择页面点击了保存按钮
    function doSaveTestParaList(){
    	var rows=$("#testparameter_dg").datagrid("getSelections");
    	for(var i=0;i<rows.length;i++){
    		testParameterPlanNoList.push(rows[i].plan_no_s);
		}
    	$("#testparameter_dlg").dialog("close");
    }
    //点击了取消按钮
    function  closedlg(){
    	testParameterPlanNoList=new Array(); 
    	$("#testparameter_dlg").dialog("close");
    }
    
    //更改背景色
    function changebackcolor(materialoutdatelistarray,productvererrorlist){
    	 $("#productiondayplan_dg").datagrid({rowStyler:function(index,row){
         	//物料失效的设置为粉红色
         	for(var i = 0; i < materialoutdatelistarray.length; i++){
                 if(row.material_code_left_s == materialoutdatelistarray[i]){
                 	return "background-color:pink";
                 }
             }
         	//无生产版本的变成橙色
         	for(var i=0;i<row.size;i++){
 				if(row.productionver_left_s==productvererrorlist[i].productionver_left_s){
 					return "background-color:orange";
 				}
 			}
         	
         	//数量为0的设置为红色
 			if(row.planamount_mor_left_i==0||row.planamount_mid_left_i==0||row.planamount_nig_left_i==0
 					||row.planamount_mor_right_i==0||row.planamount_mid_right_i==0||row.planamount_nig_right_i==0
 						||row.quantity_dayplan_left_i==0||row.quantity_dayplan_right_i==0
 						){
 				return "background-color:red";
 			}
 		}})
    }
    
    
	//校验左成本
	function onMaterialVer_left(record){
		var index = $(this).parents("[datagrid-row-index]").attr(
		"datagrid-row-index");
		var materialleftEditor = $("#productiondayplan_dg").datagrid('getEditor', {
			index : index,
			field : "material_code_left_s"
		});
		var materialleft = $(materialleftEditor.target).textbox("getValue");
		$.ajax({
		 		url:"curing/productionPlan/dailyPlan/greenTire?code=" + materialleft,
		 		type:"get",
		 		dataType:"json",
		 		async:false,
		 		success:function(data){
		 			for(var i=0;i<data.data.length;i++){
		 				if(data.data[i].specification_left_s==record){
		 					//验证成本
		 					$.ajax({
		 				 		url:"curing/productionPlan/dailyPlan/cost?code=" + materialleft+"&masterrevision="+data.data[i].childbom_ver_left_s+"&childcode="+data.data[i].childspecification_left_s,
		 				 		type:"get",
		 				 		dataType:"json",
		 				 		async:false,
		 				 		success:function(data){
		 				 			if (data.code != 0) {
		 				 				ext.tip.error("<spring:message code="tip.validmaterialcb" />");
		 							}
		 				 		}
		 				 	});
		 				}
		 			}
		 		}
		 	});

	}
    function onBeginEdit(index,row){
    	editingIndex=index;
    }
    
    function onEndEdit(index,row){
    	editingIndex=-1;
    }
    
  //加载产线信息
	$.ajax({
		url : 'curing/baseData/curingProductionLineInfo/comboxProductlineEqu',
		type : 'get',
		dataType : 'json',
		async : false,
		success : function(data) {
			jtxx = data;
		}
	});
  //加载物料信息
  function loadMaterial(date){
	 date= new Calendar(date).format("yyyyMMdd")
	  console.log(date)
	$.ajax({
		url : 'curing/productionPlan/monthlyPlan/materials?date='+date,
		type : 'post',
		dataType : 'json',
		async : false,
		success : function(data) {
			debugger
			materialList = data;
		}
	});
  }
    
    
  
    
    function onDgBeforeLoad(param){
    	if($("#from").datebox("getValue")==""){
    		return false;
    	}
    	if($("#to").combobox("getValue")==""){
    		return false;
    	}
    	param["filter[production_date_s]"]=$("#from").datebox("getValue");
    }
    
    function showOrHide(){
        if($("#ProductionDayPlan_search_form").is(":hidden")){
            $("#ProductionDayPlan_search_form").show();
        }else{
            $("#ProductionDayPlan_search_form").hide();
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
    		setFieldValue(index, "plan_queue_s",1);
    		/* setFieldValue(index, "plan_queue_s",$("#productiondayplan_dg").datagrid("getRows").length);
    		setFieldValue(index, "planamount_mor_left_i", 0);
            setFieldValue(index, "planamount_mid_left_i", 0);
            setFieldValue(index, "planamount_nig_left_i", 0); */
    		if(data.data.lastPlan==null){
    			// 找不到昨日的日计划，这里要从后台查询左右摸条码，用户去完善计划其他信息
    			ext.ajax.get("curing/productionPlan/dailyPlan/machines/"+codeValue,function(machines){
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
    		}else{
    			var plan=data.data.lastPlan;
    			setFieldValue(index, "equip_code_left_s", plan.equip_code_left_s);
    			setFieldValue(index, "equip_code_right_s", plan.equip_code_right_s);
    			setFieldValue(index, "material_code_left_s", plan.material_code_left_s);
    			setFieldValue(index, "material_code_right_s", plan.material_code_right_s);
    			setFieldValue(index, "material_desc_left_s", plan.material_desc_left_s);
    			setFieldValue(index, "material_desc_right_s", plan.material_desc_right_s);
    			setFieldValue(index, "productionver_left_s", plan.productionver_left_s);
    			setFieldValue(index, "productionver_right_s", plan.productionver_right_s);
    			setFieldValue(index, "production_step_left_s", plan.production_step_left_s);
    			setFieldValue(index, "production_step_right_s", plan.production_step_right_s);
    			setFieldValue(index, "specification_left_s", plan.specification_left_s);
    			setFieldValue(index, "specification_right_s", plan.specification_right_s);
    			setFieldValue(index, "childbom_ver_left_s", plan.childbom_ver_left_s);
    			setFieldValue(index, "childbom_ver_right_s", plan.childbom_ver_right_s);
    			setFieldValue(index, "processbom_index_build_s", plan.processbom_index_build_s);
    			setFieldValue(index, "processbom_index_curing_s", plan.processbom_index_curing_s);
    			setFieldValue(index, "planamount_mor_left_i", plan.planamount_mor_left_i);
    			setFieldValue(index, "planamount_mor_right_i", plan.planamount_mor_right_i);
    			setFieldValue(index, "planamount_mid_left_i", plan.planamount_mid_left_i);
    			setFieldValue(index, "planamount_mid_right_i", plan.planamount_mid_right_i);
    			setFieldValue(index, "planamount_nig_left_i", plan.planamount_nig_left_i);
    			setFieldValue(index, "planamount_nig_right_i", plan.planamount_nig_right_i);
    			setFieldValue(index, "quantity_dayplan_left_i", plan.quantity_dayplan_left_i);
    			setFieldValue(index, "quantity_dayplan_right_i", plan.quantity_dayplan_right_i);
    			setFieldValue(index, "reason_midclass_left_s", plan.reason_midclass_left_s);
    			setFieldValue(index, "reason_midclass_right_s", plan.reason_midclass_right_s);
    			setFieldValue(index, "reason_morclass_left_s", plan.reason_morclass_left_s);
    			setFieldValue(index, "reason_morclass_right_s", plan.reason_morclass_right_s);
    			setFieldValue(index, "reason_nigclass_left_s", plan.reason_nigclass_left_s);
    			setFieldValue(index, "reason_nigclass_right_s", plan.reason_nigclass_right_s);
    			setFieldValue(index, "memo_left_s", plan.memo_left_s);
    			setFieldValue(index, "memo_right_s", plan.memo_right_s);
    		}
    	});
    }
    
    function materialClear_left(){
    	var index=$(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
    	var zao_right=getNumberSpinnerValue(index, "planamount_mor_right_i");
        var zhong_right=getNumberSpinnerValue(index, "planamount_mid_right_i");
        var wan_right=getNumberSpinnerValue(index, "planamount_nig_right_i");
        
        setFieldValue(index, "planamount_mor_left_i", 0);
        setFieldValue(index, "planamount_mid_left_i", 0);
        setFieldValue(index, "planamount_nig_left_i", 0);
        
        setFieldValue(index, "planamount_mor_right_i", zao_right);
        setFieldValue(index, "planamount_mid_right_i", zhong_right);
        setFieldValue(index, "planamount_nig_right_i", wan_right);
        
    }
    
    function materialClear_right(){
    	var index=$(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
        
        setFieldValue(index, "planamount_mor_right_i", 0);
        setFieldValue(index, "planamount_mid_right_i", 0);
        setFieldValue(index, "planamount_nig_right_i", 0);
    }
    
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("productiondayplan_dg","ProductionDayPlan_search_form");
    }
    
    function onLineSelect(record){
        var index=$(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
        setFieldValue(index, "equip_code_left_s", record.PRODUCTLINE_CODE_S+"1");
        setFieldValue(index, "equip_code_right_s", record.PRODUCTLINE_CODE_S+"2");
        loadYesterdayPlan(index, record.PRODUCTLINE_CODE_S);
    }
    
    function add() {
    	action="ADD";
    	var date=$("#to").datebox("getValue");
    	getSerialByDate(code,date,function(data){
    		ext.easyui.grid.appendAndEdit("productiondayplan_dg",{production_date_s:date,plan_no_s:data.data,status_s:'218001'});
    	});
    }

    function edit() {
    	console.time("timer");
		
        var rows = $("#productiondayplan_dg").datagrid("getSelections");
        var index = -1;
        action="EDIT";
        for (var i = 0; i < rows.length; i++) {
            index = $("#productiondayplan_dg").datagrid("getRowIndex", rows[i]);
            if(rows[i].status_s!='218001'){
            	ext.tip.warn("<spring:message code="tip.forbiddenDeleteOrEdit" />");
            	break;
            }
            
            $("#productiondayplan_dg").datagrid("beginEdit", index);
        }
        console.timeEnd("timer");
    }
    function openEdit() {
    	console.time("timer");
		
        var rows = $("#productiondayplan_dg").datagrid("getSelections");
        var index = -1;
        action="EDIT";
        for (var i = 0; i < rows.length; i++) {
            index = $("#productiondayplan_dg").datagrid("getRowIndex", rows[i]);
            $("#productiondayplan_dg").datagrid("beginEdit", index);
        }
        console.timeEnd("timer");
    }
    function remove() {
        var rows = $("#productiondayplan_dg").datagrid("getChecked");
        if(rows.length==0){
            ext.tip.warn(tipSelectAtLeastOne );
            return;
        }
        
        
        
        $.messager.confirm('<spring:message code="tip.confirmDelete" />', '<spring:message code="tip.confirmDelete" />?', function(r){
            if (r){
            	for(var i=0;i<rows.length;i++){
            		$("#productiondayplan_dg").datagrid("deleteRow",$("#productiondayplan_dg").datagrid("getRowIndex",rows[i]));
            	}
            	
            }
        });
        
    }
    
    /**
     * 获取指定行、指定列的编辑器
     */
    function getEditor(index,field){
    	return $("#productiondayplan_dg").datagrid("getEditor",{index:index,field:field});
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
    	//选择左模，之后要清空的列值
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
					/* "planamount_mor_left_i",
					"planamount_mor_right_i",
					"planamount_mid_left_i",
                    "planamount_mid_right_i",
                    "planamount_nig_left_i",
                    "planamount_nig_right_i", */
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

            if (data.data.length == 0) {
                ext.tip.warn("<spring:message code="tip.incompleteMaterialInfo" />");
                return;
            }

            $(getEditor(index, "specification_left_s").target)
                    .combobox("loadData", data.data);
            $(
                    getEditor(index, "specification_right_s").target)
                    .combobox("loadData", data.data);
            
            $(getEditor(index, "production_step_left_s").target)
            .combobox("loadData", data.data);
            $(
            getEditor(index, "production_step_right_s").target)
            .combobox("loadData", data.data);
            
            /* if (data.data.length == 1) {
                $(getEditor(index,"specification_left_s").target)
                        .combobox("select",data.data[0].specification_left_s);
                $(getEditor(index,"specification_right_s").target)
                        .combobox("select",data.data[0].specification_right_s);
            }  */
            $(getEditor(index, "material_code_right_s").target)
            .textbox("setValue", record.MATERIAL_CODE_S);
		    $(getEditor(index, "material_desc_right_s").target)
		            .textbox("setValue", record.MATERIAL_NAME_S);
		    $(getEditor(index, "material_desc_left_s").target)
            .textbox("setValue", record.MATERIAL_NAME_S);//
             debugger
            //复制验证胎胚版本，将默认胎胚版本填入下拉框
            var specificationleftEditor = $("#productiondayplan_dg").datagrid('getEditor', {
			index : index,
			field : "specification_left_s"
			});
			var specification_left = $(specificationleftEditor.target).textbox("getValue");
            for(var i=0;i<data.data.length;i++){
            	if(specification_left==data.data[i].specification_left_s){
            	console.log(specification_left+"---"+data.data[i].specification_left_s.trim())
            		 $(getEditor(index,"specification_left_s").target)
                     .combobox("select",data.data[i].specification_left_s);
            	} 
            }
            for(var i=0;i<data.data.length;i++){
				//产品阶段默认带出顺序：投产03》试产02》试制01
				console.log(data.data[i].production_step_left_s)
				if(data.data[i].production_step_left_s=="03"){
					$(getEditor(index,"specification_left_s").target)
					 .combobox("setValue",data.data[i].specification_left_s);
					$(getEditor(index,"specification_right_s").target)
					 .combobox("setValue",data.data[i].specification_right_s);
					debugger
					return;
				}
				
			}
			for(var i=0;i<data.data.length;i++){
				 if(data.data[i].production_step_left_s=="02"){
					$(getEditor(index,"specification_left_s").target)
					 .combobox("setValue",data.data[i].specification_left_s);
					$(getEditor(index,"specification_right_s").target)
					 .combobox("setValue",data.data[i].specification_right_s);
					return;
				} 
			}
			for(var i=0;i<data.data.length;i++){
				 if(data.data[i].production_step_left_s=="01"){
					$(getEditor(index,"specification_left_s").target)
					 .combobox("setValue",data.data[i].specification_left_s);
					$(getEditor(index,"specification_right_s").target)
					 .combobox("setValue",data.data[i].specification_right_s);
					return;
				}
			}
            //map.put("productionver_left_s", costCollector(code));
            //map.put("productionver_right_s", costCollector(code));

            /* $(getEditor(index, "productionver_left_s").target).textbox("setValue",data.data[0].productionver_left_s);
            $(getEditor(index, "productionver_right_s").target).textbox("setValue",data.data[0].productionver_right_s); */

           
        
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
    	var rowIndex = $(this).parents('.datagrid-row').attr('datagrid-row-index');
    	if(ov!=""){
			ext.ajax.get(
					"curing/productionPlan/dailyPlan/greenTire?code=" + nv,
					function(data) {
						if (data.data.length == 0) {
							ext.tip.warn("<spring:message code="tip.incompleteMaterialInfo" />");
							return;
						}
						
						if(data.data.length>1){
							$(getEditor(rowIndex, "specification_left_s").target).combobox("clear");
							$(getEditor(rowIndex, "specification_right_s").target).combobox("clear");
							$(getEditor(rowIndex, "spec_right_s").target).textbox("clear");
							$(getEditor(rowIndex, "spec_left_s").target).textbox("clear");
						}
					});
		}
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
                        /* "planamount_mor_left_i",
                        "planamount_mor_right_i",
                        "planamount_mid_left_i",
                        "planamount_mid_right_i",
                        "planamount_nig_left_i",
                        "planamount_nig_right_i", */
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
        if (data.data.length == 0) {
								ext.tip.warn("<spring:message code="tip.incompleteMaterialInfo" />");
								return;
							}
            
        	$(getEditor(index, "specification_right_s").target).combobox("loadData", data.data);
            $(getEditor(index, "production_step_right_s").target).combobox("loadData", data.data);


            $(getEditor(index, "material_code_right_s").target)
                    .textbox("setValue", record.MATERIAL_CODE_S);
            $(getEditor(index, "material_desc_right_s").target)
                    .textbox("setValue", record.MATERIAL_NAME_S);
                    if (data.data.length == 1) {
							$(getEditor(index,"specification_right_s").target)
									.combobox("select",data.data[0].specification_right_s);
						}
						else if(data.data.length>1){
								debugger
								for(var i=0;i<data.data.length;i++){
									//产品阶段默认带出顺序：投产03》试产02》试制01
									console.log(data.data[i].production_step_left_s)
									if(data.data[i].production_step_left_s=="03"){
										$(getEditor(index,"specification_right_s").target)
										 .combobox("setValue",data.data[i].specification_left_s);
										
										debugger
										return;
									}
									
								}
								for(var i=0;i<data.data.length;i++){
									 if(data.data[i].production_step_left_s=="02"){
										$(getEditor(index,"specification_right_s").target)
										 .combobox("setValue",data.data[i].specification_left_s);
										
										return;
									} 
								}
								for(var i=0;i<data.data.length;i++){
									 if(data.data[i].production_step_left_s=="01"){
										$(getEditor(index,"specification_right_s").target)
										 .combobox("setValue",data.data[i].specification_left_s);
									
										return;
									}
								}
							}
        })
    }
    
	function onStageSelect_left(record){
	        
		var index = $(this).parents("[datagrid-row-index]").attr(
        "datagrid-row-index");

		var m1=getFieldValue(index, "material_code_left_s"),m2=getFieldValue(index, "material_code_right_s");
		
		$(getEditor(index, "production_step_left_s").target).combobox("setValue",
		        record.production_step_left_s);
		$(getEditor(index, "childbom_ver_left_s").target).textbox("setValue",
		        record.childbom_ver_left_s);
		
		$(getEditor(index, "processbom_index_build_s").target).textbox(
		        "setValue", record.processbom_index_build_s);
		
		$(getEditor(index, "processbom_index_curing_s").target).textbox(
		        "setValue", record.processbom_index_curing_s);
		
		if(m1!=m2){
		    return;
		}
		
		
		$(getEditor(index, "specification_right_s").target).combobox(
		        "setValue", record.specification_left_s);
		
		$(getEditor(index, "specification_right_s").target).combobox(
		        "setText", record.specification_right_s);
		
		
		
		$(getEditor(index, "production_step_right_s").target).combobox("setValue",
		        record.production_step_right_s);
		
		$(getEditor(index, "childbom_ver_right_s").target).textbox("setValue",
		        record.childbom_ver_right_s);
	}
    
    function onStageSelect_right(record){
        var index=$(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
		var specification_right_s=record.specification_right_s.substring(0,9);
		  $.ajax({
		 		url:"Part/searchByMaterialCode?partNumber="+specification_right_s,
		 		type:"get",
		 		dataType:"json",
		 		async:false,
		 		success:function(data){
		 			var spec=data.MatDescFull;
		 			var lastIndex=spec.lastIndexOf(' ');
		 			  spec= spec.substring(lastIndex+1);
		 			$(getEditor(index, "spec_right_s").target).textbox("setValue",
		 					spec);
		 		}
		 	});
		
		var m1=getFieldValue(index, "material_code_left_s"),
		m2=getFieldValue(index, "material_code_right_s");
		$(getEditor(index, "production_step_right_s").target).combobox("setValue",
                record.production_step_right_s);
		$(getEditor(index, "childbom_ver_right_s").target).textbox("setValue",
                record.childbom_ver_right_s);
		$(getEditor(index, "spare8_s").target).textbox(
                "setValue", record.processbom_index_build_s);
		$(getEditor(index, "spare10_s").target).textbox(
                "setValue", record.processbom_index_curing_s);
		
		if(m1!=m2){
			return;
		}
		
		
		$(getEditor(index, "specification_right_s").target).combobox(
				"setValue", record.specification_left_s);
		
		$(getEditor(index, "specification_right_s").target).combobox(
				"setValue", record.specification_right_s);

		
		
	
		
		
        $(getEditor(index, "production_step_right_s").target).combobox("setValue",
                record.production_step_right_s);
        
        $(getEditor(index, "childbom_ver_right_s").target).textbox("setValue",
                record.childbom_ver_right_s);
        
       
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
    
    /* 
    1. 同一天，分机台的顺序号不能重复
    2. 同一天，统机台，物料编码不能重复（是否区分左右摸）  不区分
    */
    function valid(){
    	
    	var lineAndCode={};
    	var lineAndOrder={};
    	
    	var rows=grid().datagrid("getRows");
    	
    	var order=0;
    	
    	var orders="1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30";
    	
    	for(var i=0;i<rows.length;i++){
    		
    		var line=getFieldValue(i, "production_line_s");
    		var order=getFieldValue(i, "plan_queue_s");
    		
    		lineAndOrder[line]=lineAndOrder[line]?lineAndOrder[line]:""+order;
    		
    		var key_left=line+getFieldValue(i, "material_code_left_s");
    		var key_right=line+getFieldValue(i, "material_code_right_s");
    		
    		// 左右摸一致的情况
    		if(key_left==key_right){
    			// 如果不存在该特征值，则不重复
    			if(!lineAndCode[key_left]){
                    lineAndCode[key_left]=null;
                }else{
                	ext.tip.warn("<spring:message code="tip.materialRepeat" />:"+getFieldValue(i, "production_line_s")+"\t"+getFieldValue(i, "material_code_left_s"));
                	return false;
                }
    		}else{
    			
    			if(!lineAndCode[key_left]){
                    lineAndCode[key_left]=null;
                }else{
                    ext.tip.warn("<spring:message code="tip.materialRepeat" />:"+getFieldValue(i, "production_line_s")+"\t"+getFieldValue(i, "material_code_left_s"));
                    return false;
                }
    			if(!lineAndCode[key_right]){
                    lineAndCode[key_right]=null;
                }else{
                    ext.tip.warn("<spring:message code="tip.materialRepeat" />:"+getFieldValue(i, "production_line_s")+"\t"+getFieldValue(i, "material_code_right_s"));
                    return false;
                }
    		}
    	}
    	
    	for(var k in lineAndOrder){
    		
    		if(orders.indexOf(lineAndOrder[k])!=0){
    			ext.tip.warn("<spring:message code="tip.errorOrder" />:<spring:message code="productiondayplan.column.production_line_s" />"+k+","+lineAndOrder[k]);
    			return false;
    		}
    		
    	}
    	
    	return true;
    }

    function save() {
    	var dg = $("#productiondayplan_dg");
    	//数据有效性校验
        //var rows = dg.datagrid("getSelections");
        /* for (var i = 0; i < rows.length; i++) {
            if (!dg.datagrid("validateRow", i)) {
                ext.tip.error("<spring:message code="tip.invalid" />");
                return;
            }
        } */
    	if(!valid()){
    		return;
    	}
    	
    	/* if(editingIndex==-1){
    		return;
    	} */
    	
    	
    	

        var rows = dg.datagrid("getSelections");
        var rowsSended=[];
        if(rows==null||rows.length==0){
        	ext.tip.warn("<spring:message code="tip.atLeastOneSelected" />");
        	return;
        }
        for(var i=0;i<rows.length;i++){
        	var index=dg.datagrid('getRowIndex',rows[i]);
        	rowsSended.push(getRowValues(index));
        }
        
        /* dg.datagrid("endEdit", editingIndex); */
        ext.ajax.sendJson(saveChanges,{inserted:rowsSended,testParameterList:testParameterPlanNoList,fromdate:$("#from").datebox("getValue")},function(data){
        	
        	if(data.code==OK){
        		$.messager.confirm("操作结果", data.data, function (data) {
        			
        		});
        		filter();
				parent.filter();
        		testParameterPlanNoList=new Array(); 
        	}else{
        	    testParameterPlanNoList=new Array(); 
        		ext.tip.error(data.message);
        	}
        });
        
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
        
    
    

    function cancel() {
    	editingIndex=-1;
        $("#productiondayplan_dg").datagrid("loadData",[]);
    }
    
    function searchProductionLine(q, row){
    	if(action=="EDIT"){
    		return;
    	}
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


</script>