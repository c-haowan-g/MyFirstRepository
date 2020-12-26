<!-- 

    作者      :周清玉	
    时间      :2019-08-13 15:28:51 
    页面名称:成品质量检查原始记录报表
    文件关联:
        VisualmCheckSumPrint.java
        VisualmCheckSumPrintController.java
        VisualmCheckSumPrintServiceImpl.java
        VisualmCheckSumPrintServiceImpl.xml
        VisualmCheckSumPrintExportHandler.java
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="visualmcheckdetialprint.js.jsp"%>
<script type="text/javascript" src="dict/253.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="visualmcheckdetialprint_dg_toolbar">
            <form id="visualmcheckdetialprint_search_form" class="form" >
				<!-- 外检操作时间 -->
				<spring:message code="visualmchecksumprint.column.visualpasstime_t_wt" />:
				<input name="filter[begin_created_time_visual]" editable="true" id="begin_created_time_visual" type="text" class="easyui-datetimebox" style="width:170px" data-options="label:''"> 到 <input
					name="filter[end_created_time_visual]" editable="true" id="end_created_time_visual" class="easyui-datetimebox" style="width:170px">
				<!-- 外观病象名称 -->			
                <spring:message code="visualmchecksumprint.column.reasdesc_wt" />:
                <input name="filter[wgreascode_s]" id="wgreascode_s" style="width:15%" class="easyui-combotree" type="text" data-options="label:'',
                			labelWidth:'auto',
                            panelHeight:'auto'" >
                <!-- X光病象名称 -->
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="visualmchecksumprint.column.xrayreascode_s" />:
                <input name="filter[xrayreascode_s]" id="xrayreascode_s" style="width:15%" class="easyui-combotree" type="text" data-options="label:'',
                			labelWidth:'auto',
                            panelHeight:'auto'" >
				<br/>
				<!-- 成型操作时间 -->
				<spring:message code="visualmchecksumprint.column.buildingtime_t" />:
				<input name="filter[begin_created_time_building]" editable="true" id="begin_created_time_building" type="text" class="easyui-datetimebox" style="width:170px" data-options="label:''"> 到 <input
					name="filter[end_created_time_building]" editable="true" id="end_created_time_building" class="easyui-datetimebox" style="width:170px">
				<!-- 外胎质量等级 -->
                <spring:message code="visualmchecksumprint.column.visualgradecode_s_wt" />:
                <input name="filter[atpresentgradecode_s]" id="atpresentgradecode_s" style="width:15%"  type="text" class="easyui-combotree" data-options="label:'',
				  			labelWidth:'auto',
                            panelHeight:'auto',
                            editable:true,
                            required:false,
                            data:DICT_253,
                            valueField:'code',
                            textField:'text'" >	
                <!-- 物料编码 -->
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="visualmchecksumprint.column.materialcode_s" />:
                <input name="filter[materialcode_s]" id="materialcode_s" style="width:15%" class="easyui-textbox" data-options="label:''" >
				<br/>
				<!-- 硫化时间 -->
                <spring:message code="visualmchecksumprint.column.curingopenmouldtime_t" />:
				<input name="filter[begin_created_time_curing]" editable="true" id="begin_created_time_curing" type="text" class="easyui-datetimebox" style="width:170px" data-options="label:''"> 到 <input
					name="filter[end_created_time_curing]" editable="true" id="end_created_time_curing" class="easyui-datetimebox" style="width:170px">
				<!-- 轮胎条码 -->
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="visualmchecksumprint.column.barcode_s" />:
                <input name="filter[barcode_s]" id="barcode_s" style="width:15%" class="easyui-textbox" data-options="label:''" >	
               	<br/>
               	
               	
               	<!-- 外观改判时间 -->
				<spring:message code="visualmchecksumprint.column.changetime" />:
				<input name="filter[begin_created_time_rev]" editable="true" id="begin_created_time_rev" type="text" class="easyui-datetimebox" style="width:170px" data-options="label:''"> 到 <input
					name="filter[end_created_time_rev]" editable="true" id="end_created_time_rev" class="easyui-datetimebox" style="width:170px">
					
					
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
                <auth:button code="ZJ_BBZX_CPZLJCRBB_EXPORT">
                <a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a>
                </auth:button>
            </form> 
        </div>
        <table id="visualmcheckdetialprint_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#visualmcheckdetialprint_dg_toolbar',
                url: '',
                striped:true,
                method: 'get',
                emptyMsg:'暂无数据' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'materialcode_s',editor:{type:'textbox'}"><spring:message code="visualmchecksumprint.column.materialcode_s" /></th>
                    <!-- 规格/花纹 -->
                    <th data-options="field:'materialspec_s',editor:{type:'textbox'}"><spring:message code="visualmchecksumprint.column.materialspec_s" /></th>
                    <!-- 轮胎条码：MainTyre.BARCODE -->
                    <th data-options="field:'barcode_s',editor:{type:'textbox'}"><spring:message code="visualmchecksumprint.column.barcode_s" /></th>
                    <!-- 成型机台 -->
                    <th data-options="field:'buildinmachinecode_s',editor:{type:'textbox'}"><spring:message code="visualmchecksumprint.column.buildinmachinecode_s" /></th>
                    <!-- 成型作业ID -->
                    <th data-options="field:'buildingtaskname_s',editor:{type:'textbox'}"><spring:message code="visualmchecksumprint.column.buildingtaskid_s" /></th>
                    <!-- 成型操作时间 -->
                    <th data-options="field:'buildingtime_t',editor:{type:'textbox'}"><spring:message code="visualmchecksumprint.column.buildingtime_t" /></th>
                    <!-- 硫化机台 -->
                    <th data-options="field:'curingmachinecode_s',editor:{type:'textbox'}"><spring:message code="visualmchecksumprint.column.curingmachinecode_s" /></th>
                    <!-- 硫化操作工 -->
                    <th data-options="field:'curingusername_s',editor:{type:'textbox'}"><spring:message code="visualmchecksumprint.column.curinguserid_s" /></th>
                    <!-- 硫化质量等级 -->
  					<th data-options="field:'curinggradecode_s',formatter:codeFormatter"><spring:message code="visualmchecksumprint.column.curinggradecode_s" /></th>
  					<!-- 硫化时间 -->
                    <th data-options="field:'curingopenmouldtime_t',editor:{type:'textbox'}"><spring:message code="visualmchecksumprint.column.curingopenmouldtime_t" /></th>
  					<!-- 外检操作工 -->
                    <th data-options="field:'visualusername_s',editor:{type:'textbox'}"><spring:message code="visualmchecksumprint.column.visualuserid1_s" /></th>
  					<!-- 外检操作工 -->
                    <th data-options="field:'visualmbarcode1_s',editor:{type:'textbox'}"><spring:message code="visualmchecksumprint.column.visualmbarcode1_s" /></th>
                    <!-- 外检操作时间 -->
                    <th data-options="field:'visualpasstime_t'"><spring:message code="visualmchecksumprint.column.visualpasstime_t" /></th>
                    
                    <!-- 外观改判时间-->
                    <th data-options="field:'appearancejudge_time_t'"><spring:message code="visualmchecksumprint.column.appearancejudge_time_t" /></th>
                    
                    <!-- 外检质量等级 -->
                    <th data-options="field:'visualgradecode_s',formatter:codeFormatter"><spring:message code="visualmchecksumprint.column.visualgradecode_s" /></th>
                    <!-- 外检病象 -->
                    <th data-options="field:'visualreascode_s',formatter:reasformatter,editor:{type:'textbox'}"><spring:message code="visualmchecksumprint.column.reasdesc" /></th>
                    <!-- X光机台 -->
                    <th data-options="field:'xraycode_s'"><spring:message code="visualmchecksumprint.column.xraycode_s" /></th>
                    <!-- X光操作人员 -->
                    <th data-options="field:'xrayname_s'"><spring:message code="visualmchecksumprint.column.xrayname_s" /></th>
                    <!-- X光操作时间 -->
                    <th data-options="field:'xraytime_t'"><spring:message code="visualmchecksumprint.column.xraytime_t" /></th>
                    <!-- X光质量等级 -->
                    <th data-options="field:'xraygradecode_s',formatter:codeFormatter"><spring:message code="visualmchecksumprint.column.xraygradecode_s" /></th>
                    <!-- X光病象 -->        
                    <th data-options="field:'xrayreascode_s',formatter:reasformatter,editor:{type:'textbox'}"><spring:message code="visualmchecksumprint.column.xrayreascode_s" /></th>
                    <!-- 动平衡机台 -->
                    <th data-options="field:'dynamicbalancecode_s'"><spring:message code="visualmchecksumprint.column.dynamicbalancecode_s" /></th>
                    <!-- 动平衡操作时间 -->
                    <th data-options="field:'dynamicbalancetime_t'"><spring:message code="visualmchecksumprint.column.dynamicbalancetime_t" /></th>
                    <!-- 动平衡质量等级 -->
                    <th data-options="field:'dynamicbalancegradecode_s',formatter:codeFormatter"><spring:message code="visualmchecksumprint.column.dynamicbalancegradecode_s" /></th>
                    <!-- 动平衡病象 -->             
<!--                <th data-options="field:'dynamicbalancereascode_s',formatter:reasformatter,editor:{type:'textbox'}"><spring:message code="visualmchecksumprint.column.dynamicbalancereascode_s" /></th> -->
            </thead>
        </table>
    </div>
    <!-- 	导出-->    
	<jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="visualmcheckdetialprint_search_form" />
		<jsp:param name="datagridId" value="visualmcheckdetialprint_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.finalcheck.excel.VisualmCheckSumPrintExportHandler" />
		<jsp:param name="serviceName" value="VisualmCheckSumPrintServiceImpl" />
	</jsp:include>
    
    
</body>
</html>
