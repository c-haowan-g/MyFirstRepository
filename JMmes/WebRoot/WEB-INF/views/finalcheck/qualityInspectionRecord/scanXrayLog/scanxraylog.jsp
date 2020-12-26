<!-- 

    作者      :时永良
    时间      :2018-08-05 09:07:46 
    页面名称:X光机扫描履历
    文件关联:
        ScanXrayLog.java
        ScanXrayLogController.java
        ScanXrayLogServiceImpl.java
        ScanXrayLogServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="scanxraylog.js.jsp"%> 
<script type="text/javascript" src="dict/259.js"></script>
<style type="text/css">
.columnTitle {
	padding: 6px 10px
}
</style>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="ScanXrayLog_dg_toolbar">
            <form id="ScanXrayLog_search_form" class="form" >
						<!-- 检查时间 -->
						<spring:message code="scanxraylog.column.created_time_t" />:
               			 <input name="filter[begin_created_time]" editable="true" id="begin_created_time" class="easyui-datetimebox"  style="width:130px" data-options="label:''">
                                                  到
                		<input name="filter[end_created_time]" editable="true" id="end_created_time" class="easyui-datetimebox"  style="width:130px">
						<!-- 轮胎条码：MES_MainTyre 表 BARCODE -->
						<spring:message code="scanxraylog.column.barcode_s" />:
               		    <input name="filter[barcode_s]" id="barcode_s" type="text"   style="width:130px"   class="easyui-textbox" data-options="label:''" >
						 <!-- 物料编码 -->
						 <spring:message code="scanxraylog.column.itemid_s" />:
               			 <input name="filter[itemid_s]" id="itemid_s" type="text"  like="true"  style="width:130px"  class="easyui-textbox" data-options="label:''" >
               			 <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
             <auth:button code="ZJ_ZJGL_XGSLL_DC"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
             <auth:button code="ZJ_ZJGL_XGSLL_CXL"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-hide'" onclick="searchBar()"><spring:message code="button.searchColumn" /></a></auth:button>
           </div>
        <table id="scanxraylog_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                emptyMsg: '<span><spring:message code='tip.noData'/></span>',
                rownumbers:true,
                singleSelect: false,
                toolbar: '#ScanXrayLog_dg_toolbar',
                url: '',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                	 <th data-options="field:'atr_key',checkbox:true">ID</th>
                	<!-- 轮胎条码：MES_MainTyre 表 BARCODE -->
                    <th data-options="field:'barcode_s'"><spring:message code="scanxraylog.column.barcode_s" /></th>
                    <!--设备名称-->
                  	<th data-options="field:'entname_s'"><spring:message code="enttrack.column.entid_i" /></th>
                    <!-- 分配索引号(!~1000) -->
                    <th data-options="field:'index_i'"><spring:message code="scanxraylog.column.index_i" /></th>
                    <!-- 外胎重量 -->
                    <th data-options="field:'weight_s'"><spring:message code="scanxraylog.column.weight_s" /></th>
                    <!-- MES校验是否成功：0-失败，1-成功 -->
                    <th data-options="field:'isok_s', formatter:mesxy"><spring:message code="sortappearancelog.column.isok_i" /></th>
                    <th data-options="field:'etype_i',formatter:codeFormatter,editor:{type:'combotree',options:
                                {
                                method:'get',
                                 data:DICT_259}}"><spring:message code="sortappearancelog.column.etype_i" /></th>            
                  	 <!-- 备注 -->
                    <th data-options="field:'remark_s'"><spring:message code="sortappearancelog.column.remark_s" /></th>
                     <!-- 工控下发是否成功：0-成功、1-失败 -->
                    <th data-options="field:'writein_s', formatter:mesxy"><spring:message code="sortappearancelog.column.writein_s" /></th>
                	 <!-- 工控下发备注 -->
                    <th data-options="field:'writeinremark_s'"><spring:message code="sortappearancelog.column.writeinremark_s" /></th>
                     <!-- 硫化规格描述 -->
                    <th data-options="field:'materialspec_s'"><spring:message code="scanxraylog.column.materialspec_s" /></th>
                     <!-- 规格 -->
                    <th data-options="field:'description'"><spring:message code="scanxraylog.column.materialDesc_s" /></th>
                     <!--层级 -->
                    <th data-options="field:'cj_s'"><spring:message code="scanxraylog.column.cj_s" /></th>
                     <!-- 花纹 -->
                    <th data-options="field:'pattern_s'"><spring:message code="scanxraylog.column.pattern_s" /></th>
                     <!--硫化商标  -->
                    <th data-options="field:'brand_s'"><spring:message code="scanxraylog.column.brand_s" /></th>
                     <!--检查时间  -->
                    <th data-options="field:'created_time_t'"><spring:message code="scanxraylog.column.created_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
      <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="ScanXrayLog_search_form" />
		<jsp:param name="datagridId" value="scanxraylog_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.finalcheck.excel.ScanXrayLogExportHandler" />
		<jsp:param name="serviceName" value="ScanXrayLogServiceImpl" />
	</jsp:include>
</body>
</html>
