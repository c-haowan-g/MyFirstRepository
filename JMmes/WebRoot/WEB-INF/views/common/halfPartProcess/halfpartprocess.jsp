<!-- 

    作者      :葛迎祥/李德晓增加导出功能
    时间      :2020-06-16 14:06:43 
    页面名称:PLM半部件工艺表
    文件关联:
        HalfPartProcess.java
        HalfPartProcessController.java
        HalfPartProcessServiceImpl.java
        HalfPartProcessServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/meta.jsp"%>
<%@ include file="halfpartprocess.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'west',split:true" style="width:50%;" title="<spring:message code="halfpartprocess.column.halfpartprocess" />" >
        <div id="HalfPartProcess_dg_toolbar">
            <form id="HalfPartProcess_search_form" class="form" >
            	<table class="formTable">
					<tr>
						<td class="columnTitle">
							<!-- SAP品号 -->
							<spring:message code="halfpartprocess.column.assemsapmat_s" />:
						</td>
						<td class="columnData">
							<!-- SAP品号 -->
                			<input name="filter[assemsapmat_s]" style="width:120px" id="assemsapmat_s" beginWith="true" type="text" class="easyui-textbox" data-options="label:''" >
						</td>
						<td class="columnTitle">
							<!-- 物料描述 -->
							<spring:message code="halfpartprocess.column.assemname_s" />:
						</td>
						<td class="columnData">
							<!-- 物料描述 -->
                			<input name="filter[assemname_s]" like="true" style="width:140px" id="assemname_s"  type="text" class="easyui-textbox" data-options="label:''" >
						</td>
					</tr>
					<tr>
						<td class="columnTitle">
							<!-- 设备名 -->
							<spring:message code="halfpartprocess.column.equipmentname_s" />:
						</td>
						<td class="columnData">
							<!-- 设备名 -->
                			<input name="filter[equipmentname_s]" like="true" style="width:140px" id="equipmentname_s"  type="text" class="easyui-textbox" data-options="label:''" >
						</td> 
						<td class="columnTitle">
						 	<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
                            
						</td>
					</tr>
           	   </table>
               <%-- <auth:button code="SYS_JCSJCX_halfPartProcess_export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button> --%>
            </form> 
        </div>
        <table id="halfpartprocess_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: true,
                toolbar: '#HalfPartProcess_dg_toolbar',
                url: 'common/halfPartProcess/halfpartprocess/datagridUDA',
                onSelect:selectrow,
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <%-- <!-- 半部件物料编码 -->
                    <th data-options="field:'assempdmmat_s',editor:{type:'textbox'}"><spring:message code="halfpartprocess.column.assempdmmat_s" /></th> --%>
                    <!-- SAP品号-储胎9位品号 -->
                    <th data-options="field:'assemsapmat_s',editor:{type:'textbox'}"><spring:message code="halfpartprocess.column.assemsapmat_s" /></th>
                    <!-- 半部件描述名 -->
                    <th data-options="field:'assemname_s',editor:{type:'textbox'}"><spring:message code="halfpartprocess.column.assemname_s" /></th>
                    <%-- <!-- SAP品号 -->
                    <th data-options="field:'assemsapmat_temp_s',editor:{type:'textbox'}"><spring:message code="halfpartprocess.column.assemsapmat_temp_s" /></th> --%>
                    <!-- 设备类型 -->
                    <th data-options="field:'equipmenttypename_s',editor:{type:'textbox'}"><spring:message code="halfpartprocess.column.equipmenttypename_s" /></th>
                    <!-- 设备名称 -->
                    <th data-options="field:'equipmentname_s',editor:{type:'textbox'}"><spring:message code="halfpartprocess.column.equipmentname_s" /></th>
                    <!-- 工艺路线名称 -->
                    <th data-options="field:'processroute_s',editor:{type:'textbox'}"><spring:message code="halfpartprocess.column.processroute_s" /></th>
                    <!-- 工艺版本号 -->
                    <th data-options="field:'processversion_s',editor:{type:'textbox'}"><spring:message code="halfpartprocess.column.processversion_s" /></th>
                    <!-- 版本号 -->
                    <th data-options="field:'version_s',editor:{type:'textbox'}"><spring:message code="halfpartprocess.column.version_s" /></th>
                    <!-- 分厂 半钢 G1 全钢 G3 胎胚一次法 G1 胎胚二次法 G3 -->
                    <th data-options="field:'factory_s',editor:{type:'textbox'}"><spring:message code="buildingprocess.column.factory_s" /></th>
                    <!-- 工厂 柳州 8003 -->
                    <th data-options="field:'werks_s',editor:{type:'textbox'}"><spring:message code="curingprocess.column.werks_s" /></th>
                    <!-- 接收时间 -->
                    <th data-options="field:'receive_time_t',editor:{type:'textbox'}"><spring:message code="halfpartprocess.column.receive_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
    <div data-options="region:'center',split:true" title="<spring:message code="halfpartparameter.column.halfpartparameter" />" >
        <auth:button code="SYS_JCSJCX_halfPartProcess_export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
       <form id="id_ss" class="form" style="display:none">
         <!-- 主键 -->
         <%-- <th data-options="field:'id_s',editor:{type:'textbox'}"><spring:message code="messapproduction.column.rush_id_s" /></th> --%>
         <input name="filter[id_s]" id="id_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="messapproduction.column.rush_id_s" />'"> 
        </form>
        <table id="halfpartparameter_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:false,
                singleSelect: true,
                striped:true,
                remoteSort:false,
                method: 'get'  
                ">
            <thead>
                <tr>
                    <!-- 参数类型名称 -->
                    <th data-options="field:'PARMTYPENAME_S',sortable:true,editor:{type:'textbox'}"><spring:message code="halfpartparameter.column.parmtypename_s" /></th>
                    <!-- 参数中文名称 -->
                    <th data-options="field:'PARMNAME_S',sortable:true,editor:{type:'textbox'}"><spring:message code="halfpartparameter.column.parmname_s" /></th>
                    <!-- 参数值 -->
                    <th data-options="field:'VALUE_S',sortable:true,editor:{type:'textbox'}"><spring:message code="halfpartparameter.column.value_s" /></th>
                    <!-- 参数最大值 -->
                    <th data-options="field:'VALUEMAX_S',sortable:true,editor:{type:'textbox'}"><spring:message code="halfpartparameter.column.valuemax_s" /></th>
                    <!-- 参数最小值 -->
                    <th data-options="field:'VALUEMIN_S',sortable:true,editor:{type:'textbox'}"><spring:message code="halfpartparameter.column.valuemin_s" /></th>
                    <!-- 参数最大值操作符 0 不包含、1包含 -->
                    <th data-options="field:'VALUEMAXSIGN_S',sortable:true,editor:{type:'textbox'}"><spring:message code="deviceparameter.column.valuemaxsign_s" /></th>
                    <!-- 参数最小值操作符 -->
                    <th data-options="field:'VALUEMINSIGN_S',sortable:true,editor:{type:'textbox'}"><spring:message code="deviceparameter.column.valueminsign_s" /></th>
                    <!-- 参数ID -->
                    <th data-options="field:'PARMCODE_S',sortable:true,editor:{type:'textbox'}"><spring:message code="halfpartparameter.column.parmcode_s" /></th>
                    <!-- 参数类型代码 -->
                    <th data-options="field:'PARMTYPECODE_S',sortable:true,editor:{type:'textbox'}"><spring:message code="halfpartparameter.column.parmtypecode_s" /></th>
                    <!-- 接收时间 -->
                    <th data-options="field:'RECEIVE_TIME_T',sortable:true,editor:{type:'textbox'}"><spring:message code="halfpartparameter.column.receive_time_t" /></th>
                </tr>
            </thead>
            
        </table>
    </div>
    <jsp:include page="../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="id_ss" />
		<jsp:param name="datagridId" value="halfpartparameter_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.common.ExcelHandler.HalfPartProcessExportHandler" />
		<jsp:param name="serviceName" value="HalfPartProcessServiceImpl" />
	</jsp:include>
</body>
</html>
