<!-- 

    作者      :周志祥
    时间      :2019-03-12 15:18:47 
    页面名称:年周号履历
    文件关联:
        DotRecord.java
        DotRecordController.java
        DotRecordServiceImpl.java
        DotRecordServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="dotrecord.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="DotRecord_dg_toolbar">
            <form id="DotRecord_search_form" class="form" >
                <!-- 创建时间 -->
               <spring:message code="dotrecord.column.created_time_t" />:
               <input name="filter[begin_created_time]" editable="true" id="begin_created_time"
							type="text" class="easyui-datetimebox" style="width:170px"
							data-options="label:''">
						到 <input name="filter[end_created_time]" editable="true" id="end_created_time"
							class="easyui-datetimebox" style="width:170px">
                <!-- 年周号 -->
                <spring:message code="dotrecord.column.dotnum_s" />:
                <input name="filter[dotnum_s]" id="dotnum_s" type="text" class="easyui-textbox"style="width:120px" data-options="label:''" >
                <!-- 机台 -->
                <spring:message code="dotrecord.column.equip_code_s" />:
			   <input name="filter[equip_code_s]" like="true" id="curingequip_code_s" type="text" class="easyui-combobox" data-options="data:jtxx,
                panelHeight:150,
                editable:true,
                valueField:'P_LINE_NAME',
                textField:'P_LINE_NAME',
                selectOnNavigation:false,
                limitToList:true" >
				<spring:message code="dotrecord.column.operator_id_s" />
				<input name="filter[operator_id_s]" id="operator_id_s" like="true" type="text" class="easyui-textbox"style="width:120px" data-options="label:''" >
				<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
           		<auth:button code="dot.export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            </form> 
           </div>
        <table id="dotrecord_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#DotRecord_dg_toolbar',
                 emptyMsg: '<span><spring:message code='tip.noData'/></span>',
                url: '',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 机台 -->
                    <th data-options="field:'equip_code_s',width:80,editor:{type:'textbox'}"><spring:message code="dotrecord.column.equip_code_s" /></th>
        			<!-- 年周号 -->
                    <th data-options="field:'dotnum_s',width:80,editor:{type:'textbox'}"><spring:message code="dotrecord.column.dotnum_s" /></th>
                    <!-- 操作人 -->
                    <th data-options="field:'operator_id_s',width:80,editor:{type:'textbox'}"><spring:message code="dotrecord.column.operator_id_s" /></th>
             		<!-- 操作时间 -->
                    <th data-options="field:'operator_time_t',width:80,editor:{type:'textbox'}"><spring:message code="dotrecord.column.operator_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
     <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="DotRecord_search_form" />
		<jsp:param name="datagridId" value="dotrecord_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.curing.excel.DotRecordExportHandler" />
		<jsp:param name="serviceName" value="DotRecordServiceImpl" />
	</jsp:include>
</body>
</html>
