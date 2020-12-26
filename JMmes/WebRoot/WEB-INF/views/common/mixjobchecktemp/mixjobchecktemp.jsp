<!-- 

    作者      :陈国强
    时间      :2020-09-09 14:49:53 
    页面名称:密炼作业准备检查模板表
    文件关联:
        MixJobCheckTemp.java
        MixJobCheckTempController.java
        MixJobCheckTempServiceImpl.java
        MixJobCheckTempServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/meta.jsp"%>
<%@ include file="mixjobchecktemp.js.jsp"%>
<script type="text/javascript" src="dict/079,080,081,082.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="MixJobCheckTemp_dg_toolbar">
            <form id="MixJobCheckTemp_search_form" class="form" >
                <!-- 工序名称： 079001-母炼线上辅机 079002-母炼线密炼机 079003-终练线上辅机 079004-终练线密炼机 079005-小粉料 079006-手工称料 079007-电子秤 -->
                <spring:message code="mixjobchecktemp.column.check_note_s" />
                <input name="filter[check_note_s]" id="check_note_s" type="text" class="easyui-combotree"
                 data-options="labelWidth:'auto',
                                            panelHeight:100,
										    required:false,
										    editable:false,
										    data:checkNote,
										    textField:'text',
										    valueField:'code',
										    method:'get'"  >
                <!-- 点检类别： 080001-设备情况：作业前、中、结束 080002-安全环保：作业前、中、结束 080003-计量器具：玛法、实测重量 080004-卫生：作业前、中、结束 080005-工艺 -->
                <spring:message code="mixjobchecktemp.column.check_type_s" />
                <input name="filter[check_type_s]" id="check_type_s" type="text" class="easyui-combotree" data-options="labelWidth:'auto',
                                            panelHeight:100,
										    required:false,
										    editable:false,
										    data:checkType,
										    textField:'text',
										    valueField:'code',
										    method:'get'"  >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="SYS_JCSJWH_MIXJOBCHECKTEMP_ADD"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="SYS_JCSJWH_MIXJOBCHECKTEMP_EDIT"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="SYS_JCSJWH_MIXJOBCHECKTEMP_REMOVE"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            　
            <auth:button code="SYS_JCSJWH_MIXJOBCHECKTEMP_SAVE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="SYS_JCSJWH_MIXJOBCHECKTEMP_CANCEL"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            　
            <auth:button code="SYS_JCSJWH_MIXJOBCHECKTEMP_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
        </div>
        <table id="mixjobchecktemp_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#MixJobCheckTemp_dg_toolbar',
            <!--     url: 'common/MixJobCheckTemp/datagrid', -->
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 工序名称： 079001-母炼线上辅机 079002-母炼线密炼机 079003-终练线上辅机 079004-终练线密炼机 079005-小粉料 079006-手工称料 079007-电子秤 -->
                    <th data-options="field:'check_note_s',formatter:codeFormatter,editor:{type:'combobox',options:{
										  required:true,
										  editable:false,
										  panelHeight:100,
										  disabled:false,
					                      data:checkNote,
					                      textField:'text',
					                      valueField:'code',
					                      onSelect:oncheckType
					                      }}" style="width: 150px;"><spring:message code="mixjobchecktemp.column.check_note_s" /></th>
                    <!-- 点检类别： 080001-设备情况：作业前、中、结束 080002-安全环保：作业前、中、结束 080003-计量器具：玛法、实测重量 080004-卫生：作业前、中、结束 080005-工艺 -->
                    <th data-options="field:'check_type_s',formatter:codeFormatter,editor:{type:'combobox',options:{
										  required:true,
										  editable:false,
										  panelHeight:100,
										  disabled:false,
					                      data:checkType,
					                      textField:'text',
					                      valueField:'code'
					                      }}"style="width: 200px;"><spring:message code="mixjobchecktemp.column.check_type_s" /></th>
                    <!-- 检查项编码 -->
                    <th data-options="field:'check_itemcode_s',width:100,editor:{type:'textbox'}"><spring:message code="mixjobchecktemp.column.check_itemcode_s" /></th>
                    <!-- 检查项 -->
                    <th data-options="field:'check_item_s',editor:{type:'textbox'}"><spring:message code="mixjobchecktemp.column.check_item_s" /></th>
                    <!-- 点检方法： 081001-目视 081002-耳听 081003-耳听、目视 081004-手摸 081005-手摸、目视 081006-标准砝码 081007-数显表 081008-测湿仪 081009-车报表 081010-温度仪 081011-手试拉绳 -->
                    <th data-options="field:'check_rate_s',formatter:codeFormatter,editor:{type:'combobox',options:{
										  required:true,
										  editable:false,
										  panelHeight:100,
										  disabled:false,
					                      data:checkRate,
					                      textField:'text',
					                      valueField:'code'
					                      }}" style="width: 100px;"><spring:message code="mixjobchecktemp.column.check_rate_s" /></th>
                    <!-- 点检标准 -->
                    <th data-options="field:'check_name_s',editor:{type:'textbox'}"><spring:message code="mixjobchecktemp.column.check_name_s" /></th>
                    <!-- 异常处理： 082001-停机检查 082002-随机修理 082003-停车加油 082004-停车整改 082005-重新校验 082006-停机汇报 082007-开启 082008-清理 082009-调整检查 082010-汇报整理 082011-现场整改 082012-紧固 082013-停机整理 -->
                    <th data-options="field:'spare1_s',formatter:codeFormatter,editor:{type:'combobox',options:{
										  required:true,
										  editable:false,
										  panelHeight:100,
										  disabled:false,
					                      data:checkName,
					                      textField:'text',
					                      valueField:'code'
					                      }}"style="width: 80px;"><spring:message code="mixjobchecktemp.column.spare1_s" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_s'"><spring:message code="mixjobchecktemp.column.created_by_s" /></th>
                    <!-- 创建人姓名 -->
                    <th data-options="field:'created_name_s'"><spring:message code="mixjobchecktemp.column.created_name_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t'"><spring:message code="mixjobchecktemp.column.created_time_t" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changed_by_s'"><spring:message code="mixjobchecktemp.column.changed_by_s" /></th>
                    <!-- 修改人姓名 -->
                    <th data-options="field:'changed_name_s'"><spring:message code="mixjobchecktemp.column.changed_name_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t'"><spring:message code="mixjobchecktemp.column.changed_time_t" /></th>
                    <!-- 备用字段2 -->
                    <th data-options="field:'spare2_s'"><spring:message code="mixjobchecktemp.column.spare2_s" /></th>
                    <!-- 备用字段3 -->
                    <th data-options="field:'spare3_s'"><spring:message code="mixjobchecktemp.column.spare3_s" /></th>
                    <!-- 备用字段4 -->
                    <th data-options="field:'spare4_s'"><spring:message code="mixjobchecktemp.column.spare4_s" /></th>
                    <!-- 备用字段5 -->
                    <th data-options="field:'spare5_s'"><spring:message code="mixjobchecktemp.column.spare5_s" /></th>
                 </tr>
            </thead>
        </table>
    </div>
    <!--导出-->    
	<jsp:include page="../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="MixJobCheckTemp_search_form" />
		<jsp:param name="datagridId" value="mixjobchecktemp_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.common.ExcelHandler.MixJobCheckTempExportHandler" />
		<jsp:param name="serviceName" value="MixJobCheckTempServiceImpl" />
	</jsp:include>
</body>
</html>
