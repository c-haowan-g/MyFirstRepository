<!-- 

    作者      :栾和源
    时间      :2020-02-24 09:20:21 
    页面名称:X光质检信息明细表
    文件关联:
        CheckXrayDetail.java
        CheckXrayDetailController.java
        CheckXrayDetailServiceImpl.java
        CheckXrayDetailServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="checkxraydetail.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="CheckXrayDetail_dg_toolbar">
            <form id="CheckXrayDetail_search_form" class="form" >
 
                <!-- 条码号 -->
                <spring:message code="checkxraydetail.column.tyrebarcode_s" />：<input name="filter[tyrebarcode_s]" id="tyrebarcode_s" style="width:120px" type="text" class="easyui-textbox" data-options="label:''" > &nbsp;&nbsp;&nbsp;              
                
                <!-- 缺陷ID -->
                <spring:message code="checkxraydetail.column.defectid_s" />：<input name="filter[defectid_s]" id="defectid_s" style="width:120px" type="text" class="easyui-textbox" data-options="label:''" >&nbsp;&nbsp;&nbsp;
                
               	 创建时间：<input name="filter[begin_created_time]" editable="true" id="begin_created_time" type="text" class="easyui-datetimebox" style="width:160px" data-options="label:''">
				到 <input name="filter[end_created_time]" editable="true" id="end_created_time" type="text" class="easyui-datetimebox" style="width:160px" data-options="label:''">&nbsp;&nbsp;&nbsp; 
                
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            
            　
            <auth:button code="XXX"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
        </div>
        <table id="checkxraydetail_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#CheckXrayDetail_dg_toolbar',
                url: '',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    
                     <!-- 条码号 -->
                    <th data-options="field:'tyrebarcode_s',width:80,editor:{type:'textbox'}"><spring:message code="checkxraydetail.column.tyrebarcode_s" /></th>
                    <!-- 检查次数 -->
                    <th data-options="field:'checkseq_i',width:80,editor:{type:'textbox'}"><spring:message code="checkxraydetail.column.checkseq_i" /></th>
                   
                    <!-- 缺陷ID -->
                    <th data-options="field:'defectid_s',width:80,editor:{type:'textbox'}"><spring:message code="checkxraydetail.column.defectid_s" /></th>
                   
                   
                    <!-- 上下模 -->
                    <th data-options="field:'upordown_s',width:80,editor:{type:'textbox'}"><spring:message code="checkxraydetail.column.upordown_s" /></th>
                </tr>
            </thead>
        </table>
    </div>
    
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="CheckXrayDetail_search_form" />
		<jsp:param name="datagridId" value="checkxraydetail_dg" />
		
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.finalcheck.excel.CheckXrayDetailExportHandler" />
		 
		
		<jsp:param name="serviceName" value="CheckXrayDetailServiceImpl" />
	</jsp:include>  
</body>
</html>
