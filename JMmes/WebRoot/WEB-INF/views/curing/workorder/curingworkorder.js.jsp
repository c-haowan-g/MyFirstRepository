<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"workorder/saveChanges";
    
    function showOrHide(){
        if($("#workorder_search_form").is(":hidden")){
            $("#workorder_search_form").show();
        }else{
            $("#workorder_search_form").hide();
        }
    }
    var lhjtxx=[];//机台信息
    var cxjtxx=[];
    //加载硫化产线信息
    $.ajax({
    	url:'curing/baseData/curingProductionLineInfo/comboxProductlineEqu',
    	type:'get',
    	dataType:'json',
    	async:false,
    	success:function(data){
    		console.log(data);
    		lhjtxx=data;
    	}
    });
  //加载成型产线信息
    $.ajax({
        url : 'building/basedata/productline/getProductlineByProcess?process='+'252005',
        type : 'get',
        dataType : 'json',
        async:false,
        success : function(data) {
        	for(var i=0;i<data.length;i++){
        		cxjtxx.push({value:data[i].p_line_name,text:data[i].p_line_name});
        	}
        }
    });
  /**
  	月份格式处理
  */
    function formatter2(date){
		return date==null?"":new Calendar(date).format('yyyy-MM');
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
    /**
	 * 基础数据text显示
	 */
	function codeFormatter(v, r, i) {
	  if(v==null){
		  return "";
	  }
		return dictFormat(v);
	}
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
    }
   
    
    function searchProductionLine(q, row){
    	var opts = $(this).combobox('options');
        return row[opts.textField].toUpperCase().indexOf(q.toUpperCase()) >= 0;
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
    //工单状态
    function showStatus(v){
    	if(v=='Created'){
    		return '创建';
    	}else if(v=='Started'){
    		return '已执行';
    	}else if(v=='Completed'){
    		return '已完成';
    	}else if(v=='Finished'){
    		return '生产结束';
    	}else if(v=='Shipped'){
    		return '发货';
    	}else if(v=='Closed'){
    		return '订单关闭';
    	}else if(v=='Received'){
    		return '生产恢复';
    	}
    }
   
    /**
     * 查询方法
     */
    var filter=function(){
		var opts = $("#workorder_dg").datagrid("options");
		opts.url = "workorder/datagridUDA";
		 ext.easyui.grid.search("workorder_dg","workorder_search_form");
	}

    function add() {
        //ext.easyui.grid.appendAndEdit("workorder_dg",{});
       var rows = $("#workorder_dg").datagrid("getSelected");
    	 $.ajax({
		 		url:"workorder/updateItemQua?order="+rows.order_number+"&orderItem="+rows.order_item,
		 		type:"get",
		 		dataType:"json",
		 		async:false,
		 		success:function(data){
		 			$("#workorder_dg").datagrid("reload");
		 		} });  
    }
    //详情查询工单对应的日计划
    function particulars(){
    	
    	 var rows=$("#workorder_dg").datagrid("getSelected");
    	 if(rows==""|| rows==null){
    		 ext.tip.error("请选择一条数据");
    	 }else{
    		 $.ajax({
 		 		url:"workorder/particulars?monthPlan="+rows.order_number,
 		 		type:"get",
 		 		dataType:"json",
 		 		async:false,
 		 		success:function(data){
 		 			console.log(data)
 		 			$("#buildingDayPlan_dg").datagrid("loadData",data);
 		 		} });  
    		 buildingfilter();
    		 curingfilter();
    		 $("#particulars").window("open"); 
    	 }
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
	//成型日计划
    var buildingfilter=function(){
    	var rows=$("#workorder_dg").datagrid("getSelected");
    	$("#order_number_s").next().hide();//隐藏textbox
	 	$("#order_number_s").textbox("setValue",rows.order_item);
    	$("#cxproductiondayplan_dg").datagrid("options").url="building/productionPlan/productiondayplan/datagrid";
        ext.easyui.grid.search("cxproductiondayplan_dg","CxProductionDayPlan_search_form");
    }
   
  //硫化日计划
	 var curingfilter=function(){
		 var rows=$("#workorder_dg").datagrid("getSelected");
		 	$("#left_order_number_s").next().hide();//隐藏textbox
		 	$("#left_order_number_s").textbox("setValue",rows.order_item);
		 	$("#productiondayplan_dg").datagrid("options").url="curing/productionPlan/dailyPlan/datagrid";
	        ext.easyui.grid.search("productiondayplan_dg","ProductionDayPlan_search_form");
	    }
</script>