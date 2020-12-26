<!-- 

    作者      :周清玉
    时间      :2019-09-10 13:40:17 
    页面名称:PLM系统设备清单表
    文件关联:
        DeviceList.java
        DeviceListController.java
        DeviceListServiceImpl.java
        DeviceListServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/meta.jsp"%>
<%@ include file="devicelist.js.jsp"%>
<script type="text/javascript" src="dict/-319.js"></script>


<body class="easyui-layout" fit="true"> 
    <div data-options="region:'west',split:true" style="width:50%;" title="<spring:message code="devicelist.column.devicelist" />">
        <div id="DeviceList_dg_toolbar">
            <form id="DeviceList_search_form" class="form" >
            
            	<table class="formTable">
					<tr>
						<td class="columnTitle">
							<!-- 设备名称 -->
							<spring:message code="devicelist.column.equipmentname_s" />:
						</td>
						<td class="columnData">
							<!-- 设备名称 -->
                			<input name="filter[equipmentname_s]" id="equipmentname_s" type="text" beginWith=true class="easyui-textbox" data-options="label:'',width:'150px'" >
						</td>
						<td class="columnTitle">
							<!--设备类型名称  -->
             				<spring:message code="devicelist.column.equipmenttypename_s" />:
						</td>
						<td class="columnData">
							<!-- 设备类型名称： 10-挤出联动线 11-钢丝圈成型机 12-胎圈贴合机 16-钢丝帘布压延机 17-多刀裁断机 20-尼龙帘布一次裁断 21-尼龙帘布二次裁断 22-全钢一次法成型机 23-半钢VMI一次法成型机 25-半钢二次法成型机 -->
			                <input name="filter[equipmenttypecode_s]" id="equipmenttypename_s"  type="text" class="easyui-combotree" data-options="
			                		label:'',
			                		width:'150px',
			               			required:false,
			               			panelHeight:200,
			               			url:'dict/code/-319',
			               			method:'get'" >
						</td>
						<td class="columnTitle">
						 	<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
						</td>
					</tr>
           	   </table>
            </form> 
        </div>
        <table id="devicelist_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: true,
                onSelect:selectrow,
                toolbar: '#DeviceList_dg_toolbar',
                url: 'common/devicelist/datagrid',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <!-- 设备名称 -->
                    <th data-options="field:'equipmentname_s',width:110,editor:{type:'textbox'}"><spring:message code="devicelist.column.equipmentname_s" /></th>
                    <!-- 设备类型代码 -->
                    <th data-options="field:'equipmenttypecode_s',width:80,editor:{type:'textbox'}"><spring:message code="devicelist.column.equipmenttypecode_s" /></th>
                    <!-- 设备类型名称： 10-挤出联动线 11-钢丝圈成型机 12-胎圈贴合机 16-钢丝帘布压延机 17-多刀裁断机 20-尼龙帘布一次裁断 21-尼龙帘布二次裁断 22-全钢一次法成型机 23-半钢VMI一次法成型机 25-半钢二次法成型机 -->
                    <th data-options="field:'equipmenttypename_s',width:110,editor:{type:'textbox'}"><spring:message code="devicelist.column.equipmenttypename_s" /></th>
                    <!-- 工厂 柳州 8003 -->
                    <th data-options="field:'werks_s',width:40,editor:{type:'textbox'}"><spring:message code="curingprocess.column.werks_s" /></th>
                    <!-- 分厂 半钢 G1 全钢 G3 胎胚一次法 G1 胎胚二次法 G3 -->
                    <th data-options="field:'factory_s',width:40,editor:{type:'textbox'}"><spring:message code="buildingprocess.column.factory_s" /></th>
                    <!-- 接收时间 -->
                    <th data-options="field:'receive_time_t',width:130,editor:{type:'textbox'}"><spring:message code="devicelist.column.receive_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
    <div data-options="region:'center',split:true" title="<spring:message code="deviceparameter.column.devicelist" />" style="width:100px;">
        <table id="deviceparameter_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:false,
                singleSelect: false,
                striped:true,
                remoteSort:false,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <!-- 参数类型名称 -->
                    <th data-options="field:'PARMTYPENAME_S',sortable:true,width:90,editor:{type:'textbox'}"><spring:message code="deviceparameter.column.parmtypename_s" /></th>
                    <!-- 参数中文名称 -->
                    <th data-options="field:'PARMNAME_S',sortable:true,width:180,editor:{type:'textbox'}"><spring:message code="deviceparameter.column.parmname_s" /></th>
                    <!-- 参数值 -->
                    <th data-options="field:'VALUE_S',sortable:true,width:60,editor:{type:'textbox'}"><spring:message code="deviceparameter.column.value_s" /></th>
                    <!-- 接收时间 -->
                    <th data-options="field:'RECEIVE_TIME_T',sortable:true,width:130,editor:{type:'textbox'}"><spring:message code="deviceparameter.column.receive_time_t" /></th>
                    <!-- 参数编号 -->
                    <th data-options="field:'PARMCODE_S',sortable:true,width:70,editor:{type:'textbox'}"><spring:message code="deviceparameter.column.parmcode_s" /></th>
                    <!-- 参数类型 -->
                    <th data-options="field:'PARMTYPECODE_S',sortable:true,width:70,editor:{type:'textbox'}"><spring:message code="deviceparameter.column.parmtypecode_s" /></th>
                    <!-- 参数最大值 -->
                    <th data-options="field:'VALUEMAX_S',sortable:true,width:90,editor:{type:'textbox'}"><spring:message code="deviceparameter.column.valuemax_s" /></th>
                    <!-- 参数最大值符号 -->
                    <th data-options="field:'VALUEMAXSIGN_S',sortable:true,width:110,editor:{type:'textbox'}"><spring:message code="deviceparameter.column.valuemaxsign_s" /></th>
                    <!-- 参数最小值 -->
                    <th data-options="field:'VALUEMIN_S',sortable:true,width:80,editor:{type:'textbox'}"><spring:message code="deviceparameter.column.valuemin_s" /></th>
                    <!-- 参数最小值符号 -->
                    <th data-options="field:'VALUEMINSIGN_S',sortable:true,width:110,editor:{type:'textbox'}"><spring:message code="deviceparameter.column.valueminsign_s" /></th>
                </tr>
            </thead>
        </table>
    </div>
</body>
</html>
