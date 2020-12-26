<!-- 

    作者      :时永良
    时间      :2020年7月13日10:19:37 
    页面名称:半部件计划中间表
    文件关联:
        ProductPlanMiddle.java
        ProductPlanMiddleController.java
        ProductPlanMiddleServiceImpl.java
        ProductPlanMiddleServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="productplanmiddle.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="ProductPlanMiddle_dg_toolbar">
            <form id="ProductPlanMiddle_search_form" class="form" >
                <!-- 机台编码 -->
                <spring:message code="productplanmiddle.column.equip_code_s" />
         :&emsp;<input name="filter[equip_code_s]" id="equip_code_s" type="text" style="width:150px" like="true" class="easyui-combobox" 
                       data-options="label:'',
                                     editable:true,
                                     labelWidth:'auto',
                                     panelHeight:200,
                                     data:productLineList,
                                     textField:'DESCRIPTION',
                                     valueField:'P_LINE_NAME'">
                <!-- 日计划号 -->
          &emsp;<spring:message code="productplanmiddle.column.planno_s" />
         :&emsp;<input name="filter[planno_s]" id="planno_s" type="text" style="width:150px" like="true" class="easyui-textbox" data-options="label:''" >
          &emsp;<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="PRODUCTPLANMIDDLE_ADD"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="PRODUCTPLANMIDDLE_EDIT"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="PRODUCTPLANMIDDLE_REMOVE"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            　
            <auth:button code="PRODUCTPLANMIDDLE_SAVE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="PRODUCTPLANMIDDLE_CANCEL"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            　
            <auth:button code="PRODUCTPLANMIDDLE_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
        </div>
        <table id="productplanmiddle_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
			                fit:true,
			                fitColumns:true,
			                pagination:true,
			                rownumbers: true,
			                singleSelect: false,
			                toolbar: '#ProductPlanMiddle_dg_toolbar',
			                url: 'halfpart/producttion/specialplancheck/datagrid',
			                striped:true,
			                method: 'get',
			                emptyMsg: '<span><spring:message code='tip.noData'/></span>'
			                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 机台编码 -->
                    <th data-options="field:'equip_code_s',width:80,formatter:machineFormatter,editor:{type:'combobox',
                                      options:{
                                               labelWidth:'auto',
                                               panelHeight:'200',
                                               data:productLineList,
                                               textField:'DESCRIPTION',
                                               valueField:'P_LINE_NAME'
                                              }}"><spring:message code="productplanmiddle.column.equip_code_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'materialcode_s',hidden:true,width:80,editor:{type:'textbox'}"><spring:message code="productplanmiddle.column.materialcode_s" /></th>
                    <!-- 物料描述 -->
                    <th data-options="field:'materialdesc_s',hidden:true,width:80,editor:{type:'textbox'}"><spring:message code="productplanmiddle.column.materialdesc_s" /></th>
                    <!-- 日计划号 -->
                    <th data-options="field:'planno_s',width:80,editor:{type:'textbox'}"><spring:message code="productplanmiddle.column.planno_s" /></th>
                    <!-- 产出打印阈值 -->
                    <th data-options="field:'spare1_s',width:80,editor:{type:'textbox'}"><spring:message code="productplanmiddle.column.spare1_s" /></th>
                    <!-- 多刀分割次数 -->
                    <th data-options="field:'spare2_s',width:80,editor:{type:'textbox'}"><spring:message code="productplanmiddle.column.spare2_s" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changeby',width:80,editor:{type:'textbox',options:{
                                          disabled:true
                                          }}"><spring:message code="productplanmiddle.column.change_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'change_date_t',width:80,editor:{type:'textbox',options:{
                                          disabled:true
                                          }}"><spring:message code="productplanmiddle.column.change_date_t" /></th>
               
               
               
                </tr>
            </thead>
        </table>
    </div>
   <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="ProductPlanMiddle_search_form" />
		<jsp:param name="datagridId" value="productplanmiddle_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.halfpart.excel.ProductPlanMiddleExportHandler" />
		<jsp:param name="serviceName" value="ProductPlanMiddleServiceImpl" />
   </jsp:include> 
</body>
</html>
