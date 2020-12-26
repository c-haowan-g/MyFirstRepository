<!-- 

    作者      :栾和源
    时间      :2020-08-05 08:57:48 
    页面名称:密炼料仓清理履历表
    文件关联:
        SiloclearRecord.java
        SiloclearRecordController.java
        SiloclearRecordServiceImpl.java
        SiloclearRecordServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="siloclearrecord.js.jsp"%>
<script type="text/javascript" src="dict/057,302,075.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="SiloclearRecord_dg_toolbar">
            <form id="SiloclearRecord_search_form" class="form" >
                <!-- 物料编码 -->
                <spring:message code="siloclearrecord.column.material_code_s" />
                <input name="filter[material_code_s]" id="material_code_s" style="width:120px" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 清理时间 -->
                &nbsp;&nbsp;<spring:message code="siloclearrecord.column.clear_time_s" />&nbsp;:&nbsp;<input name="filter[begintime]" editable="true" id="begin_created_time" type="text" class="easyui-datetimebox" style="width:160px" data-options="label:''">
				&nbsp;到&nbsp; <input name="filter[endtime]" editable="true" id="end_created_time" type="text" class="easyui-datetimebox" style="width:160px" data-options="label:''">&nbsp;&nbsp;&nbsp;
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
                <auth:button code="siloclearrecord.export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            </form> 
        </div>
        <table id="siloclearrecord_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#SiloclearRecord_dg_toolbar',
                url: '',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
               		<th data-options="field:'atr_key',checkbox:true">ID</th>
                	<!-- 料仓类型： 057001-密炼机胶架投料口 057002-碎胶机胶架投料口 057003-自动小料 057004-人工小料 057005-一次法小料 057006-油罐 057007-炭黑罐 057008-白炭黑罐 -->
                    <th data-options="field:'silo_type_s',width:'80px',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="siloclearrecord.column.silo_type" /></th>
                	<!-- 机台编码 -->
                    <th data-options="field:'equip_code_s',width:'80px',editor:{type:'textbox'}"><spring:message code="siloclearrecord.column.equip_code_s" /></th>
                    <!-- 料仓号（1、2、3…7） -->
                    <th data-options="field:'silono_s',width:'80px',editor:{type:'textbox'}"><spring:message code="siloclearrecord.column.silono" /></th>
                    <!-- 密炼工单跟踪表，工单号，外键，MX_PP_WO.WO_NO -->
                    <th data-options="field:'wo_no_s',width:'80px',editor:{type:'textbox'}"><spring:message code="siloclearrecord.column.wo_no" /></th>
                    <!-- 密炼生成配方编号 -->
                    <th data-options="field:'recipe_code_s',width:'120px',editor:{type:'textbox'}"><spring:message code="siloclearrecord.column.recipe_code_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',width:'80px',editor:{type:'textbox'}"><spring:message code="siloclearrecord.column.material_code_s" /></th>
                    <!-- 重量 -->
                    <th data-options="field:'weight_s',width:'80px',editor:{type:'textbox'}"><spring:message code="siloclearrecord.column.weight_s" /></th>
                	<!-- 配套供应商编号 -->
                    <th data-options="field:'supplier_code_s',width:'120px',editor:{type:'textbox'}"><spring:message code="siloclearrecord.column.supplier_code_s" /></th>
                	<!-- 班次：302001-早班、302002-中班、302003-晚班 -->
                    <th data-options="field:'shift_code_s',width:'80px',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="siloclearrecord.column.shift_code" /></th>
                	 <!-- 清理人姓名 -->
                    <th data-options="field:'clear_name_s',width:'80px',editor:{type:'textbox'}"><spring:message code="siloclearrecord.column.clear_name_s" /></th>
                    <!-- 清理时间 -->
                    <th data-options="field:'clear_time_s',width:'80px',editor:{type:'textbox'}"><spring:message code="siloclearrecord.column.clear_time_s" /></th>
                    <!-- 数据来源：075001-全钢-万向、075002-全钢-北院、075003-半钢-软控、075004-半钢-万向、075005-人工配料、075006-快检、075007-地磅、075008-密炼产出、075009-MES -->
                    <th data-options="field:'datasource_s',width:'80px',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="siloclearrecord.column.datasource" /></th>
                    <!-- 接收时间 -->
                    <th data-options="field:'receive_time_t',width:'80px',editor:{type:'textbox'}"><spring:message code="siloclearrecord.column.receive_time_t" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_s',editor:{type:'textbox'}"><spring:message code="siloclearrecord.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',width:'80px',editor:{type:'textbox'}"><spring:message code="siloclearrecord.column.created_time_t" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changed_by_s',width:'80px',editor:{type:'textbox'}"><spring:message code="siloclearrecord.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',width:'80px',editor:{type:'textbox'}"><spring:message code="siloclearrecord.column.changed_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
     <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="SiloclearRecord_search_form" />
		<jsp:param name="datagridId" value="siloclearrecord_dg" />	
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.mix.export.SiloclearRecordExportHandler" />
		<jsp:param name="serviceName" value="SiloclearRecordServiceImpl" />
	</jsp:include>  
</body>
</html>
