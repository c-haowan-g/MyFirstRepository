<!-- 

    作者      ：徐秉正
    页面名称:动平衡分拣扫描率
    文件关联:
        SortingRateServiceController.java
        SortingRateServiceImpl.java
        SortingRateServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="dynamicDalanceSortingScanRate.js.jsp"%>
<script type="text/javascript" src="resources/libs/ichart.1.1.min.js"></script>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="appearanceSortingScanningRate_dg_toolbar">
            <form id="appearanceSortingScanningRate_search_form" class="form" >
                <spring:message code="appearanceSortingScanningRate.column.dot" />:
                <input name="filter[entname_s]" id="entname_s"  type="text" class="easyui-combobox"
                 data-options="label:'',
							required:false, 
	                		url:'finalcheck/reportCenter/sortingrate/searchcode',
				   			method: 'get',
				   			panelHeight:200,
                            valueField:'REALMACHINEBAR_S',
				    		textField:'REALMACHINEBAR_S'" >
                
                 <spring:message code="appearanceSortingScanningRate.column.wgdot" />:
                <input name="filter[wgentname_s]" id="wgentname_s"  type="text" class="easyui-combobox"
                 data-options="label:'',
							required:false, 
	                		url:'finalcheck/reportCenter/sortingrate/searchcodewg',
				   			method: 'get',
				   			panelHeight:200,
                            valueField:'REALMACHINEBAR_S',
				    		textField:'REALMACHINEBAR_S'" >
				    		
				 <spring:message code="appearanceSortingScanningRate.column.xgdot" />:
                <input name="filter[xgentname_s]" id="xgentname_s"  type="text" class="easyui-combobox"
                 data-options="label:'',
							required:false, 
	                		url:'finalcheck/reportCenter/sortingrate/searchcodexg',
				   			method: 'get',
				   			panelHeight:200,
                            valueField:'REALMACHINEBAR_S',
				    		textField:'REALMACHINEBAR_S'" >
				    		
			 	<spring:message code="appearanceSortingScanningRate.column.gmdot" />:
                <input name="filter[gmentname_s]" id="gmentname_s"  type="text" class="easyui-combobox"
                 data-options="label:'',
							required:false, 
	                		url:'finalcheck/reportCenter/sortingrate/searchcodegm',
				   			method: 'get',
				   			panelHeight:200,
                            valueField:'REALMACHINEBAR_S',
				    		textField:'REALMACHINEBAR_S'" ><br>
				<spring:message code="appearanceSortingScanningRate.column.czdot" />:
                <input name="filter[start_time]" type="text"    id="start_time" class="easyui-datetimebox"  style="width:150px;" data-options="label:''">
                <spring:message code="tip.to" />
                <input name="filter[end_time]"    id="end_time" class="easyui-datetimebox"  style="width:150px;">
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
        </div>
        <table id="appearanceSortingScanningRate_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                singleSelect: true,
                toolbar: '#appearanceSortingScanningRate_dg_toolbar',
                method: 'get',
                emptyMsg:'暂无数据' 
                ">
            <thead>
                <tr>
                 	<!-- 动平衡机台 -->
                    <th data-options="field:'REALMACHINEBAR_S',width:140,editor:{type:'textbox'}"><spring:message code="dynamicscanningrate.column.entname_s1" /></th>
                	<!-- 时间 -->
                    <th data-options="field:'SORTTIME_T' ,width:140,editor:{type:'textbox'}"><spring:message code="dynamicscanningrate.column.created_time_t" /></th>
                	<!-- 扫描率 -->
                    <th data-options="field:'S_P',formatter:spFormatter,width:140,editor:{type:'textbox'}"><spring:message code="dynamicscanningrate.column.s_p" /></th>
                 </tr>
            </thead>
        </table>
    </div>
    
    
</body>
</html>
