<!-- 

    作者      :马建斌&刘程明
    时间      :2018-09-03 14:27:44 
    页面名称:质检外观扫描履历表
    文件关联:
        ScanAppearanceLog.java
        ScanAppearanceLogController.java
        ScanAppearanceLogServiceImpl.java
        ScanAppearanceLogServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="scanappearancelog.js.jsp"%>
<script type="text/javascript" src="dict/259.js"></script>
<style type="text/css">
.columnTitle {
	padding: 6px 10px
}
</style>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="ScanAppearanceLog_dg_toolbar">
            <form id="ScanAppearanceLog_search_form" class="form" >
            	<table class="formTable">
					<tr>
						<!-- 操作时间 -->
						<spring:message code="sortdynabalancelog.column.sorttime_t" />:
                		<input name="filter[begin_created_time]" editable="true" id="begin_created_time" type="text" class="easyui-textbox"   style="width:160px"   data-options="label:''" >
                 	        到
                		<input name="filter[end_created_time]" editable="true"   id="end_created_time" class="easyui-datetimebox"  style="width:160px">
						<!-- 轮胎条码-->
						<spring:message code="sortdynabalancelog.column.barcode_s" />:
                		<input name="filter[barcode_s]" id="barcode_s"  type="text" style="width:150px" class="easyui-textbox" data-options="label:''" >
						<!-- 物料编码 -->
						<spring:message code="scandynabalancelog.column.entbarcode_s" />:
						<input name="filter[entbarcode_s]" id="entbarcode_s" type="text" class="easyui-combobox" style="width:150px" data-options="label:'',
                                        required:false, 
                                        panelHeight:200,
                                        icons:[{iconCls:'icon-clear',handler:function(e){$(e.data.target).combobox('clear')}}],
			                             method: 'get',
			                             url:'finalcheck/qualityInspectionRecord/scanAppearanceLog/combox_entcode?spare1_s='+'260002',
			                             valueField:'ENTBARCODE_S',
			                             textField:'ENTNAME_S'">
			            <spring:message code="sortdynabalancelog.column.itemid_s" />:
                		<input name="filter[itemid_s]" id="itemid_s"  like="true"  type="text" style="width:150px" class="easyui-textbox" data-options="label:''" >
                	
                		
                		<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
						  <auth:button code="ZJ_ZJGL_DPHSMLL_DC"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            <auth:button code="ZJ_ZJGL_DPHSMLL_CXL"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-hide'" onclick="searchBar()"><spring:message code="button.searchColumn" /></a></auth:button>        
						
						
					</tr>
				</table>
            
            
            	 
           	 	
            	 
            </form> 
			         </div>
        <table id="scanappearancelog_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                emptyMsg: '<span><spring:message code='tip.noData'/></span>',
                singleSelect: false,
                toolbar: '#ScanAppearanceLog_dg_toolbar',
                url: '',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                     <th data-options="field:'atr_key',checkbox:true">ID</th>
               	 	<!-- 轮胎条码：MES_MainTyre 表 BARCODE -->
                    <th data-options="field:'barcode_s'"><spring:message code="scandynabalancelog.column.barcode_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'itemid_s'"><spring:message code="sortdynabalancelog.column.itemid_s" /></th>
               	 	 <!-- 物料描述 -->
                    <th data-options="field:'description'"><spring:message code="materialsplus.column.materialdesc_s" /></th>
               	 	<!-- 质检设备表ID -->
                    <th data-options="field:'entname_s'"><spring:message code="scandynabalancelog.column.entbarcode_s" /></th>
                	<!-- MES校验是否成功：0-失败，1-成功 -->
                    <th data-options="field:'isok_i', formatter:mesxy,editor:{type:'textbox',options:{required:true}}"><spring:message code="sortappearancelog.column.isok_i" /></th>
                	 <!-- 错误类型： 1:轮胎条码不存在 2:机台信息不存在 3:规格索引不存在 4:轮胎状态不允许分配 5:轮胎规格规则未维护 6:拨胎器异常 7:机台停止 8:扫描头未读取到条码 9:其它 -->
                       <th data-options="field:'etype_i',formatter:codeFormatter,editor:{type:'combotree',options:
                                {
                                method:'get',
                                 data:DICT_259}}"><spring:message code="sortappearancelog.column.etype_i" /></th>           
                  	 <!-- 备注 -->
                    <th data-options="field:'remark_s'"><spring:message code="sortappearancelog.column.remark_s" /></th>
                     <!-- 工控下发是否成功：0-成功、1-失败 -->
                    <th data-options="field:'writein_i', formatter:mesxy,editor:{type:'textbox',options:{required:true}}"><spring:message code="sortappearancelog.column.writein_s" /></th>
                	 <!-- 工控下发备注 -->
                    <th data-options="field:'writeinremark_s'"><spring:message code="sortappearancelog.column.writeinremark_s" /></th>
                    <!--硫化商标  -->
                    <th data-options="field:'brand_s'"><spring:message code="scanxraylog.column.brand_s" /></th>
                	 <!-- 创建时间 -->
                    <th data-options="field:'created_time_t'"><spring:message code="scandynabalancelog.column.created_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
      <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="ScanAppearanceLog_search_form" />
		<jsp:param name="datagridId" value="scanappearancelog_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.zj.excel.ScanAppearanceLogExportHandler" />
		<jsp:param name="serviceName" value="ScanAppearanceLogServiceImpl" />
	</jsp:include>
</body>
</html>
