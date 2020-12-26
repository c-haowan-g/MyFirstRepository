<!-- 

    作者      :葛迎祥
    时间      :2020-05-07 13:47:54 
    页面名称:Route
    文件关联:
        Route.java
        RouteController.java
        RouteServiceImpl.java
        RouteServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/meta.jsp"%>
<%@ include file="route.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="Route_dg_toolbar">
            <form id="Route_search_form" class="form" >
                <!-- 工艺路线类型 -->
                <spring:message code="routelog.column.routetype" />:
                <input name="filter[routecode_s]" id="routecode_s" type="text"  class="easyui-combobox"  data-options="label:'',
                                        required:false, 
                                        data:[{
                                        	id:'CX',
                                        	text:'成型'
                                        },{
                                        	id:'LH',
                                        	text:'硫化'
                                        }],
                                        icons:[{iconCls:'icon-clear',
					                 	handler:clearStatus}],
			                            method: 'get',
			   	                        valueField:'id',
			                            textField:'text'"> 
                <!-- 工艺路线名称 -->
                <spring:message code="routelog.column.routecode" />:
                <input name="filter[routecode_n]" id="routecode_n" type="text"  class="easyui-textbox"  data-options="label:'' ">
                
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
                <auth:button code="repairrecord.export"><a style="margin-top: 3px;" class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            </form> 
        </div>
        <table id="route_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#Route_dg_toolbar',
                url: 'common/routeLog/routelog/datagridUDA',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'route_key',checkbox:true">ID</th>
                    <!-- 工艺路线ID -->
                    <th data-options="field:'route_name',width:150,editor:{type:'textbox'}"><spring:message code="route.column.routecode_id" /></th>
                    <!-- 工艺路线名称 -->
                    <th data-options="field:'routecode_s',width:100,editor:{type:'textbox'}"><spring:message code="routelog.column.routecode" /></th>
                    <!-- 工厂 -->
                    <th data-options="field:'factory_s',width:80,editor:{type:'textbox'}"><spring:message code="curingrepairstatistics.column.s_factory_s" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'modifier_s',width:80,editor:{type:'textbox'}"><spring:message code="curingprocess_log.column.modifier_s" /></th>
                    <!-- PDM物料编码 -->
                    <th data-options="field:'pdmmat_s',width:80,editor:{type:'textbox'}"><spring:message code="buildingproc_log.column.pdmmat_s" /></th>
                    <!-- 记录标志 -->
                    <th data-options="field:'record_flag_s',width:80,editor:{type:'textbox'}"><spring:message code="curingcancelwork.column.record_flag_s" /></th>
                    <!-- SAP品号 -->
                    <th data-options="field:'sapmat_s',width:80,editor:{type:'textbox'}"><spring:message code="halfpartprocess.column.assemsapmat_s" /></th>
                    <!-- SAP品号 -->
                    <th data-options="field:'sapmat_temp_s',width:80,editor:{type:'textbox'}"><spring:message code="halfpartprocess.column.assemsapmat_s" /></th>
                    <!-- 分厂 -->
                    <th data-options="field:'werks_s',width:80,editor:{type:'textbox'}"><spring:message code="buildingprocess.column.werks_s" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'createuser_s',width:80,editor:{type:'textbox'}"><spring:message code="quickcheckedit.column.createuser_s" /></th>
                    <!-- 产品阶段 -->
                    <th data-options="field:'stage_s',width:80,editor:{type:'textbox'}"><spring:message code="curingprocess.column.stage_s" /></th>
                    <!-- 工艺版本号 -->
                    <th data-options="field:'processversion_s',width:80,editor:{type:'textbox'}"><spring:message code="halfpartprocess.column.processversion_s" /></th>
                    <!-- SAP下发版本号 -->
                    <th data-options="field:'version_s',width:80,editor:{type:'textbox'}"><spring:message code="productplan.column.sapversion_s" /></th>
                    <!-- 机台条码 -->
                    <th data-options="field:'equipmentcode_s',width:80,editor:{type:'textbox'}"><spring:message code="eq.column.equipmentcode_s" /></th>
                    <!-- 设备类型  -->
                    <th data-options="field:'equipmenttypecode_s',width:80,editor:{type:'textbox'}"><spring:message code="buildrecipepara.column.equipmenttypecode_s" /></th>
                    <!-- 接收时间 -->
                    <th data-options="field:'receive_time_t',width:140,editor:{type:'textbox'}"><spring:message code="route.column.receive_time_t" /></th>
                    <!-- 终止时间 -->
                    <th data-options="field:'expiredate_t',width:140,editor:{type:'textbox'}"><spring:message code="route.column.expiredate_t" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'createdate_t',width:140,editor:{type:'textbox'}"><spring:message code="route.column.createdate_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
    <jsp:include page="../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="Route_search_form" />
		<jsp:param name="datagridId" value="route_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.common.ExcelHandler.RouteLogExportHandler" />
		<jsp:param name="serviceName" value="RouteLogServiceImpl" />
	</jsp:include>
</body>
</html>
