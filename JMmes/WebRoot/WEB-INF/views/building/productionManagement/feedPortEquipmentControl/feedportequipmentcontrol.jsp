<!-- 

    作者      :时永良
    时间      :2019年1月28日11:41:00
    页面名称:成型机台投料口控制管理
    文件关联:
        FeederNoseControl.java
        FeederNoseControlController.java
        FeederNoseControlServiceImpl.java
        FeederNoseControlServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="feedportequipmentcontrol.js.jsp"%>
<script type="text/javascript" src="dict/198,199,211,320.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="FeederNoseControl_dg_toolbar">
            <form id="FeederNoseControl_search_form" class="form" >
                <!-- 机台名称 -->
                <spring:message code="machinecontrol.column.machinename_s" />:<input class="easyui-combobox" name="filter[machinename_s]" id="machinename_s" like="true" style="width:15%" 
                                        data-options="valueField:'DESCRIPTION',
				            			textField:'DESCRIPTION',
                                        required:false, 
                                        url:'building/productionManagement/feedPortEquipmentControl/feedportequipmentcontrol/searchDescription',
										method: 'get',
									    editable:'true',
									    limitToList:false,
									    panelHeight:150,
										filter: function(q, row){  
								        var opts = $(this).combobox('options');  
								        return row[opts.textField].indexOf(q) >= 0;//这里改成>=即可在任意地方匹配  
								    	}" >&nbsp;&nbsp;&nbsp;
				<!-- 机台组 -->
				<spring:message code="machinecontrol.column.machinegroup_s" />:<input name="filter[machinegroup_s]" id="machinegroup_s" like="true" style="width:15%" type="text" class="easyui-combotree" data-options="label:'',
				                          panelHeight:200,
						                  labelWidth:'auto',
										  panelWidth:'15%',
										  required:false,
										  url:'dict/code/320',
										  method:'get'" >&nbsp;&nbsp;&nbsp;
                </form>
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="intTable()"><spring:message code="button.search" /></a>
                <auth:button code="feedernosecontrol.export"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-excel-export'" onclick="ExcelExport()"><spring:message code="button.export" /></a></auth:button>
		        <auth:button code="feedernosecontrol.logFile"><a href="javascript:void(0)" class="easyui-linkbutton btn-black" data-options="iconCls:'icon-save'" onclick="openWindow()"><spring:message code="button.kglogFile" /></a></auth:button>
		       	<auth:button code="feedernosecontrol.showOrHide"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="showOrHide()"><spring:message code="button.searchColumn" /></a></auth:button>
            <div id="button_area" class="easyui-panel">
	       	</div>
        </div>
        
        <table id="FeederNoseControl_dg" class="easyui-datagrid" style="width:100%">
        </table>
    </div>
    <div id="w" class="easyui-window" title="机台开关履历" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:80%;height:60%;padding:10px;">
		<table id="usecontrollog_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                rownumbers: true,
                singleSelect: false,
                url: 'building/productionManagement/feedPortEquipmentControl/feedportequipmentcontrol/searchByModal',
                striped:true,
                method: 'get',
                emptyMsg:'暂无数据' 
                ">
            <thead>
                <tr>
                    <!-- 机台条码 -->
                    <th data-options="field:'MACHINEBARCODE_S',width:60,editor:{type:'textbox',options:{required:true}}"><spring:message code="buildingcontrol.column.machinebarcode_s" /></th>
                    <!-- 机台名称 -->
                    <th data-options="field:'MACHINENAME_S',width:60,editor:{type:'textbox',options:{required:true}}"><spring:message code="buildingcontrol.column.machinename_s" /></th>
                    <!-- 操作开关项 -->
                    <th data-options="field:'CONTROLITEM_S',formatter:codeFormatter,width:120,editor:{type:'textbox',
                                 options:{
                                 method:'get',
				                 url:'dict/code/198',
				                 required:true}}"><spring:message code="controldetail.column.operate_item_s" /></th>
                    <!-- 开关项状态(1打开/0关闭) -->
                	<th data-options="field:'CONTROLSTATUS_S',formatter:showControlStatus,width:80,editor:{type:'textbox',options:{required:true}}">
				    <spring:message code="machinecontrol.column.operate_status_s" /></th>
                	<!-- 操作人 -->
                    <th data-options="field:'CHANGED_BY_NAME',width:80,editor:{type:'textbox',options:{required:true}}"><spring:message code="buildingcontrol.column.changedby" /></th>
                    <!-- 操作时间 -->
                    <th data-options="field:'CHANGED_TIME_T',width:80,editor:{type:'textbox',options:{required:true}}"><spring:message code="buildingcontrol.column.changedtime" /></th>
                </tr>
            </thead>
        </table>
	</div> 
	<%-- <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="BuildingControl_search_form" />
		<jsp:param name="datagridId" value="buildingcontrol_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.cx.excel.BuildingControlExportHandler" />
		<jsp:param name="serviceName" value="BuildingControlServiceImpl" />
	</jsp:include> --%>
</body>
</html>
