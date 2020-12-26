<!--

作者      :孙尊龙
时间      :2020-5-22 13:43:44
页面名称:补硫化产量固化与SAP抛帐
文件关联:
PatchMesSapProduction.java
PatchMesSapProductionController.java
PatchMesSapProductionServiceImpl.java
PatchMesSapProductionServiceImpl.xml
-->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="patchmessapproduction.js.jsp"%>
<script type="text/javascript" src="dict/252,253,302.js"></script>
<style type="text/css">
    .columnTitle {
        padding: 6px 10px
    }
</style>
<script type="text/javascript">
    $.extend($.fn.textbox.defaults, {
        "icons" : []
    });
</script>
<body class="easyui-layout" fit="true">
<div data-options="region:'center',split:true,border:false">
    <div id="MesSapProduction_dg_toolbar">
        <form id="MesSapProduction_search_form" class="form">
            <!-- 过账日期 -->
            <spring:message code="messapproduction.column.post_date_s" />
            :&emsp;<input name="filter[post_date_s]" id="post_date_s" type="text" class="easyui-datebox" data-options="onChange:filter,buttons:[],formatter:dateFormat,parser:dateParser,width:100,label:''">
            <script type="text/javascript">
                $("#post_date_s").val(new Calendar().format("yyyyMMdd"));
            </script>
            <!-- 上传批次号 -->
            <spring:message code="messapproduction.column.batch_id_s" />:
            <input name="filter[batch_id_s]" like="true" id="batch_id_s"  type="text" class="easyui-textbox" data-options="label:''">
            <!-- 物料编码（18位） -->
            <spring:message code="messapproduction.column.material_code_s" />:
            <input name="filter[material_code_s]" like="true" id="material_code_s" type="text" class="easyui-textbox" data-options="label:''">
            <!-- 班次 -->
            <spring:message code="messapproduction.column.class_id_s" />:
            <input name="filter[class_id_s]" id="class_id_s" type="text" class="easyui-combotree" style="width:150px" data-options="label:'',
                              required:false,
                              url:'dict/code/302',
                              method:'get'">

            <!-- 操作工姓名 -->
            <spring:message code="messapproduction.column.operate_usernane_s" />:
            <input name="filter[operate_usernane_s]" like="true" id="operate_usernane_s" type="text" class="easyui-textbox" data-options="label:''">
            <br>
            <!-- LZMES+YYYYmmdd+类型 （01/02）+4 位流水号 -->
            <spring:message code="messapproduction.column.serid_s" />:
            <input name="filter[serid_s]" id="serid_s" like="true" type="text" class="easyui-textbox" data-options="label:''">
            <!-- 报产方式（01：报产，02：冲产，03：异常） -->
            <spring:message code="messapproduction.column.product_type_s" />:
            <input name="filter[product_type_s]" id="product_type_s" type="text" class="easyui-combobox"
                   data-options="valueField:'value',
	                                textField:'text',
	                                method:'get',
	                                editable:true,
	                                data: [{
											text: '报产',
											value: '01'
										},{
											text: '冲产',
											value: '02'
										}]">
            <input name="filter[process_s]" id="process_s" value='252006' type="text" class="easyui-textbox">
            <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()">
                <spring:message code="button.search" />
            </a>
            <a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="ExcelExport()">
                <spring:message code="button.export" /></a>
        </form>
        <auth:button code="MSP_GUHUA">
            <a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-shenhe'" onclick="report()">
                <spring:message code="button.clgh" />
            </a>
        </auth:button>
        <auth:button code="MSP_REPORT">
            <a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-shenhe'" onclick="reporttosap()">
                <spring:message code="button.report" />
            </a>
        </auth:button>
        <auth:button code="SRR_REPLENISH_LHGUHUA">
            <a class="easyui-linkbutton btn-deep-blue"
               data-options="iconCls:'icon-shenhe'" onclick="reflush()"><spring:message
                    code="button.lhcuring" /></a>
        </auth:button>
        <auth:button code="MSP_REFLUSH">
            <a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-shenhe'" onclick="reflushtosap()">
                <spring:message code="button.reflush" />
            </a>
        </auth:button>
        <auth:button code="MSP_DETAIL">
            <a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-shenhe'" onclick="productionDetail()">
                <spring:message code="button.detail" />
            </a>
        </auth:button>
        <auth:button code="MSP_VERSION">
            <a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-shenhe'" onclick="version()">
                <spring:message code="button.versionchange" />
            </a>
        </auth:button>
