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
<%@ include file="reas.js.jsp"%>
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
            <auth:button code="ZJ_JCGL_BX_USER_ADD"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="ZJ_JCGL_BX_USER_EDIT"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="ZJ_JCGL_BX_USER_REMOVE"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            |
            <auth:button code="ZJ_JCGL_BX_USER_SAVE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="ZJ_JCGL_BX_USER_CANCEL"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            |
            <auth:button code="ZJ_JCGL_BX_USER_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
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
                    <th data-options="field:'reas_grp_type_s',width:100,formatter:codeFormatter,editor:{type:'combotree',options:{panelWidth:120,required:true,method:'get',
                                data:DICT_261}}"><spring:message code="reas.column.reas_grp_type_s" /></th>
                    <!-- 病象类代码 -->
                    <th data-options="field:'collet_code_s',width:100,formatter:codeFormatter,editor:{type:'combotree',options:{panelWidth:120,required:true,method:'get',
                                data:DICT_262}}"><spring:message code="reas.column.collet_code_s" /></th>
                    <!-- 病象编号 -->
                    <th data-options="field:'reas_code_s',width:80"><spring:message code="reas.column.reas_code_s" /></th>
                    <!-- 病象描述（中文） -->
                    <th data-options="field:'reas_cn_s',width:80,editor:{type:'textbox',options:{panelWidth:120,required:true}}"><spring:message code="reas.column.reas_cn_s" /></th>
                    <!-- 处理措施（中文） -->
                    <th data-options="field:'handle_cn_s',width:80,editor:{type:'textbox'}"><spring:message code="reas.column.handle_cn_s" /></th>
                    <!-- 备注 -->
                    <th data-options="field:'spare1_s',width:80,editor:{type:'textbox',options:{panelWidth:120,required:true}}"><spring:message code="wwwwww.column.memo_s" /></th>
                    <!-- 备注 -->
                    <th data-options="field:'spare2_s',width:80,editor:{type:'textbox',options:{panelWidth:120}}"><spring:message code="reas.column.spare2_s" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_s',width:80,formatter:userFormatter"><spring:message code="reas.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',width:80,formatter:formatter2"><spring:message code="reas.column.created_time_t" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changed_by_s',width:80,formatter:userFormatter"><spring:message code="reas.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',width:80,formatter:formatter2"><spring:message code="reas.column.changed_time_t" /></th>
                    
                    </tr>
            </thead>
        </table>
    </div>
    
     <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="Reas_search_form" />
		<jsp:param name="datagridId" value="reas_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.finalcheck.excel.ReasExportHandler" />
		<jsp:param name="serviceName" value="ReasServiceImpl" />
  </jsp:include> 
    
</body>
</html>
