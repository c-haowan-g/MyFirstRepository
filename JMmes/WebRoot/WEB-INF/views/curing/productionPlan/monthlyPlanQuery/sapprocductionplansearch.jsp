<!-- 

    作者      :时永良
    时间      :2019年7月19日10:06:51
    页面名称:硫化月计划查询
    文件关联:
        SapProcductionPlanSearch.java
        SapProcductionPlanSearchController.java
        SapProcductionPlanSearchServiceImpl.java
        SapProcductionPlanSearchServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="sapprocductionplansearch.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="SapProcductionPlanSearch_dg_toolbar">
            <form id="SapProcductionPlanSearch_search_form" class="form" >
            	<!-- 月份 -->
            	<spring:message code="sapproductionplan.column.month_i" />:
                <input name="filter[month_i]" id="month_i" type="text"
					class="easyui-datetimespinner"
					data-options="
                	label:'',
                	formatter:formatter2,
                	parser:parser2,
                	labelWidth:50"
					style="width:120px;">
                <!-- 月计划号 -->
                <spring:message code="sapprocductionplansearch.column.planno_month_s" />:
                <input name="filter[planno_month_s]" id="planno_month_s" type="text" style="width:120px;" class="easyui-textbox" data-options="label:''" >
                <!-- 物料编码 -->
                <spring:message code="sapprocductionplansearch.column.material_code_s" />:
                <input name="filter[material_code_s]" id="material_code_s" type="text" style="width:120px;" class="easyui-combobox" data-options="label:'',
										  panelHeight:200,
										  required:false,
										  editable:'true',
										  limitToList:'false',
										  url:'curing/moldmanagement/moldmarkingdrawing/materialpdf/searchByMaterial',
										  valueField: 'MATERIALCODE_S',
                              			  textField: 'MATERIALCODE_S',
										  method:'get'" >
                <!-- 物料描述 -->
                <spring:message code="sapprocductionplansearch.column.material_name_s" />:
                <input name="filter[material_name_s]" id="material_name_s" type="text" style="width:120px;" class="easyui-textbox" data-options="label:''" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
                <auth:button code="LH_SCJH_YJHS_EXPORT">
				<a class="easyui-linkbutton btn-deep-blue"
					data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message
						code="button.export" /></a>
			</auth:button>
            </form> 
        </div>
        <table id="sapprocductionplansearch_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#SapProcductionPlanSearch_dg_toolbar',
                url: 'curing/productionPlan/monthlyPlanQuery/datagrid',
                striped:true,
                method: 'get',
                onBeforeLoad:onBeforeLoad,
                emptyMsg:'暂无数据' 
                ">
            <thead>
                <tr>
                    <!-- 月份 -->
                    <th data-options="field:'month_i',width:60,editor:{type:'textbox'}"><spring:message code="sapprocductionplansearch.column.month_i" /></th>
                    <!-- 月计划号 -->
                    <th data-options="field:'planno_month_s',width:120,editor:{type:'textbox'}"><spring:message code="sapprocductionplansearch.column.planno_month_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',width:90,editor:{type:'textbox'}"><spring:message code="sapprocductionplansearch.column.material_code_s" /></th>
                    <!-- 物料描述 -->
                    <th data-options="field:'material_name_s',width:410,editor:{type:'textbox'}"><spring:message code="sapprocductionplansearch.column.material_name_s" /></th>
                    <!-- 计划开始时间 -->
                    <th data-options="field:'plan_starttime_t',formatter:dateChangeFormatter,width:100,editor:{type:'textbox'}"><spring:message code="sapprocductionplansearch.column.plan_starttime_t" /></th>
                    <!-- 计划结束时间 -->
                    <th data-options="field:'plan_endtime_t',formatter:dateChangeFormatter,width:100,editor:{type:'textbox'}"><spring:message code="sapprocductionplansearch.column.plan_endtime_t" /></th>
                     <!-- 月计划数量 -->
                    <th data-options="field:'quantity_plan_f',width:80,editor:{type:'textbox'}"><spring:message code="sapprocductionplansearch.column.quantity_plan_f" /></th>
                    <!-- 已过动平衡量 -->
                    <th data-options="field:'balance_quantity_i',width:80,editor:{type:'textbox'}"><spring:message code="sapprocductionplansearch.column.balance_quantity_i" /></th>
                    <!-- 实际生产量 -->
                    <th data-options="field:'quantity_actual_f',width:80,editor:{type:'textbox'}"><spring:message code="sapprocductionplansearch.column.quantity_actual_f" /></th>
                    <!-- 完成率 -->
                    <th data-options="field:'completion_rate',width:80,editor:{type:'textbox'},formatter:completionRate"><spring:message code="sapprocductionplansearch.column.completion_rate" /></th>
                    <!-- 1日硫化量 -->
                    <th data-options="field:'oneday_i',width:80,editor:{type:'textbox'}"><spring:message code="sapprocductionplansearch.column.oneday_i" /></th>
                    <!-- 2日硫化量 -->
                    <th data-options="field:'twoday_i',width:80,editor:{type:'textbox'}"><spring:message code="sapprocductionplansearch.column.twoday_i" /></th>
                    <!-- 3日硫化量 -->
                    <th data-options="field:'threeday_i',width:80,editor:{type:'textbox'}"><spring:message code="sapprocductionplansearch.column.threeday_i" /></th>
                    <!-- 4日硫化量 -->
                    <th data-options="field:'fourday_i',width:80,editor:{type:'textbox'}"><spring:message code="sapprocductionplansearch.column.fourday_i" /></th>
                    <!-- 5日硫化量 -->
                    <th data-options="field:'fiveday_i',width:80,editor:{type:'textbox'}"><spring:message code="sapprocductionplansearch.column.fiveday_i" /></th>
                    <!-- 6日硫化量 -->
                    <th data-options="field:'sixday_i',width:80,editor:{type:'textbox'}"><spring:message code="sapprocductionplansearch.column.sixday_i" /></th>
                    <!-- 7日硫化量 -->
                    <th data-options="field:'sevenday_i',width:80,editor:{type:'textbox'}"><spring:message code="sapprocductionplansearch.column.sevenday_i" /></th>
                    <!-- 8日硫化量 -->
                    <th data-options="field:'eightday_i',width:80,editor:{type:'textbox'}"><spring:message code="sapprocductionplansearch.column.eightday_i" /></th>
                    <!-- 9日硫化量 -->
                    <th data-options="field:'nineday_i',width:80,editor:{type:'textbox'}"><spring:message code="sapprocductionplansearch.column.nineday_i" /></th>
                    <!-- 10日硫化量 -->
                    <th data-options="field:'tenday_i',width:80,editor:{type:'textbox'}"><spring:message code="sapprocductionplansearch.column.tenday_i" /></th>
                    <!-- 11日硫化量 -->
                    <th data-options="field:'elevenday_i',width:80,editor:{type:'textbox'}"><spring:message code="sapprocductionplansearch.column.elevenday_i" /></th>
                    <!-- 12日硫化量 -->
                    <th data-options="field:'twelvenday_i',width:80,editor:{type:'textbox'}"><spring:message code="sapprocductionplansearch.column.twelvenday_i" /></th>
                    <!-- 13日硫化量 -->
                    <th data-options="field:'thirteenday_i',width:80,editor:{type:'textbox'}"><spring:message code="sapprocductionplansearch.column.thirteenday_i" /></th>
                    <!-- 14日硫化量 -->
                    <th data-options="field:'fourteenday_i',width:80,editor:{type:'textbox'}"><spring:message code="sapprocductionplansearch.column.fourteenday_i" /></th>
                    <!-- 15日硫化量 -->
                    <th data-options="field:'fifteenday_i',width:80,editor:{type:'textbox'}"><spring:message code="sapprocductionplansearch.column.fifteenday_i" /></th>
                    <!-- 16日硫化量 -->
                    <th data-options="field:'sixteenday_i',width:80,editor:{type:'textbox'}"><spring:message code="sapprocductionplansearch.column.sixteenday_i" /></th>
                    <!-- 17日硫化量 -->
                    <th data-options="field:'seventeenday_i',width:80,editor:{type:'textbox'}"><spring:message code="sapprocductionplansearch.column.seventeenday_i" /></th>
                    <!-- 18日硫化量 -->
                    <th data-options="field:'eighteenday_i',width:80,editor:{type:'textbox'}"><spring:message code="sapprocductionplansearch.column.eighteenday_i" /></th>
                    <!-- 19日硫化量 -->
                    <th data-options="field:'ninteenday_i',width:80,editor:{type:'textbox'}"><spring:message code="sapprocductionplansearch.column.ninteenday_i" /></th>
                    <!-- 20日硫化量 -->
                    <th data-options="field:'twentyday_i',width:80,editor:{type:'textbox'}"><spring:message code="sapprocductionplansearch.column.twentyday_i" /></th>
                    <!-- 21日硫化量 -->
                    <th data-options="field:'twentyoneday_i',width:80,editor:{type:'textbox'}"><spring:message code="sapprocductionplansearch.column.twentyoneday_i" /></th>
                    <!-- 22日硫化量 -->
                    <th data-options="field:'twentytwoday_i',width:80,editor:{type:'textbox'}"><spring:message code="sapprocductionplansearch.column.twentytwoday_i" /></th>
                    <!-- 23日硫化量 -->
                    <th data-options="field:'twentythreeday_i',width:80,editor:{type:'textbox'}"><spring:message code="sapprocductionplansearch.column.twentythreeday_i" /></th>
                    <!-- 24日硫化量 -->
                    <th data-options="field:'twentyfourday_i',width:80,editor:{type:'textbox'}"><spring:message code="sapprocductionplansearch.column.twentyfourday_i" /></th>
                    <!-- 25日硫化量 -->
                    <th data-options="field:'twentyfiveday_i',width:80,editor:{type:'textbox'}"><spring:message code="sapprocductionplansearch.column.twentyfiveday_i" /></th>
                    <!-- 26日硫化量 -->
                    <th data-options="field:'twentysixday_i',width:80,editor:{type:'textbox'}"><spring:message code="sapprocductionplansearch.column.twentysixday_i" /></th>
                    <!-- 27日硫化量 -->
                    <th data-options="field:'twentysevenday_i',width:80,editor:{type:'textbox'}"><spring:message code="sapprocductionplansearch.column.twentysevenday_i" /></th>
                    <!-- 28日硫化量 -->
                    <th data-options="field:'twentyeightday_i',width:80,editor:{type:'textbox'}"><spring:message code="sapprocductionplansearch.column.twentyeightday_i" /></th>
                    <!-- 29日硫化量 -->
                    <th data-options="field:'twentynineday_i',width:80,editor:{type:'textbox'}"><spring:message code="sapprocductionplansearch.column.twentynineday_i" /></th>
                    <!-- 30日硫化量 -->
                    <th data-options="field:'thirtyday_i',width:80,editor:{type:'textbox'}"><spring:message code="sapprocductionplansearch.column.thirtyday_i" /></th>
                    <!-- 31日硫化量 -->
                    <th data-options="field:'thirtyoneday_i',width:80,editor:{type:'textbox'}"><spring:message code="sapprocductionplansearch.column.thirtyoneday_i" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_s',width:80,editor:{type:'textbox'}"><spring:message code="sapprocductionplansearch.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',width:80,editor:{type:'textbox'}"><spring:message code="sapprocductionplansearch.column.created_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="SapProcductionPlanSearch_search_form" />
		<jsp:param name="datagridId" value="sapprocductionplansearch_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.curing.excel.SapProcductionPlanSearchExportHandler" />
		<jsp:param name="serviceName" value="SapProcductionPlanSearchServiceImpl" />
	</jsp:include>
</body>
</html>
