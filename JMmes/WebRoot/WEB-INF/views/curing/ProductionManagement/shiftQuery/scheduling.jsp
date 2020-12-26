<!-- 

    作者      :时永良
    时间      :2019年7月22日14:48:10 
    页面名称:人员排班查询
    文件关联:
        Scheduling.java
        SchedulingController.java
        SchedulingServiceImpl.java
        SchedulingServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="scheduling.js.jsp"%>
<script type="text/javascript" src="dict/302.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="Scheduling_dg_toolbar">
            <form id="Scheduling_search_form" class="form" >
                <!-- 生产日期 -->
                <spring:message code="scheduling.column.product_date_s" />:
                <input name="filter[product_date_s]" id="product_date_s" type="text" class="easyui-datebox" data-options="label:''" >
                <!-- 班次 -->
                <spring:message code="scheduling.column.class_id_s" />:
                <input name="filter[class_id_s]" id="class_id_s" style="width:120px" type="text" class="easyui-combotree" data-options="label:'',
                  labelWidth:'auto',
                  editable:'true',
				  panelWidth:'120',
				  required:false,
				  url:'dict/code/302',
				  method:'get',
				  label:''" >
				<spring:message code="scheduling.column.user_id_s" />:
                <input name="filter[user_id_s]" id="user_id_s" style="width:15%" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 机台编码 -->
                <spring:message code="scheduling.column.equip_code_s" />:
                <input name="filter[equip_code_s]" id="equip_code_s" style="width:15%" type="text" class="easyui-textbox" data-options="label:''" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            
        </div>
        <div id="Btool">
        	<auth:button code="LH_SCGL_PBCX_EXPORT"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            <auth:button code="LH_SCGL_PBCX_EQU"><a href="javascript:void(0)" class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-search'" onclick="equWin()"><spring:message code="scheduling.column.edu" /></a></auth:button>
            <auth:button code="LH_SCGL_PBCX_SEARCH"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-hide'" onclick="queryBar()"><spring:message code="button.searchColumn" /></a>  </auth:button>
            
        </div>
        <table id="scheduling_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#Scheduling_dg_toolbar,#Btool',
                striped:true,
                method: 'get', 
                 emptyMsg:'<span><spring:message code='tip.noData'/></span>',
                ">
            <thead>
                <tr>
                	<th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 领用日期 -->
                    <th data-options="field:'product_date_s',width:80,editor:{type:'textbox'}"><spring:message code="scheduling.column.product_date_s" /></th>
                    <!-- 班次 -->
                    <th data-options="field:'class_id_s',width:100,formatter:codeFormatter,editor:{type:'combotree',options:{
                    			method:'get',
                                url:'dict/code/302',
                                panelWidth:'300',
                    			required:true,
                    			}}"><spring:message code="scheduling.column.class_id_s" /></th>
                    <!-- 人员编码 -->
                    <th data-options="field:'user_id_s',width:80,editor:{type:'textbox'}"><spring:message code="scheduling.column.user_id_s" /></th>
                    <!-- 人员名称 -->
                    <th data-options="field:'user_name_s',width:80,editor:{type:'textbox'}"><spring:message code="scheduling.column.user_name_s" /></th>
                    <!-- 机台条码 -->
                    <th data-options="field:'equip_code_s',width:80,editor:{type:'textbox'}"><spring:message code="scheduling.column.equip_code_s" /></th>
                    <!-- 扫描时间 -->
                    <th data-options="field:'start_time_t',width:100,editor:{type:'textbox'}"><spring:message code="scheduling.column.start_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
    
    <!-- 	导出-->    
	<jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="Scheduling_search_form" />
		<jsp:param name="datagridId" value="scheduling_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.curing.excel.SchedulingExportHandler" />
		<jsp:param name="serviceName" value="SchedulingServiceImpl" />
	</jsp:include>
	
<!-- 	未领用机台信息查询
 -->    
 <div id="w" class="easyui-window" title="未领用机台信息" data-options="modal:true,closed:true,iconCls:'icon-search'" style="width:80%;height:60%;padding:10px;">
    <table id="equ_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                rownumbers: true,
                singleSelect: false,
                url: 'curing/productionManagement/shiftQuery/getEqu',
                striped:true,
                method: 'get', 
                emptyMsg:'暂无数据',
                 onLoadSuccess : function(data) {
				$('#equ_dg').datagrid('enableFilter');
				}
                ">
            <thead>
                <tr>
                    <!-- 机台条码 -->
                    <th data-options="field:'EQUIP_CODE_S',width:80,editor:{type:'textbox'}"><spring:message code="scheduling.column.equip_code_s" /></th>
                    <!-- 机台名称 -->
                    <th data-options="field:'EQUIP_NAME_S',width:80,editor:{type:'textbox'}"><spring:message code="scheduling.column.equip_name_s" /></th>
                </tr>
            </thead>
        </table>
        </div>
</body>
</html>
