<!-- 
    作者      :时永良
    时间      :2019-03-02 11:06:03 
    页面名称:成型胎胚车维护表
    文件关联:
        TireCar.java
        TireCarController.java
        TireCarServiceImpl.java
        TireCarServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="tirecar.js.jsp"%>
<script type="text/javascript" src="dict/181.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="TireCar_dg_toolbar">
            <form id="TireCar_search_form" class="form" >
                <!-- 胎胚车编号 -->
                       <spring:message code="tirecar.column.tire_shelf_code_s"/>
                :&emsp;<input name="filter[tire_shelf_code_s]" id="tire_shelf_code_s" type="text" like=true class="easyui-combobox" 
                        data-options="label:'',
								      panelHeight:200,
									  required:false,
									  editable:'true',
									  url:'building/basedata/checktirecar/searchByTireCarCode',
									  valueField: 'TIRE_SHELF_CODE_S',
                              		  textField: 'TIRE_SHELF_CODE_S',
									  method:'get',
									  icons:[{iconCls:'icon-clear',
					                  handler:clearCar}]">
			   
			    
                <!-- 满载数量 -->
                 &emsp;<spring:message code="tirecar.column.full_loaded_number_i"/>
                :&emsp;<input name="filter[full_loaded_number_i]" id="full_loaded_number_i" type="text" class="easyui-combotree" 
                        data-options="label:'',
                                      labelWidth:'auto',
                                      panelHeight:200,
                                      editable:false,
								      required:false,
								      url:'dict/code/181',
								      method:'get'">
               <%--  <!-- 创建时间 -->
                 &emsp;<spring:message code="tirecar.column.created_time_t" />
                :&emsp;<input name="filter[start_time]" type="text" editable="true" id="start_time"
						 class="easyui-datetimebox" style="width:16%" data-options="label:''">
				 &nbsp;
				 <spring:message code="tip.to" /> 
				 &nbsp;
				 <input name="filter[end_time]" editable="true" id="end_time"
				       class="easyui-datetimebox" style="width:16%"> --%>  
				 <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="CX_BAN_GANG_JCSJ_TIRECAR_ADD"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="CX_BAN_GANG_JCSJ_TIRECAR_EDIT"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="CX_BAN_GANG_JCSJ_TIRECAR_REMOVE"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            <auth:button code="CX_BAN_GANG_JCSJ_TIRECAR_SAVE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="CX_BAN_GANG_JCSJ_TIRECAR_CANCLE"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-cancel'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            <auth:button code="CX_BAN_GANG_JCSJ_TIRECAR_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            <auth:button code="CX_BAN_GANG_JCSJ_TIRECAR_HIDE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="showOrHide()"><spring:message code="button.searchColumn" /></a></auth:button>
            <auth:button code="CX_BAN_GANG_JCSJ_TIRECAR_BATCHADD"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-add'" onclick="BatchAdd()"><spring:message code="button.piliang" /></a></auth:button>
        </div>
        <table id="tirecar_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#TireCar_dg_toolbar',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 胎胚车编号 -->
                    <th data-options="field:'tire_shelf_code_s',width:80,editor:{type:'textbox'}"><spring:message code="tirecar.column.tire_shelf_code_s" /></th>
                    <!-- 胎胚车描述 -->
                    <th data-options="field:'tire_shelf_description_s',width:80,editor:{type:'textbox'}"><spring:message code="tirecar.column.tire_shelf_description_s" /></th>
                   <%--  <!-- RFID -->
                    <th data-options="field:'rfidcode_s',width:80,editor:{type:'textbox'}"><spring:message code="tirecar.column.rfidcode_s" /></th> --%>
                    <!-- 满载数量 -->
                    <th data-options="field:'full_loaded_number_i',width:80,editor:{
                                        type:'combotree',
                                        options:{ 
                                              panelHeight:200,
                                              editable:false,
								              required:true,
								              url:'dict/code/-181'}}"><spring:message code="tirecar.column.full_loaded_number_i" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'createdname',width:80"><spring:message code="tirecar.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',width:80"><spring:message code="tirecar.column.created_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
    <div id="Batch_dg" class="easyui-dialog" title="<spring:message code="tirecar.batchinput" />"
		style="width:50%;height:60%;"
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
         &emsp;&emsp;<spring:message code="tirecar.column.startCode"/>
         :&emsp;&emsp;&emsp;<input id="myIndex" type="text" class="easyui-textbox" value="HBG" 
                       data-options="label:'',width:'60',disabled:true" >
                <input id="tireCarStartCode" type="text" class="easyui-textbox" data-options="label:'',width:'110',onChange:tireCarStartCodeChange" >
          &emsp;<spring:message code="tirecar.column.justNumTip"/>
         <br/>
         <br/>         
         &emsp;&emsp;<spring:message code="tirecar.column.full_loaded_number_i"/>
         :&emsp;&emsp;&emsp;<input id="loadnum" type="text" class="easyui-combotree" 
                       data-options="label:'',
                                     panelHeight:200,
                                     editable:false,
								     required:true,
								     url:'dict/code/-181'">
         <br/>
         <br/>
         &emsp;&emsp;<spring:message code="batchnum"/>
         :&emsp;<input id="batchnum" type="text" class="easyui-textbox" data-options="label:'',onChange:batchnumCodeChange" >
         <br/>
         <br/>

    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="TireCar_search_form" />
		<jsp:param name="datagridId" value="tirecar_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.building.excel.TireCarExportHandler" />
		<jsp:param name="serviceName" value="TireCarServiceImpl" />
    </jsp:include> 
</body>
</html>
