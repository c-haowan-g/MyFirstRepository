<!-- 

    作者      :lnk
    时间      :2019-01-04 16:06:03 
    页面名称:质检X关分拣履历表
    文件关联:
        SortXRaylog.java
        SortXRaylogController.java
        SortXRaylogServiceImpl.java
        SortXRaylogServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="sortxraylog.js.jsp"%>
<script type="text/javascript" src="dict/252,259,260,253.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="SortXRaylog_dg_toolbar">
            <form id="SortXRaylog_search_form" class="form" >
               <!-- 轮胎条码：MainTyre 表 BARCODE -->
               <spring:message code="sortxraylog.column.barcode_s" />:
                <input name="filter[barcode_s]" id="barcode_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 品号 -->
                <spring:message code="sortxraylog.column.itemid_s" />:
                <input name="filter[itemid_s]" id="changed_by_s" type="text" class="easyui-textbox" data-options="label:''" >
                <spring:message code="sortappearancelog.column.sorttime_t" />:	
                <input name="filter[begin_created_time]" editable="true" id="begin_created_time"
							type="text" class="easyui-datetimebox" style="width:170px"
							data-options="label:''">
						到 <input name="filter[end_created_time]" editable="true" id="end_created_time"
							class="easyui-datetimebox" style="width:170px">
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
                <auth:button code="XXX"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            </form> 
           
        </div>
        <table id="sortxraylog_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#SortXRaylog_dg_toolbar',
                url: '',
                striped:true,
                method: 'get' ,
                 emptyMsg:'<span><spring:message code='tip.noData'/></span>',
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                   	<!-- 轮胎条码：MainTyre 表 BARCODE -->
                    <th data-options="field:'barcode_s',editor:{type:'textbox'}"><spring:message code="sortxraylog.column.barcode_s" /></th>
                      <!-- 品号 -->
                    <th data-options="field:'itemid_s',editor:{type:'textbox'}"><spring:message code="sortxraylog.column.itemid_s" /></th>
                    <!-- 工序 -->
                     <th data-options="field:'proess_i',formatter:codeFormatter,editor:{type:'combotree',options:
                                {
                                method:'get',
                                 data:DICT_252}}"><spring:message code="sortxraylog.column.proess_i" /></th>
                     <!-- 质量等级编码 -->
                    <th data-options="field:'gradecd_i',formatter:codeFormatter,editor:{type:'combotree',options:
                                {
                                method:'get',
                                 data:DICT_253}}">
					<spring:message code="sortxraylog.column.gradecode_i" /></th>
                    
                     <!-- 分拣去向：D_EM_Ent 表 ID -->
                    <th data-options="field:'sortmachinebar_s',width:120,editor:{type:'textbox'}"><spring:message code="sortxraylog.column.sortmachinebar_s" /></th>
                    <!-- 实际去向：D_EM_Ent 表 ID -->
                    <th data-options="field:'realmachinebar_s',width:120,editor:{type:'textbox'}"><spring:message code="sortxraylog.column.realmachinebar_s" /></th>
                    <!-- 分拣点：0-割毛前、1-外观前、2-外观后、3-X光后、4-动平衡前、5-入库前 -->
                    <th data-options="field:'sorttype_i',formatter:codeFormatter,editor:{type:'combotree',options:
									{
									method:'get',
									 data:DICT_260}}">
						<spring:message code="sortxraylog.column.sorttype_i" /></th>
                  
                    <!-- MES校验是否成功：0-失败，1-成功 -->
                    <th data-options="field:'isok_i',formatter:isokFormatter,width:120,editor:{type:'textbox'}"><spring:message code="sortxraylog.column.isok_i" /></th>
                    <!-- MES校验错误类型 -->
                    <th data-options="field:'etype_i',formatter:codeFormatter,editor:{type:'combotree',options:
                                {
                                method:'get',
                                 data:DICT_259}}">
					<spring:message code="sortxraylog.column.etype_i" /></th>
                     <!-- MES备注 -->
                    <th data-options="field:'remark_s',width:80,editor:{type:'textbox'}"><spring:message code="sortxraylog.column.remark_s" /></th>
                     <!-- 工控下发是否成功：0-成功、1-失败 -->
                    <th data-options="field:'writein_i',formatter:writeinFormatter,width:80,editor:{type:'textbox'}"><spring:message code="sortxraylog.column.writein_i" /></th>
               		<!-- 工控下发备注 -->
                    <th data-options="field:'writeinremark_s',width:80,editor:{type:'textbox'}"><spring:message code="sortxraylog.column.writeinremark_s" /></th>
                     <!-- 操作时间 -->
                    <th data-options="field:'sorttime_t',editor:{type:'textbox'}"><spring:message code="sortxraylog.column.sorttime_t" /></th>
                     <!-- 创建人 -->
                    <th data-options="field:'created_by_s',width:80,editor:{type:'textbox'}"><spring:message code="sortxraylog.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',editor:{type:'textbox'}"><spring:message code="sortxraylog.column.created_time_t" /></th>
                   <%--  <!-- 修改人 -->
                    <th data-options="field:'createname',width:80,editor:{type:'textbox'}"><spring:message code="sortxraylog.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',editor:{type:'textbox'}"><spring:message code="sortxraylog.column.changed_time_t" /></th> --%>
                    </tr>
            </thead>
        </table>
    </div>
     <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="SortXRaylog_search_form" />
		<jsp:param name="datagridId" value="sortxraylog_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.finalcheck.excel.SortXrayLogExportHandler" />
		<jsp:param name="serviceName" value="SortXRaylogServiceImpl" />
	</jsp:include>
</body>
</html>
