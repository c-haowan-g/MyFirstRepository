<!-- 

    作者      :刘朋
    时间      :2019-06-23
    页面名称:单元历史状态
    文件关联:
        unithistory.java
        unithistoryController.java
        unithistoryServiceImpl.java
        unithistoryServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/meta.jsp"%>
<%@ include file="unitHistory.js.jsp"%>
<script type="text/javascript" src="dict/252.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="unithistory_dg_toolbar">
            <form id="unithistory_search_form" class="form" >
                <!-- 日计划号 -->
                月计划号<input name="filter[order_number]" id="baseunit" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 订单号-->
                   工 单 号 <input name="filter[order_item]" id="brand" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 物料编码 -->
              轮胎条码<input name="filter[serial_number]" id="zwbm" type="text" class="easyui-textbox" data-options="label:''" ></br>
                 开始时间<input name="filter[start_time]" id="start_time"  editable="true" class="easyui-datetimebox" data-options="label:''" >
               结束时间<input name="filter[end_time]" id="end_time" editable="true" class="easyui-datetimebox" data-options="label:''" >
      
      <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
     <auth:button code="unithistory.export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="export()"><spring:message code="button.export" /></a></auth:button>
     </form> 

		</div>
        <table id="unithistory_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#unithistory_dg_toolbar',
                striped:true,
                method: 'get' ,
                 emptyMsg:'<span><spring:message code='tip.noData'/></span>',
                ">
            <thead>
                <tr>
                	<!--日计划号-->
                    <th data-options="field:'order_number',width:100,editor:{type:'textbox'}">月计划号</th>
					<!-- 工单号 -->
                    <th data-options="field:'order_item',width:160,editor:{type:'textbox'}">工单号</th>
                     <!-- SN -->
<!--                     <th data-options="field:'serial_number',width:80,editor:{type:'textbox'}">轮胎条码</th>
 -->                    <th data-options="field:'uda_0',width:80,editor:{type:'textbox'}">轮胎条码</th>
                     <!-- 工艺路线 -->
                    <th data-options="field:'route_name',width:100,editor:{type:'textbox'}">工艺路线</th>
                     <!-- 是否合格 -->
                    <th data-options="field:'complete_reason',width:80,editor:{type:'textbox'}">生产说明</th>
                     <!-- 开始完成状态-->
                    <th data-options="field:'start_complete_status',formatter:start_complete_status,width:80,editor:{type:'textbox'}">开始完成状态</th>
                     <!--开始说明 -->
                    <th data-options="field:'start_comment',width:80,editor:{type:'textbox'}">开始说明</th>
                     <!--开始次数 -->
                    <th data-options="field:'start_count',width:80,editor:{type:'textbox'}">开始次数</th>
                     <!--完成说明 -->
                    <th data-options="field:'complete_comment',width:80,editor:{type:'textbox'}">完成说明</th>
                     <!--完成次数 -->
                    <th data-options="field:'complete_count',width:80,editor:{type:'textbox'}">完成次数</th>
                     <!-- 当前工艺步骤-->
                    <th data-options="field:'route_step_name',width:80,editor:{type:'textbox'}">当前工艺步骤</th>
                     <!-- 工艺操作-->
                    <th data-options="field:'op_name',width:80,editor:{type:'textbox'},formatter:function(v,r,i){return dictFormat(v);}">工艺操作</th>
                     <!-- 开始用户-->
                    <th data-options="field:'start_user_name',width:120,editor:{type:'textbox'}">开始用户</th>
                     <!-- 完成用户-->
                    <th data-options="field:'complete_user_name',width:120,editor:{type:'textbox'}">完成用户</th>
                     <!-- 开始时间-->
                    <th data-options="field:'start_time',width:120,editor:{type:'textbox'}">开始时间</th>
                     <!-- 完成时间-->
                    <th data-options="field:'complete_time',width:120,editor:{type:'textbox'}">完成时间</th>
                </tr>
            </thead>
        </table>
    </div>
</body>
</html>
