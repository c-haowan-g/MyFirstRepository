<!-- 

    作者      :时永良
    时间      :2020-07-05 10:43:26 
    页面名称:半部件交接班记录表
    文件关联:
        ShifthandoverRecord.java
        ShifthandoverRecordController.java
        ShifthandoverRecordServiceImpl.java
        ShifthandoverRecordServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<script type="text/javascript" src="dict/118.js"></script>
<%@ include file="shifthandoverrecord.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="ShifthandoverRecord_dg_toolbar">
            <form id="ShifthandoverRecord_search_form" class="form" >
             <!-- 计划开始时间 -->
                <spring:message code="shifthandoverrecord.column.created_time_t" />:&emsp;<input name="filter[planstarttime_t]" id="planstarttime_t" editable="true" type="text" class="easyui-datetimebox" data-options="label:''" >&nbsp;&nbsp;&nbsp;
                                        到：<input name="filter[planfinishtime_t]" id="planfinishtime_t" editable="true" type="text" class="easyui-datetimebox" data-options="label:''" >&nbsp;&nbsp;&nbsp;
                <!-- 机台号 -->
                <spring:message code="shifthandoverrecord.column.equip_code_s" />
                :&emsp;<input name="filter[equip_code_s]" id="equip_code_s" class="easyui-combobox" 
                          data-options="
                                        labelWidth:'auto',
                                        panelHeight:150,
                                        valueField:'P_LINE_NAME',
				            			textField:'DESCRIPTION',
				            			data:productLineList,
									    editable:'true',
									    required:false, 
									    method:'get'">     
				 <!-- 班次 -->
                 &emsp;<spring:message code="shifthandoverrecord.column.class_id_s" />
                :&emsp;&emsp;<input name="filter[class_id_s]" id="class_id_s" type="text" style="width:150px" class="easyui-combobox" 
                              data-options="labelWidth:'auto',
                                            panelHeight:100,
										    required:false,
										    editable:false,
										    data:classList,
										    textField:'text',
										    valueField:'code',
										    method:'get'">					                            
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
          <auth:button code="shifthandoverrecord.export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button> 
        </div>
        <table id="shifthandoverrecord_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#ShifthandoverRecord_dg_toolbar',
                url: '',
                striped:true,
                method: 'get',
                emptyMsg: '<span><spring:message code='tip.noData'/></span>'
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 点检日期 -->
                    <th data-options="field:'check_date_s',editor:{type:'textbox'}"><spring:message code="shifthandoverrecord.column.check_date_s" /></th>
                    <!-- 班次 -->
                    <th data-options="field:'class_id_s',formatter:classCodeFormatter,editor:{type:'textbox'}"><spring:message code="shifthandoverrecord.column.class_id_s" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'createdname',editor:{type:'textbox'}"><spring:message code="shifthandoverrecord.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',editor:{type:'textbox'}"><spring:message code="shifthandoverrecord.column.created_time_t" /></th>
                    <!-- 机台条码 -->
                    <th data-options="field:'equip_code_s',formatter:equipCodeFormatter,editor:{type:'textbox'}"><spring:message code="shifthandoverrecord.column.equip_code_s" /></th>
                    <!-- 设备运转是否正常 -->
                    <th data-options="field:'itemname1_s',editor:{type:'textbox'}"><spring:message code="shifthandoverrecord.column.itemname1_s" /></th>
                    <!-- 纠偏装置是否正常 -->
                    <th data-options="field:'itemname2_s',editor:{type:'textbox'}"><spring:message code="shifthandoverrecord.column.itemname2_s" /></th>
                    <!-- 仪表显示是否正常 -->
                    <th data-options="field:'itemname3_s',editor:{type:'textbox'}"><spring:message code="shifthandoverrecord.column.itemname3_s" /></th>
                    <!-- 各项系统控制是否正常 -->
                    <th data-options="field:'itemname4_s',editor:{type:'textbox'}"><spring:message code="shifthandoverrecord.column.itemname4_s" /></th>
                    <!-- 电柜元件是否正常 -->
                    <th data-options="field:'itemname5_s',editor:{type:'textbox'}"><spring:message code="shifthandoverrecord.column.itemname5_s" /></th>
                    <!-- 金属探测仪是否正常 -->
                    <th data-options="field:'itemname6_s',editor:{type:'textbox'}"><spring:message code="shifthandoverrecord.column.itemname6_s" /></th>
                    <!-- 机械点检是否正常 -->
                    <th data-options="field:'itemname7_s',editor:{type:'textbox'}"><spring:message code="shifthandoverrecord.column.itemname7_s" /></th>
                    <!-- 电气点检是否正常 -->
                    <th data-options="field:'itemname8_s',editor:{type:'textbox'}"><spring:message code="shifthandoverrecord.column.itemname8_s" /></th>
                    <!-- 工艺标准是否正常 -->
                    <th data-options="field:'itemname9_s',editor:{type:'textbox'}"><spring:message code="shifthandoverrecord.column.itemname9_s" /></th>
                    <!-- 质量验证是否正常 -->
                    <th data-options="field:'itemname10_s',editor:{type:'textbox'}"><spring:message code="shifthandoverrecord.column.itemname10_s" /></th>
                    <!-- 生产是否正常 -->
                    <th data-options="field:'itemname11_s',editor:{type:'textbox'}"><spring:message code="shifthandoverrecord.column.itemname11_s" /></th>
                    <!-- 现场5S是否正常 -->
                    <th data-options="field:'itemname12_s',editor:{type:'textbox'}"><spring:message code="shifthandoverrecord.column.itemname12_s" /></th>
                    <!-- 不合格是否处理 -->
                    <th data-options="field:'itemname13_s',editor:{type:'textbox'}"><spring:message code="shifthandoverrecord.column.itemname13_s" /></th>
                    <!-- 设备操作是否正常 -->
                    <th data-options="field:'itemname14_s',editor:{type:'textbox'}"><spring:message code="shifthandoverrecord.column.itemname14_s" /></th>
                </tr>
            </thead>
        </table>
    </div>
   <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="ShifthandoverRecord_search_form" />
		<jsp:param name="datagridId" value="shifthandoverrecord_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.halfpart.excel.ShifthandoverRecordExportHandler" />
		<jsp:param name="serviceName" value="ShifthandoverRecordServiceImpl" />
   </jsp:include> 
</body>
</html>
