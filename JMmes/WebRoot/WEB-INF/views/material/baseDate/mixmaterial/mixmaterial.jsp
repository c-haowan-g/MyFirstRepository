<!-- 

    作者      :李德晓
    时间      :2020-08-05 13:04:58 
    页面名称:PLM密炼物料表
    文件关联:
        MixMaterial.java
        MixMaterialController.java
        MixMaterialServiceImpl.java
        MixMaterialServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="mixmaterial.js.jsp"%>
<script type="text/javascript" src="dict/-304,-308,055.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="MixMaterial_dg_toolbar">
            <form id="MixMaterial_search_form" class="form" >
             <!-- 物料类别：055001-炭黑、055002-小药、055003-粉料、055004-油料、055005-胶料 -->
                <spring:message code="mixmaterial.column.materialtype_s" />
                :<input name="filter[materialtype_s]" id="materialtype_s"  type="text" class="easyui-combotree" style="width: 90px;"
                        data-options="label:'',
				              			 required:false,
				              			 panelHeight:200,
				              			 url:'dict/code/055',
				              			 method:'get'" >
                <!-- 物料类型 -->
                <spring:message code="mixmaterial.column.materialtype_sap_s" />
                <input name="filter[materialtype_sap_s]" id="materialtype_sap_s"  type="text" class="easyui-combotree" style="width: 120px;"
                       data-options="label:'',
				              			 required:false,
				              			 panelHeight:200,
				              			 url:'dict/code/-304',
				              			 method:'get'" >
                <!-- 物料组 -->
                <spring:message code="mixmaterial.column.materialgroup_s" />
                <input name="filter[materialgroup_s]" id="materialgroup_s" type="text" class="easyui-combotree"
                       data-options="label:'',
              	                         editable:true,
              	                         <%--required:false,--%>
					                     panelHeight:200,
                 		                 url:'dict/code/-308',
                  		                 method:'get'" >
                下发标识
                <input name="filter[send_state_s]" id="send_state_s" type="text" class="easyui-combobox" style="width: 110px;" data-options="labelWidth:'auto',
                                            panelHeight:100,
										    required:false,
										    editable:false,
										    data:[
										        {text:'未下发',value:'0'},
                                            {text:'已下发',value:'1'},
                                            {text:'下发失败',value:'2'}],
										    textField:'text',
										    valueField:'value',
										    method:'get'" >
                <!-- 物料编号 -->
                <spring:message code="mixmaterial.column.materialcode_s" />
                <input name="filter[materialcode_s]" id="materialcode_s" type="text" class="easyui-textbox" like="true"
                              data-options="label:''"><br>

                <spring:message code="mixmaterial.column.materialname_s"  />
                :<input name="filter[materialname_s]" id="materialname_s" type="text" class="easyui-textbox" data-options="label:'',width:'90px'" >
                <input type="checkbox" name="inMaterial" value="inMaterial" />在用物料筛选
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
                <auth:button code="RAW_Basic Data_JCSJCX__EDIT"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
                <auth:button code="RAW_Basic Data_JCSJCX__SAVE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
                <auth:button code="RAW_Basic Data_JCSJCX__NO"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a></auth:button>
                <auth:button code="RAW_Basic Data_JCSJCX__EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
                <auth:button code="RAW_Basic Data_JCSJCX__DOWNWARD"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-supplier'" onclick="downward()">下发</a></auth:button>
         </form>
        </div>
        <table id="mixmaterial_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#MixMaterial_dg_toolbar',
                url: 'material/baseDate/mixmaterial/mixmaterial/datagrid',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"rowspan="2"></th>
                    <th colspan="8"><strong></strong></th>
                    <th colspan="3"><strong>有效期控制</strong></th>
                    <th colspan="4"><strong>库存报警</strong></th>
                    <th colspan="3"><strong>加温时间控制</strong></th>
                    <th colspan="9"><strong></strong></th>
                </tr>
                <tr>
                    <!-- 物料编号 -->
                    <th data-options="field:'materialcode_s'"><spring:message code="mixmaterial.column.materialcode_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'materialname_s'"><spring:message code="mixmaterial.column.materialname_s" /></th>
                    <!--物料规格-->
                    <th data-options="field:'materialspec_s'"><spring:message code="mixmaterial.column.materialspec_s" /></th>
                    <!--物料类型-->
                    <th data-options="field:'materialtype_sap_s',formatter:codeFormatter"><spring:message code="mixmaterial.column.materialtype_sap_s" /></th>
                    <!-- 物料类别：055001-炭黑、055002-小药、055003-粉料、055004-油料、055005-胶料 -->
                    <th data-options="field:'materialtype_s',formatter:codeFormatter<%--,editor:{type:'combotree',options:{}}--%>"><spring:message code="mixmaterial.column.materialtype_s" /></th>
                    <!--物料组-->
                    <th data-options="field:'materialgroup_s',formatter:codeFormatter"><spring:message code="mixmaterial.column.materialgroup_s" /></th>
                    <!--下发标识-->
                    <th data-options="field:'send_state_s',formatter:sendStateFormatter">下发标识</th>
                                      <%--</tr>            --%>
         <%--   </thead>
            <thead>--%>
                <%--<tr>--%>
      <%--              <!-- 允许误差： 0.3-炭黑 0.02-粉料 0.1-油料 2-返回胶 0.3-胶料允许误差：0.3-返回胶 -->
                    <th data-options="field:'error_allow_d',formatter:errorAllow"><spring:message code="mixmaterial.column.error_allow_d" /></th>
                    <!-- 内径 -->
                    <th data-options="field:'innerdia_d'"><spring:message code="mixmaterial.column.innerdia_d" /></th>
                    <!-- 外径 -->
                    <th data-options="field:'outerdia_d'"><spring:message code="mixmaterial.column.outerdia_d" /></th>
                    <!-- 截面高 -->
                    <th data-options="field:'tyreheight_d'"><spring:message code="mixmaterial.column.tyreheight_d" /></th>
