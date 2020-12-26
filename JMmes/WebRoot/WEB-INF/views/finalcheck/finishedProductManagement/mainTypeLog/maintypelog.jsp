<!-- 

    作者      :时永良
    时间      :2018-11-28 09:59:40 
    页面名称:轮胎主表(终检蓝英接口同步履历)
    文件关联:
        MainTypeLog.java
        MainTypeLogController.java
        MainTypeLogServiceImpl.java
        MainTypeLogServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="maintypelog.js.jsp"%>
<script type="text/javascript" src="dict/253,252.js"></script>
<body class="easyui-layout" fit="true"> 
 <div class="easyui-tabs" fit="true" border="false" style="width:700px;height:250px">
   	<!-- 历史履历 -->
    <div title="<spring:message code='tip.history'/>" style="padding:10px">
     <div style="width:100%;height:100%">
        <div id="MainTypeLog_dg_toolbar">
            <form id="MainTypeLog_search_form" class="form" >
                 <!-- 数据同步创建时间 -->
                <spring:message code="maintypelog.column.sync_create_time_t" />:
                 <input name="filter[begin_created_time]" editable="true" id="begin_created_time"
							type="text" class="easyui-datetimebox" style="width:170px"
							data-options="label:''">
						到 <input name="filter[end_created_time]" editable="true" id="end_created_time"
							class="easyui-datetimebox" style="width:170px">
               <!-- 轮胎条码 -->
                <spring:message code="qualitydegrade.column.barcode_s" />:
                <input name="filter[barcode_s]" id="barcode_s" type="text" class="easyui-textbox" data-options="label:''" >
                  <!-- 物料编码 -->
                <spring:message code="maintypelog.column.curingspeccode_s" />:
                <input name="filter[curingspeccode_s]" id="curingspeccode_s" type="text" class="easyui-textbox" data-options="label:''" >
                <br/>
                <!-- 数据同步处理标记：0-未处理、1-已处理 -->
               <spring:message code="maintypelog.column.sync_hand_flag_s" />:
                <input name="filter[sync_hand_flag_s]" id="sync_hand_flag_s" type="text" class="easyui-combobox"
                 data-options="
                 valueField:'value',
                 textField:'text',
                 data: [
                 		 {text:'请选择',
                 		 value:''},
                 		 {text: '未处理',
                         value: 2},
                         {text: '已处理',
						  value: 1
						}]" />
			 <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            </form> 
         </div>
        <table id="maintypelog_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: true,
                toolbar: '#MainTypeLog_dg_toolbar',
                url: '',
                striped:true,
                method: 'get',
                emptyMsg: '<span><spring:message code='tip.noData'/></span>' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 轮胎条码：MainTyre.BARCODE -->
                    <th data-options="field:'barcode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.barcode_s" /></th>
                    <!-- 数据同步处理：A-新增、U-修改、D-删除 -->
                    <th data-options="field:'sync_flag_s',formatter:syncflagFormatter,editor:{type:'textbox'}"><spring:message code="maintypelog.column.sync_flag_s" /></th>
                    <!-- 数据同步处理标记：0-未处理、1-已处理 -->
                    <th data-options="field:'sync_hand_flag_s',formatter:handflagFormatter,editor:{type:'textbox'}"><spring:message code="maintypelog.column.sync_hand_flag_s" /></th>
                    <!-- 数据同步处理反馈 -->
                    <th data-options="field:'sync_hand_msg_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.sync_hand_msg_s" /></th>
                    <!-- 数据同步处理时间 -->
                    <th data-options="field:'sync_hand_time_t',editor:{type:'textbox'}"><spring:message code="maintypelog.column.sync_hand_time_t" /></th>
                   	<!-- 数据同步创建时间 -->
                    <th data-options="field:'sync_create_time_t',editor:{type:'textbox'}"><spring:message code="maintypelog.column.sync_create_time_t" /></th>
                    <!-- 外胎操作时间 -->
                    <th data-options="field:'visualpasstime_t',editor:{type:'textbox'}"><spring:message code="maintypelog.column.visualpasstime_t" /></th>
                    <!-- X光通过时间 -->
                    <th data-options="field:'xlightpasstime_t',editor:{type:'textbox'}"><spring:message code="maintypelog.column.xlightpasstime_t" /></th>
                    <!-- 动平衡通过时间 -->
                    <th data-options="field:'dynamicbalancepasstime_t',editor:{type:'textbox'}"><spring:message code="maintypelog.column.dynamicbalancepasstime_t" /></th>
                    <!-- 入库等级 -->
                    <th data-options="field:'storage_level_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="maintyrecur.column.storage_level_s" /></th>
                    
                    <!-- 轮胎去向标识：1-返修、2-割毛 -->
                    <th data-options="field:'trackdirection_s',formatter:trackFormatter,editor:{type:'textbox'}"><spring:message code="maintypelog.column.trackdirection_s" /></th>
                     <!-- 备用字段1 -->
                    <th data-options="field:'spare1_s',width:80,editor:{type:'textbox'}"><spring:message code="maintypelog.column.spare1_s" /></th>
                    <!-- 备用字段2 -->
                    <th data-options="field:'spare2_s',width:80,editor:{type:'textbox'}"><spring:message code="maintypelog.column.spare2_s" /></th>
                    <!-- 备用字段3 -->
                    <th data-options="field:'spare3_s',width:80,editor:{type:'textbox'}"><spring:message code="maintypelog.column.spare3_s" /></th>
                    <!-- 备用字段4 -->
                    <th data-options="field:'spare4_s',formatter:codeFormatter,width:80,editor:{type:'textbox'}"><spring:message code="maintypelog.column.spare4_s" /></th>
                    <!-- 备用字段5 -->
                    <th data-options="field:'spare5_s',width:80,editor:{type:'textbox'}"><spring:message code="maintypelog.column.spare5_s" /></th>
                   
                    <!-- 气泡病象编号：D_BS_Reas.REAS_CODE -->
                    <th data-options="field:'blistercode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.blistercode_s" /></th>
                    <!-- 气泡检查次数 -->
                    <th data-options="field:'blistercount_i',editor:{type:'textbox'}"><spring:message code="maintypelog.column.blistercount_i" /></th>
                    <!-- 气泡质量等级 -->
                    <th data-options="field:'blistergradecode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.blistergradecode_s" /></th>
                    <!-- 气泡设备条码 -->
                    <th data-options="field:'blistermbarcode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.blistermbarcode_s" /></th>
                    <!-- 气泡通过时间 -->
                    <th data-options="field:'blisterpasstime_t',editor:{type:'textbox'}"><spring:message code="maintypelog.column.blisterpasstime_t" /></th>
                    <!-- 气泡质检员工号 -->
                    <th data-options="field:'blisteruserid_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.blisteruserid_s" /></th>
                     <th data-options="field:'changed_time_t',editor:{type:'textbox'}"><spring:message code="maintypelog.column.changed_time_t" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',editor:{type:'textbox'}"><spring:message code="maintypelog.column.created_time_t" /></th>
                    <!-- 硫化合模时间 -->
                    <th data-options="field:'curingclosemouldtime_t',editor:{type:'textbox'}"><spring:message code="maintypelog.column.curingclosemouldtime_t" /></th>
                    <!-- 硫化换模首条确认标记：0-否，1-是 -->
                    <th data-options="field:'curingfirstflag_s',formatter:curingFormatter,editor:{type:'textbox'}"><spring:message code="maintypelog.column.curingfirstflag_s" /></th>
                    <!-- 硫化质量等级 -->
                    <th data-options="field:'curinggradecode_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="maintypelog.column.curinggradecode_s" /></th>
                    <!-- 硫化机台 -->
                    <th data-options="field:'curingmachinecode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.curingmachinecode_s" /></th>
                    <!-- 硫化开模时间 -->
                    <th data-options="field:'curingopenmouldtime_t',editor:{type:'textbox'}"><spring:message code="maintypelog.column.curingopenmouldtime_t" /></th>
                    <!-- 硫化物料编码 -->
                    <th data-options="field:'curingspeccode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.curingspeccode_s" /></th>
                   
                    <!-- 成型换规首条确认标记：0-否，1-是 -->
                    <th data-options="field:'buildingfirstflag_s',formatter:buildFormatter,editor:{type:'textbox'}"><spring:message code="maintypelog.column.buildingfirstflag_s" /></th>
                    <!-- 成型质量等级编码 -->
                    <th data-options="field:'buildingradecode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.buildingradecode_s" /></th>
                    <!-- 成型物料编码 -->
                    <th data-options="field:'buildingspeccode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.buildingspeccode_s" /></th>
                    <!-- 成型作业ID -->
                    <th data-options="field:'buildingtaskid_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.buildingtaskid_s" /></th>
                    <!-- 成型生产时间 -->
                    <th data-options="field:'buildingtime_t',editor:{type:'textbox'}"><spring:message code="maintypelog.column.buildingtime_t" /></th>
                    <!-- 成型机台 -->
                    <th data-options="field:'buildinmachinecode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.buildinmachinecode_s" /></th>
                    <!-- 物流装笼笼号 -->
                    <th data-options="field:'cagenumber_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.cagenumber_s" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changed_by_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                                       <!-- 外胎延时硫化标记，1为延时硫化，其余为空 -->
                    <th data-options="field:'curingtimedelay_s',formatter:curingtimeFormatter,editor:{type:'textbox'}"><spring:message code="maintypelog.column.curingtimedelay_s" /></th>
                    <!-- 硫化员工号 -->
                    <th data-options="field:'curinguserid_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.curinguserid_s" /></th>
                    <!-- 疑问胎标记：1标记 -->
                    <th data-options="field:'doubtflag_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.doubtflag_s" /></th>
                    <!-- 动平衡检查次数 -->
                    <th data-options="field:'dynamicbalancecount_i',editor:{type:'textbox'}"><spring:message code="maintypelog.column.dynamicbalancecount_i" /></th>
                    <!-- 动平衡质量等级 -->
                    <th data-options="field:'dynamicbalancegradecode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.dynamicbalancegradecode_s" /></th>
                    <!-- 动平衡配方号 -->
                    <th data-options="field:'dynamicbalanceindex_i',editor:{type:'textbox'}"><spring:message code="maintypelog.column.dynamicbalanceindex_i" /></th>
                    <!-- 动平衡机条码 -->
                    <th data-options="field:'dynamicbalancembarcode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.dynamicbalancembarcode_s" /></th>
                   <!-- 动平衡病象编号：D_BS_Reas.REAS_CODE -->
                    <th data-options="field:'dynamicbalancereascode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.dynamicbalancereascode_s" /></th>
                    <!-- 动平衡质检员工号 -->
                    <th data-options="field:'dynamicbalanceuserid_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.dynamicbalanceuserid_s" /></th>
                    <!-- 质量等级编码 -->
                    <th data-options="field:'gradecode_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="maintypelog.column.gradecode_s" /></th>
                    <!-- 轮胎毛重量 -->
                    <th data-options="field:'grossweight_i',editor:{type:'textbox'}"><spring:message code="maintypelog.column.grossweight_i" /></th>
                    <!-- 割毛次数 -->
                    <th data-options="field:'hairscount_i',editor:{type:'textbox'}"><spring:message code="maintypelog.column.hairscount_i" /></th>
                    <!-- 割毛质量等级 -->
                    <th data-options="field:'hairsgradecode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.hairsgradecode_s" /></th>
                    <!-- 割毛操作时间 -->
                    <th data-options="field:'hairspasstime_t',editor:{type:'textbox'}"><spring:message code="maintypelog.column.hairspasstime_t" /></th>
                    <!-- 物流推送-推送次数 -->
                    <th data-options="field:'handcount_i',editor:{type:'textbox'}"><spring:message code="maintypelog.column.handcount_i" /></th>
                    <!-- 物流推送-推送标记：0-未推送，1-已推送 -->
                    <th data-options="field:'handflag_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.handflag_s" /></th>
                    <!-- 镂空条码 -->
                    <th data-options="field:'hollowedbarcode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.hollowedbarcode_s" /></th>
                     <!-- 跟踪胎标识：1跟踪 -->
                    <th data-options="field:'integratedcode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.integratedcode_s" /></th>
                    <!-- 是否复检：0未复检、1已复检过 -->
                    <th data-options="field:'isrck_s',formatter:isrckFormatter,editor:{type:'textbox'}"><spring:message code="maintypelog.column.isrck_s" /></th>
                    <!-- 当前工序 -->
                    <th data-options="field:'proess_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="maintypelog.column.proess_s" /></th>
                    <!-- 病象编号：D_BS_Reas.REAS_CODE -->
                    <th data-options="field:'reascode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.reascode_s" /></th>
                    <!-- 记录标志，A可用，D删除 -->
                    <th data-options="field:'record_flag_s',formatter:recordflagFormatter,editor:{type:'textbox'}"><spring:message code="maintypelog.column.record_flag_s" /></th>
                    <!-- 物流推送-错误消息（处理成功是返回空） -->
                    <th data-options="field:'returnmsg_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.returnmsg_s" /></th>
                    <!-- 物流推送-返回处理结果状态(S:处理成功，E:处理失败，U:处理异常) -->
                    <th data-options="field:'returnstatus_s',formatter:returnstatusFormatter,editor:{type:'textbox'}"><spring:message code="maintypelog.column.returnstatus_s" /></th>
                    <!-- 销售方式：0-内销、1-外销 -->
                    <th data-options="field:'saletype_s',formatter:saletypeFormatter,editor:{type:'textbox'}"><spring:message code="maintypelog.column.saletype_s" /></th>
                    <!-- 轮胎状态编码：0-待检、1-合格、2-不合格 -->
                    <th data-options="field:'statecode_s',formatter:statecodeFormatter,editor:{type:'textbox'}"><spring:message code="maintypelog.column.statecode_s" /></th>
                    <!-- 工厂（1全钢2半钢） -->
                    <th data-options="field:'s_factory_s',formatter:factoryFormatter,editor:{type:'textbox'}"><spring:message code="maintypelog.column.s_factory_s" /></th>
                    <!-- 机构编号：招远8000；德州8002柳州8003泰国8004 -->
                    <th data-options="field:'agenc_no_s',formatter:agencFormatter,editor:{type:'textbox'}"><spring:message code="maintypelog.column.agenc_no_s" /></th>
                    <!-- 归档标记 -->
                    <th data-options="field:'arch_flag_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.arch_flag_s" /></th>
                    <!-- 预入库胎抽检扫描时间 -->
                    <th data-options="field:'tackchecktime_t',editor:{type:'textbox'}"><spring:message code="maintypelog.column.tackchecktime_t" /></th>
                    <!-- 预入库胎抽检扫描人ID -->
                    <th data-options="field:'tackcheckuserid_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.tackcheckuserid_s" /></th>
                    <!-- 总返修次数 -->
                    <th data-options="field:'totalreworknum_i',editor:{type:'textbox'}"><spring:message code="maintypelog.column.totalreworknum_i" /></th>
                    <!-- 均匀度检查次数 -->
                    <th data-options="field:'uniformitycount_i',editor:{type:'textbox'}"><spring:message code="maintypelog.column.uniformitycount_i" /></th>
                    <!-- 均匀度质量等级 -->
                    <th data-options="field:'uniformitygradecode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.uniformitygradecode_s" /></th>
                    <!-- 均匀度配方号 -->
                    <th data-options="field:'uniformityindex_i',editor:{type:'textbox'}"><spring:message code="maintypelog.column.uniformityindex_i" /></th>
                    <!-- 均匀度设备条码 -->
                    <th data-options="field:'uniformitymbarcode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.uniformitymbarcode_s" /></th>
                    <!-- 均匀度通过时间 -->
                    <th data-options="field:'uniformitypasstime_t',editor:{type:'textbox'}"><spring:message code="maintypelog.column.uniformitypasstime_t" /></th>
                    <!-- 均匀度病象编号：D_BS_Reas.REAS_CODE -->
                    <th data-options="field:'uniformityreascode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.uniformityreascode_s" /></th>
                    <!-- 均匀度质检员工号 -->
                    <th data-options="field:'uniformityuserid_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.uniformityuserid_s" /></th>
                    <!-- 外胎检查次数 -->
                    <th data-options="field:'visualcount_i',editor:{type:'textbox'}"><spring:message code="maintypelog.column.visualcount_i" /></th>
                    <!-- 外胎重检一次操作时间 -->
                    <th data-options="field:'visuald1_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.visuald1_s" /></th>
                    <!-- 外胎重检二次操作时间 -->
                    <th data-options="field:'visuald3_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.visuald3_s" /></th>
                    <!-- 外胎质量等级 -->
                    <th data-options="field:'visualgradecode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.visualgradecode_s" /></th>
                    <!-- 外胎重检一次检测工位 -->
                    <th data-options="field:'visualmbarcode1_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.visualmbarcode1_s" /></th>
                    <!-- 外胎重检一次检测工位 -->
                    <th data-options="field:'visualmbarcode2_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.visualmbarcode2_s" /></th>
                   <!-- 外胎重检一次次扫描人ID -->
                    <th data-options="field:'visualuserid1_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.visualuserid1_s" /></th>
                    <!-- 外胎重检二次扫描人ID -->
                    <th data-options="field:'visualuserid2_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.visualuserid2_s" /></th>
                    <!-- 年周号 -->
                    <th data-options="field:'weeklynumber_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.weeklynumber_s" /></th>
                    <!-- X光检查次数 -->
                    <th data-options="field:'xlightcount_i',editor:{type:'textbox'}"><spring:message code="maintypelog.column.xlightcount_i" /></th>
                    <!-- X光质量等级 -->
                    <th data-options="field:'xlightgradecode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.xlightgradecode_s" /></th>
                    <!-- X光配方号 -->
                    <th data-options="field:'xlightindex_i',editor:{type:'textbox'}"><spring:message code="maintypelog.column.xlightindex_i" /></th>
                    <!-- X光机条码 -->
                    <th data-options="field:'xlightmbarcode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.xlightmbarcode_s" /></th>
                    <!-- X光病象编号：D_BS_Reas.REAS_CODE -->
                    <th data-options="field:'xlightreascode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.xlightreascode_s" /></th>
                    <!-- X光质检员工号 -->
                    <th data-options="field:'xlightuserid_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.xlightuserid_s" /></th>
                </tr>
            </thead>
        </table>
    </div>
    </div>
    <!-- 同步履历 -->
    <div title="<spring:message code='tip.synchronization'/>" style="padding:10px">
    	<div style="width:100%;height:100%">
        <div id="MainTypeLog_dg_toolbar_history">
            <form id="MainTypeHistoryLog_search_form" class="form" >
                 <!-- 数据同步创建时间 -->
                <spring:message code="maintypelog.column.sync_create_time_t" />:
                 <input name="filter[begin_created_time_history]" editable="true" id="begin_created_time_history"
							type="text" class="easyui-datetimebox" style="width:170px"
							data-options="label:''">
						到 <input name="filter[end_created_time_history]" editable="true" id="end_created_time_history"
							class="easyui-datetimebox" style="width:170px">
               <!-- 轮胎条码 -->
                <spring:message code="qualitydegrade.column.barcode_s" />:
                <input name="filter[barcode_s_history]" id="barcode_s_history" type="text" class="easyui-textbox" data-options="label:''" >
                  <!-- 物料编码 -->
                <spring:message code="maintypelog.column.curingspeccode_s" />:
                <input name="filter[curingspeccode_s_history]" id="curingspeccode_s_history" type="text" class="easyui-textbox" data-options="label:''" >
                <br/>
                <!-- 数据同步处理标记：0-未处理、1-已处理 -->
               <spring:message code="maintypelog.column.sync_hand_flag_s" />:
                <input name="filter[sync_hand_flag_s_history]" id="sync_hand_flag_s_history" type="text" class="easyui-combobox"
                 data-options="
                 valueField:'value',
                 textField:'text',
                 data: [
                 		 {text:'请选择',
                 		 value:''},
                 		 {text: '未处理',
                         value: 2},
                         {text: '已处理',
						  value: 1
						}]" />
			 <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="hsitoryfilter()"><spring:message code="button.search" /></a>
           <%--  <auth:button code="XXX"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            --%> </form> 
         </div>
        <table id="maintypelog_dg_history" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#MainTypeLog_dg_toolbar_history',
                url: '',
                striped:true,
                method: 'get',
                emptyMsg: '<span><spring:message code='tip.noData'/></span>' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 轮胎条码：MainTyre.BARCODE -->
                    <th data-options="field:'barcode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.barcode_s" /></th>
                    <!-- 数据同步创建时间 -->
                    <th data-options="field:'sync_create_time_t',editor:{type:'textbox'}"><spring:message code="maintypelog.column.sync_create_time_t" /></th>
                    <!-- 数据同步处理：A-新增、U-修改、D-删除 -->
                    <th data-options="field:'sync_flag_s',formatter:syncflagFormatter,editor:{type:'textbox'}"><spring:message code="maintypelog.column.sync_flag_s" /></th>
                    <!-- 数据同步处理标记：0-未处理、1-已处理 -->
                    <th data-options="field:'sync_hand_flag_s',formatter:handflagFormatter,editor:{type:'textbox'}"><spring:message code="maintypelog.column.sync_hand_flag_s" /></th>
                    <!-- 数据同步处理反馈 -->
                    <th data-options="field:'sync_hand_msg_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.sync_hand_msg_s" /></th>
                    <!-- 数据同步处理时间 -->
                    <th data-options="field:'sync_hand_time_t',editor:{type:'textbox'}"><spring:message code="maintypelog.column.sync_hand_time_t" /></th>
                    <!-- 外胎操作时间 -->
                    <th data-options="field:'visualpasstime_t',editor:{type:'textbox'}"><spring:message code="maintypelog.column.visualpasstime_t" /></th>
                    <!-- X光通过时间 -->
                    <th data-options="field:'xlightpasstime_t',editor:{type:'textbox'}"><spring:message code="maintypelog.column.xlightpasstime_t" /></th>
                    <!-- 动平衡通过时间 -->
                    <th data-options="field:'dynamicbalancepasstime_t',editor:{type:'textbox'}"><spring:message code="maintypelog.column.dynamicbalancepasstime_t" /></th>
                    <!-- 入库等级 -->
                    <th data-options="field:'storage_level_s',editor:{type:'textbox'}"><spring:message code="maintyrecur.column.storage_level_s" /></th>
                    
                    
                    <!-- 轮胎去向标识：1-返修、2-割毛 -->
                    <th data-options="field:'trackdirection_s',formatter:trackFormatter,editor:{type:'textbox'}"><spring:message code="maintypelog.column.trackdirection_s" /></th>
                     <!-- 备用字段1 -->
                    <th data-options="field:'spare1_s',width:80,editor:{type:'textbox'}"><spring:message code="maintypelog.column.spare1_s" /></th>
                    <!-- 备用字段2 -->
                    <th data-options="field:'spare2_s',width:80,editor:{type:'textbox'}"><spring:message code="maintypelog.column.spare2_s" /></th>
                    <!-- 备用字段3 -->
                    <th data-options="field:'spare3_s',width:80,editor:{type:'textbox'}"><spring:message code="maintypelog.column.spare3_s" /></th>
                    <!-- 备用字段4 -->
                    <th data-options="field:'spare4_s',width:80,editor:{type:'textbox'}"><spring:message code="maintypelog.column.spare4_s" /></th>
                    <!-- 备用字段5 -->
                    <th data-options="field:'spare5_s',width:80,editor:{type:'textbox'}"><spring:message code="maintypelog.column.spare5_s" /></th>
                   
                    <!-- 气泡病象编号：D_BS_Reas.REAS_CODE -->
                    <th data-options="field:'blistercode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.blistercode_s" /></th>
                    <!-- 气泡检查次数 -->
                    <th data-options="field:'blistercount_i',editor:{type:'textbox'}"><spring:message code="maintypelog.column.blistercount_i" /></th>
                    <!-- 气泡质量等级 -->
                    <th data-options="field:'blistergradecode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.blistergradecode_s" /></th>
                    <!-- 气泡设备条码 -->
                    <th data-options="field:'blistermbarcode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.blistermbarcode_s" /></th>
                    <!-- 气泡通过时间 -->
                    <th data-options="field:'blisterpasstime_t',editor:{type:'textbox'}"><spring:message code="maintypelog.column.blisterpasstime_t" /></th>
                    <!-- 气泡质检员工号 -->
                    <th data-options="field:'blisteruserid_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.blisteruserid_s" /></th>
                     <th data-options="field:'changed_time_t',editor:{type:'textbox'}"><spring:message code="maintypelog.column.changed_time_t" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',editor:{type:'textbox'}"><spring:message code="maintypelog.column.created_time_t" /></th>
                    <!-- 硫化合模时间 -->
                    <th data-options="field:'curingclosemouldtime_t',editor:{type:'textbox'}"><spring:message code="maintypelog.column.curingclosemouldtime_t" /></th>
                    <!-- 硫化换模首条确认标记：0-否，1-是 -->
                    <th data-options="field:'curingfirstflag_s',formatter:curingFormatter,editor:{type:'textbox'}"><spring:message code="maintypelog.column.curingfirstflag_s" /></th>
                    <!-- 硫化质量等级 -->
                    <th data-options="field:'curinggradecode_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="maintypelog.column.curinggradecode_s" /></th>
                    <!-- 硫化机台 -->
                    <th data-options="field:'curingmachinecode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.curingmachinecode_s" /></th>
                    <!-- 硫化开模时间 -->
                    <th data-options="field:'curingopenmouldtime_t',editor:{type:'textbox'}"><spring:message code="maintypelog.column.curingopenmouldtime_t" /></th>
                    <!-- 硫化物料编码 -->
                    <th data-options="field:'curingspeccode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.curingspeccode_s" /></th>
                   
                    <!-- 成型换规首条确认标记：0-否，1-是 -->
                    <th data-options="field:'buildingfirstflag_s',formatter:buildFormatter,editor:{type:'textbox'}"><spring:message code="maintypelog.column.buildingfirstflag_s" /></th>
                    <!-- 成型质量等级编码 -->
                    <th data-options="field:'buildingradecode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.buildingradecode_s" /></th>
                    <!-- 成型物料编码 -->
                    <th data-options="field:'buildingspeccode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.buildingspeccode_s" /></th>
                    <!-- 成型作业ID -->
                    <th data-options="field:'buildingtaskid_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.buildingtaskid_s" /></th>
                    <!-- 成型生产时间 -->
                    <th data-options="field:'buildingtime_t',editor:{type:'textbox'}"><spring:message code="maintypelog.column.buildingtime_t" /></th>
                    <!-- 成型机台 -->
                    <th data-options="field:'buildinmachinecode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.buildinmachinecode_s" /></th>
                    <!-- 物流装笼笼号 -->
                    <th data-options="field:'cagenumber_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.cagenumber_s" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changed_by_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                                       <!-- 外胎延时硫化标记，1为延时硫化，其余为空 -->
                    <th data-options="field:'curingtimedelay_s',formatter:curingtimeFormatter,editor:{type:'textbox'}"><spring:message code="maintypelog.column.curingtimedelay_s" /></th>
                    <!-- 硫化员工号 -->
                    <th data-options="field:'curinguserid_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.curinguserid_s" /></th>
                    <!-- 疑问胎标记：1标记 -->
                    <th data-options="field:'doubtflag_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.doubtflag_s" /></th>
                    <!-- 动平衡检查次数 -->
                    <th data-options="field:'dynamicbalancecount_i',editor:{type:'textbox'}"><spring:message code="maintypelog.column.dynamicbalancecount_i" /></th>
                    <!-- 动平衡质量等级 -->
                    <th data-options="field:'dynamicbalancegradecode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.dynamicbalancegradecode_s" /></th>
                    <!-- 动平衡配方号 -->
                    <th data-options="field:'dynamicbalanceindex_i',editor:{type:'textbox'}"><spring:message code="maintypelog.column.dynamicbalanceindex_i" /></th>
                    <!-- 动平衡机条码 -->
                    <th data-options="field:'dynamicbalancembarcode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.dynamicbalancembarcode_s" /></th>
                    <!-- 动平衡病象编号：D_BS_Reas.REAS_CODE -->
                    <th data-options="field:'dynamicbalancereascode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.dynamicbalancereascode_s" /></th>
                    <!-- 动平衡质检员工号 -->
                    <th data-options="field:'dynamicbalanceuserid_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.dynamicbalanceuserid_s" /></th>
                    <!-- 质量等级编码 -->
                    <th data-options="field:'gradecode_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="maintypelog.column.gradecode_s" /></th>
                    <!-- 轮胎毛重量 -->
                    <th data-options="field:'grossweight_i',editor:{type:'textbox'}"><spring:message code="maintypelog.column.grossweight_i" /></th>
                    <!-- 割毛次数 -->
                    <th data-options="field:'hairscount_i',editor:{type:'textbox'}"><spring:message code="maintypelog.column.hairscount_i" /></th>
                    <!-- 割毛质量等级 -->
                    <th data-options="field:'hairsgradecode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.hairsgradecode_s" /></th>
                    <!-- 割毛操作时间 -->
                    <th data-options="field:'hairspasstime_t',editor:{type:'textbox'}"><spring:message code="maintypelog.column.hairspasstime_t" /></th>
                    <!-- 物流推送-推送次数 -->
                    <th data-options="field:'handcount_i',editor:{type:'textbox'}"><spring:message code="maintypelog.column.handcount_i" /></th>
                    <!-- 物流推送-推送标记：0-未推送，1-已推送 -->
                    <th data-options="field:'handflag_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.handflag_s" /></th>
                    <!-- 镂空条码 -->
                    <th data-options="field:'hollowedbarcode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.hollowedbarcode_s" /></th>
                     <!-- 跟踪胎标识：1跟踪 -->
                    <th data-options="field:'integratedcode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.integratedcode_s" /></th>
                    <!-- 是否复检：0未复检、1已复检过 -->
                    <th data-options="field:'isrck_s',formatter:isrckFormatter,editor:{type:'textbox'}"><spring:message code="maintypelog.column.isrck_s" /></th>
                    <!-- 当前工序 -->
                    <th data-options="field:'proess_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="maintypelog.column.proess_s" /></th>
                    <!-- 病象编号：D_BS_Reas.REAS_CODE -->
                    <th data-options="field:'reascode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.reascode_s" /></th>
                    <!-- 记录标志，A可用，D删除 -->
                    <th data-options="field:'record_flag_s',formatter:recordflagFormatter,editor:{type:'textbox'}"><spring:message code="maintypelog.column.record_flag_s" /></th>
                    <!-- 物流推送-错误消息（处理成功是返回空） -->
                    <th data-options="field:'returnmsg_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.returnmsg_s" /></th>
                    <!-- 物流推送-返回处理结果状态(S:处理成功，E:处理失败，U:处理异常) -->
                    <th data-options="field:'returnstatus_s',formatter:returnstatusFormatter,editor:{type:'textbox'}"><spring:message code="maintypelog.column.returnstatus_s" /></th>
                    <!-- 销售方式：0-内销、1-外销 -->
                    <th data-options="field:'saletype_s',formatter:saletypeFormatter,editor:{type:'textbox'}"><spring:message code="maintypelog.column.saletype_s" /></th>
                    <!-- 轮胎状态编码：0-待检、1-合格、2-不合格 -->
                    <th data-options="field:'statecode_s',formatter:statecodeFormatter,editor:{type:'textbox'}"><spring:message code="maintypelog.column.statecode_s" /></th>
                    <!-- 工厂（1全钢2半钢） -->
                    <th data-options="field:'s_factory_s',formatter:factoryFormatter,editor:{type:'textbox'}"><spring:message code="maintypelog.column.s_factory_s" /></th>
                    <!-- 机构编号：招远8000；德州8002柳州8003泰国8004 -->
                    <th data-options="field:'agenc_no_s',formatter:agencFormatter,editor:{type:'textbox'}"><spring:message code="maintypelog.column.agenc_no_s" /></th>
                    <!-- 归档标记 -->
                    <th data-options="field:'arch_flag_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.arch_flag_s" /></th>
                    <!-- 预入库胎抽检扫描时间 -->
                    <th data-options="field:'tackchecktime_t',editor:{type:'textbox'}"><spring:message code="maintypelog.column.tackchecktime_t" /></th>
                    <!-- 预入库胎抽检扫描人ID -->
                    <th data-options="field:'tackcheckuserid_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.tackcheckuserid_s" /></th>
                    <!-- 总返修次数 -->
                    <th data-options="field:'totalreworknum_i',editor:{type:'textbox'}"><spring:message code="maintypelog.column.totalreworknum_i" /></th>
                    <!-- 均匀度检查次数 -->
                    <th data-options="field:'uniformitycount_i',editor:{type:'textbox'}"><spring:message code="maintypelog.column.uniformitycount_i" /></th>
                    <!-- 均匀度质量等级 -->
                    <th data-options="field:'uniformitygradecode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.uniformitygradecode_s" /></th>
                    <!-- 均匀度配方号 -->
                    <th data-options="field:'uniformityindex_i',editor:{type:'textbox'}"><spring:message code="maintypelog.column.uniformityindex_i" /></th>
                    <!-- 均匀度设备条码 -->
                    <th data-options="field:'uniformitymbarcode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.uniformitymbarcode_s" /></th>
                    <!-- 均匀度通过时间 -->
                    <th data-options="field:'uniformitypasstime_t',editor:{type:'textbox'}"><spring:message code="maintypelog.column.uniformitypasstime_t" /></th>
                    <!-- 均匀度病象编号：D_BS_Reas.REAS_CODE -->
                    <th data-options="field:'uniformityreascode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.uniformityreascode_s" /></th>
                    <!-- 均匀度质检员工号 -->
                    <th data-options="field:'uniformityuserid_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.uniformityuserid_s" /></th>
                    <!-- 外胎检查次数 -->
                    <th data-options="field:'visualcount_i',editor:{type:'textbox'}"><spring:message code="maintypelog.column.visualcount_i" /></th>
                    <!-- 外胎重检一次操作时间 -->
                    <th data-options="field:'visuald1_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.visuald1_s" /></th>
                    <!-- 外胎重检二次操作时间 -->
                    <th data-options="field:'visuald3_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.visuald3_s" /></th>
                    <!-- 外胎质量等级 -->
                    <th data-options="field:'visualgradecode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.visualgradecode_s" /></th>
                    <!-- 外胎重检一次检测工位 -->
                    <th data-options="field:'visualmbarcode1_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.visualmbarcode1_s" /></th>
                    <!-- 外胎重检一次检测工位 -->
                    <th data-options="field:'visualmbarcode2_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.visualmbarcode2_s" /></th>
                    <!-- 外胎重检一次次扫描人ID -->
                    <th data-options="field:'visualuserid1_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.visualuserid1_s" /></th>
                    <!-- 外胎重检二次扫描人ID -->
                    <th data-options="field:'visualuserid2_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.visualuserid2_s" /></th>
                    <!-- 年周号 -->
                    <th data-options="field:'weeklynumber_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.weeklynumber_s" /></th>
                    <!-- X光检查次数 -->
                    <th data-options="field:'xlightcount_i',editor:{type:'textbox'}"><spring:message code="maintypelog.column.xlightcount_i" /></th>
                    <!-- X光质量等级 -->
                    <th data-options="field:'xlightgradecode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.xlightgradecode_s" /></th>
                    <!-- X光配方号 -->
                    <th data-options="field:'xlightindex_i',editor:{type:'textbox'}"><spring:message code="maintypelog.column.xlightindex_i" /></th>
                    <!-- X光机条码 -->
                    <th data-options="field:'xlightmbarcode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.xlightmbarcode_s" /></th>
                    <!-- X光病象编号：D_BS_Reas.REAS_CODE -->
                    <th data-options="field:'xlightreascode_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.xlightreascode_s" /></th>
                    <!-- X光质检员工号 -->
                    <th data-options="field:'xlightuserid_s',editor:{type:'textbox'}"><spring:message code="maintypelog.column.xlightuserid_s" /></th>
                </tr>
            </thead>
        </table>
    </div>
    </div>
   
     
</div>
<jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="MainTypeLog_search_form" />
		<jsp:param name="datagridId" value="maintypelog_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.finalcheck.excel.MainTypeLogExportHandler" />
		<jsp:param name="serviceName" value="MainTypeLogServiceImpl" />
</jsp:include>
</body>
</html>
