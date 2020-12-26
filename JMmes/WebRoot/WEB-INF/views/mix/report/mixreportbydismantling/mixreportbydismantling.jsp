<!-- 

    作者      :陈国强
    时间      :2020-08-25 16:38:18 
    页面名称:密炼拆胶产量统计报表
    文件关联:
        MixReportByDismantling.java
        MixReportByDismantlingController.java
        MixReportByDismantlingServiceImpl.java
        MixReportByDismantlingServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="mixreportbydismantling.js.jsp"%>
<script type="text/javascript" src="dict/054,302,053.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="MixReportByDismantling_dg_toolbar">
            <form id="MixReportByDismantling_search_form" class="form" >
            	<!-- 工单生产日期 -->
            	<spring:message code="生产日期"/>
            	<input name="filter[start_time]" id="start_time" style="width:90px" type="text" 
            		class="easyui-datebox"
            		data-options="formatter:dateFormat,buttons:[],parser:dateParser,label:''">
            	<script type="text/javascript">
            		$("#start_time").val(new Calendar().format("yyyyMMdd"));
            	</script>
            	&nbsp;<strong>到</strong>&nbsp; 
            	<input name="filter[end_time]" id="end_time" style="width: 90px" type="text"
					class="easyui-datebox"
					data-options="formatter:dateFormat,buttons:[],parser:dateParser,label:''">
				<script type="text/javascript">
					$("#end_time").val(new Calendar().format("yyyyMMdd"));
				</script> 
                <!-- 操作生产班次：302001-早班、302002-中班、302003-晚班 -->
                <spring:message code="班次" />
                <input name="filter[prod_shift_code_s]" id="prod_shift_code_s" type="text" class="easyui-combotree" 
                data-options="label:'',
                 					required:false,
				              		panelHeight:200,
				              		url:'dict/code/302',
				              		method:'get',
				              		onChange:filter" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
                <a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="doExport()"><spring:message code="button.export" /></a>
            </form> 
            <%-- <auth:button code="XXX"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            　
            <auth:button code="XXX"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            　
            <auth:button code="XXX"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="export()"><spring:message code="button.export" /></a></auth:button>
         --%>
         </div>
        <table id="mixreportbydismantling_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: false,
                singleSelect:true,
                toolbar: '#MixReportByDismantling_dg_toolbar',
                url: 'mix/report/mixreportbydismantling/datagrid',
                striped:true,
                onBeforeLoad:dlg1BeforeLoad, 
                method: 'get' 
                ">
            <thead>
                <tr>
                    
                    <!-- 操作生产班次：302001-早班、302002-中班、302003-晚班 -->
                    <th data-options="field:'prod_shift_code_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="生产班次" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',editor:{type:'textbox'}"><spring:message code="mixreportbydismantling.column.material_code_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'material_name_s',editor:{type:'textbox'}"><spring:message code="mixreportbydismantling.column.material_name_s" /></th>
                    <!-- 备用字段6：拆批人 -->
                    <th data-options="field:'spare6_s',editor:{type:'textbox'}"><spring:message code="拆批人" /></th>
                    <!-- 总框数 -->
                    <th data-options="field:'framenumber',width:80"><spring:message code="总框数" /></th>
                    <!-- 总重量 -->
                    <th data-options="field:'qtyleft',width:80"><spring:message code="总数量" /></th>
                </tr>
            </thead>
        </table>
    </div>
</body>
</html>
