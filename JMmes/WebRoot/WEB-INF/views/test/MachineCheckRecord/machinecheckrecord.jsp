<!-- 

    作者      :周清玉
    时间      :2019-08-09 08:42:13 
    页面名称:开班检查表
    文件关联:
        MachineCheckRecord.java
        MachineCheckRecordController.java
        MachineCheckRecordServiceImpl.java
        MachineCheckRecordServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/meta.jsp"%>
<%@ include file="machinecheckrecord.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="MachineCheckRecord_dg_toolbar">
            <form id="MachineCheckRecord_search_form" class="form" >
                <!-- 点检人工号  -->
                <input name="filter[user_id_s]" id="user_id_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="machinecheckrecord.column.user_id_s" />'" >
                <!-- 点检人名称  -->
                <input name="filter[user_name_s]" id="user_name_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="machinecheckrecord.column.user_name_s" />'" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="XXX"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            　
            <auth:button code="XXX"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            　
            <auth:button code="XXX"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-add'" onclick="export()"><spring:message code="button.export" /></a></auth:button>
        </div>
        <table id="machinecheckrecord_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#MachineCheckRecord_dg_toolbar',
                url: 'test/MachineCheckRecord/datagridUDA',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004  -->
                    <th data-options="field:'agenc_no_s',editor:{type:'textbox'}"><spring:message code="machinecheckrecord.column.agenc_no_s" /></th>
                    <!-- 开班作业编码  -->
                    <th data-options="field:'beginwork_code_s',editor:{type:'textbox'}"><spring:message code="machinecheckrecord.column.beginwork_code_s" /></th>
                     <!-- 创建人 -->
                    <th data-options="field:'created_by_s',editor:{type:'textbox'}"><spring:message code="machinecheckrecord.column.created_by_s" /></th>
                    <!-- 机台条码  -->
                    <th data-options="field:'equip_code_s',editor:{type:'textbox'}"><spring:message code="machinecheckrecord.column.equip_code_s" /></th>
                     <!-- 记录标志，A可用，D删除 -->
                    <th data-options="field:'record_flag_s',editor:{type:'textbox'}"><spring:message code="machinecheckrecord.column.record_flag_s" /></th>
                     <!-- 点检状态 1：点检中，0：点检结束  -->
                    <th data-options="field:'status_s',editor:{type:'textbox'}"><spring:message code="machinecheckrecord.column.status_s" /></th>
                    <!-- 工厂（1全钢 2半钢）  -->
                    <th data-options="field:'s_factory_s',editor:{type:'textbox'}"><spring:message code="machinecheckrecord.column.s_factory_s" /></th>
                </tr>
            </thead>
        </table>
    </div>
</body>
</html>
