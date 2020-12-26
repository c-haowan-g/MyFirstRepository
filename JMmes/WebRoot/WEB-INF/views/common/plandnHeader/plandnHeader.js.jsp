<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	/**
	 *数据字典传值
	 *
	 */
	function codeFormatter(v, r, i) {
	
		return dictFormat(v);
	}
    
    function showOrHide(){
        if($("#PlandhHeeader_search_form").is(":hidden")){
            $("#PlandhHeeader_search_form").show();
        }else{
            $("#PlandhHeeader_search_form").hide();
        }
    }
    
    /**
     * 查询方法(销售出库)
     */
    var filter=function(){
    	var opts = $("#plandhheeader_dg").datagrid("options");
    	opts.url = 'sap/InvoiceEnquiry/searchBy';
        ext.easyui.grid.search("plandhheeader_dg","PlandhHeeader_search_form");
    };
    var filterTwo=function(){
    	var opts = $("#plandhheeader_dgTwo").datagrid("options");
		opts.url = 'sap/InvoiceEnquiry/Item/ActualDNItem/searchBy';
        ext.easyui.grid.search("plandhheeader_dgTwo","PlandhHeeader_search_formTwo");
    };
    var filterThree=function(){
    	var opts = $("#plandhheeader_dgThree").datagrid("options");
		opts.url = 'sap/InvoiceEnquiry/searchdetial';
		ext.easyui.grid.search("plandhheeader_dgThree","PlandhHeeader_search_formThree");
    };
    
    /**
     * 查询方法(调拨出库)
     *
     */
    var filterFour=function(){
    	var opts = $("#inAllocatingOutbound_dg").datagrid("options");
		opts.url = 'sap/inallocatingoutbound/searchBy';
        ext.easyui.grid.search("inAllocatingOutbound_dg","InAllocatingOutbound_search_form");
    };
    var filterFive=function(){
    	var opts = $("#inAllocatingOutbound_dgTwo").datagrid("options");
		opts.url = 'sap/InvoiceEnquiry/Item/ActualDNItem/searchBy';
        ext.easyui.grid.search("inAllocatingOutbound_dgTwo","InAllocatingOutbound_search_formTwo");
    };
    var filterSix=function(){
    	var opts = $("#inAllocatingOutbound_dgThree").datagrid("options");
		opts.url = 'sap/inallocatingoutbound/searchdetial';
        ext.easyui.grid.search("inAllocatingOutbound_dgThree","InAllocatingOutbound_search_formThree");
    };
    
    function cancel() {
        $("#plandhheeader_dg").datagrid("rejectChanges");
    }

    $(function(){
    	var day=new Calendar().format("yyyy-MM-dd");
		$('#start_time').textbox("setValue",day);
		$('#end_time').textbox("setValue",day);
		
		$('#start_timeTwo').textbox("setValue",day);
		$('#end_timeTwo').textbox("setValue",day);
		filter();
		filterFour();
	     $("#plandhheeader_dg").datagrid({
	   		    //单击事件   
				onClickRow:function(rowIndex,rowData){
					$("#PlandhHeeaderLineitem").window("open");
					 var danhao=rowData.snno_s;
					 $("#snno_s1").textbox("setValue",danhao);
					 var opts = $("#plandhheeader_dgThree").datagrid("options");
					 opts.url = 'sap/InvoiceEnquiry/searchdetial';
					 ext.easyui.grid.search("plandhheeader_dgThree","PlandhHeeader_search_formThree");
				 } 
	   	 }); 
	     $("#inAllocatingOutbound_dg").datagrid({
	   		    //单击事件   
				onClickRow:function(rowIndex,rowData){
					$("#InAllocatingOutLineitem").window("open");
					 var danhao=rowData.reserno_s;
					 $("#reserno_s2").textbox("setValue",danhao);
					 var opts = $("#inAllocatingOutbound_dgThree").datagrid("options");
					 opts.url = 'sap/inallocatingoutbound/searchdetial';
					 ext.easyui.grid.search("inAllocatingOutbound_dgThree","InAllocatingOutbound_search_formThree");
				 } 
	   	 }); 
			
    });
  //点击弹出生产明细页面 (销售出库)
  function productionDetail(){
	  var rows = $("#plandhheeader_dg").datagrid("getSelections");
	  if (rows != "" && rows != null) {
	    	   var opts = $("#plandhheeader_dgTwo").datagrid("options");
			   opts.url = 'sap/InvoiceEnquiry/Item/ActualDNItem/searchBy';
	    	   var snno_s=rows[0].snno_s;
			   $("#productionDetail").window("open");
			   $("#snno_sTwo").textbox("setValue",snno_s);
			   $("#materialcode_sTwo").textbox("setValue",'');
			   $("#barcode_s").textbox("setValue",'');
			   ext.easyui.grid.search("plandhheeader_dgTwo","PlandhHeeader_search_formTwo");
	  }else{
      	ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
      }      	
  }  
  /*
  *点击查询随车单详情(销售出库)
  */
  function TheAccessory1(){
	 var rows = $("#plandhheeader_dg").datagrid("getSelections");
	  if (rows != "" && rows != null) {
		   //第一块区域
		  	 var date = new Date();
	         var seperator1 = "-";
	         var year = date.getFullYear();
	         var month = date.getMonth() + 1;
	         var strDate = date.getDate();
	         if (month >= 1 && month <= 9) {
	            month = "0" + month;
	         }
	         if (strDate >= 0 && strDate <= 9) {
	            strDate = "0" + strDate;
	         }
	         var currentdate = year + seperator1 + month + seperator1 + strDate;
			 $("#inputTest").text("制单日期:"+currentdate);
		 //第二块区域
			 
	    	   $("#divcss4").text("订单单号:"+rows[0].snno_s);
	    	   $("#divcss5").text("客户:"+rows[0].customename_s);  
	    	   $("#theAccessorySnno_s").textbox("setValue",rows[0].snno_s);
	    	   
	    	  document.getElementById('TheAccessoryThree').innerHTML = "";
	    	  document.getElementById("TheAccessoryThree").style.height= "900px";
	    	  document.getElementById("TheAccessoryThree").style.width= "1000px";
	    	  document.getElementById('TheAccessoryThree').insertAdjacentHTML("beforeEnd","<table id='TheAccessoryTreeID' class='easyui-treegrid' ></table>");
	    	    var snno_s = $("#theAccessorySnno_s").textbox("getValue");
				$('#TheAccessoryTreeID').treegrid({
	    		    url:'sap/InvoiceEnquiry/searchTheAccessoryBySonn?snno_s='+snno_s,
	    		    fitColumns:false,
	                pagination:false,
	                animate:true,
	                fit:true,
	                method: 'get',
	                rownumbers: true,
					idField: 'id',
					treeField: 'materialdesc_s',
	    		    columns:[[
	    				{title:'id',field:'id',width:100,checkbox:true},
	    				{field:'materialdesc_s',title:"<spring:message code="wmsoutstore.column.specification_s" />",width:700,type:'textbox'},
	    				{field:'barcodeSize',title:"<spring:message code="dynabalancecheresultprint.column.total" />",width:120,align:'center',type:'textbox',halign:'center'}
	    		    ]]
	    		});
			  $("#TheAccessory").window("open");
	   }else{
      	ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
      }       	
  }  
  /*
  *点击查询随车单详情(调拨出库)
  */
  function TheAccessory2(){
	  var rows = $("#inAllocatingOutbound_dg").datagrid("getSelections");
	  if (rows != "" && rows != null) {
		  //第一块区域
		  	 var date = new Date();
	         var seperator1 = "-";
	         var year = date.getFullYear();
	         var month = date.getMonth() + 1;
	         var strDate = date.getDate();
	         if (month >= 1 && month <= 9) {
	            month = "0" + month;
	         }
	         if (strDate >= 0 && strDate <= 9) {
	            strDate = "0" + strDate;
	         }
	         var currentdate = year + seperator1 + month + seperator1 + strDate;
			 $("#inputTest").text("制单日期:"+currentdate);
		 //第二块区域
			 
	    	   $("#divcss4").text("订单单号:"+rows[0].reserno_s);
	    	   $("#divcss5").text("客户:"+rows[0].customename_s);  
	    	   $("#theAccessorySnno_s").textbox("setValue",rows[0].reserno_s);
	    	   
	    	  document.getElementById('TheAccessoryThree').innerHTML = "";
	    	  document.getElementById("TheAccessoryThree").style.height= "900px";
	    	  document.getElementById("TheAccessoryThree").style.width= "1000px";
	    	  document.getElementById('TheAccessoryThree').insertAdjacentHTML("beforeEnd","<table id='TheAccessoryTreeID' class='easyui-treegrid' ></table>");
	    	    var snno_s = $("#theAccessorySnno_s").textbox("getValue");
				$('#TheAccessoryTreeID').treegrid({
	    		    url:'sap/InvoiceEnquiry/searchTheAccessoryBySonn?snno_s='+snno_s,
	    		    fitColumns:false,
	                pagination:false,
	                animate:true,
	                fit:true,
	                method: 'get',
	                rownumbers: true,
					idField: 'id',
					treeField: 'materialdesc_s',
	    		    columns:[[
	    				{title:'id',field:'id',width:100,checkbox:true},
	    				{field:'materialdesc_s',title:"<spring:message code="wmsoutstore.column.specification_s" />",width:700,type:'textbox'},
	    				{field:'barcodeSize',title:"<spring:message code="dynabalancecheresultprint.column.total" />",width:120,align:'center',type:'textbox',halign:'center'}
	    		    ]]
	    		});
				
			  $("#TheAccessory").window("open");
	  }else{
      	ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
      }      	
  }  
  //点击弹出生产明细页面 (调拨出库) 
  function productionDetail2(){
	  var rows = $("#inAllocatingOutbound_dg").datagrid("getSelections");
	  if (rows != "" && rows != null) {
	    	   var opts = $("#inAllocatingOutbound_dgTwo").datagrid("options");
			   opts.url = 'sap/InvoiceEnquiry/Item/ActualDNItem/searchBy';
	    	   var snno_s=rows[0].reserno_s;
			   $("#productionDetail2").window("open");
			   $("#snno_sThree").textbox("setValue",snno_s);
			   $("#materialcode_sThree").textbox("setValue",'');
			   $("#barcode_sThree").textbox("setValue",'');
			   ext.easyui.grid.search("inAllocatingOutbound_dgTwo","InAllocatingOutbound_search_formTwo");
	  }else{
      	ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
      }      	
  }  
    //追加合计(销售出库)
  function  onLoadSuccessTwo(){
	 var rows= $("#plandhheeader_dgTwo").datagrid("getRows");
	 var length=rows.length;
	 if(length!=0){
		//添加“合计”列
			$("#plandhheeader_dgTwo").datagrid('appendRow', {
				  snno_s: '<spring:message code="Total.number.of" />',
	              barcode_s:length+"条",
	              materialcode_s:"",
	              materialdesc_s:"",
	              dynamicbalancepasstime_t:"",
	              gradecode_s:"" 
		        });    
	 }
  }
  //追加合计(调拨出库)
  function  onLoadSuccessThree(){
	 var rows= $("#inAllocatingOutbound_dgTwo").datagrid("getRows");
	 var length=rows.length;
	 if(length!=0){
		//添加“合计”列
			$("#inAllocatingOutbound_dgTwo").datagrid('appendRow', {
				  snno_s: '<spring:message code="Total.number.of" />',
	              barcode_s:length+"条",
	              materialcode_s:"",
	              materialdesc_s:"",
	              dynamicbalancepasstime_t:"",
	              gradecode_s:"" 
		        });    
	 }
  }    
