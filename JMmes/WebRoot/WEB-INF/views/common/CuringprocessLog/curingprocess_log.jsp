<!-- 

    作者      :时永良
    时间      :2018-10-16 13:20:40 
    页面名称:PLM硫化工艺表日志
    文件关联:
        Curingprocess_log.java
        Curingprocess_logController.java
        Curingprocess_logServiceImpl.java
        Curingprocess_logServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/meta.jsp"%>
<%@ include file="curingprocess_log.js.jsp"%>
<script type="text/javascript" src="dict/-307.js"></script>
<style type="text/css">
.columnTitle {
	padding: 6px 10px
}
</style>
<body class="easyui-layout" fit="true"> 
	<div data-options="region:'west',split:true" title="<spring:message code="curingprocess.column.plmlhgycs" />" style="width:60%;">
        <div id="CuringProcess_dg_toolbar" >
            <form id="CuringProcess_search_form" class="form" >
            <table class="formTable">
					<tr>
							<!-- SAP品号  -->
             				<spring:message code="curingprocess.column.sapmat_s" />:
               			    <input name="filter[sapmat_s]"   like="true"  id="sapmat_s" type="text" class="easyui-textbox" data-options="label:''" >
							<!-- 外胎品号  -->
             				<spring:message code="curingprocess.column.mappdmmat_s" />:
               			    <input name="filter[mtsap]"   like="true"  id="mtsap" type="text" class="easyui-textbox" data-options="label:''" >
							<!--是否有效  --><br/>
             				<spring:message code="curingprocess.column.record_flag_s" /> :
               			      <input name="filter[record_flag_s]" id="record_flag_s" type="text" class="easyui-combobox" style="width:113px" data-options="label:'',
                                        required:false, 
                                       	 data: [{
											text: '是',
											value: 'A'
										},{
											text: '否',
											value: 'D'
										}],
			                             method: 'get'"> 
			                             <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
					</tr>
           	   </table>
            </form> 
            <form  class="form" id="CuringProcess_search_form2"  method="post">
				<input style="display:none"  name="filter[id_s]" id="id_s" >
			</form>
        </div>
        <table id="curingprocess_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                labelWidth:'auto',
                panelWidth:'auto',
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: true,                
                toolbar: '#CuringProcess_dg_toolbar',
                url: 'common/CuringprocessLog/curingprocesslog/datagrid',
                striped:true,
                onSelect:selectrow,
                method: 'get',
                 emptyMsg: '<span><spring:message code='tip.noData'/></span>' 
                ">
            <thead>
                <tr>
                    <!-- 胎胚规格代码  -->
                    <th data-options="field:'pdmmat_s' "><spring:message code="curingprocess.column.pdmmat_s" /></th>
                     <!-- 外胎物料编码  -->
                    <th data-options="field:'mtsap' "><spring:message code="curingprocess.column.mappdmmat_s" /></th>
                	 <!-- 胎胚版本号 -->
                    <th data-options="field:'subitemrevision_s' "><spring:message code="curingprocess.column.version_s" /></th>
                	<!-- SAP品号  -->
                    <th data-options="field:'sapmat_s' "><spring:message code="curingprocess.column.sapmat_s" /></th>
                	<!-- 产品阶段 试制 01 试产 02 投产03 -->
                    <th data-options="field:'stage_s',formatter:codeFormatter,editor:{type:'textbox',options:{panelWidth:200,required:true,method:'get',
                                url:'dict/code/-307'}} "><spring:message code="curingprocess.column.stage_s" /></th>
                	 <!-- 工艺路线名称 -->
                    <th data-options="field:'processroute_s' "><spring:message code="curingprocess.column.processroute_s" /></th>
                	<!-- 工艺版本号 -->
                    <th data-options="field:'processversion_s' "><spring:message code="curingprocess.column.processversion_s" /></th>
                	<!-- 工厂 -->
                    <th data-options="field:'factory_s' "><spring:message code="curingprocess.column.factory_s" /></th>
                	<!-- 分厂 柳州 8003 -->
                    <th data-options="field:'werks_s' "><spring:message code="curingprocess.column.werks_s" /></th>
                	<!-- 生效时间 -->
                    <th data-options="field:'receive_time_t' "><spring:message code="curingprocess.column.receive_time_t" /></th>
                	<!-- 失效时间 -->
                    <th data-options="field:'expireddate' "><spring:message code="curingprocess.column.expireddate_s" /></th>
                	 <!-- 记录标志，A可用，D删除 -->
                    <th data-options="field:'record_flag_s',formatter:flag"><spring:message code="curingprocess.column.record_flag_s" /></th>
                </tr>
            </thead>
        </table>
        </div>
        
        <div data-options="region:'center',split:true" title="<spring:message code="curingprocess.column.gycslb" />" style="width:100px;">
 	
 		 <table id="curingprocess_dg2" class="easyui-datagrid" style="width:50%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:false,
                rownumbers: true,
                singleSelect: true,
                striped:true,
                remoteSort:false,
                method: 'get' ,
                  emptyMsg: '<span><spring:message code='tip.noData'/></span>'
                ">
            <thead>
                <tr>
                    <!-- 参数类型  -->
                    <th data-options="field:'PARMTYPECODE_SALL',sortable:true"><spring:message code="curingprocess.column.parmtypecode_s" /></th>
                	<!-- 参数名称 -->
                    <th data-options="field:'PARMNAME_S',sortable:true "><spring:message code="curingprocess.column.parmname_s" /></th>
                	<!-- 参数值 -->
                    <th data-options="field:'VALUE_S',sortable:true "><spring:message code="curingprocess.column.value_s" /></th>
                	<!-- 版本号 -->
                    <th data-options="field:'VERSION_S',sortable:true "><spring:message code="curingprocess.column.version_s" /></th>
                	<!-- 接收日期 -->
                    <th data-options="field:'RECTIME',sortable:true "><spring:message code="curingprocess.column.receive_time_t" /></th>
                    <!-- 参数接收日期 -->
                    <th data-options="field:'RECEIVE_TIME_T',sortable:true "><spring:message code="curingprocess.column.csreceive_time_t" /></th>
                    <!-- 参数索引  -->
                    <th data-options="field:'OBJECTID_S',sortable:true "><spring:message code="curingprocess.column.objectid_s" /></th>
                	<!-- 参数类别代码  -->
                    <th data-options="field:'PARMTYPECODE_S',sortable:true "><spring:message code="curingprocess.column.parmtypecode_s" /></th>
                	<!-- 参数类别名称 -->
                    <th data-options="field:'PARMTYPENAME_S',sortable:true "><spring:message code="curingprocess.column.parmtypename_s" /></th>
                    <!-- 参数代码 -->
                    <th data-options="field:'PARMCODE_S',sortable:true "><spring:message code="curingprocess.column.parmcode_s" /></th>
                </tr>
            </thead>
        </table>
        </div>
</body>
</html>
