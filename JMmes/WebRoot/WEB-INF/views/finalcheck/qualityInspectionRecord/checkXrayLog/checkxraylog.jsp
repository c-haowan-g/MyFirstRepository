<!-- 

    作者      :时永良
    时间      :2018-08-09 07:39:33 
    页面名称:X光检测履历
    文件关联:
        CheckXrayLog.java
        CheckXrayLogController.java
        CheckXrayLogServiceImpl.java
        CheckXrayLogServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="checkxraylog.js.jsp"%>
<script type="text/javascript" src="dict/252.js"></script>
<style type="text/css">
.columnTitle {
	padding: 6px 10px
}
</style>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="CheckXrayLog_dg_toolbar">
            <form id="CheckXrayLog_search_form" class="form" >
							<!-- 检查时间 -->
							<spring:message code="checkxraycv.column.ti_s" />:
                			<input name="filter[begin_created_time]" editable="true" id="begin_created_time" class="easyui-datetimebox"  style="width:130px" data-options="label:''">
                                                         到
                			<input name="filter[end_created_time]" editable="true" id="end_created_time" class="easyui-datetimebox"  style="width:130px">
							<!-- 机台名称 -->
            				<spring:message code="ent.column.xentname_s" />:
                			<input type="text" class="easyui-combobox" name="filter[mn_s]" id="mn_s" style="width:150px" 
                        	data-options="  label:'',
                         	required:false, 
                		 	width:250,
                		 	icons:[{iconCls:'icon-clear',handler:function(e){$(e.data.target).combobox('clear')}}],
                		 	url:'finalcheck/baseData/entmodel/SearchEnt?equip_type=254003',
			   			 	method: 'get',
			    		 	valueField:'EQUIP_NAME',
			    		    textField:'DESCRIPTION'">
							<!-- 轮胎条码：MES_MainTyre 表 BARCODE -->
            				<spring:message code="checkxraycv.column.pn_s" />:
                			<input name="filter[pn_s]" id="pn_s" style="width:130px" type="text" class="easyui-textbox" data-options="label:''" >
                			<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
             <auth:button code="ZJ_JCGL_XJCLL_USER_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
           					<auth:button code="ZJ_JCGL_XJCLL_USER_QUAERYBAR"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-hide'" onclick="searchBar()"><spring:message code="button.searchColumn" /></a></auth:button>
                 </div>
        <table id="checkxraylog_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                emptyMsg: '<span><spring:message code='tip.noData'/></span>',
                singleSelect: false,
                toolbar: '#CheckXrayLog_dg_toolbar',
                url: '',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                	 <th data-options="field:'atr_key',checkbox:true">ID</th>
                	<!-- 轮胎条码：MES_MainTyre 表 BARCODE -->
                    <th data-options="field:'pn_s' "><spring:message code="checkxraylog.column.pn_s" /></th>
                	<!-- 病象名称：D_BS_Reas 表 ID描述 -->
                    <th data-options="field:'defectname_s' "><spring:message code="checkxraylog.column.defectname_s" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by'"><spring:message code="checkxraylog.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t' "><spring:message code="checkxraylog.column.created_time_t" /></th>
                    <!-- 硫化规格代码 -->
                    <th data-options="field:'itemid_s' "><spring:message code="checkxraylog.column.itemid_s" /></th>
                    <!-- 轮胎状态编码 -->
                    <th data-options="field:'itemstate_s'"><spring:message code="checkxraylog.column.itemstate_s" /></th>
                    <!-- 机台条码：D_EM_Ent 表 ENTBARCODE -->
                    <th data-options="field:'entname_s' "><spring:message code="checkxraylog.column.mn_s" /></th>
                    <!-- 当前工序 -->
                    <th data-options="field:'proess_s',width:80,formatter:codeFormatter,editor:{type:'combotree',options:
                                {
                                method:'get',
                                 data:DICT_252}}"><spring:message code="checkxraylog.column.proess_s" /></th>           
                    <!-- 病象编号：D_BS_Reas 表 ID -->
                    <th data-options="field:'reascd_s'"><spring:message code="checkxraylog.column.reascd_s" /></th>
                    <!-- 质检员 -->
                    <th data-options="field:'userid' "><spring:message code="checkxraylog.column.userid_s" /></th>
                </tr>
            </thead>
        </table>
    </div>
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="CheckXrayLog_search_form" />
		<jsp:param name="datagridId" value="checkxraylog_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.finalcheck.excel.CheckXrayLogExportHandler" />
		<jsp:param name="serviceName" value="CheckXrayLogServiceImpl" />
	</jsp:include>
</body>
</html>
