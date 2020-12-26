<!-- 

    作者      :时永良
    时间      :2019年7月19日10:32:29 
    页面名称:模具备模
    文件关联:
        MoldgGetReady.java
        MoldgGetReadyController.java
        MoldgGetReadyServiceImpl.java
        MoldgGetReadyServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="moldggetready.js.jsp"%>
<script type="text/javascript" src="dict/208,206.js"></script>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
    <div style="width:100%;height:60%">
        <div id="MoldgGetReady_dg_toolbar">
            <form id="MoldgGetReady_search_form" class="form" >
            	<!-- 计划编号 -->
            	<spring:message code="moldggetready.column.planno_changemold_s" />:
                <input name="filter[planno_changemold_s]" style="width:14%;" like="true" id="planno_changemold_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 计划状态    300401,已编制  300402，已下发 300403，已组装  300404，已换模 -->
                <spring:message code="moldggetready.column.plan_status_s" />:
                <input name="filter[status_s]" id="status_s"  style="width:14%;" type="text" class="easyui-combobox"  
                			data-options="textField: 'label',
                    						data: [{
												label: '已备模',
												value: '1'
											},{
												label: '未备模',
												value: '0'
											}]" >
                <!-- 机台编码 (不区分左右模) -->
                <spring:message code="moldggetready.column.equip_code_s" />:
                <input name="filter[equip_code_s]" id="equip_code_s" like="true" style="width:14%;" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 备模确认时间 -->
                <spring:message code="moldggetready.column.mold_conf_time_t" />:
                <input name="filter[start_time]" id="start_time" style="width:14%;" type="text" class="easyui-datebox" data-options="label:''" >
               	 到<input name="filter[end_time]" id="end_time" style="width:14%;" type="text" class="easyui-datebox" data-options="label:''" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form>
            <auth:button code="MoldgGetReady.add"><a href="javascript:void(0)" class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="MoldgGetReady.add" /></a></auth:button>
            <auth:button code="MoldgGetReady.remove"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="MoldDelete()"><spring:message code="MoldgGetReady.remove" /></a></auth:button>
            <auth:button code="MoldgGetReady.export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            <auth:button code="MoldgGetReady.showOrHide"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-hide'" onclick="showOrHide()"><spring:message code="button.searchColumn" /></a></auth:button>
        </div>
        <table id="moldggetready_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                title:'换模计划信息',
                pagination:true,
                rownumbers: true,
                singleSelect: true,
                toolbar: '#MoldgGetReady_dg_toolbar',
                striped:true,
                method: 'get',
                emptyMsg:'暂无数据'  
                ">
            <thead data-options="frozen:true">
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 计划编号 -->
                    <th data-options="field:'planno_changemold_s',editor:{type:'textbox'}"><spring:message code="moldggetready.column.planno_changemold_s" /></th>
                    <!-- 备模状态 已备模、待备模 -->
                    <th data-options="field:'status_s',formatter:function(value,row,index){
				                  		if(value=='1'){return '已备模'}
				                  		else if(value=='0'){return '待备模'}}"><spring:message code="moldggetready.column.plan_status_s" /></th>
                    
                    <!-- 备模确认时间 -->
                    <th data-options="field:'mold_changetime_s',editor:{type:'textbox'}"><spring:message code="moldggetready.column.mold_changetime_s" /></th>
                    <!-- 机台编码 (不区分左右模) -->
                    <th id="equip_code_s" data-options="field:'equip_code_s',editor:{type:'textbox'}"><spring:message code="moldggetready.column.equip_code_s" /></th>
                </tr>
           </thead>
            <thead>    
                <tr>
                    <!-- 模具条码 （左模） -->
                    <th  data-options="field:'mold_barcode_left_s',editor:{type:'textbox'}"><spring:message code="moldggetready.column.mold_barcode_left_s" /></th>
                    <!-- 物料编码(左模) -->
                    <th data-options="field:'material_code_left_s',editor:{type:'textbox'}"><spring:message code="moldggetready.column.material_code_left_s" /></th>
                    <!-- 规格(左模) -->
                    <th data-options="field:'speccode_left_s',editor:{type:'textbox'}"><spring:message code="moldggetready.column.speccode_left_s" /></th>
                    <!-- 花纹(左模) -->
                    <th data-options="field:'flowercode_left_s',editor:{type:'textbox'}"><spring:message code="moldggetready.column.flowercode_left_s" /></th>
                    <!-- 右模模具条码 -->
                    <th data-options="field:'moldbarcode_right_s',editor:{type:'textbox'}"><spring:message code="moldggetready.column.moldbarcode_right_s" /></th>
                    <!-- 右模物料编码 -->
                    <th data-options="field:'material_code_right_s',editor:{type:'textbox'}"><spring:message code="moldggetready.column.material_code_right_s" /></th>
                    <!-- 右模规格 -->
                    <th data-options="field:'speccode_right_s',editor:{type:'textbox'}"><spring:message code="moldggetready.column.speccode_right_s" /></th>
                    <!-- 右模花纹 -->
                    <th data-options="field:'flowercode_right_s',editor:{type:'textbox'}"><spring:message code="moldggetready.column.flowercode_right_s" /></th>
                 	<!--胶囊  -->
                    <th data-options="field:'capsule',sortable:true,width:250"><spring:message code="胶囊规格--胶囊名称(左)"/></th>
               		<!--色标线 -->
                    <th data-options="field:'linecolor',sortable:true,width:250"><spring:message code="胎胚色标线(左)" /></th>
                    <!--胶囊  -->
                    <th data-options="field:'capsuleright',sortable:true,width:250"><spring:message code="胶囊规格--胶囊名称(右)" /></th>
               		<!--色标线 -->
                    <th data-options="field:'linecolor',sortable:true,width:250"><spring:message code="胎胚色标线(右)" /></th>
                </tr>
            </thead>
        </table>
      </div>
      <div style="width:100%;height:40%">
      		<form id="moldrecord_dg_search_form" class="form"  style="display:none">
                <input name="filter[chmode_plan_no_s]" style="width:14%;"  id="equip_code_sForm" type="text" class="easyui-textbox" data-options="label:''" >
            </form>
	      <table id="moldrecord_dg" class="easyui-datagrid" style="width:100%"
	            data-options="  
	                fit:true,
	                fitColumns:true,
	                title:'备模履历',
	                pagination:true,
	                rownumbers: true,
	                singleSelect: true,
	                toolbar: '#Moldrecord_dg_toolbar',
	                url: 'curing/moldManagement/moldgGetReady/searchByRecord',
	                striped:true,
	                method: 'get',
	                emptyMsg:'暂无数据'  
	                ">
	            <thead>
	                <tr>
	                	<!-- 换模计划号 -->
	                    <th data-options="field:'chmode_plan_no_s',width:150,editor:{type:'textbox'}"><spring:message code="moldrecord.column.chmode_plan_no_s" /></th>
	                    <!-- 操作类型 -->
	                    <th data-options="field:'optype_s',width:80,formatter:codeFormatter,editor:{type:'combotree',options:{
				                    			method:'get',
				                                url:'dict/code/206',
				                    			required:true}}"><spring:message code="moldrecord.column.optype_s" /></th>
	                    <!-- 左模物料 -->
	                    <th data-options="field:'material_code_left_s',width:120,editor:{type:'textbox'}"><spring:message code="moldrecord.column.material_code_left_s" /></th>
	                    <!-- 左模具编号 -->
	                    <th data-options="field:'mold_code_left_s',width:120,editor:{type:'textbox'}"><spring:message code="moldrecord.column.mold_code_left_t" /></th>
	                    <!-- 右模物料 -->
	                    <th data-options="field:'material_code_right_s',width:120,editor:{type:'textbox'}"><spring:message code="moldrecord.column.material_code_right_s" /></th>
	                   	<!-- 右模具编号 -->
	                    <th data-options="field:'mold_code_right_s',width:120,editor:{type:'textbox'}"><spring:message code="moldrecord.column.mold_code_right_s" /></th>
	                    <!-- 创建人 -->
	                    <th data-options="field:'created_by_name',width:70,editor:{type:'textbox'}"><spring:message code="moldrecord.column.created_by_s" /></th>
	                    <!-- 创建时间 -->
	                    <th data-options="field:'created_time_t',width:120,editor:{type:'textbox'}"><spring:message code="moldrecord.column.created_time_t" /></th> 
	                </tr>
	            </thead>
	        </table>
      </div>
    </div>
    <div id="w" class="easyui-window" title="模具选择" data-options="modal:true,closed:true,iconCls:'icon-save',tools:'#tt'" style="width:80%;height:80%;padding:10px;">
		<auth:button code="MoldgGetReady.save"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="MoldSave()"><spring:message code="button.save" /></a></auth:button> 
	        <table style="width:100%;height: 95%">
	        	<tr style="width:100%">
	        		<td style="width:37%">
				        <table id="Moldrecord_dg_one" class="easyui-datagrid" 
				            data-options="  
				                 fit:true,
				                fitColumns:false,
				                pagination:true,
				                rownumbers: true,
				                singleSelect: true,
				               emptyMsg: '<span><spring:message code='tip.noData'/></span>',
				                striped:true,
				                method: 'get'
				                ">
				            <thead>
				                <tr>
				                 	<th data-options="field:'ATR_KEY',checkbox:true"></th>
				                 	<!-- 左模具编号（LT1315等） -->
                    				<th data-options="field:'MOLD_ID_S',editor:{type:'textbox'}"><spring:message code="curingmold_z.column.mold_id_sl" /></th>
									<!-- 规格 -->
                    				<th data-options="field:'MOLD_SPEC_S', editor:{type:'textbox'}"><spring:message code="curingmold_z.column.mold_spec_sl" /></th>
                    				<!-- 花纹 -->
                    				<th data-options="field:'FLOWER_PATTERN_S',editor:{type:'textbox'}"><spring:message code="curingmold_z.column.flower_pattern_sl" /></th>
				                	<!-- 状态 ：208001已出库 208002已入库 208003已报备 208004使用中 208005已报废 208006未入库 -->
				                    <th data-options="field:'STATUES_ID_S',formatter:codeFormatter,editor:{type:'combotree',options:{
				                    			method:'get',
				                                url:'dict/code/208',
				                    			required:true}}"><spring:message code="curingmold_z.column.statues_id_sl" /></th>
				                    <!-- 库存位置 -->
                    				<th data-options="field:'INVENTORY_LOCATION_S', editor:{type:'textbox'}"><spring:message code="curingmold_z.column.Inventory_Location_sr" /></th>			
				                </tr>
				            </thead>
				        </table> 
	        		</td>
	        		<td style="width:40%">
				       <table id="Moldrecord_dg_two" class="easyui-datagrid" 
				            data-options="  
				                 fit:true,
				                fitColumns:false,
				                pagination:true,
				                rownumbers: true,
				                singleSelect: true,
				                emptyMsg: '<span><spring:message code='tip.noData'/></span>',
				                striped:true,
				                method: 'get'
				                ">
				            <thead>
				                <tr>
				                   <th data-options="field:'ATR_KEY',checkbox:true"></th>
				                 	<!-- 右模具编号（LT1315等） -->
                    				<th data-options="field:'MOLD_ID_S',editor:{type:'textbox'}"><spring:message code="curingmold_z.column.mold_id_sr" /></th>
									<!-- 规格 -->
                    				<th data-options="field:'MOLD_SPEC_S',editor:{type:'textbox'}"><spring:message code="curingmold_z.column.mold_spec_sr" /></th>
                    				<!-- 花纹 -->
                    				<th data-options="field:'FLOWER_PATTERN_S',editor:{type:'textbox'}"><spring:message code="curingmold_z.column.flower_pattern_sr" /></th>
				               		<!-- 状态 ：208001已出库 208002已入库 208003已报备 208004使用中 208005已报废 208006未入库 -->
				                    <th data-options="field:'STATUES_ID_S',formatter:codeFormatter,editor:{type:'combotree',options:{
				                    			method:'get',
				                                url:'dict/code/208',
				                    			required:true}}"><spring:message code="curingmold_z.column.statues_id_sr" /></th>
				                    <!-- 库存位置 -->
                    				<th data-options="field:'INVENTORY_LOCATION_S', editor:{type:'textbox'}"><spring:message code="curingmold_z.column.Inventory_Location_sr" /></th> 			
				                </tr>
				            </thead>
				        </table>
	        		</td>
	        	</tr>
	        </table>
	</div>
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="MoldgGetReady_search_form" />
		<jsp:param name="datagridId" value="moldggetready_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.curing.excel.MoldgGetReadyExportHandler" />
		<jsp:param name="serviceName" value="MoldgGetReadyServiceImpl" />
	</jsp:include>
</body>
</html>
