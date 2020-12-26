<!-- 

    作者      :时永良
    时间      :2019-07-13 09:55:26 
    页面名称:硫化产线设备维护
    文件关联:
        CuringProductionLineController.java
        CuringProductionLineServiceImpl.java
        CuringProductionLineServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="curingproductionline.js.jsp"%>

<script type="text/javascript" src="dict/287,211,214,252,320.js"></script>

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
                           valueField:'p_line_name',
                           textField:'p_line_name',
                           method:'get'">
             &emsp;<spring:message code="机台名称"/>
            :&emsp;<input name="filter[description]" id="description" type="text" class="easyui-combobox" 
                          data-options="label:'',
                           labelWidth:'auto',
                           panelHeight:200,
                           editable:true,
                           required:false,
                           data:productLineList,
                           valueField:'description',
                           textField:'description',
                           method:'get'">
            <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="productionLineFilter()"><spring:message code="button.search" /></a>
            </form>
          <auth:button code="SYS_JCSJWH_PRODUCTLINE_WH"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-item'" onclick="productlineManage()"><spring:message code="factoryline.WH" /></a></auth:button>
          <auth:button code="SYS_JCSJJXWH_EQUIPMENT_WH"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-ent'" onclick="equipmentModel()"><spring:message code="equipmentmodel.WH" /></a></auth:button>
          <auth:button code="SYS_JCSJTLKWH_EQUIPMENT_WH"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-ent'" onclick="equipmentManage()"><spring:message code="equipment.WH" /></a></auth:button>
        </div>
        <table class="easyui-datagrid" id="productline_dg" >
            <thead>
                <tr>
                    <th data-options="field:'sss',checkbox:true" ></th>
                    <th data-options="field:'area_name',hidden:true">area名称</th>
                    <th data-options="field:'p_line_name'" >产线编号</th>
                    <th data-options="field:'description'" >产线描述</th>
                    <th data-options="field:'machinegroup_s',formatter:codeFormatter">机台组</th>
                    <th data-options="field:'memo_s'" >备注</th>
                    <th data-options="field:'createby_s'" >创建人</th>
                    <th data-options="field:'createtime_t'" >创建时间</th>
					<th data-options="field:'changeby_s'" >修改人</th>
                    <th data-options="field:'changetime_t',width:300" >修改时间</th>
                </tr>
            </thead>
        </table>
    </div>
    
    <!-- 产线维护 -->
    <div id="productline_manage_dg" class="easyui-dialog" title="产线维护" style="width:900px;height:400px;"
            data-options="
                closed:true
            ">
            <div id="ProductLine_dg_toolbar">
	         <form class="form" id="productline_add_form" action="productlineadd/save" method="post">
	           <div data-options="region:'center'" title="产线信息维护" style="width:500px;" >
		         <%--  <auth:button code="SYS_JCSJWH_FACTORYPRODUCTLINE_ADD"> --%>
		          <a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="addproductline()"><spring:message code="button.add" /></a>
		         <%--  </auth:button> --%>
		          <%-- <auth:button code="SYS_JCSJWH_FACTORYPRODUCTLINE_EDIT"> --%>
		          <a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="editproductline()"><spring:message code="button.edit" /></a>
		          <%-- </auth:button> --%>
		          <%-- <auth:button code="SYS_JCSJWH_FACTORYPRODUCTLINE_REMOVE"> --%>
		          <a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="removeproductline()"><spring:message code="button.delete" /></a>
		          <%-- </auth:button> --%>
		          <%-- <auth:button code="SYS_JCSJWH_FACTORYPRODUCTLINE_SAVE"> --%>
		          <a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="saveproductline()"><spring:message code="button.save" /></a>
		          <%-- </auth:button> --%>
		          <%-- <auth:button code="SYS_JCSJWH_FACTORYPRODUCTLINE_CANCEL"> --%>
		          <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancelproductline()"><spring:message code="button.cancel" /></a> 
		          <%--  </auth:button> --%>
		        
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
	                  striped:true
	                  ">
	            <thead>
	                <tr>
	                    <th data-options="field:'id',width:70,checkbox:true">ID</th>
	                    <th data-options="field:'area_name',width:70,hidden:true">area_name</th>
	                    <th data-options="field:'p_line_name',width:90,editor:{type:'textbox',options:{required:true,validType:'length[1,100]',onChange:onProductionLineNameChange}}">产线名称</th>
	                    <th data-options="field:'description',width:130,editor:{type:'textbox',options:{required:true,validType:'length[1,100]'}}">产线描述</th>
	                      <!-- 机台组 -->
	                    <th data-options="field:'machinegroup_s',formatter:codeFormatter,width:90,editor:{type:'combobox',options:
                               {
                               valueField:'DICTCODE_S',
					           textField:'DICTNAME_S',
                               editable:false,
                               required:true}}">机台组</th>
                        <th data-options="field:'memo_s',width:70,editor:{type:'textbox',options:{validType:'length[1,100]'}}">备注</th>
	                    <th data-options="field:'createby_s',width:70">创建人</th>
	                    <th data-options="field:'createtime_t',width:130">创建时间</th>
	                    <th data-options="field:'changeby_s',width:70">修改人</th>
	                    <th data-options="field:'changetime_t',width:130">修改时间</th>
	                </tr>
	            </thead>
	        </table>
    </div>
    
    <!-- 设备机型维护 -->
    <div id="equipment_model_dg" class="easyui-dialog" title="设备机型维护" style="width:900px;height:400px;"
            data-options="
                closed:true
            ">
            <div id="Equipment_model_dg_toolbar">
	         <form class="form" id="equipment_model_add_form"  method="post">
	           <div data-options="region:'center'" title="设备机型维护" style="width:1000px;" >
		          <%-- <auth:button code="SYS_JCSJJXWH_FACTORYEQUIP_ADD"> --%>
		          <a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="addequipmentmodel()"><spring:message code="button.add" /></a>
		          <%-- </auth:button> --%>
		          <%-- <auth:button code="SYS_JCSJJXWH_FACTORYEQUIP_EDIT"> --%>
		          <a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="editequipmentmodel()"><spring:message code="button.edit" /></a>
		          <%-- </auth:button> --%>
		          <%-- <auth:button code="SYS_JCSJJXWH_FACTORYEQUIP_REMOVE"> --%>
		          <a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="removeequipmentmodel()"><spring:message code="button.delete" /></a>
		          <%-- </auth:button> --%>
		          <%-- <auth:button code="SYS_JCSJJXWH_FACTORYEQUIP_SAVE"> --%>
		          <a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="saveequipmentmodel()"><spring:message code="button.save" /></a>
		          <%-- </auth:button> --%>
		          <%-- <auth:button code="SYS_JCSJJXWH_FACTORYEQUIP_CANCEL"> --%>
		          <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancelequipmentmodel()"><spring:message code="button.cancel" /></a> 
		          <%--  </auth:button> --%>
		        
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
	                     <th data-options="field:'equip_name',width:160,editor:{type:'textbox',options:{disabled:true,required:true,validType:'length[1,100]'}}">设备编码</th>
	                     <th data-options="field:'description',width:200,editor:{type:'textbox',options:{required:true,validType:'length[1,100]'}}">设备名称</th>
					     <!-- 机台类 -->
                         <th data-options="field:'machinetype_s',width:150,sortable:true,formatter:equipmenttype,editor:{type:'combobox',options:
	                                {valueField:'value',
	                                textField:'text',
	                                method:'get',
	                                data: [{
											text: '<spring:message code='tip.left'/>',
											value: 'L'
										},{
											text: '<spring:message code='tip.right'/>',
											value: 'R'
										}],
	                                required:true,
	                                onSelect:onEquipmentModelSelect}}"><spring:message code="curingproductionlineinfo.column.category" /></th>
					    <th data-options="field:'equip_type_s',width:110,hidden:true">设备类型</th>
					    <!-- 机台状态 214-->
                        <th data-options="field:'status_s',width:80,sortable:true,formatter:codeFormatter,editor:{type:'combotree',options:{
                    			method:'get',
                                url:'dict/code/214',
                                labelwidth:'auto',
                    			required:true
                    			}}"><spring:message code="curingproductionlineinfo.column.status_s" /></th>
                    	<!-- 机台IP -->
                        <th data-options="field:'ip_address_s',width:110,sortable:true,editor:{type:'textbox',options:{required:true}}"><spring:message code="curingproductionlineinfo.column.ip_s" /></th>
	                    <!-- 所属工序 -->
	                    <th data-options="field:'process_s',width:110,formatter:codeFormatter">所属工序</th>
	                </tr>
	            </thead>
	        </table>
    </div>
    
    <!-- 子设备投料口\产出口维护 -->
    <div id="equipment_manage_dg" class="easyui-dialog" title="子设备投料口\产出口维护" style="width:900px;height:400px;"
            data-options="
                closed:true
            ">
            <div id="Equipment_dg_toolbar">
	         <form class="form" id="equipment_add_form" method="post">
	           <div data-options="region:'center'" title="子设备投料口\产出口维护" style="width:1000px;" >
	              <input id="aaa" class="easyui-textbox"  type="hidden">
		         <%--  <auth:button code="SYS_JCSJWH_FACTORYEQUIP_ADD"> --%>
		          <a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="addequipment()"><spring:message code="button.add" /></a>
		          <%-- </auth:button> --%>
		          <%-- <auth:button code="SYS_JCSJWH_FACTORYEQUIP_EDIT"> --%>
		          <a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="editequipment()"><spring:message code="button.edit" /></a>
		          <%-- </auth:button> --%>
		          <%-- <auth:button code="SYS_JCSJWH_FACTORYEQUIP_REMOVE"> --%>
		          <a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="removeequipment()"><spring:message code="button.delete" /></a>
		          <%-- </auth:button> --%>
		          <%-- <auth:button code="SYS_JCSJWH_FACTORYEQUIP_SAVE"> --%>
		          <a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="saveequipment()"><spring:message code="button.save" /></a>
		          <%-- </auth:button> --%>
		          <%-- <auth:button code="SYS_JCSJWH_FACTORYEQUIP_CANCEL"> --%>
		          <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancelequipment()"><spring:message code="button.cancel" /></a>  
		          <%-- </auth:button> --%>
		        
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
	                    <th data-options="field:'equip_name',width:170,hidden:true">子设备编码</th>
	                    <th data-options="field:'description',width:250,editor:{type:'textbox',options:{validType:'length[1,100]'}}">子设备名称</th>
                        <th data-options="field:'equip_type_s',width:140,formatter:codeFormatter,editor:{type:'combotree',options:{
                    			method:'get',
                                data:DICT_287,
                                labelwidth:'auto',
                    			required:true
                    			}}">子设备类型</th>
                        <th data-options="field:'device_valid_s',width:90,formatter:isAllFormatter,editor:{type:'combobox',options:
				                                {valueField:'value',
				                                textField:'text',
				                                method:'get',
				                                data: [{
														text: '否',
														value: 0
													},{
														text: '是',
														value: 1
													}],
				                                required:true}}">子设备是否启用</th>
					   <th data-options="field:'remark_s',width:90,editor:{type:'textbox',options:{validType:'length[1,100]'}}">备注</th>
	                </tr>
	            </thead>
	        </table>
    </div>
    
</body>
</html>
