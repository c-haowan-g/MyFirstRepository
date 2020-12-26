<!-- 

    作者      :栾和源
    时间      :2020-08-07 16:31:49 
    页面名称:密炼退料登记表
    文件关联: 
        MixMaterialReturn.java
        MixMaterialReturnController.java
        MixMaterialReturnServiceImpl.java
        MixMaterialReturnServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="mixmaterialreturn.js.jsp"%>
<script type="text/javascript" src="dict/301,302,077,078.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="MixMaterialReturn_dg_toolbar">
            <form id="MixMaterialReturn_search_form" class="form" >
            	<!-- 班次：302001-早班、302002-中班、302003-晚班 -->
            	&nbsp;&nbsp;<spring:message code="mixmaterialreturn.column.shift_code" />
                &nbsp;<input name="filter[shift_code_s]" id="shift_code_s" style="width:110px" type="text" class="easyui-combotree" data-options="label:'',
                			required:false,
				            panelHeight:200,
				            url:'dict/code/302',
				            method:'get'" >
                <!-- 登记类型：078001-返回胶、078002-退库 -->
                &nbsp;&nbsp;<spring:message code="mixmaterialreturn.column.return_type" />
                &nbsp;<input name="filter[return_type_s]" id="return_type_s" style="width:110px" type="text" class="easyui-combotree" data-options="label:'',
                			required:false,
				            panelHeight:200,
				            url:'dict/code/078',
				            method:'get'" >
                <!-- 物料编码 -->
                &nbsp;&nbsp;<spring:message code="mixmaterialreturn.column.material_code_s" />
                &nbsp;<input name="filter[material_code_s]" id="material_code_s" style="width:110px" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 批次号 -->
                &nbsp;&nbsp;<spring:message code="mixmaterialreturn.column.lot_no_s" />
                &nbsp;<input name="filter[lot_no_s]" id="lot_no_s" type="text" style="width:110px" class="easyui-textbox" data-options="label:''" >
                <!-- 载具条码 -->
                &nbsp;&nbsp;<spring:message code="mixmaterialreturn.column.carrier_code_s" />
                &nbsp;<input name="filter[carrier_code_s]" id="carrier_code_s" style="width:110px" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 操作时间 -->
                <spring:message code="mixmaterialreturn.column.created_time" />&nbsp;:&nbsp;<input name="filter[begintime]" editable="true" id="begin_created_time" type="text" class="easyui-datetimebox" style="width:160px" data-options="label:''">
				&nbsp;到&nbsp; <input name="filter[endtime]" editable="true" id="end_created_time" type="text" class="easyui-datetimebox" style="width:160px" data-options="label:''">&nbsp;&nbsp;&nbsp;
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
                 <auth:button code="mixmaterialreturn.export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            </form> 
        </div>
        <table id="mixmaterialreturn_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#MixMaterialReturn_dg_toolbar',
                url: '',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 班组：301001-甲班、301002-乙班、301003-丙班 -->
                    <th data-options="field:'group_code_s',width:'80px',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="mixmaterialreturn.column.group_code" /></th>
                    <!-- 班次：302001-早班、302002-中班、302003-晚班 -->
                    <th data-options="field:'shift_code_s',width:'80px',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="mixmaterialreturn.column.shift_code" /></th>
                    <!-- 登记类型：078001-返回胶、078002-退库 -->
                    <th data-options="field:'return_type_s',width:'80px',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="mixmaterialreturn.column.return_type" /></th>
                    <!-- 退回工区：077001-密炼、077002-半部件、077003-成型 -->
                    <th data-options="field:'workarea_s',width:'80px',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="mixmaterialreturn.column.workarea" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmaterialreturn.column.material_code_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'material_name_s',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmaterialreturn.column.material_name_s" /></th>
                    <!-- 产出时间 -->
                    <th data-options="field:'prod_time_t',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmaterialreturn.column.prod_time_t" /></th>
                    <!-- 净重 -->
                    <th data-options="field:'net_weight_f',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmaterialreturn.column.net_weight_f" /></th>
                    <!-- 批次号 -->
                    <th data-options="field:'lot_no_s',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmaterialreturn.column.lot_no_s" /></th>
                    <!-- 载具条码 -->
                    <th data-options="field:'carrier_code_s',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmaterialreturn.column.carrier_code_s" /></th>
                    <!-- 胶案重量 -->
                    <th data-options="field:'carrier_weight_f',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmaterialreturn.column.carrier_weight_f" /></th>
                    <!-- 皮重 -->
                    <th data-options="field:'tare_weight_f',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmaterialreturn.column.tare_weight_f" /></th>
                    <!-- 物料过期日期 -->
                    <th data-options="field:'expiry_date_t',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmaterialreturn.column.expiry_date_t" /></th>
                    <!-- 主机手姓名 -->
                    <th data-options="field:'master_name_s',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmaterialreturn.column.master_name_s" /></th>
                    <!-- 是否色标与胶号一样：0-否、1-是 -->
                    <th data-options="field:'is_colorcode_s',width:'130px',formatter:isornotFormatter,editor:{type:'textbox'}"><spring:message code="mixmaterialreturn.column.is_colorcode" /></th>
                    <!-- 是否存在杂物：0-否、1-是 -->
                    <th data-options="field:'is_impurity_s',width:'80px',formatter:isornotFormatter,editor:{type:'textbox'}"><spring:message code="mixmaterialreturn.column.is_impurity" /></th>
                    <!-- 是否已打印流转卡（扉子）：0-否、1-是 -->
                    <th data-options="field:'is_print_s',width:'80px',formatter:isornotFormatter,editor:{type:'textbox'}"><spring:message code="mixmaterialreturn.column.is_print" /></th>
                    <!-- 是否为机头返回胶：0-否、1-是 -->
                    <th data-options="field:'is_return_s',width:'130px',formatter:isornotFormatter,editor:{type:'textbox'}"><spring:message code="mixmaterialreturn.column.is_return" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_s',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmaterialreturn.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',width:'130px',editor:{type:'textbox'}"><spring:message code="mixmaterialreturn.column.created_time_t" /></th>
                     <!-- 修改人 -->
                    <th data-options="field:'changed_by_s',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmaterialreturn.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',width:'130px',editor:{type:'textbox'}"><spring:message code="mixmaterialreturn.column.changed_time_t" /></th>
                    <!-- 备注 -->
                    <th data-options="field:'memo_s',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmaterialreturn.column.memo_s" /></th>
                    
                </tr>
            </thead>
        </table>
    </div>
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="MixMaterialReturn_search_form" />
		<jsp:param name="datagridId" value="mixmaterialreturn_dg" />	
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.mix.export.MixMaterialReturnExportHandler" />
		<jsp:param name="serviceName" value="MixMaterialReturnServiceImpl" />
	</jsp:include>  
</body>
</html>