<%--        <auth:button code="SRR_ABNORMAL_LHGUHUA">--%>
<%--            <a class="easyui-linkbutton btn-deep-blue"--%>
<%--               data-options="iconCls:'icon-shenhe'" onclick="abnormal()"><spring:message--%>
<%--                    code="button.abnormal" /></a>--%>
<%--        </auth:button>--%>
<%--        <auth:button code="MSP_ABNORMAL">--%>
<%--            <a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-shenhe'" onclick="abnormaltosap()">--%>
<%--                <spring:message code="button.abnormaltosap" />--%>
<%--            </a>--%>
<%--        </auth:button>--%>
		<auth:button code="MSP_REPEAT">
			<a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-shenhe'" onclick="repeattosap()">
				<spring:message code="button.repeat" />
			</a>
		</auth:button>
    </div>
    <table id="messapproduction_dg" class="easyui-datagrid" style="width:100%" data-options="
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#MesSapProduction_dg_toolbar',
                url: 'curing/patchmesapproduction/datagrid',
                striped:true,
                method: 'get',
                emptyMsg: '<span><spring:message code='tip.noData'/></span>'
                ">
        <thead>
        <tr>
            <th data-options="field:'atr_key',checkbox:true"></th>
            <!-- 报产方式（01：报产，02：冲产，03：异常） -->
            <th data-options="field:'product_type_s',formatter:bcTypeFormatter,styler:cellStyler,editor:{type:'textbox'}"><spring:message code="messapproduction.column.product_type_s" /></th>
            <%-- <!-- 报工工序 -->
            <th data-options="field:'process_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="messapproduction.column.process_s" /></th>
             --%>
            <!-- 过账日期（默认当前日期YYYYMMDD 月底最后一天16点之后跨天） -->
            <th data-options="field:'post_date_s',editor:{type:'textbox'}"><spring:message code="messapproduction.column.post_date_s" /></th>
            <!-- LZMES+YYYYmmdd+类型 （01/02）+4 位流水号 -->
            <th data-options="field:'serid_s',editor:{type:'textbox'}"><spring:message code="messapproduction.column.serid_s" /></th>
            <!-- 上传批次号 -->
            <th data-options="field:'batch_id_s',editor:{type:'textbox'}"><spring:message code="messapproduction.column.batch_id_s" /></th>
            <!-- 班次 -->
            <th data-options="field:'class_id_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="messapproduction.column.class_id_s" /></th>
            <!-- 凭证日期：默认当前日期YYYYMMDD -->
            <th data-options="field:'doc_date_s',editor:{type:'textbox'}"><spring:message code="messapproduction.column.doc_date_s" /></th>
            <!-- 产品下线批次（当前年份，过账日期前4位） -->
            <th data-options="field:'batch_s',editor:{type:'textbox'}"><spring:message code="messapproduction.column.batch_s" /></th>

            <!-- 实际固化数量 -->
            <th data-options="field:'actual_quantity_f',editor:{type:'textbox'}"><spring:message code="messapproduction.column.actual_quantity_f" /></th>
            <!-- 记录一下物料编码80位的 -->
            <th data-options="field:'rush_serid_s',editor:{type:'textbox'}"><spring:message code="messapproduction.column.rush_serid_s" /></th>
            <%-- <!-- 物料编码（18位） -->
            <th data-options="field:'material_code_s',editor:{type:'textbox'}"><spring:message code="messapproduction.column.material_code_s" /></th>
             --%>
            <!-- 物料名称 -->
            <th data-options="field:'material_name_s',editor:{type:'textbox'}"><spring:message code="messapproduction.column.material_name_s" /></th>
            <!-- 生产版本 -->
            <th data-options="field:'pro_version_s',editor:{type:'textbox'}"><spring:message code="messapproduction.column.pro_version_s" /></th>
            <!-- 固化标识(0 未固化 1 固化) -->
            <th data-options="field:'solid_flag_s',formatter:ghFormatter,styler:solidflagStyler,editor:{type:'textbox'}"><spring:message code="messapproduction.column.solid_flag_s" /></th>
            <!-- 记录标示 -->
            <th data-options="field:'record_sap_flag_s',formatter:rsFormatter,styler:cellSapRecordStyler,editor:{type:'textbox'}"><spring:message code="messapproduction.column.record_sap_flag_s" /></th>
            <!-- 下线库位 -->
            <th data-options="field:'storage_loc_s',editor:{type:'textbox'}"><spring:message code="messapproduction.column.storage_loc_s" /></th>
            <!-- 上传人 -->
            <th data-options="field:'operate_usernane_s',editor:{type:'textbox'}"><spring:message code="messapproduction.column.upload_userid_s" /></th>
            <!-- 上传时间 -->
            <th data-options="field:'operate_time_s',editor:{type:'textbox'}"><spring:message code="messapproduction.column.upload_time_t" /></th>
            <%-- <!-- 上传次数 -->
            <th data-options="field:'upload_num_s',editor:{type:'textbox'}"><spring:message code="messapproduction.column.upload_num_s" /></th>
            <!-- 上传人 -->
            <th data-options="field:'upload_userid_s',editor:{type:'textbox'}"><spring:message code="messapproduction.column.upload_userid_s" /></th>
            <!-- 上传时间 -->
            <th data-options="field:'upload_time_t',editor:{type:'textbox'}"><spring:message code="messapproduction.column.upload_time_t" /></th> --%>
            <!-- 备注 -->
            <th data-options="field:'memo_s',editor:{type:'textbox'}"><spring:message code="messapproduction.column.memo_s" /></th>
			<!-- 是否已添加(0 未添加 1 已添加)(冲产用) -->
			<th data-options="field:'spare5_s',formatter:tjFormatter,hidden:true,styler:solidflagStyler,editor:{type:'textbox'}"><spring:message code="messapproduction.column.spare5_s" /></th>
        </tr>
        </thead>
    </table>
