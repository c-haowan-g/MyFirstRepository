<!-- 

    作者      :周清玉
    时间      :2019-03-25 09:25:34 
    页面名称:设备维修履历
    文件关联:
        Maintaindetail.java
        MaintaindetailController.java
        MaintaindetailServiceImpl.java
        MaintaindetailServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<script type="text/javascript" src="dict/211,215.js"></script>
<%@ include file="maintaindetail.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="Maintaindetail_dg_toolbar">
            <form id="Maintaindetail_search_form" class="form" >
            	<spring:message code="maintaindetail.column.created_time_t" />:
                <input name="filter[begin_created_time]" editable="true" id="begin_created_time"
							type="text" class="easyui-datetimebox" style="width:170px"
							data-options="label:''">
						到 <input name="filter[end_created_time]" editable="true" id="end_created_time">
                <!-- 机台条码 -->
                <spring:message code="maintaindetail.column.equip_code_s" />:
                <input name="filter[equip_code_s]" id="equip_code_s" like="true" type="text" class="easyui-textbox" data-options="label:''" >
               <br/>
                <!-- 故障类型 -->
                <spring:message code="maintaindetail.column.fault_type_s" />:
                <input name="filter[fault_type_s]" id="fault_type_s" style="width:170px"  type="text" class="easyui-combotree" data-options="label:'',
				  			required:false,
				  			url:'dict/code/215',
				  			method:'get',
				  			label:''" >
                <!-- 维修结果 -->
                <spring:message code="maintaindetail.column.repick_result_s" />:
                <input  name="filter[repick_result_s]" id="repick_result_s" type="text" class="easyui-combobox" style="width:135px" data-options="label:'',
                                        required:false, 
                                       	 data: [{
											text: '请选择',
											value: ''
										},{
											text: '未完成',
											value: '0'
										},{
											text: '已完成',
											value: '1'
										},{
											text: '已确认',
											value: '2'
										}],
			                             method: 'get'"> 
                
                <!-- 修理状态 -->
                <spring:message code="maintaindetail.column.repick_status_s" />:
                <input  name="filter[repick_status_s]" id="repick_status_s" type="text" class="easyui-combobox" style="width:115px" data-options="label:'',
                                        required:false, 
                                       	 data: [{
											text: '请选择',
											value: ''
										},{
											text: '呼叫中',
											value: '0'
										},{
											text: '维修中',
											value: '1'
										},{
											text: '维修完成',
											value: '2'
										}],
			                             method: 'get'"> 
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="equcall.edit"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="equcall.save"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="equcall.cancel"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            <auth:button code="equcall.export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
        </div>
        <table id="maintaindetail_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: true,
                emptyMsg: '<span><spring:message code='tip.noData'/></span>',
                toolbar: '#Maintaindetail_dg_toolbar',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 机台条码 -->
                    <th data-options="field:'equip_code_s',editor:{type:'textbox',required:true,options:{editable:false,icons:[],disabled:true}}"><spring:message code="maintaindetail.column.equip_code_s" /></th>
                    <!-- 机台类型编码 -->
                    <th data-options="field:'equip_type_s',formatter:codeFormatter,editor:{type:'textbox',required:true,options:{editable:false,icons:[],disabled:true}}"><spring:message code="maintaindetail.column.equip_type_s" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'callname',editor:{type:'textbox',required:true,options:{editable:false,icons:[],disabled:true}}"><spring:message code="maintaindetail.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',editor:{type:'textbox',required:true,options:{editable:false,icons:[],disabled:true}}"><spring:message code="maintaindetail.column.created_time_t" /></th>
                    
                    <!-- 维修开始时间 -->
                    <th data-options="field:'begin_time_s',editor:{type:'textbox',required:true,options:{editable:false,icons:[],disabled:true}}"><spring:message code="maintaindetail.column.begin_time_s" /></th>
                    <!-- 维修结束时间 -->
                    <th data-options="field:'end_time_s',editor:{type:'textbox',required:true,options:{editable:false,icons:[],disabled:true}}"><spring:message code="maintaindetail.column.end_time_s" /></th>
                    <!--  -->
                    <th data-options="field:'spare1_s',formatter:timeFormatter,editor:{type:'textbox',required:true,options:{editable:false,icons:[],disabled:true}}"><spring:message code="maintaindetail.column.spare1_s" /></th>
                    <!--  -->
                    <th data-options="field:'spare2_s',formatter:createFormatter,editor:{type:'textbox',required:true,options:{editable:false,icons:[],disabled:true}}"><spring:message code="maintaindetail.column.spare2_s" /></th>
                   
                    
                    <!-- 维修工ID -->
                    <th data-options="field:'repickname',editor:{type:'textbox',required:true,options:{editable:false,icons:[],disabled:true}}"><spring:message code="maintaindetail.column.repick_worker_s" /></th>
                    <!-- 呼叫类型 -->
                    <th data-options="field:'repaircalltype_s',formatter:codeFormatter,editor:{type:'textbox',required:true,options:{editable:false,icons:[],disabled:true}}"><spring:message code="maintaindetail.column.repaircalltype_s" /></th>
                    <!-- 维修原因 -->
                    <th data-options="field:'repick_reason_s',editor:{type:'textbox'}"><spring:message code="maintaindetail.column.repick_reason_s" /></th>
                    <!-- 维修方法-->
                    <th data-options="field:'repick_method_s',editor:{type:'textbox'}"><spring:message code="maintaindetail.column.repick_method_s" /></th>
                    <!-- 维修部位-->
                    <th data-options="field:'repick_position_s',editor:{type:'textbox'}"><spring:message code="maintaindetail.column.repick_position_s" /></th>
                    <!-- 备件信息-->
                    <th data-options="field:'part_info_s',editor:{type:'textbox',options:{onClickCell:abc}}"><spring:message code="maintaindetail.column.part_info_s" /></th>
                    <!-- 维修结果 -->
                    <th data-options="field:'repick_result_s',formatter:resultFormatter,editor:{type:'textbox',required:true,options:{editable:false,icons:[],disabled:true}}"><spring:message code="maintaindetail.column.repick_result_s" /></th>
                    <!-- 修理状态 -->
                    <th data-options="field:'repick_status_s',formatter:statusFormatter,editor:{type:'textbox',required:true,options:{editable:false,icons:[],disabled:true}}"><spring:message code="maintaindetail.column.repick_status_s" /></th>
                   <!-- 车间 -->
                    <th data-options="field:'workshop_s',formatter:workFormatter,editor:{type:'textbox',required:true,options:{editable:false,icons:[],disabled:true}}"><spring:message code="maintaindetail.column.workshop_s" /></th>
                </tr>
            </thead>
        </table>
         <div id="lh_qx" class="easyui-window" title="备件选择"    style="width:200px;height:300px" closed="true">
         	
  		<div id='canvasDiv'  ></div>
    </div>
     <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="Maintaindetail_search_form" />
		<jsp:param name="datagridId" value="maintaindetail_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.curing.excel.MaintaindetailExportHandler" />
		<jsp:param name="serviceName" value="MaintaindetailServiceImpl" />
	</jsp:include> 
</body>
</html>
