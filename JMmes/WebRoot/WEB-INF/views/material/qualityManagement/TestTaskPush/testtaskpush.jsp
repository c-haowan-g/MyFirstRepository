<!-- 

    作者      :李昂
    时间      :2020-08-11 08:21:36 
    页面名称:TDM检测任务执行表[MES发WMS]
    文件关联:
        TestTaskPush.java
        TestTaskPushController.java
        TestTaskPushServiceImpl.java
        TestTaskPushServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="testtaskpush.js.jsp"%>
<script type="text/javascript" src="dict/001,-337.js"></script>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="TestTaskPush_dg_toolbar">
            <form id="TestTaskPush_search_form" class="form" >
                 <!-- 创建时间 -->
                <input type="radio" name="dummy5_s" value="created_time" checked>
                <spring:message code="testtaskpush.column.created_time_t" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input name="filter[created_time_t]" id="created_time_t" type="text" class="easyui-datebox" data-options="label:''" >
                <input name="filter[start_time]" id="start_time" type="text" class="easyui-datetimebox" data-options="label:''" >
                <!-- 任务反馈标记：0-待处理、1-已处理、2-已拒绝 -->
                <spring:message code="testtaskpush.column.data_check_flag_s" />
                <input name="filter[data_check_flag_s]" id="data_check_flag_s" type="text" class="easyui-combobox" data-options="label:'',
                                                   textField: 'label',
														data: [{
																label: '待处理',
																value: '0'
															},{
																label: '已处理',
																value: '1'
															},{
                                                          	label: '已拒绝',
																value: '2'
															}
															]" >
                       <!-- MES业务主键 -->
                <spring:message code="testtaskpush.column.mesbusinesscode_s" />
                <input name="filter[mesbusinesscode_s]" id="mesbusinesscode_s" type="text" class="easyui-textbox" data-options="label:''" >
                
                <!-- 物料编码 -->
                <spring:message code="testtaskpush.column.sapcode_s" />
                <input name="filter[sapcode_s]" id="sapcode_s" type="text" class="easyui-textbox" data-options="label:''" >
                </br>
                <!-- 送检日期 -->
               
                    
                <input type="radio" name="dummy5_s" value="sync_hand_time">
               送检时间&nbsp;——
                <%--<spring:message code="testtaskpush.column.result_receive_time_t" />--%>
                <input name="filter[sync_hand_time_t]" id="sync_hand_time_t" type="text" class="easyui-datebox" data-options="label:''" >
                
                </br>
               <!-- 结果-接收时间（质检时间） -->
                <input type="radio" name="dummy5_s" value="result_receive_time">
                质检时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <%--<spring:message code="testtaskpush.column.result_receive_time_t" />--%>
                <input name="filter[result_receive_time_t]" id="result_receive_time_t" type="text" class="easyui-datebox" data-options="label:''" >
                <input name="filter[end_time]" id="end_time" type="text" class="easyui-datetimebox" data-options="label:''" >
               
               <!-- 处理标记 -->
                <spring:message code="testtaskpush.column.sync_hand_flag_s" />
                <input name="filter[sync_hand_flag_s]" id="sync_hand_flag_s" type="text" class="easyui-combobox" data-options="label:'',
                                                   textField: 'label',
														data: [{
																label: '未处理',
																value: '0'
															},{
																label: '已处理',
																value: '1'
															},{
                                                          	label: '处理失败',
																value: '2'
															}
															]" >
				<!-- 样品批次：进厂批次 -->
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="testtaskpush.column.samplebatch_s" />
                <input name="filter[samplebatch_s]" id="samplebatch_s" type="text" class="easyui-textbox" data-options="label:''" >
                
                <!-- 条码：长度15位  条码前九位（物料名）、后六位（厂家） -->
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="testtaskpush.column.producername_custom_s" />
                <input name="filter[producername_s]" id="producername_custom_s" type="text" class="easyui-textbox" data-options="label:''" >
                
                
                </br>
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
                <a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="exportExcel()"><spring:message code="button.export" /></a>
            </form> 
           
        </div>
        <table id="testtaskpush_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: true,
                onSelect:selectrow,
                toolbar: '#TestTaskPush_dg_toolbar',
                url: 'material/qualityManagement/testtaskpush/datagrid',
                striped:true,
                method: 'get' 
                ">
           <%--  <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004 -->
                    <th data-options="field:'agenc_no_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.agenc_no_s" /></th>
                    <!-- 归档标记 -->
                    <th data-options="field:'arch_flag_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.arch_flag_s" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changed_by_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.changed_time_t" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.created_time_t" /></th>
                    <!-- 任务反馈标记：0-待处理、1-已处理、2-已拒绝 -->
                    <th data-options="field:'data_check_flag_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.data_check_flag_s" /></th>
                    <!-- 备用字段1：DQW检测项名称-气味等级是否合格：0-无DQW检测项，1-合格，2-不合格 -->
                    <th data-options="field:'dummy1_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.dummy1_s" /></th>
                    <!-- 备用字段2：物料组名称 -->
                    <th data-options="field:'dummy2_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.dummy2_s" /></th>
                    <!-- 备用字段3 -->
                    <th data-options="field:'dummy3_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.dummy3_s" /></th>
                    <!-- 备用字段4 -->
                    <th data-options="field:'dummy4_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.dummy4_s" /></th>
                    <!-- 备用字段5 -->
                    <th data-options="field:'dummy5_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.dummy5_s" /></th>
                    <!-- 最终检测结果 -->
                    <th data-options="field:'finalresult_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.finalresult_s" /></th>
                    <!-- 主键ID -->
                    <th data-options="field:'id_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.id_s" /></th>
                    <!-- MES业务主键 -->
                    <th data-options="field:'mesbusinesscode_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.mesbusinesscode_s" /></th>
                    <!-- 是否超期:0-正常状态 1-超期 -->
                    <th data-options="field:'outofdateflag_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.outofdateflag_s" /></th>
                    <!-- 条码：长度15位  条码前九位（物料名）、后六位（厂家） -->
                    <th data-options="field:'producername_custom_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.producername_custom_s" /></th>
                    <!-- 条码：长度21位  条码前九位（物料名）、后六位（厂家） -->
                    <th data-options="field:'producername_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.producername_s" /></th>
                    <!-- 记录标志，A可用，D删除 -->
                    <th data-options="field:'record_flag_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.record_flag_s" /></th>
                    <!-- 拒绝原因 -->
                    <th data-options="field:'refusereason_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.refusereason_s" /></th>
                    <!-- 拒绝-接收时间 -->
                    <th data-options="field:'refuse_receive_time_t',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.refuse_receive_time_t" /></th>
                    <!-- 结果-接收时间 -->
                    <th data-options="field:'result_receive_time_t',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.result_receive_time_t" /></th>
                    <!-- 检测结果：JSON格式 -->
                    <th data-options="field:'result_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.result_s" /></th>
                    <!-- 样品批次：进厂批次 -->
                    <th data-options="field:'samplebatch_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.samplebatch_s" /></th>
                    <!-- 样品名称 -->
                    <th data-options="field:'samplename_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.samplename_s" /></th>
                    <!-- SAP号 -->
                    <th data-options="field:'sapcode_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.sapcode_s" /></th>
                    <!-- 下发人 -->
                    <th data-options="field:'send_by_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.send_by_s" /></th>
                    <!-- 下发人姓名 -->
                    <th data-options="field:'send_name_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.send_name_s" /></th>
                    <!-- 下发标识：0-未下发、1-已下发、2-下发失败 -->
                    <th data-options="field:'send_state_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.send_state_s" /></th>
                    <!-- 下发时间 -->
                    <th data-options="field:'send_time_t',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.send_time_t" /></th>
                    <!-- MES状态编码： 001001-合格、 001002-不合格、 001003-待检状态 (MES发起的调拨只能调合格的）、 001004-封锁（MES不能调拨出库） -->
                    <th data-options="field:'state_code_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.state_code_s" /></th>
                    <!-- 进货数量 -->
                    <th data-options="field:'stocknum_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.stocknum_s" /></th>
                    <!-- 供应商 -->
                    <th data-options="field:'suppliername_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.suppliername_s" /></th>
                    <!-- 同步时间 -->
                    <th data-options="field:'sync_create_time_t',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.sync_create_time_t" /></th>
                    <!-- 数据同步处理：A-新增、U-修改、D-删除 -->
                    <th data-options="field:'sync_flag_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.sync_flag_s" /></th>
                   
                    
                    <!-- 工厂（1全钢 2半钢） -->
                    <th data-options="field:'s_factory_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.s_factory_s" /></th>
                    <!-- 专业组ID 114 技术中心化学组（招远） 115 技术中心物理组（招远） 123 实验中心化学检测室（招远） 124 实验中心半成品实验室（招远） 1101 实验中心化学实验室（柳州） 1102 实验中心半成品实验室（柳州） -->
                    <th data-options="field:'tdmgroupid_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.tdmgroupid_s" /></th>
                    <!-- 厂家批次 -->
                    <th data-options="field:'venderbatch_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.venderbatch_s" /></th>
                </tr>
            </thead> --%>
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- MES业务主键 -->
                    <th data-options="field:'mesbusinesscode_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.mesbusinesscode_s" /></th>
                    
                    <!-- 任务反馈标记：0-待处理、1-已处理、2-已拒绝 -->
                    <th data-options="field:'data_check_flag_s',formatter:data_check_flag_s"><spring:message code="testtaskpush.column.data_check_flag_s" /></th>
                    <!-- 拒绝原因 -->
                    <th data-options="field:'refusereason_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.refusereason_s" /></th>
                    <!-- 检测结果：JSON格式 -->
                    <th data-options="field:'result_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.result_s" /></th>
                    <!-- 条码：长度15位  条码前九位（物料名）、后六位（厂家） -->
                    <th data-options="field:'producername_custom_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.producername_custom_s" /></th>
                    
                    <!-- 物料编码 -->
                    <th data-options="field:'sapcode_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.sapcode_s" /></th>
                    <!-- 样品名称 -->
                    <th data-options="field:'samplename_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.samplename_s" /></th>
                    <!-- 样品批次：进厂批次 -->
                    <th data-options="field:'samplebatch_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.samplebatch_s" /></th>
                    <!-- 供应商 -->
                    <th data-options="field:'suppliername_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.suppliername_s" /></th>
                    <!-- 进货数量 -->
                    <th data-options="field:'stocknum_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.stocknum_s" /></th>
                    <!-- 厂家批次 -->
                    <th data-options="field:'venderbatch_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.venderbatch_s" /></th>
                    <!-- 是否超期:0-正常状态 1-超期 -->
                    <th data-options="field:'outofdateflag_s',formatter:isOutdate,editor:{type:'textbox'}"><spring:message code="testtaskpush.column.outofdateflag_s" /></th>
                    <!-- 处理时间 -->
                    <th data-options="field:'sync_hand_time_t',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.sync_hand_time_t" /></th>
                    <!-- 数据同步处理标记：0-未处理、1-已处理、2-处理失败 -->
                    <th data-options="field:'sync_hand_flag_s',formatter:isDispose,editor:{type:'textbox'}"><spring:message code="testtaskpush.column.sync_hand_flag_s" /></th>
                    <!-- 数据同步处理反馈 -->
                    <th data-options="field:'sync_hand_msg_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.sync_hand_msg_s" /></th>
                    <!-- 拒绝-接收时间 -->
                    <th data-options="field:'refuse_receive_time_t',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.refuse_receive_time_t" /></th>
                    <!-- 结果-接收时间 -->
                    <th data-options="field:'result_receive_time_t',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.result_receive_time_t" /></th>
                    <!-- 专业组ID 114 技术中心化学组（招远） 115 技术中心物理组（招远） 123 实验中心化学检测室（招远） 124 实验中心半成品实验室（招远） 1101 实验中心化学实验室（柳州） 1102 实验中心半成品实验室（柳州） -->
                    <th data-options="field:'tdmgroupid_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="testtaskpush.column.tdmgroupid_s" /></th>
                    <!-- 机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004 -->
                    <th data-options="field:'s_factory_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.s_factory_s" /></th>
                    <!-- 机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004 -->
                    <th data-options="field:'agenc_no_s',formatter:pushAgenc,editor:{type:'textbox'}"><spring:message code="testtaskpush.column.agenc_no_s" /></th>
                   	<!-- 备用字段1 -->
                    <th data-options="field:'dummy1_s',formatter:isQualified,editor:{type:'textbox'}"><spring:message code="testtaskpush.column.dummy1_s" /></th>
                    <!-- 备用字段2 -->
                    <th data-options="field:'dummy2_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.dummy2_s" /></th>
                    <!-- 备用字段3 -->
                    <th data-options="field:'dummy3_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.dummy3_s" /></th>
                    <!-- 备用字段4 -->
                    <th data-options="field:'dummy4_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.dummy4_s" /></th>
                    <!-- 备用字段5 -->
                    <th data-options="field:'dummy5_s',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.dummy5_s" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_name',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.created_time_t" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changed_by_name',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',editor:{type:'textbox'}"><spring:message code="testtaskpush.column.changed_time_t" /></th>

                </tr>
            </thead>
        </table>
    </div>

    <div data-options="region:'south',split:true" style="height:200px;">
        <div class="easyui-tabs" id="content_tab" data-options="fit:true,tools:'#tab-tools'">
            <div title="基本信息" style="padding:10px">
                <form id="TestTaskPush_searchbase_form" class="form" style="display:none">
                    <!-- 胶囊条码 -->
                    <spring:message code="testtaskpush.column.mesbusinesscode_s" />:
                    <input name="filter[mesbusinesscode_s]" id="base_mesbusinesscode_s" type="text" class="easyui-textbox" data-options="label:''" >
                    <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter1()"><spring:message code="button.search" /></a>
                </form>
                <!-- MES业务主键 -->
                <table border="1px" cellspacing="0" id="baselist_dg" width="100%">
                    <tr>
                        <td bgcolor="lightcyan"align="right">
                            <spring:message code="testtaskpush.column.mesbusinesscode_s" />
                        </td>
                        <td  width="20%">
                            <span id="dtmesbusinesscode_s"></span>
                            <!-- <input id="equip_code_s_sp" type="text" class="easyui-textbox">&emsp;  -->
                        </td>
                        <!--厂家批次-->
                        <td bgcolor="lightcyan"align="right">
                            <spring:message code="testtaskpush.column.venderbatch_s" />
                        </td>
                        <td width="20%">
                            <span id="dtvenderbatch_s"></span>
                            <!-- <input id="edt_code_s_sp" type="text" class="easyui-textbox"> -->
                        </td>
                        <!--备用1-->
                        <td bgcolor="lightcyan"align="right">
                            <spring:message code="testtaskpush.column.dummy1_s" />
                        </td>
                        <td width="20%">
                            <span id="dtdummy1_s"></span>
                            <!-- <input id="max_inploytemp_i_sp" type="text" class="easyui-textbox"> -->
                        </td>
                    </tr>

                    <tr>
                        <td bgcolor="lightcyan"align="right">
                            <!-- 任务反馈标记 -->
                            <spring:message code="testtaskpush.column.data_check_flag_s" />
                        </td>
                        <td>
                            <span id="dtdata_check_flag_s"></span>
                            <!-- <input id="mater_code_s_sp"  type="text" class="easyui-textbox"> -->
                        </td>
                        <!--是否超期-->
                        <td bgcolor="lightcyan"align="right">
                            <spring:message code="testtaskpush.column.outofdateflag_s" />
                        </td>
                        <td>
                            <span id="dtoutofdateflag_s"></span>
                            <!-- <input id="set_weigh_d_sp" type="text" class="easyui-textbox"> -->
                        </td>

                        <td bgcolor="lightcyan"align="right">
                            <!-- 备用2 -->
                            <spring:message code="testtaskpush.column.dummy2_s" />
                        </td>
                        <td>
                            <span id="dtdummy2_s"></span>
                            <!-- <input id="dischangetime_i_sp" type="text" class="easyui-textbox"> -->
                        </td>
                    </tr>

                    <tr>
                        <td bgcolor="lightcyan"align="right">
                           <!--拒绝原因-->
                            <spring:message code="testtaskpush.column.refusereason_s" />
                        </td>
                        <td>
                            <span id="dtrefusereason_s"></span>
                            <!-- <input id="mater_type_s_sp" type="text" class="easyui-textbox"> -->
                        </td>
                        <td bgcolor="lightcyan"align="right">
                            <!-- 处理时间 -->
                            <spring:message code="testtaskpush.column.sync_hand_time_t" />
                        </td>
                        <td>
                            <span id="dtsync_hand_time_t"></span>
                        </td>

                        

                        <td bgcolor="lightcyan"align="right">
                            <!-- 备用3 -->
                            <spring:message code="testtaskpush.column.dummy3_s" />
                        </td>
                        <td>
                            <span id="dtdummy3_s"></span>
                            <!-- <input id="plant_s_sp" type="text" class="easyui-textbox"> -->
                        </td>
                    </tr>

                    <tr>
                        <td bgcolor="lightcyan"align="right">
                            <!-- 检测结果 -->
                            <spring:message code="testtaskpush.column.result_s" />
                        </td>
                        <td>
                            <span id="dtresult_s"></span>
                            <!-- <input id="mater_name_s_sp" type="text" class="easyui-textbox">&emsp;  -->
                        </td>
                        
                         <td bgcolor="lightcyan"align="right">
                         
                            <!-- 数据同步处理标记 -->
                            <spring:message code="testtaskpush.column.sync_hand_flag_s" />
                        </td>
                        <td>
                            <span id="dtsync_hand_flag_s"></span>
                            <!-- <input id="overtemp_temp_i_sp" type="text" class="easyui-textbox"> -->
                        </td>

                       

                        <td bgcolor="lightcyan"align="right">
                            <!-- 备用4 -->
                            <spring:message code="testtaskpush.column.dummy4_s" />
                        </td>
                        <td>
                            <span id="dtdummy4_s"></span>
                            <!-- <input id="receive_time_t_sp" type="text" class="easyui-textbox"> -->
                        </td>
                    </tr>


                    <tr>
                        <td bgcolor="lightcyan"align="right">
                            <!-- 条码 -->
                            <spring:message code="testtaskpush.column.producername_custom_s" />
                        </td>
                        <td>
                            <span id="dtproducername_custom_s"></span>
                            <!-- <input id="b_version_s_sp" type="text" class="easyui-textbox">&emsp;  -->
                        </td>
                        
                        <td bgcolor="lightcyan"align="right">
                            <!-- 数据同步处理反馈 -->
                            <spring:message code="testtaskpush.column.sync_hand_msg_s" />
                        </td>
                        <td>
                            <span id="dtsync_hand_msg_s"></span>
                            <!-- <input id="min_inploytemp_i_sp" type="text" class="easyui-textbox"> -->
                        </td>
                        </th>

                        

                        <td bgcolor="lightcyan"align="right">
                            <!-- 备用5 -->
                            <spring:message code="testtaskpush.column.dummy5_s" />
                        </td>
                        <td>
                            <span id="dtdummy5_s"></span>
                            <!-- <input id="dummy2_s_sp" type="text" class="easyui-textbox">  -->
                        </td>
                    </tr>


                    <tr>
                        <td bgcolor="lightcyan"align="right">
                            <!-- SAP号 -->
                            <spring:message code="testtaskpush.column.sapcode_s" />
                        </td>
                        <td>
                            <span id="dtsapcode_s"></span>
                            <!-- <input id="edt_code_s_sp" type="text" class="easyui-textbox">&emsp;  -->
                        </td>
                        
                         <td bgcolor="lightcyan"align="right">
                            <!-- 拒绝-接收时间 -->
                            <spring:message code="testtaskpush.column.refuse_receive_time_t" />
                        </td>
                        <td>
                            <span id="dtrefuse_receive_time_t"></span>
                        </td> 


                        <td bgcolor="lightcyan"align="right">
                            <!-- 创建人 -->
                            <spring:message code="testtaskpush.column.created_by_s" />
                        </td>
                        <td>
                            <span id="dtcreated_by_s"></span>
                            <!-- <input id="dummy3_s_sp" type="text" class="easyui-textbox"> -->
                        </td>
                    </tr>

                    <tr>
                        <td bgcolor="lightcyan"align="right">
                            <!-- 样品名称 -->
                            <spring:message code="testtaskpush.column.samplename_s" />
                        </td>
                        <td>
                            <span id="dtsamplename_s"></span>
                            <!-- <input id="r_version_s_sp" type="text" class="easyui-textbox">&emsp;  -->
                        </td>
                        
                          <td bgcolor="lightcyan"align="right">
                            <!-- 结果-接收时间 -->
                            <spring:message code="testtaskpush.column.result_receive_time_t" />
                        </td>
                        <td>
                            <span id="dtresult_receive_time_t"></span>
                            <!-- <input id="overtemp_temp_i_sp" type="text" class="easyui-textbox"> -->
                        </td> 

                        <%-- <td bgcolor="lightcyan"align="right">
                            <!-- 机构编号 -->
                            <spring:message code="testtaskpush.column.agenc_no_s" />
                        </td>
                        <td>
                            <span id="dtagenc_no_s"></span>
                        </th> --%>

                        <td bgcolor="lightcyan"align="right">
                            <!-- 创建时间 -->
                            <spring:message code="testtaskpush.column.created_time_t" />
                        </td>
                        <td>
                            <span id="dtcreated_time_t"></span>
                            <!-- <input id="dummy4_s_sp" type="text" class="easyui-textbox"> -->
                        </td>
                    </tr>

                    <tr>
                        <td bgcolor="lightcyan"align="right">
                            <!-- 样品批次 -->
                            <spring:message code="testtaskpush.column.samplebatch_s" />
                        </td>
                        <td>
                            <span id="dtsamplebatch_s"></span>
                            <!-- <input id="dummy1_s_sp" type="text" class="easyui-textbox">&emsp;  -->
                        </td>
                        
                       <td bgcolor="lightcyan"align="right">
                            <!-- 专业组 -->
                            <spring:message code="testtaskpush.column.tdmgroupid_s" />
                        </td>
                        <td>
                            <span id="dttdmgroupid_s"></span>
                            <!-- <input id="min_inploytemp_i_sp" type="text" class="easyui-textbox"> -->
                        </td>
                        </th> 
                        
                        
                        <td bgcolor="lightcyan"align="right">
                            <!-- 修改人 -->
                            <spring:message code="testtaskpush.column.changed_by_s" />
                        </td>
                        <td>
                            <span id="dtchanged_by_s"></span>
                            <!-- <input id="dummy5_s_sp" type="text" class="easyui-textbox"> -->
                        </td>

                        
                    </tr>


                    <tr>
                        <td bgcolor="lightcyan"align="right">
                            <!-- 供应商 -->
                            <spring:message code="testtaskpush.column.suppliername_s" />
                        </td>
                        <td>
                            <span id="dtsuppliername_s"></span>
                            <!-- <input id="ismixed_s_sp" type="text" class="easyui-textbox">&emsp;  -->
                        </td>
                        
                        
                        <td bgcolor="lightcyan"align="right">
                            <!-- 工厂 -->
                            <spring:message code="testtaskpush.column.s_factory_s" />
                        </td>
                        <td>
                            <span id="dts_factory_s"></span>
                            <!-- <input id="makeup_temp_i_sp" type="text" class="easyui-textbox"> -->
                        </td> 

                        <td bgcolor="lightcyan"align="right">
                        
                      
                            <!--修改时间-->
                            <spring:message code="testtaskpush.column.changed_time_t" />
                        </td>
                        <td>
                            <span id="dtchanged_time_t"></span>
                        </td>

                        
                    </tr>

                    <tr>
                        <td bgcolor="lightcyan"align="right">
                            <!-- 进货数量 -->
                            <spring:message code="testtaskpush.column.stocknum_s" />
                        </td>
                        <td>
                            <span id="dtstocknum_s"></span>
                            <!-- <input id="matchingcode_s_sp" type="text" class="easyui-textbox"> -->
                        </td>

                        <td bgcolor="lightcyan"align="right">
                         <!-- 机构编号 -->
                            <spring:message code="testtaskpush.column.agenc_no_s" />
                        </td>
                        <td>
                        	<span id="dtagenc_no_s"></span>
                            <!-- <input id="matchingcode_s_sp" type="text" class="easyui-textbox"> -->
                        </td>
                    </tr>
                </table>
            </div>
            <div title="拒绝信息" style="padding:10px">
                <table id="reject_dg" class="easyui-datagrid" style="width:100%"
                       data-options="
						                fit:true,
						                fitColumns:true,
						                pagination:false,
						                rownumbers: true,
						                singleSelect: true,
						                striped:true,
						                emptyMsg: '<span><spring:message code='tip.noData'/></span>',
						                remoteSort:false,
						                method: 'get'
					">
                    <thead>
                    <tr>
                        <!-- MES业务主键-->
                        <th data-options="field:'mesbusinesscode_s'"><spring:message code="testtaskdenial.column.mesbusinesscode_s" /></th>
                        <!-- 条码 -->
                        <th data-options="field:'venderbatch_short_s'"><spring:message code="testtaskdenial.column.venderbatch_short_s" /></th>
                        <!-- 样品批次 -->
                        <th data-options="field:'samplebatch_s'"><spring:message code="testtaskdenial.column.samplebatch_s" /></th>
                        <!-- 拒绝原因 -->
                        <th data-options="field:'refusereason_s'"><spring:message code="testtaskdenial.column.refusereason_s" /></th>
                        <!-- 接收时间 -->
                        <th data-options="field:'receive_time_t'"><spring:message code="testtaskdenial.column.receive_time_t" /></th>
                        <!-- 预留1 -->
                        <th data-options="field:'dummy1_s'"><spring:message code="testtaskdenial.column.dummy1_s" /></th>
                        <!-- 预留2  -->
                        <th data-options="field:'dummy2_s'"><spring:message code="testtaskdenial.column.dummy2_s" /></th>
                        <!-- 预留3  -->
                        <th data-options="field:'dummy3_s'"><spring:message code="testtaskdenial.column.dummy3_s" /></th>
                        <!-- 预留4 -->
                        <th data-options="field:'dummy4_s'"><spring:message code="testtaskdenial.column.dummy4_s" /></th>
                        <!-- 预留5 -->
                        <th data-options="field:'dummy5_s'"><spring:message code="testtaskdenial.column.dummy5_s" /></th>
                    </tr>
                    </thead>
                </table>
            </div>
            <div title="反馈信息" style="padding:10px">
                <table id="result_dg" class="easyui-datagrid" style="width:100%"
                       data-options="
						               	fit:true,
						                fitColumns:true,
						                pagination:false,
						                
						                singleSelect: true,
						                striped:true,
						                remoteSort:false,
						                method: 'get'  ,
						                rownumbers:true
					">
                    <thead>
                    <tr>
                        <!-- MES业务主键-->
                        <th data-options="field:'mesbusinesscode_s'"><spring:message code="testtaskdetail.column.mesbusinesscode_s" /></th>
                        <!-- 条码 -->
                        <th data-options="field:'venderbatch_s' "><spring:message code="testtaskdetail.column.venderbatch_s" /></th>
                        <!-- 样品批次 -->
                       	<th data-options="field:'tdsamplebatch_s'"><spring:message code="testtaskresult.column.tdsamplebatch_s" /></th>
                        <!-- 测试结果 -->
                        <th data-options="field:'test_result_s'"><spring:message code="testtaskdetail.column.test_result_s" /></th>
                        <!-- 检测项目 -->
                        <th data-options="field:'test_items_s' "><spring:message code="testtaskdetail.column.test_items_s" /></th>
                        <!-- 检测参数 -->
                        <th data-options="field:'test_paras_s' "><spring:message code="testtaskdetail.column.test_paras_s" /></th>
                        <!-- 检测方法  -->
                        <th data-options="field:'test_method_s' "><spring:message code="testtaskdetail.column.test_method_s" /></th>
                        <!-- 条件单位  -->
                        <th data-options="field:'executive_unit_s' "><spring:message code="testtaskdetail.column.executive_unit_s" /></th>
                        <!-- 条件要求值 -->
                        <th data-options="field:'executive_reqvalue_s' "><spring:message code="testtaskdetail.column.executive_reqvalue_s" /></th>
                        <!-- 条件实际值-->
                        <th data-options="field:'executive_actualvalue_s' "><spring:message code="testtaskdetail.column.executive_actualvalue_s" /></th>
                        <!-- 执行标准 -->
                        <th data-options="field:'executive_standard_s' "><spring:message code="testtaskdetail.column.executive_standard_s" /></th>
                        <!-- 判断范围 -->
                        <th data-options="field:'decisionscope_s' "><spring:message code="testtaskdetail.column.decisionscope_s" /></th>
                        <!-- 分项结论 -->
                        <th data-options="field:'sub_conclusion_s' "><spring:message code="testtaskdetail.column.sub_conclusion_s" /></th>
                        <!-- 接收时间 -->
                        <th data-options="field:'tdreceive_time_t' "><spring:message code="testtaskresult.column.tdreceive_time_t" /></th> 
                        <!-- 备用字段1 -->
                        <th data-options="field:'dummy1_s' "><spring:message code="testtaskdetail.column.dummy1_s" /></th>
                        <!-- 备用字段2 -->
                        <th data-options="field:'dummy2_s' "><spring:message code="testtaskdetail.column.dummy2_s" /></th>
                        <!-- 备用字段3 -->
                        <th data-options="field:'dummy3_s' "><spring:message code="testtaskdetail.column.dummy3_s" /></th>
                        <!-- 备用字段4 -->
                        <th data-options="field:'dummy4_s' "><spring:message code="testtaskdetail.column.dummy4_s" /></th>
                        <!-- 备用字段5 -->
                        <th data-options="field:'dummy5_s' "><spring:message code="testtaskdetail.column.dummy5_s" /></th>

                    </tr>
                    </thead> 
        </table>
    </div>
    
</body>
</html>
