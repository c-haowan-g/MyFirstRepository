<!-- 

    作者      :时永良
    时间      :2019-07-12 13:12:11 
    页面名称:UNIT序列号帮助
    文件关联:
        SerialNumberHelp.java
        SerialNumberHelpController.java
        SerialNumberHelpServiceImpl.java
        SerialNumberHelpServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/meta.jsp"%>
<%@ include file="serialnumberhelp.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="SerialNumberHelp_dg_toolbar">
            <form id="SerialNumberHelp_search_form" class="form" >
                <!-- 规则 -->
                <spring:message code="serialnumberhelp.column.factoryflag_s" />:<input name="filter[factoryflag_s]" id="factoryflag_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 规则描述 -->
                <spring:message code="serialnumberhelp.column.descripe_s" />:<input name="filter[description_s]" id="description_s" type="text" class="easyui-textbox" data-options="label:''" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="serialnumberhelp.add"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="serialnumberhelp.edit"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="serialnumberhelp.remove"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            　
            <auth:button code="serialnumberhelp.save"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="serialnumberhelp.cancel"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
        </div>
        <table id="serialnumberhelp_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#SerialNumberHelp_dg_toolbar',
                url: 'building/test/unit/searchBy',
                striped:true,
                method: 'get',
                emptyMsg:'<span><spring:message code='tip.noData'/></span>' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 工厂标记 -->
                    <th data-options="field:'factoryflag_s',width:80,editor:{type:'textbox'}"><spring:message code="serialnumberhelp.column.factoryflag_s" /></th>
                    <!-- 标记 -->
                    <th data-options="field:'flag_s',width:80,editor:{type:'textbox'}"><spring:message code="serialnumberhelp.column.flag_s" /></th>
                    <!-- 描述 -->
                    <th data-options="field:'description_s',width:80,editor:{type:'textbox'}"><spring:message code="serialnumberhelp.column.descripe_s" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changed_by_name',width:80,editor:{}"><spring:message code="serialnumberhelp.column.changeby_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'last_modified_time',width:80,editor:{}"><spring:message code="serialnumberhelp.column.last_modified_time" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_name',width:80,editor:{}"><spring:message code="serialnumberhelp.column.creteby_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'creation_time',width:80,editor:{}"><spring:message code="serialnumberhelp.column.creation_time" /></th>
                </tr>
            </thead>
        </table>
    </div>
</body>
</html>
