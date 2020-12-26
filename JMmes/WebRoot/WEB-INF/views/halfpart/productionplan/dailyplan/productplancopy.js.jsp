<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"halfpart/productionplan/dailyplan/saveChanges";
    var unAuditStatus='104001';
    function getDg(){
     	return $("#productplan_dg");  //$("#a_dg"):获取并返回选中的标签页
    }
    function planStatusColorSetting(value,row,index){
    	if(value=="104001"){
    		return 'text-align: center;';
    	}else if (value=="104002"){
    		return 'background-color:#FFFF00;text-align: center;';
    	}
    	else if (value=="104003"){
    		return 'background-color:#00FFFF;text-align: center;';
    	}
    	else if (value=="104004"){
    		return 'background-color:#00FF00;text-align: center;';
    	}
    	else if (value=="104005"){
    		return 'background-color:#FF0000;text-align: center;';
    	}
    	else if (value=="104006"){
    		return 'background-color:#C0C0C0;text-align: center;';
    	}
    }
    function centerSetting(value,row,index){
        return 'text-align: center;';
    }
    function showOrHide(){
        if($("#ProductPlan_search_form").is(":hidden")){
            $("#ProductPlan_search_form").show();
        }else{
            $("#ProductPlan_search_form").hide();
        }
    }
    function codeFormatter(v, r, i) {
        if(v==null){
            return "";
        }
          return dictFormat(v);
      }
    var planStatus=[];
    $.ajax({
        url:"dict/code/104",
        type:"get",
        dataType:"json",
        async:false,
        success:function(data){
        	planStatus=data;
        }
        });
    
    function planStatusFormatter(v, r, i) {
    	for(var i=0;i<planStatus.length;i++){
    		 if (v == planStatus[i].code) {
    	          return planStatus[i].text;
    	     }
    	}
      }
    var materialGroupList=[];
    $.ajax({
        url:"sap/materials/getMaterialGroupList",
        type:"get",
        dataType:"json",
        async:true,
        success:function(data){
        	materialGroupList=data;
        }
        });
    
   /**
    * 物料组显示转化
    * 2019-05-20
    * 兰颖慧
    */
    function materialGroupFormatter(v, r, i){
         for(var i=0;i<materialGroupList.length;i++){
            if (v == materialGroupList[i].DICTCODE_S) {
                return materialGroupList[i].DICTNAME_S;
            }
          }
    } 
    /**
     * 获取半部件用物料信息
     * 2019/07/08
     * 兰颖慧
     */
     var materialList=[];
     $.ajax({
         url:"sap/materials/getMaterialList",
         type:"get",
         dataType:"json",
         async:false,
         success:function(data){
         	materialList=data;
         }
         });
    function productStageFormatter(v, r, i){
        if        (v == '01') {
            return "试制";
        } else if (v == '02') {
            return "试产";
        } else if (v  =='03') {
        	return "投产";
        } else{
        	return "未知";
        }
    } 
    function autoJudgeFormatter(v, r, i){
        if (v ==0) {
            return "否";
        }
        if (v ==1) {
            return "是";
        }
        if (v==null) {
        	return "未知";
        }
    } 
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("productplan_dg","ProductPlan_search_form");
    }
    /**
	 * 日期格式化
	 * 兰颖慧-2019/03/12
	 */
	function dateFormat(date) {
		return new Calendar(date).format("yyyyMMdd");
	}
    /**
	 * 解析指定格式日期
	 * 兰颖慧-2019/03/12
	 */
	function dateParser(s) {
		if (!s)
			return new Date();
		return new Date(s.substring(0, 4), parseInt(s.substring(4, 6)) - 1, s.substring(6, 8));
	}

    /**
     * 获取机台条码
     *
     */
    function onEquipcodeSelect(item){
   	 var index = $(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
     var producteDate= $(getEditor(index, "production_date_s").target).textbox("getValue");
   	 var url='cx/scgl/rjh/getPlanqueue?equipcode='+item.value+"&productdate="+producteDate;
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

	/**
	 * 班次显示转化
	 * 2019-05-20
	 * 兰颖慧
	 */
    var classList=[];
    $.ajax({
        url:"dict/code/118",
        type:"get",
        dataType:"json",
        async:false,
        success:function(data){
        	classList=data;
        }
        });
    function classCodeFormatter(v, r, i) {
    	for(var i=0;i<classList.length;i++){
    		 if (v == classList[i].code) {
    	          return classList[i].text;
    	     }
    	}
       
      } 
	function checkAndLoadData(newData,oldData){
		  var index = $(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
		  var materialCode=$(getEditor(index, "materialcode_s").target).textbox('getValue');
		  var productVersion=$(getEditor(index, "sapversion_s").target).textbox('getValue');
		  if(materialCode==null||materialCode==""){
			  alert("请先选择物料编码！");
			  return;
		  }
		  if(newData==null||newData==""){
			  return;
		  }
        var checkAndGetVersionByCode='halfpart/productionplan/dailyplan/checkBomAndVersion?materialCode='+materialCode+'&productStage='+newData+'&productVersion='+productVersion;
	      var getCheckedDataByMaterialCode='halfpart/productionplan/dailyplan/getCheckedDataByMaterialCode?materialCode='+materialCode+'&productStage='+newData;
	      $.ajax({
		   		url:checkAndGetVersionByCode,
		   		type:'get',
		   		dataType:'json',
		   		async:false,
		   		success:function(dataByMaterialCode){
		   			if(dataByMaterialCode=="StandardData"){
			   		    $.ajax({
					   		url:getCheckedDataByMaterialCode,
					   		type:'get',
					   		dataType:'json',
					   		async:false,
					   		success:function(checkedData){
			       			      $(getEditor(index, "paraversion_s").target).textbox("setValue",checkedData[0].PROCESSVERSION_S);
			       			      $(getEditor(index, "repiceno_s").target).textbox("setValue",checkedData[0].VERSION_S);
			     			      $(getEditor(index, "parameterid_s").target).textbox("setValue",checkedData[0].ID_S);
					   		}
			     		  });
		   			}else{
		   				alert(dataByMaterialCode);
		   				$(getEditor(index, "productstage_s").target).combobox("clear");
     			        $(getEditor(index, "paraversion_s").target).textbox("clear");
     			        $(getEditor(index, "repiceno_s").target).textbox("clear");
   			        $(getEditor(index, "parameterid_s").target).textbox("clear");
		   			}
	       			

		   		}
	     	}); 
	}
	/**
	 * 获取指定行、指定列的编辑器
	 */
	function getEditor(index,field){
	    return $("#productplan_dg").datagrid("getEditor",{index:index,field:field});
	}
 	/**
	 * 主界面加载触发（按时间加载当天数据）
	 * 2019-05-20
	 * 兰颖慧
	 */
 	function onDgBeforeLoad(param) {
		if ($("#plandate_s").datebox("getValue") == "") {
			return false;
		}
		param["filter[plandate_s]"] = $("#plandate_s").datebox("getValue");
	}
    /**
     *日计划复制时，校验新日期是否已经存在日计划
     *
     */
    var exist=0;
    function planExistJudgeBeforeCopy(date){
 	   exist=0;
 	   var newDate=dateFormat(date);
 		$.ajax({
 		    url : 'halfpart/productionplan/dailyplan/reLoadCopyPlan?newDate='+newDate,
 		    type : 'get',
 		    dataType : 'json',
 		    async :false,
 		    success : function(data){
 		       if(data.length>0){
 		        ext.tip.warn(newDate+"已有计划，可在当前界面查询计划并删除后再复制");
 		        exist=1;
 		       }else{
 		    	exist=0; 
 		       }
 		        return;
 		    }
 		  });
    }  
    
    function planExistJudgeBeforeCopyOldData(){
    	var dataValue = $('#plandate_to_s').datebox('getValue');
    	$.ajax({
 		    url : 'halfpart/productionplan/dailyplan/reLoadCopyPlan?newDate='+dataValue,
 		    type : 'get',
 		    dataType : 'json',
 		    async :false,
 		    success : function(data){
 		       if(data.length>0){
 		        exist=1;
 		       }else{
 		    	exist=0; 
 		       }
 		    }
 		  });
    }
    
 	var save_copy_flag = false;
	/**
	 * 复制方法
	 */
	 var newPlan=[];
	 function  copyDayplan(){
		if(exist==1){
			ext.tip.warn("请重新选择 新计划 日期");
			return;
		}
		var fromDate=$("#plandate_s").datebox("getValue");
		var toDate=$("#plandate_to_s").datebox("getValue");
		// 被复制的日期计划不能为空
		// 要复制的日期不能已经安排计划
		if(fromDate==toDate){
			 ext.tip.warn("请重新选择 新计划 日期");
	         return;
		}
		if(fromDate==""||fromDate==null||toDate==null||toDate==""){
			 ext.tip.warn("开始或结束时间请选择完整");
	         return;
		}
		var dateNow= new Calendar().format("yyyyMMdd");
		if(toDate<dateNow){
			ext.tip.error("不能添加当前日期之前的计划");
			return;
		}
		if(toDate<fromDate){
			ext.tip.error("新计划 日期为"+toDate+",原计划日期为"+fromDate+",请重新选择计划日期");
			return;
		}
		if(Number(toDate)<Number(fromDate)){
			ext.tip.error("新计划 日期为"+toDate+",原计划日期为"+fromDate+",请重新选择计划日期");
			return;
		}
		if(Number(toDate)<Number(dateNow)){
			ext.tip.error("不能添加当前日期之前的计划");
			return;
		}
		var allSelectedCopyRows=$("#productplan_dg").datagrid("getSelections");
	 	if(allSelectedCopyRows.length==0){
			ext.tip.warn(tipSelectAtLeastOne);
			return;
		}

	 	var rowLength=allSelectedCopyRows.length;
	 	var urlPlanNo='halfpart/productionplan/dailyplan/createPlanNoWhenCopy?planData='+toDate+'&num='+rowLength*3;
		$.ajax({
			    url : urlPlanNo,
			    type : 'get',
			    dataType : 'json',
			    async :false,
			    success : function(data){
                   save_copy_flag = true;
			       newPlan=data;
			       var allLength=allSelectedCopyRows.length;
			       for(var i=0;i<allSelectedCopyRows.length;i++){
			           allSelectedCopyRows[i].atr_key="";
			    	   allSelectedCopyRows[i].parent_key="";
			    	   allSelectedCopyRows[i].trx_id="";
			    	   allSelectedCopyRows[i].equip_outport_s ="";
				 	   allSelectedCopyRows[i].morn_planno_s=data[0];
				 	   allSelectedCopyRows[i].noon_planno_s=data[1];
				 	   allSelectedCopyRows[i].even_planno_s=data[2];
				 	   console.log(data[0] + '      '+allSelectedCopyRows[i].morn_planno_s)

				 	   data.splice(0,3);
				 	   allSelectedCopyRows[i].status_s=unAuditStatus;
				 	   allSelectedCopyRows[i].plandate_s=toDate;
// 				 	   $("#productplan_dg").datagrid("updateRow",{index:i,row:allSelectedCopyRows[i]});
			 	 } 
			    }
			  });
		$("#productplan_dg").datagrid("loadData",allSelectedCopyRows);

      }
	/**
	 * 日计划编辑
	 * 2019-04-12
	 * 兰颖慧
	 */
    function edit() {
        var rows = $("#productplan_dg").datagrid("getSelections");
    	if(rows.length==0){
    		ext.tip.warn(tipSelectAtLeastOne);
    		return;
    	}
        var index = -1;
        var ids=[]; //声明数组
        for (var i = 0; i < rows.length; i++) {
    		if(rows[i].status_s=='104001'){
	            var index = -1;
	            index = $("#productplan_dg").datagrid("getRowIndex", rows[i]);
	            $("#productplan_dg").datagrid("beginEdit", index);
    		}else{
	            ext.tip.warn("仅未审核的计划可编辑");
    		}

        }
    }
    /**
     * 复制后页面重新加载复制后的数据
     * 2019-06-10
     * 兰颖慧
     */
    function reLoadCopyPlan(){
    	/* url='halfpart/productionplan/dailyplan/getPlanInfoList?newDate='+newDate;
		$.ajax({
		    url : url,
		    type : 'get',
		    dataType : 'json',
		    async :false,
		    success : function(data){
			 	 $("#productplan_dg").datagrid("loadData",data);
		    }
		  }); */
		if ($("#plandate_s").datebox("getValue") == "") {
			return false;
		}
		param["filter[plandate_s]"] = $("#plandate_to_s").datebox("getValue");
    	ext.easyui.grid.search("productplan_dg","ProductPlan_search_form");
    }
    function save(){
        var dg = $("#productplan_dg");
        var rows = dg.datagrid("getRows");
        for (var i = 0; i < rows.length; i++) {
            if (!dg.datagrid("validateRow", i)) {
                ext.tip.error("<spring:message code="tip.invalid" />");
                return;
            }
        }
        for (var i = 0; i < rows.length; i++) {
            dg.datagrid("endEdit", i);
        }
        ext.ajax.sendJson(saveChanges, {
            inserted : dg.datagrid("getRows"),
        }, function(data) {
            if (data.code!=OK) {
                ext.tip.error("<spring:message code="tip.error" />");
                return;
            }
            //$("#productplan_dg").datagrid("reload");
            reLoadCopyPlan();
        });
    }
    function editSave(){
        if(save_copy_flag){
            save();
            save_copy_flag = false;
        }
        var dg = $("#productplan_dg");
        var rows = dg.datagrid("getRows");
        for (var i = 0; i < rows.length; i++) {
            if (!dg.datagrid("validateRow", i)) {
                ext.tip.error("<spring:message code="tip.invalid" />");
                return;
            }
        }
        var updated = dg.datagrid("getChanges", "updated");
        var deleted = dg.datagrid("getChanges", "deleted");
        for (var i = 0; i < rows.length; i++) {
            dg.datagrid("endEdit", i);
        }
        ext.ajax.sendJson(saveChanges, {
            updated : updated,
            deleted : deleted
        }, function(data) {
            if (!(data.message=="ok")) {
                ext.tip.error("<spring:message code="tip.error" />");
                return;
            }
            ext.tip.suc("<spring:message code="tip.success" />");
            window.parent.closeWindow();
            reLoadCopyPlan();
        });
    }
	/**
	 * 日计划编辑取消
	 * 2019-07-05
	 * 兰颖慧
	 */
    function cancel() {
        $("#productplan_dg").datagrid("rejectChanges");
    }
	/**
	 * 日计划删除
	 * 2019-07-05
	 * 兰颖慧
	 */
    function remove() {
    	var rows = $("#productplan_dg").datagrid("getSelections");//getChecked:返回复选框中选中的所有行
    	if(rows.length==0){
    		ext.tip.warn(tipSelectAtLeastOne);
    		return;
    	}
    	var ids=[]; //声明数组
    	for(var i=0;i<rows.length;i++){
    		if(rows[i].status_s=='104001'){
	            var index = -1;
	            index = $("#productplan_dg").datagrid("getRowIndex", rows[i]);
	            $("#productplan_dg").datagrid("deleteRow", index);
    		}else{
	            ext.tip.warn("仅未审核的计划可删除");
    		}
        }
    }
	/**
	 * 选择物料规格后,清除数据并设置新的物料编码相关信息
	 * 2019年08-21
	 * 兰颖慧
	 */
	function onSetMatDescCodeGroup(record){
		  var index = $(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
		    $.ajax({
		   		url:'halfpart/productionplan/dailyplan/getMatInfoByMatSpec?materialSpec='+record.OLDMATCODE_S,
		   		type:'get',
		   		dataType:'json',
		   		async:false,
		   		success:function(data){
		   			if(data.length==0){
		   				debugger;
		   				alert("物料规格:"+record.OLDMATCODE_S+"对应的物料的SAP下发版本(生产版本)不存在");
				  		  $(getEditor(index, "materialname_s").target).textbox('clear');//物料名称
						  $(getEditor(index, "materialcode_s").target).combobox('clear');//物料编码
				  		  $(getEditor(index, "materialgroup_s").target).textbox('clear');//物料组编码
				  		  $(getEditor(index, "materialdesc_s").target).textbox('clear');//物料组名称
				  		  $(getEditor(index, "sapversion_s").target).textbox('clear');//生产版本
				  		  $(getEditor(index, "overpercent_f").target).textbox('clear');//物料超产百分比
				  		  $(getEditor(index, "productstage_s").target).combobox('setValue','');//产品阶段
					  	  $(getEditor(index, "paraversion_s").target).combobox('setValue','');//工艺版本
					  	  $(getEditor(index, "parameterid_s").target).combobox('setValue','');//工艺版本ID
					  	  $(getEditor(index, "repiceno_s").target).combobox('setValue','');//配方版本(BOM版本)
		   			}
			  		  $(getEditor(index, "materialname_s").target).textbox('setValue',data[0].MATERIALDESC_S);//物料名称
					  $(getEditor(index, "materialcode_s").target).combobox('setValue',data[0].MATERIALCODE_S);//物料规格
			  		  $(getEditor(index, "materialgroup_s").target).textbox('setValue',data[0].DICTCODE_S);//物料组编码
			  		  $(getEditor(index, "materialdesc_s").target).textbox('setValue',data[0].DICTNAME_S);//物料组名称
			  		  $(getEditor(index, "sapversion_s").target).textbox('setValue',data[0].PRODUCTION_VER_S);//生产版本
			  		  $(getEditor(index, "overpercent_f").target).textbox('setValue',data[0].SORTNO_I);//物料超产百分比
				  	  $(getEditor(index, "productstage_s").target).combobox('setValue','');//产品阶段
				  	  $(getEditor(index, "paraversion_s").target).combobox('setValue','');//工艺版本
				  	  $(getEditor(index, "parameterid_s").target).combobox('setValue','');//工艺版本ID
				  	  $(getEditor(index, "repiceno_s").target).combobox('setValue','');//配方版本(BOM版本)
		   		}
 		  });
	}
	/**
	 * 选择物料编码后,清除数据并设置新的物料编码相关信息
	 * 2019年08-21
	 * 兰颖慧
	 */
	function onSetMatDescSpecGroup(record){
		  var index = $(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
		    $.ajax({
		   		url:'halfpart/productionplan/dailyplan/getMatInfoByMatCode?materialCode='+record.MATERIALCODE_S,
		   		type:'get',
		   		dataType:'json',
		   		async:false,
		   		success:function(data){
		   			if(data.length==0){
		   				alert("物料规格:"+record.MATERIALCODE_S+"对应的物料的生产版本不存在");
				  		  $(getEditor(index, "materialname_s").target).textbox('clear');//物料名称
						  $(getEditor(index, "specification_s").target).combobox('clear');//物料规格
				  		  $(getEditor(index, "materialgroup_s").target).textbox('clear');//物料组编码
				  		  $(getEditor(index, "materialdesc_s").target).textbox('clear');//物料组名称
				  		  $(getEditor(index, "sapversion_s").target).textbox('clear');//生产版本
				  		  $(getEditor(index, "overpercent_f").target).textbox('clear');//物料超产百分比
					      $(getEditor(index, "productstage_s").target).combobox('setValue','');//产品阶段
					  	  $(getEditor(index, "paraversion_s").target).combobox('setValue','');//工艺版本
					  	  $(getEditor(index, "parameterid_s").target).combobox('setValue','');//工艺版本ID
					  	  $(getEditor(index, "repiceno_s").target).combobox('setValue','');//配方版本(BOM版本)
		   			}
			  		$(getEditor(index, "materialname_s").target).textbox('setValue',data[0].MATERIALDESC_S);//物料名称
					$(getEditor(index, "specification_s").target).combobox('setValue',data[0].OLDMATCODE_S);//物料规格
			  		$(getEditor(index, "materialgroup_s").target).textbox('setValue',data[0].DICTCODE_S);//物料组编码
			  	    $(getEditor(index, "materialdesc_s").target).textbox('setValue',data[0].DICTNAME_S);//物料组名称
			  		$(getEditor(index, "sapversion_s").target).textbox('setValue',data[0].PRODUCTION_VER_S);//生产版本
			  		$(getEditor(index, "overpercent_f").target).textbox('setValue',data[0].SORTNO_I);//物料超产百分比
			  		$(getEditor(index, "productstage_s").target).combobox('setValue','');//产品阶段
			  		$(getEditor(index, "paraversion_s").target).combobox('setValue','');//工艺版本
			  		$(getEditor(index, "parameterid_s").target).combobox('setValue','');//工艺版本ID
			  		$(getEditor(index, "repiceno_s").target).combobox('setValue','');//配方版本(BOM版本)
		   		}
     		  });
	}
    /**
     * 日计划一键复制
     *
     */
    function oneClickCopy(){
	 var fromPlanDate = $("#plandate_s").datebox("getValue");
	 var toPlanDate  = $("#plandate_to_s").datebox("getValue");
   	 var url='halfpart/productionplan/dailyplan/oneClickCopy?fromPlanDate='+fromPlanDate+"&toPlanDate="+toPlanDate;
	 var choose=confirm("是否一键复制日期："+fromPlanDate+"的计划到"+"日期"+toPlanDate+"？");
	 if(choose==true){
	     ext.ajax.get(url, function(data) {
	         if (!(data.message=="ok")) {
	             ext.tip.error("<spring:message code="tip.error" />");
	             return;
	         }
	         ext.tip.suc("<spring:message code="tip.success" />");
	         reLoadCopyPlan();
	     });
	 }else{
		 ext.tip.warn("<spring:message code="tip.updatefromdateandtodate" />");
	 }
   	/*  $.ajax({
   		 url:url,
   		 type:'get',
   		 dataType:'json',
   		 async:false,
   		 success:function(data){
  	         if (!(data.message=="ok")) {
  	             ext.tip.error("<spring:message code="tip.error" />");
  	             return;
  	         }
  	         ext.tip.suc("<spring:message code="tip.success" />");
  	         reLoadCopyPlan();
   		 }
   	 }); */
    };
    
    /**
     * 日计划一键审核
     *
     */
    function oneClickAudit(){
	 var fromPlanDate = $("#plandate_s").datebox("getValue");
	 var url='halfpart/productionplan/dailyplan/oneClickAudit?planDate='+fromPlanDate;
	 var choose=confirm("是否一键审核"+fromPlanDate+"的所有未审核计划？");
	 if(choose==true){
	     ext.ajax.get(url, function(data) {
	         if (!(data.message=="ok")) {
	             ext.tip.error("<spring:message code="tip.error" />");
	             return;
	         }
	         ext.tip.suc("<spring:message code="tip.success" />");
	         reLoadCopyPlan();
	     }); 
	 }else{
		 ext.tip.warn("<spring:message code="tip.updatenewdate" />");
	 }
    };
    
    /**
     * 日计划一键撤销审核
     *
     */
    function oneClickCancelAudit(){
	 var fromPlanDate = $("#plandate_s").datebox("getValue");
	 var url='halfpart/productionplan/dailyplan/oneClickCancelAudit?planDate='+fromPlanDate;
	 var choose=confirm("是否一键撤销审核"+fromPlanDate+"的所有已审核计划？");
	 if(choose==true){
	     ext.ajax.get(url, function(data) {
	         if (!(data.message=="ok")) {
	             ext.tip.error("<spring:message code="tip.error" />");
	             return;
	         }
	         ext.tip.suc("<spring:message code="tip.success" />");
	         reLoadCopyPlan();
	     }); 
	 }else{
		 ext.tip.warn("<spring:message code="tip.updatenewdate" />");
	 }
    };
</script>