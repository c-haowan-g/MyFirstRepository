<!-- 

    作者      :肖吉朔
    时间      :2020-08-08 11:10:40 
    页面名称:PLM快检标准参数执行表
    文件关联:
        exec.java
        execController.java
        execServiceImpl.java
        execServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="exec.js.jsp"%>


<body class="easyui-layout" fit="true"> 
    <div data-options="region:'west',split:true,border:false" title="<spring:message code="rubber.quickcheck.standard.list" />" style="width:50%;">
        <div id="exec_dg_toolbar">
            <form id="exec_search_form" class="form" >
                <!-- 物料编码 -->
                <spring:message code="quickcheckexec.column.matersap_s" />
                <input name="filter[matersap_s]" id="matersap_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 物料名称 -->
                <spring:message code="quickcheckexec.column.matername_s" />
                <input name="filter[matername_s]" id="matername_s" type="text" class="easyui-textbox" data-options="label:''" >
                </br>
                <!-- 审核状态 -->
                <spring:message code="quickcheckexec.column.check_state_s" />
                <input name="filter[check_state_s]" id="check_state_s" type="text" class="easyui-combobox" 
                data-options="labelWidth:'auto', 
							   required:false,
							  editable:false,
                              data:[{text:'未审核',value:'1'},{text:'已审核',value:'0'}],
							  textField:'text',
						      valueField:'value',
							  method:'get'">
					                 
                <!-- 检验标准类型 -->
                <spring:message code="quickcheckexec.column.inspectionstandardname_s" />
                <input name="filter[inspectionstandardname_s]" id="inspectionstandardname_s" type="text" class="easyui-combotree" 
                data-options="label:'', 
                               width:'150px',
                              required:false,
                              data:DICT_327,
                              method:'get'" >
                </br>
                <!-- 配方阶段 -->
                <spring:message code="quickcheckexec.column.prescriptionstage_s" />
                <input name="filter[prescriptionstage_s]" id="prescriptionstage_s" type="text" class="easyui-combotree" 
                data-options="label:'', 
                               width:'150px',
                              required:false,
                              data:DICT_332,
                              method:'get'"  >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
                <auth:button code="BAN_GANG_MIX_JCSJ_PLMJC_SH">
                         <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-shenhe'" onclick="audit()"><spring:message code="button.audit" /></a> 
                </auth:button> 
				<auth:button code="BAN_GANG_MIX_JCSJ_PLMJC_CXSH">
				         <a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-fanshenhe'" onclick="cancelaudit()"><spring:message code="button.cancelaudit" /></a>
				</auth:button>
				<auth:button code="BAN_GANG_MIX_BZGL_HGXKZ_BC"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="issue()"><spring:message code="button.issue" /></a></auth:button>
                
          </div>
        <table id="exec_dg" 
               class="easyui-datagrid" 
               style="width:100%"
               data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: true,
                url: 'quickcheck/plmexec/datagridUDA',
                toolbar:'#exec_dg_toolbar',
                striped:true, 
                method: 'get' ,
                emptyMsg: '<span><spring:message code='tip.noData'/></span>' 
                ">
            <thead >
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 配方编号 -->
                    <th data-options="field:'recipe_code_s',editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.recipe_code_s" /></th>
                    <!-- 配方状态 -->
                    <th data-options="field:'recipe_status_s',formatter:recipestatusText,editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.recipe_status_s" /></th>
                    <!-- 审核状态 -->
                    <th data-options="field:'check_state_s',styler:cellStyler,formatter:recordflagText,editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.check_state_s" /></th>
                
                    <!-- 物料品号 -->
                    <th data-options="field:'matersap_s',editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.matersap_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'matername_s',editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.matername_s" /></th>
               
                    <!-- 物料版本 -->
                    <th data-options="field:'materrevision_s',editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.materrevision_s" /></th>
                    <!-- 配方阶段 -->
                    <th data-options="field:'prescriptionstage_s',formatter:prescriptionstageText,editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.prescriptionstage_s" /></th>
                    <!-- 检验标准类型 -->
                    <th data-options="field:'inspectionstandardname_s',formatter:inspectionstandardnameText,editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.inspectionstandardname_s" /></th>
                    <!-- 工厂 -->
                    <th data-options="field:'plant_s',editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.plant_s" /></th>
                    <!-- 接收时间 -->
                    <th data-options="field:'receive_time_t',editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.receive_time_t" /></th>
                
                
                    <!-- 审核人 -->
                    <th data-options="field:'check_name_s',editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.check_by_s" /></th>
                    <!-- 审核时间 -->
                    <th data-options="field:'check_time_t',editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.check_time_t" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'send_name_s',editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.send_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'send_time_t',editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.send_time_t" /></th>
                    
                  </tr>
            </thead>
        </table>
    </div>
    
    <div data-options="region:'center',split:true" style="width:100px;"title="<spring:message code="rubber.quickcheck.standard.parameter.list" />">
		<form id="para_search_form" class="form" style="display:none">
                <spring:message code="plmquickcheckpara.column.recipe_code_s" />:
                <input name="filter[recipe_code_s]" id="recipe_code_s" type="text" class="easyui-textbox" data-options="label:''" >
              
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
