<!--

作者 :时永良
时间 :2020年2月24日13:20:57
页面名称:X光检测信息查询
文件关联:
CheckXrayResult.java
QueryCheckXrayResultController.java
QueryCheckXrayResultServiceImpl.java
QueryCheckXrayResultServiceImpl.xml
-->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="../../../../inc/meta.jsp" %>
<%@ include file="querycheckxrayresult.js.jsp" %>
<script type="text/javascript" src="dict/253,302.js"></script>
<body class="easyui-layout" fit="true">
<div data-options="region:'center',split:true,border:false">
    <div id="CheckXrayResult_dg_toolbar">
        <form id="CheckXrayResult_search_form" class="form">
            <!-- 检测时间开始 -->
            <spring:message code="checkxrayresult.column.checktime_s"/>: <input name="filter[checktime_start]"
                                                                                id="checktime_start" type="text"
                                                                                class="easyui-textbox" data-options="">
                              到 <input name="filter[checktime_end]"
                                                                                id="checktime_end" type="text"
                                                                                class="easyui-textbox" data-options="">
            <!-- 轮条码号 -->
            <spring:message code="checkxrayresult.column.tyrebarcode_s"/>: <input name="filter[tyrebarcode_s]"
                                                                                  id="tyrebarcode_s" type="text"
                                                                                  class="easyui-textbox"
                                                                                  data-options="">
            <!-- X光机台 --> <spring:message code="checkxrayresult.column.equipid_s" />:
						<input type="text" class="easyui-combobox" style="width:120px" name="filter[machinebar_s]" id="machinebar_s" style="width:120px"
							data-options="  label:'',
							required:false, 
	                		width:200,
	                		data:entCodeName,
				   			method: 'get',
				   			url:'finalcheck/baseData/entmodel/SearchEnt?equip_type=254003',
				   			panelHeight:200,
				    		valueField:'EQUIP_NAME',
				    		textField:'DESCRIPTION'
				    		">    
		     <!-- 检测级别 -->
			 <spring:message code="dynabalancecheresult.column.tire_total_ratings_s" />:
			 <input name="filter[gradeid_s]" id="gradeid_s"  style="width:110px;" type="text" class="easyui-combotree" data-options="label:'',
									                  labelWidth:'auto',
													  panelHeight:150,
													  required:false,
													  url:'dict/code/253',
													  method:'get'"> 	    		                                                                 
            <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'"
               onclick="filter()"><spring:message code="button.search"/></a>
            <auth:button code="ZJ_ZJLL_QUAN_GANG_XRAYCHECK_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'"
                                       onclick="$_export()"><spring:message code="button.export"/></a></auth:button>
            <auth:button code="productionDetail">
				<a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-log'" onclick="openXgpic()">
					 <spring:message code="button.serrchXray" />
				</a>
			</auth:button>
        </form>
    </div>
    <table id="checkxrayresult_dg" class="easyui-datagrid" style="width:100%"
           data-options="
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#CheckXrayResult_dg_toolbar',
                url: '',
                striped:true,
                method: 'get',
                emptyMsg: '<span><spring:message code='tip.noData'/></span>' 
                ">
        <thead>
        <tr>
            <th data-options="field:'atr_key',checkbox:true">ID</th>
            <!-- 条码号 -->
            <th data-options="width:'20%',field:'tyrebarcode_s',editor:{type:'textbox'}"><spring:message
                    code="checkxrayresult.column.tyrebarcode_s"/></th>
            <!-- 品号 -->
            <th data-options="width:'20%',field:'materialcode_s',editor:{type:'textbox'}"><spring:message
                    code="checkxrayresult.column.materialcode_s"/></th>
            <!-- 规格描述 -->
            <th data-options="width:'20%',field:'description',editor:{type:'textbox'}"><spring:message
                    code="checkxrayresult.column.description"/></th>
                    <!-- 重量 -->
            <th data-options="width:'20%',field:'weight_s',editor:{type:'textbox'}"><spring:message
                    code="checkxrayresult.column.weight_s"/></th>
            <!-- X光图片名称 -->
            <th data-options="width:'15%',field:'imagename_s',editor:{type:'textbox'}"><spring:message
                    code="checkxrayresult.column.imagename_s"/></th>
            <!-- 检测设备 -->
            <th data-options="width:'15%',field:'equipid_s',editor:{type:'textbox'}"><spring:message
                    code="checkxrayresult.column.equipid_s"/></th>
            <!-- 检查次数 -->
            <th data-options="width:'10%',field:'checkseq_i',editor:{type:'textbox'}"><spring:message
                    code="checkxrayresult.column.checkseq_i"/></th>
            <!-- 检测等级 -->
            <th formatter="codeFormatter" data-options="width:'10%',field:'gradeid_s',editor:{type:'textbox'}"><spring:message
                    code="checkxrayresult.column.gradeid_s"/></th>
            <!-- 病象描述 -->
            <th  data-options="width:'10%',field:'defectid_s',formatter:defec,editor:{type:'textbox'}"><spring:message
                    code="checkxrayresult.column.defectid_s"/></th>
            <!-- 检测人员ID -->
            <th data-options="width:'10%',field:'username',editor:{type:'textbox'}"><spring:message
                    code="checkxrayresult.column.userid_s"/></th>
            <!-- 检测时间 -->
            <th data-options="width:'25%',field:'checktime',editor:{type:'textbox'}"><spring:message
                    code="checkxrayresult.column.checktime_s"/></th>
            <!-- 硫化机台 -->
            <th data-options="width:'25%',field:'curing_equipid',editor:{type:'textbox'}"><spring:message
                    code="checkxrayresult.column.curing_equipid"/></th> 
            <!-- 硫化时间 -->
            <th data-options="width:'25%',field:'curing_time',editor:{type:'textbox'}"><spring:message
                    code="checkxrayresult.column.curing_time"/></th> 
            <!-- 硫化工人 -->
            <th data-options="width:'25%',field:'curing_worker',editor:{type:'textbox'}"><spring:message
                    code="checkxrayresult.column.curing_worker"/></th> 
            <!-- 成型机台 -->
            <th data-options="width:'25%',field:'building_equipid',editor:{type:'textbox'}"><spring:message
                    code="checkxrayresult.column.building_equipid"/></th> 
            <!-- 成型时间 -->
            <th data-options="width:'25%',field:'building_time',editor:{type:'textbox'}"><spring:message
                    code="checkxrayresult.column.building_time"/></th> 
            <!-- 成型工人 -->
            <th data-options="width:'25%',field:'building_workers',editor:{type:'textbox'}"><spring:message
                    code="checkxrayresult.column.building_workers"/></th> 
        </tr>
        </thead>
    </table>

</div>

<div id="xgtp" class="easyui-window"   maximized="true"  style="width:1200px;height:700px" closed="true">

</div>
    
<jsp:include page="../../../../inc/export.jsp">
    <jsp:param name="idField" value="atr_key"/>
    <jsp:param name="formId" value="CheckXrayResult_search_form"/>
    <jsp:param name="datagridId" value="checkxrayresult_dg"/>
    <jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.finalcheck.excel.QueryCheckXrayResultExportHandler"/>
    <jsp:param name="serviceName" value="QueryCheckXrayResultServiceImpl"/>
</jsp:include>
</body>
</html>
