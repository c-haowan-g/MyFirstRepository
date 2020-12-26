<!-- 

    作者      :周清玉
    时间      :2018-09-08 15:47:33 
    页面名称:年周号管控物料
    文件关联:
        DOTControl.java
        DOTControlController.java
        DOTControlServiceImpl.java
        DOTControlServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="dotcontrol.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="DOTControl_dg_toolbar">
            <form id="DOTControl_search_form" class="form" >
                <!-- 物料编码 -->
                <spring:message code="dotcontrol.column.material_code_s" />:
                <input name="filter[material_code_s]"  id="material_code_s" name="material_code_s"  style="width:12%;" class="easyui-combobox" data-options="label:'',
										  panelHeight:200,
										  required:false,
										  editable:'true',
										  url:'curing/moldmanagement/moldmarkingdrawing/materialpdf/searchByMaterial',
										  valueField: 'MATERIALCODE_S',
                              			  textField: 'MATERIALCODE_S',
										  method:'get'" >
                <!-- 记录标志，A可用，D删除 -->
                <spring:message code="materialpdf.column.is_flag_s" />:
                <input name="filter[isvlid_s]" id="isvlid_s" style="width:10%" class="easyui-combobox" data-options="label:'',
										                textField: 'label',
														data: [{
																label: '有效',
																value: '1'
															},{
																label: '无效',
																value: '0'
															}]" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="DOTControl.add"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="DOTControl.remove"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            <auth:button code="DOTControl.save"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="DOTControl.cancel"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            <auth:button code="DOTControl.excel"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            <auth:button code="DOTControl.showOrHide"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="showOrHide()"><spring:message code="button.searchColumn" /></a></auth:button>
        </div>
        <table id="dotcontrol_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#DOTControl_dg_toolbar',
                url: 'curing/baseData/DotControl/searchBy',
                striped:true,
                method: 'get',
                emptyMsg:'暂无数据' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',width:200,editor:{type:'combobox',options:{
                    			panelHeight:200,
                    			method:'get',
                    			editable:'true',
                                url:'curing/moldmanagement/moldmarkingdrawing/materialpdf/searchByMaterial',
                                valueField: 'MATERIALCODE_S',
                              	textField: 'MATERIALCODE_S',
                    			required:true}}"><spring:message code="dotcontrol.column.material_code_s" /></th>
                    <!-- 记录标志，A可用，D删除 -->
                    <th data-options="field:'isvlid_s',width:40,
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
                    validType:'length[1,100]'}}"><spring:message code="dotcontrol.column.record_flag_s" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changed_by_name',width:80,editor:{type:'textBox'}"><spring:message code="dotcontrol.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',width:80,editor:{type:'textBox'}"><spring:message code="dotcontrol.column.changed_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="DOTControl_search_form" />
		<jsp:param name="datagridId" value="dotcontrol_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.curing.excel.DotControlExportHandler" />
		<jsp:param name="serviceName" value="DotControlServiceImpl" />
	</jsp:include>
</body>
</html>
