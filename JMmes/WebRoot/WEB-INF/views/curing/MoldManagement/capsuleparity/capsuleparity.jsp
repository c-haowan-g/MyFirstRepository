<!-- 

    作者      :周清玉
    时间      :2018-08-03 14:53:59 
    页面名称:胶囊校验位码维护
    文件关联:
        CapsuleParity.java
        CapsuleParityController.java
        CapsuleParityServiceImpl.java
        CapsuleParityServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="capsuleparity.js.jsp"%>
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
                <!-- 胶囊校验码 -->
                <spring:message code="capsulestandard.column.parity_code_s" />:
                <input name="filter[parity_code_s]" id="parity_code_s" like="true" type="textbox" class="easyui-textbox" style="width:18%" data-options="label:''" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="CapsuleParity.add"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="CapsuleParity.edit"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="CapsuleParity.delete"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            <auth:button code="CapsuleParity.save"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="CapsuleParity.cancel"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            <auth:button code="CapsuleParity.export"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            <auth:button code="CapsuleParity.showOrHide"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-hide'" onclick="showOrHide()"><spring:message code="button.searchColumn" /></a></auth:button>
        </div>
        <table id="capsulestandard_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#CapsuleStandard_dg_toolbar',
                url: 'curing/capsuleparity/searchBy',
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
                    <th data-options="field:'capsule_spec_s',width:240,editor:{type:'textbox'}"><spring:message code="capsulestandard.column.capsule_spec_s" /></th>
					<!-- 胶囊校验位码 -->
                    <th data-options="field:'parity_code_s',width:120,editor:{type:'textbox',options:{required:true}}"><spring:message code="capsulestandard.column.parity_code_s" /></th>
                	<!-- 修改人 -->
                    <th data-options="field:'changed_by_name',width:150,editor:{type:'textBox',options:{required:true}}"><spring:message code="shutdownset.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',width:180,editor:{type:'textBox',options:{required:true}}"><spring:message code="shutdownset.column.changed_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="CapsuleStandard_search_form" />
		<jsp:param name="datagridId" value="capsulestandard_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.lh.ExcelHandler.CapsuleParityExportHandler" />
		<jsp:param name="serviceName" value="CapsuleParityServiceImpl" />
	</jsp:include>
</body>
</html>
