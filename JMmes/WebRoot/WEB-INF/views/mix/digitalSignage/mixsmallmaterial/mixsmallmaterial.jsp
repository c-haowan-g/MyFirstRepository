<!-- 

    作者      :陈国强
    时间      :2020-08-29 08:25:16 
    页面名称:密炼小料库存实时表
    文件关联:
        MixSmallMaterial.java
        MixSmallMaterialController.java
        MixSmallMaterialServiceImpl.java
        MixSmallMaterialServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="mixsmallmaterial.js.jsp"%>

<style type="text/css">

table {
           /*列宽由表格宽度和列宽度设定*/
           table-layout: fixed;
       }
</style>
<script type="text/javascript">
</script>

<body class="easyui-layout" fit="true"> 
<div id="name" style="width:100%" align="center">
	<h1 style="color:blue"><spring:message code="小料库存状态看板" /></h2>
</div>
<div id="message"></div>
    <div data-options="region:'center',split:true,border:false" style="width:100%">
        
        <table id="mixsmallmaterial_dg" class="easyui-datagrid" style="width:80% " 
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:false,
                rownumbers:false,
                singleSelect: true,
                toolbar: '#name,#message',
                url: 'mix/digitalSignage/mixsmallmaterial/datagrid',
                emptyMsg:'<span><spring:message code='tip.noData'/></span>',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <!-- 库位编号 -->
                    <th data-options="field:'store_code_s',editor:{type:'textbox'}"><spring:message code="mixsmallmaterial.column.store_code_s" /></th>
                    <!-- 库区类型：062001-胶料库、062002-线边库、062004-普通小料包库、062005-烘胶房-天然胶库、062006-母炼胶-胶案库、062007-终练胶-胶案库、062008-返回胶库、062009-母炼胶-小车库、062010-终练胶-小车库、062011-烘胶房-合成胶库、062012-硫磺小料包库、062013-炭黑库(密炼)、062014-辅料库(密炼)、062015-硫磺库(密炼)、062016-油料库(密炼)、062017-烘胶房-线边库 -->
                    <th data-options="field:'store_type_s',editor:{type:'textbox'}"><spring:message code="库区类型" /></th>
                    <!-- 库存剩余数量 -->
                    <th data-options="field:'qty_left_f',editor:{type:'textbox'}"><spring:message code="mixsmallmaterial.column.qty_left_f" /></th>
                    <!-- 入库日期 -->
                    <th data-options="field:'in_time_t',editor:{type:'textbox'}"><spring:message code="mixsmallmaterial.column.in_time_t" /></th>
                    <!-- 允许出库日期 -->
                    <th data-options="field:'date_allow_out_t',editor:{type:'textbox'}"><spring:message code="mixsmallmaterial.column.date_allow_out_t" /></th>
                    <!-- 物料过期日期 -->
                    <th data-options="field:'expiry_date_t',editor:{type:'textbox'}"><spring:message code="mixsmallmaterial.column.expiry_date_t" /></th>
                    <!-- 是否超期:0-正常状态 1-超期 -->
                    <th data-options="field:'outofdateflag_s', styler:cellStyler, editor:{type:'textbox'}"><spring:message code="是否超期" /></th>
                    <!-- 出库状态：0-未出库、1-已出库 -->
                    <th data-options="field:'out_flag_s',editor:{type:'textbox'}"><spring:message code="出库状态" /></th>
                    <!-- 检测人 -->
                    <th data-options="field:'check_by_s',editor:{type:'textbox'}"><spring:message code="mixsmallmaterial.column.check_by_s" /></th>
                    <!-- 最终检测结果 -->
                    <th data-options="field:'check_result_s',editor:{type:'textbox'}"><spring:message code="mixsmallmaterial.column.check_result_s" /></th>
                    <!-- 检测日期 -->
                    <th data-options="field:'check_time_t',editor:{type:'textbox'}"><spring:message code="mixsmallmaterial.column.check_time_t" /></th>
                    <!-- 创建人姓名 -->
                    <th data-options="field:'created_name_s',editor:{type:'textbox'}"><spring:message code="mixsmallmaterial.column.created_name_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',editor:{type:'textbox'}"><spring:message code="mixsmallmaterial.column.created_time_t" /></th>
                    <!-- 超期处理次数 -->
                    <th data-options="field:'expiry_hand_count_i',editor:{type:'textbox'}"><spring:message code="mixsmallmaterial.column.expiry_hand_count_i" /></th>
                    <!-- 超期处理备注 -->
                    <th data-options="field:'expiry_hand_remark_s',editor:{type:'textbox'}"><spring:message code="mixsmallmaterial.column.expiry_hand_remark_s" /></th>
                    <!-- 等级编码-备用 -->
                    <th data-options="field:'grade_code_s',editor:{type:'textbox'}"><spring:message code="mixsmallmaterial.column.grade_code_s" /></th>
                    <!-- 主键ID -->
                    <th data-options="field:'id_s',editor:{type:'textbox'}"><spring:message code="mixsmallmaterial.column.id_s" /></th>
                    <!-- 打印标识卡：0-未打印、1-已打印、2-补充打印 -->
                    <th data-options="field:'is_print_s',editor:{type:'textbox'}"><spring:message code="打印标识卡" /></th>
                    <!-- 批次号 -->
                    <th data-options="field:'lot_no_s',editor:{type:'textbox'}"><spring:message code="mixsmallmaterial.column.lot_no_s" /></th>
                    <!-- 配套 -->
                    <th data-options="field:'matchingcode_s',editor:{type:'textbox'}"><spring:message code="mixsmallmaterial.column.matchingcode_s" /></th>
                    <!-- 物料组 -->
                    <th data-options="field:'materialgroup_s',editor:{type:'textbox'}"><spring:message code="mixsmallmaterial.column.materialgroup_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',editor:{type:'textbox'}"><spring:message code="mixsmallmaterial.column.material_code_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'material_name_s',editor:{type:'textbox'}"><spring:message code="mixsmallmaterial.column.material_name_s" /></th>
                    <!-- 密炼日计划表，日计划号，外键，MX_PP_PLAN.PLAN_NO -->
                    <th data-options="field:'plan_no_s',editor:{type:'textbox'}"><spring:message code="mixsmallmaterial.column.plan_no_s" /></th>
                    <!-- 是否优先使用：0-否、1-是 -->
                    <th data-options="field:'prioritymat_flag_s',editor:{type:'textbox'}"><spring:message code="是否优先使用" /></th>
                    <!-- 产出时间 -->
                    <th data-options="field:'product_time_t',editor:{type:'textbox'}"><spring:message code="mixsmallmaterial.column.product_time_t" /></th>
                    <!-- 区分阶段（小试XS、中试ZS、大试DS、投产TC） -->
                    <th data-options="field:'prophase_s',editor:{type:'textbox'}"><spring:message code="mixsmallmaterial.column.prophase_s" /></th>
                    <!-- 放行原因：067001-特殊放行、067002-超期处理 -->
                    <th data-options="field:'reas_code_s',editor:{type:'textbox'}"><spring:message code="mixsmallmaterial.column.reas_code_s" /></th>
                    <!-- 记录标志，A可用，D删除 -->
                    <th data-options="field:'record_flag_s',editor:{type:'textbox'}"><spring:message code="记录标志" /></th>
                    <!-- 反馈备注 -->
                    <th data-options="field:'return_remark_s',editor:{type:'textbox'}"><spring:message code="mixsmallmaterial.column.return_remark_s" /></th>
                    <!-- 反馈状态：0-无请求、1-未反馈、2-已反馈 -->
                    <th data-options="field:'return_state_s',editor:{type:'textbox'}"><spring:message code="反馈状态" /></th>
                    <!-- 反馈时间 -->
                    <th data-options="field:'return_time_t',editor:{type:'textbox'}"><spring:message code="mixsmallmaterial.column.return_time_t" /></th>
                    <!-- 自检标识：默认0合格，1不合格 -->
                    <th data-options="field:'self_flag_s',editor:{type:'textbox'}"><spring:message code="mixsmallmaterial.column.self_flag_s" /></th>
                    <!-- 状态编码： 001001-合格、 001002-不合格、 001003-待检状态 (MES发起的调拨只能调合格的）、 001004-封锁（MES不能调拨出库） -->
                    <th data-options="field:'state_code_s',editor:{type:'textbox'}"><spring:message code="状态编码" /></th>
                    <!-- 原材料供应商编号 -->
                    <th data-options="field:'supplier_code_s',editor:{type:'textbox'}"><spring:message code="mixsmallmaterial.column.supplier_code_s" /></th>
                    <!-- 原材料供应商全称 -->
                    <th data-options="field:'supplier_name_s',editor:{type:'textbox'}"><spring:message code="mixsmallmaterial.column.supplier_name_s" /></th>
                    <!-- 同步时间 -->
                    <th data-options="field:'sync_create_time_t',editor:{type:'textbox'}"><spring:message code="mixsmallmaterial.column.sync_create_time_t" /></th>
                    <!-- 是否试验料：0-否，1-是 -->
                    <th data-options="field:'testmat_flag_s',editor:{type:'textbox'}"><spring:message code="是否试验料" /></th>
                    <!-- 托盘编号 -->
                    <th data-options="field:'tray_code_s',editor:{type:'textbox'}"><spring:message code="mixsmallmaterial.column.tray_code_s" /></th>
                    <!-- 立库编号 -->
                    <th data-options="field:'warehouseid_s',editor:{type:'textbox'}"><spring:message code="mixsmallmaterial.column.warehouseid_s" /></th>
                    <!-- 出库目标位置 -->
                    <th data-options="field:'warehouse_location_s',editor:{type:'textbox'}"><spring:message code="mixsmallmaterial.column.warehouse_location_s" /></th>
                    <!-- 胶料立库出库方式：073001-指定批次、073002-指定托盘、073003-指定物料编码、073004-指定配套代码、073005-物料编码、073006-指定配方名称、073007-指定载具编号 -->
                    <th data-options="field:'warehouse_mode_s',editor:{type:'textbox'}"><spring:message code="胶料立库出库方式" /></th>
                    <!-- 密炼工单跟踪表，工单号，外检，MX_PP_WO_EDIT.WO_NO -->
                    <th data-options="field:'wo_no_s',editor:{type:'textbox'}"><spring:message code="mixsmallmaterial.column.wo_no_s" /></th>
                </tr>
            </thead>
        </table>
    </div>
</body>
</html>