</div>

<!-- 报产固化界面 -->
<div id="report_dlg" title="<spring:message code="button.curing" />" class="easyui-dialog" style="width:90%;height:90%;"
     data-options="
                closed:true,
                iconCls: 'icon-supplier',
                maximizable:true,
                buttons: [{
                    iconCls:'icon-no',
                    text:'<spring:message code="button.close" />',
                    handler:function(){
                       $('#report_dlg').dialog('close');
                       filter();
                    }
                }],
                onOpen:function(){
                    $('#reportaddOrEditWin').attr('src','view?page=curing/ReportQuery/patchCuringProductionToSap/patchworkorderresulttosap&factory='+factory);
                }
            ">
    <iframe id="reportaddOrEditWin" src="" width="100%" height="100%" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="no" allowtransparency="yes"> </iframe>
</div>

<!-- 冲产固化界面 -->
<div id="reflush_dlg" title="<spring:message code="button.lhcuring" />" class="easyui-dialog" style="width:90%;height:90%;"
     data-options="
                closed:true,
                iconCls: 'icon-supplier',
                maximizable:true,
                buttons: [{
                    iconCls:'icon-no',
                    text:'<spring:message code="button.close" />',
                    handler:function(){
                       $('#reflush_dlg').dialog('close');
                       filter();
                    }
                }],
                onOpen:function(){
                 $('#reflushaddOrEditWin').attr('src','view?page=curing/ReportQuery/patchCuringProductionToSap/patchsapreturnresulttosap&factory='+factory);
                }
            ">
    <iframe id="reflushaddOrEditWin" src="" width="100%" height="100%" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="no" allowtransparency="yes"> </iframe>
