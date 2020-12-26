<!-- 

    作者      :司乔靖
    时间      :2018-08-06 10:27:44 
    页面名称:质检病象信息表
    文件关联:
        Reas.java
        ReasController.java
        ReasServiceImpl.java
        ReasServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="reasrate.js.jsp"%>
<script type="text/javascript" src="dict/261,262.js"></script>
<style type="text/css">
.columnTitle {
	padding: 6px 10px
}
</style>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="Reas_dg_toolbar">
            <form id="Reas_search_form" class="form" >
            <table class="formTable">
				<tr>
					 <!-- 病象组编号 -->
                     <spring:message code="reas.column.reas_grp_type_s" />:
                        <input name="filter[reas_grp_type_s]" id="reas_grp_type_s" type="text" class="easyui-combotree" data-options="label:'', 
                               width:'150px',
                              required:false,
                              data:DICT_261,
                              method:'get'" >
	                 <!-- 病象类代码 -->
	                 <spring:message code="reas.column.collet_code_s" />:
	                 <input name="filter[collet_code_s]" id="collet_code_s" type="text"   class="easyui-combotree" data-options="label:'', 
	                      width:'150px',
                             required:false,
                             data:DICT_262,
                             method:'get'" >
					 <!-- 病象描述（中文） -->
					 <spring:message code="reas.column.reas_cn_s" />:
                <input name="filter[reas_cn_s]" id="reas_cn_s" type="text" class="easyui-textbox" data-options="label:'',width:'150px'" >
					
					<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
				</tr>
			</table>
            </form> 
            <auth:button code="ZJ_BZGL_BXBL_EDIT"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="ZJ_BZGL_BXBL_SAVE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="ZJ_BZGL_BXBL_CANCEL"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            <auth:button code="ZJ_BZGL_BXBL_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
             |
          <a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-hide'" onclick="showhide()"><spring:message code="查询栏" /></a>
        </div>
        <table id="reas_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                emptyMsg: '<span><spring:message code='tip.noData'/></span>',
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#Reas_dg_toolbar',
                url: 'finalcheck/baseData/reas/datagrid',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                <th data-options="field:'atr_key',checkbox:true">ID</th>
                   <!-- 病象组编号 -->
                    <th data-options="field:'reas_grp_type_s',width:40,formatter:codeFormatter"><spring:message code="reas.column.reas_grp_type_s" /></th>
                    <!-- 病象类代码 -->
                    <th data-options="field:'collet_code_s',width:40,formatter:codeFormatter"><spring:message code="reas.column.collet_code_s" /></th>       
                    <!-- 病象描述（中文） -->
                    <th data-options="field:'reas_cn_s',editor:{type:'textbox',options:{required:true}}"><spring:message code="reas.column.reas_cn_s" /></th>
                    <!-- 原材料 -->
                    <th  data-options="field:'raw_s',width:15,editor:{type:'numberbox',options:{required:true,min:0,max:1,precision:2}}"><spring:message code="reas.column.raw_s" /></th>
                    <!-- 密练 -->
                    <th data-options="field:'banburying_s',width:15,editor:{type:'numberbox',options:{required:true,min:0,max:1,precision:2}}"><spring:message code="reas.column.banburying_s" /></th>
                    <!-- 前工序 -->
                    <th data-options="field:'frontend_s',width:15,editor:{type:'numberbox',options:{required:true,min:0,max:1,precision:2}}"><spring:message code="reas.column.frontend_s" /></th>
                    <!-- 成型 -->
                    <th data-options="field:'molding_s',width:15,editor:{type:'numberbox',options:{required:true,min:0,max:1,precision:2}}"><spring:message code="reas.column.molding_s" /></th>
                    <!-- 硫化 -->
                    <th data-options="field:'curing_s',width:15,editor:{type:'numberbox',options:{required:true,min:0,max:1,precision:2}}"><spring:message code="reas.column.curing_s" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changed_by_s',formatter:userFormatter"><spring:message code="reas.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t'"><spring:message code="reas.column.changed_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
         <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="Reas_search_form" />
		<jsp:param name="datagridId" value="reas_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.finalcheck.excel.ReasBLExportHandler" />
		<jsp:param name="serviceName" value="ReasServiceImpl" />
  </jsp:include> 
</body>
</html>
