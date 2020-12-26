<!-- 

    作者      :陈国强
    时间      :2020-09-14 08:37:19 
    页面名称:密炼小料产出实绩表
    文件关联:
        MixRecipeProd.java
        MixRecipeProdController.java
        MixRecipeProdServiceImpl.java
        MixRecipeProdServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="mixrecipeprod.js.jsp"%>
<script type="text/javascript" src="dict/075,302,321,323,302.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="MixRecipeProd_dg_toolbar">
            <form id="MixRecipeProd_search_form" class="form" >
            <!-- 工单生产日期 -->
				<spring:message code="mixrecipeprod.column.prod_date_s" />
				<input name="filter[start_time]" id="start_time" 
						style="width: 90px" type="text" class="easyui-datebox"
					data-options="formatter:dateFormat,buttons:[],parser:dateParser,label:''">
				<script type="text/javascript">
					$("#start_time").val(new Calendar().format("yyyyMMdd"));
				</script>
				 &nbsp;<strong>到</strong>&nbsp; <input name="filter[end_time]"
					id="end_time" style="width: 90px" type="text"
					class="easyui-datebox"
					data-options="formatter:dateFormat,buttons:[],parser:dateParser,label:''">
				<script type="text/javascript">
					$("#end_time").val(new Calendar().format("yyyyMMdd"));
				</script> 
                <!-- 机台条码 -->
                <spring:message code="mixrecipeprod.column.equip_code_s" />
                <input name="filter[equip_code_s]" id="equip_code_s" type="text" style="width: 145px" class="easyui-combobox"
                 data-options="label:'',
                       data:equiplist2,
	         		   panelHeight:150,
	         		   editable:true,
	           		   valueField:'p_line_name',
	          		   textField:'description',
	                   selectOnNavigation:false,
	           		   limitToList:true,
	          		   filter:searchProductionLine,
	           		   onChange:filter" >
                <!-- 物料编码 -->
                <spring:message code="mixrecipeprod.column.material_code_s" />
                <input name="filter[material_code_s]" id="material_code_s" type="text" class="easyui-textbox" data-options="label:''" >
                <%-- <!-- 物料名称 -->
                <input name="filter[material_name_s]" id="material_name_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="mixrecipeprod.column.material_name_s" />'" >
                 --%>
                <!-- 密炼工单跟踪表，工单号 -->
                <spring:message code="mixrecipeprod.column.wo_no_s" />
                <input name="filter[wo_no_s]" id="wo_no_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 批次信息，长度19位 小料批次号：固定字符+工厂+生产日期+班次+机台+计划号+流水号 自动配料：FA91907011010010001 人工配料：FH91907011010010001 -->
                <spring:message code="mixrecipeprod.column.lot_no_s" />
                <input name="filter[lot_no_s]" id="lot_no_s" type="text" class="easyui-textbox" data-options="label:''" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <%-- <auth:button code="XXX"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            　
            <auth:button code="XXX"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            　
            <auth:button code="XXX"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="export()"><spring:message code="button.export" /></a></auth:button> --%>
        </div>
        <table id="mixrecipeprod_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
            	checkOnSelect: false, 
                selectOnCheck: false,  
                fit:true,
                fitColumns:false,
                pagination:true,
                pageSize: 100,
                rownumbers: true,
                singleSelect: true,
                toolbar: '#MixRecipeProd_dg_toolbar',
                url: 'mix/productionManagement/mixrecipeprod/datagrid',
                striped:true,
                onSelect:selectrow,
                onBeforeLoad:dlg1BeforeLoad,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 生产日期 -->
                    <th data-options="field:'prod_date_s',width:65"><spring:message code="mixrecipeprod.column.prod_date_s" /></th>
                    <!-- 班次 -->
                    <th data-options="field:'shift_code_s',formatter:codeFormatter,width:40"><spring:message code="mixrecipeprod.column.shift_code_s" /></th>
                    <!-- 机台名称 -->
                    <th data-options="field:'equip_name_s',width:150"><spring:message code="mixrecipeprod.column.equip_name_s" /></th>
                    <!-- 密炼工单跟踪表，工单号 -->
                    <th data-options="field:'wo_no_s',width:120"><spring:message code="mixrecipeprod.column.wo_no_s" /></th>
                    <!-- 批次信息，长度19位 小料批次号：固定字符+工厂+生产日期+班次+机台+计划号+流水号 自动配料：FA91907011010010001 人工配料：FH91907011010010001 -->
                    <th data-options="field:'lot_no_s',width:150"><spring:message code="mixrecipeprod.column.lot_no_s" /></th>
                    <!-- 生产日期 -->
                    <th data-options="field:'prod_date_s',width:80"><spring:message code="mixrecipeprod.column.prod_date_s" /></th>
                    <!-- 产出时间 -->
                    <th data-options="field:'product_time_t',width:140"><spring:message code="mixrecipeprod.column.product_time_t" /></th>
                    <!-- 产出重量 -->
                    <th data-options="field:'output_weight_s',width:80"><spring:message code="mixrecipeprod.column.output_weight_s" /></th>
                    <!-- 称量总重量 -->
                    <th data-options="field:'totalweight_s',width:80"><spring:message code="mixrecipeprod.column.totalweight_s" /></th>
                    <!-- 误差 -->
                    <th data-options="field:'error_out_s',width:80"><spring:message code="mixrecipeprod.column.error_out_s" /></th>
                    <!-- 是否超差：0-正常、1-超差 -->
                    <th data-options="field:'warning_sgn_s',formatter:warningsgnFormatter,width:80"><spring:message code="mixrecipeprod.column.warning_sgn_s" /></th>
            	    <!-- 车次 -->
                    <th data-options="field:'serial_id_s',width:80"><spring:message code="mixrecipeprod.column.serial_id_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',width:80"><spring:message code="mixrecipeprod.column.material_code_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'material_name_s',width:200"><spring:message code="mixrecipeprod.column.material_name_s" /></th>
                    <!-- 班次 -->
                    <th data-options="field:'shift_code_s',formatter:codeFormatter,width:80"><spring:message code="mixrecipeprod.column.shift_code_s" /></th>
                    <!-- 密炼生成配方编号，外键 -->
                    <th data-options="field:'recipe_code_s',width:120"><spring:message code="mixrecipeprod.column.recipe_code_s" /></th>
                    <!-- 密炼配方BOM版本 -->
                    <th data-options="field:'recipe_bom_version_s',width:80"><spring:message code="mixrecipeprod.column.recipe_bom_version_s" /></th>
                    <!-- 数据来源：075001-全钢-万向、075002-全钢-北院、075003-半钢-软控、075004-半钢-万向、075005-人工配料、075006-快检、075007-地磅、075008-密炼产出、075009-MES -->
                    <th data-options="field:'datasource_s',formatter:codeFormatter,width:100"><spring:message code="mixrecipeprod.column.datasource_s" /></th>
                    <!-- 接收时间 -->
                    <th data-options="field:'receive_time_t',width:140"><spring:message code="mixrecipeprod.column.receive_time_t" /></th>
                    <!-- 小料车装车总袋数 -->
                    <th data-options="field:'dummy1_s',width:150"><spring:message code="mixrecipeprod.column.dummy1_s" /></th>
                    <!-- 备用2 -->
                    <th data-options="field:'dummy2_s',width:100"><spring:message code="mixrecipeprod.column.dummy2_s" /></th>
                    <!-- 备用3 -->
                    <th data-options="field:'dummy3_s',width:220"><spring:message code="mixrecipeprod.column.dummy3_s" /></th>
                    <!-- 备用4 -->
                    <th data-options="field:'dummy4_s',width:220"><spring:message code="mixrecipeprod.column.dummy4_s" /></th>
                    <!-- 备用5 -->
                    <th data-options="field:'dummy5_s',width:80"><spring:message code="mixrecipeprod.column.dummy5_s" /></th>
              	</tr>
            </thead>
        </table>
    </div>
    <div data-options="region:'south',split:true" style="height: 200px;">
		<div class="easyui-tabs" id="content_tab"
			data-options="fit:true,tools:'#tab-tools'">
			<div title="小料包明细" style="padding: 10px">
				<table id="drprodxl_dg" class="easyui-datagrid" style="width: 100%"
					data-options="  
						                fit:true,
									    fitColumns:false,
						                pagination:true,
						                pageSize: 30,
						                rownumbers:true,
						                singleSelect: true,
						                striped:true,
						                emptyMsg: '<span><spring:message code='tip.noData'/></span>',
						                remoteSort:false,
						                method: 'get'
						                				">
					<thead>
						<tr>

							<!-- 机台名称 -->
							<th data-options="field:'equip_name_s',width:150"><spring:message
									code="drprodxl.column.equip_name_s" /></th>
							<!-- 批次信息，长度19位 小料批次号：固定字符+工厂+生产日期+班次+机台+计划号+流水号 自动配料：FA91907011010010001 人工配料：FH91907011010010001 -->
							<th data-options="field:'lot_no_s',width:150"><spring:message
									code="drprodxl.column.lot_no_s" /></th>
							<!-- 产出时间 -->
							<th data-options="field:'product_time_t',width:140"><spring:message
									code="drprodxl.column.product_time_t" /></th>
							<!-- 产出重量 -->
							<th
								data-options="field:'output_weight_s',width:80"><spring:message
									code="drprodxl.column.output_weight_s" /></th>
							<!-- 称量总重量 -->
							<th data-options="field:'totalweight_s',width:80"><spring:message
									code="drprodxl.column.totalweight_s" /></th>
							<!-- 误差 -->
							<th data-options="field:'error_out_s',width:80"><spring:message
									code="drprodxl.column.error_out_s" /></th>
							<!-- 是否超差：0-正常、1-超差 -->
							<th
								data-options="field:'warning_sgn_s',formatter:warningsgnFormatter,width:80"><spring:message
									code="drprodxl.column.warning_sgn_s" /></th>
							<!-- 车次 -->
							<th data-options="field:'serial_id_s',width:80"><spring:message
									code="drprodxl.column.serial_id_s" /></th>
							<!-- 物料编码 -->
							<th
								data-options="field:'material_code_s',width:100"><spring:message
									code="drprodxl.column.material_code_s" /></th>
							<!-- 物料名称 -->
							<th
								data-options="field:'material_name_s',width:200"><spring:message
									code="drprodxl.column.material_name_s" /></th>
							<!-- 班次 -->
							<th
								data-options="field:'shift_code_s',formatter:codeFormatter,width:80"><spring:message
									code="drprodxl.column.shift_code_s" /></th>
							<!-- 密炼生成配方编号，外键 -->
							<th data-options="field:'recipe_code_s',width:120"><spring:message
									code="drprodxl.column.recipe_code_s" /></th>
							<!-- 密炼配方BOM版本 -->
							<th
								data-options="field:'recipe_bom_version_s',width:80"><spring:message
									code="drprodxl.column.recipe_bom_version_s" /></th>
							<!-- 数据来源 -->
							<th
								data-options="field:'datasource_s',formatter:codeFormatter,width:100"><spring:message
									code="drprodxl.column.datasource_s" /></th>
							<!-- 接收时间 -->
							<th data-options="field:'receive_time_t',width:140"><spring:message
									code="drprodxl.column.receive_time_t" /></th>
							<!-- 备用1 -->
							<th data-options="field:'dummy1_s',width:180"><spring:message
									code="drprodxl.column.dummy1_s" /></th>
							<!-- 备用2 -->
							<th data-options="field:'dummy2_s',width:100"><spring:message
									code="drprodxl.column.dummy2_s" /></th>
							<!-- 备用3 -->
							<th data-options="field:'dummy3_s',width:220"><spring:message
									code="drprodxl.column.dummy3_s" /></th>
							<!-- 备用4 -->
							<th data-options="field:'dummy4_s',width:220"><spring:message
									code="drprodxl.column.dummy4_s" /></th>
							<!-- 备用5 -->
							<th data-options="field:'dummy5_s',width:80"><spring:message
									code="drprodxl.column.dummy5_s" /></th>

						</tr>
					</thead>
				</table>
	</div>
</body>
</html>
