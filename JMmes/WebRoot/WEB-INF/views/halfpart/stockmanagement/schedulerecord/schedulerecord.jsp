<!-- 

    作者      :孙尊龙
    时间      :2020-07-14 14:33:02 
    页面名称:半部件物流调度履历查询
    文件关联:
        ScheduleRecord.java
        ScheduleRecordController.java
        ScheduleRecordServiceImpl.java
        ScheduleRecordServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="schedulerecord.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="ScheduleRecord_dg_toolbar">
            <form id="ScheduleRecord_search_form" class="form" >
                <!-- 机台条码 -->
                <spring:message code="schedulerecord.column.equipmentcode_s" />
                :&emsp;<input name="filter[equipmentcode_s]" id="equipmentcode_s" type="text"  class="easyui-combobox"   
                         data-options="label:'',
                                            labelWidth:'auto',
                                            panelHeight:200,
                                            editable:true,
                                            required:false,
                                            url:'halfpart/basedata/productlinemanager/getHalfPartProductionLine',
                                            valueField:'P_LINE_NAME',
                              			    textField:'DESCRIPTION',
                                            method:'get'">
                <!-- 物料编码 -->
                 &emsp;<spring:message code="schedulerecord.column.materialcode_s"/>
                :&emsp;<input name="filter[schedulematerial_s]" id="schedulematerial_s" type="text"  class="easyui-combobox"   
                  		data-options="label:'',
                                            panelHeight:200,
                                            editable:true,
                                            required:false,
                                            url:'halfpart/plateinoutrecord/plateinoutrecords/searchMaterielcode',
                                            valueField:'MATERIALCODE_S',
                                            textField:'MATERIALCODE_S',
                                            method:'get'">
                <!-- 触发时间 -->
                 &emsp;<spring:message code="schedulerecord.column.scheduletime_t" />
                :&emsp;<input name="filter[start_time]" id="start_time" type="text" class="easyui-datetimebox" data-options="label:''">
					   <spring:message code="tip.to" />
					   <input name="filter[end_time]" id="end_time" type="text" class="easyui-datetimebox" data-options="label:''">&emsp;
          				   
            </form>
            <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
          <auth:button code="schedulerecord.export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
          <auth:button code="schedulerecord.showOrHide"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="showOrHide()"><spring:message code="button.searchColumn" /></a></auth:button>	     
      </div>
        <table id="schedulerecord_dg" class="easyui-datagrid" style="width:100%"
               data-options="  
			                fit:true,
			                fitColumns:true,
			                pagination:true,
			                rownumbers: true,
			                singleSelect: false,
			                toolbar: '#ScheduleRecord_dg_toolbar',
			                url: 'halfpart/stockmanagement/ScheduleRecord/datagridUDA',
			                striped:true,
			                method: 'get',
			                emptyMsg: '<span><spring:message code='tip.noData'/></span>'">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>   
                    <!-- 机台条码 -->
                    <th data-options="field:'equipmentcode_s',width:80,editor:{type:'textbox'}"><spring:message code="schedulerecord.column.equipmentcode_s" /></th>   
                    <!-- 调度指令 -->
                    <th data-options="field:'scheduleorder_s',width:80,editor:{type:'textbox'}"><spring:message code="schedulerecord.column.scheduleorder_s" /></th>
                    <!-- 调度物料 -->
                    <th data-options="field:'schedulematerial_s',width:80,editor:{type:'textbox'}"><spring:message code="schedulerecord.column.schedulematerial_s" /></th>
                    <!-- 调度数量 -->
                    <th data-options="field:'schedulequantity_i',width:80,editor:{type:'textbox'}"><spring:message code="schedulerecord.column.schedulequantity_i" /></th>
                    <!-- 调度结果，0：未完成 1：完成 -->
                    <th data-options="field:'schedulestatus_s',formatter:schedulestatus,width:80,editor:{type:'textbox'}"><spring:message code="schedulerecord.column.schedulestatus_s" /></th>
                    <!-- 触发方式 0：自动:1：手动 -->
                    <th data-options="field:'scheduletype_s',formatter:scheduletype,width:80,editor:{type:'textbox'}"><spring:message code="schedulerecord.column.scheduletype_s" /></th>
                    <!-- 触发时间 -->
                    <th data-options="field:'scheduletime_t',width:80,editor:{type:'textbox'}"><spring:message code="schedulerecord.column.scheduletime_t" /></th>
                </tr>
            </thead>
        </table>
         <!-- 	导出-->    
	<jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="ScheduleRecord_search_form" />
		<jsp:param name="datagridId" value="schedulerecord_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.halfpart.excel.ScheduleRecordExportHandler"/>
		<jsp:param name="serviceName" value="ScheduleRecordServiceImpl" />
	</jsp:include>
    </div>
</body>
</html>
