<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="productline.js.jsp"%>
<script type="text/javascript" src="dict/211,252,189,199,198,320,161,308,-117,353.js"></script>
<body class="easyui-layout" fit="true">
   <!-- 工厂模型 -->
    <div data-options="region:'center'" title="工厂模型" style="width:250px;" >
     <div id="Reas_dg_toolbar">
          <auth:button code="SYS_JCSJWH_FACTORYPRODUCTLINE_WH"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-item'" onclick="productlineManage()"><spring:message code="factoryline.WH" /></a></auth:button>
          <auth:button code="SYS_JCSJJXWH_FACTORYEQUIPMENT_WH"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-ent'" onclick="equipmentModel()"><spring:message code="equipmentmodel.WH" /></a></auth:button>
          <auth:button code="SYS_JCSJTLKWH_FACTORYEQUIPMENT_WH"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-ent'" onclick="equipmentManage()"><spring:message code="equipment.WH" /></a></auth:button>
          <auth:button code="SYS_JCSJTLKWH_FACTORYEQUIPMENT_WH_SBL">
          <a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-ent'" onclick="equipmentClassManage()"><spring:message code="equipment.WHEquipmentClass" /></a>
          </auth:button>
     </div>   
        <table class="easyui-datagrid" id="productline_dg" >
            <thead>
                <tr>
                    <th data-options="field:'sss',checkbox:true" ></th>
                    <th data-options="field:'area_name',hidden:true">area名称</th>
                    <th data-options="field:'p_line_name'" >产线编号</th>
                    <th data-options="field:'description'" >产线描述</th>
                    <th data-options="field:'machinegroup_s',formatter:codeFormatter">机台组</th>
                    <!-- <th data-options="field:'machinetype_s',formatter:codeFormatter" >设备类</th> -->
                    <th data-options="field:'producttype_s',formatter:codeFormatter">产出模式</th>
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
		          <auth:button code="SYS_JCSJWH_FACTORYPRODUCTLINE_ADD"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="addproductline()"><spring:message code="button.add" /></a></auth:button>
		          <auth:button code="SYS_JCSJWH_FACTORYPRODUCTLINE_EDIT"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="editproductline()"><spring:message code="button.edit" /></a></auth:button>
		          <auth:button code="SYS_JCSJWH_FACTORYPRODUCTLINE_REMOVE"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="removeproductline()"><spring:message code="button.delete" /></a></auth:button>
		          <auth:button code="SYS_JCSJWH_FACTORYPRODUCTLINE_SAVE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="saveproductline()"><spring:message code="button.save" /></a></auth:button>
		          <auth:button code="SYS_JCSJWH_FACTORYPRODUCTLINE_CANCEL"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancelproductline()"><spring:message code="button.cancel" /></a>  </auth:button>

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
	                    <th data-options="field:'p_line_name',width:90,editor:{type:'textbox',options:{required:true,validType:'length[1,100]'}}">产线名称</th>
	                    <th data-options="field:'description',width:130,editor:{type:'textbox',options:{validType:'length[1,100]'}}">产线描述</th>
	                     <!-- 机台组 -->
	                    <th data-options="field:'machinegroup_s',width:90,formatter:codeFormatter,editor:{type:'combotree',options:
                               {
                               method:'get',
                                data:DICT_320,
                               required:true}}">机台组</th>
                        <th data-options="field:'producttype_s',width:80,formatter:codeFormatter,editor:{type:'combotree',options:
                               {
                               method:'get',
                                data:DICT_353,
                               required:true}}">产出模式</th>
                        <th data-options="field:'memo_s',width:70,editor:{type:'textbox',options:{validType:'length[1,100]'}}">备注</th>
	                    <th data-options="field:'createby_s',width:70">创建人</th>
	                    <th data-options="field:'createtime_t',width:130">创建时间</th>
	                    <th data-options="field:'changeby_s',width:70">修改人</th>
	                    <th data-options="field:'changetime_t',width:130">修改时间</th>
	                </tr>
	            </thead>
	        </table>
    </div>
    
    <!-- 子设备机型维护 -->
    <div id="equipment_model_dg" class="easyui-dialog" title="设备机型维护" style="width:900px;height:400px;"
            data-options="
                closed:true
            ">
            <div id="Equipment_model_dg_toolbar">
	         <form class="form" id="equipment_model_add_form"  method="post">
	           <div data-options="region:'center'" title="设备机型维护" style="width:1000px;" >
		          <auth:button code="SYS_JCSJJXWH_FACTORYEQUIP_ADD"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="addequipmentmodel()"><spring:message code="button.add" /></a></auth:button>
		          <auth:button code="SYS_JCSJJXWH_FACTORYEQUIP_EDIT"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="editequipmentmodel()"><spring:message code="button.edit" /></a></auth:button>
		          <auth:button code="SYS_JCSJJXWH_FACTORYEQUIP_REMOVE"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="removeequipmentmodel()"><spring:message code="button.delete" /></a></auth:button>
		          <auth:button code="SYS_JCSJJXWH_FACTORYEQUIP_SAVE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="saveequipmentmodel()"><spring:message code="button.save" /></a></auth:button>
		          <auth:button code="SYS_JCSJJXWH_FACTORYEQUIP_CANCEL"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancelequipmentmodel()"><spring:message code="button.cancel" /></a>  </auth:button>
		        
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
					     
					     <!-- 设备类 -->
	                     <th data-options="field:'machinetype_s',width:130,formatter:codeFormatter,editor:{type:'combobox',
	                       options:{
					       delay:300,panelWidth:140,
					       required:true,
					       data:equipmentModelList,
					       panelHeight:150,
					       editable:true,
					       valueField:'DICTCODE_S',
					       textField:'DICTNAME_S',
					       limitToList:true,
					       onSelect:onEquipmentModelSelect
					       }}">设备类</th>
					    <th data-options="field:'equip_type_s',formatter:codeFormatter,width:110">设备类型</th>
					    <th data-options="field:'remarks_s',width:100,editor:{type:'textbox',options:{validType:'length[1,100]'}}">额定能力</th>
	                    <th data-options="field:'model_s',width:100,editor:{type:'textbox',options:{validType:'length[1,100]'}}">型号</th>
	                    <th data-options="field:'specification_s',width:100,editor:{type:'textbox',options:{validType:'length[1,100]'}}">规格</th>
	                    <th data-options="field:'factory_s',width:80,editor:{type:'textbox',options:{validType:'length[1,100]'}}">厂商</th>
	                    <th data-options="field:'manufacturingtime_t',width:110,editor:{type:'datebox'}">制造年月</th>
	                    <th data-options="field:'shape_s',width:70,editor:{type:'textbox',options:{validType:'length[1,100]'}}">外形尺寸</th>
	                    <th data-options="field:'weight_s',width:70,editor:{type:'textbox',options:{validType:'length[1,100]'}}">重量</th>
	                    <th data-options="field:'servicelife_s',width:70,editor:{type:'textbox',options:{validType:'length[1,100]'}}">使用年限</th>
	                	<th data-options="field:'activetime_t',width:110,editor:{type:'datebox'}">启用时间</th>
	                    <th data-options="field:'department_s',width:70,editor:{type:'textbox',options:{validType:'length[1,100]'}}">所属部门</th>
	                    <th data-options="field:'responsible_s',width:70,editor:{type:'textbox',options:{validType:'length[1,100]'}}">责任人</th>
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
		          <auth:button code="SYS_JCSJWH_FACTORYEQUIP_ADD"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="addequipment()"><spring:message code="button.add" /></a></auth:button>
		          <auth:button code="SYS_JCSJWH_FACTORYEQUIP_EDIT"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="editequipment()"><spring:message code="button.edit" /></a></auth:button>
		          <auth:button code="SYS_JCSJWH_FACTORYEQUIP_REMOVE"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="removeequipment()"><spring:message code="button.delete" /></a></auth:button>
		          <auth:button code="SYS_JCSJWH_FACTORYEQUIP_SAVE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="saveequipment()"><spring:message code="button.save" /></a></auth:button>
		          <auth:button code="SYS_JCSJWH_FACTORYEQUIP_CANCEL"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancelequipment()"><spring:message code="button.cancel" /></a>  </auth:button>
		        
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
	                    <th data-options="field:'erpcode_s',width:60,hidden:true">余料控制百分比</th>
	                    <th data-options="field:'equip_type_s',width:120,formatter:codeFormatter,editor:{type:'combotree',options:
                               {
                                method:'get',
                                onChange:enttypeChange,
                                required:true,
                                data:DICT_161}
                                }">子设备类型</th>
                       <th data-options="field:'description',width:250,editor:{type:'textbox',options:{validType:'length[1,100]'}}">子设备名称</th>
                       <th data-options="field:'productionline_code_s',width:110,hidden:true">子设备组号</th>        
					  
					   <th data-options="field:'rfid_antenna_code_s',width:90,editor:{type:'textbox',options:{validType:'length[1,100]'}}">RFID设备天线编码</th>
					   <th data-options="field:'rfidaddress_s',width:90,editor:{type:'textbox',options:{validType:'length[1,100]'}}">RFID逻辑地址</th>
					   
					   <th data-options="field:'ip_address_s',width:90,editor:{type:'textbox',options:{validType:'length[1,100]'}}">设备IP</th>
					   <th data-options="field:'configclassmes_s',width:120,formatter:materialTypeFormatter,editor:{type:'combobox',options:
                               {
                               method:'get',
                               required:false,
                               icons:[{iconCls:'icon-clear',handler:function(e){$(e.data.target).combobox('clear')}}],
                               data:DICT_MaterialType,
                               valueField:'DICTCODE_S',
			                   textField:'DICTNAME_S',
			                   panelHeight:200 
			                   }}">物料类型</th>
                       <th data-options="field:'specialcontrol_s',width:80,formatter:codeFormatter,editor:{type:'combotree',options:
                               {
                                method:'get',
                                data:DICT_117}}">特殊要求</th>
                        <th data-options="field:'device_valid_s',width:90,formatter:isAllFormatter,editor:{type:'combobox',options:
				                                {valueField:'value',
				                                textField:'text',
				                                method:'get',
				                                data: [{
														text: '否',
														value: '0'
													},{
														text: '是',
														value: '1'
													}],
													required:false
													}}">子设备是否启用</th>
                       
					   <th data-options="field:'remark_s',width:90,editor:{type:'textbox',options:{validType:'length[1,100]'}}">备注</th>
					   <th data-options="field:'changeby_s',width:90">操作人</th>
					   <th data-options="field:'changetime_t',width:120">操作时间</th>
					  

					   <th data-options="field:'current_batch_code_s',hidden:true,width:90,editor:{type:'textbox',options:{validType:'length[1,100]'}}">当前物料批次条码</th>
					   <th data-options="field:'current_barcode_s',hidden:true,width:90,editor:{type:'textbox',options:{validType:'length[1,100]'}}">当前物料编码（RFID条码）</th>
					   <th data-options="field:'current_material_code_s',hidden:true,width:90,editor:{type:'textbox',options:{validType:'length[1,100]'}}">当前物料编码</th>
					   <th data-options="field:'last_barcode_s',hidden:true,width:90,editor:{type:'textbox',options:{validType:'length[1,100]'}}">上一个工装条码</th>
					   <th data-options="field:'last_material_code_s',hidden:true,width:90,editor:{type:'textbox',options:{validType:'length[1,100]'}}">上一个物料编码</th>
					   <th data-options="field:'last_batch_code_s',hidden:true,width:90,editor:{type:'textbox',options:{validType:'length[1,100]'}}">上一个物料批次编码</th>
					   <th data-options="field:'configstatus_s',hidden:true,width:90,editor:{type:'textbox',options:{validType:'length[1,100]'}}">是否启用校验</th>
					   <th data-options="field:'configresult_s',hidden:true,width:90,editor:{type:'textbox',options:{validType:'length[1,100]'}}">投料校验结果</th>
					   <th data-options="field:'beginweight_f',hidden:true,width:90,editor:{type:'textbox',options:{validType:'length[1,100]'}}">正向投料称重起始重量</th>
					   <th data-options="field:'endweight_f',hidden:true,width:90,editor:{type:'textbox',options:{validType:'length[1,100]'}}">正向投料称重结束重量</th>
						<th data-options="field:'differentvalue_f',hidden:true,width:90,editor:{type:'textbox',options:{validType:'length[1,100]'}}">更换载具差值</th>
						<th data-options="field:'status_s',hidden:true,width:90,editor:{type:'textbox',options:{validType:'length[1,100]'}}">设备状态 0不正常1正常</th>
						<th data-options="field:'bom_material_code_s',hidden:true,width:90,editor:{type:'textbox',options:{validType:'length[1,100]'}}">BOM物料</th>
						<th data-options="field:'half_confirm_s',hidden:true,width:90,editor:{type:'textbox',options:{validType:'length[1,100]'}}">半卷料确认</th>
						<th data-options="field:'line_amount_i',hidden:true,width:90,editor:{type:'textbox',options:{validType:'length[1,100]'}}">物料线边数量</th>
						<th data-options="field:'configclassname_s',hidden:true,width:90,editor:{type:'textbox',options:{validType:'length[1,100]'}}">物料大类名称</th>
						<th data-options="field:'current_material_spec_s',hidden:true,width:90,editor:{type:'textbox',options:{validType:'length[1,100]'}}">当前物料规格</th>
						<th data-options="field:'currentmaterielamount_f',hidden:true,width:90,editor:{type:'textbox'}">当前投料物料总数量</th>
						<th data-options="field:'currentmaterielsurplusamount_f',hidden:true,width:90,editor:{type:'textbox',options:{validType:'length[1,100]'}}">当前投料物料剩余数量</th>
	                </tr>
	            </thead>
	        </table>
    </div>

    <!--机台类维护-->
    <div id="equipmentclass_manage_dg" class="easyui-dialog" title="机台类维护" style="width:900px;height:400px;"
            data-options="
                closed:true
            ">
            <div id="EquipmentClass_dg_toolbar">
	         <form class="form" id="equipmentclass_add_form"  method="post">
	           <div data-options="region:'center'" title="机台类维护" style="width:500px;" >
		          <auth:button code="X-add"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
		          <auth:button code="XA"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
		          <auth:button code="XAS"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
		          <auth:button code="XASQ"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
	           </div>    
	         </form>
         </div>  
         <table class="easyui-datagrid" style="width:100%" id="equipmentclass_dg_manage"
	            data-options="
	                 fit:true,
	                 fitColumns:false,
					 singleSelect:false,
					 autoRowHeight:true,
					 rownumbers:true,
					 toolbar: '#EquipmentClass_dg_toolbar',
					 loadMsg:'加载中。。。',
					 height:'auto',
	                  method:'get',
	                  emptyMsg:'暂无数据',
	                  striped:true
	                  ">
	            <thead>
	                <tr>
	                    <th data-options="field:'id',width:70,checkbox:true">ID</th>
	                    <th data-options="field:'deleted_i',width:100,formatter:deleted,editor:{type:'combobox',options:
	                                {valueField:'value',
	                                textField:'text',
	                                method:'get',
	                                data: [{
											text: '<spring:message code='tip.yes'/>',
											value: 0
										},{
											text: '<spring:message code='tip.no'/>',
											value: 1
										}],
	                                required:true}}">是否有效</th>
	                    <th data-options="field:'dictcode_s',width:100,editor:{type:'textbox',options:{required:true,validType:'length[1,100]'}}">代码</th>
	                    <th data-options="field:'dictname_s',width:100,editor:{type:'textbox',options:{required:true,validType:'length[1,100]'}}">中文名称</th>
	                    <th data-options="field:'dictname_en_s',width:100,editor:{type:'textbox',options:{required:true,validType:'length[1,100]'}}">英文名称</th>
	                    <th data-options="field:'dictname_th_s',width:100,editor:{type:'textbox',options:{required:true,validType:'length[1,100]'}}">泰文名称</th>
	                    <th data-options="field:'erpcode_s',width:100,editor:{type:'textbox',options:{validType:'length[1,100]'}}">代码值</th>
	                    <th data-options="field:'sortno_i',width:100,editor:{type:'numberbox',options:{precision:0,validType:'length[1,100]'}}">排序号</th>
	                    <!-- 更新人 -->
	                    <th data-options="field:'changed_by_s',width:80"><spring:message code="coredictionary.column.changed_by_s" /></th>
	                    <!-- 更新时间 -->
	                    <th data-options="field:'changed_time_t',width:100"><spring:message code="coredictionary.column.changed_time_t" /></th>
	                    <!-- 创建人 -->
	                    <th data-options="field:'created_by_s',width:80"><spring:message code="coredictionary.column.created_by_s" /></th>
	                    <!-- 创建时间 -->
	                    <th data-options="field:'created_time_t',width:100"><spring:message code="coredictionary.column.created_time_t" /></th>
	                </tr>
	            </thead>
	        </table>
    </div>
</body>
</html>
