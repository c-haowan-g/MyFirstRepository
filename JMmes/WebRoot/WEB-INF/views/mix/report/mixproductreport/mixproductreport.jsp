<!-- 

    作者      :陈国强
    时间      :2020-08-22 15:45:47 
    页面名称:密炼小料包产出实绩表
    文件关联:
        MixProductReport.java
        MixProductReportController.java
        MixProductReportServiceImpl.java
        MixProductReportServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="mixproductreport.js.jsp"%>
<script type="text/javascript" src="dict/302,301.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="MixProductReport_dg_toolbar">
            <form id="MixProductReport_search_form" class="form" >
                                         生产时间
               <%-- <input name="filter[start_time]" id="start_time" type="text" class="easyui-datetimebox" data-options="label:''" >
                <spring:message code="tip.to" /><input name="filter[end_time]" id="end_time" type="text" class="easyui-datetimebox" data-options="label:''" >--%>
                <input name="filter[start_time]" id="start_time"
                       style="width: 90px" type="text" class="easyui-datebox"
                       data-options="formatter:dateFormat,buttons:[],parser:dateParser,label:''">
                <script type="text/javascript">
                    $("#start_time").val(new Calendar().format("yyyyMMdd"));
                </script>
                &nbsp;<strong>到</strong>&nbsp;
                <input name="filter[end_time]" id="end_time" style="width: 90px" type="text" class="easyui-datebox" data-options="formatter:dateFormat,buttons:[],parser:dateParser,label:''">
                <script type="text/javascript">
                $("#end_time").val(new Calendar().format("yyyyMMdd"));
                </script>
<%--            <input name="filter[product_time_t]" id="product_time_t" type="text" class="easyui-textbox" data-options="label:''" >--%>
                <!-- 班次 -->
                <spring:message code="mixproductreport.column.shift_code_s" />
                <input name="filter[shift_code_s]" id="shift_code_s" type="text" class="easyui-combotree" 
                data-options="label:'',labelWidth:'auto',
                                            panelHeight:100,
										    required:false,
										    editable:false,
										    data:shiftCode,
										    textField:'text',
										    valueField:'code',
										    method:'get'
                " >
                <!-- 机台条码 -->
                <spring:message code="mixproductreport.column.equip_code_s" />
                <input name="filter[equip_code_s]" id="equip_code_s" type="text" class="easyui-combobox" 
                data-options="label:'',
                 			data:equiplist,
	         		   		panelHeight:150,
	         		   		editable:true,
	           		   		valueField:'p_line_name',
	          		   		textField:'description',
	                   		selectOnNavigation:false,
	           		   		limitToList:true,
	          		   		filter:searchProductionLine,
	           		   		onChange:filter" >
                
                
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
                <a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="doExport()"><spring:message code="button.export" /></a>
            </form> 
            <%-- <auth:button code="XXX"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            　
            <auth:button code="XXX"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            　
            <auth:button code="XXX"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="export()"><spring:message code="button.export" /></a></auth:button> --%>
        </div>
        <table id="mixproductreport_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#MixProductReport_dg_toolbar',
                <!-- url: 'mix/report/mixproductreport/mixproductreport/datagrid', -->
                striped:true,
                
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 产出时间 -->
                    <th data-options="field:'product_time_t',editor:{type:'textbox'}"><spring:message code="mixproductreport.column.product_time_t" /></th>
                    <!-- 班次 -->
                    <th data-options="field:'shift_code_s',formatter:codeFormatter,formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="mixproductreport.column.shift_code_s" /></th>
                    <!-- 班组 -->
                    <th data-options="field:'group_code_s',formatter:codeFormatter,formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="mixproductreport.column.group_code_s" /></th>
                    <!-- 机台名称 -->
                    <th data-options="field:'equip_name_s',editor:{type:'textbox'}"><spring:message code="mixproductreport.column.equip_name_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'material_name_s',editor:{type:'textbox'}"><spring:message code="mixproductreport.column.material_name_s" /></th>
                    <!-- 创建人姓名 -->
                    <th data-options="field:'created_name_s',editor:{type:'textbox'}">主机手</th>
                    <!--这里留个统计数量count(1) trainCount-->
                    <th data-options="field:'trainCount',editor:{type:'textbox'}">总车数</th>
                    <!-- 产出重量 -->
                    <th data-options="field:'totalWeight',editor:{type:'textbox'}">总重量</th>
                    <!-- 密炼生成配方编号，外键 -->
                    <th data-options="field:'recipe_code_name_s',editor:{type:'textbox'}">配方类型</th>
            	</tr>
            </thead>
        </table>
    </div>
    <jsp:include page="../../../../inc/export.jsp">
        <jsp:param name="idField" value="atr_key" />
        <jsp:param name="formId" value="MixProductReport_search_form" />
        <jsp:param name="datagridId" value="mixproductreport_dg" />
        <jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.mix.ExcelHandler.MixProductReportExportHandler" />
        <jsp:param name="serviceName" value="MixProductReportServiceImpl" />
    </jsp:include>
</body>
</html>
