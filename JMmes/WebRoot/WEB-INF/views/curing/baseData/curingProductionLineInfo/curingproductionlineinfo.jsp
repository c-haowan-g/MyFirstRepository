<!-- 

    作者      :司乔靖
    时间      :2019-07-13 09:55:26 
    页面名称:硫化机台信息管理
    文件关联:
        CuringProductionLineInfo.java
        CuringProductionLineInfoController.java
        CuringProductionLineInfoServiceImpl.java
        CuringProductionLineInfoServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="curingproductionlineinfo.js.jsp"%>

<script type="text/javascript" src="dict/211,214.js"></script>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="CuringProductionLineInfo_dg_toolbar">
            <form id="CuringProductionLineInfo_search_form" class="form" >
                <!-- 机台编码 -->
                <spring:message code="curingproductionlineinfo.column.p_line_name" />&nbsp;:
                <input name="filter[p_line_name]" id="p_line_name" type="text" like="true" class="easyui-textbox" data-options="label:'', width:'140px'" >
                <!-- 机台名称 -->
                <spring:message code="curingproductionlineinfo.column.description_s" />&nbsp;:
                <input name="filter[description]" id="description" type="text" like="true" class="easyui-textbox" data-options="label:'', width:'140px'" >
                <!-- 机台状态 -->
                <spring:message code="curingproductionlineinfo.column.status_s" />&nbsp;:
                <input name="filter[status_s]" id="status_s" type="text" like="true" class="easyui-combotree" data-options="
                	label:'', 
                	width:'140px',
                	required:false,
          			panelHeight:200,
          			url:'dict/code/214',
          			method:'get'" >
          		<!-- 机台名称 -->
                <spring:message code="curingproductionlineinfo.column.ip_s" />&nbsp;:
                <input name="filter[ip_s]" id="ip_s" type="text" like="true" class="easyui-textbox" data-options="label:'', width:'140px'" >
                
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="curingproductionlineinfo.add"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="curingproductionlineinfo.edit"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="curingproductionlineinfo.remove"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            　
            <auth:button code="curingproductionlineinfo.save"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="curingproductionlineinfo.no"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            　
            <auth:button code="curingproductionlineinfo.export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            <auth:button code="curingproductionlineinfo.showOrHide"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="queryBar()"><spring:message code="button.searchColumn" /></a></auth:button>
        </div>
        <table id="curingproductionlineinfo_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#CuringProductionLineInfo_dg_toolbar',
                url: 'curing/baseData/curingProductionLineInfo/datagridUDA2',
                striped:true,
                method: 'get', 
                emptyMsg: '<span><spring:message code='tip.noData'/></span>' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'p_line_key',checkbox:true"></th>
                    <!-- 机台代码 -->
                    <th data-options="field:'p_line_name',width:90,sortable:true,editor:{type:'textbox',options:{required:true,onChange:setProdutionLineInfo}}"><spring:message code="curingproductionlineinfo.column.p_line_name" /></th>
                    <!-- 机台名称 -->
                    <th data-options="field:'description',width:70,sortable:true,editor:{type:'textbox',options:{disabled:true}}" ><spring:message code="curingproductionlineinfo.column.description_s" /></th>
                    <!-- 机台类型 -->
                    <th data-options="field:'category',width:100,sortable:true,formatter:codeFormatter,editor:{type:'combotree',options:{
                    			method:'get',
                                url:'dict/code/211',
                                labelwidth:'auto',
                    			required:true,
                    			disabled:true
                    			}}"><spring:message code="curingproductionlineinfo.column.category" /></th>
                    <!-- 机台组 全钢（基础数据167） 半钢（基础数据171） -->
                    <th data-options="field:'machinegroup_s',width:60,sortable:true,editor:{type:'textbox',options:{disabled:true}}"><spring:message code="curingproductionlineinfo.column.machinegroup_s" /></th>
                    <!-- 机台状态 214-->
                    <th data-options="field:'status_s',width:80,sortable:true,formatter:codeFormatter,editor:{type:'combotree',options:{
                    			method:'get',
                                url:'dict/code/214',
                                labelwidth:'auto',
                    			required:true
                    			}}"><spring:message code="curingproductionlineinfo.column.status_s" /></th>
                    <!-- 机台IP -->
                    <th data-options="field:'ip_s',width:110,sortable:true,editor:{type:'textbox',options:{required:true}}"><spring:message code="curingproductionlineinfo.column.ip_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changetime_t',width:125,sortable:true,editor:{}"><spring:message code="curingproductionlineinfo.column.changetime_t" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changed_by_name_s',width:50,sortable:true,editor:{}"><spring:message code="curingproductionlineinfo.column.changeby_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'createtime_t',width:125,sortable:true,editor:{}"><spring:message code="curingproductionlineinfo.column.createtime_t" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_name_s',width:50,sortable:true,editor:{}"><spring:message code="curingproductionlineinfo.column.createby_s" /></th>
                </tr>
            </thead>
        </table>
    </div>
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="CuringProductionLineInfo_search_form" />
		<jsp:param name="datagridId" value="curingproductionlineinfo_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.curing.excel.CuringProductionLineInfoExportHandler" />
		<jsp:param name="serviceName" value="CuringProductionLineInfoServiceImpl" />
	</jsp:include> 
</body>
</html>
