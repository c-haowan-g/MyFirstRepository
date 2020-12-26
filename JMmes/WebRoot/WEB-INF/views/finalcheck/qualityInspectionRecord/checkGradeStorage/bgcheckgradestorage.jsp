<!-- 

    作者      :徐秉正
    时间      :2020-09-04 15:18:22 
    页面名称:机检废次品入库确认表
    文件关联:
        Bgcheckgradestorage.java
        BgcheckgradestorageController.java
        BgcheckgradestorageServiceImpl.java
        BgcheckgradestorageServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="bgcheckgradestorage.js.jsp"%>
<script type="text/javascript" src="dict/253.js"></script>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="Checkgradestorage_dg_toolbar">
            <form id="Checkgradestorage_search_form" class="form" >
                <!-- 轮胎品号 -->
                <spring:message code="checkgradestorage.column.materialcode_s" />:
                <input name="filter[materialcode_s]" id="materialcode_s" type="text" class="easyui-textbox" data-options="label:''" >&nbsp;&nbsp;&nbsp;
                <!-- 规格名称 -->
                <spring:message code="checkgradestorage.column.materialname_s" />:
                <input name="filter[materialname_s]" id="materialname_s" type="text" class="easyui-textbox" data-options="label:''" ><br>
                
                <!-- 操作时间 -->
                <spring:message code="checkgradestorage.column.operatortime_t" />:&nbsp;<input name="filter[begintime]" editable="true" id="begin_created_time" type="text" class="easyui-datetimebox" style="width:170px" data-options="label:''">
				&nbsp;&nbsp;&nbsp;到 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="filter[endtime]" editable="true" id="end_created_time" type="text" class="easyui-datetimebox" style="width:170px" data-options="label:''">&nbsp;&nbsp;&nbsp;<br>
                
                <span>选择：</span>
	           	<!--汇总-->
	           	<input style="position:relative;top:2px" class="easyui-checkbox" type="checkbox" name="filter[huizong_s]" id="huizong_s" data-options="label:'',checked:true,onChange:filter"/>
	           	<spring:message code="checkgradestorage.column.sum_s" />
	           	<!-- 详细 -->
	           	<input style="position:relative;top:2px" class="easyui-checkbox" type="checkbox" name="filter[xiangxi_s]" id="xiangxi_s" data-options="label:'',checked:true,onChange:filter"/>
	           	<spring:message code="checkgradestorage.column.all_s" />
            </form> 
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            <auth:button code="ZJ_ZJLL_BAN_GANG_CHECKGRADESTORAGE_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            　
            　
        </div>
        <table id="checkgradestorage_dg" class="easyui-datagrid" 
           data-options="
          	      pagination:true,
                  fit:true,
                  fitColumns:false,
			      singleSelect:false,
			      autoRowHeight:true,
			      rownumbers:true,
			      loadMsg:'加载中。。。',
			      toolbar: '#Checkgradestorage_dg_toolbar',
                  method:'get',
                  emptyMsg:'暂无数据',
                  striped:true
                 ">
            </table>
            <%-- <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004 -->
                    <th data-options="field:'agenc_no_s',editor:{type:'textbox'}"><spring:message code="checkgradestorage.column.agenc_no_s" /></th>
                    <!-- 动均等级 -->
                    <th data-options="field:'balnaceuniformgrade_s',editor:{type:'textbox'}"><spring:message code="checkgradestorage.column.balnaceuniformgrade_s" /></th>
                    <!-- 轮胎条码 -->
                    <th data-options="field:'barcode_s',editor:{type:'textbox'}"><spring:message code="checkgradestorage.column.barcode_s" /></th>
                    <!-- 总等级 -->
                    <th data-options="field:'grade_s',editor:{type:'textbox'}"><spring:message code="checkgradestorage.column.grade_s" /></th>
                    <!-- 轮胎品号 -->
                    <th data-options="field:'materialcode_s',editor:{type:'textbox'}"><spring:message code="checkgradestorage.column.materialcode_s" /></th>
                    <!-- 规格名称 -->
                    <th data-options="field:'materialname_s',editor:{type:'textbox'}"><spring:message code="checkgradestorage.column.materialname_s" /></th>
                    <!-- 操作时间 -->
                    <th data-options="field:'operatortime_t',editor:{type:'textbox'}"><spring:message code="checkgradestorage.column.operatortime_t" /></th>
                    <!-- 操作人 -->
                    <th data-options="field:'operator_s',editor:{type:'textbox'}"><spring:message code="checkgradestorage.column.operator_s" /></th>
                    <!-- 记录标志A可用   D删除 -->
                    <th data-options="field:'record_flag_s',editor:{type:'textbox'}"><spring:message code="checkgradestorage.column.record_flag_s" /></th>
                    <!-- 无注释 -->
                    <th data-options="field:'spare10_s',editor:{type:'textbox'}"><spring:message code="checkgradestorage.column.spare10_s" /></th>
                    <!-- 备用字段1 -->
                    <th data-options="field:'spare1_s',editor:{type:'textbox'}"><spring:message code="checkgradestorage.column.spare1_s" /></th>
                    <!-- 备用字段2 -->
                    <th data-options="field:'spare2_s',editor:{type:'textbox'}"><spring:message code="checkgradestorage.column.spare2_s" /></th>
                    <!-- 备用字段3 -->
                    <th data-options="field:'spare3_s',editor:{type:'textbox'}"><spring:message code="checkgradestorage.column.spare3_s" /></th>
                    <!-- 备用字段4 -->
                    <th data-options="field:'spare4_s',editor:{type:'textbox'}"><spring:message code="checkgradestorage.column.spare4_s" /></th>
                    <!-- 备用字段5 -->
                    <th data-options="field:'spare5_s',editor:{type:'textbox'}"><spring:message code="checkgradestorage.column.spare5_s" /></th>
                    <!-- 备用字段6 -->
                    <th data-options="field:'spare6_s',editor:{type:'textbox'}"><spring:message code="checkgradestorage.column.spare6_s" /></th>
                    <!-- 备用字段7 -->
                    <th data-options="field:'spare7_s',editor:{type:'textbox'}"><spring:message code="checkgradestorage.column.spare7_s" /></th>
                    <!-- 备用字段8 -->
                    <th data-options="field:'spare8_s',editor:{type:'textbox'}"><spring:message code="checkgradestorage.column.spare8_s" /></th>
                    <!-- 备用字段9 -->
                    <th data-options="field:'spare9_s',editor:{type:'textbox'}"><spring:message code="checkgradestorage.column.spare9_s" /></th>
                    <!-- 工厂 -->
                    <th data-options="field:'s_factory_s',editor:{type:'textbox'}"><spring:message code="checkgradestorage.column.s_factory_s" /></th>
                </tr>
            </thead>
        </table> --%>
    </div>
     <!-- 	导出-->    
	<jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="Checkgradestorage_search_form" />
		<jsp:param name="datagridId" value="checkgradestorage_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.finalcheck.excel.BgcheckgradestorageExportHandler" />
		<jsp:param name="serviceName" value="BgcheckgradestorageServiceImpl" />
	</jsp:include>
</body>
</html>
