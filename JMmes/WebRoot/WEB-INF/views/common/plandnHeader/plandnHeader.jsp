<!-- 

    作者      :周清玉
    时间      :2018-12-12 11:55:10 
    页面名称:发货单及发货实绩查询
    文件关联:
        PlandnHeader.java
        PlandnHeaderController.java
        PlandnHeaderServiceImpl.java
        PlandnHeaderServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/meta.jsp"%>
<%@ include file="plandnHeader.js.jsp"%>
<script type="text/javascript" src="dict/253.js"></script>

<style>
	#divcss{margin:0 0 0 40%;padding:0 auto;} 
	#divcss1{margin:0 15% 0 10%;padding:0 auto;} 
	#divcss2{margin:0 15% 0 10%;padding:0 auto;} 
	#divcss3{margin:0 15% 0 10%;padding:0 auto;} 
	#divcss4{margin:0 15% 0 10%;padding:0 auto;} 
	#divcss5{margin:0 15% 0 10%;padding:0 auto;} 
</style>
<body class="easyui-layout" fit="true"> 
    <div class="easyui-tabs" fit="true" border="false" style="width:700px;height:250px">
     <!-- 销售出库 -->
      <div title="<spring:message code='tip.sales'/>" style="padding:10px">
      <div style="width:100%;height:100%">
        <div id="PlandhHeeader_dg_toolbar">
            <form id="PlandhHeeader_search_form" class="form" >
                <!-- 发货单号 -->
                <spring:message code="plandhheeader.column.snno_s" />
                <input name="filter[snno_s]" id="snno_s" type="text" like="true" style="width:14%;" class="easyui-textbox" data-options="label:''" >
                <!-- 轮胎编码 -->
                <spring:message code="actualamountitem.column.barcode_s" />
               <input name="filter[barcode_s]" id="barcode" like="true"   style="width:14%;" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 客户编码(售达方） -->
                <spring:message code="plandhheeader.column.customerid_s" />
                <input name="filter[customerid_s]" id="customerid_s" type="text" like="true" style="width:14%;" class="easyui-textbox" data-options="label:''" >
                <!-- 是否上传 -->
                <spring:message code="plandnitem.column.obj" />
                <input name="filter[dummy3_s]" id="dummy3_s" type="text" class="easyui-combobox" style="width:14%" data-options="valueField:'value',
	                                textField:'text',
	                                method:'get',
	                                editable:true,
	                                data: [{
											text: '接受',
											value: '1',
										 },{
											text: '执行',
											value: '2'
										},{
											text: '关闭',
											value: '3'
										}]" >
                </br>
                <!-- 凭证日期 -->
                <spring:message code="plandhheeader.column.docdate_s" />
                <input name="filter[start_time]" id="start_time" style="width:14%;" type="text" class="easyui-datebox" data-options="label:''" >
               	 到<input name="filter[end_time]" id="end_time" style="width:14%;" type="text" class="easyui-datebox" data-options="label:''" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            	<auth:button code="plandheaderExport1"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="exportExcel()"><spring:message code="button.export" /></a></auth:button>
	            <!--<auth:button code="sapExport"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-gen'" onclick="sapExport()"><spring:message code="button.sapExport" /></a></auth:button>-->
	            <auth:button code="productionDetail1"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-item'" onclick="productionDetail()"><spring:message code="button.productionDetail" /></a></auth:button>
	            <auth:button code="TheAccessory"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-item'" onclick="TheAccessory1()"><spring:message code="TheAccessory" /></a></auth:button>
	            <auth:button code="plandnitemColumnQty"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-item'" onclick="plandnitemColumnQty()"><spring:message code="plandnitemColumnQty" /></a></auth:button>
            </form> 
        </div>
        <table id="plandhheeader_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: true,
                toolbar: '#PlandhHeeader_dg_toolbar',
                striped:true,
                method: 'get',
                emptyMsg:'<span><spring:message code='tip.noData'/></span>',
                ">
            <thead>
                <tr>
                	<th data-options="field:'atr_key',checkbox:true"></th>
                 	<!-- 发货单号 -->
                    <th data-options="field:'snno_s',width:80,editor:{type:'textbox'}"><spring:message code="plandhheeader.column.snno_s" /></th>
                    <!-- 凭证日期 -->
                    <th data-options="field:'docdate_s',width:80,editor:{type:'textbox'}"><spring:message code="plandhheeader.column.docdate_s" /></th>
                    <!-- 客户编码(售达方） -->
                    <th data-options="field:'customerid_s',width:80,editor:{type:'textbox'}"><spring:message code="plandhheeader.column.customerid_s" /></th>
                    <!-- 客户名称(售达方） -->
                    <th data-options="field:'customename_s',width:120,editor:{type:'textbox'}"><spring:message code="customerlog.column.customename_s" /></th>
                    <!--是否上传-->
                    <th data-options="field:'obj',width:60,editor:{type:'textbox'}"><spring:message code="plandnitem.column.obj" /></th>
                    <!--预计发货数量(总)-->
                    <th data-options="field:'sumqty_s',width:70,editor:{type:'textbox'}"><spring:message code="plandnitem.column.sumqty_d" /></th>
                    <!--实际发货数量(总)-->
                    <th data-options="field:'realityqty_s',width:70,editor:{type:'textbox'}"><spring:message code="plandnitem.column.realityqty_d" /></th>
                    <!--发货差异数量(总)-->
                    <th data-options="field:'differenceqty_s',width:70,editor:{type:'textbox'}"><spring:message code="plandnitem.column.differenceqty_d" /></th>
                </tr>
            </thead>
        </table>
      </div>
      
      
      <div id="productionDetail" class="easyui-window" title="<spring:message code="button.productionDetail" />" data-options="modal:true,closed:true,iconCls:'icon-log',tools:'#tt'" style="width:90%;height:90%;padding:10px;">
       <div id="PlandhHeeader_dg_toolbarTwo">
            <form id="PlandhHeeader_search_formTwo" class="form" >
                <!-- 发货单号 -->
                <spring:message code="plandhheeader.column.snno_s" />
                <input name="filter[snno_s]" id="snno_sTwo" like="true" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 轮胎编码-->
                <spring:message code="actualamountitem.column.barcode_s" />
                <input name="filter[barcode_s]" id="barcode_s" like="true" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 物料编码-->
                <spring:message code="plandnitem.column.materialcode_s" />
                <input name="filter[materialcode_s]" id="materialcode_sTwo" like="true" type="text" like="true" class="easyui-textbox" data-options="label:''" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filterTwo()"><spring:message code="button.search" /></a>
                <auth:button code="CP_CKCX_RMOVE"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
                <auth:button code="CP_CKCX_SAVE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
                <auth:button code="CP_CKCX_CANCEL"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            </form> 
        </div>
        <table id="plandhheeader_dgTwo" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                singleSelect: false,
                toolbar: '#PlandhHeeader_dg_toolbarTwo',
                striped:true,
                method: 'get',
                emptyMsg:'<span><spring:message code='tip.noData'/></span>',
                rowStyler:setRowBgColor
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 发货单号 -->
                    <th data-options="field:'snno_s',width:80,editor:{type:'textbox'}"><spring:message code="actualamountitem.column.snno_s" /></th>
                    <!-- 轮胎条码 -->
                    <th data-options="field:'barcode_s',width:80,editor:{type:'textbox'}"><spring:message code="actualamountitem.column.barcode_s" /></th>
                    <!-- 物料号 -->
                    <th data-options="field:'materialcode_s',width:80,editor:{type:'textbox'}"><spring:message code="actualamountitem.column.materialcode_s" /></th>
                    <!-- 规格/花纹 -->
                    <th data-options="field:'materialdesc_s',width:80,editor:{type:'textbox'}"><spring:message code="visualmchecksumprint.column.materialspec_s" /></th>
                     <!-- 外观质量等级 -->
                    <th data-options="field:'gradecode_s',width:80,formatter:codeFormatter,editor:{type:'combotree',options:{
				                    			method:'get',
				                                url:'dict/code/253',
				                    			required:true}}"><spring:message code="dailyreportoffinishedproductqualityinspection.column.visualgradecode_s" /></th>
                    <!-- 生产时间 -->
                    <th data-options="field:'dynamicbalancepasstime_t',width:80,editor:{type:'textbox'}"><spring:message code="workorderresultprint.column.product_date_s" /></th>
                    <!-- 发货人 -->
                    <th data-options="field:'createdby_s',width:50,editor:{type:'textbox'}"><spring:message code="actualamountitem.column.created_by_s" /></th>
                    <!-- 发货时间 -->
                    <th data-options="field:'creation_time_date',width:110,editor:{type:'textbox'}"><spring:message code="actualamountitem.column.created_time_t" /></th>
                </tr>
            </thead>
        </table>
      </div> 
     </div> 
     <!-- 调拨出库 -->
     <div title="<spring:message code='tip.allot'/>" style="padding:10px">
     <div style="width:100%;height:100%">
        <div id="InAllocatingOutbound_dg_toolbar">
            <form id="InAllocatingOutbound_search_form" class="form" >
                <!-- 发货单号 -->
                <spring:message code="inAllocatingOutbound.column.snno_s" />
                <input name="filter[reserno_s]" like='true' id="reserno_s" type="text"  class="easyui-textbox" data-options="label:''" >
                <!-- 轮胎编码 -->
                <spring:message code="actualamountitem.column.barcode_s" />
                <input name="filter[barcode_s]" id="barcode" like="true"   style="width:14%;" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 凭证日期 -->
                <spring:message code="plandhheeader.column.docdate_s" />
                <input name="filter[start_time]" id="start_timeTwo" style="width:14%;" type="text" class="easyui-datebox" data-options="label:''" >
               	 到<input name="filter[end_time]" id="end_timeTwo" style="width:14%;" type="text" class="easyui-datebox" data-options="label:''" >
                <!-- 发出工厂 -->
                <spring:message code="inAllocatingOutbound.column.plantfrom_s" />
                <input name="filter[plantfrom_s]" id="plantfrom_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 接收工厂 -->
                <br><spring:message code="inAllocatingOutbound.column.plantto_s" />
                <input name="filter[plantto_s]" id="plantto_s" type="text"  class="easyui-textbox" data-options="label:''" >
                   
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filterFour()"><spring:message code="button.search" /></a>
				<auth:button code="plandheaderExport2"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="exportExcel2()"><spring:message code="button.export" /></a></auth:button>
           		<auth:button code="productionDetail2"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-item'" onclick="productionDetail2()"><spring:message code="button.productionDetail" /></a></auth:button>
          		<auth:button code="TheAccessory"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-item'" onclick="TheAccessory2()"><spring:message code="TheAccessory" /></a></auth:button>
          		<auth:button code="inAllocatingColumnQty"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-item'" onclick="inAllocatingColumnQty()"><spring:message code="inAllocatingColumnQty" /></a></auth:button>
           </form> 
        </div>
        <table id="inAllocatingOutbound_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: true,
                toolbar: '#InAllocatingOutbound_dg_toolbar',
                striped:true,
                method: 'get',
                emptyMsg:'<span><spring:message code='tip.noData'/></span>',
                ">
            <thead>
                <tr>
                	<th data-options="field:'atr_key',checkbox:true"></th>
                	<!-- 预留单号-->
                    <th data-options="field:'reserno_s',width:80,editor:{type:'textbox'}"><spring:message code="inAllocatingOutbound.column.reserno_s" /></th>
                 	<!-- 订单号 -->
                    <th data-options="field:'order_s',width:80,editor:{type:'textbox'}"><spring:message code="inAllocatingOutbound.column.order_s" /></th>
                    <!-- 需求日期-->
                    <th data-options="field:'demondsdate_s',width:80,editor:{type:'textbox'}"><spring:message code="inAllocatingOutbound.column.demondsdate_s" /></th>
                    <!-- 需求部门-->
                    <th data-options="field:'department_s',width:80,editor:{type:'textbox'}"><spring:message code="inAllocatingOutbound.column.department_s" /></th>
                    <!-- 状态-->
                    <th data-options="field:'isdeliver_s',width:80,editor:{type:'textbox'}"><spring:message code="inAllocatingOutbound.column.isdeliver_s" /></th>
                    <!-- 收货库存地点-->
                	<th data-options="field:'storlocto_s',width:80,editor:{type:'textbox'}"><spring:message code="inAllocatingOutbound.column.storlocto_s" /></th>
                    <!-- 发出工厂 -->
                    <th data-options="field:'plantfrom_s',width:80,editor:{type:'textbox'}"><spring:message code="inAllocatingOutbound.column.plantfrom_s" /></th>
                    <!-- 接收工厂 -->
                    <th data-options="field:'plantto_s',width:80,editor:{type:'textbox'}"><spring:message code="inAllocatingOutbound.column.plantto_s" /></th>
                    <!-- 预计调拨数量(总)-->
                    <th data-options="field:'qty_s',width:80,editor:{type:'textbox'}"><spring:message code="inAllocatingOutbound.column.sumqty_d" /></th>
                    <!--实际调拨数量(总)-->
                    <th data-options="field:'realityqty_s',width:80,editor:{type:'textbox'}"><spring:message code="inAllocatingOutbound.column.realityqty_d" /></th>
                    <!--调拨差异数量(总)-->
                    <th data-options="field:'differenceqty_s',width:80,editor:{type:'textbox'}"><spring:message code="inAllocatingOutbound.column.differenceqty_d" /></th>
                </tr>
            </thead>
        </table>
      </div>
     
      <div id="productionDetail2" class="easyui-window" title="<spring:message code="button.productionDetail" />" data-options="modal:true,closed:true,iconCls:'icon-log',tools:'#tt'" style="width:90%;height:90%;padding:10px;">
       <div id="InAllocatingOutbound_dg_toolbarTwo">
           <form id="InAllocatingOutbound_search_formTwo" class="form" >
                <!-- 发货单号 -->
                <spring:message code="plandhheeader.column.snno_s" />
                <input name="filter[snno_s]" id="snno_sThree" like="true" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 轮胎编码-->
                <spring:message code="actualamountitem.column.barcode_s" />
                <input name="filter[barcode_s]" id="barcode_sThree" like="true" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 物料编码-->
                <spring:message code="plandnitem.column.materialcode_s" />
                <input name="filter[materialcode_s]" id="materialcode_sThree" like="true" type="text" like="true" class="easyui-textbox" data-options="label:''" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filterFive()"><spring:message code="button.search" /></a>
                <auth:button code="CP_CKCX_RMOVE"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove1()"><spring:message code="button.delete" /></a></auth:button>
                <auth:button code="CP_CKCX_SAVE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save1()"><spring:message code="button.save" /></a></auth:button>
                <auth:button code="CP_CKCX_CANCEL"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel1()"><spring:message code="button.cancel" /></a>  </auth:button>
            </form> 
        </div>
        <table id="inAllocatingOutbound_dgTwo" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                singleSelect: false,
                toolbar: '#InAllocatingOutbound_dg_toolbarTwo',
                striped:true,
                method: 'get',
                emptyMsg:'<span><spring:message code='tip.noData'/></span>',
                rowStyler:setRowBgColor
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 发货单号 -->
                    <th data-options="field:'snno_s',width:80,editor:{type:'textbox'}"><spring:message code="actualamountitem.column.snno_s" /></th>
                    <!-- 轮胎条码 -->
                    <th data-options="field:'barcode_s',width:80,editor:{type:'textbox'}"><spring:message code="actualamountitem.column.barcode_s" /></th>
                    <!-- 物料号 -->
                    <th data-options="field:'materialcode_s',width:80,editor:{type:'textbox'}"><spring:message code="actualamountitem.column.materialcode_s" /></th>
                    <!-- 规格/花纹 -->
                    <th data-options="field:'materialdesc_s',width:80,editor:{type:'textbox'}"><spring:message code="visualmchecksumprint.column.materialspec_s" /></th>
                    <!-- 生产时间 -->
                    <th data-options="field:'dynamicbalancepasstime_t',width:80,editor:{type:'textbox'}"><spring:message code="workorderresultprint.column.product_date_s" /></th>
                    <!-- 发货人 -->
                    <th data-options="field:'createdby_s',width:50,editor:{type:'textbox'}"><spring:message code="actualamountitem.column.created_by_s" /></th>
                    <!-- 发货时间 -->
                    <th data-options="field:'creation_time_date',width:110,editor:{type:'textbox'}"><spring:message code="actualamountitem.column.created_time_t" /></th>
                </tr>
            </thead>
        </table>	
      </div>
      <!-- 随车单 -->
      <div id="TheAccessory" class="easyui-window" title="<spring:message code="TheAccessory" />" data-options="modal:true,closed:true,iconCls:'icon-log'" style="width:90%;height:90%;padding:10px;">
	      <div id="TheAccessory_toolbarThree">
	           <form id="TheAccessoryForm" class="form">
	                <!-- 发货单号 -->
	                <input name="filter[snno_s]" type="hidden" id="theAccessorySnno_s"  class="easyui-textbox" data-options="label:''" >
	            </form> 
	      </div>    
          <div id="TheAccessoryTwo">
       		  <table>
       			 <tr>
       				<td>
       					 <spen  id="inputTest"></spen>
       					 <a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="TheAccessoryExportExcel()"><spring:message code="button.export" /></a>
       				</td>
       			 </tr>
       			 <tr><td>-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</td></tr>
       			 <tr><td><div id="divcss"><em>山东玲珑轮胎股份有限公司客户随车单</em></div></td></tr>
       			  <tr><td><spen id="divcss1">订单单别:8003</spen><spen id="divcss2">出库日期:</spen><spen id="divcss3">车辆:</spen></td></tr>
       			 <tr><td><spen id="divcss4"></spen><spen id="divcss5"></spen></td></tr>
       			 <tr><td>-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</td></tr>
       		  </table>
       		 <!-- <table id="TheAccessoryTreeID" style="height:900px" title=<spring:message code="TheAccessory" /> class="easyui-treegrid">
			</table> -->
          </div>
         <div id="TheAccessoryThree" style="height:100%;width:1000px"></div>
      </div>
      <!-- 销售行项目 -->
      <div id="PlandhHeeaderLineitem" class="easyui-window" title="<spring:message code="PlandhHeeaderLineitem" />" data-options="modal:true,closed:true,iconCls:'icon-log'" style="width:90%;height:90%;padding:10px;">
       <div style="width:100%;height:100%">
	        <div id="PlandhHeeader_dg_toolbarThree">
	           <form id="PlandhHeeader_search_formThree" class="form">
	                <!-- 发货单号 -->
	                <input name="filter[snno_s]" id="snno_s1" type="hidden" like="true" class="easyui-textbox" data-options="label:''" >
	                <!-- 物料编码-->
	                <spring:message code="plandnitem.column.materialcode_s" />
	                <input name="filter[materialcode_s]" id="srflag_s" type="text" like="true" class="easyui-textbox" data-options="label:''" >
	                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filterThree()"><spring:message code="button.search" /></a>
	            </form> 
	        </div>    
	        <table id="plandhheeader_dgThree" class="easyui-datagrid" style="width:100%"
	            data-options="  
	                fit:true,
	                fitColumns:true,
	                pagination:true,
	                rownumbers: true,
	                singleSelect: false,
	                toolbar: '#PlandhHeeader_dg_toolbarThree',
	                striped:true,
	                method: 'get',
	                emptyMsg:'<span><spring:message code='tip.noData'/></span>'
	                ">
            	<thead>
	                <tr>
	                    <th data-options="field:'atr_key',checkbox:true"></th>
	                    <!--物料号-->
	                    <th data-options="field:'materialcode_s',width:80,editor:{type:'textbox'}"><spring:message code="plandnitem.column.materialcode_s" /></th>
	                    <!--物料规格-->
	                    <th data-options="field:'materialdesc_s',width:80,editor:{type:'textbox'}"><spring:message code="weradfa.column.material_code_s" /></th>
	                    <!--预计发货数量-->
	                    <th data-options="field:'qty_s',width:80,editor:{type:'textbox'}"><spring:message code="plandnitem.column.sumqty_d" /></th>
	                    <!--实际发货数量-->
	                    <th data-options="field:'realityqty_s',width:80,editor:{type:'textbox'}"><spring:message code="plandnitem.column.realityqty_d" /></th>
	                    <!--发货差异数量-->
	                    <th data-options="field:'differenceqty_s',width:70,editor:{type:'textbox'}"><spring:message code="plandnitem.column.differenceqty_d" /></th>
	                    <!--质量等级-->
	                	<th data-options="field:'batch_s',width:80"><spring:message code="plandnitem.column.batch_s" /></th>
	                </tr>
            	</thead>
        	</table>
      	</div> 
      </div>
      <!-- 调拨行项目 -->
      <div id="InAllocatingOutLineitem" class="easyui-window" title="<spring:message code="InAllocatingOutLineitem" />" data-options="modal:true,closed:true,iconCls:'icon-log'" style="width:90%;height:90%;padding:10px;">
	      	 <div style="width:100%;height:100%">
		         <div id="InAllocatingOutbound_dg_toolbarThree">
		           <form id="InAllocatingOutbound_search_formThree" class="form">
		                <!-- 发货单号 -->
		                <input name="filter[reserno_s]" id="reserno_s2" type="hidden"  class="easyui-textbox" data-options="label:''" >
		                <!-- 物料编码-->
		                <spring:message code="inAllocatingOutbound.column.matcode_s" />
		                <input name="filter[matcode_s]" id="matcode_s" type="text"  class="easyui-textbox" data-options="label:''" >
		                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filterSix()"><spring:message code="button.search" /></a>
		            </form> 
	          </div>    
		      <table id="inAllocatingOutbound_dgThree" class="easyui-datagrid" style="width:100%"
		            data-options="  
		                fit:true,
		                fitColumns:true,
		                pagination:true,
		                rownumbers: true,
		                singleSelect: false,
		                toolbar: '#InAllocatingOutbound_dg_toolbarThree',
		                striped:true,
		                method: 'get',
		                emptyMsg:'<span><spring:message code='tip.noData'/></span>'
		                ">
		            <thead>
		                <tr>
		                    <th data-options="field:'atr_key',checkbox:true"></th>
		                    <!--预留单行号-->
		                    <th data-options="field:'reseritem_s',width:80,editor:{type:'textbox'}"><spring:message code="inAllocatingOutbound.column.reseritem_s" /></th>
		                    <!--物料号-->
		                    <th data-options="field:'matcode_s',width:80,editor:{type:'textbox'}"><spring:message code="inAllocatingOutbound.column.matcode_s" /></th>
		                    <!--物料规格-->
		                    <th data-options="field:'materialdesc_s',width:80,editor:{type:'textbox'}"><spring:message code="weradfa.column.material_code_s" /></th>
		                    <!--预计调拨数量-->
		                    <th data-options="field:'qty_s',width:80,editor:{type:'textbox'}"><spring:message code="inAllocatingOutbound.column.sumqty_d" /></th>
		                    <!--实际调拨数量-->
		                    <th data-options="field:'realityqty_s',width:80,editor:{type:'textbox'}"><spring:message code="inAllocatingOutbound.column.realityqty_d" /></th>
		                    <!--调拨差异数量-->
		                    <th data-options="field:'differenceqty_s',width:80,editor:{type:'textbox'}"><spring:message code="inAllocatingOutbound.column.differenceqty_d" /></th>
		                </tr>
		            </thead>
		      </table>
	      </div>
      </div>
      <!-- 销售发货数量 -->
      <div id="plandnitemColumnQty" class="easyui-window" title="<spring:message code="plandnitemColumnQty" />" data-options="modal:true,closed:true,iconCls:'icon-log'" style="width:90%;height:90%;padding:10px;">
	      	 <div style="width:100%;height:100%">
		         <div id="plandnitemColumnQty_dg_toolbar">
		           <form id="plandnitemColumnQty_search_form" class="form">
		           <spring:message code="ffd.column.plant_s" />
		           <input name="filter[plant_s]"  class="easyui-combobox" style="width:14%" data-options="valueField:'value',
	                                textField:'text',
	                                method:'get',
	                                editable:true,
	                                data: [{
											text: '半钢',
											value: '2',
											selected:true
										 },{
											text: '全钢',
											value: '1'
										}]" >
		                <spring:message code="plandhheeader.column.docdate_s" />
		                <input name="filter[start_time]" id="start_time_Qty" style="width:14%;" type="text" class="easyui-datebox" data-options="label:''" >
		               	 到<input name="filter[end_time]" id="end_time_Qty" style="width:14%;" type="text" class="easyui-datebox" data-options="label:''" >
		                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="plandnitemColumnQtyFilter()"><spring:message code="button.search" /></a>
		            </form> 
	          </div>    
		      <table id="plandnitemColumnQty_dg" class="easyui-datagrid" style="width:100%"
		            data-options="  
		                fit:true,
		                fitColumns:true,
		                pagination:true,
		                rownumbers: true,
		                singleSelect: false,
		                toolbar: '#plandnitemColumnQty_dg_toolbar',
		                striped:true,
		                method: 'get',
		                emptyMsg:'<span><spring:message code='tip.noData'/></span>'
		                ">
		            <thead>
		                <tr>
		                    <!--预计发货数量(总)-->
		                    <th data-options="field:'QTY_S',width:100,editor:{type:'textbox'}"><spring:message code="plandnitem.column.sumqty_d" /></th>
		                    <!--实际发货数量(总)-->
		                    <th data-options="field:'QUANTITY',width:100,editor:{type:'textbox'}"><spring:message code="plandnitem.column.realityqty_d" /></th>
		                    <!--发货差异数量(总)-->
		                    <th data-options="field:'DIFFERENCE',width:100,editor:{type:'textbox'}"><spring:message code="plandnitem.column.differenceqty_d" /></th>
		                </tr>
		            </thead>
		      </table>
	      </div>
      </div>
       <!-- 调拨发货数量 -->
      <div id="inAllocatingColumnQty" class="easyui-window" title="<spring:message code="inAllocatingColumnQty" />" data-options="modal:true,closed:true,iconCls:'icon-log'" style="width:90%;height:90%;padding:10px;">
	      	 <div style="width:100%;height:100%">
		         <div id="inAllocatingColumnQty_dg_toolbar">
		           <form id="inAllocatingColumnQty_search_form" class="form">
		           <spring:message code="ffd.column.plant_s" />
		           <input name="filter[plant_s]"  class="easyui-combobox" style="width:14%" data-options="valueField:'value',
	                                textField:'text',
	                                method:'get',
	                                editable:true,
	                                data: [{
											text: '半钢',
											value: '2',
											selected:true
										 },{
											text: '全钢',
											value: '1'
										}]" >
		                <spring:message code="plandhheeader.column.docdate_s" />
		                <input name="filter[start_time]" id="start_time_Qty1" style="width:14%;" type="text" class="easyui-datebox" data-options="label:''" >
		               	 到<input name="filter[end_time]" id="end_time_Qty1" style="width:14%;" type="text" class="easyui-datebox" data-options="label:''" >
		                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="inAllocatingColumnQtyFilter()"><spring:message code="button.search" /></a>
		            </form> 
	          </div>    
		      <table id="inAllocatingColumnQty_dg" class="easyui-datagrid" style="width:100%"
		            data-options="  
		                fit:true,
		                fitColumns:true,
		                pagination:true,
		                rownumbers: true,
		                singleSelect: false,
		                toolbar: '#inAllocatingColumnQty_dg_toolbar',
		                striped:true,
		                method: 'get',
		                emptyMsg:'<span><spring:message code='tip.noData'/></span>'
		                ">
		            <thead>
		               <tr>
		                    <!--预计发货数量(总)-->
		                    <th data-options="field:'QTY_S',width:100,editor:{type:'textbox'}"><spring:message code="plandnitem.column.sumqty_d" /></th>
		                    <!--实际发货数量(总)-->
		                    <th data-options="field:'QUANTITY',width:100,editor:{type:'textbox'}"><spring:message code="plandnitem.column.realityqty_d" /></th>
		                    <!--发货差异数量(总)-->
		                    <th data-options="field:'DIFFERENCE',width:100,editor:{type:'textbox'}"><spring:message code="plandnitem.column.differenceqty_d" /></th>
		                </tr>
		            </thead>
		      </table>
	      </div>
       </div>
     </div>
    </div> 
    
    
</body>
</html>
