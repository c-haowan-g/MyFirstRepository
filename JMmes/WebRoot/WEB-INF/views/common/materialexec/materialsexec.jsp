<!-- 

    作者      :陈国强
    时间      :2020-09-07 10:04:40 
    页面名称:SAP物料主数据执行历史表
    文件关联:
        MaterialsExec.java
        MaterialsExecController.java
        MaterialsExecServiceImpl.java
        MaterialsExecServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/meta.jsp"%>
<%@ include file="materialsexec.js.jsp"%>
<script type="text/javascript" src="dict/-304,-308.js"></script>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="MaterialsExec_dg_toolbar">
            <form id="MaterialsExec_search_form" class="form" >
            <input type="radio" name="dummy4_s" value="real_time">
                实时时间
                <input type="radio" name="dummy4_s" value="his_time" checked>
                历史时间
                <!-- 同步时间 -->
                <spring:message code="materialsexec.column.sync_create_time_t" />
                <%--<input name="filter[sync_create_time_t]" id="sync_create_time_t" type="text" class="easyui-textbox" data-options="label:''" >--%>
                <input name="filter[start_time]" id="start_time" type="text" class="easyui-datetimebox" data-options="label:''" >
                <spring:message code="tip.to" /><input name="filter[end_time]" id="end_time" type="text" class="easyui-datetimebox" data-options="label:''" >
                <!-- 物料编号80位 -->
                <spring:message code="materialsexec.column.materialcode_s" />
                <input name="filter[materialcode_s]" id="materialcode_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 物料描述 -->
                <spring:message code="materialsexec.column.materialdesc_s" />
                <input name="filter[materialdesc_s]" id="materialdesc_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 规格 -->
                <spring:message code="materialsexec.column.materialspec_s" />
                <input name="filter[materialspec_s]" id="materialspec_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 物料类型 -->
                <spring:message code="materialsexec.column.mattyp_s" />
                <input name="filter[mattyp_s]" id="mattyp_s" type="text" class="easyui-combotree" 
                data-options="label:'',
                                required:false,
				              	panelHeight:200,
				              	url:'dict/code/-304',
				              	method:'get'" >
                <!-- 物料组 -->
                <spring:message code="materialsexec.column.matgrp_s" />
                <input name="filter[matgrp_s]" id="matgrp_s" type="text" class="easyui-combotree" 
                data-options="label:'',
                				editable:true,
				              	panelHeight:200,
				              	url:'dict/code/-308',
				              	method:'get'" >
                
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <%-- <auth:button code="XXX"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            　
            <auth:button code="XXX"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            　
            <auth:button code="XXX"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="export()"><spring:message code="button.export" /></a></auth:button> --%>
        </div>
        <table id="materialsexec_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#MaterialsExec_dg_toolbar',
                <!-- url: 'common/materialexec/materialsexec/datagrid', -->
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 数据同步处理：A-新增、U-修改、D-删除 -->
                    <th data-options="field:'sync_flag_s',formatter:syncFlag,editor:{type:'textbox'}"><spring:message code="materialsexec.column.sync_flag_s" /></th>
                    <!-- 数据同步处理标记：0-未处理、1-已处理 -->
                    <th data-options="field:'sync_hand_flag_s',formatter:syncHandFlag,editor:{type:'textbox'}"><spring:message code="materialsexec.column.sync_hand_flag_s" /></th>
                    <!-- 数据同步处理反馈 -->
                    <th data-options="field:'sync_hand_msg_s',editor:{type:'textbox'}"><spring:message code="materialsexec.column.sync_hand_msg_s" /></th>
                    <!-- 数据同步处理时间 -->
                    <th data-options="field:'sync_hand_time_t',editor:{type:'textbox'}"><spring:message code="materialsexec.column.sync_hand_time_t" /></th>
                    <!-- 物料编号80位 -->
                    <th data-options="field:'materialcode_s',editor:{type:'textbox'}"><spring:message code="materialsexec.column.materialcode_s" /></th>
                    <!-- 物料描述 -->
                    <th data-options="field:'materialdesc_s',editor:{type:'textbox'}"><spring:message code="materialsexec.column.materialdesc_s" /></th>
                    <!-- 物料类型 -->
                    <th data-options="field:'mattyp_s',editor:{type:'textbox'}"><spring:message code="materialsexec.column.mattyp_s" /></th>
                    <!-- 物料组 -->
                    <th data-options="field:'matgrp_s',editor:{type:'textbox'}"><spring:message code="materialsexec.column.matgrp_s" /></th>
                    <!-- 规格 -->
                    <th data-options="field:'materialspec_s',editor:{type:'textbox'}"><spring:message code="materialsexec.column.materialspec_s" /></th>
                    <!-- 花纹 -->
                    <th data-options="field:'pattern_s',editor:{type:'textbox'}"><spring:message code="materialsexec.column.pattern_s" /></th>
                    <!-- 层级 -->
                    <th data-options="field:'cj_s',editor:{type:'textbox'}"><spring:message code="materialsexec.column.cj_s" /></th>
                    <!-- 净重 -->
                    <th data-options="field:'netheavy_f',editor:{type:'textbox'}"><spring:message code="materialsexec.column.netheavy_f" /></th>
                    <!-- 基本计量单位 -->
                    <th data-options="field:'baseunit_s',editor:{type:'textbox'}"><spring:message code="materialsexec.column.baseunit_s" /></th>
                    <!-- 工厂特定的物料状态：01-因采购/仓库二被冻结、02-因任务清单/BOM而被冻结、Z1-冻结物料，只能库存收发货、Z2-冻结物料，不允许所有、作、Z3-冻结物料，只能库存收发货和采购 -->
                    <th data-options="field:'matstatus_s',formatter:matStatus,editor:{type:'textbox'}"><spring:message code="materialsexec.column.matstatus_s" /></th>
                    <!-- 特殊采购类型  -->
                    <th data-options="field:'sobsl_s',editor:{type:'textbox'}"><spring:message code="materialsexec.column.sobsl_s" /></th>
                    <!-- 商品名称 -->
                    <th data-options="field:'spmc_s',editor:{type:'textbox'}"><spring:message code="materialsexec.column.spmc_s" /></th>
                    <!-- 跨工厂物料状态：01-因采购/仓库二被冻结、02-因任务清单/BOM而被冻结、Z1-冻结物料，只能库存收发货、Z2-冻结物料，不允许所有、作、Z3-冻结物料，只能库存收发货和采购 -->
                    <th data-options="field:'status_s',formatter:Status,editor:{type:'textbox'}"><spring:message code="materialsexec.column.status_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'ctime_s',editor:{type:'textbox'}"><spring:message code="materialsexec.column.ctime_s" /></th>
                    <!-- 同步时间 -->
                    <th data-options="field:'sync_create_time_t',editor:{type:'textbox'}"><spring:message code="materialsexec.column.sync_create_time_t" /></th>
                    <!-- 预留1 -->
                    <th data-options="field:'dummy1_s',editor:{type:'textbox'}"><spring:message code="materialsexec.column.dummy1_s" /></th>
                    <!-- 预留2 -->
                    <th data-options="field:'dummy2_s',editor:{type:'textbox'}"><spring:message code="materialsexec.column.dummy2_s" /></th>
                    <!-- 预留3 -->
                    <th data-options="field:'dummy3_s',editor:{type:'textbox'}"><spring:message code="materialsexec.column.dummy3_s" /></th>
                    <!-- 预留4 -->
                    <th data-options="field:'dummy4_s',editor:{type:'textbox'}"><spring:message code="materialsexec.column.dummy4_s" /></th>
                   
                </tr>
            </thead>
        </table>
    </div>
</body>
</html>
