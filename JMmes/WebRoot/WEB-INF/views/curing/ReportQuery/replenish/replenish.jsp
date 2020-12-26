<!-- 

    作者      :高飞
    时间      :2019-03-26 13:31:11 
    页面名称:补录
    文件关联:
        SapReturnResult.java
        SapReturnResultController.java
        SapReturnResultServiceImpl.java
        SapReturnResultServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<script type="text/javascript" src="dict/252,302.js"></script>
<%@ include file="replenish.js.jsp"%>
<script type="text/javascript">
$.extend($.fn.textbox.defaults, {
    "icons" : []
});
</script>
<body class="easyui-layout" fit="true">
	<div data-options="region:'center',split:true,border:false">
		<div id="MesSapProduction_dg_toolbar">
			<form id="MesSapProduction_search_form" class="form">
				<td class="columnTitle"><spring:message code="messapproduction.column.batch_id_s" /> <!-- 上传批次号 --> <input name="filter[batch_id_s]" like="true" id="batch_id_s" type="text" class="easyui-textbox" data-options="label:''"></td>

				<td class="columnTitle"><spring:message code="messapproduction.column.material_code_s" /> <!-- 物料编码（18位） --> <input name="filter[material_code_s]" like="true" id="material_code_s" type="text" class="easyui-textbox" data-options="label:''"></td>
				<td class="columnTitle"><spring:message code="messapproduction.column.class_id_s" /> <!-- 班次 --> <input name="filter[class_id_s]" id="class_id_s" type="text" class="easyui-combotree" style="width:150px" data-options="label:'', 
                              required:false,
                              url:'dict/code/302',
                              method:'get'"></td> <br>
				<td class="columnTitle"><spring:message code="messapproduction.column.operate_usernane_s" /> <!-- 操作工姓名 --> <input name="filter[operate_usernane_s]" like="true" id="operate_usernane_s" type="text" class="easyui-textbox" data-options="label:''"></td>

				<td class="columnTitle"><spring:message code="messapproduction.column.product_type_s" /> <!-- 报产方式（01：报产，02：冲产） --> <input name="filter[product_type_s]" id="product_type_s" type="text" class="easyui-combobox"
						data-options="valueField:'value',
                                    textField:'text',
                                    method:'get',
                                    editable:true,
                                    data: [{
                                            text: '报产',
                                            value: '01'
                                        },{
                                            text: '冲产',
                                            value: '02'
                                        }]"></td>
				<td class="columnTitle"><spring:message code="messapproduction.column.serid_s" /> <!-- LZMES+YYYYmmdd+类型 （01/02）+4 位流水号 --> <input name="filter[serid_s]" id="serid_s" like="true" type="text" class="easyui-textbox" data-options="label:''"></td>

				<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()">
					<spring:message code="button.search" />
				</a>
			</form>
			<auth:button code="SRR_REPLENISH_GUHUA"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-shenhe'" onclick="guhua_dlg()"><spring:message code="button.curing" /></a></auth:button>
            <auth:button code="SRR_REPLENISH_UPLOAD"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-reload'" onclick="reporttosap()"><spring:message code="button.report" /></a></auth:button>
            <auth:button code="SRR_REPLENISH_SAVE"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-save'" onclick="save()">保存</a></auth:button>
            <auth:button code="SRR_REPLENISH_ADD"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-add'" onclick="add()">添加</a></auth:button>
            <auth:button code="SRR_REPLENISH_EDIT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-edit'" onclick="edit()">编辑</a></auth:button>
            <auth:button code="SRR_REPLENISH_DELETE"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-no'" onclick="remove()">删除</a></auth:button>
		</div>
		<table id="messapproduction_dg" class="easyui-datagrid" style="width:100%"
			data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                clickToEdit:false,
                singleSelect: false,
                toolbar: '#MesSapProduction_dg_toolbar',
                url: 'curing/mesapproduction/datagrid',
                onBeforeLoad:onMesSapDgBeforeLoad,
                striped:true,
                method: 'get' 
                ">
			<thead>
				<tr>
					<th data-options="width:100,field:'atr_key',checkbox:true"></th>
					<!-- 报产方式（01：报产，02：冲产） -->
					<th data-options="width:100,field:'product_type_s',formatter:bcTypeFormatter,editor:{type:'combobox',options:{required:true,readonly:true,data:[{value:'01',text:'报产'},{value:'02',text:'冲产'}]}}"><spring:message code="messapproduction.column.product_type_s" />　　</th>
					<%-- <!-- 报工工序 -->
					<th data-options="width:100,field:'process_s',formatter:codeFormatter,editor:{type:'combobox',options:{readonly:true,data:[{value:'252004',text:'半部件'},{value:'252005',text:'成型'},{value:'252006',text:'硫化'},{value:'252007',text:'割毛'},{value:'252008',text:'外观'},{value:'252009',text:'X光'},{value:'252010',text:'动平衡'},{value:'252011',text:'均匀性'},{value:'252013',text:'入库'},{value:'252014',text:'发货'},{value:'252015',text:'退车间'}]}}"><spring:message code="messapproduction.column.process_s" />　　</th>
					 --%>
					<!-- 过账日期（默认当前日期YYYYMMDD 月底最后一天16点之后跨天） -->
					<th data-options="width:100,field:'post_date_s',editor:{type:'textbox',options:{readonly:true}}"><spring:message code="messapproduction.column.post_date_s" /></th>
					
					<!-- LZMES+YYYYmmdd+类型 （01/02）+4 位流水号 -->
					<th data-options="width:150,field:'serid_s',editor:{type:'combobox',options:{readonly:true,panelWidth:150,required:true,mode:'remote',url:'lh/scgl/sap_return_result/code',limitToList:true,onBeforeLoad:onOrderBeforeLoad}}"><spring:message code="messapproduction.column.serid_s" /></th>
					 
					<!--  
					<th data-options="field:'serid_s',width:100,editor:{
                    type:'combobox',
                    options:{
                    readonly:true,
                    panelWidth:150,
                    required:true,
                    url:'lh/scgl/sap_return_result/code',
                    valueField:'value',
			        textField:'text',
                    limitToList:true,
                    onBeforeLoad:onOrderBeforeLoad
                  	}}"> -->
					
					<!-- 上传批次号 -->
					<th data-options="width:150,field:'batch_id_s',editor:{type:'textbox',options:{readonly:true}}"><spring:message code="messapproduction.column.batch_id_s" /></th>
					
					<!-- 记录一下物料编码80位的 -->
                    <th data-options="width:130,field:'rush_serid_s',editor:{type:'textbox',options:{readonly:true}}"><spring:message code="messapproduction.column.rush_serid_s" /></th>
                    <!-- 物料编码（18位） -->
                    <th data-options="width:150,field:'material_code_s',editor:{type:'combobox',options:{onSelect:onMtSelect,delay:300,panelHeight:200,required:true,url:'sap/materials/list',mode:'remote',editable:true,valueField:'materialcode_s',textField:'materialcode_s',selectOnNavigation:false,limitToList:true}}"><spring:message code="messapproduction.column.material_code_s" />　　　　</th>
                    <!-- 物料名称 -->
                    <th data-options="width:100,field:'material_name_s',editor:{type:'textbox',options:{readonly:true}}"><spring:message code="messapproduction.column.material_name_s" /></th>
                    <!-- 生产版本 -->
                    <th data-options="width:100,field:'pro_version_s',editor:{type:'combobox',options:{required:true}}"><spring:message code="messapproduction.column.pro_version_s" />　　　　</th>
                    <!-- 实际固化数量 -->
                    <th data-options="width:100,field:'actual_quantity_f',editor:{type:'numberspinner',options:{min:1,max:99999,required:true}}"><spring:message code="messapproduction.column.actual_quantity_f" /></th>
					<!-- 班次 -->
					<th data-options="width:100,field:'class_id_s',formatter:codeFormatter,editor:{type:'combobox',options:{required:true,data:[{value:'302001',text:'早班'},{value:'302002',text:'中班'},{value:'302003',text:'晚班'}]}}"><spring:message code="messapproduction.column.class_id_s" />　　　　</th>
					<!-- 同过账日期 -->
					<th data-options="width:100,field:'doc_date_s',editor:{type:'textbox',options:{readonly:true}}"><spring:message code="messapproduction.column.doc_date_s" /></th>
					<!-- 产品下线批次（当前年份，过账日期前4位） -->
					<th data-options="width:100,field:'batch_s',editor:{type:'textbox',options:{readonly:true}}"><spring:message code="messapproduction.column.batch_s" /></th>
					<!-- 操作工姓名 -->
					<th data-options="width:100,field:'operate_usernane_s',editor:{type:'textbox',options:{readonly:true}}"><spring:message code="messapproduction.column.operate_usernane_s" /></th>
					<!-- 操作时间 -->
					<th data-options="width:100,field:'operate_time_s',editor:{type:'textbox',options:{readonly:true}}"><spring:message code="messapproduction.column.operate_time_s" /></th>
					<!-- 固化标识(0 未固化 1 固化) -->
					<th data-options="width:100,field:'solid_flag_s',formatter:ghFormatter,editor:{type:'combobox',options:{data:[{value:0,text:'未固化'},{value:1,text:'已固化'}],readonly:true}}"><spring:message code="messapproduction.column.solid_flag_s" /></th>
					<!-- 记录标示 -->
					<th data-options="width:100,field:'record_sap_flag_s',formatter:rsFormatter,editor:{type:'combobox',options:{readonly:true,data:[{value:0,text:'SAP未读取'},{value:1,text:'已读取'},{value:2,text:'正常'},{value:3,text:'错误'}]}}"><spring:message code="messapproduction.column.record_sap_flag_s" />　　　　</th>
					<!-- 下线库位 -->
					<th data-options="width:100,field:'storage_loc_s',editor:{type:'textbox',options:{readonly:true}}"><spring:message code="messapproduction.column.storage_loc_s" /></th>
					<!-- 上传次数 -->
					<th data-options="width:100,field:'upload_num_s',editor:{type:'textbox',options:{readonly:true}}"><spring:message code="messapproduction.column.upload_num_s" /></th>
					<!-- 上传人 -->
					<th data-options="width:100,field:'upload_userid_s',editor:{type:'textbox',options:{readonly:true}}"><spring:message code="messapproduction.column.upload_userid_s" /></th>
					<!-- 上传时间 -->
					<th data-options="width:100,field:'upload_time_t',editor:{type:'textbox',options:{readonly:true}}"><spring:message code="messapproduction.column.upload_time_t" /></th>
					<!-- 备注 -->
					<th data-options="width:100,field:'memo_s',editor:{type:'textbox',options:{readonly:true}}"><spring:message code="messapproduction.column.memo_s" /></th>
				</tr>
			</thead>
		</table>
	</div>
	<div id="guhua_dlg" title="<spring:message code="button.curing" />" class="easyui-dialog" style="width:100%;height:90%;"
		data-options="
                closed:true,
                iconCls: 'icon-supplier',
                maximizable:true,
                buttons: [{
                    iconCls:'icon-no',
                    text:'<spring:message code="button.close" />',
                    handler:function(){
                       $('#curingdlg').dialog('close');
                       guhua_filter();
                }
                }],
                onOpen:function(){
                }
            ">
		<div id="MesSapProduction_dg_toolbar2">
			<form id="MesSapProduction_search_form2" class="form">
				<spring:message code="maintyrecur.column.curingclosemouldtime_t" />
				<input name="filter[beginTime]" type="text" id="beginTime" class="easyui-datetimebox" style="width:150px;" data-options="label:'',onSelect:onBeginSelect">
				<spring:message code="tip.to" />
				<input name="filter[endTime]" id="endTime" class="easyui-datetimebox" style="width:150px;" data-options="onSelect:onEndSelect">
				
				<spring:message code="messapproduction.column.material_code_s" />
				<input name="filter[material_code]" id="material_code" class="easyui-textbox" style="width:150px;" data-options="onSelect:onEndSelect">
				<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="guhua_filter()">
					<spring:message code="button.search" />
				</a>
			</form>
			<a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-save'" onclick="guhua()">固化</a>
		</div>
		<table id="messapproduction_dg2" class="easyui-datagrid" style="width:100%" data-options="  
                fit:true,
                fitColumns:true,
                pagination:false,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#MesSapProduction_dg_toolbar2',
                striped:true,
                method: 'get' 
                ">
			<thead>
				<tr>
					<th data-options="field:'',checkbox:true"></th>
					<th data-options="field:'material_code_s',width:100">物料编码</th>
					<th data-options="field:'material_name_s',width:100">物料名称</th>
					<th data-options="field:'productionver_s',width:100">生产版本</th>
					<th data-options="field:'class_id_s',formatter:codeFormatter">班组</th>
					<th data-options="field:'total',width:100">数量</th>
				</tr>
			</thead>
		</table>
	</div>
</body>
</html>
