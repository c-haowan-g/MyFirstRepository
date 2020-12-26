<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="halfpartstoragezoneunit.js.jsp"%>
<script type="text/javascript" src="dict/112,308,227.js"></script>
<body class="easyui-layout" fit="true">
<!-- 主页面 --> 
<div data-options="region:'center'">
   <div id="Halfpart_zone_dg_toolbar">
      <form id="Halfpart_zone_search_form" class="form" >
         <!-- 库区条码（name-AT） -->
         <spring:message code="库区条码"/>
         :&emsp;<input name="filter[category]" id="category" type="text" like=true class="easyui-combobox" 
          data-options="label:'',
                        labelWidth:'auto',
                        panelHeight:200,
                        editable:true,
                        required:false,
                        url:'curing/basedata/storagezonemanager/searchZoneName',
                        valueField:'STORAGE_ZONE_NAME',
          			    textField:'STORAGE_ZONE_NAME',
                        method:'get'">
         <!-- 库区名称 （name-AT）-->            
         &emsp;<spring:message code="库区名称"/>
         :&emsp;<input name="filter[description]" id="description" type="text" like=true class="easyui-combobox" 
          data-options="label:'',
                        labelWidth:'auto',
                        panelHeight:200,
                        editable:true,
                        required:false,
                       data:[{value:'模具库',text:'模具库'},{value:'胶囊库',text:'胶囊库'}],
                        method:'get'">

         <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
      </form> 
      <auth:button code="HALFPART_STORAGE_ZONE_ADD1"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="zone_add()"><spring:message code="button.add" /></a></auth:button>
      <auth:button code="HALFPART_STORAGE_ZONE_EDIT1"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="zone_edit()"><spring:message code="button.edit" /></a></auth:button>
      <auth:button code="HALFPART_STORAGE_ZONE_REMOVE1"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="zone_remove()"><spring:message code="button.delete" /></a></auth:button>
      <auth:button code="HALFPART_STORAGE_ZONE_SAVE1"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="zone_save()"><spring:message code="button.save" /></a></auth:button>
      <auth:button code="HALFPART_STORAGE_ZONE_CANCEL1"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="zone_cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
      <auth:button code="HALFPART_STORAGE_ZONE_UNIT"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-curringmachine'" onclick="zone_unit()"><spring:message code="storage.unit" /></a></auth:button>
   </div> 
   <table id="halfpart_storagezone_dg"  class="easyui-datagrid"  
          data-options="  
                        fit:true,
                        fitColumns:true,
                        pagination:false,
                        rownumbers:false,
                        singleSelect:true,
                        toolbar:'#Halfpart_zone_dg_toolbar',
                        striped:true,
                        method:'get'">
       <thead>
       <tr>
          <th data-options="field:'id_key',checkbox:true"></th>
          <!-- 库区主键 -->
          <th data-options="field:'storage_zone_key',hidden:true"></th>
          <!-- 库区条码-->
          <th data-options="field:'storage_zone_name',width:100,sortable:true,editor:{type:'textbox',
                            options:{
							          required:true,
							          editable:true
                                    }}">库区条码</th>
          <!-- 库区名称 -->
          <th data-options="field:'description',width:100,sortable:true,editor:{type:'textbox',
	                       options:{
								     required:true,
								     editable:true
	                               }}">库区名称</th>
	                               
	                               
          <!-- 库区逻辑条码-->
          <th data-options="field:'inventory_barcode_s',sortable:true,hidden:true,editor:{type:'textbox',
                           options:{
							        required:false,
							        editable:true
                                  }}">库区逻辑条码</th>
                                  
          <!-- 库区种类 -->
          <th data-options="field:'storage_type_s',width:150,formatter:codeFormatter,editor:{type:'combobox',options:{
                             
                                panelWidth:'300',
                    			required:true,
                    			data:[{value:'227001',text:'模具库'},{value:'227002',text:'胶囊库'}]
								
                    			}}">库区种类</th>   
          
          <!-- 厂区 -->
          <%--<th data-options="field:'s_factory_s',width:100,formatter:s_factory_s,sortable:true,editor:{type:'combobox',
	                       options:{
								     required:true,
								     editable:true,
								     data:[
								     {'value':'0','text':'不区分'},
								     {'value':'1','text':'全钢'},
								     {'value':'2','text':'半钢'}],
								     valueField:'value',
								     textField:'text'
	                               }}">厂区</th>   --%>
	                               
          <!-- 是否包含子库uda -->
          <th data-options="field:'is_allow_child_stock_s',width:60,hidden:true,formatter:yesFormatter,sortable:true,editor:{type:'combobox',
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
          <!-- 操作时间uda  -->
	      <th data-options="field:'operatetime_t',width:100,sortable:true,editor:{type:'textbox',options:{disabled:true}}">操作时间</th>
	   </tr>
	   </thead>
   </table>
