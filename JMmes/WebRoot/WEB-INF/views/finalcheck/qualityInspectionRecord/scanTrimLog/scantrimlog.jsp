<!-- 

    作者      :时永良
    时间      :2018-08-04 18:14:57 
    页面名称:割毛产量查询
    文件关联:
        ScanTrimLog.java
        ScanTrimLogController.java
        ScanTrimLogServiceImpl.java
        ScanTrimLogServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="scantrimlog.js.jsp"%>
<script type="text/javascript" src="dict/301,302.js"></script>
<style type="text/css">
.columnTitle {
	padding: 6px 10px
}
</style>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="ScanTrimLog_dg_toolbar">
           <form id="ScanTrimLog_search_form" class="form" >
           	<table class="formTable">
					<tr>
							 <!-- 检测时间-->
							 <spring:message code="checktrimlog.column.created_time_t" />:
                			<input name="filter[begin_created_time]" type="text"  editable="true"    id="begin_created_time" class="easyui-datetimebox"  style="width:160px" 
                			data-options="
                			label:''">
                                                        到
                		    <input name="filter[end_created_time]" editable="true"   id="end_created_time" class="easyui-datetimebox"  style="width:160px">
						
					    	<!-- 检测班次-->
								<spring:message code="workorderresult.column.building_shift_s" />:
				                <input name="filter[class_id_s]" id="class_id_s" type="text" class="easyui-combotree" style="width:120px" data-options="label:'', 
		                              required:false,
		                              data:DICT_302,
		                              method:'get'">
						
							<a id="button-search" class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
					</tr>
			</table>
                
            </form>
            <auth:button code="ZJ_ZJGL_GM_DC"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            <auth:button code="ZJ_ZJGL_GM_CXL"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-hide'" onclick="searchBar()"><spring:message code="button.searchColumn" /></a></auth:button>
        </div>

        <table id="scantrimlog_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                emptyMsg: '<span><spring:message code='tip.noData'/></span>',
                rownumbers: true,
                singleSelect: false,
                toolbar: '#ScanTrimLog_dg_toolbar',
                url: '',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                  <!--  <th data-options="field:'atr_key',checkbox:true">ID</th> -->
                	<!-- 检测X光机台条码 -->
                    <th data-options="field:'equip_code_s',width:80"><spring:message code="checktrimlog.column.machinebar_s" /></th>
                   <!-- 班次编号 -->
                    <th data-options="field:'class_id_s',width:80,formatter:classFormatter"><spring:message code="checktrimlog.column.shiftcode_s" /></th>
                     <%-- <!-- 班组编号 -->
                    <th data-options="field:'groupcode_s',width:80"><spring:message code="checktrimlog.column.groupcode_s" /></th>
 --%>                    <!-- 产量 -->
                    <th data-options="field:'count_i',width:80"><spring:message code="checktrimlog.column.yield" /></th>
                   <%--  <!-- 创建人 -->
                    <th data-options="field:'created_by_s',width:80"><spring:message code="checktrimlog.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',width:80"><spring:message code="checktrimlog.column.created_time_t" /></th>
 --%>                </tr>
            </thead>
        </table>
    </div>
     <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="ScanTrimLog_search_form" />
		<jsp:param name="datagridId" value="scantrimlog_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.finalcheck.excel.PimiddleExportHandler" />
		<jsp:param name="serviceName" value="ScanTrimLogServiceImpl" />
	</jsp:include>
</body>
</html>
