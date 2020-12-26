<!-- 

    作者      :王超
    时间      :2020-08-08 08:20:54 
    页面名称:密炼日计划表
    文件关联:
        DayPlan.java
        DayPlanController.java
        DayPlanServiceImpl.java
        DayPlanServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="mixdayplancopyxl.js.jsp"%>
<script type="text/javascript" src="dict/052,053,054,075.js"></script>
<body class="easyui-layout" fit="true"> 
        <div id="mixdayplan_copy_dg_toolbar">
            <form id="MixDayPlan_copy_search_form" class="form" >
                <spring:message code="tip.from" />
				:&emsp;<input id="datebox_from" type="text" class="easyui-datebox" style="width:100px" data-options="formatter:dateFormat,buttons:[],parser:dateParser,labelWidth:30,label:''">
	            <spring:message code="tip.copy" /><spring:message code="tip.to" />
	            :&emsp;<input id="datebox_to" type="text" class="easyui-datebox" style="width:100px" data-options="formatter:dateFormat,buttons:[],parser:dateParser,labelWidth:70,label:''">
                <script type="text/javascript">
                  $("#production_date_s").val(new Calendar().format("yyyyMMdd"));
                  $("#production_date_to_s").val(new Calendar().format("yyyyMMdd"));
	            </script>
            </form> 
            <a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-copy'" onclick="copy()">复制</a>
            <a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a>
            <a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a>
            <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>
            <a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a>
        </div>
        <table id="mixdayplan_copy_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#mixdayplan_copy_dg_toolbar',
                striped:true,
                onBeforeLoad:dlg1BeforeLoad,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th rowspan="2" data-options="field:'atr_key',checkbox:true"></th>
                    <th colspan="7">计划基本信息</th>
                    <th colspan="4">配方基本信息</th>
                    <th colspan="2">日计划量</th>
                    <th colspan="2">早班计划量</th>
                    <th colspan="2">中班计划量</th>
                    <th colspan="2">晚班计划量</th>
                    <th colspan="8">早班计划执行情况</th>
                    <th colspan="8">中班计划执行情况</th>
                    <th colspan="8">晚班计划执行情况</th>
                    
                    <!-- 数据来源：075001-全钢-万向、075002-全钢-北院、075003-半钢-软控、075004-半钢-万向、075005-人工配料、075006-快检 -->
                    <th rowspan="2" data-options="field:'datasource_s',formatter:codeFormatter,width:80"><spring:message code="plan.column.datasource_s" /></th>
                    <!-- 审核人姓名 -->
                    <th rowspan="2" data-options="field:'check_by_s'"><spring:message code="plan.column.check_by_s" /></th>
                    <!-- 审核时间 -->
                    <th rowspan="2" data-options="field:'check_time_t'"><spring:message code="plan.column.check_time_t" /></th>
                    <!-- 下发人姓名 -->
                    <th rowspan="2" data-options="field:'send_by_s'"><spring:message code="plan.column.send_by_s" /></th>
                    <!-- 下发时间 -->
                    <th rowspan="2" data-options="field:'send_time_t'"><spring:message code="plan.column.send_time_t" /></th>
                    <!-- 修改人姓名 -->
                    <th rowspan="2" data-options="field:'changed_by_s'"><spring:message code="plan.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th rowspan="2" data-options="field:'changed_time_t'"><spring:message code="plan.column.changed_time_t" /></th>
                    <!-- 创建人姓名 -->
                    <th rowspan="2" data-options="field:'created_by_s'"><spring:message code="plan.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th rowspan="2" data-options="field:'created_time_t'"><spring:message code="plan.column.created_time_t" /></th>
                    </tr>   
                 <tr> 
                    <!-- 计划基本信息 -->
                    <!-- 计划生产日期 -->
                    <th data-options="field:'plan_date_s'"><spring:message code="plan.column.plan_date_s" /></th>
                    <!-- 日计划号 -->
                    <th data-options="field:'plan_no_s',width:130"><spring:message code="plan.column.plan_no_s" /></th>
                    <!--执行顺序-->
                    <th data-options="field:'spare8_s',editor:close"><spring:message code="mixdayplan.column.spare8_s" /></th>
                    <!-- 计划状态 -->
                    <th data-options="field:'plan_status_s',styler:planStatusCellStyler,formatter:codeFormatter"><spring:message code="plan.column.plan_status_s" /></th>
                    <!-- 机台条码 -->
                    <th data-options="field:'equip_code_s',width:80"><spring:message code="plan.column.equip_code_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',required:true,width:125"><spring:message code="plan.column.material_code_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'material_name_s',required:true,width:125"><spring:message code="plan.column.material_name_s" /></th>
                     
                    <!-- 配方基本信息 -->
                    <!-- 密炼生成配方编号 -->
                    <th data-options="field:'mixrecipe_recipe_code_s',width:135"><spring:message code="plan.column.mixrecipe_recipe_code_s" /></th>
                    <!-- 密炼配方BOM版本 -->
                    <th data-options="field:'recipe_bom_version_s',width:80"><spring:message code="plan.column.recipe_bom_version_s" /></th>
                    <!-- 快检检验配方编号 -->
                    <th data-options="field:'quickcheck_recipe_code_s',width:140"><spring:message code="plan.column.quickcheck_recipe_code_s" /></th>
                    <!-- 密炼快检检验百分比 -->
                    <th data-options="field:'sip_s'"><spring:message code="plan.column.sip_s" /></th>
                    
                    <!-- 日计划量 -->
                    <th data-options="field:'qty_plan_i',width:80,editor:{type:'numberspinner',options:{min:0,max:8888888,required:true,icons:[]}}"><spring:message code="plan.column.qty_plan_i" /></th>
                    <!-- 日计划检验量：车数*检验百分比 -->
                    <th data-options="field:'qty_check_plan_f',width:80,editor:{type:'numberspinner',options:{min:0,max:8888888,required:true,icons:[]}}"><spring:message code="plan.column.qty_check_plan_f" /></th>
                   
                    <!-- 早班计划量 -->
                    <th data-options="field:'qty_mor_i',width:80,editor:{type:'numberspinner',options:{min:0,max:8888888,onChange:onCountChange1,icons:[]}}"><spring:message code="plan.column.qty_mor_i" /></th>
                    <!-- 早班计划检验量：车数*检验百分比 -->
                    <th data-options="field:'qty_check_mor_f',width:80,editor:{type:'numberspinner',options:{min:0,max:8888888,onChange:onCheckCountChange1,icons:[]}}"><spring:message code="plan.column.qty_check_mor_f" /></th>
                    
                    <!-- 中班计划量 -->
                    <th data-options="field:'qty_mid_i',width:80,editor:{type:'numberspinner',options:{min:0,max:8888888,onChange:onCountChange1,icons:[]}}"><spring:message code="plan.column.qty_mid_i" /></th>
                    <!-- 中班计划检验量：车数*检验百分比 -->
                    <th data-options="field:'qty_check_mid_f',width:80,editor:{type:'numberspinner',options:{min:0,max:8888888,onChange:onCheckCountChange1,icons:[]}}"><spring:message code="plan.column.qty_check_mid_f" /></th>
                  
                    <!-- 晚班计划量 -->
                    <th data-options="field:'qty_nig_i',width:80,editor:{type:'numberspinner',options:{min:0,max:8888888,onChange:onCountChange1,icons:[]}}"><spring:message code="plan.column.qty_nig_i" /></th>
                    <!-- 晚班计划检验量：车数*检验百分比 -->
                    <th data-options="field:'qty_check_nig_f',width:80,editor:{type:'numberspinner',options:{min:0,max:8888888,onChange:onCheckCountChange1,icons:[]}}"><spring:message code="plan.column.qty_check_nig_f" /></th>
                   
                    <!-- 早班生产状态 -->
                    <th data-options="field:'status_mor_s',formatter:codeFormatter"><spring:message code="plan.column.status_mor_s" /></th>
                    <!-- 早班检查状态 -->
                    <th data-options="field:'status_check_mor_s',formatter:codeFormatter"><spring:message code="plan.column.status_check_mor_s" /></th>
                    <!-- 早班检验合格数量 -->
                    <th data-options="field:'qty_check_good_mor_f'"><spring:message code="plan.column.qty_check_good_mor_i" /></th>
                    <!-- 早班检验不合格数量 -->
                    <th data-options="field:'qty_check_bad_mor_f'"><spring:message code="plan.column.qty_check_bad_mor_i" /></th>
                    <!-- 早班生产开始时间 -->
                    <th data-options="field:'act_start_time_mor_t'"><spring:message code="plan.column.act_start_time_mor_t" /></th>
                    <!-- 早班生产结束时间 -->
                    <th data-options="field:'act_finish_time_mor_t'"><spring:message code="plan.column.act_finish_time_mor_t" /></th>
                    <!-- 早班检查开始时间 -->
                    <th data-options="field:'act_start_checktime_mor_t'"><spring:message code="plan.column.act_start_checktime_mor_t" /></th>
                    <!-- 早班检查结束时间 -->
                    <th data-options="field:'act_finish_checktime_mor_t'"><spring:message code="plan.column.act_finish_checktime_mor_t" /></th>
                  
                    <!-- 中班生产状态 -->
                    <th data-options="field:'status_mid_s',formatter:codeFormatter"><spring:message code="plan.column.status_mid_s" /></th>
                    <!-- 中班检查状态 -->
                    <th data-options="field:'status_check_mid_s',formatter:codeFormatter"><spring:message code="plan.column.status_check_mid_s" /></th>
                    <!-- 中班检验合格数量 -->
                    <th data-options="field:'qty_check_good_mid_f'"><spring:message code="plan.column.qty_check_good_mid_i" /></th>
                    <!-- 中班检验不合格数量 -->
                    <th data-options="field:'qty_check_bad_mid_f'"><spring:message code="plan.column.qty_check_bad_mid_i" /></th>
                    <!-- 中班生产开始时间：展示DD HH:MM:MM -->
                    <th data-options="field:'act_start_time_mid_t'"><spring:message code="plan.column.act_start_time_mid_t" /></th>
                    <!-- 中班生产结束时间：展示DD HH:MM:MM -->
                    <th data-options="field:'act_finish_time_mid_t'"><spring:message code="plan.column.act_finish_time_mid_t" /></th>
                    <!-- 中班检查开始时间：展示DD HH:MM:MM -->
                    <th data-options="field:'act_start_checktime_mid_t'"><spring:message code="plan.column.act_start_checktime_mid_t" /></th>
                    <!-- 中班检查结束时间：展示DD HH:MM:MM -->
                    <th data-options="field:'act_finish_checktime_mid_t'"><spring:message code="plan.column.act_finish_checktime_mid_t" /></th>
                   
                    <!-- 晚班生产状态 -->
                    <th data-options="field:'status_nig_s',formatter:codeFormatter"><spring:message code="plan.column.status_nig_s" /></th>
                    <!-- 晚班检查状态 -->
                    <th data-options="field:'status_check_nig_s',formatter:codeFormatter"><spring:message code="plan.column.status_check_nig_s" /></th>
                    <!-- 晚班检验合格数量 -->
                    <th data-options="field:'qty_check_good_nig_f'"><spring:message code="plan.column.qty_check_good_nig_i" /></th>
                    <!-- 晚班检验不合格数量 -->
                    <th data-options="field:'qty_check_bad_nig_f'"><spring:message code="plan.column.qty_check_bad_nig_i" /></th>
                    <!-- 晚班生产开始时间：展示DD HH:MM:MM -->
                    <th data-options="field:'act_start_time_nig_t'"><spring:message code="plan.column.act_start_time_nig_t" /></th>
                    <!-- 晚班生产结束时间：展示DD HH:MM:MM -->
                    <th data-options="field:'act_finish_checktime_nig_t'"><spring:message code="plan.column.act_finish_checktime_nig_t" /></th>
                    <!-- 晚班检查开始时间：展示DD HH:MM:MM -->
                    <th data-options="field:'act_start_checktime_nig_t'"><spring:message code="plan.column.act_start_checktime_nig_t" /></th>
                    <!-- 晚班检查结束时间：展示DD HH:MM:MM -->
                    <th data-options="field:'act_finish_time_nig_t'"><spring:message code="plan.column.act_finish_time_nig_t" /></th>
                </tr>
            </thead>
        </table>
  </body>
</html>