</div>
   <!-- 库位维护 width=900px height=500px-->
   <div id="halfpart_unit_manage_dg" class="easyui-dialog" title="库位维护"  
        data-options="closed:true,
                      width:900,
		              height:500,
		              maximizable:true,
		              minimizable:true">
     <div id="Halfpart_unit_dg_toolbar">
        <form class="form" id="Halfpart_unit_search_form"  method="post">
           <div data-options="region:'center'">
                 <auth:button code="HALFPART_STORAGE_UNIT_ADD"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="unit_add()"><spring:message code="button.add" /></a></auth:button>
		         <auth:button code="HALFPART_STORAGE_UNIT_EDIT"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="unit_edit()"><spring:message code="button.edit" /></a></auth:button>
		         <auth:button code="HALFPART_STORAGE_UNIT_REMOVE"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="unit_remove()"><spring:message code="button.delete" /></a></auth:button>
		         <auth:button code="HALFPART_STORAGE_UNIT_SAVE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="unit_save()"><spring:message code="button.save" /></a></auth:button>
		         <auth:button code="HALFPART_STORAGE_UNIT_CANCEL"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="unit_cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
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
              <!-- 库区条码-->
              <th data-options="field:'storage_zone_name',sortable:true,hidden:true,editor:{type:'textbox',
                                options:{
							             required:false,
							             editable:true
                                        }}">库区条码</th>
              <!-- 库位名称 -->
              <th data-options="field:'storage_unit_name',sortable:true,width:120,editor:{type:'textbox',options:{}}">库位名称</th>
              <!-- 库位描述 -->
              <th data-options="field:'description',width:180,sortable:true,editor:{type:'textbox',options:{}}">库位描述</th>
              <!-- 库位划分 -->
              <th data-options="field:'storage_zone_barcode_s',width:130,formatter:zoneDivideFormatter,sortable:true,editor:{type:'combobox',
                                options:{
                                          labelWidth:'auto',
                                          panelHeight:200,
										  required:true,
										  editable:false,
										  data:fullZoneDivide,
										  textField:'text',
										  valueField:'code',
                                        }}">库位划分</th> 
              <!-- 机台条码 -->
              <!-- <th data-options="field:'machinecode_s',width:100,sortable:true,editor:{type:'combobox',
                       options:{
                                 labelWidth:'auto',
                                 panelHeight:'200',
							     required:false,
							     editable:true,
							     url:'curing/basedata/productlinemanager/getHalfPartProductionLine',
							     valueField:'P_LINE_NAME',
					             textField:'P_LINE_NAME',
					             method:'get'
                               }}">机台条码</th> -->
             <!--  <!-- 库存容量 -->
              <!--<th data-options="field:'max_storage_duration',width:80,sortable:true,editor:{type:'numberspinner',options:{min:1,max:99}}">库存容量</th> -->
             <!--  当前库存 --> 
              <!-- <th data-options="field:'current_storage_i',width:80,sortable:true,editor:{type:'textbox',options:{readonly:true}}">当前库存</th> -->
              <!-- 存放物料编码 -->
              <th data-options="field:'inventory_materialcode_s',width:100,sortable:true,editor:{type:'textbox',options:{}}"><spring:message code="sapproductionplan.column.material_code_s" /></th>
              <!-- 存放物料名称 -->
              <th data-options="field:'inventory_materialname_s',width:100,sortable:true,editor:{type:'textbox',options:{}}"><spring:message code="sapproductionplan.column.material_name_s" /></th>
              <!-- 最后入库时间 uda-->
             <!-- <th data-options="field:'lastintime_t',width:120,sortable:true,editor:{type:'textbox',options:{readonly:true}}">最后入库时间</th> -->
              <!-- 启用/停用 -->
              <!--<th data-options="field:'canuse_s',width:90,formatter:stopFormatter,sortable:true,editor:{type:'combobox',
                                options:{
										  required:true,
										  editable:false,
										  data:[{value:'0',text:'停用'},{value:'1',text:'启用'}],
										  textField:'text',
										  valueField:'value'
                                        }}">启用/停用</th>  -->
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
              <!-- <th data-options="field:'lockinflag_s',width:100,formatter:lockFormatter,sortable:true,editor:{type:'combobox',
                                options:{
										  required:true,
										  editable:false,
										  data:[{value:'0',text:'未锁定'},{value:'1',text:'已锁定'}],
										  textField:'text',
										  valueField:'value'
                                        }}">入库锁定</th>  -->
              <!-- 出库锁定 -->
              <!-- <th data-options="field:'lockoutflag_s',width:100,formatter:lockFormatter,sortable:true,editor:{type:'combobox',
                                options:{
										  required:true,
										  editable:false,
										  data:[{value:'0',text:'未锁定'},{value:'1',text:'已锁定'}],
										  textField:'text',
										  valueField:'value'
                                        }}">出库锁定</th>  -->
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
