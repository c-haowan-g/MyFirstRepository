<!-- 

    作者      :司乔靖
    时间      :2019-07-16 10:13:23 
    页面名称:PLM硫化工艺参数
    文件关联:
        PlmCuringProcessParameter.java
        PlmCuringProcessParameterController.java
        PlmCuringProcessParameterServiceImpl.java
        PlmCuringProcessParameterServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="plmcuringprocessparameter.js.jsp"%>
<script type="text/javascript" src="dict/-307.js"></script>
<body class="easyui-layout" fit="true"> 
	<div data-options="region:'west',split:true" title="<spring:message code="curingprocess.column.plmlhgycs" />" style="width:60%;">
        <div id="PlmCuringProcessParameter_dg_toolbar">
            <form id="PlmCuringProcessParameter_search_form" class="form" >
                <!-- SAP品号-储胎9位品号 -->
                <spring:message code="plmcuringprocessparameter.column.sapmat" />:&nbsp;
                <input name="filter[sapmat_s]" id="sapmat" type="text" like="true" class="easyui-textbox" data-options="label:'', width:'140px'" >
                <!-- 外胎品号 -->
                <spring:message code="plmcuringprocessparameter.column.sapcover" />:&nbsp;
                <input name="filter[sapcover_s]" id="sapcover" type="text" like="true" class="easyui-textbox" data-options="label:'', width:'140px'" >
                <br/>
                <!-- 工艺路线名称 -->
                <spring:message code="plmcuringprocessparameter.column.process_route" />:&nbsp;
                <input name="filter[process_route_s]" id="process_route" type="text" like="true" class="easyui-textbox" data-options="label:'', width:'140px'" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
	            <form  class="form" id="CuringProcess_search_form2"  method="post">
					<input style="display:none"  name="filter[route_key]" id="route_key" >
				</form>
        </div>
        <table id="plmcuringprocessparameter_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: true,
                toolbar: '#PlmCuringProcessParameter_dg_toolbar',
                url: 'curing/baseData/plmCuringProcessParameter/datagridUDA2',
                striped:true,
                onSelect:selectrow,
                method: 'get',
                emptyMsg: '<span><spring:message code='tip.noData'/></span>' 
                ">
            <thead>
                <tr>
                   <!--  <th data-options="field:'route_key',checkbox:true"></th> -->
                    <!-- 胎胚施工代码 -->
                    <th data-options="field:'pdmmat_s',sortable:true,editor:{type:'textbox'}"><spring:message code="plmcuringprocessparameter.column.pdmmat" /></th>
                    <!-- 外胎品号 -->
                    <th data-options="field:'sapcover_s',sortable:true,editor:{type:'textbox'}"><spring:message code="plmcuringprocessparameter.column.sapcover" /></th>
                    <!-- 胎胚版本号 -->
                    <th data-options="field:'version_s',sortable:true,editor:{type:'textbox'}"><spring:message code="plmcuringprocessparameter.column.version" /></th>
                    <!-- SAP品号-储胎9位品号 -->
                    <th data-options="field:'sapmat_s',sortable:true,editor:{type:'textbox'}"><spring:message code="plmcuringprocessparameter.column.sapmat" /></th>
                    <!-- 产品阶段 试制 01 试产 02 投产03 -->
                    <th data-options="field:'stage_s',formatter:codeFormatter,editor:{type:'textbox',options:{panelWidth:200,required:true,method:'get',
                                url:'dict/code/-307'}} ">产品阶段</th>
                    
                    <!-- 工艺路线名称 -->
                    <th data-options="field:'process_route_s',sortable:true,editor:{type:'textbox'}"><spring:message code="plmcuringprocessparameter.column.process_route" /></th>
                    <!-- 工艺版本号 -->
                    <th data-options="field:'processversion_s',sortable:true,editor:{type:'textbox'}"><spring:message code="plmcuringprocessparameter.column.processversion" /></th>
                    <!-- 分厂  外胎BOM【半钢 G1 全钢 G2】、 胎胚BOM【胎胚一次法 G1 胎胚二次法 G3 全钢 G2】 -->
                    <th data-options="field:'factory_s',sortable:true,editor:{type:'textbox'}"><spring:message code="plmcuringprocessparameter.column.factory" /></th>
                    <!-- 接收时间 -->
                    <th data-options="field:'receive_time_t',sortable:true,editor:{type:'textbox'}"><spring:message code="plmcuringprocessparameter.column.receive_time" /></th>
                    <!-- 失效时间 -->
                    <th data-options="field:'expiredate_t',sortable:true,editor:{type:'textbox'}"><spring:message code="plmcuringprocessparameter.column.expiredate" /></th>
                </tr>
            </thead>
        </table>
    </div>
    <div data-options="region:'center',split:true" title="<spring:message code="curingprocess.column.gycslb" />" style="width:100px;">
 		 <table id="plmcuringprocessparameterlist_dg" class="easyui-datagrid" style="width:50%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:false,
                rownumbers: true,
                singleSelect: true,
                striped:true,
                remoteSort:false,
                method: 'get',
                emptyMsg: '<span><spring:message code='tip.noData'/></span>'  
                ">
            <thead>
                 <tr>
                    <!-- 参数类型  -->
                    <th data-options="field:'parmtypecode_sall',sortable:true"><spring:message code="curingprocess.column.parmtypecode_s" /></th>
                	<!-- 参数名称 -->
                    <th data-options="field:'parmname_s',sortable:true "><spring:message code="curingprocess.column.parmname_s" /></th>
                	<!-- 参数值 -->
                    <th data-options="field:'value_s',sortable:true "><spring:message code="curingprocess.column.value_s" /></th>
                	<!-- 版本号 -->
                    <th data-options="field:'version_s',sortable:true "><spring:message code="curingprocess.column.version_s" /></th>
                	<!-- 接收日期 -->
                    <th data-options="field:'rectime',sortable:true "><spring:message code="curingprocess.column.receive_time_t" /></th>
                    <!-- 参数接收日期 -->
                    <th data-options="field:'receive_time_t',sortable:true "><spring:message code="curingprocess.column.csreceive_time_t" /></th>
                    <!-- 参数索引  -->
                    <th data-options="field:'objectid_s',sortable:true "><spring:message code="curingprocess.column.objectid_s" /></th>
                	<!-- 参数类别代码  -->
                    <th data-options="field:'parmtypecode_s',sortable:true "><spring:message code="curingprocess.column.parmtypecode_s" /></th>
                	<!-- 参数类别名称 -->
                    <th data-options="field:'parmtypename_s',sortable:true "><spring:message code="curingprocess.column.parmtypename_s" /></th>
                    <!-- 参数代码 -->
                    <th data-options="field:'parmcode_s',sortable:true "><spring:message code="curingprocess.column.parmcode_s" /></th>
                </tr>
            </thead>
        </table>
        </div>
</body>
</html>
