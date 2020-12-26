<!-- 

    作者      :王超
    时间      :2020-01-15 13:13:26 
    页面名称:胎胚重量合格率查询
    文件关联:
        WeightOkRateByCode.java
        WeightOkRateByCodeController.java
        WeightOkRateByCodeServiceImpl.java
        WeightOkRateByCodeServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="qualifiedrateofweight.js.jsp"%>
<script type="text/javascript" src="dict/105.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="WorkorderResult_dg_toolbar">
            <form id="WorkorderResult_search_form" class="form" >
                <!-- 物料编码 -->
                <spring:message code="workorderresult.column.material_code_s" />:<input name="filter[material_code_s]" id="material_code_s" style="width:120px" type="text" class="easyui-textbox" data-options="label:''" >&nbsp;&nbsp;&nbsp;
				<!-- 机台编码 -->
				<spring:message code="workorderresult.column.equip_code_s" />:<input name="filter[equip_code_s]" id="equip_code_s" style="width:120px" type="text" class="easyui-textbox" data-options="label:''" >&nbsp;&nbsp;&nbsp;
				<!-- 产出时间 -->
				<spring:message code="workorderresult.column.building_date_t" />:<input name="filter[begintime]" editable="true" id="begin_created_time" type="text" class="easyui-datetimebox" style="width:160px" data-options="label:''">
				到 <input name="filter[endtime]" editable="true" id="end_created_time" type="text" class="easyui-datetimebox" style="width:160px" data-options="label:''">&nbsp;&nbsp;&nbsp;
            	<span>统计方式：</span>
	           	<!-- 机台编码 -->
	           	<input style="position:relative;top:2px" class="easyui-checkbox" type="checkbox" name="filter[line_spec_s]" id="line_spec_s" data-options="label:'',checked:true,onChange:filter"/>
	           	<spring:message code="workerorderresult.column.line_spec" />
	           	<!-- 物料编码 -->
	           	<input style="position:relative;top:2px" class="easyui-checkbox" type="checkbox" name="filter[material_spec_s]" id="material_spec_s" data-options="label:'',checked:true,onChange:filter"/>
	           	<spring:message code="workerorderresult.column.material_spec_s" />
            </form>
            <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            <auth:button code="qualifiedrateofweight.export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            <auth:button code="qualifiedrateofweight.showOrHide"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="showOrHide()"><spring:message code="button.searchColumn" /></a></auth:button> 
        </div>
        <table class="easyui-datagrid"  id="workorderresult_dg"
             data-options="
          	      pagination:true,
                  fit:true,
                  fitColumns:false,
			      singleSelect:false,
			      autoRowHeight:true,
			      rownumbers:true,
			      loadMsg:'加载中。。。',
			      toolbar: '#WorkorderResult_dg_toolbar',
                  method:'get',
                  emptyMsg:'暂无数据',
                  striped:true
                 ">
        </table>
    </div>
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="WorkorderResult_search_form" />
		<jsp:param name="datagridId" value="workorderresult_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.building.excel.WeightOkRateByCodeExportHandler" />
		<jsp:param name="serviceName" value="WeightOkRateByCodeServiceImpl" />
	</jsp:include> 
</body>
</html>
