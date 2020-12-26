<!-- 

    作者      :lnk
    时间      :2019-01-11 17:24:50 
    页面名称:机头库存表
    文件关联:
        Mouldstock.java
        MouldstockController.java
        MouldstockServiceImpl.java
        MouldstockServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="mouldstock.js.jsp"%>
<script type="text/javascript" src="dict/153,154.js"></script>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="Mouldstock_dg_toolbar">
            <form id="Mouldstock_search_form" class="form" >
             	<!-- 机头编码 -->
             	<spring:message code="mouldstock.column.capsule_code_s" />
                :&emsp;<input name="filter[capsule_code_s]" id="capsule_code_s" type="text" class="easyui-textbox" data-options="label:''" >
               	<!-- 机头名称 -->
               	&emsp;<spring:message code="mouldstock.column.capsule_name_s" />
                :&emsp;<input name="filter[capsule_name_s]" id="capsule_name_s" type="text" class="easyui-textbox" data-options="label:''" >
               	<!-- 机头状态 -->
               	&emsp;<spring:message code="mouldstock.column.status_s" />
                :&emsp;<input name="filter[status_s]" id="status_s" type="text" class="easyui-combotree" data-options="
                  labelWidth:'auto',
				  panelWidth:'200',
				  required:false,
				  url:'dict/code/154',
				  method:'get',
				  label:''" >
               	<!-- 机头类型 -->
               	&emsp;<spring:message code="mouldstock.column.capsule_type_s" />
                :&emsp;<input name="filter[capsule_type_s]" id="capsule_type_s"   type="text" class="easyui-combotree" data-options="
                  labelWidth:'auto',
				  panelWidth:'200',
				  required:false,
				  url:'dict/code/153',
				  method:'get',
				  label:''">
				  <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="CX_BAN_GANG_JCSJ_ADD"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="CX_BAN_GANG_JCSJ_EDIT"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="CX_BAN_GANG_JCSJ_RMOVE"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            <auth:button code="CX_BAN_GANG_JCSJ_SAVE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="CX_BAN_GANG_JCSJ_CANCEL"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            <auth:button code="CX_BAN_GANG_JCSJ_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
       		
       		<auth:button code="LH_SCGL_PBCX_SEARCH"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-hide'" onclick="queryBar()"><spring:message code="button.searchColumn" /></a>  </auth:button>
        </div>
        <table id="mouldstock_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#Mouldstock_dg_toolbar',
                url: 'cx/zlgl/mouldstock/datagridUDA',
                striped:true,
                method: 'get' 
                ">
            <thead>
            
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                   	<!-- 机头编码 -->
                    <th data-options="field:'capsule_code_s',width:80,editor:{type:'textbox',options:{required:true}}"><spring:message code="mouldstock.column.capsule_code_s" /></th>
                     <!-- 机头名称 -->
                    <th data-options="field:'capsule_name_s',width:80,editor:{type:'textbox',options:{required:true}}"><spring:message code="mouldstock.column.capsule_name_s" /></th>
                    <!-- 机头状态 -->
                    <th id='status_de' data-options="field:'status_s',formatter:codeFormatter,width:80,editor:{type:'combotree',options:{
                    			method:'get',
                                url:'dict/code/154',
                                panelWidth:'300',
                    			required:true,
                    			disabled:true
                    			}}"><spring:message code="mouldstock.column.status_s" /></th>
                    <!-- 存放位置 -->
                    <th id = 'store_location_s' data-options="field:'store_location_s',mode:'remote',width:80,editor:{type:'combobox',options:{
                    			panelHeight:100,
                    			method:'get',
                    			editable:'false',
                    			url:'cx/zlgl/mouldstock/searchbylocation',
                                valueField: 'STORE_LOCATION_S',
                              	textField: 'STORE_LOCATION_S',
                              	required:true
                              	}}"><spring:message code="mouldstock.column.store_location_s" /></th>
                    <!-- 机头规格 -->
                    <th data-options="field:'capsule_specification_s',width:80,editor:{type:'textbox',options:{required:true}}"><spring:message code="mouldstock.column.capsule_specification_s" /></th>
                    <!-- 机头类型 -->
                    <th id='typecap' data-options="field:'capsule_type_s',formatter:codeFormatter,width:80,editor:{type:'combotree',options:{
                    			method:'get',
                                url:'dict/code/153',
                                panelWidth:'300',
                    			required:true,
                    			}}"><spring:message code="mouldstock.column.capsule_type_s" /></th>
                    
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_name',width:80,editor:{}"><spring:message code="mouldstock.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',width:80,editor:{}"><spring:message code="mouldstock.column.created_time_t" /></th>
                   <%--  <!-- 修改人 -->
                    <th data-options="field:'changed_by_s',width:80,editor:{type:'textbox'}"><spring:message code="mouldstock.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',width:80,editor:{type:'textbox'}"><spring:message code="mouldstock.column.changed_time_t" /></th>
                     --%>
                    <%-- <!-- 采购进厂日期 -->
                    <th data-options="field:'in_time_t',width:80,editor:{type:'textbox'}"><spring:message code="mouldstock.column.in_time_t" /></th>
                    <!-- 机头校验位码 -->
                    <th data-options="field:'parity_code_s',width:80,editor:{type:'textbox'}"><spring:message code="mouldstock.column.parity_code_s" /></th>
                    <!-- 采购人 -->
                    <th data-options="field:'purchaser_s',width:80,editor:{type:'textbox'}"><spring:message code="mouldstock.column.purchaser_s" /></th>
                    <!-- 换上时间 -->
                    <th data-options="field:'put_time_t',width:80,editor:{type:'textbox'}"><spring:message code="mouldstock.column.put_time_t" /></th>
                    <!-- 记录标志，A可用，D删除 -->
                    <th data-options="field:'record_flag_s',width:80,editor:{type:'textbox'}"><spring:message code="mouldstock.column.record_flag_s" /></th>
                    <!-- 换下时间 -->
                    <th data-options="field:'replaced_time_t',width:80,editor:{type:'textbox'}"><spring:message code="mouldstock.column.replaced_time_t" /></th>
                    <!-- 备用字段1 -->
                    <th data-options="field:'spare1_s',width:80,editor:{type:'textbox'}"><spring:message code="mouldstock.column.spare1_s" /></th>
                    <!-- 备用字段2 -->
                    <th data-options="field:'spare2_s',width:80,editor:{type:'textbox'}"><spring:message code="mouldstock.column.spare2_s" /></th>
                    <!-- 备用字段3 -->
                    <th data-options="field:'spare3_s',width:80,editor:{type:'textbox'}"><spring:message code="mouldstock.column.spare3_s" /></th>
                    <!-- 备用字段4 -->
                    <th data-options="field:'spare4_s',width:80,editor:{type:'textbox'}"><spring:message code="mouldstock.column.spare4_s" /></th>
                    <!-- 备用字段5 -->
                    <th data-options="field:'spare5_s',width:80,editor:{type:'textbox'}"><spring:message code="mouldstock.column.spare5_s" /></th>
                     --%>
                    <%-- <!-- 存放库区 -->
                    <th data-options="field:'store_area_s',width:80,editor:{type:'textbox'}"><spring:message code="mouldstock.column.store_area_s" /></th>
                    <!-- 存放位置 -->
                    <th data-options="field:'store_location_s',width:80,editor:{type:'textbox'}"><spring:message code="mouldstock.column.store_location_s" /></th>
                    <!-- 供应商编号 -->
                    <th data-options="field:'suppliers_no_s',width:80,editor:{type:'textbox'}"><spring:message code="mouldstock.column.suppliers_no_s" /></th>
                    <!-- 工厂（1全钢 2半钢） -->
                    <th data-options="field:'s_factory_s',width:80,editor:{type:'textbox'}"><spring:message code="mouldstock.column.s_factory_s" /></th>
                    <!-- 累计使用次数 -->
                    <th data-options="field:'total_number_s',width:80,editor:{type:'textbox'}"><spring:message code="mouldstock.column.total_number_s" /></th>
                    <!-- 入库人 -->
                    <th data-options="field:'user_id_s',width:80,editor:{type:'textbox'}"><spring:message code="mouldstock.column.user_id_s" /></th>
                    <!-- 入库时间 -->
                    <th data-options="field:'use_time_t',width:80,editor:{type:'textbox'}"><spring:message code="mouldstock.column.use_time_t" /></th>
                 --%>
                 </tr>
            </thead>
        </table>
        
    </div>
    <!-- 	导出-->    
	<jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="Mouldstock_search_form" />
		<jsp:param name="datagridId" value="mouldstock_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.building.excel.MouldstockExportHandler" />
		<jsp:param name="serviceName" value="MouldstockServiceImpl" />
	</jsp:include>
</body>
</html>
