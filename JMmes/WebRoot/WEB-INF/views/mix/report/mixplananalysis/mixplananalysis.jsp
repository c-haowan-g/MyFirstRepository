<!-- 

    作者      :mike
    时间      :2020-08-20 11:10:21 
    页面名称:计划库存分析报表_密炼日计划表
    文件关联:
        MixPlanAnalysis.java
        MixPlanAnalysisController.java
        MixPlanAnalysisServiceImpl.java
        MixPlanAnalysisServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="mixplananalysis.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="MixPlanAnalysis_dg_toolbar">
            <form id="MixPlanAnalysis_search_form" class="form" >
             <!-- 计划生产日期 -->
                计划日期:
                <input name="filter[plan_date_s]" id="plan_date_s" type="text"  class="easyui-datebox" style="width:100px"  data-options="onChange:filter,formatter:dateFormat,buttons:[],parser:dateParser,label:''" >
                <script type="text/javascript">
	                $("#plan_date_s").val(new Calendar().format("yyyyMMdd"));
	            </script>
	            
	            				              			
	              <!-- 在产机台 -->
                &nbsp;&nbsp;<spring:message code="密炼机台" />
                &nbsp;<input name="filter[equip_code_s]" id="equip_code_s" type="text" class="easyui-combobox" data-options="label:'',
                       data:materialnameList,
	         		   panelHeight:150,
	         		   editable:true,
	           		   valueField:'p_line_name',
	          		   textField:'description',
	                   selectOnNavigation:false,
	           		   limitToList:true,
	           		   onChange:filter
	           		   "	 >
	           		   
	           	<!-- 物料编码 -->
	           	 &nbsp;&nbsp;物料编码:
                 &nbsp;<input name="filter[material_code_s]" id="material_code_s" type="text" class="easyui-textbox" data-options="label:''" >
                 <!-- 物料名称 -->
                 &nbsp;&nbsp;物料名称:
                 &nbsp;<input name="filter[material_name_s]" id="material_name_s" type="text" class="easyui-textbox" data-options="label:''" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
                <a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="doExport()"><spring:message code="button.export" /></a>
            </form> 
           
            　
            
        </div>
        <table id="mixplananalysis_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#MixPlanAnalysis_dg_toolbar',
                url: 'mix/report/mixplananalysis/datagrid',
                 onBeforeLoad:dlg1BeforeLoad,
                striped:true,
                method: 'get' 
                ">
            <thead>
                 <tr>
             <th colspan="6"><strong></strong></th>
                   <th colspan="3"><strong>早班</strong></th>
                    <th colspan="3"><strong>中班</strong></th>
                     <th colspan="3"><strong>晚班</strong></th>
            </tr>
                <tr>                 
                     <!-- 机台名称 -->
                    <th data-options="field:'equip_name_s',width:110,editor:{type:'textbox'}"><spring:message code="机台名称" /></th>
                     <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',width:80,editor:{type:'textbox'}"><spring:message code="物料编码 " /></th>
                     <!-- 物料名称 -->
                    <th data-options="field:'material_name_s',width:80,editor:{type:'textbox'}"><spring:message code="物料名称" /></th>
                     <!-- 日计划量 -->
                    <th data-options="field:'qty_plan_i',width:80,editor:{type:'textbox'}"><spring:message code="日计划量" /></th>
                     <!-- 日完成 -->
                    <th data-options="field:'play_complete',width:80,editor:{type:'textbox'}"><spring:message code="日完成量" /></th>
                    <!-- 日计划完成率 -->
                    <th data-options="field:'play_completion',formatter:completionrateFormatter,width:80,editor:{type:'textbox'}"><spring:message code="日完成率" /></th>
                    
                    <!-- 早班计划量 -->
                    <th data-options="field:'qty_mor_i',width:80,editor:{type:'textbox'}"><spring:message code="计划量" /></th>
                    <!-- 早班完成数量 -->
                    <th data-options="field:'qty_complete_mor_i',width:80,editor:{type:'textbox'}"><spring:message code="完成量" /></th>
                    <!-- 早班完成率 -->
                    <th data-options="field:'qty_completion_mor_i',formatter:completionrateFormatter,width:80,editor:{type:'textbox'}"><spring:message code="完成率" /></th>
                    
                    <!-- 中班计划量 -->
                    <th data-options="field:'qty_mid_i',width:80,editor:{type:'textbox'}"><spring:message code="计划量" /></th>
                    <!-- 中班完成数量 -->
                    <th data-options="field:'qty_complete_mid_i',width:80,editor:{type:'textbox'}"><spring:message code="完成量" /></th>
                     <!-- 中班完成率 -->
                    <th data-options="field:'qty_completion_mid_i',formatter:completionrateFormatter,width:80,editor:{type:'textbox'}"><spring:message code="完成率" /></th>
                    
                    <!-- 晚班计划量 -->
                    <th data-options="field:'qty_nig_i',width:80,editor:{type:'textbox'}"><spring:message code="计划量" /></th>
                    <!-- 晚班完成数量 -->
                    <th data-options="field:'qty_complete_nig_i',width:80,editor:{type:'textbox'}"><spring:message code="完成量" /></th> 
                     <!-- 晚班完成率 -->
                    <th data-options="field:'qty_completion_nig_i',formatter:completionrateFormatter,width:80,editor:{type:'textbox'}"><spring:message code="完成率" /></th>               
                    
                </tr>
            </thead>
        </table>
    </div>
</body>
</html>
