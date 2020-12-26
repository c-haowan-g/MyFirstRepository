<!-- 

    作者      :周清玉
    时间      :2019-09-05 15:27:34 
    页面名称:返修胎合格率统计
    文件关联:
        Maintype.java
        MaintypeController.java
        MaintypeServiceImpl.java
        MaintypeServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="maintype.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="Maintype_dg_toolbar">
            <form id="Maintype_search_form" class="form" >
            	<spring:message code="workorderresultprint.column.created_time_t" />
                <!-- 操作时间 -->
				<input name="filter[begin_created_time]" editable="true" id="begin_created_time"
							type="text" class="easyui-datetimebox" style="width:170px"
							data-options="label:''">
						到 <input name="filter[end_created_time]" editable="true" id="end_created_time"
							class="easyui-datetimebox" style="width:170px">
               
                <!-- 机台编码 -->
                <spring:message code="maintype.column.curingmachinecode_s" />
                <input name="filter[curingmachinecode_s]" like="true" id="curingmachinecode_s" type="text" class="easyui-combobox" data-options="data:jtxx,panelHeight:150,editable:true,valueField:'P_LINE_NAME',textField:'P_LINE_NAME',selectOnNavigation:false,limitToList:true" >
               
                <!--  品号-->
                <spring:message code="maintype.column.curingspeccode_s" />
                <input name="filter[curingspeccode_s]" like="true" type="text" class="easyui-textbox" data-options="label:''" >
 				
 				<spring:message code="maintype.column.curingspecmater" />
 				<!-- 硫化物料编码 -->
                <input name="filter[curingspecmater]" id="curingspecmater" like="true"  type="text" class="easyui-textbox" data-options="label:''" >
 				
 				                    
               
               <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
           <%--     <auth:button code="LH_BB_BAN_GANG_REWORKPREOSS_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-add'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            --%>
            </form> 
        </div>
        <table id="maintype_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                rowStyler:setRowBgColor,
                onLoadSuccess:onLoadSuccess,
                toolbar: '#Maintype_dg_toolbar',
                emptyMsg: '<span><spring:message code='tip.noData'/></span>',
                url: '',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 硫化机台 -->
                    <th data-options="field:'curingmachinecode_s',width:80,editor:{type:'textbox'}"><spring:message code="maintype.column.curingmachinecode_s" /></th>
                    <!-- 硫化物料编码 -->
                    <th data-options="field:'curingspeccode_s',width:80,editor:{type:'textbox'}"><spring:message code="maintype.column.curingspeccode_s" /></th>
                    <!-- 规格名称 -->
                    <th data-options="field:'curingspecmater',width:80,editor:{type:'textbox'}"><spring:message code="maintype.column.curingspecmater" /></th>
                    <!-- 返修总数 -->
                    <th data-options="field:'reworkpreosscount',width:80,editor:{type:'textbox'}"><spring:message code="maintype.column.reworkpreosscount" /></th>
                    <!-- 不合格总数 -->
                    <th data-options="field:'unqualifiedcount',width:80,editor:{type:'textbox'}"><spring:message code="maintype.column.unqualifiedcount" /></th>
                  	<!-- 百分比 -->
                    <th data-options="field:'reworkpreosspassrate',formatter:reworkpreossFormatter,width:80,editor:{type:'textbox'}"><spring:message code="maintype.column.reworkpreosspassrate" /></th>
                  </tr>
            </thead>
        </table>
    </div>
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="Maintype_search_form" />
		<jsp:param name="datagridId" value="maintype_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.lh.ExcelHandler.MaintypeExportHandler" />
		<jsp:param name="serviceName" value="MaintypeServiceImpl" />
	</jsp:include>
</body>
</html>
