<!-- 

    作者      :栾和源
    时间      :2020-03-05 16:11:38 
    页面名称:(半部件)库存汇总
    文件关联:
        Ledger.java
        LedgerController.java
        LedgerServiceImpl.java
        LedgerServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="ledger.js.jsp"%>
<script type="text/javascript" src="dict/227.js"></script> 

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="Ledger_dg_toolbar">
            <form id="Ledger_search_form" class="form" >
                <!-- 机台条码-->
                <spring:message code="ledger.column.equip_code_s" />:&emsp;
                <input name="filter[equip_code_s]" id="equip_code_s_s" editable="true" type="text" class="easyui-combobox" 
                       data-options="label:'',
                                     labelWidth:'auto',
                                     panelHeight:200,
                                     editable:true,
                                     data:productLineList,
                                     valueField:'P_LINE_NAME',
                       			     textField:'P_LINE_NAME',
                                     method:'get'">
                <!-- 机台名称-->
                &emsp;<spring:message code="ledger.column.equipdescription_s" />
               :&emsp;<input name="filter[equipdescription_s]" id="equipdescription_s_s" editable="true" type="text" class="easyui-combobox" 
                       data-options="label:'',
                                     labelWidth:'auto',
                                     panelHeight:200,
                                     editable:true,
                                     data:productLineList,
                                     valueField:'DESCRIPTION',
                       			     textField:'DESCRIPTION',
                                     method:'get'">
               
                
                <!-- 物料编码-->
                <spring:message code="ledger.column.materielcode_s" />
               :&emsp;<input name="filter[materielcode_s]" id="materielcode_s_s" editable="true" type="text" class="easyui-combobox" 
                       data-options="label:'',
                                     labelWidth:'auto',
	                                 panelHeight:200,
									 editable:true,
									 disabled:false,
									 data:materialList,
				                     valueField:'MATERIALCODE_S',
				                     textField:'MATERIALCODE_S',
				                     method:'get'" >
				 <br>
                <!-- 物料名称-->
                &emsp;<spring:message code="ledger.column.materielname_s" />
               :&emsp;<input name="filter[materiel_name_s]" id="materielname_s_s" editable="true" type="text" class="easyui-combobox" 
                       data-options="label:'',
                                     labelWidth:'auto',
                                     panelHeight:200,
								     editable:true,
								     data:materialList,
			                         valueField:'MATERIALDESC_S',
			                         textField:'MATERIALDESC_S',
			                         method:'get'">
                                     
                <!-- 库存位置-->
                &emsp;<spring:message code="ledger.column.location_s" />
               :&emsp;<input name="filter[location_s]" id="location_s_s" editable="true" type="text" like="true" class="easyui-textbox" data-options="label:''" >
                &emsp;<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
                &emsp;<auth:button code="ledger.export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="ExcelExport()"><spring:message code="button.export" /></a></auth:button>
                <br>
                <span><spring:message code="ledger.column.summarizingmode"/>:&emsp;</span>
                <!-- 条码号 -->
                <input style="position:relative;top:4px;zoom:150%;"  type="checkbox" name="sumFlag" value="barcode_s" id="barcode_s"/>
                <spring:message code="ledger.column.barcode_s" />
                <!-- 载具 -->
                <input style="position:relative;top:4px;zoom:150%;"  type="checkbox" name="sumFlag" value="vehicles_code_s" id="vehicles_code_s"/>
                <spring:message code="ledger.column.vehicles_code_s" />
                <!-- 物料编码 -->
                <input style="position:relative;top:4px;zoom:150%;"  type="checkbox" name="sumFlag" value="materielcode_s" id="materielcode_s" checked/>
                <spring:message code="ledger.column.materielcode_s" />
                <!-- 物料名称 -->
                <input style="position:relative;top:4px;zoom:150%;"  type="checkbox" name="sumFlag" value="materielname_s" id="materielname_s" checked/>
                <spring:message code="ledger.column.materielname_s" />
                <!-- 质量状态 -->
                <input style="position:relative;top:4px;zoom:150%;"  type="checkbox" name="sumFlag" value="quality_status_s" id="quality_status_s" checked/>
                <spring:message code="ledger.column.quality_status_s" /> 
                <!-- 机台条码 -->
                <input style="position:relative;top:4px;zoom:150%;"  type="checkbox" name="sumFlag" value="equip_code_s" id="equip_code_s" checked/>
                <spring:message code="ledger.column.equip_code_s" />
                <!-- 机台名称 -->
                <input style="position:relative;top:4px;zoom:150%;"  type="checkbox" name="sumFlag" value="equipdescription_s" id="equipdescription_s"/>
                <spring:message code="ledger.column.equipdescription_s" />
                <!-- 主操作手 -->
                <input style="position:relative;top:4px;zoom:150%;"  type="checkbox" name="sumFlag" value="mainoperator_s" id="mainoperator_s" checked/>
                <spring:message code="ledger.column.mainoperator_s" /> 
                <!-- 库存位置 -->
                <input style="position:relative;top:4px;zoom:150%;"  type="checkbox" name="sumFlag" value="location_s" id="location_s"/>
                <spring:message code="ledger.column.location_s" />
                <!-- 生产时间 -->
                <input style="position:relative;top:4px;zoom:150%;"  type="checkbox" name="sumFlag" value="productiondate_t" id="productiondate_t"/>
                <spring:message code="ledger.column.productiondate_t" /> 
                <!-- 入库时间 -->
                <input style="position:relative;top:4px;zoom:150%;"  type="checkbox" name="sumFlag" value="outputtime_t" id="outputtime_t"/>
                <spring:message code="ledger.column.outputtime_t" />
                <!-- 库存类型 基础数据112  -->
                <input style="position:relative;top:4px;zoom:150%;"  type="checkbox" name="sumFlag" value="stocktype_s" id="stocktype_s" checked/>
                <spring:message code="ledger.column.stocktype_s" /><br>
             </form> 
            
        </div>
        <table id="ledger_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
			    fitColumns:true,
				pagination:true,
				rownumbers:true,
				singleSelect: false,
				sorter:filter,
				remoteSort:false,
				pageSize:15,
				pageList:[15,30,50,100,200,500],
				loadFilter: pagerFilter,
                toolbar: '#Ledger_dg_toolbar',
                emptyMsg: '<span><spring:message code='tip.noData'/></span>',
				striped:true,
				method: 'get'">
            <thead>
                <tr>
                   <!--  <th data-options="field:'atr_key',checkbox:false,hidden:true"></th> -->
                    <!-- 条码号 -->
                    <th data-options="field:'barcode_s',sortable:true,editor:{type:'textbox'}"><spring:message code="ledger.column.barcode_s" /></th>
                    <!-- 载具条码 -->
                    <th data-options="field:'vehicles_code_s',sortable:true,editor:{type:'textbox'}"><spring:message code="ledger.column.vehicles_code_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'materielcode_s',sortable:true,editor:{type:'textbox'}"><spring:message code="ledger.column.materielcode_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'materielname_s',sortable:true,editor:{type:'textbox'}"><spring:message code="ledger.column.materielname_s" /></th>
                    <!-- 质量状态  -->
                    <th data-options="field:'quality_status_s',sortable:true,formatter:qualityStatusFormatter,editor:{type:'textbox'}"><spring:message code="ledger.column.quality_status_s" /></th>
                    <!-- 机台条码 -->
                    <th data-options="field:'equip_code_s',sortable:true,editor:{type:'textbox'}"><spring:message code="ledger.column.equip_code_s" /></th>
                    <!-- 机台名称  -->
                    <th data-options="field:'equipdescription_s',sortable:true,editor:{type:'textbox'}"><spring:message code="ledger.column.equipdescription_s" /></th>
                    <!-- 主手 -->
                    <th data-options="field:'mainoperator_s',sortable:true,editor:{type:'textbox'}"><spring:message code="ledger.column.mainoperator_s" /></th>
                    <!-- 库存位置 -->
                    <th data-options="field:'location_s',sortable:true,editor:{type:'textbox'}"><spring:message code="ledger.column.location_s" /></th>
                    <!-- 生产时间 -->
                    <th data-options="field:'productiondate_t',sortable:true,editor:{type:'textbox'}"><spring:message code="ledger.column.productiondate_t" /></th>
                    <!-- 入库时间 -->
                    <th data-options="field:'outputtime_t',sortable:true,editor:{type:'textbox'}"><spring:message code="ledger.column.outputtime_t" /></th>
                    <!-- 库存类型 -->
                    <th data-options="field:'stocktype_s',sortable:true,formatter:storageTypeFormatter,editor:{type:'textbox'}"><spring:message code="ledger.column.stocktype_s" /></th>
                    <!-- 当前汇总量 -->
                    <th data-options="field:'current_num_f',sortable:true,editor:{type:'textbox'}"><spring:message code="ledger.column.current_num" /></th>
                  </tr>
            </thead>
        </table>
    </div>
   
    
    
    
</body>
</html>
