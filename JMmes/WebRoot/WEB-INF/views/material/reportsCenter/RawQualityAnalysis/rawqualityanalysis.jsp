<!-- 

    作者      :李昂
    时间      :2020-08-13 15:47:00 
    页面名称:原材料质量分析报表
    文件关联:
        RawQualityAnalysis.java
        RawQualityAnalysisController.java
        RawQualityAnalysisServiceImpl.java
        RawQualityAnalysisServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="rawqualityanalysis.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="TestTaskPush_dg_toolbar">
            <form id="TestTaskPush_search_form" class="form" >
                <!--送检日期 detail-->
                送检日期
<%--                <input name="filter[receive_time_t]" id="receive_time_t" type="text" class="easyui-datebox" data-options="label:''" >--%>
                <input name="filter[start_time]" editable="true" id="start_time"
                       type="text" class="easyui-datetimebox" style="width:165px"
                       data-options="label:''">
                到 <input name="filter[end_time]" editable="true" id="end_time"
                         class="easyui-datetimebox" style="width:165px">

                <!--供应商-->
                供应商
                <input name="filter[suppliername_s]" id="suppliername_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!--物料编码-->
                物料编码
                <input name="filter[sapcode_s]" id="sapcode_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!--物料名称-->
                </br>
                物料名称
                <input name="filter[samplename_s]" id="samplename_s" type="text" class="easyui-textbox" data-options="label:''" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
                <auth:button code="RAW_Reports Center_LLRP01_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            </form> 

        </div>
        <table id="testtaskpush_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#TestTaskPush_dg_toolbar',
                url: 'material/reportsCenter/RawQualityAnalysis/datagrid',
                 emptyMsg: '<span><spring:message code='tip.noData'/></span>',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 条码：长度15位  条码前九位（物料名）、后六位（厂家） -->
                    <th data-options="field:'producername_custom_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.producername_custom_s" /></th>
                    <!-- 供应商 -->
                    <th data-options="field:'suppliername_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.suppliername_s" /></th>
                    <!--物料编码-->
                    <th data-options="field:'sapcode_s',editor:{type:'textbox'}">物料编码</th>
                    <!--物料名称-->
                    <th data-options="field:'samplename_s',editor:{type:'textbox'}">物料名称</th>
                    <!-- 最终检测结果 -->
                    <th data-options="field:'finalresult_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.finalresult_s" /></th>
                    <!--分项结论 detail-->
                    <th data-options="field:'sub_conclusion_d',editor:{type:'textbox'}">分项结论</th>
                    <!--检测项目 detail-->
                    <th data-options="field:'test_items_d',editor:{type:'textbox'}">检测项目</th>
                    <!--检测参数 detail-->
                    <th data-options="field:'TEST_PARAS_D',editor:{type:'textbox'}">检测参数</th>
                    <!--检测方法 detail-->
                    <th data-options="field:'test_method_d',editor:{type:'textbox'}">检测方法</th>
                    <!--测试结果（detail）-->
                    <th data-options="field:'test_result_d',editor:{type:'textbox'}">测试结果</th>
                    <!--执行标准 detail-->
                    <th data-options="field:'executive_standard_d',editor:{type:'textbox'}">执行标准</th>
                    <!--条件名称 detail-->
                    <th data-options="field:'executive_name_d',editor:{type:'textbox'}">条件名称</th>
                    <!--条件单位 detail-->
                    <th data-options="field:'executive_unit_d',editor:{type:'textbox'}">条件单位</th>
                    <!--条件要求值 detail-->
                    <th data-options="field:'executive_reqvalue_d',editor:{type:'textbox'}">条件要求值</th>
                    <!--条件实际值 detail-->
                    <th data-options="field:'executive_actualvalue_d',editor:{type:'textbox'}">条件实际值</th>
                    <!--判定范围 detail-->
                    <th data-options="field:'decisionscope_d',editor:{type:'textbox'}">判定范围</th>
                    <!--送检日期 detail-->
                    <th data-options="field:'receive_time_d',editor:{type:'textbox'}">送检日期</th>
                    <!--检测日期-->
                    <th data-options="field:'result_receive_time_t',editor:{type:'textbox'}">检测日期</th>
                </tr>
            </thead>
        </table>
    </div>
    <jsp:include page="../../../../inc/export.jsp">
        <jsp:param name="idField" value="atr_key" />
        <jsp:param name="formId" value="TestTaskPush_search_form" />
        <jsp:param name="datagridId" value="testtaskpush_dg"/>
        <jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.material.excel.RawQualityAnalysisExportHandler" />
        <jsp:param name="serviceName" value="RawQualityAnalysisServiceImpl" />
    </jsp:include>
</body>
</html>
