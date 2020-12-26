<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	var ISOneRow = 0;//判断是否是 datagrid的一行被触发  1表示是一行被点击，0表示超链接被点击
	//var plan_no_s;
	$(function() {
		$("#plandayparameter_dg").datagrid({
			//单击事件
			onClickRow : function(index, row) {
				if (ISOneRow == 1) {
					ClikRow(row.plan_no_s,row.material_code_left_s,row.material_code_right_s);
				} else {
				// plan_no_s=row.plan_no_s;
					ISOneRow = 0;
					
				}
			}
		});

	});
	//超链接
 var parameter = function(value, row, index) {
       //plan_no_s=row.plan_no_s;
		return "<a href='javascript:void(0)' onclick='getParameter(&apos;"
				+ value  +"&apos;,&apos;"+row.plan_no_s+ "&apos;)'>" + value +"</a>";
	};
	//超链接
 var parameterr = function(value, row, index) {
       //plan_no_s=row.plan_no_s;
		return "<a href='javascript:void(0)' onclick='getParameterr(&apos;"
				+ value  +"&apos;,&apos;"+row.plan_no_s+ "&apos;)'>" + value +"</a>";
	};
	//点击行方法
	/* function ClikRow(value,l,r) {
		var plan_no_s = value;//获取当前点击行日计划号
		var material_code_left_s=r;//获取当前点击左轮胎编码
		var material_code_right_s=l;//获取当前点击右轮胎编码
		$("#production_dayplan_s").textbox("setValue", plan_no_s);
		$("#tyre_materialcode_s").textbox("setValue", "");
		$("#material_code_left_s").textbox("setValue", material_code_left_s);
	   // $("#material_code_right_s").textbox("setValue", material_code_right_s);
		
		
		//提交获取日计划号，查询对应参数
		$("#plancuringparameter_dg").datagrid("options").url = "curing/productionManagement/planCuringParameter/getParameter";
		ext.easyui.grid.search("plancuringparameter_dg",
				"plancuringparameter_form");
		$("#plancuringparameter_dg").datagrid("reload");
	} */

	//超链接点击方法
	function getParameter(value,plan_no_s) {
	 log(plan_no_s);
	var plan_no =plan_no_s;
		ISOneRow = 0;
		$("#production_dayplan_s").textbox("setValue", plan_no);
		$("#tyre_materialcode_s").textbox("setValue", "");
		$("#material_code_left_s").textbox("setValue", value);
		//提交获取日计划号，查询对应参数
		$("#plancuringparameter_dg").datagrid("options").url = "curing/productionManagement/planCuringParameter/getParameterl";
		ext.easyui.grid.search("plancuringparameter_dg",
				"plancuringparameter_form");

	} 
//超链接点击方法
	function getParameterr(value,plan_no_s) {
	 log(plan_no_s);
	var plan_no =plan_no_s;
		ISOneRow = 0;
		$("#production_dayplan_s").textbox("setValue", plan_no);
		$("#tyre_materialcode_s").textbox("setValue", "");
		$("#material_code_left_s").textbox("setValue", value);
		//提交获取日计划号，查询对应参数
		$("#plancuringparameter_dg").datagrid("options").url = "curing/productionManagement/planCuringParameter/getParameter";
		ext.easyui.grid.search("plancuringparameter_dg",
				"plancuringparameter_form");

	} 
	/*     查询栏按钮*/
	function queryBar() {
		$("#PlanDayParameter_search_form").toggle(500);
	}

	/**
	 * 查询方法
	 */
	var filter = function() {
		ext.easyui.grid.search("plandayparameter_dg",
				"PlanDayParameter_search_form");
	}

	//取消
	function cancel() {
		$("#plandayparameter_dg").datagrid("rejectChanges");
	}
	
    /**
     * 接收色标线数据
     */
     var colorLineInfo=[];
 	
 	$.ajax({
 		url:"curing/productionManagement/planCuringParameter/colorMarkingLine",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			colorLineInfo=data;
 		}
 	});
	//色标线转换
	function colorMarkingLineFormatter(v,r,i){
		if(r.parameter_name_s.indexOf("色标")!=-1){
			for(var i=0;i<colorLineInfo.length;i++){
				if(r.parameter_value_s==colorLineInfo[i].ERPCODE_S){
					return colorLineInfo[i].DICTNAME_S;
				}
			}
		}
		else{
			return v;
		}
	}
</script>