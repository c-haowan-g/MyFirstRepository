<!-- 

    作者      :时永良
    时间      :2019-01-04 16:19:05 
    页面名称:质检入库分拣履历表
    文件关联:
        SortStorageLog.java
        SortStorageLogController.java
        SortStorageLogServiceImpl.java
        SortStorageLogServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="sortstoragelog.js.jsp"%>
<script type="text/javascript" src="dict/252,259,260,253.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="SortStorageLog_dg_toolbar">
            <form id="SortStorageLog_search_form" class="form" >
               <!-- 轮胎条码轮胎条码：MES_MainTyre 表 BARCODE -->
                <spring:message code="sortxraylog.column.barcode_s" />:
                <input name="filter[barcode_s]" id="barcode_s" type="text" class="easyui-textbox"  >
               <!-- 品号 -->
                <spring:message code="sortstoragelog.column.itemid_s" />:
                <input name="filter[itemid_s]" id="itemid_s" type="text" class="easyui-textbox" >
               <!-- 操作时间 -->
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
        <table id="sortstoragelog_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#SortStorageLog_dg_toolbar',
                url: '',
                striped:true,
                method: 'get',
                 emptyMsg:'<span><spring:message code='tip.noData'/></span>',
                ">
            <thead>
                <tr>
                	 <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 轮胎条码轮胎条码：MES_MainTyre 表 BARCODE -->
                    <th data-options="field:'barcode_s',width:80,editor:{type:'textbox'}"><spring:message code="sortstoragelog.column.barcode_s" /></th>
                     <!-- 品号 -->
                    <th data-options="field:'itemid_s',editor:{type:'textbox'}"><spring:message code="sortstoragelog.column.itemid_s" /></th>
                     <!-- 工序 -->
                   <th data-options="field:'proess_i',formatter:codeFormatter,editor:{type:'combotree',options:
                                {
                                method:'get',
                                 data:DICT_252}}"><spring:message code="sortstoragelog.column.proess_i" /></th>
                    <!-- 质量等级编码 -->
                   	<th data-options="field:'gradecd_i',formatter:codeFormatter,editor:{type:'combotree',options:
                                {
                                method:'get',
                                 data:DICT_259}}">
					<spring:message code="sortstoragelog.column.gradecd_i" /></th>
                   
                    
                    <!-- 分拣去向：D_EM_Ent 表 ID -->
                    <th data-options="field:'eentname_s',width:80,editor:{type:'textbox'}"><spring:message code="sortstoragelog.column.sortmachinebar_s" /></th>
                    <!-- 实际去向：D_EM_Ent 表 ID -->
                    <th data-options="field:'nentname_s',width:80,editor:{type:'textbox'}"><spring:message code="sortstoragelog.column.realmachinebar_s" /></th>
                    <!-- 分拣点：0-割毛前、1-外观前、2-外观后、3-X光后、4-动均前、5-入库前 -->
                  	<th data-options="field:'sorttype_i',formatter:codeFormatter,editor:{type:'combotree',options:
									{
									method:'get',
									 data:DICT_260}}">
						<spring:message code="sortstoragelog.column.sorttype_i" /></th>
                   <!-- 分拣是否成功：0-失败，1-成功 -->
                    <th data-options="field:'isok_i',formatter:isokFormatter,width:80,editor:{type:'textbox'}"><spring:message code="sortstoragelog.column.isok_i" /></th>
                     <!-- 错误类型： 1:轮胎条码不存在 2:机台信息不存在 3:规格索引不存在 4:轮胎状态不允许分配 5:轮胎规格规则未维护 6:拨胎器异常 7:机台停止 8:扫描头未读取到条码 9:其它 -->
                    	<th data-options="field:'etype_i',formatter:codeFormatter,editor:{type:'combotree',options:
                                {
                                method:'get',
                                 data:DICT_259}}">
					<spring:message code="sortstoragelog.column.etype_i" /></th>
                    <!-- 备注 -->
                    <th data-options="field:'remark_s',width:80,editor:{type:'textbox'}"><spring:message code="sortstoragelog.column.remark_s" /></th>
                    <!--  工控下发是否成功：0-成功、1-失败 -->
                    <th data-options="field:'writein_s',formatter:writeinFormatter,width:80,editor:{type:'textbox'}"><spring:message code="sortstoragelog.column.writein_s" /></th>
               		<!-- 工控下发备注 -->
                    <th data-options="field:'writeinremark_s',width:80,editor:{type:'textbox'}"><spring:message code="sortstoragelog.column.writeinremark_s" /></th>
                  	<%--  <!-- 修改人 -->
                    <th data-options="field:'createname',width:80,editor:{type:'textbox'}"><spring:message code="sortstoragelog.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',editor:{type:'textbox'}"><spring:message code="sortstoragelog.column.changed_time_t" /></th> --%>
                    <!-- 操作时间 -->
                    <th data-options="field:'sorttime_t',editor:{type:'textbox'}"><spring:message code="sortstoragelog.column.sorttime_t" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_s',width:80,editor:{type:'textbox'}"><spring:message code="sortstoragelog.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',editor:{type:'textbox'}"><spring:message code="sortstoragelog.column.created_time_t" /></th>
                   </tr>
            </thead>
        </table>
    </div>
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="formId" value="SortStorageLog_search_form" />
		<jsp:param name="datagridId" value="sortstoragelog_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.finalcheck.excel.SortstoragelogsExportHandler" />
		<jsp:param name="serviceName" value="SortstoragelogsServiceImpl" />
	</jsp:include>
</body>
</html>
