<!-- 

    作者      :李德晓
    时间      :2020-08-10 13:18:12 
    页面名称:盘库结果管理
    文件关联:
        MaterialStockPlanResult.java
        MaterialStockPlanResultController.java
        MaterialStockPlanResultServiceImpl.java
        MaterialStockPlanResultServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="materialstockplanresult.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="MaterialStockPlanResult_dg_toolbar">
            <form id="MaterialStockPlanResult_search_form" class="form" >
                <!-- 计划名称 -->
					&nbsp;&nbsp;
					计划状态           	
                <input name="filter[job_name_s]" id="job_name_s" type="text" class="easyui-combobox" data-options="label:'',
                       data:jobnamelist,
	         		   panelHeight:150,
	         		   editable:true,
	           		   valueField:'JOB_NAME_S',
	          		    textField:'JOB_NAME_S',
	                   selectOnNavigation:false,
	           		   limitToList:true"	          		  
	           		    >
				
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="RAW_Stock Management_materialstockplanresult_pen"><a class="easyui-linkbutton btn-black"
						data-options="iconCls:'icon-pen'" onclick="lock()">推算结存</a></auth:button>
				

				
					<auth:button code="RAW_Stock Management_materialstockplanresult_save"><a class="easyui-linkbutton btn-black"
						data-options="iconCls:'icon-save'" onclick="onsave()">保存结存</a></auth:button>
			
            <%-- <auth:button code="XXX"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            　
            <auth:button code="XXX"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>--%>
            　
            <auth:button code="RAW_Stock Management_materialstockplanresult_expor"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button> 
        </div>
        <table id="materialstockplanresult_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#MaterialStockPlanResult_dg_toolbar',
                url: 'material/stockMangement/materialstockplanpesult/datagrid',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
					<th data-options="field:'atr_key',checkbox:true" rowspan="2"></th>
					<th colspan="3"><strong>基本信息</strong></th>
					<th colspan="2"><strong>入库量</strong></th>
					<th colspan="2"><strong>退库量</strong></th>
					<th colspan="2"><strong>期初结存</strong></th>
					<th colspan="2"><strong>出库量</strong></th>
					<th colspan="2"><strong>期末结存</strong></th>
					<th colspan="2"><strong>系统结存</strong></th>
					
				</tr>
                <tr>                   
                     <!-- 物料组 -->
                    <th data-options="field:'material_group_s',editor:{type:'textbox'}">物料组</th>
                     <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',editor:{type:'textbox'}">物料编码</th>                 
                    <!-- 物料名称 -->
                    <th data-options="field:'material_name_s',editor:{type:'textbox'}">物料名称</th>
                    
                     <!-- 生产数量 -->
                    <th data-options="field:'prod_qty_f',editor:{type:'textbox'}">数量</th>
                    <!-- 生产重量 -->
                    <th data-options="field:'prod_weight_f',editor:{type:'textbox'}">重量</th>
                     <!-- 退库数量 -->
                    <th data-options="field:'return_qty_f',editor:{type:'textbox'}">数量</th>
                    <!-- 退库重量 -->
                    <th data-options="field:'return_weight_f',editor:{type:'textbox'}">重量</th>
                    <!-- 期初结存-数量 -->
                    <th data-options="field:'ini_qty_f',editor:{type:'textbox'}">数量</th>
                    <!-- 期初结存-重量 -->
                    <th data-options="field:'ini_weight_f',editor:{type:'textbox'}">重量</th>
                    <!-- 使用数量 -->
                    <th data-options="field:'use_qty_f',editor:{type:'textbox'}">数量</th>
                    <!-- 使用重量 -->
                    <th data-options="field:'use_weight_f',editor:{type:'textbox'}">重量</th>
                    <!-- 期初结存-数量 -->
                    <th data-options="field:'ini_qty_f',editor:{type:'textbox'}">数量</th>
                    <!-- 期初结存-重量 -->
                    <th data-options="field:'ini_weight_f',editor:{type:'textbox'}">重量</th>
                     <!-- 系统结存-数量 -->
                    <th data-options="field:'sys_qty_f',editor:{type:'textbox'}">数量</th>
                    <!-- 系统结存-重量 -->
                    <th data-options="field:'sys_weight_f',editor:{type:'textbox'}">重量</th>
                </tr>
            </thead>
        </table>
    </div>
    <jsp:include page="../../../../inc/export.jsp">
        <jsp:param name="idField" value="atr_key" />
        <jsp:param name="formId" value="MaterialStockPlanResult_search_form" />
        <jsp:param name="datagridId" value="materialstockplanresult_dg" />
        <jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.material.excel.MaterialStockPlanResultExportHandler" />
        <jsp:param name="serviceName" value="MaterialStockPlanResultServiceImpl" />
    </jsp:include>
</body>
</html>
