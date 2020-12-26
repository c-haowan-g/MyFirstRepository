<!-- 

    作者      :lp
    时间      :2019-03-19 08:57:05 
    页面名称:硫化报警统计
    文件关联:
        CuringAlarmCount.java
        CuringAlarmCountController.java
        CuringAlarmCountServiceImpl.java
        CuringAlarmCountServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="curingalarmcount.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="CuringAlarmCount_dg_toolbar">
            <form id="CuringAlarmCount_search_form" class="form" >
               <spring:message code="dotrecord.column.created_time_t" />
               <input name="filter[begin_created_time]" editable="true" id="begin_created_time"
							type="text" class="easyui-datetimebox" style="width:170px"
							data-options="label:''">
						到 <input name="filter[end_created_time]" editable="true" id="end_created_time"
							class="easyui-datetimebox" style="width:170px">
                <!-- 机台 -->
                <spring:message code="curingalarm.curingequip_code_s" />
                <input name="filter[curingequip_code_s]" like="true" id="curingequip_code_s" type="text" class="easyui-combobox" data-options="data:jtxx,
                panelHeight:150,
                editable:true,
                valueField:'P_LINE_NAME',
                textField:'P_LINE_NAME',
                selectOnNavigation:false,
                limitToList:true" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            	<auth:button code="alarmcount.export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-add'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            </form> 
            <%-- <auth:button code="XXX"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            　
            <auth:button code="XXX"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            　
                    --%></div>
        <table id="curingalarmcount_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#CuringAlarmCount_dg_toolbar',
                emptyMsg:'<span><spring:message code='tip.noData'/></span>' ,
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <!-- <th data-options="field:'atr_key',checkbox:true"></th> -->
                    <!-- 机台 -->
                    <th data-options="field:'curingequip_code_s',editor:{type:'textbox'}"><spring:message code="curingalarm.curingequip_code_s" /></th>
                    <!-- 报警数量 -->
                    <th data-options="field:'sumcount',editor:{type:'textbox'}"><spring:message code="curingalarm.sumcount" /></th>
                    <!-- 左蒸锅内温报警-->
                    <th data-options="field:'leftneiwencall',editor:{type:'textbox'}"><spring:message code="curingalarm.leftneiwencall" /></th>
                    <!-- 右蒸锅内温报警 -->
                    <th data-options="field:'rightneiwencall',editor:{type:'textbox'}"><spring:message code="curingalarm.rightneiwencall" /></th>
                    <!-- 温模报警 -->
                    <th data-options="field:'wenmocall',editor:{type:'textbox'}"><spring:message code="curingalarm.wenmocall" /></th>
                    <!-- 焖锅报警 -->
                    <th data-options="field:'wenguocall',editor:{type:'textbox'}"><spring:message code="curingalarm.wenguocall" /></th>
                    <!-- 自动中指执行手动-->
                    <th data-options="field:'shoudongdesc',editor:{type:'textbox'}"><spring:message code="curingalarm.shoudongdesc" /></th>
                    <!-- 左热板温度报警 -->
                    <th data-options="field:'leftrebancall',editor:{type:'textbox'}"><spring:message code="curingalarm.leftrebancall" /></th>
                    <!-- 右热板温度报警 -->
                    <th data-options="field:'rightrebancall',editor:{type:'textbox'}"><spring:message code="curingalarm.rightrebancall" /></th>
                    <!-- 左右热板温差报警 -->
                    <th data-options="field:'leftrebanwenchacall',editor:{type:'textbox'}"><spring:message code="curingalarm.leftrebanwenchacall" /></th>
                    <!--左热环温度报警 -->
                    <th data-options="field:'leftrehuancall',editor:{type:'textbox'}"><spring:message code="curingalarm.leftrehuancall" /></th>
                    <!--右热环温度报警-->
                    <th data-options="field:'rightrehuancall',editor:{type:'textbox'}"><spring:message code="curingalarm.rightrehuancall" /></th>
                    <!-- 左右热环温差报警 -->
                    <th data-options="field:'leftwenchacall',editor:{type:'textbox'}"><spring:message code="curingalarm.leftwenchacall" /></th>
                     <!-- 步序1 -->
                    <th data-options="field:'buxu1',editor:{type:'textbox'}"><spring:message code="curingalarm.buxu1" /></th>
                     <!-- 步序2 -->
                    <th data-options="field:'buxu2',editor:{type:'textbox'}"><spring:message code="curingalarm.buxu2" /></th>
                     <!-- 步序3 -->
                    <th data-options="field:'buxu3',editor:{type:'textbox'}"><spring:message code="curingalarm.buxu3" /></th>
                     <!-- 步序4 -->
                    <th data-options="field:'buxu4',editor:{type:'textbox'}"><spring:message code="curingalarm.buxu4" /></th>
                     <!-- 步序5 -->
                    <th data-options="field:'buxu5',editor:{type:'textbox'}"><spring:message code="curingalarm.buxu5" /></th>
                     <!-- 步序6 -->
                    <th data-options="field:'buxu6',editor:{type:'textbox'}"><spring:message code="curingalarm.buxu6" /></th>
                     <!-- 步序7 -->
                    <th data-options="field:'buxu7',editor:{type:'textbox'}"><spring:message code="curingalarm.buxu7" /></th>
                     <!-- 步序8 -->
                    <th data-options="field:'buxu8',editor:{type:'textbox'}"><spring:message code="curingalarm.buxu8" /></th>
                    <th data-options="field:'buxu9',editor:{type:'textbox'}"><spring:message code="curingalarm.buxu9" /></th>
                    <th data-options="field:'buxu10',editor:{type:'textbox'}"><spring:message code="curingalarm.buxu10" /></th>
                    <th data-options="field:'buxu11',editor:{type:'textbox'}"><spring:message code="curingalarm.buxu11" /></th>
                    <%-- <th data-options="field:'buxu12',editor:{type:'textbox'}"><spring:message code="curingalarm.buxu12" /></th>
                    <th data-options="field:'buxu13',editor:{type:'textbox'}"><spring:message code="curingalarm.buxu13" /></th>
                    <th data-options="field:'buxu14',editor:{type:'textbox'}"><spring:message code="curingalarm.buxu14" /></th> --%>
                    <!-- 后充气报警 -->
                    <th data-options="field:'houchongqicall',editor:{type:'textbox'}"><spring:message code="curingalarm.houchongqicall" /></th>
                    <!-- 洗模报警 -->
                    <th data-options="field:'cleanmoldcall',editor:{type:'textbox'}"><spring:message code="curingalarm.cleanmoldcall" /></th>
                    <!-- 工艺参数报警 -->
                    <th data-options="field:'gongyicall',editor:{type:'textbox'}"><spring:message code="curingalarm.gongyicall" /></th>
                    <!-- 后工序报警 -->
                    <th data-options="field:'hougongxucall',editor:{type:'textbox'}"><spring:message code="curingalarm.hougongxucall" /></th>
                    <!-- 电气故障 -->
                    <th data-options="field:'dianqicall',editor:{type:'textbox'}"><spring:message code="curingalarm.dianqicall" /></th>
                    <!-- 机械故障 -->
                    <th data-options="field:'jixiecall',editor:{type:'textbox'}"><spring:message code="curingalarm.jixiecall" /></th>
                    <!-- 胶囊破裂 -->
                    <th data-options="field:'huanjiaonangcall',editor:{type:'textbox'}"><spring:message code="curingalarm.huanjiaonangcall" /></th>
                 </tr>
            </thead>
        </table>
    </div>
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="CuringAlarmCount_search_form" />
		<jsp:param name="datagridId" value="curingalarmcount_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.curing.excel.CuringAlarmCountExportHandler" />
		<jsp:param name="serviceName" value="CuringAlarmCountServiceImpl" />
	</jsp:include> 
</body>
</html>
