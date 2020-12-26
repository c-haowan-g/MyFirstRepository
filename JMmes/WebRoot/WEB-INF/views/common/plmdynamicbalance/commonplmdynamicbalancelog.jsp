<!-- 

    作者      :刘朋
    时间      :2019-07-02 17:26:05 
    页面名称:PLM动平衡标准集成日志表
    文件关联:
        CommonPlmDynamicBalanceLog.java
        CommonPlmDynamicBalanceLogController.java
        CommonPlmDynamicBalanceLogServiceImpl.java
        CommonPlmDynamicBalanceLogServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/meta.jsp"%>
<%@ include file="commonplmdynamicbalancelog.js.jsp"%>
<script type="text/javascript" src="dict/323.js"></script>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="CommonPlmDynamicBalanceLog_dg_toolbar">
            <form id="CommonPlmDynamicBalanceLog_search_form" class="form" >
              <!-- 接收时间 -->
                <spring:message code="commonplmdynamicbalance.column.receive_time_t" />:
                <input name="filter[begin_created_time]" editable="true" id="begin_created_time" class="easyui-datetimebox"  style="width:150px" data-options="label:''">
                                                到
                <input name="filter[end_created_time]" editable="true" id="end_created_time" class="easyui-datetimebox"  style="width:150px">
                <!-- 配方编号-13位：Java系统当前时间 例如 1552888628141 -->
                <spring:message code="commonplmdynamicbalancelog.column.recipe_code_s" />:
                <input name="filter[recipe_code_s]" id="recipe_code_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 配方名称：设备类别+规格+花纹 例如 TBROE_115/110M LL CCC TL LRR OE_KCA651 -->
                <spring:message code="commonplmdynamicbalancelog.column.recipe_code_name_s" />:
                <input name="filter[recipe_code_name_s]" id="recipe_code_name_s" type="text" class="easyui-textbox" 
                       data-options="label:''" ><br/>
                <!-- 物料编号-->
                <spring:message code="commonplmdynamicbalance.column.sapcode_s" />:
                <input name="filter[material_code_s]" id="material_code_s" type="text" class="easyui-textbox" 
                       data-options="label:''" >
                <!-- 配方状态：323001-待用、323002-正用、323003-停用 -->
                <spring:message code="commonplmdynamicbalancelog.column.recipe_status_s" />:
                <input name="filter[recipe_status_s]" id="recipe_status_s" type="text" class="easyui-combotree" 
                       data-options="label:'',
                                     labelWidth:'auto',
                                     editable:'true',
				                     required:false,
				                     url:'dict/code/323',
				                     method:'get'">
                <!-- 下发标识（下发成功后置逻辑删除）：0-未下发、1-已下发 -->
                <spring:message code="commonplmdynamicbalancelog.column.send_state_s" />:
                <input name="filter[send_state_s]" id="send_state_s" type="text" class="easyui-combobox" 
                       data-options="label:'',
                       	             textField: 'label',
									 data: [{label: '未下发',value: '0'},
									        {label: '已下发',value: '1'}],
									 icons:[{iconCls:'icon-clear',
					                       handler:clearStatus}]">
                

                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form>
        </div>
        <table id="commonplmdynamicbalancelog_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#CommonPlmDynamicBalanceLog_dg_toolbar',
                url: 'common/plm/commonplmdynamicbalancelog/datagridAll',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
					<!-- 配方编号 -->
					<th data-options="field:'recipe_code_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalancelog.column.recipe_code_s" /></th>
                    <!-- 配方名称 -->
					<th data-options="field:'recipe_code_name_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalancelog.column.recipe_code_name_s" /></th>
					<!-- 配方状态:323001-待用、323002-正用、323003-停用 -->
					<th data-options="field:'recipe_status_s',editor:{type:'textbox'},formatter:codeFormatter,styler:recipeStatusCellStyler"><spring:message code="commonplmdynamicbalancelog.column.recipe_status_s" /></th>
					<!-- 设备类别 TBROE-全钢配套、TBRRE-全钢零售、PCROE-半钢配套、PCRRE-半钢零售-->
                    <th data-options="field:'category_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalancelog.column.category_s" /></th>
					<!-- 规格 -->
				    <th data-options="field:'specification_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalancelog.column.specification_s" /></th>
                    <!-- 层级 -->
                    <th data-options="field:'hierarchy_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalancelog.column.hierarchy_s" /></th>
                    <!-- 描述 -->
					<th data-options="field:'description_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.description_s" /></th>
				    <!-- 花纹 -->
					<th data-options="field:'pattern_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.pattern_s" /></th>
				    <!-- SAP号 -->
					<th data-options="field:'sapcode_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.sapcode_s" /></th>
				    <!-- 气压 -->
				    <th data-options="field:'pressure_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.pressure_s" /></th>
				    <!-- 负荷 -->
				    <th data-options="field:'load_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.load_s" /></th>
				    <!-- 等级 -->
				    <th data-options="field:'grade_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.grade_s" /></th>
				    <!-- Up/Low -->
                    <th data-options="field:'uplow_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.uplow_s" /></th>
				    <!-- Total -->
				    <th data-options="field:'total_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.total_s" /></th>
				    <!-- 凹凸度 -->
			        <th data-options="field:'camber_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.camber_s" /></th>
				    <!-- 径向跳动 -->
				    <th data-options="field:'runout_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.runout_s" /></th>
				    <!-- 侧向跳动 -->
				    <th data-options="field:'lateralbeating_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.lateralbeating_s" /></th>
				    <!-- RFV -->
				    <th data-options="field:'rfv_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.rfv_s" /></th>
				    <!-- RIH -->
				    <th data-options="field:'rih_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.rih_s" /></th>
				    <!-- LFV -->
				    <th data-options="field:'lfv_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.lfv_s" /></th>
	  			    <!-- CON -->
	  			    <th data-options="field:'con_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.con_s" /></th>
					<!-- 外直径 -->
					<th data-options="field:'externaldiameter_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.externaldiameter_s" /></th>
	  			    <!-- 胎圈直径（内径） -->
	  			    <th data-options="field:'beaddiameter_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.beaddiameter_s" /></th>
					<!-- 轮胎断面宽度（充气后最宽的部分） -->
					<th data-options="field:'sectionwidth_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.sectionwidth_s" /></th>
	  			    <!-- 最大外径 -->
	  			    <th data-options="field:'maxoutsidediameter_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.maxoutsidediameter_s" /></th>
					<!-- 最小外径 -->
					<th data-options="field:'minimumoutsidediameter_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.minimumoutsidediameter_s" /></th>
	  			    <!-- 胎压公差 -->
	  			    <th data-options="field:'tirepressuretolerance_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.tirepressuretolerance_s" /></th>
				 	<!-- 打标特殊要求 -->
					<th data-options="field:'specialrequire_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.specialrequire_s" /></th>
	  			   <!-- 备注 -->
	  			    <th data-options="field:'comment_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.comment_s" /></th>
					 <!-- 上凹 -->
					<th data-options="field:'upconcave_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.upconcave_s" /></th>
	  			    <!-- 下凹 -->
	  			    <th data-options="field:'downconcave_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.downconcave_s" /></th>
					<!-- 上凸-->
					<th data-options="field:'upbulge_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.upbulge_s" /></th>
	  			    <!-- 下凸 -->
	  			    <th data-options="field:'downbulge_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.downbulge_s" /></th>
					<!-- 上侧跳 -->
					<th data-options="field:'upjump_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.upjump_s" /></th>
	  			    <!-- 下侧跳 -->
	  			    <th data-options="field:'downjump_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.downjump_s" /></th>
				    <!-- 打标位置要求 -->
					<th data-options="field:'markpositionrequire_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.markpositionrequire_s" /></th>
	  			  	<!-- 检查型号 -->
	  			    <th data-options="field:'examinetype_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.examinetype_s" /></th>
					<!-- 胎圈宽度 -->
					<th data-options="field:'beadwidth_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.beadwidth_s" /></th>
	  			    <!-- 负荷公差 -->
	  			    <th data-options="field:'loadtolerance_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.loadtolerance_s" /></th>
					<!-- 角度效应上限 -->
					<th data-options="field:'angleeffectupperbound_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.angleeffectupperbound_s" /></th>
	  			    <!-- 角度效应下限 -->
	  			    <th data-options="field:'angleeffectlowerbound_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.angleeffectlowerbound_s" /></th>
					 <!-- 锥度上限 -->
					<th data-options="field:'taperupperbound_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.taperupperbound_s" /></th>
	  			    <!-- 锥度下限 -->
	  			    <th data-options="field:'taperlowerbound_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.taperlowerbound_s" /></th>
					<!-- 径向力二次谐波 -->
					<th data-options="field:'radialrecondharmonics_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.radialrecondharmonics_s" /></th>
	  			    <!-- 径向力一次谐波 -->
	  			    <th data-options="field:'radialfirstharmonics_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.radialfirstharmonics_s" /></th>
					<!-- 力偶不平衡量 -->
					<th data-options="field:'coupleunbalance_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.coupleunbalance_s" /></th>
	  			   <!-- 径向力八次谐波 -->
	  			    <th data-options="field:'radialeightharmonics_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.radialeightharmonics_s" /></th>
					<!-- 打标半径1 -->
                    <th data-options="field:'markradiusone_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.markradiusone_s" /></th>
                    <!-- 打标半径2 -->
                    <th data-options="field:'markradiustwo_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.markradiustwo_s" /></th>
                    <!-- 打标半径3 -->
                    <th data-options="field:'markradiusthree_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.markradiusthree_s" /></th>
                    <!-- 打标半径4 -->
                    <th data-options="field:'markradiusfour_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.markradiusfour_s" /></th>
                    <!-- 打标半径5 -->
                    <th data-options="field:'markradiusfive_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.markradiusfive_s" /></th>
	  			     <!-- 接收时间 -->
	  			    <th data-options="field:'receive_time_t',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.receive_time_t" /></th>
					<!-- 配方启停人姓名 -->
                    <th data-options="field:'recipe_name_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.recipe_name_s" /></th>
                    <!-- 配方启停时间 -->
                    <th data-options="field:'recipe_time_t',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.recipe_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
</body>
</html>
