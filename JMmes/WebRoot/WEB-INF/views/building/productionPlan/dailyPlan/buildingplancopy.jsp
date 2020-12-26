<!--

作者 :时永良
时间 :2019-02-26 17:37:56
页面名称:成型日计划表
文件关联:
CxProductionDayPlan.java
CxProductionDayPlanController.java
CxProductionDayPlanServiceImpl.java
CxProductionDayPlanServiceImpl.xml
-->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="../../../../inc/meta.jsp" %>
<%@ include file="buildingplancopy.js.jsp" %>
<script type="text/javascript" src="dict/152,-307,328.js"></script>

<body class="easyui-layout" fit="true">
<div data-options="region:'center',split:true,border:false">
    <div id="CxProductionDayPlan_dg_toolbar">
        <form id="CxProductionDayPlan_search_form" class="form">
            <spring:message code="tip.from"/>
            :&emsp;<input id="datebox_from" type="text" class="easyui-datebox" style="width:100px"
                          data-options="formatter:dateFormat,buttons:[],parser:dateParser,labelWidth:30,label:''">
            <spring:message code="tip.copy"/> <spring:message code="tip.to"/>
            :&emsp;<input id="datebox_to" type="text" class="easyui-datebox" style="width:100px"
                          data-options="formatter:dateFormat,buttons:[],parser:dateParser,labelWidth:70,label:''">
            <script type="text/javascript">
                $("#production_date_s").val(new Calendar().format("yyyyMMdd"));
                $("#production_date_to_s").val(new Calendar().format("yyyyMMdd"));
            </script>
        </form>
        <auth:button code="CX_PRODUCTIONPLAN_DAILYPLAN_COPY"><a class="easyui-linkbutton btn-yellow"
                                                                data-options="iconCls:'icon-copy'"
                                                                onclick="copyDayplan()"><spring:message
                code="button.copy"/></a></auth:button>
      <%--   <auth:button code="CX_PRODUCTIONPLAN_DAILYPLAN_ADD"><a class="easyui-linkbutton btn-green"
                                                               data-options="iconCls:'icon-add'"
                                                               onclick="add()"><spring:message
                code="button.add"/></a></auth:button> --%>
      <%--   <auth:button code="CX_PRODUCTIONPLAN_DAILYPLAN_EDIT"><a class="easyui-linkbutton btn-red"
                                                                data-options="iconCls:'icon-edit'"
                                                                onclick="edit()"><spring:message
                code="button.edit"/></a></auth:button> --%>
        <%-- <auth:button code="CX_PRODUCTIONPLAN_DAILYPLAN_REMOVE"><a class="easyui-linkbutton btn-black"
                                                                  data-options="iconCls:'icon-remove'"
                                                                  onclick="remove()"><spring:message
                code="button.delete"/></a></auth:button> --%>
        <auth:button code="CX_PRODUCTIONPLAN_DAILYPLAN_SAVE"><a class="easyui-linkbutton btn-blue"
                                                                data-options="iconCls:'icon-save'"
                                                                onclick="save()"><spring:message
                code="button.save"/></a></auth:button>
        <auth:button code="CX_PRODUCTIONPLAN_DAILYPLAN_CANCEL"><a class="easyui-linkbutton btn-yellow"
                                                                  data-options="iconCls:'icon-no'"
                                                                  onclick="cancel()"><spring:message
                code="button.cancel"/></a></auth:button>
    </div>
    <table id="cxproductiondayplan_dg" class="easyui-datagrid" style="width:100%"
           data-options="
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#CxProductionDayPlan_dg_toolbar',
                url: '',
                striped:true,
                method: 'get'
                ">
        <thead>
        <tr>
            <th data-options="required:true,field:'atr_key',checkbox:true"></th>
            <!-- 计划生产日期 -->
            <th data-options="required:true,field:'production_date_s',width:100,editor:{type:'textbox',options:{required:true,editable:false,icons:[]}}">
                <spring:message code="cxproductiondayplan.column.production_date_s"/></th>
            <!-- 日计划号 -->
            <th data-options="required:true,field:'plan_no_s',width:150,editor:{type:'textbox',options:{editable:false,icons:[]}}">
                <spring:message code="cxproductiondayplan.column.plan_no_s"/></th>
            <!-- 计划状态 -->
            <th data-options="required:true,formatter:codeFormatter,field:'status_s',width:100,editor:{type:'combobox',options:{url:'dict/code/152',disabled:true,valueField:'code'}}">
                <spring:message code="cxproductiondayplan.column.status_s"/></th>
            <!-- 设备条码 -->
            <th data-options="field:'equip_code_s',width:90,editor:{type:'combobox',
                    options:{panelHeight:200,
                     onSelect:onEquipcodeSelect,
                    required:true,icons:[],editable:true,data:jtxx}}"><spring:message
                    code="productiondayplan.column.equip_code_s"/></th>
            <!-- 日计划顺序 -->
            <th data-options="required:true,field:'plan_queue_i',editor:{type:'textbox',options:{
					    required:true,
					     editable:true
					    }}"><spring:message code="cxproductiondayplan.column.plan_queue_i"/></th>
            <!-- 胎胚代码 -->
            <th data-options="width:130,field:'specification_s',editor:{
					        type:'combobox',
					       options:{
					       delay:300,panelWidth:120,
					       required:true,
					       panelHeight:150,
					       editable:true,
					       data:materialCodeList,
					       valueField:'OLDMATCODE_S',
					       textField:'OLDMATCODE_S',
					       selectOnNavigation:false,
					       limitToList:true,
					       onSelect:onSpecificationSelect
					       }}"><spring:message code="cxproductiondayplan.column.specification_s"/></th>
            <!-- 胎胚物料编码 -->
            <th data-options="required:true,field:'material_code_s',width:130,editor:{
					       type:'combobox',
					       options:{
					       delay:300,panelWidth:120,
					       required:true,
					       panelHeight:150,
					       editable:true,
					        delay:300,panelWidth:120,
					       valueField:'PART_NUMBER',
					       textField:'PART_NUMBER',
					       selectOnNavigation:false,
					        data:materialCodeList,
					       limitToList:true,
					       onSelect:onMaterialSelect}}"><spring:message
                    code="cxproductiondayplan.column.material_code_s"/></th>
            <!-- 胎胚物料名称 -->
            <th data-options="required:true,field:'material_desc_s',width:200,editor:{type:'textbox',
					    options:{
					    required:true,
					     editable:false
					    }}"><spring:message code="cxproductiondayplan.column.material_desc_s"/></th>
            <!-- 产品阶段 -->
            <th data-options="required:true,formatter:codeFormatter,field:'production_step_s',width:100,
                               editor:{
                               type:'combobox',
                               options:{panelWidth:70,
                               method:'get',
                               required:true,
                               valueField:'ERPCODE_S',
					           textField:'DICTNAME_S',
					           onSelect:onProStepSlect,
					           onShowPanel:onShowProductionStep
                               }}"><spring:message
                    code="cxproductiondayplan.column.production_step_s"/></th>
            <!-- 成本收集器版本 -->
            <th data-options="field:'productionver_s',width:100,editor:{type:'combobox', options:{
					     required:true,
					     type:'combobox',
					     panelWidth:70,
                         method:'get',
					     valueField:'PRODUCTION_VER_S',
					     textField:'PRODUCTION_VER_S',
					     editable:false,
					     onShowPanel:showProductionverPanelList
					    }}"><spring:message code="cxproductiondayplan.column.productionver_s"/></th>
            <!-- 胎胚版本号 -->
            <th data-options="required:true,field:'version_s',width:120,editor:{
					       type:'combobox',
					       options:{
					       delay:300,
					       panelWidth:80,
					       required:true,
					       panelHeight:150,
					       editable:true,
					       valueField:'BOM_REVISION',
					       textField:'BOM_REVISION',
					       selectOnNavigation:false,
					       onSelect:onVersionSlect,
					       onShowPanel:showVersionPanelList,
					       limitToList:true}}"><spring:message code="cxproductiondayplan.column.version_s"/></th>
            <!-- 中班计划量 -->
            <th data-options="required:true,field:'planamount_mid_i',width:80,editor:{type:'numberspinner',options:{min:1,max:8888888,onChange:onCountChange,icons:[]}}">
                <spring:message code="cxproductiondayplan.column.planamount_mid_i"/></th>
            <!-- 晚班计划量 -->
            <th data-options="required:true,field:'planamount_nig_i',width:80,editor:{type:'numberspinner',options:{min:1,max:8888888,onChange:onCountChange,icons:[]}}">
                <spring:message code="cxproductiondayplan.column.planamount_nig_i"/></th>
            <!-- 早班计划量 -->
            <th data-options="required:true,field:'planamount_mor_i',width:80,editor:{type:'numberspinner',options:{min:1,max:8888888,onChange:onCountChange,icons:[]}}">
                <spring:message code="cxproductiondayplan.column.planamount_mor_i"/></th>
            <!-- 日计划量 -->
            <th data-options="required:true,field:'quantity_dayplan_i',width:80,editor:{type:'numberspinner',options:{min:1,max:8888888,editable:false,required:true,icons:[]}}">
                <spring:message code="cxproductiondayplan.column.quantity_dayplan_i"/></th>
            <!-- 月计划号 -->
            <th data-options="required:true,field:'planno_month_s',width:180,editor:{type:'combobox',options:{
					        panelHeight:200,
                    		required:true,
                    		editable:true,
                    		valueField:'PLANNO_MONTH_S',
					        textField:'PLANNO_MONTH_S'
					    }}"><spring:message code="cxproductiondayplan.column.planno_month_s"/></th>
            <!-- 工单号 -->
            <th data-options="required:true,field:'order_number_s',width:160,editor:{type:'textbox',options:{
					    required:true,
					    disabled:true
					    }}"><spring:message code="cxproductiondayplan.column.order_number_s"/></th>
            <!-- 客户标识 -->
            <th data-options="field:'customer_flag_s',formatter:codeFormatter,width:100,editor:{type:'combobox',options:
                                {
                                type:'combobox',
                                method:'get',
                                data:DICT_328,
                                valueField:'DICTCODE_S',
					            textField:'DICTNAME_S',
                                required:true}}"><spring:message
                    code="cxproductiondayplan.column.customer_flag_s"/></th>
            <!-- 工艺配方工艺ID成型 -->
            <th data-options="required:true,field:'processbom_index_s',width:240,editor:{type:'textbox',options:{
					    required:true,
					     editable:false
					    }}"><spring:message code="cxproductiondayplan.column.processbom_index_s"/></th>
            <!-- 备注 -->
            <th data-options="field:'spare1_s',width:120,editor:{type:'textbox',options:{
					    required:true,
					    disabled:true}}"><spring:message code="cxproductiondayplan.column.spare1_s"/></th>
            <!-- 审核人 -->
            <th data-options="field:'auditbyname',width:80"><spring:message
                    code="cxproductiondayplan.column.audit_by_s"/></th>
            <!-- 审核时间 -->
            <th data-options="field:'audit_time_t',width:120"><spring:message
                    code="cxproductiondayplan.column.audit_time_t"/></th>
            <!-- 创建人 -->
            <th data-options="required:true,field:'createdname',width:80"><spring:message
                    code="cxproductiondayplan.column.created_by_s"/></th>
            <!-- 创建时间 -->
            <th data-options="required:true,field:'created_time_t',width:80"><spring:message
                    code="cxproductiondayplan.column.created_time_t"/></th>
        </tr>
        </thead>
    </table>
