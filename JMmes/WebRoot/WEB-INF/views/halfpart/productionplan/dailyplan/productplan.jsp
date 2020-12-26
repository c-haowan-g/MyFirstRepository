<!-- 

    作者      :时永良
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
<%@ include file="productplan.js.jsp"%>
<script type="text/javascript" src="dict/104,-118,328.js"></script>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="ProductPlan_dg_toolbar">
            <form id="ProductPlan_search_form" class="form" >
                <!-- 计划生产日期 -->
                <spring:message code="productplan.column.plandate_s" />
                :&emsp;<input name="filter[plandate_s]" id="plandate_s" type="text" class="easyui-datebox" 
                              data-options="label:'',
                                            onChange:filter,
                                            formatter:dateFormat,
                                            parser:dateParser,
                                            editable:false,
                                            required:true">
                		 <script type="text/javascript">
                               $("#plandate_s").val(new Calendar().format("yyyyMMdd"));
                         </script>
                <!-- 机台名称 -->
                 &emsp;<spring:message code="productplan.column.spare1_s" />
                :&emsp;<input name="filter[equip_code_s]" id="equip_code_s" type="text" class="easyui-combobox" 
                              data-options="label:'',
                                            labelWidth:'auto',
                                            panelHeight:200,
                                            editable:true,
                                            required:false,
                                            data:productLineList,
                                            valueField:'P_LINE_NAME',
                              			    textField:'DESCRIPTION',
                                            method:'get'">
                 <!-- 物料组 -->
                 &emsp;<spring:message code="productplan.column.materialgroup_s" />
                :&emsp;&emsp;<input name="filter[materialgroup_s]" id="materialgroup_s" type="text" class="easyui-combobox" 
                              data-options="label:'',
                                            labelWidth:'auto',
                                            panelHeight:200,
                                            editable:true,
                                            required:false,
                                            data:materialGroupList,
                                            valueField:'DICTCODE_S',
                              			    textField:'DICTNAME_S',
                                            method:'get' " ><br>
                 <!-- 成型计划日期 -->
                <%-- <spring:message code="productplan.column.buildingdate" />
                :&emsp;<input id="buildingDate" type="text" class="easyui-datebox"
                           data-options="label:'',
                                         formatter:dateFormat,
                                         parser:dateParser,
                                         editable:false" >&emsp;
                    <script type="text/javascript">
                            $("#buildingDate").val(new Calendar().format("yyyyMMdd"));
                    </script> --%>
                 <!-- 物料编码 -->
                 <spring:message code="productplan.column.materialcode_s" />
                :&emsp;<input name="filter[materialcode_s]" id="materialcode_s" type="text" class="easyui-combobox" 
                              data-options="label:'',
                                            labelWidth:'auto',
                                            panelHeight:200,
                                            editable:true,
                                            required:false,
                                            data:materialList,
                                            valueField:'MATERIALCODE_S',
                              			    textField:'MATERIALCODE_S',
                                            method:'get' " >
                 <!-- 物料规格 -->
                 &emsp;<spring:message code="productplan.column.specification_s" />
                :&emsp;<input name="filter[specification_s]" id="specification_s" type="text" class="easyui-combobox" 
                              data-options="label:'',
                                            labelWidth:'auto',
                                            panelHeight:200,
                                            editable:true,
                                            required:false,
                                            data:materialList,
                                            valueField:'OLDMATCODE_S',
                              			    textField:'OLDMATCODE_S',
                                            method:'get' " >&emsp;                                   
                 <a id="searchId" class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="PRODUCTPLAN_ADD"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="PRODUCTPLAN_EDIT"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="PRODUCTPLAN_REMOVE"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            　
            <auth:button code="PRODUCTPLAN_SAVE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="PRODUCTPLAN_CANCEL"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            　
            <auth:button code="PRODUCTPLAN_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            <auth:button code="PRODUCTPLAN_AUDIT"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-shenhe'" onclick="audit()"><spring:message code="button.audit" /></a></auth:button>
            <auth:button code="PRODUCTPLAN_AUDITCANCEL"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-fanshenhe'" onclick="auditCancel()"><spring:message code="button.cancelAudit" /></a></auth:button>
            <auth:button code="PRODUCTPLAN_CLOSE"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-power'" onclick="planClose()"><spring:message code="button.close" /></a></auth:button>
            <auth:button code="PRODUCTPLAN_COPY"><a class="easyui-linkbutton btn-deep-blue"data-options="iconCls:'icon-copy'" onclick="copy()"><spring:message code="button.copy" /></a></auth:button> 
            <auth:button code="PRODUCTPLAN_ONECLICKAUDIT"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-copy'" onclick="oneClickAudit()"><spring:message code="button.oneclickaudit" /></a></auth:button>     
            <auth:button code="PRODUCTPLAN_ONECLICKUNAUDIT"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-copy'" onclick="oneClickCancelAudit()"><spring:message code="button.oneclickcancelaudit" /></a></auth:button>
        </div>
        <div id='loading' style="display:none;text-align:center">
			<font color="#000000">计划倒推进行中,请耐心等待···</font>
		</div>
        <table id="productplan_dg" class="easyui-datagrid" style="width:100%"
            data-options="  fit:true, 
			                fitColumns:false,
			                pagination:true,
			                rownumbers: true,
			                singleSelect: false,
			                toolbar: '#ProductPlan_dg_toolbar',
			                url: 'halfpart/productionplan/dailyplan/getPlanInfoList',
			                striped:true,
			                method:'get',
			                onBeforeLoad:onDgBeforeLoad,">
            <thead data-options="frozen:true">
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <th data-options="field:'morn_atr_key',hidden:true,editor:{type:'textbox'}"></th>
                    <th data-options="field:'noon_atr_key',hidden:true,editor:{type:'textbox'}"></th>
                    <th data-options="field:'even_atr_key',hidden:true,editor:{type:'textbox'}"></th>
                    <!-- 计划生产日期 -->
                    <th align="center" data-options="field:'plandate_s',width:91,sortable:true,styler:centerSetting,editor:{type:'textbox',options:{
                                          disabled:true
                                          }}"><spring:message code="productplan.column.plandate_s" /></th>
                    </tr>
               </thead> 
               <thead>
                    <tr>     
                    <!-- 机台编码 -->
                    <th align="center" data-options="field:'equip_code_s',width:85,sortable:true,hidden:true,styler:centerSetting, editor:{type:'textbox',options:{ 
										  disabled:true,
										  valueField:'P_LINE_NAME',
                              			  textField:'P_LINE_NAME'}}"><spring:message code="productplan.column.equip_code_s" /></th>
                    <!-- 机台名称 -->
                    <th align="center" data-options="field:'spare1_s',width:150,sortable:true,styler:centerSetting,editor:{type:'textbox',options:{ 
										  disabled:true,
										  valueField:'DESCRIPTION',
                              			  textField:'DESCRIPTION'}}"><spring:message code="productplan.column.spare1_s" /></th>
                    <!-- 物料规格 -->
                    <th align="center" data-options="field:'specification_s',width:130,sortable:true,styler:centerSetting,editor:{type:'combobox',options:{ 
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
					<!-- 物料名称(备用字段) -->
                    <th align="center" data-options="field:'spare9_s',width:130,sortable:true,hidden:false,styler:centerSetting, editor:{type:'textbox',options:{ 
                                          labelWidth:'auto',
                                          panelHeight:200,
										  required:true,
										  editable:true,
					                      valueField:'MATERIALDESC_S',
					                      textField:'MATERIALDESC_S'
					                      }}"><spring:message code="productplan.column.materialname_s" /></th>
					<!-- 物料名称 -->
                    <th align="center" data-options="field:'materialname_s',width:190,sortable:true,hidden:true,styler:centerSetting, editor:{type:'textbox',options:{ 
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
                    <!-- 产品阶段 -->
                    <th align="center" data-options="field:'productstage_s',width:100,sortable:true,formatter:productStageFormatter,styler:centerSetting,editor:{type:'combobox',options:{ 
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
                    <th align="center" data-options="field:'noon_planquantityconfirm_f',sortable:true,styler:centerSetting,editor:{type:'numberbox',options:{precision:0,min:0,max:1000000}}"><spring:message code="noon_productionplan.column.planquantityconfirm_f" /></th>
                    <!-- 晚班计划量 -->
                    <th align="center" data-options="field:'even_planquantityconfirm_f',sortable:true,styler:centerSetting,editor:{type:'numberbox',options:{precision:0,min:0,max:1000000}}"><spring:message code="even_productionplan.column.planquantityconfirm_f" /></th>
                    <!-- 早班计划量 -->
                    <th align="center" data-options="field:'morn_planquantityconfirm_f',sortable:true,styler:centerSetting,editor:{type:'numberbox',options:{precision:0,min:0,max:1000000}}"><spring:message code="morn_productionplan.column.planquantityconfirm_f" /></th>
                    <!-- 总计划量 -->
                    <th align="center" data-options="field:'total_planquantityconfirm_f',sortable:true,styler:centerSetting,editor:{type:'numberbox',options:{disabled:true}}"><spring:message code="total_productionplan.column.planquantityconfirm_f" /></th>
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
                                        <!-- 计划状态：基础数据104 -->
                    <th align="center" data-options="field:'status_s',width:100,styler:planStatusColorSetting,hidden:true,formatter:planStatusFormatter,sortable:true,editor:{type:'textbox',options:{
										  required:true,
										  editable:false,
										  disabled:true
                                          }}"><spring:message code="productplan.column.status_s" /></th>
                    <!-- SAP下发版本号 -->
                    <th align="center" data-options="field:'sapversion_s',width:100,sortable:true,styler:centerSetting,editor:{type:'combobox',options:{ 
										  required:true,
										  editable:false,
										  valueField:'PRODUCTION_VER_S',
                              			  textField:'PRODUCTION_VER_S'}}"><spring:message code="productplan.column.sapversion_s" /></th>
                    <!-- 工艺版本号 -->
                    <th align="center" data-options="field:'paraversion_s',width:130,sortable:true,styler:centerSetting,editor:{type:'combobox',options:{ 
										  required:true,
										  editable:true,
										  valueField:'PROCESSVERSION_S',
					                      textField:'PROCESSVERSION_S'
										  }}"><spring:message code="productplan.column.paraversion_s" /></th>
                    <!-- 工艺版本ID -->
                    <th align="center" data-options="field:'parameterid_s',width:130,sortable:true,hidden:true,editor:{type:'combobox',options:{ 
										  required:false,
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
                    <!-- 中班计划号 -->
                    <th align="center" data-options="field:'noon_planno_s',width:133,sortable:true,styler:centerSetting,editor:{type:'textbox',options:{
                                          disabled:true
                                          }}"><spring:message code="productplan.column.noon_planno_s" /></th>
                    <!-- 晚班计划号 -->
                    <th align="center" data-options="field:'even_planno_s',width:133,sortable:true,styler:centerSetting,editor:{type:'textbox',options:{
                                          disabled:true
                                          }}"><spring:message code="productplan.column.even_planno_s" /></th>
                    <!-- 早班计划号 -->
                    <th align="center" data-options="field:'morn_planno_s',width:133,sortable:true,styler:centerSetting,editor:{type:'textbox',options:{
                                          disabled:true
                                          }}"><spring:message code="productplan.column.morn_planno_s" /></th>

                </tr>
             </tr>
            </thead>
        </table>
    </div>
  <!-- 日计划复制 -->  
  <script type="text/javascript">
  </script>
      <div id="productplancopy_dg" title="<spring:message code="button.copy" />" class="easyui-dialog" 
            data-options="
                closed:true,
                width:window.innerWidth,
		        height:window.innerHeight,
                iconCls: 'icon-save',
                maximizable:true,
                buttons: [{
		                    iconCls:'icon-no',
		                    text:'<spring:message code="button.close" />',
		                    handler:function(){
		                       $('#productplancopy_dg').dialog('close');
		                    }
                         }],
                onOpen:function(){
                },
                onClose:reLoadDataGrid
            ">
        <iframe
            id="copyframe"
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
   <!--日计划排序-->
     <div id="ProductPlanResort" class="easyui-dialog" title="<spring:message code="日计划排序" />" width="800px" height="400px"
		  data-options="
		                resizable:true,
		    			modal:true,
		                iconCls:'icon-window',
		                onOpen:resortDataLoad,
		                width:window.innerWidth,
		                height:window.innerHeight,
		                closed:true">
        <div id="ProductPlanResort_dg_toolbar">
            <form id="ProductPlanResort_search_form" class="form" >
              <auth:button code="PRODUCTPLANRESORT_UPPER"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-up'" onclick="upper()"><spring:message code="button.up" /></a></auth:button>
              <auth:button code="PRODUCTPLANRESORT_LOWER"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-down'" onclick="lower()"><spring:message code="button.down" /></a></auth:button>
              <auth:button code="PRODUCTPLANRESORT_SAVE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="sortDataSave()"><spring:message code="button.save" /></a></auth:button>
              <auth:button code="PRODUCTPLANRESORT_CANCEL"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="sortDataCancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            </form> 
        </div>
        <table id="productplanresort_dg" class="easyui-datagrid" style="width:100%"
               data-options="  
			                fit:true, 
			                fitColumns:false,
			                pagination:true,
			                rownumbers: true,
			                singleSelect:true,
			                toolbar: '#ProductPlanResort_dg_toolbar',
			                striped:true,
			                method:'get',
			                ">
            <thead data-options="frozen:true">
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 机台号 -->
                    <th data-options="field:'equip_code_s',width:110,sortable:true"><spring:message code="productplan.column.equip_code_s" /></th>
                    <!-- 日计划号：生成规则 -->
                    <th data-options="field:'planno_s',width:133,sortable:true"><spring:message code="productplan.column.planno_s" /></th>
                    <!-- 计划生产日期 -->
                    <th data-options="field:'plandate_s',width:91,sortable:true"><spring:message code="productplan.column.plandate_s" /></th>
                    <!-- 班次 基础数据字典 118 -->
                    <th data-options="field:'classcode_s',width:87,formatter:classCodeFormatter,sortable:true"><spring:message code="productplan.column.class_s" /></th>
                    <!-- 计划顺序优先级 -->
                    <th data-options="field:'plan_order_i',sortable:true"><spring:message code="productplan.column.plan_order_i" /></th>
                    <!-- 计划状态：基础数据104 -->
                    <th data-options="field:'status_s',width:101,formatter:planStatusFormatter,sortable:true"><spring:message code="productplan.column.status_s" /></th>
                  </thead> 
                  <thead>
                   <tr>
                    <!-- 物料组 -->
                    <th data-options="field:'materialgroup_s',width:170,formatter:materialGroupFormatter,sortable:true"><spring:message code="productplan.column.materialgroup_s" /></th>
                    <!-- 物料组名称 -->
                    <th data-options="field:'materialdesc_s',width:150,sortable:true"><spring:message code="productplan.column.materialdesc_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'materialcode_s',width:125,sortable:true"><spring:message code="productplan.column.materialcode_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'materialname_s',width:150,sortable:true"><spring:message code="productplan.column.materialname_s" /></th>
                    <!-- 产品阶段 -->
                    <th data-options="field:'productstage_s',width:80,sortable:true,formatter:productStageFormatter"><spring:message code="productplan.column.productstage_s" /></th>
                    <!-- 确认计划量 -->
                    <th data-options="field:'planquantityconfirm_f',sortable:true"><spring:message code="productplan.column.planquantityconfirm_f" /></th>
                    <!-- 计划量超产百分比 5%-基础数据字典 113 -->
                    <th data-options="field:'overpercent_f',sortable:true"><spring:message code="productplan.column.overpercent_f" /></th>
                    <!-- 工艺版本号 -->
                    <th data-options="field:'paraversion_s',width:130,sortable:true"><spring:message code="productplan.column.paraversion_s" /></th>
                    <!-- SAP下发版本号 -->
                    <th data-options="field:'sapversion_s',width:100,sortable:true"><spring:message code="productplan.column.sapversion_s" /></th>
                    <!-- 配方版本(BOM) -->
                    <th data-options="field:'repiceno_s',sortable:true"><spring:message code="productplan.column.repiceno_s" /></th>
                    <!-- 客户标识  设置基础数据字典 328 -->
                    <th data-options="field:'customerflag_s',width:100,formatter:codeFormatter,sortable:true"><spring:message code="productplan.column.customerflag_s" /></th>
                    <!-- 是否自动 0否 1 是 -->
                    <th data-options="field:'handflag_s',formatter:autoJudgeFormatter,sortable:true"><spring:message code="productplan.column.handflag_s" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changed_by_s',width:60,sortable:true"><spring:message code="productplan.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',width:120,sortable:true"><spring:message code="productplan.column.changed_time_t" /></th>
                </tr>
             </tr>
            </thead>
        </table>
    </div>
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="ProductPlan_search_form" />
		<jsp:param name="datagridId" value="productplan_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.halfpart.excel.ProductPlanExportHandler" />
		<jsp:param name="serviceName" value="ProductPlanServiceImpl" />
    </jsp:include> 
</body>
</html>
