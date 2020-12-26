<!-- 

    作者      :徐秉正
    时间      :2020-07-03 09:31:01 
    页面名称:质检统计报表
    文件关联:
        Statistatement.java
        StatistatementController.java
        StatistatementServiceImpl.java
        StatistatementServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/meta.jsp"%>
<%@ include file="statistatement.js.jsp"%>
<script type="text/javascript" src="dict/301,253,252,302.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="EntDetial_dg_toolbar">
            <form id="Detial_search_form" class="form" >
	            <!-- 质检时间 -->
	            <spring:message code="detial.column.worktimee" />:
	            <input name="filter[start_opertime_t]" editable="true" id="start_opertime_t"  class="easyui-datetimebox" data-options="label:''" >
	            <!-- 质检时间 -->
	                             到<input name="filter[end_opertime_t]" editable="true" id="end_opertime_t"  class="easyui-datetimebox"  >
	                              <!-- 轮胎品号 -->
                <spring:message code="物料编码" />:
                <input name="filter[itemid_s]" id="itemid_s" type="text" class="easyui-textbox" data-options="label:''" >&nbsp;&nbsp;&nbsp;
	             <%-- <!-- 病象代码：QM_Reas 表 ID -->
	             <spring:message code="detial.column.reascd_s" />
                <input name="filter[reascd_s]" id="reascd_s"  type="text" class="easyui-combobox"
                 data-options="label:'',
							required:false, 
	                		url:'finalcheck/statistatement/statistatement/searchcode',
				   			method: 'get',
				   			panelHeight:200,
                            valueField:'REAS_CODE_S',
				    		textField:'REAS_CN_S'" >
				    		   <!-- 病象代码：QM_Reas 表 ID --> --%>
	             <spring:message code="病象" />
                <input name="filter[proess_s]" id="proess_s"  type="text" class="easyui-combobox"
                data-options="label:'',
							required:false, 
				   			panelHeight:200, 
				   			valueField:'value',
	                        textField:'text', 
				    		valueField:'value',
	                                textField:'text',
	                                method:'get',
	                                data: [{
											text: '外观病象',
											value: 252008
										},{
											text: 'X光病象',
											value: ''
										}]">
                  </br>                         
                 <span>选择：</span>
	           	<!--汇总-->
	          <input style="position:relative;top:2px" class="easyui-checkbox" type="checkbox" name="filter[huizong_s]" id="huizong_s" data-options="label:''"/> 
	           	<spring:message code="checkgradestorage.column.sum_s" />
	           	<!-- 详细 -->
	           	<input style="position:relative;top:2px" class="easyui-checkbox" type="checkbox" name="filter[xiangxi_s]" id="xiangxi_s" data-options="label:'',checked:true"/>
	           	<spring:message code="checkgradestorage.column.all_s" />
                
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a> 
                
                       
			<%-- <auth:button code="STATISEARCHFORM"><a id="condition_button" class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="queryBar()"><spring:message code="button.searchColumn" /></a></auth:button>   --%>
             
             	
             </form> 
             <auth:button code="STATIEXPORT"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
        </div>
         <div id="dg_toolbar" style="padding:2px">
					 </div>
        <table id="detial_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#EntDetial_dg_toolbar,#dg_toolbar',
                url: '',
                method:'get',
                pageSize:300,
 				pageList:[300,600,900] ,
		        emptyMsg:'<span><spring:message code='tip.noData'/></span>',  
		        striped:true,
                ">
          <%--   <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                	<!-- 品号 -->
                    <th data-options="field:'itemid_s',width:120"><spring:message code="detial.column.itemid_s" /></th>
                    <!-- 规格名称-->
                    <th data-options="field:'materialdesc_s'"><spring:message code="workorderresultprint.column.material_code_s" /></th>
                    <!-- 等级 -->
                    <th data-options="field:'gradecd_s',width:120,formatter:codeFormatter,editor:{type:'textbox',options:{
                   		method:'get',
	                    url:'dict/code/253',
	        			required:true
                    }}"><spring:message code="detial.column.gradecd" /></th> 
                	<!-- 病象描述 -->
                    <th data-options="field:'reascd_s',formatter:operatorFormatter,width:120,editor:{type:'textbox'}"><spring:message code="detial.column.reascd" /></th>
                	<!-- 病象类描述（外观还是x光） -->
                    <th data-options="field:'proess_s',formatter:levFormatter,width:120,editor:{type:'textbox'}"><spring:message code="reas.column.reasclass" /></th>
                     <!--数量 -->
                    <th data-options="field:'num',width:80"><spring:message code="maintyre.column.numtotal" /></th>
                </tr>

            </thead> --%>
        </table>
    </div>
    
     <!-- 	导出-->    
 <jsp:include page="../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="Detial_search_form" />
		<jsp:param name="datagridId" value="detial_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.finalcheck.excel.StatistatementExportHandler" />
		<jsp:param name="serviceName" value="StatistatementServiceImpl" />
	</jsp:include> 
</body>
</html>
