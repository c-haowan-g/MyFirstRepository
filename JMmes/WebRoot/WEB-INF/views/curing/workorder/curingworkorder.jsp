<!-- 

    作者      :刘朋
    时间      :2019-07-18
    页面名称:硫化工单查询
    文件关联:
        
        cringworkorderController.java
       cringworkorderServiceImpl.java
        cringworkorderServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/meta.jsp"%>
<%@ include file="curingworkorder.js.jsp"%>
<script type="text/javascript" src="dict/218,-307,328,152.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="workorder_dg_toolbar">
            <form id="workorder_search_form" class="form" >
                <!-- 日计划号 -->
                <spring:message code="sapreturnresult.column.spare4_s" /><input name="filter[order_number]" id="baseunit" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 订单号-->
                <spring:message code="workordertest.column.order_item" /><input name="filter[order_item]" id="brand" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 物料编码 -->
                <spring:message code="workordertest.column.part_number" /><input name="filter[part_number]" id="zwbm" type="text" class="easyui-textbox" data-options="label:''" ></br>
                <spring:message code="sapproductionplan.column.month_i" />:
				<input name="filter[month_i]" id="month_i" type="text"
					class="easyui-datetimespinner"
					data-options="
                	label:'',
                	formatter:formatter2,
                	parser:parser2,
                	labelWidth:50"
					style="width:140px;">
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            <auth:button code="cringworkorder.detial"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-search'" onclick="particulars()"><spring:message code="functionmenu.column.description_s" /></a></auth:button>
            <auth:button code="cringworkorder.export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="export()"><spring:message code="button.export" /></a></auth:button>
            </form> 
            <%-- <auth:button code="XXX"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            　
            <auth:button code="XXX"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            　 --%>
        </div>
        <table id="workorder_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: true,
                toolbar: '#workorder_dg_toolbar',
                striped:true,
                method: 'get' ,
                 emptyMsg:'<span><spring:message code='tip.noData'/></span>',
                ">
            <thead>
                <tr>
                	<!--月计划号-->
                    <th data-options="field:'order_number',width:100,editor:{type:'textbox'}"><spring:message code="sapreturnresult.column.spare4_s" /></th>
                     <!-- 班次 -->
<%--                     <th data-options="field:'uda_0',width:80,editor:{type:'textbox'}"><spring:message code="workordertest.column.uda_0" /></th>--%>					<!-- 工单号 -->
                    <th data-options="field:'order_item',width:160,editor:{type:'textbox'}"><spring:message code="workordertest.column.order_item" /></th>
                     <!-- 工单状态 -->
                    <th data-options="field:'status',formatter:showStatus,width:80,editor:{type:'textbox'}"><spring:message code="workordertest.column.order_state" /></th>
                     <!-- 产品编号 -->
                    <th data-options="field:'part_number',width:100,editor:{type:'textbox'}"><spring:message code="workordertest.column.part_number" /></th>
                     <!-- 产品版本-->
                    <th data-options="field:'part_revision',width:80,editor:{type:'textbox'}"><spring:message code="workordertest.column.part_revision" /></th>
                     <!-- BOM品号 -->
                   <!-- <th data-options="field:'bom_name',width:80,editor:{type:'textbox'}"><spring:message code="workordertest.column.bom_name" /></th>
                     <!-- BOM版本-->
                    <!--<th data-options="field:'bom_revision',width:80,editor:{type:'textbox'}"><spring:message code="plmcuringprocessparameter.column.version" /></th>
                     <!-- 产线-->
                    <!--<th data-options="field:'planned_line',width:80,editor:{type:'textbox'}"><spring:message code="plandayparameter.column.production_line" /></th>
                     <!-- 订单数量-->
                    <th data-options="field:'quantity_ordered',width:80,editor:{type:'textbox'}"><spring:message code="machinestatus.column.order_quantity_i" /></th>
                     <!-- 生产中的数量-->
<%--                     <th data-options="field:'quantity_in_progress',width:80,editor:{type:'textbox'}"><spring:message code="workordertest.column.quantity_in_progress" /></th>
 --%>                     <!-- 完成数量-->
                    <th data-options="field:'quantity_finished',width:80,editor:{type:'textbox'}"><spring:message code="projecttrack.column.planfinish_i" /></th>
                     <!-- 工艺-->
                    <th data-options="field:'planned_route',width:180,editor:{type:'textbox'}"><spring:message code="plmcuringprocessparameter.column.process_route" /></th>
                     <!-- 计划开始时间-->
                    <th data-options="field:'planned_start_time',width:180,editor:{type:'textbox'}"><spring:message code="workorder.column.planned_start_time" /></th>
                     <!-- 计划结束时间-->
                    <th data-options="field:'planned_finish_time',width:180,editor:{type:'textbox'}"><spring:message code="workorder.column.planned_finish_time" /></th>
                     <!-- 实际开始时间-->
