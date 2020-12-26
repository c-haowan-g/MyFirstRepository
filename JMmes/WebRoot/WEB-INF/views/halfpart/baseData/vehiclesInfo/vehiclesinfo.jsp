<!-- 

    作者      :栾和源
    时间      :2020-03-03 15:56:00 
    页面名称:半部件工装载具信息
    文件关联:
        VehiclesInfo.java
        VehiclesInfoController.java
        VehiclesInfoServiceImpl.java
        VehiclesInfoServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<script type="text/javascript" src="dict/102.js"></script>
<%@ include file="vehiclesinfo.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="VehiclesInfo_dg_toolbar">
            <form id="VehiclesInfo_search_form" class="form" >
                
                <!-- 条码  规则(需校验载具类型条码) -->
                <spring:message code="vehiclesinfo.column.vehicles_barcode_s" />：
                <input name="filter[vehicles_barcode_s]" id="vehicles_barcode_s"  type="text" style="width:120px" class="easyui-textbox" data-options="label:''" >&nbsp;&nbsp;&nbsp;
                
                
                
                <!-- 类型 ：载具基础数据 102，工装基础数据103 -->
                <spring:message code="vehiclesinfo.column.vehicles_type_s" />：
                <input name="filter[vehicles_type_s]" id="vehicles_type_s"  type="text" style="width:120px" class="easyui-combobox" 
                data-options="
                			textField:'DICTNAME_S',
							valueField:'DICTNAME_S',
                            required:false, 
                            url:'halfpart/basedata/vehiclesinfo/searchMethodName',
							method: 'get',
							editable:'true',
							limitToList:false,
							panelHeight:150" >&nbsp;&nbsp;&nbsp;
               
                <!-- 存放库位 -->
                <spring:message code="vehiclesinfo.column.location_s" />
                <input name="filter[location_s]" id="location_s"  type="text" style="width:120px" class="easyui-combobox" 
                data-options="
                			textField:'STORAGE_UNIT_NAME',
							valueField:'STORAGE_UNIT_NAME',
                            required:false, 
                            url:'halfpart/basedata/vehiclesinfo/location',
							method: 'get',
							editable:'true',
							limitToList:false,
							panelHeight:150,
							filter: function(q, row){  
								        var opts = $(this).combobox('options');  
								        return row[opts.textField].indexOf(q) >= 0;//这里改成>=即可在任意地方匹配  
								    	}
                			" >
                &nbsp;&nbsp;&nbsp;
                
                
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="vehiclesinfo.add"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="vehiclesinfo.edit"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="vehiclesinfo.remove"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            <auth:button code="vehiclesinfo.save"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="vehiclesinfo.no"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            <auth:button code="vehiclesinfo.export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            <auth:button code="vehiclesinfo.batchadd"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-add'" onclick="BatchAdd()"><spring:message code="button.piliangadd" /></a></auth:button>
            <auth:button code="equipmentcapacity_hide"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="showOrHide()"><spring:message code="button.searchColumn" /></a></auth:button>
        </div>
        <table id="vehiclesinfo_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#VehiclesInfo_dg_toolbar',
                url: 'halfpart/basedata/vehiclesinfo/datagrid',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    
                    
                    <!-- 条码  规则(需校验载具类型条码) -->
                    <th data-options="field:'vehicles_barcode_s',align:'center',width:100,editor:{type:'textbox',
                    		options:{
							          required:true,
							          editable:true,
                                   onChange:setVehicles_rfidcode_s }}"><spring:message code="vehiclesinfo.column.vehicles_barcode_s" /></th>
                    <!-- RFID码 -->
                    <%-- <th data-options="field:'vehicles_rfidcode_s',align:'center',width:100,editor:{type:'textbox',
                    				options:{
							          required:true,
							          editable:true
                                    }}"><spring:message code="vehiclesinfo.column.vehicles_rfidcode_s" /></th> --%>
                    <!-- 类型 ：载具基础数据 102，工装基础数据103 -->
                    <th data-options="field:'vehicles_type_s',align:'center',width:150,editor:{type:'combobox',
                                 options:{
                                 textField:'DICTNAME_S',
								valueField:'DICTNAME_S',
                           		 required:true, 
                            	url:'halfpart/basedata/vehiclesinfo/searchMethodName',
								method: 'get',
								editable:'true',
								limitToList:false,
								panelHeight:150,
								
                    						}}"><spring:message code="vehiclesinfo.column.vehicles_type_s" />(主)</th>
                    <th data-options="field:'spare1_s',align:'center',width:150,editor:{type:'combobox',
                                 options:{
                                 textField:'DICTNAME_S',
								valueField:'DICTNAME_S',
                           		 required:false, 
                            	url:'halfpart/basedata/vehiclesinfo/searchMethodName',
								method: 'get',
								editable:'true',
								limitToList:false,
								panelHeight:150,
								
                    						}}"><spring:message code="vehiclesinfo.column.vehicles_type_s" />(从)</th>
                     <!-- 存放库位 -->
                    <!-- <th data-options="field:'location_s',align:'center',width:100,editor:{type:'combobox',
                                 options:{
                                 textField:'STORAGE_UNIT_NAME',
								valueField:'STORAGE_UNIT_NAME',
                           		 required: true, 
                            	url:'halfpart/basedata/vehiclesinfo/location',
								method: 'get',
								editable:'true',
								limitToList:false,
								panelHeight:150,
								
                    						}}"> -->
                    <th data-options="field:'location_s',width:100,sortable:true"><spring:message code="vehiclesinfo.column.location_s" /></th>
                     <!-- 批次条码 -->
                    <th data-options="field:'batchno_s',align:'center',width:100,editor:{}"><spring:message code="vehiclesinfo.column.batchno_s" /></th>
                    <!-- 物料规格 -->
                    <th data-options="field:'materialcode_s',align:'center',width:100,editor:{}"><spring:message code="vehiclesinfo.column.materialcode_s" /></th>
                     <!-- 物料名称 -->
                    <th data-options="field:'materialname_s',align:'center',width:100,editor:{}"><spring:message code="vehiclesinfo.column.materialname_s" /></th>
                    <!-- 容量 -->
                    <th data-options="field:'capacity_s',align:'center',width:100,editor:{type:'numberbox',
                                      options:{
                                                precision:0,
                                                required:true,
                                                onChange:checkCapacity_s}}"><spring:message code="vehiclesinfo.column.capacity_s" /></th>
                    <!-- 实际量 -->
                    <th data-options="field:'actual_amount_s',align:'center',width:100,editor:{}"><spring:message code="vehiclesinfo.column.actual_amount_s" /></th>
                    <!-- 产出时间 -->
                    <th data-options="field:'output_time_t',align:'center',width:100,editor:{}"><spring:message code="vehiclesinfo.column.output_time_t" /></th>
                     <!-- 流转卡打印标识 -->
                    <th data-options="field:'printflag_s',width:100,sortable:true,formatter:printFlagFormatter,editor:{type:'combobox',
						              options:{
						              required:true,
		                              panelHeight:100,
		                    		  data:[{value:'0',text:'停用'},{value:'1',text:'启用'}]}}"><spring:message code="vehiclesinfo.column.printflag_s" /></th>
                    <!-- 标志  1 / 0 -->
                    <!-- <th data-options="field:'flag_s',align:'center',width:100,formatter:flagFormat,editor:{type:'combobox',
						             	 options:{
						              	required:true,
		                             	 panelHeight:100,
		                    		  	data:[{value:'0',text:'空闲'},
		                    		  		  {value:'1',text:'已用'}]
		                    		  		  }}"> -->
		              <th data-options="field:'flag_s',width:100,sortable:true,textField:'FLAG_S',valueField:'FLAG_S',formatter:flagFormat"><spring:message code="vehiclesinfo.column.flag_s" /></th>
                     <!-- 修改人 -->
                    <th data-options="field:'changed_by_s',align:'center',width:100"><spring:message code="vehiclesinfo.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',align:'center',width:100"><spring:message code="vehiclesinfo.column.changed_time_t" /></th>
                    
                </tr>
            </thead>
        </table>
    </div>
    
    
    <div id="Batch_dg" class="easyui-dialog" title="<spring:message code="vehiclestypeprestore.batchinput" />"
		style="width:38%;height:68%;"
		data-options="
                resizable:true,
    			modal:true,
                iconCls:'icon-window',
                closed:true,
                buttons: [
                {
                    text:'确认',
                     iconCls:'icon-save',
                     handler:function(){
                         BatchSave();
                    }
                 },{
                    text:'返回',
                    iconCls:'icon-cancel',
                    handler:function(){
                         BatchCancel();
                    }
                }]
                ">
        <br/> 
         <br/>
         
         <table>
         	<tr>
         		<td>
         			<!-- 起始条码 -->
         			&emsp;&emsp;<spring:message code="vehiclestypeprestore.startcode"/>:
         		</td>
         		<td>
         			&emsp;<input id="myIndexA" type="text" class="easyui-combobox" value="" 
                       data-options="label:'',width:'100', 
                                    valueField:'value',
	                                textField:'text',
	                                method:'get',
	                                data: [{
											text: 'FAG',
											value: 'FAG'
										},{
											text: 'GAG',
											value: 'GAG'
										}],
									onChange:vehiclesBarcodeChange1" >
         			<input id="startcode" type="text" class="easyui-textbox" data-options="label:'',width:'90',required:true,onChange:vehiclesBarcodeChange" >
         		</td>
         	</tr>
         	<tr>
         		<td>
         			<!-- 增加数量 -->
         			&emsp;&emsp;<spring:message code="vehiclestypeprestore.batchnum"/>:
         		</td>
         		<td>
         			&emsp;<input id="batchNum" class="easyui-numberspinner" style="width:80px;" required="required" data-options="onChange:batchNumChange,min:1,max:10000,editable:true">  
         		</td>
         	</tr>
         	<tr>
         		<td>
         			<!-- 结束条码 -->
         			&emsp;&emsp;<spring:message code="vehiclestypeprestore.endcode"/>:
         		</td>
         		<td>
         			&emsp;<input id="myIndexB" type="text" class="easyui-textbox" value="" 
			                       data-options="label:'',width:'100',disabled:true" >
			         <input id="endcode" type="text" class="easyui-textbox"  data-options="label:'',width:'90',editable:false,required:true" >
         		</td>
         	</tr>
         	<tr>
         		<td>
         			<!-- 载具类型（主） -->
          			&emsp;&emsp;<spring:message code="vehiclesinfo.column.vehicles_type_s" />（主）:
         		</td>
         		<td>
         			&emsp;<input id="vehicles_type_z" type="text" class="easyui-combobox" 
                data-options="
                			textField:'DICTNAME_S',
							valueField:'DICTNAME_S',
                            required:true, 
                            url:'halfpart/basedata/vehiclesinfo/searchMethodName',
							method: 'get',
							editable:'true',
							limitToList:false,
							panelHeight:150" >
         		</td>
         	</tr>
         	<tr>
         		<td>
         			<!-- 载具类型（从） -->
         			&emsp;&emsp;<spring:message code="vehiclesinfo.column.vehicles_type_s" />（从）:
         		</td>
         		<td>
         			&emsp;<input id="vehicles_type_c" type="text" class="easyui-combobox" 
                data-options="
                			textField:'DICTNAME_S',
							valueField:'DICTNAME_S',
                            required:false, 
                            url:'halfpart/basedata/vehiclesinfo/searchMethodName',
							method: 'get',
							editable:'true',
							limitToList:false,
							panelHeight:150" >
         		</td>
         	</tr>
         	<tr>
         		<td>
         			&emsp;&emsp;<spring:message code="vehiclesinfo.column.capacity_s"/>:
         		</td>
         		<td>
         			&emsp;<input id="capacity" type="text" class="easyui-numberbox" data-options="label:'',required:true,min:0,precision:0" >
         		</td>
         	</tr>
         	<tr>
         		<td>
         			&emsp;&emsp;<spring:message code="vehiclesinfo.column.printflag_s" />:
         		</td>
         		<td>
         			&emsp;<input id="printflag" type="text" class="easyui-combobox" 
                                        data-options="label:'',
                                     panelHeight:'auto',
                                     editable:false,
								     required:true,
								     valueField:'value',
                    				 textField:'text',
								     data:[{value:'1',text:'启用','selected':true},{value:'0',text:'停用'}],
								     ">			
         		</td>
         	</tr>
         </table>
     </div>
    
     <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="VehiclesInfo_search_form" />
		<jsp:param name="datagridId" value="vehiclesinfo_dg" />
		
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.halfpart.excel.VehiclesInfoExportHandler" />
		 
		
		<jsp:param name="serviceName" value="VehiclesInfoServiceImpl" />
	</jsp:include>  
    
    
</body>
</html>
