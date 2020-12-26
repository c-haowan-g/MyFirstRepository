<!-- 

    作者      :时永良
    时间      :2019-01-07 14:09:34 
    页面名称:质检外观后分拣履历表
    文件关联:
        SortAppearanceBackLog.java
        SortAppearanceBackLogController.java
        SortAppearanceBackLogServiceImpl.java
        SortAppearanceBackLogServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="appearancebacklog.js.jsp"%>
<script type="text/javascript" src="dict/252,259,260,253.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="SortAppearanceBackLog_dg_toolbar">
            <form id="SortAppearanceBackLog_search_form" class="form" >
                <!-- 轮胎条码：MainTyre 表 BARCODE -->
                <spring:message code="sortappearancebacklog.column.barcode_s" />:
                <input name="filter[barcode_s]" id="barcode_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 品号 -->
                <spring:message code="sortappearancebacklog.column.itemid_s" />:
                <input name="filter[itemid_s]" id="itemid_s" type="text" class="easyui-textbox" data-options="label:''" >
                <spring:message code="sortappearancelog.column.sorttime_t" />:	
				<input name="filter[begin_created_time]" editable="true" id="begin_created_time"
					type="text" class="easyui-datetimebox" style="width:170px" data-options="label:''"> 到 <input name="filter[end_created_time]" editable="true" id="end_created_time"
					class="easyui-datetimebox" style="width:170px"> 
					<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
           		 <auth:button code="XXX"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            </form> 
                   </div>
        <table id="sortappearancebacklog_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#SortAppearanceBackLog_dg_toolbar',
                url: '',
                striped:true,
                method: 'get' ,
                emptyMsg:'<span><spring:message code='tip.noData'/></span>',
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 轮胎条码：MainTyre 表 BARCODE -->
                    <th data-options="field:'barcode_s',width:80,editor:{type:'textbox'}"><spring:message code="sortappearancebacklog.column.barcode_s" /></th>
                    <!-- 品号 -->
                    <th data-options="field:'itemid_s',width:80,editor:{type:'textbox'}"><spring:message code="sortappearancebacklog.column.itemid_s" /></th>
                     <!-- 工序 -->
                    <th data-options="field:'proess_i',formatter:codeFormatter,editor:{type:'combotree',options:
                                {
                                method:'get',
                                 data:DICT_252}}">
                    <spring:message code="sortappearancebacklog.column.proess_i" /></th>
                     <!-- 分拣去向：D_EM_Ent 表 ENTBARCODE -->
                    <th data-options="field:'sortmachinebar',width:80,editor:{type:'textbox'}"><spring:message code="sortappearancebacklog.column.sortmachinebar_s" /></th>
                    <!-- 实际去向：D_EM_Ent 表 ENTBARCODE -->
                    <th data-options="field:'realmachinebar',width:80,editor:{type:'textbox'}"><spring:message code="sortappearancebacklog.column.realmachinebar_s" /></th>
                     <!-- 分拣是否成功：0-失败，1-成功 -->
                    <th data-options="field:'isok_i',width:80,formatter:IsokFormatter,editor:{type:'textbox'}"><spring:message code="sortappearancebacklog.column.isok_i" /></th>
                     <!-- 分拣点：260001-割毛前、260002-外观前、260003-外观后、260004-X光后、260005-动平衡前、260006-入库前 -->
                    <th data-options="field:'sorttype_i',formatter:codeFormatter,editor:{type:'combotree',options:
                                {
                                method:'get',
                                 data:DICT_260}}">
                    <spring:message code="sortappearancebacklog.column.sorttype_i" /></th>
                     <!-- MES校验错误类型：259001：轮胎条码、259002：机台信息不存在、259003：规格索引不存在、259004：轮胎状态不允许分配、259005：轮胎规格规则未维护、59006：滑道异常、259007：机台停止、259008：扫描头未读取到条码、259009：轮胎状态不允许检测、259010：其它 -->
                    <th data-options="field:'etype_i',formatter:codeFormatter,editor:{type:'combotree',options:
                                {
                                method:'get',
                                 data:DICT_259}}">
                    <spring:message code="sortappearancebacklog.column.etype_i" /></th>
                    <!-- 质量等级编码 -->
                    <th data-options="field:'gradecd_i',formatter:codeFormatter,editor:{type:'combotree',options:
                                {
                                method:'get',
                                 data:DICT_259}}">
                    <spring:message code="sortappearancebacklog.column.gradecd_i" /></th>
                   <!-- 备注 -->
                    <th data-options="field:'remark_s',width:80,editor:{type:'textbox'}"><spring:message code="sortappearancebacklog.column.remark_s" /></th>
                   <!-- 工控下发是否成功：0-失败、1-成功 -->
                    <th data-options="field:'writein_s',formatter:WriteinFormatter,editor:{type:'textbox'}"><spring:message code="sortappearancebacklog.column.writein_s" /></th>
                    <!-- 工控下发备注 -->
                    <th data-options="field:'writeinremark_s',width:80,editor:{type:'textbox'}"><spring:message code="sortappearancebacklog.column.writeinremark_s" /></th>
                    <!-- 操作时间 -->
                    <th data-options="field:'sorttime_t',editor:{type:'textbox'}"><spring:message code="sortappearancebacklog.column.sorttime_t" /></th>
                   <!-- 创建人 -->
                    <th data-options="field:'username',width:80,editor:{type:'textbox'}"><spring:message code="sortappearancebacklog.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',editor:{type:'textbox'}"><spring:message code="sortappearancebacklog.column.created_time_t" /></th>
                   
                   <%--  <!-- 修改人 -->
                    <th data-options="field:'changed_by_s',width:80,editor:{type:'textbox'}"><spring:message code="sortappearancebacklog.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',width:80,editor:{type:'textbox'}"><spring:message code="sortappearancebacklog.column.changed_time_t" /></th>
                    <!-- 记录标志，A可用，D删除 -->
                    <th data-options="field:'record_flag_s',width:80,editor:{type:'textbox'}"><spring:message code="sortappearancebacklog.column.record_flag_s" /></th>
                    <!-- 备用字段1 -->
                    <th data-options="field:'spare1_s',width:80,editor:{type:'textbox'}"><spring:message code="sortappearancebacklog.column.spare1_s" /></th>
                    <!-- 备用字段2 -->
                    <th data-options="field:'spare2_s',width:80,editor:{type:'textbox'}"><spring:message code="sortappearancebacklog.column.spare2_s" /></th>
                    <!-- 备用字段3 -->
                    <th data-options="field:'spare3_s',width:80,editor:{type:'textbox'}"><spring:message code="sortappearancebacklog.column.spare3_s" /></th>
                    <!-- 备用字段4 -->
                    <th data-options="field:'spare4_s',width:80,editor:{type:'textbox'}"><spring:message code="sortappearancebacklog.column.spare4_s" /></th>
                    <!-- 备用字段5 -->
                    <th data-options="field:'spare5_s',width:80,editor:{type:'textbox'}"><spring:message code="sortappearancebacklog.column.spare5_s" /></th>
                    <!-- 工厂(1.全钢 2.半钢) -->
                    <th data-options="field:'s_factory_s',width:80,editor:{type:'textbox'}"><spring:message code="sortappearancebacklog.column.s_factory_s" /></th>
                     --%>
                </tr>
            </thead>
        </table>
    </div>
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="SortAppearanceBackLog_search_form" />
		<jsp:param name="datagridId" value="sortappearancebacklog_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.finalcheck.excel.SortAppearanceBackLogExportHandler" />
		<jsp:param name="serviceName" value="SortAppearanceBackLogServiceImpl" />
	</jsp:include>
</body>
</html>
