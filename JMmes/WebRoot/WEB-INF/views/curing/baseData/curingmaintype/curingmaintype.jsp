<!-- 

    作者      :李迺锟
    时间      :2019-08-07 08:15:27 
    页面名称:硫化与成型轮胎主表
    文件关联:
        CuringMainType.java
        CuringMainTypeController.java
        CuringMainTypeServiceImpl.java
        CuringMainTypeServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="curingmaintype.js.jsp"%>
<script type="text/javascript" src="dict/253,252.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="CuringMainType_dg_toolbar">
            <form id="CuringMainType_search_form" class="form" >
               	<!-- 物料编码 -->
                <spring:message code="curingmaintype.column.materialcode_s" />:
                <input name="filter[materialcode_s]" id="materialcode_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 轮胎条码 -->
                <spring:message code="curingmaintype.column.tyrebarcode_s" />:
                <input name="filter[tyrebarcode_s]" id="tyrebarcode_s" type="text" class="easyui-textbox" style="width:160px" data-options="label:''" >
                
                 <!-- 总质量等级 -->
                <spring:message code="curingmaintype.column.quality_grade_s" />:
                <input name="filter[quality_grade_s]" id="quality_grade_s" type="text" class="easyui-combotree" style="width:160px" data-options="
                  labelWidth:'auto',
				  panelWidth:'200',
				  required:false,
				  url:'dict/code/253',
				  method:'get',
				  label:''" >
                <!-- 当前工序质量等级 -->
                <spring:message code="curingmaintype.column.atpresentgradecode_s" />:
                <input name="filter[atpresentgradecode_s]" id="atpresentgradecode_s" type="text" class="easyui-combotree" data-options="
                  labelWidth:'auto',
				  panelWidth:'200',
				  required:false,
				  url:'dict/code/253',
				  method:'get',
				  label:''" >
                <br>
                <!-- 当前工序 -->
                <spring:message code="curingmaintype.column.proess_s" />:
                <input name="filter[proess_s]" id="proess_s" type="text" class="easyui-combotree" data-options="
                  labelWidth:'auto',
				  panelWidth:'200',
				  required:false,
				  url:'dict/code/252',
				  method:'get',
				  label:''" >
                
                <!-- 操作时间 -->
						<spring:message code="maintyre.column.jianchatime" />:
						<input name="filter[begin_created_time]" editable="true" id="begin_created_time"
							type="text" class="easyui-datetimebox" style="width:160px"
							data-options="label:''">
						&emsp;&emsp;到&emsp;&emsp; <input name="filter[end_created_time]" editable="true" id="end_created_time"
							class="easyui-datetimebox" style="width:160px">
                <!-- 机台 -->
               	<spring:message code="curingmaintype.column.machinecode_s" />:
                <input name="filter[machinecode_s]" id="machinecode_s" type="text" class="easyui-textbox" data-options="label:''" >
                &emsp;
                &emsp;<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <%-- <auth:button code="XXX"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-add'" onclick="export()"><spring:message code="button.export" /></a></auth:button> --%>
        </div>
        <table id="curingmaintype_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#CuringMainType_dg_toolbar',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                   <!-- 机台 -->
                    <th data-options="field:'machinecode_s',width:80,editor:{type:'textbox'}"><spring:message code="curingmaintype.column.machinecode_s" /></th>
                    <!-- 月计划 -->
                    <th data-options="field:'monthlyplan_s',editor:{type:'textbox'}"><spring:message code="curingmaintype.column.monthlyplan_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'materialcode_s',width:80,editor:{type:'textbox'}"><spring:message code="curingmaintype.column.materialcode_s" /></th>
                    <!-- 轮胎条码 -->
                    <th data-options="field:'tyrebarcode_s',width:80,editor:{type:'textbox'}"><spring:message code="curingmaintype.column.tyrebarcode_s" /></th>
                    <!-- 当前工序 -->
                    <th data-options="field:'proess_s',formatter:codeFormatter,width:80,editor:{type:'combotree',options:{
                    			method:'get',
                                url:'dict/code/252',
                                panelWidth:'300',
                    			required:true,
                    			disabled:true
                    			}}"><spring:message code="curingmaintype.column.proess_s" /></th>
                    <!-- 总质量等级 -->
                    <th data-options="field:'quality_grade_s',formatter:codeFormatter,width:80,editor:{type:'combotree',options:{
                    			method:'get',
                                url:'dict/code/253',
                                panelWidth:'300',
                    			required:true,
                    			disabled:true
                    			}}"><spring:message code="curingmaintype.column.quality_grade_s" /></th>
                    <!-- 当前工序质量等级 -->
                    <th data-options="field:'atpresentgradecode_s',formatter:codeFormatter,width:100,editor:{type:'combotree',options:{
                    			method:'get',
                                url:'dict/code/253',
                                panelWidth:'300',
                    			required:true,
                    			disabled:true
                    			}}"><spring:message code="curingmaintype.column.atpresentgradecode_s" /></th>

                    <th data-options="field:'storagelevel_s',formatter:codeFormatter,width:100,editor:{type:'combotree',options:{
                    			method:'get',
                                url:'dict/code/253',
                                panelWidth:'300',
                    			required:true,
                    			disabled:true
                    			}}"><spring:message code="curingmaintype.column.storagelevel_s" /></th>

                    <!-- 外胎延时硫化标记， 1为延时硫化，其余为空 -->
                    <th data-options="field:'curingtimedelay_s',formatter:codeFormatter,formatter:curingtotaltime_s,width:105,editor:{type:'combotree',options:{
                    			method:'get',
                                url:'dict/code/253',
                                panelWidth:'300',
                    			required:true,
                    			disabled:true
                    			}}"><spring:message code="curingmaintype.column.curingtimedelay_s" /></th>
                   		<!-- 备用字段2 -->
                    <th data-options="field:'reservedate2_s',formatter:curingtotaltime_s,width:80,editor:{type:'textbox'}"><spring:message code="curingmaintype.column.reservedate2_s" /></th>
                    
                   	<!-- 硫化总时间 -->
                   	<th data-options="field:'curingtotaltime_s',formatter:curingtotaltime_s,width:80,editor:{type:'textbox'}"><spring:message code="curingmaintype.column.curingtotaltime_s" /></th>
                   	<th data-options="field:'starttime_t',editor:{type:'textbox'}"><spring:message code="curingmaintype.column.starttime_t" /></th>
                    <!-- 结束时间 -->
                    <th data-options="field:'overtime_t',editor:{type:'textbox'}"><spring:message code="curingmaintype.column.overtime_t" /></th>
                   	<!-- 年周号 -->
                    <th data-options="field:'weeklynumber_s',formatter:curingtotaltime_s,width:80,editor:{type:'textbox'}"><spring:message code="curingmaintype.column.weeklynumber_s" /></th>
                    <!-- 配方号 -->
                    <th data-options="field:'formulanumber_s',formatter:curingtotaltime_s,width:80,editor:{type:'textbox'}"><spring:message code="curingmaintype.column.formulanumber_s" /></th>
                   	<!-- 病象编号 -->
                    <th data-options="field:'conumber',width:80,formatter:curingtotaltime_s,editor:{type:'textbox'}"><spring:message code="curingmaintype.column.reascode_s" /></th>
                   	<!-- 报警标记 -->
                    <th data-options="field:'alarm_flag_s',width:80,formatter:curingtotaltime_s,editor:{type:'textbox'}"><spring:message code="curingmaintype.column.alarm_flag_s" /></th>
                   <!-- 检测次数 -->
                    <th data-options="field:'checknumber_i',formatter:curingtimeschange,editor:{type:'textbox'}"><spring:message code="mddd.column.checknumber_i" /></th>
                   	<!-- 首条确认 -->
                    <th data-options="field:'firstflag_s',formatter:curingtotaltime_s,width:80,editor:{type:'textbox'}"><spring:message code="curingmaintype.column.firstflag_s" /></th>
                    <!-- 轮胎毛重量 -->
                    <th data-options="field:'gross_weight_s',formatter:curingtimeschange,width:80,editor:{type:'textbox'}"><spring:message code="curingmaintype.column.gross_weight_s" /></th>
                    <%--  <!-- 备用字段10 -->
                    <th data-options="field:'reservedate10_s',width:80,editor:{type:'textbox'}"><spring:message code="curingmaintype.column.reservedate10_s" /></th>
                    <!-- 备用字段1 -->
                    <th data-options="field:'reservedate1_s',width:80,editor:{type:'textbox'}"><spring:message code="curingmaintype.column.reservedate1_s" /></th>
                    <!-- 备用字段2 -->
                    <th data-options="field:'reservedate2_s',width:80,editor:{type:'textbox'}"><spring:message code="curingmaintype.column.reservedate2_s" /></th>
                    <!-- 备用字段3 -->
                    <th data-options="field:'reservedate3_s',width:80,editor:{type:'textbox'}"><spring:message code="curingmaintype.column.reservedate3_s" /></th>
                    <!-- 备用字段4 -->
                    <th data-options="field:'reservedate4_s',width:80,editor:{type:'textbox'}"><spring:message code="curingmaintype.column.reservedate4_s" /></th>
                    <!-- 备用字段5 -->
                    <th data-options="field:'reservedate5_s',width:80,editor:{type:'textbox'}"><spring:message code="curingmaintype.column.reservedate5_s" /></th>
                    <!-- 备用字段6 -->
                    <th data-options="field:'reservedate6_s',width:80,editor:{type:'textbox'}"><spring:message code="curingmaintype.column.reservedate6_s" /></th>
                    <!-- 备用字段7 -->
                    <th data-options="field:'reservedate7_s',width:80,editor:{type:'textbox'}"><spring:message code="curingmaintype.column.reservedate7_s" /></th>
                    <!-- 备用字段8 -->
                    <th data-options="field:'reservedate8_s',width:80,editor:{type:'textbox'}"><spring:message code="curingmaintype.column.reservedate8_s" /></th>
                    <!-- 备用字段9 -->
                    <th data-options="field:'reservedate9_s',width:80,editor:{type:'textbox'}"><spring:message code="curingmaintype.column.reservedate9_s" /></th>
                   	 --%><!-- 开始时间 -->
                    <!-- 操作工ID -->
                    <th data-options="field:'callnames',width:80,editor:{type:'textbox'}"><spring:message code="curingmaintype.column.userid_s" /></th>
                    </tr>
            </thead>
        </table>
    </div>
</body>
</html>
