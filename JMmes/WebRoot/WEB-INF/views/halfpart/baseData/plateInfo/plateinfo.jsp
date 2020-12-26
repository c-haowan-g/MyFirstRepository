<!-- 

    作者      :栾和源
    时间      :2020-01-22 08:00:37 
    页面名称:半部件口型板信息
    文件关联:
        PlateInfo.java
        PlateInfoController.java
        PlateInfoServiceImpl.java
        PlateInfoServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="plateinfo.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="PlateInfo_dg_toolbar">
            <form id="PlateInfo_search_form" class="form" >
                
                
                <!-- 口型板编码 -->
                <spring:message code="plateinfo.column.mouthplatecode" />：
                <input name="filter[vehicles_barcode_s]" id="vehicles_barcode_s"  style="width:120px" type="text" class="easyui-combobox" 
                data-options="textField:'VEHICLES_BARCODE_S',
										valueField:'VEHICLES_BARCODE_S',
                                        required:false, 
                                        url:'halfpart/plateinfo/searchDescription',
										method: 'get',
									    editable:'true',
									    limitToList:false,
									    panelHeight:150,
										filter: function(q, row){  
								        var opts = $(this).combobox('options');  
								        return row[opts.textField].indexOf(q) >= 0;//这里改成>=即可在任意地方匹配  
								    	}" >
                &nbsp;&nbsp;&nbsp;
                <!-- RFID码 -->
                <spring:message code="plateinfo.column.vehicles_rfidcode_s" />：
                <input name="filter[vehicles_rfidcode_s]" id="vehicles_rfidcode_s" style="width:120px" type="text" class="easyui-combobox" 
                data-options="textField:'VEHICLES_BARCODE_S',
										valueField:'VEHICLES_BARCODE_S',
                                        required:false, 
                                        url:'halfpart/plateinfo/searchDescription',
										method: 'get',
									    editable:'true',
									    limitToList:false,
									    panelHeight:150,
										filter: function(q, row){  
								        var opts = $(this).combobox('options');  
								        return row[opts.textField].indexOf(q) >= 0;//这里改成>=即可在任意地方匹配  
								    	}" >
                &nbsp;&nbsp;&nbsp;
                
                <!-- 口型板状态 -->
                <spring:message code="plateinfo.column.mouthplatestatus" />：
                <input name="filter[flag_s]" id="flag_s" style="width:120px" type="text" class="easyui-combobox" 
                data-options="label:'',
                			 data:[{value:'0',text:'未使用'},
		                    	   {value:'1',text:'已使用'}],
                			 method: 'get'">
				&nbsp;&nbsp;&nbsp;
                
                <!-- 口型板规格 -->
                <spring:message code="plateinfo.column.mouthplatespecification_s" />：
                <input name="filter[mouthplatespecification_s]" id="mouthplatespecification_s" style="width:120px" type="text" class="easyui-combobox" 
                data-options="textField:'MOUTHPLATESPECIFICATION_S',
										valueField:'MOUTHPLATESPECIFICATION_S',
                                        required:false, 
                                        url:'halfpart/plateinfo/searchDescription',
										method: 'get',
									    editable:'true',
									    limitToList:false,
									    panelHeight:150,
										filter: function(q, row){  
								        var opts = $(this).combobox('options');  
								        return row[opts.textField].indexOf(q) >= 0;//这里改成>=即可在任意地方匹配  
								    	}" >
                &nbsp;&nbsp;&nbsp;
                
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="plateinfo.add"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="plateinfo.edit"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="plateinfo.remove"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            <auth:button code="plateinfo.save"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="plateinfo.cancel"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            <auth:button code="plateinfo.export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
        	<auth:button code="equipmentcapacity_hide"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="showOrHide()"><spring:message code="button.searchColumn" /></a></auth:button>
        </div>
        <table id="plateinfo_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#PlateInfo_dg_toolbar',
                url: 'halfpart/plateinfo/datagrid',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    
                     <!-- 口型板编码 -->
                    <th data-options="field:'vehicles_barcode_s',width:80,editor:{type:'textbox'}"><spring:message code="plateinfo.column.mouthplatecode" /></th>
                     <!-- RFID码 -->
                    <th data-options="field:'vehicles_rfidcode_s',width:80,editor:{type:'textbox',options:{
                                      disabled:true}}"><spring:message code="plateinfo.column.vehicles_rfidcode_s" /></th>
                     <!-- 口型板状态 -->
                    <th data-options="field:'flag_s',width:120,formatter:flagFormat,editor:{type:'combobox',
						             	 options:{
						             	 disabled:true,
						              	required:true,
		                             	 panelHeight:100,
		                    		  	data:[{value:'0',text:'未使用'},
		                    		  		  {value:'1',text:'已使用'}]
		                    		  		  }}"><spring:message code="plateinfo.column.mouthplatestatus" /></th>
                     <!-- 口型板规格 -->
                    <th data-options="field:'mouthplatespecification_s',width:80,editor:{type:'textbox'}"><spring:message code="plateinfo.column.mouthplatespecification_s" /></th>
                     <!-- 工装类型 -->
                    <th data-options="field:'vehicles_type_s',width:80,editor:{type:'textbox'}"><spring:message code="plateinfo.column.vehiclestype" /></th>
                     <!-- 内径 -->
                    <th data-options="field:'internaldiameter_s',width:80,editor:{type:'textbox'}"><spring:message code="plateinfo.column.internaldiameter_s" /></th>
                     <!-- 厚度 -->
                    <th data-options="field:'thickness_s',width:80,editor:{type:'textbox'}"><spring:message code="plateinfo.column.thickness_s" /></th>
                     <!-- 当前位置 -->
                    <th data-options="field:'currentlocation_s',width:80,editor:{}"><spring:message code="plateinfo.column.currentlocation_s" /></th>
                     <!-- 开始使用时间（最新换上时间) -->
                    <th data-options="field:'begintime_t',width:80,editor:{}"><spring:message code="plateinfo.column.begintime_t" /></th>
                     <!-- 结束使用时间（最新换下时间） -->
                    <th data-options="field:'endtime_t',width:80,editor:{}"><spring:message code="plateinfo.column.endtime_t" /></th>
                     <!-- 修改人 -->
                    <th data-options="field:'changed_by_s',width:80"><spring:message code="plateinfo.column.changed_by_s" /></th>
                     <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',width:80"><spring:message code="plateinfo.column.changed_time_t" /></th>
                     <!-- 累计使用次数 -->
                    <th data-options="field:'usecount_i',width:80,editor:{}"><spring:message code="plateinfo.column.usecount_i" /></th>
                    
                </tr>
            </thead>
        </table>
    </div>
    
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="PlateInfo_search_form" />
		<jsp:param name="datagridId" value="plateinfo_dg" />
		
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.halfpart.excel.PlateInfoExportHandler" />
		 
		
		<jsp:param name="serviceName" value="PlateInfoServiceImpl" />
	</jsp:include>  
    
</body>
</html>
