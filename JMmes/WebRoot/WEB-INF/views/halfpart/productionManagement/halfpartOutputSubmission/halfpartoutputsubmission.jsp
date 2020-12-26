<!-- 

    作者      :葛迎祥
    时间      :2020-12-10 16:05:04 
    页面名称:半部件送检单
    文件关联:
        HalfpartMachineOutputSearch.java
        HalfpartMachineOutputSearchController.java
        HalfpartMachineOutputSearchServiceImpl.java
        HalfpartMachineOutputSearchServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="halfpartoutputsubmission.js.jsp"%>
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
                <auth:button code="halfpartoutputsubmission.edit"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
                <auth:button code="halfpartoutputsubmission.save"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
                <auth:button code="halfpartoutputsubmission.cancel"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
                <auth:button code="halfpartoutputsubmission.export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
                <auth:button code="halfpartoutputsubmission.hide"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="showOrHide()"><spring:message code="button.searchColumn" /></a></auth:button>
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
                method: 'get',
                loadFilter: function (data) {
                	var value = { 
						total:data.total, 
						rows:[] 
					}; 
					var x = 0;
                	for(var i = 0; i < data.rows.length; i++){
                		if(data.rows[i].spare2_s != null){
                			value.rows[x++] = data.rows[i];
                		}
                	}
                	
                	value.total = x;
                	
                	return value;
				}
                ">
            <thead>
                <tr>
                    <!-- 送检单号 -->
                    <th data-options="field:'atr_key',width:100"><spring:message code="halfpartmachineoutput.column.atr_key" /></th>
                    <!-- 日计划号-工单号 -->
                    <th data-options="field:'planno_s',editor:{type:'textbox'}"><spring:message code="halfpartmachineoutput.column.planno_s" /></th>
                    <!-- 产出批次条码 -->
                    <th data-options="field:'barcode_s',editor:{type:'textbox'},width:180"><spring:message code="halfpartmachineoutput.column.barcode_s" /></th>
                    <!-- 机台条码 -->
                    <th data-options="field:'machinecode_s',editor:{type:'textbox'},width:80"><spring:message code="halfpartmachineoutput.column.machinecode_s" /></th>
                    <!-- 机台名称 -->
                    <th data-options="field:'machinename_s',editor:{type:'textbox'},width:150"><spring:message code="halfpartmachineoutput.column.machinename_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'materialcode_s',editor:{type:'textbox'},width:100"><spring:message code="halfpartmachineoutput.column.materialcode_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'materialname_s',editor:{type:'textbox'},width:150"><spring:message code="halfpartmachineoutput.column.materialname_s" /></th>
                    <!-- 物料名称 (中文)-->
                    <th data-options="field:'spare9_s',editor:{type:'textbox'},width:100"><spring:message code="halfpartmachineoutput.column.materialname_s_c" /></th>
                    <!-- 产出时间 -->
                    <th data-options="field:'outputtime_t',editor:{type:'textbox'},width:150"><spring:message code="storagearea.column.outputtime_t" /></th>
                    <!-- 送检单生成时间 -->
                    <th data-options="field:'spare2_s',editor:{type:'textbox'},width:180"><spring:message code="storagearea.column.submissiontime_t" /></th>
                    <!-- 状态 -->
                    <th data-options="field:'spare3_s',formatter:stateFormatter,width:120,editor:{type:'combobox',options:{
                    					required:true,
				            			textField:'text',
                    					valueField:'value',
										data: [{
											 text: '未检测',
											 value: '0'
										 },{
											 text: '合格',
											 value: '1'
										 },{
											 text: '不合格',
											 value: '2'
										 }],
									    editable:'true',
									    limitToList:false,
									    panelHeight:200
										}}"><spring:message code="halfpartmachineoutput.column.state" /></th>
                    <!-- 质检人 -->
                    <th data-options="field:'spare4_s',editor:{type:'textbox'},width:80"><spring:message code="halfpartmachineoutput.column.qualityer" /></th>
                    <!-- 质检时间 -->
                    <th data-options="field:'spare7_s',editor:{type:'textbox'},width:150"><spring:message code="halfpartmachineoutput.column.qualitytime" /></th>
                    <!-- 产出量（重量，数量，长度） -->
                    <th data-options="field:'outnum_f',editor:{type:'textbox'},width:100"><spring:message code="output.column.outnum_f" /></th>
                    <!-- 主手操作工 -->
                    <th data-options="field:'operator1_s',formatter:operatorFormatter,sortable:true,width:80,editor:{type:'textbox',options:{
                    					valueField:'USERCODE',
				            			textField:'USERNAME',
										data:basetypesList,
										method: 'get',
									    editable:'true',
									    limitToList:false,
									    panelHeight:200,
										}}"><spring:message code="halfpartmachineoutput.column.operator1_s" /></th>
                    <!-- 副手 -->
                    <th data-options="field:'assistantone_s',formatter:operatorFormatter,sortable:true,width:80,editor:{type:'textbox',options:{
                    					valueField:'USERCODE',
				            			textField:'USERNAME',
										data:basetypesList,
										method: 'get',
									    editable:'true',
									    limitToList:false,
									    panelHeight:200,
										}}"><spring:message code="halfpartmachineoutput.column.assistantone_s" /></th>
                    <!-- 卷曲工主手 -->
                    <th data-options="field:'curlyworker_s',formatter:operatorFormatter,sortable:true,width:80,editor:{type:'textbox',options:{
                    					valueField:'USERCODE',
				            			textField:'USERNAME',
										data:basetypesList,
										method: 'get',
									    editable:'true',
									    limitToList:false,
									    panelHeight:200,
										}}"><spring:message code="halfpartmachineoutput.column.curlyworker_s" /></th>
                    <!-- 卷曲工 副手 -->
                    <th data-options="field:'curlyassistone_s',formatter:operatorFormatter,sortable:true,width:80,editor:{type:'textbox',options:{
                    					valueField:'USERCODE',
				            			textField:'USERNAME',
										data:basetypesList,
										method: 'get',
									    editable:'true',
									    limitToList:false,
									    panelHeight:200,
										}}"><spring:message code="halfpartmachineoutput.column.curlyassistone_s" /></th>
                </tr>
                
            </thead>
        </table>
    </div>
    <!-- 	导出-->    
	<jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="HalfpartMachineOutputSearch_search_form" />
		<jsp:param name="datagridId" value="halfpartmachineoutputsearch_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.halfpart.excel.HalfpartoutputsubmissionExportHandler" />
		<jsp:param name="serviceName" value="HalfpartMachineOutputSearchServiceImpl" />
	</jsp:include>
</body>
</html>
