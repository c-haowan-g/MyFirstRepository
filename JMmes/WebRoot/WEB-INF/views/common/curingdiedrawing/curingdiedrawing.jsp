<!-- 

    作者      :lnk
    时间      :2019-01-09 15:11:23 
    页面名称:PLM硫化模具标识图表
    文件关联:
        CuringdieDrawing.java
        CuringdieDrawingController.java
        CuringdieDrawingServiceImpl.java
        CuringdieDrawingServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/meta.jsp"%>
<%@ include file="curingdiedrawing.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="CuringdieDrawing_dg_toolbar">
            <form id="CuringdieDrawing_search_form" class="form" >
                <!-- 外胎SAP品号 -->
                <spring:message code="curingdiedrawing.column.coversap_s" />:
                <input name="filter[coversap_s]" id="coversap_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 文件名 -->
                <spring:message code="curingdiedrawing.column.filename_s" />:
                <input name="filter[filename_s]" id="filename_s" type="text" class="easyui-textbox" data-options="label:''" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
          </div>
        <table id="curingdiedrawing_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#CuringdieDrawing_dg_toolbar',
                url: 'common/curingdiedrawing/datagridOn',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 外胎SAP品号 -->
                    <th data-options="field:'coversap_s',width:80,editor:{type:'textbox'}"><spring:message code="curingdiedrawing.column.coversap_s" /></th>
                    <!-- 文件名 -->
                    <th data-options="field:'filename_s',width:80,editor:{type:'textbox'}"><spring:message code="curingdiedrawing.column.filename_s" /></th>
                    <!-- 模具标识图文件，格式待确定 -->
                    <th data-options="field:'file_s',width:80,editor:{type:'textbox'}"><spring:message code="curingdiedrawing.column.file_s" /></th>
                    <!-- 接收时间 -->
                    <th data-options="field:'receive_time_t',width:80,editor:{type:'textbox'}"><spring:message code="curingdiedrawing.column.receive_time_t" /></th>
                    
                  </tr>
            </thead>
        </table>
    </div>
</body>
</html>
