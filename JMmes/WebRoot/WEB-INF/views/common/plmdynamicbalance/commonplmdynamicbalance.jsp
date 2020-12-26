<!-- 

    作者      :周清玉
    时间      :2019-06-27 14:24:00 
    页面名称:PLM动平衡参数集成表
    文件关联:
        CommonPlmDynamicBalance.java
        CommonPlmDynamicBalanceController.java
        CommonPlmDynamicBalanceServiceImpl.java
        CommonPlmDynamicBalanceServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/meta.jsp"%>
<%@ include file="commonplmdynamicbalance.js.jsp"%>
<script type="text/javascript" src="dict/323.js"></script>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="CommonPlmDynamicBalance_dg_toolbar">
            <form id="CommonPlmDynamicBalance_search_form" class="form" >
                  <!-- 配方编号-13位：Java系统当前时间 例如 1552888628141 -->
                <spring:message code="commonplmdynamicbalance.column.recipe_code_s" />:
                <input name="filter[recipe_code_s]" id="recipe_code_s" type="text" class="easyui-textbox" data-options="label:''" >
                
                <!-- 配方名称-->
                <spring:message code="commonplmdynamicbalance.column.recipe_code_name_s" />:
                <input name="filter[recipe_code_name_s]" id="recipe_code_name_s" type="text" class="easyui-textbox" data-options="label:''" >
                 
                 <!-- SAP号 -->
                <spring:message code="commonplmdynamicbalance.column.sapcode_s" />:
                <input name="filter[sapcode_s]" id="sapcode_s" type="text" class="easyui-textbox" data-options="label:''" >
                
                 <!-- 配方状态：323001-待用、323002-正用、323003-停用 -->
                <spring:message code="commonplmdynamicbalance.column.recipe_status_s" />:
                <input name="filter[recipe_status_s]" id="recipe_status_s" type="text" class="easyui-combotree" data-options="label:'',
                  labelWidth:'auto',
                  editable:'true',
				  required:false,
				  url:'dict/code/323',
				  method:'get',
				  label:''">
               <br>
               
                <!-- 下发标识（下发成功后置逻辑删除）：0-未下发、1-已下发 -->
                <spring:message code="commonplmdynamicbalance.column.send_state_s" />:
                <input name="filter[send_state_s]" id="send_state_s" type="text" class="easyui-combobox" 
                       data-options="label:'',
                       	             textField: 'label',
									 data: [{label: '未下发',value: '0'},
									        {label: '已下发',value: '1'}],
									 icons:[{iconCls:'icon-clear',
					                 handler:clearStatus}]">
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="PLMDYNAMICBALANCE_START"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-shenhe'" onclick="startstandard()"><spring:message code="button.start" /></a></auth:button>
            <auth:button code="PLMDYNAMICBALANCE_STOP"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-fanshenhe'" onclick="stopstandard()"><spring:message code="button.stop" /></a></auth:button>
            <auth:button code="PLMDYNAMICBALANCE_LETDOWN"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-supplier'" onclick="letdown()"><spring:message code="button.letdown" /></a></auth:button>  
          </div>
        <table id="commonplmdynamicbalance_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#CommonPlmDynamicBalance_dg_toolbar',
                url: 'common/plm/commonplmdynamicbalance/datagridOn',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- GUID，同一次报文传递的数据 -->
                    <th data-options="field:'guid_s',hidden:'true',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.guid_s" /></th>
                    <!-- 主键ID -->
                    <th data-options="field:'id_s',hidden:'true',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.id_s" /></th>
                     <!-- 配方编号-13位：Java系统当前时间 例如 1552888628141 -->
                    <th data-options="field:'recipe_code_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.recipe_code_s" /></th>
                     <!-- 配方名称：设备类别+规格+花纹 例如 TBROE_115/110M LL CCC TL LRR OE_KCA651 -->
                    <th data-options="field:'recipe_code_name_s',editor:{type:'textbox'}"><spring:message code="commondynamicbalanceedit.column.recipe_code_name_s" /></th>
                    <!-- 配方状态：323001-待用、323002-正用、323003-停用 -->
                    <th data-options="field:'recipe_status_s',editor:{type:'textbox'},formatter:codeFormatter,styler:recipeStatusCellStyler"><spring:message code="commonplmdynamicbalance.column.recipe_status_s" /></th>
                    <!-- 设备类别：TBROE、TBRRE -->
                    <th data-options="field:'category_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.category_s" /></th>
                    <!-- 规格 -->
                    <th data-options="field:'specification_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.specification_s" /></th>
                    <!-- 层级 -->
                    <th data-options="field:'hierarchy_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.hierarchy_s" /></th>
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
                    <!-- 静平衡 -->
                    <th data-options="field:'staticbalance_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.staticbalance_s" /></th>
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
                     <!-- 胎圈直径(内径) -->
                    <th data-options="field:'beaddiameter_s',editor:{type:'textbox'}"><spring:message code="commonplmdynamicbalance.column.beaddiameter_s" /></th>
                   <!-- 轮胎断面宽度(充气后最宽的部分) -->
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
                    <!-- 上凸 -->
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
                    <!-- 预留1 -->
                    <th data-options="field:'dummy1_s',editor:{type:'textbox'}"><spring:message code="qqq.column.dummy1_s" /></th>
                    <!-- 预留2 -->
                    <th data-options="field:'dummy2_s',editor:{type:'textbox'}"><spring:message code="qqq.column.dummy2_s" /></th>
                    <!-- 预留3 -->
                    <th data-options="field:'dummy3_s',editor:{type:'textbox'}"><spring:message code="qqq.column.dummy3_s" /></th>
                    <!-- 预留4 -->
                    <th data-options="field:'dummy4_s',editor:{type:'textbox'}"><spring:message code="qqq.column.dummy4_s" /></th>
                    <!-- 预留5 -->
                    <th data-options="field:'dummy5_s',editor:{type:'textbox'}"><spring:message code="qqq.column.dummy5_s" /></th>
                </tr>
            </thead>
        </table>
    </div>
</body>
</html>
