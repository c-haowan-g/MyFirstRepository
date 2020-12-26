<!-- 

    作者      :李德晓
    时间      :2020-08-10 08:17:13 
    页面名称:盘库计划管理表
    文件关联:
        MaterialStoragePlanJob.java
        MaterialStoragePlanJobController.java
        MaterialStoragePlanJobServiceImpl.java
        MaterialStoragePlanJobServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="materialstorageplanjob.js.jsp"%>
<script type="text/javascript" src="dict/343,344,347,302.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="MaterialStoragePlanJob_dg_toolbar">
            <form id="MaterialStoragePlanJob_search_form" class="form" >
                <!-- 作业日期：YYYYMMDD作业日期 -->
				计划日期
				<input name="filter[job_date_s]" id="job_date_s" style="width: 90px"
					type="text" class="easyui-datebox"
					data-options="onChange:filter,formatter:dateFormat,buttons:[],parser:dateParser,label:''">
				<script type="text/javascript">
					$("#job_date_s").val(new Calendar().format("yyyyMMdd"));
				</script>

				<!-- 班次 -->
				&nbsp;&nbsp;
				班次
				<input name="filter[job_shift_s]" id="job_shift_s" type="text"
					style="width: 90px" class="easyui-combotree"
					data-options="label:'',
				              			 required:false,
				              			 panelHeight:200,
				              			 url:'dict/code/302',
				              			 method:'get',
				              			 onChange:filter
				              			">

				<!-- 盘点区域 -->
				&nbsp;&nbsp;
				盘点区域
				<input name="filter[inventory_area_s]" id="inventory_area_s"
					type="text" style="width: 180px" class="easyui-combotree"
					data-options="label:'',
				              			 required:false,
				              			 panelHeight:200,
				              			 url:'dict/code/343',
				              			 method:'get',
				              			 onChange:filter
				              			">
				<!-- 计划状态 -->
				&nbsp;&nbsp;
				计划状态
				<input name="filter[job_status_s]" id="job_status_s" type="text"
					style="width: 120px" class="easyui-combotree"
					data-options="label:'',
				              			 required:false,
				              			 panelHeight:200,
				              			 url:'dict/code/344',
				              			 method:'get',
				              			 onChange:filter
				              			">
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="RAW_Stock Management_MaterialStoragePlanJob_add"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="RAW_Stock Management_MaterialStoragePlanJob_remove"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()">删除</a></auth:button>
            　
            <auth:button code="RAW_Stock Management_MaterialStoragePlanJob_save"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="RAW_Stock Management_MaterialStoragePlanJob_no"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            　
            
            <auth:button code="RAW_Stock Management_materialstockplanresult_expor"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button> 
        </div>
        <table id="materialstorageplanjob_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#MaterialStoragePlanJob_dg_toolbar',
                url: 'material/stockManagement/materialstorageplanjob/datagrid',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
					<th data-options="field:'atr_key',checkbox:true" rowspan="2"></th>
					<th colspan="5"><strong>基本信息</strong></th>
					<th colspan="3"><strong>结存量</strong></th>
					<th colspan="3"><strong>截存量</strong></th>
					<th colspan="2"><strong>盘点量</strong></th>
					<th colspan="3"><strong>对库产出量</strong></th>
					<th colspan="3"><strong>对库退库量</strong></th>
					<th colspan="3"><strong>对库出库量</strong></th>
					<th colspan="2"><strong>截存时间</strong></th>
					<th colspan="2"><strong>盘库时间</strong></th>
					<th colspan="2"><strong>对库产出时间</strong></th>
					<th colspan="2"><strong>对库出库时间</strong></th>
					<th colspan="2"><strong>对库时间</strong></th>
					<th colspan="21"><strong>其他信息</strong></th>

				</tr>
                <tr>
                    <!-- 作业班次：302001-早班、302002-中班、302003-晚班 -->
					<th
						data-options="field:'job_shift_s',width:120,formatter:codeFormatter,editor:{type:'combotree',options:{
                    			method:'get',
                    			 labelwidth:'auto',
                                url:'dict/code/302',                              
                    			required:true,
                    			onSelect:onshiftselect
                    			}}">班次</th>
					<!-- 盘点区域 -->
					<th
						data-options="field:'inventory_area_s',width:230,formatter:codeFormatter,editor:{type:'combotree',options:{
                    			method:'get',
                    			 labelwidth:'auto',
                                url:'dict/code/343',                              
                    			required:true,
                    			onSelect:oninventoryselect
                    			}}">盘点区域</th>
					<!-- 作业编号 -->
					<th data-options="field:'job_no_s'">计划编号</th>
					<!-- 作业名称 -->
					<th data-options="field:'job_name_s'">计划名称</th>
					<!-- 作业状态： 343001-盘库开始 343002-盘库中 343003-盘库结束 343004-对库开始 343005-对库中 343006-对库结束 343007-结存开始 343008-结存结束 343009-作业完成 343010-作业作废 -->
					<th data-options="field:'job_status_s',formatter:codeFormatter">计划状态</th>

					<!-- 结存标识：0-未处理、1-已处理、2-处理失败 -->
					<th data-options="field:'balance_state_s',formatter:flagformatter">处理标识</th>
					<!-- 结存数量 -->
					<th data-options="field:'balance_qty_f'">数量</th>
					<!-- 结存重量 -->
					<th data-options="field:'balance_weight_f'">重量</th>
					<!-- 截存标识：0-未处理、1-已处理、2-处理失败 -->
					<th
						data-options="field:'intercept_state_s',formatter:flagformatter">处理标识</th>
					<!-- 截存计划-数量 -->
					<th data-options="field:'sys_plan_qty_f',width:60">数量</th>
					<!-- 截存计划-重量 -->
					<th data-options="field:'sys_plan_weight_f',width:60">重量</th>
					<!-- 盘点数量 -->
					<th data-options="field:'inventory_qty_f',width:60">数量</th>
					<!-- 盘点重量 -->
					<th data-options="field:'inventory_weight_f',width:60">重量</th>

					<!-- 对库产出标识：0-未处理、1-已处理、2-处理失败 -->
					<th
						data-options="field:'check_prod_state_s',formatter:flagformatter">处理标识</th>
					<!-- 对库产出-数量 -->
					<th data-options="field:'check_prod_qty_f'">数量</th>
					<!-- 对库产出-重量 -->
					<th data-options="field:'check_prod_weight_f'">重量</th>


					<!-- 对库退库产出标识：0-未处理、1-已处理、2-处理失败 -->
					<th
						data-options="field:'check_return_state_s',formatter:flagformatter">处理标识</th>
					<!-- 对库退库-数量 -->
					<th data-options="field:'check_return_qty_f'">数量</th>
					<!-- 对库退库-重量 -->
					<th data-options="field:'check_returnt_weight_f'">重量</th>



					<!-- 对库出库标识：0-未处理、1-已处理、2-处理失败 -->
					<th
						data-options="field:'check_out_state_s',formatter:flagformatter">处理标识</th>
					<!-- 对库出库-数量 -->
					<th data-options="field:'check_out_qty_f'">数量</th>
					<!-- 对库出库-重量 -->
					<th data-options="field:'check_out_weight_f'">重量</th>

					<!-- 截存开始时间 -->
					<th data-options="field:'sys_start_time_t'">开始时间</th>
					<!-- 截存结束时间 -->
					<th data-options="field:'sys_finish_time_t'">结束时间</th>


					<!-- 盘点开始时间 -->
					<th data-options="field:'inventory_start_time_s'">开始时间</th>
					<!-- 盘点结束时间 -->
					<th data-options="field:'inventory_finish_time_s'">结束时间</th>

					<!-- 对库产出-开始时间 -->
					<th data-options="field:'check_prod_start_time_t'">开始时间</th>
					<!-- 对库产出-结束时间 -->
					<th data-options="field:'check_prod_finish_time_t'">结束时间</th>

					<!-- 对库出库-开始时间 -->
					<th data-options="field:'check_out_start_time_t'">开始时间</th>
					<!-- 对库出库-结束时间 -->
					<th data-options="field:'check_out_finish_time_t'">结束时间</th>
					<!-- 对库开始时间 -->
					<th data-options="field:'check_start_time_s'">开始时间</th>
					<!-- 对库结束时间 -->
					<th data-options="field:'check_finish_time_s'">结束时间</th>
					<!-- 创建人姓名 -->
					<th data-options="field:'created_name_s'">创建人</th>
					<!-- 创建时间  -->
					<th data-options="field:'created_time_t'">创建时间 </th>
					<!-- 截存人姓名 -->
					<th data-options="field:'intercept_name_s'">截存人</th>
					<!-- 截存时间 -->
					<th data-options="field:'intercept_time_t'">截存时间</th>

					<!-- 对库人姓名 -->
					<th data-options="field:'check_name_s'">对库人</th>
					<!-- 对库时间 -->
					<th data-options="field:'check_time_t'">对库时间</th>
					<!-- 结存人姓名 -->
					<th data-options="field:'balance_name_s'">结存人</th>
					<!-- 结存时间  -->
					<th data-options="field:'balance_time_t'">结存时间 </th>

					<!-- 修改人 -->
					<th data-options="field:'changed_name_s'">修改人</th>
					<!-- 修改时间  -->
					<th data-options="field:'changed_time_t'">修改时间</th>
					<!-- 数据来源： 347001-原材料 347002-密炼 347003-半部件 347004-成型 347005-硫化 -->
					<th data-options="field:'datasource_s',formatter:codeFormatter">数据源</th>

					 <!-- 备用字段1  -->
					<!--<th data-options="field:'spare1_s'">备用字段1</th>
					备用字段2
					<th data-options="field:'spare2_s'">备用字段2</th>
					备用字段3
					<th data-options="field:'spare3_s'">备用字段3</th>
					备用字段4
					<th data-options="field:'spare4_s'">备用字段4</th>
					备用字段5
					<th data-options="field:'spare5_s'">备用字段5</th>
					备用字段6
					<th data-options="field:'spare6_s'">备用字段6</th>
					备用字段7
					<th data-options="field:'spare7_s'">备用字段7</th>
					备用字段8
					<th data-options="field:'spare8_s'">备用字段8</th>
					备用字段9
					<th data-options="field:'spare9_s'">备用字段9</th>
					备用字段10
					<th data-options="field:'spare10_s'">备用字段10</th> 
                    -->
				</tr>
            </thead>
        </table>
    </div>
  
     <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="MaterialStoragePlanJob_search_form" />
		<jsp:param name="datagridId" value="materialstorageplanjob_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.material.excel.MaterialStoragePlanJobExportHandler" />
		<jsp:param name="serviceName" value="MaterialStoragePlanJobServiceImpl" />
    </jsp:include> 
</body>
</html>
