<!-- 

    作者      :时永良
    时间      :2019年7月17日16:49:51 
    页面名称:模具标识图维护
    文件关联:
        MaterialPDF.java
        MaterialPDFController.java
        MaterialPDFServiceImpl.java
        MaterialPDFServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="materialpdf.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="MaterialPDF_dg_toolbar">
            <form id="MaterialPDF_search_form" class="form" >
             	<!-- 原始PDF名称 -->
             	<spring:message code="materialpdf.column.pdf_name_original_s" />:
                <input name="filter[pdf_name_original_s]" id="pdf_name_original_s" like="true" style="width:15%" class="easyui-textbox" data-options="label:''" >
                <!-- 上传时间-->
                <spring:message code="materialpdf.column.upload_time_t" />:
                <input name="filter[upload_time_t]" id="upload_time_t" like="true" style="width:15%" class="easyui-datebox" data-options="label:''" >
                <!-- 物料编码 -->
                <spring:message code="materialpdf.column.material_code_s" />:
                <input name="filter[material_code_s]"  id="material_code_s" like="true" style="width:15%;" class="easyui-combobox" data-options="label:'',
										  panelHeight:200,
										  required:false,
										  editable:'true',
										  limitToList:'false',
										  url:'curing/moldmanagement/moldmarkingdrawing/materialpdf/searchByMaterial',
										  valueField: 'MATERIALCODE_S',
                              			  textField: 'MATERIALCODE_S',
										  method:'get'" >
                <!-- 有效标志 -->
                <spring:message code="materialpdf.column.is_flag_s" />:
                <input name="filter[is_flag_s]" id="is_flag_s" style="width:10%" class="easyui-combobox" data-options="label:'',
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
            <auth:button code="MaterialPDF.add"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="MaterialPDF.edit"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="MaterialPDF.remove"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            <auth:button code="MaterialPDF.save"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="MaterialPDF.cancel"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            <auth:button code="MaterialPDF.export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
        	<auth:button code="MaterialPDF.download"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-save'" onclick="downloads()"><spring:message code="button.download" /></a></auth:button>
            <auth:button code="MaterialPDF.check"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-search'" onclick="check()"><spring:message code="button.check" /></a></auth:button>
        	<auth:button code="MaterialPDF.showOrHide"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="showOrHide()"><spring:message code="button.searchColumn" /></a></auth:button>
        </div>
        <table id="materialpdf_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#MaterialPDF_dg_toolbar',
                url: 'curing/moldmanagement/moldmarkingdrawing/materialpdf/searchBy',
                striped:true,
                method: 'get',
                emptyMsg:'暂无数据' 
                ">
            <thead>
                <tr>
                	<th data-options="field:'atr_key',checkbox:true">ID</th>
                	<!-- 当前版本号 -->
                    <th data-options="field:'vision_s',width:70,editor:{type:'textbox',options:{required:true}}"><spring:message code="materialpdf.column.vision_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',width:80,editor:{type:'combobox',options:{
                    			panelHeight:200,
                    			method:'get',
                    			editable:'true',
                    			limitToList:'false',
                                url:'curing/moldmanagement/moldmarkingdrawing/materialpdf/searchByMaterial',
                                valueField: 'MATERIALCODE_S',
                              	textField: 'MATERIALCODE_S',
                    			required:true}}"><spring:message code="materialpdf.column.material_code_s" /></th>
                    <!-- 原始PDF名称 -->
                    <th id="fileboxid" data-options="field:'pdf_name_original_s_temp',formatter:function(v,r,i){return r.pdf_name_original_s},editor:{type:'filebox',options:{onChange:upload,accept:'application/pdf',buttonText:'<spring:message code="Choose File" />'}}"><spring:message code="materialpdf.column.pdf_name_original_s" /></th>
                    <!-- 上传人 -->
                    <th data-options="field:'uploader_s_name',width:50,editor:{type:'textBox',options:{required:true}}"><spring:message code="materialpdf.column.uploader_s" /></th>
                    <!-- 上传时间 -->
                    <th data-options="field:'upload_time_t',width:80,editor:{type:'textBox',options:{required:true}}"><spring:message code="materialpdf.column.upload_time_t" /></th>
                	<!-- 有效标识  1:有效 0 无效 -->
                    <th data-options="field:'is_flag_s',width:50,
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
                    validType:'length[1,100]'}}"><spring:message code="materialpdf.column.is_flag_s" /></th>
                </tr>
            </thead>
        </table>
    </div>
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="MaterialPDF_search_form" />
		<jsp:param name="datagridId" value="materialpdf_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.curing.excel.MaterialPDFExportHandler" />
		<jsp:param name="serviceName" value="MaterialPdfServiceImpl" />
	</jsp:include>
</body>
</html>
