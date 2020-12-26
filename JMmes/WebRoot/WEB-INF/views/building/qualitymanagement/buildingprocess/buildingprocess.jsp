<!-- 

    作者      :周清玉 
    时间      :2019-08-14 08:40:14 
    页面名称:成型工艺参数配方查询
    文件关联:
        BuilDingProcess.java
        BuilDingProcessController.java
        BuilDingProcessServiceImpl.java
        BuilDingProcessServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="buildingprocess.js.jsp"%>
<script type="text/javascript" src="dict/-307,-319.js"></script>
<body class="easyui-layout" fit="true"> 


    <div data-options="region:'west',split:true" style="width:55%;" title="<spring:message code="buildingprocess.column.cxgycs" />">
        <div id="BuilDingProcess_dg_toolbar">
            <form id="BuilDingProcess_search_form" class="form" >
				<!-- PDM物料编码 -->
				<spring:message code="buildingprocess.column.pdmmat_s" />:
                <input name="filter[pdmmat_s]"  like="true"  id="pdmmat_s" type="text" class="easyui-textbox" data-options="label:''" >
				<!-- SAP品号 -->
				<spring:message code="buildingprocess.column.sapmat_s" />:
				<input name="filter[sapmat_s]"  like="true"  id="sapmat_s" type="text" class="easyui-textbox" data-options="label:''" >
				
				<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
        </div>
        <table id="buildingprocess_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: true,
                toolbar: '#BuilDingProcess_dg_toolbar',
                url: 'building/quailtyManageMent/buildingProcess/datagrid',
                onSelect:selectrow,
                striped:true,
                method: 'get',
                emptyMsg:'<span><spring:message code='tip.noData'/></span>' 
                ">
            <thead>
                <tr>
                	<!-- PDM物料编码 -->
                    <th data-options="field:'pdmmat_s' ,width:80,editor:{type:'textbox'}"><spring:message code="buildingprocess.column.pdmmat_s" /></th>
                	<!-- SAP品号 -->
                    <th data-options="field:'sapmat_s' ,width:80,editor:{type:'textbox'}"><spring:message code="buildingprocess.column.sapmat_s" /></th>
                    <!-- 产品阶段 试制 01 试产 02 投产03 -->
                    <th data-options="field:'stage_s',width:55,formatter:codeFormatter,editor:{type:'textbox',options:{panelWidth:200,required:true,method:'get',
                                url:'dict/code/-307'}} "><spring:message code="curingprocess.column.stage_s" /></th>
                	<!-- 版本号 -->
                    <th data-options="field:'version_s' ,width:60,editor:{type:'textbox'}"><spring:message code="buildingprocess.column.version_s" /></th>
                    <!-- 设备类型代码 -->
                    <th data-options="field:'equipmenttypecode_s',formatter:codeFormatter,width:130,editor:{type:'textbox'}"><spring:message code="buildingprocess.column.equipmenttypecode_s" /></th>
                    <!-- 设备类型代码 22-全钢一次法成型机 23-半钢VMI一次法成型机 25-半钢二次法成型机 -->
                    <th data-options="field:'equipmentcode_s',formatter:equipFormatter,width:220,editor:{type:'textbox'}"><spring:message code="buildingprocess.column.equipmentcode_s" /></th>
                    <!-- 工厂 -->
                    <th data-options="field:'factory_s' ,width:30,editor:{type:'textbox'}"><spring:message code="buildingprocess.column.factory_s" /></th>
                    <!-- 分厂 柳州 8003 -->
                    <th data-options="field:'werks_s' ,width:40"><spring:message code="curingprocess.column.werks_s" /></th>
                  	<!-- 生效时间 -->
                    <th data-options="field:'receive_time_t' ,width:130"><spring:message code="curingprocess.column.receive_time_t" /></th>
                	<!-- 失效时间 -->
                    <th data-options="field:'expiredate_t' ,width:80"><spring:message code="curingprocess.column.expireddate_s" /></th>
                     <%-- <!-- 记录标志，A可用，D删除 -->
                    <th data-options="field:'record_flag_s',formatter:flag"><spring:message code="curingprocess.column.record_flag_s" /></th> --%>
                    
                </tr>
            </thead>
        </table>
    </div>
    
    	<div data-options="region:'center',split:true" title="<spring:message code="curingprocess.column.gycslb" />" style="width:100px;">
 		 <table id="buildingprocess_dg2" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                singleSelect: false,
                striped:true,
                remoteSort:false,
                method: 'get',
                emptyMsg:'<span><spring:message code='tip.noData'/></span>'  
                ">
            <thead>
                <tr>
                	<!-- 参数类别名称 -->
                    <th data-options="field:'PARMTYPENAME_S',sortable:true,editor:{type:'textbox'}"><spring:message code="curingprocess.column.parmtypecode_s" /></th>
                	<!-- 参数名称 -->
                    <th data-options="field:'PARMNAME_S',sortable:true,editor:{type:'textbox'}"><spring:message code="curingprocess.column.parmname_s" /></th>
                    <!-- 参数值 -->
                    <th data-options="field:'VALUE_S',sortable:true,editor:{type:'textbox'},formatter:colorMarkingLineFormatter"><spring:message code="curingprocess.column.value_s" /></th>
                    <!-- 胎胚版本号 -->
                    <th data-options="field:'VERSION_S',sortable:true,editor:{type:'textbox'}"><spring:message code="curingprocess.column.version_s" /></th>
                    <!-- 接收日期 -->
                    <th data-options="field:'RECTIME',sortable:true "><spring:message code="curingprocess.column.receive_time_t" /></th>
                    <!-- 参数接收日期 -->
                    <th data-options="field:'RECEIVE_TIME_T',sortable:true "><spring:message code="curingprocess.column.csreceive_time_t" /></th>
                	<!-- 参数索引 -->
                    <th data-options="field:'PARMCODE_S',sortable:true,editor:{type:'textbox'}"><spring:message code="curingprocess.column.objectid_s" /></th>
                	<!-- 参数类别代码  -->
                    <th data-options="field:'PARMTYPECODE_S',sortable:true,editor:{type:'textbox'}"><spring:message code="curingprocess.column.dm_code" /></th>
                    <!-- 参数最大值 -->
                    <th data-options="field:'VALUEMAX_S'  "><spring:message code="curingprocess.column.valuemax_s" /></th>
                    <!-- 参数最小值 -->
                    <th data-options="field:'VALUEMIN_S' "><spring:message code="curingprocess.column.valuemin_s" /></th> 
                </tr>
            </thead>
        </table>
 	</div>
    
</body>
</html>
