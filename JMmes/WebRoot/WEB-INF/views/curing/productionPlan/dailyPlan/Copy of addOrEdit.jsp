<!-- 

    作者      :周清玉&刘朋
    时间      :2019-07-16 14:34:18 
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
<%@ include file="addOrEdit.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="ProductionDayPlan_dg_toolbar">
            <form id="ProductionDayPlan_search_form">
	            <!-- 操作时间 -->
	            <input name="filter[production_date_s]" id="production_date_s" type="text" class="easyui-datebox" style="width:250px" data-options="onChange:filter,formatter:dateFormat,buttons:[],parser:dateParser,labelWidth:100,label:'<spring:message code="productiondayplan.column.production_date_s" />'">
	            <script type="text/javascript">
	            $("#production_date_s").val(new Calendar().format("yyyyMMdd"));
	            </script>
	            <!-- 产线条码 -->
	            <spring:message code="productiondayplan.column.production_line_s" />
	            <input type="text" name="filter[production_line_s]" id="production_line_s" class="easyui-combobox" data-options="required:true,data:jtxx,panelHeight:150,editable:true,valueField:'PRODUCTLINE_CODE_S',textField:'PRODUCTLINE_CODE_S',selectOnNavigation:false,limitToList:true,filter:searchProductionLine,onChange:filter" />
	            <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form>
            
            
            <a disable=true class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a>
            <a disable=true class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a>
            <a disable=true class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a>
            　         
            <a disable=true class="easyui-linkbutton btn-red" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a>
            <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>
            
            <a disable=true class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-sort'" onclick="setOrder()"><spring:message code="button.sort" /></a>
            <a disable=false class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-savesort',disabled:true" onclick="saveOrder()"><spring:message code="button.saveSort" /></a>
             
        </div>
        <table id="productiondayplan_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:false,
                rownumbers: true,
                singleSelect: true,
                toolbar: '#ProductionDayPlan_dg_toolbar',
                url: 'curing/productionPlan/dailyPlan/datagrid?all=1',
                striped:true,
                method: 'get',
                onBeginEdit:onBeginEdit,
                onEndEdit:onEndEdit,
                onBeforeLoad:onDgBeforeLoad,
                onLoadSuccess:onLoadSuccess
                ">
             <thead data-options="frozen:true">
	            <tr>
	                <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 计划生产日期 -->
                    <th data-options="field:'production_date_s',width:70,editor:{type:'textbox',options:{editable:false,required:true,icons:[]}}"><spring:message code="productiondayplan.column.production_date_s" /></th>
                     <!-- 日计划号 -->
                    <th data-options="field:'plan_no_s',width:105,editor:{type:'textbox',options:{editable:false,icons:[],required:true}}"><spring:message code="productiondayplan.column.plan_no_s" /></th>
                    <!-- 产线条码 -->
                    <th data-options="field:'production_line_s',width:70,editor:{type:'textbox',options:{required:true,icons:[],editable:false}}"><spring:message code="productiondayplan.column.production_line_s" /></th>
                    <!-- 日计划顺序 -->
                    <th data-options="field:'plan_queue_s',width:70,editor:{type:'numberspinner',options:{icons:[],min:1,max:999,required:true}}"><spring:message code="productiondayplan.column.plan_queue_s" /></th>
	                <!-- 计划状态 218  -->
                    <th data-options="field:'status_s',width:60,hidden:true,formatter:function(v,r,i){return dictFormat(v);}"><spring:message code="productiondayplan.column.status_s" /></th>
	            </tr>
	        </thead>
            <thead>
                <tr>
                    <!-- 物料编码(左) -->
                    <th data-options="field:'material_code_left_s',width:130,editor:{type:'combobox',options:{icons:[{iconCls:'icon-clear',handler:materialClear_left}],onChange:onMaterialChage_left,delay:300,panelWidth:300,required:true,url:'lh/scjh/yjh/materials',onBeforeLoad:onMaterialBeforeLoad,panelHeight:150,editable:true,valueField:'MATERIAL_CODE_S',textField:'MATERIAL_CODE_S',selectOnNavigation:false,limitToList:true,onSelect:onMaterialSelect_left}}"><spring:message code="productiondayplan.column.material_code_left_s" /></th>
                    <!-- 物料编码(右) -->
                    <th data-options="field:'material_code_right_s',width:130,editor:{type:'combobox',options:{icons:[{iconCls:'icon-clear',handler:materialClear_right}],onChange:onMaterialChage_right,delay:300,panelWidth:300,required:true,url:'lh/scjh/yjh/materials',onBeforeLoad:onMaterialBeforeLoad,panelHeight:150,editable:true,valueField:'MATERIAL_CODE_S',textField:'MATERIAL_CODE_S',selectOnNavigation:false,limitToList:true,onSelect:onMaterialSelect_right}}"><spring:message code="productiondayplan.column.material_code_right_s" /></th>
                    <!-- 早班计划量(左) -->
                    <th data-options="field:'planamount_mor_left_i',width:120,editor:{type:'numberspinner',options:{min:0,max:8888888,required:true,onChange:onCountChange,icons:[]}}"><spring:message code="productiondayplan.column.planamount_mor_left_i" /></th>
                    <!-- 中班计划量(左) -->
                    <th data-options="field:'planamount_mid_left_i',width:120,editor:{type:'numberspinner',options:{min:0,max:8888888,required:true,onChange:onCountChange,icons:[]}}"><spring:message code="productiondayplan.column.planamount_mid_left_i" /></th>
                    <!-- 晚班计划量(左) -->
                    <th data-options="field:'planamount_nig_left_i',width:120,editor:{type:'numberspinner',options:{min:0,max:8888888,required:true,onChange:onCountChange,icons:[]}}"><spring:message code="productiondayplan.column.planamount_nig_left_i" /></th>
                    <!-- 早班计划量(右) -->
                    <th data-options="field:'planamount_mor_right_i',width:120,editor:{type:'numberspinner',options:{min:0,max:8888888,required:true,onChange:onCountChange,icons:[]}}"><spring:message code="productiondayplan.column.planamount_mor_right_i" /></th>
                    <!-- 中班计划量(右) -->
                    <th data-options="field:'planamount_mid_right_i',width:120,editor:{type:'numberspinner',options:{min:0,max:8888888,required:true,onChange:onCountChange,icons:[]}}"><spring:message code="productiondayplan.column.planamount_mid_right_i" /></th>
                    <!-- 晚班计划量(右) -->
                    <th data-options="field:'planamount_nig_right_i',width:120,editor:{type:'numberspinner',options:{min:0,max:8888888,required:true,onChange:onCountChange,icons:[]}}"><spring:message code="productiondayplan.column.planamount_nig_right_i" /></th>
                    <!-- 日计划量(左) -->
                    <th data-options="field:'quantity_dayplan_left_i',width:120,editor:{type:'textbox',options:{required:true,icons:[]}}"><spring:message code="productiondayplan.column.quantity_dayplan_left_i" /></th>
                    <!-- 日计划量(右) -->
                    <th data-options="field:'quantity_dayplan_right_i',width:120,editor:{type:'textbox',options:{required:true,icons:[]}}"><spring:message code="productiondayplan.column.quantity_dayplan_right_i" /></th>
                    <!-- 机台条码(左) -->
                    <th data-options="field:'equip_code_left_s',hidden:true,width:120,editor:{type:'textbox',options:{icons:[],required:true,editable:false}}"><spring:message code="productiondayplan.column.equip_code_left_s" /></th>
                    <!-- 机台条码(右) -->
                    <th data-options="field:'equip_code_right_s',hidden:true,width:120,editor:{type:'textbox',options:{icons:[],required:true,editable:false}}"><spring:message code="productiondayplan.column.equip_code_right_s" /></th>
                    <!-- 物料名称(左) -->
                    <th data-options="field:'material_desc_left_s',width:220,editor:{type:'textbox',options:{required:true,icons:[],editable:false}}"><spring:message code="productiondayplan.column.material_desc_left_s" /></th>
                    <!-- 物料名称(右) -->
                    <th data-options="field:'material_desc_right_s',width:220,editor:{type:'textbox',options:{required:true,icons:[],editable:false}}"><spring:message code="productiondayplan.column.material_desc_right_s" /></th>
                    <!-- 成本收集器版本(左) -->
                    <%-- <th data-options="field:'productionver_left_s',width:120,editor:{type:'textbox',options:{icons:[],required:false,editable:false}}"><spring:message code="productiondayplan.column.productionver_left_s" /></th> --%>
                    <!-- 成本收集器版本(右) -->
                    <%-- <th data-options="field:'productionver_right_s',width:120,editor:{type:'textbox',options:{icons:[],required:false,editable:false}}"><spring:message code="productiondayplan.column.productionver_right_s" /></th> --%>
                    <!-- 所属产品阶段(左) -->
                    <th data-options="field:'production_step_left_s',formatter:function(v,r,i){return dictFormat(v);},width:120,editor:{type:'combobox',options:{required:true,editable:false,valueField:'production_step_left_s',textField:'production_step_left_s_text',onSelect:onStageSelect_left}}"><spring:message code="productiondayplan.column.production_step_left_s" /></th>
                    <!-- 所属产品阶段(右) -->
                    <th data-options="field:'production_step_right_s',formatter:function(v,r,i){return dictFormat(v);},width:120,editor:{type:'combobox',options:{required:true,editable:false,valueField:'production_step_right_s',textField:'production_step_right_s_text',onSelect:onStageSelect_right}}"><spring:message code="productiondayplan.column.production_step_right_s" /></th>
                    <!-- 胎胚品号(左) -->
                    <th data-options="field:'specification_left_s',width:120,editor:{type:'textbox',options:{required:true,editable:false,icons:[]}}"><spring:message code="productiondayplan.column.specification_left_s" /></th>
                    <!-- 胎胚品号(右) -->
                    <th data-options="field:'specification_right_s',width:120,editor:{type:'textbox',options:{required:true,editable:false,icons:[]}}"><spring:message code="productiondayplan.column.specification_right_s" /></th>
                    <!-- 胎胚版本(左) -->
                    <th data-options="field:'childbom_ver_left_s',width:120,editor:{type:'textbox',options:{required:true,editable:false,icons:[]}}"><spring:message code="productiondayplan.column.childbom_ver_left_s" /></th>
                    <!-- 胎胚版本(右) -->
                    <th data-options="field:'childbom_ver_right_s',width:120,editor:{type:'textbox',options:{required:true,editable:false,icons:[]}}"><spring:message code="productiondayplan.column.childbom_ver_right_s" /></th>
                    <!-- 工艺配方ID成型 -->
                    <th data-options="field:'processbom_index_build_s',hidden:false,width:120,editor:{type:'textbox',options:{editable:false,icons:[],required:true}}"><spring:message code="productiondayplan.column.processbom_index_build_s" /></th>
                    <!-- 工艺配方ID硫化 -->
                    <th data-options="field:'processbom_index_curing_s',hidden:false,width:120,editor:{type:'textbox',options:{editable:false,icons:[],required:true}}"><spring:message code="productiondayplan.column.processbom_index_curing_s" /></th>
                    <%-- <!-- 日完成量(左) -->
                    <th data-options="field:'qty_dayproduct_left_i',width:120,editor:{type:'textbox'}"><spring:message code="productiondayplan.column.qty_dayproduct_left_i" /></th>
                    <!-- 日完成量(右) -->
                    <th data-options="field:'qty_dayproduct_right_i',width:120,editor:{type:'textbox'}"><spring:message code="productiondayplan.column.qty_dayproduct_right_i" /></th>
                     --%>
                    <!-- 中班原因分析(左) -->
                    <th data-options="field:'reason_midclass_left_s',hidden:true,width:120,editor:{type:'textbox'}"><spring:message code="productiondayplan.column.reason_midclass_left_s" /></th>
                    <!-- 中班原因分析(右) -->
                    <th data-options="field:'reason_midclass_right_s',hidden:true,width:120,editor:{type:'textbox'}"><spring:message code="productiondayplan.column.reason_midclass_right_s" /></th>
                    <!-- 早班原因分析(左) -->
                    <th data-options="field:'reason_morclass_left_s',hidden:true,width:120,editor:{type:'textbox'}"><spring:message code="productiondayplan.column.reason_morclass_left_s" /></th>
                    <!-- 早班原因分析(右) -->
                    <th data-options="field:'reason_morclass_right_s',hidden:true,width:120,editor:{type:'textbox'}"><spring:message code="productiondayplan.column.reason_morclass_right_s" /></th>
                    <!-- 晚班原因分析(左) -->
                    <th data-options="field:'reason_nigclass_left_s',hidden:true,width:120,editor:{type:'textbox'}"><spring:message code="productiondayplan.column.reason_nigclass_left_s" /></th>
                    <!-- 晚班原因分析(右) -->
                    <th data-options="field:'reason_nigclass_right_s',hidden:true,width:120,editor:{type:'textbox'}"><spring:message code="productiondayplan.column.reason_nigclass_right_s" /></th>
                    <!-- 备注(左) -->
                    <th data-options="field:'memo_left_s',width:120,editor:{type:'textbox'}"><spring:message code="productiondayplan.column.memo_left_s" /></th>
                    <!-- 备注(右) -->
                    <th data-options="field:'memo_right_s',hidden:true,width:120,editor:{type:'textbox'}"><spring:message code="productiondayplan.column.memo_right_s" /></th>
                  </tr>
            </thead>
        </table>
    </div>
</body>
</html>
