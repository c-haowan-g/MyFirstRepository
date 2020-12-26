<!-- 

    作者      :刘朋
    时间      :2019-01-18 15:32:07 
    页面名称:质检动平衡检测结果表(国际计测)
    文件关联:
        Balandproresult.java
        BalandproresultController.java
        BalandproresultServiceImpl.java
        BalandproresultServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="balandproresult.js.jsp"%>
<script type="text/javascript" src="dict/253.js"></script>


<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="Balandproresult_dg_toolbar">
            <form id="Balandproresult_search_form" class="form" >
               <table class="formTable" >
               				<spring:message code="sortdynabalancelog.column.sorttime_t" />:
							<!-- 操作时间 --> <input name="filter[begin_created_time]" editable="true" id="begin_created_time" type="text" class="easyui-textbox" style="width:150px" data-options="label:''"> 到 <input
							name="filter[end_created_time]" editable="true" id="end_created_time" class="easyui-datetimebox" style="width:150px">
						
							<!-- 动平衡机台条码 --> <spring:message code="dynabalancecheresult.column.machinebar_s" />:
						<input type="text" class="easyui-combobox" style="width:120px" name="filter[machinebar_s]" id="machinebar_s" style="width:120px"
							data-options="  label:'',
							required:false, 
	                		width:200,
	                		data:entCodeName,
				   			method: 'get',
				   			url:'finalcheck/baseData/entmodel/SearchEnt?equip_type=254004',
				   			panelHeight:200,
				    		valueField:'EQUIP_NAME',
				    		textField:'DESCRIPTION'
				    		">
							<!-- 物料编码 --> <spring:message code="hhhh.column.material_code_s" /> :
							<input name="filter[sap_item_s]" style="width:110px" like="true" id="sap_item_s" type="text" class="easyui-textbox" data-options="label:'',width:'100px'">
							<br/>
							<!-- 轮胎条码 --> 
							<spring:message code="dynabalancecheresult.column.barcode_s" />:
							<input name="filter[barcode_s]" id="barcode_s"  type="text" style="width:110px" class="easyui-textbox" data-options="label:''">
						
							  <!-- 硫化等级 -->
							<spring:message code="dynabalancecheresult.column.tire_total_ratings_s" />:
							<input name="filter[grade_code_s]" id="grade_code_s" like="true" style="width:110px;" type="text" class="easyui-combotree" data-options="label:'',
									                  labelWidth:'auto',
													  panelHeight:150,
													  required:false,
													  url:'dict/code/253',
													  method:'get'">
						
						<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
				</table>
			</form>
			<auth:button code="ZJ_ZJLL_QUAN_GANG_DPHJCLLPG_EXPORT">
				<a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="exportExcel()"><spring:message code="button.export" /></a>
			</auth:button>
			<auth:button code="ZJ_ZJLL_QUAN_GANG_DPHJCLLPG_SEARCHBAR">
				<a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-hide'" onclick="searchBar()"><spring:message code="button.searchColumn" /></a>
			</auth:button>
			</div>
        <table id="balandproresult_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                autoRowHeight:false,
                nowrap:true,
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#Balandproresult_dg_toolbar',
                emptyMsg: '<span><spring:message code='tip.noData'/></span>',
                striped:true,
                method: 'get'
               
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true" rowspan="2">ID</th>
					<!-- 动平衡机台条码：D_EM_Ent 表 ENTBARCODE -->
					<th width="80" rowspan="2" data-options="field:'machinebar_s',formatter:entCodeFormatter"><spring:message code="dynabalancecheresult.column.machinebar_s" /></th>
                    <!-- 轮胎条码：MainTyre.BARCODE -->
                    <th width="80" rowspan="2" data-options="field:'barcode_s',width:80"><spring:message code="balandproresult.column.barcode_s" /></th>
                     <!-- SAP品号 -->
                    <th width="80" rowspan="2" data-options="field:'curingspeccode_s',width:80"><spring:message code="balandproresult.column.sap_item_s" /></th>
                    <!-- 物料描述 -->
					<th  width="230" rowspan="2" data-options="field:'description'"><spring:message code="hhhh.column.material_name_s" /></th>
					<!-- 创建时间 -->
                    <th width="130" rowspan="2" data-options="field:'created_time_t'"><spring:message code="balandproresult.column.created_time_t" /></th>
					<!-- 成型机台 -->
					<th width="70" rowspan="2" data-options="field:'buildinmachinecode_s'"><spring:message code="maintyrecurlog.column.buildinmachinecode_s" /></th>
					<!-- 成型时间 -->
					<th width="130" rowspan="2" data-options="field:'buildintime_t'"><spring:message code="maintyrecurlog.column.buildintime_t" /></th>
					<!-- 硫化机台 -->
					<th width="70" rowspan="2" data-options="field:'curingmachinecode_s'"><spring:message code="curingalarmcount.column.curingequip_code_s" /></th>
					<!-- 硫化时间 -->
					<th width="130" rowspan="2" data-options="field:'curingtime_t'"><spring:message code="curingalarmcount.column.curingtime_t" /></th>
					<!-- 轮胎总等级 -->
					<th width="80" rowspan="2" data-options="field:'grade_code_s',formatter:codeFormatter"><spring:message code="dynabalancecheresult.column.tire_total_ratings_s" /></th>
					 <!-- 动平衡总等级 -->
                    <th width="80" rowspan="2" data-options="field:'balance_total_rank_s',width:80,editor:{type:'textbox'}"><spring:message code="balandproresult.column.balance_total_rank_s" /></th>
                    <!-- 跳动度总等级 -->
                    <th width="80" rowspan="2" data-options="field:'ro_total_rank_s',width:80,editor:{type:'textbox'}"><spring:message code="balandproresult.column.ro_total_rank_s" /></th>
                    <th colspan="3">Upper</th>
                    <th colspan="3">Lower</th>
                    <th colspan="2">Up+Lo</th>
                    <th colspan="3">Static</th>
                    <th colspan="3">Couple</th>
                    <th colspan="3">LRO-T1 OA</th>
                    <th colspan="3">LRO-T2 OA</th>
                    <th colspan="3">LRO-T3 OA</th>
                    <th colspan="3">LRO-B1 OA</th>
                    <th colspan="3">LRO-B2 OA</th>
                    <th colspan="3">LRO-B3 OA</th>
                    <th colspan="3">RRO-T OA</th>
                    <th colspan="3">RRO-C OA</th>
                    <th colspan="3">RRO-B OA</th>
                    <th colspan="3">LRO-T1 1'ST</th>
                    <th colspan="3">LRO-T2 2'ST</th>
                    <th colspan="3">LRO-T3 3'ST</th>
                    <th colspan="3">LRO-B1 1'ST</th>
                    <th colspan="3">LRO-B2 2'ST</th>
                    <th colspan="3">LRO-B3 3'ST</th>
                    <th colspan="3">RRO-T 1'ST</th>
                    <th colspan="3">RRO-C 1'ST</th>
                    <th colspan="3">RRO-B 1'ST</th>
                    <th colspan="3">LRO-T1 Nth</th>
                    <th colspan="3">LRO-T2 Nth</th>
                    <th colspan="3">LRO-T3 Nth</th>
                    <th colspan="3">LRO-B1 Nth</th>
                    <th colspan="3">LRO-B2 Nth</th>
                    <th colspan="3">LRO-B3 Nth</th>
                    <th colspan="3">RRO-T Nth</th>
                    <th colspan="3">RRO-C Nth</th>
                    <th colspan="3">RRO-B Nth</th>
                    <th colspan="3">LRO-T1 Bulge</th>
                    <th colspan="3">LRO-T2 Bulge</th>
                    <th colspan="3">LRO-T3 Bulge</th>
                    <th colspan="3">LRO-B1 Bulge</th>
                    <th colspan="3">LRO-B2 Bulge</th>
                    <th colspan="3">LRO-B3 Bulge</th>
                    <th colspan="3">LRO-T1 Dent</th>
                    <th colspan="3">LRO-T2 Dent</th>
                    <th colspan="3">LRO-T3 Dent</th>
                    <th colspan="3">LRO-B1 Dent</th>
                    <th colspan="3">LRO-B2 Dent</th>
                    <th colspan="3">LRO-B3 Dent</th>
                    
                    
                     <%--  <!-- 测试模式1：精度测试0：正常测试 -->
                    <th width="80" rowspan="2" data-options="field:'testmode_s',formatter:testmodeFormatter,width:80,editor:{type:'textbox'}"><spring:message code="balandproresult.column.testmode_s" /></th>
                    
                    <!-- 修改人 -->
                    <th width="80" rowspan="2" data-options="field:'changed_by',width:80,editor:{type:'textbox'}"><spring:message code="balandproresult.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th width="80" rowspan="2" data-options="field:'changed_time_t',width:80,editor:{type:'textbox'}"><spring:message code="balandproresult.column.changed_time_t" /></th>
                     --%>
                    <!-- 创建人 -->
                    <th width="80" rowspan="2" data-options="field:'created_by',width:80,editor:{type:'textbox'}"><spring:message code="balandproresult.column.created_by_s" /></th>
                </tr>
                <tr>
                	<!-- 上面不平衡量 -->
                    <th width="80" data-options="field:'upper_unbalance_g_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.amount_g" /></th>
                	<!-- 上面不平衡量角度 -->
                    <th width="80" data-options="field:'upper_unbalance_deg_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.angle_deg" /></th>
                    <!-- 上面不平衡量等级 -->
                    <th width="80" data-options="field:'upper_unbalance_rank_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.rank" /></th>
                   
                    <!-- 下面不平衡量 -->
                    <th width="80" data-options="field:'lower_unbalance_g_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.amount_g" /></th>
                	<!-- 下面不平衡量角度 -->
                    <th width="80" data-options="field:'lower_unbalance_deg_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.angle_deg" /></th>
                    <!-- 下面不平衡量等级 -->
                    <th width="80" data-options="field:'lower_unbalance_rank_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.rank" /></th>
                    
                    <!-- 上面+下面不平衡量 -->
                    <th width="80" data-options="field:'up_low_unbalance_g_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.amount_g" /></th>
                    <!-- 上面+下面不平衡量等级 -->
                    <th width="80" data-options="field:'up_low_unbalance_rank_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.rank" /></th>
                	
                	<!-- 静合成不平衡量 -->
                    <th width="80" data-options="field:'static_unbalance_g_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.amount_g_cm" /></th>
                    <!-- 静合成不平衡量角度 -->
                    <th width="80" data-options="field:'static_unbalance_deg_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.angle_deg" /></th>
                    <!-- 静合成不平衡量等级 -->
                    <th width="80" data-options="field:'static_unbalance_rank_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.rank" /></th>
                
                 	<!-- 偶不平衡量 -->
                    <th width="80" data-options="field:'couple_unbalance_g_s'"><spring:message code="balandproresult.column.amount_g" /></th>
                    <!-- 偶不平衡量角度 -->
                    <th width="80" data-options="field:'couple_unbalance_deg_s'"><spring:message code="balandproresult.column.angle_deg" /></th>
                    <!-- 偶不平衡量等级 -->
                    <th width="80" data-options="field:'couple_unbalance_rank_s'"><spring:message code="balandproresult.column.rank" /></th>
                   
                    <!-- 上部侧向跳动值1 -->
                    <th width="80" data-options="field:'lt_oa_mm_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.amount_value" /></th>
                    <!-- 上部侧向跳动角度1 -->
                    <th width="80" data-options="field:'lt_oa_deg_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.angle" /></th>
                    <!-- 上部侧向跳动等级1 -->
                    <th width="80" data-options="field:'lt_oa_rank_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.rank" /></th>
                    <!-- 上部侧向跳动值2 -->
                    <th width="80" data-options="field:'lt_oa2_mm_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.amount_value" /></th>
                    <!-- 上部侧向跳动角度2 -->
                    <th width="80" data-options="field:'lt_oa2_deg_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.angle" /></th>
                    <!-- 上部侧向跳动等级2 -->
                    <th width="80" data-options="field:'lt_oa2_rank_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.rank" /></th>
                    <!-- 上部侧向跳动值3 -->
                    <th width="80" data-options="field:'lt_oa3_mm_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.amount_value" /></th>
                    <!-- 上部侧向跳动角度3 -->
                    <th width="80" data-options="field:'lt_oa3_deg_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.angle" /></th>
                    <!-- 上部侧向跳动等级3 -->
                    <th width="80" data-options="field:'lt_oa3_rank_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.rank" /></th>
                    
                    <!-- 下部侧向跳动值1 -->
                    <th width="80" data-options="field:'lb_oa_mm_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.amount_value" /></th>
                    <!-- 下部侧向跳动角度1 -->
                    <th width="80" data-options="field:'lb_oa_deg_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.angle" /></th>
                    <!-- 下部侧向跳动等级1 -->
                    <th width="80" data-options="field:'lb_oa_rank_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.rank" /></th>
                    <!-- 下部侧向跳动值2 -->
                    <th width="80" data-options="field:'lb_oa2_mm_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.amount_value" /></th>
                    <!-- 下部侧向跳动角度2 -->
                    <th width="80" data-options="field:'lb_oa2_deg_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.angle" /></th>
                    <!-- 下部侧向跳动等级2 -->
                    <th width="80" data-options="field:'lb_oa2_rank_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.rank" /></th>
                    <!-- 下部侧向跳动值3 -->
                    <th width="80" data-options="field:'lb_oa3_mm_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.amount_value" /></th>
                    <!-- 下部侧向跳动角度3 -->
                    <th width="80" data-options="field:'lb_oa3_deg_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.angle" /></th>
                    <!-- 下部侧向跳动等级3 -->
                    <th width="80" data-options="field:'lb_oa3_rank_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.rank" /></th>
                    
                    <!-- 上部径向跳动值 -->
                    <th width="80" data-options="field:'rt_oa_mm_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.amount_value" /></th>
                    <!-- 上部径向跳动角度 -->
                    <th width="80" data-options="field:'rt_oa_deg_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.angle" /></th>
                    <!-- 上部径向跳动等级 -->
                    <th width="80" data-options="field:'rt_oa_rank_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.rank" /></th>
                    <!-- 中部径向跳动值 -->
                    <th width="80" data-options="field:'rc_oa_mm_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.amount_value" /></th>
                    <!-- 中部径向跳动角度 -->
                    <th width="80" data-options="field:'rc_oa_deg_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.angle" /></th>
                    <!-- 中部径向跳动等级 -->
                    <th width="80" data-options="field:'rc_oa_rank_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.rank" /></th>
                    <!-- 下部径向跳动值 -->
                    <th width="80" data-options="field:'rb_oa_mm_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.amount_value" /></th>
                    <!-- 下部径向跳动角度 -->
                    <th width="80" data-options="field:'rb_oa_deg_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.angle" /></th>
                    <!-- 下部径向跳动等级 -->
                    <th width="80" data-options="field:'rb_oa_rank_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.rank" /></th>
                     
                    <!-- 上部侧向跳动一次谐波值1 -->
                    <th width="80" data-options="field:'lt_oa_1h_mm_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.amount_value" /></th>
                    <!-- 上部侧向跳动一次谐波角度1 -->
                    <th width="80" data-options="field:'lt_oa_1h_deg_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.angle" /></th>
                    <!-- 上部侧向跳动一次谐波等级1 -->
                    <th width="80" data-options="field:'lt_oa_1h_rank_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.rank" /></th>
                     <!-- 上部侧向跳动一次谐波值2 -->
                    <th width="80" data-options="field:'lt_oa2_1h_mm_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.amount_value" /></th>
                    <!-- 上部侧向跳动一次谐波角度2 -->
                    <th width="80" data-options="field:'lt_oa2_1h_deg_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.angle" /></th>
                    <!-- 上部侧向跳动一次谐波等级2 -->
                    <th width="80" data-options="field:'lt_oa2_1h_rank_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.rank" /></th>
                    <!-- 上部侧向跳动一次谐波值3 -->
                    <th width="80" data-options="field:'lt_oa3_1h_mm_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.amount_value" /></th>
                    <!-- 上部侧向跳动一次谐波角度3 -->
                    <th width="80" data-options="field:'lt_oa3_1h_deg_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.angle" /></th>
                    <!-- 上部侧向跳动一次谐波等级3 -->
                    <th width="80" data-options="field:'lt_oa3_1h_rank_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.rank" /></th>
                    
                    <!-- 下部侧向跳动一次谐波值1 -->
                    <th width="80" data-options="field:'lb_oa_1h_mm_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.amount_value" /></th>
                    <!-- 下部侧向跳动一次谐波角度1 -->
                    <th width="80" data-options="field:'lb_oa_1h_deg_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.angle" /></th>
                    <!-- 下部侧向跳动一次谐波等级1 -->
                    <th width="80" data-options="field:'lb_oa_1h_rank_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.rank" /></th>
                    <!-- 下部侧向跳动一次谐波值2 -->
                    <th width="80" data-options="field:'lb_oa2_1h_mm_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.amount_value" /></th>
                    <!-- 下部侧向跳动一次谐波角度2 -->
                    <th width="80" data-options="field:'lb_oa2_1h_deg_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.angle" /></th>
                    <!-- 下部侧向跳动一次谐波等级2 -->
                    <th width="80" data-options="field:'lb_oa2_1h_rank_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.rank" /></th>
                    <!-- 下部侧向跳动一次谐波值3 -->
                    <th width="80" data-options="field:'lb_oa3_1h_mm_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.amount_value" /></th>
                    <!-- 下部侧向跳动一次谐波角度3 -->
                    <th width="80" data-options="field:'lb_oa3_1h_deg_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.angle" /></th>
                    <!-- 下部侧向跳动一次谐波等级3 -->
                    <th width="80" data-options="field:'lb_oa3_1h_rank_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.rank" /></th>
                    
                    <!-- 上部径向跳动一次谐波值 -->
                    <th width="80" data-options="field:'rt_oa_1h_mm_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.amount_value" /></th>
                    <!-- 上部径向跳动一次谐波角度 -->
                    <th width="80" data-options="field:'rt_oa_1h_deg_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.angle" /></th>
                    <!-- 上部径向跳动一次谐波等级 -->
                    <th width="80" data-options="field:'rt_oa_1h_rank_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.rank" /></th>
                    <!-- 中部径向跳动一次谐波值 -->
                    <th width="80" data-options="field:'rc_oa_1h_mm_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.amount_value" /></th>
                    <!-- 中部径向跳动一次谐波角度 -->
                    <th width="80" data-options="field:'rc_oa_1h_deg_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.angle" /></th>
                    <!-- 中部径向跳动一次谐波等级 -->
                    <th width="80" data-options="field:'rc_oa_1h_rank_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.rank" /></th>
                    <!-- 下部径向跳动一次谐波值 -->
                    <th width="80" data-options="field:'rb_oa_1h_mm_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.amount_value" /></th>
                    <!-- 下部径向跳动一次谐波角度 -->
                    <th width="80" data-options="field:'rb_oa_1h_deg_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.angle" /></th>
                   	<!-- 下部径向跳动一次谐波等级 -->
                    <th width="80" data-options="field:'rb_oa_1h_rank_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.rank" /></th>
                    
                    <!-- 上部侧向跳动N次谐波值1 -->
                    <th width="80" data-options="field:'lro_t1_nth_mm_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.amount_value" /></th>
                    <!-- 上部侧向跳动N次谐波角度1 -->
                    <th width="80" data-options="field:'lro_t1_nth_deg_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.angle" /></th>
                    <!-- 上部侧向跳动N次谐波等级1 -->
                    <th width="80" data-options="field:'lro_t1_nth_rank_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.rank" /></th>
                    <!-- 上部侧向跳动N次谐波值2 -->
                    <th width="80" data-options="field:'lro_t2_nth_mm_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.amount_value" /></th>
                    <!-- 上部侧向跳动N次谐波角度2 -->
                    <th width="80" data-options="field:'lro_t2_nth_deg_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.angle" /></th>
                    <!-- 上部侧向跳动N次谐波等级2 -->
                    <th width="80" data-options="field:'lro_t2_nth_rank_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.rank" /></th>
                    <!-- 上部侧向跳动N次谐波值3 -->
                    <th width="80" data-options="field:'lro_t3_nth_mm_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.amount_value" /></th>
                    <!-- 上部侧向跳动N次谐波角度3 -->
                    <th width="80" data-options="field:'lro_t3_nth_deg_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.angle" /></th>
                    <!-- 上部侧向跳动N次谐波等级3 -->
                    <th width="80" data-options="field:'lro_t3_nth_rank_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.rank" /></th>
                   
                    <!-- 下部侧向跳动N次谐波值1 -->
                    <th width="80" data-options="field:'lro_b1_nth_mm_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.amount_value" /></th>
                    <!-- 下部侧向跳动N次谐波角度1 -->
                    <th width="80" data-options="field:'lro_b1_nth_deg_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.angle" /></th>
                    <!-- 下部侧向跳动N次谐波等级1 -->
                    <th width="80" data-options="field:'lro_b1_nth_rank_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.rank" /></th>
                    <!-- 下部侧向跳动N次谐波值2 -->
                    <th width="80" data-options="field:'lro_b2_nth_mm_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.amount_value" /></th>
                    <!-- 下部侧向跳动N次谐波角度2 -->
                    <th width="80" data-options="field:'lro_b2_nth_deg_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.angle" /></th>
                    <!-- 下部侧向跳动N次谐波等级2 -->
                    <th width="80" data-options="field:'lro_b2_nth_rank_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.rank" /></th>
                    <!-- 下部侧向跳动N次谐波值3 -->
                    <th width="80" data-options="field:'lro_b3_nth_mm_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.amount_value" /></th>
                    <!-- 下部侧向跳动N次谐波角度3 -->
                    <th width="80" data-options="field:'lro_b3_nth_deg_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.angle" /></th>
                    <!-- 下部侧向跳动N次谐波等级3 -->
                    <th width="80" data-options="field:'lro_b3_nth_rank_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.rank" /></th>
               
                    <!-- 上部径向跳动N次谐波值 -->
                    <th width="80" data-options="field:'rro_t_nth_mm_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.amount_value" /></th>
                    <!-- 上部径向跳动N次谐波角度 -->
                    <th width="80" data-options="field:'rro_t_nth_deg_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.angle" /></th>
                    <!-- 上部径向跳动N次谐波等级 -->
                    <th width="80" data-options="field:'rro_t_nth_rank_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.rank" /></th>
                    <!-- 中部径向跳动N次谐波值 -->
                    <th width="80" data-options="field:'rro_c_nth_mm_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.amount_value" /></th>
                    <!-- 中部径向跳动N次谐波角度 -->
                    <th width="80" data-options="field:'rro_c_nth_deg_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.angle" /></th>
                    <!-- 中部径向跳动N次谐波等级 -->
                    <th width="80" data-options="field:'rro_c_nth_rank_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.rank" /></th>
                    <!-- 下部径向跳动N次谐波值 -->
                    <th width="80" data-options="field:'rro_b_nth_mm_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.amount_value" /></th>
                    <!-- 下部径向跳动N次谐波角度 -->
                    <th width="80" data-options="field:'rro_b_nth_deg_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.angle" /></th>
                    <!-- 下部径向跳动N次谐波等级 -->
                    <th width="80" data-options="field:'rro_b_nth_rank_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.rank" /></th>
                    
                    <!-- 上部侧向凸值1 -->
                    <th width="80" data-options="field:'lt_bulging_mm_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.amount_value" /></th>
                    <!-- 上部侧向凸角度1 -->
                    <th width="80" data-options="field:'lt_bulging_deg_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.angle" /></th>
                    <!-- 上部侧向凸等级1 -->
                    <th width="80" data-options="field:'lt_bulging_rank_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.rank" /></th>
                    <!-- 上部侧向凸值2 -->
                    <th width="80" data-options="field:'lt_bulging2_mm_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.amount_value" /></th>
                    <!-- 上部侧向凸角度2 -->
                    <th width="80" data-options="field:'lt_bulging2_deg_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.angle" /></th>
                    <!-- 上部侧向凸等级2 -->
                    <th width="80" data-options="field:'lt_bulging2_rank_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.rank" /></th>
                    <!-- 上部侧向凸值3 -->
                    <th width="80" data-options="field:'lt_bulging3_mm_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.amount_value" /></th>
                    <!-- 上部侧向凸角度3 -->
                    <th width="80" data-options="field:'lt_bulging3_deg_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.angle" /></th>
                    <!-- 上部侧向凸等级3 -->
                    <th width="80" data-options="field:'lt_bulging3_rank_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.rank" /></th>
                   
                    <!-- 下部侧向凸值1 -->
                    <th width="80" data-options="field:'lb_bulging_mm_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.amount_value" /></th>
                    <!-- 下部侧向凸角度1 -->
                    <th width="80" data-options="field:'lb_bulging_deg_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.angle" /></th>
                    <!-- 下部侧向凸等级1 -->
                    <th width="80" data-options="field:'lb_bulging_rank_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.rank" /></th>
                     <!-- 下部侧向凸值2 -->
                    <th width="80" data-options="field:'lb_bulging2_mm_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.amount_value" /></th>
                    <!-- 下部侧向凸角度2 -->
                    <th width="80" data-options="field:'lb_bulging2_deg_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.angle" /></th>
                    <!-- 下部侧向凸等级2 -->
                    <th width="80" data-options="field:'lb_bulging2_rank_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.rank" /></th>
                    <!-- 下部侧向凸值3 -->
                    <th width="80" data-options="field:'lb_bulging3_mm_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.amount_value" /></th>
                    <!-- 下部侧向凸角度3 -->
                    <th width="80" data-options="field:'lb_bulging3_deg_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.angle" /></th>
                    <!-- 下部侧向凸等级3 -->
                    <th width="80" data-options="field:'lb_bulging3_rank_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.rank" /></th>
                     
                    <!-- 上部侧向凹值1 -->
                    <th width="80" data-options="field:'lt_dent_mm_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.amount_value" /></th>
                    <!-- 上部侧向凹角度1 -->
                    <th width="80" data-options="field:'lt_dent_deg_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.angle" /></th>
                    <!-- 上部侧向凹等级1 -->
                    <th width="80" data-options="field:'lt_dent_rank_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.rank" /></th>
                    <!-- 上部侧向凹值2 -->
                    <th width="80" data-options="field:'lt_dent2_mm_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.amount_value" /></th>
                    <!-- 上部侧向凹角度2 -->
                    <th width="80" data-options="field:'lt_dent2_deg_s',editor:{type:'textbox'}"><spring:message code="bbalandproresult.column.angle" /></th>
                    <!-- 上部侧向凹等级2 -->
                    <th width="80" data-options="field:'lt_dent2_rank_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.rank" /></th>
                    <!-- 上部侧向凹值3 -->
                    <th width="80" data-options="field:'lt_dent3_mm_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.amount_value" /></th>
                    <!-- 上部侧向凹角度3 -->
                    <th width="80" data-options="field:'lt_dent3_deg_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.angle" /></th>
                    <!-- 上部侧向凹等级3 -->
                    <th width="80" data-options="field:'lt_dent3_rank_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.rank" /></th>
                   
                    <!-- 下部侧向凹值1 -->
                    <th width="80" data-options="field:'lb_dent_mm_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.amount_value" /></th>
                    <!-- 下部侧向凹角度1 -->
                    <th width="80" data-options="field:'lb_dent_deg_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.angle" /></th>
                    <!-- 下部侧向凹等级1 -->
                    <th width="80" data-options="field:'lb_dent_rank_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.rank" /></th>
                    <!-- 下部侧向凹值2 -->
                    <th width="80" data-options="field:'lb_dent2_mm_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.amount_value" /></th>
                    <!-- 下部侧向凹角度2 -->
                    <th width="80" data-options="field:'lb_dent2_deg_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.angle" /></th>
                    <!-- 下部侧向凹等级2 -->
                    <th width="80" data-options="field:'lb_dent2_rank_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.rank" /></th>
                    <!-- 下部侧向凹值3 -->
                    <th width="80" data-options="field:'lb_dent3_mm_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.amount_value" /></th>
                    <!-- 下部侧向凹角度3 -->
                    <th width="80" data-options="field:'lb_dent3_deg_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.angle" /></th>
                    <!-- 下部侧向凹等级3 -->
                    <th width="80" data-options="field:'lb_dent3_rank_s',editor:{type:'textbox'}"><spring:message code="balandproresult.column.rank" /></th>
                   </tr>
            </thead>
        </table>
    </div>

    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="Balandproresult_search_form" />
		<jsp:param name="datagridId" value="balandproresult_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.finalcheck.excel.BalandproresultExportHandler" />
		<jsp:param name="serviceName" value="BalandproresultServiceImpl" />
	</jsp:include>
</body>
</html>