</div>
<!-- 异常固化界面 -->
<%--<div id="abnormal_dlg" title="<spring:message code="button.abnormal" />" class="easyui-dialog" style="width:90%;height:90%;"--%>
<%--     data-options="--%>
<%--                closed:true,--%>
<%--                iconCls: 'icon-supplier',--%>
<%--                maximizable:true,--%>
<%--                buttons: [{--%>
<%--                    iconCls:'icon-no',--%>
<%--                    text:'<spring:message code="button.close" />',--%>
<%--                    handler:function(){--%>
<%--                       $('#abnormal_dlg').dialog('close');--%>
<%--                       filter();--%>
<%--                    }--%>
<%--                }],--%>
<%--                onOpen:function(){--%>
<%--                 $('#abnormaladdOrEditWin').attr('src','view?page=curing/ReportQuery/curingProductionToSap/abnormal&factory='+factory);--%>
<%--                }--%>
<%--            ">--%>
<%--    <iframe id="abnormaladdOrEditWin" src="" width="100%" height="100%" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="no" allowtransparency="yes"> </iframe>--%>
</div>
<!-- 明细窗口 -->
<div id="workorderresult_detail_dg" class="easyui-dialog" title="明细查询窗口" style="width:900px;height:400px;"
     data-options="
                closed:true
            ">
    <table class="easyui-datagrid" style="width:100%" id="detail_dg"
           data-options="
	                 fit:true,
	                 fitColumns:false,
					 singleSelect:false,
					 autoRowHeight:true,
					 rownumbers:true,
					 loadMsg:'加载中。。。',
					 height:'auto',
	                  method:'get',
	                  emptyMsg:'暂无数据',
	                  striped:true
	                  ">
        <thead>
        <tr>
            <!-- 轮胎条码 -->
            <th data-options="field:'tyre_barcode_s',sortable:true,editor:{type:'textbox'}"><spring:message code="workorderresult.column.tyre_barcode_s" /></th>
            <!-- 硫化质量等级 -->
            <th data-options="field:'curing_grade_s',formatter:codeFormatter,sortable:true,editor:{type:'textbox'}"><spring:message code="workorderresultprint.column.spare5_s" /></th>
            <!-- 机台编码 -->
            <th data-options="field:'equip_code_s',sortable:true,editor:{type:'textbox'}"><spring:message code="c_mm_workorderresult.column.equip_code_s" /></th>
            <!-- 物料编码 -->
            <th data-options="field:'material_code_s',editor:{type:'textbox'}"><spring:message code="workorderresult.column.material_code_s" /></th>
            <!-- 规格描述 -->
            <th data-options="field:'material_name_s',editor:{type:'textbox'}"><spring:message code="workorderresult.column.material_name_s" /></th>
            <!-- 生产日期 -->
            <th data-options="field:'product_date_s',sortable:true,editor:{type:'textbox'}"><spring:message code="workorderresult.column.product_date_s" /></th>
        </tr>
        </thead>
    </table>
</div>

