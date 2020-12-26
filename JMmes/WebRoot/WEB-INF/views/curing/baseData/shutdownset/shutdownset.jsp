<!-- 

    作者      :周清玉
    时间      :2018-08-20 08:42:24 
    页面名称:硫化报警停机参数
    文件关联:
        Shutdownset.java
        ShutdownsetController.java
        ShutdownsetServiceImpl.java
        ShutdownsetServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="shutdownset.js.jsp"%>
<script type="text/javascript" src="dict/201.js"></script>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="Shutdownset_dg_toolbar">
            <form id="Shutdownset_search_form" class="form" >
                <!-- 轮胎判级 报警等级 -->
                <spring:message code="shutdownset.column.judge_lever_s" />:
				<input name="filter[judge_lever_s]" id="judge_lever_s" beginWith=true style="width:15%" type="text" class="easyui-combotree" data-options="label:'',
						                  panelHeight:200,
						                  labelWidth:'auto',
										  panelWidth:'15%',
										  required:false,
										  url:'dict/code/201',
										  method:'get'" >						  
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="Shutdownset.add"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="Shutdownset.edit"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="Shutdownset.remove"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            <auth:button code="Shutdownset.save"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="Shutdownset.cancel"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            <auth:button code="Shutdownset.excel"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            <auth:button code="Shutdownset.showOrHide"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="showOrHide()"><spring:message code="button.searchColumn" /></a></auth:button>
        </div>
        <table id="shutdownset_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#Shutdownset_dg_toolbar',
                url: 'curing/baseData/shutdownset/searchBy',
                striped:true,
                method: 'get',
                nowrap:false,
                emptyMsg:'暂无数据' 
                ">
            <thead>
                <tr>
                	<th data-options="field:'atr_key',checkbox:true">ID</th>
                	<!-- 轮胎判级 报警等级 -->
                    <th data-options="field:'judge_lever_s',width:100,formatter:codeFormatter,editor:{type:'combotree',options:{
                    			panelHeight:200,
                    			method:'get',
                                url:'dict/code/201',
                    			required:true}}"><spring:message code="shutdownset.column.judge_lever_s" /></th>
                    
                    <!-- 时间范围  -->
                    <th data-options="field:'set_time_s',width:60,editor:{type:'numberbox',options:{required:true,precision:0}}"><spring:message code="shutdownset.column.set_time_s" /></th>
                    <!-- 报警停机次数 -->
                    <th data-options="field:'alarm_number_s',width:60,editor:{type:'numberbox',options:{required:true,precision:0}}"><spring:message code="shutdownset.column.alarm_number_s" /></th>
                    <!-- 有效标识  1:有效 0 无效 -->
                    <th data-options="field:'valid_flag_s',width:40,
                                         	formatter:function(value,row,index){
				                  				if(value=='1'){return '有效'}
				                  				else if(value=='0'){return '无效'}},
                    editor:{type:'combobox',options:{required:true,valueField: 'value',textField: 'label',
                    						data: [{
												label: '有效',
												value: '1'
											},{
												label: '无效',
												value: '0'
											}],
                    validType:'length[1,100]'}}"><spring:message code="shutdownset.column.valid_flag_s" /></th>
                    <!-- 备注 -->
                    <th data-options="field:'memo_s',width:150,editor:{type:'textbox',options:{required:false}}"><spring:message code="shutdownset.column.memo_s" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changed_by_name',width:60,editor:{type:'textBox',options:{required:true}}"><spring:message code="shutdownset.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',width:80,editor:{type:'textBox',options:{required:true}}"><spring:message code="shutdownset.column.changed_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="Shutdownset_search_form" />
		<jsp:param name="datagridId" value="shutdownset_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.curing.excel.ShutdownsetExportHandler" />
		<jsp:param name="serviceName" value="ShutDownSetServiceImpl" />
	</jsp:include>
</body>
</html>
