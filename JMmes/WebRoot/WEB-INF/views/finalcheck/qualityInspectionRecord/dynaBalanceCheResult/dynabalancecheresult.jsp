<!-- 

    作者      :时永良
    时间      :2018-08-10 07:25:02 
    页面名称:2018动平衡检测履历页面
    文件关联:
        DynaBalanceCheResult.java
        DynaBalanceCheResultController.java
        DynaBalanceCheResultServiceImpl.java
        DynaBalanceCheResultServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="dynabalancecheresult.js.jsp"%>
<script type="text/javascript" src="dict/253.js"></script>
<style type="text/css">
.columnTitle {
	padding: 6px 10px
}
</style>
<body class="easyui-layout" fit="true">
	<div data-options="region:'center',split:true,border:false">
		<div id="DynaBalanceCheResult_dg_toolbar">
			<form id="DynaBalanceCheResult_search_form" class="form">
				<table class="formTable" >
						<spring:message code="sortdynabalancelog.column.sorttime_t" />:</td>
							<!-- 操作时间 --> <input name="filter[begin_created_time]" editable="true" id="begin_created_time" type="text" class="easyui-textbox" style="width:165px" data-options="label:''"> 到 <input
							name="filter[end_created_time]" editable="true" id="end_created_time" class="easyui-datetimebox" style="width:165px">
					
						 <!-- 动平衡机台条码 --> <spring:message code="dynabalancecheresult.column.machinebar_s" />:
						<input type="text" class="easyui-combobox" style="width:140px" name="filter[machinebar_s]" id="machinebar_s" style="width:120px"
							data-options="  label:'',
						required:false, 
                		width:200,
                		panelHeight:200,
                		icons:[{iconCls:'icon-clear',handler:function(e){$(e.data.target).combobox('clear')}}],
                		url:'finalcheck/baseData/entmodel/SearchEnt?equip_type=254004',
				   			panelHeight:200,
				    		valueField:'EQUIP_NAME',
				    		textField:'DESCRIPTION'"> 
							 <!-- 物料编码 --> <spring:message code="hhhh.column.material_code_s" />:
							<input name="filter[curingspeccode_s]" style="width:140px" like=true id="curingspeccode_s" type="text" class="easyui-textbox" data-options="label:'',width:'100px'">
							<br/><!-- 硫化机台 --> <spring:message code="curingalarmcount.column.curingequip_code_s" />:
							<input name="filter[curingmachinecode_s]" style="width:140px" like=true id="curingmachinecode_s" type="text" class="easyui-textbox" data-options="label:'',width:'100px'"> 
						
							<!-- 轮胎条码 --> <spring:message code="dynabalancecheresult.column.barcode_s" />:
						    <input name="filter[barcode_s]" id="barcode_s" type="text" style="width:140px" class="easyui-textbox" data-options="label:''"></td>

							
						  <!-- 硫化等级 -->
						<spring:message code="dynabalancecheresult.column.tire_total_ratings_s" />:
						<input name="filter[tire_total_ratings_s]" id="tire_total_ratings_s" like="true" style="width:110px;" type="text" class="easyui-combotree" data-options="label:'',
								                  labelWidth:'auto',
												  panelHeight:150,
												  required:false,
												  url:'dict/code/253',
												  method:'get'">
						<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
				</table>
			</form>
			<auth:button code="ZJ_ZJGL_DPHJCLL_EXPORT">
				<a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="doExport()"><spring:message code="button.export" /></a>
			</auth:button>
			<auth:button code="ZJ_ZJGL_DPHJCLL_SEARCHBAR">
				<a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-hide'" onclick="searchBar()"><spring:message code="button.searchColumn" /></a>
			</auth:button>
		</div>
		<table id="dynabalancecheresult_dg" class="easyui-datagrid"
			data-options="  
			    autoRowHeight:false,
			    nowrap:true,
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: false,
                emptyMsg: '<span><spring:message code='tip.noData'/></span>',
                singleSelect: false,
                toolbar: '#DynaBalanceCheResult_dg_toolbar',
                url: '',
                striped:false,
                method: 'get' 
                ">
			<thead>
				<tr>
					<th data-options="field:'atr_key',checkbox:true" rowspan="2">ID</th>
					<!-- 动平衡机台条码：D_EM_Ent 表 ENTBARCODE -->
					<th width="80" rowspan="2" data-options="field:'machinebar_s',formatter:entCodeFormatter"><spring:message code="dynabalancecheresult.column.machinebar_s" /></th>
					<!-- 轮胎条码：MainTyre 表 BARCODE -->
					<th width="80" rowspan="2" data-options="field:'barcode_s'"><spring:message code="dynabalancecheresult.column.barcode_s" /></th>
					<!-- 物料编码 -->
					<th width="80" rowspan="2" data-options="field:'material_code_s'"><spring:message code="hhhh.column.material_code_s" /></th>
					<!-- 物料描述 -->
					<th width="230" rowspan="2" data-options="field:'material_name_s'"><spring:message code="hhhh.column.material_name_s" /></th> 
					<!-- 测试时间 -->
					<th width="130" rowspan="2" data-options="field:'outputtime_t'"><spring:message code="dynabalancecheresult.column.outputtime_t" /></th>
				    <!-- 成型机台 -->
					<th width="130" rowspan="2" data-options="field:'buildinmachinecode_s'"><spring:message code="maintyrecurlog.column.buildinmachinecode_s" /></th>
					<!-- 成型时间 -->
					<th width="130" rowspan="2" data-options="field:'buildintime_t'"><spring:message code="maintyrecurlog.column.buildintime_t" /></th>
					<!-- 硫化机台 -->
					<th width="130" rowspan="2" data-options="field:'curingmachinecode_s'"><spring:message code="curingalarmcount.column.curingequip_code_s" /></th>
					<!-- 硫化时间 -->
					<th width="130" rowspan="2" data-options="field:'curingtime_t'"><spring:message code="curingalarmcount.column.curingtime_t" /></th>
					<!-- 轮胎总等级 -->
					<th width="80" rowspan="2" data-options="field:'tire_total_ratings_s',formatter:codeFormatter"><spring:message code="dynabalancecheresult.column.tire_total_ratings_s" /></th>
					<!-- 动平衡总等级 -->
					<th width="80" rowspan="2" data-options="field:'balancetotal_rank_s'"><spring:message code="dynabalancecheresult.column.balancetotal_rank_s" /></th>
					<!-- 跳动度总等级 -->
					<th width="80" rowspan="2" data-options="field:'rototal_rank_s'"><spring:message code="dynabalancecheresult.column.rototal_rank_s" /></th>
					<!-- 均匀性总等级 -->
					<th width="80" rowspan="2" data-options="field:'ufm_totalrank_s'"><spring:message code="dynabalancecheresult.column.ufm_totalrank_s" /></th>
					<!-- 荷重 -->
					<th width="80" rowspan="2" data-options="field:'load_s'"><spring:message code="dynabalancecheresult.column.load" /></th>
					<th colspan="3">CW-RFV-OA</th>
					<th colspan="3">1H</th>
					<th colspan="3">2H</th>
					<th colspan="3">3H</th>
					<th colspan="3">4H</th>
					<th colspan="3">5H</th>
					<th colspan="3">6H</th>
					<th colspan="3">7H</th>
					<th colspan="3">8H</th>
					<th colspan="3">9H</th>
					<th colspan="3">10H</th>
					
                    <th colspan="3">CW-LFV-OA</th>
                    <th colspan="3">1H</th>
					<th colspan="3">2H</th>
					<th colspan="3">3H</th>
					<th colspan="3">4H</th>
					<th colspan="3">5H</th>
					<th colspan="3">6H</th>
					<th colspan="3">7H</th>
					<th colspan="3">8H</th>
					<th colspan="3">9H</th>
					<th colspan="3">10H</th>
					
                    <th colspan="2">CW-LFD</th>
                    <th style="color:'red'" colspan="3">CCW RFV-OA</th>
                    <th colspan="3">1H</th>
					<th colspan="3">2H</th>
					<th colspan="3">3H</th>
					<th colspan="3">4H</th>
					<th colspan="3">5H</th>
					<th colspan="3">6H</th>
					<th colspan="3">7H</th>
					<th colspan="3">8H</th>
					<th colspan="3">9H</th>
					<th colspan="3">10H</th>
					
                    <th colspan="3">CCW LFV-OA</th>
                    <th colspan="3">1H</th>
					<th colspan="3">2H</th>
					<th colspan="3">3H</th>
					<th colspan="3">4H</th>
					<th colspan="3">5H</th>
					<th colspan="3">6H</th>
					<th colspan="3">7H</th>
					<th colspan="3">8H</th>
					<th colspan="3">9H</th>
					<th colspan="3">10H</th>
                    
                    <th colspan="2">CCW LFD</th>
                    <th colspan="2">CON</th>
                    <th colspan="2">PLY</th>
                    <th colspan="3">LROT-OA</th>
                    <th colspan="3">1H</th>
                    <th colspan="3">LROB-OA</th>
                    <th colspan="3">1H</th>
                    <th colspan="3">RFOT-OA</th>
                    <th colspan="3">1H</th>
                    <th colspan="3">RROC-OA</th>
                    <th colspan="3">1H</th>
                    <th colspan="3">RROB-OA</th>
                    <th colspan="3">1H</th>
                    <th colspan="3">LROT-BULGE</th>
                    <th colspan="3">DENT</th>
                    <th colspan="3">LROT-BULGE</th>
                    <th colspan="3">DENT</th>
                    <th colspan="2">OUT-DIA</th>
                    <th colspan="3">Upper</th>
                    <th colspan="3">Lower</th>
                    <th colspan="3">Static</th>
                    <th colspan="3">Couple</th>
                    <th colspan="2">Up+Low</th>
                    <th colspan="2">WEIGHT</th>
                    <!-- MODELNO -->
					<th width="80" rowspan="2" data-options="field:'modelno_s'" ><spring:message code="dynabalancecheresult.column.modelno_s" /></th>
					<!-- 测试模式1：精度测试0：正常测试 -->
					<th width="80" rowspan="2" data-options="field:'testmode_s',formatter:testmodeFormatter" ><spring:message code="dynabalancecheresult.column.testmode_s" /></th>
					<!-- 创建人 -->
					<th width="80" rowspan="2" data-options="field:'created_by'" ><spring:message code="dynabalancecheresult.column.created_by_s" /></th>
					<!-- 创建时间 -->
					<th width="120" rowspan="2" data-options="field:'created_time_t'" ><spring:message code="dynabalancecheresult.column.created_time_t" /></th>
                    
					</tr>
					<tr>
					<!-- 径向力波动值 -->
					<th width="60" data-options="field:'cw_rfvoa_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 径向力波动角度 -->
					<th width="60" data-options="field:'cw_rfvoa_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 径向力波动等级 -->
					<th width="60" data-options="field:'cw_rfvoa_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 径向力波动一次谐波值 -->
					<th width="80" data-options="field:'cw_rfvoa_1h_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 径向力波动一次谐角度 -->
					<th width="80" data-options="field:'cw_rfvoa_1h_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 径向力波动一次谐波等级 -->
					<th width="80" data-options="field:'cw_rfvoa_1h_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 径向力波动二次谐波值 -->
					<th width="80" data-options="field:'cw_rfvoa_2h_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 径向力波动二次谐波角度 -->
					<th width="80" data-options="field:'cw_rfvoa_2h_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 径向力波动二次谐波等级 -->
					<th width="80" data-options="field:'cw_rfvoa_2h_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 径向力波动三次谐波值  -->
					<th width="80" data-options="field:'cw_rfvoa_3h_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 径向力波动三次谐波角度 -->
					<th width="80" data-options="field:'cw_rfvoa_3h_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 径向力波动三次谐波等级 -->
					<th width="80" data-options="field:'cw_rfvoa_3h_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 径向力波动四次谐波值 -->
					<th width="80" data-options="field:'cw_rfvoa_4h_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 径向力波动四次谐波角度 -->
					<th width="80" data-options="field:'cw_rfvoa_4h_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 径向力波动四次谐波等级 -->
					<th width="80" data-options="field:'cw_rfvoa_4h_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 径向力波动五次谐波值  -->
					<th width="80" data-options="field:'cw_rfvoa_5h_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 径向力波动五次谐波角度 -->
					<th width="80" data-options="field:'cw_rfvoa_5h_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 径向力波动五次谐波等级 -->
					<th width="80" data-options="field:'cw_rfvoa_5h_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 径向力波动六次谐波值  -->
					<th width="80" data-options="field:'cw_rfvoa_6h_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 径向力波动六次谐波角度 -->
					<th width="80" data-options="field:'cw_rfvoa_6h_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 径向力波动六次谐波等级 -->
					<th width="80" data-options="field:'cw_rfvoa_6h_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 径向力波动七次谐波值  -->
					<th width="80" data-options="field:'cw_rfvoa_7h_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 径向力波动七次谐波角度  -->
					<th width="80" data-options="field:'cw_rfvoa_7h_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 径向力波动七次谐波等级 -->
					<th width="80" data-options="field:'cw_rfvoa_7h_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 径向力波动八次谐波值 -->
					<th width="80" data-options="field:'cw_rfvoa_8h_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 径向力波动八次谐波角度 -->
					<th width="80" data-options="field:'cw_rfvoa_8h_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 径向力波动八次谐波等级 -->
					<th width="80" data-options="field:'cw_rfvoa_8h_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 径向力波动九次谐波值  -->
					<th width="80" data-options="field:'cw_rfvoa_9h_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 径向力波动九次谐波角度 -->
					<th width="80" data-options="field:'cw_rfvoa_9h_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 径向力波动九次谐波等级 -->
					<th width="80" data-options="field:'cw_rfvoa_9h_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 径向力波动十次谐波值  -->
					<th width="80" data-options="field:'cw_rfvoa_10h_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 径向力波动十次谐波角度 -->
					<th width="80" data-options="field:'cw_rfvoa_10h_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 径向力波动十次谐波等级 -->
					<th width="80" data-options="field:'cw_rfvoa_10h_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					
					
					<!-- 侧向力波动值  -->
					<th width="60" data-options="field:'cw_lfvoa_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 侧向力波动角度 -->
					<th width="60" data-options="field:'cw_lfvoa_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 侧向力波动等级 -->
					<th width="60" data-options="field:'cw_lfvoa_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 侧向力波动一次谐波值 -->
					<th width="80" data-options="field:'cw_lfvoa_1h_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 侧向力波动一次谐角度 -->
					<th width="80" data-options="field:'cw_lfvoa_1h_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 侧向力波动一次谐波等级 -->
					<th width="80" data-options="field:'cw_lfvoa_1h_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 侧向力波动二次谐波值 -->
					<th width="80" data-options="field:'cw_lfvoa_2h_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 侧向力波动二次谐波角度  -->
					<th width="80" data-options="field:'cw_lfvoa_2h_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 侧向力波动二次谐波等级 -->
					<th width="80" data-options="field:'cw_lfvoa_2h_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 侧向力波动三次谐波值 -->
					<th width="80" data-options="field:'cw_lfvoa_3h_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 侧向力波动三次谐波角度  -->
					<th width="80" data-options="field:'cw_lfvoa_3h_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 侧向力波动三次谐波等级 -->
					<th width="80" data-options="field:'cw_lfvoa_3h_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 侧向力波动四次谐波值 -->
					<th width="80" data-options="field:'cw_lfvoa_4h_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 侧向力波动四次谐波角度 -->
					<th width="80" data-options="field:'cw_lfvoa_4h_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 侧向力波动四次谐波等级 -->
					<th width="80" data-options="field:'cw_lfvoa_4h_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 侧向力波动五次谐波值 -->
					<th width="80" data-options="field:'cw_lfvoa_5h_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 侧向力波动五次谐波角度  -->
					<th width="80" data-options="field:'cw_lfvoa_5h_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 侧向力波动五次谐波等级 -->
					<th width="80" data-options="field:'cw_lfvoa_5h_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 侧向力波动六次谐波值 -->
					<th width="80" data-options="field:'cw_lfvoa_6h_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 侧向力波动六次谐波角度-->
					<th width="80" data-options="field:'cw_lfvoa_6h_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 侧向力波动六次谐波角度  -->
					<th width="80" data-options="field:'cw_lfvoa_6h_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 侧向力波动七次谐波值 -->
					<th width="80" data-options="field:'cw_lfvoa_7h_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 侧向力波动七次谐波角度  -->
					<th width="80" data-options="field:'cw_lfvoa_7h_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 侧向力波动七次谐波等级 -->
					<th width="80" data-options="field:'cw_lfvoa_7h_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 侧向力波动八次谐波值 -->
					<th width="80" data-options="field:'cw_lfvoa_8h_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 侧向力波动八次谐波角度  -->
					<th width="80" data-options="field:'cw_lfvoa_8h_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 侧向力波动八次谐波等级 -->
					<th width="80" data-options="field:'cw_lfvoa_8h_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 侧向力波动九次谐波值 -->
					<th width="80" data-options="field:'cw_lfvoa_9h_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 侧向力波动九次谐波角度  -->
					<th width="80" data-options="field:'cw_lfvoa_9h_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 侧向力波动九次谐波等级 -->
					<th width="80" data-options="field:'cw_lfvoa_9h_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 侧向力波动十次谐波值 -->
					<th width="80" data-options="field:'cw_lfvoa_10h_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 侧向力波动十次谐波角度  -->
					<th width="80" data-options="field:'cw_lfvoa_10h_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 侧向力波动十次谐波等级 -->
					<th width="80" data-options="field:'cw_lfvoa_10h_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					
					
					
					<!-- 正转侧向力偏移值 -->
					<th width="60" data-options="field:'cw_lfd_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 正转侧向力偏移等级  -->
					<th width="60" data-options="field:'cw_lfd_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					
					
					<!-- 反转径向力波动值 -->
					<th width="60" data-options="field:'ccw_rfvoa_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 反转径向力波动角度  -->
					<th width="60" data-options="field:'ccw_rfvoa_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 反转径向力波动等级 -->
					<th width="60" data-options="field:'ccw_rfvoa_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 反转径向力波动一次谐波值 -->
					<th width="80" data-options="field:'ccw_rfvoa_1h_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 反转径向力波动一次谐波角度 -->
					<th width="80" data-options="field:'ccw_rfvoa_1h_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 反转径向力波动一次谐波等级 -->
					<th width="80" data-options="field:'ccw_rfvoa_1h_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 反转径向力波动二次谐波值 -->
					<th width="80" data-options="field:'ccw_rfvoa_2h_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 反转径向力波动二次谐波角度 -->
					<th width="80" data-options="field:'ccw_rfvoa_2h_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 反转径向力波动二次谐波等级 -->
					<th width="80" data-options="field:'ccw_rfvoa_2h_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 反转径向力波动三次谐波值 -->
					<th width="80" data-options="field:'ccw_rfvoa_3h_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 反转径向力波动三次谐波角度 -->
					<th width="80" data-options="field:'ccw_rfvoa_3h_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 反转径向力波动三次谐波等级 -->
					<th width="80" data-options="field:'ccw_rfvoa_3h_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 反转径向力波动四次谐波值 -->
					<th width="80" data-options="field:'ccw_rfvoa_4h_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 反转径向力波动四次谐波角度 -->
					<th width="80" data-options="field:'ccw_rfvoa_4h_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 反转径向力波动四次谐波等级 -->
					<th width="80" data-options="field:'ccw_rfvoa_4h_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 反转径向力波动五次谐波值 -->
					<th width="80" data-options="field:'ccw_rfvoa_5h_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 反转径向力波动五次谐波角度 -->
					<th width="80" data-options="field:'ccw_rfvoa_5h_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 反转径向力波动五次谐波等级 -->
					<th width="80"  data-options="field:'ccw_rfvoa_5h_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 反转径向力波动六次谐波值 -->
					<th width="80" data-options="field:'ccw_rfvoa_6h_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 反转径向力波动六次谐波角度 -->
					<th width="80" data-options="field:'ccw_rfvoa_6h_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 反转径向力波动六次谐波等级 -->
					<th width="80" data-options="field:'ccw_rfvoa_6h_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 反转径向力波动七次谐波值 -->
					<th width="80" data-options="field:'ccw_rfvoa_7h_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 反转径向力波动七次谐波角度 -->
					<th width="80" data-options="field:'ccw_rfvoa_7h_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 反转径向力波动七次谐波等级 -->
					<th width="80" data-options="field:'ccw_rfvoa_7h_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 反转径向力波动八次谐波值 -->
					<th width="80" data-options="field:'ccw_rfvoa_8h_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 反转径向力波动八次谐波角度 -->
					<th width="80" data-options="field:'ccw_rfvoa_8h_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 反转径向力波动八次谐波等级 -->
					<th width="80" data-options="field:'ccw_rfvoa_8h_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 反转径向力波动九次谐波值 -->
					<th width="80" data-options="field:'ccw_rfvoa_9h_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 反转径向力波动九次谐波角度 -->
					<th width="80" data-options="field:'ccw_rfvoa_9h_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 反转径向力波动九次谐波等级 -->
					<th width="80" data-options="field:'ccw_rfvoa_9h_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 反转径向力波动十次谐波值 -->
					<th width="80" data-options="field:'ccw_rfvoa_10h_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 反转径向力波动十次谐波角度 -->
					<th width="80" data-options="field:'ccw_rfvoa_10h_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 反转径向力波动十次谐波等级 -->
					<th width="80" data-options="field:'ccw_rfvoa_10h_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					
					
					<!-- 反转侧向力波动值  -->
					<th width="60" data-options="field:'ccw_lfvoa_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 反转侧向力波动角度 -->
					<th width="60" data-options="field:'ccw_lfvoa_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 反转侧向力波动等级 -->
					<th width="60" data-options="field:'ccw_lfvoa_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 反转侧向力波动一次谐波值 -->
					<th width="80" data-options="field:'ccw_lfvoa_1h_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 反转侧向力波动一次谐波角度 -->
					<th width="80" data-options="field:'ccw_lfvoa_1h_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 反转侧向力波动一次谐波等级 -->
					<th width="80" data-options="field:'ccw_lfvoa_1h_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 反转侧向力波动二次谐波值 -->
					<th width="80" data-options="field:'ccw_lfvoa_2h_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 反转侧向力波动二次谐波角度 -->
					<th width="80" data-options="field:'ccw_lfvoa_2h_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 反转侧向力波动二次谐波等级 -->
					<th width="80" data-options="field:'ccw_lfvoa_2h_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 反转侧向力波动三次谐波值 -->
					<th width="80" data-options="field:'ccw_lfvoa_3h_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 反转侧向力波动三次谐波角度 -->
					<th width="80" data-options="field:'ccw_lfvoa_3h_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 反转侧向力波动三次谐波等级 -->
					<th width="80" data-options="field:'ccw_lfvoa_3h_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 反转侧向力波动四次谐波值 -->
					<th width="80" data-options="field:'ccw_lfvoa_4h_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 反转侧向力波动四次谐波角度 -->
					<th width="80" data-options="field:'ccw_lfvoa_4h_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 反转侧向力波动四次谐波等级 -->
					<th width="80" data-options="field:'ccw_lfvoa_4h_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 反转侧向力波动五次谐波值 -->
					<th width="80" data-options="field:'ccw_lfvoa_5h_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 反转侧向力波动五次谐波角度 -->
					<th width="80" data-options="field:'ccw_lfvoa_5h_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 反转侧向力波动五次谐波等级 -->
					<th width="80" data-options="field:'ccw_lfvoa_5h_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 反转侧向力波动六次谐波值 -->
					<th width="80" data-options="field:'ccw_lfvoa_6h_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 反转侧向力波动六次谐波角度 -->
					<th width="80" data-options="field:'ccw_lfvoa_6h_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 反转侧向力波动六次谐波等级 -->
					<th width="80" data-options="field:'ccw_lfvoa_6h_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 反转侧向力波动七次谐波值 -->
					<th width="80" data-options="field:'ccw_lfvoa_7h_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 反转侧向力波动七次谐波角度 -->
					<th width="80" data-options="field:'ccw_lfvoa_7h_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 反转侧向力波动七次谐波等级 -->
					<th width="80" data-options="field:'ccw_lfvoa_7h_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 反转侧向力波动八次谐波值 -->
					<th width="80" data-options="field:'ccw_lfvoa_8h_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 反转侧向力波动八次谐波角度 -->
					<th width="80" data-options="field:'ccw_lfvoa_8h_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 反转侧向力波动八次谐波等级 -->
					<th width="80" data-options="field:'ccw_lfvoa_8h_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 反转侧向力波动九次谐波值 -->
					<th width="80" data-options="field:'ccw_lfvoa_9h_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 反转侧向力波动九次谐波角度 -->
					<th width="80" data-options="field:'ccw_lfvoa_9h_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 反转侧向力波动九次谐波等级 -->
					<th width="80" data-options="field:'ccw_lfvoa_9h_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 反转侧向力波动十次谐波值 -->
					<th width="80" data-options="field:'ccw_lfvoa_10h_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 反转侧向力波动十次谐波角度 -->
					<th width="80" data-options="field:'ccw_lfvoa_10h_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 反转侧向力波动十次谐波等级 -->
					<th width="80" data-options="field:'ccw_lfvoa_10h_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					
					
					<!-- 反转侧向力偏移值 -->
					<th width="60" data-options="field:'ccw_lfd_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 反转侧向力偏移等级 -->
					<th width="60" data-options="field:'ccw_lfd_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					
					
					<!-- 锥度值 -->
					<th width="60" data-options="field:'con_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 锥度等级 -->
					<th width="60" data-options="field:'con_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					
					<!-- 帘布效应（跑偏，角度效应） -->
					<th width="60" data-options="field:'ply_kgf_s'"><spring:message code="dynabalancecheresult.column.kgf" /></th>
					<!-- 帘布效应等级 -->
					<th width="60" data-options="field:'ply_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					
					
					
					<!-- 上部侧向跳动值 -->
					<th width="60" data-options="field:'ltoa_mm_s'"><spring:message code="dynabalancecheresult.column.mm" /></th>
					<!-- 上部侧向跳动角度 -->
					<th width="60" data-options="field:'ltoa_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 上部侧向跳动等级 -->
					<th width="60" data-options="field:'ltoa_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 上部侧向跳动一次谐波值 -->
					<th width="80" data-options="field:'ltoa_1h_mm_s'"><spring:message code="dynabalancecheresult.column.mm" /></th>
					<!-- 上部侧向跳动一次谐波角度 -->
					<th width="80" data-options="field:'ltoa_1h_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 上部侧向跳动一次谐波等级 -->
					<th width="80" data-options="field:'ltoa_1h_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					
					
					<!-- 下部侧向跳动值 -->
					<th width="60" data-options="field:'lboa_mm_s'"><spring:message code="dynabalancecheresult.column.mm" /></th>
					<!-- 下部侧向跳动角度 -->
					<th width="60" data-options="field:'lboa_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 下部侧向跳动等级 -->
					<th width="60" data-options="field:'lboa_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 下部侧向跳动一次谐波值 -->
					<th width="80" data-options="field:'lboa_1h_mm_s'"><spring:message code="dynabalancecheresult.column.mm" /></th>
					<!-- 下部侧向跳动一次谐波角度 -->
					<th width="80" data-options="field:'lboa_1h_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 下部侧向跳动一次谐波等级 -->
					<th width="80"  data-options="field:'lboa_1h_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					
					
					<!-- 上部径向跳动值 -->
					<th width="60" data-options="field:'rtoa_mm_s'"><spring:message code="dynabalancecheresult.column.mm" /></th>
					<!-- 上部径向跳动角度 -->
					<th width="60" data-options="field:'rtoa_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 上部径向跳动等级  -->
					<th width="60" data-options="field:'rtoa_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 上部径向跳动一次谐波值  -->
					<th width="80" data-options="field:'rtoa_1h_mm_s'"><spring:message code="dynabalancecheresult.column.mm" /></th>
					<!-- 上部径向跳动一次谐波角度 -->
					<th width="80" data-options="field:'rtoa_1h_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 上部径向跳动一次谐波等级 -->
					<th width="80" data-options="field:'rtoa_1h_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					
					
					
					<!-- 中部径向跳动值 -->
					<th width="60" data-options="field:'rcoa_mm_s'"><spring:message code="dynabalancecheresult.column.mm" /></th>
					<!-- 中部径向跳动角度 -->
					<th width="60" data-options="field:'rcoa_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 中部径向跳动等级  -->
					<th width="60" data-options="field:'rcoa_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 中部径向跳动一次谐波值  -->
					<th width="80" data-options="field:'rcoa_1h_mm_s'"><spring:message code="dynabalancecheresult.column.mm" /></th>
					<!-- 中部径向跳动一次谐波角度 -->
					<th width="80" data-options="field:'rcoa_1h_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 中部径向跳动一次谐波等级 -->
					<th width="80" data-options="field:'rcoa_1h_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					
					
					<!-- 下部径向跳动值 -->
					<th width="60" data-options="field:'rboa_mm_s'"><spring:message code="dynabalancecheresult.column.mm" /></th>
					<!-- 下部径向跳动角度 -->
					<th width="60" data-options="field:'rboa_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 下部径向跳动等级  -->
					<th width="60" data-options="field:'rboa_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 下部径向跳动一次谐波值  -->
					<th width="80" data-options="field:'rboa_1h_mm_s'"><spring:message code="dynabalancecheresult.column.mm" /></th>
					<!-- 下部径向跳动一次谐波角度 -->
					<th width="80" data-options="field:'rboa_1h_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 下部径向跳动一次谐波等级 -->
					<th width="80" data-options="field:'rboa_1h_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					
					
					<!-- 上部侧向凸值  -->
					<th width="60" data-options="field:'lt_bulging_mm_s'"><spring:message code="dynabalancecheresult.column.mm" /></th>
					<!-- 上部侧向凸角度 -->
					<th width="60" data-options="field:'lt_bulging_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 上部侧向凸等级 -->
					<th width="60" data-options="field:'lt_bulging_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 上部侧向凹值 -->
					<th width="60" data-options="field:'lt_dent_mm_s'"><spring:message code="dynabalancecheresult.column.mm" /></th>
					<!-- 上部侧向凹角度 -->
					<th width="60" data-options="field:'lt_dent_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 上部侧向凹等级 -->
					<th width="60" data-options="field:'lt_dent_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					
					
					<!-- 下部侧向凸值  -->
					<th width="60" data-options="field:'lb_bulging_mm_s'"><spring:message code="dynabalancecheresult.column.mm" /></th>
					<!-- 下部侧向凸角度 -->
					<th width="60" data-options="field:'lb_bulging_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 下部侧向凸等级 -->
					<th width="60" data-options="field:'lb_bulging_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					<!-- 下部侧向凹值 -->
					<th width="60" data-options="field:'lb_dent_mm_s'"><spring:message code="dynabalancecheresult.column.mm" /></th>
					<!-- 下部侧向凹角度 -->
					<th width="60" data-options="field:'lb_dent_deg_s'"><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 下部侧向凹等级 -->
					<th width="60" data-options="field:'lb_dent_rank_s'"><spring:message code="dynabalancecheresult.column.rank" /></th>
					
					
					<!-- 轮胎外直径 -->
					<th width="60" data-options="field:'outsidediameter_mm_s'" ><spring:message code="dynabalancecheresult.column.mm" /></th>
					<!-- 轮胎外直径等级 -->
					<th width="60" data-options="field:'outsidediameter_rank_s'" ><spring:message code="dynabalancecheresult.column.rank" /></th>
					
					
					<!-- 上面不平衡量 -->
					<th width="60" data-options="field:'upper_unbalance_g_s'" ><spring:message code="dynabalancecheresult.column.g" /></th>
					<!-- 上面不平衡量角度 -->
					<th width="60" data-options="field:'upper_unbalance_deg_s'" ><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 上面不平衡量等级 -->
					<th width="60" data-options="field:'upper_unbalance_rank_s'" ><spring:message code="dynabalancecheresult.column.rank" /></th>
					
					
					<!-- 下面不平衡量 -->
					<th width="60" data-options="field:'lower_unbalance_g_s'" ><spring:message code="dynabalancecheresult.column.g" /></th>
					<!-- 下面不平衡量角度 -->
					<th width="60" data-options="field:'lower_unbalance_deg_s'" ><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 下面不平衡量等级 -->
					<th width="60" data-options="field:'lower_unbalance_rank_s'" ><spring:message code="dynabalancecheresult.column.rank" /></th>
					
					
					<!-- 静合成不平衡量 -->
					<th width="60" data-options="field:'static_unbalance_g_s'" ><spring:message code="dynabalancecheresult.column.g_cm" /></th>
					<!-- 静合成不平衡量角度  -->
					<th width="60" data-options="field:'static_unbalance_deg_s'" ><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 静合成不平衡量等级 -->
					<th width="60" data-options="field:'static_unbalance_rank_s'" ><spring:message code="dynabalancecheresult.column.rank" /></th>
					
					
					<!-- 偶不平衡量 -->
					<th width="60" data-options="field:'couple_unbalance_g_s'" ><spring:message code="dynabalancecheresult.column.g" /></th>
					<!-- 偶不平衡量角度 -->
					<th width="60" data-options="field:'couple_unbalance_deg_s'" ><spring:message code="dynabalancecheresult.column.deg" /></th>
					<!-- 偶不平衡量等级 -->
					<th width="60" data-options="field:'couple_unbalance_rank_s'" ><spring:message code="dynabalancecheresult.column.rank" /></th>
					
					
					<!-- 上面+下面不平衡量 -->
					<th width="60" data-options="field:'uplow_unbalance_g_s'" ><spring:message code="dynabalancecheresult.column.g" /></th>
					<!-- 上面+下面不平衡量角度 -->
					<%-- <th width="60" data-options="field:'uplow_unbalance_deg_s'" ><spring:message code="dynabalancecheresult.column.uplow_unbalance_deg_s" /></th> --%>
					<!-- 上面+下面不平衡量等级 -->
					<th width="60" data-options="field:'uplow_unbalance_rank_s'" ><spring:message code="dynabalancecheresult.column.deg" /></th>
					
					
					
					<!-- 轮胎重量 -->
					<th width="80" data-options="field:'weight_s'" ><spring:message code="dynabalancecheresult.column.kg" /></th>
					<!-- 轮胎重量等级 -->
					<th width="80" data-options="field:'weight_rank_s'" ><spring:message code="dynabalancecheresult.column.rank" /></th>
					
					
					
				</tr>
			</thead>
		</table>
	</div>
	<jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="DynaBalanceCheResult_search_form" />
		<jsp:param name="datagridId" value="dynabalancecheresult_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.finalcheck.excel.DynaBalanceCheResultExportHandler" />
		<jsp:param name="serviceName" value="DynaBalanceCheResultServiceImpl" />

	</jsp:include>
</body>
</html>
