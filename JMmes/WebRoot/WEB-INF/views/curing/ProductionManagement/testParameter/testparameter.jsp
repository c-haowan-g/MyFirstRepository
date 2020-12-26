<!-- 

    作者      :whl
    时间      :2018-09-04 18:37:22 
    页面名称:工艺参数查询
    文件关联:
        PlanCuringParameter.java
        PlanCuringParameterController.java
        PlanCuringParameterServiceImpl.java
        PlanCuringParameterServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="testparameter.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
		<form id="testparameter_form" > 
			<!-- 机台号 -->
	        <spring:message code="plancuringparameter.column.equip_code_s" />:
	         <input  class="easyui-combobox" name="equip_code_s" id="equip_code_s" style="width:25%" 
                        data-options="	valueField:'EQUIP_CODE_S',
				            			textField:'EQUIP_CODE_S',
                                        required:false, 
                                        url:'curing/ProductionManagement/testParameter/getDataByStatus',
										method: 'get',
									    editable:'true',
									    limitToList:false,
									    panelHeight:300,
									    onClick:onChangePlan,
										filter: function(q, row){  
								        var opts = $(this).combobox('options');  
								        return row[opts.textField].indexOf(q) >= 0;//这里改成>=即可在任意地方匹配  
								    	}"> 
			<!-- 日计划号 -->
	        <spring:message code="plandayparameter.column.plan_no_s" />:
	        <input  class="easyui-combobox" name="filter[producting_dayplan_s]" id="production_dayplan_s"  style="width:25%" data-options="label:'',
                                  width:'90px',
                                 required:true, 
	                             method: 'get',
	                             editable:true,
	                             panelHeight:300,
	                             valueField:'PLAN_NO_S',
	                             textField:'PLAN_NO_S'" > 
        	<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="doSearch()"><spring:message code="button.search" /></a>
		</form>
		<div style="border:none;style="padding:2px,margin:3px">
		   <div id="dg_toolbar" style="padding:2px">
		   <auth:button code="LH_SCGL_TESTPARAMETER_SAVE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
				<auth:button code="LH_SCGL_TESTPARAMETER_EDIT"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
				<auth:button code="LH_SCGL_TESTPARAMETER_OPEN"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-add'" onclick="start()"><spring:message code="button.start" /></a> </auth:button> 
				<auth:button code="LH_SCGL_TESTPARAMETER_CLOSE"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-remove'" onclick="stop()"><spring:message code="button.stop" /></a></auth:button>
				<auth:button code="LH_SCGL_TESTPARAMETER_CANCEL"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a></auth:button>
				<auth:button code="LH_SCGL_TESTPARAMETER_EXPORT"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
				<auth:button code="LH_SCGL_TESTPARAMETER_SEARCH"><a id="condition_button" class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="queryBar()"><spring:message code="button.searchColumn" /></a> </auth:button> 
			</div>
		</div>
        			<table id="testparameter_dg" class="easyui-datagrid" style="width:100%"
			            data-options="  
			                fit:true,
			                fitColumns:true,
			                pagination:true,
			                rownumbers: true,
			                singleSelect: false,
			                toolbar: '#testparameter_form,#dg_toolbar',
			                striped:true,
			                method: 'get' ,
			                emptyMsg:'暂无数据',
			                ">
			            <thead>
			                <tr>
			                	<th data-options="field:'atr_key',checkbox:true">ID</th>
			                	<!-- 日计划号 -->
			                    <th data-options="field:'producting_dayplan_s',width:80"><spring:message code="plancuringparameter.column.producting_dayplan_s" /></th>
			                    <!-- 参数代码 -->
			                    <th data-options="field:'parameter_code_s',width:80,editor:{}"><spring:message code="plancuringparameter.column.parameter_code_s" /></th>
			                    <!-- 参数名称 -->
			                    <th data-options="field:'parameter_name_s',width:80,editor:{}"><spring:message code="plancuringparameter.column.parameter_name_s" /></th>
			                    <!-- 参数值 -->
			                    <th data-options="field:'parameter_value_s',width:80,editor:{},formatter:colorMarkingLineFormatter"><spring:message code="plancuringparameter.column.parameter_value_s" /></th>
			                    <!-- 试验胎参数值 -->
			                    <th data-options="field:'formulapara_id_s',width:80,editor:{},formatter:colorChangeFormatter"><spring:message code="plancuringparameter.column.formulapara_id_s" /></th>
			                    <!-- 试验胎标识位 -->
			                    <th data-options="field:'test_flag_s',width:80,formatter:test_flag_Text"><spring:message code="plancuringparameter.column.test_flag_s" /></th>
			                    <!-- 修改人 -->
			                    <th data-options="field:'changed_by_s',width:80,formatter:toUserName"><spring:message code="plancuringparameter.column.changed_by_s" /></th>
			                    <!-- 修改时间 -->
			                    <th data-options="field:'changed_time_t',width:80"><spring:message code="plancuringparameter.column.changed_time_t" /></th>
			                </tr>
			            </thead>
			        </table>
        		
         <!-- 	导出-->    
	<jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="testparameter_form" />
		<jsp:param name="datagridId" value="testparameter_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.curing.excel.TestParameterExportHandler" />
		<jsp:param name="serviceName" value="TestParameterServiceImpl" />
	</jsp:include>
    </div>
</body>
</html>
