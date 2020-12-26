<!-- 

    作者      :边朝会
    时间      :2020-08-08 11:20:06 
    页面名称:设备报警信息表
    文件关联:
        MixAlarmData.java
        MixAlarmDataController.java
        MixAlarmDataServiceImpl.java
        MixAlarmDataServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="mixalarmdata.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="MixAlarmData_dg_toolbar">
            <form id="MixAlarmData_search_form" class="form" >
            <table class="formTable">
					<tr>
						<td class="columnData">
                 <!-- 报警时间（报警开始时间、解除报警时间） -->
                              报警时间:<input name="filter[alarm_time_s]" id="alarm_time_s" type="text" class="easyui-datebox" data-options="label:''" >
                <script type="text/javascript">
				            	$("#alarm_time_s").val(new Calendar().format("yyyy-MM-dd"));
				</script>  </td>                  
				<!-- 设备名称 -->
				<td>
                                设备类型: <input name="filter[machine_name_s]" id="machine_name_s" type="text" class="easyui-textbox" data-options="label:''" >
                  <!-- 报警名称 --></td>
                  <td>
                              报警类型:<input name="filter[alarm_type_s]" id="alarm_type_s" type="text" class="easyui-combotree" data-options="label:'',
	              			 required:false,
	              			 panelHeight:200,
	              			 url:'dict/code/059',
	              			 method:'get'" >
                <!-- 报警编码 --></td>
                <td>
                            报警编码:<input name="filter[alarm_code_s]" id="alarm_code_s" type="text" class="easyui-textbox" data-options="label:''" >
                 
                
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
                
                </td>
						</tr>
				</table>
            </form> 
        </div>
        <table id="mixalarmdata_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#MixAlarmData_dg_toolbar',
                url: 'views/mix/productionManagement/datagrid',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                 <!-- 报警ID：GUID -->
                    <th data-options="field:'alarm_id_s',editor:{type:'textbox'}">报警ID</th>
                    <!-- 设备编号（可区分不同设备） -->
                    <th data-options="field:'machine_code_s',editor:{type:'textbox'}">设备编号</th>
                    <!-- 设备名称 -->
                    <th data-options="field:'machine_name_s',editor:{type:'textbox'}">设备名称</th>
                     <!-- 触发类型 -->
                    <th data-options="field:'alarm_triangletype_s',editor:{type:'textbox'}">触发类型</th>
                     <!-- 报警类型：059001-机械故障、059002-控制系统故障、059003-通讯故障、059004-安全报警、059005-接收异常 -->
                    <th data-options="field:'alarm_type_s',editor:{type:'textbox'}">报警类型</th>
                    <!-- 报警编码 -->
                    <th data-options="field:'alarm_code_s',editor:{type:'textbox'}">报警编码</th>
                    <!-- 报警名称 -->
                    <th data-options="field:'alarm_name_s',editor:{type:'textbox'}">报警名称</th>
                    <!-- 报警时间（报警开始时间、解除报警时间） -->
                    <th data-options="field:'alarm_time_s',editor:{type:'textbox'}">报警时间</th>
                     <!-- 报警位置 -->
                    <th data-options="field:'alarm_position_s',editor:{type:'textbox'}">报警位置</th>
                    <!-- 报警内容 -->
                    <th data-options="field:'alarm_comments_s',editor:{type:'textbox'}">报警内容</th>
                    <!-- 数据来源：075001-全钢-万向、075002-全钢-北院、075003-半钢-软控、075004-半钢-万向、075005-人工配料、075006-快检、075007-地磅、075008-密炼产出、075009-MES -->
                    <th data-options="field:'datasource_s',editor:{type:'textbox'}">数据来源</th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_s',editor:{type:'textbox'}">创建人</th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',editor:{type:'textbox'}">创建时间</th>
                    <!-- 备用字段1 -->
                    <th data-options="field:'spare1_s',editor:{type:'textbox'}">备用字段1 </th>
                    <!-- 备用2：当前机台IP -->
                    <th data-options="field:'spare2_s',editor:{type:'textbox'}">备用字段2</th>
                    <!-- 备用3：生产日期：yyyyMMdd -->
                    <th data-options="field:'spare3_s',editor:{type:'textbox'}">备用字段3</th>
                    <!-- 备用4：生产班次：302001-早班、302002-中班、302003-晚班 -->
                    <th data-options="field:'spare4_s',editor:{type:'textbox'}">备用字段4</th>
                    <!-- 备用5 -->
                    <th data-options="field:'spare5_s',editor:{type:'textbox'}">备用字段5</th>
                    
                </tr>
            </thead>
        </table>
    </div>
</body>
</html>
