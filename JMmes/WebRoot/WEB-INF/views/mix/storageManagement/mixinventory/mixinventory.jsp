<!-- 

    作者      :陈国强
    时间      :2020-08-14 09:26:09 
    页面名称:密炼库存实时表
    文件关联:
        MixInventory.java
        MixInventoryController.java
        MixInventoryServiceImpl.java
        MixInventoryServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="mixinventory.js.jsp"%>
<script type="text/javascript" src="dict/308,001,062,073.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="MixInventory_dg_toolbar">
            <form id="MixInventory_search_form" class="form" >
                <!-- 产出时间 -->
                <input type="radio" name="spare10_s" value="product_time" id="test" checked>
                <spring:message code="mixinventory.column.product_time_t" />
                <input name="filter[product_time_t]" id="product_time_t" type="text" class="easyui-datebox" data-options="label:''" >
                <input name="filter[start_time]" id="start_time" type="text" class="easyui-datetimebox" data-options="label:''" >
                <!-- 库区类型：062001-胶料库、062002-线边库、062004-普通小料包库、062005-烘胶房-天然胶库、062006-母炼胶-胶案库、062007-终练胶-胶案库、062008-返回胶库、062009-母炼胶-小车库、062010-终练胶-小车库、062011-烘胶房-合成胶库、062012-硫磺小料包库、062013-炭黑库(密炼)、062014-辅料库(密炼)、062015-硫磺库(密炼)、062016-油料库(密炼)、062017-烘胶房-线边库 -->
                                             库区<input name="filter[store_type_s]" id="store_type_s" type="text" class="easyui-combotree" ,
                       data-options="label:'',
				              			 required:false,
				              			 panelHeight:200,
				              			 url:'dict/code/062',
				              			 method:'get'" >
                <!-- 载具编号 -->
                <spring:message code="mixinventory.column.carrier_code_s" />
                <input name="filter[carrier_code_s]" id="carrier_code_s" type="text" class="easyui-textbox" data-options="label:''" >
                <br>
                <!-- 入库日期 -->
                <input type="radio" name="spare10_s" value="in_time" id="test">
                <spring:message code="mixinventory.column.in_time_t" />
                <input name="filter[in_time_t]" id="in_time_t" type="text" class="easyui-datebox" data-options="label:''" >
                -->>
                <br>
                <!-- 检测日期 -->
                <input type="radio" name="spare10_s" value="check_time" id="test">
                <spring:message code="mixinventory.column.check_time_t" />
                <input name="filter[check_time_t]" id="check_time_t" type="text" class="easyui-datebox" data-options="label:''" >
                <input name="filter[end_time]" id="end_time" type="text" class="easyui-datetimebox" data-options="label:''" >
                <!-- 状态编码： 001001-合格、 001002-不合格、 001003-待检状态 (MES发起的调拨只能调合格的）、 001004-封锁（MES不能调拨出库） -->
                                            物料状态<input name="filter[state_code_s]" id="state_code_s" type="text" class="easyui-combotree" ,
                       data-options="label:'',
				              			 required:false,
				              			 panelHeight:200,
				              			 url:'dict/code/001',
				              			 method:'get'" >
                <!-- 物料编码 -->
                <spring:message code="mixinventory.column.material_code_s" />
                <input name="filter[material_code_s]" id="material_code_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 批次号 -->
                <spring:message code="mixinventory.column.lot_no_s" />
                <input name="filter[lot_no_s]" id="lot_no_s" type="text" class="easyui-textbox" data-options="label:''" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
                <a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="specialRelease()">特殊放行</a> 
                <a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="overdueDispose()">超期处理</a>
                <auth:button code="BAN_GANG_ML_KCGL_MIXINVENTORY_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button> 
            </form>
            
            
            <%-- <auth:button code="XXX"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            　
            <auth:button code="XXX"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            　
            <auth:button code="XXX"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="export()"><spring:message code="button.export" /></a></auth:button> --%>
        </div>
        <table id="mixinventory_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#MixInventory_dg_toolbar',
                emptyMsg: '<span><spring:message code='tip.noData'/></span>',
               <!--  url: 'mix/storageManagement/mixInventory/datagrid', -->
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 批次号 -->
                    <th data-options="field:'lot_no_s',editor:{type:'textbox'}"><spring:message code="mixinventory.column.lot_no_s" /></th>
                    <!-- 载具编号 -->
                    <th data-options="field:'carrier_code_s',editor:{type:'textbox'}"><spring:message code="mixinventory.column.carrier_code_s" /></th>
                    <!-- 开始车次号 -->
                    <th data-options="field:'begin_train_num_s',editor:{type:'textbox'}"><spring:message code="mixinventory.column.begin_train_num_s" /></th>
                    <!-- 结束车次号 -->
                    <th data-options="field:'end_train_num_s',editor:{type:'textbox'}"><spring:message code="mixinventory.column.end_train_num_s" /></th>
                    <!-- 物料组 -->
                    <th data-options="field:'materialgroup_s',editor:{type:'textbox'}"><spring:message code="mixinventory.column.materialgroup_s" /></th>
                    <!-- 状态编码： 001001-合格、 001002-不合格、 001003-待检状态 (MES发起的调拨只能调合格的）、 001004-封锁（MES不能调拨出库） -->
                    <th data-options="field:'state_code_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="mixinventory.column.state_code_s" /></th>
                    <!--放行原因-->
                    <th data-options="field:'reas_code_s',formatter:reasCodeFormatter,width:80,editor:{type:'textbox'}"><spring:message code="mixinventory.column.reas_code_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',editor:{type:'textbox'}"><spring:message code="mixinventory.column.material_code_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'material_name_s',editor:{type:'textbox'}"><spring:message code="mixinventory.column.material_name_s" /></th>
                    <!-- 库存剩余数量 -->
                    <th data-options="field:'qty_left_f',editor:{type:'textbox'}"><spring:message code="mixinventory.column.qty_left_f" /></th>
                    <!-- 立库编号 -->
                    <th data-options="field:'warehouseid_s',editor:{type:'textbox'}"><spring:message code="mixinventory.column.warehouseid_s" /></th>
                    <!-- 库区类型：062001-胶料库、062002-线边库、062004-普通小料包库、062005-烘胶房-天然胶库、062006-母炼胶-胶案库、062007-终练胶-胶案库、062008-返回胶库、062009-母炼胶-小车库、062010-终练胶-小车库、062011-烘胶房-合成胶库、062012-硫磺小料包库、062013-炭黑库(密炼)、062014-辅料库(密炼)、062015-硫磺库(密炼)、062016-油料库(密炼)、062017-烘胶房-线边库 -->
                    <th data-options="field:'store_type_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="mixinventory.column.store_type_s" /></th>
                    <!-- 库位编号 -->
                    <th data-options="field:'store_code_s',editor:{type:'textbox'}"><spring:message code="mixinventory.column.store_code_s" /></th>
                    <!-- 托盘编号 -->
                    <th data-options="field:'tray_code_s',editor:{type:'textbox'}"><spring:message code="mixinventory.column.tray_code_s" /></th>
                    <!-- 基本单位 -->
                    <th data-options="field:'baseunit_s',editor:{type:'textbox'}"><spring:message code="mixinventory.column.baseunit_s" /></th>
                    <!-- 胶料立库出库方式：073001-指定批次、073002-指定托盘、073003-指定物料编码、073004-指定配套代码、073005-物料编码、073006-指定配方名称、073007-指定载具编号 -->
                    <th data-options="field:'warehouse_mode_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="mixinventory.column.warehouse_mode_s" /></th>
                    <!-- 出库目标位置 -->
                    <th data-options="field:'warehouse_location_s',editor:{type:'textbox'}"><spring:message code="mixinventory.column.warehouse_location_s" /></th>
                     <!-- 打印标识卡：0-未打印、1-已打印、2-补充打印 -->
                    <th data-options="field:'is_print_s',formatter:printFlag,editor:{type:'textbox'}"><spring:message code="mixinventory.column.is_print_s" /></th>
                    <!-- 是否试验料：0-否，1-是 -->
                    <th data-options="field:'testmat_flag_s',formatter:isTestmatFlag,editor:{type:'textbox'}"><spring:message code="mixinventory.column.testmat_flag_s" /></th>
                    <!-- 是否优先使用：0-否、1-是 -->
                    <th data-options="field:'prioritymat_flag_s',formatter:isPrioritymatFlag,editor:{type:'textbox'}"><spring:message code="mixinventory.column.prioritymat_flag_s" /></th>
                    <!-- 产出时间 -->
                    <th data-options="field:'product_time_t',editor:{type:'textbox'}"><spring:message code="mixinventory.column.product_time_t" /></th>
                    <!-- 检测日期 -->
                    <th data-options="field:'check_time_t',editor:{type:'textbox'}"><spring:message code="mixinventory.column.check_time_t" /></th>
                    <!-- 入库日期 -->
                    <th data-options="field:'in_time_t',editor:{type:'textbox'}"><spring:message code="mixinventory.column.in_time_t" /></th>
                    <!-- 允许出库日期 -->
                    <th data-options="field:'date_allow_out_t',editor:{type:'textbox'}"><spring:message code="mixinventory.column.date_allow_out_t" /></th>
                    <!-- 物料过期日期 -->
                    <th data-options="field:'expiry_date_t',editor:{type:'textbox'}"><spring:message code="mixinventory.column.expiry_date_t" /></th>
                    <!-- 自检标识：默认0合格，1不合格 -->
                    <th data-options="field:'self_flag_s',formatter:selfFlag,editor:{type:'textbox'}"><spring:message code="mixinventory.column.self_flag_s" /></th>
                    <!-- 检测人 -->
                    <th data-options="field:'check_by_s',editor:{type:'textbox'}"><spring:message code="mixinventory.column.check_by_s" /></th>
                    <!-- 最终检测结果 -->
                    <th data-options="field:'check_result_s',editor:{type:'textbox'}"><spring:message code="mixinventory.column.check_result_s" /></th>
                    <!-- 是否超期:0-正常状态 1-超期 -->
                    <th data-options="field:'outofdateflag_s',formatter:isOutofdateflag,editor:{type:'textbox'}"><spring:message code="mixinventory.column.outofdateflag_s" /></th>
                    <!-- 检测人 -->
                    <th data-options="field:'check_by_s',editor:{type:'textbox'}"><spring:message code="mixinventory.column.check_by_s" /></th>
                    <!-- 检测日期 -->
                    <th data-options="field:'check_time_t',editor:{type:'textbox'}"><spring:message code="mixinventory.column.check_time_t" /></th>
                    <!-- 超期处理次数 -->
                    <th data-options="field:'expiry_hand_count_i',editor:{type:'textbox'}"><spring:message code="mixinventory.column.expiry_hand_count_i" /></th>
                    <!-- 超期处理备注 -->
                    <th data-options="field:'expiry_hand_remark_s',editor:{type:'textbox'}"><spring:message code="mixinventory.column.expiry_hand_remark_s" /></th>
                    <!-- 创建人姓名 -->
                    <th data-options="field:'created_name_s',editor:{type:'textbox'}"><spring:message code="mixinventory.column.created_name_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',editor:{type:'textbox'}"><spring:message code="mixinventory.column.created_time_t" /></th>
                    <!-- 修改人姓名 -->
                    <th data-options="field:'changed_name_s',editor:{type:'textbox'}"><spring:message code="mixinventory.column.changed_name_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',editor:{type:'textbox'}"><spring:message code="mixinventory.column.changed_time_t" /></th>
                    <!-- 备用字段1：密炼接口预留：小料接口传无称量实绩原因备注，数据同步处理：A-最新数据、D-删除，重新下发：下发人，胶片立库接口预留：出库楼层1-一楼、2-二楼 -->
                    <th data-options="field:'spare1_s',editor:{type:'textbox'}"><spring:message code="mixinventory.column.spare1_s" /></th>
                    <!-- 备用字段2：密炼接口预留：胶料接口传载具编号、小料接口传小料车装车总袋数，重新下发：下发人姓名，胶片立库接口预留：空胶案类型 1-胶案、2-工字轮 出库区分为063014时传值 -->
                    <th data-options="field:'spare2_s',editor:{type:'textbox'}"><spring:message code="mixinventory.column.spare2_s" /></th>
                    <!-- 备用字段3：密炼接口预留：小料接口传产出类型：0-小料袋、1-小料车，线边库下发接口传是否掺胶：Yes-掺胶、No-不掺胶，重新下发：下发时间，胶片立库接口预留：载具数量，默认1 -->
                    <th data-options="field:'spare3_s',editor:{type:'textbox'}"><spring:message code="mixinventory.column.spare3_s" /></th>
                    <!-- 备用字段4：密炼接口预留：小料接口传小料袋关联小料车批次号，线边库下发接口传配方阶段：ZC-正常、ZCC-不正常、SY-实验，重新下发：下发标识：0-未下发、1-已下发、2-下发失败 原材料领料、发料-进厂批次：（G固定字符+4位年号+-固定字符+4位流水号）例如：G2019-0001 -->
                    <th data-options="field:'spare4_s',editor:{type:'textbox'}"><spring:message code="mixinventory.column.spare4_s" /></th>
                    <!-- 备用字段5：密炼接口预留：配方类型：1-正常、2-返炼、3-洗车、4-返洗、5-正洗 -->
                    <th data-options="field:'spare5_s',editor:{type:'textbox'}"><spring:message code="mixinventory.column.spare5_s" /></th>
                    <!-- 备用字段6：拆批人 -->
                    <th data-options="field:'spare6_s',editor:{type:'textbox'}"><spring:message code="mixinventory.column.spare6_s" /></th>
                    <!-- 备用字段7：拆批时间 -->
                    <th data-options="field:'spare7_s',editor:{type:'textbox'}"><spring:message code="mixinventory.column.spare7_s" /></th>
                    <!-- 备用字段8：入烘胶房时间 -->
                    <th data-options="field:'spare8_s',editor:{type:'textbox'}"><spring:message code="mixinventory.column.spare8_s" /></th>
                    <!-- 备用字段9：出烘胶房时间 -->
                    <th data-options="field:'spare9_s',editor:{type:'textbox'}"><spring:message code="mixinventory.column.spare9_s" /></th>
                    <!-- 备用字段10：被拆批次号 -->
                    <th data-options="field:'spare10_s',editor:{type:'textbox'}"><spring:message code="mixinventory.column.spare10_s" /></th>
                   
                </tr>
            </thead>
        </table>
    </div>
    	<jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="MixInventory_search_form" />
		<jsp:param name="datagridId" value="mixinventory_dg" />	
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.mix.export.MixInventoryExportHandler" />
		<jsp:param name="serviceName" value="MixInventoryServiceImpl" />
	</jsp:include>  
</body>
</html>
