<!-- 

    作者      :王海霖
    页面名称:动平衡扫描率
    文件关联:
        DynamicScanningRateServiceImpl.java
        DynamicScanningRateController.java
        DynamicScanningRateServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="dynamicScanningRate.js.jsp"%>
<script type="text/javascript" src="resources/libs/ichart.1.1.min.js"></script>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="dynamicscanningrate_dg_toolbar">
            <form id="dynamicscanningrate_search_form" class="form" >
             	<!-- 轮胎条码 -->
                <spring:message code="dynamicscanningrate.column.entname_s" />:
              <!--   <input name="filter[entname_s]" id="entname_s" style="width:150px;"  type="text" class="easyui-textbox" data-options="label:''" >
				 -->			<!-- 分拣去向 --> 
							<input name="filter[entname_s]"
							id="entname_s"   type="text" style="width:168px"
							class="easyui-combobox"
							data-options="label:'', required:false, 
                                    data:entCodeName,
                                    panelHeight:200,
                                     icons:[{iconCls:'icon-clear',handler:function(e){$(e.data.target).combobox('clear')}}],
									method: 'get',
									valueField:'ENTNAME_S',
									textField:'ENTNAME_S'">
                
                <spring:message code="dynamicscanningrate.column.curings_candate_t" />:
                <input name="filter[start_time]" type="text"    id="start_time" class="easyui-datetimebox"  style="width:150px;" data-options="label:''">
                <spring:message code="tip.to" />
                <input name="filter[end_time]"    id="end_time" class="easyui-datetimebox"  style="width:150px;">
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
        </div>
        <table id="dynamicscanningrate_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                singleSelect: true,
                toolbar: '#dynamicscanningrate_dg_toolbar',
                method: 'get',
                emptyMsg:'暂无数据' 
                ">
            <thead>
                <tr>
                 	<!-- 动平衡机台 -->
                    <th data-options="field:'ENTNAME_S',width:140,editor:{type:'textbox'}"><spring:message code="dynamicscanningrate.column.entname_s" /></th>
                	<!-- 时间 -->
                    <th data-options="field:'CREATED_TIME_T',width:140,editor:{type:'textbox'}"><spring:message code="dynamicscanningrate.column.created_time_t" /></th>
                	<!-- 扫描率 -->
                    <th data-options="field:'S_P',formatter:spFormatter,width:140,editor:{type:'textbox'}"><spring:message code="dynamicscanningrate.column.s_p" /></th>
                	<!-- 扫描下发成功率 -->
                    <th data-options="field:'SW_P',formatter:spFormatter,width:140,editor:{type:'textbox'}"><spring:message code="dynamicscanningrate.column.sw_p" /></th>
                 </tr>
            </thead>
        </table>
    </div>
    
    
</body>
</html>