--%>                    <!-- 密炼快检检验百分比 -->
                    <th data-options="field:'sip_i',formatter:sipDisplay,editor:{type:'numberbox',options:{precision:0}}"><spring:message code="mixmaterial.column.sip_i" /></th>
                   <!--有效期是否管控-->
                    <th data-options="field:'overduecontrol_s',editor:{type:'combobox',options:{
										  required:true,
										  editable:false,
										  disabled:false,
					                      data:[{text:'是',value:'1'},
					                            {text:'否',value:'0'}],
					                      textField:'text',
					                      valueField:'value'
					                      }}, formatter:overDueControlFormatter" style="width: 8%;"><spring:message code="mixmaterial.column.overduecontrol_s" /></th>
                    <!-- 最小存放时间(h) -->
                    <th data-options="field:'smalltime_f', editor:{type:'numberbox',options:{precision:0}}" style="width: 6%;"><spring:message code="mixmaterial.column.smalltime_f" /></th>
                    <!-- 最长存放时间(h) -->
                    <th data-options="field:'overtime_f', editor:{type:'numberbox',options:{precision:0}}" style="width: 6%;"><spring:message code="mixmaterial.column.overtime_f" /></th>
                    <!-- 库存是否报警：0-否、1-是 -->
                    <th data-options="field:'stockalarm_s',editor:{type:'combobox',options:{
										  required:true,
										  editable:false,
										  disabled:false,
					                      data:[{text:'是',value:'1'},
					                            {text:'否',value:'0'}],
					                      textField:'text',
					                      valueField:'value',
					                      onSelect:onOverduecontrol
					                      <%--onChange:checkAndLoadData--%>
					                      }}, formatter:isNotFormatter" style="width: 10%;"><spring:message code="mixmaterial.column.stockalarm_s" /></th>
                    <!-- 警报值 -->
                    <th data-options="field:'alarmvalue_f',editor:{type:'numberbox',options:{precision:0}}" style="width: 6%;"><spring:message code="mixmaterial.column.alarmvalue_f" /></th>
                    <!-- 最小库存 -->
                    <th data-options="field:'minimumstock_f',editor:{type:'numberbox',options:{precision:0}}" style="width: 6%;"><spring:message code="mixmaterial.column.minimumstock_f" /></th>
                    <!-- 最大库存 -->
                    <th data-options="field:'maximumstock_f',editor:{type:'numberbox',options:{precision:0}}" style="width: 6%;"><spring:message code="mixmaterial.column.maximumstock_f" /></th>
                    <!--加温是否管控-->
                    <th data-options="field:'isheat_s',editor:{type:'combobox',options:{
										  required:true,
										  editable:false,
										  disabled:false,
					                      data:[{text:'是',value:'1'},
					                            {text:'否',value:'0'}],
					                      textField:'text',
					                      valueField:'value'
					                      }}, formatter:isHeatFormatter" style="width: 10%;"><spring:message code="mixmaterial.column.isheat_s" /></th>
                    <!--最短加温时间-->
                    <th data-options="field:'maxheattime_f',editor:{type:'numberbox',options:{precision:0}}" style="width: 6%;"><spring:message code="mixmaterial.column.maxheattime_f" /></th>
                    <!-- 最长加温时间 -->
                    <th data-options="field:'minheattime_f',editor:{type:'numberbox',options:{precision:0}}" style="width: 6%;" value="0"><spring:message code="mixmaterial.column.minheattime_f" /></th>
                    <!-- 物料状态：为空正常可用，反之亦然 01-因采购/仓库二被冻结 02-因任务清单/BOM而被冻结 Z1-冻结物料，只能库存收发货 Z2-冻结物料，不允许所有操作 Z3-冻结物料，只能库存收发货和采购 -->
                    <th data-options="field:'materialstatus_s',formatter:materialStatusFormatter"><spring:message code="mixmaterial.column.materialstatus_s" /></th>
                    <!--等同物料代码-->
