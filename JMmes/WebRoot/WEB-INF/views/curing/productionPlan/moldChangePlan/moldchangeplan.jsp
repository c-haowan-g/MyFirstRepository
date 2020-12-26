<!-- 

    作者      :司乔靖
    时间      :2019-07-18 10:58:42 
    页面名称:硫化换模计划
    文件关联:
        MoldChangePlan.java
        MoldChangePlanController.java
        MoldChangePlanServiceImpl.java
        MoldChangePlanServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="moldchangeplan.js.jsp"%>
<script type="text/javascript" src="dict/219,205.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="MoldChangePlan_dg_toolbar">
            <form id="MoldChangePlan_search_form" class="form" >
                <!-- 计划编号 -->
                <spring:message code="moldchangeplan.column.planno_changemold_s" />:
                <input name="filter[planno_changemold_s]" id="planno_changemold_s" style="width:140px" type="text" class="easyui-textbox" data-options="label:''" >
               <!-- 换模日期 -->
				<spring:message code="moldchangeplan.column.moldchangetime_s" />
				:&emsp;<input name="filter[begin_mold_changetime]" id="begin_mold_changetime" type="text" class="easyui-datebox" data-options="onChange:filter,buttons:[],formatter:dateFormat,parser:dateParserStart,width:100,label:''">
				 到
				:&emsp;<input name="filter[end_mold_changetime]" id="end_mold_changetime" type="text" class="easyui-datebox" data-options="onChange:filter,buttons:[],formatter:dateFormat,parser:dateParserEnd,width:100,label:''">
				
				<script type="text/javascript">
                $("#begin_mold_changetime").val(new Calendar().format("yyyyMMdd"));
				$("#end_mold_changetime").val(new Calendar().format("yyyyMMdd"));
                </script>
               
                <!-- 机台编码 (不区分左右模) -->
                <spring:message code="moldchangeplan.column.machinecode_s" />:
                <input name="filter[equip_code_s]" id="equip_code_s" type="text"  style="width:120px"  
                	class="easyui-combobox" data-options="
                		label:'',
                    	url:'curing/baseData/curingProductionLineInfo/comboxProductlineEqu',
                    	valueField: 'P_LINE_NAME',
                    	textField: 'P_LINE_NAME',
                    	limitToList:true,
                    	panelHeight:150,
                    	editable:true,
                    	filter:searchBarcode
							" >
				<spring:message code="moldchangeplan.column.plan_status_s" />:
				<input name="filter[plan_status_s]" id="plan_status_s" type="text" class="easyui-combotree" data-options="label:'',
                  labelWidth:'auto',
                  editable:'true',
				  required:false,
				  url:'dict/code/219',
				  method:'get',
				  label:''"><br/>
				 <spring:message code="moldchangeplan.column.executive_s" />:
				 <input  name="filter[executive_s]" id="executive_s" type="text" class="easyui-combobox"  data-options="label:'',
                                        required:false, 
                                       	data: [{
											text: '请选择',
											value: ''
										},{
											text: '已执行',
											value: '1'
										},{
											text: '未执行',
											value: '0'
										}],
			                             method: 'get'"> 
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
	            <auth:button code="LH_SCJH_HMJH_ADD"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
	            <auth:button code="LH_SCJH_HMJH_EDIT"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
	            <auth:button code="LH_SCJH_HMJH_REMOVE"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
	            |
	            <auth:button code="LH_SCJH_HMJH_SAVE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
	            <auth:button code="LH_SCJH_HMJH_CANCEL"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
	            |
	            <auth:button code="LH_SCJH_HMJH_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
	            <auth:button code="LH_SCJH_HMJH_AUDIT">
						<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-shenhe'" onclick="dealAudit('219003')"><spring:message code="button.audit" /></a>
				</auth:button>
				<auth:button code="LH_SCJH_HMJH_CANCEL_AUDIT">
						<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-fanshenhe'" onclick="dealAudit('219001')"><spring:message code="button.cancelaudit" /></a>
				</auth:button>
            </form> 
           
        </div>
        <table id="moldchangeplan_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#MoldChangePlan_dg_toolbar',
                url: 'curing/baseData/moldChangePlan/datagrid',
                emptyMsg: '<span><spring:message code='tip.noData'/></span>',
                striped:true,
                onBeforeLoad:onDgBeforeLoad,
                method: 'get' 
                ">
            <thead>
                <tr>
                	<th field="ck" checkbox="true">ID</th>
                	<!-- 换模计划编号 -->
                    <th data-options="field:'planno_changemold_s',sortable:true,width:150,editor:{type:'textbox',options:{editable:false,icons:[],disabled:true}}""><spring:message code="moldchangeplan.column.planno_changemold_s" /></th>
                	<!-- 换模日期 -->
                    <th data-options="field:'mold_changetime_s',sortable:true,width:110,editor:{type:'datebox',options:{formatter:myformatter,parser:dateParse,required:true}}"><spring:message code="moldchangeplan.column.moldchangetime_s" /></th>
                    <!-- 机台编码 (不区分左右模) -->
                    <th data-options="field:'equip_code_s',sortable:true,width:90,editor:{type:'combobox',options:{
                    	required:true,
                    	url:'curing/baseData/curingProductionLineInfo/comboxProductlineEqu',
                    	valueField: 'P_LINE_NAME',
                    	textField: 'P_LINE_NAME',
                    	limitToList:true,
                    	labelPosition: 'top',
                    	panelHeight:150,
                    	editable:true,
                    	filter: function(q, row){
							var opts = $(this).combobox('options');
							return row[opts.textField].indexOf(q) == 0;
							}
                    	}}"><spring:message code="moldchangeplan.column.equip_code_s" /></th>
                    
                    <!-- 计划状态   -->
                    <th data-options="field:'plan_status_s',sortable:true,width:100,
                    	formatter:codeFormatter,
                    	editor:{type:'combotree',
                    		options:{required:true,
                    		disabled:true,
                    		editable:false,
                    		valueField:'id',
                			textField:'text',
                  			icons:[],
                  			url:'dict/code/219'
                		}}"><spring:message code="moldchangeplan.column.plan_status_s" /></th>
                    <!-- 硫化生产计划.PLAN_NO -->
                    <th data-options="field:'plan_no_s',sortable:true,width:120,editor:{type:'combobox',
                    	options:{required:true,
                    	valueField: 'PLAN_NO_S',
                    	textField: 'PLAN_NO_S',
                    	limitToList:true,
                    	panelHeigth:150,
                    	selectOnNavigate:false,
                    	onShowPanel:getDayPlannoData,
                    	onChange:getInfoByPlanNo,
                    	editable:true
                    	}}"><spring:message code="moldchangeplan.column.plan_no_s" /></th>
                    <!-- 模具条码 （左模） -->
                    <th data-options="field:'mold_barcode_left_s',sortable:true,width:120"><spring:message code="moldchangeplan.column.mold_barcode_s" /></th>
                    <!-- 右模模具条码 -->
                    <th data-options="field:'moldbarcode_right_s',sortable:true,width:100"><spring:message code="moldchangeplan.column.moldbarcode_r_s" /></th>
                    
                     <!-- 物料编码(左模) -->
                    <th data-options="field:'material_code_left_s',width:80,editor:{type:'textbox',options:{editable:false,required:true}}"><spring:message code="moldchangeplan.column.material_code_left_s" /></th>
                    <!-- 右模物料编码 -->
                    <th data-options="field:'material_code_right_s',width:80,editor:{type:'textbox',options:{editable:false,required:true}}"><spring:message code="moldchangeplan.column.material_code_right_s" /></th>
                   
                   <!-- 物料名称(左模) -->
                    <th data-options="field:'material_name_left_s',width:120,editor:{type:'textbox',options:{editable:false,required:true}}"><spring:message code="moldchangeplan.column.material_name_left_s" /></th>
                    <!-- 右模物料名称 -->
                    <th data-options="field:'material_name_right_s',width:120,editor:{type:'textbox',options:{editable:false,required:true}}"><spring:message code="moldchangeplan.column.material_name_right_s" /></th>
                    <!-- 左模规格 -->
                    <th data-options="field:'speccode_left_s',sortable:true,width:100,editor:{type:'textbox',options:{editable:false,required:true}}"><spring:message code="moldchangeplan.column.speccode_s" /></th>
                    <!-- 右模规格 -->
                    <th data-options="field:'speccode_right_s',sortable:true,width:100,editor:{type:'textbox',options:{editable:false,required:true}}"><spring:message code="moldchangeplan.column.speccode_right_s" /></th>
                    <!-- 执行开始时间 -->
                    <th data-options="field:'excute_time_t',sortable:true,width:100"><spring:message code="moldchangeplan.column.excute_time_t" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_s',sortable:true,width:80"><spring:message code="moldchangeplan.column.created_by_s" /></th>
                    <!-- 创建时间-->
                    <th data-options="field:'created_time_t',sortable:true,width:100"><spring:message code="moldchangeplan.column.created_time_t" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changed_by_s',sortable:true,width:80"><spring:message code="moldchangeplan.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',sortable:true,width:100"><spring:message code="moldchangeplan.column.changed_time_t" /></th>
                    <!-- 执行情况   0：未执行   1：执行完成 -->
                    <th data-options="field:'executive_s',sortable:true,formatter:executiveFormatter,width:100"><spring:message code="moldchangeplan.column.executive_s" /></th>
                    <!--胶囊  -->
                    <th data-options="field:'capsule',sortable:true,width:250"><spring:message code="胶囊规格--胶囊名称(左)" /></th>
               		<!--色标线 -->
                    <th data-options="field:'lineColor',sortable:true,width:250"><spring:message code="胎胚色标线(左)" /></th>
                     <!--胶囊  -->
                    <th data-options="field:'capsuler',sortable:true,width:250"><spring:message code="胶囊规格--胶囊名称(右)" /></th>
               		<!--色标线 -->
                    <th data-options="field:'lineColorr',sortable:true,width:250"><spring:message code="胎胚色标线(右)" /></th>
                </tr>
            </thead>
        </table>
    </div>
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="MoldChangePlan_search_form" />
		<jsp:param name="datagridId" value="moldchangeplan_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.lh.ExcelHandler.MoldChangePlanExportHandler" />
		<jsp:param name="serviceName" value="MoldChangePlanServiceImpl" />
	</jsp:include>
</body>
</html>
