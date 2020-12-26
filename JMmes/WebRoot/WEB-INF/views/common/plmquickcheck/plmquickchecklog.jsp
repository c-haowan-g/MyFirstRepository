<!-- 

    作者      :肖吉朔
    时间      :2020-08-26 10:00:10 
    页面名称:PLM快检标准参数日志主表
    文件关联:
        PlmQuickCheckLog.java
        PlmQuickCheckLogController.java
        PlmQuickCheckLogServiceImpl.java
        PlmQuickCheckLogServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/meta.jsp"%>
<%@ include file="plmquickchecklog.js.jsp"%>
<script type="text/javascript" src="dict/323.js"></script>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'west',split:true" style="width:60%;">
        <div id="plmquickchecklog_dg_toolbar">
            <form id="PlmQuickCheckLog_search_form" class="form" >
                <!-- 物料编码-->
                <spring:message code="plmquickcheck.column.matersap_s" />:
                <input name="filter[matersap_s]" id="matersap_s" type="text" style="width:125px;"  like="true" class="easyui-textbox" data-options="label:''" >
                <!-- 物料名称-->
                <spring:message code="plmquickcheck.column.matername_s" />:
                <input name="filter[matername_s]" id="matername_s" like="true" style="width:110px;" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 审核状态 -->
                <spring:message code="plmquickcheck.column.check_state_s" />:
                <input  name="filter[check_state_s]" id="check_state_s" type="text"  style="width:110px;" class="easyui-combobox" style="" data-options="label:'',
                                        required:false, 
                                       	 data: [{
											text: '全部',
											value: ''
										},{
											text: '已审核',
											value: '1'
										},{
											text: '未审核',
											value: '0'
										}],
			                             method: 'get'"> 
                <br/>
                <!-- 配方编号-13位：Java系统当前时间 例如 1552888628141 -->
                <spring:message code="plmquickcheckpara.column.recipe_code_s" />:
                <input name="filter[recipe_code_s]" id="recipe_code_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 配方阶段 -->
                <spring:message code="plmquickcheck.column.prescriptionstage_s" />:
                <input  name="filter[prescriptionstage_s]" id="prescriptionstage_s" style="width:110px;" type="text" class="easyui-combobox" style="" data-options="label:'',
                                        required:false, 
                                       	 data: [{
											text: '全部',
											value: ''
										},{
											text: '正常',
											value: 'ZC'
										},{
											text: '不正常',
											value: 'SY'
										}],
			                             method: 'get'"> 
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-add'" onclick="filter()"><spring:message code="button.search" /></a>
            </form>
        </div>
         <table id="plmquickchecklog_dg" 
               class="easyui-datagrid" 
               style="width:100%"
               data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: true,
                url: 'common/PlmQuickCheckLog/datagrid',
                toolbar:'#plmquickchecklog_dg_toolbar',
                striped:true, 
                method: 'get' ,
                emptyMsg: '<span><spring:message code='tip.noData'/></span>' 
                ">
            <thead >
                <tr>
                   <!-- <th data-options="field:'atr_key',checkbox:true"></th> -->
                    <!-- 配方编号-13位：Java系统当前时间 例如 1552888628141 -->
                    <th data-options="field:'recipe_code_s',editor:{type:'textbox'}"><spring:message code="plmquickchecklog.column.recipe_code_s" /></th>
                    <!-- 配方状态：323001-待用、323002-正用、323003-停用 -->
                    <th data-options="field:'recipe_status_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="plmquickchecklog.column.recipe_status_s" /></th>
                    <!-- 审核状态：0-未审核、1-已审核 -->
                    <th data-options="field:'check_state_s',styler:cellStyler,formatter:stateFormatter,editor:{type:'textbox'}"><spring:message code="plmquickchecklog.column.check_state_s" /></th>
                    <!-- 物料品号：存储9位品号（返回胶、实验胶11位，例如 300000308_-F） -->
                    <th data-options="field:'matersap_s',editor:{type:'textbox'}"><spring:message code="plmquickchecklog.column.matersap_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'matername_s',editor:{type:'textbox'}"><spring:message code="plmquickchecklog.column.matername_s" /></th>
                    <!-- 物料版本 -->
                    <th data-options="field:'materrevision_s',editor:{type:'textbox'}"><spring:message code="plmquickchecklog.column.materrevision_s" /></th>
                    <!-- 配方阶段：ZC-正常、SY-不正常 -->
                    <th data-options="field:'prescriptionstage_s',formatter:stageFormatter,editor:{type:'textbox'}"><spring:message code="plmquickchecklog.column.prescriptionstage_s" /></th>
                    <!-- 检验标准类型：考核标准、检验标准、专检标准 -->
                    <th data-options="field:'inspectionstandardname_s',formatter:inspectionstandardnameText,editor:{type:'textbox'}"><spring:message code="plmquickchecklog.column.inspectionstandardname_s" /></th>
                    <!-- 工厂 -->
                    <th data-options="field:'plant_s',editor:{type:'textbox'}"><spring:message code="plmquickchecklog.column.plant_s" /></th>
                    <!-- 接收时间 -->
                    <th data-options="field:'receive_time_t',editor:{type:'textbox'}"><spring:message code="plmquickchecklog.column.receive_time_t" /></th>
                    <!-- 审核人姓名 -->
                    <th data-options="field:'check_name_s',editor:{type:'textbox'}"><spring:message code="plmquickchecklog.column.check_name_s" /></th>
                    <!-- 审核时间 -->
                    <th data-options="field:'check_time_t',editor:{type:'textbox'}"><spring:message code="plmquickchecklog.column.check_time_t" /></th>
                    <!-- 预留1 -->
                    <th data-options="field:'dummy1_s',editor:{type:'textbox'}"><spring:message code="plmquickchecklog.column.dummy1_s" /></th>
                    <!-- 预留2 -->
                    <th data-options="field:'dummy2_s',editor:{type:'textbox'}"><spring:message code="plmquickchecklog.column.dummy2_s" /></th>
                    <!-- 预留3 -->
                    <th data-options="field:'dummy3_s',editor:{type:'textbox'}"><spring:message code="plmquickchecklog.column.dummy3_s" /></th>
                    <!-- 预留4 -->
                    <th data-options="field:'dummy4_s',editor:{type:'textbox'}"><spring:message code="plmquickchecklog.column.dummy4_s" /></th>
                    <!-- 预留5 -->
                    <th data-options="field:'dummy5_s',editor:{type:'textbox'}"><spring:message code="plmquickchecklog.column.dummy5_s" /></th>
                    
                    
                    
                  </tr>
            </thead>
        </table>
    </div>
    <div data-options="region:'center',split:true" style="width:100px;"title="<spring:message code="rubber.quickcheck.standard.parameter.list" />">
		<form id="para_search_form" class="form" style="display:none">
                <spring:message code="plmquickcheckpara.column.recipe_code_s" />:
                <input name="filter[recipe_code_s]" id="recipe_code" type="text" class="easyui-textbox" data-options="label:''" >
              
               <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-add'" onclick="filter()"><spring:message code="button.search" /></a>
        </form>  
		<table id="para_dg" 
		      class="easyui-datagrid" 
		     style="width:100%"
			data-options="  
                fit:true,
                fitColumns:true,
                pagination:false,
                rownumbers: true,
                singleSelect: true,
                     
                striped:true,
                remoteSort:false,
                method: 'get'
                ">
			<thead>
				  <tr>
                   <!--  <th data-options="field:'atr_key',checkbox:true">ID</th> -->
                    <!-- 检验项目类型：门尼类、硫变类、硬度类、比重类、物性、VMA、其它 门尼类：M(1+4)、T5 硫变类：ML、MH、Ts1、T25、T30、T60、T90、T25' 硬度类：硬度 比重类：比重 物性：H抽出 VMA：流动值、膨胀率 其它：△G'、X -->
                    <th data-options="field:'inspectionitemname_s',formatter:typeforText,editor:{type:'textbox'}"><spring:message code="plmquickcheckpara.column.inspectionitemname_s" /></th>
                    
                    <!-- 检验方法 -->
                    <th data-options="field:'dummy1_s',editor:{type:'textbox'}"><spring:message code="parahis.column.dummy1_s" /></th>
                    <!-- 上限值符号：0-不包含、1-包含 -->
                    <th data-options="field:'valuemaxsign_s',formatter:limitforText,editor:{type:'textbox'}"><spring:message code="plmquickcheckpara.column.valuemaxsign_s" /></th>
                    <!-- 上限值 -->
                    <th data-options="field:'valuemax_s',editor:{type:'textbox'}"><spring:message code="plmquickcheckpara.column.valuemax_s" /></th>
                    <!-- 下限值符号：0-不包含、1-包含 -->
                    <th data-options="field:'valueminsign_s',formatter:limitforText,editor:{type:'textbox'}"><spring:message code="plmquickcheckpara.column.valueminsign_s" /></th>
                    <!-- 下限值 -->
                    <th data-options="field:'valuemin_s',editor:{type:'textbox'}"><spring:message code="plmquickcheckpara.column.valuemin_s" /></th>
                
                    <!-- 接收时间 -->
                    <th data-options="field:'receive_time_t',editor:{type:'textbox'}"><spring:message code="plmquickcheckpara.column.receive_time_t" /></th>
                    
                    <!-- 预留2 -->
                    <th data-options="field:'dummy2_s',editor:{type:'textbox'}"><spring:message code="plmquickcheckpara.column.dummy2_s" /></th>
                    <!-- 预留3 -->
                    <th data-options="field:'dummy3_s',editor:{type:'textbox'}"><spring:message code="plmquickcheckpara.column.dummy3_s" /></th>
                    <!-- 预留4 -->
                    <th data-options="field:'dummy4_s',editor:{type:'textbox'}"><spring:message code="plmquickcheckpara.column.dummy4_s" /></th>
                    <!-- 预留5 -->
                    <th data-options="field:'dummy5_s',editor:{type:'textbox'}"><spring:message code="plmquickcheckpara.column.dummy5_s" /></th>
                 </tr>
			</thead>
		</table>
	</div>
</body>
</html>
