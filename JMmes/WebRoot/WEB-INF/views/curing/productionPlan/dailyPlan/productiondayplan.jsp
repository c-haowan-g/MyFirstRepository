<!-- 

    作者      :周清玉&刘朋
    时间      :2019-07-05 14:34:18 
    页面名称:硫化生产日计划
    文件关联:
        ProductionDayPlan.java
        ProductionDayPlanController.java
        ProductionDayPlanServiceImpl.java
        ProductionDayPlanServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<script type="text/javascript" src="dict/218,-307.js"></script>
<%@ include file="productiondayplan.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="ProductionDayPlan_dg_toolbar">
            <form id="ProductionDayPlan_search_form" class="form">
	            <!-- 操作时间 -->
	            <spring:message code="productiondayplan.column.production_date_s" />
	            <input name="filter[production_date_s]" id="production_date_s" type="text" class="easyui-datebox" style="width:120px" data-options="onChange:filter,formatter:dateFormat,buttons:[],parser:dateParser,labelWidth:100,label:''">
	            <script type="text/javascript">
	            $("#production_date_s").val(new Calendar().format("yyyyMMdd"));
	            </script>
	            <!-- 产线条码 -->
	            <spring:message code="productiondayplan.column.production_line_s" />
	            <input type="text" name="filter[production_line_s]" id="production_line_s" class="easyui-combobox" data-options="data:jtxx,panelHeight:150,editable:true,valueField:'P_LINE_NAME',textField:'P_LINE_NAME',selectOnNavigation:false,limitToList:true,filter:searchProductionLine,onChange:filter" />
	            <!-- 物料编码 -->
	            <spring:message code="productiondayplan.column.material_code_left_s" />
	            <input type="text" name="filter[material_code_left_s]" id="material_code_left_s" like ="true" class="easyui-textbox" data-options="" />
	            <!-- 物料名称 -->
	            <spring:message code="productiondayplan.column.material_desc_left_s" />
	            <input type="text" name="filter[material_desc_left_s]" id="material_desc_left_s" like="true" class="easyui-textbox" data-options="" />
	            
	            <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form>
            
            <auth:button code="LH_SCJH_RJH_ADD"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="tip.addOrEdit" /></a></auth:button>
            <auth:button code="LH_SCJH_RJH_COPYPLAN"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-copy'" onclick="copy()"><spring:message code="button.copy" /></a></auth:button>
            　
            <auth:button code="LH_SCJH_RJH_AUDIT"> <a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-shenhe'" onclick="audit()"><spring:message code="button.audit" /></a></auth:button>
            <auth:button code="LH_SCJH_RJH_CANCELAUDIT"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-fanshenhe'" onclick="cancelAudit()"><spring:message code="button.cancelAudit" /></a></auth:button>
            <auth:button code="LH_SCJH_RJH_REMOVE"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            
            <auth:button code="LH_SCJH_RJH_CANCEL"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            
        </div>
        <table id="productiondayplan_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#ProductionDayPlan_dg_toolbar',
                url: 'curing/productionPlan/dailyPlan/plandatagrid',
                striped:true,
                method: 'get',
                onBeginEdit:onBeginEdit,
                onEndEdit:onEndEdit,
                onBeforeLoad:onDgBeforeLoad
                ">
             <thead data-options="frozen:true">
	            <tr>
	                <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 计划生产日期 -->
                    <th data-options="field:'production_date_s',editor:{type:'textbox',options:{editable:false,required:true,icons:[]}}"><spring:message code="productiondayplan.column.production_date_s" /></th>
                     <!-- 日计划号 -->
                    <th data-options="field:'plan_no_s',editor:{type:'textbox',options:{editable:false,icons:[],required:true}}"><spring:message code="productiondayplan.column.plan_no_s" /></th>
                    <!-- 月计划号（左） -->
                    <th data-options="field:'planno_month_s',editor:{type:'textbox',options:{editable:false,icons:[],required:true}}"><spring:message code="月计划号（左）" /></th>
                    <!-- 月计划号（右） -->
                    <th data-options="field:'spare6_s',editor:{type:'textbox',options:{editable:false,icons:[],required:true}}"><spring:message code="月计划号（右）" /></th>
                    <!-- 工单号 -->
                    <th data-options="field:'left_order_number_s',editor:{type:'textbox',options:{editable:false,icons:[],required:true}}"><spring:message code="workordertest.column.order_item" /></th>
                    <!-- 产线条码 -->
                    <th data-options="field:'production_line_s',editor:{type:'textbox',options:{required:true,icons:[],editable:false}}"><spring:message code="productiondayplan.column.production_line_s" /></th>
                    <!-- 日计划顺序 -->
                    <th data-options="field:'plan_queue_s',editor:{type:'numberspinner',options:{icons:[],min:1,max:999,required:true}}"><spring:message code="productiondayplan.column.plan_queue_s" /></th>
                    <!-- 计划状态 218  -->
                    <th data-options="field:'status_s',formatter:function(v,r,i){return dictFormat(v);}"><spring:message code="productiondayplan.column.status_s" /></th>
	            </tr>
	        </thead>
            <thead>
                <tr>
                    <!-- 机台条码(左) -->
                    <th data-options="field:'equip_code_left_s',width:80,hidden:true,editor:{type:'textbox',hidden:true,options:{icons:[],required:true,editable:false}}"><spring:message code="productiondayplan.column.equip_code_left_s" /></th>
                    <!-- 机台条码(右) -->
                    <th data-options="field:'equip_code_right_s',width:80,hidden:true,editor:{type:'textbox',hidden:true,options:{icons:[],required:true,editable:false}}"><spring:message code="productiondayplan.column.equip_code_right_s" /></th>
                    <!-- 物料编码(左) -->
                    <th data-options="field:'material_code_left_s',width:100,editor:{type:'combobox',options:{onChange:onMaterialChage_left,delay:300,panelWidth:300,mode:'remote',required:true,onBeforeLoad:onMaterialBeforeLoad,panelHeight:150,editable:true,valueField:'MATERIAL_CODE_S',textField:'MATERIAL_CODE_S',selectOnNavigation:false,limitToList:true,onSelect:onMaterialSelect_left}}"><spring:message code="productiondayplan.column.material_code_left_s" /></th>
                    <!-- 物料编码(右) -->
                    <th data-options="field:'material_code_right_s',width:100,editor:{type:'combobox',options:{onChange:onMaterialChage_right,delay:300,panelWidth:300,mode:'remote',required:true,onBeforeLoad:onMaterialBeforeLoad,panelHeight:150,editable:true,valueField:'MATERIAL_CODE_S',textField:'MATERIAL_CODE_S',selectOnNavigation:false,limitToList:true,onSelect:onMaterialSelect_right}}"><spring:message code="productiondayplan.column.material_code_right_s" /></th>
                    <!-- 物料名称(左) -->
                    <th data-options="field:'material_desc_left_s',width:180,editor:{type:'textbox',options:{required:true,icons:[],editable:false}}"><spring:message code="productiondayplan.column.material_desc_left_s" /></th>
                    <!-- 物料名称(右) -->
                    <th data-options="field:'material_desc_right_s',width:180,editor:{type:'textbox',options:{required:true,icons:[],editable:false}}"><spring:message code="productiondayplan.column.material_desc_right_s" /></th>
                    <!-- 成本收集器版本(左) -->
                    <th data-options="field:'productionver_left_s',width:80,hidden:true,editor:{type:'textbox',options:{icons:[],required:true,editable:false}}"><spring:message code="productiondayplan.column.productionver_left_s" /></th>
                    <!-- 成本收集器版本(右) -->
                    <th data-options="field:'productionver_right_s',width:80,hidden:true,editor:{type:'textbox',options:{icons:[],required:true,editable:false}}"><spring:message code="productiondayplan.column.productionver_right_s" /></th>
                    <!-- 所属产品阶段(左) -->
                    <th data-options="field:'production_step_left_s',width:80,formatter:function(v,r,i){return dictFormat(v);},editor:{type:'combobox',options:{required:true,editable:false,valueField:'production_step_left_s',textField:'production_step_left_s_text',onSelect:onStageSelect_left}}"><spring:message code="productiondayplan.column.production_step_left_s" /></th>
                    <!-- 所属产品阶段(右) -->
                    <th data-options="field:'production_step_right_s',width:80,formatter:function(v,r,i){return dictFormat(v);},editor:{type:'combobox',options:{required:true,editable:false,valueField:'production_step_right_s',textField:'production_step_right_s_text',onSelect:onStageSelect_right}}"><spring:message code="productiondayplan.column.production_step_right_s" /></th>
                    <!-- 工艺配方ID成型 -->
                    <th data-options="field:'processbom_index_build_s',width:80,hidden:true,editor:{type:'textbox',options:{editable:false}}"><spring:message code="productiondayplan.column.processbom_index_build_s" /></th>
                    <!-- 工艺配方ID硫化 -->
                    <th data-options="field:'processbom_index_curing_s',width:80,hidden:true,editor:{type:'textbox',options:{editable:false}}"><spring:message code="productiondayplan.column.processbom_index_curing_s" /></th>
                    <%-- <!-- 中班完成量(左) -->
                    <th data-options="field:'output_midclass_left_i',width:120,editor:{type:'textbox'}"><spring:message code="productiondayplan.column.output_midclass_left_i" /></th>
                    <!-- 中班完成量(右) -->
                    <th data-options="field:'output_midclass_right_i',width:120,editor:{type:'textbox'}"><spring:message code="productiondayplan.column.output_midclass_right_i" /></th>
                    <!-- 早班完成量(左) -->
                    <th data-options="field:'output_morclass_left_i',width:120,editor:{type:'textbox'}"><spring:message code="productiondayplan.column.output_morclass_left_i" /></th>
                    <!-- 早班完成量(右) -->
                    <th data-options="field:'output_morclass_right_i',width:120,editor:{type:'textbox'}"><spring:message code="productiondayplan.column.output_morclass_right_i" /></th>
                    <!-- 晚班完成量(左) -->
                    <th data-options="field:'output_nigclass_left_i',width:120,editor:{type:'textbox'}"><spring:message code="productiondayplan.column.output_nigclass_left_i" /></th>
                    <!-- 晚班完成量(右) -->
                    <th data-options="field:'output_nigclass_right_i',width:120,editor:{type:'textbox'}"><spring:message code="productiondayplan.column.output_nigclass_right_i" /></th>
                     --%>
                    <!-- 早班计划量(左) -->
                    <th data-options="field:'planamount_mor_left_i',width:80,editor:{type:'numberspinner',options:{min:2,max:8888888,required:true,onChange:onCountChange,icons:[]}}"><spring:message code="productiondayplan.column.planamount_mor_left_i" /></th>
                    <!-- 中班计划量(左) -->
                    <th data-options="field:'planamount_mid_left_i',width:80,editor:{type:'numberspinner',options:{min:2,max:8888888,required:true,onChange:onCountChange,icons:[]}}"><spring:message code="productiondayplan.column.planamount_mid_left_i" /></th>
                    <!-- 晚班计划量(左) -->
                    <th data-options="field:'planamount_nig_left_i',width:80,editor:{type:'numberspinner',options:{min:2,max:8888888,required:true,onChange:onCountChange,icons:[]}}"><spring:message code="productiondayplan.column.planamount_nig_left_i" /></th>
                    <!-- 早班计划量(右) -->
                    <th data-options="field:'planamount_mor_right_i',width:80,editor:{type:'numberspinner',options:{min:2,max:8888888,required:true,onChange:onCountChange,icons:[]}}"><spring:message code="productiondayplan.column.planamount_mor_right_i" /></th>
                    <!-- 中班计划量(右) -->
                    <th data-options="field:'planamount_mid_right_i',width:80,editor:{type:'numberspinner',options:{min:2,max:8888888,required:true,onChange:onCountChange,icons:[]}}"><spring:message code="productiondayplan.column.planamount_mid_right_i" /></th>
                    <!-- 晚班计划量(右) -->
                    <th data-options="field:'planamount_nig_right_i',width:80,editor:{type:'numberspinner',options:{min:2,max:8888888,required:true,onChange:onCountChange,icons:[]}}"><spring:message code="productiondayplan.column.planamount_nig_right_i" /></th>
                    <!-- 日计划量(左) -->
                    <th data-options="field:'quantity_dayplan_left_i',width:80,editor:{type:'textbox',options:{required:true,icons:[]}}"><spring:message code="productiondayplan.column.quantity_dayplan_left_i" /></th>
                    <!-- 日计划量(右) -->
                    <th data-options="field:'quantity_dayplan_right_i',width:80,editor:{type:'textbox',options:{required:true,icons:[]}}"><spring:message code="productiondayplan.column.quantity_dayplan_right_i" /></th>
                    <!-- 胎胚品号(左) -->
                    <th data-options="field:'specification_left_s',width:80,editor:{type:'textbox',options:{required:true,editable:false,icons:[]}}"><spring:message code="productiondayplan.column.specification_left_s" /></th>
                    <!-- 胎胚品号(右) -->
                    <th data-options="field:'specification_right_s',width:80,editor:{type:'textbox',options:{required:true,editable:false,icons:[]}}"><spring:message code="productiondayplan.column.specification_right_s" /></th>
                    <!-- 胎胚规格(左) -->
                    <th data-options="field:'spec_left_s',width:120,editor:{type:'textbox',options:{required:true}}"><spring:message code="productiondayplan.column.spec_left_s" /></th>
                    <!-- 胎胚规格(右) -->
                    <th data-options="field:'spec_right_s',width:120,editor:{type:'textbox',options:{required:true}}"><spring:message code="productiondayplan.column.spec_right_s" /></th>
                   
                    <!-- 胎胚版本(左) -->
                    <th data-options="field:'childbom_ver_left_s',width:80,editor:{type:'textbox',options:{required:true,editable:false,icons:[]}}"><spring:message code="productiondayplan.column.childbom_ver_left_s" /></th>
                    <!-- 胎胚版本(右) -->
                    <th data-options="field:'childbom_ver_right_s',width:80,editor:{type:'textbox',options:{required:true,editable:false,icons:[]}}"><spring:message code="productiondayplan.column.childbom_ver_right_s" /></th>
                    
                    <%-- <!-- 日完成量(左) -->
                    <th data-options="field:'qty_dayproduct_left_i',width:120,editor:{type:'textbox'}"><spring:message code="productiondayplan.column.qty_dayproduct_left_i" /></th>
                    <!-- 日完成量(右) -->
                    <th data-options="field:'qty_dayproduct_right_i',width:120,editor:{type:'textbox'}"><spring:message code="productiondayplan.column.qty_dayproduct_right_i" /></th>
                     --%>
                    <%-- <!-- 中班原因分析(左) -->
                    <th data-options="field:'reason_midclass_left_s',width:120,editor:{type:'textbox'}"><spring:message code="productiondayplan.column.reason_midclass_left_s" /></th>
                    <!-- 中班原因分析(右) -->
                    <th data-options="field:'reason_midclass_right_s',width:120,editor:{type:'textbox'}"><spring:message code="productiondayplan.column.reason_midclass_right_s" /></th>
                    <!-- 早班原因分析(左) -->
                    <th data-options="field:'reason_morclass_left_s',width:120,editor:{type:'textbox'}"><spring:message code="productiondayplan.column.reason_morclass_left_s" /></th>
                    <!-- 早班原因分析(右) -->
                    <th data-options="field:'reason_morclass_right_s',width:120,editor:{type:'textbox'}"><spring:message code="productiondayplan.column.reason_morclass_right_s" /></th>
                    <!-- 晚班原因分析(左) -->
                    <th data-options="field:'reason_nigclass_left_s',width:120,editor:{type:'textbox'}"><spring:message code="productiondayplan.column.reason_nigclass_left_s" /></th>
                    <!-- 晚班原因分析(右) -->
                    <th data-options="field:'reason_nigclass_right_s',width:120,editor:{type:'textbox'}"><spring:message code="productiondayplan.column.reason_nigclass_right_s" /></th>
                     --%>
                     <!-- 备注(左) -->
                    <th data-options="field:'memo_left_s',width:180,editor:{type:'textbox'}"><spring:message code="productiondayplan.column.memo_left_s" /></th>
                    <!-- 备注(右) -->
                    <th data-options="field:'memo_right_s',width:180,editor:{type:'textbox'}"><spring:message code="productiondayplan.column.memo_right_s" /></th>
                    <!-- 计划状态 218  -->
                    <th data-options="field:'status_s',width:80,formatter:function(v,r,i){return dictFormat(v);}"><spring:message code="productiondayplan.column.status_s" /></th>
                    <!-- 审核时间 -->
                    <th data-options="field:'approval_time_s',width:120,"><spring:message code="productiondayplan.column.approval_time_s" /></th>
                    <!-- 执行时间 -->
                    <th data-options="field:'spare9_s',width:120,"><spring:message code="classplan.column.production_date_s" /></th>
                    <!-- 审核人 -->
                    <th data-options="field:'approver_s',width:120,"><spring:message code="productiondayplan.column.approver_s" /></th>
                    <!-- 更新人 -->
                    <th data-options="field:'changed_by_s',width:100,"><spring:message code="productiondayplan.column.changed_by_s" /></th>
                    <!-- 更新时间 -->
                    <th data-options="field:'changed_time_t',width:120,"><spring:message code="productiondayplan.column.changed_time_t" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_s',width:120,"><spring:message code="productiondayplan.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',width:120,"><spring:message code="productiondayplan.column.created_time_t" /></th>
                    
                </tr>
            </thead>
        </table>
    </div>
    <jsp:include page="../../../../inc/export.jsp">
        <jsp:param name="idField" value="atr_key" />
        <jsp:param name="formId" value="ProductionDayPlan_search_form" />
        <jsp:param name="datagridId" value="productiondayplan_dg" />
        <jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.curing.excel.ProductionDayPlanExportHandler" />
        <jsp:param name="serviceName" value="ProductionDayPlanServiceImpl" />
    </jsp:include>

    <div id="dlg" title="<spring:message code="tip.addOrEdit" />" class="easyui-dialog" style="width:90%;height:90%;"
            data-options="
                closed:true,
                iconCls: 'icon-save',
                maximizable:true,
                buttons: [{
                    iconCls:'icon-no',
                    text:'<spring:message code="button.close" />',
                    handler:function(){
                       $('#dlg').dialog('close');
                    }
                }],
                onOpen:function(){
                    $('#addOrEditWin').attr('src','view?page=curing/productionPlan/dailyPlan/addOrEdit&factory='+factory);
                }
            ">
        <iframe
            id="addOrEditWin"
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
    
    <div id="dlg-copy" title="<spring:message code="button.copy" />" class="easyui-dialog" style="width:90%;height:90%;"
            data-options="
                closed:true,
                iconCls: 'icon-save',
                maximizable:true,
                buttons: [{
                    iconCls:'icon-no',
                    text:'<spring:message code="button.close" />',
                    handler:function(){
                       $('#dlg-copy').dialog('close');
                    }
                }],
                onOpen:function(){
                    $('#copyWin').attr('src','view?page=curing/productionPlan/dailyPlan/copy&factory='+factory);
                }
            ">
        <iframe
            id="copyWin"
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
</body>
</html>
