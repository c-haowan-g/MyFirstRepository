<!-- 

    作者      :时永良
    时间      :2018-10-18 08:58:27 
    页面名称:PLM成型工艺表日志
    文件关联:
        Buildingproc_log.java
        Buildingproc_logController.java
        Buildingproc_logServiceImpl.java
        Buildingproc_logServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/meta.jsp"%>
<%@ include file="buildingproc_log.js.jsp"%>
<script type="text/javascript" src="dict/-307.js"></script>

<body class="easyui-layout" fit="true"> 


    <div data-options="region:'west',split:true" style="width:50%;" title="<spring:message code="buildingprocess.column.cxgycs" />">
        <div id="BuilDingProcess_dg_toolbar">
            <form id="BuilDingProcess_search_form" class="form" >
                 <table class="formTable">
					<tr>
						<td class="columnTitle">
							<!-- SAP品号 -->
							<spring:message code="buildingprocess.column.sapmat_s" />:
						</td>
						<td class="columnData">
							<input name="filter[sapmat_s]"  like="true"  id="sapmat_s" type="text" class="easyui-textbox" data-options="label:''" >
						</td>
						<%-- <td class="columnTitle">
							<!--是否有效  -->
             				<spring:message code="curingprocess.column.record_flag_s" />
						</td>
						<td class="columnData">
							<input name="filter[record_flag_s]" id="record_flag_s" type="text" class="easyui-combobox" style="width:185px" data-options="label:'',
                                        required:false, 
                                       	 data: [{
											text: '是',
											value: 'A'
										},{
											text: '否',
											value: 'D'
										}],
			                             method: 'get'"> 
						</td> --%>
						<td class="columnTitle">
						 	<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
						</td>
					</tr>
           	   </table>
            </form> 
        </div>
        <table id="buildingprocess_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: true,
                toolbar: '#BuilDingProcess_dg_toolbar',
                url: 'common/BuildingprocessLog/buildingprocesslog/datagrid',
                onSelect:selectrow,
                striped:true,
                method: 'get',
                 emptyMsg: '<span><spring:message code='tip.noData'/></span>' 
                 ">
            <thead>
                <tr>
                	 <!-- PDM物料编码 -->
                    <th data-options="field:'pdmmat_s' ,editor:{type:'textbox'}"><spring:message code="buildingprocess.column.pdmmat_s" /></th>
                	 <!-- SAP品号 -->
                    <th data-options="field:'sapmat_s' ,editor:{type:'textbox'}"><spring:message code="buildingprocess.column.sapmat_s" /></th>
                    <!-- 产品阶段 试制 01 试产 02 投产03 -->
                    <th data-options="field:'stage_s',formatter:codeFormatter,editor:{type:'textbox',options:{panelWidth:200,required:true,method:'get',
                                url:'dict/code/-307'}} "><spring:message code="curingprocess.column.stage_s" /></th>
                	 <!-- 版本号 -->
                    <th data-options="field:'version_s' ,editor:{type:'textbox'}"><spring:message code="buildingprocess.column.version_s" /></th>
                     <!-- 工厂 -->
                    <th data-options="field:'factory_s' ,editor:{type:'textbox'}"><spring:message code="buildingprocess.column.factory_s" /></th>
                    <!-- 分厂 柳州 8003 -->
                    <th data-options="field:'werks_s' "><spring:message code="curingprocess.column.werks_s" /></th>
                   <!-- 生效时间 -->
                    <th data-options="field:'receive_time_t' "><spring:message code="curingprocess.column.receive_time_t" /></th>
                	<!-- 失效时间 -->
                    <th data-options="field:'expireddate' "><spring:message code="curingprocess.column.expireddate_s" /></th>
                    <%--  <!-- 记录标志，A可用，D删除 -->
                    <th data-options="field:'record_flag_s',formatter:flag"><spring:message code="curingprocess.column.record_flag_s" /></th>
 --%>                    
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
                 emptyMsg: '<span><spring:message code='tip.noData'/></span>'  
                ">
            <thead>
                <tr>
                	<!-- 参数类别名称 -->
                    <th data-options="field:'PARMTYPENAME_S',sortable:true,editor:{type:'textbox'}"><spring:message code="curingprocess.column.parmtypecode_s" /></th>
                	 <!-- 参数名称 -->
                    <th data-options="field:'PARMNAME_S',sortable:true,editor:{type:'textbox'}"><spring:message code="curingprocess.column.parmname_s" /></th>
                    	<!-- 参数值 -->
                    <th data-options="field:'VALUE_S',sortable:true,editor:{type:'textbox'}"><spring:message code="curingprocess.column.value_s" /></th>
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
                    <th data-options="field:'valuemax_s'  "><spring:message code="curingprocess.column.valuemax_s" /></th>
                    <!-- 参数最小值 -->
                    <th data-options="field:'valuemin_s' "><spring:message code="curingprocess.column.valuemin_s" /></th>
                    <!-- 参数最大值操作符 -->
                    <th data-options="field:'valuemaxsign_s',formatter:valuemax "><spring:message code="curingprocess.column.valuemaxsign_s" /></th>
                    <!-- 参数最小值操作符 -->
                    <th data-options="field:'valueminsign_s' "><spring:message code="curingprocess.column.valueminsign_s" /></th>
                </tr>
            </thead>
        </table>
 	</div>
    
</body>
</html>
