<!-- 

    作者      :李迺锟
    时间      :2018-11-22 17:23:04 
    页面名称:入库规则维护
    文件关联:
        SortStoragItem.java
        SortStoragItemController.java
        SortStoragItemServiceImpl.java
        SortStoragItemServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="sortstoragitem.js.jsp"%>
<script type="text/javascript" src="dict/253.js"></script>
<style type="text/css">
.columnTitle {
	padding: 6px 10px
}
</style>
<body class="easyui-layout" fit="true"> 
   <div class="easyui-tabs" fit="true" border="false" style="width:700px;height:250px">
   
   <div title="规则查询" style="padding:10px">
        <div id="SortStoragItem_dg_toolbar">
            <form id="SortStoragItem_search_form" class="form" >
            	<td class="columnTitle">
	            	<spring:message code="sortstoragitem.column.trackno_i" />:
	            	 <!-- 道口：D_EM_EntTrack.TRACK -->
	                <input name="filter[entbarcode_s]" id="entbarcode_s" type="text" class="easyui-combobox" data-options="label:'',
	                required:false, 
	                panelHeight:200,
	                width:140,
	                icons:[{iconCls:'icon-clear',handler:function(e){$(e.data.target).combobox('clear')}}],
	                method: 'get',
	                data:EntNameData,
				    valueField:'ENTBARCODE_S',
				    textField:'ENTNAME_S'
	                " >
                </td>
                <td class="columnTitle">
	            	<!-- 质量等级编码 -->
	            	<spring:message code="sortstoragitem.column.gradecode_i" />:
	                <input name="filter[gradecode_i]" id="gradecode_i" style="width:120px" type="text" class="easyui-combotree" data-options="label:'',
	                 labelWidth:'auto',
	                 required:false,
	                 url:'dict/code/253',
	                 method:'get'
	                " >
                </td>
                <td class="columnTitle">
            		 <!-- 品号 -->
            		 <spring:message code="sortstoragitem.column.itemid_s" />:
               		 <input name="filter[itemid_s]" id="itemid_s" like="true" type="text" class="easyui-textbox" data-options="label:''" >
                </td>
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
                <a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a>
            	<a class="easyui-linkbutton btn-blue"data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a>
            </form> 
            <%-- <auth:button code="ZJ_BZGL_RKFJ_ADD"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="ZJ_BZGL_RKFJ_EDIT"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="ZJ_BZGL_RKFJ_REMOVE"><a class="easyui-linkbutton btn-black"data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
		    <auth:button code="ZJ_BZGL_RKFJ_SAVE"><a class="easyui-linkbutton btn-blue"data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="ZJ_BZGL_RKFJ_CANCEL"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            <auth:button code="ZJ_BZGL_RKGZ_DC"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-add'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            <auth:button code="ZJ_BZGL_RKGZ_CXL"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-undo'" onclick="searchBar()"><spring:message code="button.searchColumn" /></a></auth:button> --%>
        </div>
        <table id="sortstoragitem_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                emptyMsg: '<span><spring:message code='tip.noData'/></span>',
                singleSelect: false,
                toolbar: '#SortStoragItem_dg_toolbar',
                url: 'finalcheck/reportcenter/sortstorageitem/datagrid',
                striped:true,
                method: 'get'  
                ">
            <thead>
                <tr>
                    <th data-options="field:'ck',checkbox:true"></th>
                	 <!-- 品号 -->
                    <th data-options="field:'itemid_s',editor:{
				                    type:'combobox',options:{
				                    delay:300,
				                    panelWidth:300,
				                    required:true,
				                    data:GradeData,
				                    panelHeight:150,editable:true,
				                    valueField:'MATERIALCODE_S',
				                    textField:'MATERIALCODE_S',
				                    selectOnNavigation:false,
				                    limitToList:true}}"><spring:message code="sortstoragitem.column.itemid_s" /></th>
				         
				      <!-- 物料描述 -->              
				      <th data-options="field:'materialdesc',formatter:materialdescFormatter"><spring:message code="materialslog.column.materialname_s" /></th>              
				                    
                	 <!-- 质量等级编码 -->
                    <th data-options="field:'gradecode_i',formatter:codeFormatter,editor:{type:'combotree',options:{panelWidth:200,required:true,method:'get',
                                url:'dict/code/253'}}"><spring:message code="sortstoragitem.column.gradecode_i" /></th>
                	 <!-- 设备名称 -->
                    <th data-options="field:'entbarcode_s',formatter:showEntNameFormatter,editor:{type:'combobox',options:
	                                {valueField:'ENTBARCODE_S',
	                                textField:'ENTNAME_S',
	                                required:true,
	                                method:'get',
	                                data:EntNameData}}"><spring:message code="sortstoragitem.column.entbarcode_s" /></th>
                     <!-- 道口：D_EM_EntTrack.TRACK -->
                    <th data-options="field:'trackno_s',editor:{type:'textbox'}"><spring:message code="sortstoragitem.column.trackno_i" /></th>
                	 <!-- 创建人 -->
                    <th data-options="field:'created_by_s'"><spring:message code="sortstoragitem.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t'"><spring:message code="sortstoragitem.column.created_time_t" /></th>
                     <!-- 修改人 -->
                    <th data-options="field:'changed_by_s'"><spring:message code="sortstoragitem.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t'"><spring:message code="sortstoragitem.column.changed_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
    
    
    
    <div title="规则维护" style="padding:10px">
    		<div class="easyui-layout" fit="true" border="false">	
    			  <div data-options="region:'west',iconCls:'icon-ok',split:true" title="待选项" style="width:50%">
							<table id="material_dg" class="easyui-datagrid"
										style="width:100%"
										data-options="  
										fit:true,
										fitColumns:true,
										pagination:true,
										rownumbers: true,
										emptyMsg: '<span><spring:message code='tip.noData'/></span>',
										singleSelect:true,
										data:GradeData,
										striped:true,
										method: 'get',
										 onSelect:selectmaterialrow,
										onLoadSuccess:function(data){
										   $(this).datagrid('enableFilter');
										}"
										>
							<thead>
								<tr>
								   <th data-options="field:'ck',checkbox:true"></th>
									<!-- 品号 -->
									<th data-options="field:'MATERIALCODE_S',width:50,editor:{type:'textbox',options:{required:true}}"><spring:message code="materials.column.materialcode_s" /></th>
									<!-- 物料描述 -->
									<th data-options="field:'MATERIALDESC_S',width:150,editor:{type:'textbox',options:{required:true}}"><spring:message code="materials.column.materialdesc_s" /></th>
								</tr>
							</thead>
						</table>
    			  </div>
    			 <div data-options="region:'center',iconCls:'icon-ok',split:true" title="等级"style="width:25%">
                  <auth:button code="ZJ_BZGL_RKFJ_ADD"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="showgrademenudlg()"><spring:message code="button.add" /></a></auth:button>
    			  	<table id="grade_dg" class="easyui-datagrid"
						style="width:100%"
						data-options="  fit:true,
										fitColumns:true,
										singleSelect: true,
										url: '',
										emptyMsg: '<span><spring:message code='tip.noGradeData'/></span>',
										striped:true,
										onSelect:selectgraderow,
										method: 'get'">
						<thead>
							<tr>
							    <th data-options="field:'ck',checkbox:true"></th>
								 <!-- 质量等级编码 -->
                   				 <th data-options="field:'GRADECODE_I',width:80,formatter:codeFormatter,editor:{type:'textbox',options:{panelWidth:200,required:true,method:'get',
                               	 url:'dict/code/253'}}"><spring:message code="sortstoragitem.column.gradecode_i" /></th>
							</tr>
						</thead>
					</table>
    			 </div>
    			 
    			 
    			  <div data-options="region:'east',iconCls:'icon-ok',split:true" title="道口"style="width:25%">
    			  	 <auth:button code="ZJ_BZGL_RKFJ_ADD"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="showtrackmenudlg()"><spring:message code="button.add" /></a></auth:button>
    			  	<auth:button code="ZJ_BZGL_RKFJ_REMOVE"><a class="easyui-linkbutton btn-black"data-options="iconCls:'icon-remove'" onclick="removeStorageItem()"><spring:message code="button.delete" /></a></auth:button>
    			  	<table id="track_dg" class="easyui-datagrid"
						style="width:100%"
						data-options="  fit:true,
										fitColumns:true,
										singleSelect: false,
										url: '',
										striped:true,
										method: 'get'">
						<thead>
							<tr>
							     <th data-options="field:'ck',checkbox:true"></th>
							     <!-- 设备号 -->
                  			     <th data-options="field:'ENTBARCODE_S',width:80,formatter:showEntNameFormatter,editor:{type:'combobox',options:
	                                {valueField:'ENTBARCODE_S',
	                                textField:'ENTNAME_S',
	                                required:true,
	                                method:'get',
	                                data:EntNameData}}"><spring:message code="sortstoragitem.column.entbarcode_s" /></th>
								 <!-- 道口-->
                  			     <th data-options="field:'TRACKNO_I',width:80,editor:{type:'textbox'}"><spring:message code="sortstoragitem.column.trackno_i" /></th>
								
							</tr>
						</thead>
					</table>
    			 </div>
    			 <div id="menu_dlg" class="easyui-dialog" title="新增质量等级"
						style="width:20%;height:70%;"
						data-options="
				                resizable:true,
				    			modal:true,
				                iconCls:'icon-window',
				                closed:true,
				                onOpen:loadnoselectgrade,
				                buttons: [{
				                    text:'保存',
				                    iconCls:'icon-ok',
				                    handler:function(){
				                        dosaveToGradeDlg();
				                    }
				                },{
				                    text:'取消',
				                     iconCls:'icon-cancel',
				                    handler:function(){
				                        cancelselectgrade();
				                    }
				                }]
				                ">
				                
					     <table id="addgrade_dg" class="easyui-datagrid"
							style="width:100%"
							data-options="  fit:true,
											fitColumns:true,
											singleSelect: false,
											url: '',
											striped:true,
											method: 'get'">
							<thead>
								<tr>
								     <th data-options="field:'ck',checkbox:true"></th>
								     <!-- 质量等级编码 -->
                   				 	 <th data-options="field:'GRADECODE_I',width:80,formatter:codeFormatter,editor:{type:'textbox',options:{panelWidth:200,required:true,method:'get',
                               	 	 url:'dict/code/253'}}"><spring:message code="sortstoragitem.column.gradecode_i" /></th>
								</tr>
							</thead>
						</table>
				</div>
				<div id="menutrack_dlg" class="easyui-dialog" title="新增设备道口"
						style="width:20%;height:70%;"
						data-options="
				                resizable:true,
				    			modal:true,
				                iconCls:'icon-window',
				                closed:true,
				                onOpen:loadnoselecttrack,
				                buttons: [{
				                    text:'保存',
				                    iconCls:'icon-ok',
				                    handler:function(){
				                        dosaveToTracknoDlg();
				                    }
				                },{
				                    text:'取消',
				                     iconCls:'icon-cancel',
				                    handler:function(){
				                        cancelselecttrackno();
				                    }
				                }]
				                ">
					     <table id="addtrack_dg" class="easyui-datagrid"
							style="width:100%"
							data-options="  fit:true,
											fitColumns:true,
											singleSelect: false,
											url: '',
											striped:true,
											method: 'get'">
							<thead>
								<tr>
								     <th data-options="field:'ck',checkbox:true"></th>
								     <!-- 设备号 -->
                  			         <th data-options="field:'ENTBARCODE_S',width:80,formatter:showEntNameFormatter,editor:{type:'combobox',options:
	                                 {valueField:'ENTBARCODE_S',
	                                 textField:'ENTNAME_S',
	                                 required:true,
	                                 method:'get',
	                                 data:EntNameData}}"><spring:message code="sortstoragitem.column.entbarcode_s" /></th>
								     <!-- 道口-->
                  			         <th data-options="field:'TRACKNO_I',width:80,editor:{type:'textbox'}"><spring:message code="sortstoragitem.column.trackno_i" /></th>
							   </tr>
							</thead>
						</table>
				</div>
    		</div>
    </div>
    </div>
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="SortStoragItem_search_form" />
		<jsp:param name="datagridId" value="sortstoragitem_dg" />
		<jsp:param name="handlerClass"
			value="com.bluebirdme.mes.linglong.zj.excel.SortStoragItemExportHandler" />
		<jsp:param name="serviceName" value="SortStoragItemServiceImpl" />
	</jsp:include>
</body>
</html>
