

<!-- 胶囊模具库位维护 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="locationSetting.js.jsp"%>
<body class="easyui-layout" fit="true">
	<div data-options="region:'center',split:true,border:false" style="width:100%">
    
    <div id="cc" class="easyui-layout" style="width:100%;height:100%;">
    	<div data-options="region:'west',title:'库位类型',split:true" style="width:20%;">
		    <div style="float: left;margin-left: 10px;" id="rightC">  
		        <strong>
			        <ul id="tree" ></ul>
		        </strong>  
		    </div>  
	    </div>
	    <!-- style="width:500px;height:500px;background:red" -->
	    <div data-options="region:'center',title:'',split:true" style="width:80%;">
	    	<table class="easyui-datagrid" style="width:80%" id="dg"
			data-options="
		          fit:true,
		          fitColumns:true,
		          pagination:true,
		          rownumbers:true,
		          singleSelect:false,
		          url:'lh/jcgl/mjjnkw/getLocationSetting',
		          method:'get',
		           emptyMsg:'<span><spring:message code='tip.noData'/></span>',
		          striped:true,
		          toolbar:'#dg_toolbar,#query_bar'
		          ">
			<thead>
				<tr>
					<th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 库存条码 -->
                    <th data-options="field:'inventory_barcode_s',width:80,editor:{type:'textbox',options:{required:true}}"><spring:message code="locationsettings.column.inventory_barcode_s" /></th>
                    <!-- 库位名称 -->
                    <th data-options="field:'remarks_s',width:80,editor:{type:'textbox',options:{required:true}}"><spring:message code="locationsettings.column.remarks_s" /></th>
                     <!-- 库存编码中文 -->
                    <th data-options="field:'inventory_name_cn_s',width:80,editor:{type:'textbox',options:{required:true}}"><spring:message code="locationsettings.column.inventory_name_cn_s" /></th>
                    <!-- 库存类型 -->
                    <th data-options="field:'inventory_type_s',width:80,editor:{type:'combobox',options:{required:true,
                    data:[{value:'模具库',text:'模具库'},{value:'胶囊库',text:'胶囊库'}
					]}}"><spring:message code="locationsettings.column.inventory_type_s" /></th>
					 
					
                    <%-- <!-- 库存容量 -->
                    <th data-options="field:'inventory_capacity_s',editor:{type:'textbox'}"><spring:message code="locationsettings.column.inventory_capacity_s" /></th>
                    <!-- 库存编码 -->
                    <th data-options="field:'inventory_code_s',editor:{type:'textbox',options:{required:true}}"><spring:message code="locationsettings.column.inventory_code_s" /></th>
                    <!-- 存放物料编码 -->
                    <th data-options="field:'inventory_materialcode_s',width:80,editor:{type:'textbox'}"><spring:message code="locationsettings.column.inventory_materialcode_s" /></th> --%>
                   
                    <!-- 是否启用 -->
                    <%-- <th data-options="field:'isenable_s',width:80,editor:{type:'textbox',options:{required:true,
                    data:[{value:'1',text:'是'},{value:'2',text:'否'}
					]}}"><spring:message code="locationsettings.column.isenable_s" /></th>
                    <!-- 是否允许包含子库存  -->
                    <th data-options="field:'is_allow_child_stock_s',width:80,editor:{type:'textbox'}"><spring:message code="locationsettings.column.is_allow_child_stock_s" /></th>
                    <!-- 最后入库时间（库位推荐有关） -->
                    <th data-options="field:'lastintime_t',width:80,editor:{type:'datetimebox'}"><spring:message code="locationsettings.column.lastintime_t" /></th>
                    <!-- 入库锁定标记 -->
                    <th data-options="field:'lockflag_s',width:80,editor:{type:'textbox'}"><spring:message code="locationsettings.column.lockflag_s" /></th>
                    <!-- 发货锁定标记 -->
                    <th data-options="field:'lockoutflag_s',width:80,editor:{type:'textbox'}"><spring:message code="locationsettings.column.lockoutflag_s" /></th>
                    <!-- 父结构路径 -->
                    <th data-options="field:'parent_flag_s',width:80,editor:{type:'textbox'}"><spring:message code="locationsettings.column.parent_flag_s" /></th>
                    <!-- 父库存 -->
                    <th data-options="field:'parent_stock_s',width:80,editor:{type:'textbox'}"><spring:message code="locationsettings.column.parent_stock_s" /></th>
                    <!-- 备注 -->
                    <th data-options="field:'remarks_s',width:80,editor:{type:'textbox'}"><spring:message code="locationsettings.column.remarks_s" /></th>
                    <!-- 存放物料质量状态 -->
                    <th data-options="field:'stockqs_s',width:80,editor:{type:'textbox'}"><spring:message code="locationsettings.column.stockqs_s" /></th>
                    <!-- 存放规格 -->
                    <th data-options="field:'store_specifications_s',width:80,editor:{type:'textbox'}"><spring:message code="locationsettings.column.store_specifications_s" /></th> --%>
					<%-- <!-- 更新人 -->
                    <th data-options="field:'changed_by_s'"><spring:message code="locationsettings.column.changed_by_s" /></th>
                    <!-- 更新时间 -->
                    <th data-options="field:'changed_time_t'"><spring:message code="locationsettings.column.changed_time_t" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_s'"><spring:message code="locationsettings.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t'"><spring:message code="locationsettings.column.created_time_t" /></th> --%>
				</tr>
			</thead>
		</table>
	    </div>
	</div>
		<div id="query_bar">
			<form class="form" id="condition_form"  method="post">
				
				<spring:message code="locationsettings.column.inventory_barcode_s" />：
				<input class="easyui-textbox" name="filter[inventory_barcode_s]" id="inventory_barcode" style="width:25%">
				<spring:message code="locationsettings.column.inventory_type_s" />:
				<input class="easyui-combobox" name="filter[inventory_type_s]" id="inventory_type" style="width:35%" data-options=" editable:true,data:[{value:'模具库',text:'模具库'},{value:'胶囊库',text:'胶囊库'}]">
				<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'"  onclick="doSearch()">查询</a>
			</form>
			<form  class="form" id="tree_form"  method="post">
				<input style="display:none"  name="filter[inventory_name_cn_s]" id="inventory_name_cn_tree" >
				<input style="display:none" name="filter[inventory_type_s]" id="inventory_type_tree"  >
			</form>
		</div>
		<div style="border:none;style="padding:2px,margin:3px">
		   <div id="dg_toolbar" style="padding:2px">
				<auth:button code="LH_MJJNKW_ADD"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
				<auth:button code="LH_MJJNKW_EDIT"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
				<auth:button code="LH_MJJNKW_REMOVE"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
				<auth:button code="LH_MJJNKW_SAVE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
				<auth:button code="LH_MJJNKW_CANCEL"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a> </auth:button>
				<auth:button code="LH_MJJNKW_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a> </auth:button>
				<auth:button code="LH_MJJNKW_SEARCH"><a id="condition_button" class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="queryBar()"><spring:message code="button.searchColumn" /></a> </auth:button>
			</div>
		
		</div>
	</div>
	
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="condition_form" />
		<jsp:param name="datagridId" value="dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.lh.ExcelHandler.LocationSettingExportHandler" />
		<jsp:param name="serviceName" value="LocationSettingServiceImpl" />
	</jsp:include>
    
</body>
</html>
