<!-- 

    作者      :李德晓
    时间      :2020-08-10 15:29:52 
    页面名称:原材料称量表
    文件关联:
        WeightFactory.java
        WeightFactoryController.java
        WeightFactoryServiceImpl.java
        WeightFactoryServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="weightfactory.js.jsp"%>
<script type="text/javascript" src="dict/343,344,347,302,007.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="WeightFactory_dg_toolbar">
            <form id="WeightFactory_search_form" class="form" >
                 <!-- 到货日期 -->
                到货日期
                

                <input name="filter[start_time]" id="start_time" type="text" class="easyui-datetimebox" data-options="label:''" >
                到<input name="filter[end_time]" id="end_time" type="text" class="easyui-datetimebox" data-options="label:''" >
                <!-- SAP内向交货单表，内向交货单号 -->
                内向交货单号
                <input name="filter[dn_dnno_s]" id="dn_dnno_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 供应商编号 -->
                供应商编号
                <input name="filter[supplier_code_s]" id="supplier_code_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 称量状态 -->
                称量状态
                <input name="filter[status_s]" id="status_s" type="text" class="easyui-combotree" data-options="label:'',
                         required:false,
                         url:'dict/code/007',
				  			method:'get',
				  			label:''" >

                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()">查询</a>
                <auth:button code="RAW_Stock Management_materialWeightFactory_export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            </form> 
        </div>
        <table id="weightfactory_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#WeightFactory_dg_toolbar',
                url: 'material/stockManagement/weightManagement/datagrid',
                striped:true,
                method: 'get' 
                ">
            <thead>
                 <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    
                    
                    <!-- SAP内向交货单表，出货单行号 -->
                    <th data-options="field:'dn_salorditem_s',editor:{type:'textbox'}">出货单行号</th>
                    <!-- SAP内向交货单表，出货单单号 -->
                    <th data-options="field:'dn_salordid_s',editor:{type:'textbox'}">出货单单号</th>
                    <!-- SAP内向交货单表，内向交货单号 -->
                    <th data-options="field:'dn_dnno_s',editor:{type:'textbox'}">内向交货单号</th>
                    <!-- SAP内向交货单表，内向交货单行号 -->
                    <th data-options="field:'dn_dnitem_s',editor:{type:'textbox'}">内向交货单行号</th>
                    <!-- SAP内向交货单表，ERP 采购订单号 -->
                    <th data-options="field:'dn_referenceno_s',editor:{type:'textbox'}">ERP 采购订单号</th>
                    <!-- SAP内向交货单表，ERP 采购订单行号 -->
                    <th data-options="field:'dn_referenceitem_s',editor:{type:'textbox'}">ERP 采购订单行号</th>
                    <!-- 到货日期 -->
                    <th data-options="field:'delivery_date_s',editor:{type:'textbox'}">到货日期</th>
                    <!-- 供货批号：厂家批次 -->
                    <th data-options="field:'supplier_lot_no_s',editor:{type:'textbox'}">厂家批次</th>
                    <!-- 供应商编号 -->
                    <th data-options="field:'supplier_code_s',editor:{type:'textbox'}">供应商编号</th>
                    <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',editor:{type:'textbox'}">物料编码</th>
                    <!-- 物料名称 -->
                    <th data-options="field:'material_name_s',editor:{type:'textbox'}">物料名称</th>
                    <!-- 交货数量 -->
                    <th data-options="field:'qty_left_f',editor:{type:'textbox'}">交货数量</th>
                    <!-- 供应商原料批次号生产日期 -->
                    <th data-options="field:'product_time_t',editor:{type:'textbox'}">生产日期</th>
                    <!-- 计量单号 -->
                    <th data-options="field:'weight_number_s',editor:{type:'textbox'}">计量单号</th>
                    <!-- MES生成批次号 -->
                    <th data-options="field:'lot_no_s',editor:{type:'textbox'}">MES生成批次号</th>
                    <!-- 称量状态 -->
                    <th data-options="field:'status_s',formatter:codeFormatter,editor:{type:'textbox'}">称量状态</th>
                    <!-- 过毛重时间 -->
                    <th data-options="field:'gross_time_t',editor:{type:'textbox'}">过毛重时间</th>
                    <!-- 毛重 -->
                    <th data-options="field:'gross_weight_f',editor:{type:'textbox'}">毛重(kg)</th>
                    <!-- 过毛操作人 -->
                    <th data-options="field:'gross_by_s',editor:{type:'textbox'}">过毛操作人</th>
                    <!-- 过毛操作人姓名 -->
                    <th data-options="field:'gross_name_s',editor:{type:'textbox'}">过毛操作人姓名</th>
                    <!-- TDM检测任务推送表，MES业务主键 -->
                    <th data-options="field:'testare_mesbusinesscode_s',editor:{type:'textbox'}">MES业务主键</th>
                    <!--样品批次-->
                    <th data-options="field:'samplebatch_s',editor:{type:'textbox'}">样品批次</th>
                    <!--专业组ID-->
                    <th data-options="field:'tdmgroupid_s',formatter:codeFormatter,editor:{type:'textbox'}">专业组ID</th>
                    <!-- 过皮重时间 -->
                    <th data-options="field:'tare_time_t',editor:{type:'textbox'}">过皮重时间</th>
                    <!-- 皮重 -->
                    <th data-options="field:'tare_weight_f',editor:{type:'textbox'}">皮重(kg)</th>
                    <!-- 过皮操作人 -->
                    <th data-options="field:'tare_by_s',editor:{type:'textbox'}">过皮操作人</th>
                    <!-- 过皮操作人姓名 -->
                    <th data-options="field:'tare_name_s',editor:{type:'textbox'}">过皮操作人姓名</th>
                    <!-- 净重（实际交货数量） -->
                    <th data-options="field:'net_weight_f',editor:{type:'textbox'}">净重(kg)</th>
                    <!-- 是否入库：0-否、1-是 -->
                    <th data-options="field:'is_instore_s',formatter:isInstore,editor:{type:'textbox'}">是否入库</th>
                    <!-- 操作班次 -->
                    <th data-options="field:'weight_shift_s',formatter:codeFormatter,editor:{type:'textbox'}">操作班次</th>
                    <!-- 操作班组 -->
                    <th data-options="field:'weight_group_s',formatter:codeFormatter,editor:{type:'textbox'}">操作班组</th>
                    <!-- 预留1 -->
                    <th data-options="field:'spare1_s',editor:{type:'textbox'}">预留1</th>
                    <!-- 预留2 -->
                    <th data-options="field:'spare2_s',editor:{type:'textbox'}">预留2</th>
                    <!-- 预留3 -->
                    <th data-options="field:'spare3_s',editor:{type:'textbox'}">预留3</th>
                    <!-- 预留4 -->
                    <th data-options="field:'spare4_s',editor:{type:'textbox'}">预留4</th>
                    <!-- 预留5 -->
                    <th data-options="field:'spare5_s',editor:{type:'textbox'}">预留5</th>
                    <!-- 接收时间 -->
                    <th data-options="field:'receive_time_t',editor:{type:'textbox'}">接收时间</th>
                    <!-- 工厂：1-全钢、2-半钢 -->
                    <th data-options="field:'s_factory_s',formatter:factoryName,editor:{type:'textbox'}">工厂</th>
                    <!-- 机构编号 -->
                    <th data-options="field:'agenc_no_s',editor:{type:'textbox'}">机构编号</th>
                      <!-- 创建人 -->
                    <th data-options="field:'created_by_s',editor:{type:'textbox'}">创建人</th>
                    <!-- 创建人姓名 -->
                    <th data-options="field:'created_name_s',editor:{type:'textbox'}">创建人姓名</th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',editor:{type:'textbox'}">创建时间</th>
                    <!-- 修改人 -->
                    <th data-options="field:'changed_by_s',editor:{type:'textbox'}">修改人</th>
                    <!-- 修改人姓名 -->
                    <th data-options="field:'changed_name_s',editor:{type:'textbox'}">修改人姓名</th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',editor:{type:'textbox'}">修改时间</th>
                    <!-- 归档标记 -->
                    
                    <!-- 记录标志，A可用，D删除 -->
                    <th data-options="field:'record_flag_s',formatter:recordFlag,editor:{type:'textbox'}">记录标志</th>
                    </tr>
            </thead>
        </table>
    </div>
   <jsp:include page="../../../../inc/export.jsp">
        <jsp:param name="idField" value="atr_key" />
        <jsp:param name="formId" value="WeightFactory_search_form" />
        <jsp:param name="datagridId" value="weightfactory_dg" />
        <jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.material.excel.WeightFactoryExportHandler" />
        <jsp:param name="serviceName" value="WeightFactoryServiceImpl" />
    </jsp:include>
</body>
</html>
