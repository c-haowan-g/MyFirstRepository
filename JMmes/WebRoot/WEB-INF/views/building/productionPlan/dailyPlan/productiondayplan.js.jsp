<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    
    var jtxx=[];
    var action = "";
    
    var planStatusCellStyler=function (value,row,index){
    	if (value=="152002"){
    		return 'background-color:#ccff99;';
    	}
    	else if (value=="152004"){
    		return 'background-color:#ffb6c1;';
    	}
    	else if (value=="152003"){
    		return 'background-color:#adff2f;';
    	}
    };
   /*  var monthPlanFlag=0;//月计划初始化标识，默认0未初始化，1初始化
    var materialFlag=0;//物料初始化标识，默认0未初始化，1初始化 */
    /**
     * 接收硫化月计划数据
     */
     var monthPlanList=[];
	    	 var url='building/productionPlan/productiondayplan/searchPlanNoMonthByMonthPlan';
	    	 $.ajax({
	    		 url:url,
	    		 type:'get',
	    		 dataType:'json',
	    		 async:false,
	    		 success:function(data){
	    			 monthPlanList=data;
	    			
	    		 }
	    	 });
	/**
     * 接收物料数据
     */
     var materialCodeList=[];
 	
 	$.ajax({
 		url:"Part/halbMaterialListForDay",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			materialCodeList=data;
 			
 		}
 	});
 	
    
    /**
	 * 基础数据text显示
	 */
	function codeFormatter(v, r, i) {
	  if(v==null){
		  return "";
	  }
		return dictFormat(v);
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
     * 接收combtree数据
     */
     var DICT_307=[];
 	
 	$.ajax({
 		url:"building/productionPlan/productiondayplan/get307BaseData",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			DICT_307=data;
 		}
 	});
 	 /**
     * 接收combtree数据
     */
     var DICT_328=[];
 	
	 	$.ajax({
	 		url:"building/productionPlan/productiondayplan/get328BaseData",
	 		type:"get",
	 		dataType:"json",
	 		async:false,
	 		success:function(data){
	 			DICT_328=data;
	 		}
	 	});
 	
    
  //加载产线信息
    $.ajax({
        url : 'building/basedata/productline/getProductlineByProcess?process='+'252005',
        type : 'get',
        dataType : 'json',
        async:false,
        success : function(data) {
        	log(data)
        	for(var i=0;i<data.length;i++){
        		jtxx.push({value:data[i].p_line_name,text:data[i].p_line_name});
        	}
        }
    });
    
    function showOrHide(){
        if($("#CxProductionDayPlan_search_form").is(":hidden")){
            $("#CxProductionDayPlan_search_form").show();
        }else{
            $("#CxProductionDayPlan_search_form").hide();
        }
    }
    //表格加载前事件
	function onDgBeforeLoad(param) {
		if ($("#production_date_s").datebox("getValue") == "") {
			return false;
		}
		
		param["filter[production_date_s]"] = $("#production_date_s").datebox(
				"getValue");
		
	}
    //胎胚版本选择事件
	 function onVersionSlect(item){
		 var index = $(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
			var materialcode= $(getEditor(index, "material_code_s").target).textbox("getValue");
			if(materialcode==""){
				 ext.tip.error("物料编码请先选择");
		    	return;
		    } 
		    var productionstep= $(getEditor(index, "production_step_s").target).textbox("getValue");
		    var versions=item.BOM_REVISION;
		    //带出工艺配方工艺ID成型
		    var nurl='building/productionPlan/productiondayplan/getPlmBuildingProcessID?materialcode='+materialcode
		    		+"&productionstep="+productionstep
		    		+"&version="+versions;
		    $.ajax({
		        url : nurl,
		        type : 'get',
		        dataType : 'json',
		        async : false,
		        success : function(data) {
		        	$(getEditor(index, "processbom_index_s").target).textbox('setValue',data[0].ROUTE_NAME);//设置成型工艺配方ID
		        }
		    });
    }
    
     function onEquipcodeSelect(item){
    	 var index = $(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
		 var producteDate= $(getEditor(index, "production_date_s").target).textbox("getValue");
    	 var url='building/productionPlan/productiondayplan/getPlanqueue?equipcode='+item.value+"&productdate="+producteDate;
    	 $.ajax({
    		 url:url,
    		 type:'get',
    		 dataType:'json',
    		 async:false,
    		 success:function(data){
    			 $(getEditor(index, "plan_queue_i").target).textbox('setValue',data);//设置顺序号 
    		 }
    	 });
     };
    
     //月计划号选择后->带出列信息，比如规格,物料编码,物料描述,工单号
     /* function onMonthPlanSelect(record){
	    	var index = $(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
	    	//带出工单号
	    	var newurl='building/productionPlan/productiondayplan/getOrderItenByMonthPlanNo?monthPlanNo='+record.PLANNO_MONTH_S;
			    $.ajax({
			        url : newurl,
			        type : 'get',
			        dataType : 'json',
			        async : false,
			        success : function(data) {
			        	if(data==null||data==""){
 			        		 $(getEditor(index, "order_number_s").target).textbox('clear');
 			        		 $(getEditor(index, "order_number_s").target).textbox('loadData',"");
 			        	}else{
 			        		 $(getEditor(index, "order_number_s").target).textbox('setValue',data[0].ORDER_ITEM);//设置工单号
 			        	}
			        }
		        });
		 		var newurl2='building/productionPlan/productiondayplan/getPartNumberByMonthPlanNo?monthPlanNo='+record.PLANNO_MONTH_S;	    
		 			    $.ajax({
		 			        url : newurl2,
		 			        type : 'get',
		 			        dataType : 'json',
		 			        async : false,
		 			        success : function(data) {
		 			        	if(monthPlanFlag==1){
		 			        	     if(data==null||data==""){
		 			        	    	 $(getEditor(index, "specification_s").target).combobox('clear');
		 			        	    	 $(getEditor(index, "specification_s").target).combobox('loadData',"");//物料规格
		 			        	    	 $(getEditor(index, "material_code_s").target).combobox('clear');
		 				        		 $(getEditor(index, "material_code_s").target).combobox('loadData',"");//物料编码
		 				        		 $(getEditor(index, "material_desc_s").target).textbox('clear');
		 				        	}else{
		 				        		 $(getEditor(index, "specification_s").target).combobox('loadData',data);//物料规格
		 				        		 $(getEditor(index, "material_code_s").target).combobox('loadData',data);//物料编码
		 				        		 materialFlag=0;
		 				        	}
		 			        	    var specification = $(getEditor(index, "specification_s").target).combobox('getData');
		 			        	    var materialCode = $(getEditor(index, "material_code_s").target).combobox('getData');
		 							//如果就一个数据的话，就直接填充值了
		 							if(materialCode.length==1){
		 				        		 $(getEditor(index, "specification_s").target).combobox("setValue",specification[0].OLDMATCODE_S);//物料规格
		 				        		 $(getEditor(index, "material_code_s").target).combobox("setValue",materialCode[0].PART_NUMBER);//物料编码
		 							}else{
		 								 $(getEditor(index, "specification_s").target).combobox('clear');
		 								 $(getEditor(index, "material_code_s").target).combobox('clear');
		 								 $(getEditor(index, "material_desc_s").target).textbox('clear');
		 							} 
		 			        	}
		 			        }
		 		        });
     } */
     
     var newFlag=false;
     //物料规格后->带出列信息，比如物料编码,物料描述,月计划号,工单号
    function onSpecificationSelect(record){
    	
	    	var index = $(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
			 $(getEditor(index, "material_desc_s").target)
	         .textbox("setValue", record.DESCRIPTION);//物料描述
			 $(getEditor(index, "material_code_s").target)
	         .textbox("setValue", record.PART_NUMBER);//物料编码
			/*  var productionstep=$(getEditor(index, "production_step_s").target).textbox("getValue");
	          if(productionstep==""){
	        	  //没选阶段
			      return;
	    	  } */
	          var materialcode = record.PART_NUMBER;
	          var productDate = $(getEditor(index, "production_date_s").target).textbox("getValue");
	          if(productDate==""){
	        	  //没选计划日期
			      return;
	    	  }
	            setProductionStep(index,materialcode);
	          //setProductionVersion(index,materialcode,productionstep);
	         // if(materialFlag==1){
	            setPlannoMonthAndOrderNumber(index,materialcode,productDate);
	         // }
	    }
     
       //物料选择后->带出列信息，比如规格,物料描述,月计划号,工单号
       function onMaterialSelect(record){
    	 
	    	var index = $(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
			 $(getEditor(index, "material_desc_s").target)
	         .textbox("setValue", record.DESCRIPTION);//物料描述
			 $(getEditor(index, "specification_s").target)
	         .textbox("setValue", record.OLDMATCODE_S);//规格
			/*  var productionstep=$(getEditor(index, "production_step_s").target).textbox("getValue");
	          if(productionstep==""){
	        	  //没选阶段
			      return;
	    	  } */
	          var materialcode = record.PART_NUMBER;
	          var productDate = $(getEditor(index, "production_date_s").target).textbox("getValue");
	          if(productDate==""){
	        	  //没选计划日期
			      return;
	    	  }
	            setProductionStep(index,materialcode);
	          //setProductionVersion(index,materialcode,productionstep);
	         // if(materialFlag==1){
	            setPlannoMonthAndOrderNumber(index,materialcode,productDate);
	         // }
	    }
      function setProductionStep(index,materialcode){
    	  var nurl='building/productionPlan/productiondayplan/getProductionStepByMaterialcode?materialcode='+materialcode;
		    $.ajax({
		        url : nurl,
		        type : 'get',
		        dataType : 'json',
		        async : false,
		        success : function(data) {
		        	if(data==null||data==""){
		        		 //标记位是为了区分产品阶段弹出窗口是否应该打开
		        		 newFlag = false;
		        		 $(getEditor(index, "production_step_s").target).combobox('clear');
		        		 $(getEditor(index, "production_step_s").target).combobox('loadData',"");
		        		 $(getEditor(index, "productionver_s").target).combobox('clear');
		        		 $(getEditor(index, "productionver_s").target).combobox('loadData',"");
		        		 $(getEditor(index, "version_s").target).combobox('clear');
		        		 $(getEditor(index, "version_s").target).combobox('loadData',"");
		        		 $(getEditor(index, "processbom_index_s").target).textbox('clear');
		        		 $.ajax({
		     		        url : 'building/productionPlan/productiondayplan/getBOMorProductionverByMaterialcode?materialcode='+materialcode,
		     		        type : 'get',
		     		        dataType : 'json',
		     		        async : false,
		     		        success : function(data) {
		     		        	if(data=="BOM为空"){
		     		        		ext.tip.error("物料："+materialcode+"BOM不存在，请联系技术人员！");
		   		        		    return;
		     		        	}else if(data=="成本收集器为空"){
		     		        		ext.tip.error("物料："+materialcode+"成本收集器不存在，请联系财务人员！");
		   		        		    return;
		     		        	}else{
		     		        		ext.tip.error("物料："+materialcode+"BOM和成本收集器都不存在，请联系MES管理人员处理！");
		   		        		    return;
		     		        	}
		     		        }
		     		     });
		        	}else{
		        		if(data[0].judge==2){
		        			//标记位是为了区分产品阶段弹出窗口是否应该打开
		        			newFlag =false;
		        			//以下代码是为了往数组中存入所有后台查出的产品阶段数据
		        			var newData=[];
			        	 	for(var i=0;i<data.length;i++){
			        			if(data[i].PROPHASE_S==01){
			        				newData.push({'ERPCODE_S':'01','DICTNAME_S':'试制'});
			        			}
			        			if(data[i].PROPHASE_S==02){
			        				newData.push({'ERPCODE_S':'02','DICTNAME_S':'试产'});
			        			}
			        			if(data[i].PROPHASE_S==03){
			        				newData.push({'ERPCODE_S':'03','DICTNAME_S':'投产'});
			        			}
			        		} 
			        	 	//以下代码是为了去重对象数组（产品阶段数据）
			        		var result = [];
			        	    var obj = {};
			        		for(var i =0; i<newData.length; i++){
			        		    if(!obj[newData[i].ERPCODE_S]){
			        		       result.push(newData[i]);
			        		       obj[newData[i].ERPCODE_S] = true;
			        		    }
			        	     }
			        		 $(getEditor(index, "production_step_s").target).combobox('clear');
			        		 $(getEditor(index, "production_step_s").target).combobox('loadData',result);
			        		 $(getEditor(index, "productionver_s").target).combobox('clear');
			        		 $(getEditor(index, "productionver_s").target).combobox('loadData',"");
			        		 $(getEditor(index, "version_s").target).combobox('clear');
			        		 $(getEditor(index, "version_s").target).combobox('loadData',"");
			        		 $(getEditor(index, "processbom_index_s").target).textbox('clear');
			        		 ext.tip.error("物料："+materialcode+"有多个胎胚版本号！"+"请手动选择产品阶段");
			        		 return;
			        	}else if(data[0].judge==1){
			        		//标记位是为了区分产品阶段弹出窗口是否应该打开
			        		newFlag =true;
			        		//以下代码是为了往数组中存入所有后台查出的产品阶段数据
		        			var newData=[];
			        	 	for(var i=0;i<data.length;i++){
			        			if(data[i].PROPHASE_S==01){
			        				newData.push({'ERPCODE_S':'01','DICTNAME_S':'试制'});
			        			}
			        			if(data[i].PROPHASE_S==02){
			        				newData.push({'ERPCODE_S':'02','DICTNAME_S':'试产'});
			        			}
			        			if(data[i].PROPHASE_S==03){
			        				newData.push({'ERPCODE_S':'03','DICTNAME_S':'投产'});
			        			}
			        		} 
			        	 	//以下代码是为了去重对象数组（产品阶段数据）
			        		var result = [];
			        	    var obj = {};
			        		for(var i =0; i<newData.length; i++){
			        		    if(!obj[newData[i].ERPCODE_S]){
			        		       result.push(newData[i]);
			        		       obj[newData[i].ERPCODE_S] = true;
			        		    }
			        	    }
			        		//产品阶段
							$(getEditor(index, "production_step_s").target).combobox("setValue",data[0].PROPHASE_S);
                            newFlag =true;
							$(getEditor(index, "production_step_s").target).combobox('loadData',result);
			        		//成本收集器版本
							$(getEditor(index, "productionver_s").target).combobox("setValue",data[0].PRODUCTION_VER_S); 
							//胎胚版本号
							$(getEditor(index, "version_s").target).combobox("setValue",data[0].BOM_REVISION);
							var materialCode=data[0].MASTERSAP_S;
							var productionstep=data[0].PROPHASE_S;
							var versions=data[0].BOM_REVISION;
							//带出工艺配方索引
						    var nurl2='building/productionPlan/productiondayplan/getPlmBuildingProcessID?materialcode='+materialCode
				    		+"&productionstep="+productionstep
				    		+"&version="+versions;
						    $.ajax({
						        url : nurl2,
						        type : 'get',
						        dataType : 'json',
						        async : false,
						        success : function(processbom_index_data) {
						        	$(getEditor(index, "processbom_index_s").target).textbox('setValue',processbom_index_data[0].ROUTE_NAME);//设置成型工艺配方ID
						        }
						    });
			        	}
		        	}
		        }
	     }); 
      }
       
       
       //下拉成本收集器时触发
      function showProductionverPanelList(){
    	  var index = $(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
		  var materialcode= $(getEditor(index, "material_code_s").target).textbox("getValue");
    	  var productionstep=$(getEditor(index, "production_step_s").target).textbox("getValue");
          setProductionVersion(index,materialcode,productionstep);
      }
       //胎胚版本下拉框点击事件
      function showVersionPanelList(){
    	  var index = $(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
  		  var materialcode= $(getEditor(index, "material_code_s").target).textbox("getValue");
  		  if(materialcode==""){
  		    ext.tip.error("物料编码请先选择");
		       return;
  	      }
          var productionstep=$(getEditor(index, "production_step_s").target).textbox("getValue");
          if(productionstep==""){
    		  ext.tip.error("生产阶段请先选择");
		      return;
    	  }
          var newurl='building/productionPlan/productiondayplan/getMaterialVersionByCodeAndStep?materialcode='+materialcode+"&productionstep="+productionstep;
		    $.ajax({
		        url : newurl,
		        type : 'get',
		        dataType : 'json',
		        async : false,
		        success : function(data) {
		        	if(data==null||data==""){
		        		ext.tip.error(materialcode+"该物料、该产品阶段下没有胎胚版本信息,请点击产品阶段来选择需要的胎胚版本信息！");
		        	}
		        	$(getEditor(index, "version_s").target).combobox('loadData',data);//设置
		        }
	     });
          
          
      }
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("cxproductiondayplan_dg","CxProductionDayPlan_search_form");
    }
    
    function add() {
    	
    	action = "ADD";
    	var dateTimeboxData=$("#production_date_s").datebox("getValue");
    	//新增的计划号时间用的是上方下拉框的时间
    	if (dateTimeboxData == "") {
            ext.tip.error("上方下拉框请选择日期");
		}
    	var date1=dateTimeboxData;
    	var date2= new Calendar().format("yyyyMMdd");
    	
    	if(date1<date2){
    		ext.tip.error("不能添加当前日期之前的计划");
    		return;
    	}
    	
    	getSerialByDate("CXRJH",dateTimeboxData,function(data){
    		var row={status_s:152001,
    				production_date_s:dateTimeboxData,
    				plan_no_s:data.data,
    				s_factory_s:factory,
    				customer_flag_s:328001,
    				agenc_no_s:8023,
    				spare1_s:'新增'};
    		ext.easyui.grid.appendAndEdit("cxproductiondayplan_dg",row);
        });
    	 //monthPlanFlag=1;
    	 //materialFlag=1;
    }
    function edit() {
    	var rows = $("#cxproductiondayplan_dg").datagrid("getSelections");//返回选中的复选框
    	var index = -1;
        if(rows.length==0){
        	ext.tip.warn(tipSelectAtLeastOne);
        	return;
        }
        for(var i=0;i<rows.length;i++){
        	if(rows[i].status_s=='152001'){
                index = $("#cxproductiondayplan_dg").datagrid("getRowIndex", rows[i]);
                $("#cxproductiondayplan_dg").datagrid("beginEdit", index);
        	}
        	else{
        		ext.tip.warn("<spring:message code="tip.notAllowToEdit" />");
        	}
        }
    }
    function remove() {

        var rows = $("#cxproductiondayplan_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
        	if(rows[i].status_s=='152001'){
        		index = $("#cxproductiondayplan_dg").datagrid("getRowIndex", rows[i]);
                $("#cxproductiondayplan_dg").datagrid("deleteRow", index);
        		
        	}else{
        		ext.tip.warn("只有未审核状态的计划才允许删除");
        	}
            
        }

    }
    
    var saveChanges=path+"building/productionPlan/productiondayplan/saveChanges";
    function save() {
        var dg = $("#cxproductiondayplan_dg");

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
      //由于实体类不对应,需要把table中来自其他表的键删掉
		Utils.each(deleted, function(i, d) {
			delete d.auditbyname;
			delete d.createdname;
			delete d.changebyname;
		});
        var panduan=true;
		Utils.each(updated, function(i, d) {
			delete d.auditbyname;
			delete d.createdname;
			delete d.changebyname;
			if(d.quantity_dayplan_i<=0){
            	ext.tip.error(d.equip_code_s+"日计划数量不能为0");
            	dg.datagrid("beginEdit", i);
            	panduan=false;
                return;
            }
		});
		Utils.each(inserted, function(i, d) {
			delete d.auditbyname;
			delete d.createdname;
			delete d.changebyname;
			if(d.quantity_dayplan_i<=0){
            	ext.tip.error(d.equip_code_s+"日计划数量不能为0");
            	dg.datagrid("beginEdit", i);
            	panduan=false;
                return;
            }
		});
        if(panduan==false){
        	return;
        }
        ext.ajax.sendJson(saveChanges, {
            inserted : inserted,
            updated : updated,
            deleted : deleted
        }, function(data) {

            if (data.data!="操作成功") {
         		$.messager.confirm({
         		    width: 700,
         		    height: 350,
         		    title: '操作结果',
         		    msg: data.data,
         		    fn: function (r) {
         		           
         		        }
         		    }
         		);
            }
            else{
               $("#cxproductiondayplan_dg").datagrid("reload");
               ext.tip.suc("<spring:message code="tip.success" />");
            }

        });
    }

    function cancel() {
        $("#cxproductiondayplan_dg").datagrid("rejectChanges");
    }
    //审核按钮
    function audit(){
    	var rows= $("#cxproductiondayplan_dg").datagrid("getChecked");
    	
    	if(rows.length==0){
    		ext.tip.warn(tipSelectAtLeastOne);
    		return;
    	}
    	
    	var ids=[];
    	
    	for(var i=0;i<rows.length;i++){
    		if(rows[i].status_s!='152001'){
    			ext.tip.warn((i+1)+"<spring:message code="tip.row" /><spring:message code="tip.audited" />");
    			return;
    		}
    		ids.push(rows[i].atr_key);
    	}
    	
    	ext.ajax.post("building/productionPlan/productiondayplan/audit",{ids:ids.toString()},function(data){
    		if(data.code==OK){
    			ext.tip.suc();
    			filter();
    			return;
    		}
    		ext.tip.error(data.message);
    	});
    }
    //撤销审核
    function cancelAudit(){
        var rows=$("#cxproductiondayplan_dg").datagrid("getChecked");
        
        if(rows.length==0){
            ext.tip.warn(tipSelectAtLeastOne);
            return;
        }
        
        var ids=[];
        
        for(var i=0;i<rows.length;i++){
        	if(rows[i].status_s!='152002'){
                ext.tip.warn((i+1)+"<spring:message code="tip.row" /><spring:message code="tip.canNotCancelAudit" />");
                return;
            }
            ids.push(rows[i].atr_key);
        }
        
        ext.ajax.post("building/productionPlan/productiondayplan/cancelAudit",{ids:ids.toString()},function(data){
            if(data.code!=OK){
            	ext.tip.error(data.message);
            	return;
            }
            ext.tip.suc();
            filter();
        });
    }
    //复制
    function copy(){
    	$("#buildingdayplandlg-copy").dialog("open");
    }
    //插入
    function insert(){
    	 var allrows = $("#cxproductiondayplan_dg").datagrid("getRows");
    	 for(var i=0;i<allrows.length;i++){
    		 if(getEditor(i,"material_code_s")!=null){
    			 ext.tip.warn("请将先保存后再进行插入操作");
    	         return;
    		 }
    	 }
        var rows=$("#cxproductiondayplan_dg").datagrid("getChecked");
        if(rows.length!=1){
            ext.tip.warn("请选择一行数据进行插入");
            return;
        }
        var row=$("#cxproductiondayplan_dg").datagrid("getSelected");
        if(row.status_s=='152003'||row.status_s=='152004'){
        	ext.tip.warn("插入位置是已关闭或未执行，不允许在此插入");
            return;
        }
        if(row.plan_queue_i==1){
        	ext.tip.warn("此序号前不允许插入");
        	return;
        }
        
    	var beforePlanqueue=null;
    	var boolen=true;
    	$.ajax({
	 		url:"building/productionPlan/productiondayplan/getPlanqueueByAfterPlanqueue?currentplanqueue="
	 				+row.plan_queue_i+"&equipCode="+row.equip_code_s+"&productDate="+row.production_date_s,
	 		type:"get",
	 		dataType:"json",
	 		async:false,
	 		success:function(data){
	 			beforePlanqueue=data.data;
	 			if(row.plan_queue_i==parseInt(beforePlanqueue)+1){
	 	        	ext.tip.warn("此序号前不允许插入");
	 	        	boolen=false;
	 	        }
	 		}
	 	});
    	if(boolen==false){
    		return;
    	}
        if(row.status_s=='152002'){
        	$.messager.confirm("提示信息", "插入位置计划会撤销审核，是否继续？", function (data) {
        		if(data) {
        			//点了确认的话，会撤销掉审核状态
        			 var ids=[];
                     ids.push(row.atr_key);
                     ext.ajax.post("building/productionPlan/productiondayplan/cancelAudit",{ids:ids.toString()},function(data){
                         if(data.code!=OK){
                         	ext.tip.error(data.message);
                         	return;
                         }
                     });
        			}else {
        				$("#cxproductiondayplan_dg").datagrid("reload");
        			}
			});
        }
        
    	//插入行
    	var dateTimeboxData=$("#production_date_s").datebox("getValue");
    	if (dateTimeboxData == "") {
            ext.tip.error("上方下拉框请选择日期");
		}
    	var date1=dateTimeboxData;
    	var date2= new Calendar().format("yyyyMMdd");
    	if(date1<date2){
    		ext.tip.error("不能添加当前日期之前的计划");
    		return;
    	}
    	var rowindex = $("#cxproductiondayplan_dg").datagrid("getRowIndex", row);

    	getSerialByDate("CXRJH",dateTimeboxData,function(data){
    		var insertrow={status_s:152001,
    				production_date_s:dateTimeboxData,
    				plan_no_s:data.data,
    				s_factory_s:factory,
    				production_step_s:'03',
    				customer_flag_s:328001,
    				agenc_no_s:8023,
    				equip_code_s:row.equip_code_s,
    				plan_queue_i:parseInt(beforePlanqueue)+1,
    				spare1_s:'新增'};
    		$('#cxproductiondayplan_dg').datagrid('insertRow', {
				index : rowindex,
				row : insertrow
			});
			$("#cxproductiondayplan_dg").datagrid("beginEdit", rowindex);
        });
    	 //monthPlanFlag=1;
    	// materialFlag=1;
    }
    /**
	 * 日期格式化
	 */
	function dateFormat(date) {
		return new Calendar(date).format("yyyyMMdd");
	}
    //计划量联动
    	function onCountChange(nv, ov) {

		var index = $(this).parents("[datagrid-row-index]").attr(
				"datagrid-row-index");

		var zaocount = getNumberSpinnerValue(index, "planamount_mor_i");
		var zhongcount = getNumberSpinnerValue(index, "planamount_mid_i");
		var wancount = getNumberSpinnerValue(index, "planamount_nig_i");
		var dayCount = zaocount + zhongcount + wancount;
		if(dayCount==0){
			ext.tip.error("计划总数不能为0");
			return;
		}
		$(getEditor(index, "quantity_dayplan_i").target).textbox(
				"setValue", dayCount);
	}

    //换物料后，清空受物料编码影响的列
    function onMaterialChange(){
    	var index = $(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
		//更换了物料编码后，要清除得列
		var fields = [
				   "version_s",
				   "processbom_index_s"
				 ];

		for ( var k in fields) {
			clearFieldValue(index, fields[k]);
		}
    }

    //物料选择后->清理计划量
    function materialClearCount(){
    	var index = $(this).parents("[datagrid-row-index]").attr(
		"datagrid-row-index");
		setFieldValue(index, "planamount_mor_i", 0);
		setFieldValue(index, "planamount_mid_i", 0);
		setFieldValue(index, "planamount_nig_i", 0);
		setFieldValue(index, "quantity_dayplan_i", 0);
    }
    
    
    //设置成本收集器下拉框
    function setProductionVersion(index,materialcode,productionstep){
  	  if(materialcode==""){
  		  ext.tip.error("物料编码请先选择");
		      return;
  	  }
      if(productionstep==""){
      	  ext.tip.error("生产阶段请先选择");
		      return;
  	  }
      //带出成本收集器
         var isnull=true;
		  var nurl='building/productionPlan/productiondayplan/getCostcollectorByMaterialAndStep?materialcode='+materialcode+"&productStep="+productionstep;
			    $.ajax({
			        url : nurl,
			        type : 'get',
			        dataType : 'json',
			        async : false,
			        success : function(data) {
			        	if(data==null||data==""){
			        		 ext.tip.error("物料："+materialcode+"当前选择阶段，无成本收集器"+"请联系成本部人员维护");
			        		 $(getEditor(index, "productionver_s").target).combobox('clear');
			        		 $(getEditor(index, "productionver_s").target).combobox('loadData',"");
			        		 isnull=false;
			        		 return;
			        	}
			        	if(isnull==true){
			        		$(getEditor(index, "productionver_s").target).combobox('loadData',data);//设置成本收集器
			        	}
						var v = $(getEditor(index, "productionver_s").target).combobox('getData');
						//如果就一个数据的话，就直接填充值了
						if(v.length==1){
							var productionver=v[0].PRODUCTION_VER_S;//成本收集器版本
							$(getEditor(index, "productionver_s").target).combobox("setValue",productionver);  
						}
			        }
		     }); 
			    
			 //带出胎胚版本
			 var newurl='building/productionPlan/productiondayplan/getMaterialVersionByCodeAndStep?materialcode='+materialcode+"&productionstep="+productionstep;
			    $.ajax({
			        url : newurl,
			        type : 'get',
			        dataType : 'json',
			        async : false,
			        success : function(data) {
			        	if(data==null||data==""){
			        		ext.tip.error(materialcode+"该物料、该产品阶段下没有胎胚版本信息,请点击产品阶段来选择需要的胎胚版本信息！");
			        		 $(getEditor(index, "version_s").target).combobox('clear');
			        		 $(getEditor(index, "version_s").target).combobox('loadData',"");
			        		 $(getEditor(index, "processbom_index_s").target).textbox('setValue',"");
			        	}
			        	$(getEditor(index, "version_s").target).combobox('loadData',data);//设置
			        	
			        	var vv = $(getEditor(index, "version_s").target).combobox('getData');
						//如果就一个数据的话，就直接填充值了
						if(vv.length==1){
							var versions=vv[0].BOM_REVISION;//胎胚版本
							$(getEditor(index, "version_s").target).combobox("setValue",versions);  
						    
							console.log("----"+materialcode);
							console.log("----"+productionstep);
							console.log("----"+versions);
							
							//带出工艺配方索引
						    var nurl2='building/productionPlan/productiondayplan/getPlmBuildingProcessID?materialcode='+materialcode
				    		+"&productionstep="+productionstep
				    		+"&version="+versions;
						    $.ajax({
						        url : nurl2,
						        type : 'get',
						        dataType : 'json',
						        async : false,
						        success : function(data) {
						        	$(getEditor(index, "processbom_index_s").target).textbox('setValue',data[0].ROUTE_NAME);//设置成型工艺配方ID
						        }
						    });
						}
			        }
		     });
    }
    
    function setPlannoMonthAndOrderNumber(index,materialcode,productDate){
    	  if(materialcode==""){
      		  ext.tip.error("物料编码请先选择");
    		      return;
      	  }
          if(productDate==""){
          	  ext.tip.error("计划日期请先选择");
    		      return;
      	  }
          //带出月计划号
 		  var monthPlanNurl='building/productionPlan/productiondayplan/monthlyPlanToCxProductionDayPlan?materialcode='+materialcode+"&productDate="+productDate;
 			    $.ajax({
 			        url : monthPlanNurl,
 			        type : 'get',
 			        dataType : 'json',
 			        async : false,
 			        success : function(data) {
 			        	if(data==null||data==""){
 			        		 $(getEditor(index, "planno_month_s").target).combobox('clear');
 			        		 $(getEditor(index, "planno_month_s").target).combobox('loadData',"");
 			        	}else{
 			        		$(getEditor(index, "planno_month_s").target).combobox('loadData',data);//设置月计划号
 			        		//monthPlanFlag=0;
 			        	}
 			        	 var v = $(getEditor(index, "planno_month_s").target).combobox('getData');
						//如果就一个数据的话，就直接填充值了
						if(v.length==1){
							var plannomonth=v[0].PLANNO_MONTH_S;//成本月计划号
							$(getEditor(index, "planno_month_s").target).combobox("setValue",plannomonth); 
						}else{
							 $(getEditor(index, "planno_month_s").target).combobox('clear');
						}
 			        }
 		     });
 			    
 			 //带出工单号
 		 	 var orderNumberNurl='building/productionPlan/productiondayplan/orderNumberToCxProductionDayPlan?materialcode='+materialcode+"&productDate="+productDate;
 		 		 $.ajax({
 		 			   url : orderNumberNurl,
 		 			   type : 'get',
 		 			   dataType : 'json',
 		 			   async : false,
 		 			   success : function(data) {
 		 			        	if(data==null||data==""){
 		 			        		 $(getEditor(index, "order_number_s").target).textbox('clear');
 		 			        		 $(getEditor(index, "order_number_s").target).textbox('loadData',"");
 		 			        	}else{
 		 			        		$(getEditor(index, "order_number_s").target).textbox('setValue',data[0].ORDER_ITEM);//设置工单号
 		 			        	}
 		 			   }
 		 	     });   
    }
    var editIndex=-1;
    var materialCode="";
    var specification="";
    var productionstep="";
    //产品阶段选择
    function onProStepSlect(record){
    	if(newFlag){
    		newFlag=false;
    	}else {
    		 var index = $(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
    	   	 materialCode = $(getEditor(index, "material_code_s").target).textbox("getValue");
    	   	 specification = $(getEditor(index, "specification_s").target).textbox("getValue");
    	   	 if(materialCode==""||specification==""){
    	   		 ext.tip.error("请先选择物料编码");
    	   		 return;
    	   	 }
    	   	 productionstep=record.ERPCODE_S;
    	     setProductionVersion(index,materialCode,productionstep);
    	     $("#partBomSearch_dlg").dialog("open");
    	     loadPartBomDlgOnOpen();
    	     editIndex=index;
    	}
    }
    function showOrHide(){
        if($("#BillOfMaterial_search_form").is(":hidden")){
            $("#BillOfMaterial_search_form").show();
        }else{
            $("#BillOfMaterial_search_form").hide();
        }
    }
  
    function myLoad(row){
 	   if(row.bom_name==null||row.bom_name==''||row.bom_name==undefined){
 		   return false;
 	   }
        var urlList = "common/billofmaterials/datagridBOMCount?bomkey="+row.bom_name+"/"+row.bom_revision;
     	$("#billofmaterial_dg").treegrid('options').url=urlList; 
     	return true;
    }
    
    function myExpand(){
 	   var url='common/billofmaterials/datagridUDA';
 	   $("#billofmaterial_dg").treegrid('options').url=url;
 	  $('#billofmaterial_dg').treegrid("reload", getFormJson("BillOfMaterial_search_form"));
    }
  
    
    /**
    * 空值转换
    */
    function noneFormatter(value,row){

        if(value==null){
            return "";
        }
        return value;
    }
     /**
      * 查询方法
      */
     var filterBom=function(){
       var url='common/billofmaterials/datagridUDA';
   	   $("#billofmaterial_dg").treegrid('options').url=url;
     	var revisionValue=$('#bom_revision').val();
     	if(revisionValue!=''&&revisionValue!=null){
     		var nameValue=$('#bom_name').val();
     		if(nameValue==null||nameValue==''){
     			ext.tip.warn("BOM版本与BOM名称不能为空！");
     			return false;
     		}
     	}
        $('#billofmaterial_dg').treegrid("reload", getFormJson("BillOfMaterial_search_form"));
     }
     function getFormJson(formId){
 	    if($("#"+formId).length==0){
 	        return {};
 	    }
 		
 	    var formJsonArray=$("#"+formId).serializeArray();
 	    
 	    var likes=$("#"+formId+" [like=true]");
 	    var ins=$("#"+formId+" [in=true]");
 	    var beginWith=$("#"+formId+" [beginWith=true]");
 	    var endWith=$("#"+formId+" [endWith=true]");
 	    
 	    var operators={};
 	    $.each(likes,function(index,e){
 	    	eleName=Utils.isEmpty($(e).attr("textboxname"))?$(e).attr("name"):$(e).attr("textboxname");
 	    	operators[eleName]="contains:";
 	    });
 	    $.each(ins,function(index,e){
 	    	eleName=Utils.isEmpty($(e).attr("textboxname"))?$(e).attr("name"):$(e).attr("textboxname");
 	    	operators[eleName]="in:";
 	    });
 	    
 	    $.each(beginWith,function(index,e){
 	    	eleName=Utils.isEmpty($(e).attr("textboxname"))?$(e).attr("name"):$(e).attr("textboxname");
 	    	operators[eleName]="beginWith:";
 	    });
 	    
 	    $.each(endWith,function(index,e){
 	    	eleName=Utils.isEmpty($(e).attr("textboxname"))?$(e).attr("name"):$(e).attr("textboxname");
 	    	operators[eleName]="endWith:";
 	    });
 	    
 	    
 	    var formJson={};
 	    
 	    Utils.each(formJsonArray,function(i,e){
 	        if(Utils.trim(e.value)!=""){
 	        	formJson[e.name]=(operators[e.name]==undefined?"":operators[e.name])+Utils.trim(e.value);
 	        }
 	    });
 	    //console.log(formJson);
 	    return formJson;
     }
   
    //产品阶段下拉列表
    function onShowProductionStep(){
    	 var index = $(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
    	 $(getEditor(index, "production_step_s").target).combobox('clear');//清空选中项
    } 
    
    function loadPartBomDlgOnOpen(){
    	//子物料SAP品号 
    	var subitemsap_s=materialCode;
    	var productionStep=productionstep;
    	$('#bom_name').val(subitemsap_s);
    	$('#prophase').val(productionStep);
    	filterBom();
    }
    
    var filter1=function(){
    	var url ="building/productionPlan/productiondayplan/treelistQuery2";
    	var list_map = new Array();
    	var subitemsap_s=materialCode;
    	//父物料版本 
    	var bom_revision=$("#bom_revision1").textbox("getValue");
    	//BOM类型
    	var part_number=$("#part_number1").textbox("getValue");
    	//子物料规格
    	var part_revision=$("#part_revision1").textbox("getValue");
    	list_map.push({subitemsap_s:subitemsap_s});
    	list_map.push({bom_revision:bom_revision});
    	list_map.push({part_number:part_number});
    	list_map.push({part_revision:part_revision});
    	ext.ajax.sendJson(url,list_map, function(data) {
    		$("#bom_dg").datagrid("loadData", data);
         });
    }
    
    //半部件bom保存事件
    function savePartBomDlg(){
    	
   		var row=$("#billofmaterial_dg").datagrid("getSelected");
       	if(row.length==0){
       		ext.tip.warn(tipSelectAtLeastOne);
       		return;
       	}
       	console.log($('#bom_name').val()+"____"+row.bom_name.split("_")[0]);
       	if($('#bom_name').val()!=row.bom_name.split("_")[0]){
       		ext.tip.warn("请选择胎胚BOM所在行！");
       		return;
       	}
       	$("#partBomSearch_dlg").dialog("close");
    	$(getEditor(editIndex, "production_step_s").target).combobox('select',row.bom_name.split("_")[1]);
    	$(getEditor(editIndex, "version_s").target).combobox('select',row.bom_revision);
     	materialCode="";
     	editIndex=-1;
    }
  //半部件bom取消事件
    function closePartBomDlg(){
    	 materialCode="";
    	$("#partBomSearch_dlg").dialog("close");
    }
    function flagformatter(v, r, i) {

		if (v == 'A') {
			return "可用";
		}
		return "删除";
	}
    function changeBomStep(){
    	pathBomFilter();
    }
    
    
    //以下为通用
    //获取数据框得值
    function getNumberSpinnerValue(index, field) {
		return parseInt($(getEditor(index, field).target).numberspinner(
				"getValue")) || 0;
	}
    function getRowValues(index){
        var cs=$("#cxproductiondayplan_dg").datagrid('getColumnFields');
        var fcs=$("#cxproductiondayplan_dg").datagrid('getColumnFields', true);
        
        var rows=$("#cxproductiondayplan_dg").datagrid("getRows");
        
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
    
    
    /**
     * 获取指定行、指定列的编辑器
     */
    function getEditor(index,field){
        return $("#cxproductiondayplan_dg").datagrid("getEditor",{index:index,field:field});
    }
    
    /**
     * 清空指定行指定列的值
     */
    function clearFieldValue(index,field){
        
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