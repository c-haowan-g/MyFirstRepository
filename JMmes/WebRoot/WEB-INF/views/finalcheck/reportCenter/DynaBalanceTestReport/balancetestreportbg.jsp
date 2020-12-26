<!-- 
    作者      :时永良
    时间      :2020年1月5日15:07:01
    页面名称:动平衡检测报表(半钢)
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="balancetestreportbg.js.jsp"%>
<script type="text/javascript" src="dict/253,262.js"></script>
<style type="text/css">
.columnTitle {
	padding: 6px 10px
}
</style>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="DynaBalanceTestReport_dg_toolbar">
            <form id="DynaBalanceTestReport_search_form" class="form" >
            <table class="formTable">
				<tr>
						<!-- 操作时间 -->
						<spring:message code="maintyre.column.jianchatime" />:
						<input name="filter[begin_created_time]" id="begin_created_time" type="text" class="easyui-datetimebox" data-options="label:'',width:'150px',required:true">
						到
						<input name="filter[end_created_time]" id="end_created_time" type="text" class="easyui-datetimebox" data-options="label:'',width:'150px',required:true"> 
						<!-- 物料编码 --> <spring:message code="maintyre.column.curingspeccode_s" /> :
						<input name="filter[curingspeccode_s]" style="width:110px" like="true" id="curingspeccode_s" type="text" class="easyui-textbox" data-options="label:'',width:'100px'">&nbsp;&nbsp;
						<a class="easyui-linkbutton btn-yellow"
						data-options="iconCls:'icon-search'" onclick="intTable()"><spring:message
						code="button.search" /></a>
					<auth:button code="ZJ_BBZX_DPHJCJGHZ_PRINT">
						<a class="easyui-linkbutton btn-deep-blue"
							data-options="iconCls:'icon-excel-export'" onclick="ExcelExport()"><spring:message
								code="button.export" /></a>
					</auth:button>
				</tr>
			</table>
			</form>
			
			
        </div>
        <table id="dynamicbalancetestreport_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#DynaBalanceTestReport_dg_toolbar',
                striped:true,
                method: 'get', 
                emptyMsg: '<span><spring:message code='tip.noData'/></span>',
                onLoadSuccess:onLoadSuccess,
                rowStyler:setRowBgColor,
                onCheckAll:onCheckAll
                ">
            <thead>
                <tr>
                	 <th data-options="field:'atr_key',checkbox:true">ID</th>
                     <!-- 物料编码 -->
                     <th data-options="field:'curingspeccode_s',width:80,editor:{type:'textbox'}"><spring:message code="maintyre.column.curingspeccode_s" /></th>
                     <!-- 物料描述 -->
                     <th data-options="field:'description',width:260,editor:{type:'textbox'} " ><spring:message code="maintyre.column.description" /></th>
                     <!-- 受检总数-->
                     <th data-options="field:'speccount',width:60,editor:{type:'textbox'} " ><spring:message code="maintyre.column.speccount" /></th>
                    
                    <!-- 动平衡A+1-->
                    <th data-options="field:'dpha1',width:80,editor:{type:'textbox'} " ><spring:message code="maintyre.column.dpha1" /></th>
                    <!-- 动平衡A+1品率-->
                    <th data-options="field:'dpha1pinlv',width:100,editor:{type:'textbox'} " ><spring:message code="maintyre.column.dpha1pinlv" /></th>
                    <!-- 跳动度A+1-->
                    <th data-options="field:'tdda1',width:80,editor:{type:'textbox'} " ><spring:message code="maintyre.column.tdda1" /></th>
                    <!-- 跳动度A+1品率-->
                    <th data-options="field:'tdda1pinlv',width:100,editor:{type:'textbox'} " ><spring:message code="maintyre.column.tdda1pinlv" /></th>
                    <!-- 均匀性A+1-->
                    <th data-options="field:'jyxa1',width:80,editor:{type:'textbox'} " ><spring:message code="maintyre.column.jyxa1" /></th>
                    <!-- 均匀性A+1品率-->
                    <th data-options="field:'jyxa1pinlv',width:100,editor:{type:'textbox'} " ><spring:message code="maintyre.column.jyxa1pinlv" /></th>
                    <!-- A+1-->
                    <th data-options="field:'a1',width:40,editor:{type:'textbox'} " ><spring:message code="maintyre.column.a1" /></th>
                    <!-- A+1品率-->
                    <th data-options="field:'a1pinlv',width:60,editor:{type:'textbox'} " ><spring:message code="maintyre.column.a1pinlv" /></th>
                    
                    <!-- 动平衡A-->
                    <th data-options="field:'dpha',width:60,editor:{type:'textbox'} " ><spring:message code="maintyre.column.dpha" /></th>
                    <!-- 动平衡A品率-->
                    <th data-options="field:'dphapinlv',width:80,editor:{type:'textbox'} " ><spring:message code="maintyre.column.dphapinlv" /></th>
                    <!-- 跳动度A-->
                    <th data-options="field:'tdda',width:60,editor:{type:'textbox'} " ><spring:message code="maintyre.column.tdda" /></th>
                    <!-- 跳动度A品率-->
                    <th data-options="field:'tddapinlv',width:80,editor:{type:'textbox'} " ><spring:message code="maintyre.column.tddapinlv" /></th>
                    <!-- 均匀性度A-->
                    <th data-options="field:'jyxa',width:80,editor:{type:'textbox'} " ><spring:message code="maintyre.column.jyxa" /></th>
                    <!-- 均匀性A品率-->
                    <th data-options="field:'jyxapinlv',width:100,editor:{type:'textbox'} " ><spring:message code="maintyre.column.jyxapinlv" /></th>
                    <!-- A-->
                    <th data-options="field:'a',width:40,editor:{type:'textbox'} " ><spring:message code="maintyre.column.a" /></th>
                    <!-- A品率-->
                    <th data-options="field:'apinlv',width:60,editor:{type:'textbox'} " ><spring:message code="maintyre.column.apinlv" /></th>
                    
                    <!-- 动平衡A0-->
                    <th data-options="field:'dpha0',width:60,editor:{type:'textbox'} " ><spring:message code="maintyre.column.dpha0" /></th>
                    <!-- 动平衡A0品率-->
                    <th data-options="field:'dpha0pinlv',width:80,editor:{type:'textbox'} " ><spring:message code="maintyre.column.dpha0pinlv" /></th>
                    <!-- 跳动度A0-->
                    <th data-options="field:'tdda0',width:60,editor:{type:'textbox'} " ><spring:message code="maintyre.column.tdda0" /></th>
                    <!-- 跳动度A0品率-->
                    <th data-options="field:'tdda0pinlv',width:80,editor:{type:'textbox'} " ><spring:message code="maintyre.column.tdda0pinlv" /></th>
                    <!-- 均匀性度A0-->
                    <th data-options="field:'jyxa0',width:80,editor:{type:'textbox'} " ><spring:message code="maintyre.column.jyxa0" /></th>
                    <!-- 均匀性A品率0-->
                    <th data-options="field:'jyxa0pinlv',width:100,editor:{type:'textbox'} " ><spring:message code="maintyre.column.jyxa0pinlv" /></th>
                    <!-- A0-->
                    <th data-options="field:'a0',width:40,editor:{type:'textbox'} " ><spring:message code="maintyre.column.a0" /></th>
                    <!-- A0品率-->
                    <th data-options="field:'a0pinlv',width:60,editor:{type:'textbox'} " ><spring:message code="maintyre.column.a0pinlv" /></th>
                    
                    <!-- 动平衡D-->
                    <th data-options="field:'dphd',width:60,editor:{type:'textbox'} " ><spring:message code="maintyre.column.dphd" /></th>
                    <!-- 动平衡D品率-->
                    <th data-options="field:'dphdpinlv',width:80,editor:{type:'textbox'} " ><spring:message code="maintyre.column.dphdpinlv" /></th>
                    <!-- 跳动度D-->
                    <th data-options="field:'tddd',width:60,editor:{type:'textbox'} " ><spring:message code="maintyre.column.tddd" /></th>
                    <!-- 跳动度D品率-->
                    <th data-options="field:'tdddpinlv',width:80,editor:{type:'textbox'} " ><spring:message code="maintyre.column.tdddpinlv" /></th>
                    <!-- 均匀性度D-->
                    <th data-options="field:'jyxd',width:80,editor:{type:'textbox'} " ><spring:message code="maintyre.column.jyxd" /></th>
                    <!-- 均匀性D品率-->
                    <th data-options="field:'jyxdpinlv',width:100,editor:{type:'textbox'} " ><spring:message code="maintyre.column.jyxdpinlv" /></th>
                    <!-- 二级-->
                    <th data-options="field:'erji',width:40,editor:{type:'textbox'} " ><spring:message code="maintyre.column.erji" /></th>
                    <!-- 二级品率-->
                    <th data-options="field:'erjipinlv',width:60,editor:{type:'textbox'} " ><spring:message code="maintyre.column.erjipinlv" /></th>
                    
                </tr>
            </thead>
        </table>
    </div>

    <%-- <jsp:include page="../../../../inc/export.jsp">
        <jsp:param name="idField" value="atr_key"/>
        <jsp:param name="formId" value="DynaBalanceTestReport_search_form"/>
        <jsp:param name="datagridId" value="dynamicbalancetestreport_dg"/>
        <jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.finalcheck.excel.DynaBalanceTestReportExportHandler"/>
        <jsp:param name="serviceName" value="DynabalancereversalServiceImpl"/>
    </jsp:include> --%>
</body>
</html>
