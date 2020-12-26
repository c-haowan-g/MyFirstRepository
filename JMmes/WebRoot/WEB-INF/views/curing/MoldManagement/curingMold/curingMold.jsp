
<!-- 模具信息维护 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="curingMold.js.jsp"%>
<script type="text/javascript" src="dict/205,208,229,239.js"></script>
<style type="text/css">

table {
           /*列宽由表格宽度和列宽度设定*/
           table-layout: fixed;
       }
</style>

<body class="easyui-layout" fit="true">
	<div data-options="region:'center',split:true,border:false" style="width:100%">
	    	<table class="easyui-datagrid" style="width:80%" id="dg"
			data-options="
		          fit:true,
		          fitColumns:false,
		          pagination:true,
		          rownumbers:true,
		          singleSelect:false,
		          url:'curing/moldmanagement/curingmold/getCuringMold',
		          method:'get',
		           emptyMsg:'<span><spring:message code='tip.noData'/></span>',
		          striped:true,
		          toolbar:'#dg_toolbar,#query_bar',
		          ">
			<thead>
				<tr>
				
					<th data-options="field:'atr_key',checkbox:true">ID</th>
					<!-- 模具的条码/二维码/RFID芯片等，唯一 -->
                    <th id="mold_code_s" data-options="field:'mold_code_s',width:100,editor:{type:'textbox',options:{required:true,events:{blur:getValue}}}"><spring:message code="curingmold.column.mold_code_s" /></th>
                   	<!-- 模具编号（LT1315等） -->
                    <th id="code" data-options="field:'mold_id_s',width:100,editor:{type:'textbox',options:{
	                    onChange:function(value){
									if(value!=null||value!=undefined){
									var k=$(this).parents('[datagrid-row-index]').attr('datagrid-row-index');
							        var td=$('.datagrid-body td[field=\'mold_code_s\']')[k];
							        var input = $(td).find('input')[0];
							        $(input).textbox('setValue',value);
						        }
							}
	                    }}"><spring:message code="curingmold.column.mold_id_s" /></th> 
                    <!--  模具类型 -->
                    <th data-options="field:'mold_type_s',width:100,formatter:codeFormatter,
                    	editor:{type:'combotree',options:{
	        			method:'get',
	                    url:'dict/code/205',
	        			required:true,
	        			 panelWidth:150,
	        			onChange: onchangeText,}}"><spring:message code="curingmold.column.mold_type_s" /></th>
                      <!-- 备注 -->
                 	<th data-options="field:'mold_desc_s',width:150,formatter:codeFormatter,editor:{type:'combotree',options:{
                    			method:'get',
                                url:'dict/code/239',
                                editable:'true',
                                panelWidth:'300',
                    			}}"><spring:message code="curingmold.column.mold_desc_s" /></th>
                    <!-- 规格 -->
                    <th data-options="field:'mold_spec_s',width:120,editor:{type:'combobox',options:
	                	{valueField:'THSPEC_S',
			            textField:'THSPEC_S',
			            editable:'true',
			            limitToList:'false',
			            panelHeight:300,
			            panelWidth:200,
			            method:'get',
			            url:'curing/moldmanagement/curingmold/comboxMoldspec',
			            required:true,
			            filter: function(q, row){  
					        var opts = $(this).combobox('options');  
					        return row[opts.textField].indexOf(q) >= 0;//这里改成>=即可在任意地方匹配  
					    }, 
					     onChange:SpecOnChange
	                    }}"><spring:message code="curingmold.column.mold_spec_s" /></th>
                    <!-- 花纹 -->
                    <th  data-options="field:'flower_pattern_s',width:100,editor:{type:'combobox',
	        			options:
	                    {valueField:'PATTERN_S',
	                    textField:'PATTERN_S',
	                    editable:'true',	
	                    panelHeight:300,
	                    limitToList:'false',
	                    panelWidth:200,
	                    required:true,
	                    method:'get',
	                    url:'curing/moldmanagement/curingmold/comboxPattern',
	                    filter: function(q, row){  
					        var opts = $(this).combobox('options');  
					        return row[opts.textField].indexOf(q) >= 0;//这里改成>=即可在任意地方匹配  
					    },  
					   onChange:PattOnChange
	                    }}"><spring:message code="curingmold.column.flower_pattern_s" /></th>
                    
                      <!-- 备用字段1_用作储存层级信息 -->
                    <th data-options="field:'spare1_s',editor:{type:'combobox',
	        			options:
	                    {valueField:'CJ_S',
	                    textField:'CJ_S',
	                    editable:'true',	
	                    panelHeight:300,
	                    limitToList:'false',
	                    panelWidth:200,
	                    required:false,
	                    method:'get',
	                    url:'curing/moldmanagement/curingmold/comboxCJ',
	                    filter: function(q, row){  
					        var opts = $(this).combobox('options');  
					        return row[opts.textField].indexOf(q) >= 0;//这里改成>=即可在任意地方匹配  
					    } 
					   
	                    }}"><spring:message code="materialslog.column.cj_s" /></th>  
	                <!-- 贴标角度 -->
                    <th data-options="field:'spare2_s',width:100,editor:{type:'textbox',options:{}}"><spring:message code="curingmold.column.labelling_angle_s" /></th>			       
                    <!-- 周向定位角度 -->
                    <th data-options="field:'spare3_s',width:100,editor:{type:'textbox',options:{required:true}}"><spring:message code="curingmold.column.circuposition_angle_s" /></th>			
                    <!-- 径向定位尺寸 -->
                    <th data-options="field:'spare4_s',width:100,editor:{type:'textbox',options:{required:true}}"><spring:message code="curingmold.column.radialposition_size_s" /></th>			
                    <!-- 商标 -->
                    <th data-options="field:'trade_mark_s',width:150,editor:{type:'textbox',options:{}}"><spring:message code="curingmold.column.trade_mark_s" /></th>			
                     <!-- 组模状态 -->
                    <th data-options="field:'repair_state_s',width:100,formatter:stateText"><spring:message code="curingmold.column.repair_state_s" /></th>
                    <!-- 状态 ：600501已出库，600502已入库 600503已报备   600504使用中 600505已报废 -->
                    <th data-options="field:'statues_id_s',width:100,formatter:codeFormatter,editor:{type:'combotree',options:{
	        			method:'get',
	                    url:'dict/code/208',
	        			required:true}}"><spring:message code="curingmold.column.statues_id_s" /></th>
					<!-- 库存位置 -->
                    <th data-options="field:'inventory_location_s',width:150,
                    editor:{type:'combobox',
					options:
		            {required:true,
		            valueField:'INVENTORY_BARCODE_S',
		            textField:'INVENTORY_BARCODE_S',
		            editable:'true',	
		            limitToList:'false',
		            panelHeight:300,
		            panelWidth:300,
		            onShowPanel:Inventory_location,
		            method:'get',
		            url:'curing/moldmanagement/curingmold/comboxMoldLocation',
		            filter: function(q, row){  
				        var opts = $(this).combobox('options');  
				        return row[opts.textField].indexOf(q) >= 0;//这里改成>=即可在任意地方匹配  
				    }},
				    onShowPanel:Inventory_location,
				    }"><spring:message code="curingmold.column.inventory_location_s" /></th>
					<!-- 储位地址 -->
                    <th data-options="field:'store_place_s',editor:{}"><spring:message code="curingmold.column.store_place_s" /></th>
					 <!-- 水洗最高使用次数 -->
                    <th data-options="field:'change_maxnum_i',type:'textbox',editor:{type:'textbox',options:{validType:['number']}}"><spring:message code="curingmold.column.change_maxnum_s" /></th>
					 <!-- 干冰洗最高使用次数 -->
                    <th data-options="field:'clear_maxnum_i',type:'textbox',editor:{type:'textbox',options:{validType:['number']}}"><spring:message code="curingmold.column.clear_maxnum_s" /></th>
					 <!-- 水洗预警次数 -->
                    <th data-options="field:'mold_wash_i',type:'textbox',editor:{type:'textbox',options:{validType:['number']}}"><spring:message code="curingmold.column.mold_wash_s" /></th>
                    <!-- 干冰洗预警次数 -->
                    <th data-options="field:'mold_icewash_i',type:'textbox',editor:{type:'textbox',options:{validType:['number']}}"><spring:message code="curingmold.column.mold_icewash_s" /></th>
                    <!-- 水洗后使用次数 -->
                    <th data-options="field:'after_clean_mold_num_i',editor:{}"><spring:message code="curingmold.column.after_clean_mold_num_s" /></th>
                    <!-- 干冰洗后使用次数 -->
                    <th data-options="field:'after_change_mold_num_i',editor:{}"><spring:message code="curingmold.column.after_change_mold_num_s" /></th>
                    <!-- 干冰洗后使用次数 -->
                    <th data-options="field:'use_num_i',editor:{}"><spring:message code="curingmold.column.use_num_i" /></th>
					<!-- 总累加值 -->
                    <th data-options="field:'total_number_i',editor:{}"><spring:message code="curingmold.column.total_number_s" /></th>
					
                    <!-- 换模时间/入库时间 -->
                    <th data-options="field:'load_date_t'"><spring:message code="curingmold.column.load_date_t" /></th>
                    <!-- 进厂时间 -->
                    <th data-options="field:'purchase_time_s',editor:{type:'datetimebox'}"><spring:message code="curingmold.column.purchase_time_s" /></th>
                    <!-- 厂家 -->
                    <th data-options="field:'factory_s',width:100,editor:{type:'textbox',options:{}}"><spring:message code="curingmold.column.factory_s" /></th>
                    <!-- 环套 -->
                    <th data-options="field:'collar_s',width:100,editor:{type:'textbox',options:{}}"><spring:message code="curingmold.column.collar_s" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changed_by'"><spring:message code="curingmold.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t'"><spring:message code="curingmold.column.changed_time_t" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by'"><spring:message code="curingmold.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t'"><spring:message code="curingmold.column.created_time_t" /></th>
				</tr>
			</thead>
		</table>
		<div id="query_bar"  >
			<form class="form" id="condition_form">
			<table class="formTable" >
					<tr>
						<td class="columnTitle">
							<spring:message code="curingmold.column.mold_code_s" />:
						</td>
						<td class="columnData" >
							<input class="easyui-textbox" name="filter[mold_code_s]" id="mold_code" style="width:168px" >	
						</td>
						<td class="columnTitle">
							<spring:message code="curingmold.column.mold_spec_s" />:
						</td>
						<td class="columnData">
							 <input  class="easyui-combobox" name="filter[mold_spec_s]" id="mold_spec_s" style="width:168px" 
                       		 data-options="	valueField:'THSPEC_S',
				            			textField:'THSPEC_S',
                                        required:false, 
                                        url:'curing/moldmanagement/curingmold/comboxMoldspec',
										method: 'get',
									    editable:'true',
									    limitToList:false,
									    panelHeight:150,
										filter: function(q, row){  
								        var opts = $(this).combobox('options');  
								        return row[opts.textField].indexOf(q) >= 0;//这里改成>=即可在任意地方匹配  
								    	}">
						</td>
						<td class="columnTitle">
							<spring:message code="curingmold.column.statues_id_s" />:
						</td>
						<td class="columnData">
							<input name="filter[statues_id_s]" id="mold_type_s" style="width:168px"  type="text" class="easyui-combotree" data-options="label:'<spring:message code="machinecontrol.column.mold_type_s" />',
				  			required:false,
				  			url:'dict/code/208',
				  			method:'get',
				  			label:''" >
						</td>
						<td class="columnTitle">
							<spring:message code="curingmold.column.trade_mark_s" />:
						</td>
						<td class="columnData">
							<input class="easyui-textbox" name="filter[trade_mark_s]" id="trademark" style="width:168px" >
						</td>
					</tr>
					<tr>
					<td class="columnTitle">
						<spring:message code="curingmold.column.factory_s" />:
					</td>
					<td class="columnData">
						<input class="easyui-textbox" name="filter[factory_s]" id="factory" style="width:168px" >
					</td>
					<td class="columnTitle">
						<spring:message code="curingmold.column.store_place_s" />:
					</td>
					<td class="columnData">
						<input class="easyui-textbox" name="filter[store_place_s]" id="storeplace" style="width:168px" >
					</td>
					<td class="columnTitle">
						<spring:message code="curingmold.column.mold_type_s" />:
			  		</td>
			  		<td class="columnData">
			  			<input name="filter[mold_type_s]" id="mold_type_s" style="width:168px"  type="text" class="easyui-combotree" data-options="label:'<spring:message code="machinecontrol.column.mold_type_s" />',
				  		required:false,
				  		url:'dict/code/205',
				  		method:'get',
				  		label:''" >
			  		</td>
			  		<td>
					<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="doSearch()"><spring:message code="button.search" /></a>
					</td>
				</tr>
			</table>		
			</form>
		</div>
		<div style="border:none;style="padding:2px,margin:3px">
		   <div id="dg_toolbar" style="padding:2px">
				<auth:button code="LH_JCGL_MJXXWH_ADD"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
				<auth:button code="LH_JCGL_MJXXWH_EDIT"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
				<auth:button code="LH_JCGL_MJXXWH_REMOVE"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
				<auth:button code="LH_JCGL_MJXXWH_SAVE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
				<auth:button code="LH_JCGL_MJXXWH_CANCEL"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a> </auth:button> 
				<auth:button code="LH_JCGL_MJXXWH_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
				<auth:button code="LH_JCGL_MJXXWH_PRINT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-print'" onclick="print()"><spring:message code="button.print" /></a></auth:button>
				<auth:button code="LH_JCGL_MJXXWH_MOLDIN"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-backone'" onclick="inStock()"><spring:message code="button.instock" /></a></auth:button>
				<auth:button code="LH_JCGL_MJXXWH_SEARCH"><a id="condition_button" class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="queryBar()"><spring:message code="button.searchColumn" /></a> </auth:button> 
			</div>
		</div>
	</div>
<!-- 	导出-->    
	<jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="condition_form" />
		<jsp:param name="datagridId" value="dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.curing.excel.CuringMoldExportHandler" />
		<jsp:param name="serviceName" value="CuringMoldServiceImpl" />
	</jsp:include>
    
</body>
</html>
