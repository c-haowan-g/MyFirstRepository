<!-- 

    作者      :徐秉正
    时间      :2020-03-13 10:58:42 
    页面名称:半部件调拨记录查询
    文件关联:
        Plateinoutrecord.java
        PlateinoutrecordController.java
        PlateinoutrecordServiceImpl.java
        PlateinoutrecordServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/meta.jsp"%>
<%@ include file="plateinoutrecords.js.jsp"%>
<script type="text/javascript" src="dict/113,308.js"></script> 
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="PlateinoutRecords_dg_toolbar">
            <form id="PlateinoutRecords_search_form" class="form" >
             
               <div>
                 <!-- 物料组 -->
                <spring:message code="plateinoutrecord.column.materialgroup_s" />
                <input name="filter[materialgroup_s]" id="materialgroup_s" type="text" like="true"  class="easyui-combobox" 
               data-options="valueField:'DICTCODE_S',
				            			textField:'DICTNAME_S',
                                        required:false, 
                                        editable:true,
                                        url:'halfpart/plateinoutrecord/plateinoutrecords/searchMaterielgroup',
                                        
										method: 'get',
										prompt:'全部',
									    limitToList:'false',
									    panelHeight:150,
									    labelWidth:'auto',
										" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									   <!--  onSelect:onSelectMaterialCode -->
               <!-- 物料编码 -->
                 &emsp;<spring:message code="plateinoutrecords.column.materielcode_s" />
                :&emsp;<input name="filter[materielcode_s]" id="materielcode_s" type="text"   class="easyui-combobox"   
			                 data-options="label:'',
                                            labelWidth:'auto',
                                            panelHeight:200,
                                            editable:true,
                                            required:false,
                                            limitToList:'false',
                                            url:'halfpart/plateinoutrecord/plateinoutrecords/searchMaterielcode',
                                            valueField:'MATERIALCODE_S',
                              			    textField:'MATERIALCODE_S',
                                            method:'get'"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <!-- 物料名称 -->
                <spring:message code="plateinoutrecords.column.materielname_s" />
                :&emsp;<input name="filter[materielname_s]" id="materielname_s" type="text"  class="easyui-combobox"   
			                 data-options="label:'',
                                            labelWidth:'auto',
                                            panelHeight:200,
                                            editable:true,
                                            required:false,
                                            limitToList:'false',
                                            url:'halfpart/plateinoutrecord/plateinoutrecords/searchMaterielname',
                                            valueField:'MATERIALDESC_S',
                              			    textField:'MATERIALDESC_S',
                                            method:'get'">
								    	
               </div>
            
                <!-- 调入位置 -->
                <spring:message code="plateinoutrecord.column.in_location_s" />
                <input name="filter[in_location_s]" id="in_location_s" type="text" like="true" class="easyui-textbox" data-options="label:''" >&nbsp;&nbsp;&nbsp;
                <!-- 调出位置 -->
                <spring:message code="plateinoutrecord.column.out_location_s" />
                <input name="filter[out_location_s]" id="out_location_s" type="text" like="true" class="easyui-textbox" data-options="label:''" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <!--批次条码-->
               <spring:message code="plateinoutrecord.column.batch_no_s" />
                <input name="filter[batch_no_s]" id="batch_no_s" type="text" like="true"  class="easyui-textbox" data-options="label:''" >
                 <div>
               <!-- 载具条码 -->
               <spring:message code="plateinoutrecord.column.rfid_no_s" />
                <input name="filter[rfid_no_s]" id="rfid_no_s" type="text" like="true" class="easyui-textbox" data-options="label:''" >
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <!-- 操作时间 -->
                <spring:message code="plateinoutrecord.column.worktime_t" />
               <input name="filter[start_time]" id="start_time" editable="true" type="text" class="easyui-datetimebox" data-options="label:''" >&nbsp;&nbsp;&nbsp;
                                        到：<input name="filter[end_time]" id="end_time" editable="true" type="text" class="easyui-datetimebox" data-options="label:''" >&nbsp;&nbsp;&nbsp;
               </div>
            </form> 
                 <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            <auth:button code="plateinoutrecord.export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
           	 <auth:button code="plateinoutrecord.showOrHide"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="showOrHide()"><spring:message code="button.searchColumn" /></a></auth:button> 
            </div>
        <table id="plateinoutrecords_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#PlateinoutRecords_dg_toolbar',
                
                striped:true,
                method: 'get',
                emptyMsg: '<span><spring:message code='tip.noData'/></span>' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 物料编码  -->
                    <th data-options="field:'materielcode_s',width:80,editor:{type:'textbox'}"><spring:message code="plateinoutrecord.column.materielcode_s" /></th>
                    <!-- 物料名称  -->
                    <th data-options="field:'materielname_s',width:110,editor:{type:'textbox'}"><spring:message code="plateinoutrecord.column.materielname_s" /></th>
                    <!-- 物料组 -->
                    <th data-options="field:'sapm_group_s',formatter:codeFormatter,editor:{type:'textbox'},options:{
			                 method:'get',
			                 url:'dict/code/308',
			                 required:true},width:80,editor:{type:'textbox'}"><spring:message code="plateinoutrecord.column.materialgroup_s" /></th>
                    <!-- 批次条码-->
                    <th data-options="field:'batch_no_s',width:80,editor:{type:'textbox'}"><spring:message code="plateinoutrecord.column.batch_no_s" /></th>
                    <!-- 载具条码 -->
                     <th data-options="field:'rfid_no_s',width:80,editor:{type:'textbox'}"><spring:message code="plateinoutrecord.column.rfid_no_s" /></th>
                    <!-- 调拨数量 -->
                    <th data-options="field:'weight_i',width:30,editor:{type:'textbox'}"><spring:message code="plateinoutrecord.column.weight_i" /></th>
                    <!-- 调入位置 -->
                    <th data-options="field:'in_location_s',width:80,editor:{type:'textbox'}"><spring:message code="plateinoutrecord.column.in_location_s" /></th>
                    <!-- 调出位置 -->
                    <th data-options="field:'out_location_s',width:80,editor:{type:'textbox'}"><spring:message code="plateinoutrecord.column.out_location_s" /></th>
                    <!-- 操作类型 0 换上 1 换下 -->
                    <th data-options="field:'operate_type_s',formatter:function(value,row,index){
				                  				if(value=='1'){return '换下'}
				                  				else if(value=='0'){return '换上'}},
				             width:50,editor:{type:'textbox'}"><spring:message code="plateinoutrecord.column.operate_type_s" /></th>
                     <!-- 操作人 -->
                    <th data-options="field:'workid_s',width:60,editor:{type:'textbox'}"><spring:message code="plateinoutrecord.column.workid_s" /></th>
                    <!-- 操作时间 -->
                    <th data-options="field:'worktime_t',width:120,editor:{type:'textbox'}"><spring:message code="plateinoutrecord.column.worktime_t" /></th>
                    
                        
              </tr>
            </thead>
        </table>
      <!-- 	导出-->    
	 <jsp:include page="../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="PlateinoutRecords_search_form" />
		<jsp:param name="datagridId" value="plateinoutrecords_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.halfpart.excel.PlateinoutrecordExportHandler" />
		<jsp:param name="serviceName" value="PlateinoutRecordsServiceImpl" />
	</jsp:include>
    </div>
</body>
</html>
