<!-- 

    作者      :刘朋
    时间      :2019-09-12 09:49:19 
    页面名称:质检均匀性扫描履历表-全钢
    文件关联:
        ScanUniformLog.java
        ScanUniformLogController.java
        ScanUniformLogServiceImpl.java
        ScanUniformLogServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="scanuniformlog.js.jsp"%>
<script type="text/javascript" src="dict/259.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="ScanUniformLog_dg_toolbar">
            <form id="ScanUniformLog_search_form" class="form" >
                <!-- 操作时间 -->
				<spring:message code="sortdynabalancelog.column.sorttime_t" />:
            		<input name="filter[begin_created_time]" editable="true" id="begin_created_time" type="text" class="easyui-textbox"   style="width:160px"   data-options="label:''" >
             	       到
            		<input name="filter[end_created_time]" editable="true"   id="end_created_time" class="easyui-datetimebox"  style="width:160px">
                <!-- 设备ID：质检设备信息表主键ID -->
                <spring:message code="scanuniformlog.column.entbarcode_s" />:<input name="filter[entbarcode_s]" id="entbarcode_s" type="text" class="easyui-combobox" style="width:130px" data-options="label:'',
                                        required:false, 
                                        panelHeight:200,
                                        icons:[{iconCls:'icon-clear',handler:function(e){$(e.data.target).combobox('clear')}}],
			                             method: 'get',
			                             url:'finalcheck/baseData/entmodel/SearchEnt?equip_type=254005',
			                             valueField:'EQUIP_NAME',
			                             textField:'DESCRIPTION'" >
                <!-- 轮胎条码：MainTyre 表 BARCODE -->
                <spring:message code="scanuniformlog.column.barcode_s" />:<input name="filter[barcode_s]" id="barcode_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 品号 -->
                <spring:message code="scanuniformlog.column.itemid_s" />:<input name="filter[itemid_s]" id="itemid_s" type="text" class="easyui-textbox" data-options="label:''" >
            	</br>
            	<!-- MES校验 -->
				<spring:message code="sortappearancelog.column.isok_i" />:
                <input name="filter[isok_s]" id="isok_s"   type="text" class="easyui-combobox" style="width:150px" data-options="label:'',
                		                 required:false, 
                                       	 data: [{
											text: '请选择',
											value: ''
										},{
											text: '成功',
											value: '1'
										},{
											text: '失败',
											value: '0'
										}]" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            	<auth:button code="XXX"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            </form> 
            　
            　
        </div>
        <table id="scanuniformlog_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#ScanUniformLog_dg_toolbar',
                url: '',
                striped:true,
                method: 'get',
                emptyMsg: '<span><spring:message code='tip.noData'/></span>' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 轮胎条码：MainTyre 表 BARCODE -->
                    <th data-options="field:'barcode_s',width:80,editor:{type:'textbox'}"><spring:message code="scanuniformlog.column.barcode_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'itemid_s',width:80,editor:{type:'textbox'}"><spring:message code="scanuniformlog.column.itemid_s" /></th>
                    <!-- 硫化规格描述 -->
                    <th data-options="field:'materialdesc_s'"><spring:message code="materialsplus.column.materialdesc_s" /></th>
                    <!-- 机台 -->
                    <th data-options="field:'entname_s',width:80,editor:{type:'textbox'}"><spring:message code="scanuniformlog.column.entbarcode_s" /></th>
                    <!-- 配方号：D_BS_Recipe 表 ID -->
                    <th data-options="field:'recipeno_i',editor:{type:'textbox'}"><spring:message code="scanuniformlog.column.recipeno_i" /></th>
                     <!-- MES校验是否成功：0-失败，1-成功 -->
                    <th data-options="field:'isok_s',formatter:isok,editor:{type:'textbox'}"><spring:message code="scanuniformlog.column.isok_s" /></th>
                    <!-- MES校验错误类型： 1:轮胎条码 2:机台信息不存在 3:规格索引不存在 4:轮胎状态不允许分配 -->
                    <th data-options="field:'etype_s',formatter:etypeFormatter,editor:{type:'combotree',options:
                                {
                                method:'get',
                                 data:DICT_259}}"><spring:message code="scanuniformlog.column.etype_s" /></th>
                    <!-- MES备注 -->
                    <th data-options="field:'remark_s',width:120,editor:{type:'textbox'}"><spring:message code="scanuniformlog.column.remark_s" /></th>
                    <!-- 工控下发是否成功：0-失败、1-成功 -->
                    <th data-options="field:'writein_s',formatter:writein,editor:{type:'textbox'}"><spring:message code="scanuniformlog.column.writein_s" /></th>
                    <!-- 工控下发备注 -->
                    <th data-options="field:'writeinremark_s',width:120,editor:{type:'textbox'}"><spring:message code="scanuniformlog.column.writeinremark_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',width:150,editor:{type:'textbox'}"><spring:message code="scanuniformlog.column.created_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
     <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="ScanUniformLog_search_form" />
		<jsp:param name="datagridId" value="scanuniformlog_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.finalcheck.excel.ScanUniformLogExportHandler" />
		<jsp:param name="serviceName" value="ScanUniformLogServiceImpl" />
	</jsp:include>
</body>
</html>
