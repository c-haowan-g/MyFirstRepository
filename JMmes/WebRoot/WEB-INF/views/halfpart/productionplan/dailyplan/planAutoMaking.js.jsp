<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
    function showOrHide(){
        if($("#ProductPlan_search_form").is(":hidden")){
            $("#ProductPlan_search_form").show();
        }else{
            $("#ProductPlan_search_form").hide();
        }
    }
    var saveChanges=path+"halfpart/productionplan/automaking/saveChanges";
    function getDg(){
     	return $("#productplan_dg");  //$("#a_dg"):获取并返回选中的标签页
    }
    function getSortDg(){
     	return $("#productplanresort_dg");  //$("#a_dg"):获取并返回选中的标签页
    }
    /**
     * 班次显示转化
     * 兰颖慧
     * 2019-08-01
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
   /**
    * 计划状态显示转化
    * 兰颖慧
    * 2019-08-01
    */
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
    /**
     * 物料组显示转化
     * 兰颖慧
     * 2019-08-01
     */
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
     function materialGroupFormatter(v, r, i){
          for(var i=0;i<materialGroupList.length;i++){
             if (v == materialGroupList[i].DICTCODE_S) {
                 return materialGroupList[i].DICTNAME_S;
             }
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
   /*  $.ajax({
        url:'halfpart/productionplan/automaking/planAutoMaking?halfPartDate='+"20190730"+'&buildingDate='+"20190721"+'&model='+"class",
        type:"get",
        dataType:"json",
        async:false,
        success:function(data){
        	$.messager.alert({
     		    width: 700,
     		    height: 350,
     		    title: '未排产信息',
     		    msg: data
     		    }
     		);
        }
        }); */
   function planAutoMakingByDate(){
      var choose=confirm("计划倒推会删除指定半部件计划日期的所有计划并根据成型计划的胎胚信息生成新的半部件计划,是否执行倒推？");
      debugger
	   	  if(choose==true){
	       var  currentDate=new Calendar().format("yyyyMMdd");
	       var  buildingDate=$('#buildingDate').datebox('getValue');
	       var  halfpartDate=$('#halfpartDate').datebox('getValue');
	       //1.判断半部件计划日期是否在明天及以后
	       if(halfpartDate<currentDate){
	    	   ext.tip.warn("只能倒推明天及以后的半部件计划，请重新选择半部件计划日期");
	    	   return;
	       }
	   	   $('#planautomakingbydate').linkbutton('disable');
		   $('#planautomakingbyclass').linkbutton('disable');
		   $('#searchId').linkbutton('disable');
	       $("#loading").attr("style","display:block;background:#00FFFF;text-align:center;height:10%;text-align:center;line-height:50px;font-size:30px");//显示div
	       $.ajax({
	        url:'halfpart/productionplan/automaking/planAutoMaking?halfPartDate='+halfpartDate+'&buildingDate='+buildingDate+'&model='+"date",
	        type:"get",
	        dataType:"json",
	        async:true,
	        success:function(data){
	        	debugger
	        	           //$('#productplan_dg').datagrid('loadData',data);
				           $.messager.alert({
				       		    width: 700,
				       		    height: 350,
				       		    title: '未排产信息',
				       		    msg: data,
				       		    onClosed:filter()
				       		    }
				       		);
				           $("#loading").attr("style","display:none;");//显示div
				           $('#planautomakingbydate').linkbutton('enable');
				           $('#planautomakingbyclass').linkbutton('enable');
				           $('#searchId').linkbutton('enable');
	       }
	       }); 
   	  }else{
   		  return;
   	  }
   }
   function planAutoMakingByClass(){
	  var choose=confirm("计划倒推会删除指定半部件计划日期的所有计划并根据成型计划的胎胚信息生成新的半部件计划,是否执行倒推？");
	  if(choose==true){
	       var  currentDate=new Calendar().format("yyyyMMdd");
	       var  halfpartDate=$('#halfpartDate').datebox('getValue');
	       var  buildingDate=$('#buildingDate').datebox('getValue');
	       //1.判断半部件计划日期是否在明天及以后
	       if(halfpartDate<currentDate){
	    	   ext.tip.warn("只能倒推明天及以后的半部件计划，请重新选择半部件计划日期");
	    	   return;
	       }
		   $('#planautomakingbydate').linkbutton('disable');
		   $('#planautomakingbyclass').linkbutton('disable');
		   $('#searchId').linkbutton('disable');
	       $("#loading").attr("style","display:block;background:#00FFFF;text-align:center;height:10%;text-align:center;line-height:50px;font-size:30px");//显示div
	       $.ajax({
	           url:'halfpart/productionplan/automaking/planAutoMaking?halfPartDate='+halfpartDate+'&buildingDate='+buildingDate+'&model='+"class",
	           type:"get",
	           dataType:"json",
	           async:true,
	           success:function(data){
	   			           $.messager.alert({
	   			       		    width: 700,
	   			       		    height: 350,
	   			       		    title: '未排产信息',
	   			       		    msg: data,
	   			       		    }
	   			       		);
	   			           $("#loading").attr("style","display:none;");//显示div
	   			           $('#planautomakingbydate').linkbutton('enable');
	   			           $('#planautomakingbyclass').linkbutton('enable');
	   			           $('#searchId').linkbutton('enable');
	          }
	          }); 
	  }else{
		  return;
	  }
   }
   /**
    * 主界面加载触发（按时间加载当天数据）
    * 2019-05-20
    * 兰颖慧
    */
	function onDgBeforeLoad(param) {
		if ($("#halfpartDate").datebox("getValue") == "") {
			return false;
		}
		param["filter[plandate_s]"] = $("#halfpartDate").datebox("getValue");
	}
   /**
    * 查询方法
    * 2019-08-01
    * 兰颖慧
    */
   function filter(){
       ext.easyui.grid.search("productplan_dg","ProductPlan_search_form");
   }
   var productLineList=[];
   $.ajax({
       url:"halfpart/basedata/productlinemanager/getHalfPartProductionLine",
       type:"get",
       dataType:"json",
       async:false,
       success:function(data){
       	productLineList=data;
       }
       });
   /**
    * 查询方法
    * 2019-08-01
    * 兰颖慧
    */
   var filter=function(){
       ext.easyui.grid.search("productplan_dg","ProductPlan_search_form");
   };
   /**
	 * 日期格式化
	 * 2019/08/01
	 * 兰颖慧
	 */
	function dateFormat(date) {
		return new Calendar(date).format("yyyyMMdd");
	}
    /**
	 * 解析指定格式日期
	 * 2019/08/01
	 * 兰颖慧
	 */
	function dateParser(s) {
		if (!s)
			return new Date();
		return new Date(s.substring(0, 4), parseInt(s.substring(4, 6)) - 1, s.substring(6, 8));
	}
    function centerSetting(value,row,index){
        return 'text-align: center;';
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
    function productStageFormatter(v, r, i){
        if        (v == '01') {
            return "试制";
        } else if (v == '02') {
            return "试产";
        } else if (v  =='03') {
        	return "投产";
        } else{
        	return v;
        }
    } 
    function codeFormatter(v, r, i) {
        if(v==null){
            return "";
        }
          return dictFormat(v);
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
	 * 日计划删除
	 * 2019-04-12
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
	 * 日计划编辑取消
	 * 2019-04-12
	 * 兰颖慧
	 */
    function cancel() {
        $("#productplan_dg").datagrid("rejectChanges");
    }
	/**
	 * 日计划保存
	 * 2019-04-12
	 * 兰颖慧
	 */
    function save() {
        var dg = $("#productplan_dg");

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

            if (data.message!="ok") {
                ext.tip.error("<spring:message code="tip.invalid" />");
            }else{
            	ext.tip.suc("<spring:message code="tip.success" />");
            	$("#productplan_dg").datagrid("reload");
            	//filter();
            }
        });
    }
    /**
     * 半部件日计划审核
     * half-part-daily plan audit
     * Yinghui.lan
     * 2019/04/25
     * 兰颖慧
     */
    function audit(){
    	var rows=getDg().datagrid("getChecked");//getChecked:返回复选框中选中的所有行
    	if(rows.length==0){
    		ext.tip.warn(tipSelectAtLeastOne);
    		return;
    	}
    	var ids=[]; //声明数组
    	for(var i=0;i<rows.length;i++){
    		if(rows[i].status_s!='104001'){
    			ext.tip.warn("请核对所选计划的状态，仅未审核状态允许审核");
    			return;
    		}
    		ids.push(rows[i].atr_key);
    	}
    	ext.ajax.post("halfpart/productionplan/dailyplan/audit",{ids:ids.toString()},
                      function(data){ //ext.ajax.post:用于客户端向服务端传输数据
    		                         if(data.code==OK){
    			                     ext.tip.suc();
    		                         filter();
    			                     return;
    		                        }
    		ext.tip.error(data.message);
    	});
    }
    /**
     * 半部件日计划取消 审核
     * half-part-daily plan cancel audit
     * 2019/04/22
     * 兰颖慧
     * 
     */
    function auditCancel(){
        var rows=getDg().datagrid("getSelections");
        if(rows.length==0){
            ext.tip.warn(tipSelectAtLeastOne);
            return;
        }
        var ids=[];
        for(var i=0;i<rows.length;i++){
    	    if(rows[i].status_s!='104002'){
    			ext.tip.warn("请核对所选计划的状态，仅已审核状态允许撤销审核");
    			return;
    		}
            ids.push(rows[i].atr_key);
        }
        ext.ajax.post("halfpart/productionplan/dailyplan/auditCancel",{ids:ids.toString()},function(data){
        if(data.code!=OK){
        	return;
        }
        ext.tip.suc();
        filter();
        });
    }
    function planClose(){
    	var rows=getDg().datagrid("getChecked");//getChecked:返回复选框中选中的所有行
    	if(rows.length==0){
    		ext.tip.warn(tipSelectAtLeastOne);
    		return;
    	}
    	var ids=[]; //声明数组
    	for(var i=0;i<rows.length;i++){
    		if(rows[i].status_s=='104006'){
    			continue;
    		}
    		ids.push(rows[i].atr_key);
    	}
    	if(ids.length>0){
        	ext.ajax.post("halfpart/productionplan/dailyplan/planClose",{ids:ids.toString()},
                    function(data){ //ext.ajax.post:用于客户端向服务端传输数据
  		                         if(data.code==OK){
  			                     ext.tip.suc();
  		                         filter();
  			                     return;
  		                        }
  		             ext.tip.error(data.message);
  	                 });
    	}
    }
    /**
     * 重排序弹出界面
     * 2019-05-21
     * 兰颖慧
     */
     function resetOrder(){
 		if ($("#halfpartDate").datebox("getValue") ==""||$("#halfpartDate").datebox("getValue") ==null) {
 			alert("请选择计划日期、班次和机台");
 		}
 		else if ($("#classcode_s").combobox("getValue") ==""||$("#classcode_s").combobox("getValue") ==null) {
 			alert("请选择计划日期、班次和机台");
 		}
 		else if ($("#equip_code_s").combobox("getValue") ==""||$("#equip_code_s").combobox("getValue") ==null) {
 			alert("请选择计划日期、班次和机台");
 		}
 		else{
 	    	$("#ProductPlanResort").dialog("open");	 
 		}
     }
    
    
    	//上移
     function MoveUp() {
    	    var row = $("#productplanresort_dg").datagrid('getSelected');
    	    var index = $("#productplanresort_dg").datagrid('getRowIndex', row);
    	    mysort(index, 'up', 'productplanresort_dg');
    	     
    	}
    
   		//下移
     function MoveDown() {
         var row = $("#productplanresort_dg").datagrid('getSelected');
         var index = $("#productplanresort_dg").datagrid('getRowIndex', row);
         mysort(index, 'down', 'productplanresort_dg');
          
     }
     function mysort(index, type, gridname) {
    	    if ("up" == type) {
    	        if (index != 0) {
    	            var toup = $('#' + gridname).datagrid('getData').rows[index];
    	            var todown = $('#' + gridname).datagrid('getData').rows[index - 1];
    	            var uporder = toup.plan_order_i;
    	            var downorder = todown.plan_order_i;
    	            toup.plan_order_i=downorder;
    	            todown.plan_order_i=uporder;
    	            $('#' + gridname).datagrid('getData').rows[index] = todown;
    	            $('#' + gridname).datagrid('getData').rows[index - 1] = toup;
    	            $('#' + gridname).datagrid('refreshRow', index);
    	            $('#' + gridname).datagrid('refreshRow', index - 1);
    	            $('#' + gridname).datagrid('selectRow', index - 1);
    	        }
    	    } else if ("down" == type) {
    	        var rows = $('#' + gridname).datagrid('getRows').length;
    	        if (index != rows - 1) {
    	            var todown = $('#' + gridname).datagrid('getData').rows[index];
    	            var toup = $('#' + gridname).datagrid('getData').rows[index + 1];
    	            $('#' + gridname).datagrid('getData').rows[index + 1] = todown;
    	            $('#' + gridname).datagrid('getData').rows[index] = toup;
    	            $('#' + gridname).datagrid('refreshRow', index);
    	            $('#' + gridname).datagrid('refreshRow', index + 1);
    	            $('#' + gridname).datagrid('selectRow', index + 1);
    	        }
    	    }
    	 
    	}
    
    /**
     * 重排序弹出界面前按照生产日期、班次和机台加载数据
     * 2019-05-21
     * 兰颖慧
     */
 	function resortDataLoad() {
 		var planDate=$("#halfpartDate").datebox("getValue");
 		var classCode=$("#classcode_s").combobox("getValue");
 		var equipCode=$("#equip_code_s").combobox("getValue");
 	    $("#productplanresort_dg").datagrid("options").url='halfpart/productionplan/dailyplan/getSortingData?planDate='+planDate+'&equipCode='+equipCode+'&classCode='+classCode; 
 	    ext.easyui.grid.search("productplanresort_dg","ProductPlanResort_search_form");
    }
	/**
	 * 日计划重排序后保存
	 * 2019-05-22
	 * 兰颖慧
	 */
    function sortDataSave() {
        var dg = $("#productplanresort_dg");
        var rows  = dg.datagrid("getRows");
        var valid = false;
        for (var i = 0; i < rows.length; i++) {
            if (!dg.datagrid("validateRow", i)) {
                ext.tip.error("<spring:message code="tip.invalid" />");
                return;
            }
        }
        var inserted = dg.datagrid("getChanges", "inserted");
        var updated = rows;
        var deleted = dg.datagrid("getChanges", "deleted");

        for (var i = 0; i < rows.length; i++) {
            dg.datagrid("endEdit", i);
        }
        ext.ajax.sendJson(saveChanges, {
            inserted : inserted,
            updated : updated,
            deleted : deleted
        }, function(data) {

            if (data.message!="ok") {
                ext.tip.error("<spring:message code="tip.invalid" />");
            }else{
            	ext.tip.suc("<spring:message code="tip.success" />");
            }
            resortDataLoad();
        });
    }
	/**
	 * 日计划重排序编辑取消
	 * 2019-04-12
	 * 兰颖慧
	 */
    function sortDataCancel() {
        $("#productplanresort_dg").datagrid("rejectChanges");
    }
</script>