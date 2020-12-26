<!-- 

    作者      :李德晓
    时间      :2020-03-17 16:05:04 
    页面名称:半部件产出实绩
    文件关联:
        HalfpartMachineOutputSearch.java
        HalfpartMachineOutputSearchController.java
        HalfpartMachineOutputSearchServiceImpl.java
        HalfpartMachineOutputSearchServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="halfpartmachineoutputsearch.js.jsp"%>
<script type="text/javascript" src="dict/105,177,302,253.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="HalfpartMachineOutputSearch_dg_toolbar">
            <form id="HalfpartMachineOutputSearch_search_form" class="form" >
                <!-- 机台名称-->
                <spring:message code="halfpartmachineoutput.column.machinename_s" />:
                <input name="filter[machinename_s]" id="machinename_s" style="width:150px" type="text" class="easyui-combobox" 
                  data-options="label:'',
                 
                        labelWidth:'auto',
                        panelHeight:200,
                        editable:true,
                        required:false,
                        data:productLineList,
                        valueField:'DESCRIPTION',
          			    textField:'DESCRIPTION',
                        method:'get'"
                       >
                   <!-- 日计划工单号 -->
                <spring:message code="halfpartmachineoutput.column.planno_s" />:
                <input name="filter[planno_s]" id="planno_s" type="text" style="width:150px" class="easyui-textbox" data-options="label:''" >
                <!-- 批次条码 -->
                <spring:message code="halfpartmachineoutput.column.barcode_s" />:
                <input name="filter[barcode_s]" id="barcode_s" type="text" style="width:150px" class="easyui-textbox" data-options="label:''" >
                <!-- 规格 -->
                <spring:message code="halfpartmachineoutput.column.materspec_s" />:
                <input name="filter[materspec_s]" id="materspec_s" type="text" style="width:150px" class="easyui-combobox" 
                data-options="label:'',
                         url:' halfpart/baseData/halfpartMachineOutput/searchMaterspec_s',
                        labelWidth:'auto',
                        panelHeight:200,
                        editable:true,
                        required:false,
                        valueField:'MATERIALDESC_S',
          			    textField:'MATERIALDESC_S',
                        method:'get'
                " >
               <br>
                 <!-- 物料编码 -->
                <spring:message code="halfpartmachineoutput.column.materialcode_s" />:
                <input name="filter[materialcode_s]" id="materialcode_s" style="width:150px" type="text" class="easyui-combobox" 
                data-options="label:'',
               
                        url:' halfpart/baseData/halfpartMachineOutput/searchMaterspec_s',
                        labelWidth:'auto',
                        panelHeight:200,
                        editable:true,
                        required:false,
                        valueField:'MATERIALCODE_S',
          			    textField:'MATERIALCODE_S',
                        method:'get'"
                 >
                 
                <!-- 载具条码 -->
                <spring:message code="halfpartmachineoutput.column.vehicles_code_s" />:
                <input name="filter[vehicles_code_s]" id="vehicles_code_s" type="text" style="width:150px" class="easyui-textbox" data-options="label:''" >
               <!-- 产出标记 -->
                 <spring:message code="productoutputsearch.column.outflag_s" />:
                <input name="filter[outflag_s]" id="outflag_s" type="text" class="easyui-combotree" data-options="label:'',
                required:false,
	                editable:true,
          			panelHeight:200,
          			url:'dict/code/105',
          			method:'get'
                " ><br>
                 
                <!-- 产出时间 -->
                 <spring:message code="storagearea.column.outputtime_t" />:
                <input name="filter[start_time]" type="text" style="width:150px" editable="true" id="start_time" class="easyui-datetimebox"  data-options="label:''">
				 &nbsp;
				 到
				 &nbsp;
                 <input name="filter[end_time]" editable="true" id="end_time" 
							type="text" class="easyui-datetimebox" style="width:150px"
							data-options="label:''">
				
                
            </form> 
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
                <auth:button code="halfpartMachineOutputSearchs_export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
                <auth:button code="halfpartMachineOutputSearchs_hide"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="showOrHide()"><spring:message code="button.searchColumn" /></a></auth:button>
        </div>
        <table id="halfpartmachineoutputsearch_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#HalfpartMachineOutputSearch_dg_toolbar',
                
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'',checkbox:true">ID</th>
                    <!-- 载具条码(工字轮) -->
                    <th data-options="field:'vehicles_code_s',editor:{type:'textbox'}"><spring:message code="halfpartmachineoutput.column.vehicles_code_s" /></th>
                    <!-- 产出批次条码 -->
                    <th data-options="field:'barcode_s',editor:{type:'textbox'}"><spring:message code="halfpartmachineoutput.column.barcode_s" /></th>
                    <!-- 日计划号-工单号 -->
                    <th data-options="field:'planno_s',editor:{type:'textbox'}"><spring:message code="halfpartmachineoutput.column.planno_s" /></th>
                    <!-- 机台条码 -->
                    <th data-options="field:'machinecode_s',editor:{type:'textbox'}"><spring:message code="halfpartmachineoutput.column.machinecode_s" /></th>
                    <!-- 机台名称 -->
                    <th data-options="field:'machinename_s',editor:{type:'textbox'}"><spring:message code="halfpartmachineoutput.column.machinename_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'materialcode_s',editor:{type:'textbox'}"><spring:message code="halfpartmachineoutput.column.materialcode_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'materialname_s',editor:{type:'textbox'}"><spring:message code="halfpartmachineoutput.column.materialname_s" /></th>
                    <!-- 物料名称 (中文)-->
                    <th data-options="field:'spare9_s',editor:{type:'textbox'}"><spring:message code="halfpartmachineoutput.column.materialname_s_c" /></th>
                    
                    <!-- 产出口 -->
                    <th data-options="field:'exportcode_s',editor:{type:'textbox'}"><spring:message code="halfpartmachineoutput.column.exportcode_s" /></th>
                    <!-- 产出时间 -->
                    <th data-options="field:'outputtime_t',editor:{type:'textbox'}"><spring:message code="storagearea.column.outputtime_t" /></th>
                    <!-- 产出班次 -->
                    <th data-options="field:'outclass_s',formatter:outclassFormatter,width:120,editor:{type:'combobox',options:{
                    				 required:true,
								     editable:false,
								     data:[
								     {'value':'118001','text':'早班'},
								     {'value':'118002','text':'中班'},
								     {'value':'118003','text':'晚班'}
								     ],
								     valueField:'value',
								     textField:'text'}}"><spring:message code="halfpartmachineoutput.column.outclass_s" /></th>
                    <!-- 产出存储标记 0服务端 1客户端 -->
                    <th data-options="field:'outputflag_s',formatter:outputflagFormatter,width:120,editor:{type:'combobox',options:{
                    				 required:true,
								     editable:false,
								     data:[
								     {'value':'0','text':'服务端'},
								     {'value':'1','text':'客户端'}],
								     valueField:'value',
								     textField:'text'}}"><spring:message code="productoutputsearch.column.outputflag_s" /></th>
                    <!-- 产出量（重量，数量，长度） -->
                    <th data-options="field:'outnum_f',editor:{type:'textbox'}"><spring:message code="output.column.outnum_f" /></th>
                    <!-- 主手操作工 -->
                    <th data-options="field:'operator1_s',formatter:operatorFormatter,sortable:true,editor:{type:'textbox',options:{
                    					valueField:'USERCODE',
				            			textField:'USERNAME',
                                        required:true, 
										data:basetypesList,
										method: 'get',
									    editable:'true',
									    limitToList:false,
									    panelHeight:200,
										}}"><spring:message code="halfpartmachineoutput.column.operator1_s" /></th>
                    <!-- 副手 -->
                    <th data-options="field:'assistantone_s',formatter:operatorFormatter,sortable:true,editor:{type:'textbox',options:{
                    					valueField:'USERCODE',
				            			textField:'USERNAME',
                                        required:true, 
										data:basetypesList,
										method: 'get',
									    editable:'true',
									    limitToList:false,
									    panelHeight:200,
										}}"><spring:message code="halfpartmachineoutput.column.assistantone_s" /></th>
                    <!-- 卷曲工主手 -->
                    <th data-options="field:'curlyworker_s',formatter:operatorFormatter,sortable:true,editor:{type:'textbox',options:{
                    					valueField:'USERCODE',
				            			textField:'USERNAME',
                                        required:true, 
										data:basetypesList,
										method: 'get',
									    editable:'true',
									    limitToList:false,
									    panelHeight:200,
										}}"><spring:message code="halfpartmachineoutput.column.curlyworker_s" /></th>
                    <!-- 卷曲工 副手 -->
                    <th data-options="field:'curlyassistone_s',formatter:operatorFormatter,sortable:true,editor:{type:'textbox',options:{
                    					valueField:'USERCODE',
				            			textField:'USERNAME',
                                        required:true, 
										data:basetypesList,
										method: 'get',
									    editable:'true',
									    limitToList:false,
									    panelHeight:200,
										}}"><spring:message code="halfpartmachineoutput.column.curlyassistone_s" /></th>
                    <!-- 产出标记  -->
                    <th data-options="field:'outflag_s',formatter:outflagFormatter,width:120,editor:{type:'combobox',options:{
                    				 required:true,
								     editable:false,
								     data:[
								     {'value':'105001','text':'正常产出'},
								     {'value':'105002','text':'补产出'},
								     {'value':'105003','text':'取消产出'}
								     ],
								     valueField:'value',
								     textField:'text'}}"><spring:message code="productoutputsearch.column.outflag_s" /></th>
                    <!-- 固化标识  -->
                    <th data-options="field:'solidifyflag_s',formatter:solidifyflagFormatter,width:120,editor:{type:'combobox',options:{
                    				 required:true,
								     editable:false,
								     data:[
								     {'value':'0','text':'未固化'},
								     {'value':'1','text':'已固化'}],
								     valueField:'value',
								     textField:'text'}}"><spring:message code="halfpartmachineoutput.column.solidifyflag_s" /></th>
					<!-- 有效期 -->
                    <th data-options="field:'valuetime',formatter:valuetimeFormatter,editor:{type:'textbox'}"><spring:message code="tyredelay.column.validtime_s" /></th>
					
                </tr>
                
            </thead>
        </table>
    </div>
    <!-- 	导出-->    
	<jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="HalfpartMachineOutputSearch_search_form" />
		<jsp:param name="datagridId" value="halfpartmachineoutputsearch_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.halfpart.excel.HalfpartMachineOutputSearchExportHandler" />
		<jsp:param name="serviceName" value="HalfpartMachineOutputSearchServiceImpl" />
	</jsp:include>
</body>
</html>
