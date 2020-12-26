<!--

作者 :wanghailin
时间 :2018-08-09 15:47:59
页面名称:2018
文件关联:
ScanDynaBalanceLog.java
ScanDynaBalanceLogController.java
ScanDynaBalanceLogServiceImpl.java
ScanDynaBalanceLogServiceImpl.xml
-->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="../../../../inc/meta.jsp" %>
<%@ include file="scandynabalancelog.js.jsp" %>
<script type="text/javascript" src="dict/259.js"></script>
<style type="text/css">
    .columnTitle {
        padding: 6px 10px
    }
</style>
<body class="easyui-layout" fit="true">
<div data-options="region:'center',split:true,border:false">
    <div id="ScanDynaBalanceLog_dg_toolbar">
        <form id="ScanDynaBalanceLog_search_form" class="form">
            <table class="formTable">
                <tr>
                    <!-- 操作时间 -->
                    <spring:message code="sortdynabalancelog.column.sorttime_t"/>:
                    <input name="filter[begin_created_time]" editable="true" id="begin_created_time" type="text"
                           class="easyui-textbox" style="width:160px" data-options="label:''">
                    到
                    <input name="filter[end_created_time]" editable="true" id="end_created_time"
                           class="easyui-datetimebox" style="width:160px">
                    <!-- 机台 -->
                    <spring:message code="sortltem.column.entbarcode_s"/>:
                    <input name="filter[entbarcode_s]" id="entbarcode_s" type="text" class="easyui-combobox"
                           style="width:130px" data-options="label:'',
                                        required:false, 
                                        panelHeight:200,
                                        icons:[{iconCls:'icon-clear',handler:function(e){$(e.data.target).combobox('clear')}}],
			                             method: 'get',
			                             url:'finalcheck/baseData/entmodel/SearchEnt?equip_type=254004',
			                             valueField:'EQUIP_NAME',
			                             textField:'DESCRIPTION'">
                    <!-- 轮胎条码 -->
                    <spring:message code="sortdynabalancelog.column.barcode_s"/>:
                    <input name="filter[barcode_s]" id="barcode_s" type="text" style="width:130px"
                           class="easyui-textbox" data-options="label:''">
                    <!-- 物料编码 -->
                    <spring:message code="sortdynabalancelog.column.itemid_s"/>:
                    <input name="filter[itemid_s]" id="itemid_s" like="true" type="text" style="width:150px"
                           class="easyui-textbox" data-options="label:''">
                    <br/>
                    <!-- MES校验 -->
                    <spring:message code="sortappearancelog.column.isok_i"/>:
                    <input name="filter[isok_s]" id="isok_s" type="text" class="easyui-combobox" style="width:150px"
                           data-options="label:'',
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
										}]">
                    <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'"
                       onclick="filter()"><spring:message code="button.search"/></a>
                    <auth:button code="ZJ_ZJGL_DPHSMLL_DC"><a class="easyui-linkbutton btn-deep-blue"
                                                              data-options="iconCls:'icon-excel-export'"
                                                              onclick="$_export()"><spring:message
                            code="button.export"/></a></auth:button>
                </tr>
            </table>
        </form>
    </div>
    <table id="scandynabalancelog_dg" class="easyui-datagrid" style="width:100%"
           data-options="
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                emptyMsg: '<span><spring:message code='tip.noData'/></span>',
                singleSelect: false,
                toolbar: '#ScanDynaBalanceLog_dg_toolbar',
                url: '',
                striped:true,
                method: 'get' 
                ">
        <thead>
        <tr>
            <th data-options="field:'atr_key',checkbox:true">ID</th>
            <!-- 轮胎条码：MES_MainTyre 表 BARCODE -->
            <th data-options="field:'barcode_s'"><spring:message code="scandynabalancelog.column.barcode_s"/></th>
            <!-- 物料编码-->
            <th data-options="field:'itemid_s'"><spring:message code="sortdynabalancelog.column.itemid_s"/></th>
            <!-- 硫化规格描述 -->
            <th data-options="field:'materialdesc_s'"><spring:message code="materialsplus.column.materialdesc_s"/></th>
            <!-- 质检设备表ID -->
            <th data-options="field:'entname_s'"><spring:message code="scandynabalancelog.column.entbarcode_s"/></th>
            <!-- 配方号：D_BS_Recipe 表 ID -->
            <th data-options="field:'recipeno_i'"><spring:message code="scandynabalancelog.column.recipeno_i"/></th>
            <%--  <!-- 外胎重量 -->
            <th data-options="field:'weight_s'"><spring:message code="scandynabalancelog.column.weight_s" /></th> --%>
            <!-- MES校验是否成功：0-失败，1-成功 -->
            <th data-options="field:'isok_s', formatter:mesxy,editor:{type:'textbox',options:{required:true}}">
                <spring:message code="sortappearancelog.column.isok_i"/></th>
            <!-- 错误类型： 1:轮胎条码不存在 2:机台信息不存在 3:规格索引不存在 4:轮胎状态不允许分配 5:轮胎规格规则未维护 6:拨胎器异常 7:机台停止 8:扫描头未读取到条码 9:其它 -->
            <th data-options="field:'etype_s',formatter:etypeFormatter,editor:{type:'combotree',options:{ method:'get',data:DICT_259}}"><spring:message code="sortappearancelog.column.etype_i"/></th>
            <!-- 备注 -->
            <th data-options="field:'remark_s'"><spring:message code="sortappearancelog.column.remark_s"/></th>
            <!-- 工控下发是否成功：0-失败、1-成功 -->
            <th data-options="field:'writein_s', formatter:mesxy,editor:{type:'textbox',options:{required:true}}">
                <spring:message code="sortappearancelog.column.writein_s"/></th>
            <!-- 工控下发备注 -->
            <th data-options="field:'writeinremark_s'"><spring:message
                    code="sortappearancelog.column.writeinremark_s"/></th>
            <!-- 轮胎翻转信息 -->
            <th formatter="dictFormatter" data-options="field:'spare2_s'"><spring:message
                    code="sortappearancelog.column.DynaBalanceReversal"/></th>
            <!--硫化商标  -->
            <th data-options="field:'brand_s'"><spring:message code="scanxraylog.column.brand_s"/></th>
            <!-- 创建时间 -->
            <th data-options="field:'created_time_t'"><spring:message
                    code="scandynabalancelog.column.created_time_t"/></th>

        </tr>
        </thead>
    </table>
</div>
<jsp:include page="../../../../inc/export.jsp">
    <jsp:param name="idField" value="atr_key"/>
    <jsp:param name="formId" value="ScanDynaBalanceLog_search_form"/>
    <jsp:param name="datagridId" value="scandynabalancelog_dg"/>
    <jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.finalcheck.excel.ScanDynaBalanceLogExportHandler"/>
    <jsp:param name="serviceName" value="ScanDynaBalanceLogServiceImpl"/>
</jsp:include>
</body>
</html>
