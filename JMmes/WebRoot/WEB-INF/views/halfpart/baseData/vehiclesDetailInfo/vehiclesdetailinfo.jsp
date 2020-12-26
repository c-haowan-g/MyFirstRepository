<!-- 

    作者      :栾和源
    时间      :2020-03-04 11:27:02 
    页面名称:口型板规格对应维护表
    文件关联:
        VehiclesDetailInfo.java
        VehiclesDetailInfoController.java
        VehiclesDetailInfoServiceImpl.java
        VehiclesDetailInfoServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="vehiclesdetailinfo.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="VehiclesDetailInfo_dg_toolbar">
            <form id="VehiclesDetailInfo_search_form" class="form" >
                
                <!-- 口型板条码 -->
                <spring:message code="vehiclesdetailinfo.column.vehicles_barcode_s" />
                <input name="filter[vehicles_barcode_s]" id="vehicles_barcode_s"  type="text" style="width:120px" class="easyui-combobox" 
                	data-options="
							textField:'VEHICLES_BARCODE_S',
							valueField:'VEHICLES_BARCODE_S',
                            required:false, 
                            url:'halfpart/basedata/vehiclesDetailInfo/searchVehiclesDescription',
							method: 'get',
							editable:'true',
							limitToList:false,
							panelHeight:150,
				          	filter: function(q, row){  
								        var opts = $(this).combobox('options');  
								        return row[opts.textField].indexOf(q) >= 0;//这里改成>=即可在任意地方匹配  
								    	}                
                	" >&nbsp;&nbsp;&nbsp;
                	
                	<!-- 口型板规格 -->
               	 <spring:message code="vehiclesdetailinfo.column.vehiclesspecification_s" />
               	 <input name="filter[vehiclesspecification_s]" id="vehiclesspecification_s"  type="text" style="width:120px" class="easyui-combobox" 
                	data-options="
                			textField:'MOUTHPLATESPECIFICATION_S',
							valueField:'MOUTHPLATESPECIFICATION_S',
                            required:false, 
                            url:'halfpart/basedata/vehiclesDetailInfo/searchVehiclesDescription',
							method: 'get',
							editable:'true',
							limitToList:false,
							panelHeight:150,
				          	filter: function(q, row){  
								        var opts = $(this).combobox('options');  
								        return row[opts.textField].indexOf(q) >= 0;//这里改成>=即可在任意地方匹配  
								    	}    	
                			" >&nbsp;&nbsp;&nbsp;
                  <!-- 物料编码 -->
                 <spring:message code="vehiclesdetailinfo.column.materialcode_s" />
                 <input name="filter[materialcode_s]" id="materialcode_s" type="text" style="width:120px" class="easyui-combobox" 
                	data-options="
                			textField:'MATERIALCODE_S',
							valueField:'MATERIALCODE_S',
                            required:false, 
                            url:'sap/materials/getMaterialList',
							method: 'get',
							editable:'true',
							limitToList:false,
							panelHeight:150,
				          	filter: function(q, row){  
								        var opts = $(this).combobox('options');  
								        return row[opts.textField].indexOf(q) >= 0;//这里改成>=即可在任意地方匹配  
								    	}    
									" >&nbsp;&nbsp;&nbsp; 
                  
                 <!-- 物料规格 -->
                 <spring:message code="vehiclesdetailinfo.column.materialspecification_s" />
                <input name="filter[materialspecification_s]" id="materialspecification_s"  type="text" style="width:120px" class="easyui-combobox" 
                	data-options="
                			textField:'OLDMATCODE_S',
							valueField:'OLDMATCODE_S',
                            required:false, 
                            url:'sap/materials/getMaterialList',
							method: 'get',
							editable:'true',
							limitToList:false,
							panelHeight:150,
				          	filter: function(q, row){  
								        var opts = $(this).combobox('options');  
								        return row[opts.textField].indexOf(q) >= 0;//这里改成>=即可在任意地方匹配  
								    	}    
                		" >&nbsp;&nbsp;&nbsp; 
                
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="vehiclesdetailinfo.add"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="vehiclesdetailinfo.edit"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="vehiclesdetailinfo.remove"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            <auth:button code="vehiclesdetailinfo.save"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="vehiclesdetailinfo.cancel"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            <auth:button code="vehiclesdetailinfo.export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="ExcelExport()"><spring:message code="button.export" /></a></auth:button>
            <auth:button code="vehiclesdetailinfo.copy"><a class="easyui-linkbutton btn-deep-blue"data-options="iconCls:'icon-copy'" onclick="copy()"><spring:message code="button.copy" /></a></auth:button>
            <auth:button code="vehiclesdetailinfo.bacthAdd"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-add'" onclick="bacthAdd()"><spring:message code="button.piliangadd" /></a></auth:button>
            <auth:button code="equipmentcapacity_hide"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="showOrHide()"><spring:message code="button.searchColumn" /></a></auth:button>
        </div>
        <table id="vehiclesdetailinfo_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#VehiclesDetailInfo_dg_toolbar',
                url: 'halfpart/basedata/vehiclesDetailInfo/datagrid',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    
                    <!-- 口型板条码 -->
                    <th data-options="field:'vehicles_barcode_s',align:'center', width:140,editor:{type:'combobox',
                               options:{
									textField:'VEHICLES_BARCODE_S',
									valueField:'VEHICLES_BARCODE_S',
                            		required:false, 
                           			url:'halfpart/basedata/vehiclesDetailInfo/searchVehiclesDescription',
									method: 'get',
									editable:'true',
									limitToList:false,
									panelHeight:150,
									onSelect:onSetPlateSpec	
						}}"><spring:message code="vehiclesdetailinfo.column.vehicles_barcode_s" /></th>
                    <!-- 口型板规格 -->
                    <th data-options="field:'vehiclesspecification_s',align:'center',width:140,editor:{type:'combobox',
                               options:{
		                			textField:'MOUTHPLATESPECIFICATION_S',
									valueField:'MOUTHPLATESPECIFICATION_S',
		                            required:false, 
		                            url:'halfpart/basedata/vehiclesDetailInfo/searchVehiclesDescription',
									method: 'get',
									editable:'true',
									limitToList:false,
									panelHeight:150,
									onSelect:onSetPlateCode	
						}}"><spring:message code="vehiclesdetailinfo.column.vehiclesspecification_s" /></th>
					 <!-- 口型板状态 -->	
					 <th data-options="field:'spare1_s',align:'center' , hidden: true,width:140,editor:{type:'combobox',
                               options:{
		                			textField:'FLAG_S',
									valueField:'FLAG_S',
		                            required:false, 
		                            url:'halfpart/basedata/vehiclesDetailInfo/searchVehiclesDescription',
									method: 'get',
									editable:'true',
									limitToList:false,
									panelHeight:150,
									
						}}"><spring:message code="plateinfo.column.mouthplatestatus" /></th>					
                     <!-- 物料编码 -->
                    <th data-options="field:'materialcode_s',align:'center',width:140,editor:{type:'combobox' ,
                    			options:{
                    				textField:'MATERIALCODE_S',
									valueField:'MATERIALCODE_S',
		                            required:false, 
		                            url:'sap/materials/getMaterialList',
									method: 'get',
									editable:'true',
									limitToList:false,
									panelHeight:150,
		                    		onSelect:onSetMatDescSpec
                    	}}"><spring:message code="vehiclesdetailinfo.column.materialcode_s" /></th>
                    <!-- 物料规格 -->
                    <th data-options="field:'materialspecification_s',align:'center',width:140,editor:{type:'combobox' ,
                    			options:{
                    				textField:'OLDMATCODE_S',
									valueField:'OLDMATCODE_S',
		                            required:false, 
		                            url:'sap/materials/getMaterialList',
									method: 'get',
									editable:'true',
									limitToList:false,
									panelHeight:150,
		                    		onSelect:onSetMatCodeDesc
                    	}}"><spring:message code="vehiclesdetailinfo.column.materialspecification_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'materialname_s',align:'center',width:140,editor:{type:'textbox',options:{disabled:true}}"><spring:message code="vehiclesdetailinfo.column.materialname_s" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_s',align:'center',width:140,editor:{}"><spring:message code="vehiclesdetailinfo.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',align:'center',width:140,editor:{}"><spring:message code="vehiclesdetailinfo.column.created_time_t" /></th>
                     <!-- 修改人 -->
                    <th data-options="field:'changed_by_s',align:'center',width:140,editor:{}"><spring:message code="vehiclesdetailinfo.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',align:'center',width:140,editor:{}"><spring:message code="vehiclesdetailinfo.column.changed_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
    
    
    <div id="bacthAdd" class="easyui-dialog" title="批量添加" style="width:1000px;height:100%;"
         data-options="resizable:true,
 			           modal:true,
                       iconCls:'icon-window',
                       closed:true,
                       onClose:reload">
     	<div id="layout" class="easyui-layout" style="width:980px;height:100%;">   
   			<div data-options="region:'west',title:'口型板选择',split:true" style="width:50%;height:100%;">
   				<div data-options="region:'center',split:true,border:false"style="width:100%;height:100%;">
			 		<form id="PlateInfo_search_form" class="form" >
           			   <!-- 口型板条码-->
           			   <spring:message code="vehiclesdetailinfo.column.vehicles_barcode_s" />&nbsp;:
           			   <input name="filter[vehicles_barcode_s]" id="vehicles_barcode"  style="width:100px" type="text" class="easyui-combobox" 
                				data-options="textField:'VEHICLES_BARCODE_S',
										valueField:'VEHICLES_BARCODE_S',
                                        required:false, 
                                        url:'halfpart/basedata/vehiclesDetailInfo/searchVehiclesDescription',
										method: 'get',
									    editable:'true',
									    limitToList:false,
									    panelHeight:150,
										filter: function(q, row){  
								        var opts = $(this).combobox('options');  
								        return row[opts.textField].indexOf(q) >= 0;//这里改成>=即可在任意地方匹配  
								    	}" > &nbsp;
           			   <!-- 内径-->
          			   <spring:message code="plateinfo.column.internaldiameter_s" />&nbsp;:
		               <input name="filter[internaldiameter_s]" id="capsule_code_s" style="width:70px" type="text" class="easyui-textbox" data-options="label:''" > &nbsp;
		             
           			   <!-- 厚度 -->
           			   <spring:message code="plateinfo.column.thickness_s" />&nbsp;:
                	   <input name="filter[thickness_s]" id="capsule_specification_s" style="width:70px" type="text" class="easyui-textbox" data-options="label:''" > &nbsp;
                	   
           			   <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="getPlateInfo()"><spring:message code="button.search" /></a>
      				</form>	
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
                     		<!-- 口型板规格 -->
                    		<th data-options="field:'mouthplatespecification_s',width:80,editor:{type:'textbox'}"><spring:message code="plateinfo.column.mouthplatespecification_s" /></th>
                     		<!-- 内径 -->
                    		<th data-options="field:'internaldiameter_s',width:80,editor:{type:'textbox'}"><spring:message code="plateinfo.column.internaldiameter_s" /></th>
                    		<!-- 厚度 -->
                    		<th data-options="field:'thickness_s',width:80,editor:{type:'textbox'}"><spring:message code="plateinfo.column.thickness_s" /></th>
                    		<!-- 口型板状态 -->
                    		<th data-options="field:'flag_s',width:80,hidden:true ,editor:{type:'textbox'}"><spring:message code="plateinfo.column.mouthplatestatus" /></th>
                			</tr>
            			</thead>
        			</table>
   				</div>
   			</div>
   			<div data-options="region:'center',title:'物料选择',split:true" style="width:50%;height:100%;">
				<div data-options="region:'center',split:true,border:false" style="width:100%;height:100%;">
			 		<form id="Material_search_form" class="form" >
           				<!-- 物料编码 -->
           				<spring:message code="vehiclesdetailinfo.column.materialcode_s" />&nbsp;:
           				<input name="filter[materialcode_s]"  id="oldmatcode_s" style="width:100px" type="text" like="true" class="easyui-textbox" data-options="label:''" > &nbsp;
           				<!-- 物料规格 -->
           				<spring:message code="vehiclesdetailinfo.column.materialspecification_s" />&nbsp;:
           				<input name="filter[materialspec_s]"  id="materialspec_s" style="width:100px" type="text" like="true" class="easyui-textbox" data-options="label:''" > &nbsp;
           				<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="getMaterialInfo()"><spring:message code="button.search" /></a>
           				<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-save'" onclick="bacthsave()"><spring:message code="button.save" /></a>
      				</form>	
			 		<table id="material_dg" class="easyui-datagrid" style="width:100%;height:100%;"
				            data-options="
				                fit:true,
				                fitColumns:true,
				                singleSelect: false,
				                toolbar:'#Material_search_form',
				                url:'sap/materials/getMaterialList',
				                striped:true,
				                emptyMsg: '<span><spring:message code='tip.noData'/></span>'  ,
				                method: 'get'">
				     	<thead>           
				        	<tr>
				        		<th data-options="field:'atr_key',checkbox:true"></th>
				        		<!-- 物料编码 -->
		               			<th data-options="field:'MATERIALCODE_S',width:80,editor:{type:'textbox'}"><spring:message code="vehiclesdetailinfo.column.materialcode_s" /></th>
		               			<!-- 物料名称 -->
				        		<th data-options="field:'MATERIALDESC_S',width:80,editor:{type:'textbox'}"><spring:message code="vehiclesdetailinfo.column.materialname_s" /></th>
				        		<!-- 物料规格-->
				        		<th data-options="field:'OLDMATCODE_S',width:80,editor:{type:'textbox'}"><spring:message code="vehiclesdetailinfo.column.materialspecification_s" /></th>
				        		</tr>        
						</thead>
					</table>
				</div>
			</div>
    	</div>   
    </div>
    
    <%-- <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="VehiclesDetailInfo_search_form" />
		<jsp:param name="datagridId" value="vehiclesdetailinfo_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.halfpart.excel.VehiclesDetailInfoExportHandler" />
		<jsp:param name="serviceName" value="VehiclesDetailInfoServiceImpl" />
	</jsp:include> --%>
</body>
</html>
