<!-- 

    作者      :葛迎祥
    时间      :2020-12-23 13:55:16 
    页面名称:半部件信息修正履历
    文件关联:
        UpdateInfo.java
        UpdateInfoController.java
        UpdateInfoServiceImpl.java
        UpdateInfoServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/meta.jsp"%>
<%@ include file="updateinfo.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="UpdateInfo_dg_toolbar">
            <form id="UpdateInfo_search_form" class="form" >
                <!-- 批次条码 -->
                <spring:message code="updateinfo.column.batchcode_s" />
                <input name="filter[batchcode_s]" id="batchcode_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 部件名称 -->
                <spring:message code="updateinfo.column.halfpartspec_s" />
                <input name="filter[halfpartspec_s]" id="halfpartspec_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 物料编码 -->
                <spring:message code="updateinfo.column.materialcode_s" />
                <input name="filter[materialcode_s]" id="materialcode_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 规格名称 -->
                <spring:message code="updateinfo.column.repairitem_s" />
                <input name="filter[repairitem_s]" id="repairitem_s" type="text" class="easyui-textbox" data-options="label:''" >
                
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            
            <auth:button code="updateinfo.export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="export()"><spring:message code="button.export" /></a></auth:button>
        </div>
        <table id="updateinfo_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#UpdateInfo_dg_toolbar',
                url: 'halfpart/updateinforecord/updateinforecord/datagrid',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 批次条码 -->
                    <th data-options="field:'batchcode_s',editor:{type:'textbox'}"><spring:message code="updateinfo.column.batchcode_s" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changed_by_s',editor:{type:'textbox'}"><spring:message code="updateinfo.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',editor:{type:'textbox'}"><spring:message code="updateinfo.column.changed_time_t" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_s',editor:{type:'textbox'}"><spring:message code="updateinfo.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',editor:{type:'textbox'}"><spring:message code="updateinfo.column.created_time_t" /></th>
                    <!-- 部件名称 -->
                    <th data-options="field:'halfpartspec_s',editor:{type:'textbox'}"><spring:message code="updateinfo.column.halfpartspec_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'materialcode_s',editor:{type:'textbox'}"><spring:message code="updateinfo.column.materialcode_s" /></th>
                    <!-- 新工装条码 -->
                    <th data-options="field:'newbarcode_s',editor:{type:'textbox'}"><spring:message code="updateinfo.column.newbarcode_s" /></th>
                    <!-- 新数量 -->
                    <th data-options="field:'newnumber_s',editor:{type:'textbox'}"><spring:message code="updateinfo.column.newnumber_s" /></th>
                    <!-- 原工装条码 -->
                    <th data-options="field:'oldbarcode_s',editor:{type:'textbox'}"><spring:message code="updateinfo.column.oldbarcode_s" /></th>
                    <!-- 原数量 -->
                    <th data-options="field:'oldnumber_s',editor:{type:'textbox'}"><spring:message code="updateinfo.column.oldnumber_s" /></th>
                </tr>
            </thead>
        </table>
    </div>
</body>
</html>
