<!-- 

    作者      :周清玉
    时间      :2019-05-07 11:27:42 
    页面名称:PLM配方下发基础参数表
    文件关联:
        BuildRecipePara.java
        BuildRecipeParaController.java
        BuildRecipeParaServiceImpl.java
        BuildRecipeParaServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="buildrecipepara.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="BuildRecipePara_dg_toolbar">
            <form id="BuildRecipePara_search_form" class="form" >
               <!-- 设备类型名称： 10-挤出联动线 11-钢丝圈成型机 12-胎圈贴合机 16-钢丝帘布压延机 17-多刀裁断机 20-尼龙帘布一次裁断 21-尼龙帘布二次裁断 22-全钢一次法成型机 23-半钢VMI一次法成型机 25-半钢二次法成型机 -->
                <spring:message code="buildrecipepara.column.equipmenttypecode_s" />
                :&emsp;<input name="filter[equipmenttypecode_s]" id="equipmenttypecode_s" type="text"  class="easyui-combobox"  data-options="label:'',
                                        required:false, 
                                        data:enttypeList,
			                             method: 'get',
			                              panelHeight:100,
			   	                          valueField:'EQUIPMENTTYPECODE_S',
			                             textField:'EQUIPMENTTYPENAME_S'"> 
                
                <!-- 参数类型代码 -->
                <spring:message code="buildrecipepara.column.parmtypecode_s" />
                :&emsp;<input name="filter[parmtypecode_s]" id="parmtypecode_s" type="text" class="easyui-combobox"  data-options="label:'',
                                        required:false, 
                                        url:'building/basedata/buildrecipepara/comboxparamtype',
			                             method: 'get',
			                              panelHeight:100,
			                             valueField:'PARMTYPECODE_S',
			                             textField:'PARMTYPENAME_S'"> 
                
                <!-- 参数CODE -->
                <spring:message code="buildrecipepara.column.parmcode_s" />
                :&emsp;<input name="filter[parmcode_s]" like =true id="parmcode_s" type="text" class="easyui-textbox" data-options="label:''" >
                
                <!-- 参数中文名称 -->
                <spring:message code="buildrecipepara.column.parmname_s" />
                :&emsp;<input name="filter[parmname_s]" like =true id="parmname_s" type="text" class="easyui-textbox" data-options="label:''" >
                <br>
                <!-- 记录标志，A可用，D删除 -->
                <spring:message code="buildrecipepara.column.record_flag_s" />
                :&emsp;<input name="filter[record_flag_s]" id="record_flag_s" type="text" class="easyui-combobox" 
	             data-options="label:'',
							   panelHeight:100,
							   editable:false,
							   required:false,
							   textField: 'label',
							    valueField: 'value',
							   data: [{label:'启用',value:'A'},
							          {label:'停用',value:'D'}]
							  ">
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="CX_QUAN_GANG_JCSJ_BUILDERCIPEPARA_EDIT"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="CX_QUAN_GANG_JCSJ_BUILDERCIPEPARA_SAVE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="CX_QUAN_GANG_JCSJ_BUILDERCIPEPARA_OPENPARA"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-add'" onclick="openpara()"><spring:message code="button.start" /></a></auth:button>
            <auth:button code="CX_QUAN_GANG_JCSJ_BUILDERCIPEPARA_CLOSEPARA"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-remove'" onclick="closepara()"><spring:message code="button.stop" /></a>  </auth:button>
             
             <auth:button code="CX_QUAN_GANG_JCSJ_BUILDERCIPEPARA_OpenAddress"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-add'" onclick="openaddress()"><spring:message code="button.startaddress" /></a></auth:button>
            <auth:button code="CX_QUAN_GANG_JCSJ_BUILDERCIPEPARA_CloseAddress"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-remove'" onclick="closeaddress()"><spring:message code="button.stopaddress" /></a>  </auth:button>
           
            <auth:button code="CX_QUAN_GANG_JCSJ_BUILDERCIPEPARA_CANCEL"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            <auth:button code="CX_QUAN_GANG_JCSJ_BUILDERCIPEPARA_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
        </div>
        <table id="buildrecipepara_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#BuildRecipePara_dg_toolbar',
                url: 'building/basedata/buildrecipepara/datagrid',
                striped:true,
                method: 'get',
                emptyMsg:'<span><spring:message code='tip.noData'/></span>',
                pageSize:300,
 				pageList:[300,600,900]
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 设备类型名称： 10-挤出联动线 11-钢丝圈成型机 12-胎圈贴合机 16-钢丝帘布压延机 17-多刀裁断机 20-尼龙帘布一次裁断 21-尼龙帘布二次裁断 22-全钢一次法成型机 23-半钢VMI一次法成型机 25-半钢二次法成型机 -->
                    <th data-options="field:'equipmenttypecode_s',formatter:enttypefromatter,width:130"><spring:message code="buildrecipepara.column.equipmenttypecode_s" /></th>
                    <!-- 参数类型代码 -->
                    <th data-options="field:'parmtypecode_s'"><spring:message code="buildrecipepara.column.parmtypecode_s" /></th>
                    <!-- 参数类型名称： 1000-施工显示参数 1001-施工控制参数 1002-接头定位角度显示参数 2000-施工显示参数 2001-施工控制参数 2002-接头定位角度控制参数 2003-接头定位角度显示参数 2004-施工显示参数 2005-施工显示参数 2006-施工显示参数 2007-施工显示参数 2008-施工显示参数 2009-施工显示参数 -->
                    <th data-options="field:'parmtypename_s'"><spring:message code="buildrecipepara.column.parmtypename_s" /></th>
                    <!-- 参数CODE -->
                    <th data-options="field:'parmcode_s'"><spring:message code="buildrecipepara.column.parmcode_s" /></th>
                    <!-- 参数中文名称 -->
                    <th data-options="field:'parmname_s'"><spring:message code="buildrecipepara.column.parmname_s" /></th>
                    <!-- 记录标志，A可用，D删除 -->
                    <th data-options="field:'record_flag_s',styler:cellStyler,formatter:recordflagText,width:80"><spring:message code="buildrecipepara.column.record_flag_s" /></th>
                    <!-- 单位 -->
                    <th data-options="field:'unit_s',width:80,editor:{type:'textbox'}"><spring:message code="buildrecipepara.column.unit_s" /></th>
                    <!-- 逻辑地址 -->
                    <th data-options="field:'logicaladdress_s'"><spring:message code="buildrecipepara.column.logicaladdress_s" /></th>
                    <!-- 逻辑地址备注 -->
                    <th data-options="field:'remark_s',editor:{type:'textbox'}"><spring:message code="buildrecipepara.column.remark_s" /></th>
                    <!-- 上下限是否启用：A-是、D-否 -->
                    <th data-options="field:'is_max_min_s',styler:cellStyler,formatter:recordflagText"><spring:message code="buildrecipepara.column.is_max_min_s" /></th>
                    <!-- 上限值逻辑地址 -->
                    <th data-options="field:'logicaladdress_max_s',editor:{type:'textbox'}"><spring:message code="buildrecipepara.column.logicaladdress_max_s" /></th>
                    <!-- 上限值逻辑地址描述 -->
                    <th data-options="field:'logicaladdress_max_name_s',editor:{type:'textbox'}"><spring:message code="buildrecipepara.column.logicaladdress_max_name_s" /></th>
                    <!-- 下限值逻辑地址 -->
                    <th data-options="field:'logicaladdress_min_s',editor:{type:'textbox'}"><spring:message code="buildrecipepara.column.logicaladdress_min_s" /></th>
                    <!-- 下限值逻辑地址描述 -->
                    <th data-options="field:'logicaladdress_min_name_s',editor:{type:'textbox'}"><spring:message code="buildrecipepara.column.logicaladdress_min_name_s" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changebyname',width:60"><spring:message code="buildrecipepara.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',width:130"><spring:message code="buildrecipepara.column.changed_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="BuildRecipePara_search_form" />
		<jsp:param name="datagridId" value="buildrecipepara_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.building.excel.BuildiRecipeParaExportHandler" />
		<jsp:param name="serviceName" value="WorkOrderResultServiceImpl" />
	</jsp:include>
</body>
</html>
