<!-- 

    作者      :李德晓
    时间      :2020-08-06 12:12:08 
    页面名称:原材料库存表
    文件关联:
        MaterialInventory.java
        MaterialInventoryController.java
        MaterialInventoryServiceImpl.java
        MaterialInventoryServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="materialinventory.js.jsp"%>
<script type="text/javascript" src="dict/-308,006.js"></script>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
            <form id="MaterialInventory_search_form" class="form" >
             <!-- 入库日期 -->
            <input type="radio" name="spare10_s"  value="in_time" id="test">入库日期:
            <input name="filter[in_time_t]" id="in_time_t" type="text" class="easyui-datebox" data-options="label:''" >
            <input name="filter[start_time]" id="start_time" type="text" class="easyui-datetimebox" data-options="label:''" >
            <!-- 库区编码 -->
            库区名称:
            &emsp;<input name="filter[store_type_s]" id="store_type_s" type="text" class="easyui-combobox"
                         data-options="label:'',
                                     editable:true,
                                     data:storeType,
                                     textField:'text',
                                     valueField:'code',
                                     onChange:getstoreUnit" style="width: 120px">
            <!--库位编码-->
            库位名称：
            <input name="filter[store_code_s]" id="store_code_s" type="text" class="easyui-combobox"
                   data-options="label:'',
	         		          panelHeight:150,
	         		          editable:true,
	           		          valueField:'STORE_CODE_S',
	          		           textField:'SPARE4_S',
	                          selectOnNavigation:false,
	           		          limitToList:true" style="width: 140px">
            <!-- 状态编码(物料状态) -->
            物料状态:
            <input name="filter[state_code_s]" id="state_code_s" type="text" class="easyui-combobox"
                   data-options="label:'',
                                     editable:true,
                                     data:stateCode,
                                     textField:'text',
                                     valueField:'code'" style="width: 120px">
            <!-- 物料编码 -->
            物料编码:
            <input name="filter[material_code_s]" id="material_code_s" type="text" class="easyui-textbox" data-options="label:''" style="width: 100px">
            <br>

           <!-- 检测日期 -->
            <input type="radio" id="mutex" name="spare10_s" value="product_time">生产日期:
            <input name="filter[product_time_t]" id="product_time_t" type="text" class="easyui-datebox" data-options="label:''" >
            <input name="filter[end_time]" id="end_time" type="text" class="easyui-datetimebox" data-options="label:''" >
            <!--供应商名称查询-->
            供应商:
            <input name="filter[supplier_name_s]" id="supplier_name_s" type="text" class="easyui-textbox" data-options="label:''" style="width: 100px">
            <!-- 原材料称量表，计量单号 -->
            计量单号:
            <input name="filter[weight_number_s]" id="weight_number_s" type="text" class="easyui-textbox" data-options="label:''" style="width: 100px">
            <!-- 供应商原料批次号 -->
            进厂批次:
            <input name="filter[lot_no_s]" id="lot_no_s" type="text" class="easyui-textbox" data-options="label:''" style="width: 100px">
            <!-- 供应商原料批次号 -->
            批次号:
            <input name="filter[supplier_lot_no_s]" id="supplier_lot_no_s" type="text" class="easyui-textbox" data-options="label:''" >
            <br>
            <input name="filter[validSign]" id="validSign" type="text" class="easyui-textbox" data-options="label:''" >
            <input type="radio" name="spare11_s"  value="all" id="spare11_s" checked>
            全部
            <input type="radio" name="spare11_s"  value="expired" id="">
            已过期
            <input type="radio" name="spare11_s"  value="recent" id="">
            临近过期
            <input name="filter[expiredDay]" id="expiredDay" type="text" class="easyui-textbox" data-options="label:''" style="width: 80px">
            天
            
            <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()">查询</a>
            <auth:button code="RAW_Stock Management_Material_specialReleaseBefore"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="specialReleaseBefore('pass')">特殊放行</a></auth:button>
            <auth:button code="RAW_Stock Management_Material_specialReleaseo"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="specialReleaseBefore('over')">超期处理</a></auth:button>
            <auth:button code="RAW_Stock Management_Material_remove"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()">库存清理</a></auth:button>
            <auth:button code="RAW_Stock Management_Material_export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()">导出</a></auth:button>
            </form> 
            </div>
        <div data-options="region:'south',split:true" style="height:85%;">
        
    <div class="easyui-tabs" id="content_tab" data-options="fit:true,tools:'#tab-tools'">
        <div title="实时库存" style="padding:10px">
            <table id="materialinventory_dg" class="easyui-datagrid" style="width:100%"
                   data-options="
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                mptyMsg: '<span>无数据NoData</span>',
                singleSelect: false,
                toolbar: '#MaterialInventory_dg_toolbar',
                striped:true,
                method: 'get'
                ">
                <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 供应商原料批次号 -->
                    <th data-options="field:'supplier_lot_no_s',width:160,editor:{type:'textbox'}">批次号</th>
                    <!-- 进厂批次 -->
                    <th data-options="field:'lot_no_s',width:80,editor:{type:'textbox'}">进厂批次</th>
                    <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',width:80,editor:{type:'textbox'}">物料编码</th>
                    <!-- 物料名称 -->
                    <th data-options="field:'material_name_s',width:200,editor:{type:'textbox'}">物料名称</th>
                    
                    <th data-options="field:'supplier_code_s',width:80,editor:{type:'textbox'}">供应商编号</th>
                    <!-- 供应商全称 -->
                    <th data-options="field:'supplier_name_s',width:80,editor:{type:'textbox'}">供应商全称</th>
                    <!--入库重量-->
                    <th data-options="field:'qty_in_f',width:80,editor:{type:'textbox'}">入库重量(kg)</th>
                    <!--入库数量-->
                    <th data-options="field:'num_in_i',width:80,editor:{type:'textbox'}">入库数量(包/袋/罐)</th>
                    <!-- 库存剩余重量 -->
                    <th data-options="field:'qty_left_f',width:80,editor:{type:'textbox'}">剩余重量(kg)</th>
                    <!-- 备用字段5 （发料状态）-->
                    <th data-options="field:'spare5_s',formatter:codeFormatter,width:80,editor:{type:'textbox'}">发料状态</th>
                    <!-- 状态编码 -->
                    <th data-options="field:'state_code_s',formatter:stateCodeFormatter,width:80,editor:{type:'textbox'}">物料状态</th>
                    <!-- 放行原因 -->
                    <th data-options="field:'reas_code_s',formatter:codeFormatter,width:80,editor:{type:'textbox'}">放行原因</th>
                    <!-- 备用字段6 DQW检测项-->
                    <th data-options="field:'spare6_s',formatter:spare6Formatter,width:80,editor:{type:'textbox'}">DQW检测项</th>
                    <!-- 库区编码 -->
                    <th data-options="field:'store_type_s',formatter:storeTypeFormatter,width:80,editor:{type:'textbox'}">库区名称</th>
                    <!-- 备用字段4 -->
                    <th data-options="field:'spare4_s',width:80,editor:{type:'textbox'}">库位名称</th>
                    <!-- 物料组 -->
                    <th data-options="field:'materialgroup_s',formatter:codeFormatter,width:80,editor:{type:'textbox'}">物料组</th>
                    <!-- 备用字段1 -->
                    <th data-options="field:'spare1_s',width:80,editor:{type:'textbox'}">剩余数量(包/袋/罐)</th>
                    <!-- 备用字段2 -->
                    <th data-options="field:'spare2_s',width:80,editor:{type:'textbox'}">单件重量(kg)</th>


                    <!-- 供应商原料批次号生产日期 -->
                    <th data-options="field:'product_time_t'">生产日期</th>
                    <!-- 入库日期 -->
                    <th data-options="field:'in_time_t',width:80,editor:{type:'textbox'}">入库日期</th>
                    <!-- 允许出库日期 -->
                    <th data-options="field:'date_allow_out_t',width:80,editor:{type:'textbox'}">允许出库日期</th>
                    <!-- 物料过期日期 -->
                    <th data-options="field:'expiry_date_t',width:80,width:80,editor:{type:'textbox'}">物料过期日期</th>
                    <!-- 是否超期:0-正常状态 1-超期 -->
                    <th data-options="field:'outofdateflag_s',formatter:outofdateflag,width:80,editor:{type:'textbox'}">是否超期</th>
                    <!-- 超期处理次数 -->
                    <th data-options="field:'expiry_hand_count_i',width:80,editor:{type:'textbox'}">超期处理次数</th>
                    <!-- 超期处理备注 -->
                    <th data-options="field:'expiry_hand_remark_s',width:80,editor:{type:'textbox'}">超期处理备注</th>
                    <!-- 立库编号 -->
                    <th data-options="field:'warehouseid_s',width:80,editor:{type:'textbox'}">立库编号</th>
                    <!-- 出库方式 -->
                    <th data-options="field:'warehouse_mode_s',formatter:warehouseMode,width:80,editor:{type:'textbox'}">出库方式</th>
                    <!-- 出库目标位置 -->
                    <th data-options="field:'warehouse_location_s',width:80,editor:{type:'textbox'}">出库目标位置</th>
                    <!-- 基本单位 -->
                    <th data-options="field:'baseunit_s',width:80,editor:{type:'textbox'}">基本单位</th>
                    <!-- 备用字段7 -->
                    <th data-options="field:'spare7_s',width:80,editor:{type:'textbox'}">退库原因</th>
                    <!-- 是否试验料：0-否，1-是 -->
                    <th data-options="field:'testmat_flag_s',formatter:isTestmat,width:80,editor:{type:'textbox'}">是否试验料</th>
                    <!-- 是否优先使用：0-否、1-是 -->
                    <th data-options="field:'prioritymat_flag_s',formatter:isPrioritymat,width:80,editor:{type:'textbox'}">是否优先使用</th>
                    <!-- 检测日期 -->
                    <th data-options="field:'check_time_t',width:80,editor:{type:'textbox'}">检测日期</th>
                    <!-- 自检标识：默认0合格，1不合格 -->
                    <th data-options="field:'self_flag_s',formatter:selfFlag,width:80,editor:{type:'textbox'}">自检标识</th>
                    <!-- 检测人 -->
                    <th data-options="field:'check_by_s',width:80,editor:{type:'textbox'}">检测人</th>
                    <!-- 最终检测结果 -->
                    <th data-options="field:'check_result_s',width:80,editor:{type:'textbox'}">最终检测结果</th>
                    <!-- 原材料称量表，计量单号 -->
                    <th data-options="field:'weight_number_s',width:80,editor:{type:'textbox'}">计量单号</th>
                    <!-- SAP内向交货单表，内向交货单号 -->
                    <th data-options="field:'dn_dnno_s',width:80,editor:{type:'textbox'}">内向交货单号</th>
                    <!-- SAP内向交货单表，内向交货单行号 -->
                    <th data-options="field:'dn_dnitem_s',width:80,editor:{type:'textbox'}">内向交货单行号</th>
                    <!-- SAP内向交货单表，出货单单号 -->
                    <th data-options="field:'dn_salordid_s',width:80,editor:{type:'textbox'}">出货单单号</th>
                    <!-- SAP内向交货单表，出货单行号 -->
                    <th data-options="field:'dn_salorditem_s',width:80,editor:{type:'textbox'}">出货单行号</th>
                   <!-- 托盘编号 -->
                    
                    <!-- 创建人姓名 -->
                    <th data-options="field:'created_name_s',width:80,editor:{type:'textbox'}">创建人姓名</th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',width:80,editor:{type:'textbox'}">创建时间</th>
                    <!-- 修改人姓名 -->
                    <th data-options="field:'changed_name_s',width:80,editor:{type:'textbox'}">修改人姓名</th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',width:80,editor:{type:'textbox'}">修改时间</th>
                    <!-- 备用字段3 -->
                    
                    <!-- 备用字段8 -->
                    
                    <!-- 备用字段9 -->
                    
                    <!-- 备用字段10 -->
                    
                </tr>
                </thead>
            </table>
        </div>
        <div title="历史库存" style="padding:10px">
            <table id="materialinventory_dg1" class="easyui-datagrid" style="width:100%"
                   data-options="
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                mptyMsg: '<span>无数据NoData</span>',
                singleSelect: true,
                toolbar: '#MaterialInventory_dg_toolbar',
                striped:true,
                method: 'get'
                ">
                <thead>
                <tr>
                    <!-- 供应商原料批次号 -->
                    <th data-options="field:'supplier_lot_no_s',width:160,editor:{type:'textbox'}">批次号</th>
                    <!-- 进厂批次 -->
                    <th data-options="field:'lot_no_s',width:80,editor:{type:'textbox'}">进厂批次</th>
                    <!-- 物料名称 -->
                    <th data-options="field:'material_name_s',width:200,editor:{type:'textbox'}">物料名称</th>
                    <!-- 供应商全称 -->
                    <th data-options="field:'supplier_name_s',width:80,editor:{type:'textbox'}">供应商全称</th>
                    <!--入库重量-->
                    <th data-options="field:'qty_in_f',width:80,editor:{type:'textbox'}">入库重量(kg)</th>
                    <!--入库数量-->
                    <th data-options="field:'num_in_i',width:80,editor:{type:'textbox'}">入库数量(包/袋/罐)</th>
                    <!-- 库存剩余重量 -->
                    <th data-options="field:'qty_left_f',width:80,editor:{type:'textbox'}">剩余重量(kg)</th>
                    <!-- 备用字段5 （发料状态）-->
                    <th data-options="field:'spare5_s',formatter:codeFormatter,width:80,editor:{type:'textbox'}">发料状态</th>
                    <!-- 状态编码 -->
                    <th data-options="field:'state_code_s',formatter:stateCodeFormatter,width:80,editor:{type:'textbox'}">物料状态</th>
                    <!-- 放行原因 -->
                    <th data-options="field:'reas_code_s',formatter:codeFormatter,width:80,editor:{type:'textbox'}">放行原因</th>
                    <!-- 备用字段6 DQW检测项-->
                    <th data-options="field:'spare6_s',formatter:spare6Formatter,width:80,editor:{type:'textbox'}">DQW检测项</th>
                    <!-- 库区编码 -->
                    <th data-options="field:'store_type_s',formatter:storeTypeFormatter,width:80,editor:{type:'textbox'}">库区名称</th>
                    <!-- 备用字段4 -->
                    <th data-options="field:'spare4_s',width:80,editor:{type:'textbox'}">库位名称</th>
                    <!-- 物料组 -->
                    <th data-options="field:'materialgroup_s',formatter:codeFormatter,width:80,editor:{type:'textbox'}">物料组</th>
                    <!-- 备用字段1 -->
                    <th data-options="field:'spare1_s',width:80,editor:{type:'textbox'}">剩余数量(包/袋/罐)</th>
                    <!-- 备用字段2 -->
                    <th data-options="field:'spare2_s',width:80,editor:{type:'textbox'}">单件重量(kg)</th>
                    <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',width:80,editor:{type:'textbox'}">物料编码</th>
                    
                    <th data-options="field:'supplier_code_s',width:80,editor:{type:'textbox'}">供应商编号</th>
                    <!-- 供应商原料批次号生产日期 -->
                    <th data-options="field:'product_time_t'">生产日期</th>
                    <!-- 入库日期 -->
                    <th data-options="field:'in_time_t',width:80,editor:{type:'textbox'}">入库日期</th>
                    <!-- 允许出库日期 -->
                    <th data-options="field:'date_allow_out_t',width:80,editor:{type:'textbox'}">允许出库日期</th>
                    <!-- 物料过期日期 -->
                    <th data-options="field:'expiry_date_t',width:80,width:80,editor:{type:'textbox'}">物料过期日期</th>
                    <!-- 是否超期:0-正常状态 1-超期 -->
                    <th data-options="field:'outofdateflag_s',formatter:outofdateflag,width:80,editor:{type:'textbox'}">是否超期</th>
                    <!-- 超期处理次数 -->
                    <th data-options="field:'expiry_hand_count_i',width:80,editor:{type:'textbox'}">超期处理次数</th>
                    <!-- 超期处理备注 -->
                    <th data-options="field:'expiry_hand_remark_s',width:80,editor:{type:'textbox'}">超期处理备注</th>
                    <!-- 立库编号 -->
                    <th data-options="field:'warehouseid_s',width:80,editor:{type:'textbox'}">立库编号</th>
                    <!-- 出库方式 -->
                    <th data-options="field:'warehouse_mode_s',formatter:warehouseMode,width:80,editor:{type:'textbox'}">出库方式</th>
                    <!-- 出库目标位置 -->
                    <th data-options="field:'warehouse_location_s',width:80,editor:{type:'textbox'}">出库目标位置</th>
                    <!-- 基本单位 -->
                    <th data-options="field:'baseunit_s',width:80,editor:{type:'textbox'}">基本单位</th>
                    <!-- 备用字段7 -->
                    
                    <!-- 是否试验料：0-否，1-是 -->
                    <th data-options="field:'testmat_flag_s',formatter:isTestmat,width:80,editor:{type:'textbox'}">是否试验料</th>
                    <!-- 是否优先使用：0-否、1-是 -->
                    <th data-options="field:'prioritymat_flag_s',formatter:isPrioritymat,width:80,editor:{type:'textbox'}">是否优先使用</th>
                    <!-- 检测日期 -->
                    <th data-options="field:'check_time_t',width:80,editor:{type:'textbox'}">检测日期</th>
                    <!-- 自检标识：默认0合格，1不合格 -->
                    <th data-options="field:'self_flag_s',formatter:selfFlag,width:80,editor:{type:'textbox'}">自检标识</th>
                    <!-- 检测人 -->
                    <th data-options="field:'check_by_s',width:80,editor:{type:'textbox'}">检测人</th>
                    <!-- 最终检测结果 -->
                    <th data-options="field:'check_result_s',width:80,editor:{type:'textbox'}">最终检测结果</th>
                    <!-- 原材料称量表，计量单号 -->
                    <th data-options="field:'weight_number_s',width:80,editor:{type:'textbox'}">计量单号</th>
                    <!-- SAP内向交货单表，内向交货单号 -->
                    <th data-options="field:'dn_dnno_s',width:80,editor:{type:'textbox'}">内向交货单号</th>
                    <!-- SAP内向交货单表，内向交货单行号 -->
                    <th data-options="field:'dn_dnitem_s',width:80,editor:{type:'textbox'}">内向交货单行号</th>
                    <!-- SAP内向交货单表，出货单单号 -->
                    <th data-options="field:'dn_salordid_s',width:80,editor:{type:'textbox'}">出货单单号</th>
                    <!-- SAP内向交货单表，出货单行号 -->
                    <th data-options="field:'dn_salorditem_s',width:80,editor:{type:'textbox'}">出货单行号</th>
                    <!-- 托盘编号 -->
                    
                    <!-- 创建人姓名 -->
                    <th data-options="field:'created_name_s',width:80,editor:{type:'textbox'}">创建人姓名</th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',width:80,editor:{type:'textbox'}">创建时间</th>
                    <!-- 修改人姓名 -->
                    <th data-options="field:'changed_name_s',width:80,editor:{type:'textbox'}">修改人姓名</th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',width:80,editor:{type:'textbox'}">修改时间</th>
                    <!-- 备用字段3 -->
                    
                    <!-- 备用字段8 -->
                    
                    <!-- 备用字段9 -->
                    
                    <!-- 备用字段10 -->
                    
                </tr>
                </thead>
            </table>
        </div>
    </div>
</div>
<div id="rea_dlg" class="easyui-dialog" title="放行/超期处理原因" style="width:300px;height:300px;"
     data-options="
                iconCls: 'icon-window',
                buttons:'#reason_btn',
                closed:true
            ">

    <form class="form" id="reason_form" action="material/baseDate/materialinventory/specialRelease" method="post">
        <input type="hidden" name="id" id="id">
        <div class="form-row">
            <textarea cols="35" rows="10" id="spare7_s"></textarea>
        </div>
    </form>
</div>
<div id="reason_btn">
    <a class="easyui-linkbutton btn-blue" iconCls="icon-ok"  onclick="specialReleaseAfter()">保存</a>
    <a class="easyui-linkbutton btn-black" iconCls="icon-remove" onclick="cancel1()">取消</a>
</div>
     <jsp:include page="../../../../inc/export.jsp">
        <jsp:param name="idField" value="atr_key" />
        <jsp:param name="formId" value="MaterialInventory_search_form" />
        <jsp:param name="datagridId" value="materialinventory_dg" />
        <jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.material.excel.MaterialInventoryExportHandler" />
        <jsp:param name="serviceName" value="MaterialInventoryServiceImpl" />
    </jsp:include>
</body>
</html>
