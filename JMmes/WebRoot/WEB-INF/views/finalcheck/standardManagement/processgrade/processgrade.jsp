<!-- 

    作者      :李迺锟
    时间      :2018-09-04 09:27:19 
    页面名称:质检工序等级表
    文件关联:
        ProcessGrade.java
        ProcessGradeController.java
        ProcessGradeServiceImpl.java
        ProcessGradeServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="processgrade.js.jsp"%>
<script type="text/javascript" src="dict/252,253.js"></script>
<style type="text/css">
.columnTitle {
	padding: 6px 10px
}
</style>
<body class="easyui-layout" fit="true"> 
	<div class="easyui-tabs" fit="true" border="false" style="width:700px;height:250px">
		
		 <div title="规则查询" style="padding:10px">
		 
        <div id="ProcessGrade_dg_toolbar">
            <form id="ProcessGrade_search_form" class="form" >
            	<table class="formTable">
					<tr>
						  <!-- 工序 -->
						  <spring:message code="processgrade.column.proess_i" />:
                	 	  <input name="filter[proess_i]" id="proess_i"    type="text" class="easyui-combotree" data-options="
					      label:'',
                    	  required:false,
                    	  url:'dict/code/252',
                    	  method:'get'," >
						  <!-- 质量等级编码 -->
						  <spring:message code="maintyre.column.statecode_i" />:
                		  <input name="filter[gradecode_i]" id="gradecode_i"   type="text" class="easyui-combotree" data-options="
						  label:'',
                    	  required:false,
                    	  url:'dict/code/253',
                    	  method:'get'," >
							<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
						 <auth:button code="ZJ_ZJGL_DPHSMLL_DC"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
					</tr>
				</table>
            </form> 
            			<auth:button code="ZJ_ZJGL_DPHSMLL_CXL"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-undo'" onclick="searchBar()"><spring:message code="button.searchColumn" /></a></auth:button> 
               </div>
        <table id="processgrade_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#ProcessGrade_dg_toolbar',
                url: 'finalchenk/standardManagement/processgrade/datagrid',
                striped:true,
                method: 'get' ,
                onLoadSuccess: onLoadSuccess
                ">
            <thead>
                <tr>
                	<!-- 工序 -->
                     <th data-options="field:'proess_i',width:80,formatter:codeFormatter,editor:{type:'combotree',options:
                                {
                                method:'get',
                                 data:DICT_252}}"><spring:message code="processgrade.column.proess_i" /></th>            
                	 <!-- 优先级 -->
                    <th data-options="field:'sort_i',width:80"><spring:message code="processgrade.column.sort_i" /></th>
                    <!-- 质量等级描述 -->
                    <th data-options="field:'gradedesc_s',width:80"><spring:message code="processgrade.column.gradedesc_s" /></th>
                	<!-- 创建人 -->
                    <th data-options="field:'create_name',width:80"><spring:message code="processgrade.column.created_b_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',width:80"><spring:message code="processgrade.column.created_time_t" /></th>
                	 <!-- 修改人 -->
                    <th data-options="field:'change_name',width:80"><spring:message code="processgrade.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',width:80"><spring:message code="processgrade.column.changed_time_t" /></th>
                </tr>
            </thead>
        </table>
		 
	</div>
		 
	 <div title="规则维护" style="padding:10px">
	 	<div class="easyui-layout" fit="true" border="false" style="width:700px;height:350px;">	
	 	 <div data-options="region:'west',split:true" title="工序" style="width:600px;">
	 	  <table id="processgrade_dg1" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: true,
                striped:true,
                 onSelect:selectrow,
                url: 'finalchenk/standardManagement/processgrade/gongxu',
                method: 'get' ,
                ">
            <thead>
                <tr>
                	<!-- 工序 -->
                    <th data-options="field:'dictcode_s',formatter:codeFormatter,width:80,editor:{type:'textbox',options:{panelWidth:200,required:true,method:'get',
                                url:'dict/code/252'}}"><spring:message code="processgrade.column.proess_i" /></th>
                </tr>
            </thead>
        </table>
	 	 </div>
	 	   <!-- 保存界面更改情况 -->
	 	  <div data-options="region:'center',iconCls:'icon-ok'" title="已选项">
	 	  <div id="toolbar">
			<a   class="easyui-linkbutton" data-options="iconCls:'icon-save'"onclick="save2()"></a>
			</div>
	 	  	<table id="processgrade_dg2" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                striped:true,
                toolbar:'#toolbar',
                method: 'get' ,
                url: 'finalchenk/standardManagement/processgrade/dengji',
                onLoadSuccess: onLoadSuccess
                ">
            <thead>
                <tr>
                	<th data-options="field:'ck',checkbox:true"></th>
                	<!-- 等级 -->
                    <th data-options="field:'dictcode_s',formatter:codeFormatter,width:80,editor:{type:'textbox',options:{panelWidth:200,required:true,method:'get',
                                url:'dict/code/253'}}"><spring:message code="processgrade.column.dengji" /></th>
                     <!-- 等级 -->
                    <th data-options="field:'gradedesc_s',width:80,editor:{type:'textbox'}"><spring:message code="processgrade.column.dengji" /></th>
                </tr>
            </thead>
        </table>
	 	  </div>
	 	</div>
	 </div>
   	  </div>  
   	   <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="ProcessGrade_search_form" />
		<jsp:param name="datagridId" value="processgrade_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.zj.excel.ProcessGradeExportHandler" />
		<jsp:param name="serviceName" value="ProcessGradeServiceImpl" />
	</jsp:include>
	</body>
</html>
