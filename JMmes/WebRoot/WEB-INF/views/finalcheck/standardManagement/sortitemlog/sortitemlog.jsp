<!-- 

    作者      :司乔靖
    时间      :2018-11-28 14:52:17 
    页面名称:质检分拣物料规则表(终检蓝英接口同步履历)
    文件关联:
        SortItemLog.java
        SortItemLogController.java
        SortItemLogServiceImpl.java
        SortItemLogServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="sortitemlog.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="SortItemLog_dg_toolbar">
            <form id="SortItemLog_search_form" class="form" >
            <spring:message code="sortitemlog.column.sync_create_time_t" />:
              <input name="filter[begin_created_time]" editable="true" id="begin_created_time"
							type="text" class="easyui-datetimebox" style="width:170px"
							data-options="label:''">
						到 <input name="filter[end_created_time]" editable="true" id="end_created_time"
							class="easyui-datetimebox" style="width:170px">
                <!-- 数据同步处理标记：0-未处理、1-已处理 -->
               <spring:message code="sortitemlog.column.sync_hand_flag_s" />:
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
            </form> 
          <%--   <auth:button code="XXX"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            　
            <auth:button code="XXX"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            　
            <auth:button code="XXX"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-add'" onclick="export()"><spring:message code="button.export" /></a></auth:button>
 --%>        </div>
        <table id="sortitemlog_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#SortItemLog_dg_toolbar',
                url: '',
                striped:true,
                emptyMsg:'<span><spring:message code='tip.noData'/></span>',
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 数据同步创建时间 -->
                    <th data-options="field:'sync_create_time_t',editor:{type:'textbox'}"><spring:message code="sortitemlog.column.sync_create_time_t" /></th>
                    <!-- 数据同步处理：A-新增、U-修改、D-删除 -->
                    <th data-options="field:'sync_flag_s',formatter:syncflagFormatter,editor:{type:'textbox'}"><spring:message code="sortitemlog.column.sync_flag_s" /></th>
                    <!-- 数据同步处理标记：0-未处理、1-已处理 -->
                    <th data-options="field:'sync_hand_flag_s',formatter:handflagFormatter,editor:{type:'textbox'}"><spring:message code="sortitemlog.column.sync_hand_flag_s" /></th>
                    <!-- 数据同步处理反馈 -->
                    <th data-options="field:'sync_hand_msg_s',editor:{type:'textbox'}"><spring:message code="sortitemlog.column.sync_hand_msg_s" /></th>
                    <!-- 数据同步处理时间 -->
                    <th data-options="field:'sync_hand_time_t',editor:{type:'textbox'}"><spring:message code="sortitemlog.column.sync_hand_time_t" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_s',editor:{type:'textbox'}"><spring:message code="sortitemlog.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',editor:{type:'textbox'}"><spring:message code="sortitemlog.column.created_time_t" /></th>
                    <!-- D_ZJ_Ent 表 ID -->
                    <th data-options="field:'entbarcode_s',editor:{type:'textbox'}"><spring:message code="sortitemlog.column.entbarcode_s" /></th>
                    <!-- 品号 -->
                    <th data-options="field:'itemid_s',editor:{type:'textbox'}"><spring:message code="sortitemlog.column.itemid_s" /></th>
                    <%--  <!-- 归档标记 -->
                    <th data-options="field:'arch_flag_s',editor:{type:'textbox'}"><spring:message code="sortitemlog.column.arch_flag_s" /></th>
                     --%><!-- 修改人 -->
                    <th data-options="field:'changed_by_s',editor:{type:'textbox'}"><spring:message code="sortitemlog.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',editor:{type:'textbox'}"><spring:message code="sortitemlog.column.changed_time_t" /></th>
                    <!-- 抽检比例：0-免检，1-全检 -->
                    <th data-options="field:'num_i',formatter:numFormatter,editor:{type:'textbox'}"><spring:message code="sortitemlog.column.num_i" /></th>
                    <!-- 记录标志，A当前可检，D历史可检 -->
                    <th data-options="field:'record_flag_s',formatter:recordflagFormatter,editor:{type:'textbox'}"><spring:message code="sortitemlog.column.record_flag_s" /></th>
                    <!-- 分拣点：0-割毛，1-外观，2-X光机、3-动平衡、4-均匀性、5-动均一体 -->
                    <th data-options="field:'station_i',formatter:stationFormatter,editor:{type:'textbox'}"><spring:message code="sortitemlog.column.station_i" /></th>
                                    </tr>
            </thead>
        </table>
    </div>
</body>
</html>
