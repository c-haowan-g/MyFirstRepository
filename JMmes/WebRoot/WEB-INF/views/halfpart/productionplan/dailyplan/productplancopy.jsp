<!-- 

    作者      :李新宇
    时间      :2019-04-04 14:49:13 
    页面名称:半部件日计划
    文件关联:
        ProductPlan.java
        ProductPlanController.java
        ProductPlanServiceImpl.java
        ProductPlanServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="productplancopy.js.jsp"%>
<script type="text/javascript" src="dict/104,118,328.js"></script>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="ProductPlan_dg_toolbar">
            <form id="ProductPlan_search_form" class="form" >
                <!-- 原计划生产日期productplan.column.plandate_s -->
                <spring:message code="原计划日期" />
                :&emsp;<input name="filter[plandate_s]" id="plandate_s" type="text" class="easyui-datebox" 
                              data-options="label:'',
                                            onChange:filter,
                                            formatter:dateFormat,
                                            parser:dateParser,
                                            editable:false,
                                            required:false,
                                            onSelect:planExistJudgeBeforeCopyOldData">
                		 <script type="text/javascript">
                               $("#plandate_s").val(new Calendar().format("yyyyMMdd"));
                         </script>
	       
            <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <!-- 新计划生产日期 productplan.column.plandate_s-->
            &nbsp;<spring:message code="新计划日期" />
            :&emsp;<input name="filter[plandate_to_s]" id="plandate_to_s" type="text" class="easyui-datebox" 
                          data-options="label:'',
                                        formatter:dateFormat,
                                        parser:dateParser,
                                        editable:false,
                                        required:false,
                                        onSelect:planExistJudgeBeforeCopy">
            <script type="text/javascript">
                  $("#plandate_to_s").val(new Calendar().format("yyyyMMdd"));
            </script>
       		<auth:button code="PRODUCTPLAN_ONECLICKCOPY"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-copy'" onclick="oneClickCopy()"><spring:message code="button.oneclickcopy" /></a></auth:button>
            <auth:button code="PRODUCTPLAN_COPY"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-copy'" onclick="copyDayplan()"><spring:message code="button.copy" /></a></auth:button>
            <auth:button code="PRODUCTPLAN_EDIT"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="PRODUCTPLAN_REMOVE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            <auth:button code="PRODUCTPLAN_SAVE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="editSave()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="PRODUCTPLAN_CANCEL"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-cancel'" onclick="cancel()"><spring:message code="button.cancel" /></a></auth:button>
        </div>
        <table id="productplan_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
			                fit:true, 
			                fitColumns:false,
			                pagination:true,
			                pageSize:15,
						    pageList:[15,200,300,500,1000,2000],
			                rownumbers: true,
			                singleSelect: false,
			                toolbar: '#ProductPlan_dg_toolbar',
			                url: 'halfpart/productionplan/dailyplan/getPlanInfoList',
			                striped:true,
			                onBeforeLoad:onDgBeforeLoad,
			                method:'get'">
           <thead data-options="frozen:true">
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <th data-options="field:'morn_atr_key',hidden:true,editor:{type:'textbox'}"></th>
                    <th data-options="field:'noon_atr_key',hidden:true,editor:{type:'textbox'}"></th>
                    <th data-options="field:'even_atr_key',hidden:true,editor:{type:'textbox'}"></th>
                    <!-- 机台编码 -->
                    <th align="center" data-options="field:'equip_code_s',width:85,sortable:true,styler:centerSetting, editor:{type:'textbox',options:{ 
										  disabled:true,
										  valueField:'P_LINE_NAME',
                              			  textField:'P_LINE_NAME'}}"><spring:message code="productplan.column.equip_code_s" /></th>
                    <!-- 机台名称 -->
                    <th align="center" data-options="field:'spare1_s',width:150,sortable:true,styler:centerSetting,editor:{type:'textbox',options:{ 
										  disabled:true,
										  valueField:'DESCRIPTION',
                              			  textField:'DESCRIPTION'}}"><spring:message code="productplan.column.spare1_s" /></th>
                    </tr>
               </thead> 
               <thead>
                    <tr>     
                    <!-- 中班计划号 -->
                    <th align="center" data-options="field:'noon_planno_s',width:133,sortable:true,hidden:false,styler:centerSetting,editor:{type:'textbox',options:{
                                          disabled:true
                                          }}"><spring:message code="productplan.column.noon_planno_s" /></th>
                    <!-- 晚班计划号 -->
                    <th align="center" data-options="field:'even_planno_s',width:133,sortable:true,hidden:false,styler:centerSetting,editor:{type:'textbox',options:{
                                          disabled:true
                                          }}"><spring:message code="productplan.column.even_planno_s" /></th>
                    <!-- 早班计划号 -->
                    <th align="center" data-options="field:'morn_planno_s',width:133,sortable:true,hidden:false,styler:centerSetting,editor:{type:'textbox',options:{
                                          disabled:true
                                          }}"><spring:message code="productplan.column.morn_planno_s" /></th>
                    <!-- 计划生产日期 -->
                    <th align="center" data-options="field:'plandate_s',width:91,sortable:true,styler:centerSetting,editor:{type:'textbox',options:{
                                          disabled:true
                                          }}"><spring:message code="productplan.column.plandate_s" /></th>
                    <!-- 中班执行顺序 -->
                    <th align="center" data-options="field:'noon_plan_order_i',sortable:true,styler:centerSetting,editor:{type:'textbox',options:{
                                          required:true,
                                          editable:true,
                                          }}"><spring:message code="productplan.column.noon_plan_order_i" /></th>
                    <!-- 晚班执行顺序 -->
                    <th align="center" data-options="field:'even_plan_order_i',sortable:true,styler:centerSetting,editor:{type:'textbox',options:{
                                          required:true,
                                          editable:true,
                                          }}"><spring:message code="productplan.column.even_plan_order_i" /></th>
                    <!-- 早班执行顺序 -->
                    <th align="center" data-options="field:'morn_plan_order_i',sortable:true,styler:centerSetting,editor:{type:'textbox',options:{
                                          required:true,
                                          editable:true,
                                          }}"><spring:message code="productplan.column.morn_plan_order_i" /></th>
                    <!-- 中班计划状态：基础数据104 -->
                    <th align="center" data-options="field:'noon_status_s',width:100,styler:planStatusColorSetting,formatter:planStatusFormatter,sortable:true,editor:{type:'textbox',options:{
						  required:false,
						  editable:false,
						  disabled:true
                                      }}"><spring:message code="productplan.column.noonstatus_s" /></th>
                    <!-- 晚班计划状态：基础数据104 -->
                    <th align="center" data-options="field:'even_status_s',width:100,styler:planStatusColorSetting,formatter:planStatusFormatter,sortable:true,editor:{type:'textbox',options:{
						  required:false,
						  editable:false,
						  disabled:true
                                      }}"><spring:message code="productplan.column.evenstatus_s" /></th>
                    <!-- 早班计划状态：基础数据104 -->
                    <th align="center" data-options="field:'morn_status_s',width:100,styler:planStatusColorSetting,formatter:planStatusFormatter,sortable:true,editor:{type:'combotree',options:{
						  required:false,
						  editable:false,
						  disabled:true
                                      }}"><spring:message code="productplan.column.mornstatus_s" /></th>                      
                    <!-- 物料规格 -->
                    <th align="center" data-options="field:'specification_s',width:110,sortable:true,styler:centerSetting,editor:{type:'combobox',options:{ 
										  labelWidth:'auto',
                                          panelHeight:200,
										  required:true,
										  editable:true,
										  disabled:false,
										  data:materialList,
					                      valueField:'OLDMATCODE_S',
					                      textField:'OLDMATCODE_S',
					                      onSelect:onSetMatDescCodeGroup
					                      }}"><spring:message code="productplan.column.specification_s" /></th>
					                      
					<!-- 物料编码 -->
                    <th align="center" data-options="field:'materialcode_s',width:130,sortable:true,styler:centerSetting,editor:{type:'combobox',options:{ 
										  labelWidth:'auto',
                                          panelHeight:200,
										  required:true,
										  editable:true,
										  disabled:false,
										  data:materialList,
					                      valueField:'MATERIALCODE_S',
					                      textField:'MATERIALCODE_S',
					                      onSelect:onSetMatDescSpecGroup
					                      }}"><spring:message code="productplan.column.materialcode_s" /></th>                     
					                      
                    <!-- 物料名称 -->
                    <th align="center" data-options="field:'materialname_s',width:190,sortable:true,hidden:true,styler:centerSetting, editor:{type:'textbox',options:{ 
                                          labelWidth:'auto',
                                          panelHeight:200,
										  required:true,
										  editable:true,
					                      valueField:'MATERIALDESC_S',
					                      textField:'MATERIALDESC_S'
					                      }}"><spring:message code="productplan.column.materialname_s" /></th>
                    
                    <!-- 物料名称(备用字段) -->
                    <th align="center" data-options="field:'spare9_s',width:130,sortable:true,hidden:false,styler:centerSetting, editor:{type:'textbox',options:{ 
                                          labelWidth:'auto',
                                          panelHeight:200,
										  required:true,
										  editable:true,
					                      valueField:'MATERIALDESC_S',
					                      textField:'MATERIALDESC_S'
					                      }}"><spring:message code="productplan.column.materialname_s" /></th>
                    
					<!-- 物料组 -->
                    <th align="center" data-options="field:'materialgroup_s',width:80, styler:centerSetting,hidden:true,sortable:true,editor:{type:'textbox',options:{}}"><spring:message code="productplan.column.materialgroup_s" /></th>
                    <!-- 物料组名称 -->
                    <th align="center" data-options="field:'materialdesc_s',width:150,sortable:true,editor:{type:'textbox',options:{}}"><spring:message code="productplan.column.materialdesc_s" /></th>
					<!-- SAP下发版本号 -->
                    <th align="center" data-options="field:'sapversion_s',width:100,sortable:true,styler:centerSetting,editor:{type:'combobox',options:{ 
										  required:true,
										  editable:false,
										  valueField:'PRODUCTION_VER_S',
                              			  textField:'PRODUCTION_VER_S'}}"><spring:message code="productplan.column.sapversion_s" /></th>
                    <!-- 产品阶段 -->
                    <th align="center" data-options="field:'productstage_s',width:80,sortable:true,formatter:productStageFormatter,styler:centerSetting,editor:{type:'combobox',options:{ 
										  required:true,
										  editable:false,
										  disabled:false,
					                      data:[{text:'试制',value:'01'},
					                            {text:'试产',value:'02'},
					                            {text:'投产',value:'03'}],
					                      textField:'text',
					                      valueField:'value',
					                      onChange:checkAndLoadData
					                      }}"><spring:message code="productplan.column.productstage_s" /></th>

                    <!-- 中班计划量 -->
                    <th align="center" data-options="field:'noon_planquantityconfirm_f',sortable:true,styler:centerSetting,editor:{type:'numberspinner',options:{min:0,max:10000}}"><spring:message code="noon_productionplan.column.planquantityconfirm_f" /></th>
                    <!-- 晚班计划量 -->
                    <th align="center" data-options="field:'even_planquantityconfirm_f',sortable:true,styler:centerSetting,editor:{type:'numberspinner',options:{min:0,max:10000}}"><spring:message code="even_productionplan.column.planquantityconfirm_f" /></th>
                    <!-- 早班计划量 -->
                    <th align="center" data-options="field:'morn_planquantityconfirm_f',sortable:true,styler:centerSetting,editor:{type:'numberspinner',options:{min:0,max:10000}}"><spring:message code="morn_productionplan.column.planquantityconfirm_f" /></th>
                    <!-- 总计划量 -->
                    <th align="center" data-options="field:'total_planquantityconfirm_f',sortable:true,styler:centerSetting,editor:{type:'numberspinner',options:{disabled:true}}"><spring:message code="total_productionplan.column.planquantityconfirm_f" /></th>
                    <!-- 工艺版本号 -->
                    <th align="center" data-options="field:'paraversion_s',width:130,sortable:true,styler:centerSetting,editor:{type:'combobox',options:{ 
										  required:true,
										  editable:true,
										  valueField:'PROCESSVERSION_S',
					                      textField:'PROCESSVERSION_S'
										  }}"><spring:message code="productplan.column.paraversion_s" /></th>
                    <!-- 工艺版本ID -->
                    <th align="center" data-options="field:'parameterid_s',width:130,sortable:true, editor:{type:'combobox',options:{ 
										  editable:true,
										  valueField:'PARAMETERID_S',
					                      textField:'PARAMETERID_S'
										  }}"><spring:message code="productplan.column.parameterid_s" /></th>
                    
                    <!-- 配方版本(BOM) -->
                    <th align="center" data-options="field:'repiceno_s',sortable:true,styler:centerSetting,editor:{type:'combobox',options:{ 
										  required:true,
										  editable:true,
										  valueField:'VERSION_S',
					                      textField:'VERSION_S'
										  }}"><spring:message code="productplan.column.repiceno_s" /></th>
                    <!-- 客户标识  设置基础数据字典 328 -->
                    <th align="center" data-options="field:'customerflag_s',width:100,formatter:codeFormatter,sortable:true,styler:centerSetting,editor:{type:'combotree',options:{
                                          labelWidth:'auto',
                                          panelHeight:200,
										  required:true,
										  editable:false,
										  url:'dict/code/328'}}"><spring:message code="productplan.column.customerflag_s" /></th>
                    <!-- 是否自动 0否 1 是 -->
                    <th align="center" data-options="field:'handflag_s',formatter:autoJudgeFormatter,sortable:true,styler:centerSetting,editor:{type:'texbox',options:{
										  required:true,
										  editable:false,
                                          disabled:true}}"><spring:message code="productplan.column.handflag_s" /></th>
                    <!-- 计划量超产百分比  -->
                    <th align="center" data-options="field:'overpercent_f',sortable:true,editor:{type:'textbox',options:{}}"><spring:message code="productplan.column.overpercent_f" /></th>
                    <!-- 修改人 -->
                    <th align="center" data-options="field:'changed_by_s',width:60,sortable:true,styler:centerSetting,editor:{type:'textbox',options:{
                                          disabled:true
                                          }}"><spring:message code="productplan.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th align="center" data-options="field:'changed_time_t',width:120,sortable:true,styler:centerSetting,editor:{type:'textbox',options:{
                                          disabled:true
                                          }}"><spring:message code="productplan.column.changed_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
</body>
</html>
