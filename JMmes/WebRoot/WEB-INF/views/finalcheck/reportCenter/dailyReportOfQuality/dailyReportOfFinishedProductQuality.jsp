<!-- 
    作者      :whl
    时间      :2018-12-3 09:27:32 
    页面名称:成品质量检查日报表
    文件关联:
        DailyReportOfFinishedProductQualityInspection.java
        DailyReportOfFinishedProductQualityInspectionController.java
        DailyReportOfFinishedProductQualityInspectionServiceImpl.java
        DailyReportOfFinishedProductQualityInspectionServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="dailyReportOfFinishedProductQuality.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="DailyReportOfFinishedProductQualityInspection_dg_toolbar">
            <form id="DailyReportOfFinishedProductQualityInspection_search_form" class="form" >
               <td class="columnTitle">
						<!-- 操作时间 -->
						<spring:message code="maintyre.column.jianchatime" />:
						<input name="filter[begin_created_time]" editable="true" id="begin_created_time"
							type="text" class="easyui-datetimebox" style="width:170px"
							data-options="label:''">
						到 <input name="filter[end_created_time]" editable="true" id="end_created_time"
							class="easyui-datetimebox" style="width:170px">
			   </td>
			   <td class="columnTitle">
						<!-- 品号 -->	
						<spring:message code="maintyre.column.curingspeccode_s" />:
					    <input name="filter[curingspeccode_s]" like="true" id="curingspeccode_s" type="text"
						style="width:150px" class="easyui-textbox"
						data-options="label:''">
			   </td>
						<a class="easyui-linkbutton btn-yellow"
						data-options="iconCls:'icon-search'" onclick="filter()"><spring:message
						code="button.search" /></a>
                        <auth:button code="ZJ_BBZX_CPZLJC_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            </form> 
        </div>
        <table id="DailyReportOfFinishedProductQualityInspection_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#DailyReportOfFinishedProductQualityInspection_dg_toolbar',
                url: '',
                pageSize: 15,
       			pageList: [15,30,50,100,200],
                striped:true,
                method: 'get' ,
                emptyMsg:'暂无数据',
                 checkOnSelect:true,
	           selectOnCheck:true
                ">
            <thead>
                <tr>
                    <th data-options="field:'ATR_KEY',checkbox:true">ID</th>
                    <!--物料编码 -->
                    <th data-options="field:'curingspeccode',width:50,editor:{type:'textbox'}"><spring:message code="maintyre.column.curingspeccode_s" /></th>
                    <!--产品规格-->
                    <th data-options="field:'materialspec',width:190,editor:{type:'textbox'}"><spring:message code="visualmchecksumprint.column.product_standard_s" /></th>
                    <!--花纹代号-->
                    <th data-options="field:'pattern',width:60,editor:{type:'textbox'}"><spring:message code="dynamicbalance.column.pattern_s" /></th>
                    <!--A级品数量-->
                    <th data-options="field:'a_count_s',width:40,editor:{type:'textbox'}"><spring:message code="visualmchecksumprint.column.a_count_s" /></th>
                    <!--B级品数量-->
                    <th data-options="field:'b_count_s',width:40,editor:{type:'textbox'}"><spring:message code="dynabalancecheresultprint.column.b_count_s" /></th>
                    <!--一级品数量-->
                    <th data-options="field:'yiji_count_s',width:40,editor:{type:'textbox'}"><spring:message code="visualmchecksumprint.column.onelevel_count_s" /></th>
                    <!--二级品数量-->
                    <th data-options="field:'erji_count_s',width:40,editor:{type:'textbox'}"><spring:message code="visualmchecksumprint.column.secondlevel_count_s" /></th>
                    <!--废品数量-->
                    <th data-options="field:'feipin_count_s',width:40,editor:{type:'textbox'}"><spring:message code="dynabalancecheresultprint.column.fp_count_s" /></th>
                    <!--不合格品数量-->
                    <th data-options="field:'buhege_count_s',width:40,editor:{type:'textbox'}"><spring:message code="dynabalancecheresultprint.column.buhege_count_s" /></th>
                </tr>
            </thead>
        </table>
    </div>


    <jsp:include page="../../../../inc/export.jsp">
        <jsp:param name="idField" value="atr_key"/>
        <jsp:param name="formId" value="DailyReportOfFinishedProductQualityInspection_search_form"/>
        <jsp:param name="datagridId" value="DailyReportOfFinishedProductQualityInspection_dg"/>
        <jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.finalcheck.excel.DailyReportOfFinishedProductQualityExportHandler"/>
        <jsp:param name="serviceName" value="DailyReportOfFinishedProductQualityInspectionServiceImpl"/>
    </jsp:include>
</body>
</html>
