<!-- 

    作者      :栾和源
    时间      :2020-08-04 09:34:26 
    页面名称:密炼胶料产出实绩表
    文件关联:
        Drprod.java
        DrprodController.java
        DrprodServiceImpl.java
        DrprodServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="drprod.js.jsp"%>
<script type="text/javascript" src="dict/074,068,069,301,302,068,062,001.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="Drprod_dg_toolbar">
            <form id="Drprod_search_form" class="form" >
           		 <!-- 班次 -->
           		 <spring:message code="drprod.column.shift_code_s" />
                <input name="filter[shift_code_s]" id="shift_code_s" style="width:110px" type="text" class="easyui-combotree" data-options="label:'',
                			required:false,
				            panelHeight:200,
				            url:'dict/code/302',
				            method:'get'" > &nbsp;&nbsp;
                <!-- 机台编码：设备类型（2 位）+流水号（3 位） 例如 01001 -->
                <spring:message  code="drprod.column.equip_code" />
                <input name="filter[equip_code_s]" id="equip_code_s" style="width:110px" type="text" class="easyui-combobox" data-options="label:'',
                				 data:equiplist,
	         		  			 panelHeight:150,
	         		  			 editable:true,
	           		  			 valueField:'p_line_name',
			          		  	 textField:'description',
			                  	 selectOnNavigation:false,
			           		  	 limitToList:true,
			          		  	 filter:searchProductionLine,
			           		  	onChange:filter" >&nbsp;&nbsp;
			     <!-- 下发标识 0-未下发、1-已下发 -->
                  <spring:message code="drprod.column.spare5" />
               	  &nbsp;<input name="filter[spare5_s]" id="spare5_s" type="text" style="width:110px" class="easyui-combobox" data-options="label:'',
               	 			required:false,
				            panelHeight:200,
               	 			data:[{value:'0',text:'未下发'},
		                      	  {value:'1',text:'已下发'},
		                      	  {value:'2',text:'重新下发'}],
               	 			method: 'get'
               	 				" >
                <!-- 工单号 -->
                 &nbsp;&nbsp;<spring:message code="drprod.column.wo_no" />
                 &nbsp;<input name="filter[wo_no_s]" id="wo_no_s" style="width:110px" type="text" class="easyui-textbox" data-options="label:''" >
                  <!-- 批次信息，长度19位： 母胶批次号 -->
                  &nbsp;&nbsp;<spring:message code="drprod.column.lot_no" />
                  &nbsp;<input name="filter[lot_no_s]" id="lot_no_s" style="width:110px" type="text" class="easyui-textbox" data-options="label:''" >
                 <!-- 物料编码 -->
                  &nbsp;&nbsp;<spring:message code="drprod.column.material_code_s" />
                  &nbsp;<input name="filter[material_code_s]" id="material_code_s" style="width:110px" type="text" class="easyui-textbox" data-options="label:''" >
                    <!-- 载具条码 -->
                  &nbsp;&nbsp;<spring:message code="drprod.column.carrier_code" />
                  &nbsp;<input name="filter[carrier_code_s]" id="carrier_code_s" style="width:110px" type="text" class="easyui-textbox" data-options="label:''" >
                  <!-- 是否绑定产出车次：0-否、1-是 -->
                  &nbsp;&nbsp;<spring:message code="drprod.column.is_bindtrain" />
               	  &nbsp;<input name="filter[is_bindtrain_s]" id="is_bindtrain_s" type="text" style="width:110px" class="easyui-combobox" data-options="label:'',
               	 		required:false,
				            panelHeight:200,
               	 		data:[{value:'0',text:'否'},
		                      {value:'1',text:'是'}],
               	 		method: 'get'
               	 		" >&nbsp;&nbsp;
                <!-- 产出时间 -->
                <spring:message code="drprod.column.product_time_t" />&nbsp;:&nbsp;<input name="filter[begintime]" editable="true" id="begin_created_time" type="text" class="easyui-datetimebox" style="width:160px" data-options="label:''">
				&nbsp;到&nbsp; <input name="filter[endtime]" editable="true" id="end_created_time" type="text" class="easyui-datetimebox" style="width:160px" data-options="label:''">&nbsp;&nbsp;&nbsp;
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
                &nbsp;&nbsp; 
                 <auth:button code="drprod.returnissued"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="downward()"><spring:message code="button.returnissued" /></a></auth:button>
            </form> 
           
           
        </div>
        <table id="drprod_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#Drprod_dg_toolbar',
                url: '',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 生产日期 -->
                    <th data-options="field:'prod_date_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprod.column.prod_date_s" /></th>
                    <!-- 班次 -->
                    <th data-options="field:'shift_code_s',width:'80px',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="drprod.column.shift_code_s" /></th>
                    <!-- 机台名称 -->
                    <th data-options="field:'equip_name_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprod.column.equip_code" /></th>
					<!-- 密炼工单跟踪表，工单号，外键，MX_PP_WO_EDIT.WO_NO -->
                    <th data-options="field:'wo_no_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprod.column.wo_no" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprod.column.material_code_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'material_name_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprod.column.material_name_s" /></th>
                    <!-- 批次信息，长度19位： 母胶批次号：固定字符+工厂+生产日期+班次+机台+计划号+开始车次+车数 例如 M919070110100100015 终炼胶批次号：固定字符+工厂+生产日期+班次+机台+计划号+开始车次+车数 例如 F919070110100100015 -->
                    <th data-options="field:'lot_no_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprod.column.lot_no" /></th>
                    <!-- 设定重量 -->
                    <th data-options="field:'set_weight_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprod.column.set_weight_s" /></th>
                    <!-- 实际重量 -->
                    <th data-options="field:'real_weight_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprod.column.real_weight_s" /></th>
                    <!-- 载具条码：M + 8 位流水号 -->
                    <th data-options="field:'carrier_code_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprod.column.carrier_code" /></th>
					<!-- 质量备注 -->
                    <th data-options="field:'qc_mark_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprod.column.qc_mark_s" /></th>
                    <!-- RFID读取错误类型： 074001-离线载具条码未读到 074002-在线载具条码未读到 074003-载具条码MES不存在 074004-载具条码MES类型错误 074005-载具条码MES状态错误 074006-其它 -->
                    <th data-options="field:'rfid_etype_s',width:'100px',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="drprod.column.rfid_etype" /></th>
                    <!-- RFID读取是否成功：0-失败，1-成功 -->
                    <th data-options="field:'rfid_isok_s',width:'80px',formatter:rfidisokFormatter,editor:{type:'textbox'}"><spring:message code="drprod.column.rfid_isok" /></th>
                    <!-- 架子数 -->
                    <th data-options="field:'shelves_num_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprod.column.shelves_num_s" /></th>
                    <!-- 开始车次 -->
                    <th data-options="field:'begin_train_num_i',width:'80px',editor:{type:'textbox'}"><spring:message code="drprod.column.begin_train_num_i" /></th>
                    <!-- 结束车次 -->
                    <th data-options="field:'end_train_num_i',width:'80px',editor:{type:'textbox'}"><spring:message code="drprod.column.end_train_num_i" /></th>
                    <!-- 快检开始车次 -->
                    <th data-options="field:'set_begin_train_num_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprod.column.set_begin_train_num_s" /></th>
                    <!-- 快检结束车次 -->
                    <th data-options="field:'set_end_train_num_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprod.column.set_end_train_num_s" /></th>
                    <!-- 是否绑定产出车次：0-否、1-是 -->
                    <th data-options="field:'is_bindtrain_s',width:'80px',formatter:isbindtrainFormatter,editor:{type:'textbox'}"><spring:message code="drprod.column.is_bindtrain" /></th>
                    <!-- 金属探测数 -->
                    <th data-options="field:'metal_num_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprod.column.metal_num_s" /></th>
                    <!-- 配套 -->
                    <th data-options="field:'matchingcode_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprod.column.matchingcode_s" /></th>
                    <!-- 切胶方式：1-手动切胶、2-自动切胶 -->
                    <th data-options="field:'cut_type_s',width:'80px',formatter:cuttypeFormatter,editor:{type:'textbox'}"><spring:message code="drprod.column.cut_type" /></th>
                    <!-- 产出方式： 068001-手动产出（正常计划） 068002-自动产出（正常计划） 068003-手动产出（离线计划） 068004-自动产出（离线计划 -->
                    <th data-options="field:'prod_type_s',width:'100px',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="drprod.column.prod_type" /></th>
                    <!-- 打印方式： 069001-未打印 069002-已打印（手动） 069003-已打印（自动） 069004-补充打印 -->
                    <th data-options="field:'print_type_s',width:'80px',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="drprod.column.print_type" /></th>
                    <!-- 检验标识：0-否、1-是 -->
                    <th data-options="field:'is_check_s',width:'80px',formatter:ischeckFormatter,editor:{type:'textbox'}"><spring:message code="drprod.column.is_check" /></th>
                    <!-- 备用字段5：下发标识：0-未下发、1-已下发 -->
                    <th data-options="field:'spare5_s',width:'80px',formatter:issuedFormatter,editor:{type:'textbox'}"><spring:message code="drprod.column.spare5" /></th>
                    <!-- 自检标识：0-合格、1-不合格 -->
                    <th data-options="field:'is_selfcheck_s',formatter:isselfcheckFormatter,width:'80px',editor:{type:'textbox'}"><spring:message code="drprod.column.is_selfcheck" /></th>
				    <!-- 产出时间 -->
                    <th data-options="field:'product_time_t',width:'80px',width:'80px',editor:{type:'textbox'}"><spring:message code="drprod.column.product_time_t" /></th>               
                    <!-- 物料过期日期 -->
                    <th data-options="field:'expiry_date_t',width:'80px',editor:{type:'textbox'}"><spring:message code="drprod.column.expiry_date_t" /></th>
                    <!-- 主机手 -->
                    <th data-options="field:'master_by_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprod.column.master_by_s" /></th>
                    <!-- 接片人 -->
                    <th data-options="field:'splice_by_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprod.column.splice_by_s" /></th>
                    <!-- 误差值 -->
                    <th data-options="field:'cutpoly_weight_d',width:'80px',editor:{type:'textbox'}"><spring:message code="drprod.column.cutpoly_weight_d" /></th>
                    <!-- 产出工位（胶架移除工位）：值域 0、1、2，0-摆片，1、2-卷曲位 -->
                    <th data-options="field:'prod_location_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprod.column.prod_location" /></th>
                    <!-- 质量备注 -->
                    <th data-options="field:'qc_mark_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprod.column.qc_mark_s" /></th>
                    <!-- 密炼配方BOM版本 -->
                    <th data-options="field:'recipe_bom_version_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprod.column.recipe_bom_version_s" /></th>
                    <!-- 密炼生成配方编号，外键，INT_PLM_MIXRECIPE_EDIT.RECIPE_CODE -->
                    <th data-options="field:'recipe_code_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprod.column.recipe_code" /></th>
                    <!-- RFID读取备注 -->
                    <th data-options="field:'rfid_remark_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprod.column.rfid_remark_s" /></th>
                    <!-- 提前量 -->
                    <th data-options="field:'slowdown_weight_d',width:'80px',editor:{type:'textbox'}"><spring:message code="drprod.column.slowdown_weight_d" /></th>
                    <!-- 备用字段10：下发时间 -->
                    <th data-options="field:'spare10_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprod.column.spare10" /></th>
                    <!-- 备用字段1：物料最小存放时间或允许出库时间 -->
                    <th data-options="field:'spare1_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprod.column.spare1" /></th>
                    <!-- 备用字段2：配方名称 -->
                    <th data-options="field:'spare2_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprod.column.spare2" /></th>
                    <!-- 备用字段3：最小存放时间(h) -->
                    <th data-options="field:'spare3_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprod.column.spare3" /></th>
                    <!-- 备用字段4：最长存放时间(h) -->
                    <th data-options="field:'spare4_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprod.column.spare4" /></th>
                    <!-- 备用字段6：生胶（车次消耗原材料胶料），名称+批次生产日期 -->
                    <th data-options="field:'spare6_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprod.column.spare6" /></th>
                    <!-- 备用字段7：塑解剂（车次消耗原材料胶料），名称+重量 -->
                    <th data-options="field:'spare7_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprod.column.spare7" /></th>
                    <!-- 备用字段8：下发人 -->
                    <th data-options="field:'spare8_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprod.column.spare8" /></th>
                    <!-- 状态编码： 001001-合格、 001002-不合格、 001003-待检状态 (MES发起的调拨只能调合格的）、 001004-封锁（MES不能调拨出库） -->
                    <th data-options="field:'state_code_s',width:'80px',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="drprod.column.state_code" /></th>
                    <!-- 库位编号 -->
                    <th data-options="field:'store_code_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprod.column.store_code_s" /></th>
                    <!-- 库区编码：062001-胶料库、062002-线边库、062003-历史库 -->
                    <th data-options="field:'store_type_s',width:'80px',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="drprod.column.store_type" /></th>
                    <!-- 托盘编号 -->
                    <th data-options="field:'tray_code_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprod.column.tray_code_s" /></th>
                    <!-- 立库编号（1、2、3、4、5...） -->
                    <th data-options="field:'warehouseid_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprod.column.warehouseid" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changed_by_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprod.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',width:'80px',editor:{type:'textbox'}"><spring:message code="drprod.column.changed_time_t" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprod.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',width:'80px',editor:{type:'textbox'}"><spring:message code="drprod.column.created_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
    <div data-options="region:'south',split:true" style="height:200px;">
    	<div class="easyui-tabs" id="content_tab" data-options="fit:true,tools:'#tab-tools'">   
  	    	<div title="胶料车次产出实绩" style="padding:10px">
  	    	<form id="Drprodimplement_search_form" class="form" style="display:none">
  	    		<!-- 载具条码 -->
                <input name="filter[carrier_code_s]" id="carrier" type="text" class="easyui-textbox" data-options="label:''" >
  	    	</form> 
         		<table id="drprodimplement_dg" class="easyui-datagrid" style="width:100%"
           				 data-options="  
						   				fit:true,
						                fitColumns:false,
						                pagination:true,
						                rownumbers: true,						         
						                singleSelect: true,
						                toolbar: '#Drprodimplement_dg_toolbar',
						                striped:true,
						                url: 'mix/productionManagement/drprodimplement/datagrid',
						                emptyMsg: '<span><spring:message code='tip.noData'/></span>',
						                method: 'get'                 
					">
           		 <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 生产日期 -->
                    <th data-options="field:'prod_date_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprodimplement.column.prod_date_s" /></th>
                    <!-- 班次 -->
                    <th data-options="field:'shift_code_s',width:'80px',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="drprodimplement.column.shift_code_s" /></th>
                    <!-- 机台名称 -->
                    <th data-options="field:'equip_name_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprodimplement.column.equip_name_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprodimplement.column.material_code_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'material_name_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprodimplement.column.material_name_s" /></th>
                    <!-- 胶料车次批次号，长度19位： -->
                    <th data-options="field:'lot_no_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprodimplement.column.lot_no" /></th>
                    <!-- 备用字段4：下发标识：0-未下发、1-已下发 -->
                    <th data-options="field:'spare4_s',width:'80px',formatter:issuedFormatter,editor:{type:'textbox'}"><spring:message code="drprodimplement.column.spare4" /></th>
                    <!-- 开始时间 -->
                    <th data-options="field:'start_datetime_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprodimplement.column.start_datetime_s" /></th>
                    <!-- 炼胶时间 -->
                    <th data-options="field:'mixtime_i',width:'80px',editor:{type:'textbox'}"><spring:message code="drprodimplement.column.mixtime_i" /></th>
                    <!-- 产出时间 -->
                    <th data-options="field:'product_time_t',width:'80px',editor:{type:'textbox'}"><spring:message code="drprodimplement.column.product_time_t" /></th>
                    <!-- 产出方式 -->
                    <th data-options="field:'prod_type_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprodimplement.column.prod_type_s" /></th>
                    <!-- 接收时间 -->
                    <th data-options="field:'receive_time_t',width:'80px',editor:{type:'textbox'}"><spring:message code="drprodimplement.column.receive_time_t" /></th>
                    <!-- 配方时间 -->
                    <th data-options="field:'recipetime_i',width:'80px',editor:{type:'textbox'}"><spring:message code="drprodimplement.column.recipetime_i" /></th>
                    <!-- 加炭黑时间 -->
                    <th data-options="field:'addcbtime_i',width:'80px',editor:{type:'textbox'}"><spring:message code="drprodimplement.column.addcbtime_i" /></th>
                    <!-- 加胶时间 -->
                    <th data-options="field:'addnrtime_i',width:'80px',editor:{type:'textbox'}"><spring:message code="drprodimplement.column.addnrtime_i" /></th>
                    <!-- 加油时间  -->
                    <th data-options="field:'addoiltime_i',width:'80px',editor:{type:'textbox'}"><spring:message code="drprodimplement.column.addoiltime_i" /></th>
                    <!-- 上辅机车次号 -->
                    <th data-options="field:'serial_id_i',width:'80px',editor:{type:'textbox'}"><spring:message code="drprodimplement.column.serial_id_i" /></th>
                    <!-- MES快检车次号 -->
                    <th data-options="field:'mes_serial_id_i',width:'80px',editor:{type:'textbox'}"><spring:message code="drprodimplement.column.mes_serial_id_i" /></th>
                    <!-- 设定车次 -->
                    <th data-options="field:'allche_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprodimplement.column.allche_s" /></th>
                    <!-- 载具条码：M + 8 位流水号 -->
                    <th data-options="field:'carrier_code_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprodimplement.column.carrier_code" /></th>
                    <!-- 数据来源：075001-全钢-万向、075002-全钢-北院、075003-半钢-软控、075004-半钢-万向、075005-人工配料、075006-快检、075007-地磅、075008-密炼产出、075009-MES -->
                    <th data-options="field:'datasource_s',width:'80px',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="drprodimplement.column.datasource" /></th>
                    <!-- 排胶能量 -->
                    <th data-options="field:'dischargeenergy_f',width:'80px',editor:{type:'textbox'}"><spring:message code="drprodimplement.column.dischargeenergy_f" /></th>
                    <!-- 排胶功率 -->
                    <th data-options="field:'dischargepower_f',width:'80px',editor:{type:'textbox'}"><spring:message code="drprodimplement.column.dischargepower_f" /></th>
                    <!-- 排胶温度 -->
                    <th data-options="field:'dischargetemp_f',width:'80px',editor:{type:'textbox'}"><spring:message code="drprodimplement.column.dischargetemp_f" /></th>
                    <!-- 间隔时间 -->
                    <th data-options="field:'intervals_i',width:'80px',editor:{type:'textbox'}"><spring:message code="drprodimplement.column.intervals_i" /></th>
                    <!-- JPW：上辅机回传接收次数 -->
                    <th data-options="field:'jpw_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprodimplement.column.jpw" /></th>
                    <!-- 密炼配方BOM版本 -->
                    <th data-options="field:'recipe_bom_version_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprodimplement.column.recipe_bom_version" /></th>
                    <!-- 密炼生成配方编号，外键，INT_PLM_MIXRECIPE_EDIT.RECIPE_CODE -->
                    <th data-options="field:'recipe_code_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprodimplement.column.recipe_code" /></th>
                    <!-- 状态编码 -->
                    <th data-options="field:'state_code_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprodimplement.column.state_code_s" /></th>
                    <!-- 产出重量 -->
                    <th data-options="field:'weight_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprodimplement.column.weight_s" /></th>
                    <!-- 密炼工单跟踪表，工单号，外键，MX_PP_WO_EDIT.WO_NO -->
                    <th data-options="field:'wo_no_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprodimplement.column.wo_no" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprodimplement.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',width:'80px',editor:{type:'textbox'}"><spring:message code="drprodimplement.column.created_time_t" /></th>
                    <!-- 备用字段1：无称量实绩原因备注 -->
                    <th data-options="field:'spare1_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprodimplement.column.spare1" /></th>
                    <!-- 备用字段2：下发人姓名 -->
                    <th data-options="field:'spare2_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprodimplement.column.spare2" /></th>
                    <!-- 备用字段3：下发时间 -->
                    <th data-options="field:'spare3_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprodimplement.column.spare3" /></th>
                    <!-- 备用字段5：月产量汇总：0-未处理、1-已处理、2-处理失败 -->
                    <th data-options="field:'spare5_s',width:'80px',formatter:synchandflagFormatter,editor:{type:'textbox'}"><spring:message code="drprodimplement.column.spare5" /></th>
                </tr>
       	     	</thead>
       		 </table>
   
		</div>
	</div>
</div>
    
</body>
</html>
