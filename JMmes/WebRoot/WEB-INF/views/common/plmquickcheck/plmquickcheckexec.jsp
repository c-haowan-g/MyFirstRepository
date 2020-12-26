<!-- 

    作者      :肖吉朔
    时间      :2020-08-18 10:23:37 
    页面名称:PLM快检标准参数从表
    文件关联:
        plmquickcheckexec.java
        plmquickcheckexecController.java
        plmquickcheckexecServiceImpl.java
        plmquickcheckexecServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/meta.jsp"%>
<%@ include file="plmquickcheckexec.js.jsp"%>


<body class="easyui-layout" fit="true"> 
     <div data-options="region:'west',split:true" style="width:60%;">
        <div id="plmquickcheckexec_dg_toolbar">
            <form id="plmquickcheckexec_search_form" class="form" >
                 <input type="radio" name="dummy4_s" value="real_time">
                                 实时时间
                <input type="radio" name="dummy4_s" value="his_time" checked>
                                  历史时间
                <spring:message code="quickcheckexec.column.sync_create_time_t" />
                <input name="filter[start_time]" id="start_time" type="text" class="easyui-datetimebox" data-options="label:''" >
                <spring:message code="tip.to" /><input name="filter[end_time]" id="end_time" type="text" class="easyui-datetimebox" data-options="label:''" >
                <br>
                <!--配方编号-->
                <spring:message code="plmquickcheck.column.recipe_code_s" />:
                <input name="filter[recipe_code_s]" id="recipe_code" type="text" style="width:125px;" class="easyui-textbox" data-options="label:''" >

                <!-- 物料编码-->
                <spring:message code="plmquickcheck.column.matersap_s" />:
                <input name="filter[matersap_s]" id="matersap_s" type="text" style="width:134px;" like="true" class="easyui-textbox" data-options="label:''" >
                <!-- 物料名称-->
                <spring:message code="plmquickcheck.column.matername_s" />:
                <input name="filter[matername_s]" id="matername_s" like="true" style="width:110px;" type="text" class="easyui-textbox" data-options="label:''" >
                </br>
                <!--配方状态-->
                <spring:message code="plmquickcheck.column.recipe_status_s" />:
                <input name="filter[recipe_status_s]" id="recipe_status_s"  style="width:110px;" type="text" class="easyui-combotree" data-options="labelWidth:'auto',
                                            panelHeight:100,
										    required:false,
										    editable:false,
										    data:recipeStatus,
										    textField:'text',
										    valueField:'code',
										    method:'get'" >
				
				 <!--下发标识-->
                <spring:message code="plmquickcheck.column.send_state_s" />:
                <input name="filter[send_state_s]" id="send_state_s"  style="width:110px;" type="text" class="easyui-combobox" data-options="label:'',
                                        required:false,
                                       	 data: [{
											text: '未下发',
											value: '0'
										},{
											text: '已下发',
											value: '1'
										},{
											text: '下发失败',
											value: '2'
										}],
			                             method: 'get'" >
               
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-add'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
        </div>
        <table id="plmquickcheck_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: true,
                toolbar: '#plmquickcheckexec_dg_toolbar',
                <%--url: 'commom/quickcheckexec/datagrid',--%>
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 数据同步处理：A-新增、U-修改、D-删除 -->
                    <th data-options="field:'sync_flag_s',formatter:syncFormatter,editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.sync_flag_s" /></th>
                    <!-- 同步时间 -->
                    <th data-options="field:'sync_create_time_t',editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.sync_create_time_t" /></th>
                    <!-- 数据同步处理标记：0-未处理、1-已处理 -->
                    <th data-options="field:'sync_hand_flag_s',formatter:flagFormatter,editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.sync_hand_flag_s" /></th>                    
                    <!-- 数据同步处理时间 -->
                    <th data-options="field:'sync_hand_time_t',editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.sync_hand_time_t" /></th>
                    <!-- 数据同步处理反馈 -->
                    <th data-options="field:'sync_hand_msg_s',editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.sync_hand_msg_s" /></th>
                    <!-- 配方编号-13位：Java系统当前时间 例如 1552888628141 -->
                    <th data-options="field:'recipe_code_s',editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.recipe_code_s" /></th>
                    <!-- 配方状态：323001-待用、323002-正用、323003-停用 -->
                    <th data-options="field:'recipe_status_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.recipe_status_s" /></th>                  
                    <!-- 物料品号：存储9位品号（返回胶、实验胶11位，例如 300000308_-F） -->
                    <th data-options="field:'matersap_s',editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.matersap_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'matername_s',editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.matername_s" /></th>
                    <!-- 物料版本 -->
                    <th data-options="field:'materrevision_s',editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.materrevision_s" /></th>
                    <!-- 配方阶段：ZC-正常、SY-不正常 -->
                    <th data-options="field:'prescriptionstage_s',editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.prescriptionstage_s" /></th>
                    <!-- 检验标准类型：考核标准、检验标准、专检标准 -->
                    <th data-options="field:'inspectionstandardname_s',formatter:typeformatter,editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.inspectionstandardname_s" /></th>
                    <!-- 工厂 -->
                    <th data-options="field:'plant_s',editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.plant_s" /></th>
                    <!-- 接收时间 -->
                    <th data-options="field:'receive_time_t',editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.receive_time_t" /></th>
                    <!-- 审核状态：0-未审核、1-已审核 -->
                    <th data-options="field:'check_state_s',formatter:stateFormatter,editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.check_state_s" /></th>
                    <!-- 下发人姓名 -->
                    <th data-options="field:'send_name_s',editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.send_name_s" /></th>
                    <!-- 下发时间 -->
                    <th data-options="field:'send_time_t',editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.send_time_t" /></th>
                    <!-- 下发标识（下发成功后置逻辑删除）：0-未下发、1-已下发 -->
                    <th data-options="field:'send_state_s',formatter:sendFormatter,editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.send_state_s" /></th>
                    <!-- 配方启停人姓名 -->
                    <th data-options="field:'recipe_name_s',editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.recipe_name_s" /></th>
                    <!-- 配方启停时间 -->
                    <th data-options="field:'recipe_time_t',editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.recipe_time_t" /></th>
                     <!-- 预留1 -->
                    <th data-options="field:'dummy1_s',editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.dummy1_s" /></th>
                    <!-- 预留2 -->
                    <th data-options="field:'dummy2_s',editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.dummy2_s" /></th>
                    <!-- 预留3 -->
                    <th data-options="field:'dummy3_s',editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.dummy3_s" /></th>
                    <!-- 预留4 -->
                    <th data-options="field:'dummy4_s',editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.dummy4_s" /></th>
                    <!-- 预留5 -->
                    <th data-options="field:'dummy5_s',editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.dummy5_s" /></th>
                    
                    <%-- <!-- 修改人 -->
                    <th data-options="field:'changed_by_s',editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.changed_by_s" /></th>
                    <!-- 修改人姓名 -->
                    <th data-options="field:'changed_name_s',editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.changed_name_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.changed_time_t" /></th>
                    <!-- 审核人 -->
                    <th data-options="field:'check_by_s',editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.check_by_s" /></th>
                    <!-- 审核人姓名 -->
                    <th data-options="field:'check_name_s',editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.check_name_s" /></th>
                    <!-- 审核时间 -->
                    <th data-options="field:'check_time_t',editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.check_time_t" /></th>
                    <!-- 创建日期 -->
                    <th data-options="field:'createdate_s',editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.createdate_s" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'createuser_s',editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.createuser_s" /></th>
                    <!-- GUID，同一次报文传递的数据 -->
                    <th data-options="field:'guid_s',editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.guid_s" /></th>
                    <!-- 主键ID -->
                    <th data-options="field:'id_s',editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.id_s" /></th>
                    <!-- 物料品号 -->
                    <th data-options="field:'matersap_temp_s',editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.matersap_temp_s" /></th>
                    <!-- 配方启停人 -->
                    <th data-options="field:'recipe_by_s',editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.recipe_by_s" /></th>
                    <!-- 记录标志，A可用，D删除 -->
                    <th data-options="field:'record_flag_s',editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.record_flag_s" /></th>
                    <!-- 下发人 -->
                    <th data-options="field:'send_by_s',editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.send_by_s" /></th>
                    <!-- 工厂（1全钢 2半钢） -->
                    <th data-options="field:'s_factory_s',editor:{type:'textbox'}"><spring:message code="quickcheckexec.column.s_factory_s" /></th> --%>
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
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
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
