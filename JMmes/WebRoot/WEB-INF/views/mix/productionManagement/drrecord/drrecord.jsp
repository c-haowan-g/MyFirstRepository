<!-- 

    作者      :栾和源
    时间      :2020-08-03 11:41:49 
    页面名称:密炼投料履历
    文件关联:
        Drrecord.java
        DrrecordController.java
        DrrecordServiceImpl.java
        DrrecordServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="drrecord.js.jsp"%>
<script type="text/javascript" src="dict/054,056,066,324,301,302,075.js"></script>

<body class="easyui-layout" fit="true"> 
  <div class="easyui-tabs" fit="true" border="false" style="width:700px;height:250px">
   <!--投料履历-->
    <div title="<spring:message code='投料履历'/>" style="padding:10px" >
        <div id="Drrecord_dg_toolbar">
            <form id="Drrecord_search_form" class="form" >
                <!-- 机台编码 -->
                <spring:message code="drrecord.column.equip_code_s" /> &nbsp;
                <input name="filter[equip_code_s]" id="equip_code_s" type="text" style="width:110px" class="easyui-combobox" data-options="label:'',
               		   data:equiplist,
	         		   panelHeight:150,
	         		   editable:true,
	           		   valueField:'p_line_name',
	          		   textField:'description',
	                   selectOnNavigation:false,
	           		   limitToList:true,
	          		   filter:searchProductionLine,
	           		   onChange:filter" >&nbsp;&nbsp;
                <!-- 工单状态：054001-未生成、054002-已生成、054003-已执行、054004-已暂停、054005-已关闭 -->
                <spring:message code="drrecord.column.wo_status" />&nbsp;
                <input name="filter[wo_status_s]" id="wo_status_s" type="text" style="width:110px"  class="easyui-combotree" data-options="label:'',
                			required:false,
				            panelHeight:200,
				            url:'dict/code/054',
				            method:'get'" > &nbsp;&nbsp;
                <!-- 投料类型：056001-炭黑、056002-油料、056003-胶料上辅机、056004-小料上辅机、056005-人工配料、056006-碎胶投料碎胶投料 -->
                <spring:message code="drrecord.column.input_type" />&nbsp;
                <input name="filter[input_type_s]" id="input_type_s" type="text" style="width:110px" class="easyui-combotree" data-options="label:'',
                			required:false,
				            panelHeight:200,
				            url:'dict/code/056',
				            method:'get'" > &nbsp;&nbsp;
                <!-- 物料编码 -->
                <spring:message code="drrecord.column.material_code_s" /> &nbsp;
                <input name="filter[material_code_s]" id="material_code_s" type="text" style="width:110px" class="easyui-textbox" data-options="label:''" > &nbsp;&nbsp;
                <!-- 批次号 -->
                <spring:message code="drrecord.column.lot_no_s" /> &nbsp;
                <input name="filter[lot_no_s]" id="lot_no_s" type="text" style="width:110px" class="easyui-textbox" data-options="label:''" >&nbsp;&nbsp;
                <!-- 投料时间 --> 
                <spring:message code="drrecord.column.create_time" />:<input name="filter[begintime]" editable="true" id="begin_created_time" type="text" class="easyui-datetimebox" style="width:160px" data-options="label:''">
				到 <input name="filter[endtime]" editable="true" id="end_created_time" type="text" class="easyui-datetimebox" style="width:160px" data-options="label:''">&nbsp;&nbsp;&nbsp;
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            
        </div>
        <table id="drrecord_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#Drrecord_dg_toolbar',
                url: '',
                striped:true,
                method: 'get' 
                ">
            <thead>
                 <tr>
                    <th data-options="field:'atr_key',checkbox:true"rowspan="2"></th>
                    <th colspan="9"><strong>通讯信息</strong></th>
                    <th colspan="10"><strong>接受信息</strong></th>
                    <th colspan="14"><strong>扫描反馈信息</strong></th>
                 </tr> 
                 <tr>    
                     <!-- 工单生产日期 -->
                    <th data-options="field:'wo_date_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drrecord.column.wo_date" /></th>
                    <!-- 密炼工单跟踪表，工单号，外键，MX_PP_WO.WO_NO -->
                    <th data-options="field:'wo_no_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drrecord.column.wo_no" /></th>
                    <!-- 投料班次：302001-早班、302002-中班、302003-晚班 -->
                    <th data-options="field:'shift_code_s',width:'80px',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="drrecord.column.shift_code" /></th>
                    <!-- 投料类型：056001-炭黑、056002-油料、056003-胶料上辅机、056004-小料上辅机、056005-人工配料、056006-碎胶投料碎胶投料 -->
                    <th data-options="field:'input_type_s',width:'80px',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="drrecord.column.input_type" /></th>
                    <!-- 工单状态：054001-未生成、054002-已生成、054003-已执行、054004-已暂停、054005-已关闭 -->
                    <th data-options="field:'wo_status_s',width:'80px',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="drrecord.column.wo_status" /></th>
                    <!-- 机台编码 -->
                    <th data-options="field:'equip_code_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drrecord.column.equip_code_s" /></th>
                    <!-- 机台名称 -->
                    <th data-options="field:'equip_name_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drrecord.column.equip_name_s" /></th>
                    <!-- 输送线：炭黑、油料输送 -->
                    <th data-options="field:'pipeline_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drrecord.column.pipeline" /></th>
                    <!-- 连通料仓号：炭黑、油料输送 -->
                    <th data-options="field:'silono_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drrecord.column.silono" /></th>
                     <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drrecord.column.material_code_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'material_name_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drrecord.column.material_name_s" /></th>
                    <!-- 称量类型： 324-炭黑称 1-油料称 2-胶料称 3-小料称 4-小料称 5-油料称2 6-小料在胶料称 7-预分散称 8-返回胶专用秤 -->
                    <th data-options="field:'weigh_type_s',width:'80px',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="drrecord.column.weigh_type" /></th>
                    <!-- 密炼生成配方编号 -->
                    <th data-options="field:'recipe_code_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drrecord.column.recipe_code" /></th>
                     <!-- 数据来源：075001-全钢-万向、075002-全钢-北院、075003-半钢-软控、075004-半钢-万向、075005-人工配料、075006-快检 -->
                    <th data-options="field:'datasource_s',width:'80px',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="drrecord.column.datasource" /></th>
                    <!-- 当前车次号 -->
                    <th data-options="field:'serial_id_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drrecord.column.serial_id_s" /></th>             
                     <!-- 批次号 -->
                    <th data-options="field:'lot_no_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drrecord.column.lot_no_s" /></th>
                    <!-- 载具条码（母胶投入时胶架条码） -->
                    <th data-options="field:'carrier_code_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drrecord.column.carrier_code" /></th>
                    <!-- 投料重量 -->
                    <th data-options="field:'weight_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drrecord.column.weight_s" /></th>
                    <!-- 允许误差 -->
                    <th data-options="field:'error_allow_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drrecord.column.error_allow_s" /></th>
                     <!-- 扫描人 -->
                    <th data-options="field:'scan_by_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drrecord.column.scan_by_s" /></th>
                     <!-- 扫描时间 -->
                    <th data-options="field:'scan_time_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drrecord.column.scan_time_s" /></th>  
                     <!-- 创建人 -->
                    <th data-options="field:'created_by_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drrecord.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',width:'80px',editor:{type:'textbox'}"><spring:message code="drrecord.column.created_time_t" /></th>
                     <!--接受时间 -->
                    <th data-options="field:'receive_time_t',width:'80px',editor:{type:'textbox'}"><spring:message code="drrecord.column.receive_time_t" /></th> 
                    <!-- 备用字段1：供应商代码 -->
                    <th data-options="field:'spare1_s',editor:{type:'textbox'}"><spring:message code="drrecord.column.spare1" /></th>
                    <!-- 备用字段2：供应商名称 -->
                    <th data-options="field:'spare2_s',editor:{type:'textbox'}"><spring:message code="drrecord.column.spare2" /></th>
                    <!-- 备用字段3：是否校验通过： 066001-投料准备、 066002-等待反馈、 066003-通过、 066004-未通过、066005-其它 -->
                    <th data-options="field:'spare3_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="drrecord.column.spare3" /></th>
                    <!-- 备用字段4：密炼通讯反馈备注 -->
                    <th data-options="field:'spare4_s',editor:{type:'textbox'}"><spring:message code="drrecord.column.spare4" /></th>
                    <!-- 备用字段5：小料数量 -->
                    <th data-options="field:'spare5_s',editor:{type:'textbox'}"><spring:message code="drrecord.column.spare5" /></th>
                    <!-- 备用字段6：是否掺胶：Yes-掺胶、No-不掺胶 -->
                    <th data-options="field:'spare6_s',formatter:useglueFormatter,editor:{type:'textbox'}"><spring:message code="drrecord.column.spare6" /></th>
                    <!-- 备用字段7：配方阶段：ZC-正常、ZCC-不正常、SY-实验 -->
                    <th data-options="field:'spare7_s',formatter:formulastatusFormatter,editor:{type:'textbox'}"><spring:message code="drrecord.column.spare7" /></th>
                    <!-- 备用字段8：配方类型：1-正常、2-返炼、3-洗车、4-返洗、5-正洗 -->
                    <th data-options="field:'spare8_s',formatter:formulastyleFormatter,editor:{type:'textbox'}"><spring:message code="drrecord.column.spare8" /></th>   
                </tr>
            </thead>
        </table>
    </div>
     <!-- 投料请求 -->  
    <div  title="<spring:message code='投料请求'/>" style="padding:10px" >
        <div id="Drrequest_dg_toolbar">
            <form id="Drrequest_search_form" class="form" >
            	<!-- 机台编码 -->
                <spring:message code="drrequest.column.equip_code_s" /> &nbsp;
                <input name="filter[equip_code_s]" id="equip_code_s" type="text" style="width:110px" class="easyui-combobox" data-options="label:'',
               		   data:equiplist,
	         		   panelHeight:150,
	         		   editable:true,
	           		   valueField:'p_line_name',
	          		   textField:'description',
	                   selectOnNavigation:false,
	           		   limitToList:true,
	          		   filter:searchProductionLine,
	           		   onChange:filter1" >&nbsp;&nbsp;
                <!-- 投料类型：056001-炭黑、056002-油料、056003-胶料上辅机、056004-小料上辅机、056005-人工配料、056006-碎胶投料碎胶投料 -->
                 <spring:message code="drrequest.column.input_type" />
                &nbsp;&nbsp;<input name="filter[input_type_s]" id="input_type_s" type="text" style="width:110px" class="easyui-combotree" ,
                        data-options="label:'',
				              			 required:false,
				              			 panelHeight:200,
				              			 url:'dict/code/056',
				              			 method:'get'" > 
                
                 <!-- 密炼通讯状态： 065001-MES接收请求 065002-MES正常反馈 065003-MES发出请求 065004-MES未接收到反馈 065005-其它 -->
                 &nbsp;&nbsp;<spring:message code="drrequest.column.request_state" />
                &nbsp;&nbsp;<input name="filter[request_state_s]" id="request_state_s" type="text" style="width:110px"  class="easyui-combotree" ,
                        data-options="label:'',
				              			 required:false,
				              			 panelHeight:200,
				              			 url:'dict/code/065',
				              			 method:'get'" > 
                <!-- 是否校验通过： 066001-等待反馈 066002-通过 066003-未通过 -->
                 &nbsp;&nbsp;<spring:message code="drrequest.column.is_pass" />
                 &nbsp;&nbsp;<input name="filter[is_pass_s]" id="is_pass_s" type="text" style="width:110px"  class="easyui-combotree" ,
                        data-options="label:'',
				              			 required:false,
				              			 panelHeight:200,
				              			 url:'dict/code/066',
				              			 method:'get'" > 
                 &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter1()"><spring:message code="button.search" /></a>
            </form>             
        </div>
        <table id="drrequest_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#Drrequest_dg_toolbar',
                url: '',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"rowspan="2"></th>
                    <th colspan="5"><strong>通讯信息</strong></th>
                    <th colspan="12"><strong>接受信息</strong></th>
                    <th colspan="6"><strong>扫描反馈信息</strong></th>
                </tr> 
                <tr>            
                    <!-- 投料类型：056001-炭黑、056002-油料、056003-胶料上辅机、056004-小料上辅机、056005-人工配料、056006-碎胶投料碎胶投料 -->
                    <th data-options="field:'input_type_s',width:'80px',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="drrequest.column.input_type" /></th>
                    <!-- 机台编码 -->
                    <th data-options="field:'equip_code_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drrequest.column.equip_code_s" /></th>
                    <!-- 机台名称 -->
                    <th data-options="field:'equip_name_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drrequest.column.equip_name_s" /></th>
                     <!-- 输送线：炭黑、油料输送 -->
                    <th data-options="field:'pipeline_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drrequest.column.pipeline" /></th>
                    <!-- 连通料仓号：炭黑、油料输送 -->
                    <th data-options="field:'silono_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drrequest.column.silono" /></th>
                     <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drrequest.column.material_code_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'material_name_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drrequest.column.material_name_s" /></th>
                    <!-- 称量类型： 0-炭黑称 1-油料称 2-胶料称 3-小料称 4-小料称 5-油料称2 6-小料在胶料称 7-预分散称 8-返回胶专用秤 -->
                    <th data-options="field:'weigh_type_s',width:'80px',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="drrequest.column.weigh_type" /></th>
                    <!-- 密炼工单跟踪表，工单号，外键，MX_PP_WO.WO_NO -->
                    <th data-options="field:'wo_no_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drrequest.column.wo_no" /></th>
                    <!-- 密炼生成配方编号 -->
                    <th data-options="field:'recipe_code_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drrequest.column.recipe_code" /></th>
                     <!-- 数据来源：075001-全钢-万向、075002-全钢-北院、075003-半钢-软控、075004-半钢-万向、075005-人工配料、075006-快检 -->
                    <th data-options="field:'datasource_s',width:'80px',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="drrequest.column.datasource" /></th>
                    <!-- 当前车次号 -->
                    <th data-options="field:'serial_id_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drrequest.column.serial_id_s" /></th>
                    <!-- 调用ID -->
                    <th data-options="field:'transactionid_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drrequest.column.transactionid_s" /></th>
                     <!-- 批次号 -->
                    <th data-options="field:'lot_no_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drrequest.column.lot_no_s" /></th>
                    <!-- 载具条码（母胶投入时胶架条码） -->
                    <th data-options="field:'carrier_code_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drrequest.column.carrier_code" /></th>
                    <!-- 投料重量 -->
                    <th data-options="field:'weight_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drrequest.column.weight_s" /></th>
                    <!-- 允许误差 -->
                    <th data-options="field:'error_allow_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drrequest.column.error_allow_s" /></th>
                     <!-- 扫描人 -->
                    <th data-options="field:'scan_by_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drrequest.column.scan_by_s" /></th>
                     <!-- 扫描时间 -->
                    <th data-options="field:'scan_time_t',width:'80px',editor:{type:'textbox'}"><spring:message code="drrequest.column.scan_time_t" /></th>
                    <!-- 投料班次：302001-早班、302002-中班、302003-晚班 -->
                    <th data-options="field:'shift_code_s',formatter:codeFormatter,width:'80px',editor:{type:'textbox'}"><spring:message code="drrequest.column.shift_code" /></th>
                     <!-- 创建人 -->
                    <th data-options="field:'created_by_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drrequest.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',width:'80px',editor:{type:'textbox'}"><spring:message code="drrequest.column.created_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
    </div>
</body>
</html>
