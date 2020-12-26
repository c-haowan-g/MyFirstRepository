<!-- 

    作者      :王超
    时间      :2020-03-06 11:24:18 
    页面名称:半部件物料时效维护
    文件关联:
        MaterialAging.java
        MaterialAgingController.java
        MaterialAgingServiceImpl.java
        MaterialAgingServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="materialaging.js.jsp"%>
<script type="text/javascript" src="dict/105,177,302,253.js"></script>
<body class="easyui-layout" fit="true"> 
    <div class="easyui-tabs" data-options="region:'center',split:true,border:false" >
        <div title="物料组维护">
        	<div id="MaterialsPlus_dg_toolbar">
            <form id="MaterialsPlus_search_form" class="form" >
                <!-- 物料组 -->
                <spring:message code="equipmentmaterial.column.materialgroup_s" />:<input name="filter[materialgroup_s]" id="materialgroup_s" type="text" class="easyui-combobox"
                    data-options="valueField:'materialgroup_s',
				            			textField:'materialgroup_s',
                                        required:false, 
                                        url:'halfpart/baseData/materialAging/searchMaterialGroup',
										method: 'get',
									    editable:'true',
									    limitToList:false,
									    panelHeight:200,
										filter: function(q, row){  
								        var opts = $(this).combobox('options');  
								        return row[opts.textField].indexOf(q) >= 0;
								    	}"
				>
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form>
            <auth:button code="materialaging.save"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="setSameAging()"><spring:message code="button.savegroupaging" /></a></auth:button>
            　		<auth:button code="materialaging.setSameAging"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.setgroupaging" /></a></auth:button>
            <auth:button code="materialaging.no"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a></auth:button>
        	<auth:button code="materialaging.showOrHide"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="showOrHide()"><spring:message code="button.searchColumn" /></a></auth:button>
        </div>
        <table id="materialsplus_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: true,
                toolbar: '#MaterialsPlus_dg_toolbar',
                striped:true,
                method: 'get'
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 物料组 -->
                    <th data-options="field:'materialgroup_s',width:140,editor:close"><spring:message code="equipmentmaterial.column.materialgroup_s" /></th>
                    <!-- 钢丝压延垫布层数 -->
                    <th data-options="field:'site_num',formatter:toDC,width:120"><spring:message code="materialsplus.column.spare1_s" /></th>
                    <!-- 最小存放时间 -->
                    <th data-options="field:'smalltime_f',width:100,editor:{type:'numberbox',options:{
                    					required:true,
                    					editable:true,
                    					precision:0,
                    					min:0
                    					}}"><spring:message code="materialsplus.column.smalltime_f" /></th>
                    <!-- 最大存放时间 -->
                    <th data-options="field:'overtime_f',width:100,editor:{type:'numberbox',options:{
                    					required:true,
                    					editable:true,
                    					precision:0,
                    					min:0
                    					}}"><spring:message code="materialsplus.column.overtime_f" /></th>
                    <!-- 钢丝压延垫布层数 -->
                    <th data-options="field:'trx_id',formatter:toSC,width:120"><spring:message code="materialsplus.column.spare1_s" /></th>
                    <!-- 最小存放时间 -->
                    <th data-options="field:'spare1_s',width:100"><spring:message code="materialsplus.column.smalltime_f" /></th>
                    <!-- 最大存放时间 -->
                    <th data-options="field:'spare2_s',width:100"><spring:message code="materialsplus.column.overtime_f" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changed_by_s',width:50,formatter:toUserName,editor:close"><spring:message code="materialsplus.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',width:120,editor:close"><spring:message code="materialsplus.column.changed_time_t" /></th>
                </tr>
            </thead>
        </table>
        </div>
        <div title="单物料维护">
        	<div id="MaterialsPlus_dg_toolbar1">
            <form id="MaterialsPlus_search_form1" class="form" >
                <!-- 物料编码 -->
                <spring:message code="equipmentmaterial.column.materialcode_s" />:<input name="filter[materialcode_s]" id="materialcode_s" type="text" class="easyui-combobox"
                    data-options="valueField:'part_number',
				            			textField:'part_number',
                                        required:false, 
                                        url:'halfpart/baseData/materialAging/searchMaterialCode',
										method: 'get',
									    editable:'true',
									    limitToList:false,
									    panelHeight:200,
										filter: function(q, row){  
								        var opts = $(this).combobox('options');  
								        return row[opts.textField].indexOf(q) >= 0;
								    	}"
				>&nbsp;&nbsp;&nbsp;
                <!-- 物料规格 -->
                <spring:message code="equipmentmaterial.column.materialspecification_s" />:<input name="filter[materialspec_s]" id="materialspec_s" type="text" class="easyui-combobox"
                    data-options="valueField:'materialspec_s',
				            			textField:'materialspec_s',
                                        required:false, 
                                        url:'halfpart/baseData/materialAging/searchMaterialSpec',
										method: 'get',
									    editable:'true',
									    limitToList:false,
									    panelHeight:200,
										filter: function(q, row){  
								        var opts = $(this).combobox('options');  
								        return row[opts.textField].indexOf(q) >= 0;
								    	}"
				>&nbsp;&nbsp;&nbsp;
                <!-- 物料组 -->
                <spring:message code="equipmentmaterial.column.materialgroup_s" />:<input name="filter[materialgroup_s]" id="materialgroup_s" type="text" class="easyui-combobox"
                    data-options="valueField:'materialgroup_s',
				            			textField:'materialgroup_s',
                                        required:false, 
                                        url:'halfpart/baseData/materialAging/searchMaterialGroup',
										method: 'get',
									    editable:'true',
									    limitToList:false,
									    panelHeight:200,
										filter: function(q, row){  
								        var opts = $(this).combobox('options');  
								        return row[opts.textField].indexOf(q) >= 0;
								    	}"
				>
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter1()"><spring:message code="button.search" /></a>
            </form>
            <a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="singlemaintain()">
            <spring:message code="materialsing.maintain" /></a>
        	<auth:button code="materialaging.showOrHide"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="showOrHide1()"><spring:message code="button.searchColumn" /></a></auth:button>
        </div>
        <table id="materialsplus_dg1" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#MaterialsPlus_dg_toolbar1',
                striped:true,
                method: 'get'
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 物料编码 -->
                    <th data-options="field:'part_number',width:100,editor:close"><spring:message code="equipmentmaterial.column.materialcode_s" /></th>
                    <!-- 物料描述 -->
                    <th data-options="field:'description',width:100,editor:close"><spring:message code="equipmentmaterial.column.materialdescription_s" /></th>
                    <!-- 物料组 -->
                    <th data-options="field:'materialgroup_s',width:140,editor:close"><spring:message code="equipmentmaterial.column.materialgroup_s" /></th>
                    <!-- 钢丝压延垫布层数 -->
                    <th data-options="field:'spare1_s',width:120,formatter:exchange,editor:{type:'combobox',options:{
                    				    required:false,
								        editable:false,
								        data:[
								        {'value':'单层','text':'单层'},
								        {'value':'双层','text':'双层'}],
								        valueField:'value',
								        textField:'text'}}"><spring:message code="materialsplus.column.spare1_s" /></th>
                    <!-- 最小存放时间 -->
                    <th data-options="field:'smalltime_f',width:100,editor:{type:'numberbox',options:{
                    					required:true,
                    					editable:true,
                    					precision:0,
                    					min:0
                    					}}"><spring:message code="materialsplus.column.smalltime_f" /></th>
                    <!-- 最大存放时间 -->
                    <th data-options="field:'overtime_f',width:100,editor:{type:'numberbox',options:{
                    					required:true,
                    					editable:true,
                    					precision:0,
                    					min:0
                    					}}"><spring:message code="materialsplus.column.overtime_f" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changed_by_s',width:100,formatter:toUserName,editor:close"><spring:message code="materialsplus.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',width:150,editor:close"><spring:message code="materialsplus.column.changed_time_t" /></th>
                </tr>
            </thead>
        </table>
        </div>
    </div>
    <!-- 单物料维护 width=900px height=500px-->
	<div id="singlematerialmanager_dg" class="easyui-dialog" title="单物料维护"
	     data-options="closed:true,
             width:window.innerWidth,
	         height:window.innerHeight,
	         maximizable:true,
	         minimizable:true,
	         onClose:function(){
                singleclose();
             }
         ">
	    <div id="singlematerialmanager_dg_toolbar">
	        <form class="form" id="singlematerialmanager_search_form" method="post">
	            <div data-options="region:'center'">
	                <auth:button code="materialaging.edit"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit1()">
	                <spring:message code="button.edit"/></a></auth:button>
	                <auth:button code="materialaging.save"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save1()">
	                <spring:message code="button.save"/></a></auth:button>
	                <auth:button code="materialaging.no"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel1()">
	                <spring:message code="button.cancel"/></a></auth:button>
	            </div>
	        </form>
	    </div>
	    <table id="singlematerial_dg" class="easyui-datagrid"
	           data-options="
                    fit:true,
                    fitColumns:false,
			        singleSelect:false,
			        autoRowHeight:true,
			        rownumbers:true,
			        toolbar:'#singlematerialmanager_dg_toolbar',
			        loadMsg:'加载中。。。',
			        height:'auto',
                    method:'get',
                    emptyMsg:'暂无数据',
                    striped:true">
	        <thead>
	        <tr>
	            <th data-options="field:'atr_key',checkbox:true">ID</th>
	            <!-- 物料组 -->
                <th data-options="field:'materialgroup_s',width:140,editor:close"><spring:message code="equipmentmaterial.column.materialgroup_s" /></th>
                <!-- 物料编码 -->
                <th data-options="field:'materialcode_s',width:100,editor:close"><spring:message code="equipmentmaterial.column.materialcode_s" /></th>
                <!-- 钢丝压延垫布层数 -->
                <th data-options="field:'spare1_s',width:120,formatter:toDC"><spring:message code="materialsplus.column.spare1_s" /></th>
                <!-- 最小存放时间 -->
                <th data-options="field:'smalltime_f',width:100,editor:{type:'numberbox',options:{
                					required:true,
                					editable:true,
                					precision:0,
                					min:0
                					}}"><spring:message code="materialsplus.column.smalltime_f" /></th>
                <!-- 最大存放时间 -->
                <th data-options="field:'overtime_f',width:100,editor:{type:'numberbox',options:{
                					required:true,
                					editable:true,
                					precision:0,
                					min:0
                					}}"><spring:message code="materialsplus.column.overtime_f" /></th>
                <!-- 钢丝压延垫布层数 -->
                <th data-options="field:'spare4_s',width:120,formatter:toSCC"><spring:message code="materialsplus.column.spare1_s" /></th>
                <!-- 最小存放时间 -->
                <th data-options="field:'spare7_s',width:100"><spring:message code="materialsplus.column.smalltime_f" /></th>
                <!-- 最大存放时间 -->
                <th data-options="field:'spare8_s',width:100"><spring:message code="materialsplus.column.overtime_f" /></th>					
	        </tr>
	        </thead>
	    </table>
	</div>
    
    <%-- <!--导出-->    
	<jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="part_key" />
		<jsp:param name="formId" value="MaterialsPlus_search_form" />
		<jsp:param name="datagridId" value="materialsplus_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.halfpart.excel.MaterialAgingExportHandler" />
		<jsp:param name="serviceName" value="MaterialAgingServiceImpl" />
	</jsp:include>
	
	<!--导出-->    
	<jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="part_key" />
		<jsp:param name="formId" value="MaterialsPlus_search_form1" />
		<jsp:param name="datagridId" value="materialsplus_dg1" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.halfpart.excel.MaterialAgingExportHandler" />
		<jsp:param name="serviceName" value="MaterialAgingServiceImpl" />
	</jsp:include> --%>
</body>
</html>
