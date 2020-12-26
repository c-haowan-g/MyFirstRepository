<!-- 

    作者      :司乔靖
    时间      :2018-11-28 11:37:41 
    页面名称:质检工序等级表(终检蓝英接口同步履历)
    文件关联:
        ProcessGradeLog.java
        ProcessGradeLogController.java
        ProcessGradeLogServiceImpl.java
        ProcessGradeLogServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="processgradelog.js.jsp"%>
<script type="text/javascript" src="dict/253,252.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="ProcessGradeLog_dg_toolbar">
            <form id="ProcessGradeLog_search_form" class="form" >
            <spring:message code="processgradelog.column.sync_create_time_t" />:
            <input name="filter[begin_created_time]" editable="true" id="begin_created_time"
							type="text" class="easyui-datetimebox" style="width:170px"
							data-options="label:''">
						到 <input name="filter[end_created_time]" editable="true" id="end_created_time"
							class="easyui-datetimebox" style="width:170px">
                <!-- 数据同步处理标记：0-未处理、1-已处理 -->
               <spring:message code="processgradelog.column.sync_hand_flag_s" />:
                <input name="filter[sync_hand_flag_s]" id="sync_hand_flag_s" type="text" class="easyui-combobox"
                 data-options="
                 valueField:'value',
                 textField:'text',
                data: [
                 		 {text:'请选择',
                 		 value:''},
                 		 {text: '未处理',
                         value: 2},
                         {text: '已处理',
						  value: 1
						}]" />
                  <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
           	  	<auth:button code="XXX"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            </form> 
                  </div>
        <table id="processgradelog_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#ProcessGradeLog_dg_toolbar',
                url: 'finalcheck/standardmagement/processgradelog/datagrid',
                striped:true,
                emptyMsg:'<span><spring:message code='tip.noData'/></span>',
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 数据同步创建时间 -->
                    <th data-options="field:'sync_create_time_t',editor:{type:'textbox'}"><spring:message code="processgradelog.column.sync_create_time_t" /></th>
                    <!-- 数据同步处理：A-新增、U-修改、D-删除 -->
                    <th data-options="field:'sync_flag_s',formatter:syncflagFormatter,editor:{type:'textbox'}"><spring:message code="processgradelog.column.sync_flag_s" /></th>
                    <!-- 数据同步处理标记：0-未处理、1-已处理 -->
                    <th data-options="field:'sync_hand_flag_s',formatter:handflagFormatter,editor:{type:'textbox'}"><spring:message code="processgradelog.column.sync_hand_flag_s" /></th>
                    <!-- 数据同步处理反馈 -->
                    <th data-options="field:'sync_hand_msg_s',editor:{type:'textbox'}"><spring:message code="processgradelog.column.sync_hand_msg_s" /></th>
                    <!-- 数据同步处理时间 -->
                    <th data-options="field:'sync_hand_time_t',editor:{type:'textbox'}"><spring:message code="processgradelog.column.sync_hand_time_t" /></th>
                     <!-- 创建人 -->
                    <th data-options="field:'created_b_s',editor:{type:'textbox'}"><spring:message code="processgradelog.column.created_b_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',editor:{type:'textbox'}"><spring:message code="processgradelog.column.created_time_t" /></th>
                    <!-- 质量等级编码 -->
                    <th data-options="field:'gradecode_i',editor:{type:'textbox'}"><spring:message code="processgradelog.column.gradecode_i" /></th>
                    <!-- 质量等级描述 -->
                    <th data-options="field:'gradedesc_s',editor:{type:'textbox'}"><spring:message code="processgradelog.column.gradedesc_s" /></th>
                    
                                              <!-- 修改人 -->
                    <th data-options="field:'changed_by_s',editor:{type:'textbox'}"><spring:message code="processgradelog.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',editor:{type:'textbox'}"><spring:message code="processgradelog.column.changed_time_t" /></th>
                                       <!-- 工序描述 -->
                    <th data-options="field:'proessdesc_s',editor:{type:'textbox'}"><spring:message code="processgradelog.column.proessdesc_s" /></th>
                    <!-- 工序 -->
                    <th data-options="field:'proess_i',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="processgradelog.column.proess_i" /></th>
                    <!-- 记录标记，A可用，D删除 -->
                    <th data-options="field:'record_flag_s',formatter:recordflagFormatter,editor:{type:'textbox'}"><spring:message code="processgradelog.column.record_flag_s" /></th>
                     <!-- 机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004 -->
                    <th data-options="field:'agenc_no_s',formatter:agencFormatter,editor:{type:'textbox'}"><spring:message code="processgradelog.column.agenc_no_s" /></th>
          
                    <!-- 工厂(1.全钢 2.半钢) -->
                    <th data-options="field:'s_factory_s',formatter:factoryFormatter,editor:{type:'textbox'}"><spring:message code="processgradelog.column.s_factory_s" /></th>
                    <!-- 归档标记 -->
                    <th data-options="field:'arch_flag_s',editor:{type:'textbox'}"><spring:message code="processgradelog.column.arch_flag_s" /></th>
                     <!-- 优先级 -->
                    <th data-options="field:'sort_i',editor:{type:'textbox'}"><spring:message code="processgradelog.column.sort_i" /></th>
                    <!-- 备注 -->
                    <th data-options="field:'remark_s',editor:{type:'textbox'}"><spring:message code="processgradelog.column.remark_s" /></th>
                    <!-- 备用字段1 -->
                    <th data-options="field:'spare1_s',editor:{type:'textbox'}"><spring:message code="processgradelog.column.spare1_s" /></th>
                    <!-- 备用字段2 -->
                    <th data-options="field:'spare2_s',editor:{type:'textbox'}"><spring:message code="processgradelog.column.spare2_s" /></th>
                    <!-- 备用字段3 -->
                    <th data-options="field:'spare3_s',editor:{type:'textbox'}"><spring:message code="processgradelog.column.spare3_s" /></th>
                    <!-- 备用字段4 -->
                    <th data-options="field:'spare4_s',editor:{type:'textbox'}"><spring:message code="processgradelog.column.spare4_s" /></th>
                    <!-- 备用字段5 -->
                    <th data-options="field:'spare5_s',editor:{type:'textbox'}"><spring:message code="processgradelog.column.spare5_s" /></th>
                  </tr>
            </thead>
        </table>
    </div>
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="ProcessGradeLog_search_form" />
		<jsp:param name="datagridId" value="processgradelog_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.finalcheck.excel.ProcessGradeLogExportHandler" />
		<jsp:param name="serviceName" value="ProcessGradeLogServiceImpl" />
	</jsp:include>
</body>
</html>
