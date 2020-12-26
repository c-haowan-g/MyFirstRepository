<!-- 

    作者      :周清玉
    时间      :2018-09-25 10:28:55 
    页面名称:供应商信息表
    文件关联:
        Vendor.java
        VendorController.java
        VendorServiceImpl.java
        VendorServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../inc/meta.jsp"%>
<%@ include file="vendor.js.jsp"%>
<script type="text/javascript" src="dict/-303.js"></script>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="Vendor_dg_toolbar">
            <form id="Vendor_search_form" class="form" >
            	<!-- 供应商编号 -->
            	<spring:message code="vendor.column.suppliercode_s" />:
                <input name="filter[suppliercode_s]" id="suppliercode_s" like="true" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 供应商全称 -->
                <spring:message code="vendor.column.suppliername_s" />:
                <input name="filter[suppliername_s]" id="suppliername_s" like="true" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 联络人 -->
                &emsp;<spring:message code="vendor.column.contactor_s" />:
                <input name="filter[contactor_s]" id="contactor_s" like="true" type="text" class="easyui-textbox" data-options="label:''" >
               	<!-- 采购组织 -->
               	<spring:message code="vendor.column.pur_org_s" />:
                <input name="filter[pur_org_s]" id="pur_org_s" like="true" type="text" class="easyui-textbox" data-options="label:''" >
               	</br>
                <!-- Email -->
                &emsp;&emsp;&emsp;<spring:message code="vendor.column.email_s" />:
                <input name="filter[email_s]" id="email_s" like="true" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 传真 -->
                &emsp;&emsp;&emsp;<spring:message code="vendor.column.fax_s" />:
                <input name="filter[fax_s]" id="fax_s" type="text" like="true" class="easyui-textbox" data-options="label:''" >
                <!-- 联系电话 -->
                <spring:message code="vendor.column.tel1_s" />:
                <input name="filter[tel1_s]" id="tel1_s" like="true" type="text" class="easyui-textbox" data-options="label:''" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
        </div>
        <table id="vendor_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#Vendor_dg_toolbar',
                url: 'common/Vendor/datagrid',
                striped:true,
                method: 'get',
                emptyMsg:'暂无数据' 
                ">
            <thead>
                <tr>
                	<th data-options="field:'atr_key',checkbox:true"></th>
                	<!-- 供应商编号 -->
                    <th data-options="field:'suppliercode_s',editor:{type:'textbox'}"><spring:message code="vendor.column.suppliercode_s" /></th>
                    <!-- 供应商全称 -->
                    <th data-options="field:'suppliername_s',editor:{type:'textbox'}"><spring:message code="vendor.column.suppliername_s" /></th>
                    <!-- 供应商简称 -->
                    <th data-options="field:'suppliernick_s',editor:{type:'textbox'}"><spring:message code="vendor.column.suppliernick_s" /></th>
                    <!-- 联络人 -->
                    <th data-options="field:'contactor_s',editor:{type:'textbox'}"><spring:message code="vendor.column.contactor_s" /></th>
                    <!-- 联系电话 -->
                    <th data-options="field:'tel1_s',editor:{type:'textbox'}"><spring:message code="vendor.column.tel1_s" /></th>
                    <!-- 传真 -->
                    <th data-options="field:'fax_s',editor:{type:'textbox'}"><spring:message code="vendor.column.fax_s" /></th>
                    <!-- 通信地址 -->
                    <th data-options="field:'address1_s',editor:{type:'textbox'}"><spring:message code="vendor.column.address1_s" /></th>
                    <!-- 公司代码 -->
                    <th data-options="field:'companycode_s',formatter:codeFormatter,editor:{type:'combotree',options:{
                    			panelHeight:200,
                    			method:'get',
                                url:'dict/code/-303',
                    			required:true}}"><spring:message code="vendor.column.companycode_s" /></th>
                    
                    <!-- Email -->
                    <th data-options="field:'email_s',editor:{type:'textbox'}"><spring:message code="vendor.column.email_s" /></th>
                    <!-- 通信邮编 -->
                    <th data-options="field:'postalcode_s',editor:{type:'textbox'}"><spring:message code="vendor.column.postalcode_s" /></th>
                    <!-- 采购组织 -->
                    <th data-options="field:'pur_org_s',editor:{type:'textbox'}"><spring:message code="vendor.column.pur_org_s" /></th>
                    <!-- 备注 -->
                    <th data-options="field:'remark_s',editor:{type:'textbox'}"><spring:message code="vendor.column.remark_s" /></th>
                    <!-- 同步时间 -->
                    <th data-options="field:'synchronous_time_t',editor:{type:'textbox'}"><spring:message code="vendor.column.synchronous_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
</body>
</html>
