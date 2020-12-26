<!-- 

    作者      :时永良
    时间      :2019年7月17日16:49:38 
    页面名称:硫化机台控制管理
    文件关联:
        MachineControl.java
        MachineControlController.java
        MachineControlServiceImpl.java
        MachineControlServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="machinecontrol.js.jsp"%>
<script type="text/javascript" src="dict/211,214,252.js"></script>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="MachineControl_dg_toolbar">
            <form id="MachineControl_search_form" class="form" >
            	<!-- 产线条码 -->
            	<spring:message code="machinecontrol.column.product_line_s" />:
                <input name="filter[p_line_name]" id="p_line_name"  style="width:15%" type="text" class="easyui-textbox" like="true" data-options="label:''" >
                <!-- 机台状态    生产、待机、维护、换模具、换胶囊、冻结 -->
                <spring:message code="machinecontrol.column.isused_s" />:
                <input name="filter[status_s]" id="status_s" style="width:15%" type="text" class="easyui-combotree" data-options="label:'',
						                  panelHeight:200,
						                  labelWidth:'auto',
										  panelWidth:'15%',
										  required:false,
										  url:'dict/code/214',
										  method:'get'" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form>
            	<div style="padding:5px;">
		            <auth:button code="machineControl.export"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
		            <auth:button code="machineControl.logFile"><a href="javascript:void(0)" class="easyui-linkbutton btn-black" data-options="iconCls:'icon-search'" onclick="openWindow()"><spring:message code="button.logFile" /></a></auth:button>
		       		<auth:button code="machineControl.showOrHide"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="showOrHide()"><spring:message code="button.searchColumn" /></a></auth:button>
	       		</div>
	       		<div >
		       		<auth:button code="machineControl.mold_heatflag_on"><a style='width:140px' class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-add'" onclick="on_off('温模打开')" ><spring:message code="button.wmon" /></a></auth:button>
				    <auth:button code="machineControl.offlinerunflag_on"><a style='width:140px' class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-add'" onclick="on_off('单机打开')"><spring:message code="button.djon" /> </a></auth:button>  
		       		<auth:button code="machineControl.alarm_controlflag_on"><a style='width:140px' class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-add'" onclick="on_off('报警打开')"><spring:message code="button.bjon" /> </a></auth:button>
		       		<auth:button code="machineControl.firstmold_controlflag_on"><a style='width:140px' class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-add'" onclick="on_off('首模打开')"><spring:message code="button.smon" /> </a></auth:button>
		       		<auth:button code="machineControl.verification_mark_on"><a style='width:140px' class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-add'" onclick="on_off('胎胚放行打开')"><spring:message code="button.tpfxon" /> </a></auth:button>
		       		<auth:button code="machineControl.tyre_timever_on"><a style='width:140px' class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-add'" onclick="on_off('胎胚时效打开')"><spring:message code="button.tpsxon" /> </a></auth:button>
		       		<auth:button code="machineControl.tyre_pickver_on"><a style='width:140px' class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-add'" onclick="on_off('胎胚领用打开')"><spring:message code="button.tplyon" /> </a></auth:button>
	       		<br/>
					<auth:button code="machineControl.mold_heatflag_off"><a style='width:140px' class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-remove'" onclick="on_off('温模关闭')"><spring:message code="button.wmoff" /> </a></auth:button>
		       		<auth:button code="machineControl.offlinerunflag_off"><a style='width:140px' class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-remove'" onclick="on_off('单机关闭')"><spring:message code="button.djoff" /> </a></auth:button>
		       		<auth:button code="machineControl.alarm_controlflag_off"><a style='width:140px' class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-remove'" onclick="on_off('报警关闭')"><spring:message code="button.bjoff" /> </a></auth:button>
		       		<auth:button code="machineControl.firstmold_controlflag_off"><a style='width:140px' class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-remove'" onclick="on_off('首模关闭')"><spring:message code="button.smoff" /> </a></auth:button>
		       		<auth:button code="machineControl.verification_mark_off"><a style='width:140px' class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-remove'" onclick="on_off('胎胚放行关闭')"><spring:message code="button.tpfxoff" /> </a></auth:button>
		       		<auth:button code="machineControl.tyre_timever_off"><a style='width:140px' class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-remove'" onclick="on_off('胎胚时效关闭')"><spring:message code="button.tpsxoff" /> </a></auth:button>
		       		<auth:button code="machineControl.tyre_pickver_off"><a style='width:140px' class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-remove'" onclick="on_off('胎胚领用关闭')"><spring:message code="button.tplyoff" /> </a></auth:button>
	       		<br/>
	       		    <auth:button code="machineControl.qs_stop_on"><a style='width:140px' class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-add'" onclick="on_off('后工序打开')"><spring:message code="button.hxon" /> </a></auth:button>
	       			<auth:button code="machineControl.tyrebar_controlflag_on"><a style='width:140px' class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-add'" onclick="on_off('后充气受控打开')"><spring:message code="button.hcqskon" /></a></auth:button>
	       			<auth:button code="machinecontrol.column.tyre_feeding_on"><a style='width:140px' class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-add'" onclick="on_off('投料管控打开')"><spring:message code="button.tlgkon" /></a></auth:button>
	       			<auth:button code="machinecontrol.column.spare7_s_on"><a style='width:140px' class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-add'" onclick="on_off('质量管控打开')"><spring:message code="button.zlgkon" /></a></auth:button>
	       			<auth:button code="machinecontrol.column.spare6_s_on"><a style='width:140px' class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-add'" onclick="on_off('洗模管控打开')"><spring:message code="button.xmgkon" /></a></auth:button>
	       			
	       		<br/>
	       		    <auth:button code="machineControl.qs_stop_off"><a style='width:140px' class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-remove'" onclick="on_off('后工序关闭')"><spring:message code="button.hxoff" /></a></auth:button>
		       		<auth:button code="machineControl.tyrebar_controlflag_off"><a style='width:140px' class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-remove'" onclick="on_off('后充气受控关闭')"><spring:message code="button.hcqskoff" /></a></auth:button>
	       			<auth:button code="machinecontrol.column.tyre_feeding_off"><a style='width:140px' class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-remove'" onclick="on_off('投料管控关闭')"><spring:message code="button.tlgkoff" /></a></auth:button>
	       			<auth:button code="machinecontrol.column.spare7_s_off"><a style='width:140px' class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-remove'" onclick="on_off('质量管控关闭')"><spring:message code="button.zlgkoff" /></a></auth:button>
	       			<auth:button code="machinecontrol.column.spare6_s_off"><a style='width:140px' class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-remove'" onclick="on_off('洗模管控关闭')"><spring:message code="button.xmgkoff" /></a></auth:button>
	       		<br/>
	       		</div>
        </div>
        <table id="machinecontrol_dg" class="easyui-datagrid" style="width:100%"
                 data-options="
	                 fit:true,
	                 fitColumns:false,
	                 pagination:true,
	                 singleSelect: false,
	                 collapsible: true,
	                 rownumbers: true,
	                 toolbar: '#MachineControl_dg_toolbar',
	                 url: 'curing/baseData/curingControl/machinecontrol/searchBy',
	                 striped:true,
	                 method: 'get',
	                 emptyMsg:'暂无数据'
                ">
            <thead data-options="frozen:true">
	                <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 产线条码 -->
                    <th data-options="field:'p_line_name',width:100,editor:{}"><spring:message code="machinecontrol.column.product_line_s" /></th>
                    <!-- 机台条码 -->
                    <th data-options="field:'equip_name',width:100,editor:{}"><spring:message code="main.column.curingmachinecode_s" /></th>
                    <!-- 机台状态 1:生产、2待机、3:维护、4 换模具 5、换胶囊 6冻结 -->
                    <th data-options="field:'status_s',width:100,formatter:codeFormatter,editor:{options:{
                    			panelHeight:200,
                    			method:'get',
                                url:'dict/code/214',
                    			required:true}}"><spring:message code="machinecontrol.column.isused_s" /></th>
	        </thead>
	        <thead>
	             	<!-- 是否温模，1是，0，否 -->
                    <th data-options="field:'mold_heatflag_s',
		                    formatter:function(value,row,index){
						                  				if(value=='1'){return '是'}
						                  				else if(value=='0'){return '否'}}"><spring:message code="machinecontrol.column.mold_heatflag_s" /></th>
                    <!-- 是否单机运行   1 是  0 否 -->
                    <th data-options="field:'offlinerunflag_s',
                    formatter:function(value,row,index){
				                  				if(value=='1'){return '是'}
				                  				else if(value=='0'){return '否'}}"><spring:message code="machinecontrol.column.offlinerunflag_s" /></th>
                    <!-- 警报需解除受控 1：是 （受控）  0：否（不受控，自动解除） -->
                    <th data-options="field:'alarm_controlflag_s',
					formatter:function(value,row,index){
				                  				if(value=='1'){return '是'}
				                  				else if(value=='0'){return '否'}}"><spring:message code="machinecontrol.column.alarm_controlflag_s" /></th>
                    <!-- 首模需验证 受控  1：是 0：否（首模不需验证） -->
                    <th data-options="field:'firstmold_controlflag_s',
                    formatter:function(value,row,index){
				                  				if(value=='1'){return '是'}
				                  				else if(value=='0'){return '否'}}"><spring:message code="machinecontrol.column.firstmold_controlflag_s" /></th>
                    <!-- 验证放行标志，0不放行，1：放行 -->
                    <th data-options="field:'verification_mark_s',
                    formatter:function(value,row,index){
				                  				if(value=='1'){return '是'}
				                  				else if(value=='0'){return '否'}}"><spring:message code="machinecontrol.column.verification_mark_s" /></th>
                    <!-- 胎胚时效性验证  1：是  0： 否 -->
                    <th data-options="field:'tyre_timever_s',
                    formatter:function(value,row,index){
				                  				if(value=='1'){return '是'}
				                  				else if(value=='0'){return '否'}}"><spring:message code="machinecontrol.column.tyre_timever_s" /></th>
                    <!-- 胚胎领用验证 1：是  0： 否 -->
                    <th data-options="field:'tyre_pickver_s',
                    formatter:function(value,row,index){
				                  				if(value=='1'){return '是'}
				                  				else if(value=='0'){return '否'}}"><spring:message code="machinecontrol.column.tyre_pickver_s" /></th>
                    <!-- 后工序停机控制开关 1：是  0： 否 -->
                    <th data-options="field:'qs_stop_s',
                    formatter:function(value,row,index){
				                  				if(value=='1'){return '是'}
				                  				else if(value=='0'){return '否'}}"><spring:message code="machinecontrol.column.qs_stop_s" /></th>
                    <!-- 后充气受控 1：是  0：否 -->
                    <th data-options="field:'tyrebar_controlflag_s',
                    formatter:function(value,row,index){
				                  				if(value=='1'){return '是'}
				                  				else if(value=='0'){return '否'}}"><spring:message code="machinecontrol.column.tyrebar_controlflag_s" /></th>
                    <!-- 投料管控 -->
                    <th data-options="field:'tyre_feeding_s',
                    formatter:function(value,row,index){
				                  				if(value=='1'){return '是'}
				                  				else if(value=='0'){return '否'}}"><spring:message code="machinecontrol.column.tyre_feeding_s" /></th>
                    <!-- 质量管控 -->
                    <th data-options="field:'spare7_s',
                    formatter:function(value,row,index){
				                  				if(value=='1'){return '是'}
				                  				else if(value=='0'){return '否'}}"><spring:message code="machinecontrol.column.spare7_s" /></th>
                    <!-- 模具洗模管控 -->
                    <th data-options="field:'spare6_s',
                    formatter:function(value,row,index){
				                  				if(value=='1'){return '是'}
				                  				else if(value=='0'){return '否'}}"><spring:message code="machinecontrol.column.spare6_s" /></th>
                    <!-- ip地址 -->
                    <th data-options="field:'ip_s',width:150, editor:{type:'textbox',options:{required:true}}"><spring:message code="machinecontrol.column.equip_ip_s" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changed_by_name',editor:{type:'textBox',options:{required:true}}"><spring:message code="machinecontrol.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',editor:{type:'textBox',options:{required:true}}"><spring:message code="machinecontrol.column.changed_time_t" /></th>
            </thead>
        </table>
    </div>
    <div id="w" class="easyui-window" title="机台日志" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:80%;height:60%;padding:10px 10px 30px;">
		<form id="LineControl_search_form" class="form" >
            	<!-- 产线条码 -->
            	<spring:message code="machinecontrol.column.product_line_s" />:
                <input name="filter[equip_code_s]" id="equip_code_s"  style="width:15%" type="text" class="easyui-textbox" like="true" data-options="label:''" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter1()"><spring:message code="button.search" /></a>
        </form>
		<table id="controldetail_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                collapsible: true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#ControlDetail_dg_toolbar',
                url: 'curing/baseData/curingControl/machinecontrol/searchByLine',
                striped:true,
                method: 'get',
                emptyMsg:'暂无数据' 
                ">
            <thead>
                <tr>
                    <!-- 机台条码 -->
                    <th data-options="field:'equip_code_s',width:80,editor:{type:'textbox',options:{required:true}}"><spring:message code="machinecontrol.column.product_line_s" /></th>
                    <!-- 机台名称 -->
                    <th data-options="field:'equip_name_s',width:80,editor:{type:'textbox',options:{required:true}}"><spring:message code="machinecontrol.column.productline_name_s" /></th>
                    <!-- 操作开关项 -->
                    <th data-options="field:'operate_item_s',width:80,editor:{type:'textbox',options:{required:true}}"><spring:message code="controldetail.column.operate_item_s" /></th>
                    <!-- 开关项状态(1打开/0关闭) -->
                	<th data-options="field:'operate_status_s',width:80,
                    						formatter:function(value,row,index){
				                  				if(value=='1'){return '是'}
				                  				else if(value=='0'){return '否'}},
                    editor:{type:'combobox',options:{required:true,valueField: 'value',textField: 'label',
                    						data: [{
												label: '是',
												value: '1'
											},{
												label: '否',
												value: '0'
											}],
                    validType:'length[1,100]'}}"><spring:message code="machinecontrol.column.operate_status_s" /></th>
                	<!-- 修改人 -->
                    <th data-options="field:'changed_by_name',width:80,editor:{type:'textbox',options:{required:true}}"><spring:message code="controldetail.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',width:80,editor:{type:'textbox',options:{required:true}}"><spring:message code="controldetail.column.changed_time_t" /></th>
                    
                </tr>
            </thead>
        </table>
	</div>
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="MachineControl_search_form" />
		<jsp:param name="datagridId" value="machinecontrol_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.curing.excel.MachineControlExportHandler" />
		<jsp:param name="serviceName" value="MachineControlServiceImpl" />
	</jsp:include>
	
</body>
</html>
