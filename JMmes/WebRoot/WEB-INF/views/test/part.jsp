<!-- 

    作者      :周清玉
    时间      :2019-06-20 09:09:22 
    页面名称:20190620新封装
    文件关联:
        Part.java
        PartController.java
        PartServiceImpl.java
        PartServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../inc/meta.jsp"%>
<%@ include file="part.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="Part_dg_toolbar">
            <form id="Part_search_form" class="form" >
                <!-- 基本计量单位 -->
                <input name="filter[baseunit_s]" id="baseunit" type="text" class="easyui-textbox" data-options="label:'<spring:message code="part.column.baseunit" />'" >
                <!-- 品牌 -->
                <input name="filter[brand_s]" id="brand" type="text" class="easyui-textbox" data-options="label:'<spring:message code="part.column.brand" />'" >
                <input name="filter[zwbm_s]" id="zwbm" type="text" class="easyui-textbox" data-options="label:'<spring:message code="part.column.zwbm" />'" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-add'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="XXX"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            　
            <auth:button code="XXX"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            　
            <auth:button code="XXX"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-add'" onclick="export()"><spring:message code="button.export" /></a></auth:button>
        </div>
        <table id="part_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#Part_dg_toolbar',
                url: 'demoTest/datagridUDA',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                
                
                	<!-- 物料描述 -->
                    <th data-options="field:'materialdesc_s',width:80,editor:{type:'textbox'}"><spring:message code="part.column.materialdesc" /></th>
                    <!-- 物料编号80位 -->
                    <th data-options="field:'materialcode_s',width:80,editor:{type:'textbox'}"><spring:message code="part.column.materialcode" /></th>
                     <!-- 物料号9位 -->
                    <th data-options="field:'materialpure_s',width:80,editor:{type:'textbox'}"><spring:message code="part.column.materialpure" /></th>
                   
                </tr>
            </thead>
        </table>
    </div>
</body>
</html>
