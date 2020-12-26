<!-- 
    作者      :司乔靖
    时间      :2018-11-28 13:33:09 
    页面名称:质检分检等级规则表(终检蓝英接口同步履历)
    文件关联:
        SortGradeLog.java
        SortGradeLogController.java
        SortGradeLogServiceImpl.java
        SortGradeLogServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="sortgradelog.js.jsp"%>
<script type="text/javascript" src="dict/253,252.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="SortGradeLog_dg_toolbar">
            <form id="SortGradeLog_search_form" class="form" >
              <spring:message code="sortgradelog.column.sync_create_time_t" />:
              <input name="filter[begin_created_time]" editable="true" id="begin_created_time"
							type="text" class="easyui-datetimebox" style="width:170px"
							data-options="label:''">
						到 <input name="filter[end_created_time]" editable="true" id="end_created_time"
							class="easyui-datetimebox" style="width:170px">
                <!-- 数据同步处理标记：0-未处理、1-已处理 -->
               <spring:message code="sortgradelog.column.sync_hand_flag_s" />:
                <input name="filter[sync_hand_flag_s]" id="sync_hand_flag_s" type="text" class="easyui-combobox"
                 data-options="
                 valueField:'value',
                 textField:'text',
                 data: [
                 		 {text: '请选择',
                         value: ''},
                 		 {text: '未处理',
                         value: 2},
                         {text: '已处理',
						  value: 1
						}]" />
              <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
           	  <auth:button code="XXX"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            </form> 
                   </div>
        <table id="sortgradelog_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#SortGradeLog_dg_toolbar',
                url: '',
                striped:true,
                 emptyMsg:'<span><spring:message code='tip.noData'/></span>',
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 数据同步创建时间 -->
                    <th data-options="field:'sync_create_time_t',editor:{type:'textbox'}"><spring:message code="sortgradelog.column.sync_create_time_t" /></th>
                    <!-- 数据同步处理：A-新增、U-修改、D-删除 -->
                    <th data-options="field:'sync_flag_s',formatter:syncflagFormatter,editor:{type:'textbox'}"><spring:message code="sortgradelog.column.sync_flag_s" /></th>
                    <!-- 数据同步处理标记：0-未处理、1-已处理 -->
                    <th data-options="field:'sync_hand_flag_s',formatter:handflagFormatter,editor:{type:'textbox'}"><spring:message code="sortgradelog.column.sync_hand_flag_s" /></th>
                    <!-- 数据同步处理反馈 -->
                    <th data-options="field:'sync_hand_msg_s',editor:{type:'textbox'}"><spring:message code="sortgradelog.column.sync_hand_msg_s" /></th>
                    <!-- 数据同步处理时间 -->
                    <th data-options="field:'sync_hand_time_t',editor:{type:'textbox'}"><spring:message code="sortgradelog.column.sync_hand_time_t" /></th>
                     <!-- 创建人 -->
                    <th data-options="field:'created_by_s',editor:{type:'textbox'}"><spring:message code="sortgradelog.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',editor:{type:'textbox'}"><spring:message code="sortgradelog.column.created_time_t" /></th>
                    <!-- D_ZJ_Ent 表 ID -->
                    <th data-options="field:'entbarcode_s',editor:{type:'textbox'}"><spring:message code="sortgradelog.column.entbarcode_s" /></th>
                    <!-- 质量等级编码 -->
                    <th data-options="field:'gradecd_i',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="sortgradelog.column.gradecd_i" /></th>
                    <!-- 质量等级描述 -->
                    <th data-options="field:'gradedesc_s',editor:{type:'textbox'}"><spring:message code="sortgradelog.column.gradedesc_s" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changed_by_s',editor:{type:'textbox'}"><spring:message code="sortgradelog.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',editor:{type:'textbox'}"><spring:message code="sortgradelog.column.changed_time_t" /></th>
                                       <!-- 下工序处理：0-不允许，1-允许 -->
                    <th data-options="field:'ischeck_i',formatter:ischeckFormatter,editor:{type:'textbox'}"><spring:message code="sortgradelog.column.ischeck_i" /></th>
                    <!-- 工序描述 -->
                    <th data-options="field:'proessdesc_s',editor:{type:'textbox'}"><spring:message code="sortgradelog.column.proessdesc_s" /></th>
                    <!-- 工序 -->
                    <th data-options="field:'proess_i',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="sortgradelog.column.proess_i" /></th>
                    <!-- 记录标志，A当前可检，D历史可检 -->
                    <th data-options="field:'record_flag_s',formatter:recordflagFormatter,editor:{type:'textbox'}"><spring:message code="sortgradelog.column.record_flag_s" /></th>
                    <!-- 分拣点描述 -->
                    <th data-options="field:'stationdesc_s',editor:{type:'textbox'}"><spring:message code="sortgradelog.column.stationdesc_s" /></th>
                    <!-- 分拣点：0-割毛前、1-外观前、4-动均前、5-入库前 -->
                    <th data-options="field:'station_i',formatter:stationFormatter,editor:{type:'textbox'}"><spring:message code="sortgradelog.column.station_i" /></th>
                    <!-- 归档标记 -->
                    <th data-options="field:'arch_flag_s',editor:{type:'textbox'}"><spring:message code="sortgradelog.column.arch_flag_s" /></th>
                  </tr>
            </thead>
        </table>
    </div>
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="SortGradeLog_search_form" />
		<jsp:param name="datagridId" value="sortgradelog_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.finalcheck.excel.SortGradeLogExportHandler" />
		<jsp:param name="serviceName" value="SortGradeLogServiceImpl" />
	</jsp:include>
</body>
</html>
