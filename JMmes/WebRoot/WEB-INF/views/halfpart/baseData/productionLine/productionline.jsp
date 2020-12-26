<!--
    作者      :时永良
    时间      :2020-05-6 
    页面名称:半部件机台信息管理
    文件关联:
        HalfPartProductLineController.java
        HalfPartProductLineServiceImpl.java
        HalfPartProductLineServiceImpl.xml
-->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="productionline.js.jsp"%>
<script type="text/javascript" src="dict/115,252,211,189,320,161,308,-117,353,308,-319,328.js"></script>
<body class="easyui-layout" fit="true">
    <div id="main_page" data-options="region:'center',border:true" >
        <div id="productline_dg_tools">
            <form id="productline_dg_search_form" class="form">
            <spring:message code="机台条码"/>
            :&emsp;<input name="filter[p_line_name]" id="p_line_name" type="text" class="easyui-combobox" 
                          data-options="label:'',
                           labelWidth:'auto',
                           panelHeight:200,
                           editable:true,
                           required:false,
                           data:productLineList,
                           valueField:'P_LINE_NAME',
                           textField:'P_LINE_NAME',
                           method:'get'">
             &emsp;<spring:message code="机台名称"/>
            :&emsp;<input name="filter[description]" id="description" type="text" class="easyui-combobox" 
                          data-options="label:'',
                           labelWidth:'auto',
                           panelHeight:200,
                           editable:true,
                           required:false,
                           data:productLineList,
                           valueField:'DESCRIPTION',
                           textField:'DESCRIPTION',
                           method:'get'">
            &emsp;<%-- <spring:message code="机台类型"/>
            :&emsp;<input name="filter[category]" id="category" type="text" class="easyui-combobox"  
                              data-options="url:'halfpart/basedata/productlinemanager/getProductLineType',
                                            textField:'DICTNAME_S',
                                            valueField:'DICTCODE_S'"> --%>
            <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form>
            <auth:button code="HAIFPART_BASIC_DATA_MAINTAIN_MAINTAIN"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="productlineManage()"><spring:message code="factoryline.WH" /></a></auth:button>
            <auth:button code="HAIFPART_BASIC_DATA_FACTORYEQUIPMENT_MAINTAIN"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="equipmentModel()"><spring:message code="equipmentmodel.WH" /></a></auth:button>
            <auth:button code="HAIFPART_BASIC_DATA_EQUIPMENT_MAINTAIN"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="equipmentManage()"><spring:message code="equipment.WH" /></a></auth:button>
        </div>
          <table class="easyui-datagrid" id="productline_dg" >
            <thead>
                <tr>
                    <th data-options="field:'sss',checkbox:true" ></th>
                    <th data-options="field:'area_name',hidden:true">area名称</th>
                    <th data-options="field:'p_line_name'" >产线编号</th>
                    <th data-options="field:'description'" >产线描述</th>
                    <th data-options="field:'memo_s'" >备注</th>
                    <th data-options="field:'createby_s'" >创建人</th>
                    <th data-options="field:'createtime_t'" >创建时间</th>
					<th data-options="field:'changeby_s'" >修改人</th>
                    <th data-options="field:'changetime_t',width:300" >修改时间</th>
                </tr>
            </thead>
        </table>
  </div>
    <!-- 产线维护 style="width:1000px;height:400px;"-->
    <div id="productline_manage_dg" class="easyui-dialog" title="产线维护" 
            data-options="closed:true,
                          width:window.innerWidth,
		                  height:window.innerHeight,
                          onClose:productLineload">
            <div id="ProductLine_dg_toolbar">
             <form class="form" id="productline_add_form" action="productlineadd/save" method="post">
               <div data-options="region:'center'" title="产线信息维护" style="width:500px;" >
                  <auth:button code="HAIFPART_MAINTAIN_MAINTAIN_ADD"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="addproductline()"><spring:message code="button.add" /></a></auth:button>
                  <auth:button code="HAIFPART_MAINTAIN_MAINTAIN_EDIT"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="editproductline()"><spring:message code="button.edit" /></a></auth:button>
                  <auth:button code="HAIFPART_MAINTAIN_MAINTAIN_REMOVE"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="removeproductline()"><spring:message code="button.delete" /></a></auth:button>
                  <auth:button code="HAIFPART_MAINTAIN_MAINTAIN_SAVE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="saveproductline()"><spring:message code="button.save" /></a></auth:button>
                  <auth:button code="HAIFPART_MAINTAIN_MAINTAIN_CANCEL"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancelproductline()"><spring:message code="button.cancel" /></a>  </auth:button>
               </div>    
             </form>
         </div>  
         <table class="easyui-datagrid" style="width:100%" id="productline_dg_manage"
                data-options="
                     fit:true,
                     fitColumns:false,
                     singleSelect:false,
                     autoRowHeight:true,
                     rownumbers:true,
                     toolbar: '#ProductLine_dg_toolbar',
                     loadMsg:'加载中。。。',
                     height:'auto',
                     method:'get',
                     emptyMsg:'暂无数据',
                     striped:true">
                <thead>
                    <tr>
                        <th data-options="field:'id',width:70,checkbox:true">ID</th>
                        <th data-options="field:'area_name',width:70,hidden:true">area_name</th>
                        <th data-options="field:'p_line_name',width:80,editor:{type:'textbox',options:{required:true,validType:'length[1,100]'}}">产线条码</th>
                        <th data-options="field:'description',width:100,editor:{type:'textbox',options:{required:true,validType:'length[1,100]'}}">产线名称</th>
                        <th data-options="field:'memo_s',width:120,editor:{type:'textbox',options:{validType:'length[1,100]'}}">备注</th>
                        <th data-options="field:'createby_s',width:50">创建人</th>
                        <th data-options="field:'createtime_t',width:150">创建时间</th>
                        <th data-options="field:'changeby_s',width:50">修改人</th>
                        <th data-options="field:'changetime_t',width:150">修改时间</th>
                    </tr>
                </thead>
            </table>
    </div>
    
     <!-- 设备机型维护 -->
    <div id="equipment_model_dg" class="easyui-dialog" title="设备机型维护" style="width:900px;height:400px;"
            data-options="
                closed:true,
                width:window.innerWidth,
		        height:window.innerHeight,
                onClose:productLineload
            ">
            <div id="Equipment_model_dg_toolbar">
	         <form class="form" id="equipment_model_add_form"  method="post">
	           <div data-options="region:'center'" title="设备机型维护" style="width:1000px;" >
		          <auth:button code="HAIFPART_FACTORYEQUIP_ADD"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="addequipmentmodel()"><spring:message code="button.add" /></a></auth:button>
		          <auth:button code="HAIFPART_FACTORYEQUIP_EDIT"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="editequipmentmodel()"><spring:message code="button.edit" /></a></auth:button>
		          <auth:button code="HAIFPART_FACTORYEQUIP_REMOVE"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="removeequipmentmodel()"><spring:message code="button.delete" /></a></auth:button>
		          <auth:button code="HAIFPART_FACTORYEQUIP_SAVE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="saveequipmentmodel()"><spring:message code="button.save" /></a></auth:button>
		          <auth:button code="HAIFPART_FACTORYEQUIP_CANCEL"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancelequipmentmodel()"><spring:message code="button.cancel" /></a>  </auth:button>
		        
	           </div>    
	         </form>
         </div>  
         <table class="easyui-datagrid" style="width:100%" id="equipment_model_manage_dg"
	            data-options="
	                 fit:true,
	                 fitColumns:false,
					 singleSelect:false,
					 autoRowHeight:true,
					 rownumbers:true,
					 toolbar: '#Equipment_model_dg_toolbar',
					 loadMsg:'加载中。。。',
					 height:'auto',
	                  method:'get',
	                  emptyMsg:'暂无数据',
	                  striped:true
	                  ">
	            <thead>
	                <tr>
	                     <th data-options="field:'equip_key',width:70,checkbox:true">id</th>
	                     <th data-options="field:'wc_name',width:70,hidden:true">wc_name</th>
	                     <th data-options="field:'p_line_name',width:70,hidden:true,editor:{type:'textbox'}">p_line_name</th>
	                     <th data-options="field:'equip_name',width:130,editor:{type:'textbox',options:{disabled:true,required:true,validType:'length[1,100]'}}">设备编码</th>
	                     <th data-options="field:'description',width:200,editor:{type:'textbox',options:{required:true,validType:'length[1,100]'}}">设备名称</th>
					    <!-- 机台类型 -->
                        <th data-options="field:'machinetype_s',width:120,formatter:codeFormatter,editor:{type:'combobox',
                                          options:{ 
                                                    required:true,
                                                    editable:false,
					                                url:'halfpart/basedata/productlinemanager/getProductLineType',
					                                 panelHeight:150,
					                                textField:'DICTNAME_S',
					                                valueField:'DICTCODE_S',
					                                 onSelect:onEquipmentModelSelect}}">设备类型</th>
					    <th data-options="field:'uda_3',width:130,formatter:PlmEquipCodeFormatter,editor:{type:'combobox',
					                      options:{ required:true,
					                                validType:'length[1,100]',
					                                 panelHeight:150,
					                                data:DICT_319,
					                                textField:'text',
					                                valueField:'code'
					                               }}" >PLM设备代码</th>
                        <th data-options="field:'uda_4',width:90,formatter:kouxingban,editor:{type:'combobox',
                                          options:{required:true,
                                                    editable:false,
                                                    data:[{value:'0',text:'无'},{value:'1',text:'有'}],
                                                    icons:[{iconCls:'icon-clear',handler:clearStatus}],
                                                    onChange:onPlasticJudge
                                                  }}">是否有口型板</th>
                        <th data-options="field:'factory_s',width:100,formatter:customerFormatter,editor:{type:'combotree',
                                          options:{
                                                    label:'',
		                                            labelWidth:'auto',
		                                            panelHeight:200,
		                                            editable:true,
		                                            required:true,
		                                            data:CustomerList,
		                                            valueField:'code',
		                              			    textField:'text',
		                                            method:'get'}}">配套厂家</th>
	                </tr>
	            </thead>
	        </table>
    </div>
    
    <!-- 子设备维护 style="width:1000px;height:400px;"-->
    <div id="equipment_manage_dg" class="easyui-dialog" title="子设备维护"  
         data-options="width:window.innerWidth,
		               height:window.innerHeight, 
                       closed:true,
                       onClose:productLineload
                       ">
         <div id="Equipment_dg_toolbar">
             <form class="form" id="equipment_add_form" action="equipmentadd/save" method="post">
               <div data-options="region:'center'" title="子设备维护" style="width:1000px;" >
                  <input id="aaa" class="easyui-textbox"  type="hidden">
                  <auth:button code="HAIFPART_EQUIPMENT_MAINTAIN_ADD"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="addequipment()"><spring:message code="button.add" /></a></auth:button>
                  <auth:button code="HAIFPART_EQUIPMENT_MAINTAIN_EDIT"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="editequipment()"><spring:message code="button.edit" /></a></auth:button>
                  <auth:button code="HAIFPART_EQUIPMENT_MAINTAIN_REMOVE"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="removeequipment()"><spring:message code="button.delete" /></a></auth:button>
                  <auth:button code="HAIFPART_EQUIPMENT_MAINTAIN_SAVE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="saveequipment()"><spring:message code="button.save" /></a></auth:button>
                  <auth:button code="HAIFPART_EQUIPMENT_MAINTAIN_CANCEL"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancelequipment()"><spring:message code="button.cancel" /></a>  </auth:button>
               </div>    
             </form>
         </div>  
         <table class="easyui-datagrid" style="width:100%" id="equipment_dg"
                data-options="
                     fit:true,
                     fitColumns:false,
                     singleSelect:false,
                     autoRowHeight:true,
                     rownumbers:true,
                     toolbar: '#Equipment_dg_toolbar',
                     loadMsg:'加载中。。。',
                     height:'auto',
                      method:'get',
                      emptyMsg:'暂无数据',
                      striped:true
                      ">
                <thead>
                    <tr>
                        <th data-options="field:'id',width:70,checkbox:true">id</th>
                        <th data-options="field:'area_name',width:70,hidden:true">area</th>
                        <th data-options="field:'wc_name',width:70,hidden:true">工作中心</th>    
                        <th data-options="field:'p_line_name',width:70,hidden:true">p_line_name</th>
                        <th data-options="field:'isplate_s',width:70,hidden:true">是否有口型版</th>
                        <th data-options="field:'equip_type_s',width:100,formatter:codeFormatter,editor:{type:'combotree',
                                          options:{
													method:'get',
													required:true,
													url:'dict/code/115',
													onChange:equipTypeJudge
													}}">子设备类型</th>
                        <th data-options="field:'equip_name',width:250,editor:{type:'textbox',options:{required:true,editable:true}}">子设备编号</th>
                        <th data-options="field:'description',width:130,editor:{type:'textbox',options:{required:true,editable:true}}">子设备名称</th>
						<th data-options="field:'productionline_code_s',width:120,editor:{type:'textbox',options:{disabled:true}}">子设备组号</th> 
                        <th data-options="field:'configclass_s',width:150,formatter:codeFormatter,editor:{type:'combobox',
                                          options:{ 
                                                    label:'',
		                                            labelWidth:'auto',
		                                            panelHeight:200,
		                                            editable:true,
		                                            required:false,
		                                            url:'halfpart/basedata/productlinemanager/searchMaterialGroup',
		                                            valueField:'dictcode_s',
		                              			    textField:'dictname_s',
		                                            method:'get' }}">物料类型</th>
                        <th data-options="field:'plasticnumber_i',width:80,editor:{type:'textbox',
                                          options:{required:true,
                                                   onChange:plasticNumberJudge
                                                   }}">投入胶案数量</th>
                        <th data-options="field:'outputgroup_s',width:90,editor:{type:'combobox',
                                          options:{
                                                   validType:'length[1,100]',
                                                   textField:'label',
                                                   valueField:'value',
                                                   data:[{label: 'A',value: 'A'},{label: 'B',value: 'B'}]
                                                   }}">产出分组</th>
                        <th data-options="field:'ip_address_s',width:120,editor:{type:'textbox',options:{validType:'length[1,100]'}}">设备IP</th>
                        <th data-options="field:'rfidaddress_s',width:150,editor:{type:'textbox',options:{validType:'length[0,100]'}}">RFID逻辑地址</th>
                        <th data-options="field:'intoutaddress_s',width:150,editor:{type:'textbox',options:{validType:'length[0,100]'}}">工装移入移出逻辑地址</th>       
                        <th data-options="field:'specialselect_s',width:100,editor:{type:'textbox',options:{validType:'length[0,100]'}}">特殊选择</th>
                        <th data-options="field:'remark_s',width:90,editor:{type:'textbox',options:{validType:'length[1,100]'}}">备注</th>
                        <th data-options="field:'changeby_s',width:90">操作人</th>
                        <th data-options="field:'changetime_t',width:120">操作时间</th>
                    </tr>
                </thead>
            </table>
    </div>
</body>
</html>
