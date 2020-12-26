<!-- 

    作者      :王海霖
    时间      :2018-12-12 11:17:18 
    页面名称:硫化等级产量报表
    文件关联:
        VulcanizationGradeYiedPrint.java
        VulcanizationGradeYiedPrintController.java
        VulcanizationGradeYiedPrintServiceImpl.java
        VulcanizationGradeYiedPrintServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="vulcanizationgradeyiedprint.js.jsp"%>
<style type="text/css">
.columnTitle {
	padding: 6px 10px
}
</style>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="vulcanizationgradeyieldprint_dg_toolbar">
            <form id="vulcanizationgradeyieldprint_search_form" class="form" >
            <td class="columnTitle">
            <spring:message code="vjyp.column.begin_created_time" />:
                  	<!-- 操作时间 -->
				<input name="filter[begin_created_time]" editable="true" id="begin_created_time"
							type="text" class="easyui-datebox" style="width:170px"
							data-options="">
						到 <input name="filter[end_created_time]" editable="true" id="end_created_time"
							class="easyui-datebox" data-options="" style="width:170px">
				</td>
				<td class="columnTitle">
				<spring:message code="messapproduction.column.operate_userid_s" />:
                <!-- 操作工编号 -->
                <input name="filter[created_by_s]" like="true" id="created_by_s" type="text" class="easyui-textbox" data-options="label:''" >
               </td>
                <td class="columnTitle">
                <spring:message code="messapproduction.column.operate_usernane_s" />:
                <!-- 规格描述 -->
                <input name="filter[username]" like="true" id="username" type="text" class="easyui-textbox" data-options="label:''" >
                </td>
          <a class="easyui-linkbutton btn-yellow"data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
	     <auth:button code="LH_BB_LHCLBB_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
     </form> 
         </div>
        <table id="vulcanizationgradeyieldprint_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#vulcanizationgradeyieldprint_dg_toolbar',
                url: '',
                onDblClickRow:openDouleDatagrid,
                striped:true,
                method: 'get',
                emptyMsg:'<span><spring:message code='tip.noData'/></span>'
                ">
            <thead>
                <tr> 
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 操作工姓名 -->
                    <th data-options="field:'username',width:60,editor:{type:'textbox'}"><spring:message code="vgyp.column.name" /></th>
                    <!-- 计划量-->
                    <th data-options="field:'quantity_plan',width:60,editor:{type:'textbox'}"><spring:message code="vgyp.column.quantity_plan" /></th>
                    <!-- 产量 -->
                    <th data-options="field:'active_output',width:80,editor:{type:'textbox'}"><spring:message code="vgyp.column.active_output" /></th>
                    <!-- 一级品 -->
                    <th data-options="field:'gradea',width:80,editor:{type:'textbox'}"><spring:message code="vgyd.column.gradea" /></th>
                    <!-- 二级品 -->
                    <th data-options="field:'secondlevel',width:80,editor:{type:'textbox'}"><spring:message code="vgyp.column.secondleve" /></th>
                  	 <!-- 废品 -->
                    <th data-options="field:'waste',width:80,editor:{type:'textbox'}"><spring:message code="vgyp.column.waste" /></th> 
                 	<!--一级品率 -->
                    <th data-options="field:'first_grade',formatter:finishhours,width:80,editor:{type:'textbox'}"><spring:message code="vgyp.column.first_grade" /></th> 
              		<!--合格率 -->
                    <th data-options="field:'percentofpass',formatter:adequatecompletionrate,width:80,editor:{type:'textbox'}"><spring:message code="vgyp.column.percentofpass" /></th> 
                	<!--完成率 -->
                    <th data-options="field:'qualitycompletionrate',formatter:qualitycompletionrate,width:80,editor:{type:'textbox'}"><spring:message code="vgyp.column.completionrate" /></th> 
                </tr>
            </thead>
        </table>
    </div>
    
   <div id="w" class="easyui-window" title="机台日志" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:80%;height:60%;padding:10px;">
		<div id="Detail_dg_toolbar" >
            <form id="Detail_dg_toolbar_form" class="form" style="height:0px">
	            <td class="columnTitle">
	                  	<!-- 操作时间 -->
					<input name="filter[begin_created_time_detail]" id="begin_created_time_detail"
								type="hidden"  style="width:170px"
								data-options="">
							 <input name="filter[end_created_time_detail]"  id="end_created_time_detail"
								 type="hidden" data-options="" style="width:170px">
				    <input name="filter[usercode]"  id="usercode_detail" type="hidden"  data-options="label:''" >
				</td>
	     </form> 
         </div>
		<table id="controldetail_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                rownumbers: true,
                pagination:true,
                singleSelect: false,
                toolbar: '#Detail_dg_toolbar',
                striped:true,
                method: 'get',
                emptyMsg:'暂无数据' 
                ">
            <thead>
                <tr>
                    <!-- 班次 -->
                    <th data-options="field:'class_id_s',width:80,editor:{type:'textbox',options:{required:true}}"><spring:message code="vgyp.column.class_id_s" /></th>
                    <!-- 物料规格 -->
                    <th data-options="field:'material_code_s',width:80,editor:{type:'textbox',options:{required:true}}"><spring:message code="vgyp.column.material_code_s" /></th>
                    <!-- 物料描述 -->
                    <th data-options="field:'material_name_s',width:80,editor:{type:'textbox',options:{required:true}}"><spring:message code="vgyp.column.material_name_s" /></th>
                    <!-- 生产时间 -->
                    <th data-options="field:'production_date_s',width:80,editor:{type:'textbox',options:{required:true}}"><spring:message code="vgyp.column.production_date_s" /></th>
                    
                </tr>
            </thead>
        </table>
	</div>
	
	 <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="vulcanizationgradeyieldprint_search_form" />
		<jsp:param name="datagridId" value="vulcanizationgradeyieldprint_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.curing.excel.VulcanizationGradeYieldPrintExportHandler" />
		<jsp:param name="serviceName" value="VulcanizationGradeYieldPrintServiceImpl" />
	</jsp:include>
</body>
</html>
