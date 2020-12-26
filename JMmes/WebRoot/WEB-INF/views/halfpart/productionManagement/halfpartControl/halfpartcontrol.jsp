<!-- 

    作者      :时永良
    时间      :2020年8月18日08:11:47
    页面名称:半部件机台控制管理
    文件关联:
        HalfpartControlController.java
        HalfpartControlServiceImpl.java
        HalfpartControlServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="halfpartcontrol.js.jsp"%>
<script type="text/javascript" src="dict/101,119,211,252.js"></script> 
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="HalfpartControl_dg_toolbar">
            <form id="HalfpartControl_search_form" class="form" >
                <!-- 机台条码 -->
                <spring:message code="machinecontrol.column.machinecode_s" />
                :&emsp;<input  class="easyui-combobox" name="filter[machinecode_s]" id="machinecode_s" like="true" style="width:15%" 
                       		 data-options="valueField:'P_LINE_NAME',
				            			textField:'P_LINE_NAME',
                                        required:false, 
                                        url:'halfpart/productionManagement/halfpartControl/searchDescription',
										method: 'get',
									    editable:'true',
									    limitToList:false,
									    panelHeight:150,
										filter: function(q, row){  
								        var opts = $(this).combobox('options');  
								        return row[opts.textField].indexOf(q) >= 0;//这里改成>=即可在任意地方匹配  
								    	}">&nbsp;&nbsp;&nbsp;
				<!-- 机台类型 数据字典 211-->
				<spring:message code="machinecontrol.column.machinetype_s" />
				:&emsp;<input name="filter[machinetype_s]" id="machinetype_s" type="text" class="easyui-combobox"  
                              data-options="url:'halfpart/basedata/productlinemanager/getProductLineType',
                                            textField:'DICTNAME_S',
                                            valueField:'DICTCODE_S'">&nbsp;&nbsp;&nbsp;
                <!-- 机台状态  数据字典 101 -->
                <spring:message code="machinecontrol.column.isused_s" />
                :&emsp;<input name="filter[machinestatus_s]" id="machinestatus_s" like="true" style="width:15%" type="text" class="easyui-combotree" data-options="label:'',
						                  panelHeight:200,
						                  labelWidth:'auto',
										  panelWidth:'15%',
										  required:false,
										  url:'dict/code/101',
										  method:'get'" >&nbsp;&nbsp;&nbsp;
				<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="intTable()"><spring:message code="button.search" /></a>
                </form> 
                <auth:button code="halfpartcontrol.export"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-excel-export'" onclick="ExcelExport()"><spring:message code="button.export" /></a></auth:button>
		        <auth:button code="halfpartcontrol.logFile"><a href="javascript:void(0)" class="easyui-linkbutton btn-black" data-options="iconCls:'icon-save'" onclick="openWindow()"><spring:message code="button.logFile" /></a></auth:button>
		       	<auth:button code="halfpartcontrol.showOrHide"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="showOrHide()"><spring:message code="button.searchColumn" /></a></auth:button>
           <div id="button_area" class="easyui-panel">
	       </div>
        </div>
        
        <table id="halfpartcontrol_dg" class="easyui-datagrid" style="width:100%">
        </table>
    </div>
    <div id="w" class="easyui-window" title="机台开关履历" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:80%;height:60%;padding:10px;">
		<table id="usecontrollog_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                rownumbers: true,
                singleSelect: false,
                url: 'halfpart/productionManagement/halfpartControl/searchByModal',
                striped:true,
                method: 'get',
                emptyMsg:'暂无数据' 
                ">
            <thead>
                <tr>
                    <!-- 机台条码 -->
                    <th data-options="field:'MACHINEBARCODE_S',width:60,editor:{type:'textbox',options:{required:true}}"><spring:message code="buildingcontrol.column.machinebarcode_s" /></th>
                    <!-- 操作开关项 -->
                    <th data-options="field:'CONTROLITEM_S',formatter:codeFormatter,width:120,editor:{type:'textbox',
                                 options:{
                                 method:'get',
				                 url:'dict/code/119',
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
</body>
</html>
