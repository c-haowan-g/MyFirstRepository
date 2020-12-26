<!-- 

    作者      :李迺锟
    时间      :2019-02-20 17:30:34 
    页面名称:轮胎主表(同步硫化月计划实际产量及已过动平衡量)
    文件关联:
        CuringMonthPlanLog.java
        CuringMonthPlanLogController.java
        CuringMonthPlanLogServiceImpl.java
        CuringMonthPlanLogServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="curingmonthplanlog.js.jsp"%>

<script type="text/javascript" src="dict/400,253.js"></script>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="CuringMonthPlanLog_dg_toolbar">
            <form id="CuringMonthPlanLog_search_form" class="form" >

				<td class="columnTitle">
					<!--硫化物料编码(品号)--> 
					<spring:message code="curingmonthplanlog.column.curingspeccode_s"/>
					: <input name="filter[curingspeccode_s]" id="curingspeccode_s" style="width:16%" type="text"
					 class="easyui-textbox" data-options="label:''">
	                     &nbsp;
				</td>
				<td class="columnTitle">
					<!--硫化月计划号 -->
					<spring:message code="curingmonthplanlog.column.month_plan_no_s" />
					:&emsp;&emsp; <input name="filter[month_plan_no_s]" id="month_plan_no_s" style="width:16%" type="text" 
					 class="easyui-textbox" data-options="label:''">
	                     &nbsp;
				</td>
				<td class="columnTitle">
					<!-- 数据同步处理标记：0-未处理、1-已处理 --> <spring:message
						code="curingmonthplanlog.column.sync_hand_flag_s" /> : <input
					    name="filter[sync_hand_flag_s]" id="sync_hand_flag_s"
					    style="width:16%" class="easyui-combobox"
					    data-options="label:'',
                             textField: 'label',
	                         data: [{
			                 label: '请选择',
			                 value: ''
			                 },{
			                 label: '未处理',
			                 value: '0'
			                 },{
			                 label: '已处理',
			                 value: '1'
                             }]">
					     &nbsp;
				</td> 
				<br />
				<!--轮胎条码 --> 
			 		<spring:message code="curingmonthplanlog.column.barcode_s" />
					:&emsp;&emsp; <input name="filter[barcode_s]" id="barcode_s" style="width:16%" type="text" 
					 class="easyui-textbox" data-options="label:''"> 
	                &nbsp;
				</td>
                <!-- 数据同步创建时间 -->
                <spring:message code="curingmonthplanlog.column.sync_create_time_t" />
                : <input name="filter[start_time]" type="text" editable="true" id="start_time"
						 class="easyui-datetimebox" style="width:16%" data-options="label:''">
				&nbsp;
				<spring:message code="tip.to" /> 
				&nbsp;
				<input name="filter[end_time]" editable="true" id="end_time"
				       class="easyui-datetimebox" style="width:16%"> 
               <%--  <br/>
                 <auth:button code="COM_INTERFACE_CURINGMONTHLOG_EDIT"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button> 
                 <auth:button code="COM_INTERFACE_CURINGMONTHLOG_SAVE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button> --%>
                 <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
        </div> 
      
        <table id="curingmonthplanlog_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#CuringMonthPlanLog_dg_toolbar',
                striped:true,
                method: 'get',
                emptyMsg:'暂无数据',
                ">
            <thead>
                 <tr>
                	<th data-options="field:'atr_key',checkbox:true" rowspan="2">ID</th>
                    <!-- 轮胎条码-->
                    <th data-options="field:'barcode_s',editor:{type:'textbox'}" rowspan="2"><spring:message code="curingmonthplanlog.column.barcode_s" /></th>
                    <!-- 质量等级编码 -->
                    <th data-options="field:'gradecode_s', formatter:codeFormatter" rowspan="2"><spring:message code="curingmonthplanlog.column.gradecode_s" /></th>
                    
                    <th colspan="9">硫化</th>
                    <th colspan="8">动平衡</th>
                    
                    <!-- 记录标志，A可用，D删除 -->
                    <th data-options="field:'record_flag_s',formatter:formatter_recordflag,editor:{type:'textbox'}" rowspan="2"><spring:message code="curingmonthplanlog.column.record_flag_s" /></th>
                    <!-- 工厂（1全钢2半钢） -->
                    <th data-options="field:'s_factory_s',formatter:formatter_factory,editor:{type:'textbox'}" rowspan="2"><spring:message code="curingmonthplanlog.column.s_factory_s" /></th>
                    <!-- 年周号 -->
                    <th data-options="field:'weeklynumber_s',editor:{type:'textbox'}" rowspan="2"><spring:message code="curingmonthplanlog.column.weeklynumber_s" /></th>
                    <!-- 同步时间 -->
                    <th data-options="field:'sync_create_time_t',editor:{type:'textbox'}" rowspan="2"><spring:message code="curingmonthplanlog.column.sync_create_time_t" /></th>
                    <!-- 数据同步处理：A-新增，U-修改，D-删除 -->
                    <th data-options="field:'sync_flag_s',formatter:formatter_changee,editor:{type:'textbox'}" rowspan="2"><spring:message code="curingmonthplanlog.column.sync_flag_s" /></th>
                    <!-- 数据同步处理标记：0-未处理（产量或动平衡量未更新），1-已处理（产量及动平衡量更新完） -->
                    <th data-options="field:'sync_hand_flag_s',formatter:formatter_change,editor:{type:'textbox'}" rowspan="2"><spring:message code="curingmonthplanlog.column.sync_hand_flag_s" /></th>
                    <!-- 数据同步处理反馈 -->
                    <th data-options="field:'sync_hand_msg_s',editor:{type:'textbox'}" rowspan="2"><spring:message code="curingmonthplanlog.column.sync_hand_msg_s" /></th>
                    <!-- 处理时间 -->
                    <th data-options="field:'sync_hand_time_t',editor:{type:'textbox'}" rowspan="2"><spring:message code="curingmonthplanlog.column.sync_hand_time_t" /></th>
                </tr>
                <tr>
                    <!-- 硫化合模时间 -->
                    <th data-options="field:'curingclosemouldtime_t',editor:{type:'textbox'}"><spring:message code="curingmonthplanlog.column.curingclosemouldtime_t" /></th>
                    <!-- 硫化换模首条确认：0-否，1-是 -->
                    <th data-options="field:'curingfirstflag_s',formatter:formatter_firstflag,editor:{type:'textbox'}"><spring:message code="curingmonthplanlog.column.curingfirstflag_s" /></th>
                    <!-- 硫化质量等级 -->
                    <th data-options="field:'curinggradecode_s',formatter:codeFormatter" editor:{type:'textbox'}"><spring:message code="curingmonthplanlog.column.curinggradecode_s" /></th>
                    <!-- 硫化机台 -->
                    <th data-options="field:'curingmachinecode_s',editor:{type:'textbox'}"><spring:message code="curingmonthplanlog.column.curingmachinecode_s" /></th>
                    <!-- 硫化开模时间 -->
                    <th data-options="field:'curingopenmouldtime_t',editor:{type:'textbox'}"><spring:message code="curingmonthplanlog.column.curingopenmouldtime_t" /></th>
                    <!-- 硫化物料编码 -->
                    <th data-options="field:'curingspeccode_s',editor:{type:'textbox'}"><spring:message code="curingmonthplanlog.column.curingspeccode_s" /></th>
                    <!-- 硫化日计划号 -->
                    <th data-options="field:'daily_plan_no_s',editor:{type:'textbox'}"><spring:message code="curingmonthplanlog.column.daily_plan_no_s" /></th>
                    <!-- 硫化月计划号 -->
                    <th data-options="field:'month_plan_no_s',editor:{type:'textbox'}"><spring:message code="curingmonthplanlog.column.month_plan_no_s" /></th>
                    <!-- 过硫化量更新标记 0 未更新，1 已更新 -->
                    <th data-options="field:'curing_update_flag_s',formatter:formatter_update_flag,editor:{type:'textbox'}"><spring:message code="curingmonthplanlog.column.curing_update_flag_s" /></th>
                    
                    <!-- 动平衡检查次数 -->
                    <th data-options="field:'dynamicbalancecount_i',editor:{type:'textbox'}"><spring:message code="curingmonthplanlog.column.dynamicbalancecount_i" /></th>
                    <!-- 动平衡质量等级 -->
                    <th data-options="field:'dynamicbalancegradecode_s',formatter:codeFormatter"><spring:message code="curingmonthplanlog.column.dynamicbalancegradecode_s" /></th>
                    <!-- 动平衡配方号 -->
                    <th data-options="field:'dynamicbalanceindex_i',editor:{type:'textbox'}"><spring:message code="curingmonthplanlog.column.dynamicbalanceindex_i" /></th>
                    <!-- 动平衡机条码 -->
                    <th data-options="field:'dynamicbalancembarcode_s',editor:{type:'textbox'}"><spring:message code="curingmonthplanlog.column.dynamicbalancembarcode_s" /></th>
                    <!-- 动平衡通过时间 -->
                    <th data-options="field:'dynamicbalancepasstime_t',editor:{type:'textbox'}"><spring:message code="curingmonthplanlog.column.dynamicbalancepasstime_t" /></th>
                    <!-- 动平衡病象编号 -->
                    <th data-options="field:'dynamicbalancereascode_s',editor:{type:'textbox'}"><spring:message code="curingmonthplanlog.column.dynamicbalancereascode_s" /></th>
                    <!-- 是否已过动平衡：0-否，1-是 -->
                    <th data-options="field:'is_balance_s',formatter:formatter_firstflag,editor:{type:'textbox'}"><spring:message code="curingmonthplanlog.column.is_balance_s" /></th>
                    <!-- 过动平衡量更新标记：0-未更新，1-已更新 -->
                    <th data-options="field:'balance_update_flag_s',formatter:formatter_update_flag,editor:{type:'textbox'}"><spring:message code="curingmonthplanlog.column.balance_update_flag_s" /></th>
                </tr>    
            </thead>
        </table>
        
    </div>
</body>
</html>
