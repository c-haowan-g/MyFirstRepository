<!-- 

    作者      :${author}
    时间      :${time} 
    页面名称:${comment}
    文件关联:
        ${entityName}.java
        ${entityName}Controller.java
        ${entityName}ServiceImpl.java
        ${entityName}ServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="${entityName?lower_case}.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="${entityName}_dg_toolbar">
            <form id="${entityName}_search_form" class="form" >
                <#list columns as c>
                <!-- ${c.memo} -->
                <input name="filter[${c.name?lower_case}]" id="${c.name?lower_case}" type="text" class="easyui-textbox" data-options="label:'<spring:message code="${entityName?lower_case}.column.${c.name?lower_case}" />'" >
                </#list>
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="XXX"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            　
            <auth:button code="XXX"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            　
            <auth:button code="XXX"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="export()"><spring:message code="button.export" /></a></auth:button>
        </div>
        <table id="${entityName?lower_case}_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#${entityName}_dg_toolbar',
                url: '${url}/datagrid',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <#list columns as c>
                    <!-- ${c.memo} -->
                    <th data-options="field:'${c.name?lower_case}',editor:{type:'textbox'}"><spring:message code="${entityName?lower_case}.column.${c.name?lower_case}" /></th>
                    </#list>
                </tr>
            </thead>
        </table>
    </div>
</body>
</html>
