<!-- 

    作者      :陈国强
    时间      :2020-08-20 08:13:07 
    页面名称:盘库结果管理
    文件关联:
        MixStoragePlanResult.java
        MixStoragePlanResultController.java
        MixStoragePlanResultServiceImpl.java
        MixStoragePlanResultServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="mixstorageplanresult.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="MixStoragePlanResult_dg_toolbar">
            <form id="MixStoragePlanResult_search_form" class="form" >
                <!-- 作业名称 -->
                <spring:message code="mixstorageplanresult.column.job_name_s" />
                <input name="filter[job_name_s]" id="job_name_s" type="text" class="easyui-combobox" 
                data-options="label:'',
                					data:jobnamelist,
	         		   				panelHeight:150,
	         		   				editable:true,
	           		   				valueField:'JOB_NAME_S',
	          		    			textField:'JOB_NAME_S',
	                   				selectOnNavigation:false,
	           		   				limitToList:true">
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form>
             	<auth:button code="BAN_GANG_ML_KCGL_STOCK_MANAGEMENT_PLANRESULT_PEN"><a class="easyui-linkbutton btn-black"
						data-options="iconCls:'icon-pen'" onclick="lock()">推算结存</a></auth:button>
				<auth:button code="BAN_GANG_ML_KCGL_STOCK_MANAGEMENT_PLANRESULT_SAVE"><a class="easyui-linkbutton btn-black"
						data-options="iconCls:'icon-save'" onclick="onsave()">保存结存</a></auth:button> 
            <%-- <auth:button code="XXX"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            　
            <auth:button code="XXX"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button> --%>
            　
            <auth:button code="XXX"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="export()"><spring:message code="button.export" /></a></auth:button>
        </div>
        <table id="mixstorageplanresult_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#MixStoragePlanResult_dg_toolbar',
                url: 'mix/storageManagement/mixStoragePlanResult/datagrid',
                striped:true,
                method: 'get' 
                ">
            <thead>
            	<tr>
					<th data-options="field:'atr_key',checkbox:true" rowspan="2"></th>
					<th colspan="3"><strong>基本信息</strong></th>
					<th colspan="2"><strong>入库量</strong></th>
					<th colspan="2"><strong>退库量</strong></th>
					<th colspan="2"><strong>期初结存</strong></th>
					<th colspan="2"><strong>出库量</strong></th>
					<th colspan="2"><strong>期末结存</strong></th>
					<th colspan="2"><strong>系统结存</strong></th>
					
				</tr>
                <tr>
                    <!-- <th data-options="field:'atr_key',checkbox:true">ID</th> -->
                    <!-- 物料组 -->
                    <th data-options="field:'material_group_s',editor:{type:'textbox'}"><spring:message code="mixstorageplanresult.column.material_group_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',editor:{type:'textbox'}"><spring:message code="mixstorageplanresult.column.material_code_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'material_name_s',editor:{type:'textbox'}"><spring:message code="mixstorageplanresult.column.material_name_s" /></th>
                    <!-- 生产数量 -->
                    <th data-options="field:'prod_qty_f',editor:{type:'textbox'}"><spring:message code="mixstorageplanresult.column.prod_qty_f" /></th>
                    <!-- 生产重量 -->
                    <th data-options="field:'prod_weight_f',editor:{type:'textbox'}"><spring:message code="mixstorageplanresult.column.prod_weight_f" /></th>
                    <!-- 退库数量 -->
                    <th data-options="field:'return_qty_f',editor:{type:'textbox'}"><spring:message code="mixstorageplanresult.column.return_qty_f" /></th>
                    <!-- 退库重量 -->
                    <th data-options="field:'return_weight_f',editor:{type:'textbox'}"><spring:message code="mixstorageplanresult.column.return_weight_f" /></th>
                    <!-- 期初结存-数量 -->
                    <th data-options="field:'ini_qty_f',editor:{type:'textbox'}"><spring:message code="mixstorageplanresult.column.ini_qty_f" /></th>
                    <!-- 期初结存-重量 -->
                    <th data-options="field:'ini_weight_f',editor:{type:'textbox'}"><spring:message code="mixstorageplanresult.column.ini_weight_f" /></th>
                    <!-- 使用数量 -->
                    <th data-options="field:'use_qty_f',editor:{type:'textbox'}"><spring:message code="mixstorageplanresult.column.use_qty_f" /></th>
                    <!-- 使用重量 -->
                    <th data-options="field:'use_weight_f',editor:{type:'textbox'}"><spring:message code="mixstorageplanresult.column.use_weight_f" /></th>
                    <!-- 期末结存-数量 -->
                    <th data-options="field:'end_qty_f',editor:{type:'textbox'}"><spring:message code="mixstorageplanresult.column.end_qty_f" /></th>
                    <!-- 期末结存-重量 -->
                    <th data-options="field:'end_weight_f',editor:{type:'textbox'}"><spring:message code="mixstorageplanresult.column.end_weight_f" /></th>
                    <!-- 系统结存-数量 -->
                    <th data-options="field:'sys_qty_f',editor:{type:'textbox'}"><spring:message code="mixstorageplanresult.column.sys_qty_f" /></th>
                    <!-- 系统结存-重量 -->
                    <th data-options="field:'sys_weight_f',editor:{type:'textbox'}"><spring:message code="mixstorageplanresult.column.sys_weight_f" /></th>
                    <%-- <!-- 机构编号： 柳州 8003 -->
                    <th data-options="field:'agenc_no_s',editor:{type:'textbox'}"><spring:message code="mixstorageplanresult.column.agenc_no_s" /></th>
                    <!-- 归档标记 -->
                    <th data-options="field:'arch_flag_s',editor:{type:'textbox'}"><spring:message code="mixstorageplanresult.column.arch_flag_s" /></th>
                    <!-- 单位  -->
                    <th data-options="field:'baseunit_s',editor:{type:'textbox'}"><spring:message code="mixstorageplanresult.column.baseunit_s" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changed_by_s',editor:{type:'textbox'}"><spring:message code="mixstorageplanresult.column.changed_by_s" /></th>
                    <!-- 修改人姓名 -->
                    <th data-options="field:'changed_name_s',editor:{type:'textbox'}"><spring:message code="mixstorageplanresult.column.changed_name_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',editor:{type:'textbox'}"><spring:message code="mixstorageplanresult.column.changed_time_t" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_s',editor:{type:'textbox'}"><spring:message code="mixstorageplanresult.column.created_by_s" /></th>
                    <!-- 创建人姓名 -->
                    <th data-options="field:'created_name_s',editor:{type:'textbox'}"><spring:message code="mixstorageplanresult.column.created_name_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',editor:{type:'textbox'}"><spring:message code="mixstorageplanresult.column.created_time_t" /></th>
                    <!-- 数据来源： 347001-原材料 347002-密炼 347003-半部件 347004-成型 347005-硫化 -->
                    <th data-options="field:'datasource_s',editor:{type:'textbox'}"><spring:message code="mixstorageplanresult.column.datasource_s" /></th>
                    <!-- 主键ID -->
                    <th data-options="field:'id_s',editor:{type:'textbox'}"><spring:message code="mixstorageplanresult.column.id_s" /></th>
                    <!-- 作业名称 -->
                    <th data-options="field:'job_name_s',editor:{type:'textbox'}"><spring:message code="mixstorageplanresult.column.job_name_s" /></th>
                    <!-- 盘库计划管理表作业号：外键，CM_WH_ITEM_INV_JOB.JOB_NO -->
                    <th data-options="field:'job_no_s',editor:{type:'textbox'}"><spring:message code="mixstorageplanresult.column.job_no_s" /></th>
                    <!-- 记录标志：A-可用，D-删除 -->
                    <th data-options="field:'record_flag_s',editor:{type:'textbox'}"><spring:message code="mixstorageplanresult.column.record_flag_s" /></th>
                    <!-- 备用字段10 -->
                    <th data-options="field:'spare10_s',editor:{type:'textbox'}"><spring:message code="mixstorageplanresult.column.spare10_s" /></th>
                    <!-- 备用字段1 -->
                    <th data-options="field:'spare1_s',editor:{type:'textbox'}"><spring:message code="mixstorageplanresult.column.spare1_s" /></th>
                    <!-- 备用字段2 -->
                    <th data-options="field:'spare2_s',editor:{type:'textbox'}"><spring:message code="mixstorageplanresult.column.spare2_s" /></th>
                    <!-- 备用字段3 -->
                    <th data-options="field:'spare3_s',editor:{type:'textbox'}"><spring:message code="mixstorageplanresult.column.spare3_s" /></th>
                    <!-- 备用字段4 -->
                    <th data-options="field:'spare4_s',editor:{type:'textbox'}"><spring:message code="mixstorageplanresult.column.spare4_s" /></th>
                    <!-- 备用字段5 -->
                    <th data-options="field:'spare5_s',editor:{type:'textbox'}"><spring:message code="mixstorageplanresult.column.spare5_s" /></th>
                    <!-- 备用字段6 -->
                    <th data-options="field:'spare6_s',editor:{type:'textbox'}"><spring:message code="mixstorageplanresult.column.spare6_s" /></th>
                    <!-- 备用字段7 -->
                    <th data-options="field:'spare7_s',editor:{type:'textbox'}"><spring:message code="mixstorageplanresult.column.spare7_s" /></th>
                    <!-- 备用字段8 -->
                    <th data-options="field:'spare8_s',editor:{type:'textbox'}"><spring:message code="mixstorageplanresult.column.spare8_s" /></th>
                    <!-- 备用字段9 -->
                    <th data-options="field:'spare9_s',editor:{type:'textbox'}"><spring:message code="mixstorageplanresult.column.spare9_s" /></th>
                    <!-- 工厂：1-全钢、2-半钢 -->
                    <th data-options="field:'s_factory_s',editor:{type:'textbox'}"><spring:message code="mixstorageplanresult.column.s_factory_s" /></th>
                     --%>
                </tr>
            </thead>
        </table>
    </div>
</body>
</html>
