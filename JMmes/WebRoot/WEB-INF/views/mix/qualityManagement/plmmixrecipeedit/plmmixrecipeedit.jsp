<!-- 

    作者      :栾和源
    时间      :2020-08-11 16:43:15 
    页面名称:PLM密炼配方维护表
    文件关联:
        PlmMixRecipeEdit.java
        PlmMixRecipeEditController.java
        PlmMixRecipeEditServiceImpl.java
        PlmMixRecipeEditServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="plmmixrecipeedit.js.jsp"%>
<script type="text/javascript" src="dict/303,321,322,323,324,330,333,332,335,336.js"></script>
<style type="text/css">
table {
	border-collapse: collapse;
}

table, th, td {
	border: 1px, solid, black;
}
</style>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'center',split:true,border:true">
       			<div id="PlmMixRecipeEdit_dg_toolbar">
            	<form id="PlmMixRecipeEdit_search_form" class="form" >
            	<!-- 配方编号-13位：Java系统当前时间 例如 1552888628141 -->
	            	&nbsp;<spring:message code="plmmixrecipe.column.recipe_code" />
	                &nbsp;<input name="filter[recipe_code_s]" id="recipe_code_s" style="width:110px" type="text" class="easyui-textbox" data-options="label:''" >
	                <!-- 配方名称：父物料名称+工艺类型（是否掺胶+配方阶段+工艺类型） -->
	                &nbsp;<spring:message code="plmmixrecipe.column.recipe_code_name" />
	                &nbsp;<input name="filter[recipe_code_name_s]" id="recipe_code_name_s" style="width:110px" type="text" class="easyui-textbox" data-options="label:''" >
	                <!-- 父物料SAP品号 -->
	                &nbsp;<spring:message code="plmmixrecipe.column.mater_code" />
	                &nbsp;<input name="filter[mater_code_s]" id="mater_code_s" style="width:110px" type="text" class="easyui-textbox" data-options="label:''" >
	                <!-- 父物料名称 -->
	                &nbsp;<spring:message code="plmmixrecipe.column.mater_name_s" />
	                &nbsp;<input name="filter[mater_name_s]" id="mater_name_s" type="text" style="width:110px" class="easyui-textbox" data-options="label:''" >
	                <!-- MES机台条码 -->
	                &nbsp;<spring:message code="plmmixrecipe.column.mes_equip_code_s" />
	                &nbsp;<input name="filter[mes_equip_code_s]" id="mes_equip_code_s" style="width:110px" type="text" class="easyui-combobox" data-options="label:'',
	                			     data:equiplist,
		         		  			 panelHeight:150,
		         		  			 editable:true,
		           		  			 valueField:'p_line_name',
				          		  	 textField:'description',
				                  	 selectOnNavigation:false,
				           		  	 limitToList:true,
				          		  	 filter:searchProductionLine,
				           		  	onChange:filter" >
	                <!-- 配方状态：323001-待用、323002-正用、323003-停用 -->
	                &nbsp;<spring:message code="plmmixrecipe.column.recipe_status" />
	                &nbsp;<input name="filter[recipe_status_s]" id="recipe_status_s" style="width:100px" type="text" class="easyui-combotree" data-options="label:'',
	                			required:false,
					            panelHeight:200,
					            url:'dict/code/323',
					            method:'get'" >
	                <!-- 审核状态：0-未审核、1-已审核 -->
	                &nbsp;<spring:message code="plmmixrecipe.column.check_state" />
	                &nbsp;<input name="filter[check_state_s]" id="check_state_s" type="text" style="width:110px" class="easyui-combobox" data-options="label:'',
	                			required:false,
					            panelHeight:200,
	               	 			data:[{value:'0',text:'未审核'},
			                      	  {value:'1',text:'已审核'}],
	               	 			method: 'get'" >
	                <!-- 下发标识：0-未下发、1-已下发、2-下发失败 -->
	                &nbsp;<spring:message code="plmmixrecipe.column.send_state" />
	                &nbsp;<input name="filter[send_state_s]" id="send_state_s" type="text" style="width:110px" class="easyui-combobox" data-options="label:'',
	                			required:false,
					            panelHeight:200,
	               	 			data:[{value:'0',text:'未下发'},
			                      	  {value:'1',text:'已下发'},
			                      	  {value:'2',text:'重新下发'}],
	               	 			method: 'get'" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="MIXRECIPEEDIT_RANGESETTING"> 
            <a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-edit'" onclick="rangesetting()">称量调整范围设定</a>
			</auth:button>
			<auth:button code="MIXRECIPEEDIT_SUBMITWEIGHING">
			<a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-supplier'" onclick="submitweighing()">提交称量调整范围设定</a>
			</auth:button>
			<auth:button code="MIXRECIPEEDIT_WEIGHTMANAGE_EDIT">
			<a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-edit'" onclick="edit()">称量调整</a>
			</auth:button>
			<auth:button code="MIXRECIPEEDIT_WEIGHTMANAGE_COMMIT">
			<a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-supplier'" onclick="changeweight()">提交称量调整</a>
			</auth:button>
			<auth:button code="MIXRECIPEEDIT_START">
			<a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-shenhe'" onclick="startrecipe()">启用</a>
			</auth:button>
			<auth:button code="MIXRECIPEEDIT_STOP">
			<a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-fanshenhe'" onclick="stoprecipe()">停用</a>
			</auth:button>
			<auth:button code="MIXRECIPEEDIT_LETDOWN">
			<a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-supplier'" onclick="downward()">重新下发</a>
			</auth:button>
        </div>
        <table id="plmmixrecipeedit_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: true,
                toolbar: '#PlmMixRecipeEdit_dg_toolbar',
                url: '',
                onSelect:selectrow,
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 配方编号-13位：Java系统当前时间 例如 1552888628141 -->
                    <th data-options="field:'recipe_code_s',width:'110px',editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.recipe_code" /></th>
                    <!-- 配方名称：父物料名称+工艺类型（是否掺胶+配方阶段+工艺类型） -->
                    <th data-options="field:'recipe_code_name_s',width:'110px',editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.recipe_code_name" /></th>
                    <!-- 配方状态：323001-待用、323002-正用、323003-停用 -->
                    <th data-options="field:'recipe_status_s',formatter:codeFormatter,width:'80px',editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.recipe_status" /></th>
                    <!-- 审核状态：0-未审核、1-已审核 -->
                    <th data-options="field:'check_state_s',formatter:checkstateformatter,width:'80px',editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.check_state" /></th>
                    <!-- 机台代码 -->
                    <th data-options="field:'equip_code_s',width:'80px',editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.equip_code_s" /></th>
                    <!-- MES机台条码 -->
                    <th data-options="field:'mes_equip_code_s',width:'80px',editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.mes_equip_code_s" /></th>
                    <!-- MES机台名称 -->
                    <th data-options="field:'mes_equip_name_s',width:'80px',editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.mes_equip_name_s" /></th>
                    <!-- 父物料SAP品号：存储9位品号（返回胶、实验胶11位，例如 300000308_-F） -->
                    <th data-options="field:'mater_code_s',editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.mater_code" /></th>
                    <!-- 父物料类型： 母胶(LLMasterBatch) 终炼胶M(LLFinalBatchMPart) -->
                    <th data-options="field:'mater_type_s',formatter:codeFormatter,width:'80px',editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.mater_type" /></th>
                    <!-- 父物料名称 -->
                    <th data-options="field:'mater_name_s',width:'80px',editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.mater_name_s" /></th>
                    <!-- 父物料PLM版本 -->
                    <th data-options="field:'b_version_s',width:'80px',editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.b_version_s" /></th>
                    <!-- 配方替代号 -->
                    <th data-options="field:'edt_code_s',width:'80px',editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.edt_code_s" /></th>
                    <!-- 父物料工艺PLM版本 -->
                    <th data-options="field:'r_version_s',width:'110px',editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.r_version_s" /></th>
                    <!-- 区分阶段（小试XS、中试ZS、大试DS、投产TC  322） -->
                    <th data-options="field:'dummy1_s',formatter:codeFormatter,width:'80px',editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.dummy1" /></th>
                    <!-- 是否掺胶：Yes-掺胶、No-不掺胶 -->
                    <th data-options="field:'ismixed_s',formatter:codeFormatter,width:'80px',editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.ismixed" /></th>
                    <!-- 配套 -->
                    <th data-options="field:'matchingcode_s',width:'80px',editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.matchingcode_s" /></th>
                    <!-- 配方阶段：ZC-正常、SY-不正常  332-->
                    <th data-options="field:'prescriptionstage_s',width:'80px',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.prescriptionstage" /></th>
                    <!-- 工艺类型：1-正常、2-返炼、3-洗车、4-返洗、5-正洗  321-->
                    <th data-options="field:'routing_type_s',width:'80px',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.routing_type" /></th>
                    <!-- 提前量 -->
                    <th data-options="field:'slowdown_weight_d',width:'80px',editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.slowdown_weight_d" /></th>
                    <!-- 设定重量 -->
                    <th data-options="field:'set_weigh_d',width:'80px',editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.set_weigh_d" /></th>
                    <!-- 误差值 -->
                    <th data-options="field:'cutpoly_weight_d',width:'80px',editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.cutpoly_weight_d" /></th>
                    <!-- 小料包重量 -->
                    <th data-options="field:'pack_weight_s',width:'80px',editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.pack_weight_s" /></th>
                    <!-- 架子数 -->
                    <th data-options="field:'shelf_num_i',width:'80px',editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.shelf_num_i" /></th>
                    <!-- 炭黑回收类型：0-不回收、1-回收  335-->
                    <th data-options="field:'cb_recycletype_s',width:'110px',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.cb_recycletype" /></th>
                    <!-- 炭黑回收时间 -->
                    <th data-options="field:'cb_recycletime_i',width:'130px',editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.cb_recycletime_i" /></th>
                    <!-- 最高进胶温度 -->
                    <th data-options="field:'max_inploytemp_i',width:'80px',editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.max_inploytemp_i" /></th>
                    <!-- 最低进胶温度 -->
                    <th data-options="field:'min_inploytemp_i',width:'80px',editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.min_inploytemp_i" /></th>
                    <!-- 超温最短时间 -->
                    <th data-options="field:'overtemp_mintime_i',width:'130px',editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.overtemp_mintime_i" /></th>
                    <!-- 紧急排胶温度 -->
                    <th data-options="field:'overtemp_temp_i',width:'80px',editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.overtemp_temp_i" /></th>
                    <!-- 超时排胶时间 -->
                    <th data-options="field:'overtime_time_i',width:'130px',editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.overtime_time_i" /></th>
                    <!-- 补偿温度 -->
                    <th data-options="field:'makeup_temp_i',width:'80px',editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.makeup_temp_i" /></th>
                    <!-- 是否使用三区温度：0-不使用、1-使用 -->
                    <th data-options="field:'is_useareatemp_s',width:'110px',formatter:isuseareatempformatter,editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.is_useareatemp" /></th>
                    <!-- 侧壁温度 -->
                    <th data-options="field:'side_temp_i',width:'80px',editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.side_temp_i" /></th>
                    <!-- 转子温度 -->
                    <th data-options="field:'roll_temp_i',width:'80px',editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.roll_temp_i" /></th>
                    <!-- 卸料门温度 -->
                    <th data-options="field:'ddoor_temp_i',width:'80px',editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.ddoor_temp_i" /></th>
                    <!-- 加硫限制 -->
                    <th data-options="field:'dischangetime_i',width:'80px',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.dischangetime_i" /></th>
                    <!-- 工厂代码 -->
                    <th data-options="field:'plant_s',width:'80px',editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.plant_s" /></th>
                    <!-- 接收时间 -->
                    <th data-options="field:'receive_time_t',width:'80px',editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.receive_time_t" /></th>
                    <!-- 配方启停人 -->
                    <th data-options="field:'recipe_by_s',width:'80px',editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.recipe_by_s" /></th>
                    <!-- 配方启停时间 -->
                    <th data-options="field:'recipe_time_t',width:'150px',editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.recipe_time_t" /></th>
					<!-- 审核人 -->
                    <th data-options="field:'check_by_s',width:'80px',editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.check_by_s" /></th>
                    <!-- 审核时间 -->
                    <th data-options="field:'check_time_t',width:'150px',editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.check_time_t" /></th>                   
                    <!-- 修改人 -->
                    <th data-options="field:'changed_by_s',width:'80px',editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',width:'150px',editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.changed_time_t" /></th>
                    <!-- 每车标准时间 -->
                    <th data-options="field:'dummy2_s',width:'150px',editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.dummy2_s" /></th>
                    <!-- 原材料气味控制 -->
                    <th data-options="field:'dummy3_s',width:'110px',editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.dummy3_s" /></th>
                    <!-- 原材料等级控制 -->
                    <th data-options="field:'dummy4_s',width:'110px',editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.dummy4_s" /></th>
                    <!-- 备用5 -->
                    <th data-options="field:'dummy5_s',width:'80px',editor:{type:'textbox'}"><spring:message code="plmmixrecipe.column.dummy5_s" /></th> 
                </tr>
            </thead>
        </table>
    </div>
    <!-- 配方基本信息 -->
    <div data-options="region:'south',split:true" style="height: 200px;">
				<div class="easyui-tabs" id="content_tab"
					data-options="fit:true,tools:'#tab-tools'">
					<div title="配方基本信息" style="padding: 10px">
						<!-- 机台代码 -->
						<table  border="1px" cellspacing="0">
							<tr>
								<td bgcolor="#D1E9E9" width="150px">
									<spring:message code="plmmixrecipe.column.equip_code_s" />
								</td>
								<td width="250px">
									<span id="equip_code_s_sp"></span> 
								</td>
								<td bgcolor="#D1E9E9" width="150px" >
									<spring:message code="plmmixrecipe.column.edt_code_s" />
								</td>
								<td width="250px">
									<span id="edt_code_s_sp"></span> 
								</td>
								<td bgcolor="#D1E9E9" width="150px" >
									<spring:message code="plmmixrecipe.column.max_inploytemp_i" />
								</td>
								<td width="250px">
									<span id="max_inploytemp_i_sp"></span>
								</td>
							</tr>
							<tr>
								<td bgcolor="#D1E9E9" >
									<!-- 父物料SAP品号：存储9位品号（返回胶、实验胶11位，例如 300000308_-F） --> 
									<spring:message code="plmmixrecipe.column.mater_code" />
								</td>
								<td>
									<span id="mater_code_s_sp"></span> 
								</td>
								<td bgcolor="#D1E9E9" >
									<!-- 设定重量 --> 
									<spring:message code="plmmixrecipe.column.set_weigh_d" />
								</td>
								<td>
									<span id="set_weigh_d_sp"></span> 
								</td>
								<td bgcolor="#D1E9E9" >
									<!-- 加硫限制 --> 
									<spring:message code="plmmixrecipe.column.dischangetime_i" />
								</td>
								<td>
									<span id="dischangetime_i_sp"></span> 
								</td>
							</tr>
							<tr>
								<td bgcolor="#D1E9E9" >
									<!-- 父物料类型： 母胶(LLMasterBatch) 终炼胶M(LLFinalBatchMPart) --> 
									<spring:message code="plmmixrecipe.column.mater_type" />
								</td>
								<td>
									<span id="mater_type_s_sp"></span> 
								</td>
								<td bgcolor="#D1E9E9" >
									<!-- 炭黑回收类型 --> 
									<spring:message code="plmmixrecipe.column.cb_recycletype" />
								</td>
								<td>
									<span id="cb_recycletype_s_sp"></span> 
								</td>
								<td bgcolor="#D1E9E9" >
									<!-- 工厂代码 --> 
									<spring:message code="plmmixrecipe.column.plant_s" />
								</td>
								<td>
									<span id="plant_s_sp"></span> 
								</td>
							</tr>
							<tr>
								<td bgcolor="#D1E9E9" >
									<!-- 父物料名称 --> 
									<spring:message code="plmmixrecipe.column.mater_name_s" />
								</td>
								<td>
									<span id="mater_name_s_sp"></span> 
								</td>
								<td bgcolor="#D1E9E9" >
									<!-- 炭黑回收时间 --> 
									<spring:message code="plmmixrecipe.column.cb_recycletime_i" />
								</td>
								<td>
									<span id="cb_recycletime_i_sp">
								</td>
								<td bgcolor="#D1E9E9" >
									<!-- 接收时间 --> 
									<spring:message code="plmmixrecipe.column.receive_time_t" />
								</td>
								<td><span id="receive_time_t_sp"></span> 
								</td>
							</tr>
							<tr>
								<td bgcolor="#D1E9E9" >
									<!-- 父物料PLM版本 --> 
									<spring:message code="plmmixrecipe.column.b_version_s" />&emsp;
								</td>
								<td>
									<span id="b_version_s_sp"></span> 
								</td>

								<td bgcolor="#D1E9E9" >
									<!-- 超温最短时间 --> 
									<spring:message code="plmmixrecipe.column.overtemp_mintime_i" />&emsp;
								</td>
								<td>
									<span id="overtemp_mintime_i_sp"></span> 
								</th>

								<td bgcolor="#D1E9E9" >
									<!-- 每车标准时间 --> 
									<spring:message code="plmmixrecipe.column.dummy2_s" />
								</td>
								<td>
									<span id="dummy2_s_sp"></span> 
								</td>
							</tr>
							<tr>
								<td bgcolor="#D1E9E9" >
									<!-- 配方状态 --> 
									<spring:message code="plmmixrecipe.column.recipe_status" />&emsp;
								</td>
								<td>
									<span id="recipe_status_s_sp"></span> 
								</td>
								<td bgcolor="#D1E9E9" >
									<!-- 超时排胶时间 --> 
									<spring:message code="plmmixrecipe.column.overtime_time_i" />&emsp;
								</td>
								<td>
									<span id="overtime_time_i_sp"></span> 
								</td>

								<td bgcolor="#D1E9E9" >
									<!-- 备用3 --> 
									<spring:message code="plmmixrecipe.column.dummy3_s" />&emsp;
								</td>
								<td>
									<span id="dummy3_s_sp"></span> 
								</td>
							</tr>
							<tr>
								<td bgcolor="#D1E9E9" >
									<!-- 父物料工艺PLM版本 --> 
									<spring:message code="plmmixrecipe.column.r_version_s" />
								</td>
								<td>
									<span id="r_version_s_sp"></span> 
								</td>
								<td bgcolor="#D1E9E9" >
									<!-- 紧急排胶温度 --> 
									<spring:message code="plmmixrecipe.column.overtemp_temp_i" />&emsp;
								</td>
								<td>
									<span id="overtemp_temp_i_sp"></span> 
								</td>
								<td bgcolor="#D1E9E9" >
									<!-- 备用4 --> 
									<spring:message code="plmmixrecipe.column.dummy4_s" />&emsp;
								</td>
								<td>
									<span id="dummy4_s_sp">
								</td>
							</tr>
							<tr>
								<td bgcolor="#D1E9E9" >
									<!-- 区分阶段（小试XS、中试ZS、大试DS、投产TC） --> 
									<spring:message code="plmmixrecipe.column.dummy1" />&emsp;
								</td>
								<td>
									<span id="dummy1_s_sp"></span> 
								</td>
								<td bgcolor="#D1E9E9" >
									<!-- 最低进胶温度 --> 
									<spring:message code="plmmixrecipe.column.min_inploytemp_i" />&emsp;
								</td>
								<td>
									<span id="min_inploytemp_i_sp"></span> 
								</td>
								<td bgcolor="#D1E9E9" >
									<!-- 备用5 --> 
									<spring:message code="plmmixrecipe.column.dummy5_s" />&emsp;
								</td>
								<td>
									<span id="dummy5_s_sp"></span> 
								</td>
							</tr>
							<tr>
								<td bgcolor="#D1E9E9" >
									<!-- 是否掺胶：Yes-掺胶、No-不掺胶 --> 
									<spring:message code="plmmixrecipe.column.ismixed" />&emsp;
								</td>
								<td>
									<span id="ismixed_s_sp"></span> 
								</td>
								<td bgcolor="#D1E9E9" >
									<!-- 补偿温度 --> 
									<spring:message code="plmmixrecipe.column.makeup_temp_i" />&emsp;
								</td>
								<td>
									<span id="makeup_temp_i_sp"></span> 
								</td>

								<td bgcolor="#D1E9E9" >
									<!-- mes机台条码 --> 
									<spring:message code="plmmixrecipe.column.mes_equip_code_s" />&emsp;
								</td>
								<td>
									<span id="mes_equip_code_s_sp"></span>
								</td>
							</tr>
							<tr>
								<td bgcolor="#D1E9E9" >
									<!-- 配套 --> 
									<spring:message code="plmmixrecipe.column.matchingcode_s" />&emsp;
								</td>
								<td>
									<span id="matchingcode_s_sp"></span> 
								</td>

								<td bgcolor="#D1E9E9" >
									<!-- 是否使用三区温度：0-不使用、1-使用 --> 
									<spring:message code="plmmixrecipe.column.is_useareatemp" />&emsp;
								</td>
								<td>
									<span id="is_useareatemp_s_sp"></span> 
								</th>
								<td bgcolor="#D1E9E9" >
									<!-- MES机台名称 --> 
									<spring:message code="plmmixrecipe.column.mes_equip_name_s" />&emsp;
								</td>
								<td>
									<span id="mes_equip_name_s"></span>
								</td>
							</tr>
							<tr>
								<td bgcolor="#D1E9E9" >
									<!-- 架子数 --> 
									<spring:message code="plmmixrecipe.column.shelf_num_i" />&emsp;
								</td>
								<td>
									<span id="shelf_num_i_sp"></span> 
								</td>
								<td bgcolor="#D1E9E9" >
									<!-- 侧壁温度 --> 
									<spring:message code="plmmixrecipe.column.side_temp_i" />&emsp;
								</td>
								<td>
									<span id="side_temp_i_sp"></span>
								</td>
								<td bgcolor="#D1E9E9" >
									<!-- 提前量 --> 
									<spring:message code="plmmixrecipe.column.slowdown_weight_d" />&emsp;
								</td>
								<td>
									<span id="slowdown_weight_d"></span>
								</td>
							</tr>
							<tr>
								<td bgcolor="#D1E9E9" >
									<!-- 工艺类型：1-正常、2-返炼、3-洗车、4-返洗、5-正洗 --> 
									<spring:message code="plmmixrecipe.column.routing_type" />&emsp;
								</td>
								<td>
									<span id="routing_type_s_sp"></span> 
								</td>
								<td bgcolor="#D1E9E9" >
									<!-- 转子温度 --> 
									<spring:message code="plmmixrecipe.column.roll_temp_i" />&emsp;
								</td>
								<td>
									<span id="roll_temp_i_sp"></span> 
								</td>
								<td bgcolor="#D1E9E9" >
									<!-- 误差值 --> 
									<spring:message code="plmmixrecipe.column.cutpoly_weight_d" />&emsp;
								</td>
								<td>
									<span id="cutpoly_weight_d"></span>
								</td>
							</tr>
							<tr>
								<td bgcolor="#D1E9E9" >
									<!-- 配方阶段：ZC-正常、SY-不正常 --> 
									<spring:message code="plmmixrecipe.column.prescriptionstage" />&emsp;
								</td>
								<td>
									<span id="prescriptionstage_s_sp">
								</td>
								<td bgcolor="#D1E9E9" >
									<!-- 卸料门温度 --> 
									<spring:message code="plmmixrecipe.column.ddoor_temp_i" />&emsp;
								</td>
								<td>
									<span id="ddoor_temp_i_sp"></span> 
								</td>
								<td>
									<!-- 待填写项目名 -->
								</td>
								<td>
									<!-- 待填写数值 -->
								</td>
							</tr>
						</table>
					</div>
					<div title="PLM密炼称量表" style="padding: 10px">
						<table id="plmmixweightedit_dg" class="easyui-datagrid"
							style="width: 100%"
							data-options="  
						                fit:true,
						                fitColumns:false,
						                pagination:false,
						                rownumbers: false,
						                singleSelect: true,
						                striped:true,
						                onLoadSuccess:onWeightLoadSuccess,
						                rowStyler:setWeightSumRowBgColor,
						                emptyMsg: '<span><spring:message code='tip.noData'/></span>',
						                remoteSort:false,
						                method: 'get'">
							<thead>
								<tr>
									<!-- 称量序号 -->
                    				<th data-options="field:'weight_id_i',width:'120px',editor:{}"><spring:message code="plmmixweight.column.weight_id_i" /></th>
                					<!-- 子物料SAP号：存储9位品号（返回胶、实验胶11位，例如 300000308_-F） -->
                    				<th data-options="field:'child_matercode_s',width:'120px',editor:{}"><spring:message code="plmmixweight.column.child_matercode" /></th>
                					<!-- 子物料名称 -->
                    				<th data-options="field:'child_matername_s',width:'120px',editor:{}"><spring:message code="plmmixweight.column.child_matername_s" /></th>
                					<!-- 重量 -->
                    				<th data-options="field:'set_weight_d',width:'120px',formatter:formatterWeightSetWeight,editor:{type:'textbox'}"><spring:message code="plmmixweight.column.set_weight" /></th>
                					<!-- 小料袋重 -->
                    				<th data-options="field:'dummy1_s',width:'120px',editor:{}"><spring:message code="plmmixweight.column.dummy1" /></th>
                					<!-- 允许误差： 0.3-C.B.-炭黑 0.02-F.L.-粉料 0.1-Oil-油料 2-Poly-返回胶 0.3-Poly-胶料 -->
                    				<th data-options="field:'error_allow_d',width:'120px',editor:{}"><spring:message code="plmmixweight.column.error_allow" /></th>
                					<!-- 子物料版本 -->
                    				<th data-options="field:'bc_version_s',width:'120px',editor:{}"><spring:message code="plmmixweight.column.bc_version_s" /></th>
                					<!-- 子物料供应商代码 -->
                    				<th data-options="field:'supply_code_s',width:'120px',editor:{}"><spring:message code="plmmixweight.column.supply_code_s" /></th>
                					<!-- 配方阶段 332-->
                    				<th data-options="field:'childprescriptionstage_s',width:'120px',formatter:codeFormatter,editor:{}"><spring:message code="plmmixweight.column.childprescriptionstage_s" /></th>
                					<!-- 是否掺胶 333-->
                    				<th data-options="field:'childismixed_s',width:'120px',formatter:codeFormatter,editor:{}"><spring:message code="plmmixweight.column.childismixed_s" /></th>
                					<!-- 投入母胶类型 -->
                    				<th data-options="field:'into_type_s',width:'120px',formatter:codeFormatter,editor:{}"><spring:message code="plmmixweight.column.into_type_s" /></th>
                					<!-- 投入母胶工艺类型  321-->
                    				<th data-options="field:'into_routing_s',width:'120px',formatter:codeFormatter,editor:{}"><spring:message code="plmmixweight.column.into_routing_s" /></th>
                    				<!-- 子物料的粘度标准 -->
                        			<th data-options="field:'viscositystandard_s',width:'120px',editor:{}"><spring:message code="plmmixweight.column.viscositystandard_s" /></th>
                					<!--324 称量类型： 0-炭黑称 1-油料称 2-胶料称 3-小料称 5-油料称2 6-小料用胶料称 7-预分散称 8-一次法返回胶称 9-密炼机粉料称 -->
                    				<th data-options="field:'weight_type_i',width:'120px',formatter:codeFormatter,editor:{}"><spring:message code="plmmixweight.column.weight_type" /></th>
                					<!-- 小料分类属性 -->
                    				<th data-options="field:'weight_prop_s',width:'120px',editor:{}"><spring:message code="plmmixweight.column.weight_prop_s" /></th>
               						<!-- 接收时间 -->
                    				<th data-options="field:'receive_time_t',width:'120px',editor:{}"><spring:message code="plmmixweight.column.receive_time_t" /></th>
                    				<!-- 修改人 -->
                    				<th data-options="field:'changed_by_s',width:'120px',editor:{}"><spring:message code="plmmixweight.column.changed_by_s" /></th>
                    				<!-- 修改时间 -->
                    				<th data-options="field:'changed_time_t',width:'120px',editor:{}"><spring:message code="plmmixweight.column.changed_time_t" /></th>
                    				<!-- 每车标准时间 -->
			                    	<th data-options="field:'dummy2_s',width:'120px',editor:{}"><spring:message code="plmmixweight.column.dummy2_s" /></th>
			                    	<!-- 备用3 -->
			                    	<th data-options="field:'dummy3_s',width:'120px',editor:{}"><spring:message code="plmmixweight.column.dummy3_s" /></th>		
								</tr>
							</thead>
						</table>
					</div>
					<div title="PLM密炼工艺表" style="padding: 10px">
						<table id="plmmixmixedit_dg" class="easyui-datagrid"
							style="width: 100%"
							data-options="  
						               	fit:true,
						                fitColumns:false,
						                pagination:false,
						                rownumbers: false,
						                singleSelect: true,
						                striped:true,
						                remoteSort:false,
						                method: 'get' ,
						                rownumbers:true">
							<thead>
								<tr>
									<!-- 开练机序号 -->
				                    <th data-options="field:'openequip_id_i',width:'120px',editor:{type:'textbox'}"><spring:message code="plmmixmix.column.openequip_id" /></th>
				                    <!-- 步序 -->
				                    <th data-options="field:'mix_id_i',width:'120px',editor:{type:'textbox'}"><spring:message code="plmmixmix.column.mix_id_i" /></th>
				                    <!-- 条件代码 -->
				                    <th data-options="field:'term_code_d',width:'120px',editor:{type:'textbox'}"><spring:message code="plmmixmix.column.term_code_d" /></th>
				                    <!-- 持续时间 -->
				                    <th data-options="field:'set_time_d',width:'120px',editor:{type:'textbox'}"><spring:message code="plmmixmix.column.set_time_d" /></th>
				                    <!-- 温度 -->
				                    <th data-options="field:'set_temp_d',width:'120px',editor:{type:'textbox'}"><spring:message code="plmmixmix.column.set_temp_d" /></th>
				                    <!-- 功率 -->
				                    <th data-options="field:'set_power_d',width:'120px',editor:{type:'textbox'}"><spring:message code="plmmixmix.column.set_power_d" /></th>
				                    <!-- 能量 -->
				                    <th data-options="field:'set_enter_d',width:'120px',editor:{type:'textbox'}"><spring:message code="plmmixmix.column.set_enter_d" /></th>
				                    <!-- 动作代码 -->
				                    <th data-options="field:'act_code_i',width:'120px',editor:{type:'textbox'}"><spring:message code="plmmixmix.column.act_code_i" /></th>
				                    <!-- 压力 -->
				                    <th data-options="field:'set_press_d',width:'120px',editor:{type:'textbox'}"><spring:message code="plmmixmix.column.set_press_d" /></th>
				                    <!-- 转速 -->
				                    <th data-options="field:'set_rota_d',width:'120px',editor:{type:'textbox'}"><spring:message code="plmmixmix.column.set_rota_d" /></th>
				                    <!-- 冷却鼓速度 -->
				                    <th data-options="field:'coolspeed_mix_d',width:'120px',editor:{type:'textbox'}"><spring:message code="plmmixmix.column.coolspeed_mix_d" /></th>
				                    <!-- 开炼机速度 -->
				                    <th data-options="field:'openmixspeed_mix_d',width:'120px',editor:{type:'textbox'}"><spring:message code="plmmixmix.column.openmixspeed_mix_d" /></th>
				                    <!-- 辊距 -->
				                    <th data-options="field:'rollor_mix_d',width:'120px',editor:{type:'textbox'}"><spring:message code="plmmixmix.column.rollor_mix_d" /></th>
				                    <!-- 胶温 -->
				                    <th data-options="field:'rubtemp_mix_d',width:'120px',editor:{type:'textbox'}"><spring:message code="plmmixmix.column.rubtemp_mix_d" /></th>
				                    <!-- 水温 -->
				                    <th data-options="field:'watrtemp_mix_d',width:'120px',editor:{type:'textbox'}"><spring:message code="plmmixmix.column.watrtemp_mix_d" /></th>
				                    <!-- 速差比 -->
				                    <th data-options="field:'speeddiff_mix_d',width:'120px',editor:{type:'textbox'}"><spring:message code="plmmixmix.column.speeddiff_mix_d" /></th>
				                    <!-- 接收时间 -->
				                    <th data-options="field:'receive_time_t',width:'120px',editor:{type:'textbox'}"><spring:message code="plmmixmix.column.receive_time_t" /></th>
								</tr>
							</thead>
						</table>
					</div>	
					<div title="称量范围设定信息" style="padding: 10px">
						<table id="mixrecipeweightrange_dg" class="easyui-datagrid"
							style="width: 100%"
							data-options="  
             	               	fit:true,
						                fitColumns:false,
						                pagination:false,
						                rownumbers: true,
						                singleSelect: true,
						                striped:true,
						                remoteSort:false,
						                method: 'get'  ,
						                rownumbers:true	">
							<thead>
								<tr>
                                    <!-- 调整物料-->
									<th data-options="field:'DICTNAME_S',formatter:materialgroupformatter,width:150"><spring:message code="调整物料" /></th>
									<!-- 物料组-->
									<th data-options="field:'ERPCODE_S',formatter:materialgroupformatter,width:150"><spring:message code="物料组" /></th>
									<!-- 上限-->
									<th data-options="field:'DICTNAME_EN_S' ,editor:{type:'numberbox',options:{required:true,min:0,max:1000,precision:2}},width:60"><spring:message code="上限" /></th>
									<!-- 下限 -->
									<th data-options="field:'DICTNAME_TH_S',editor:{type:'numberbox',options:{required:true,min:0,max:1000,precision:2}},width:60 "><spring:message code="下限" /></th>
									<!-- 更改人姓名 -->
									<th data-options="field:'CHANGED_BY_S' ,width:120"><spring:message code="更新人" /></th>
									<!-- 更新时间 -->
									<th data-options="field:'CHANGED_TIME_T' ,width:130"><spring:message code="更新时间" /></th>
								</tr>
							</thead>
						</table>
					</div>
				</div> 
			</div> 		
    	</div>
    </div>
</body>
</html>
