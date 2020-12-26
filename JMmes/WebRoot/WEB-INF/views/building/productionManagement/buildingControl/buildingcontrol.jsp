<!-- 

    作者      :时永良
    时间      :2019-01-12 11:28:38 
    页面名称:成型机台开关控制管理
    文件关联:
        BuildingControl.java
        BuildingControlController.java
        BuildingControlServiceImpl.java
        BuildingControlServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="buildingcontrol.js.jsp"%>
<script type="text/javascript" src="dict/101,196,211,320.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="BuildingControl_dg_toolbar">
            <form id="BuildingControl_search_form" class="form" >
                <!-- 机台名称 -->
                <spring:message code="machinecontrol.column.machinename_s" />:<input  class="easyui-combobox" name="filter[machinename_s]" id="machinename_s" like="true" style="width:15%" 
                       		 data-options="valueField:'DESCRIPTION',
				            			textField:'DESCRIPTION',
                                        required:false, 
                                        url:'building/productionManagement/buildingControl/searchDescription',
										method: 'get',
									    editable:'true',
									    limitToList:false,
									    panelHeight:150,
										filter: function(q, row){  
								        var opts = $(this).combobox('options');  
								        return row[opts.textField].indexOf(q) >= 0;//这里改成>=即可在任意地方匹配  
								    	}">&nbsp;&nbsp;&nbsp;
                <!-- 机台状态  数据字典 101 -->
                <spring:message code="machinecontrol.column.isused_s" />:<input name="filter[machinestatus_s]" id="machinestatus_s" like="true" style="width:15%" type="text" class="easyui-combotree" data-options="label:'',
						                  panelHeight:200,
						                  labelWidth:'auto',
										  panelWidth:'15%',
										  required:false,
										  url:'dict/code/101',
										  method:'get'" >&nbsp;&nbsp;&nbsp;
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
                <auth:button code="buildingcontrol.export"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
		        <auth:button code="buildingcontrol.logFile"><a href="javascript:void(0)" class="easyui-linkbutton btn-black" data-options="iconCls:'icon-save'" onclick="openWindow()"><spring:message code="button.logFile" /></a></auth:button>
		       	<auth:button code="buildingcontrol.showOrHide"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="showOrHide()"><spring:message code="button.searchColumn" /></a></auth:button>
           <div id="button_area" class="easyui-panel">
	       </div>
        </div>
        
        <table id="buildingcontrol_dg" class="easyui-datagrid" style="width:100%">
        </table>
    </div>
    <div id="w" class="easyui-window" title="机台开关履历" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:100%;height:100%;padding:10px;">
	   <div id="Usecontrollog_dg_toolbar"> 	
		<form id="Usecontrollog_search_form" class="form" >
		        <!-- 机台 -->
                <spring:message code="buildingcontrol.column.machinebarcode_s" />:
                <input name="filter[machinebarcode_s]" id="machinebarcode_s" like="true" type="text" class="easyui-textbox" data-options="label:''" >
		        <!-- 操作人 -->
                <spring:message code="buildingcontrol.column.changedby" />:
                <input name="filter[changed_by_name]" id="changed_by_name" like="true" type="text" class="easyui-textbox" data-options="label:''" >
		        <!-- 操作时间 -->
		        <spring:message code="buildingcontrol.column.changedtime" />:
                <input name="filter[begin_created_time]" editable="true" id="begin_created_time"
									type="text" class="easyui-datetimebox" style="width:165px"
									data-options="label:''">
								到 <input name="filter[end_created_time]" editable="true" id="end_created_time"
									class="easyui-datetimebox" style="width:165px">
			    <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
		</form>
	  </div>	
		<table id="usecontrollog_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                rownumbers: true,
                pagination:true,
                singleSelect: false,
                url: '',
                striped:true,
                method: 'get',
                toolbar: '#Usecontrollog_dg_toolbar',
                emptyMsg:'暂无数据' 
                ">
            <thead>
                <tr>
                    <!-- 机台条码 -->
                    <th data-options="field:'machinebarcode_s',width:60,editor:{type:'textbox',options:{required:true}}"><spring:message code="buildingcontrol.column.machinebarcode_s" /></th>
                    <!-- 机台名称 -->
                    <th data-options="field:'machinename_s',width:60,editor:{type:'textbox',options:{required:true}}"><spring:message code="buildingcontrol.column.machinename_s" /></th>
                    <!-- 操作开关项 -->
                    <th data-options="field:'controlitem_s',formatter:codeFormatter,width:120,editor:{type:'textbox',
                                 options:{
                                 method:'get',
				                 url:'dict/code/196',
				                 required:true}}"><spring:message code="controldetail.column.operate_item_s" /></th>
                    <!-- 开关项状态(1打开/0关闭) -->
                	<th data-options="field:'controlstatus_s',formatter:showControlStatus3,width:80,editor:{type:'textbox',options:{required:true}}">
				    <spring:message code="machinecontrol.column.operate_status_s" /></th>
                	<!-- 操作人 -->
                    <th data-options="field:'changed_by_name',width:80,editor:{type:'textbox',options:{required:true}}"><spring:message code="buildingcontrol.column.changedby" /></th>
                    <!-- 操作时间 -->
                    <th data-options="field:'changed_time_t',width:80,editor:{type:'textbox',options:{required:true}}"><spring:message code="buildingcontrol.column.changedtime" /></th>
                </tr>
            </thead>
        </table>
	</div>

    <jsp:include page="../../../../inc/export.jsp">
        <jsp:param name="idField" value="atr_key"/>
        <jsp:param name="formId" value="BuildingControl_search_form"/>
        <jsp:param name="datagridId" value="buildingcontrol_dg"/>
        <jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.building.excel.BuildingControlExportHandler"/>
        <jsp:param name="serviceName" value="BuildingControlServiceImpl"/>
    </jsp:include>

</body>
</html>
