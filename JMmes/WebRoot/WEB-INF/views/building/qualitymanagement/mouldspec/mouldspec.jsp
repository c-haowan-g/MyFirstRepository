<!-- 

    作者      :lnk
    时间      :2019-01-14 15:22:26 
    页面名称:机头规格对应关系表
    文件关联:
        MouldSpec.java
        MouldSpecController.java
        MouldSpecServiceImpl.java
        MouldSpecServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="mouldspec.js.jsp"%>
<script type="text/javascript" src="dict/153,154.js"></script>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="MouldSpec_dg_toolbar">
            <form id="MouldSpec_search_form" class="form" >
                <!-- 机头编码 -->
                <spring:message code="mouldspec.column.capsule_code_s" />:
                <input name="filter[capsule_code_s]" id="capsule_code_s" type="text" class="easyui-textbox" data-options="label:''" >&nbsp; &nbsp; &nbsp; &nbsp;
                <!-- 机头名称 -->
                <spring:message code="mouldspec.column.capsule_name_s" />:
                <input name="filter[capsule_name_s]" id="capsule_name_s" type="text" class="easyui-textbox" data-options="label:''" >&nbsp; &nbsp; &nbsp; &nbsp;
                
                <spring:message code="mouldspec.column.material_code_s" />:
                <input name="filter[material_code_s]" id="material_code_s" like="true" type="text" class="easyui-textbox" data-options="label:''" >&nbsp; &nbsp; &nbsp; &nbsp;
                
                
                <!-- 机头类型 -->
                <spring:message code="mouldspec.column.capsule_type_s" />:
                <input name="filter[capsule_type_s]" id="capsule_type_s" type="text" class="easyui-combotree" data-options="label:'',
                  labelWidth:'auto',
                  editable:'true',
				  panelWidth:'200',
				  required:false,
				  url:'dict/code/153',
				  method:'get',
				  label:''">
                <%-- 
                <!-- 胎胚物料编码（SAP品号） -->
                <input name="filter[material_code_s]" id="material_code_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="mouldspec.column.material_code_s" />'" >
                <!-- 机头规格 -->
                <input name="filter[capsule_specification_s]" id="capsule_specification_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="mouldspec.column.capsule_specification_s" />'" >
                 <!-- 创建人 -->
                <input name="filter[created_by_s]" id="created_by_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="mouldspec.column.created_by_s" />'" >
                <!-- 创建时间 -->
                <input name="filter[created_time_t]" id="created_time_t" type="text" class="easyui-textbox" data-options="label:'<spring:message code="mouldspec.column.created_time_t" />'" >
                 <!-- 机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004 -->
                <input name="filter[agenc_no_s]" id="agenc_no_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="mouldspec.column.agenc_no_s" />'" >
                <!-- 修改人 -->
                <input name="filter[changed_by_s]" id="changed_by_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="mouldspec.column.changed_by_s" />'" >
                <!-- 修改时间 -->
                <input name="filter[changed_time_t]" id="changed_time_t" type="text" class="easyui-textbox" data-options="label:'<spring:message code="mouldspec.column.changed_time_t" />'" >
               	<!-- 记录标志，A可用，D删除 -->
                <input name="filter[record_flag_s]" id="record_flag_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="mouldspec.column.record_flag_s" />'" >
                <!-- 备用字段1 -->
                <input name="filter[spare1_s]" id="spare1_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="mouldspec.column.spare1_s" />'" >
                <!-- 备用字段2 -->
                <input name="filter[spare2_s]" id="spare2_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="mouldspec.column.spare2_s" />'" >
                <!-- 备用字段3 -->
                <input name="filter[spare3_s]" id="spare3_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="mouldspec.column.spare3_s" />'" >
                <!-- 备用字段4 -->
                <input name="filter[spare4_s]" id="spare4_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="mouldspec.column.spare4_s" />'" >
                <!-- 备用字段5 -->
                <input name="filter[spare5_s]" id="spare5_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="mouldspec.column.spare5_s" />'" >
                <!-- 工厂（1全钢 2半钢） -->
                <input name="filter[s_factory_s]" id="s_factory_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="mouldspec.column.s_factory_s" />'" >
                 --%><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="CX_BAN_GANG_JCSJ_CXJTDYWH_ADD"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="CX_BAN_GANG_JCSJ_CXJTDYWH_EDIT"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="CX_BAN_GANG_JCSJ_CXJTDYWH_RMOVE"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            <auth:button code="CX_BAN_GANG_JCSJ_CXJTDYWH_SAVE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="CX_BAN_GANG_JCSJ_CXJTDYWH_CANCEL"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            <auth:button code="CX_BAN_GANG_JCSJ_CXJTDYWH_PL"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-add'" onclick="piliang()"><spring:message code="button.piliang" /></a>  </auth:button>
            <auth:button code="CX_BAN_GANG_JCSJ_CXJTDYWH_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
        </div>
        <table id="mouldspec_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#MouldSpec_dg_toolbar',
                url: 'cx/zlgl/mouldspec/datagridUDA',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 机头编码 -->
                    
                    <th id="capsulesl" data-options="field:'capsule_code_s',mode:'remote',width:80,editable:'false',editor:{type:'combobox',options:{
                    			panelHeight:400,
                    			method:'get',
                    			editable:'true',
                                url:'cx/zlgl/mouldspec/searchByCapsulel',
                                valueField: 'CAPSULE_CODE_S',
                              	textField: 'CAPSULE_CODE_S',
                              
                              	onHidePanel : function() {  
							    var _options = $(this).combobox('options');  
							    var _data = $(this).combobox('getData');/* 下拉框所有选项 */  
							    var _value = $(this).combobox('getValue');/* 用户输入的值 */  
							    var _b = false;/* 标识是否在下拉列表中找到了用户输入的字符 */  
							    for (var i = 0; i < _data.length; i++) {  
							        if (_data[i][_options.valueField] == _value) {  
							            _b=true;  
							            break;  
							        }  
								    }  
								    if(!_b){  
								        $(this).combobox('setValue', '');  
								    }  
								},
							
								onSelect : selee,
								required:true}}"><spring:message code="mouldspec.column.capsule_code_s" /></th>
                    
                    <!-- 机头名称 -->
                    <th data-options="field:'capsule_name_s',mode:'remote',textField:'CAPSULE_NAME_S',valueField:'CAPSULE_NAME_S',width:80,editor:{type:'textbox',options:{disabled:true}}"><spring:message code="mouldspec.column.capsule_name_s" /></th>
                    <!-- 胎胚物料编码（SAP品号） -->
                    <%-- <th data-options="field:'material_code_s',mode:'remote',textField:'MATERIAL_CODE_S',valueField:'MATERIAL_CODE_S',width:80,editor:{type:'textbox'}"><spring:message code="mouldspec.column.material_code_s" /></th>
                     --%>
                    <th data-options="field:'material_code_s',mode:'remote',editor:{type:'combobox',options:{
                    			panelHeight:400,
                    			method:'get',
                    			editable:'false',
                    			url:'cx/zlgl/mouldspec/searchByMaterialConbox',
                                valueField: 'MATERIALCODE_S',
                              	textField: 'MATERIALCODE_S',
                              	onHidePanel : function() {  
							    var _options = $(this).combobox('options');  
							    var _data = $(this).combobox('getData');/* 下拉框所有选项 */  
							    var _value = $(this).combobox('getValue');/* 用户输入的值 */  
							    var _b = false;/* 标识是否在下拉列表中找到了用户输入的字符 */  
							    for (var i = 0; i < _data.length; i++) {  
							        if (_data[i][_options.valueField] == _value) {  
							            _b=true;  
							            break;  
							        }  
								    }  	
								    if(!_b){  
								        $(this).combobox('setValue', '');  
								    }  
								},
								onSelect : selectmater,
                    			required:true}}"><spring:message code="mouldspec.column.material_code_s" /></th>
                      <!-- 机头规格 -->
                    <th data-options="field:'spare2_s',mode:'remote',valueField:'SPARE2_S',textField:'SPARE2_S',width:80,editor:{type:'textbox',options:{disabled:true}}"><spring:message code="mouldspec.column.oldmatcode_s" /></th>
                     
                     <!-- 机头规格 -->
                    <th data-options="field:'capsule_specification_s',mode:'remote',valueField:'CAPSULE_SPECIFICATION_S',textField:'CAPSULE_SPECIFICATION_S',width:80,editor:{type:'textbox',options:{disabled:true}}"><spring:message code="mouldspec.column.capsule_specification_s" /></th>
                   
                   	
                    <!-- 机头类型 -->
                    <th data-options="field:'capsule_type_s',mode:'remote',valueField:'CAPSULE_TYPE_S',textField:'CAPSULE_TYPE_S',formatter:codeFormatter,width:80,editor:{type:'combotree',options:{
                    			method:'get',
                                url:'dict/code/153',
                                panelWidth:'300',
                    			required:true,
                    			disabled:true
                    			}}"><spring:message code="mouldspec.column.capsule_type_s" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'create_name_bycode',mode:'remote',valueField:'CREATED_BY_S',textField:'CREATED_BY_S',width:80,editor:{}"><spring:message code="mouldspec.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',mode:'remote',valueField:'CREATED_TIME_T',textField:'CREATED_TIME_T',width:80,editor:{}"><spring:message code="mouldspec.column.created_time_t" /></th>
                   
 <!--               修改人
                    <th data-options="field:'changed_by_s',width:80,editor:{type:'textbox'}"><spring:message code="mouldspec.column.changed_by_s" /></th>
                  	  修改时间
                    <th data-options="field:'changed_time_t',width:80,editor:{type:'textbox'}"><spring:message code="mouldspec.column.changed_time_t" /></th>
                     	记录标志，A可用，D删除
                    <th data-options="field:'record_flag_s',width:80,editor:{type:'textbox'}"><spring:message code="mouldspec.column.record_flag_s" /></th>
                   	 备用字段1
                    <th data-options="field:'spare1_s',width:80,editor:{type:'textbox'}"><spring:message code="mouldspec.column.spare1_s" /></th>
                   	 备用字段2
                    <th data-options="field:'spare2_s',width:80,editor:{type:'textbox'}"><spring:message code="mouldspec.column.spare2_s" /></th>
                    	备用字段3
                    <th data-options="field:'spare3_s',width:80,editor:{type:'textbox'}"><spring:message code="mouldspec.column.spare3_s" /></th>
                   	 备用字段4
                    <th data-options="field:'spare4_s',width:80,editor:{type:'textbox'}"><spring:message code="mouldspec.column.spare4_s" /></th>
                    	备用字段5
                    <th data-options="field:'spare5_s',width:80,editor:{type:'textbox'}"><spring:message code="mouldspec.column.spare5_s" /></th>
                    	 机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004
                    <th data-options="field:'agenc_no_s',width:80,editor:{type:'textbox'}"><spring:message code="mouldspec.column.agenc_no_s" /></th>
                   
                  	  工厂（1全钢 2半钢）
                    <th data-options="field:'s_factory_s',width:80,editor:{type:'textbox'}"><spring:message code="mouldspec.column.s_factory_s" /></th> -->
                </tr>
            </thead>
        </table>
    </div>
    
    <div id="menu_dlg" class="easyui-dialog" title="批量" style="width:1000px;height:100%;"
            data-options="
                resizable:true,
    			modal:true,
                iconCls:'icon-window',
                closed:true">
           
     	<div id="cc" class="easyui-layout" style="width:980px;height:100%;">   
   			<div data-options="region:'west',title:'机头选择',split:true" style="width:380px;height:100%;">
   				<div data-options="region:'center',split:true,border:false"style="width:100%;height:100%;">
			 		<form id="MouldSpec_search_form2" class="form" >
           				
           				<!-- 机头编码 -->
           				<spring:message code="mouldspec.column.capsule_code_s" />&emsp;:&emsp;
           				<input name="filter[capsule_code_s]" id="capsule_code_s" type="text" class="easyui-textbox" data-options="label:''" >
           				 <br>
           				 <spring:message code="mouldspec.column.capsule_type_s" />&emsp;:&emsp;
			             <input name="filter[capsule_type_s]" id="capsule_type_s" type="text" class="easyui-combotree" data-options="label:'',
			                  labelWidth:'auto',
			                  editable:'true',
							  panelWidth:'200',
							  required:false,
							  url:'dict/code/153',
							  method:'get',
							  label:''">
							   <br>
           				 <!-- 机头规格 -->
           				<spring:message code="mouldspec.column.capsule_specification_s" />&emsp;:&emsp;
                		<input name="filter[capsule_specification_s]" id="capsule_specification_s" type="text" class="easyui-textbox" data-options="label:''" >
           				<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter2()"><spring:message code="button.search" /></a>
      				</form>	
			 		<table id="mouldspec_dg2" class="easyui-datagrid" style="width:100%;height:90%"
				            data-options="
				           	 
                				fitColumns:true,
                				pagination:true,
               					rownumbers: true,
                				singleSelect: false,
				                url: 'cx/zlgl/mouldstock/datagridUDA',
				                striped:true,
				                autoRowHeight: true,
				                method: 'get'
				                ">
				     	<thead>           
				        	<tr>
				        		<!-- 机头编码 -->
				        		<th data-options="field:'atr_key',checkbox:true"></th>
				        		<!-- 机头编码 -->
			              		<th data-options="field:'capsule_code_s',width:80,editor:{type:'textbox'}"><spring:message code="mouldspec.column.capsule_code_s" /></th>
				        		 <!-- 机头名称 -->
                    			<th data-options="field:'capsule_name_s',mode:'remote',textField:'CAPSULE_NAME_S',valueField:'CAPSULE_NAME_S',width:80,editor:{type:'textbox'}"><spring:message code="mouldspec.column.capsule_name_s" /></th>
				        		<th data-options="field:'capsule_type_s',mode:'remote',valueField:'CAPSULE_TYPE_S',textField:'CAPSULE_TYPE_S',formatter:codeFormatter,width:80,editor:{type:'combotree',options:{
                    			method:'get',
                                url:'dict/code/153',
                                panelWidth:'300',
                    			required:true,
                    			}}"><spring:message code="mouldspec.column.capsule_type_s" /></th>
                    			<!-- 机头规格 -->
                    			<th data-options="field:'capsule_specification_s',mode:'remote',valueField:'CAPSULE_SPECIFICATION_S',textField:'CAPSULE_SPECIFICATION_S',width:80,editor:{type:'textbox'}"><spring:message code="mouldspec.column.capsule_specification_s" /></th>
				        		 
				        	</tr>        
						</thead>
					</table>
   				</div>
   			</div>
			<div data-options="region:'center',title:'胚胎物料编码',split:true" style="padding:5px;width:600px;height:100%;">
				<div data-options="region:'center',split:true,border:false" style="width:100%;height:100%;">
			 		<form id="MouldSpec_search_form3" class="form" >
           				
           				<spring:message code="mouldspec.column.oldmatcode_s" />&emsp;:&emsp;
           				<input name="filter[oldmatcode_s]"  id="oldmatcode_s" type="text" class="easyui-textbox" data-options="label:''" >
           				<spring:message code="mouldspec.column.ltgg" />&emsp;:&emsp;
           				<input name="filter[ltgg]"  id="oldmatcode_s" type="text" class="easyui-textbox" data-options="label:''" >
           				<br/>
           				<spring:message code="mouldspec.column.value_s" />&emsp;:&emsp;&emsp;
           				<input name="filter[value_s]"  id="value_s" type="text" class="easyui-textbox" data-options="label:''" >
           				&emsp;到&emsp;：&emsp;<input name="filter[value_s2]"  id="value_s" type="text" class="easyui-textbox" data-options="label:''" ><br>
           				<!--物料编码 -->
           				<spring:message code="tirecarreal.column.material_code_s" />&emsp;:&emsp;
           				<input name="filter[slmaterialcode_s]"  id="capsule_code_s" type="text" class="easyui-textbox" data-options="label:''" >
           				 	
           				<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter3()"><spring:message code="button.search" /></a>
           				<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-save'" onclick="plsave()"><spring:message code="button.save" /></a>
      				</form>	
			 		<table id="mouldspec_dg3" class="easyui-datagrid" style="width:100%;height:100%;"
				            data-options="
				                fit:true,
				                fitColumns:true,
				                singleSelect: false,
				                emptyMsg: '<span>输入查询条件，查询对应胎胚</span>',
				                striped:true">
				     	<thead>           
				        	<tr>
				        		<th data-options="field:'atr_key',checkbox:true"></th>
				        		<!-- 机头编码 -->
		               			<th data-options="field:'MATERIALCODE_S',width:80,editor:{type:'textbox'}"><spring:message code="mouldspec.column.material_code_s" /></th>
				        		<th data-options="field:'OLDMATCODE_S',width:80,editor:{type:'textbox'}"><spring:message code="mouldspec.column.oldmatcode_s" /></th>
				        		<th data-options="field:'LTGG',width:80,editor:{type:'textbox'}"><spring:message code="mouldspec.column.ltgg" /></th>
				        		<th data-options="field:'JTKD',width:80,editor:{type:'textbox'}"><spring:message code="mouldspec.column.jtkd" /></th>
				        		<th data-options="field:'TQSDWZ',width:80,editor:{type:'textbox'}"><spring:message code="mouldspec.column.tqsdwz" /></th>
				        		</tr>        
						</thead>
					</table>
				</div>
			</div>
    	</div>   
    	</div> 	
    </div>
     <!-- 	导出-->    
	<jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="MouldSpec_search_form" />
		<jsp:param name="datagridId" value="mouldspec_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.building.excel.MouldSpecExportHandler" />
		<jsp:param name="serviceName" value="MouldSpecServiceImpl" />
	</jsp:include>
</body>
</html>
