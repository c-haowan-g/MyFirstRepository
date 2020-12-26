<!-- 

    作者      :司乔靖
    时间      :2019-02-18 16:06:00 
    页面名称:胎胚病象查询
    文件关联:
        Qualitycheck.java
        QualitycheckController.java
        QualitycheckServiceImpl.java
        QualitycheckServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<script type="text/javascript" src="dict/194.js"></script>
<%@ include file="qualitycheck.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="Qualitycheck_dg_toolbar">
            <form id="Qualitycheck_search_form" class="form" >
                <!-- 轮胎条码 -->
                <spring:message code="qualitycheck.column.tyre_barcode_s" />:&emsp;
                <input name="filter[tyre_barcode_s]" id="tyre_barcode_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 物料编码 -->
                <spring:message code="qualitycheck.column.material_code_s" />:&emsp;
                <input name="filter[material_code_s]" id="material_code_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 生产机台 -->
                <spring:message code="qualitycheck.column.machine_code_s" />:&emsp;
                <input name="filter[machine_code_s]" id="machine_code_s" type="text" class="easyui-textbox" data-options="label:''" >
                <br>
                <!-- 创建时间 -->
                <spring:message code="qualitycheck.column.created_time_t" />:&emsp;
                 <input name="filter[begin_created_time]" editable="true" id="begin_created_time"
							type="text" class="easyui-datetimebox" style="width:170px"
							data-options="label:''">
						到 <input name="filter[end_created_time]" editable="true" id="end_created_time"
							class="easyui-datetimebox" style="width:170px">
               <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
       </div>
        <table id="qualitycheck_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#Qualitycheck_dg_toolbar',
                striped:true,
                method: 'get',
                emptyMsg:'<span><spring:message code='tip.noData'/></span>'
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 轮胎条码 -->
                    <th data-options="field:'tyre_barcode_s',width:80,editor:{type:'textbox'}"><spring:message code="qualitycheck.column.tyre_barcode_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',width:80,editor:{type:'textbox'}"><spring:message code="qualitycheck.column.material_code_s" /></th>
                    <!-- 物料规格 -->
                    <th data-options="field:'material_spec_s',width:80,editor:{type:'textbox'}"><spring:message code="qualitycheck.column.material_spec_s" /></th>
                    <!-- 物料描述 -->
                    <th data-options="field:'material_desc_s',width:80,editor:{type:'textbox'}"><spring:message code="qualitycheck.column.material_desc_s" /></th>
                   
                 
                    <!-- 缺陷代码1 -->
                    <th data-options="field:'cause_code1_s',formatter:codeFormatter,width:80,editor:{type:'combotree',options:{
                    			method:'get',
                                url:'dict/code/194',
                                panelWidth:'300',
                    			required:true,
                    			}}"><spring:message code="qualitycheck.column.cause_code1_s" /></th>
                    <!-- 缺陷代码2 -->
                    <th data-options="field:'cause_code2_s',formatter:codeFormatter,width:80,editor:{type:'combotree',options:{
                    			method:'get',
                                url:'dict/code/194',
                                panelWidth:'300',
                    			required:true,
                    			}}"><spring:message code="qualitycheck.column.cause_code2_s" /></th>
                    <!-- 缺陷代码3 -->
                    <th data-options="field:'cause_code3_s',formatter:codeFormatter,width:80,editor:{type:'combotree',options:{
                    			method:'get',
                                url:'dict/code/194',
                                panelWidth:'300',
                    			required:true,
                    			}}"><spring:message code="qualitycheck.column.cause_code3_s" /></th>
                    <!-- 是否复检：0未复检、1已复检过 -->
                    <th data-options="field:'is_rck_s',width:80,formatter:isrcks,editor:{type:'textbox'}"><spring:message code="qualitycheck.column.is_rck_s" /></th>
                    <!-- 生产机台 -->
                    <th data-options="field:'machine_code_s',width:80,editor:{type:'textbox'}"><spring:message code="qualitycheck.column.machine_code_s" /></th>
                    <!-- 操作人 -->
                    <th data-options="field:'created_by_name',width:80,editor:{type:'textbox'}"><spring:message code="qualitycheck.column.worker_id_s" /></th>
               
               
                <!-- 
                    机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004
                    <th data-options="field:'agenc_no_s',width:80,editor:{type:'textbox'}"><spring:message code="qualitycheck.column.agenc_no_s" /></th>
                    换规首条确认标记
                    <th data-options="field:'aqhm_flag_s',width:80,editor:{type:'textbox'}"><spring:message code="qualitycheck.column.aqhm_flag_s" /></th>
                    轮胎类型区分：
                    <th data-options="field:'attribute_s',width:80,editor:{type:'textbox'}"><spring:message code="qualitycheck.column.attribute_s" /></th>
                    修改人
                    <th data-options="field:'changed_by_s',width:80,editor:{type:'textbox'}"><spring:message code="qualitycheck.column.changed_by_s" /></th>
                    修改时间
                    <th data-options="field:'changed_time_t',width:80,editor:{type:'textbox'}"><spring:message code="qualitycheck.column.changed_time_t" /></th>
                    检验点
                    <th data-options="field:'check_point_s',width:80,editor:{type:'textbox'}"><spring:message code="qualitycheck.column.check_point_s" /></th>
                    创建人
                    <th data-options="field:'created_by_s',width:80,editor:{type:'textbox'}"><spring:message code="qualitycheck.column.created_by_s" /></th>
                    创建时间
                    <th data-options="field:'created_time_t',width:80,editor:{type:'textbox'}"><spring:message code="qualitycheck.column.created_time_t" /></th>
                    班组
                    <th data-options="field:'group_code_s',width:80,editor:{type:'textbox'}"><spring:message code="qualitycheck.column.group_code_s" /></th>
                    当前工序
                    <th data-options="field:'proess_s',width:80,editor:{type:'textbox'}"><spring:message code="qualitycheck.column.proess_s" /></th>
                    记录标志，A可用，D删除
                    <th data-options="field:'record_flag_s',width:80,editor:{type:'textbox'}"><spring:message code="qualitycheck.column.record_flag_s" /></th>
                    班次
                    <th data-options="field:'shift_code_s',width:80,editor:{type:'textbox'}"><spring:message code="qualitycheck.column.shift_code_s" /></th>
                    备用字段1
                    <th data-options="field:'spare1_s',width:80,editor:{type:'textbox'}"><spring:message code="qualitycheck.column.spare1_s" /></th>
                    备用字段2
                    <th data-options="field:'spare2_s',width:80,editor:{type:'textbox'}"><spring:message code="qualitycheck.column.spare2_s" /></th>
                    备用字段3
                    <th data-options="field:'spare3_s',width:80,editor:{type:'textbox'}"><spring:message code="qualitycheck.column.spare3_s" /></th>
                    备用字段4
                    <th data-options="field:'spare4_s',width:80,editor:{type:'textbox'}"><spring:message code="qualitycheck.column.spare4_s" /></th>
                    备用字段5
                    <th data-options="field:'spare5_s',width:80,editor:{type:'textbox'}"><spring:message code="qualitycheck.column.spare5_s" /></th>
                    工厂（1全钢 2半钢）
                    <th data-options="field:'s_factory_s',width:80,editor:{type:'textbox'}"><spring:message code="qualitycheck.column.s_factory_s" /></th>
                    轮胎判定结果编码
                    <th data-options="field:'tyre_status_code_s',width:80,editor:{type:'textbox'}"><spring:message code="qualitycheck.column.tyre_status_code_s" /></th>
                   -->  
                   </tr>
            </thead>
        </table>
    </div>
</body>
</html>
