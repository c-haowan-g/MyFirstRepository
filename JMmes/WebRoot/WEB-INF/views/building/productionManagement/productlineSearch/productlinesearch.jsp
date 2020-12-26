<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="productlinesearch.js.jsp"%>
<script type="text/javascript" src="dict/252,189,320,161,308,-117,353,357.js"></script>
<body class="easyui-layout" fit="true">
   <!-- 工厂模型 -->
   <div data-options="region:'north',title:'产线',split:true" style="height:50%;">
		   <div id="ProductLine_dg_toolbar">
				  <form id="ProductLine_search_form" class="form" >
						<tr>
							<spring:message code="equipment.type" />:
							<!-- 子设备类型-->
							<input id="equipmenttype" type="text" class="easyui-combotree" style="width:150px" data-options="label:'', 
								  required:false,
								  method:'get',
								  onSelect:equipmenttypeSelect,
	                             data:DICT_161,
								  method:'get'">
						</tr>
				  </form> 
			</div>
	       <table class="easyui-datagrid" style="width:100%" id="productline_dg_manage"
	          data-options="
	               fit:true,
	               fitColumns:false,
				   singleSelect:false,
				   autoRowHeight:true,
				   rownumbers:true,
				   loadMsg:'加载中。。。',
				   height:'auto',
				   toolbar: '#ProductLine_dg_toolbar',
	                method:'get',
	                emptyMsg:'暂无数据',
	                striped:true
	                ">
	          <thead data-options="frozen:true">
	              <tr>
	                  <th data-options="field:'id',width:70,checkbox:true">ID</th>
	                  <th data-options="field:'area_name',width:70,hidden:true">area_name</th>
	                  <th data-options="field:'p_line_name',editor:{type:'textbox',options:{required:true,validType:'length[1,100]'}}">产线名称</th>
	               </tr>
			 </thead>
			 <thead>
			        <tr>
	                  <th data-options="field:'producttype_s',formatter:codeFormatter,editor:{type:'combotree',options:
	                            {
	                            method:'get',
	                             data:DICT_353,
	                            required:true}}">产出模式</th>
	                  <!-- 所属工序 -->
	                  <th data-options="field:'process_s',hidden:true,formatter:codeFormatter">所属工序</th>
	                  <th data-options="field:'memo_s',width:70,editor:{type:'textbox',options:{validType:'length[1,100]'}}">备注</th>
	                  <th data-options="field:'createby_s',width:70">创建人</th>
	                  <th data-options="field:'createtime_t',width:130">创建时间</th>
	                  <th data-options="field:'changeby_s',width:70">修改人</th>
	                  <th data-options="field:'changetime_t',width:130">修改时间</th>
	              </tr>
	          </thead>
	      </table>
    
    </div>   
    
    <div data-options="region:'center',split:true" style="height:50%;">
       <div class="easyui-layout" fit="true">
	          <div data-options="region:'west',title:'设备机型',split:true" style="width:50%;">
			     <table class="easyui-datagrid" style="width:100%" id="equipment_model_dg"
		             data-options="
		               fit:true,
		               fitColumns:false,
					   singleSelect:true,
					   autoRowHeight:true,
					   rownumbers:true,
					   loadMsg:'加载中。。。',
					   height:'auto',
					   rowStyler:rowStylerChange,
		                method:'get',
		                emptyMsg:'暂无数据',
		                striped:true,
		                remoteSort:false,
						multiSort:true,
						onClickRow:clickRow1
		                ">
			     <thead>
		               <tr>
		                <th data-options="field:'equip_key',width:70,checkbox:true">ID</th>
				        <th data-options="field:'equip_name',width:280">设备编码</th> 
				        <th data-options="field:'description',width:280">设备机型</th> 
		              </tr>
		          </thead>
		      </table>
	        </div>
	        <div data-options="region:'center',title:'子设备',split:true" >
              <table class="easyui-datagrid" style="width:100%" id="equipment_dg_manage"
                  data-options="
	               fit:true,
	               fitColumns:false,
				   singleSelect:false,
				   autoRowHeight:true,
				   rownumbers:true,
				   loadMsg:'加载中。。。',
				   height:'auto',
				   rowStyler:rowStylerChange,
	                method:'get',
	                emptyMsg:'暂无数据',
	                striped:true,
	                remoteSort:false,
					multiSort:true
	                ">
	          <thead data-options="frozen:true">
		            <tr>
	                  <th data-options="field:'id',width:70,checkbox:true">ID</th>
					  <th data-options="field:'description',width:210">设备名称</th> 
				    </tr>
		      </thead>
	         <thead>
               <tr>
				  <th data-options="field:'equip_type_s',formatter:codeFormatter,width:130,sortable:true">子设备类型</th>  
				  <th data-options="field:'device_valid_s',formatter:isAllFormatter,styler:isAllCellStyler,align:'center'">子设备是否启用</th> 
				  <th data-options="field:'bom_material_code_s'">BOM物料</th> 	
				  <th data-options="field:'current_batch_code_s',width:130">当前物料批次条码</th>                              
				  <th data-options="field:'current_barcode_s'">载具条码</th> 
				  <th data-options="field:'configclassmes_s',formatter:codeFormatter">物料类型</th> 
				  <th data-options="field:'configclassname_s'">物料大类名称</th> 	
				  <th data-options="field:'current_material_code_s'">当前物料编码</th> 
				  <th data-options="field:'current_material_spec_s'">当前物料规格</th> 	
				  <th data-options="field:'currentmaterielamount_i'">当前投料物料总数量</th> 	
				  <th data-options="field:'currentmaterielsurplusamount_i'">当前投料物料剩余数量</th> 	
				  <th data-options="field:'line_amount_i'">物料线边数量</th> 
				  <th data-options="field:'configstatus_s',formatter:isAllFormatter,styler:isAllCellStyler,align:'center'">是否启用校验</th> 
				  <th data-options="field:'specialcontrol_s',width:130">特殊要求</th> 
				  <th data-options="field:'configresult_s'">投料校验结果</th> 
				  <th data-options="field:'tire_shelf_code_s'">胎胚车编码</th> 
				  <th data-options="field:'tire_material_code_s'">胎胚车物料编码</th> 
				  <th data-options="field:'tire_full_number_i'">胎胚车额定数量</th> 
				  <th data-options="field:'tire_real_number_i'">胎胚车实际数量</th> 
				  <th data-options="field:'barcode_s'">胎桶产出条码</th> 
				  <th data-options="field:'barcodelast_s'">上一个胎桶产出条码</th> 
				  <th data-options="field:'scanstatus_s',formatter:codeFormatter">胎桶扫描状态</th> 
				  <th data-options="field:'scanstatuslast_s',formatter:codeFormatter">上一个胎桶扫描状态</th>
				  <th data-options="field:'ip_address_s',width:130">设备IP</th> 
				  <th data-options="field:'status_s',formatter:isAllFormatter,styler:isAllCellStyler,align:'center'">设备状态</th> 	
				  <th data-options="field:'half_confirm_s'">半卷料确认</th> 	
				  <th data-options="field:'equip_name',width:160,sortable:true">设备编码</th>
				   <th data-options="field:'rfid_antenna_code_s',width:130">RFID设备编码</th> 
				  <th data-options="field:'changeby_s'">操作人</th> 	
				  <th data-options="field:'changetime_t'">操作时间</th> 	
              </tr>
          </thead>
      </table>
      </div>
	  </div>
    </div>   
</body>
</html>