</div>
<script type="text/javascript">
</script>
<div id="partBomSearch_dlg" class="easyui-dialog" title="半部件bom查询窗口"
     style="width:80%;height:70%;"
     data-options="
				                resizable:true,
				    			modal:true,
				                iconCls:'icon-window',
				                closed:true,
				                onOpen:loadPartBomDlgOnOpen,
				                buttons: [{
				                    text:'保存',
				                     iconCls:'icon-save',
				                    handler:function(){
				                        savePartBomDlg();
				                    }
				                },{
				                    text:'关闭',
				                     iconCls:'icon-cancel',
				                    handler:function(){
				                        closePartBomDlg();
				                    }
				                }]
				                ">

    <div id="BillOfMaterial_dg_toolbar">
        <form id="BillOfMaterial_search_form" class="form" >
            <!-- BOM名称-->
            <input name="filter[bom_name]" id="bom_name" type="hidden" />
            <!-- BOM版本 -->
            <input name="filter[bom_revision]" id="bom_revision" type="hidden"  />
            <input name="filter[bomflag_i]" id="bomflag_i" type="hidden" value = "2"/>
            <input name="filter[prophase]" id="prophase" type="hidden"/>
        </form>
    </div>
    <table id="billofmaterial_dg" class="easyui-treegrid" style="width:100%"
           data-options="
               fit:true,
                toolbar: '#BillOfMaterial_dg_toolbar',
       			pagination:true,
                striped:true,
                method: 'get',
                rownumbers: false,
       			animate: true,
        		fitColumns: false,
        		onBeforeExpand: myLoad,
                idField: 'ids',
                treeField: 'bom_name',
                onBeforeLoad: function(row,param){
					if (!row) {
						param.id = 0;
					}
				}
                ">
        <thead>
        <tr>
            <th data-options="field:'bom_key'">序号</th>
            <!-- 物料编号 -->
            <th data-options="field:'bom_name',formatter:noneFormatter,width:210,editor:{type:'textbox'}"><spring:message code="billofmaterial.column.bom_name" /></th>
            <!-- 物料版本 -->
            <th data-options="field:'bom_revision',width:80,editor:{type:'textbox'}"><spring:message code="billofmaterial.column.bom_revision" /></th>
            <!--子物料 -->
            <th data-options="field:'part_number',width:110,editor:{type:'textbox'}"><spring:message code="billofmaterial.column.partnumber" /></th>
            <!--子物料 版本-->
            <th data-options="field:'part_revision',width:80,editor:{type:'textbox'}"><spring:message code="billofmaterial.column.partrevision" /></th>
            <!--物料描述-->
            <th data-options="field:'description',width:120,editor:{type:'textbox'}"><spring:message code="billofmaterial.column.description" /></th>
            <!-- 数量 -->
            <th data-options="field:'basenum_s',width:80,editor:{type:'textbox'}"><spring:message code="billofmaterial.column.basenum" /></th>
            <!-- 创建时间 -->
            <th data-options="field:'createddate_s',width:80,editor:{type:'textbox'}"><spring:message code="billofmaterial.column.createddate" /></th>
            <!-- 失效时间，首次为空值，试制不为空 -->
            <th data-options="field:'expireddate_s',width:80,editor:{type:'textbox'}"><spring:message code="billofmaterial.column.exipreddate" /></th>
            <!-- 层级：半钢-胎体(1|2|3)，全钢、半钢：带束层(1|2|3|4) -->
            <th data-options="field:'layer_number_s',width:80,editor:{type:'textbox'}"><spring:message code="billofmaterial.column.layer_number" /></th>
            <!-- 子件用量 -->
            <th data-options="field:'quantity',width:80,editor:{type:'textbox'}"><spring:message code="billofmaterial.column.makeuse" /></th>
            <!-- 子件单位 -->
            <th data-options="field:'unit_of_measure',width:80,editor:{type:'textbox'}"><spring:message code="billofmaterial.column.unit" /></th>
            <!-- 创建人 -->
            <th data-options="field:'createuser_s',width:80,editor:{type:'textbox'}"><spring:message code="billofmaterial.column.createuser" /></th>
            <!-- 修改人 -->
            <th data-options="field:'modifier_s',width:80,editor:{type:'textbox'}"><spring:message code="billofmaterial.column.modifier" /></th>
            <!-- 接收时间 -->
            <th data-options="field:'receive_time_t',width:80,editor:{type:'textbox'}"><spring:message code="billofmaterial.column.receive_time" /></th>
            <!-- 空值，终炼胶类型 -->
            <th data-options="field:'recipetype_s',width:80,editor:{type:'textbox'}"><spring:message code="billofmaterial.column.recipetype" /></th>
            <!-- 父项SAP物料号 -->
            <th data-options="field:'mastersap_temp_s',width:80,editor:{type:'textbox'}"><spring:message code="billofmaterial.column.mastersap_temp" /></th>
            <!-- 工厂 柳州 8003 -->
            <th data-options="field:'werks_s',width:80,editor:{type:'textbox'}"><spring:message code="billofmaterial.column.werks" /></th>
            <!-- 所属产品阶段 试制 01 试产 02 投产03 -->
            <th data-options="field:'prophase_s',formatter:codeFormatter,width:80,editor:{type:'textbox'}"><spring:message code="billofmaterial.column.prophase" /></th>
            <!-- BOM替代号 -->
            <th data-options="field:'replacebom_s',width:80,editor:{type:'textbox'}"><spring:message code="billofmaterial.column.replacebom" /></th>
            <!-- 物料类型 PCR TBR -->
            <th data-options="field:'materialtype_s',width:80,editor:{type:'textbox'}"><spring:message code="billofmaterial.column.materialtype" /></th>
            <!-- BOM类型：外胎MBOM(CoverTireMBOM)胎胚MBOM(GreenTireMBOM)半部件MBOM(SemiPartMBOM) -->
            <th data-options="field:'bommold_s',formatter:codeFormatter,width:80,editor:{type:'textbox'}"><spring:message code="billofmaterial.column.bommold" /></th>
            <!-- 分厂 半钢 G1 全钢 G3 胎胚一次法 G1 胎胚二次法 G3 -->
            <th data-options="field:'factory_s',width:80,editor:{type:'textbox'}"><spring:message code="billofmaterial.column.factory" /></th>
        </tr>
        </thead>
    </table>
</div>
</body>
</html>
