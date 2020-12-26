<!-- 

    作者      :周清玉
    时间      :2019-08-01 13:26:16 
    页面名称:动平衡均匀机检测配套标准物料表
    文件关联:
        UfmDBResult.java
        UfmDBResultController.java
        UfmDBResultServiceImpl.java
        UfmDBResultServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="ufmdbresult.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="UfmDBResult_dg_toolbar">
            <form id="UfmDBResult_search_form" class="form" >
                <!-- 创建时间 -->
                <spring:message code="ufmdbresult.column.created_time_t" />:
                <input name="filter[begin_created_time]" editable="true" id="begin_created_time"
							type="text" class="easyui-datetimebox" style="width:170px"
							data-options="label:''">
						到 <input name="filter[end_created_time]" editable="true" id="end_created_time">
                <%-- <!-- 物料描述 -->
                <spring:message code="ufmdbresult.column.itemdesc_s" />
                <input name="filter[materialdesc]" id="materialdesc" type="text" class="easyui-textbox" data-options="label:''" >
                 --%><!-- 物料编码 -->
                <spring:message code="ufmdbresult.column.itemid_s" />:
                <input name="filter[curingspeccode_s]" id="curingspeccode_s" like="true" type="text" class="easyui-textbox" data-options="label:''" >
               
               <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
           	   <auth:button code="XXX"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            </form> 
           </div>
        <table id="ufmdbresult_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#UfmDBResult_dg_toolbar',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 物料编码 -->
                    <th data-options="field:'curingspeccode_s',width:80,editor:{type:'textbox'}"><spring:message code="ufmdbresult.column.itemid_s" /></th>
                    <!-- 物料描述 -->
                    <th data-options="field:'materialdesc',width:80,editor:{type:'textbox'}"><spring:message code="ufmdbresult.column.itemdesc_s" /></th>
                   <!-- 检测条数 -->
                    <th data-options="field:'sumcount',width:80,editor:{type:'textbox'}"><spring:message code="ufmdbresult.column.sumcount" /></th>
               		<!-- 跳动条数 -->
                    <th data-options="field:'ufcount',width:80,editor:{type:'textbox'}"><spring:message  code="ufmdbresult.column.ufcount" /></th>
              		<!--合格率 -->
                    <th data-options="field:'ufquali',formatter:ufqualiFormatter,width:80,editor:{type:'textbox'}"><spring:message code="ufmdbresult.column.ufquali" /></th>
               		<!-- 动平衡条数 -->
                    <th data-options="field:'dbcount',width:80,editor:{type:'textbox'}"><spring:message code="ufmdbresult.column.dbcount" /></th>
               		<!--合格率 -->
                    <th data-options="field:'dbquali',formatter:dbqualiFormatter,width:80,editor:{type:'textbox'}"><spring:message code="ufmdbresult.column.dbquali" /></th>
                </tr>
            </thead>
        </table>
    </div>
     <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="UfmDBResult_search_form" />
		<jsp:param name="datagridId" value="ufmdbresult_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.finalcheck.excel.UfmDBResultExportHandler" />
		<jsp:param name="serviceName" value="UfmDBResultServiceImpl" />
	</jsp:include> 
</body>
</html>
