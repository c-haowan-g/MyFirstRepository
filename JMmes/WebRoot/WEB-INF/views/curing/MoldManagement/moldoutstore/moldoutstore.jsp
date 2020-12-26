<!-- 

    作者      :whl
    时间      :2018-10-03 15:16:26 
    页面名称:模具出库记录
    文件关联:
        Moldoutstore.java
        MoldoutstoreController.java
        MoldoutstoreServiceImpl.java
        MoldoutstoreServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="moldoutstore.js.jsp"%>
<script type="text/javascript" src="dict/301,302,220.js"></script>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="Moldoutstore_dg_toolbar">
            <form id="Moldoutstore_search_form" class="form" >
               <table class="formTable" >
					<tr>
							<!-- 模具条码 -->
							<spring:message code="moldinstore.column.mold_bar_s" />:
							<input name="filter[mold_bar_s]" id="mold_bar_s"  like="true"  type="text" class="easyui-textbox" data-options="label:''" >
							<!-- 模具规格 -->
							<spring:message code="moldinstore.column.mold_spec_s" />:
							<input name="filter[mold_spec_s]" id="mold_spec_s"  like="true"  type="text" class="easyui-textbox" data-options="label:''" >
							<!-- 储位地址 -->
							<spring:message code="moldinstore.column.storeplace_s" />:
							<input name="filter[storeplace_s]" id="storeplace_s"  like="true"  type="text" class="easyui-textbox" data-options="label:''" >
<br/>							<!-- 出库开始时间 -->
							<spring:message code="moldinstore.column.instore_time_t" />:
							<input name="filter[begin_created_time]"
							id="begin_created_time" class="easyui-datetimebox"editable="true"
							data-options="label:''">
							<!-- 出库结束时间 -->
							<spring:message code="moldinstore.column.instore_time_end" />:
							<input name="filter[end_created_time]"editable="true"
							id="end_created_time" class="easyui-datetimebox"
							data-options="label:''">
						<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>	
					</tr>
				</table>
				</form>
        </div>
        <table id="moldoutstore_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#Moldoutstore_dg_toolbar',
                emptyMsg:'<span><spring:message code='tip.noData'/></span>' ,
                url: '',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                	<!-- 模具的条码/二维码/RFID芯片等，唯一 -->
                    <th data-options="field:'mold_bar_s',width:80,editor:{type:'textbox'}"><spring:message code="moldinstore.column.mold_bar_s" /></th>
                	<!-- 模具规格 -->
                    <th data-options="field:'mold_spec_s',width:80,editor:{type:'textbox'}"><spring:message code="moldoutstore.column.mold_spec_s" /></th>
                	<!-- 模具花纹 -->
                    <th data-options="field:'flower_pattern_s',width:80,editor:{type:'textbox'}"><spring:message code="moldoutstore.column.flower_pattern_s" /></th>
                	<!-- 出库目的 -->
                    <th data-options="field:'purpose_s',width:80,formatter:codeFormatter,
						editor:{type:'combotree',options:
                                {
                                method:'get',
                                 data:DICT_220}}"><spring:message code="moldoutstore.column.purpose_s" /></th>
                	<!-- 模具出库时间 -->
                    <th data-options="field:'outstore_time_s',width:80,editor:{type:'textbox'}"><spring:message code="moldoutstore.column.outstore_time_s" /></th>
                    <!-- 模具出库班次 -->
                    <th data-options="field:'class_id_s',width:80,formatter:codeFormatter,
						editor:{type:'combotree',options:
                                {
                                method:'get',
                                 data:DICT_302}}"><spring:message code="moldoutstore.column.class_id_s" /></th>
                	<!-- 模具出库班组 -->
                    <th data-options="field:'shift_id_s',width:80,formatter:codeFormatter,
                    	editor:{type:'combotree',options:
                                {
                                method:'get',
                                 data:DICT_301}}"><spring:message code="moldoutstore.column.shift_id_s" /></th>
                	<!-- 模具出库人 -->
                    <th data-options="field:'changed_by',width:80,editor:{type:'textbox'}"><spring:message code="moldoutstore.column.outstore_worker_s" /></th>
                    <!-- 库位条码 -->
                    <th data-options="field:'storeplace_s',width:80,editor:{type:'textbox'}"><spring:message code="moldoutstore.column.storeplace_s" /></th>
                    <!-- 库位名称 -->
                    <th data-options="field:'remarks_s',width:80,editor:{type:'textbox'}"><spring:message code="moldoutstore.column.remarks_s" /></th>
                </tr>
            </thead>
        </table>
    </div>
</body>
</html>
