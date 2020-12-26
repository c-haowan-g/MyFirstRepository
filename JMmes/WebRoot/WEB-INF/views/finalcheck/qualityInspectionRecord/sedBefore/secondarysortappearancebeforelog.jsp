<!-- 

    作者      :孙尊龙
    时间      :2020-01-21 13:54:15 
    页面名称:二次质检外观前分拣履历表
    文件关联:
        SecondarySortAppearanceBeforeLog.java
        SecondarySortAppearanceBeforeLogController.java
        SecondarySortAppearanceBeforeLogServiceImpl.java
        SecondarySortAppearanceBeforeLogServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="secondarysortappearancebeforelog.js.jsp"%>
<script type="text/javascript" src="dict/252,259,260,253.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="SecondarySortAppearanceBeforeLog_dg_toolbar">
            <form id="SecondarySortAppearanceBeforeLog_search_form" class="form" >
				<input name="filter[proess_i]" id="proess_i" value="252016"   type="hidden">
				<!-- 轮胎条码：MainTyre 表 BARCODE -->
				<spring:message code="sortappearancelog.column.barcode_s" />:
				<input name="filter[barcode_s]" id="barcode_s" type="text" class="easyui-textbox" data-options="label:''">
				<!-- 品号 -->
				<spring:message code="sortappearancelog.column.itemid_s" />:
				<input name="filter[itemid_s]" id="itemid_s" type="text" class="easyui-textbox" data-options="label:''"> 
				<spring:message code="sortappearancelog.column.sorttime_t" />:	
				<input name="filter[begin_created_time]" editable="true" id="begin_created_time"
					type="text" class="easyui-datetimebox" style="width:170px" data-options="label:''"> 到 <input name="filter[end_created_time]" editable="true" id="end_created_time"
					class="easyui-datetimebox" style="width:170px"> 
					<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
					<a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a>
          
            </form> 
        </div>
        <table id="secondarysortappearancebeforelog_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#SecondarySortAppearanceBeforeLog_dg_toolbar',
                url: '',
                striped:true,
                method: 'get',
                emptyMsg:'<span><spring:message code='tip.noData'/></span>',
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 轮胎条码：MainTyre 表 BARCODE -->
                    <th data-options="field:'barcode_s',width:80,editor:{type:'textbox'}"><spring:message code="sortappearancelog.column.barcode_s" /></th>
                    <!-- 品号 -->
                    <th data-options="field:'itemid_s',width:80,editor:{type:'textbox'}"><spring:message code="sortappearancelog.column.itemid_s" /></th>
                    <!-- 工序 -->
                    <th data-options="field:'proess_i',formatter:codeFormatter,editor:{type:'combotree',options:
                                {
                                method:'get',
                                 data:DICT_252}}">
                    <spring:message code="sortappearancelog.column.proess_i" /></th>
                    <!-- 分拣去向：MES_ZJ_Ent 表 ENTBARCODE -->
                    <th data-options="field:'sortmachinebar_s',width:80,editor:{type:'textbox'}"><spring:message code="sortappearancelog.column.sortmachinebar_s" /></th>
                   	<!-- 实绩去向：MES_ZJ_Ent 表 ENTBARCODE -->
                    <th data-options="field:'realmachinebar_s',width:80,editor:{type:'textbox'}"><spring:message code="sortappearancelog.column.realmachinebar_s" /></th>
                    <!-- 分拣点：260001-割毛前、260002-外观前、260003-外观后、260004-X光后、260005-动平衡前、260006-入库前 -->
                    <th data-options="field:'sorttype_i',formatter:codeFormatter,editor:{type:'combotree',options:
                                {
                                method:'get',
                                 data:DICT_260}}">
					<spring:message code="sortappearancelog.column.sorttype_i" /></th>
					<!-- MES校验是否成功：0-失败，1-成功 -->
					<th data-options="field:'isok_i',width:80,formatter:IsokFormatter,editor:{type:'textbox'}"><spring:message code="sortappearancelog.column.isok_i" /></th>
					<!-- 错误类型： 1:轮胎条码不存在 2:机台信息不存在 3:规格索引不存在 4:轮胎状态不允许分配 5:轮胎规格规则未维护 6:拨胎器异常 7:机台停止 8:扫描头未读取到条码 9:其它 -->
					<th data-options="field:'etype_i',formatter:codeFormatter,editor:{type:'combotree',options:
                                {
                                method:'get',
                                 data:DICT_259}}">
					<spring:message code="sortappearancelog.column.etype_i" /></th>
					<!-- 质量等级编码 -->
					<th data-options="field:'gradecd_i',formatter:codeFormatter,editor:{type:'combotree',options:
                                {
                                method:'get',
                                 data:DICT_259}}">
					<spring:message code="sortappearancelog.column.gradecd_i" /></th>
					<!-- 备注 -->
					<th data-options="field:'remark_s',width:80,editor:{type:'textbox'}"><spring:message code="sortappearancelog.column.remark_s" /></th>
					<!-- 工控下发是否成功：0-成功、1-失败 -->
					<th data-options="field:'writein_s',formatter:WriteinFormatter,width:80,editor:{type:'textbox'}"><spring:message code="sortappearancelog.column.writein_s" /></th>
					<!-- 工控下发备注 -->
					<th data-options="field:'writeinremark_s',width:80,editor:{type:'textbox'}"><spring:message code="sortappearancelog.column.writeinremark_s" /></th>
                    <!-- 操作时间 -->
                    <th data-options="field:'sorttime_t',width:80,editor:{type:'textbox'}"><spring:message code="sortappearancelog.column.sorttime_t" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_s',width:80,editor:{type:'textbox'}"><spring:message code="sortappearancelog.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',width:80,editor:{type:'textbox'}"><spring:message code="sortappearancelog.column.created_time_t" /></th>
                    
                    <%--
                    <!-- 备用字段1 -->
                    <th data-options="field:'spare1_s',width:80,editor:{type:'textbox'}"><spring:message code="sortappearancelog.column.spare1_s" /></th>
                    <!-- 备用字段2 -->
                    <th data-options="field:'spare2_s',width:80,editor:{type:'textbox'}"><spring:message code="sortappearancelog.column.spare2_s" /></th>
                    <!-- 备用字段3 -->
                    <th data-options="field:'spare3_s',width:80,editor:{type:'textbox'}"><spring:message code="sortappearancelog.column.spare3_s" /></th>
                    <!-- 备用字段4 -->
                    <th data-options="field:'spare4_s',width:80,editor:{type:'textbox'}"><spring:message code="sortappearancelog.column.spare4_s" /></th>
                    <!-- 备用字段5 -->
                    <th data-options="field:'spare5_s',width:80,editor:{type:'textbox'}"><spring:message code="sortappearancelog.column.spare5_s" /></th>
                     --%>
                </tr>
            </thead>
        </table>
    </div>
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="SecondarySortAppearanceBeforeLog_search_form" />
		<jsp:param name="datagridId" value="secondarysortappearancebeforelog_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.finalcheck.excel.SecondarySortAppearanceBeforeLogExportHandler" />
		<jsp:param name="serviceName" value="SecondarySortAppearanceBeforeLogServiceImpl" />
	</jsp:include>
</body>
</html>
