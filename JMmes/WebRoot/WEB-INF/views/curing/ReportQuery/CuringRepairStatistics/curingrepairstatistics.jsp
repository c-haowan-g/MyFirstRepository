<!-- 

    作者      :葛迎祥
    时间      :2020-04-09 15:06:18 
    页面名称:硫化返修统计
    文件关联:
        CuringRepairStatistics.java
        CuringRepairStatisticsController.java
        CuringRepairStatisticsServiceImpl.java
        CuringRepairStatisticsServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="curingrepairstatistics.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="CuringRepairStatistics_dg_toolbar">
            <form id="CuringRepairStatistics_search_form" class="form" >
                <!-- 月份 -->                        
                <spring:message code="sapproductionplan.column.month_i" />:
				<input name="filter[month_s]" id="month_s" type="text"
					class="easyui-datetimespinner"
					data-options="
                	label:'',
                	formatter:formatter2,
                	parser:parser2,
                	labelWidth:50"
					style="width:140px;">                          
                                          
                <!-- 返修人员 -->
                                         返修人员：<input name="filter[worker_id_s]" id="worker_id_s" type="text" class="easyui-textbox" data-options="" >
                <!-- 物料编码 -->
                                          物料编码：<input name="filter[material_code_s]" id="material_code_s" type="text" class="easyui-textbox" data-options="" >
                <br/>                         
	            <span>统计方式：</span>
	           	<!-- 返修人員 -->
	           	<input style="position:relative;top:2px" class="easyui-checkbox" type="checkbox" name="filter[work_id]" id="work_id" data-options="label:'',checked:true,onChange:filter"/>
	           	返修人员
	           	<!-- 物料编码 -->
	           	<input style="position:relative;top:2px" class="easyui-checkbox" type="checkbox" name="filter[material_code]" id="material_code" data-options="label:'',checked:true,onChange:filter"/>
	           	物料编码
	            <a style="margin-top: 3px;" class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
	            <auth:button code="repairrecord.export"><a style="margin-top: 3px;" class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            </form>
        </div>
        <table id="curingrepairstatistics_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#CuringRepairStatistics_dg_toolbar',
                url: '',
                emptyMsg:'暂无数据',
                loadMsg:'加载中。。。',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 返修人员 -->
	                <th data-options="field:'worker_id_s',title:'<spring:message code="curingrepairstatistics.column.worker_id_s" />',width:80" ></th>
                    <!-- 物料编码 -->
	                <th data-options="field:'material_code_s',title:'<spring:message code="curingrepairstatistics.column.material_code_s" />',width:80" ></th>
                    <!-- 物料描述 -->
	                <th data-options="field:'mterial_desc_s',title:'<spring:message code="curingrepairstatistics.column.mterial_desc_s" />',width:360" ></th>
                    <!-- 当前月份 -->
	                <th data-options="field:'month_s',title:'<spring:message code="curingrepairstatistics.column.month_s" />',width:80" ></th>
                    <!-- 总计 -->
	                <th data-options="field:'total_num_i',title:'<spring:message code="curingrepairstatistics.column.total_num_i" />',width:80" ></th>
                    <!-- 1日返修量 -->
	                <th data-options="field:'worker_id_s',title:'<spring:message code="curingrepairstatistics.column.oneday_i" />',width:80" ></th>
                    <!-- 2日返修量 -->
	                <th data-options="field:'twoday_i',title:'<spring:message code="curingrepairstatistics.column.twoday_i" />',width:80" ></th>
                    <!-- 3日返修量 -->
	                <th data-options="field:'threeday_i',title:'<spring:message code="curingrepairstatistics.column.threeday_i" />',width:80" ></th>
                    <!-- 4日返修量 -->
	                <th data-options="field:'fourday_i',title:'<spring:message code="curingrepairstatistics.column.fourday_i" />',width:80" ></th>
                    <!-- 5日返修量 -->
	                <th data-options="field:'fiveday_i',title:'<spring:message code="curingrepairstatistics.column.fiveday_i" />',width:80" ></th>
                    <!-- 6日返修量 -->
	                <th data-options="field:'sixday_i',title:'<spring:message code="curingrepairstatistics.column.sixday_i" />',width:80" ></th>
                    <!-- 7日返修量 -->
	                <th data-options="field:'sevenday_i',title:'<spring:message code="curingrepairstatistics.column.sevenday_i" />',width:80" ></th>
                    <!-- 8日返修量 -->
	                <th data-options="field:'eightday_i',title:'<spring:message code="curingrepairstatistics.column.eightday_i" />',width:80" ></th>
                    <!-- 9日返修量 -->
	                <th data-options="field:'nineday_i',title:'<spring:message code="curingrepairstatistics.column.nineday_i" />',width:80" ></th>
                    <!-- 10日返修量 -->
	                <th data-options="field:'tenday_i',title:'<spring:message code="curingrepairstatistics.column.tenday_i" />',width:80" ></th>
                    <!-- 11日返修量 -->
	                <th data-options="field:'elevenday_i',title:'<spring:message code="curingrepairstatistics.column.elevenday_i" />',width:80" ></th>
                    <!-- 12日返修量 -->
	                <th data-options="field:'twelvenday_i',title:'<spring:message code="curingrepairstatistics.column.twelvenday_i" />',width:80" ></th>
                    <!-- 13日返修量 -->
	                <th data-options="field:'thirteenday_i',title:'<spring:message code="curingrepairstatistics.column.thirteenday_i" />',width:80" ></th>
                    <!-- 14日返修量 -->
	                <th data-options="field:'fourteenday_i',title:'<spring:message code="curingrepairstatistics.column.fourteenday_i" />',width:80" ></th>
                    <!-- 15日返修量 -->
	                <th data-options="field:'fifteenday_i',title:'<spring:message code="curingrepairstatistics.column.fifteenday_i" />',width:80" ></th>
                    <!-- 16日返修量 -->
	                <th data-options="field:'sixteenday_i',title:'<spring:message code="curingrepairstatistics.column.sixteenday_i" />',width:80" ></th>
                    <!-- 17日返修量 -->
	                <th data-options="field:'seventeenday_i',title:'<spring:message code="curingrepairstatistics.column.seventeenday_i" />',width:80" ></th>
                    <!-- 18日返修量 -->
	                <th data-options="field:'eighteenday_i',title:'<spring:message code="curingrepairstatistics.column.eighteenday_i" />',width:80" ></th>
                    <!-- 19日返修量 -->
	                <th data-options="field:'ninteenday_i',title:'<spring:message code="curingrepairstatistics.column.ninteenday_i" />',width:80" ></th>
                    <!-- 20日返修量 -->
	                <th data-options="field:'twentyday_i',title:'<spring:message code="curingrepairstatistics.column.twentyday_i" />',width:80" ></th>
                    <!-- 21日返修量 -->
	                <th data-options="field:'twentyoneday_i',title:'<spring:message code="curingrepairstatistics.column.twentyoneday_i" />',width:80" ></th>
                    <!-- 22日返修量 -->
	                <th data-options="field:'twentytwoday_i',title:'<spring:message code="curingrepairstatistics.column.twentytwoday_i" />',width:80" ></th>
                    <!-- 23日返修量 -->
	                <th data-options="field:'twentythreeday_i',title:'<spring:message code="curingrepairstatistics.column.twentythreeday_i" />',width:80" ></th>
                    <!-- 24日返修量 -->
	                <th data-options="field:'twentyfourday_i',title:'<spring:message code="curingrepairstatistics.column.twentyfourday_i" />',width:80" ></th>
                    <!-- 25日返修量 -->
	                <th data-options="field:'twentyfiveday_i',title:'<spring:message code="curingrepairstatistics.column.twentyfiveday_i" />',width:80" ></th>
                    <!-- 26日返修量 -->
	                <th data-options="field:'twentysixday_i',title:'<spring:message code="curingrepairstatistics.column.twentysixday_i" />',width:80" ></th>
                    <!-- 27日返修量 -->
	                <th data-options="field:'twentysevenday_i',title:'<spring:message code="curingrepairstatistics.column.twentysevenday_i" />',width:80" ></th>
                    <!-- 28日返修量 -->
	                <th data-options="field:'twentyeightday_i',title:'<spring:message code="curingrepairstatistics.column.twentyeightday_i" />',width:80" ></th>
                    <!-- 29日返修量 -->
	                <th data-options="field:'twentynineday_i',title:'<spring:message code="curingrepairstatistics.column.twentynineday_i" />',width:80" ></th>
                    <!-- 30日返修量 -->
	                <th data-options="field:'thirtyday_i',title:'<spring:message code="curingrepairstatistics.column.thirtyday_i" />',width:80" ></th>
                    <!-- 31日返修量 -->
	                <th data-options="field:'thirtyoneday_i',title:'<spring:message code="curingrepairstatistics.column.thirtyoneday_i" />',width:80" ></th>
                </tr>
            </thead>
        </table>
    </div>
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="CuringRepairStatistics_search_form" />
		<jsp:param name="datagridId" value="curingrepairstatistics_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.curing.excel.CuringRepairStatisticsExportHandler" />
		<jsp:param name="serviceName" value="CuringRepairStatisticsServiceImpl" />
	</jsp:include> 
</body>
</html>
