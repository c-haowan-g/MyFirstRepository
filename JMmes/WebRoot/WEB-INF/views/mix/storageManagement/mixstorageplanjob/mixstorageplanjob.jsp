<!-- 

    作者      :陈国强
    时间      :2020-08-18 08:37:07 
    页面名称:盘库计划管理表
    文件关联:
        MixStoragePlanJob.java
        MixStoragePlanJobController.java
        MixStoragePlanJobServiceImpl.java
        MixStoragePlanJobServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="mixstorageplanjob.js.jsp"%>
<script type="text/javascript" src="dict/343,344,347,302.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="MixStoragePlanJob_dg_toolbar">
            <form id="MixStoragePlanJob_search_form" class="form" >
                <!-- 作业日期：YYYYMMDD作业日期 -->
                <spring:message code="mixstorageplanjob.column.job_date_s" />
                <input name="filter[job_date_s]" id="job_date_s" style="with:90px" type="text" class="easyui-datebox" 
                data-options="onChange:filter,formatter:dateFormat,buttons:[],parser:dateParser,label:''" >
                <script type="text/javascript">
					$("#job_date_s").val(new Calendar().format("yyyyMMdd"));
				</script>
                <!-- 作业班次：302001-早班、302002-中班、302003-晚班 -->
                <spring:message code="mixstorageplanjob.column.job_shift_s" />
                <input name="filter[job_shift_s]" id="job_shift_s" style="with:90px" type="text" class="easyui-combotree" 
                data-options="label:'',
                 					 required:false,
				            		 panelHeight:200,
				            		 url:'dict/code/302',
				           			 method:'get',
				            		 onChange:filter" >
                <!-- 盘点区域 -->
                <spring:message code="mixstorageplanjob.column.inventory_area_s" />
                <input name="filter[inventory_area_s]" id="inventory_area_s" style="with:180px" type="text" class="easyui-combotree" 
                data-options="label:'',
                				        required:false,
				              			panelHeight:200,
				              			url:'dict/code/344',
				              			method:'get',
				              			onChange:filter" >
                <!-- 作业状态： 343001-盘库开始 343002-盘库中 343003-盘库结束 343004-对库开始 343005-对库中 343006-对库结束 343007-结存开始 343008-结存结束 343009-作业完成 343010-作业作废 -->
                <spring:message code="mixstorageplanjob.column.job_status_s" />
                <input name="filter[job_status_s]" id="job_status_s" style="with:120px"type="text" class="easyui-combotree" 
                data-options="label:'',				              			 
                					required:false,
				              		panelHeight:200,
				              		url:'dict/code/343',
				              		method:'get',
				              		onChange:filter" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="BAN_GANG_ML_KCGL_MIXSTORAGEPLANJOB_CANCEL"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            <auth:button code="BAN_GANG_ML_KCGL_MIXSTORAGEPLANJOB_REMOVE"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()">计划删除</a></auth:button>
            <auth:button code="BAN_GANG_ML_KCGL_MIXSTORAGEPLANJOB_ADD"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="BAN_GANG_ML_KCGL_MIXSTORAGEPLANJOB_SAVE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <%-- <auth:button code="XXX"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="export()"><spring:message code="button.export" /></a></auth:button> --%>
        </div>
        <table id="mixstorageplanjob_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#MixStoragePlanJob_dg_toolbar',
                url: 'mix/storageManagement/mixStoragePlanJob/datagrid',
                onBeforeLoad:dlg1BeforeLoad,
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
                    			}}"><spring:message code="mixstorageplanjob.column.job_shift_s" /></th> 
					<!-- 盘点区域 -->
					<th
						data-options="field:'inventory_area_s',width:230,formatter:codeFormatter,editor:{type:'combotree',options:{
                    			method:'get',
                    			 labelwidth:'auto',
                                url:'dict/code/343',                              
                    			required:true,
                    			onSelect:oninventoryselect
                    			}}"><spring:message code="mixstorageplanjob.column.inventory_area_s" /></th> 
					<!-- 作业编号 -->
					<th data-options="field:'job_no_s'"><spring:message code="mixstorageplanjob.column.job_no_s" /></th>
					<!-- 作业名称 -->
					<th data-options="field:'job_name_s'"><spring:message code="mixstorageplanjob.column.job_name_s" /></th>
					<!-- 作业状态： 343001-盘库开始 343002-盘库中 343003-盘库结束 343004-对库开始 343005-对库中 343006-对库结束 343007-结存开始 343008-结存结束 343009-作业完成 343010-作业作废 -->
					<th data-options="field:'job_status_s',formatter:codeFormatter"><spring:message code="mixstorageplanjob.column.job_status_s" /></th>
					<!-- 结存标识：0-未处理、1-已处理、2-处理失败 -->
					<th data-options="field:'balance_state_s',formatter:flagformatter"><spring:message code="mixstorageplanjob.column.balance_state_s" /></th> 
					<!-- 结存数量 -->
					<th data-options="field:'balance_qty_f'"><spring:message code="mixstorageplanjob.column.balance_qty_f" /></th>
					<!-- 结存重量 -->
					<th data-options="field:'balance_weight_f'"><spring:message code="mixstorageplanjob.column.balance_weight_f" /></th>
					<!-- 截存标识：0-未处理、1-已处理、2-处理失败 -->
					<th data-options="field:'intercept_state_s',formatter:flagformatter"><spring:message code="mixstorageplanjob.column.intercept_state_s" /></th>
					<!-- 截存计划-数量 -->
					<th data-options="field:'sys_plan_qty_f',width:60"><spring:message code="mixstorageplanjob.column.sys_plan_qty_f" /></th>
					<!-- 截存计划-重量 -->
					<th data-options="field:'sys_plan_weight_f',width:60"><spring:message code="mixstorageplanjob.column.sys_plan_weight_f" /></th>
					<!-- 盘点数量 -->
					<th data-options="field:'inventory_qty_f',width:60"><spring:message code="mixstorageplanjob.column.inventory_qty_f" /></th>
					<!-- 盘点重量 -->
					<th data-options="field:'inventory_weight_f',width:60"><spring:message code="mixstorageplanjob.column.inventory_weight_f" /></th>

					<!-- 对库产出标识：0-未处理、1-已处理、2-处理失败 -->
					<th data-options="field:'check_prod_state_s',formatter:flagformatter"><spring:message code="mixstorageplanjob.column.check_prod_state_s" /></th>
					<!-- 对库产出-数量 -->
					<th data-options="field:'check_prod_qty_f'"><spring:message code="mixstorageplanjob.column.check_prod_qty_f" /></th>
					<!-- 对库产出-重量 -->
					<th data-options="field:'check_prod_weight_f'"><spring:message code="mixstorageplanjob.column.check_prod_weight_f" /></th>
					<!-- 对库退库产出标识：0-未处理、1-已处理、2-处理失败 -->
					<th data-options="field:'check_return_state_s',formatter:flagformatter"><spring:message code="mixstorageplanjob.column.check_return_state_s" /></th>
					<!-- 对库退库-数量 -->
					<th data-options="field:'check_return_qty_f'"><spring:message code="mixstorageplanjob.column.check_return_qty_f" /></th>
					<!-- 对库退库-重量 -->
					<th data-options="field:'check_returnt_weight_f'"><spring:message code="mixstorageplanjob.column.check_returnt_weight_f" /></th>

					<!-- 对库出库标识：0-未处理、1-已处理、2-处理失败 -->
					<th data-options="field:'check_out_state_s',formatter:flagformatter"><spring:message code="mixstorageplanjob.column.check_out_state_s" /></th>
					<!-- 对库出库-数量 -->
					<th data-options="field:'check_out_qty_f'"><spring:message code="mixstorageplanjob.column.check_out_qty_f" /></th>
					<!-- 对库出库-重量 -->
					<th data-options="field:'check_out_weight_f'"><spring:message code="mixstorageplanjob.column.check_out_weight_f" /></th>

					<!-- 截存开始时间 -->
					<th data-options="field:'sys_start_time_t'"><spring:message code="mixstorageplanjob.column.sys_start_time_t" /></th>
					<!-- 截存结束时间 -->
					<th data-options="field:'sys_finish_time_t'"><spring:message code="mixstorageplanjob.column.sys_finish_time_t" /></th>


					<!-- 盘点开始时间 -->
					<th data-options="field:'inventory_start_time_s'"><spring:message code="mixstorageplanjob.column.inventory_start_time_s" /></th>
					<!-- 盘点结束时间 -->
					<th data-options="field:'inventory_finish_time_s'"><spring:message code="mixstorageplanjob.column.inventory_finish_time_s" /></th>

					<!-- 对库产出-开始时间 -->
					<th data-options="field:'check_prod_start_time_t'"><spring:message code="mixstorageplanjob.column.check_prod_start_time_t" /></th>
					<!-- 对库产出-结束时间 -->
					<th data-options="field:'check_prod_finish_time_t'"><spring:message code="mixstorageplanjob.column.check_prod_finish_time_t" /></th>

					<!-- 对库出库-开始时间 -->
					<th data-options="field:'check_out_start_time_t'"><spring:message code="mixstorageplanjob.column.check_out_start_time_t" /></th>
					<!-- 对库出库-结束时间 -->
					<th data-options="field:'check_out_finish_time_t'"><spring:message code="mixstorageplanjob.column.check_out_finish_time_t" /></th>
					<!-- 对库开始时间 -->
					<th data-options="field:'check_start_time_s'"><spring:message code="mixstorageplanjob.column.check_start_time_s" /></th>
					<!-- 对库结束时间 -->
					<th data-options="field:'check_finish_time_s'"><spring:message code="mixstorageplanjob.column.check_finish_time_s" /></th>
					<!-- 创建人姓名 -->
					<th data-options="field:'created_name_s'"><spring:message code="mixstorageplanjob.column.created_name_s" /></th>
					<!-- 创建时间  -->
					<th data-options="field:'created_time_t'"><spring:message code="mixstorageplanjob.column.created_time_t" /> </th>
					<!-- 截存人姓名 -->
					<th data-options="field:'intercept_name_s'"><spring:message code="mixstorageplanjob.column.intercept_name_s" /></th>
					<!-- 截存时间 -->
					<th data-options="field:'intercept_time_t'"><spring:message code="mixstorageplanjob.column.intercept_time_t" /></th>

					<!-- 对库人姓名 -->
					<th data-options="field:'check_name_s'"><spring:message code="mixstorageplanjob.column.check_name_s" /></th>
					<!-- 对库时间 -->
					<th data-options="field:'check_time_t'"><spring:message code="mixstorageplanjob.column.check_time_t" /></th>
					<!-- 结存人姓名 -->
					<th data-options="field:'balance_name_s'"><spring:message code="mixstorageplanjob.column.balance_name_s" /></th>
					<!-- 结存时间  -->
					<th data-options="field:'balance_time_t'"><spring:message code="mixstorageplanjob.column.balance_time_t" /></th>

					<!-- 修改人姓名 -->
					<th data-options="field:'changed_name_s'"><spring:message code="mixstorageplanjob.column.changed_name_s" /></th>
					<!-- 修改时间  -->
					<th data-options="field:'changed_time_t'"><spring:message code="mixstorageplanjob.column.changed_time_t" /></th>
					<!-- 数据来源： 347001-原材料 347002-密炼 347003-半部件 347004-成型 347005-硫化 -->
					<th data-options="field:'datasource_s',formatter:codeFormatter"><spring:message code="mixstorageplanjob.column.datasource_s" /></th>

					<!-- 备用字段1  -->
					<th data-options="field:'spare1_s'"><spring:message code="mixstorageplanjob.column.spare1_s" /></th>
					<!-- 备用字段2 -->
					<th data-options="field:'spare2_s'"><spring:message code="mixstorageplanjob.column.spare2_s" /></th>
					<!-- 备用字段3 -->
					<th data-options="field:'spare3_s'"><spring:message code="mixstorageplanjob.column.spare3_s" /></th>
					<!-- 备用字段4 -->
					<th data-options="field:'spare4_s'"><spring:message code="mixstorageplanjob.column.spare4_s" /></th>
					<!-- 备用字段5 -->
					<th data-options="field:'spare5_s'"><spring:message code="mixstorageplanjob.column.spare5_s" /></th>
					<!-- 备用字段6 -->
					<th data-options="field:'spare6_s'"><spring:message code="mixstorageplanjob.column.spare6_s" /></th>
					<!-- 备用字段7 -->
					<th data-options="field:'spare7_s'"><spring:message code="mixstorageplanjob.column.spare7_s" /></th>
					<!-- 备用字段8 -->
					<th data-options="field:'spare8_s'"><spring:message code="mixstorageplanjob.column.spare8_s" /></th>
					<!-- 备用字段9 -->
					<th data-options="field:'spare9_s'"><spring:message code="mixstorageplanjob.column.spare9_s" /></th>
					<!-- 备用字段10 -->
					<th data-options="field:'spare10_s'"><spring:message code="mixstorageplanjob.column.spare10_s" /></th> 
                   
				</tr>
            </thead>
         </table>
    </div>
</body>
</html>
