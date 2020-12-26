<!-- 

    作者      :肖吉朔
    时间      :2020-09-01 14:09:12 
    页面名称:(半部件)盘库记录主表
    文件关联:
        Stockingmain.java
        StockingmainController.java
        StockingmainServiceImpl.java
        StockingmainServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/meta.jsp"%>
<%@ include file="stockingmain.js.jsp"%>
<script type="text/javascript" src="dict/133,134,308.js"></script>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="Stockingmain_dg_toolbar">
            <form id="Stockingmain_search_form" class="form" >
                <!-- 库位 -->
                <spring:message code="stockingmain.column.location_s" />
                :&emsp;<input name="filter[location_s]" like="true" id="location_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 盘库单号 -->
                 &emsp;<spring:message code="stockingmain.column.stockno_s" />
                :&emsp;<input name="filter[stockno_s]" id="stockno_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!--盘库类型 -->
                 &emsp;<spring:message code="stockingmain.column.spare1_s" />
                :&emsp;<input  name="filter[spare1_s]" id="spare1_s" type="text" class="easyui-combobox"  data-options="label:'',
                                        required:false, 
                                       	 data: [{
											text: '正式库盘库',
											value: '1'
										},{
											text: '线边库盘库',
											value: '2'
										}],
			                             method: 'get'"> 
                 <br>
                <!-- 创建时间 -->
              	 &emsp;<spring:message code="stockingmain.column.created_time_t" />
				:&emsp;<input name="filter[start_time]" type="text" id="start_time" class="easyui-datetimebox"  data-options="label:''">
				<spring:message code="tip.to" />
				<input name="filter[end_time]" id="end_time" class="easyui-datetimebox">
               
                <!-- 状态 -->
				<spring:message code="stockingmain.column.state_s" />
				:&emsp;<input name="filter[state_s]" id="state_s"  type="text" class="easyui-combotree" data-options="label:'',
						                  labelWidth:'auto',
										  panelHeight:100,
										  required:false,
										  url:'dict/code/133',
										  method:'get'">
			   <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            
        </div>
        <table id="stockingmain_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#Stockingmain_dg_toolbar',
                url: 'halfpart/stockingRecord/stockingmain/datagridUDA',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 盘库单号 -->
                    <th data-options="field:'stockno_s',editor:{type:'textbox'}"><spring:message code="stockingmain.column.stockno_s" /></th>
                    <!-- 库位 -->
                    <th data-options="field:'location_s',editor:{type:'textbox'}"><spring:message code="stockingmain.column.location_s" /></th>
                    <!-- 状态 -->
                    <th data-options="field:'state_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="stockingmain.column.state_s" /></th>
                    <!-- 盘库类型-->
                    <th data-options="field:'spare1_s',formatter:typeFormatter,editor:{type:'textbox'}"><spring:message code="stockingmain.column.spare1_s" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_s',editor:{type:'textbox'}"><spring:message code="stockingmain.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',editor:{type:'textbox'}"><spring:message code="stockingmain.column.created_time_t" /></th>
                 </tr>
            </thead>
        </table>
    </div>
</body>
</html>
