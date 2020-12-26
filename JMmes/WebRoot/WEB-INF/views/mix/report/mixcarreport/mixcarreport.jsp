<!-- 

    作者      :边朝会
    时间      :2020-08-13 16:06:19 
    页面名称:密炼胶料产出车次实绩表
    文件关联:
        MixCarReport.java
        MixCarReportController.java
        MixCarReportServiceImpl.java
        MixCarReportServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="mixcarreport.js.jsp"%>
<script type="text/javascript"
        src="dict/-324,-325.js"></script>
<script type="text/javascript" src="resources/libs/ichart.1.1.min.js"></script>
<script  type="text/javascript" src="resources/libs/html2canvas.js"></script>
<script  type="text/javascript" src="resources/libs/jspdf.debug.js"></script>
<script  type="text/javascript" src="resources/libs/canvas2image.js"></script>
<style type="text/css">
    table { border-color:gainsboro; border-style:dotted; border-width:0px; border-right-width:1px; border-bottom-width:1px; margin:0; padding:0; border-spacing:0; }
    td { border-color:gainsboro; border-style:dotted; border-width:0px; border-top-width:1px; border-left-width:1px; padding:0; }
</style>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'north',split:true,border:false" style="height: 12%">
        <div>
            <form id="MixCarReport_search_form" class="form" >
                <!-- 生产日期 -->
                生产日期:
                <%--<input name="filter[prod_date_s]" id="prod_date_s" type="text" class="easyui-textbox" data-options="label:''" >--%>
                <input name="filter[start_time]" id="start_time" type="text" class="easyui-datebox" data-options="label:''" style="width: 100px">
                <spring:message code="tip.to" /><input name="filter[end_time]" id="end_time" type="text" class="easyui-datebox" data-options="label:''" style="width: 100px">
                <!-- 机台编码 -->
              <%--  <spring:message code="mixcarreport.column.equip_code_s" />
                <input name="filter[equip_code_s]" id="equip_code_s" type="text" class="easyui-textbox" data-options="label:''" >--%>
                <spring:message code="drprodimplement.column.equip_code_s" />
                &nbsp; <input name="filter[equip_code_s]" id="equip_code_s"
                              style="width: 110px" type="text" class="easyui-combobox"
                              data-options="label:'',
	          		   data:equiplist,
	         		   panelHeight:150,
	         		   editable:true,
	           		   valueField:'p_line_name',
	          		   textField:'description',
	                   selectOnNavigation:false,
	           		   limitToList:true,
	          		   filter:searchProductionLine,
	          		   onChange:getrecipecodebycode
	           		   <%--onChange:filter--%>">

                <!-- 班次 -->
                班次:
                <%--<input name="filter[shift_code_s]" id="shift_code_s" type="text" class="easyui-textbox" data-options="label:''" >--%>
                <input name="filter[shift_code_s]" id="shift_code_s" type="text"
                       style="width: 90px" class="easyui-combotree"
                       data-options="label:'',
				              			 required:false,
				              			 panelHeight:200,
				              			 url:'dict/code/302',
				              			 method:'get',
				              			 onChange:shiftFilter
				              			">

                <%--spare8_s--%>
                配方名称<%--<input name="filter[spare8_s]" id="spare8_s" type="text" class="easyui-textbox" data-options="label:''" >--%>
                <input name="filter[recipe_code_s]" id="recipe_code_s" type="text"
                        class="easyui-combobox"
                        data-options="label:'',
                              data:recipecodelist,
	         		          panelHeight:150,
	         		          editable:true,
	           		          valueField:'RECIPE_CODE_S',
	          		           textField:'SPARE8_S',
	                          selectOnNavigation:false,
	           		          limitToList:true,
	           		          onChange:recipeFilter">
                <input name="filter[page]" id="pageInput" type="text" class="easyui-textbox" data-options="label:''" >
                <br>
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'pagination-first'" onclick="zero()" id="firstCar">首车[<span id="firstNum"></span>]</a>
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'pagination-prev'" onclick="retreat()" id="retreatCar">上一车[<span id="retreatNum"></span>]</a>
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'pagination-next'" onclick="forward()" id="forwardCar">下一车[<span id="forwardNum"></span>]</a>
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'pagination-last'" onclick="skipLast()" id="lastCar">最后一车 <span id="lastNum"></span></a>
               <a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="exportReportTemplet()"><spring:message code="button.export" /></a>
                <a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="CurrentCarDetail()">当前车详细信息</a>
            </form>
        </div>
    </div>
    <div data-options="region:'west',split:true"
         style="width:247px;height: 100%"
         title="密炼基本信息<span id='test'></span>">
        <table border="3px" cellspacing="0" id="baselist_dg" width="100%"  bordercolor="white" >
            <tr>
                <td align="right">
                    <span style="font-family: 黑体;font-weight: bolder;font-size: medium">条码号:</span>
                </td>
                <td bgcolor="#D1E9E9" width="55%">
                    <span id="lot_no" style="width:auto"></span>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <span style="font-family: 黑体;font-weight: bolder;font-size: medium">工单:</span>
                </td>
                <td bgcolor="#D1E9E9" width="55%">
                    <span id="wo_no"></span>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <span style="font-family: 黑体;font-weight: bolder;font-size: medium">机台名称:</span>
                </td>
                <td bgcolor="#D1E9E9" width="55%">
                    <span id="equip_name_s"></span>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <span style="font-family: 黑体;font-weight: bolder;font-size: medium">班次:</span>
                </td>
                <td bgcolor="#D1E9E9" width="55%">
                    <span id="shift_code"></span>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <span style="font-family: 黑体;font-weight: bolder;font-size: medium">班组:</span>
                </td>
                <td bgcolor="#D1E9E9" width="55%">
                    <span id="group_code"></span>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <span style="font-family: 黑体;font-weight: bolder;font-size: medium">配方:</span>
                </td>
                <td bgcolor="#D1E9E9" width="55%">
                    <span id="recipe_name"></span>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <span style="font-family: 黑体;font-weight: bolder;font-size: medium">配方状态:</span>
                </td>
                <td bgcolor="#D1E9E9" width="55%">
                    <span id="state_code"></span>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <span style="font-family: 黑体;font-weight: bolder;font-size: medium">开始时间:</span>
                </td>
                <td bgcolor="#D1E9E9" width="55%">
                    <span id="start_datetime"></span>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <span style="font-family: 黑体;font-weight: bolder;font-size: medium">产出时间:</span>
                </td>
                <td bgcolor="#D1E9E9" width="55%">
                    <span id="product_time"></span>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <span style="font-family: 黑体;font-weight: bolder;font-size: medium">配方时间:</span>
                </td>
                <td bgcolor="#D1E9E9" width="55%">
                    <span id="recipetime_i"></span>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <span style="font-family: 黑体;font-weight: bolder;font-size: medium">排胶能量:</span>
                </td>
                <td bgcolor="#D1E9E9" width="55%">
                    <span id="dischargeenergy"></span>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <span style="font-family: 黑体;font-weight: bolder;font-size: medium">排胶温度:</span>
                </td>
                <td bgcolor="#D1E9E9" width="55%">
                    <span id="dischargetemp"></span>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <span style="font-family: 黑体;font-weight: bolder;font-size: medium">设定车次:</span>
                </td>
                <td bgcolor="#D1E9E9" width="55%">
                    <span id="allche"></span>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <span style="font-family: 黑体;font-weight: bolder;font-size: medium">车次:</span>
                </td>
                <td bgcolor="#D1E9E9" width="55%">
                    <span id="serial_id"></span>
                </td>
            </tr>

            <tr>
                <td align="right">
                    <span style="font-family: 黑体;font-weight: bolder;font-size: medium">炼胶时间:</span>
                </td>
                <td bgcolor="#D1E9E9" width="55%">
                    <span id="mixtime"></span>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <span style="font-family: 黑体;font-weight: bolder;font-size: medium">加胶时间:</span>
                </td>
                <td bgcolor="#D1E9E9" width="55%">
                    <span id="addnrtime"></span>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <span style="font-family: 黑体;font-weight: bolder;font-size: medium">加炭黑时间:</span>
                </td>
                <td bgcolor="#D1E9E9" width="55%">
                    <span id="addcbtime"></span>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <span style="font-family: 黑体;font-weight: bolder;font-size: medium">加油时间:</span>
                </td>
                <td bgcolor="#D1E9E9" width="55%">
                    <span id="addoiltime"></span>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <span style="font-family: 黑体;font-weight: bolder;font-size: medium">间隔时间:</span>
                </td>
                <td bgcolor="#D1E9E9" width="55%">
                    <span id="intervals"></span>
                </td>
            </tr>
        </table>
    </div>
    <%--<div id='canvasDiv'></div>--%>
    <div  data-options="region:'center',split:true"
         style="width:50%;height: 100%"
         title="炼胶曲线图" id="ljFrame">
    <%--    <div id="lj_qx" class="easyui-window" title="炼胶曲线图" maximized="true"
             style="width: 1200px; height: 700px" closed="true">--%>

            <div id='canvasDiv'<%--style="margin: 0cm 0cm 0cm 0cm;"--%>></div>
        </div>
    </div>
    <div data-options="region:'east',split:true"
         style="width:0%;height: 100%"
         title="">
        <table id="mixcarreport_dg" class="easyui-datagrid" style="width:100%"
               data-options="
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#MixCarReport_dg_toolbar',
                <%--url: 'mix/MixCarReport/datagrid',--%>
                striped:true,
                method: 'get',
                onLoadSuccess: onLoadSuccess
                ">
            <thead>
            <tr>
                <th data-options="field:'atr_key',checkbox:true"></th>
                <!-- 胶料车次批次号，长度19位： 母胶车次批次号：固定字符+工厂+生产日期+班次+机台+计划号+开始车次+车数 例如 MC91907011010010001 终炼胶车次批次号：固定字符+工厂+生产日期+班次+机台+计划号+开始车次+车数 例如 FC91907011010010001 -->
                <th data-options="field:'lot_no_s',width:80,editor:{type:'textbox'}"><spring:message code="mixcarreport.column.lot_no_s" /></th>
                <!-- 密炼工单跟踪表，工单号，外键，MX_PP_WO_EDIT.WO_NO -->
                <th data-options="field:'wo_no_s',width:80,editor:{type:'textbox'}"><spring:message code="mixcarreport.column.wo_no_s" /></th>
                <!-- 设定车次 -->
                <th data-options="field:'allche_s',width:80,editor:{type:'textbox'}"><spring:message code="mixcarreport.column.allche_s" /></th>
                <!-- 车次号 -->
                <th data-options="field:'serial_id_i',width:80,editor:{type:'textbox'}"><spring:message code="mixcarreport.column.serial_id_i" /></th>
                <!-- 班次 -->
                <th data-options="field:'shift_code_s',width:80,editor:{type:'textbox'}"><spring:message code="mixcarreport.column.shift_code_s" /></th>
                <!-- 班组 -->
                <th data-options="field:'group_code_s',width:80,editor:{type:'textbox'}"><spring:message code="mixcarreport.column.group_code_s" /></th>
                <!--配方名称-->
                <th data-options="field:'spare8_s',width:80,editor:{type:'textbox'}">配方名称</th>
                <!-- 开始时间 -->
                <th data-options="field:'start_datetime_s',width:80,editor:{type:'textbox'}"><spring:message code="mixcarreport.column.start_datetime_s" /></th>
                <!-- 产出时间 -->
                <th data-options="field:'product_time_t',width:80,editor:{type:'textbox'}"><spring:message code="mixcarreport.column.product_time_t" /></th>
                <!-- 配方时间 -->
                <th data-options="field:'recipetime_i',width:80,editor:{type:'textbox'}"><spring:message code="mixcarreport.column.recipetime_i" /></th>
                <!-- 炼胶时间 -->
                <th data-options="field:'mixtime_i',width:80,editor:{type:'textbox'}"><spring:message code="mixcarreport.column.mixtime_i" /></th>
                <!-- 加胶时间 -->
                <th data-options="field:'addnrtime_i',width:80,editor:{type:'textbox'}"><spring:message code="mixcarreport.column.addnrtime_i" /></th>
                <!-- 加炭黑时间 -->
                <th data-options="field:'addcbtime_i',width:80,editor:{type:'textbox'}"><spring:message code="mixcarreport.column.addcbtime_i" /></th>
                <!-- 加油时间  -->
                <th data-options="field:'addoiltime_i',width:80,editor:{type:'textbox'}"><spring:message code="mixcarreport.column.addoiltime_i" /></th>
                <!-- 间隔时间 -->
                <th data-options="field:'intervals_i',width:80,editor:{type:'textbox'}"><spring:message code="mixcarreport.column.intervals_i" /></th>
            </tr>
            </thead>
        </table>
    </div>
 <%--   <div id="lj_qx" class="easyui-window" title="查看炼胶曲线" maximized="true"
         style="width: 1200px; height: 700px" closed="true">

        <div id='canvasDiv'></div>
    </div>--%>
    <div id="carDetail_dlg" class="easyui-dialog" title="车报表详细信息"
         maximized="true" maximizable="true" minimizable="true"
         style="width: 70%;"
         data-options="resizable:true,
		    			modal:true,
		                iconCls:'icon-window',
		                closed:true,
		                ">
        <%--配方信息--%>
            <table border="1px"  cellspacing="0" cellpadding="0" id="baselist_dg" width="100%" >
                <tr>
                    <td align="left" bgcolor="#D1E9E9" style="padding-left: 5px;">
                        生产班组:
                    </td>
                    <td  width="15%">
                        <span id="group_code_s"></span>
                    </td>
                    <!--生产班次-->
                    <td align="left" bgcolor="#D1E9E9" style="padding-left: 5px;">生产班次:</td>
                    <td width="15%"><span id="shiftCode"></span></td>
                    <!--配方名称-->
                    <td align="left" bgcolor="#D1E9E9" style="padding-left: 5px;">配方名称:</td>
                    <td width="15%"><span id="recipe_code_name_s"></span></td>
                    <td align="left" bgcolor="#D1E9E9" style="padding-left: 5px;">配方代码:</td>
                    <td width="15%"><span id="recipeCode"></span></td>
                </tr>

                <tr>
                    <td align="left" bgcolor="#D1E9E9" style="padding-left: 5px;">
                        <!-- 生产机台 -->
                        生产机台:
                    </td>
                    <td>
                        <span id="equipName"></span>
                    </td>
                    <!--当前车次-->
                    <td align="left" bgcolor="#D1E9E9" style="padding-left: 5px;">
                        当前车次:
                    </td>
                    <td>
                        <span id="serialId"></span>
                    </td>

                    <td align="left" bgcolor="#D1E9E9" style="padding-left: 5px;">
                        加胶时间(s):
                    </td>
                    <td>
                        <span id="addnrtime_i"></span>
                    </td>

                    <td align="left" bgcolor="#D1E9E9" style="padding-left: 5px;">
                        排胶温度(℃):
                    </td>
                    <td>
                        <span id="dischargetemp_f"></span>
                    </td>
                </tr>

                <tr>
                    <td align="left" bgcolor="#D1E9E9" style="padding-left: 5px;">
                        炼胶时间(s):
                    </td>
                    <td>
                        <span id="mixTime_i"></span>
                    </td>

                    <td align="left" bgcolor="#D1E9E9" style="padding-left: 5px;">
                        间隔时间(s):
                    </td>
                    <td>
                        <span id="intervals_i"></span>
                    </td>

                    <td align="left" bgcolor="#D1E9E9" style="padding-left: 5px;">
                        配方时间(s):
                    </td>
                    <td>
                        <span id="recipeTime"></span>
                    </td>
                    <td align="left" bgcolor="#D1E9E9" style="padding-left: 5px;">
                        开始时间:
                    </td>
                    <td>
                        <span id="start_datetime_s"></span>
                    </td>

                </tr>

                <tr>
                    <td align="left" bgcolor="#D1E9E9" style="padding-left: 5px;">
                        <!-- 累计能量 -->
                        累积能量(KWH):
                    </td>
                    <td>
                        <span id="dischargeenergy_f"></span>
                    </td>

                    <td align="left" bgcolor="#D1E9E9" style="padding-left: 5px;">
                        <!-- 排胶功率-->
                        排胶功率(KW):
                    </td>
                    <td>
                        <span id="dischargepower_f"></span>
                    </td>

                    <td align="left" bgcolor="#D1E9E9" style="padding-left: 5px;">
                        补偿温度:
                    </td>
                    <td>
                        <span id="makeup_temp_i"></span>
                    </td>

                    <td align="left">
                    </td>
                    <td>
                    </td>
                </tr>
            </table>
        <%--称重信息--%>
            <table id="drprodimplementcl_dg" class="easyui-datagrid"
                   title="称量部分<span id='carWeight'></span>"
                   style="width: 100%;"
                   data-options="
						                <%--fit:true,--%>
						                fitColumns:false,
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
                    <!-- 称量类型（称量类型定义） -->
                    <th data-options="field:'weight_type_s',formatter:weightTypeformatter,width:80">称量类别</th>
                    <!-- 物料名称 -->
                    <th data-options="field:'material_name_s',width:180"><spring:message
                            code="drprodimplementcl.column.material_name_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',width:80"><spring:message
                            code="drprodimplementcl.column.material_code_s" /></th>
                    <!-- 设定重量 -->
                    <th data-options="field:'set_weight_s',width:80"><spring:message
                            code="drprodimplementcl.column.set_weight_s" />(kg)</th>
                    <!-- 实际重量 -->
                    <th data-options="field:'real_weight_s',width:80"><spring:message
                            code="drprodimplementcl.column.real_weight_s" />(kg)</th>
                    <!-- 允许误差 (设定误差)-->
                    <th data-options="field:'error_allow_s',width:80"><spring:message
                            code="drprodimplementcl.column.error_allow_s" />(kg)</th>
                    <%--设定检量重量(kg)--%>
                    <%--实际检量称量(kg)--%>
                    <%--设定检量误差(kg)--%>
                    <%--生产方式--%>
                    <th data-options="field:'spare1_s',width:80">生产方式</th>
                </tr>
                </thead>
            </table>
        <%--工艺信息--%>
            <table id="drprodimplementgy_dg" class="easyui-datagrid"
                   title="混炼部分/开炼部分"
                   style="width: 100%;"
                   data-options="
						                <%--fit:true,--%>
						                fitColumns:false,
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
                    <!-- 步序 -->
                    <th data-options="field:'mix_id_i',width:80"><spring:message
                            code="drprodimplementgy.column.mix_id_i" /></th>
                    <!-- 条件代码 -->
                    <th
                            data-options="field:'term_code_s',formatter:conditionformatter,width:80">条件</th>
                    <!-- 设定时间 -->
                    <%--<th data-options="field:'time_d',width:80">设定时间(s)</th>--%>
                    <!--时间(s)-->
                   <th data-options="field:'set_time_d',width:80">时间(s)</th>
                    <!-- 设定温度 -->
                    <%--<th data-options="field:'temp_d',width:80">设定温度(℃)</th>--%>
                    <!--温度-->
                   <th data-options="field:'set_temp_d',width:80">温度(℃)</th>
                    <!-- 设定功率 -->
                    <%--<th data-options="field:'power_d',width:80">设定功率(KW)</th>--%>
                    <!--功率(KW)-->
                   <th data-options="field:'set_power_d',width:80">功率(KW)</th>
                    <!-- 设定能量 -->
                    <%--<th data-options="field:'enter_d',width:80">设定能量(KWH)</th>--%>
                    <!--能量-->
                   <th data-options="field:'set_enter_d',width:80">能量(KWH)</th>
                    <!-- 动作代码 -->
                    <th data-options="field:'act_code_s',formatter:actionformatter,width:80">动作</th>
                    <!-- 压力 -->
                    <th data-options="field:'set_press_d',width:80">压力(bar)</th>
                    <!-- 转速 -->
                    <th data-options="field:'set_rota_d',width:80">转速(RPM)</th>
                    <!--开炼部分-->
                    <!--开练机台-->
                    <!--序号-->
                    <%--<th data-options="field:'mix_id_i',width:80">序号</th>--%>
                    <!--动作-->
                    <%--<th data-options="field:'act_code_s',width:80">动作</th>--%>
                    <!--时间(s)-->
                    <%--<th data-options="field:'set_time_d',width:80">时间</th>--%>
                    <!--开炼机速度-->
                    <th data-options="field:'openmixspeed_mix_d',width:80">开炼机速度</th>
                    <!--水温-->
                    <th data-options="field:'watrtemp_mix_d',width:80">水温</th>
                    <!--胶温-->
                    <th data-options="field:'rubtemp_mix_d',width:80">胶温</th>
                    <!--压力-->
                    <%--<th data-options="field:'set_press_d',width:80">压力</th>--%>
                    <!--辊距-->
                    <th data-options="field:'rollor_mix_d',width:80">辊距</th>
                </tr>
                </thead>
            </table>
    </div>

</body>

</html>
