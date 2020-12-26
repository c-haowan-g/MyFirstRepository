<!-- 

    作者      :徐秉正
    时间      :2020-10-20 17:55:26 
    页面名称:WMS通用履历
    文件关联:
        Wmscommon.java
        WmscommonController.java
        WmscommonServiceImpl.java
        WmscommonServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="wmscommon.js.jsp"%>
<script type="text/javascript" src="dict/253.js"></script>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="Wmscommon_dg_toolbar">
            <form id="Wmscommon_search_form" class="form" >
            <!-- 创建时间 -->
                <spring:message code="wmscommon.column.created_time_t" />:
                  <input name="filter[begin_created_time]" editable="true" id="begin_created_time"
				type="text" class="easyui-datetimebox" style="width:165px"data-options="label:''">
				 &nbsp;&nbsp;&nbsp;到 &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;<input name="filter[end_created_time]" editable="true" id="end_created_time"
				class="easyui-datetimebox" style="width:165px">&nbsp;&nbsp;&nbsp;&nbsp;
				
                <!-- 轮胎条码 -->
                <spring:message code="wmscommon.column.barcode_s" />:
                <input name="filter[barcode_s]" id="barcode_s" type="text" class="easyui-textbox" data-options="label:''" >
                
                <!-- 物料编码 -->
                <spring:message code="wmscommon.column.materialcode_s" />:
                <input name="filter[materialcode_s]" id="materialcode_s" type="text" class="easyui-textbox" data-options="label:''" ><br>
                <!-- 物料规格 -->
                <spring:message code="wmscommon.column.materialspec_s" />:
                <input name="filter[materialspec_s]" id="materialspec_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 创建人 -->
                &nbsp;&nbsp;<spring:message code="wmscommon.column.created_by_s" />:
                <input name="filter[created_by_s]" id="created_by_s" type="text" class="easyui-textbox" data-options="label:''" > 
                
                                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
                
            </form> 
            　
        </div>
        <table id="wmscommon_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#Wmscommon_dg_toolbar',
                url: '',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 轮胎条码 -->
                    <th data-options="field:'barcode_s',width:90,editor:{type:'textbox'}"><spring:message code="wmscommon.column.barcode_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'materialcode_s',width:90,editor:{type:'textbox'}"><spring:message code="wmscommon.column.materialcode_s" /></th>
                    <!-- 物料规格 -->
                    <th data-options="field:'materialspec_s',width:200,editor:{type:'textbox'}"><spring:message code="wmscommon.column.materialspec_s" /></th>
                     <!-- 等级 -->
                    <th data-options="field:'grade_s',formatter:codeFormatter,editor:{type:'textbox',options:{
                   		method:'get',
	                    url:'dict/code/253',
	        			required:true
                    }}"><spring:message code="wmscommon.column.grade_s" /></th>
                    <!-- WMS推送等级 -->
                    <th data-options="field:'grade_wms_s',formatter:codeFormatter,width:90,editor:{type:'textbox',options:{
                   		method:'get',
	                    url:'dict/code/253',
	        			required:true
                    }}"><spring:message code="wmscommon.column.grade_wms_s" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_name',width:90,editor:{type:'textbox'}"><spring:message code="wmscommon.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',width:150,editor:{type:'textbox'}"><spring:message code="wmscommon.column.created_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
</body>
</html>