<%--                     <th data-options="field:'scheduled_start_time',width:180,editor:{type:'textbox'}"><spring:message code="workorder.column.scheduled_start_time" /></th>
 --%>                     <!-- 实际结束时间-->
                    <th data-options="field:'finished_time',width:180,editor:{type:'textbox'}"><spring:message code="workorder.column.scheduled_finish_time" /></th>
                     <!-- 创建时间-->
                    <th data-options="field:'last_modified_time',width:180,editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.changed_time_t" /></th>
                     <!-- 创建时间-->
                    <th data-options="field:'creation_time',width:180,editor:{type:'textbox'}"><spring:message code="plmcuringprocessparameter.column.createdate" /></th>
                   
                </tr>
            </thead>
        </table>
    </div>
    <div id="particulars" class="easyui-window" title="工单详情" data-options="modal:true,closed:true,iconCls:'icon-search'" style="width:100%;height:100%;padding:10px;">
	    <div class="easyui-layout" fit="true"> 
			<div data-options="region:'west',split:true" title="成型日计划" style="width:50%;">
			<form id="CxProductionDayPlan_search_form" class="form">
				<!-- 计划生产日期 -->
				<spring:message code="productiondayplan.column.production_date_s" />
				<input name="filter[production_date_s]" id="cxproduction_date_s" type="text" class="easyui-datebox" data-options="onChange:buildingfilter,buttons:[],formatter:dateFormat,parser:dateParser,width:100,label:''">
				<input name="filter[order_number_s]"  id="order_number_s" type="text" class="easyui-textbox" >
				
				<script type="text/javascript">
                $("#cxproduction_date_s").val(new Calendar().format("yyyyMMdd"));
                </script>
                <!-- 设备条码 -->
                <spring:message code="cxproductiondayplan.column.equip_code_s" />
                <input name="filter[equip_code_s]" id="equip_code_s" type="text" class="easyui-combobox" data-options="label:'',
                                  width:'90px',
                                 required:false, 
                                 url:'building/basedata/productline/getProductlineByProcess?process='+'252005',
	                             method: 'get',
	                             editable:true,
	                             panelHeight:300,
	                             valueField:'p_line_name',
	                             textField:'p_line_name'" >
				<!-- 计划状态 -->
				<spring:message code="cxproductiondayplan.column.status_s" />
				<input name="filter[status_s]" id="status_s" type="text" class="easyui-combobox" data-options="width:100,url:'dict/code/152',valueField:'code',label:''">
				</br>
				<!-- 胎胚物料编码（SAP品号） -->
				<spring:message code="cxproductiondayplan.column.material_code_s" />
				<input name="filter[material_code_s]" like=true id="material_code_s" type="text" class="easyui-textbox" data-options="width:100,labelWidth:100,label:''">
				
				<!-- 规格代码 -->
				<spring:message code="cxproductiondayplan.column.specification_s" />
                <input name="filter[specification_s]" like=true id="specification_s" type="text" class="easyui-textbox" data-options="width:100,labelWidth:100,label:''" >
				
				<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="buildingfilter()"><spring:message code="button.search" /></a>
			</form>
			    <table id="cxproductiondayplan_dg" class="easyui-datagrid" style="width:100%"
					data-options="  
		                fit:true,
		                fitColumns:false,
		                pagination:true,
		                rownumbers: true,
		                singleSelect: false,
		                toolbar: '#CxProductionDayPlan_search_form',
		                striped:true,
		                method: 'get'
		                ">
					<thead>
						<tr>
							<th data-options="required:true,field:'atr_key',checkbox:true"></th>
							<!-- 计划生产日期 -->
							<th data-options="required:true,field:'production_date_s',editor:{type:'textbox',options:{required:true,editable:false,icons:[]}}"><spring:message code="productiondayplan.column.production_date_s" /></th>
							<!-- 日计划号 -->
							<th data-options="required:true,field:'plan_no_s',editor:{type:'textbox',options:{editable:false,icons:[]}}"><spring:message code="cxproductiondayplan.column.plan_no_s" /></th>
							<!--工单号 -->
							<th data-options="required:true,field:'order_number_s',editor:{type:'textbox',options:{editable:false,icons:[]}}"><spring:message code="workordertest.column.order_item" /></th>
					    	<!-- 计划状态 -->
							<th data-options="required:true,width:100,styler:planStatusCellStyler,formatter:function(v,r,i){return dictFormat(v);},field:'status_s'"><spring:message code="cxproductiondayplan.column.status_s" /></th>
							<!-- 设备条码 -->
		                    <th data-options="field:'equip_code_s',width:100"><spring:message code="productiondayplan.column.equip_code_s" /></th>
							<!-- 日计划顺序 -->
							<th data-options="required:true,field:'plan_queue_i'"><spring:message code="cxproductiondayplan.column.plan_queue_i" /></th>
							<!-- 规格 -->
		                    <th data-options="width:130,field:'specification_s'"><spring:message code="cxproductiondayplan.column.specification_s" /></th>
							<!-- 胎胚物料编码 -->
							<th data-options="required:true,width:130,field:'material_code_s'"><spring:message code="cxproductiondayplan.column.material_code_s" /></th>
							<!-- 胎胚物料名称 -->
							<th data-options="required:true,field:'material_desc_s',editor:{type:'textbox'}"><spring:message code="cxproductiondayplan.column.material_desc_s" /></th>
						    <!-- 中班计划量 -->
		                    <th data-options="required:true,field:'planamount_mid_i',editor:{type:'numberspinner',options:{min:1,max:8888888,icons:[]}}"><spring:message code="cxproductiondayplan.column.planamount_mid_i" /></th>
							<!-- 晚班计划量 -->
							<th data-options="required:true,field:'planamount_nig_i',editor:{type:'numberspinner',options:{min:1,max:8888888,icons:[]}}"><spring:message code="cxproductiondayplan.column.planamount_nig_i" /></th>
							<!-- 早班计划量 -->
							<th data-options="required:true,field:'planamount_mor_i',editor:{type:'numberspinner',options:{min:1,max:8888888,icons:[]}}"><spring:message code="cxproductiondayplan.column.planamount_mor_i" /></th>
							<!-- 日计划量 -->
							<th data-options="required:true,field:'quantity_dayplan_i',editor:{type:'numberspinner',options:{min:1,max:8888888,editable:false,required:true,icons:[]}}"><spring:message code="cxproductiondayplan.column.quantity_dayplan_i" /></th>
						    <!-- 产品阶段 -->
  		                    <th data-options="required:true,width:100,formatter:function(v,r,i){return dictFormat(v);},field:'production_step_s'"><spring:message code="cxproductiondayplan.column.production_step_s" /></th>
 						    <!-- 成本收集器版本 -->
		                    <th data-options="field:'productionver_s',editor:{type:'combobox'}"><spring:message code="cxproductiondayplan.column.productionver_s" /></th>
							<!-- 胎胚版本号 -->
							<th data-options="required:true,width:80,field:'version_s',editor:{}"><spring:message code="cxproductiondayplan.column.version_s" /></th>
		                    <!-- 工艺配方索引号 -->
		                    <th data-options="required:true,field:'processbom_index_s',editor:{type:'textbox'}"><spring:message code="cxproductiondayplan.column.processbom_index_s" /></th>
		                   	<!-- 客户标识 -->
		                     <th data-options="field:'customer_flag_s',width:100,formatter:function(v,r,i){return dictFormat(v);},editor:{type:'combobox'}"><spring:message code="cxproductiondayplan.column.customer_flag_s" /></th> 
							 <!-- 审核人 -->
		                    <th data-options="field:'auditbyname'"><spring:message code="cxproductiondayplan.column.audit_by_s" /></th>
		                    <!-- 审核时间 -->
		                    <th data-options="field:'audit_time_t'"><spring:message code="cxproductiondayplan.column.audit_time_t" /></th>
							<!-- 修改人 -->
							<th data-options="required:true,field:'changebyname'"><spring:message code="cxproductiondayplan.column.changed_by_s" /></th>
							<!-- 修改时间 -->
							<th data-options="required:true,field:'changed_time_t'"><spring:message code="cxproductiondayplan.column.changed_time_t" /></th>
							<!-- 创建人 -->
							<th data-options="required:true,field:'createdname'"><spring:message code="cxproductiondayplan.column.created_by_s" /></th>
							<!-- 创建时间 -->
							<th data-options="required:true,field:'created_time_t'"><spring:message code="cxproductiondayplan.column.created_time_t" /></th>
						</tr>
					</thead>
		 		</table>
			</div>
			<div data-options="region:'center',split:true" title="硫化日计划" style="width:50%;">
			 <div id="ProductionDayPlan_dg_toolbar">
	            <form id="ProductionDayPlan_search_form" class="form">
		            <!-- 操作时间 -->
		            <spring:message code="productiondayplan.column.production_date_s" />
		            <input name="filter[production_date_s]" id="lhproduction_date_s" type="text" class="easyui-datebox" style="width:120px" data-options="onChange:curingfilter,buttons:[],formatter:dateFormat,parser:dateParser,width:100,label:''">
		            <input name="filter[left_order_number_s]" id="left_order_number_s"    class="easyui-textbox" >
		            
		            <script type="text/javascript">
		            $("#lhproduction_date_s").val(new Calendar().format("yyyyMMdd"));
		            </script>
		            <!-- 产线条码 -->
		            <spring:message code="productiondayplan.column.production_line_s" />
		            <input type="text" name="filter[production_line_s]" id="production_line_s" class="easyui-combobox" data-options="data:lhjtxx,panelHeight:150,editable:true,valueField:'P_LINE_NAME',textField:'P_LINE_NAME',selectOnNavigation:false,limitToList:true,filter:searchProductionLine,onChange:curingfilter" />
		            <!-- 物料编码 --></br>
		            <spring:message code="productiondayplan.column.material_code_left_s" />
		            <input type="text" name="filter[material_code_left_s]" id="material_code_left_s" like ="true" class="easyui-textbox" data-options="" />
		            <!-- 物料名称 -->
		            <spring:message code="productiondayplan.column.material_desc_left_s" />
		            <input type="text" name="filter[material_desc_left_s]" id="material_desc_left_s" like="true" class="easyui-textbox" data-options="" />
		            
		            <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="curingfilter()"><spring:message code="button.search" /></a>
	            </form>
        	</div>
				<table id="productiondayplan_dg" class="easyui-datagrid" style="width:100%"
		            data-options="  
		                fit:true,
		                fitColumns:false,
		                pagination:true,
		                rownumbers: true,
		                singleSelect: false,
		                toolbar: '#ProductionDayPlan_dg_toolbar',
		                striped:true,
		                method: 'get',
		                ">
		             <thead >
			            <tr>
			                <th data-options="field:'atr_key',checkbox:true">ID</th>
		                    <!-- 计划生产日期 -->
		                    <th data-options="field:'production_date_s',width:70,editor:{type:'textbox',options:{editable:false,required:true,icons:[]}}"><spring:message code="productiondayplan.column.production_date_s" /></th>
		                     <!-- 日计划号 -->
		                    <th data-options="field:'plan_no_s',width:105,editor:{type:'textbox',options:{editable:false,icons:[],required:true}}"><spring:message code="productiondayplan.column.plan_no_s" /></th>
		                    <!-- 月计划号 -->
		                    <th data-options="field:'planno_month_s',width:105,editor:{type:'textbox',options:{editable:false,icons:[],required:true}}"><spring:message code="productiondayplan.column.planno_month_s" /></th>
		                    <!-- 工单号 -->
		                    <th data-options="field:'left_order_number_s',width:110,editor:{type:'textbox',options:{editable:false,icons:[],required:true}}"><spring:message code="workordertest.column.order_item" /></th>
		                    <!-- 产线条码 -->
		                    <th data-options="field:'production_line_s',width:70,editor:{type:'textbox',options:{required:true,icons:[],editable:false}}"><spring:message code="productiondayplan.column.production_line_s" /></th>
		                    <!-- 日计划顺序 -->
		                    <th data-options="field:'plan_queue_s',width:50,editor:{type:'numberspinner',options:{icons:[],min:1,max:999,required:true}}"><spring:message code="productiondayplan.column.plan_queue_s" /></th>
		                    <!-- 计划状态 218  -->
		                    <th data-options="field:'status_s',width:50,styler:planStatusCellStyler,formatter:function(v,r,i){return dictFormat(v);}"><spring:message code="productiondayplan.column.status_s" /></th>
		                    <!-- 机台条码(左) -->
		                    <th data-options="field:'equip_code_left_s',hidden:true,width:100,editor:{type:'textbox',hidden:true,options:{icons:[],required:true,editable:false}}"><spring:message code="productiondayplan.column.equip_code_left_s" /></th>
		                    <!-- 机台条码(右) -->
		                    <th data-options="field:'equip_code_right_s',hidden:true,width:100,editor:{type:'textbox',hidden:true,options:{icons:[],required:true,editable:false}}"><spring:message code="productiondayplan.column.equip_code_right_s" /></th>
		                    <!-- 物料编码(左) -->
		                    <th data-options="field:'material_code_left_s',width:100,editor:{type:'combobox',options:{delay:300,panelWidth:300,mode:'remote',required:true,panelHeight:150,editable:true,valueField:'MATERIAL_CODE_S',textField:'MATERIAL_CODE_S',selectOnNavigation:false,limitToList:true}}"><spring:message code="productiondayplan.column.material_code_left_s" /></th>
		                    <!-- 物料编码(右) -->
		                    <th data-options="field:'material_code_right_s',width:100,editor:{type:'combobox',options:{delay:300,panelWidth:300,mode:'remote',required:true,panelHeight:150,editable:true,valueField:'MATERIAL_CODE_S',textField:'MATERIAL_CODE_S',selectOnNavigation:false,limitToList:true}}"><spring:message code="productiondayplan.column.material_code_right_s" /></th>
		                    <!-- 物料名称(左) -->
		                    <th data-options="field:'material_desc_left_s',width:220,editor:{type:'textbox',options:{required:true,icons:[],editable:false}}"><spring:message code="productiondayplan.column.material_desc_left_s" /></th>
		                    <!-- 物料名称(右) -->
		                    <th data-options="field:'material_desc_right_s',width:220,editor:{type:'textbox',options:{required:true,icons:[],editable:false}}"><spring:message code="productiondayplan.column.material_desc_right_s" /></th>
		                    <!-- 成本收集器版本(左) -->
		                    <th data-options="field:'productionver_left_s',hidden:true,width:120,editor:{type:'textbox',options:{icons:[],required:true,editable:false}}"><spring:message code="productiondayplan.column.productionver_left_s" /></th>
		                    <!-- 成本收集器版本(右) -->
		                    <th data-options="field:'productionver_right_s',hidden:true,width:120,editor:{type:'textbox',options:{icons:[],required:true,editable:false}}"><spring:message code="productiondayplan.column.productionver_right_s" /></th>
		                    <!-- 所属产品阶段(左) -->
		                    <th data-options="field:'production_step_left_s',formatter:function(v,r,i){return dictFormat(v);},width:120,editor:{type:'combobox',options:{required:true,editable:false,valueField:'production_step_left_s',textField:'production_step_left_s_text'}}"><spring:message code="productiondayplan.column.production_step_left_s" /></th>
		                    <!-- 所属产品阶段(右) -->
		                    <th data-options="field:'production_step_right_s',formatter:function(v,r,i){return dictFormat(v);},width:120,editor:{type:'combobox',options:{required:true,editable:false,valueField:'production_step_right_s',textField:'production_step_right_s_text'}}"><spring:message code="productiondayplan.column.production_step_right_s" /></th>
		                    <!-- 工艺配方ID成型 -->
		                    <th data-options="field:'processbom_index_build_s',hidden:true,width:120,editor:{type:'textbox',options:{editable:false}}"><spring:message code="productiondayplan.column.processbom_index_build_s" /></th>
		                    <!-- 工艺配方ID硫化 -->
		                    <th data-options="field:'processbom_index_curing_s',hidden:true,width:120,editor:{type:'textbox',options:{editable:false}}"><spring:message code="productiondayplan.column.processbom_index_curing_s" /></th>
		                    <!-- 早班计划量(左) -->
		                    <th data-options="field:'planamount_mor_left_i',width:120,editor:{type:'numberspinner',options:{min:2,max:8888888,required:true,icons:[]}}"><spring:message code="productiondayplan.column.planamount_mor_left_i" /></th>
		                    <!-- 中班计划量(左) -->
		                    <th data-options="field:'planamount_mid_left_i',width:120,editor:{type:'numberspinner',options:{min:2,max:8888888,required:true,icons:[]}}"><spring:message code="productiondayplan.column.planamount_mid_left_i" /></th>
		                    <!-- 晚班计划量(左) -->
		                    <th data-options="field:'planamount_nig_left_i',width:120,editor:{type:'numberspinner',options:{min:2,max:8888888,required:true,icons:[]}}"><spring:message code="productiondayplan.column.planamount_nig_left_i" /></th>
		                    <!-- 早班计划量(右) -->
		                    <th data-options="field:'planamount_mor_right_i',width:120,editor:{type:'numberspinner',options:{min:2,max:8888888,required:true,icons:[]}}"><spring:message code="productiondayplan.column.planamount_mor_right_i" /></th>
		                    <!-- 中班计划量(右) -->
		                    <th data-options="field:'planamount_mid_right_i',width:120,editor:{type:'numberspinner',options:{min:2,max:8888888,required:true,icons:[]}}"><spring:message code="productiondayplan.column.planamount_mid_right_i" /></th>
		                    <!-- 晚班计划量(右) -->
		                    <th data-options="field:'planamount_nig_right_i',width:120,editor:{type:'numberspinner',options:{min:2,max:8888888,required:true,icons:[]}}"><spring:message code="productiondayplan.column.planamount_nig_right_i" /></th>
		                    <!-- 日计划量(左) -->
		                    <th data-options="field:'quantity_dayplan_left_i',width:120,editor:{type:'textbox',options:{required:true,icons:[]}}"><spring:message code="productiondayplan.column.quantity_dayplan_left_i" /></th>
		                    <!-- 日计划量(右) -->
		                    <th data-options="field:'quantity_dayplan_right_i',width:120,editor:{type:'textbox',options:{required:true,icons:[]}}"><spring:message code="productiondayplan.column.quantity_dayplan_right_i" /></th>
		                    <!-- 胎胚品号(左) -->
		                    <th data-options="field:'specification_left_s',width:120,editor:{type:'textbox',options:{required:true,editable:false,icons:[]}}"><spring:message code="productiondayplan.column.specification_left_s" /></th>
		                    <!-- 胎胚品号(右) -->
		                    <th data-options="field:'specification_right_s',width:120,editor:{type:'textbox',options:{required:true,editable:false,icons:[]}}"><spring:message code="productiondayplan.column.specification_right_s" /></th>
		                    <!-- 胎胚规格(左) -->
		                    <th data-options="field:'spec_left_s',formatter:specFormatter1,width:120,editor:{type:'textbox',options:{required:true}}"><spring:message code="productiondayplan.column.spec_left_s" /></th>
		                    <!-- 胎胚规格(右) -->
		                    <th data-options="field:'spec_right_s',formatter:specFormatter1,width:120,editor:{type:'textbox',options:{required:true}}"><spring:message code="productiondayplan.column.spec_right_s" /></th>
		                    <!-- 胎胚版本(左) -->
		                    <th data-options="field:'childbom_ver_left_s',width:120,editor:{type:'textbox',options:{required:true,editable:false,icons:[]}}"><spring:message code="productiondayplan.column.childbom_ver_left_s" /></th>
		                    <!-- 胎胚版本(右) -->
		                    <th data-options="field:'childbom_ver_right_s',width:120,editor:{type:'textbox',options:{required:true,editable:false,icons:[]}}"><spring:message code="productiondayplan.column.childbom_ver_right_s" /></th>
		                     <!-- 备注(左) -->
		                    <th data-options="field:'memo_left_s',width:120,editor:{type:'textbox'}"><spring:message code="productiondayplan.column.memo_left_s" /></th>
		                    <!-- 备注(右) -->
		                    <th data-options="field:'memo_right_s',width:120,editor:{type:'textbox'}"><spring:message code="productiondayplan.column.memo_right_s" /></th>
		                    <!-- 计划状态 218  -->
		                    <th data-options="field:'status_s',width:120,formatter:function(v,r,i){return dictFormat(v);}"><spring:message code="productiondayplan.column.status_s" /></th>
		                    <!-- 审核时间 -->
		                    <th data-options="field:'approval_time_s',width:120"><spring:message code="productiondayplan.column.approval_time_s" /></th>
		                    <!-- 审核人 -->
		                    <th data-options="field:'approver_s',width:120"><spring:message code="productiondayplan.column.approver_s" /></th>
		                    <!-- 更新人 -->
		                    <th data-options="field:'changed_by_s',width:120"><spring:message code="productiondayplan.column.changed_by_s" /></th>
		                    <!-- 更新时间 -->
		                    <th data-options="field:'changed_time_t',width:120"><spring:message code="productiondayplan.column.changed_time_t" /></th>
		                    <!-- 创建人 -->
		                    <th data-options="field:'created_by_s',width:120"><spring:message code="productiondayplan.column.created_by_s" /></th>
		                    <!-- 创建时间 -->
		                    <th data-options="field:'created_time_t',width:120"><spring:message code="productiondayplan.column.created_time_t" /></th>
		                    
		                </tr>
		            </thead>
		        </table>
			</div>
	    </div>
	    
	    
   
     </div>
</body>
</html>
