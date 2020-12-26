<!-- 

    作者      :徐秉正
    时间      :2020-03-23 13:42:36 
    页面名称:投料记录
    文件关联:
        Feedrecord.java
        FeedrecordController.java
        FeedrecordServiceImpl.java
        FeedrecordServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/meta.jsp"%>
<%@ include file="feedrecord.js.jsp"%>
<script type="text/javascript" src="dict/308,118,302,137.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="Feedrecord_dg_toolbar">
            <form id="Feedrecord_search_form" class="form" >
                <!-- 机台条码 -->
                <spring:message code="feedrecord.column.machinecode_s" />:
                <input name="filter[machinecode_s]" id="machinecode_s" type="text" class="easyui-combobox" 
                data-options="label:'',
               								labelWidth:'auto',
                                            panelHeight:200,
                                            editable:true,
                                            required:false,
                                            limitToList:'false',
                                            data:productLineList,
				            	            textField:'DESCRIPTION',
				            	            valueField:'P_LINE_NAME',
                                            method:'get'
                " >
                 <!-- 投料类型 -->
                 <spring:message code="feedrecord.column.feedingtype_s" />
                <input name="filter[feedingtype_s]" id="feedingtype_s" type="text" class="easyui-combotree" data-options="label:'',
                required:false,
	                editable:true,
          			panelHeight:200,
          			url:'dict/code/308',
          			method:'get'
                " >
                <!-- 原料条码 -->
                <spring:message code="feedrecord.column.barcode_s" />
                <input name="filter[barcode_s]" id="barcode_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 班次 -->
                <spring:message code="feedrecord.column.bz_class_s" />
                <input name="filter[bz_class_s]" id="bz_class_s" type="text" class="easyui-combotree" data-options="label:'',
                required:false,
          			panelHeight:150,
          			url:'dict/code/118',
          			method:'get'
                " ><br>
                <!-- 载具条码 -->
                <spring:message code="feedrecord.column.vehicles_code_s" />
                <input name="filter[vehicles_code_s]" id="vehicles_code_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 使用状态 -->
                <spring:message code="feedrecord.column.usestatus_s" />
                <input name="filter[usestatus_s]" id="usestatus_s" type="text" class="easyui-combotree" data-options="label:'',
                    required:false,
          			panelHeight:150,
          			url:'dict/code/137',
          			method:'get'
                " >
                <!-- 投料时间 -->
                 &emsp;<spring:message code="feedingrecord.column.inputtime_t" />
                :&emsp;<input name="filter[start_time]" id="start_time" type="text" class="easyui-datetimebox" data-options="label:''"></td>
				 &nbsp;<spring:message code="tip.to" />
				 &nbsp;<input name="filter[end_time]" id="end_time" type="text" class="easyui-datetimebox" data-options="label:''"></td>
            </form> 
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            <auth:button code="feedrecord.add"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="feedrecord.edit"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
      	 <auth:button code="feedrecord.delete"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            <auth:button code="feedrecord.save"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="feedrecord.cancel"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            <auth:button code="feedrecord.export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            <auth:button code="feedrecord.machinesearch"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-search'" onclick="machinesearch()"><spring:message code="button.machinesearch" /></a></auth:button>
        </div>
        <table id="feedrecord_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#Feedrecord_dg_toolbar',
                url: 'halfpart/feedrecord/feedrecord/datagridUDA',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 物料组 -->
                    <th data-options="field:'materialcode_s',width:250,formatter:materialFormatter,sortable:true,editor:{type:'combobox',
                    options:{
                                 labelWidth:'auto',
                                 panelHeight:'200',
                                 fitColumns:true,
							     required:true,
							     editable:true,
								url:'halfpart/feedrecord/feedrecord/materialGroupList',
								     valueField:'ERPCODE_S',
						             textField:'DICTNAME_S',
					             method:'get'
                               }
                    
                    
                    }"><spring:message code="feedrecord.column.materialgroup_s" /></th>
                    <!-- 载具条码 -->
                    <th data-options="field:'vehicles_code_s',editor:{type:'textbox'}"><spring:message code="feedrecord.column.vehicles_code_s" /></th>
                    <!-- 机台条码 -->
                    <th data-options="field:'machinecode_s',formatter:machineFormatter,editor:{type:'combobox',
                     options:{
                     						labelWidth:'auto',
                                            panelHeight:200,
                                            editable:true,
                                            fitColumns:true,
                                            required:false,
                                            limitToList:'false',
                                            data:productLineList,
				            	            textField:'DESCRIPTION',
				            	            valueField:'P_LINE_NAME',
                                            method:'get'
                     }
                    }"><spring:message code="feedrecord.column.machinecode_s" /></th>
                    <!-- 原料条码 -->
                    <th data-options="field:'barcode_s',editor:{type:'textbox'}"><spring:message code="feedrecord.column.barcode_s" /></th>
                    <!-- 班次 -->
                    <th data-options="field:'bz_class_s',formatter:codeFormatter,width:80,editor:{type:'combotree',
                    options:{
                     required:false,
          			panelHeight:150,
          			
          			url:'dict/code/118',
          			method:'get'
                    }
                    
                    }"><spring:message code="feedrecord.column.bz_class_s" /></th>
                    <!-- 班组 -->
                    <th data-options="field:'bz_group_s',editor:{type:'textbox'}"><spring:message code="feedrecord.column.bz_group_s" /></th>
                    <!-- 投料类型 -->
                    <th data-options="field:'feedingtype_s',editor:{type:'textbox'}"><spring:message code="feedrecord.column.feedingtype_s" /></th>
                    <!-- 投料时间 -->
                    <th data-options="field:'inputtime_t',editor:{type:'textbox'}"><spring:message code="feedrecord.column.inputtime_t" /></th>
                    <!-- 投料计数器数 -->
                    <th data-options="field:'macnumin_f',editor:{type:'textbox'}"><spring:message code="feedrecord.column.macnumin_f" /></th>
                    <!-- 工单号 -->
                    <th data-options="field:'order_planno_s',editor:{type:'combobox',
                     options:{
                                 labelWidth:'auto',
                                            panelHeight:200,
                                            editable:true,
                                            required:false,
                                            limitToList:'false',
                                            url:'halfpart/feedrecord/feedrecord/getPlanno',
                                            data:getPlanno,
				            	            textField:'PLANNO_S',
				            	            valueField:'PLANNO_S',
                                            method:'get'
                               }
                    
                    }"><spring:message code="feedrecord.column.order_planno_s" /></th>
                    <!-- 撤下时间 -->
                    <th data-options="field:'removetime_t',editor:{type:'textbox',
                    options:{
                    disabled:true
                    }
                    }"><spring:message code="feedrecord.column.removetime_t" /></th>
                    <!-- 操作工名称 -->
                    <th data-options="field:'worker_id_s',editor:{type:'textbox'}"><spring:message code="feedrecord.column.worker_id_s" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changed_by_s',editor:{type:'textbox',
                    options:{
                    disabled:true
                    }
                    }"><spring:message code="feedrecord.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',editor:{type:'textbox',
                    options:{
                    disabled:true
                    }
                    }"><spring:message code="feedrecord.column.changed_time_t" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_s',editor:{type:'textbox',
                    options:{
                    disabled:true
                    }
                    }"><spring:message code="feedrecord.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',editor:{type:'textbox',
                    options:{
                    disabled:true
                    }
                    }"><spring:message code="feedrecord.column.created_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
    
    
             <!-- 子界面 -->
    <div id="Machine_dg" class="easyui-dialog" title="机台查询" style="width:900px;height:400px;" closed="true" >
		
  <div id="EquipmentMaterial_dg_toolbar">
            <form id="EquipmentMaterial_search_form" class="form" >
               <!-- 机台名称 -->
                <spring:message code="equipmentmaterial.column.equipmentname_s" />:<input name="filter[equipmentcode_s]" id="equipmentcode_s" style="width:170px" type="text" class="easyui-combobox"
					 data-options="label:'',
               								labelWidth:'auto',
                                            panelHeight:200,
                                            editable:true,
                                            required:false,
                                            limitToList:'false',
                                            data:productLineList,
				            	            textField:'DESCRIPTION',
				            	            valueField:'P_LINE_NAME',
                                            method:'get'
                " >&nbsp;&nbsp;&nbsp;
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter1()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="equipmentmaterial.save"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save1()"><spring:message code="button.save" /></a></auth:button>
        </div>
        <table id="equipmentmaterial_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#EquipmentMaterial_dg_toolbar',
                striped:true,
                method: 'get' 
                ">
                <!-- url:'halfpart/basedata/equipmentMaterial/datagrid', -->
            <thead>
                <tr>
                <th data-options="field:'atr_key',checkbox:true">ID</th>
                  <!-- 物料组 -->
                    <th data-options="field:'dictname_s',formatter:getNameByGroupCode,editor:{type:'textbox',
                    options:{
                    					valueField:'materialgroup_s',
				            			textField:'materialgroup_s',
                                        required:true, 
                                        url:'halfpart/feedrecord/feedrecord/searchMaterialGroup',
										method: 'get',
									    editable:'true',
									    limitToList:false,
									    panelHeight:200,
										filter: function(q, row){  
								        var opts = $(this).combobox('options');  
								        return row[opts.textField].indexOf(q) >= 0;
								    	}}
                    }"><spring:message code="eq.column.materialgroup_s" /></th>
                    <!-- 机台条码 -->
                    <th data-options="field:'description',formatter:toEquipName,editor:{type:'textbox',
                    options:{
                    					valueField:'description',
				            			textField:'description',
                                        required:true, 
                                        url:'halfpart/basedata/productlinemanager/getProductline',
										method: 'get',
									    editable:'true',
									    limitToList:false,
									    panelHeight:200,
										filter: function(q, row){  
								        var opts = $(this).combobox('options');  
								        return row[opts.textField].indexOf(q) >= 0;
								    	}}
                    }"><spring:message code="eq.column.equipmentcode_s" /></th>
                    
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_s',formatter:toUserName,editor:{type:'textbox'}"><spring:message code="eq.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',editor:{type:'textbox'}"><spring:message code="eq.column.created_time_t" /></th>
                    
                    <!-- 是否是主物料 0：主物料 1：副物料 -->
                    <th data-options="field:'isprimary_s',formatter:isprimary_material,editor:{type:'textbox',
                    options:{
                    				 required:true,
								     editable:false,
								     data:[
								     {'value':'0','text':'是'},
								     {'value':'1','text':'否'}],
								     valueField:'value',
								     textField:'text'}
                    }"><spring:message code="eq.column.isprimary_s" /></th>
                  <!-- 修改人 -->
                    <th data-options="field:'changed_by_s',formatter:toUserName,editor:{type:'textbox'}"><spring:message code="eq.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',editor:{type:'textbox'}"><spring:message code="eq.column.changed_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
    
    
    
    <jsp:include page="../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="Feedrecord_search_form" />
		<jsp:param name="datagridId" value="feedrecord_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.halfpart.excel.FeedrecordExportHandler" />
		<jsp:param name="serviceName" value="FeedrecordServiceImpl" />
	</jsp:include>
</body>
</html>
