<!-- 

    作者      :陈国强
    时间      :2020-08-16 09:58:50 
    页面名称:密炼库存操作履历表
    文件关联:
        DrRecordkc.java
        DrRecordkcController.java
        DrRecordkcServiceImpl.java
        DrRecordkcServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="drrecordkc.js.jsp"%>
<script type="text/javascript" src="dict/062,072,063,001,067.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="DrRecordkc_dg_toolbar">
            <form id="DrRecordkc_search_form" class="form" >
                <!-- 接收时间 -->
                <spring:message code="drrecordkc.column.receive_time_t" />
                <!-- <input name="filter[receive_time_t]" id="receive_time_t" type="text" class="easyui-textbox" data-options="label:''" > -->
                &nbsp;<input name="filter[start_time]" id="start_time" type="text" class="easyui-datetimebox" data-options="label:''">
				&nbsp;<spring:message code="tip.to" />
				&nbsp;<input name="filter[end_time]" id="end_time" type="text" style="width:168px"  class="easyui-datetimebox" data-options="label:''">
                <!-- 库区类型：062001-胶料库、062002-线边库、062004-普通小料包库、062005-烘胶房-天然胶库、062006-母炼胶-胶案库、062007-终练胶-胶案库、062008-返回胶库、062009-母炼胶-小车库、062010-终练胶-小车库、062011-烘胶房-合成胶库、062012-硫磺小料包库、062013-炭黑库(密炼)、062014-辅料库(密炼)、062015-硫磺库(密炼)、062016-油料库(密炼)、062017-烘胶房-线边库 -->
                &nbsp;<spring:message code="drrecordkc.column.store_type_s" />
                &nbsp;<input name="filter[store_type_s]" id="store_type_s" style="width:120px" type="text" class="easyui-combotree" 
                                         data-options="label:'',
                                         required:false,
				              			 panelHeight:200,
				              			 url:'dict/code/062',
				              			 method:'get'" >
                <!-- 库存操作类型：072001-入库、072002-出库、072003-移库、072004-发料、072005-第三方反馈 -->
                 &nbsp;<spring:message code="drrecordkc.column.inv_type_s" />
                 &nbsp;<input name="filter[inv_type_s]" id="inv_type_s" style="width:120px" type="text" class="easyui-combotree" 
                data-options="label:'',
                required:false,
				panelHeight:200,
				url:'dict/code/072',
				method:'get'"
                >
                <!-- 库存操作区分： 063001-产出新增入库 063002-手动入库 063003-退库入库 063004-返回胶入库 063005-空胶案入库 063010-生产出库 063011-手动出库 063012-检查出库 063013-不良出库 063014-空胶案出库 063020-生产移库 063021-手动移库 063022-检查移库 063023-不良移库  063024-拆批入库  063025-手动盘库 063030-手动发料 063031-自动发料 063040-库存更新 063041-其它 -->
                 &nbsp;<spring:message code="drrecordkc.column.warehouse_type_s" />
                 &nbsp;<input name="filter[warehouse_type_s]" id="warehouse_type_s" style="width:120px" type="text" class="easyui-combotree" 
                data-options="label:'',
                 required:false,
				panelHeight:200,
				url:'dict/code/063',
				method:'get'" >
                <!-- 物料编码 -->
                 &nbsp;<spring:message code="drrecordkc.column.material_code_s" />
                 &nbsp;<input name="filter[material_code_s]" id="material_code_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 批次号 -->
                 &nbsp;<spring:message code="drrecordkc.column.lot_no_s" />
                 &nbsp;<input name="filter[lot_no_s]" id="lot_no_s" type="text" class="easyui-textbox" data-options="label:''" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="BAN_GANG_ML_KCGL_MLKCCZLL_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button> 
           <%--  <auth:button code="XXX"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>            　
            <auth:button code="XXX"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="export()"><spring:message code="button.export" /></a></auth:button>  --%>
        </div>
        <table id="drrecordkc_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#DrRecordkc_dg_toolbar',
                url: 'mix/storageManagement/drRecordkc/datagrid',
                striped:true,
                onBeforeLoad:dlg1BeforeLoad,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 批次号 -->
                    <th data-options="field:'lot_no_s',editor:{type:'textbox'}"><spring:message code="drrecordkc.column.lot_no_s" /></th>
                    <!-- 载具编号 -->
                    <th data-options="field:'carrier_code_s',editor:{type:'textbox'}"><spring:message code="drrecordkc.column.carrier_code_s" /></th>
                    <!-- 库存剩余数量 -->
                    <th data-options="field:'qty_left_f',editor:{type:'textbox'}"><spring:message code="drrecordkc.column.qty_left_f" /></th>
                    <!-- 物料组 -->
                    <th data-options="field:'materialgroup_s',editor:{type:'textbox'}"><spring:message code="drrecordkc.column.materialgroup_s" /></th>
                     <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',editor:{type:'textbox'}"><spring:message code="drrecordkc.column.material_code_s" /></th>
                    <!-- 立库编号（1、2、3、4、5...） -->
                    <th data-options="field:'warehouseid_s',editor:{type:'textbox'}"><spring:message code="drrecordkc.column.warehouseid_s" /></th>
                    <!-- 库区类型：062001-胶料库、062002-线边库、062004-普通小料包库、062005-烘胶房-天然胶库、062006-母炼胶-胶案库、062007-终练胶-胶案库、062008-返回胶库、062009-母炼胶-小车库、062010-终练胶-小车库、062011-烘胶房-合成胶库、062012-硫磺小料包库、062013-炭黑库(密炼)、062014-辅料库(密炼)、062015-硫磺库(密炼)、062016-油料库(密炼)、062017-烘胶房-线边库 -->
                    <th data-options="field:'store_type_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="drrecordkc.column.store_type_s" /></th>
                    <!-- 库位编号 -->
                    <th data-options="field:'store_code_s',editor:{type:'textbox'}"><spring:message code="drrecordkc.column.store_code_s" /></th>
                    <!-- 托盘编号 -->
                    <th data-options="field:'tray_code_s',editor:{type:'textbox'}"><spring:message code="drrecordkc.column.tray_code_s" /></th>
                    <!-- 库存操作类型：072001-入库、072002-出库、072003-移库、072004-发料、072005-第三方反馈 -->
                    <th data-options="field:'inv_type_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="drrecordkc.column.inv_type_s" /></th>
                    <!-- 库存操作区分： 063001-产出新增入库 063002-手动入库 063003-退库入库 063004-返回胶入库 063005-空胶案入库 063010-生产出库 063011-手动出库 063012-检查出库 063013-不良出库 063014-空胶案出库 063020-生产移库 063021-手动移库 063022-检查移库 063023-不良移库  063024-拆批入库  063025-手动盘库 063030-手动发料 063031-自动发料 063040-库存更新 063041-其它 -->
                    <th data-options="field:'warehouse_type_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="drrecordkc.column.warehouse_type_s" /></th>
                    <!-- 库存操作备注 -->
                    <th data-options="field:'warehouse_remark_s',editor:{type:'textbox'}"><spring:message code="drrecordkc.column.warehouse_remark_s" /></th>
                    <!-- 状态编码： 001001-合格、 001002-不合格、 001003-待检状态 (MES发起的调拨只能调合格的）、 001004-封锁（MES不能调拨出库） -->
                    <th data-options="field:'state_code_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="drrecordkc.column.state_code_s" /></th>
                    <!-- 放行原因：067001-特殊放行、067002-超期处理 -->
                    <th data-options="field:'reas_code_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="drrecordkc.column.reas_code_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'material_name_s',editor:{type:'textbox'}"><spring:message code="drrecordkc.column.material_name_s" /></th>
                    <!-- 基本单位 -->
                    <th data-options="field:'baseunit_s',editor:{type:'textbox'}"><spring:message code="drrecordkc.column.baseunit_s" /></th>
                    <!-- 出库方式：1-指定批次、2-指定托盘、3-指定物料编码、4-指定配套代码、物料编码、5-指定配方名称、6-指定载具编号 -->
                    <th data-options="field:'warehouse_mode_s',formatter:warehousemodeFormatter,editor:{type:'textbox'}"><spring:message code="drrecordkc.column.warehouse_mode_s" /></th>
                    <!-- 出库目标位置 -->
                    <th data-options="field:'warehouse_location_s',editor:{type:'textbox'}"><spring:message code="drrecordkc.column.warehouse_location_s" /></th>
                    <!-- 是否试验料：0-否，1-是 -->
                    <th data-options="field:'testmat_flag_s',formatter:testmatflagFormatter,editor:{type:'textbox'}"><spring:message code="drrecordkc.column.testmat_flag_s" /></th>
                    <!-- 是否优先使用：0-否、1-是 -->
                    <th data-options="field:'prioritymat_flag_s',formatter:prioritymatflagFormatter,editor:{type:'textbox'}"><spring:message code="drrecordkc.column.prioritymat_flag_s" /></th>
                    <!-- 产出时间 -->
                    <th data-options="field:'product_time_s',editor:{type:'textbox'}"><spring:message code="drrecordkc.column.product_time_s" /></th>
                    <!-- 接收时间 -->
                    <th data-options="field:'receive_time_t',editor:{type:'textbox'}"><spring:message code="drrecordkc.column.receive_time_t" /></th>
                    <!-- 请求状态：0-发出请求、1-正常反馈、2-离线反馈 -->
                    <th data-options="field:'request_state_s',formatter:requeststateFormatter,editor:{type:'textbox'}"><spring:message code="drrecordkc.column.request_state_s" /></th>
                    <!-- 请求备注 -->
                    <th data-options="field:'request_remark_s',editor:{type:'textbox'}"><spring:message code="drrecordkc.column.request_remark_s" /></th>
                    <!-- 创建人姓名 -->
                    <th data-options="field:'created_name_s',editor:{type:'textbox'}"><spring:message code="drrecordkc.column.created_name_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',editor:{type:'textbox'}"><spring:message code="drrecordkc.column.created_time_t" /></th>
                    <!-- 修改人姓名 -->
                    <th data-options="field:'changed_name_s',editor:{type:'textbox'}"><spring:message code="drrecordkc.column.changed_name_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',editor:{type:'textbox'}"><spring:message code="drrecordkc.column.changed_time_t" /></th>
                    <!-- 备用字段1：密炼接口预留：小料接口传无称量实绩原因备注，数据同步处理：A-最新数据、D-删除，重新下发：下发人，胶片立库接口预留：出库楼层1-一楼、2-二楼 -->
                    <th data-options="field:'spare1_s',editor:{type:'textbox'}"><spring:message code="drrecordkc.column.spare1_s" /></th>
                    <!-- 备用字段2：密炼接口预留：胶料接口传载具编号、小料接口传小料车装车总袋数，重新下发：下发人姓名，胶片立库接口预留：空胶案类型 1-胶案、2-工字轮 出库区分为063014时传值 -->
                    <th data-options="field:'spare2_s',editor:{type:'textbox'}"><spring:message code="drrecordkc.column.spare2_s" /></th>
                    <!-- 备用字段3：密炼接口预留：小料接口传产出类型：0-小料袋、1-小料车，线边库下发接口传是否掺胶：Yes-掺胶、No-不掺胶，重新下发：下发时间，胶片立库接口预留：载具数量，默认1 -->
                    <th data-options="field:'spare3_s',editor:{type:'textbox'}"><spring:message code="drrecordkc.column.spare3_s" /></th>
                    <!-- 备用字段4：密炼接口预留：小料接口传小料袋关联小料车批次号，线边库下发接口传配方阶段：ZC-正常、ZCC-不正常、SY-实验，重新下发：下发标识：0-未下发、1-已下发、2-下发失败 原材料领料、发料-进厂批次：（G固定字符+4位年号+-固定字符+4位流水号）例如：G2019-0001 -->
                    <th data-options="field:'spare4_s',editor:{type:'textbox'}"><spring:message code="drrecordkc.column.spare4_s" /></th>
                    <!-- 备用字段5：密炼接口预留：线边库下发接口传配方类型：1-正常、2-返炼、3-洗车、4-返洗、5-正洗 烘胶房拆胶-打印方式： 069001-未打印 069002-已打印（手动） 069003-已打印（自动） 069004-补充打印 -->
                    <th data-options="field:'spare5_s',editor:{type:'textbox'}"><spring:message code="drrecordkc.column.spare5_s" /></th>
                    <!-- 备用字段6：拆批人 -->
                    <th data-options="field:'spare6_s',editor:{type:'textbox'}"><spring:message code="drrecordkc.column.spare6_s" /></th>
                    <!-- 备用字段7：拆批时间 -->
                    <th data-options="field:'spare7_s',editor:{type:'textbox'}"><spring:message code="drrecordkc.column.spare7_s" /></th>
                    <!-- 备用字段8：入烘胶房时间 -->
                    <th data-options="field:'spare8_s',editor:{type:'textbox'}"><spring:message code="drrecordkc.column.spare8_s" /></th>
                    <!-- 备用字段9：出烘胶房时间 -->
                    <th data-options="field:'spare9_s',editor:{type:'textbox'}"><spring:message code="drrecordkc.column.spare9_s" /></th>
                    <!-- 备用字段10：被拆批次号 -->
                    <th data-options="field:'spare10_s',editor:{type:'textbox'}"><spring:message code="drrecordkc.column.spare10_s" /></th>                   
                </tr>
            </thead>
        </table>
    </div>
       <jsp:include page="../../../../inc/export.jsp">
        <jsp:param name="idField" value="atr_key" />
        <jsp:param name="formId" value="DrRecordkc_search_form" />
        <jsp:param name="datagridId" value="drrecordkc_dg" />
        <jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.mix.export.DrRecordkcExportHandler" />
        <jsp:param name="serviceName" value="DrRecordkcServiceImpl" />
    </jsp:include>
</body>
</html>