//根据条件设置表格行背景颜色
  function setRowBgColor(index, row) {
      if (row.materialcode_s == "") {
          return 'background-color:yellow;color:black;font-weight: bold;';
      }
  }
  
  //导出(销售出库)
  function exportExcel(){
	    var node = $('#plandhheeader_dg').datagrid("getSelected");
 		if(node==null){
 			return ext.tip.error("<spring:message code="tip.selectJudgeNum" />");
 		}else{
 			var snno_s = node.snno_s;
 			var url = path+"/sap/InvoiceEnquiry/exprot?snno_s="+snno_s;
 			window.location.href=url;
 		}
  
  }
  
  //导出(调拨出库)
  function exportExcel2(){
	    var node = $('#inAllocatingOutbound_dg').datagrid("getSelected");
 		if(node==null){
 			return ext.tip.error("<spring:message code="tip.selectJudgeNum" />");
 		}else{
 			var reserno_s = node.reserno_s;
 			var url = path+"/sap/inallocatingoutbound/exprot?snno_s="+reserno_s;
 			window.location.href=url;
 		}
  }
  
  //上传
 function sapExport(){
	var url="sap/InvoiceEnquiry/addActualAmount";
	var list_map = new Array();
	var sonn_s= $("#snno_sTwo").textbox("getValue");
	if(sonn_s==""){
		return  ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
	}
  	list_map.push({sonn_s:sonn_s});
  	ext.ajax.sendJson(url,list_map, function(data) {
  		 $("#snno_sTwo").textbox("setValue","");
		 $("#materialcode_sTwo").textbox("setValue","");
  		if (data.code!=OK) {
             ext.tip.error("<spring:message code="tip.error" />");
            return;
        }
        $("#plandhheeader_dg").datagrid("reload");
        ext.tip.suc("<spring:message code="tip.success" />");
       
    });
  }
  
 function remove() {

     var rows = $("#plandhheeader_dgTwo").datagrid("getSelections");
     if (rows == "" || rows == null) {
    	 ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
     }
     var index = -1;
     for (var i = 0; i < rows.length; i++) {
         index = $("#plandhheeader_dgTwo").datagrid("getRowIndex", rows[i]);
         $("#plandhheeader_dgTwo").datagrid("deleteRow", index);
     }

 }
 
 var saveChanges=path+"sap/InvoiceEnquiry/Item/ActualDNItem/saveChanges";
 function save() {
     var dg = $("#plandhheeader_dgTwo");

     var rows = dg.datagrid("getRows");
     var valid = false;
     for (var i = 0; i < rows.length; i++) {
         if (!dg.datagrid("validateRow", i)) {
             ext.tip.error("<spring:message code="tip.invalid" />");
             return;
         }
     }

     var deleted = dg.datagrid("getChanges", "deleted");

	 	if(deleted.length ==0){
			$("#plandhheeader_dgTwo").datagrid("reload");
	        ext.tip.error("<spring:message code="tip.nosave" />");
		}else{
			var list_map = new Array();
			for(var i=0;i<deleted.length;i++){
				delete deleted[i]["dynamicbalancepasstime_t"];
				delete deleted[i]["materialdesc_s"];
				delete deleted[i]["gradecode_s"];
				delete deleted[i]["createdby_s"];
				delete deleted[i]["creation_time_date"];
				
			}
		if(list_map.length !=0){
			ext.tip.error("<spring:message code="tip.codingError" />");
		}else{
			ext.ajax.sendJson(saveChanges, {
				deleted : deleted
			}, function(data) {
				if (data.message != "ok") {
	      			$("#plandhheeader_dgTwo").datagrid("reload");
                    ext.tip.error("<spring:message code="tip.error" />");
	            }else{
	          	  $("#plandhheeader_dgTwo").datagrid("reload");
	                ext.tip.suc("<spring:message code="tip.success" />");
	            }
			});
	  	}
	}
	filter();
	filterThree();
 }
 
 function cancel() {
     $("#plandhheeader_dgTwo").datagrid("rejectChanges");
 }
 
 function remove1() {

     var rows = $("#inAllocatingOutbound_dgTwo").datagrid("getSelections");
     if (rows == "" || rows == null) {
    	 ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
     }
     var index = -1;
     for (var i = 0; i < rows.length; i++) {
         index = $("#inAllocatingOutbound_dgTwo").datagrid("getRowIndex", rows[i]);
         $("#inAllocatingOutbound_dgTwo").datagrid("deleteRow", index);
     }

 }
 
 var saveChanges=path+"sap/InvoiceEnquiry/Item/ActualDNItem/saveChanges";
 function save1() {
     var dg = $("#inAllocatingOutbound_dgTwo");

     var rows = dg.datagrid("getRows");
     var valid = false;
     for (var i = 0; i < rows.length; i++) {
         if (!dg.datagrid("validateRow", i)) {
             ext.tip.error("<spring:message code="tip.invalid" />");
             return;
         }
     }

     var deleted = dg.datagrid("getChanges", "deleted");

	 	if(deleted.length ==0){
			$("#inAllocatingOutbound_dgTwo").datagrid("reload");
	        ext.tip.error("<spring:message code="tip.nosave" />");
		}else{
			var list_map = new Array();
			for(var i=0;i<deleted.length;i++){
				delete deleted[i]["dynamicbalancepasstime_t"];
				delete deleted[i]["materialdesc_s"];
				delete deleted[i]["gradecode_s"];
				delete deleted[i]["createdby_s"];
				delete deleted[i]["creation_time_date"];
			}
		if(list_map.length !=0){
			ext.tip.error("<spring:message code="tip.codingError" />");
		}else{
			ext.ajax.sendJson(saveChanges, {
				deleted : deleted
			}, function(data) {
				if (data.message != "ok") {
	      			$("#inAllocatingOutbound_dgTwo").datagrid("reload");
                    ext.tip.error("<spring:message code="tip.error" />");
	            }else{
	          	  $("#inAllocatingOutbound_dgTwo").datagrid("reload");
	                ext.tip.suc("<spring:message code="tip.success" />");
	            }
			});
	  	}
	}
	filterFour();
	filterSix();
 }
 
 function cancel1() {
     $("#inAllocatingOutbound_dgTwo").datagrid("rejectChanges");
 }
 
 
 
 function TheAccessoryExportExcel(){
	    var node = $('#plandhheeader_dg').datagrid("getSelected");
	    var nodeTwo = $('#inAllocatingOutbound_dg').datagrid("getSelected");
		if(node==null && nodeTwo==null){
			return ext.tip.error("<spring:message code="tip.selectJudgeNum" />");
		}else if(node!=null){
			var snno_s = node.snno_s;
			var customename_s = node.customename_s;
			var url = path+"/sap/InvoiceEnquiry/theAccessoryExportExcel?snno_s="+snno_s+"&customename_s="+customename_s;
			window.location.href=url;
		}else if(nodeTwo!=null){
			var snno_s = nodeTwo.reserno_s;
			var url = path+"/sap/InvoiceEnquiry/theAccessoryExportExcel?snno_s="+snno_s+"&customename_s="+customename_s;
			window.location.href=url;
		}
 }
 /**
 *	销售发货数量
 */
 function plandnitemColumnQty(){
	    var day=new Calendar().format("yyyy-MM-dd");
		$('#start_time_Qty').textbox("setValue",day);
		$('#end_time_Qty').textbox("setValue",day);
		$('#plandnitemColumnQty').window("open");
		var opts = $("#plandnitemColumnQty_dg").datagrid("options");
		opts.url = 'sap/InvoiceEnquiry/plandnitemColumnQty';
		ext.easyui.grid.search("plandnitemColumnQty_dg","plandnitemColumnQty_search_form");
 }
 function plandnitemColumnQtyFilter(){
	    var opts = $("#plandnitemColumnQty_dg").datagrid("options");
		opts.url = 'sap/InvoiceEnquiry/plandnitemColumnQty';
		ext.easyui.grid.search("plandnitemColumnQty_dg","plandnitemColumnQty_search_form");
 }
 /**
 *	调拨发货数量
 */
 function inAllocatingColumnQty(){
	    var day=new Calendar().format("yyyy-MM-dd");
		$('#start_time_Qty1').textbox("setValue",day);
		$('#end_time_Qty1').textbox("setValue",day);
		$('#inAllocatingColumnQty').window("open");
		var opts = $("#inAllocatingColumnQty_dg").datagrid("options");
		opts.url = 'sap/InvoiceEnquiry/inAllocatingColumnQty';
		ext.easyui.grid.search("inAllocatingColumnQty_dg","inAllocatingColumnQty_search_form");
		
 }
 function inAllocatingColumnQtyFilter(){
	    var opts = $("#inAllocatingColumnQty_dg").datagrid("options");
		opts.url = 'sap/InvoiceEnquiry/inAllocatingColumnQty';
		ext.easyui.grid.search("inAllocatingColumnQty_dg","inAllocatingColumnQty_search_form");
}
</script>