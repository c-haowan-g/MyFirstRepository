 <!-- 

    作者      :刘朋
    时间      :2020-03-49 08:49:13 
    页面名称:半部件日计划自动编制
    文件关联:
        ProductPlan.java
        ProductPlanAutoMakingController.java
        ProductPlanAutoMakingServiceImpl.java
        ProductPlanAutoMakingServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="planAutoMaking.js.jsp"%>
<script type="text/javascript" src="dict/104,198,302,328,118,308.js"></script>
<body class="easyui-layout" fit="true">
     <div data-options="region:'center',split:true,border:false" >
        <div id="ProductPlan_dg_toolbar">
            <form id="ProductPlan_search_form" class="form" >
                <!-- 半部件计划日期 -->
                <spring:message code="productplan.column.plandate_s" />
                :&emsp;<input name="filter[plandate_s]" id="halfpartDate" type="text" style="width:150px" class="easyui-datebox" 
                              data-options="label:'',
                                            onChange:filter,
                                            formatter:dateFormat,
                                            parser:dateParser,
                                            editable:false,
                                            required:true">
                	   <script type="text/javascript">
                               $("#halfpartDate").val(new Calendar().format("yyyyMMdd"));
                       </script>
                <!-- 机台号 -->
                 &emsp;<spring:message code="productplan.column.spare1_s" />
                :&emsp;<input name="filter[spare1_s]" id="spare1_s" type="text" style="width:150px" class="easyui-combobox" like="true"
                              data-options="label:'',
                                            labelWidth:'auto',
                                            panelHeight:200,
                                            editable:true,
                                            required:false,
                                            data:productLineList,
                                            valueField:'DESCRIPTION',
                              			    textField:'DESCRIPTION',
                                            method:'get'">
                 <!-- 班次 -->
                 &emsp;<spring:message code="productplan.column.class_s" />
                :&emsp;&emsp;<input name="filter[classcode_s]" id="classcode_s" type="text" style="width:150px" class="easyui-combobox" 
                              data-options="labelWidth:'auto',
                                            panelHeight:100,
										    required:false,
										    editable:false,
										    data:classList,
										    textField:'text',
										    valueField:'code',
										    method:'get'">
                 <!--是否倒推-->
                 &emsp;<spring:message code="productplan.column.buildingrecord_s" />
                :&emsp;<input name="filter[buildingrecord_s]" id="buildingrecord_s" type="text" style="width:150px" class="easyui-combobox" 
                              data-options="labelWidth:'auto',
                                            panelHeight:100,
										    required:false,
										    editable:false,
										    data:[{text:'是',value:'1'},{text:'否',value:'0'}],
										    textField:'text',
										    valueField:'value',
										    method:'get'">
		        <br>
		        <!-- 成型计划日期 -->
                <spring:message code="productplan.column.buildingdate" />
                :&emsp;&emsp;<input id="buildingDate" type="text" style="width:150px" class="easyui-datebox" 
                           data-options="label:'',
                                         formatter:dateFormat,
                                         parser:dateParser,
                                         editable:false" >&emsp;
                    <script type="text/javascript">
                            $("#buildingDate").val(new Calendar().format("yyyyMMdd"));
                    </script>
                <!--计划状态-->
                <spring:message code="productplan.column.status_s" />
                :&emsp;<input name="filter[status_s]" id="status_s" type="text" style="width:150px" class="easyui-combotree" 
                              data-options="label:'',
                                            labelWidth:'auto',
                                            panelHeight:200,
                                            editable:false,
                                            required:false,
                                            url:'dict/code/104',
                                            method:'get' ">
                 <!-- 物料组 -->
                 &emsp;<spring:message code="productplan.column.materialgroup_s" />
                :&emsp;<input name="filter[materialgroup_s]" id="materialgroup_s" type="text" style="width:150px" class="easyui-combobox" 
                              data-options="label:'',
                                            labelWidth:'auto',
                                            panelHeight:200,
                                            editable:true,
                                            required:false,
                                            url:'sap/materials/getMaterialGroupList',
                                            valueField:'DICTCODE_S',
                              			    textField:'DICTNAME_S',
                                            method:'get' " >&emsp;
                <!-- 计划号 -->
                <spring:message code="productplan.column.planno_s" />
                :&emsp;<input name="filter[planno_s]" id="planno_s" type="text" style="width:150px" class="easyui-textbox" like="true" data-options="label:''">
                
            </form> 
            <%-- &emsp;<auth:button code="PLANAUTOMAKINGBYCLASS"><a id="planautomakingbyclass" class="easyui-linkbutton" onclick="planAutoMakingByClass()" data-options="iconCls:'icon-add'"><spring:message code="button.autoMakingByClass" /></a></auth:button> --%>
            <auth:button code="PLANAUTOMAKINGBYDATE"><a id="planautomakingbydate" class="easyui-linkbutton" onclick="planAutoMakingByDate()" data-options="iconCls:'icon-allforward'"><spring:message code="button.autoMakingByDate" /></a></auth:button>
            <auth:button code="PLANAUTOMAKINGEDIT"><a id="planautomakingedit" class="easyui-linkbutton" onclick="edit()" data-options="iconCls:'icon-edit'"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="PLANAUTOMAKINGREMOVE"><a id="planautomakingremove" class="easyui-linkbutton" onclick="remove()" data-options="iconCls:'icon-remove'"><spring:message code="button.delete" /></a></auth:button>
            <auth:button code="PLANAUTOMAKINGCANCEL"><a id="planautomakingcancel" class="easyui-linkbutton" onclick="cancel()" data-options="iconCls:'icon-cancel'"><spring:message code="button.cancel" /></a></auth:button>
            <auth:button code="PLANAUTOMAKINGSAVE"><a id="planautomakingsave" class="easyui-linkbutton" onclick="save()" data-options="iconCls:'icon-save'"><spring:message code="button.save" /></a></auth:button>
            
            <auth:button code="PLANAUTOMAKINGAUDIT"><a id="planautomakingaudit" class="easyui-linkbutton" onclick="audit()" data-options="iconCls:'icon-shenhe'"><spring:message code="button.audit" /></a></auth:button>
            <auth:button code="PLANAUTOMAKINGAUDITCANCEL"><a id="planautomakingauditcancel" class="easyui-linkbutton" onclick="auditCancel()" data-options="iconCls:'icon-fanshenhe'"><spring:message code="button.cancelAudit" /></a></auth:button>
            <auth:button code="PLANAUTOMAKINGPLANCLOSE"><a id="planautomakingplanclose" class="easyui-linkbutton" onclick="planClose()" data-options="iconCls:'icon-power'"><spring:message code="button.close" /></a></auth:button>
            <auth:button code="PLANAUTOMAKINGRESETORDER"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-upper'" onclick="resetOrder()"><spring:message code="button.sort" /></a></auth:button>
		    <a id="searchId" class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
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
			                url: 'halfpart/productionplan/automaking/datagrid',
			                striped:true,
			                method:'get',
			                onBeforeLoad:onDgBeforeLoad">
            <thead data-options="frozen:true">
                <tr>
                <th data-options="field:'atr_key',checkbox:true"></th>
                <!-- 计划生产日期 -->
                <th align="center" data-options="field:'plandate_s',sortable:true,styler:centerSetting,editor:{type:'textbox',options:{
                                      disabled:true
                                      }}"><spring:message code="productplan.column.plandate_s" /></th>
                </tr>
            </thead> 
            <thead>
                <tr>     
                <!-- 机台号 -->
                <th align="center" data-options="field:'equip_code_s',sortable:true,hidden:true,styler:centerSetting,editor:{type:'textbox',options:{ 
						  disabled:true,
						  valueField:'P_LINE_NAME',
                          			  textField:'P_LINE_NAME'}}"><spring:message code="productplan.column.equip_code_s" /></th>
                <!-- 机台名称 -->
                <th align="center" data-options="field:'spare1_s',sortable:true,styler:centerSetting,editor:{type:'textbox',options:{ 
						  disabled:true,
						  valueField:'DESCRIPTION',
                          			  textField:'DESCRIPTION'}}"><spring:message code="productplan.column.spare1_s" /></th>
                <!-- 设备代码 -->
                <th align="center" data-options="field:'devicecode_s',sortable:true,hidden:true,editor:{type:'textbox',options:{ 
						  disabled:true,
						  textField:'EQUIPCODE_S',
						  valueField:'EQUIPCODE_S'}}"><spring:message code="productplan.column.devicecode_s" /></th>
                <!-- 日计划号：生成规则 -->
                <th align="center" data-options="field:'planno_s',sortable:true,styler:centerSetting,editor:{type:'textbox',options:{
                                      disabled:true
                                      }}"><spring:message code="productplan.column.planno_s" /></th>
                <!-- 班次 基础数据字典 118 -->
                <th align="center" data-options="field:'classcode_s',formatter:classCodeFormatter,styler:centerSetting,sortable:true,editor:{type:'combobox',
                                      options:{
                                               disabled:true,
                                               data:classList,
                                               textField:'text',
                                               valueField:'code'
                                              }}"><spring:message code="productplan.column.class_s" /></th>
                <!-- 计划顺序优先级 -->
                <th align="center" data-options="field:'plan_order_i',sortable:true,styler:centerSetting,editor:{type:'textbox',options:{
                                      required:true,
                                      editable:true,
                                      }}"><spring:message code="productplan.column.plan_order_i" /></th>
                <!-- 计划状态：基础数据104 -->
                <th align="center" data-options="field:'status_s',styler:planStatusColorSetting,formatter:planStatusFormatter,sortable:true,editor:{type:'combotree',options:{
                                      labelWidth:'auto',
                                      panelHeight:200,
						  required:true,
						  editable:false,
						  disabled:true,
						  url:'dict/code/104'
                                      }}"><spring:message code="productplan.column.status_s" /></th>
                <!-- 物料规格 -->
                <th align="center" data-options="field:'specification_s',sortable:true,styler:centerSetting,editor:{type:'combobox',options:{ 
						  labelWidth:'auto',
                                      panelHeight:200,
						  required:true,
						  editable:true,
						  disabled:false,
	                      valueField:'OLDMATCODE_S',
	                      textField:'OLDMATCODE_S'
	                      }}"><spring:message code="productplan.column.specification_s" /></th>
                <!-- 物料名称 -->
                <th align="center" data-options="field:'materialname_s',sortable:true,styler:centerSetting,editor:{type:'combobox',options:{ 
                                      labelWidth:'auto',
                                      panelHeight:200,
						  required:true,
						  editable:true,
	                      valueField:'MATERIALDESC_S',
	                      textField:'MATERIALDESC_S'
	                      }}"><spring:message code="productplan.column.materialname_s" /></th>
                
                <!-- 物料编码 -->
                <th align="center" data-options="field:'materialcode_s',sortable:true,styler:centerSetting,editor:{type:'combobox',
                           options:{ 
						  labelWidth:'auto',
                                      panelHeight:200,
						  required:true,
						  editable:true,
						  disabled:false,
	                      valueField:'MATERIALCODE_S',
	                      textField:'MATERIALCODE_S',
	                      }}"><spring:message code="productplan.column.materialcode_s" /></th>
	            <!-- 物料组 -->
                <th align="center" data-options="field:'materialgroup_s',styler:centerSetting,sortable:true,hidden:true,editor:{type:'textbox',options:{}}"><spring:message code="productplan.column.materialgroup_s" /></th>
                <!-- 物料组名称 -->
                <th align="center" data-options="field:'materialdesc_s',sortable:true,editor:{type:'textbox',options:{}}"><spring:message code="productplan.column.materialdesc_s" /></th>
	            <!-- SAP下发版本号 -->
                <th align="center" data-options="field:'sapversion_s',sortable:true,styler:centerSetting,editor:{type:'combobox',options:{ 
						  required:true,
						  editable:false,
						  valueField:'PRODUCTION_VER_S',
                          			  textField:'PRODUCTION_VER_S'}}"><spring:message code="productplan.column.sapversion_s" /></th>
                <!-- 计划量超产百分比  -->
                <th align="center" data-options="field:'overpercent_f',sortable:true,editor:{type:'textbox',options:{}}"><spring:message code="productplan.column.overpercent_f" /></th>
                <!-- 产品阶段 -->
                <th align="center" data-options="field:'productstage_s',sortable:true,formatter:productStageFormatter,styler:centerSetting,editor:{type:'combobox',options:{ 
						  required:true,
						  editable:false,
						  disabled:false,
	                      data:[{text:'试制',value:'01'},
	                            {text:'试产',value:'02'},
	                            {text:'投产',value:'03'}],
	                      textField:'text',
	                      valueField:'value'
	                      }}"><spring:message code="productplan.column.productstage_s" /></th>
                <!-- 确认计划量 -->
                <th align="center" data-options="field:'planquantityconfirm_f',sortable:true,styler:centerSetting,editor:{type:'numberspinner',options:{min:0,max:10000}}"><spring:message code="productplan.column.planquantityconfirm_f" /></th>
                <!-- 工艺版本号 -->
                <th align="center" data-options="field:'paraversion_s',sortable:true,styler:centerSetting,editor:{type:'combobox',options:{ 
						  required:true,
						  editable:true,
						  valueField:'PROCESSVERSION_S',
	                      textField:'PROCESSVERSION_S'
						  }}"><spring:message code="productplan.column.paraversion_s" /></th>
                <!-- 工艺版本ID -->
                <th align="center" data-options="field:'parameterid_s',sortable:true,hidden:true,editor:{type:'combobox',options:{ 
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
                <th align="center" data-options="field:'customerflag_s',formatter:codeFormatter,sortable:true,styler:centerSetting,editor:{type:'combotree',options:{
                                      labelWidth:'auto',
                                      panelHeight:200,
						  required:true,
						  editable:false,
						  url:'dict/code/328'}}"><spring:message code="productplan.column.customerflag_s" /></th>
                <!-- 是否自动 0否 1 是 -->
                <th align="center" data-options="field:'buildingrecord_s',formatter:autoJudgeFormatter,sortable:true,styler:centerSetting,editor:{type:'texbox',options:{
						  required:true,
						  editable:false,
                                      disabled:true}}"><spring:message code="productplan.column.buildingrecord_s" /></th>
                <!-- 修改人 -->
                <th align="center" data-options="field:'changed_by_s',sortable:true,styler:centerSetting,editor:{type:'textbox',options:{
                                      disabled:true
                                      }}"><spring:message code="productplan.column.changed_by_s" /></th>
                <!-- 修改时间 -->
                <th align="center" data-options="field:'changed_time_t',sortable:true,styler:centerSetting,editor:{type:'textbox',options:{
                                      disabled:true
                                      }}"><spring:message code="productplan.column.changed_time_t" /></th>
                </tr>
            </thead>
        </table>
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
              <auth:button code="PRODUCTPLANRESORT_UPPER"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-up'" onclick="MoveUp()"><spring:message code="button.up" /></a></auth:button>
              <auth:button code="PRODUCTPLANRESORT_LOWER"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-down'" onclick="MoveDown()"><spring:message code="button.down" /></a></auth:button>
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
                </tr>
                </thead> 
                <thead>
                <tr>
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
</body>
</html>
