<!-- 

    作者      :李迺锟
    时间      :2018-08-03 14:53:59 
    页面名称:胶囊工艺标准
    文件关联:
        CapsuleStandard.java
        CapsuleStandardController.java
        CapsuleStandardServiceImpl.java
        CapsuleStandardServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="capsulestandard.js.jsp"%>
<script type="text/javascript" src="dict/204.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="CapsuleStandard_dg_toolbar">
            <form id="CapsuleStandard_search_form" class="form" >
            	<!-- 胶囊编码 -->
            	<spring:message code="capsulestandard.column.material_capsulecode_s" />:
                <input name="filter[material_capsulecode_s]" id="material_capsulecode_s" like="true" type="textbox" class="easyui-textbox" style="width:18%" data-options="label:''" >
                <!-- 胶囊规格 -->
                <spring:message code="capsulestandard.column.capsule_spec_s" />:
                <input name="filter[capsule_spec_s]" id="capsule_spec_s" like="true" type="textbox" class="easyui-textbox" style="width:18%" data-options="label:''" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="CapsuleStandard.add"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="CapsuleStandard.edit"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="CapsuleStandard.delete"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            <auth:button code="CapsuleStandard.save"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="CapsuleStandard.cancel"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            <auth:button code="machineControl.export"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            <auth:button code="CapsuleStandard.showOrHide"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-hide'" onclick="showOrHide()"><spring:message code="button.searchColumn" /></a></auth:button>
        </div>
        <table id="capsulestandard_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#CapsuleStandard_dg_toolbar',
                url: 'curing/moldmanagement/CapsuleStandard/searchBy',
                striped:true,
                method: 'get',
                emptyMsg:'暂无数据'
             
                ">
            <thead>
                <tr>
                	<th data-options="field:'atr_key',checkbox:true">ID</th>
                	<!-- 胶囊编码 -->
                    <th  data-options="field:'material_capsulecode_s',width:140,editor:{type:'combobox'}"><spring:message code="capsulestandard.column.material_capsulecode_s" /></th>
                    <!-- 胶囊规格 -->
                    <th data-options="field:'capsule_spec_s',width:180,editor:{type:'textbox'}"><spring:message code="capsulestandard.column.capsule_spec_s" /></th>
                    <!-- 厂商 -->
					<th data-options="field:'capsule_factory_s',width:180,formatter:codeFormatter,editor:{type:'combotree',options:{
                    			panelHeight:200,
                    			method:'get',
                                url:'dict/code/204',
                    			required:true}}"><spring:message code="capsulestandard.column.capsule_factory_s" /></th>
                    <!-- 校验位码 -->
                    <th data-options="field:'parity_code_s',width:80,editor:{type:'textbox'}"><spring:message code="capsulestandard.column.parity_code_s"/></th>
                    
                  <%--   <!-- 报警值 -->
                    <th data-options="field:'alarm_number_i',editor:{type:'textbox'}"><spring:message code="capsulestandard.column.alarm_number_i" /></th>
					 --%>
					<!-- 最高使用次数 -->
                    <th data-options="field:'max_limit_i',width:80,editor:{type:'numberbox',options:{min:0,precision:0}}"><spring:message code="capsulestandard.column.yujin"/></th>
                    <!-- 超上限使用次数 -->
                    <th data-options="field:'over_limit_i',width:80,editor:{type:'numberbox',options:{min:0,precision:0}}"><spring:message code="capsulestandard.column.tingji"/></th>
                	<!-- 修改人 -->
                    <th data-options="field:'changed_by_name',editor:{type:'textBox',options:{required:true}}"><spring:message code="shutdownset.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',editor:{type:'textBox',options:{required:true}}"><spring:message code="shutdownset.column.changed_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="CapsuleStandard_search_form" />
		<jsp:param name="datagridId" value="capsulestandard_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.curing.excel.CapsuleStandardExportHandler" />
		<jsp:param name="serviceName" value="CapsuleStandardServiceImpl" />
	</jsp:include>
</body>
</html>
