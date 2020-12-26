<!-- 

    作者      :边朝会
    时间      :2020-08-12 13:26:13 
    页面名称:批报表
    文件关联:
        MixBatchReportAll.java
        MixBatchReportAllController.java
        MixBatchReportAllServiceImpl.java
        MixBatchReportAllServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="mixbatchreportall.js.jsp"%>
<script type="text/javascript" src="dict/302,054.js"></script>

<body class="easyui-layout" fit="true">
	<div class="easyui-layout" fit="true" border="false"
		style="width: 700px; height: 350px;">

		<div data-options="region:'north'" style="height: 50px">
			<div id="MixBatchReportAll1_dg_toolbar">
				<form id="MixBatchReportAll_search_form" class="form">
					<table class="formTable">
						<tr>
							<td class="columnTitle">
								<!-- 工单生产日期 --> 生产日期:
								<input name="filter[start_time]" id="start_time"
								style="width: 90px" type="text" class="easyui-datebox"
								data-options="onChange:getequipcode,formatter:dateFormat,buttons:[],parser:dateParser,label:''">
								<script type="text/javascript">
									$("#start_time").val(
											new Calendar().format("yyyyMMdd"));
								</script> &nbsp;<strong>到</strong>&nbsp; <input name="filter[end_time]"
								id="end_time" style="width: 90px" type="text"
								class="easyui-datebox"
								data-options="onChange:getequipcode,formatter:dateFormat,buttons:[],parser:dateParser,label:''">
								<script type="text/javascript">
									$("#end_time").val(
											new Calendar().format("yyyyMMdd"));
								</script> <!-- 班次 --> &nbsp;&nbsp; <spring:message code="生产班次" /> <input
								name="filter[wo_shift_s]" id="wo_shift_s" type="text"
								style="width: 90px" class="easyui-combotree"
								data-options="label:'',
				              			 required:false,
				              			 panelHeight:200,
				              			 url:'dict/code/302',
				              			 method:'get',
				              			 onChange:filter
				              			">

								<!-- 机台条码 --> &nbsp;&nbsp; <spring:message code="机台条码" /> <input
								name="filter[equip_code_s]" id="equip_code_s" type="text"
								class="easyui-combobox"
								data-options="label:'',
                               data:equipcodelist,
	         		           panelHeight:150,
	         		           editable:true,
	           		           valueField:'EQUIP_CODE_S',
	          		            textField:'EQUIP_NAME_S',
	                           selectOnNavigation:false,
	           		           limitToList:true,
	           		           onChange:getrecipecodebycode">

								<!-- 配方名称 --> &nbsp;&nbsp; <spring:message code="配方名称" /> <input
								name="filter[recipe_code_s]" id="recipe_code_s" type="text"
								class="easyui-combobox"
								data-options="label:'',
                              data:recipecodelist,
	         		          panelHeight:150,
	         		          editable:true,
	           		          valueField:'RECIPE_CODE_S',
	          		           textField:'SPARE8_S',
	                          selectOnNavigation:false,
	           		          limitToList:true,
	           		          onChange:filter">

							</td>
							<td class="columnTitle"><a
								class="easyui-linkbutton btn-yellow"
								data-options="iconCls:'icon-search'" onclick="filter()"><spring:message
										code="button.search" /></a></td>

							<td class="columnTitle">&nbsp;&nbsp; 
									<a class="easyui-linkbutton btn-black"
										data-options="iconCls:'icon-print'" onclick="batch()">批报表</a>
								</td>
					</table>
				</form>
			</div>
		</div>

		<div data-options="region:'west',split:true" title="生产计划执行汇总"
			style="width: 38%">
			<div class="easyui-panel" fit="true" border="false">
				<div class="easyui-layout" data-options="fit:true">
					<div data-options="region:'center'" style="width: 10px;">
						<table id="mixbatchreportall_dg" class="easyui-datagrid"
							data-options="  
                                        checkOnSelect: false, 
                                       selectOnCheck: false,  
                                       fit:true,
                                       fitColumns:false,
                                       pagination:true,
                                       pageSize: 100,
                                       rownumbers: true,
                                       singleSelect: true,
                                       toolbar: '#MixBatchReportAll_dg_toolbar',
                                       onBeforeLoad:dlg1BeforeLoad,
                                       striped:true,
                                       onSelect:selectrow,
                                       method: 'get' 
                ">
							<thead>
								<tr>
									<!--  onSelect:selectrow, -->
									<!-- 物料编码-->
									<th data-options="field:'material_code_s'"><spring:message
											code="物料编码" /></th>
									<!-- 物料名称 -->
									<th data-options="field:'material_name_s'"><spring:message
											code="物料名称" /></th>

									<!-- 计划量-->
									<th data-options="field:'qtyplan'"><spring:message
											code="计划量" /></th>
									<!-- 完成量 -->
									<th data-options="field:'qtycomplete'"><spring:message
											code="完成量" /></th>

								</tr>
							</thead>
						</table>
					</div>
				</div>
			</div>
		</div>

		<div data-options="region:'center',iconCls:'icon-ok'" title="工单汇总">
			<table id="groupname_dg" class="easyui-datagrid"
				data-options="    
                fit:true,
                fitColumns:false,
                pagination:true,
                pageSize: 100,
                rownumbers: true,
                singleSelect: true,
                striped:true,
                method: 'get' ,
                ">
				<thead>
					<tr>
                      <!--   onSelect:selectrow1, -->
						<!--生产日期-->
						<th data-options="field:'wo_date_s',width:80"><spring:message
								code="生产日期" /></th>
						<!--班次-->
						<th
							data-options="field:'wo_shift_s',width:80,formatter:codeFormatter"><spring:message
								code="班次" /></th>
						<!--机台名称-->
						<th data-options="field:'equip_name_s',width:145"><spring:message
								code="机台名称" /></th>
						<!-- 物料名称-->
						<th data-options="field:'material_name_s',width:120"><spring:message
								code="物料名称" /></th>
						<!-- 计划数-->
						<th data-options="field:'qty_plan_i',width:80"><spring:message
								code="计划数" /></th>
						<!--完成数-->
						<th data-options="field:'qty_complete_i',width:80"><spring:message
								code="完成数" /></th>
						<!--开始时间-->
						<th data-options="field:'act_start_time_t',width:140"><spring:message
								code="开始时间" /></th>
						<!--结束时间-->
						<th data-options="field:'act_finish_time_t',width:140"><spring:message
								code="结束时间" /></th>
						<!--工单状态-->
						<th
							data-options="field:'status_check_s',width:80,formatter:codeFormatter"><spring:message
								code="工单状态" /></th>
						<!--工单号-->
						<th data-options="field:'wo_no_s',width:120"><spring:message
								code="工单号" /></th>
					</tr>
				</thead>
			</table>
		</div>

		<div id="equalmaterial_dlg" class="easyui-dialog" title="批报表"
			maximized="true" maximizable="true" minimizable="true"
			style="width: 70%;"
			data-options="
		                resizable:true,
		    			modal:true,
		                iconCls:'icon-window',		                
		                closed:true,       
		                ">
			<table>
				<tr>
					<td><spen id="wo_no_s1">工单号:</spen> &nbsp;&nbsp;&nbsp;<spen
							id="equip_name_s1">生产机台:</spen> &nbsp;&nbsp;&nbsp;<spen
							id="wo_shift_s1">班次:</spen> &nbsp;&nbsp;&nbsp;<spen
							id="spare8_s1">配方名称:</spen>&nbsp;&nbsp;&nbsp; <spen
							id="qty_plan_i1">设定:</spen>&nbsp;&nbsp;&nbsp;<spen
							id="qty_complete_i1">完成:</spen></td>
				</tr>
				<tr>
					<td><spen id="act_start_time_t1">开始时间:</spen>&nbsp;&nbsp;&nbsp;<spen
							id="act_finish_time_t1">结束时间:</spen></td>
				</tr>
			</table>
			<table id="equalmaterialdg" class="easyui-datagrid" title="报表明细"
				data-options="  fit:true,
									fitColumns:true,
									pagination:true,
									singleSelect: false,									 
									striped:true,									
									method: 'get',																	
									">
				<thead>
					<tr>


						<th data-options="field:'N_NAME_S'"><spring:message code="" /></th>
						<!--车次号-->
						<th data-options="field:'SERIAL_ID_I'"><spring:message
								code="车次号" /></th>
						<!-- 配方时间-->
						<th data-options="field:'RECIPETIME_I'"><spring:message
								code="配方时间" /></th>
						<!-- 炼胶时间-->
						<th data-options="field:'MIXTIME_I'"><spring:message
								code="炼胶时间" /></th>
						<!-- 间隔时间-->
						<th data-options="field:'INTERVALS_I'"><spring:message
								code="间隔时间" /></th>
						<!-- 加胶时间-->
						<th data-options="field:'ADDNRTIME_I'"><spring:message
								code="加胶时间" /></th>
						<!-- 加炭黑时间-->
						<th data-options="field:'ADDCBTIME_I'"><spring:message
								code="加炭黑时间" /></th>
						<!--加油时间-->
						<th data-options="field:'ADDOILTIME_I'"><spring:message
								code="加油时间" /></th>
						<!-- 排胶温度-->
						<th data-options="field:'DISCHARGETEMP_F'"><spring:message
								code="排胶温度" /></th>
						<!-- 排胶功率-->
						<th data-options="field:'DISCHARGEPOWER_F'"><spring:message
								code="排胶功率" /></th>
						<!-- 排胶能量-->
						<th data-options="field:'DISCHARGEENERGY_F'"><spring:message
								code="排胶能量" /></th>
						<!-- 检量称-->
						<th data-options="field:'CALIBRATION_SAID'"><spring:message
								code="检量称" /></th>
						<!-- 小料-->
						<th data-options="field:'SMALL_MATERIAL'"><spring:message
								code="小料" /></th>								
						<!-- 胶料-->
						<th data-options="field:'RUBBER'"><spring:message code="胶料" /></th>
						<!-- 炭黑-->
						<th data-options="field:'CARBON_BLACK'"><spring:message
								code="炭黑" /></th>
						<th data-options="field:'SET_WEIGHT_S'"><spring:message
								code="设定重量" /></th>
						
						<th data-options="field:'REAL_WEIGHT_S'"><spring:message
								code="实际重量" /></th>
						
						<th data-options="field:'ERROR_ALLOW_S'"><spring:message
								code="允许误差" /></th>
						<!-- 总重-->
						<th data-options="field:'ALL_NUM'"><spring:message code="总重" /></th>
					</tr>
				</thead>
			</table>
		</div>
</body>
</html>
