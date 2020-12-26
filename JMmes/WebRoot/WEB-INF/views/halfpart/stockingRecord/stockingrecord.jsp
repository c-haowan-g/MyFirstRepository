<!-- 

    作者      :徐秉正
    时间      :2020-03-16 10:33:49 
    页面名称:半部件盘库记录
    文件关联:
        Stockingrecord.java
        StockingrecordController.java
        StockingrecordServiceImpl.java
        StockingrecordServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/meta.jsp"%>
<%@ include file="stockingrecord.js.jsp"%>
<script type="text/javascript" src="dict/308.js"></script>
<style type="text/css">
.columnTitle {
	padding: 6px 10px
}
</style>
<body class="easyui-layout" fit="true"> 
    <div  data-options="region:'north',split:true"  style="height:50px;">
        <div id="Stockingrecord_dg_toolbar" >
            <form id="Stockingrecord_search_form" class="form"  >
            
            
            <td class="columnTitle">
                <!-- 盘库单号 -->
                <spring:message code="stockingrecord.column.stockno_s" />:
                <input name="filter[stockno_s]" id="stockno_s" type="text" class="easyui-textbox" data-options="
                url:''
                " >
            </td>
            
            
             <td class="columnTitle">
                <!-- 物料组 -->
                <spring:message code="stockingrecord.column.materialgroup_s" />:
                <input name="filter[materialgroup_s]" id="materialgroup_s" type="text"   class="easyui-combobox" 
               data-options="valueField:'DICTCODE_S',
				            			textField:'DICTNAME_S',
                                        required:false, 
                                        editable:true,
                                        url:'halfpart/stockingRecord/stockingrecord/stockingrecord/searchMaterielgroup',
                                        
										method: 'get',
										prompt:'全部',
									    limitToList:'false',
									    panelHeight:150,
									    labelWidth:'auto',
										" >
              </td>  
              
              
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter1()"><spring:message code="button.stockingScratch" /></a>
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="searchStockData()"><spring:message code="button.stockingData" /></a>
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="searchStockData()"><spring:message code="button.stockingConfirm" /></a> 	
                
                
            </form> 
        </div>
    </div> 
    
  
    

    
    
    <div data-options="region:'center',split:true" >
     <div class="easyui-layout" fit="true">
	   <div data-options="region:'west',split:true" title='盘库数据' style="width:50%;">
        <table id="stockingrecord_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                url: 'halfpart/stockingRecord/stockingrecord/stockingrecord/datagrid',
                striped:true,
                method: 'get' 
                ">
               <!--  toolbar: '#Stockingrecord_dg_toolbar', -->
                <!-- url: 'halfpart/stockingRecord/stockingrecord/stockingrecord/datagrid', -->
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 条码号 -->
                    <th data-options="field:'tirebarcode_s',editor:{type:'textbox'}"><spring:message code="stockingrecord.column.tirebarcode_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'materialcode_s',editor:{type:'textbox'}"><spring:message code="stockingrecord.column.materialcode_s" /></th>
                    <!-- 规格 -->
                    <th data-options="field:'specification_s',editor:{type:'textbox'}"><spring:message code="stockingrecord.column.specification_s" /></th>
                    <!-- 生产机台 -->
                    <th data-options="field:'machinno_s',editor:{type:'textbox'}"><spring:message code="stockingrecord.column.machinno_s" /></th>
                      <!-- 生产数量 -->
                    <th data-options="field:'quantity_i',editor:{type:'textbox'}"><spring:message code="stockingrecord.column.quantity_i" /></th>
                    <!-- 盘库单号 -->
                    <th data-options="field:'stockno_s',editor:{type:'textbox'}"><spring:message code="stockingrecord.column.stockno_s" /></th>
                     <!-- 盘库信息来源  0：立库 1：人工 2:MES   -->
                    <th data-options="field:'messagefrom_s',formatter:messagefromFormatter,editor:{type:'textbox'}"><spring:message code="stockingrecord.column.messagefrom_s" /></th>
                </tr>
            </thead>
        </table>
    </div>
    
    
    
    
    <div data-options="region:'center',split:true" title='MES数据'>
    <table id="ledger_dg" class="easyui-datagrid" style="width:100%" 
            data-options="  
                fit:true,
                fitColumns:true,
                 pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#Ledger_dg_toolbar',
                striped:true,
                url: 'halfpart/ledger/ledger/datagrid',
                method: 'get' 
                ">
               <!--  toolbar: '#Ledger_dg_toolbar'-->
                
                <!--  url: 'halfpart/ledger/ledger/datagrid', -->
                
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 条码号 -->
                    <th data-options="field:'barcode_s',sortable:true,editor:{type:'textbox'}"><spring:message code="ledger.column.barcode_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'materielcode_s',sortable:true,editor:{type:'textbox'}"><spring:message code="ledger.column.materielcode_s" /></th>
                    <!-- 规格 -->
                    <th data-options="field:'specification_s',sortable:true,editor:{type:'textbox'}"><spring:message code="ledger.column.specification_s" /></th>
                     <!-- 生产机台 -->
                    <th data-options="field:'equip_code_s',sortable:true,editor:{type:'textbox'}"><spring:message code="ledger.column.equip_code_s" /></th>
                     <!-- 生产数量 -->
                    <th data-options="field:'yl_num_f',sortable:true,editor:{type:'textbox'}"><spring:message code="ledger.column.yl_num_f" /></th>
                   
                    
                </tr>
            </thead>
        </table>
       </div>
        </div>
         </div>
         
         
         
         
         
           <!-- 点击查询盘库数据弹出子界面 -->
    <div id="StockingDataClick_dg" class="easyui-dialog" title="查询盘库数据" style="width:900px;height:400px;" closed="true" >
		<%--  data-options="closed:true,width:window.innerWidth,
		                  height:window.innerHeight, onClose:productLineload"> --%>
                        
 <div id="Stockdifferentlist_dg_toolbar">
            <form id="Stockingrecord_search_form" class="form"  >
            
            
            <td class="columnTitle">
                <!-- 盘库单号 -->
                <spring:message code="stockingrecord.column.stockno_s" />:
                <input name="filter[stockno_s]" id="stockno_s" type="text" class="easyui-textbox" data-options="label:''" >
            </td>
            </form>
            <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="searchStockData()"><spring:message code="button.search" /></a>
        </div>
        <table id="stockdifferentlist_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                autoRowHeight:true,
                singleSelect: false,
                toolbar: '#Stockdifferentlist_dg_toolbar',
                url:'halfpart/stockdifferentlist/stockdifferentlist/datagrid',
               height:'auto',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
               
                
                     <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <th data-options="field:'stockno_s',editor:{type:'textbox'}"><spring:message code="stockingrecord.column.stockno_s" /></th>
                    <th data-options="field:'tirebarcode_s',editor:{type:'textbox'}"><spring:message code="stockdifferentlist.column.tirebarcode_s" /></th>
                    <th data-options="field:'rfidno_s',editor:{type:'textbox'}"><spring:message code="stockdifferentlist.column.rfidno_s" /></th>
                    <th data-options="field:'resultflag_s',editor:{type:'textbox'}"><spring:message code="stockdifferentlist.column.resultflag_s" /></th>
                    <th data-options="field:'instoretype_s',editor:{type:'textbox'}"><spring:message code="stockdifferentlist.column.instoretype_s" /></th>
                    <th data-options="field:'materialcode_s',editor:{type:'textbox'}"><spring:message code="stockdifferentlist.column.materialcode_s" /></th>
                    <th data-options="field:'specification_s',editor:{type:'textbox'}"><spring:message code="stockdifferentlist.column.specification_s" /></th>
                    <th data-options="field:'machinno_s',editor:{type:'textbox'}"><spring:message code="stockdifferentlist.column.machinno_s" /></th>
                    <th data-options="field:'productiondate_t',editor:{type:'textbox'}"><spring:message code="stockdifferentlist.column.productiondate_t" /></th>
                    <th data-options="field:'quantity_s',editor:{type:'textbox'}"><spring:message code="stockdifferentlist.column.quantity_s" /></th> 
                </tr>
            </thead>
        </table>
    </div>
</body>
</html>
