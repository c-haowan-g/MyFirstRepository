<!-- 

    作者      :时永良/李德晓
    时间      :2019-01-16 08:11:24 
    页面名称:成型生成实绩查询
    文件关联:
        WorkorderResult.java
        WorkorderResultController.java
        WorkorderResultServiceImpl.java
        WorkorderResultServiceImpl.xml
        WorkorderResultExportHandler.java
    备注：美化页面排版--徐秉正
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="workorderresult.js.jsp"%>
<script type="text/javascript" src="dict/105,360,177,193,302,253,361.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="WorkorderResult_dg_toolbar">
            <form id="WorkorderResult_search_form" class="form" >
                <!-- 胎胚条码 -->
                <spring:message code="workorderresult.column.tyre_barcode_s" />:<input name="filter[tyre_barcode_s]" id="tyre_barcode_s" style="width:120px" type="text"  class="easyui-textbox" data-options="label:''" >&nbsp;&nbsp;&nbsp;&nbsp;
                <!-- 机台条码 -->
                <spring:message code="workorderresult.column.equip_code_s" />:<input name="filter[equip_code_s]" id="equip_code_s" style="width:120px" type="text" class="easyui-textbox" data-options="label:''" >&nbsp;&nbsp;&nbsp;
                <!-- 物料编码 -->
                <spring:message code="workorderresult.column.material_code_s" />:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="filter[material_code_s]" id="material_code_s" style="width:120px" type="text" class="easyui-textbox" data-options="label:''" >
                &nbsp;&nbsp;
                <spring:message code="workorderresult.column.workerMain_id_s" />:&nbsp;&nbsp;&nbsp;&nbsp;<input name="filter[workerMain_id_s]" id="workerMain_id_s" style="width:120px" type="text" class="easyui-textbox" data-options="label:''" >&nbsp;&nbsp;&nbsp;
                
                <spring:message code="workorderresult.column.workerAssistant_id1_s" />:&nbsp;&nbsp;&nbsp;&nbsp;<input name="filter[workerAssistant_id1_s]" id="workerAssistant_id1_s" style="width:120px" type="text" class="easyui-textbox" data-options="label:''" ><br>
                </br>
                <spring:message code="workorderresult.column.workerAssistant_id2_s" />:<input name="filter[workerAssistant_id2_s]" id="workerAssistant_id2_s" style="width:120px" type="text"  class="easyui-textbox" data-options="label:''" >&nbsp;
                <!-- 质量状态 -->
                &nbsp;&nbsp;&nbsp;<spring:message code="workorderresult.column.quality_status_s" />:<input  class="easyui-combobox" name="filter[quality_status_s]" id="quality_status_s"  style="width:120px" 
                       		 data-options="valueField:'DICTCODE_S',
				            			textField:'DICTNAME',
                                        required:false, 
                                        url:'building/productionManagement/workOrderResult/searchDescription',
										method: 'get',
									    editable:'true',
									    limitToList:false,
									    panelHeight:100,
										filter: function(q, row){  
								        var opts = $(this).combobox('options');  
								        return row[opts.textField].indexOf(q) >= 0;//这里改成>=即可在任意地方匹配  
								    	}">&nbsp;&nbsp;&nbsp;
                
                <%--  <!-- 补产出类型(由created_by_s字段代替补产出类型) -->
                &nbsp;&nbsp;&nbsp; <spring:message code="workerorderresult.column.outputType" />:<input name="filter[created_by_s]" id="formula_index_s" type="text" style="width:120px" class="easyui-combotree" data-options="label:'',
                                          panelHeight:200,
						                  labelWidth:'auto',
										  panelWidth:'15%',
										  required:false,
										  prompt:'全部',
										  url:'dict/code/360',
										  method:'get'
										  " >&nbsp;&nbsp;&nbsp; --%>
										  
					<label>成型补产出类型:</label>					  
                <select name="filter[created_by_s]" id="formula_index_s"   style="width:120px" class="easyui-combobox">
					     <option value="">全部</option>
					    <option value="360001">新增</option>
					    <option value="360002">条码替换</option>
					    <option value="360003">规格更改</option>
					</select>
                <!-- 产出标记 基础数据105 105001正常产出105002补产出105003取消产出 -->
                 &nbsp;&nbsp;&nbsp;<spring:message code="workorderresult.column.add_flag_s" />:&nbsp;<input name="filter[add_flag_s]" id="add_flag_s" type="text" style="width:120px" class="easyui-combotree" data-options="label:'',
                                          panelHeight:200,
						                  labelWidth:'auto',
										  panelWidth:'15%',
										  required:false,
										  url:'dict/code/105',
										  method:'get'" >&nbsp;&nbsp;&nbsp;
                
				<!-- 胎胚车号 -->
                <spring:message code="workorderresult.column.tire_car_code_s" />:<input name="filter[tire_car_code_s]" id="tire_car_code_s" type="text" style="width:120px" class="easyui-textbox" data-options="label:''" >&nbsp;&nbsp;&nbsp;<br></br>
                <!-- 成型班次 -->
                <spring:message code="workorderresult.column.building_shift_s" />:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="filter[building_shift_s]" id="building_shift_s" type="text" style="width:120px" class="easyui-combotree" data-options="label:'',
                                          panelHeight:200,
						                  labelWidth:'auto',
										  panelWidth:'15%',
										  required:false,
										  url:'dict/code/193',
										  method:'get'" >&nbsp;&nbsp;&nbsp;&nbsp;
				<spring:message code="workorderresult.column.building_date_t" />:<input name="filter[begintime]" editable="true" id="begin_created_time" type="text" class="easyui-datetimebox" style="width:160px" data-options="label:''">
				到 <input name="filter[endtime]" editable="true" id="end_created_time" type="text" class="easyui-datetimebox" style="width:160px" data-options="label:''">&nbsp;&nbsp;&nbsp;&nbsp;
				<!-- 补录原因 -->
                <spring:message code="patchcuringwork.column.patchreason_s" />:&nbsp;&nbsp;&nbsp;&nbsp;<input name="filter[spare1_s]" id="spare1_s" type="text" style="width:120px" class="easyui-combotree" data-options="label:'',
                                          panelHeight:200,
						                  labelWidth:'auto',
										  panelWidth:'15%',
										  required:false,
										  url:'dict/code/361',
										  method:'get'" >&nbsp;&nbsp;&nbsp;
            </form> 
            <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            <auth:button code="workorderresult.export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="doExport()"><spring:message code="button.export" /></a></auth:button>
            <auth:button code="workorderresult.showOrHide"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="showOrHide()"><spring:message code="button.searchColumn" /></a></auth:button> 
        </div>
        <table id="workorderresult_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#WorkorderResult_dg_toolbar',
                striped:true,
                method: 'get',
                emptyMsg: '<span><spring:message code='tip.noData'/></span>' 
                ">
            <thead>
                <tr>
                    <!-- 胎胚条码 -->
                    <th data-options="field:'tyre_barcode_s',width:80,editor:{type:'textbox'}"><spring:message code="workorderresult.column.tyre_barcode_s" /></th>
                    <!-- 日计划号 -->
                    <th data-options="field:'plan_no_s',width:120,editor:{type:'textbox'}"><spring:message code="workorderresult.column.plan_no_s" /></th>
                    <!-- 工单编号 -->
                    <th data-options="field:'work_order_id_s',width:140,editor:{type:'textbox'}"><spring:message code="workorderresult.column.work_order_id_s" /></th>
                    <!-- 机台条码 -->
                    <th data-options="field:'equip_code_s',width:120,editor:{type:'textbox'}"><spring:message code="workorderresult.column.equip_code_s" /></th>
                    <!-- 补产出类型(由工艺配方索引号字段代替补产出类型) -->
                    <th data-options="field:'created_by_s',formatter:classFormatter,editor:{type:'textbox'}"><spring:message code="workerorderresult.column.outputType" /></th>
                     <!--（是否补成型）产出标记 基础数据105 105001正常产出105002补产出105003取消产出 -->
                    <th data-options="field:'add_flag_s',formatter:codeFormatter,width:80,editor:{type:'textbox',
                                options:{
				                 method:'get',
				                 url:'dict/code/105',
				                 required:true}}"> <spring:message code="workorderresult.column.add_flag_s" /></th>
                    <!-- 补录原因 -->
                    <th data-options="field:'spare1_s',formatter:codeFormatter,width:120,editor:{type:'textbox', options:{
				                 method:'get',
				                 url:'dict/code/361',
				                 required:true}}"><spring:message code="patchcuringwork.column.patchreason_s" /></th>
                    
                    <!-- 胎胚车号 -->
                    <th data-options="field:'tire_car_code_s',width:120,editor:{type:'textbox'}"><spring:message code="workorderresult.column.tire_car_code_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',width:80,editor:{type:'textbox'}"><spring:message code="workorderresult.column.material_code_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'material_name_s',width:140,editor:{type:'textbox'}"><spring:message code="workorderresult.column.material_name_s" /></th>
                    <!-- 产出时间 -->
                    <th data-options="field:'building_date_t',width:150,editor:{type:'textbox'}"><spring:message code="workorderresult.column.building_date_t" /></th>
                    <!-- 标准重量 -->
                    <th data-options="field:'standard_weight_s',formatter:max_min_Formatter,width:80,editor:{type:'textbox'}"><spring:message code="workorderresult.column.standard_weight_s" /></th>
                    <!-- 胎胚重量 -->
                    <th data-options="field:'building_weight_s',width:80,editor:{type:'textbox'}"><spring:message code="workorderresult.column.building_weight_s" /></th>
                    <!-- 上限重量 -->
                    <th data-options="field:'spare4_s',width:80,editor:{type:'textbox'}"><spring:message code="workorderresult.column.max_weight_s" /></th>
                    <!-- 下限重量 -->
                    <th data-options="field:'spare3_s',width:80,editor:{type:'textbox'}"><spring:message code="workorderresult.column.min_weight_s" /></th>
                    <!-- 质量等级 数据字典253 -->
                    <th data-options="field:'quality_status_s',formatter:codeFormatter,width:80,editor:{type:'textbox',
                                options:{
				                 method:'get',
				                 url:'dict/code/253',
				                 required:true}}"><spring:message code="workorderresult.column.quality_status_s" /></th>
                    <!-- 重量是否合格 -->
                    <th data-options="field:'quality_weight_status_s',formatter:weightFormatter,width:80,editor:{type:'textbox'}"><spring:message code="workorderresult.column.quality_weight_status_s" /></th>
                    
                    
                    
                   
				    <!-- 是否首条 -->	
                    <th data-options="field:'first_s',formatter:function(value,row,index){
				                  if(value=='0'||value==''){return '是'}
				                  else if(value=='1'){return '否'}},
				    width:100,editor:{type:'textbox'}"><spring:message code="workorderresult.column.first_s" /></th>
                    <!-- 主手操作工 -->
                    <th data-options="field:'workermain_id_s',width:80,editor:{type:'textbox'}"><spring:message code="workorderresult.column.workerMain_id_s" /></th>
                    <!-- 副手操作工1 -->
                    <th data-options="field:'workerassistant_id1_s',width:80,editor:{type:'textbox'}"><spring:message code="workorderresult.column.workerAssistant_id1_s" /></th>
                    <!-- 副手操作工2 -->
                    <th data-options="field:'workerassistant_id2_s',width:80,editor:{type:'textbox'}"><spring:message code="workorderresult.column.workerAssistant_id2_s" /></th>
                    <!-- 固化标识 1:已固化 0或者null :未固化 -->
                    <th data-options="field:'solid_yflag_s',formatter:codeFormatter,width:80,editor:{type:'textbox',
                                 options:{
				                 method:'get',
				                 url:'dict/code/177',
				                 required:true}}"><spring:message code="workorderresult.column.solid_yflag_s" /></th>
                    <!-- 固话时间 -->
                    <th data-options="field:'solid_time_t',width:150,editor:{type:'textbox'}"><spring:message code="workorderresult.column.solid_time_s" /></th>
                    <!-- 成型班次 -->
                    <th data-options="field:'building_shift_s',formatter:codeFormatter,width:150,editor:{type:'textbox'}"><spring:message code="workorderresult.column.building_shift_s" /></th>
                    <!-- 成型时间 -->
                    <th data-options="field:'spare2_s',width:150,editor:{type:'textbox'}"><spring:message code="maintyrecurlog.column.buildintime_t" /></th>
                    <!-- 工厂 -->
                    <%-- <th data-options="field:'s_factory_s',formatter:factoryFormatter,width:150,editor:{type:'textbox'}"><spring:message code="wmscommon.column.s_factory_s" /></th> --%>
                 </tr>
            </thead>
        </table>
    </div>
        <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="WorkorderResult_search_form" />
		<jsp:param name="datagridId" value="workorderresult_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.building.excel.WorkorderResultExportHandler" />
		<jsp:param name="serviceName" value="WorkorderResultServiceImpl" />
	</jsp:include>  
</body>
</html>
