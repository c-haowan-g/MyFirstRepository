<!-- 

    作者      :李迺锟
    时间      :2018-09-25 15:16:48 
    页面名称:客户主数据信息
    文件关联:d
        Customer.java
        CustomerController.java
        CustomerServiceImpl.java
        CustomerServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/meta.jsp"%>
<%@ include file="customer.js.jsp"%>
<script type="text/javascript" src="dict/-303.js"></script>
<style type="text/css">

table {
           /*列宽由表格宽度和列宽度设定*/
           table-layout: fixed;
       }
</style>
<!-- 下拉框引入 -->
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="Customer_dg_toolbar">
            <form id="Customer_search_form" class="form" >
            <table class="formTable" >
					<tr>
						<td class="columnTitle">
                <!-- 地区ID，A、B等/亚太区等 -->
                <spring:message code="customer.column.areaid_s" />:
                		</td>
                		<td>
                <input name="filter[areaid_s]" id="areaid_s" type="text" class="easyui-textbox" data-options="label:''" >
               			</td>	
                		<td>
                <!-- 国家 -->
                <spring:message code="customer.column.countryid_s" />:
                		</td>
                		<td>
                <input name="filter[countryid_s]" id="countryid_s" type="text" class="easyui-textbox" data-options="label:''" >
                		</td>
                		<td>
                <!-- 客户编码 -->
                <spring:message code="customer.column.customerid_s" />:
                		</td>
                		<td>
                <input name="filter[customerid_s]" id="customerid_s" type="text" class="easyui-textbox" data-options="label:''" >
                		</td>
               		</tr>
               		<tr>
               			<td>
                <!-- 客户名称 -->
                <spring:message code="customer.column.customename_s" />:
                		</td>
                		<td>
                <input name="filter[customename_s]" id="customename_s" type="text" class="easyui-textbox" data-options="label:''" >
                		</td>
                		<td>
                <!-- 品牌 -->
                <spring:message code="customer.column.mark_s" />:
                		</td>
                		<td>
                <input name="filter[mark_s]" id="mark_s" type="text" class="easyui-textbox" data-options="label:''" >
                		</td>
                		<td>
                <!-- 税号 -->
                <spring:message code="customer.column.taxid_s" />:
                		</td>
                		<td>
                <input name="filter[taxid_s]" id="taxid_s" type="text" class="easyui-textbox" data-options="label:''" >
                		</td>
                		<td>
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
                		</td>
           			</tr>
           		</table>
            </form> 
        </div>
        <table id="customer_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#Customer_dg_toolbar',
                url: 'sap/common/customer/datagrid',
                striped:true,
                method: 'get' ,
                emptyMsg:'<span><spring:message code='tip.noData'/></span>',
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 客户编码 -->
                    <th data-options="field:'customerid_s',editor:{type:'textbox'}"><spring:message code="customer.column.customerid_s" /></th>
                    <!-- 客户全称 -->
                    <th data-options="field:'customename_s',editor:{type:'textbox'}"><spring:message code="customer.column.customename_s" /></th>
                    <!-- 客户简称 -->
                    <th data-options="field:'customenick_s',editor:{type:'textbox'}"><spring:message code="customer.column.customenick_s" /></th>
                    <!-- 国家 -->
                    <th data-options="field:'countryid_s',editor:{type:'textbox'}"><spring:message code="customer.column.countryid_s" /></th>
                    <!-- 国家描述 -->
                    <th data-options="field:'countrydesc_s',editor:{type:'textbox'}"><spring:message code="customer.column.countrydesc_s" /></th>
                    <!-- 地区ID，A、B等/亚太区等 -->
                    <th data-options="field:'areaid_s',editor:{type:'textbox'}"><spring:message code="customer.column.areaid_s" /></th>
                    <!-- 地区描述，A、B等/亚太区等 -->
                    <th data-options="field:'area_s',editor:{type:'textbox'}"><spring:message code="customer.column.area_s" /></th>
                    <!-- 核准情况（1：已核准、2：尚待核准、3：不准交易） -->
                    <th data-options="field:'authorize_s',editor:{type:'textbox'}"><spring:message code="customer.column.authorize_s" /></th>
                    <!-- 公司代码 -->
                    <th data-options="field:'comparea_s'"><spring:message code="customer.column.comparea_s" /></th>
                    <!-- 联系人 -->
                    <th data-options="field:'contactor_s',editor:{type:'textbox'}"><spring:message code="customer.column.contactor_s" /></th>
                    <!-- 部门描述 -->
                    <th data-options="field:'deptdesc_s',editor:{type:'textbox'}"><spring:message code="customer.column.deptdesc_s" /></th>
                    <!-- 部门 -->
                    <th data-options="field:'deptid_s',editor:{type:'textbox'}"><spring:message code="customer.column.deptid_s" /></th>
                    <!-- 品牌描述 -->
                    <th data-options="field:'markdesc_s',editor:{type:'textbox'}"><spring:message code="customer.column.markdesc_s" /></th>
                    <!-- 品牌 -->
                    <th data-options="field:'mark_s',editor:{type:'textbox'}"><spring:message code="customer.column.mark_s" /></th>
                    <!-- 渠道描述 -->
                    <th data-options="field:'passdesc_s',editor:{type:'textbox'}"><spring:message code="customer.column.passdesc_s" /></th>
                    <!-- 渠道，出口/内销 -->
                    <th data-options="field:'pass_s',editor:{type:'textbox'}"><spring:message code="customer.column.pass_s" /></th>
                    <!-- 备注，地址注释 -->
                    <th data-options="field:'remark_s',editor:{type:'textbox'}"><spring:message code="customer.column.remark_s" /></th>
                    <!-- 业务人员，需要传入代码和描述，EC根据此信息维护 -->
                    <th data-options="field:'salesid_s',editor:{type:'textbox'}"><spring:message code="customer.column.salesid_s" /></th>
                    <!-- 业务人员名 -->
                    <th data-options="field:'salesname_s',editor:{type:'textbox'}"><spring:message code="customer.column.salesname_s" /></th>
                    <!-- 税号 -->
                    <th data-options="field:'taxid_s',editor:{type:'textbox'}"><spring:message code="customer.column.taxid_s" /></th>
                	<!-- 同步时间 -->
                    <th data-options="field:'synchronous_time_t',editor:{type:'textbox'}"><spring:message code="customer.column.synchronous_time_t" /></th>
                    
                </tr>
            </thead>
        </table>
    </div>
</body>
</html>
