<!-- 

    作者      :李新宇
    时间      :2020-04-15 10:51:34 
    页面名称:X光质检信息日志查询
    文件关联:
        CheckxrayResultlog.java
        CheckxrayResultlogController.java
        CheckxrayResultlogServiceImpl.java
        CheckxrayResultlogServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="checkxrayresultlog.js.jsp"%>
<script src="dict/253,302.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="CheckxrayResultlog_dg_toolbar">
            <form id="CheckxrayResultlog_search_form" class="form" >
                <!-- 检测时间 -->
                <spring:message code="checkxrayresultlog.column.checktime_s" /> : <input name="filter[start_checktime]" id="start_checktime" type="text" class="easyui-datetimebox" data-options="" >
                <spring:message code="tip.to" /> <input name="filter[end_checktime_s]" id="end_checktime_s" type="text" class="easyui-datetimebox" data-options="" >
                <!-- 设备ID -->
                <spring:message code="checkxrayresultlog.column.equipid_s" /> :
                <input type="text" class="easyui-combobox" style="width:120px" name="filter[equipid_s]" id="equipid_s" style="width:120px"
                       data-options="
							required:false,
	                		width:200,
	                		data:entCodeName,
				   			method: 'get',
				   			url:'finalcheck/baseData/entmodel/SearchEnt?equip_type=254003',
				   			panelHeight:200,
				    		valueField:'EQUIP_NAME',
				    		textField:'DESCRIPTION'
				    		">
                <!-- 条码号 -->
                <spring:message code="checkxrayresultlog.column.tyrebarcode_s" /> : <input name="filter[tyrebarcode_s]" id="tyrebarcode_s" type="text" class="easyui-textbox" data-options="" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="XXX"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="ZJ_ZJLL_QUAN_GANG_XRAY_LOG_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
        </div>
        <table id="checkxrayresultlog_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#CheckxrayResultlog_dg_toolbar',
                url: '',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                   <!-- 检查次数 -->
                    <th data-options="field:'checkseq_i',editor:{type:'textbox'}"><spring:message code="checkxrayresultlog.column.checkseq_i" /></th>
                    <!-- 检测时间 -->
                    <th data-options="field:'checktime_s',editor:{type:'textbox'}"><spring:message code="checkxrayresultlog.column.checktime_s" /></th>
                    <!-- 设备ID -->
                    <th data-options="field:'equipid_s',editor:{type:'textbox'}"><spring:message code="checkxrayresultlog.column.equipid_s" /></th>
                    <!-- 检测等级 -->
                    <th formatter="codeFormatter" data-options="field:'gradeid_s',editor:{type:'textbox'}"><spring:message code="checkxrayresultlog.column.gradeid_s" /></th>
                    <!-- X光图片名称 -->
                    <th data-options="field:'imagename_s',editor:{type:'textbox'}"><spring:message code="checkxrayresultlog.column.imagename_s" /></th>
                    <!-- X光图片存储路径 -->
                    <th data-options="field:'imagesavepath_s',editor:{type:'textbox'}"><spring:message code="checkxrayresultlog.column.imagesavepath_s" /></th>
                    <!-- 消息提示 -->
                    <th data-options="field:'logmeg_s',editor:{type:'textbox'}"><spring:message code="checkxrayresultlog.column.logmeg_s" /></th>
                    <!-- 条码号 -->
                    <th data-options="field:'tyrebarcode_s',editor:{type:'textbox'}"><spring:message code="checkxrayresultlog.column.tyrebarcode_s" /></th>
                    <!-- 检测人员ID -->
                    <th data-options="field:'user_name',editor:{type:'textbox'}"><spring:message code="checkxrayresultlog.column.userid_s" /></th>
                    <!-- 检测人员班次 -->
                    <th formatter="codeFormatter" data-options="field:'usershift_s',editor:{type:'textbox'}"><spring:message code="checkxrayresultlog.column.usershift_s" /></th>
                </tr>
            </thead>
        </table>
    </div>


    <jsp:include page="../../../../inc/export.jsp">
        <jsp:param name="idField" value="atr_key" />
        <jsp:param name="formId" value="CheckxrayResultlog_search_form" />
        <jsp:param name="datagridId" value="checkxrayresultlog_dg" />
        <jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.finalcheck.excel.CheckxrayResultlogExportHandler"/>
        <jsp:param name="serviceName" value="finalcheck" />
    </jsp:include>
</body>
</html>
