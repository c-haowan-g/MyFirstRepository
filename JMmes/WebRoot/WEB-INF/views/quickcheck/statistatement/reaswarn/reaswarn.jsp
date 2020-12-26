<!-- 

    作者      :肖吉朔
    时间      :2020-08-07 13:21:10 
    页面名称:病象预警等级表
    文件关联:
        ReasWarn.java
        ReasWarnController.java
        ReasWarnServiceImpl.java
        ReasWarnServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="reaswarn.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="reaswarn_dg_toolbar">
            <form id="reaswarn_search_form" class="form" >
                <table class="formTable">
				<tr>
					 <!-- 病象组编号 -->
                     <spring:message code="reas.column.reas_grp_type_s" />:
                        <input name="filter[reas_grp_type_s]" id="reas_grp_type_s" type="text" class="easyui-combotree" 
                        data-options="label:'', 
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
            
            <auth:button code="BAN_GANG_MIX_BZGL_HGXKZ_BJ"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>

            <auth:button code="BAN_GANG_MIX_BZGL_HGXKZ_BC"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
     
            <auth:button code="BAN_GANG_MIX_BZGL_HGXKZ_DC"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            <auth:button code="BAN_GANG_MIX_BZGL_HGXKZ_QX"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
        </div>
        <table id="reaswarn_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: true,
                toolbar: '#reaswarn_dg_toolbar',
                url: 'quickcheck/statistatement/reaswarn/datagridUDA',
                striped:true,
                method: 'get' 
                ">
            <thead>
                 <tr>
            		<th data-options="colspan:3"></th>
            		<!-- 停机条件 -->
                    <th data-options="width:660,colspan:3">停机条件<%-- <spring:message code="reaswarn.column.dw_where2_s" /> --%></th>
                 </tr>
                <tr>
                    <!-- <th data-options="field:'atr_key',checkbox:true">ID</th>  -->
                    <!-- 病象组 -->
                    <th data-options="field:'dw_reas_grp_desc_s',width:120"><spring:message code="reas.column.reas_grp_type_s" /></th>
                    <!-- 病象类 -->
                    <th data-options="field:'spare2_s',width:120"><spring:message code="reas.column.collet_code_s" /></th>       
                    <!-- 病象描述（中文） -->
                    <th data-options="field:'spare1_s',width:120"><spring:message code="reas.column.reas_cn_s" /></th>
                    <!-- 停机-数量 -->
                    <th data-options="field:'dw_num1_i',width:100,editor:{type:'textbox'}">数量（条）<%-- <spring:message code="reaswarn.column.dw_num1_i" /> --%></th>
                    <!-- 停机-预警附加条件：1-同规格,同机台,同班次、2-不同机台，同一病象  type = 114 eg 1,2,3 -->
                    <th align="center" data-options="field:'dw_where1_s',width:300,formatter:dwforText,
                    editor:{type:'combobox',options:{ 
						  required:true,
						  editable:false,
						  disabled:false,
	                      data:[{text:'同规格,同机台,同班次',value:'1'},
	                            {text:'不同机台，同一病象',value:'2'}],
	                      textField:'text',
	                      valueField:'value'
	                      }}">条件<%-- <spring:message code="reaswarn.column.dw_where1_s" /> --%></th>
                    <!-- 预警开关：0-开，1-关 -->
                    <th  data-options="field:'dw_is_warm_s',formatter:formatOper,width:100">预警开关
                     <%-- <spring:message code="reaswarn.column.dw_is_warm_s" /> --%></th>
                    
                </tr>
            </thead>
        </table>
    </div>
        <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="reaswarn_search_form" />
		<jsp:param name="datagridId" value="reaswarn_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.quickcheck.excel.ReasWarnExportHandler" />
		<jsp:param name="serviceName" value="ReasWarnServiceImpl" />
        </jsp:include> 
</body>
</html>
