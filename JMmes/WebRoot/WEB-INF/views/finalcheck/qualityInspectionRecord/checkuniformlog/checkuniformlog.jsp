<!-- 

    作者      :时永良
    时间      :2019-05-02 10:00:12 
    页面名称:质检均匀机检测履历表_全钢
    文件关联:
        Checkuniformlog.java
        CheckuniformlogController.java
        CheckuniformlogServiceImpl.java
        CheckuniformlogServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="checkuniformlog.js.jsp"%>
<script type="text/javascript" src="dict/253.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="Checkuniformlog_dg_toolbar">
            <form id="Checkuniformlog_search_form" class="form" >
            	<spring:message code="sortdynabalancelog.column.sorttime_t" />:</td>
							<!-- 操作时间 --> <input name="filter[begin_created_time]" editable="true" id="begin_created_time" type="text" class="easyui-textbox" style="width:175px" data-options="label:''"> 到 <input
							name="filter[end_created_time]" editable="true" id="end_created_time" class="easyui-datetimebox" style="width:170px">
						
            	<!-- 动平衡机台条码 -->
            	 <spring:message code="checkuniformlog.column.machinebar_s" />:
						<input type="text" class="easyui-combobox" style="width:140px" name="filter[machinebar_s]" id="machinebar_s" style="width:120px"
							data-options="  label:'',
						required:false, 
                		width:200,
                		panelHeight:200,
                		icons:[{iconCls:'icon-clear',handler:function(e){$(e.data.target).combobox('clear')}}],
                		url:'finalcheck/baseData/entmodel/SearchEnt?equip_type=254005',
			   			method: 'get',
			    		valueField:'EQUIP_NAME',
			    		textField:'DESCRIPTION'">
			    		<!-- 物料编码 --> 
			    		<spring:message code="hhhh.column.material_code_s" /> :
					    <input name="filter[curingspeccode_s]" style="width:140px" like=true id="curingspeccode_s" type="text" class="easyui-textbox" data-options="label:'',width:'100px'">
						<br/>
						<!-- 硫化机台 --> 
					    <spring:message code="curingalarmcount.column.curingequip_code_s" />:
						<input name="filter[curingmachinecode_s]" style="width:140px" like=true id="curingmachinecode_s" type="text" class="easyui-textbox" data-options="label:'',width:'100px'">
					<!-- 轮胎条码 -->
					 <spring:message code="dynabalancecheresult.column.barcode_s" />:
						<input name="filter[barcode_s]" id="barcode_s" like="true" type="text" style="width:140px" class="easyui-textbox" data-options="label:''"></td>
						<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
	            <a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="doExport()"><spring:message code="button.export" /></a>
	        </form> 
        </div>
        <table id="checkuniformlog_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                autoRowHeight:false,
			    nowrap:true,
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: false,
                singleSelect: false,
                 emptyMsg: '<span><spring:message code='tip.noData'/></span>',
                toolbar: '#Checkuniformlog_dg_toolbar',
                url: '',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true" rowspan="2">ID</th>
                    <!-- 均匀机机台条码：D_EM_Ent.ENTBARCODE -->
                    <th width="80" rowspan="2" data-options="field:'machinebar_s',formatter:entCodeFormatter,editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.machinebar_s" /></th>
                    <!-- 轮胎条码：MainTyre.BARCODE -->
                    <th width="80" rowspan="2" data-options="field:'barcode_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.barcode_s" /></th>
                    <!-- 物料编码 -->
					<th width="80" rowspan="2" data-options="field:'materialcode_s'"><spring:message code="hhhh.column.material_code_s" /></th>
					<!-- 物料描述 -->
					<th width="260" rowspan="2" data-options="field:'description'"><spring:message code="hhhh.column.material_name_s" /></th>
					<!-- 测试时间 -->
					<th width="130" rowspan="2" data-options="field:'created_time_t'"><spring:message code="dynabalancecheresult.column.outputtime_t" /></th>
					<!-- 成型机台 -->
					<th width="80" rowspan="2" data-options="field:'buildinmachinecode_s'"><spring:message code="curingalarmcount.column.buildingequip_code_s" /></th>
					<!-- 成型时间 -->
					<th width="130" rowspan="2" data-options="field:'buildintime_t'"><spring:message code="maintyrecurlog.column.buildintime_t" /></th>
					<!-- 硫化机台 -->
					<th width="80" rowspan="2" data-options="field:'curingmachinecode_s'"><spring:message code="curingalarmcount.column.curingequip_code_s" /></th>
					<!-- 硫化时间 -->
					<th width="130" rowspan="2" data-options="field:'curingtime_t'"><spring:message code="curingalarmcount.column.curingtime_t" /></th>
					<!-- 轮胎总等级 -->
                    <th width="80" rowspan="2" data-options="field:'gradecode_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.gradecode_s" /></th>
                    <!-- 跳动度总等级 -->
                    <th width="80" rowspan="2" data-options="field:'ro_total_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ro_total_rank_s" /></th>
					 <!-- 均匀性总等级 -->
					<th width="80" rowspan="2" data-options="field:'ufm_total_rank_s'"><spring:message code="dynabalancecheresult.column.ufm_totalrank_s" /></th>
					<th colspan="33">CW_RFV_OA</th>
                    <th colspan="33">CW_LFV_OA</th>
                    <th colspan="2">CW_LFD</th>
                    <th style="color:'red'" colspan="33">CCW_RFV_OA</th>
                    <th colspan="33">CCW_LFV_OA</th>
                    <th colspan="2">CCW_LFD</th>
                    <th colspan="2">CON</th>
                    <th colspan="2">PLY</th>
                    <th colspan="6">LT_OA</th>
                    <th colspan="6">LB_OA</th>
                    <th colspan="6">RT_OA</th>
                    <th colspan="6">RC_OA</th>
                    <th colspan="6">RB_OA</th>
                    <th colspan="6">LT_BULGING</th>
                    <th colspan="6">LB_BULGING</th>
                    <th colspan="2">OUTSIDE_DIAMETER</th>
                    <!-- 荷重 -->
                    <th width="80" rowspan="2" data-options="field:'load_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.load_s" /></th>
                    <!-- 备注 -->
                    <th width="80" rowspan="2" data-options="field:'memo_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.memo_s" /></th>
                    <!-- 修改人 -->
                    <th width="80" rowspan="2" data-options="field:'changed_by',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th width="80" rowspan="2" data-options="field:'changed_time_t',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.changed_time_t" /></th>
                    <!-- 创建人 -->
                    <th width="80" rowspan="2" data-options="field:'created_by',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th width="80" rowspan="2" data-options="field:'created_time_t',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.created_time_t" /></th>                
                </tr>
                <tr>
                    <!-- 径向力波动值 -->
                    <th width="100" data-options="field:'cw_rfv_oa_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_rfv_oa_kgf_s" /></th>
                	 <!-- 径向力波动角度 -->
                    <th width="100" data-options="field:'cw_rfv_oa_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_rfv_oa_deg_s" /></th>
                    <!-- 径向力波动等级 -->
                    <th width="100" data-options="field:'cw_rfv_oa_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_rfv_oa_rank_s" /></th>
                    <!-- 径向力波动一次谐波值 -->
                    <th width="150" data-options="field:'cw_rfv_oa_1h_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_rfv_oa_1h_kgf_s" /></th>
                    <!-- 径向力波动一次谐波角度 -->
                    <th width="150" data-options="field:'cw_rfv_oa_1h_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_rfv_oa_1h_deg_s" /></th>
                    <!-- 径向力波动一次谐波等级 -->
                    <th width="150" data-options="field:'cw_rfv_oa_1h_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_rfv_oa_1h_rank_s" /></th>
                    <!-- 径向力波动二次谐波值 -->
                    <th width="150" data-options="field:'cw_rfv_oa_2h_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_rfv_oa_2h_kgf_s" /></th>
                    <!-- 径向力波动二次谐波角度 -->
                    <th width="150" data-options="field:'cw_rfv_oa_2h_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_rfv_oa_2h_deg_s" /></th>
                    <!-- 径向力波动二次谐波等级 -->
                    <th width="150" data-options="field:'cw_rfv_oa_2h_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_rfv_oa_2h_rank_s" /></th>
                    <!-- 径向力波动三次谐波值 -->
                    <th width="150" data-options="field:'cw_rfv_oa_3h_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_rfv_oa_3h_kgf_s" /></th>
                    <!-- 径向力波动三次谐波角度 -->
                    <th width="150" data-options="field:'cw_rfv_oa_3h_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_rfv_oa_3h_deg_s" /></th>
                    <!-- 径向力波动三次谐波等级 -->
                    <th width="150" data-options="field:'cw_rfv_oa_3h_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_rfv_oa_3h_rank_s" /></th>
                    <!-- 径向力波动四次谐波值 -->
                    <th width="150" data-options="field:'cw_rfv_oa_4h_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_rfv_oa_4h_kgf_s" /></th>
                    <!-- 径向力波动四次谐波角度 -->
                    <th width="150" data-options="field:'cw_rfv_oa_4h_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_rfv_oa_4h_deg_s" /></th>
                    <!-- 径向力波动四次谐波等级 -->
                    <th width="150" data-options="field:'cw_rfv_oa_4h_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_rfv_oa_4h_rank_s" /></th>
                    <!-- 径向力波动五次谐波值 -->
                    <th width="150" data-options="field:'cw_rfv_oa_5h_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_rfv_oa_5h_kgf_s" /></th>
                    <!-- 径向力波动五次谐波角度 -->
                    <th width="150" data-options="field:'cw_rfv_oa_5h_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_rfv_oa_5h_deg_s" /></th>
                    <!-- 径向力波动五次谐波等级 -->
                    <th width="150" data-options="field:'cw_rfv_oa_5h_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_rfv_oa_5h_rank_s" /></th>
                    <!-- 径向力波动六次谐波值 -->
                    <th width="150" data-options="field:'cw_rfv_oa_6h_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_rfv_oa_6h_kgf_s" /></th>
                    <!-- 径向力波动六次谐波角度 -->
                    <th width="150" data-options="field:'cw_rfv_oa_6h_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_rfv_oa_6h_deg_s" /></th>
                    <!-- 径向力波动六次谐波等级 -->
                    <th width="150" data-options="field:'cw_rfv_oa_6h_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_rfv_oa_6h_rank_s" /></th>
                    <!-- 径向力波动七次谐波值 -->
                    <th width="150" data-options="field:'cw_rfv_oa_7h_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_rfv_oa_7h_kgf_s" /></th>
                    <!-- 径向力波动七次谐波角度 -->
                    <th width="150" data-options="field:'cw_rfv_oa_7h_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_rfv_oa_7h_deg_s" /></th>
                    <!-- 径向力波动七次谐波等级 -->
                    <th width="150" data-options="field:'cw_rfv_oa_7h_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_rfv_oa_7h_rank_s" /></th>
                    <!-- 径向力波动八次谐波值 -->
                    <th width="150" data-options="field:'cw_rfv_oa_8h_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_rfv_oa_8h_kgf_s" /></th>
                    <!-- 径向力波动八次谐波角度 -->
                    <th width="150" data-options="field:'cw_rfv_oa_8h_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_rfv_oa_8h_deg_s" /></th>
                    <!-- 径向力波动八次谐波等级 -->
                    <th width="150" data-options="field:'cw_rfv_oa_8h_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_rfv_oa_8h_rank_s" /></th>
                    <!-- 径向力波动九次谐波值 -->
                    <th width="150" data-options="field:'cw_rfv_oa_9h_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_rfv_oa_9h_kgf_s" /></th>
                    <!-- 径向力波动九次谐波角度 -->
                    <th width="150" data-options="field:'cw_rfv_oa_9h_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_rfv_oa_9h_deg_s" /></th>
                    <!-- 径向力波动九次谐波等级 -->
                    <th width="150" data-options="field:'cw_rfv_oa_9h_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_rfv_oa_9h_rank_s" /></th>
                    <!-- 径向力波动十次谐波值 -->
                    <th width="150" data-options="field:'cw_rfv_oa_10h_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_rfv_oa_10h_kgf_s" /></th>
                    <!-- 径向力波动十次谐波角度 -->
                    <th width="150" data-options="field:'cw_rfv_oa_10h_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_rfv_oa_10h_deg_s" /></th>
                    <!-- 径向力波动十次谐波等级 -->
                    <th width="150" data-options="field:'cw_rfv_oa_10h_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_rfv_oa_10h_rank_s" /></th>
                	
                    <!-- 侧向力波动值 -->
                    <th width="100" data-options="field:'cw_lfv_oa_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_lfv_oa_kgf_s" /></th>
                	<!-- 侧向力波动角度 -->
                    <th width="100" data-options="field:'cw_lfv_oa_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_lfv_oa_deg_s" /></th>
                	<!-- 侧向力波动等级 -->
                    <th width="100" data-options="field:'cw_lfv_oa_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_lfv_oa_rank_s" /></th>
                    <!-- 侧向力波动一次谐波值 -->
                    <th width="150" data-options="field:'cw_lfv_oa_1h_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_lfv_oa_1h_kgf_s" /></th>
                    <!-- 侧向力波动一次谐波角度 -->
                    <th width="150" data-options="field:'cw_lfv_oa_1h_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_lfv_oa_1h_deg_s" /></th>
                    <!-- 侧向力波动一次谐波等级 -->
                    <th width="150" data-options="field:'cw_lfv_oa_1h_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_lfv_oa_1h_rank_s" /></th>
                    <!-- 侧向力波动二次谐波值 -->
                    <th width="150" data-options="field:'cw_lfv_oa_2h_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_lfv_oa_2h_kgf_s" /></th>
                    <!-- 侧向力波动二次谐波角度 -->
                    <th width="150" data-options="field:'cw_lfv_oa_2h_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_lfv_oa_2h_deg_s" /></th>
                    <!-- 侧向力波动二次谐波等级 -->
                    <th width="150" data-options="field:'cw_lfv_oa_2h_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_lfv_oa_2h_rank_s" /></th>
                    <!-- 侧向力波动三次谐波值 -->
                    <th width="150" data-options="field:'cw_lfv_oa_3h_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_lfv_oa_3h_kgf_s" /></th>
                    <!-- 侧向力波动三次谐波角度 -->
                    <th width="150" data-options="field:'cw_lfv_oa_3h_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_lfv_oa_3h_deg_s" /></th>
                    <!-- 侧向力波动三次谐波等级 -->
                    <th width="150" data-options="field:'cw_lfv_oa_3h_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_lfv_oa_3h_rank_s" /></th>
                    <!-- 侧向力波动四次谐波值 -->
                    <th width="150" data-options="field:'cw_lfv_oa_4h_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_lfv_oa_4h_kgf_s" /></th>
                    <!-- 侧向力波动四次谐波角度 -->
                    <th width="150" data-options="field:'cw_lfv_oa_4h_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_lfv_oa_4h_deg_s" /></th>
                    <!-- 侧向力波动四次谐波等级 -->
                    <th width="150" data-options="field:'cw_lfv_oa_4h_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_lfv_oa_4h_rank_s" /></th>
                    <!-- 侧向力波动五次谐波值 -->
                    <th width="150" data-options="field:'cw_lfv_oa_5h_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_lfv_oa_5h_kgf_s" /></th>
                    <!-- 侧向力波动五次谐波角度 -->
                    <th width="150" data-options="field:'cw_lfv_oa_5h_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_lfv_oa_5h_deg_s" /></th>
                    <!-- 侧向力波动五次谐波等级 -->
                    <th width="150" data-options="field:'cw_lfv_oa_5h_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_lfv_oa_5h_rank_s" /></th>
                    <!-- 侧向力波动六次谐波值 -->
                    <th width="150" data-options="field:'cw_lfv_oa_6h_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_lfv_oa_6h_kgf_s" /></th>
                    <!-- 侧向力波动六次谐波角度 -->
                    <th width="150" data-options="field:'cw_lfv_oa_6h_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_lfv_oa_6h_deg_s" /></th>
                    <!-- 侧向力波动六次谐波等级 -->
                    <th width="150" data-options="field:'cw_lfv_oa_6h_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_lfv_oa_6h_rank_s" /></th>
                    <!-- 侧向力波动七次谐波值 -->
                    <th width="150" data-options="field:'cw_lfv_oa_7h_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_lfv_oa_7h_kgf_s" /></th>
                    <!-- 侧向力波动七次谐波角度 -->
                    <th width="150" data-options="field:'cw_lfv_oa_7h_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_lfv_oa_7h_deg_s" /></th>
                    <!-- 侧向力波动七次谐波等级 -->
                    <th width="150" data-options="field:'cw_lfv_oa_7h_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_lfv_oa_7h_rank_s" /></th>
                    <!-- 侧向力波动八次谐波值 -->
                    <th width="150" data-options="field:'cw_lfv_oa_8h_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_lfv_oa_8h_kgf_s" /></th>
                    <!-- 侧向力波动八次谐波角度 -->
                    <th width="150" data-options="field:'cw_lfv_oa_8h_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_lfv_oa_8h_deg_s" /></th>
                    <!-- 侧向力波动八次谐波等级 -->
                    <th width="150" data-options="field:'cw_lfv_oa_8h_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_lfv_oa_8h_rank_s" /></th>
                    <!-- 侧向力波动九次谐波值 -->
                    <th width="150" data-options="field:'cw_lfv_oa_9h_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_lfv_oa_9h_kgf_s" /></th>
                    <!-- 侧向力波动九次谐波角度 -->
                    <th width="150" data-options="field:'cw_lfv_oa_9h_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_lfv_oa_9h_deg_s" /></th>
                    <!-- 侧向力波动九次谐波等级 -->
                    <th width="150" data-options="field:'cw_lfv_oa_9h_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_lfv_oa_9h_rank_s" /></th>
                    <!-- 侧向力波动十次谐波值 -->
                    <th width="150" data-options="field:'cw_lfv_oa_10h_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_lfv_oa_10h_kgf_s" /></th>
                    <!-- 侧向力波动十次谐波角度 -->
                    <th width="150" data-options="field:'cw_lfv_oa_10h_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_lfv_oa_10h_deg_s" /></th>
                    <!-- 侧向力波动十次谐波等级 -->
                    <th width="150" data-options="field:'cw_lfv_oa_10h_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_lfv_oa_10h_rank_s" /></th>
                    
                
                	<!-- 正转侧向力偏移值 -->
                    <th width="120" data-options="field:'cw_lfd_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_lfd_kgf_s" /></th>
                    <!-- 正转侧向力偏移等级 -->
                    <th width="120" data-options="field:'cw_lfd_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.cw_lfd_rank_s" /></th>
                   
                
                    <!-- 反转径向力波动值 -->
                    <th width="150" data-options="field:'ccw_rfv_oa_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_rfv_oa_kgf_s" /></th>
                	<!-- 反转径向力波动角度 -->
                    <th width="150" data-options="field:'ccw_rfv_oa_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_rfv_oa_deg_s" /></th>
                    <!-- 反转径向力波动等级 -->
                    <th width="150" data-options="field:'ccw_rfv_oa_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_rfv_oa_rank_s" /></th>
                    <!-- 反转径向力波动一次谐波值 -->
                    <th width="170" data-options="field:'ccw_rfv_oa_1h_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_rfv_oa_1h_kgf_s" /></th>
                    <!-- 反转径向力波动一次谐波角度 -->
                    <th width="170" data-options="field:'ccw_rfv_oa_1h_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_rfv_oa_1h_deg_s" /></th>
                    <!-- 反转径向力波动一次谐波等级 -->
                    <th width="170" data-options="field:'ccw_rfv_oa_1h_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_rfv_oa_1h_rank_s" /></th>
                    <!-- 反转径向力波动二次谐波值 -->
                    <th width="170" data-options="field:'ccw_rfv_oa_2h_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_rfv_oa_2h_kgf_s" /></th>
                    <!-- 反转径向力波动二次谐波角度 -->
                    <th width="170" data-options="field:'ccw_rfv_oa_2h_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_rfv_oa_2h_deg_s" /></th>
                    <!-- 反转径向力波动二次谐波等级 -->
                    <th width="170" data-options="field:'ccw_rfv_oa_2h_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_rfv_oa_2h_rank_s" /></th>
                    <!-- 反转径向力波动三次谐波值 -->
                    <th width="170" data-options="field:'ccw_rfv_oa_3h_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_rfv_oa_3h_kgf_s" /></th>
                    <!-- 反转径向力波动三次谐波角度 -->
                    <th width="170" data-options="field:'ccw_rfv_oa_3h_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_rfv_oa_3h_deg_s" /></th>
                    <!-- 反转径向力波动三次谐波等级 -->
                    <th width="170" data-options="field:'ccw_rfv_oa_3h_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_rfv_oa_3h_rank_s" /></th>
                    <!-- 反转径向力波动四次谐波值 -->
                    <th width="170" data-options="field:'ccw_rfv_oa_4h_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_rfv_oa_4h_kgf_s" /></th>
                    <!-- 反转径向力波动四次谐波角度 -->
                    <th width="170" data-options="field:'ccw_rfv_oa_4h_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_rfv_oa_4h_deg_s" /></th>
                    <!-- 反转径向力波动四次谐波等级 -->
                    <th width="170" data-options="field:'ccw_rfv_oa_4h_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_rfv_oa_4h_rank_s" /></th>
                    <!-- 反转径向力波动五次谐波值 -->
                    <th width="170" data-options="field:'ccw_rfv_oa_5h_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_rfv_oa_5h_kgf_s" /></th>
                    <!-- 反转径向力波动五次谐波角度 -->
                    <th width="170" data-options="field:'ccw_rfv_oa_5h_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_rfv_oa_5h_deg_s" /></th>
                    <!-- 反转径向力波动五次谐波等级 -->
                    <th width="170" data-options="field:'ccw_rfv_oa_5h_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_rfv_oa_5h_rank_s" /></th>
                    <!-- 反转径向力波动六次谐波值 -->
                    <th width="170" data-options="field:'ccw_rfv_oa_6h_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_rfv_oa_6h_kgf_s" /></th>
                    <!-- 反转径向力波动六次谐波角度 -->
                    <th width="170" data-options="field:'ccw_rfv_oa_6h_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_rfv_oa_6h_deg_s" /></th>
                    <!-- 反转径向力波动六次谐波等级 -->
                    <th width="170" data-options="field:'ccw_rfv_oa_6h_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_rfv_oa_6h_rank_s" /></th>
                    <!-- 反转径向力波动七次谐波值 -->
                    <th width="170" data-options="field:'ccw_rfv_oa_7h_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_rfv_oa_7h_kgf_s" /></th>
                    <!-- 反转径向力波动七次谐波角度 -->
                    <th width="170" data-options="field:'ccw_rfv_oa_7h_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_rfv_oa_7h_deg_s" /></th>
                    <!-- 反转径向力波动七次谐波等级 -->
                    <th width="170" data-options="field:'ccw_rfv_oa_7h_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_rfv_oa_7h_rank_s" /></th>
                    <!-- 反转径向力波动八次谐波值 -->
                    <th width="170" data-options="field:'ccw_rfv_oa_8h_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_rfv_oa_8h_kgf_s" /></th>
                    <!-- 反转径向力波动八次谐波角度 -->
                    <th width="170" data-options="field:'ccw_rfv_oa_8h_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_rfv_oa_8h_deg_s" /></th>
                    <!-- 反转径向力波动八次谐波等级 -->
                    <th width="170" data-options="field:'ccw_rfv_oa_8h_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_rfv_oa_8h_rank_s" /></th>
                    <!-- 反转径向力波动九次谐波值 -->
                    <th width="170" data-options="field:'ccw_rfv_oa_9h_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_rfv_oa_9h_kgf_s" /></th>
                    <!-- 反转径向力波动九次谐波角度 -->
                    <th width="170" data-options="field:'ccw_rfv_oa_9h_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_rfv_oa_9h_deg_s" /></th>
                    <!-- 反转径向力波动九次谐波等级 -->
                    <th width="170" data-options="field:'ccw_rfv_oa_9h_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_rfv_oa_9h_rank_s" /></th>
                    <!-- 反转径向力波动十次谐波值 -->
                    <th width="170" data-options="field:'ccw_rfv_oa_10h_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_rfv_oa_10h_kgf_s" /></th>
                    <!-- 反转径向力波动十次谐波角度 -->
                    <th width="170" data-options="field:'ccw_rfv_oa_10h_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_rfv_oa_10h_deg_s" /></th>
                    <!-- 反转径向力波动十次谐波等级 -->
                    <th width="170" data-options="field:'ccw_rfv_oa_10h_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_rfv_oa_10h_rank_s" /></th>
                    
                
                   
                    <!-- 反转侧向力波动值 -->
                    <th width="120" data-options="field:'ccw_lfv_oa_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_lfv_oa_kgf_s" /></th>
                    <!-- 反转侧向力波动角度 -->
                    <th width="120" data-options="field:'ccw_lfv_oa_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_lfv_oa_deg_s" /></th>
                    <!-- 反转侧向力波动等级 -->
                    <th width="120" data-options="field:'ccw_lfv_oa_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_lfv_oa_rank_s" /></th>
                    <!-- 反转侧向力波动一次谐波值 -->
                    <th width="170" data-options="field:'ccw_lfv_oa_1h_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_lfv_oa_1h_kgf_s" /></th>
                    <!-- 反转侧向力波动一次谐波角度 -->
                    <th width="170" data-options="field:'ccw_lfv_oa_1h_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_lfv_oa_1h_deg_s" /></th>
                    <!-- 反转侧向力波动一次谐波等级 -->
                    <th width="170" data-options="field:'ccw_lfv_oa_1h_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_lfv_oa_1h_rank_s" /></th>
                    <!-- 反转侧向力波动二次谐波值 -->
                    <th width="170" data-options="field:'ccw_lfv_oa_2h_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_lfv_oa_2h_kgf_s" /></th>
                    <!-- 反转侧向力波动二次谐波角度 -->
                    <th width="170" data-options="field:'ccw_lfv_oa_2h_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_lfv_oa_2h_deg_s" /></th>
                    <!-- 反转侧向力波动二次谐波等级 -->
                    <th width="170" data-options="field:'ccw_lfv_oa_2h_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_lfv_oa_2h_rank_s" /></th>
                    <!-- 反转侧向力波动三次谐波值 -->
                    <th width="170" data-options="field:'ccw_lfv_oa_3h_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_lfv_oa_3h_kgf_s" /></th>
                    <!-- 反转侧向力波动三次谐波角度 -->
                    <th width="170" data-options="field:'ccw_lfv_oa_3h_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_lfv_oa_3h_deg_s" /></th>
                    <!-- 反转侧向力波动三次谐波等级 -->
                    <th width="170" data-options="field:'ccw_lfv_oa_3h_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_lfv_oa_3h_rank_s" /></th>
                    <!-- 反转侧向力波动四次谐波值 -->
                    <th width="170" data-options="field:'ccw_lfv_oa_4h_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_lfv_oa_4h_kgf_s" /></th>
                    <!-- 反转侧向力波动四次谐波角度 -->
                    <th width="170" data-options="field:'ccw_lfv_oa_4h_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_lfv_oa_4h_deg_s" /></th>
                    <!-- 反转侧向力波动四次谐波等级 -->
                    <th width="170" data-options="field:'ccw_lfv_oa_4h_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_lfv_oa_4h_rank_s" /></th>
                    <!-- 反转侧向力波动五次谐波值 -->
                    <th width="170" data-options="field:'ccw_lfv_oa_5h_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_lfv_oa_5h_kgf_s" /></th>
                    <!-- 反转侧向力波动五次谐波角度 -->
                    <th width="170" data-options="field:'ccw_lfv_oa_5h_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_lfv_oa_5h_deg_s" /></th>
                    <!-- 反转侧向力波动五次谐波等级 -->
                    <th width="170" data-options="field:'ccw_lfv_oa_5h_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_lfv_oa_5h_rank_s" /></th>
                    <!-- 反转侧向力波动六次谐波值 -->
                    <th width="170" data-options="field:'ccw_lfv_oa_6h_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_lfv_oa_6h_kgf_s" /></th>
                    <!-- 反转侧向力波动六次谐波角度 -->
                    <th width="170" data-options="field:'ccw_lfv_oa_6h_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_lfv_oa_6h_deg_s" /></th>
                    <!-- 反转侧向力波动六次谐波等级 -->
                    <th width="170" data-options="field:'ccw_lfv_oa_6h_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_lfv_oa_6h_rank_s" /></th>
                    <!-- 反转侧向力波动七次谐波值 -->
                    <th width="170" data-options="field:'ccw_lfv_oa_7h_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_lfv_oa_7h_kgf_s" /></th>
                    <!-- 反转侧向力波动七次谐波角度 -->
                    <th width="170" data-options="field:'ccw_lfv_oa_7h_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_lfv_oa_7h_deg_s" /></th>
                    <!-- 反转侧向力波动七次谐波等级 -->
                    <th width="170" data-options="field:'ccw_lfv_oa_7h_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_lfv_oa_7h_rank_s" /></th>
                    <!-- 反转侧向力波动八次谐波值 -->
                    <th width="170" data-options="field:'ccw_lfv_oa_8h_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_lfv_oa_8h_kgf_s" /></th>
                    <!-- 反转侧向力波动八次谐波角度 -->
                    <th width="170" data-options="field:'ccw_lfv_oa_8h_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_lfv_oa_8h_deg_s" /></th>
                    <!-- 反转侧向力波动八次谐波等级 -->
                    <th width="170" data-options="field:'ccw_lfv_oa_8h_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_lfv_oa_8h_rank_s" /></th>
                    <!-- 反转侧向力波动九次谐波值 -->
                    <th width="170" data-options="field:'ccw_lfv_oa_9h_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_lfv_oa_9h_kgf_s" /></th>
                    <!-- 反转侧向力波动九次谐波角度 -->
                    <th width="170" data-options="field:'ccw_lfv_oa_9h_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_lfv_oa_9h_deg_s" /></th>
                    <!-- 反转侧向力波动九次谐波等级 -->
                    <th width="170" data-options="field:'ccw_lfv_oa_9h_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_lfv_oa_9h_rank_s" /></th>
                    <!-- 反转侧向力波动十次谐波值 -->
                    <th width="170" data-options="field:'ccw_lfv_oa_10h_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_lfv_oa_10h_kgf_s" /></th>
                    <!-- 反转侧向力波动十次谐波角度 -->
                    <th width="170" data-options="field:'ccw_lfv_oa_10h_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_lfv_oa_10h_deg_s" /></th>
                    <!-- 反转侧向力波动十次谐波等级 -->
                    <th width="170" data-options="field:'ccw_lfv_oa_10h_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_lfv_oa_10h_rank_s" /></th>
                    
                    
                    <!-- 反转侧向力偏移值 -->
                    <th width="120" data-options="field:'ccw_lfd_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_lfd_kgf_s" /></th>
                    <!-- 反转侧向力偏移等级 -->
                    <th width="120" data-options="field:'ccw_lfd_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ccw_lfd_rank_s" /></th>
                   
                   
                    <!-- 锥度值 -->
                    <th width="80" data-options="field:'con_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.con_kgf_s" /></th>
                    <!-- 锥度等级 -->
                    <th width="80" data-options="field:'con_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.con_rank_s" /></th>
                    
                    
                    <!-- 帘布效应（跑偏，角度效应） -->
                    <th width="170" data-options="field:'ply_kgf_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ply_kgf_s" /></th>
                    <!-- 帘布效应等级 -->
                    <th width="100" data-options="field:'ply_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.ply_rank_s" /></th>
                    
                    
                    <!-- 上部侧向跳动值 -->
                    <th width="120" data-options="field:'lt_oa_mm_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.lt_oa_mm_s" /></th>
                    <!-- 上部侧向跳动角度 -->
                    <th width="120" data-options="field:'lt_oa_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.lt_oa_deg_s" /></th>
                    <!-- 上部侧向跳动等级 -->
                    <th width="120" data-options="field:'lt_oa_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.lt_oa_rank_s" /></th>
                    <!-- 上部侧向跳动一次谐波值 -->
                    <th width="170" data-options="field:'lt_oa_1h_mm_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.lt_oa_1h_mm_s" /></th>
                    <!-- 上部侧向跳动一次谐波角度 -->
                    <th width="170" data-options="field:'lt_oa_1h_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.lt_oa_1h_deg_s" /></th>
                    <!-- 上部侧向跳动一次谐波等级 -->
                    <th width="170" data-options="field:'lt_oa_1h_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.lt_oa_1h_rank_s" /></th>
                    
                    
                    <!-- 下部侧向跳动值 -->
                    <th width="120" data-options="field:'lb_oa_mm_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.lb_oa_mm_s" /></th>
                    <!-- 下部侧向跳动角度 -->
                    <th width="120" data-options="field:'lb_oa_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.lb_oa_deg_s" /></th>
                    <!-- 下部侧向跳动等级 -->
                    <th width="120" data-options="field:'lb_oa_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.lb_oa_rank_s" /></th>
                    <!-- 下部侧向跳动一次谐波值 -->
                    <th width="170" data-options="field:'lb_oa_1h_mm_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.lb_oa_1h_mm_s" /></th>
                    <!-- 下部侧向跳动一次谐波角度 -->
                    <th width="170" data-options="field:'lb_oa_1h_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.lb_oa_1h_deg_s" /></th>
                    <!-- 下部侧向跳动一次谐波等级 -->
                    <th width="170" data-options="field:'lb_oa_1h_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.lb_oa_1h_rank_s" /></th>
                  
                    <!-- 上部径向跳动值 -->
                    <th width="120" data-options="field:'rt_oa_mm_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.rt_oa_mm_s" /></th>
                    <!-- 上部径向跳动角度 -->
                    <th width="120" data-options="field:'rt_oa_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.rt_oa_deg_s" /></th>
                    <!-- 上部径向跳动等级 -->
                    <th width="120" data-options="field:'rt_oa_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.rt_oa_rank_s" /></th>
                    <!-- 上部径向跳动一次谐波值 -->
                    <th width="170" data-options="field:'rt_oa_1h_mm_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.rt_oa_1h_mm_s" /></th>
                    <!-- 上部径向跳动一次谐波角度 -->
                    <th width="170" data-options="field:'rt_oa_1h_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.rt_oa_1h_deg_s" /></th>
                    <!-- 上部径向跳动一次谐波等级 -->
                    <th width="170" data-options="field:'rt_oa_1h_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.rt_oa_1h_rank_s" /></th>
                    
                    <!-- 中部径向跳动值 -->
                    <th width="120" data-options="field:'rc_oa_mm_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.rc_oa_mm_s" /></th>
                    <!-- 中部径向跳动角度 -->
                    <th width="120" data-options="field:'rc_oa_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.rc_oa_deg_s" /></th>
                    <!-- 中部径向跳动等级 -->
                    <th width="120" data-options="field:'rc_oa_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.rc_oa_rank_s" /></th>
                    <!-- 中部径向跳动一次谐波值 -->
                    <th width="170" data-options="field:'rc_oa_1h_mm_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.rc_oa_1h_mm_s" /></th>
                    <!-- 中部径向跳动一次谐波角度 -->
                    <th width="170" data-options="field:'rc_oa_1h_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.rc_oa_1h_deg_s" /></th>
                    <!-- 中部径向跳动一次谐波等级 -->
                    <th width="170" data-options="field:'rc_oa_1h_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.rc_oa_1h_rank_s" /></th>
                    
                    <!-- 下部径向跳动值 -->
                    <th width="120" data-options="field:'rb_oa_mm_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.rb_oa_mm_s" /></th>
                    <!-- 下部径向跳动角度 -->
                    <th width="120" data-options="field:'rb_oa_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.rb_oa_deg_s" /></th>
                    <!-- 下部径向跳动等级 -->
                    <th width="120" data-options="field:'rb_oa_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.rb_oa_rank_s" /></th>
                    <!-- 下部径向跳动一次谐波值 -->
                    <th width="170" data-options="field:'rb_oa_1h_mm_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.rb_oa_1h_mm_s" /></th>
                    <!-- 下部径向跳动一次谐波角度 -->
                    <th width="170" data-options="field:'rb_oa_1h_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.rb_oa_1h_deg_s" /></th>
                    <!-- 下部径向跳动一次谐波等级 -->
                    <th width="170" data-options="field:'rb_oa_1h_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.rb_oa_1h_rank_s" /></th>
                   
                    
                    <!-- 上部侧向凸值 -->
                    <th width="120" data-options="field:'lt_bulging_mm_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.lt_bulging_mm_s" /></th>
                    <!-- 上部侧向凸角度 -->
                    <th width="120" data-options="field:'lt_bulging_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.lt_bulging_deg_s" /></th>
                    <!-- 上部侧向凸等级 -->
                    <th width="120" data-options="field:'lt_bulging_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.lt_bulging_rank_s" /></th>
                    <!-- 上部侧向凹值 -->
                    <th width="120" data-options="field:'lt_dent_mm_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.lt_dent_mm_s" /></th>
                    <!-- 上部侧向凹角度 -->
                    <th width="120" data-options="field:'lt_dent_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.lt_dent_deg_s" /></th>
                    <!-- 上部侧向凹等级 -->
                    <th width="120" data-options="field:'lt_dent_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.lt_dent_rank_s" /></th>
                     
                    <!-- 下部侧向凸值 -->
                    <th width="120" data-options="field:'lb_bulging_mm_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.lb_bulging_mm_s" /></th>
                    <!-- 下部侧向凸角度 -->
                    <th width="120" data-options="field:'lb_bulging_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.lb_bulging_deg_s" /></th>
                    <!-- 下部侧向凸等级 -->
                    <th width="120" data-options="field:'lb_bulging_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.lb_bulging_rank_s" /></th>
                    <!-- 下部侧向凹值 -->
                    <th width="120" data-options="field:'lb_dent_mm_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.lb_dent_mm_s" /></th>
                    <!-- 下部侧向凹角度 -->
                    <th width="120" data-options="field:'lb_dent_deg_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.lb_dent_deg_s" /></th>
                    <!-- 下部侧向凹等级 -->
                    <th width="120" data-options="field:'lb_dent_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.lb_dent_rank_s" /></th>
                    
                    
                    <!-- 轮胎外直径 -->
                    <th width="100" data-options="field:'outside_diameter_mm_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.outside_diameter_mm_s" /></th>
                    <!-- 轮胎外直径等级 -->
                    <th width="120" data-options="field:'outside_diameter_rank_s',editor:{type:'textbox'}"><spring:message code="checkuniformlog.column.outside_diameter_rank_s" /></th>
                  
                   </tr>
            </thead>
        </table>
    </div>


    <jsp:include page="../../../../inc/export.jsp">
        <jsp:param name="idField" value="atr_key"/>
        <jsp:param name="formId" value="Checkuniformlog_search_form"/>
        <jsp:param name="datagridId" value="checkuniformlog_dg"/>
        <jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.finalcheck.excel.CheckuniformlogExportHandler"/>
        <jsp:param name="serviceName" value="CheckuniformlogServiceImpl"/>
    </jsp:include>
</body>
</html>
