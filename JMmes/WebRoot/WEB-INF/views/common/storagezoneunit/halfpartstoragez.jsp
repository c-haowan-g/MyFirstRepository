<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/meta.jsp"%>
<%@ include file="halfpartstoragezoneunit.js.jsp"%>
<script type="text/javascript" src="dict/112,308.js"></script>
<body class="easyui-layout">
	<!-- 主页面 --> 
	<div data-options="region:'center',split:true,border:false">
	   <div id="Halfpart_storage">
	      <form id="Halfpart_storage_form" class="form" >
	         <!-- 库区条码（name-AT） -->
	         <spring:message code="库区条码"/>
	         :&emsp;<input name="filter[category]" id="category" type="text"  class="easyui-combobox" 
	          data-options="label:'',
	                        labelWidth:'auto',
	                        panelHeight:200,
	                        editable:false,
	                        required:false,
	                        url:'halfpart/basedata/productlinemanager/getHalfPartProductionLine',
	                        valueField:'P_LINE_NAME',
	          			    textField:'P_LINE_NAME',
	                        method:'get'">
	         <!-- 库区名称 （name-AT）-->            
	         &emsp;<spring:message code="库区名称"/>
	         :&emsp;<input name="filter[description]" id="description" type="text"  class="easyui-combobox" 
	          data-options="label:'',
	                        labelWidth:'auto',
	                        panelHeight:200,
	                        editable:false,
	                        required:false,
	                        url:'halfpart/basedata/storagezonemanager/searchZoneName',
	                        valueField:'DESCRIPTION',
	          			    textField:'DESCRIPTION',
	                        method:'get'">
	
	         <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
	      </form> 
	      <auth:button code="HALFPART_STORAGE_ZONE"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-curringmachine'" onclick="zone_open()"><spring:message code="storage.zone" /></a></auth:button>
	      <auth:button code="HALFPART_STORAGE_UNIT"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-curringmachine'" onclick="unit_open()"><spring:message code="storage.unit" /></a></auth:button>
	   </div> 
	   <table id="halfpart_storage_dg"  class="easyui-datagrid"  
	          data-options="  
	                        fit:true,
	                        fitColumns:true,
	                        pagination:true,
	                        rownumbers: true,
	                        singleSelect: false,
	                        toolbar:'#Halfpart_storage',
	                        striped:true,
	                        method: 'get'">
	       <thead>
	       <tr>
	          <!-- 库区主键 -->
	          <th data-options="field:'storage_zone_key',checkbox:true"></th>
	          <!-- 库区条码 -->
	          <th data-options="field:'category',width:80,sortable:true">库区条码</th>
	          <!-- 库区流水条码（库区条码+4位流水号）模型表-->
	          <th data-options="field:'storage_zone_name',sortable:true,hidden:true">库区流水条码</th>
	          <!-- 库区逻辑条码-->
	          <th data-options="field:'inventory_barcode_s',sortable:true,hidden:true">库区逻辑条码</th>
	          <!-- 库区流水条码（库区条码+4位流水号）uda表-->
	          <th data-options="field:'storage_zone_barcode_s',sortable:true,hidden:true">库区逻辑条码</th>
	          <!-- 库区名称 -->
	          <th data-options="field:'description',width:100,sortable:true">库区名称</th>
	          <!-- 物料组uda -->
	          <th data-options="field:'materialgroup_s',width:100,formatter:materialGroupFormatter,sortable:true">物料组</th>
	          <!-- 是否包含子库uda -->
	          <th data-options="field:'is_allow_child_stock_s',width:60,formatter:yesFormatter,hidden:true,sortable:true">是否包含子库</th>
	          <!-- 备注uda -->
	          <th data-options="field:'remarks_s',width:100,sortable:true">备注</th>
	          <!-- 操作人uda  -->
	          <th data-options="field:'operater_s',width:80,sortable:true">操作人</th>
	          <!-- 操作时间uda  -->
		      <th data-options="field:'operatetime_t',width:100,sortable:true">操作时间</th>
		   </tr>
		   </thead>
	   </table>
	</div>
	<!-- 库区维护 --> 
	<div id="Storage_zone_manage_dg" class="easyui-dialog" title="库区维护" style="width:1000px;height:400px;" data-options="closed:true">
	   <div id="Halfpart_zone_dg_toolbar">
	      <form id="Halfpart_zone_search_form" class="form" >
            <div>
             <auth:button code="HALFPART_STORAGE_ZONE_ADD"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="zone_add()"><spring:message code="button.add" /></a></auth:button>
	         <auth:button code="HALFPART_STORAGE_ZONE_EDIT"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="zone_edit()"><spring:message code="button.edit" /></a></auth:button>
	         <auth:button code="HALFPART_STORAGE_ZONE_REMOVE"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="zone_remove()"><spring:message code="button.delete" /></a></auth:button>
	         <auth:button code="HALFPART_STORAGE_ZONE_SAVE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="zone_save()"><spring:message code="button.save" /></a></auth:button>
	         <auth:button code="HALFPART_STORAGE_ZONE_CANCEL"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="zone_cancel()"><spring:message code="button.cancel" /></a></auth:button>
            </div>
	      </form> 
	   </div> 
	   <table id="halfpart_storagezone_dg" style="width:100%" class="easyui-datagrid" 
	          data-options="  
	                        fit:true,
	                        fitColumns:true,
	                        pagination:true,
	                        autoRowHeight:true,
	                        rownumbers: true,
	                        singleSelect: false,
	                        toolbar:'#Halfpart_zone_dg_toolbar',
	                        striped:true,
	                        height:'auto',
	                        emptyMsg:'暂无数据',
	                        loadMsg:'加载中。。。',
	                        method: 'get'">
	       <thead>
	       <tr>
	          <th data-options="field:'id_key',checkbox:true"></th>
	          <!-- 库区主键 -->
	          <th data-options="field:'storage_zone_key',hidden:true"></th>
	          <!-- 库区条码 -->
	          <th data-options="field:'category',width:80,sortable:true,editor:{type:'combobox',
		                       options:{
		                                label:'',
				                        labelWidth:'auto',
				                        panelHeight:200,
				                        editable:true,
				                        required:true,
				                        url:'halfpart/basedata/productlinemanager/getHalfPartProductionLine',
				                        valueField:'P_LINE_NAME',
				          			    textField:'P_LINE_NAME',
				                        method:'get'}}">库区条码</th>
	          <!-- 库区流水条码（库区条码+4位流水号）模型表-->
	          <th data-options="field:'storage_zone_name',sortable:true,hidden:true,editor:{type:'textbox',
	                           options:{
								     required:false,
								     editable:'false'
	                               }}">库区流水条码</th>
	          <!-- 库区逻辑条码-->
	          <th data-options="field:'inventory_barcode_s',sortable:true,hidden:true,editor:{type:'textbox',                           options:{
								     required:false,
								     editable:'false'
	                               }}">库区逻辑条码</th>
	          <!-- 库区流水条码（库区条码+4位流水号）uda表-->
	          <th data-options="field:'storage_zone_barcode_s',sortable:true,hidden:true,editor:{type:'textbox',
	                           options:{
								     required:false,
								     editable:'false'
	                               }}">库区逻辑条码</th>
	          <!-- 库区名称 -->
	          <th data-options="field:'description',width:100,sortable:true,editor:{type:'textbox',
	                       options:{
								     required:true,
								     editable:'false'
	                               }}">库区名称</th>
	                                 
	          <!-- 物料组uda -->
	          <th data-options="field:'materialgroup_s',width:100,formatter:materialGroupFormatter,sortable:true,editor:{type:'combobox',
	                       options:{
	                                 panelHeight:'200',
								     required:true,
								     editable:false,
								     url:'sap/materialsPlus/getMaterialGroupList',
								     valueField:'DICTCODE_S',
						             textField:'DICTNAME_S',
						             onSelect:zoneAndMaterialGroupJudge
	                               }}">物料组</th>
	          <!-- 是否包含子库uda -->
	          <th data-options="field:'is_allow_child_stock_s',width:60,formatter:yesFormatter,hidden:true,sortable:true,editor:{type:'combobox',
	                                options:{
											  required:false,
											  editable:false,
											  data:[{value:'0',text:'否'},{value:'1',text:'是'}],
											  textField:'text',
											  valueField:'value'
	                                        }}">是否包含子库</th>
	          <!-- 备注uda -->
	          <th data-options="field:'remarks_s',width:100,sortable:true,editor:{type:'textbox',
	                       options:{
								     required:false,
								     editable:'false',
	                               }}">备注</th>
	          <!-- 操作人uda  -->
	          <th data-options="field:'operater_s',width:80,sortable:true,editor:{type:'textbox',options:{disabled:true}}">操作人</th>
	          <!-- 操作时间uda -->
		      <th data-options="field:'operatetime_t',width:100,sortable:true,editor:{type:'textbox',options:{disabled:true}}">操作时间</th>              
		   </tr>
		   </thead>
	   </table>
	</div>
	<!-- 库位维护 -->
	<div id="halfpart_unit_manage_dg" class="easyui-dialog" title="库位维护" style="width:1000px;height:400px;" data-options="closed:true">
	  <div id="Halfpart_unit_dg_toolbar">
	     <form class="form" id="Halfpart_unit_search_form"  method="post">
	        <div data-options="region:'center'">
	        <auth:button code="HALFPART_STORAGE_UNIT_ADD"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="unit_add()"><spring:message code="button.add" /></a></auth:button>
	        <auth:button code="HALFPART_STORAGE_UNIT_EDIT"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="unit_edit()"><spring:message code="button.edit" /></a></auth:button>
	        <auth:button code="HALFPART_STORAGE_UNIT_REMOVE"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="unit_remove()"><spring:message code="button.delete" /></a></auth:button>
	        <auth:button code="HALFPART_STORAGE_UNIT_SAVE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="unit_save()"><spring:message code="button.save" /></a></auth:button>
	        <auth:button code="HALFPART_STORAGE_UNIT_CANCEL"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="unit_cancel()"><spring:message code="button.cancel" /></a></auth:button>
	        </div>    
	     </form>
	  </div>  
	  <table id="halfpart_storageunit_dg" class="easyui-datagrid" 
	     data-options="
	                  fit:true,
	                  fitColumns:false,
		        singleSelect:false,
		        autoRowHeight:true,
		        rownumbers:true,
		        toolbar:'#Halfpart_unit_dg_toolbar',
		        loadMsg:'加载中。。。',
		        height:'auto',
	                  method:'get',
	                  emptyMsg:'暂无数据',
	                  striped:true">
	        <thead>
	        <tr>
	           <th data-options="field:'id_key',checkbox:true"></th>
	           <!-- 库位主键 -->
	           <th data-options="field:'storage_unit_key',hidden:true">库位主键</th>
	           <!-- 父键 -->
	           <th data-options="field:'parent_key',hidden:true">parent_key</th>
	           <!-- 库区逻辑条码 -->
	           <th data-options="field:'inventory_barcode_s',hidden:true">库区逻辑条码</th>
	           <!-- 库位划分 -->
	           <th data-options="field:'storage_zone_barcode_s',width:120,formatter:zoneDivideFormatter,sortable:true,editor:{type:'combobox',
	                             options:{
	                                       
	                                       labelWidth:'auto',
	                                       panelHeight:200,
								  required:true,
								  editable:false,
								  data:zoneDivide,
								  textField:'text',
								  valueField:'code',
								  onSelect:getMaterialCodeList
	                                     }}">库区划分</th> 
	           <!-- 库位名称 -->
	           <th data-options="field:'storage_unit_name',sortable:true,hidden:true,editor:{type:'textbox',options:{}}">库位名称</th>
	           <!-- 库位描述 -->
	           <th data-options="field:'description',width:100,sortable:true,editor:{type:'textbox',options:{}}">库位描述</th>
	           <!-- 库存容量 -->
	           <th data-options="field:'max_storage_duration',width:80,sortable:true,editor:{type:'numberspinner',options:{min:1,max:99}}">库存容量</th>
	           <!-- 当前库存 -->
	           <th data-options="field:'current_storage_i',width:80,sortable:true,editor:{type:'numberspinner',options:{min:1,max:99}}">当前库存</th>
	           <!-- 存放规格（ERP编码）-->
	           <th data-options="field:'erpcode_s',width:100,sortable:true,editor:{type:'textbox',options:{disabled:true}}">存放规格</th> 
	           <!-- 存放物料编码 -->
	           <th data-options="field:'inventory_materialcode_s',width:130,sortable:true,editor:{type:'combobox',
	                             options:{
								  required:true,
								  editable:true,
			                      valueField:'MATERIALCODE_S',
			                      textField:'MATERIALCODE_S'
	                                     }}"><spring:message code="sapproductionplan.column.material_code_s" /></th>
	           <!-- 最后入库时间 uda-->
	           <th data-options="field:'lastintime_t',width:120,sortable:true,editor:{type:'textbox',options:{disabled:true}}">最后入库时间</th> 
	           <!-- 启用/停用 -->
	           <th data-options="field:'canuse_s',width:90,formatter:stopFormatter,sortable:true,editor:{type:'combobox',
	                             options:{
								  required:true,
								  editable:false,
								  data:[{value:'0',text:'停用'},{value:'1',text:'启用'}],
								  textField:'text',
								  valueField:'value'
	                                     }}">启用/停用</th> 
	           <!-- 是否占用 -->
	           <th data-options="field:'lockflag_s',width:80,formatter:yesFormatter,sortable:true,editor:{type:'combobox',
	                             options:{
								  required:true,
								  editable:false,
								  data:[{value:'0',text:'否'},{value:'1',text:'是'}],
								  textField:'text',
								  valueField:'value'
	                                     }}">是否占用</th> 
	           <!-- 入库锁定 -->
	           <th data-options="field:'lockinflag_s',width:100,formatter:lockFormatter,sortable:true,editor:{type:'combobox',
	                             options:{
								  required:true,
								  editable:false,
								  data:[{value:'0',text:'未锁定'},{value:'1',text:'已锁定'}],
								  textField:'text',
								  valueField:'value'
	                                     }}">入库锁定</th> 
	           <!-- 出库锁定 -->
	           <th data-options="field:'lockoutflag_s',width:100,formatter:lockFormatter,sortable:true,editor:{type:'combobox',
	                             options:{
								  required:true,
								  editable:false,
								  data:[{value:'0',text:'未锁定'},{value:'1',text:'已锁定'}],
								  textField:'text',
								  valueField:'value'
	                                     }}">出库锁定</th> 
	           <!-- 操作人 -->
	           <th data-options="field:'operater_s',width:90,sortable:true,editor:{type:'textbox',options:{disabled:true}}">操作人</th> 
	           <!-- 操作时间 -->
	           <th data-options="field:'operatetime_t',sortable:true,editor:{type:'textbox',options:{disabled:true}}">操作时间</th> 
	        </tr>
	        </thead>
	    </table>
	</div>
</body>
</html>
