<!-- 

    作者      :时永良
    时间      :2019年7月19日14:21:09 
    页面名称:模具使用履历
    文件关联:
        WorkList.java
        MouldWorkListController.java
        MouldWorkListServiceImpl.java
        MouldWorkListServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="mouldworklist.js.jsp"%>
<script type="text/javascript" src="dict/228,232,208.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="WorkList_dg_toolbar">
            <form id="WorkList_search_form" class="form" >
            	<!-- 模具条码 -->
            	<spring:message code="worklist.column.moldcode_s" />:
                <input name="filter[mold_code_s]" id="mold_code_s" style="width:15%" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 机台编码 -->
                <spring:message code="worklist.column.machinecode_s" />:
                <input name="filter[machinecode_s]" id="machinecode_s" style="width:15%" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 开始时间 -->
                <spring:message code="worklist.column.operate_starttime_s" />:
                <input name="filter[start_time]" id="start_time" type="text" class="easyui-datetimebox" data-options="label:''" >
               	 <spring:message code="tip.to" /><input name="filter[end_time]" id="end_time" type="text" class="easyui-datetimebox" data-options="label:''" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
                <auth:button code="LH_SCGL_MJSYLL_EXPORT"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a>  </auth:button>
            </form> 
        </div>
        
        <table id="worklist_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#WorkList_dg_toolbar',
                striped:true,
                emptyMsg:'<span><spring:message code='tip.noData'/></span>',
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 模具条码 -->
                    <th data-options="field:'mold_code_s',width:80,editor:{type:'textbox'}"><spring:message code="worklist.column.moldcode_s" /></th>
                    <!-- 机台编码 -->
                    <th data-options="field:'machinecode_s',width:80,editor:{type:'textbox'}"><spring:message code="worklist.column.machinecode_s" /></th>
                    <!-- 当前规格编码 -->
                    <th data-options="field:'mold_spec',width:80,editor:{type:'textbox'}"><spring:message code="machinestatus.column.materialname_s" /></th>
                    <!-- 入库时间 -->
                    <th data-options="field:'load_date',editor:{type:'textbox'}"><spring:message code="curing.column.load_date_t" /></th>
                    <!-- 入库状态 -->
                    <th data-options="field:'statues_id',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="curing.column.statues_id_s" /></th>
                    
                    
                   <!-- 机台作业类型  1模具换上，2换胶囊，3洗模 4 模具换下 5模具修理6组装 -->
                    <th data-options="field:'operate_type_s',width:100,formatter:codeFormatter,editor:{type:'combotree',options:{
                    			method:'get',
                                url:'dict/code/228',
                                panelWidth:'300',
                    			required:true,
                    			}}"><spring:message code="worklist.column.operate_type_s" /></th>
                     <!-- 洗模类型 -->
                    <th data-options="field:'clent_ype_s',formatter:codeFormatter,width:80,editor:{type:'textbox'}"><spring:message code="worklist.column.clent_ype_s" /></th>
                    <!-- 当前记录次数 -->
                    <th data-options="field:'usenum_current_s',width:80,editor:{type:'textbox'}"><spring:message code="worklist.column.usenum_current_s" /></th>
                    <!-- 使用次数 -->
                    <th data-options="field:'usenumber_s',width:80,editor:{type:'textbox'}"><spring:message code="worklist.column.usenumber_s" /></th>
                    <!-- 作业开始时间 -->
                    <th data-options="field:'operate_starttime_t',width:80,editor:{type:'textbox'}"><spring:message code="worklist.column.operate_starttime_s" /></th>
                    <!-- 作业结束时间 -->
                    <th data-options="field:'operate_endtime_t',width:80,editor:{type:'textbox'}"><spring:message code="worklist.column.operate_endtime_s" /></th>
                    <!-- 作业人 -->
                    <th data-options="field:'created_by_s',width:80,editor:{type:'textbox'}"><spring:message code="worklist.column.execution_operator_s" /></th>  
                </tr>
            </thead>
        </table>
    </div>
    
   
</body>
 <!-- 	导出-->    
	<jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="WorkList_search_form" />
		<jsp:param name="datagridId" value="worklist_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.curing.excel.MouldWorkListExportHandler" />
		<jsp:param name="serviceName" value="WorkListServiceImpl" />
	</jsp:include>
</html>
