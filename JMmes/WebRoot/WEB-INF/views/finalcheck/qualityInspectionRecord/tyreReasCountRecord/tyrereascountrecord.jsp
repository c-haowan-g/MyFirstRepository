<!-- 

    作者      :李昂
    时间      :2020-07-27 13:15:13 
    页面名称:外观检测统计病象条码数量
    文件关联:
        TyreReasCountRecord.java
        TyreReasCountRecordController.java
        TyreReasCountRecordServiceImpl.java
        TyreReasCountRecordServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="tyrereascountrecord.js.jsp"%>
<script type="text/javascript" src="dict/252.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="TyreReasCountRecord_dg_toolbar">
            <form id="TyreReasCountRecord_search_form" class="form" >
                
                
                
                <!-- 工序名称 -->
                <spring:message code="tyrereascountrecord.column.curingmachinecode_s" />
                :&emsp;<input name="filter[curingmachinecode_s]" id="curingmachinecode_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 机台编码-->
                <spring:message code="tyrereascountrecord.column.spare2_s" />
                :&emsp;<input name="filter[spare2_s]" id="itemid_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 轮胎条码 -->
                <spring:message code="tyrereascountrecord.column.spare1_s" />
                :&emsp;<input name="filter[spare1_s]" id="proess_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 病象编码 -->
                <spring:message code="tyrereascountrecord.column.reas_code_s" />
                :&emsp;<input name="filter[reas_code_s]" id="reas_code_s" type="text" class="easyui-textbox" data-options="label:''" >
                </br>
                <!-- 创建时间 -->
                <spring:message code="tyrereascountrecord.column.created_time_t" />
                 :&emsp;<input name="filter[begin_created_time]" editable="true" id="begin_created_time"
				type="text" class="easyui-datetimebox" style="width:165px"data-options="label:''">
				
				&emsp;到&emsp; <input name="filter[end_created_time]" editable="true" id="end_created_time"
				class="easyui-datetimebox" style="width:165px">
               
                &emsp;<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <%-- <auth:button code="XXX"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            　
            <auth:button code="XXX"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button> --%>
            　
            <auth:button code="ZJ_ZJLL_QUAN_GANG_TRCRC_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            <auth:button code="LH_SCGL_PBCX_SEARCH"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-hide'" onclick="queryBar()"><spring:message code="button.searchColumn" /></a>  </auth:button>
        </div>
        <table id="tyrereascountrecord_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#TyreReasCountRecord_dg_toolbar',
                emptyMsg: '<span><spring:message code='tip.noData'/></span>',
                url: 'finalcheck/qualityInspectionRecord/tyrereascountrecord/datagridUDA',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 轮胎条码 -->
                    <th data-options="field:'spare1_s',align:'center',width:90,editor:{type:'textbox'}"><spring:message code="tyrereascountrecord.column.spare1_s" /></th>
                    <!-- 机台编码 -->
                    <th data-options="field:'spare2_s',align:'center',width:90,editor:{type:'textbox'}"><spring:message code="tyrereascountrecord.column.spare2_s" /></th>
                    <!-- 工序名称 -->
                    <th data-options="field:'curingmachinecode_s',align:'center',width:90,editor:{type:'textbox'}"><spring:message code="tyrereascountrecord.column.curingmachinecode_s" /></th>
                    <!-- 物料编号 -->
                    <th data-options="field:'itemid_s',align:'center',width:90,editor:{type:'textbox'}"><spring:message code="tyrereascountrecord.column.itemid_s" /></th>
                    <!-- 病象编码 -->
                    <th data-options="field:'reas_name_s',align:'center',width:90,editor:{type:'textbox'}"><spring:message code="tyrereascountrecord.column.reas_name_s" /></th>
                    <!-- 病象条码数量 -->
                    <th data-options="field:'reas_count_i',align:'center',width:90,editor:{type:'textbox'}"><spring:message code="tyrereascountrecord.column.reas_count_i" /></th>
                    <!-- 归档标记 -->
                    <th data-options="field:'arch_flag1_s',align:'center',width:90,editor:{type:'textbox'}"><spring:message code="tyrereascountrecord.column.arch_flag1_s" /></th>
                   	<!-- 工序 -->
                    <th data-options="field:'proess_s',formatter:codeFormatter,align:'center',width:90,editor:{type:'combotree',options:{
                    			method:'get',
                                url:'dict/code/252',
                                panelWidth:'300',
                    			required:true,
                    			}}"><spring:message code="tyrereascountrecord.column.proess_s" /></th>
                    
                    
                    <!-- 创建人 -->
                    <th data-options="field:'creation_by_created',align:'center',width:90,editor:{type:'textbox'}"><spring:message code="tyrereascountrecord.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',align:'center',width:130,editor:{type:'textbox'}"><spring:message code="tyrereascountrecord.column.created_time_t" /></th>
                    
                    
                    
                </tr>
            </thead>
        </table>
    </div>
    <!-- 	导出-->    
	<jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="TyreReasCountRecord_search_form" />
		<jsp:param name="datagridId" value="tyrereascountrecord_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.finalcheck.excel.TyreReasCountRecordExportHandler" />
		<jsp:param name="serviceName" value="TyreReasCountRecordServiceImpl" />
	</jsp:include>
</body>
</html>
