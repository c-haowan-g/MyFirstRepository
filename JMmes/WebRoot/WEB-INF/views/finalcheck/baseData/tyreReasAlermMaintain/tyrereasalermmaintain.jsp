<!-- 

    作者      :司乔靖
    时间      :2019-05-20 11:10:40 
    页面名称:外观检测后工序报警病象计数配置表
    文件关联:
        TyreReasAlermMaintain.java
        TyreReasAlermMaintainController.java
        TyreReasAlermMaintainServiceImpl.java
        TyreReasAlermMaintainServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="tyrereasalermmaintain.js.jsp"%>
<script type="text/javascript" src="dict/252.js"></script>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="TyreReasAlermMaintain_dg_toolbar">
            <form id="TyreReasAlermMaintain_search_form" class="form" >
                
                <!-- 病象条码 -->
                <spring:message code="tyrereasalermmaintain.column.reas_code_s" />
                <input name="filter[reas_code_s]" id="reas_code_s" type="text" class="easyui-combobox" 
                    data-options="label:'',
							required:false, 
	                		url:'finalcheck/baseData/ReasAlermMaintain/getReasByCode',
				   			method: 'get',
				   			panelHeight:200,
                            valueField:'REAS_CODE_S',
				    		textField:'REAS_CN_S'" >
                
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="ZJ_JCGL_QUAN_GANG_ReasAlermMaintain_ADD"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="ZJ_JCGL_QUAN_GANG_ReasAlermMaintain_UPDATE"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="ZJ_JCGL_QUAN_GANG_ReasAlermMaintain_DELETE"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            <auth:button code="ZJ_JCGL_QUAN_GANG_ReasAlermMaintain_SAVE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="ZJ_JCGL_QUAN_GANG_ReasAlermMaintain_CANCEL"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            <auth:button code="ZJ_JCGL_QUAN_GANG_ReasAlermMaintain_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            <a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-hide'" onclick="showOrHide()"><spring:message code="查询栏" /></a>
        </div>
        <table id="tyrereasalermmaintain_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#TyreReasAlermMaintain_dg_toolbar',
                url: 'finalcheck/baseData/ReasAlermMaintain/datagrid_min',
                striped:true,
                emptyMsg: '<span><spring:message code='tip.noData'/></span>',  
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 病象名称 -->
                    <th data-options="field:'creation_name',width:80"><spring:message code="tyrereasalermmaintain.column.creation_name" /></th>
                    <!-- 病象条码 -->
                    <th data-options="field:'reas_code_s',width:80,editor:{type:'combobox',options:{
               
                  
                    		width:'auto',
                    		required:true,
                    		method:'get',
                            url:'finalcheck/baseData/ReasAlermMaintain/getReasByCode',
                            panelHeight:200,
                            valueField:'REAS_CODE_S',
				    		textField:'REAS_CN_S'
				    		
				    		}}"><spring:message code="tyrereasalermmaintain.column.reas_code_s" /></th>
                    <!-- 病象统计次数   当次数设置为0的时候，默认保存为1，不允许为0-->
                    <th id="count" data-options="field:'reas_count_i', width:80,editor:{type:'numberbox',options:{
                    					required:true,
                    					editable:true,
                    					precision:0,
                    					min:1
                    					}}"><spring:message code="tyrereasalermmaintain.column.reas_count_i" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changed_by_s',width:80,formatter:userFormatter"><spring:message code="tyrereasalermmaintain.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',width:80,formatter:formatter2"><spring:message code="tyrereasalermmaintain.column.changed_time_t" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_s',width:80,formatter:userFormatter"><spring:message code="tyrereasalermmaintain.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',width:80,formatter:formatter2"><spring:message code="tyrereasalermmaintain.column.created_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="TyreReasAlermMaintain_search_form" />
		<jsp:param name="datagridId" value="tyrereasalermmaintain_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.finalcheck.excel.TyreReasAlermMaintainExportHandler" />
		<jsp:param name="serviceName" value="TyreReasAlermMaintainServiceImpl" />
  </jsp:include> 
</body>
</html>