<%--                    <th data-options="field:'equivalentmaterial_s'">等同物料代码</th>--%>
                    <!--等同物料等级-->
                    <%--<th data-options="field:'dummy2_s'">等同物料等级</th>--%>
                    <!-- 基本单位 -->
                    <th data-options="field:'baseunit_s'"><spring:message code="mixmaterial.column.baseunit_s" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changed_by_s'"><spring:message code="mixmaterial.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t'" /><spring:message code="mixmaterial.column.changed_time_t" /></th>
                    <!--下发人-->
                    <th data-options="field:'send_name_s'">下发人</th>
                    <!--下发时间-->
                    <th data-options="field:'send_time_t'" />下发时间</th>
                    <!-- 机构编号 -->
                    <th data-options="field:'agenc_no_s',formatter:agencNoFormatter"><spring:message code="mixmaterial.column.agenc_no_s" /></th>
                    <!-- 数据来源：0-PLM原数据、1-自动生成、2-SAP原数据 -->
                    <th data-options="field:'data_source_s',formatter:dataSourceFormatter"><spring:message code="mixmaterial.column.data_source_s" /></th>
                    <!-- 数据来源类型：0-上辅机配方、1-配料系统配方 -->
                    <th data-options="field:'data_source_type_s',formatter:dataSourceInfo,width:80"><spring:message code="mixmateriallog.column.data_source_type_s" /></th>
             </tr>
            </thead>
        </table>
    </div>
     <!-- 	导出-->    
	<jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="MixMaterial_search_form" />
		<jsp:param name="datagridId" value="mixmaterial_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.material.excel.MixMaterialExportHandler" />
		<jsp:param name="serviceName" value="MixMaterialServiceImpl" />
	</jsp:include>
</body>
</html>
