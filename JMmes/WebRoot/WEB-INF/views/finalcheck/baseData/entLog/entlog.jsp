<!-- 

    作者      :司乔靖
    时间      :2018-11-27 16:21:40 
    页面名称:质检设备信息表(终检蓝英接口同步履历)
    文件关联:
        EntLog.java
        EntLogController.java
        EntLogServiceImpl.java
        EntLogServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="entlog.js.jsp"%>
<script type="text/javascript" src="dict/254,260,255.js"></script>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="EntLog_dg_toolbar">
            <form id="EntLog_search_form" class="form" >
                <!-- 同步时间 -->
                <spring:message code="entlog.column.sync_create_time_t" />:
                <input name="filter[begin_created_time]" editable="true" id="begin_created_time"
							type="text" class="easyui-datetimebox" style="width:170px"
							data-options="label:''">
						到 <input name="filter[end_created_time]" editable="true" id="end_created_time"
							class="easyui-datetimebox" style="width:170px">
                <!-- 数据同步处理标记：0-未处理、1-已处理 -->
                <spring:message code="entlog.column.sync_hand_flag_s" />:
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
        <table id="entlog_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#EntLog_dg_toolbar',
                url: '',
                striped:true,
                 emptyMsg:'<span><spring:message code='tip.noData'/></span>',
                method: 'get' 
                ">
            <thead>
                <tr>
                 	<th data-options="field:'atr_key',checkbox:true"></th>
               		<!-- 数据同步处理-->
                	<th data-options="field:'sync_create_time_t',editor:{type:'textbox'}"><spring:message code="entlog.column.sync_create_time_t" /></th>
                    <!-- 数据同步处理：A-新增、U-修改、D-删除 -->
                    <th data-options="field:'sync_flag_s',formatter:syncflagFormatter,editor:{type:'textbox'}"><spring:message code="entlog.column.sync_flag_s" /></th>
                    <!-- 数据同步处理标记：0-未处理、1-已处理 -->
                    <th data-options="field:'sync_hand_flag_s',formatter:flagFormatter,editor:{type:'textbox'}"><spring:message code="entlog.column.sync_hand_flag_s" /></th>
                    <!-- 数据同步处理反馈 -->
                    <th data-options="field:'sync_hand_msg_s',editor:{type:'textbox'}"><spring:message code="entlog.column.sync_hand_msg_s" /></th>
                    <!-- 归档标记 -->
                    <th data-options="field:'arch_flag_s',editor:{type:'textbox'}"><spring:message code="entlog.column.arch_flag_s" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changed_by_s',editor:{type:'textbox'}"><spring:message code="entlog.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',editor:{type:'textbox'}"><spring:message code="entlog.column.changed_time_t" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_s',editor:{type:'textbox'}"><spring:message code="entlog.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',editor:{type:'textbox'}"><spring:message code="entlog.column.created_time_t" /></th>
                    <!-- 机台条码 -->
                    <th data-options="field:'entbarcode_s',editor:{type:'textbox'}"><spring:message code="entlog.column.entbarcode_s" /></th>
                    <!-- 机台名称 -->
                    <th data-options="field:'entname_s',editor:{type:'textbox'}"><spring:message code="entlog.column.entname_s" /></th>
                    <!-- 设备类：0-割毛，1-外观，2-X光机、3-动平衡、4-均匀性、5-动均一体、6-入库 -->
                    <th data-options="field:'enttype_i',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="entlog.column.enttype_i" /></th>
                    <!-- 工作状态：0-正常、1-停用、2-换轮辋、3-检修 -->
                    <th data-options="field:'iswork_i',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="entlog.column.iswork_i" /></th>
                    <!-- 程序开发逻辑名称 -->
                    <th data-options="field:'logical_address_s',editor:{type:'textbox'}"><spring:message code="entlog.column.logical_address_s" /></th>
                    <!-- 记录标志，A可用，D删除 -->
                    <th data-options="field:'record_flag_s',editor:{type:'textbox'}"><spring:message code="entlog.column.record_flag_s" /></th>
                    <!-- 所属分拣点 -->
                    <th data-options="field:'spare1_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="entlog.column.spare1_s" /></th>
                   <!-- 处理时间 -->
                    <th data-options="field:'sync_hand_time_t',editor:{type:'textbox'}"><spring:message code="entlog.column.sync_hand_time_t" /></th>
                    <!-- 工厂(1.全钢 2.半钢) -->
                    <th data-options="field:'s_factory_s',formatter:facotryFormatter,editor:{type:'textbox'}"><spring:message code="entlog.column.s_factory_s" /></th>
                    <!-- 下发道口号：1-8号分别为，1,2,3,4,5,6,7,8 -->
                    <th data-options="field:'tackno_s',editor:{type:'textbox'}"><spring:message code="entlog.column.tackno_s" /></th>
                </tr>
            </thead>
        </table>
    </div>
      <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="EntLog_search_form" />
		<jsp:param name="datagridId" value="entlog_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.finalcheck.excel.EntLogExportHandler" />
		<jsp:param name="serviceName" value="EntLogServiceImpl" />
	</jsp:include> 
</body>
</html>
