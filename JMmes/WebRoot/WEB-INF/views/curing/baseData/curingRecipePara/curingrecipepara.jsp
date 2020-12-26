<!-- 

    作者      :刘朋
    修改人   :徐秉正
    时间      :2018-09-27 10:55:48 
    页面名称:PLM配方下发基础参数表
    文件关联:
        CuringRecipePara.java
        CuringRecipeParaController.java
        CuringRecipeParaServiceImpl.java
        CuringRecipeParaServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="curingrecipepara.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="Curingrecipepara_dg_toolbar">
            <%-- <form id="Curingrecipepara_search_form" class="form" >
                <!-- 参数类型：1-成型、2-硫化 -->
                <input name="filter[basetype_s]" id="basetype_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="curingrecipepara.column.basetype_s" />'" >
                <!-- 主键ID -->
                <input name="filter[id_i]" id="id_i" type="text" class="easyui-textbox" data-options="label:'<spring:message code="curingrecipepara.column.id_i" />'" >
                <!-- 逻辑地址 -->
                <input name="filter[logicaladdress_s]" id="logicaladdress_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="curingrecipepara.column.logicaladdress_s" />'" >
                <!-- 参数CODE -->
                <input name="filter[parmcode_s]" id="parmcode_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="curingrecipepara.column.parmcode_s" />'" >
                <!-- 参数中文名称 -->
                <input name="filter[parmname_s]" id="parmname_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="curingrecipepara.column.parmname_s" />'" >
                <!-- 参数对象类型代码 -->
                <input name="filter[parmtypecode_s]" id="parmtypecode_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="curingrecipepara.column.parmtypecode_s" />'" >
                <!-- 参数对象类型名称： 10-硫化时间 11-胶囊拉伸 12-定型位置 13-定型时间 14-定型压力 15-合模力 16-一次定型高度 17-后充气卡盘宽度 18-后充气压力 19-二次定型高度 -->
                <input name="filter[parmtypename_s]" id="parmtypename_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="curingrecipepara.column.parmtypename_s" />'" >
                <!-- 记录标志，A可用，D删除 -->
                <input name="filter[record_flag_s]" id="record_flag_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="curingrecipepara.column.record_flag_s" />'" >
                <!-- 逻辑地址备注 -->
                <input name="filter[remark_s]" id="remark_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="curingrecipepara.column.remark_s" />'" >
                <!-- 参数值 -->
                <input name="filter[value_s]" id="value_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="curingrecipepara.column.value_s" />'" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-add'" onclick="filter()"><spring:message code="button.search" /></a>
            </form>  --%>
            	<auth:button code="LH_ZLGL_CURINGRECIPEPARA_ADD"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            	<auth:button code="LH_ZLGL_CURINGRECIPEPARA_SAVE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
				<auth:button code="LH_ZLGL_CURINGRECIPEPARA_EDIT"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
				<%-- <auth:button code="LH_ZLGL_CURINGRECIPEPARA_REMOVE"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button> --%>
				<auth:button code="LH_ZLGL_CURINGRECIPEPARA_OPEN"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-add'" onclick="start()"><spring:message code="button.start" /></a> </auth:button> 
				<auth:button code="LH_ZLGL_CURINGRECIPEPARA_CLOSE"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-remove'" onclick="stop()"><spring:message code="button.stop" /></a></auth:button>
				<auth:button code="LH_ZLGL_CURINGRECIPEPARA_EXPORT"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
				<auth:button code="LH_ZLGL_CURINGRECIPEPARA_CANCEL"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a></auth:button>
        </div>
        <table id="curingrecipepara_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#Curingrecipepara_dg_toolbar',
                url: 'curing/baseData/curingRecipePara/datagrid',
                striped:true,
                method: 'get' ,
                pageSize: 100,
                 emptyMsg:'<span><spring:message code='tip.noData'/></span>',
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 参数类型：1-成型、2-硫化 -->
                    <th data-options="field:'basetype_s',formatter:basetypeText,width:100,editor:{type:'combobox',
						              options:{
						              required:true,
		                              panelHeight:100,
		                    		  data:[{value:'1',text:'成型'},{value:'2',text:'硫化'}]}}"><spring:message code="curingrecipepara.column.basetype_s" /></th>
                    <!-- 逻辑地址 -->
                    <th data-options="field:'logicaladdress_s',editor:{type:'textbox'}"><spring:message code="curingrecipepara.column.logicaladdress_s" /></th>
                    <!-- 参数CODE -->
                    <th data-options="field:'parmcode_s',editor:{type:'textbox'}"><spring:message code="curingrecipepara.column.parmcode_s" /></th>
                    <!-- 参数中文名称 -->
                    <th data-options="field:'parmname_s',editor:{type:'textbox'}"><spring:message code="curingrecipepara.column.parmname_s" /></th>
                    <!--  单位 -->
                    <th data-options="field:'unit_s',width:60,editor:{type:'textbox'}"><spring:message code="curingrecipepara.column.unit_s" /></th>
                    <!-- 参数对象类型代码 -->
                    <th data-options="field:'parmtypecode_s',editor:{type:'textbox'}"><spring:message code="curingrecipepara.column.parmtypecode_s" /></th>
                    <!-- 参数对象类型名称： 10-硫化时间 11-胶囊拉伸 12-定型位置 13-定型时间 14-定型压力 15-合模力 16-一次定型高度 17-后充气卡盘宽度 18-后充气压力 19-二次定型高度 -->
                    <th data-options="field:'parmtypename_s',editor:{type:'textbox'}"><spring:message code="curingrecipepara.column.parmtypename_s" /></th>
                    <!-- 记录标志，A可用，D删除 -->
                    <th data-options="field:'record_flag_s',styler:cellStyler,width:100,formatter:recordflagText,editor:{}"><spring:message code="curingrecipepara.column.record_flag_s" /></th>
                    <!-- 逻辑地址备注 -->
                    <th data-options="field:'remark_s',editor:{type:'textbox'}"><spring:message code="curingrecipepara.column.remark_s" /></th>
                    <!--  修改人 -->
                    <th data-options="field:'changename',editor:{}"><spring:message code="curingrecipepara.column.changed_by_s" /></th>
                    <!--  修改时间 -->
                    <th data-options="field:'changed_time_t',editor:{}"><spring:message code="curingrecipepara.column.changed_time_t" /></th>
                    
                </tr>
            </thead>
        </table>
    </div>
    <!-- 导出 -->    
	<jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="condition_form" />
		<jsp:param name="datagridId" value="curingrecipepara_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.curing.excel.CuringRecipeParaExportHandler" />
		<jsp:param name="serviceName" value="CuringRecipeParaServiceImpl" />
	</jsp:include>
    
</body>
</html>
