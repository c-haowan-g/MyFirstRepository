<!-- 

    作者      :陈国强
    时间      :2020-09-01 11:05:23 
    页面名称:密炼料仓物料维护下发历史表
    文件关联:
        MixSiloMaterialExec.java
        MixSiloMaterialExecController.java
        MixSiloMaterialExecServiceImpl.java
        MixSiloMaterialExecServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="mixsilomaterialexec.js.jsp"%>
<script type="text/javascript" src="dict/055.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="MixSiloMaterialExec_dg_toolbar">
            <form id="MixSiloMaterialExec_search_form" class="form" >
                <input type="radio" name="dummy4_s" value="real_time">
                实时时间
                <input type="radio" name="dummy4_s" value="his_time" checked>
                历史时间
                <!-- 同步时间 -->
                <spring:message code="mixsilomaterialexec.column.sync_create_time_t" />
                <%--<input name="filter[sync_create_time_t]" id="sync_create_time_t" type="text" class="easyui-datebox" data-options="label:''" >--%>
                <input name="filter[start_time]" id="start_time" type="text" class="easyui-datetimebox" data-options="label:''" >
                <spring:message code="tip.to" /><input name="filter[end_time]" id="end_time" type="text" class="easyui-datetimebox" data-options="label:''" >

                <!-- 机台条码 -->
                <spring:message code="mixsilomaterialexec.column.equip_code_s" />
                <input name="filter[equip_code_s]" id="equip_code_s" type="text" class="easyui-combobox" data-options="label:'',
                       data:equiplist1,
	         		   panelHeight:150,
	         		   editable:true,
	           		   valueField:'p_line_name',
	          		   textField:'description',
	                   selectOnNavigation:false,
	           		   limitToList:true,
	          		   filter:searchProductionLine,
	           		   onChange:filter" >
                <!-- 使用状态：058001-未审核、058002-已审核、058003-正下发、058004-已下发、058005-已执行、058006-已关闭 -->
                <spring:message code="mixsilomaterialexec.column.status_s" />
                <input name="filter[status_s]" id="status_s" type="text" class="easyui-combotree" data-options="label:'',
				  			required:false,
				  			url:'dict/code/058',
				  			method:'get',
				  			label:''" ></td>


                <!-- 物料编码：对应INT_PLM_MIXMATERIAL表MATERIALCODE -->
                <spring:message code="mixsilomaterialexec.column.material_code_s" />
                <input name="filter[material_code_s]" id="material_code_s" type="text" class="easyui-textbox" data-options="label:''" >
                <%--<!-- 机台名称 -->--%>
                <%--<input name="filter[equip_name_s]" id="equip_name_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="mixsilomaterialexec.column.equip_name_s" />'" >--%>
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <%--<auth:button code="XXX"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>--%>
            <%--<auth:button code="XXX"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>--%>
            <%--<auth:button code="XXX"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>--%>
            <%--　--%>
            <%--<auth:button code="XXX"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>--%>
            <%--<auth:button code="XXX"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>--%>
            <%--　--%>
            <%--<auth:button code="XXX"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="export()"><spring:message code="button.export" /></a></auth:button>--%>
        </div>
        <table id="mixsilomaterialexec_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#MixSiloMaterialExec_dg_toolbar',
                <%--url: 'mix/MixSiloMaterialExec/datagrid',--%>
                striped:true,
                method: 'get' 
                ">
            <thead>
            <tr>
                <th data-options="width:80,field:'atr_key',checkbox:true"rowspan="2"></th>
                <th colspan="9"><strong></strong></th>
                <th colspan="3"><strong>数据同步</strong></th>
                <th colspan="3"><strong>1#胶料上辅机-数据同步</strong></th>
                <th colspan="3"><strong>2#胶料上辅机-数据同步</strong></th>
                <th colspan="3"><strong>3#胶料上辅机-数据同步</strong></th>
                <th colspan="3"><strong>4#胶料上辅机-数据同步</strong></th>
                <th colspan="3"><strong>5#胶料上辅机-数据同步</strong></th>
                <th colspan="3"><strong>1#小料上辅机-数据同步</strong></th>
                <th colspan="3"><strong>2#小料上辅机-数据同步</strong></th>
                <th colspan="3"><strong>3#小料上辅机-数据同步</strong></th>
                <th colspan="3"><strong>1#炭黑输送-数据同步</strong></th>
                <th colspan="3"><strong>2#炭黑输送-数据同步</strong></th>
                <th colspan="3"><strong>3#炭黑输送-数据同步</strong></th>
                <th colspan="3"><strong>1#油料输送-数据同步</strong></th>
                <th colspan="3"><strong>2#油料输送-数据同步</strong></th>
                <th colspan="3"><strong>3#油料输送-数据同步</strong></th>
                <th colspan="2"><strong></strong></th>
            </tr>
                <tr>
                    <%--<th data-options="width:80,field:'atr_key',checkbox:true"></th>--%>
                    <!-- 机台名称 -->
                    <th data-options="width:160,field:'equip_name_s',editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.equip_name_s" /></th>
                    <!-- 料仓号：加载机台对应配置料仓号 -->
                    <th data-options="width:160,field:'silono_s',formatter:Mixpipelineformatter,editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.silono_s" /></th>
                    <!-- 输送线：加载炭黑、油料输送线基础数据 -->
                    <th data-options="width:80,field:'pipeline_s',formatter:equipcodeformatter,editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.pipeline_s" /></th>
                    <!-- 物料类别(上辅机定义)：055001-炭黑、055002-小药、055003-粉料、055004-油料、055005-胶料 ：对应INT_PLM_MIXMATERIAL表MATERIALTYPE -->
                    <th data-options="width:80,field:'materialtype_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.materialtype_s" /></th>
                    <!-- 物料编码：对应INT_PLM_MIXMATERIAL表MATERIALCODE -->
                    <th data-options="width:80,field:'material_code_s',editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.material_code_s" /></th>
                    <!-- 物料名称：对应INT_PLM_MIXMATERIAL表MATERIALNAME -->
                    <th data-options="width:140,field:'material_name_s',editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.material_name_s" /></th>
                    <!-- 供应商名称 例如：A|B -->
                    <th data-options="width:80,field:'supplyname_s',editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.supplyname_s" /></th>
                    <!-- 数据同步处理：A-新增、U-修改、D-删除 -->
                    <th data-options="width:80,field:'sync_flag_s',formatter:syncFlag,editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_flag_s" /></th>
                    <!-- 同步时间 -->
                    <th data-options="width:140,field:'sync_create_time_t',editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_create_time_t" /></th>
                    <!-- 数据同步处理标记：0-未处理、1-已处理 -->
                    <th data-options="width:80,field:'sync_hand_flag_s',formatter:syncHandFlag,editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_hand_flag_s" /></th>
                    <!-- 数据同步处理时间 -->
                    <th data-options="width:80,field:'sync_hand_time_t',editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_hand_time_t" /></th>
                    <!-- 数据同步处理反馈 -->
                    <th data-options="width:80,field:'sync_hand_msg_s',editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_hand_msg_s" /></th>
                    <!-- 1#胶料上辅机-数据同步处理标记：0-未处理、1-已处理、2-处理失败 -->
                    <th data-options="width:80,field:'sync_hand_flag_poly1_s',formatter:syncHandFlagPoly1,editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_hand_flag_poly1_s" /></th>
                    <!-- 1#胶料上辅机-数据同步处理时间 -->
                    <th data-options="width:80,field:'sync_hand_time_poly1_t',editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_hand_time_poly1_t" /></th>
                    <!-- 1#胶料上辅机-数据同步处理反馈 -->
                    <th data-options="width:80,field:'sync_hand_msg_poly1_s',editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_hand_msg_poly1_s" /></th>
                    <!-- 2#胶料上辅机-数据同步处理标记：0-未处理、1-已处理、3-处理失败 -->
                    <th data-options="width:80,field:'sync_hand_flag_poly2_s',formatter:syncHandFlagPoly2,editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_hand_flag_poly2_s" /></th>
                    <!-- 2#胶料上辅机-数据同步处理时间 -->
                    <th data-options="width:80,field:'sync_hand_time_poly2_t',editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_hand_time_poly2_t" /></th>
                    <!-- 2#胶料上辅机-数据同步处理反馈 -->
                    <th data-options="width:80,field:'sync_hand_msg_poly2_s',editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_hand_msg_poly2_s" /></th>
                    <!-- 3#胶料上辅机-数据同步处理标记：0-未处理、1-已处理、4-处理失败 -->
                    <th data-options="width:80,field:'sync_hand_flag_poly3_s',formatter:syncHandFlagPoly3,editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_hand_flag_poly3_s" /></th>
                    <!-- 3#胶料上辅机-数据同步处理时间 -->
                    <th data-options="width:80,field:'sync_hand_time_poly3_t',editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_hand_time_poly3_t" /></th>
                    <!-- 3#胶料上辅机-数据同步处理反馈 -->
                    <th data-options="width:80,field:'sync_hand_msg_poly3_s',editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_hand_msg_poly3_s" /></th>
                    <!-- 4#胶料上辅机-数据同步处理标记：0-未处理、1-已处理、5-处理失败 -->
                    <th data-options="width:80,field:'sync_hand_flag_poly4_s',formatter:syncHandFlagPoly4,editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_hand_flag_poly4_s" /></th>
                    <!-- 4#胶料上辅机-数据同步处理时间 -->
                    <th data-options="width:80,field:'sync_hand_time_poly4_t',editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_hand_time_poly4_t" /></th>
                    <!-- 4#胶料上辅机-数据同步处理反馈 -->
                    <th data-options="width:80,field:'sync_hand_msg_poly4_s',editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_hand_msg_poly4_s" /></th>
                    <!-- 5#胶料上辅机-数据同步处理标记：0-未处理、1-已处理、6-处理失败 -->
                    <th data-options="width:80,field:'sync_hand_flag_poly5_s',formatter:syncHandFlagPoly5,editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_hand_flag_poly5_s" /></th>
                    <!-- 5#胶料上辅机-数据同步处理时间 -->
                    <th data-options="width:80,field:'sync_hand_time_poly5_t',editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_hand_time_poly5_t" /></th>
                    <!-- 5#胶料上辅机-数据同步处理反馈 -->
                    <th data-options="width:80,field:'sync_hand_msg_poly5_s',editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_hand_msg_poly5_s" /></th>
                    <!-- 1#小料上辅机-数据同步处理标记：0-未处理、1-已处理、2-处理失败 -->
                    <th data-options="width:80,field:'sync_hand_flag_flauto1_s',formatter:syncHandFlagFlauto1,editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_hand_flag_flauto1_s" /></th>
                    <!-- 1#小料上辅机-数据同步处理时间 -->
                    <th data-options="width:80,field:'sync_hand_time_flauto1_t',editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_hand_time_flauto1_t" /></th>
                    <!-- 1#小料上辅机-数据同步处理反馈 -->
                    <th data-options="width:80,field:'sync_hand_msg_flauto1_s',editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_hand_msg_flauto1_s" /></th>
                    <!-- 2#小料上辅机-数据同步处理标记：0-未处理、1-已处理、3-处理失败 -->
                    <th data-options="width:80,field:'sync_hand_flag_flauto2_s',formatter:syncHandFlagFlauto2,editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_hand_flag_flauto2_s" /></th>
                    <!-- 2#小料上辅机-数据同步处理时间 -->
                    <th data-options="width:80,field:'sync_hand_time_flauto2_t',editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_hand_time_flauto2_t" /></th>
                    <!-- 2#小料上辅机-数据同步处理反馈 -->
                    <th data-options="width:80,field:'sync_hand_msg_flauto2_s',editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_hand_msg_flauto2_s" /></th>
                    <!-- 3#小料上辅机-数据同步处理标记：0-未处理、1-已处理、4-处理失败 -->
                    <th data-options="width:80,field:'sync_hand_flag_flauto3_s',formatter:syncHandFlagFlauto3,editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_hand_flag_flauto3_s" /></th>
                    <!-- 3#小料上辅机-数据同步处理时间 -->
                    <th data-options="width:80,field:'sync_hand_time_flauto3_t',editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_hand_time_flauto3_t" /></th>
                    <!-- 3#小料上辅机-数据同步处理反馈 -->
                    <th data-options="width:80,field:'sync_hand_msg_flauto3_s',editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_hand_msg_flauto3_s" /></th>
                    <!-- 1#炭黑输送-数据同步处理标记：0-未处理、1-已处理、2-处理失败 -->
                    <th data-options="width:80,field:'sync_hand_flag_cb1_s',formatter:syncHandFlagCb1,editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_hand_flag_cb1_s" /></th>
                    <!-- 1#炭黑输送-数据同步处理时间 -->
                    <th data-options="width:80,field:'sync_hand_time_cb1_t',editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_hand_time_cb1_t" /></th>
                    <!-- 1#炭黑输送-数据同步处理反馈 -->
                    <th data-options="width:80,field:'sync_hand_msg_cb1_s',editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_hand_msg_cb1_s" /></th>
                    <!-- 2#炭黑输送-数据同步处理标记：0-未处理、1-已处理、3-处理失败 -->
                    <th data-options="width:80,field:'sync_hand_flag_cb2_s',formatter:syncHandFlagCb2,editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_hand_flag_cb2_s" /></th>
                    <!-- 2#炭黑输送-数据同步处理时间 -->
                    <th data-options="width:80,field:'sync_hand_time_cb2_t',editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_hand_time_cb2_t" /></th>
                    <!-- 2#炭黑输送-数据同步处理反馈 -->
                    <th data-options="width:80,field:'sync_hand_msg_cb2_s',editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_hand_msg_cb2_s" /></th>
                    <!-- 3#炭黑输送-数据同步处理标记：0-未处理、1-已处理、4-处理失败 -->
                    <th data-options="width:80,field:'sync_hand_flag_cb3_s',formatter:syncHandFlagCb3,editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_hand_flag_cb3_s" /></th>
                    <!-- 3#炭黑输送-数据同步处理时间 -->
                    <th data-options="width:80,field:'sync_hand_time_cb3_t',editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_hand_time_cb3_t" /></th>
                    <!-- 3#炭黑输送-数据同步处理反馈 -->
                    <th data-options="width:80,field:'sync_hand_msg_cb3_s',editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_hand_msg_cb3_s" /></th>
                    <!-- 1#油料输送-数据同步处理标记：0-未处理、1-已处理、2-处理失败 -->
                    <th data-options="width:80,field:'sync_hand_flag_oil1_s',formatter:syncHandFlagOil1,editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_hand_flag_oil1_s" /></th>
                    <!-- 1#油料输送-数据同步处理时间 -->
                    <th data-options="width:80,field:'sync_hand_time_oil1_t',editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_hand_time_oil1_t" /></th>
                    <!-- 1#油料输送-数据同步处理反馈 -->
                    <th data-options="width:80,field:'sync_hand_msg_oil1_s',editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_hand_msg_oil1_s" /></th>
                    <!-- 2#油料输送-数据同步处理标记：0-未处理、1-已处理、3-处理失败 -->
                    <th data-options="width:80,field:'sync_hand_flag_oil2_s',formatter:syncHandFlagOil2,editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_hand_flag_oil2_s" /></th>
                    <!-- 2#油料输送-数据同步处理时间 -->
                    <th data-options="width:80,field:'sync_hand_time_oil2_t',editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_hand_time_oil2_t" /></th>
                    <!-- 2#油料输送-数据同步处理反馈 -->
                    <th data-options="width:80,field:'sync_hand_msg_oil2_s',editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_hand_msg_oil2_s" /></th>
                    <!-- 3#油料输送-数据同步处理标记：0-未处理、1-已处理、4-处理失败 -->
                    <th data-options="width:80,field:'sync_hand_flag_oil3_s',formatter:syncHandFlagOil3,editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_hand_flag_oil3_s" /></th>
                    <!-- 3#油料输送-数据同步处理时间 -->
                    <th data-options="width:80,field:'sync_hand_time_oil3_t',editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_hand_time_oil3_t" /></th>
                    <!-- 3#油料输送-数据同步处理反馈 -->
                    <th data-options="width:80,field:'sync_hand_msg_oil3_s',editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.sync_hand_msg_oil3_s" /></th>
                    <%--<!-- 使用状态：058001-未审核、058002-已审核、058003-正下发、058004-已下发、058005-已执行、058006-已关闭 -->--%>
                    <%--<th data-options="width:80,field:'status_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.status_s" /></th>--%>
                    <%--<!-- 审核人 -->--%>
                    <%--<th data-options="width:80,field:'check_name_s',editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.check_by_s" /></th>--%>
                    <%--<!-- 审核时间 -->--%>
                    <%--<th data-options="width:80,field:'check_time_t',editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.check_time_t" /></th>--%>
                    <%--<!-- 下发人 -->--%>
                    <%--<th data-options="width:80,field:'send_name_s',editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.send_by_s" /></th>--%>
                    <%--<!-- 下发时间 -->--%>
                    <%--<th data-options="width:80,field:'send_time_t',editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.send_time_t" /></th>--%>
                    <!-- 创建人 -->
                    <th data-options="width:80,field:'created_name_s',editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="width:80,field:'created_time_t',editor:{type:'textbox'}"><spring:message code="mixsilomaterialexec.column.created_time_t" /></th>



                </tr>
            </thead>
        </table>
    </div>
</body>
</html>
