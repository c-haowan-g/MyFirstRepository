<!-- 

    作者      :陈国强
    时间      :2020-12-01 14:24:14 
    页面名称:轮胎锁定信息管理表
    文件关联:
        LockManagement.java
        LockManagementController.java
        LockManagementServiceImpl.java
        LockManagementServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="lockmanagement.js.jsp"%>
<script type="text/javascript" src="dict/270,224,062,073.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="LockManagement_dg_toolbar">
            <form id="LockManagement_search_form" class="form" >
                <!-- 管控规则 -->
                <input name="filter[control_rules_s]" id="control_rules_s" type="text" class="easyui-combotree"
    data-options="label:'<spring:message code="lockmanagement.column.control_rules_s" />',
    width:'200px',
   required:false,
   panelHeight:200,
   url:'dict/code/224',
   method:'get'"
	],
	method:'get'" >
                <!-- 病象名称 -->
                <input name="filter[reas_cn_s]" id="reas_cn_s" type="text" class="easyui-textbox" 
                data-options="label:'<spring:message code="lockmanagement.column.reas_cn_s" />',
                width:'200px'" >
                 </br>
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
                <a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a>
                <a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a>
            	<a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a>
            	<a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a>
            	<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  
            </form> 
            <%-- <auth:button code="ADD"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            　
            <auth:button code="XXX"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            　
            <auth:button code="XXX"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="export()"><spring:message code="button.export" /></a></auth:button> --%>
        </div>
        <table id="lockmanagement_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#LockManagement_dg_toolbar',
                url: 'finalcheck/baseData/lockManagement/datagrid',
                striped:true,
                emptyMsg: '<span><spring:message code='tip.noData'/></span>',
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 管控规则 -->
                    <th data-options="field:'control_rules_s',formatter:codeFormatter,width:100,editor:{type:'combotree',options:{
                    			method:'get',
                                url:'dict/code/224',
                                panelWidth:'150',
                                panelHeight:130,
                    			}}"><spring:message code="lockmanagement.column.control_rules_s" /></th>
                    <!-- 病象名称 -->
                    <th data-options="field:'reas_cn_s',formatter:operatorFormatter,width:100,editor:{type:'combobox',
                    options:{
                    
                    url:'finalcheck/baseData/lockManagement/getrea',
                    valueField:'REAS_CODE_S',
                    textField:'REAS_CN_S',
                    limitToList:true,
                    	labelPosition: 'top',
                    	panelHeight:130,
                    	editable:true}}"><spring:message code="lockmanagement.column.reas_cn_s" /></th>
                    <!-- 病象编号 -->
                    <th data-options="field:'reas_code_s',width:100,editor:{type:'textbox',options:{editable:false,icons:[],disabled:true}}"><spring:message code="lockmanagement.column.reas_code_s" /></th>
                    <!-- 向前锁定数量 -->
                    <th data-options="field:'f_lock_num_s',width:100,editor:{type:'textbox'}"><spring:message code="lockmanagement.column.f_lock_num_s" /></th>
                    <!-- 向后锁定数量 -->
                    <th data-options="field:'b_lock_num_s',width:100,editor:{type:'textbox'}"><spring:message code="lockmanagement.column.b_lock_num_s" /></th>
                    <%-- <!-- 向前次品数量 -->
                    <th data-options="field:'f_twoleve_num_s',width:100,editor:{type:'textbox'}"><spring:message code="lockmanagement.column.f_twoleve_num_s" /></th>
                    <!-- 向后次品数量 -->
                    <th data-options="field:'b_twoleve_num_s',width:100,editor:{type:'textbox'}"><spring:message code="lockmanagement.column.b_twoleve_num_s" /></th>
                    <!-- 向前废品数量 -->
                    <th data-options="field:'f_rejecttire_num_s',width:100,editor:{type:'textbox'}"><spring:message code="lockmanagement.column.f_rejecttire_num_s" /></th>
                    <!-- 向后废品数量 -->
                    <th data-options="field:'b_rejecttire_num_s',width:100,editor:{type:'textbox'}"><spring:message code="lockmanagement.column.b_rejecttire_num_s" /></th> --%>
                </tr>
            </thead>
        </table>
    </div>
</body>
</html>
