<!-- 

    作者      :刘朋
    时间      :2018-08-10 07:56:16 
    页面名称:质检设备信息表
    文件关联:
        EntModel.java
        EntModelController.java
        EntModelServiceImpl.java
        EntModelServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="entmodel.js.jsp"%>
<script type="text/javascript" src="dict/254,255,260.js"></script>
<style type="text/css">
.columnTitle {
	padding: 6px 10px
}
</style>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="Ent_dg_toolbar">
            <form id="Ent_search_form" class="form" >
            <table class="formTable">
					<tr>
						<spring:message code="ent.column.enttype_i" />:
                             <input name="filter[equip_type_s]" id="equip_type_s" type="text" class="easyui-combotree" data-options="label:'', 
                               width:'150px',
                              required:false,
                             data:DICT_254,
                              method:'get'" >
						
						 <!-- 机台条码 -->
						 <spring:message code="ent.column.entbarcode_s" />:
                           <input name="filter[equip_name]" id="equip_name" like="true" type="text" class="easyui-textbox" data-options="label:'', width:'150px'" >
						<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
					</tr>
			</table>
            </form> 
            <auth:button code="ZJ_JCGL_SB_USER_ADD"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="ZJ_JCGL_SB_USER_EDIT"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="ZJ_JCGL_SB_USER_REMOVE"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            <auth:button code="ZJ_JCGL_SB_USER_SAVE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="ZJ_JCGL_SB_USER_CANCLE"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            <auth:button code="ZJ_JCGL_SB_USER_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
           <%--  <auth:button code="ZJ_JCGL_SB_FORCEON"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-add'" onclick="on_off('1')" ><spring:message code="button.forcedstart" /></a></auth:button>
           	<auth:button code="ZJ_JCGL_SB_FORCEOFF"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-remove'" onclick="on_off('0')"><spring:message code="button.forcedoff" /> </a></auth:button> --%>
            <a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-hide'" onclick="showhide()"><spring:message code="查询栏" /></a>
        </div>
        <table id="ent_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                emptyMsg: '<span><spring:message code='tip.noData'/></span>',
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#Ent_dg_toolbar',
                url: 'finalcheck/baseData/entmodel/datagridUDA',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                <th data-options="field:'equip_key',checkbox:true">ID</th>
                <!-- 分拣点 -->
                <th data-options="field:'uda_0',width:70,formatter:codeFormatter,editor:{type:'combotree',options:
                                {required:true,
                                method:'get',
                                data:DICT_260}}"><spring:message code="ent.column.spare1_s" /></th>
                <!-- 设备类型 -->
                <th data-options="field:'equip_type_s',width:70,formatter:codeFormatter,editor:{type:'combotree',options:
                                {required:true,
                                method:'get',
                                data:DICT_254}}"><spring:message code="ent.column.enttype_i" /></th>
                    <!-- 机台条码 -->
                    <th data-options="field:'equip_name',width:70,editor:{type:'textbox',options:{onChange:exitEntbarcode,required:true}}"><spring:message code="ent.column.entbarcode_s" /></th>
                    <!-- 机台名称 -->
                    <th data-options="field:'description',width:70,editor:{type:'textbox',options:{required:true}}"><spring:message code="ent.column.entname_s" /></th>
                   <!-- 优先级 -->
                   <th data-options="field:'uda_1',width:70,editor:{type:'textbox',options:{required:true,validType:['number']}}"><spring:message code="ent.column.sortnum_i" /></th>  
                    <!-- 工作状态：255001-正常、255002-停用、255003-换轮辋、255004-检修 -->
                    <th data-options="field:'status_s',width:70,formatter:codeFormatter,editor:{type:'combotree',options:
                                {required:true,
                                method:'get',
                                data:DICT_255}}"><spring:message code="ent.column.iswork_i" /></th>
                   <%--  <!-- 是否强制执行 -->
                    <th data-options="field:'device_valid_s',formatter:spareFormatter,width:70"><spring:message code="ent.column.spare2_s" /></th> --%>
                   <th data-options="field:'uda_2',width:80"><spring:message code="创建人" /></th>
                   
                   <th data-options="field:'changeby_s',width:80"><spring:message code="修改人" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'creation_time',width:80"><spring:message code="ent.column.created_time_t" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'last_modified_time',width:80"><spring:message code="ent.column.changed_time_t" /></th>
                   
                   
                  
                   
                    </tr>
            </thead>
        </table>
    </div>
     <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="Ent_search_form" />
		<jsp:param name="datagridId" value="ent_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.finalcheck.excel.EntModelExportHandler" />
		<jsp:param name="serviceName" value="EntModelServiceImpl" />
  </jsp:include> 
  
</body>
</html>
