<!-- 

    作者      :时永良
    时间      :2019-01-04 16:17:10 
    页面名称:质检动平衡分拣履历表
    文件关联:
        SortDynabalanceLog.java
        SortDynabalanceLogController.java
        SortDynabalanceLogServiceImpl.java
        SortDynabalanceLogServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="sortdynabalancelog.js.jsp"%>
<script type="text/javascript" src="dict/252,259,260,253.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="SortDynabalanceLog_dg_toolbar">
            <form id="SortDynabalanceLog_search_form" class="form" >
               <!-- 轮胎条码：MES_MainTyre 表 BARCODE -->
               <spring:message code="sortdynabalancelog.column.barcode_s" />:
                <input name="filter[barcode_s]" id="barcode_s" type="text" class="easyui-textbox" data-options="label:''" >
               <!-- 品号 -->
               <spring:message code="sortdynabalancelog.column.itemid_s" />:
                <input name="filter[itemid_s]" id="itemid_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 修改时间 -->
                 <spring:message code="sortappearancelog.column.sorttime_t" />:	
                <input name="filter[begin_created_time]" editable="true" id="begin_created_time"
							type="text" class="easyui-datetimebox" style="width:170px"
							data-options="label:''">
						到 <input name="filter[end_created_time]" editable="true" id="end_created_time"
							class="easyui-datetimebox" style="width:170px">
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            	<auth:button code="XXX"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            </form> 
          </div>
        <table id="sortdynabalancelog_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#SortDynabalanceLog_dg_toolbar',
                url: '',
                striped:true,
                method: 'get' ,
                 emptyMsg:'<span><spring:message code='tip.noData'/></span>',
                ">
            <thead>
                <tr>
                  <th data-options="field:'atr_key',checkbox:true"></th>
                	 <!-- 轮胎条码：MES_MainTyre 表 BARCODE -->
                    <th data-options="field:'barcode_s',width:80,editor:{type:'textbox'}"><spring:message code="sortdynabalancelog.column.barcode_s" /></th>
                    <!-- 品号 -->
                    <th data-options="field:'itemid_s',editor:{type:'textbox'}"><spring:message code="sortdynabalancelog.column.itemid_s" /></th>
                   <!-- 工序 -->
                    <th data-options="field:'proess_i',formatter:codeFormatter,editor:{type:'combotree',options:
                                {
                                method:'get',
                                 data:DICT_252}}"><spring:message code="sortdynabalancelog.column.proess_i" /></th>
                    <!-- 质量等级编码 -->
                    <th data-options="field:'gradecd_i',formatter:codeFormatter,editor:{type:'combotree',options:
                                {
                                method:'get',
                                 data:DICT_259}}"><spring:message code="sortdynabalancelog.column.gradecd_i" /></th>
                     <!-- 层：1-1#(层)、2-2#(层)、3-3#(层)、4-4#(层) -->
                    <th data-options="field:'floor_i',width:80,editor:{type:'textbox'}"><spring:message code="sortdynabalancelog.column.floor_i" /></th>
                  	 <!-- 分拣去向：MES_ZJ_Ent 表 ID -->
                    <th data-options="field:'sortmachinebar_s',width:80,editor:{type:'textbox'}"><spring:message code="sortdynabalancelog.column.sortmachinebar_s" /></th>
                     <!-- 实绩去向：MES_ZJ_Ent 表 ID -->
                    <th data-options="field:'realmachinebar_s',width:80,editor:{type:'textbox'}"><spring:message code="sortdynabalancelog.column.realmachinebar_s" /></th>
                   <!-- 分拣点：0-割毛前、1-外观前、2-外观后、3-X光后、4-动均前、5-入库前 -->
                    
                    <th data-options="field:'sorttype_i',formatter:codeFormatter,editor:{type:'combotree',options:
                                {
                                method:'get',
                                 data:DICT_260}}">
                     <spring:message code="sortdynabalancelog.column.sorttype_i" /></th>            
                     <!-- 分拣是否成功:0-失败，1-成功 -->
                    <th data-options="field:'isok_i',formatter:isokFormatter,width:80,editor:{type:'textbox'}"><spring:message code="sortdynabalancelog.column.isok_i" /></th>
                   
                    <!-- 错误类型： 1:轮胎条码不存在 2:机台信息不存在 3:规格索引不存在 4:轮胎状态不允许分配 5:轮胎规格规则未维护 6:拨胎器异常 7:机台停止 8:扫描头未读取到条码 9:其它 -->
                    <th data-options="field:'etype_i',formatter:etypeFormatter,width:80,editor:{type:'textbox'}"><spring:message code="sortdynabalancelog.column.etype_i" /></th>
                     <!-- 备注 -->
                    <th data-options="field:'remark_s',width:80,editor:{type:'textbox'}"><spring:message code="sortdynabalancelog.column.remark_s" /></th>
                   
                     <!-- 工控下发是否成功：0-成功、1-失败 -->
                    <th data-options="field:'writein_s',formatter:writeinFormatter,width:80,editor:{type:'textbox'}"><spring:message code="sortdynabalancelog.column.writein_s" /></th>
               	 <!-- 工控下发备注 -->
                    <th data-options="field:'writeinremark_s',width:80,editor:{type:'textbox'}"><spring:message code="sortdynabalancelog.column.writeinremark_s" /></th>
                   <!-- 操作时间 -->
                    <th data-options="field:'sorttime_t',editor:{type:'textbox'}"><spring:message code="sortdynabalancelog.column.sorttime_t" /></th>
                 
                   <%--  <!-- 修改人 -->
                    <th data-options="field:'changed_by_s',width:80,editor:{type:'textbox'}"><spring:message code="sortdynabalancelog.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',editor:{type:'textbox'}"><spring:message code="sortdynabalancelog.column.changed_time_t" /></th> --%>
                    <!-- 创建人 -->
                    <th data-options="field:'createname',width:80,editor:{type:'textbox'}"><spring:message code="sortdynabalancelog.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',editor:{type:'textbox'}"><spring:message code="sortdynabalancelog.column.created_time_t" /></th>
                    </tr>
            </thead>
        </table>
    </div>
     <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="formId" value="SortDynabalanceLog_search_form" />
		<jsp:param name="datagridId" value="sortdynabalancelog_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.finalcheck.excel.SortDynabalanceLogExportHandler" />
		<jsp:param name="serviceName" value="ExportServiceImpl" />
	</jsp:include>
</body>
</html>
