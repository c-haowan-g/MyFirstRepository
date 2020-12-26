<!-- 

    作者      :李德晓
    时间      :2020-08-28 10:39:14 
    页面名称:原材料库存预警看板
    文件关联:
        RawMaterialWarning.java
        RawMaterialWarningController.java
        RawMaterialWarningServiceImpl.java
        RawMaterialWarningServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="rawmaterialwarning.js.jsp"%>
<script type="text/javascript" src="dict/005.js"></script>
<style type="text/css">

table {
           /*列宽由表格宽度和列宽度设定*/
           table-layout: fixed;
       }
</style>
<script type="text/javascript">
</script>
<body class="easyui-layout" fit="true">
<div id="name" style="width:100%" align="center">
	<h1 style="color:blue">原材料库存预警看板</h2>
</div>
<div id="message"></div>
     <div data-options="region:'center',split:true,border:false" style="width:100%">
        <table id="dg" class="easyui-datagrid" style="width:80%" 
            data-options="  
                fit:true,
                fitColumns:true,
                rownumbers: false,
                singleSelect: true,
                url: 'material/digitalSignage/rawmaterialwarning/datagrid',
                 emptyMsg:'<span><spring:message code='tip.noData'/></span>',
                striped:true,
                method: 'get',
                toolbar:'#message,#name',
                rowStyler:setRowBgColor 
                ">
            <thead>
                <tr>  
                     <!-- 进厂批次 -->
                    <!-- <th data-options="field:'lot_no_s',editor:{type:'textbox'}">进场批次</th>  -->
                    <!-- 批次号 -->
                    <th data-options="field:'supplier_lot_no_s',editor:{type:'textbox'}">批次号</th>
                    <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',editor:{type:'textbox'}">物料编码</th>
                    <!-- 物料名称 -->
                    <th data-options="field:'material_name_s',editor:{type:'textbox'}">物料名称</th>
                    <!-- 生产日期 -->
                    <th data-options="field:'product_time_t',editor:{type:'textbox'}">生产日期</th>
                    
                   <!-- 库存重量 -->
                    <th data-options="field:'qty_left_f',editor:{type:'textbox'}">库存重量</th> 
                    <!-- 出库请求时间 -->
                    <th data-options="field:'date_allow_out_t',editor:{type:'textbox'}">允许出库日期</th>
                    <!-- 库位 -->
                    <th data-options="field:'spare4_s',editor:{type:'textbox'}">库位名称</th>
                    
                    <!-- 供应商全称 -->
                    <th data-options="field:'supplier_name_s',editor:{type:'textbox'}">供应商</th>
                    <!-- 过期时间 -->
                    <th data-options="field:'expiry_date_t',editor:{type:'textbox'}">过期时间</th>
                </tr>
            </thead>
        </table>
    </div>
</body>
</html>
