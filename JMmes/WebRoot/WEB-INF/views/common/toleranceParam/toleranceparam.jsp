<!-- 

    作者      :周清玉
    时间      :2019-09-10 13:40:17 
    页面名称:PLM公差参数表
    文件关联:
        Toleranceparam.java
        ToleranceparamController.java
        ToleranceparamServiceImpl.java
        ToleranceparamServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/meta.jsp"%>
<%@ include file="toleranceparam.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'west',split:true" style="width:50%;" title="<spring:message code="toleranceparam.column.toleranceparam" />">
        <div id="ToleranceParam_dg_toolbar">
            <form id="ToleranceParam_search_form" class="form" >
				<!-- 工序名称 -->
				<spring:message code="toleranceparam.column.processname_s" />:
       			<input name="filter[processname_s]" id="processname_s" type="text" like="true" style="width:18s0px" class="easyui-textbox" data-options="label:''" >
				<!-- 类别 -->
				<spring:message code="toleranceparam.column.classification_s" />:
  		 		<input name="filter[classification_s]" id="classification_s" type="text" style="width:120px" beginWith="true" class="easyui-textbox" data-options="label:''" >
				<!-- 部门 --><br/>
				<spring:message code="toleranceparam.column.section_s" />:
      			<input name="filter[section_s]" id="section_s" type="text" like="true" style="width:120px" class="easyui-textbox" data-options="label:''" >
			 	<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form>
        </div>
        <table id="toleranceparam_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: true,
                onSelect:selectrow,
             	striped:true,
                toolbar: '#ToleranceParam_dg_toolbar',
                url: 'common/toleranceparam/datagrid',
                method: 'get' 
                ">
            <thead>
                <tr>
                    <!-- 工序名称 -->
                    <th data-options="field:'processname_s',editor:{type:'textbox'}"><spring:message code="toleranceparam.column.processname_s" /></th>
                    <!-- 类别 -->
                    <th data-options="field:'classification_s',editor:{type:'textbox'}"><spring:message code="toleranceparam.column.classification_s" /></th>
                    <!-- 部门 -->
                    <th data-options="field:'section_s',editor:{type:'textbox'}"><spring:message code="toleranceparam.column.section_s" /></th>
                    <!-- 工厂 柳州 8003 -->
                    <th data-options="field:'werks_s',editor:{type:'textbox'}"><spring:message code="curingprocess.column.werks_s" /></th>
                    <!-- 分厂 半钢 G1 全钢 G3 胎胚一次法 G1 胎胚二次法 G3 -->
                    <th data-options="field:'factory_s',editor:{type:'textbox'}"><spring:message code="buildingprocess.column.factory_s" /></th>
                    <!-- 接收时间 -->
                    <th data-options="field:'receive_time_t',editor:{type:'textbox'}"><spring:message code="toleranceparam.column.receive_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
    
    
    
    <div data-options="region:'center',split:true" title="<spring:message code="tolerancepara.column.toleranceparam" />" style="width:100px;">
        <table id="tolerancepara_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:false,
                singleSelect: false,
                striped:true,
                remoteSort:false,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <!-- 参数名称 code-->
                    <th data-options="field:'PARMNAME_S',sortable:true,editor:{type:'textbox'}"><spring:message code="tolerancepara.column.parmnamecode_s" /></th>
                    <!-- 参数名称  -->
                    <th data-options="field:'DUMMY1_S',sortable:true,editor:{type:'textbox'}"><spring:message code="toleranceparam.column.parmname_s" /></th>
                    <!-- 标准值Code -->
                    <th data-options="field:'PARMCODE_S',sortable:true,editor:{type:'textbox'}"><spring:message code="tolerancepara.column.parmcode_s" /></th>
                    <!-- 参数最大值（公差） -->
                    <th data-options="field:'VALUEMAX_S',sortable:true,editor:{type:'textbox'}"><spring:message code="deviceparameter.column.valuemax_s" /></th>
                    <!-- 参数最大值操作符 -->
                    <th data-options="field:'VALUEMAXSIGN_S',sortable:true,editor:{type:'textbox'}"><spring:message code="deviceparameter.column.valuemaxsign_s" /></th>
                    <!-- 参数最小值（公差） -->
                    <th data-options="field:'VALUEMIN_S',sortable:true,editor:{type:'textbox'}"><spring:message code="deviceparameter.column.valuemin_s" /></th>
                    <!-- 参数最小值操作符 -->
                    <th data-options="field:'VALUEMINSIGN_S',sortable:true,editor:{type:'textbox'}"><spring:message code="deviceparameter.column.valueminsign_s" /></th>
                    <!-- 接收时间 -->
                    <th data-options="field:'RECEIVE_TIME_T',sortable:true,editor:{type:'textbox'}"><spring:message code="tolerancepara.column.receive_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
</body>
</html>
