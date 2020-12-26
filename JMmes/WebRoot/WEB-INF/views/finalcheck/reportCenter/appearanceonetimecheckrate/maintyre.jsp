<!-- 

    作者      :周清玉
    时间      :2019-08-07 10:26:06 
    页面名称:外观一次交检合格率报表
    文件关联:
        MainTyre.java
        MainTyreController.java
        MainTyreServiceImpl.java
        MainTyreServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="maintyre.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="MainTyre_dg_toolbar">
            <form id="MainTyre_search_form" class="form" >
				<spring:message code="maintyre.column.jianchatime" />:
				<input name="filter[begin_created_time]" editable="true" id="begin_created_time"
					type="text" class="easyui-datetimebox" style="width:170px"
					data-options="label:''">
				到 <input name="filter[end_created_time]" editable="true" id="end_created_time"
					class="easyui-datetimebox" style="width:170px">
          
           
            <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            <auth:button code="ZJ_BBZX_APPEARANCEONETIMECHECKRATE_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            </form> 
        </div>
        <table id="maintyre_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#MainTyre_dg_toolbar',
                url: '',
                striped:true,
                 emptyMsg:'<span><spring:message code='tip.noData'/></span>',
                method: 'get' 
                ">
            <thead>
                <tr>
                 <th data-options="field:'atr_key',checkbox:true"></th>
                    
                    
                     <!-- 检测数量 -->
                    <th data-options="field:'totalnum',width:80,editor:{type:'textbox'}"><spring:message code="maintyre.column.curingspeccode_count_s" /></th>
                    
                     <!--一次合格数量 -->
                    <th data-options="field:'onetimepass_count',width:80,editor:{type:'textbox'}"><spring:message code="maintype.column.onetimepass_count" /></th>
                    
                     <!-- 一次交检率 -->
                    <th data-options="field:'onetime_rate',formatter:rateformatter,width:80,editor:{type:'textbox'}"><spring:message code="maintype.column.onetime_rate" /></th>
                    
                     <!-- 胎圈缺胶-->
                    <th data-options="field:'taiquanquejiao_count_s',width:80,editor:{type:'textbox'}"><spring:message code="maintyre.column.taiquanquejiao_count_s" /></th>
                    
                     <!-- 胎侧缺胶 -->
                    <th data-options="field:'taicequejiao_count_s',width:80,editor:{type:'textbox'}"><spring:message code="maintyre.column.taicequejiao_count_s" /></th>
                    
                     <!-- 胎冠缺胶 -->
                    <th data-options="field:'taiguanquejiao_count_s',width:80,editor:{type:'textbox'}"><spring:message code="maintyre.column.taiguanquejiao_count_s" /></th>
                    
                     <!-- 胎肩缺胶-->
                    <th data-options="field:'taijianquejiao_count_s',width:80,editor:{type:'textbox'}"><spring:message code="maintyre.column.taijianquejiao_count_s" /></th>
                    
                    <%--  <!-- 缺胶 -->
                    <th data-options="field:'quejiao_count_s',formatter:quejiaoformatter,width:80,editor:{type:'textbox'}"><spring:message code="maintyre.column.quejiao_count_s" /></th> --%>
                    
                     <!-- 杂物 -->
                    <th data-options="field:'zawu_count_s',width:80,editor:{type:'textbox'}"><spring:message code="maintyre.column.zawu_count_s" /></th>
                    
                     <!-- 胶边 -->
                    <th data-options="field:'jiaobian_count_s',width:80,editor:{type:'textbox'}"><spring:message code="maintyre.column.jiaobian_count_s" /></th>
                    
                     <!-- 割毛不净 -->
                    <th data-options="field:'gemaosunshang_count_s',width:80,editor:{type:'textbox'}"><spring:message code="maintyre.column.gemaosunshang_count_s" /></th>
                    
                    
                     <!-- 胎圈气泡-->
                    <th data-options="field:'taiquanqipao_count_s',width:80,editor:{type:'textbox'}"><spring:message code="maintyre.column.taiquanqipao_count_s" /></th>
                    
                     <!-- 废次品 -->
                    <th data-options="field:'feicipin_count_s',width:80,editor:{type:'textbox'}"><spring:message code="maintyre.column.feicipin_count_s" /></th>
                   
                     <!-- 返修品 -->
                    <th data-options="field:'totalrework_count_s',width:80,editor:{type:'textbox'}"><spring:message code="maintyre.column.totalrework_count_s" /></th>
                   
                    <!-- 其他 -->
                    <th data-options="field:'others_count_s',width:80,editor:{type:'textbox'}"><spring:message code="maintyre.column.others_count_s" /></th>
                    
                     <!-- 缺陷合计 -->
                    <th data-options="field:'rease_count_s',formatter:reasformatter,width:80,editor:{type:'textbox'}"><spring:message code="maintyre.column.rease_count_s" /></th>
                    
                    
            </thead>
        </table>
    </div>


    <jsp:include page="../../../../inc/export.jsp">
        <jsp:param name="idField" value="atr_key"/>
        <jsp:param name="formId" value="MainTyre_search_form"/>
        <jsp:param name="datagridId" value="maintyre_dg"/>
        <jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.finalcheck.excel.MainTyreCurExportHandler"/>
        <jsp:param name="serviceName" value="MainTyreServiceImpl"/>
    </jsp:include>
</body>
</html>
