<!-- 

    作者      :刘朋
    时间      :2019-08-22
    页面名称:成型产量与SAP集成报产--------主页面
    文件关联:
        MesSapProduction.java
        MesSapProductionController.java
        MesSapProductionServiceImpl.java
        MesSapProductionServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="maininterface.js.jsp"%>
<script type="text/javascript" src="dict/252,193.js"></script>
<style type="text/css">
.columnTitle {
	padding: 6px 10px
}
</style>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="MainInterface_dg_toolbar">
            <form id="MainInterface_search_form" class="form" >
            	<td class="columnTitle">
            	<spring:message code="messapproduction.column.batch_id_s" />
                <!-- 上传批次号 -->
                :&nbsp;<input name="filter[batch_id_s]" like="true" id="batch_id_s" type="text" class="easyui-textbox" data-options="label:''" >
                </td>
               
                <td class="columnTitle">
                <spring:message code="messapproduction.column.material_code_s" />
                <!-- 物料编码（18位） -->
                :&nbsp;<input name="filter[material_code_s]" like="true"  id="material_code_s" type="text" class="easyui-textbox" data-options="label:''" >
                </td>
                <td class="columnTitle">
                <spring:message code="messapproduction.column.record_sap_flag_s" />
                <!-- 记录标示（0:未上传SAP；1：已上传未返回结果；2：SAP返回OK；3：SAP返回NG) -->
                :&nbsp;  <input name="filter[record_sap_flag_s]" id="record_sap_flag_s" type="text" class="easyui-combobox" 
		             data-options="label:'',
								   panelHeight:200,
								   editable:true,
								   required:false,
								   textField: 'label',
								   valueField: 'value',
								   data: [{label:'SAP未读取',value:'0'},
								          {label:'已读取',value:'1'},
								          {label:'正常',value:'2'},
								          {label:'错误',value:'3'}]
								  ">
                </td>
                <td class="columnTitle">
                <spring:message code="messapproduction.column.solid_flag_s" />
                <!-- 固化标识(0 未固化 1 固化) -->
                :&nbsp;<input name="filter[solid_flag_s]" id="solid_flag_s"type="text" class="easyui-combobox" 
		             data-options="label:'',
								   panelHeight:200,
								   editable:true,
								   required:false,
								   textField: 'label',
								   valueField: 'value',
								   data: [{label:'未固化',value:'0'},
								          {label:'已固化',value:'1'}]
								  ">
                </td>
                <br/>
                <td class="columnTitle">
                <spring:message code="messapproduction.column.serid_s" />
                <!--LZMES+YYYYmmdd+类型 （01/02）+4 位流水号 -->
                :&nbsp;<input name="filter[serid_s]" id="serid_s" like="true"  type="text" class="easyui-textbox" data-options="label:''" >
                </td>
                
                <td class="columnTitle">
                <spring:message code="messapproduction.column.product_type_s" />
                <!-- 报产方式（01：报产，02：冲产） -->
                :&nbsp;<input name="filter[product_type_s]" id="product_type_s" type="text" class="easyui-combobox" data-options="valueField:'value',
	                                textField:'text',
	                                method:'get',
	                                editable:true,
	                                data: [{
											text: '报产',
											value: '01'
										},{
											text: '冲产',
											value: '02'
										}]" >
                </td>
                <td class="columnTitle">
                <spring:message code="messapproduction.column.class_id_s" />
                <!-- 班次 -->
                :&nbsp;<input name="filter[class_id_s]" id="class_id_s" type="text" class="easyui-combotree" data-options="label:'', 
                              required:false,
                              url:'dict/code/193',
                              method:'get'">
                </td>
                <input name="filter[process_s]" id="process_s" value='252005' type="text" class="easyui-textbox">
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
                </form> 
                <auth:button code="CX_QUAN_GANG_SAP_SOLID"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-shenhe'" onclick="curing()"><spring:message code="button.curing" /></a></auth:button>
                <auth:button code="CX_QUAN_GANG_SAP_REPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-supplier'" onclick="reporttosap()"><spring:message code="button.report" /></a></auth:button>
                <auth:button code="CX_QUAN_GANG_SAP_UPDATESOLID"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-maintype'" onclick="updatesolid()"><spring:message code="button.updatesolid" /></a></auth:button>
                <auth:button code="CX_QUAN_GANG_SAP_REFLUSH"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-supplier'" onclick="reflushtosap()"><spring:message code="button.reflush" /></a></auth:button>
                <auth:button code="CX_QUAN_GANG_SAP_DETAIL"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-shenhe'" onclick="productionDetail()"><spring:message code="button.detail" /></a></auth:button>
        </div>
        <table id="MainInterface_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#MainInterface_dg_toolbar',
                url: 'curing/mesapproduction/datagridUDA',
                emptyMsg: '<span><spring:message code='tip.noData'/></span>',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 上传批次号 (报产工单号)-->
                    <th data-options="field:'batch_id_s',editor:{type:'textbox'}"><spring:message code="messapproduction.column.batch_id_s" /></th>
                    <!-- LZMES+YYYYmmdd+类型 （01/02）+4 位流水号 -->
                    <th data-options="field:'serid_s',editor:{type:'textbox'}"><spring:message code="messapproduction.column.serid_s" /></th>
                    <!-- 报产方式（01：报产，02：冲产） -->
                    <th data-options="field:'product_type_s',formatter:bcTypeFormatter,styler:cellStyler,editor:{type:'textbox'}"><spring:message code="messapproduction.column.product_type_s" /></th>
                    <!-- 记录标示 -->
                    <th data-options="field:'record_sap_flag_s',formatter:rsFormatter,styler:cellSapRecordStyler,editor:{type:'textbox'}"><spring:message code="messapproduction.column.record_sap_flag_s" /></th>
                    <!-- 过账日期（默认当前日期YYYYMMDD 月底最后一天16点之后跨天） -->
                    <th data-options="field:'post_date_s',editor:{type:'textbox'}"><spring:message code="messapproduction.column.post_date_s" /></th>
                    <!-- 班次 -->
                    <th data-options="field:'class_id_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="messapproduction.column.class_id_s" /></th>
                    <!-- 实际固化数量 -->
                    <th data-options="field:'actual_quantity_f',editor:{type:'textbox'}"><spring:message code="messapproduction.column.actual_quantity_f" /></th>
                    <!-- 记录一下物料编码80位的 -->
                    <th data-options="field:'rush_serid_s',editor:{type:'textbox'}"><spring:message code="messapproduction.column.rush_serid_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'material_name_s',editor:{type:'textbox'}"><spring:message code="messapproduction.column.material_name_s" /></th>
                    <!-- 操作工姓名 -->
                    <th data-options="field:'operate_usernane_s',editor:{type:'textbox'}"><spring:message code="messapproduction.column.operate_usernane_s" /></th>
                    <!-- 操作时间 -->
                    <th data-options="field:'operate_time_s',editor:{type:'textbox'}"><spring:message code="messapproduction.column.operate_time_s" /></th>
                    <!-- 生产版本 -->
                    <th data-options="field:'pro_version_s',editor:{type:'textbox'}"><spring:message code="messapproduction.column.pro_version_s" /></th>
                    <!-- 固化标识(0 未固化 1 固化) -->
                    <th data-options="field:'solid_flag_s',styler:solidflagStyler,formatter:ghFormatter,editor:{type:'textbox'}"><spring:message code="messapproduction.column.solid_flag_s" /></th>
                     <!-- 下线库位 -->
                    <th data-options="field:'storage_loc_s',editor:{type:'textbox'}"><spring:message code="messapproduction.column.storage_loc_s" /></th>
                    <!-- 上传次数 -->
                    <th data-options="field:'upload_num_s',editor:{type:'textbox'}"><spring:message code="messapproduction.column.upload_num_s" /></th>
                    <!-- 上传人 -->
                    <th data-options="field:'upload_userid_s',editor:{type:'textbox'}"><spring:message code="messapproduction.column.upload_userid_s" /></th>
                    <!-- 上传时间 -->
                    <th data-options="field:'upload_time_t',editor:{type:'textbox'}"><spring:message code="messapproduction.column.upload_time_t" /></th>
                    <!-- 备注 -->
                    <th data-options="field:'memo_s',editor:{type:'textbox'}"><spring:message code="messapproduction.column.memo_s" /></th>
                    <!-- 报工工序 -->
                    <th data-options="field:'process_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="messapproduction.column.process_s" /></th>
                </tr>
            </thead>
        </table>
    </div>
    <div id="curingdlg" title="<spring:message code="button.curing" />" class="easyui-dialog" style="width:90%;height:90%;"
            data-options="
                closed:true,
                iconCls: 'icon-supplier',
                maximizable:true,
                buttons: [{
                    iconCls:'icon-no',
                    text:'<spring:message code="button.close" />',
                    handler:function(){
                       $('#curingdlg').dialog('close');
                       filter();
                    }
                }],
                onOpen:function(){
                $('#curingaddOrEditWin').attr('src','view?page=building/report/moldingproductiontosap/moldingsap&factory='+factory);
                }
            ">
        <iframe
            id="curingaddOrEditWin"
		    src=""
		    width="100%"
		    height="100%"
		    frameborder="no"
		    border="0"
		    marginwidth="0"
		    marginheight="0"
		    scrolling="no"
		    allowtransparency="yes">
		</iframe>
    </div> 
     <div id="moldingdlg" title="<spring:message code="button.updatesolid" />" class="easyui-dialog" style="width:90%;height:90%;"
            data-options="
                closed:true,
                iconCls: 'icon-supplier',
                maximizable:true,
                buttons: [{
                    iconCls:'icon-no',
                    text:'<spring:message code="button.close" />',
                    handler:function(){
                       $('#moldingdlg').dialog('close');
                       filter();
                    }
                }],
                onOpen:function(){
                $('#moldingaddOrEditWin').attr('src','view?page=building/report/moldingproductiontosap/updatemoldingsap&factory='+factory);
                }
            ">
        <iframe
            id="moldingaddOrEditWin"
		    src=""
		    width="100%"
		    height="100%"
		    frameborder="no"
		    border="0"
		    marginwidth="0"
		    marginheight="0"
		    scrolling="no"
		    allowtransparency="yes">
		</iframe>
    </div> 
    
    
     <!-- 明细窗口 -->
    <div id="workorderresult_detail_dg" class="easyui-dialog" title="明细查询窗口" style="width:900px;height:400px;"
            data-options="
                closed:true
            ">
             <table class="easyui-datagrid" style="width:100%" id="detail_dg"
	            data-options="
	                 fit:true,
	                 fitColumns:false,
					 singleSelect:false,
					 autoRowHeight:true,
					 rownumbers:true,
					 loadMsg:'加载中。。。',
					 height:'auto',
	                  method:'get',
	                  emptyMsg:'暂无数据',
	                  striped:true
	                  ">
	            <thead>
	                <tr>
	                    <!-- 轮胎条码 -->
					    <th data-options="field:'tyre_barcode_s',sortable:true,editor:{type:'textbox'}"><spring:message code="workorderresult.column.tyre_barcode_s" /></th>
	                    <!-- 成型质量等级 -->
						<th data-options="field:'quality_status_s',formatter:codeFormatter,sortable:true,editor:{type:'textbox'}"><spring:message code="workorderresultprint.column.quality_status_s" /></th>
						<!-- 机台编码 -->
						<th data-options="field:'equip_code_s',sortable:true,editor:{type:'textbox'}"><spring:message code="c_mm_workorderresult.column.equip_code_s" /></th>
						<!-- 物料编码 -->
	                    <th data-options="field:'material_code_s',editor:{type:'textbox'}"><spring:message code="workorderresult.column.material_code_s" /></th>
	                    <!-- 规格描述 -->
	                    <th data-options="field:'material_name_s',editor:{type:'textbox'}"><spring:message code="workorderresult.column.material_name_s" /></th>
	                    <!-- 生产日期 -->
						<th data-options="field:'building_date_t',sortable:true,editor:{type:'textbox'}"><spring:message code="workorderresult.column.product_date_s" /></th>
	                </tr>
	            </thead>
	        </table>
    </div>
    
</body>
</html>
