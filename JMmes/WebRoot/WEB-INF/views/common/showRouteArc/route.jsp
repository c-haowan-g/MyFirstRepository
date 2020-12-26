<!-- 

    作者      :时永良
    时间      :2019-08-08 16:01:32 
    页面名称:Route-Arc
    文件关联:
        Route.java
        RouteController.java
        RouteServiceImpl.java
        RouteServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/meta.jsp"%>
<%@ include file="route.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="Route_dg_toolbar">
            <form id="Route_search_form" class="form" >
                <!-- 创建时间 -->
                <input name="filter[routename]" id="routename" style="width:250px" type="text" beginWith="true" editable="true" class="easyui-combobox" data-options="label:'<spring:message code="route.column.routename" />',
                                        valueField:'ROUTE_NAME',
				            			textField:'ROUTE_NAME',
                                        required:false, 
                                        url:'route/getRouteName',
										method: 'get',
									    limitToList:false,
									    panelHeight:150,
										filter: function(q, row){  
								        var opts = $(this).combobox('options');  
								        return row[opts.textField].indexOf(q) >= 0;//这里改成>=即可在任意地方匹配  
								    	}" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
        </div>
        <table id="route_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#Route_dg_toolbar',
                url: '',
                striped:true,
                method: 'get',
                emptyMsg: '<span><spring:message code='tip.noData'/></span>' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'route_key',checkbox:true"></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'DESCRIPTION',width:80,editor:{type:'textbox'}"><spring:message code="route.column.routearc" /></th>
                </tr>
            </thead>
        </table>
    </div>
</body>
</html>
