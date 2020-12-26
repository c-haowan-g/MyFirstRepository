<!-- 

    作者      :李德晓
    时间      :2020-08-11 08:41:41 
    页面名称:盘库数据管理表
    文件关联:
        MaterialStoragePlanData.java
        MaterialStoragePlanDataController.java
        MaterialStoragePlanDataServiceImpl.java
        MaterialStoragePlanDataServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="materialstorageplandata.js.jsp"%>
<script type="text/javascript" src="dict/343,344,345.js"></script>
<body class="easyui-layout" fit="true"> 
   <div class="easyui-tabs" fit="true" border="false"
		style="width: 700px; height: 250px">
		<!--盘库截存数据-->
		<div title="盘库截存数据" style="padding: 10px">
			<div id="MaterialStoragePlanData_dg_toolbar">
				<form id="MaterialStoragePlanData_search_form" class="form">
					<!--入库日期 -->
					计划日期
					<input name="filter[in_date_s]" id="in_date_s1" style="width: 90px"
						type="text" class="easyui-datebox"
						data-options="onChange:getJobName,formatter:dateFormat,buttons:[],parser:dateParser,label:''">
					<script type="text/javascript">
						$("#in_date_s1").val(new Calendar().format("yyyyMMdd"));
					</script>



					<!-- 计划名称 -->
					&nbsp;&nbsp;
					计划状态           	
                <input name="filter[job_name_s]" id="job_name_s" type="text" class="easyui-combobox" data-options="label:'',
                       data:jobnamelist,
	         		   panelHeight:150,
	         		   editable:true,
	           		   valueField:'JOB_NAME_S',
	          		    textField:'JOB_NAME_S',
	                   selectOnNavigation:false,
	           		   limitToList:true"	          		  
	           		    >

					<!-- 信息状态 -->
					&nbsp;&nbsp;
					信息状态
					<input name="filter[inventory_result_s]" id="inventory_result_s1"
						type="text" style="width: 180px" class="easyui-combotree"
						data-options="label:'',
				              			 required:false,
				              			 panelHeight:200,
				              			 url:'dict/code/345',
				              			 method:'get',
				              			 onChange:filter
				              			">
					<a class="easyui-linkbutton btn-yellow"
						data-options="iconCls:'icon-search'" onclick="filter()">查询</a>
				</form>
					<auth:button code="MATERIALSTORAGEPLANDATA_LOCKS"><a class="easyui-linkbutton btn-black"
						data-options="iconCls:'icon-locks'" onclick="lock()">锁定盘库</a></auth:button>
				
					 <auth:button code="MATERIALSTORAGEPLANDATA_UNLOCK"><a class="easyui-linkbutton btn-black"
						data-options="iconCls:'icon-unlock'" onclick="unlock()">解锁盘库</a></auth:button>
				
					 <auth:button code="MATERIALSTORAGEPLANDATA_SCANNING"><a class="easyui-linkbutton btn-black"
						data-options="iconCls:'icon-scanning'" onclick="scanning()">扫描对库</a></auth:button>
				
					 <auth:button code="MATERIALSTORAGEPLANDATA_DELETES"><a class="easyui-linkbutton btn-black"
						data-options="iconCls:'icon-deletes'" onclick="deletes()">无效删除</a></auth:button>
			 <auth:button code="MATERIALSTORAGEPLANDATA_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
				

			</div>
			<table id="materialstorageplandata_dg" class="easyui-datagrid"
				style="width: 100%"
				data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: true,
                toolbar: '#MaterialStoragePlanData_dg_toolbar',
                url: 'material/stockManagement/materialstorageplandata/datagrid',
                striped:true, 
                method: 'get' 
                ">
				<thead>
					<tr>
						<th data-options="field:'atr_key',checkbox:true"></th>
						<!-- 数据对库处理标记：0-未处理、1-已处理、2-处理失败 -->
						<th
							data-options="field:'check_hand_flag_s',editor:{type:'textbox'}">处理标记</th>
						<!-- 数据对库处理时间 -->
						<th
							data-options="field:'check_hand_time_t',editor:{type:'textbox'}">处理时间</th>
						<!-- 数据对库处理反馈 -->
						<th
							data-options="field:'check_hand_msg_s',editor:{type:'textbox'}">处理反馈</th>
						<!-- 盘库结果类型： 345001-正常(数据一致) 345002-正常(数据不一致) 345003-有实物，无信息 345004-有信息，无实物 -->
						<th
							data-options="field:'inventory_result_s',editor:{type:'textbox'}">盘库结果</th>

						<!-- 物料组 -->
						<th
							data-options="field:'material_group_s',editor:{type:'textbox'}">物料规格</th>
						<!-- 物料编码 -->
						<th data-options="field:'material_code_s',editor:{type:'textbox'}">物料编码</th>
						<!-- 物料名称 -->
						<th data-options="field:'material_name_s',editor:{type:'textbox'}">物料名称</th>
						<!-- 系统数量 -->
						<th data-options="field:'sys_qty_f',editor:{type:'textbox'}">系统数量</th>
						<!-- 系统重量 -->
						<th data-options="field:'sys_weight_f',editor:{type:'textbox'}">系统重量</th>
						<!-- 系统库位 -->
						<th data-options="field:'sys_loc_s',editor:{type:'textbox'}">系统库位</th>

						<!-- 盘点数量 -->
						<th data-options="field:'inventory_qty_f',editor:{type:'textbox'}">盘点数量</th>
						<!-- 盘点重量 -->
						<th
							data-options="field:'inventory_weight_f',editor:{type:'textbox'}">盘点重量 </th>
						<!-- 盘点时库位  -->
						<th data-options="field:'inventory_loc_s',editor:{type:'textbox'}">盘点库位</th>
						<!-- 批次号 -->
						<th data-options="field:'lot_no_s',editor:{type:'textbox'}">条码号</th>
						<!-- 进厂批次 -->
						<th data-options="field:'spare1_s',editor:{type:'textbox'}">进厂批次</th>
						<!-- 载具条码 -->
						<th data-options="field:'carrier_code_s',editor:{type:'textbox'}">载具号</th>
						<!-- 机台名称 -->
						<th data-options="field:'equip_name_s',editor:{type:'textbox'}">机台名称</th>

						<!-- 产出时间 -->
						<th data-options="field:'product_time_s',editor:{type:'textbox'}">产出时间</th>
						<!-- 入库日期 -->
						<th data-options="field:'in_date_s',editor:{type:'textbox'}">入库时间</th>

						<!-- 出库日期 -->
						<th data-options="field:'out_date_s',editor:{type:'textbox'}">出库时间</th>

						<!-- 数据来源： 347001-原材料 347002-密炼 347003-半部件 347004-成型 347005-硫化 -->
						<th data-options="field:'datasource_s',editor:{type:'textbox'}">数据源</th>

						<!-- 创建人 -->
						<th data-options="field:'created_name_s',editor:{type:'textbox'}">创建人</th>
						<!-- 创建时间 -->
						<th data-options="field:'created_time_t',editor:{type:'textbox'}">创建时间</th>
						<!-- 修改人姓名 -->
						<th data-options="field:'changed_name_s',editor:{type:'textbox'}">修改人</th>
						<!-- 修改时间 -->
						<th data-options="field:'changed_time_t',editor:{type:'textbox'}">修改时间</th>

						<!-- 备用字段2 -->
						<!-- <th data-options="field:'spare2_s',editor:{type:'textbox'}">备用字段2</th>
						备用字段3
						<th data-options="field:'spare3_s',editor:{type:'textbox'}">备用字段3</th>
						备用字段4
						<th data-options="field:'spare4_s',editor:{type:'textbox'}">备用字段4</th>
						备用字段5
						<th data-options="field:'spare5_s',editor:{type:'textbox'}">备用字段5</th>
						备用字段6
						<th data-options="field:'spare6_s',editor:{type:'textbox'}">备用字段6</th>
						备用字段7
						<th data-options="field:'spare7_s',editor:{type:'textbox'}">备用字段7</th>
						备用字段8
						<th data-options="field:'spare8_s',editor:{type:'textbox'}">备用字段8</th>
						备用字段9
						<th data-options="field:'spare9_s',editor:{type:'textbox'}">备用字段9</th>
						备用字段10
						<th data-options="field:'spare10_s',editor:{type:'textbox'}">备用字段10</th> -->
					</tr>
				</thead>
			</table>
		</div>
    <!-- 盘库扫描数据 -->
		<div title="盘库扫描数据" style="padding: 10px">
			<div id="MaterialStoragePlanDataScan_dg_toolbar">
				<form id="MaterialStoragePlanDataScan_search_form" class="form">
					<!--入库日期 -->
					计划日期
					<input name="filter[in_date_s]" id="in_date_s2" style="width: 90px"
						type="text" class="easyui-datebox"
						data-options="onChange:getJobName1,formatter:dateFormat,buttons:[],parser:dateParser,label:''">
					<script type="text/javascript">
						$("#in_date_s2").val(new Calendar().format("yyyyMMdd"));
					</script>

					

					<!-- 计划名称 -->
					&nbsp;&nbsp;
					计划状态           	
                <input name="filter[job_name_s]" id="job_name_s" type="text" class="easyui-combobox" data-options="label:'',
                       data:jobnamelist,
	         		   panelHeight:150,
	         		   editable:true,
	           		   valueField:'JOB_NAME_S',
	          		    textField:'JOB_NAME_S',
	                   selectOnNavigation:false,
	           		   limitToList:true"	          		  
	           		    >

					<a class="easyui-linkbutton btn-yellow"
						data-options="iconCls:'icon-search'" onclick="filter1()">查询</a>
				</form>
                     <auth:button code="MATERIALSTORAGEPLANDATA_LOCKS"><a class="easyui-linkbutton btn-black"
						data-options="iconCls:'icon-locks'" onclick="lock1()">锁定盘库</a></auth:button>
				
					 <auth:button code="MATERIALSTORAGEPLANDATA_UNLOCK"><a class="easyui-linkbutton btn-black"
						data-options="iconCls:'icon-unlock'" onclick="unlock1()">解锁盘库</a></auth:button>
				
					 <auth:button code="MATERIALSTORAGEPLANDATA_SCANNING"><a class="easyui-linkbutton btn-black"
						data-options="iconCls:'icon-scanning'" onclick="scanning1()">扫描对库</a></auth:button>
			</div>
			<table id="materialstorageplandatascan_dg" class="easyui-datagrid"
				style="width: 100%"
				data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: true,
                toolbar: '#MaterialStoragePlanDataScan_dg_toolbar',
                url: 'material/stockManagement/materialstorageplandatascan/datagrid',
                striped:true, 
                method: 'get' 
                ">
				<thead>
					<tr>
						<th data-options="field:'atr_key',checkbox:true"></th>
						<!-- 数据对库处理标记：0-未处理、1-已处理、2-处理失败 -->
						<th
							data-options="field:'check_hand_flag_s',editor:{type:'textbox'}">处理标记</th>
						<!-- 数据对库处理时间 -->
						<th
							data-options="field:'check_hand_time_t',editor:{type:'textbox'}">处理时间</th>
						<!-- 数据对库处理反馈 -->
						<th
							data-options="field:'check_hand_msg_s',editor:{type:'textbox'}">处理反馈</th>
						<!-- 盘库结果类型： 345001-正常(数据一致) 345002-正常(数据不一致) 345003-有实物，无信息 345004-有信息，无实物 -->
						<th
							data-options="field:'inventory_result_s',editor:{type:'textbox'}">盘库结果</th>

						<!-- 物料组 -->
						<th
							data-options="field:'material_group_s',editor:{type:'textbox'}">物料规格</th>
						<!-- 物料编码 -->
						<th data-options="field:'material_code_s',editor:{type:'textbox'}">物料编码</th>
						<!-- 物料名称 -->
						<th data-options="field:'material_name_s',editor:{type:'textbox'}">物料名称</th>
						<!-- 系统数量 -->
						<th data-options="field:'sys_qty_f',editor:{type:'textbox'}">系统数量</th>
						<!-- 系统重量 -->
						<th data-options="field:'sys_weight_f',editor:{type:'textbox'}">系统重量</th>
						<!-- 系统库位 -->
						<th data-options="field:'sys_loc_s',editor:{type:'textbox'}">系统库位</th>

						<!-- 批次号 -->
						<th data-options="field:'lot_no_s',editor:{type:'textbox'}">条码号</th>
						<!-- 进厂批次 -->
						<th data-options="field:'spare1_s',editor:{type:'textbox'}">进厂批次</th>
						<!-- 载具条码 -->
						<th data-options="field:'carrier_code_s',editor:{type:'textbox'}">载具号</th>
						<!-- 机台名称 -->
						<th data-options="field:'equip_name_s',editor:{type:'textbox'}">机台名称</th>

						<!-- 产出时间 -->
						<th data-options="field:'product_time_s',editor:{type:'textbox'}">产出时间</th>
						<!-- 入库日期 -->
						<th data-options="field:'in_date_s',editor:{type:'textbox'}">入库时间</th>

						<!-- 出库日期 -->
						<th data-options="field:'out_date_s',editor:{type:'textbox'}">出库时间</th>

						<!-- 数据来源： 347001-原材料 347002-密炼 347003-半部件 347004-成型 347005-硫化 -->
						<th data-options="field:'datasource_s',editor:{type:'textbox'}">数据源</th>

						<!-- 创建人 -->
						<th data-options="field:'created_name_s',editor:{type:'textbox'}">创建人</th>
						<!-- 创建时间 -->
						<th data-options="field:'created_time_t',editor:{type:'textbox'}">创建时间</th>
						<!-- 修改人姓名 -->
						<th data-options="field:'changed_name_s',editor:{type:'textbox'}">修改人</th>
						<!-- 修改时间 -->
						<th data-options="field:'changed_time_t',editor:{type:'textbox'}">修改时间</th>

						<!-- 备用字段2 -->
						<!-- <th data-options="field:'spare2_s',editor:{type:'textbox'}">备用字段2</th>
						备用字段3
						<th data-options="field:'spare3_s',editor:{type:'textbox'}">备用字段3</th>
						备用字段4
						<th data-options="field:'spare4_s',editor:{type:'textbox'}">备用字段4</th>
						备用字段5
						<th data-options="field:'spare5_s',editor:{type:'textbox'}">备用字段5</th>
						备用字段6
						<th data-options="field:'spare6_s',editor:{type:'textbox'}">备用字段6</th>
						备用字段7
						<th data-options="field:'spare7_s',editor:{type:'textbox'}">备用字段7</th>
						备用字段8
						<th data-options="field:'spare8_s',editor:{type:'textbox'}">备用字段8</th>
						备用字段9
						<th data-options="field:'spare9_s',editor:{type:'textbox'}">备用字段9</th>
						备用字段10
						<th data-options="field:'spare10_s',editor:{type:'textbox'}">备用字段10</th>
 -->
					</tr>
				</thead>
			</table>
		</div>
    <!-- 盘库生产数据 -->
		<div title="盘库生产数据" style="padding: 10px">
			<div id="MaterialStoragePlanDataProd_dg_toolbar">
				<form id="MaterialStoragePlanDataProd_search_form" class="form">
					<!--入库日期 -->
					计划日期
					<input name="filter[in_date_s]" id="in_date_s3" style="width: 90px"
						type="text" class="easyui-datebox"
						data-options="onChange:getJobName2,formatter:dateFormat,buttons:[],parser:dateParser,label:''">
					<script type="text/javascript">
						$("#in_date_s3").val(new Calendar().format("yyyyMMdd"));
					</script>

					

					<!-- 计划名称 -->
					&nbsp;&nbsp;
					计划状态           	
                <input name="filter[job_name_s]" id="job_name_s" type="text" class="easyui-combobox" data-options="label:'',
                       data:jobnamelist,
	         		   panelHeight:150,
	         		   editable:true,
	           		   valueField:'JOB_NAME_S',
	          		    textField:'JOB_NAME_S',
	                   selectOnNavigation:false,
	           		   limitToList:true"	          		  
	           		    >

					<a class="easyui-linkbutton btn-yellow"
						data-options="iconCls:'icon-search'" onclick="filter2()">查询</a>
				</form>

					<auth:button code="MATERIALSTORAGEPLANDATA_LOCKS"><a class="easyui-linkbutton btn-black"
						data-options="iconCls:'icon-locks'" onclick="lock2()">锁定盘库</a></auth:button>
				
					 <auth:button code="MATERIALSTORAGEPLANDATA_UNLOCK"><a class="easyui-linkbutton btn-black"
						data-options="iconCls:'icon-unlock'" onclick="unlock2()">解锁盘库</a></auth:button>
				
					 <auth:button code="MATERIALSTORAGEPLANDATA_SCANNING"><a class="easyui-linkbutton btn-black"
						data-options="iconCls:'icon-scanning'" onclick="scanning2()">扫描对库</a></auth:button>

			</div>
			<table id="materialstorageplandataprod_dg" class="easyui-datagrid"
				style="width: 100%"
				data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: true,
                toolbar: '#MaterialStoragePlanDataProd_dg_toolbar',
                url: 'material/stockManagement/materialstorageplandataprod/datagrid',
                striped:true, 
                method: 'get' 
                ">
				<thead>
					<tr>
						<th data-options="field:'atr_key',checkbox:true"></th>
						<!-- 数据对库处理标记：0-未处理、1-已处理、2-处理失败 -->
						<th
							data-options="field:'check_hand_flag_s',editor:{type:'textbox'}">处理标记</th>
						<!-- 数据对库处理时间 -->
						<th
							data-options="field:'check_hand_time_t',editor:{type:'textbox'}">处理时间</th>
						<!-- 数据对库处理反馈 -->
						<th
							data-options="field:'check_hand_msg_s',editor:{type:'textbox'}">处理反馈</th>
						<!-- 盘库结果类型： 345001-正常(数据一致) 345002-正常(数据不一致) 345003-有实物，无信息 345004-有信息，无实物 -->
						<th
							data-options="field:'inventory_result_s',editor:{type:'textbox'}">盘库结果</th>

						<!-- 物料组 -->
						<th
							data-options="field:'material_group_s',editor:{type:'textbox'}">物料规格</th>
						<!-- 物料编码 -->
						<th data-options="field:'material_code_s',editor:{type:'textbox'}">物料编码</th>
						<!-- 物料名称 -->
						<th data-options="field:'material_name_s',editor:{type:'textbox'}">物料名称</th>
						<!-- 系统数量 -->
						<th data-options="field:'sys_qty_f',editor:{type:'textbox'}">系统数量</th>
						<!-- 系统重量 -->
						<th data-options="field:'sys_weight_f',editor:{type:'textbox'}">系统重量</th>
						<!-- 系统库位 -->
						<th data-options="field:'sys_loc_s',editor:{type:'textbox'}">系统库位</th>

						<!-- 批次号 -->
						<th data-options="field:'lot_no_s',editor:{type:'textbox'}">条码号</th>
						<!-- 进厂批次 -->
						<th data-options="field:'spare1_s',editor:{type:'textbox'}">进厂批次</th>
						<!-- 载具条码 -->
						<th data-options="field:'carrier_code_s',editor:{type:'textbox'}">载具号</th>
						<!-- 机台名称 -->
						<th data-options="field:'equip_name_s',editor:{type:'textbox'}">机台名称</th>

						<!-- 产出时间 -->
						<th data-options="field:'product_time_s',editor:{type:'textbox'}">产出时间</th>
						<!-- 入库日期 -->
						<th data-options="field:'in_date_s',editor:{type:'textbox'}">入库时间</th>

						<!-- 出库日期 -->
						<th data-options="field:'out_date_s',editor:{type:'textbox'}">出库时间</th>

						<!-- 数据来源： 347001-原材料 347002-密炼 347003-半部件 347004-成型 347005-硫化 -->
						<th data-options="field:'datasource_s',editor:{type:'textbox'}">数据源</th>

						<!-- 创建人 -->
						<th data-options="field:'created_name_s',editor:{type:'textbox'}">创建人</th>
						<!-- 创建时间 -->
						<th data-options="field:'created_time_t',editor:{type:'textbox'}">创建时间</th>
						<!-- 修改人姓名 -->
						<th data-options="field:'changed_name_s',editor:{type:'textbox'}">修改人</th>
						<!-- 修改时间 -->
						<th data-options="field:'changed_time_t',editor:{type:'textbox'}">修改时间</th>

						<!-- 备用字段2 -->
						<!-- <th data-options="field:'spare2_s',editor:{type:'textbox'}">备用字段2</th>
						备用字段3
						<th data-options="field:'spare3_s',editor:{type:'textbox'}">备用字段3</th>
						备用字段4
						<th data-options="field:'spare4_s',editor:{type:'textbox'}">备用字段4</th>
						备用字段5
						<th data-options="field:'spare5_s',editor:{type:'textbox'}">备用字段5</th>
						备用字段6
						<th data-options="field:'spare6_s',editor:{type:'textbox'}">备用字段6</th>
						备用字段7
						<th data-options="field:'spare7_s',editor:{type:'textbox'}">备用字段7</th>
						备用字段8
						<th data-options="field:'spare8_s',editor:{type:'textbox'}">备用字段8</th>
						备用字段9
						<th data-options="field:'spare9_s',editor:{type:'textbox'}">备用字段9</th>
						备用字段10
						<th data-options="field:'spare10_s',editor:{type:'textbox'}">备用字段10</th>
 -->
					</tr>
				</thead>
			</table>
		</div>
		<!-- 盘库出库数据 -->
		<div title="盘库出库数据" style="padding: 10px">
			<div id="MaterialStoragePlanDataOut_dg_toolbar">
				<form id="MaterialStoragePlanDataOut_search_form" class="form">
					<!--入库日期 -->
					计划日期
					<input name="filter[in_date_s]" id="in_date_s4" style="width: 90px"
						type="text" class="easyui-datebox"
						data-options="onChange:getJobName3,formatter:dateFormat,buttons:[],parser:dateParser,label:''">
					<script type="text/javascript">
						$("#in_date_s4").val(new Calendar().format("yyyyMMdd"));
					</script>

					

					<!-- 计划名称 -->
					&nbsp;&nbsp;
					计划状态           	
                <input name="filter[job_name_s]" id="job_name_s" type="text" class="easyui-combobox" data-options="label:'',
                       data:jobnamelist,
	         		   panelHeight:150,
	         		   editable:true,
	           		   valueField:'JOB_NAME_S',
	          		    textField:'JOB_NAME_S',
	                   selectOnNavigation:false,
	           		   limitToList:true"	          		  
	           		    >

					<a class="easyui-linkbutton btn-yellow"
						data-options="iconCls:'icon-search'" onclick="filter3()">查询</a>
				</form>


				
					<auth:button code="MATERIALSTORAGEPLANDATA_LOCKS"><a class="easyui-linkbutton btn-black"
						data-options="iconCls:'icon-locks'" onclick="lock3()">锁定盘库</a></auth:button>
				
					 <auth:button code="MATERIALSTORAGEPLANDATA_UNLOCK"><a class="easyui-linkbutton btn-black"
						data-options="iconCls:'icon-unlock'" onclick="unlock3()">解锁盘库</a></auth:button>
				
					 <auth:button code="MATERIALSTORAGEPLANDATA_SCANNING"><a class="easyui-linkbutton btn-black"
						data-options="iconCls:'icon-scanning'" onclick="scanning3()">扫描对库</a></auth:button>

			</div>
			<table id="materialstorageplandataout_dg" class="easyui-datagrid"
				style="width: 100%"
				data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: true,
                toolbar: '#MaterialStoragePlanDataOut_dg_toolbar',
                url: 'material/stockManagement/materialstorageplandataout/datagrid',
                striped:true,
                method: 'get' 
                ">
				<thead>
					<tr>
						<th data-options="field:'atr_key',checkbox:true"></th>
						<!-- 数据对库处理标记：0-未处理、1-已处理、2-处理失败 -->
						<th
							data-options="field:'check_hand_flag_s',editor:{type:'textbox'}">处理标记</th>
						<!-- 数据对库处理时间 -->
						<th
							data-options="field:'check_hand_time_t',editor:{type:'textbox'}">处理时间</th>
						<!-- 数据对库处理反馈 -->
						<th
							data-options="field:'check_hand_msg_s',editor:{type:'textbox'}">处理反馈</th>
						<!-- 盘库结果类型： 345001-正常(数据一致) 345002-正常(数据不一致) 345003-有实物，无信息 345004-有信息，无实物 -->
						<th
							data-options="field:'inventory_result_s',editor:{type:'textbox'}">盘库结果</th>

						<!-- 物料组 -->
						<th
							data-options="field:'material_group_s',editor:{type:'textbox'}">物料规格</th>
						<!-- 物料编码 -->
						<th data-options="field:'material_code_s',editor:{type:'textbox'}">物料编码</th>
						<!-- 物料名称 -->
						<th data-options="field:'material_name_s',editor:{type:'textbox'}">物料名称</th>
						<!-- 系统数量 -->
						<th data-options="field:'sys_qty_f',editor:{type:'textbox'}">系统数量</th>
						<!-- 系统重量 -->
						<th data-options="field:'sys_weight_f',editor:{type:'textbox'}">系统重量</th>
						<!-- 系统库位 -->
						<th data-options="field:'sys_loc_s',editor:{type:'textbox'}">系统库位</th>

						<!-- 批次号 -->
						<th data-options="field:'lot_no_s',editor:{type:'textbox'}">条码号</th>
						<!-- 进厂批次 -->
						<th data-options="field:'spare1_s',editor:{type:'textbox'}">进厂批次</th>
						<!-- 载具条码 -->
						<th data-options="field:'carrier_code_s',editor:{type:'textbox'}">载具号</th>
						<!-- 机台名称 -->
						<th data-options="field:'equip_name_s',editor:{type:'textbox'}">机台名称</th>

						<!-- 产出时间 -->
						<th data-options="field:'product_time_s',editor:{type:'textbox'}">产出时间</th>
						<!-- 入库日期 -->
						<th data-options="field:'in_date_s',editor:{type:'textbox'}">入库时间</th>

						<!-- 出库日期 -->
						<th data-options="field:'out_date_s',editor:{type:'textbox'}">出库时间</th>

						<!-- 数据来源： 347001-原材料 347002-密炼 347003-半部件 347004-成型 347005-硫化 -->
						<th data-options="field:'datasource_s',editor:{type:'textbox'}">数据源</th>

						<!-- 创建人 -->
						<th data-options="field:'created_name_s',editor:{type:'textbox'}">创建人</th>
						<!-- 创建时间 -->
						<th data-options="field:'created_time_t',editor:{type:'textbox'}">创建时间</th>
						<!-- 修改人姓名 -->
						<th data-options="field:'changed_name_s',editor:{type:'textbox'}">修改人</th>
						<!-- 修改时间 -->
						<th data-options="field:'changed_time_t',editor:{type:'textbox'}">修改时间</th>

						<!-- 备用字段2 -->
						<!-- <th data-options="field:'spare2_s',editor:{type:'textbox'}">备用字段2</th>
						备用字段3
						<th data-options="field:'spare3_s',editor:{type:'textbox'}">备用字段3</th>
						备用字段4
						<th data-options="field:'spare4_s',editor:{type:'textbox'}">备用字段4</th>
						备用字段5
						<th data-options="field:'spare5_s',editor:{type:'textbox'}">备用字段5</th>
						备用字段6
						<th data-options="field:'spare6_s',editor:{type:'textbox'}">备用字段6</th>
						备用字段7
						<th data-options="field:'spare7_s',editor:{type:'textbox'}">备用字段7</th>
						备用字段8
						<th data-options="field:'spare8_s',editor:{type:'textbox'}">备用字段8</th>
						备用字段9
						<th data-options="field:'spare9_s',editor:{type:'textbox'}">备用字段9</th>
						备用字段10
						<th data-options="field:'spare10_s',editor:{type:'textbox'}">备用字段10</th>
 -->
					</tr>
				</thead>
			</table>
		</div>

	</div>
	<jsp:include page="../../../../inc/export.jsp">
        <jsp:param name="idField" value="atr_key" />
        <jsp:param name="formId" value="MaterialStoragePlanData_search_form" />
        <jsp:param name="datagridId" value="materialstorageplandataout_dg" />
        <jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.material.excel.MaterialStoragePlanDataExportHandler" />
        <jsp:param name="serviceName" value="MaterialStoragePlanDataServiceImpl" />
    </jsp:include>
</body>
</html>
