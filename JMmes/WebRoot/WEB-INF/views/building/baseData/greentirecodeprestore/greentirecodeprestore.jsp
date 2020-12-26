<!-- 

    作者      :whl
    时间      :2019-03-06 12:45:58 
    页面名称:胎胚条码预存表
    文件关联:
        GreenTireCodePrestore.java
        GreenTireCodePrestoreController.java
        GreenTireCodePrestoreServiceImpl.java
        GreenTireCodePrestoreServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="greentirecodeprestore.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="GreenTireCodePrestore_dg_toolbar">
            <form id="GreenTireCodePrestore_search_form" class="form" >
                <!-- 条码号 -->
                <spring:message code="greentireprestore.column.barcode_s" />
                :&emsp;<input name="filter[barcode_s]" id="barcode_s" type="text" class="easyui-textbox" like="true" 
                          data-options="label:''">
                <!-- 机台条码 -->
                <spring:message code="greentireprestore.column.equip_code_s" />
                :&emsp;<input name="filter[equip_code_s]" id="equip_code_s" type="text" class="easyui-combobox"  
                          data-options="label:'',
                                        labelWidth:'auto',
                                        panelHeight:200,
										required:false,
										editable:true,
										url:'building/basedata/productline/getProductlineByProcess?process='+'252005',
										valueField:'p_line_name',
                              			textField:'p_line_name',
										method:'get'">
                <!-- 使用状态（未使用-01，已使用-02） -->
                 &emsp;<spring:message code="greentirecodeprestore.column.status_s" />
                :&emsp;<input name="filter[status_s]" id="status_s" type="text" class="easyui-combobox" 
                       data-options="label:'',
                       	             textField: 'label',
									 data: [{label: '未使用',value: '01'},
									        {label: '已使用',value: '02'}],
									 icons:[{iconCls:'icon-clear',
					                 handler:clearStatus}]">
                <br/>
                <!-- 创建时间 -->
                 <spring:message code="greentirecodeprestore.column.created_time_t" />
                :&emsp;&emsp;<input name="filter[start_time]" type="text" editable="true" id="start_time" class="easyui-datetimebox" style="width:16%" data-options="label:''">
				 &nbsp;
				 <spring:message code="tip.to" /> 
				 &nbsp;
				 <input name="filter[end_time]" editable="true" id="end_time" class="easyui-datetimebox" style="width:16%"> 
				 <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="CX_BAN_GANG_JCSJ_GreenTireCodePrestore_ADD"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="CX_BAN_GANG_JCSJ_GreenTireCodePrestore_EDIT"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="CX_BAN_GANG_JCSJ_GreenTireCodePrestore_REMOVE"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            <auth:button code="CX_BAN_GANG_JCSJ_GreenTireCodePrestore_SAVE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="CX_BAN_GANG_JCSJ_GreenTireCodePrestore_CANCLE"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-cancel'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            <auth:button code="CX_BAN_GANG_JCSJ_GreenTireCodePrestore_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            <auth:button code="CX_BAN_GANG_JCSJ_GreenTireCodePrestore_HIDE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="showOrHide()"><spring:message code="button.searchColumn" /></a></auth:button>
            <auth:button code="CX_BAN_GANG_JCSJ_GreenTireCodePrestore_BATCHADD"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-add'" onclick="BatchAdd()"><spring:message code="button.piliangadd" /></a></auth:button>
            <auth:button code="CX_GreenTireCodePrestore_BatchEdit"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-edit'" onclick="BatchEdit()"><spring:message code="button.piliangedit" /></a></auth:button>
        </div >
        <table id="greentirecodeprestore_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#GreenTireCodePrestore_dg_toolbar',
                url: '',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 胎胚编码 -->
                    <th data-options="field:'barcode_s',width:80,editor:{type:'textbox',
                              options:{   panelHeight:200,
                                          required:true,
										  editable:'true',
										  url:'building/basedata/greentirecodeprestore/getMaxBarcode',
										  valueField:'BARCODE_S',
                              			  textField:'BARCODE_S',
										  method:'get'}}"><spring:message code="greentireprestore.column.barcode_s" /></th>
                    <!-- 使用状态（未使用-01，已使用-02） -->
                    <th data-options="field:'status_s',width:80,formatter:codeFormatter"><spring:message code="greentirecodeprestore.column.status_s" /></th>
                    <!-- 机台条码 -->
                    <th data-options="field:'equip_code_s',width:80,editor:{type:'combobox',options:{
                                          panelHeight:200,
										  required:true,
										  editable:'true',
										  url:'building/basedata/productline/getProductlineByProcess?process='+'252005',
										  valueField:'p_line_name',
                              			  textField:'p_line_name',
										  method:'get'}}">
										  <spring:message code="greentireprestore.column.equip_code_s" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'createdname',width:80"><spring:message code="greentirecodeprestore.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',width:80"><spring:message code="greentirecodeprestore.column.created_time_t" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'changedname',width:80"><spring:message code="greentirecodeprestore.column.changed_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'changed_time_t',width:80"><spring:message code="greentirecodeprestore.column.changed_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
    <div id="Batch_dg" class="easyui-dialog" title="<spring:message code="greentirecodeprestore.batchinput" />"
		style="width:50%;height:60%;"
		data-options="
                resizable:true,
    			modal:true,
                iconCls:'icon-window',
                closed:true,
                onOpen:onBatchDlgOpen,
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
         <!-- 机台条码  -->
          &emsp;&emsp;<spring:message code="greentireprestore.column.equip_code_s" />
         :&emsp;&emsp;&emsp;<input id="equipCode" type="text" class="easyui-combobox" 
                                          data-options="label:'',
                                          panelHeight:200,
										  required:true,
										  editable:true,
										  url:'building/basedata/productline/getProductlineByProcess?process='+'252005',
										  valueField:'p_line_name',
                              			  textField:'p_line_name',
										  method:'get'">  
         <br/>
         <br/>
         &emsp;&emsp;<spring:message code="greentirecodeprestore.startcode"/>
         :&emsp;<input id="barcodeFrom" type="text" class="easyui-textbox"  data-options="onChange:batchNumChange,label:'',required:true" >
         <br/>
         <br/>
         &emsp;&emsp;<spring:message code="greentirecodeprestorebatchnum"/>
         :&emsp;<input id="batchNum" class="easyui-numberspinner" style="width:80px;" required="required" data-options="onChange:batchNumChange,min:1,max:10000,editable:true">  
         <br/>
         <br/>
         &emsp;&emsp;<spring:message code="endBarcode"/>
          :&emsp;<input id="endcode" type="text" class="easyui-textbox"  data-options="label:'',editable:false,required:false" >
         <br/>
         <br/>
         &emsp;&emsp;<spring:message code="tip.isInPortStatus"/>
         :&emsp;<input id="batchstatus" type="text" class="easyui-textbox"  data-options="label:'',editable:false,required:false" >
     </div>
     
     <div id="BatchEdit_dg" class="easyui-dialog" title="<spring:message code="greentirecodeprestore.batchedit" />"
		style="width:50%;height:60%;"
		data-options="
                resizable:true,
    			modal:true,
                iconCls:'icon-window',
                closed:true,
                onOpen:onBatchEditDlgOpen,
                buttons: [
                {
                    text:'确认',
                     iconCls:'icon-save',
                     handler:function(){
                         BatchEditSave();
                    }
                 },{
                    text:'返回',
                    iconCls:'icon-cancel',
                    handler:function(){
                         BatchEditCancel();
                    }
                }]
                ">
         <br/> 
         <br/>
         <!-- 机台条码  -->
          &emsp;&emsp;更改为
         :&emsp;&emsp;&emsp;<input id="equipCodeEdit" type="text" class="easyui-combobox" 
                                          data-options="label:'',
                                          panelHeight:200,
										  required:true,
										  editable:true,
										  url:'building/basedata/productline/getProductlineByProcess?process='+'252005',
										  valueField:'p_line_name',
                              			  textField:'p_line_name',
										  method:'get'">  
         <br/>
         <br/>
         &emsp;&emsp;<spring:message code="greentirecodeprestore.startcode"/>
         :&emsp;<input id="barcodeFromEdit" type="text" class="easyui-textbox"  data-options="onChange:batchNumEditChange,label:'',required:true" >
         <br/>
         <br/>
         &emsp;&emsp;<spring:message code="greentirecodeprestorebatchnumedit"/>
         :&emsp;<input id="batchNumEdit" class="easyui-numberspinner" style="width:80px;" required="required" data-options="onChange:batchNumEditChange,min:1,max:10000,editable:true">  
         <br/>
         <br/>
         &emsp;&emsp;<spring:message code="endBarcode"/>
          :&emsp;<input id="endcodeEdit" type="text" class="easyui-textbox"  data-options="label:'',editable:false,required:true" >
         <br/>
         <br/>
         &emsp;&emsp;<spring:message code="tip.isInPortStatus"/>
         :&emsp;<input id="batchstatusEdit" type="text" class="easyui-textbox"  data-options="label:'',editable:false,required:false" >
     </div>
     
        <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="GreenTireCodePrestore_search_form" />
		<jsp:param name="datagridId" value="greentirecodeprestore_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.building.excel.GreenTireCodePrestoreExportHandler" />
		<jsp:param name="serviceName" value="GreenTireCodePrestoreServiceImpl" />
        </jsp:include> 
</body>
</html>