<!-- 版本变更 -->
<div id="version_dlg" title="<spring:message code="button.curing" />版本变更" class="easyui-dialog" style="width:100%;height:100%;"
     data-options="
                closed:true,
                iconCls: 'icon-supplier',
                maximizable:true,
                buttons: [{
                    iconCls:'icon-no',
                    text:'<spring:message code="button.close" />',
                    handler:function(){
                       $('#version_dlg').dialog('close');
                       filter();
                    }
                }]
            ">
    <div id="MesSapProduction_dg_toolbar2">
        <form id="MesSapProduction_search_form2" class="form">
            <td class="columnTitle"><spring:message code="messapproduction.column.batch_id_s" />: <!-- 上传批次号 --> <input name="filter[batch_id_s]" like="true" id="batch_id_s" type="text" class="easyui-textbox" data-options="label:''"></td>

            <td class="columnTitle"><spring:message code="messapproduction.column.material_code_s" />: <!-- 物料编码（18位） --> <input name="filter[material_code_s]" like="true" id="material_code_s" type="text" class="easyui-textbox" data-options="label:''"></td>

            <td class="columnTitle"><spring:message code="messapproduction.column.class_id_s" />: <!-- 班次 --> <input name="filter[class_id_s]" id="class_id_s" type="text" class="easyui-combotree" style="width:150px" data-options="label:'',
                              required:false,
                              url:'dict/code/302',
                              method:'get'"></td>

            <br>
            <td class="columnTitle"><spring:message code="messapproduction.column.operate_usernane_s" />: <!-- 操作工姓名 --> <input name="filter[operate_usernane_s]" like="true" id="operate_usernane_s" type="text" class="easyui-textbox" data-options="label:''"></td>

            <td class="columnTitle"><spring:message code="messapproduction.column.product_type_s" />: <!-- 报产方式（01：报产，02：冲产） --> <input name="filter[product_type_s]" id="product_type_s" type="text" class="easyui-combobox"
                                                                                                                                        data-options="valueField:'value',
                                    textField:'text',
                                    method:'get',
                                    editable:true,
                                    data: [{
                                            text: '报产',
                                            value: '01'
                                        },{
                                            text: '冲产',
                                            value: '02'
                                        }]"></td>
            <td class="columnTitle"><spring:message code="messapproduction.column.serid_s" />: <!-- LZMES+YYYYmmdd+类型 （01/02）+4 位流水号 --> <input name="filter[serid_s]" id="serid_s" like="true" type="text" class="easyui-textbox" data-options="label:''"></td>

            <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="version_filter()">
                <spring:message code="button.search" />
            </a>
        </form>
        <a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-edit'" onclick="editVersion()">修改版本</a>
        <a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-save'" onclick="saveVersion()">保存</a>
        <a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-no'" onclick="cancel()">取消</a>
    </div>
    <table id="messapproduction_dg2" class="easyui-datagrid" style="width:100%"
           data-options="
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#MesSapProduction_dg_toolbar2',
                url: 'curing/patchmesapproduction/datagrid',
                onBeforeLoad:onVersionDgBeforeLoad,
                striped:true,
                method: 'get',
                emptyMsg: '<span><spring:message code='tip.noData'/></span>'
                ">
        <thead>
        <tr>
            <th data-options="field:'atr_key',checkbox:true"></th>
            <!-- 记录一下物料编码80位的 -->
            <th data-options="field:'rush_serid_s'"><spring:message code="messapproduction.column.rush_serid_s" /></th>
            <!-- 物料编码（18位） -->
            <th data-options="field:'material_code_s'"><spring:message code="messapproduction.column.material_code_s" /></th>
            <!-- 生产版本 -->
            <th data-options="field:'pro_version_s'"><spring:message code="messapproduction.column.pro_version_s" /></th>
            <!-- 生产版本 -->
            <th data-options="field:'pro_version_s_new',editor:{type:'combobox',options:{url:'common/material/version',onBeforeLoad:onComboboxBeforeLoad2,required:true}}">新（New）<spring:message code="messapproduction.column.pro_version_s" /></th>
            <!-- 物料名称 -->
            <th data-options="field:'material_name_s'"><spring:message code="messapproduction.column.material_name_s" /></th>
            <!-- 报产方式（01：报产，02：冲产） -->
            <th data-options="field:'product_type_s',formatter:bcTypeFormatter"><spring:message code="messapproduction.column.product_type_s" /></th>
            <!-- 报工工序 -->
            <th data-options="field:'process_s',formatter:codeFormatter"><spring:message code="messapproduction.column.process_s" /></th>
            <!-- 过账日期（默认当前日期YYYYMMDD 月底最后一天16点之后跨天） -->
            <th data-options="field:'post_date_s'"><spring:message code="messapproduction.column.post_date_s" /></th>
            <!-- LZMES+YYYYmmdd+类型 （01/02）+4 位流水号 -->
            <th data-options="field:'serid_s'"><spring:message code="messapproduction.column.serid_s" /></th>
            <!-- 上传批次号 -->
            <th data-options="field:'batch_id_s'"><spring:message code="messapproduction.column.batch_id_s" /></th>
            <!-- 班次 -->
            <th data-options="field:'class_id_s',formatter:codeFormatter"><spring:message code="messapproduction.column.class_id_s" /></th>
            <!-- 同过账日期 -->
            <th data-options="field:'doc_date_s'"><spring:message code="messapproduction.column.doc_date_s" /></th>
            <!-- 产品下线批次（当前年份，过账日期前4位） -->
            <th data-options="field:'batch_s'"><spring:message code="messapproduction.column.batch_s" /></th>
            <!-- 实际固化数量 -->
            <th data-options="field:'actual_quantity_f'"><spring:message code="messapproduction.column.actual_quantity_f" /></th>
            <!-- 操作工姓名 -->
            <th data-options="field:'operate_usernane_s'"><spring:message code="messapproduction.column.operate_usernane_s" /></th>
            <!-- 操作时间 -->
            <th data-options="field:'operate_time_s'"><spring:message code="messapproduction.column.operate_time_s" /></th>
            <!-- 固化标识(0 未固化 1 固化) -->
            <th data-options="field:'solid_flag_s',formatter:ghFormatter"><spring:message code="messapproduction.column.solid_flag_s" /></th>
            <!-- 记录标示 -->
            <th data-options="field:'record_sap_flag_s',formatter:rsFormatter"><spring:message code="messapproduction.column.record_sap_flag_s" /></th>
            <!-- 下线库位 -->
            <th data-options="field:'storage_loc_s'"><spring:message code="messapproduction.column.storage_loc_s" /></th>
            <!-- 上传次数 -->
            <th data-options="field:'upload_num_s'"><spring:message code="messapproduction.column.upload_num_s" /></th>
            <!-- 上传人 -->
            <th data-options="field:'upload_userid_s'"><spring:message code="messapproduction.column.upload_userid_s" /></th>
            <!-- 上传时间 -->
            <th data-options="field:'upload_time_t'"><spring:message code="messapproduction.column.upload_time_t" /></th>
            <!-- 备注 -->
            <th data-options="field:'memo_s'"><spring:message code="messapproduction.column.memo_s" /></th>
        </tr>
        </thead>
    </table>
</div>

</body>
</html>
