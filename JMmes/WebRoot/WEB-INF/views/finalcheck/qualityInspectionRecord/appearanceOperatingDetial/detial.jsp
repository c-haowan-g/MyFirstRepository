<!-- 

    作者      :wanghailin
    时间      :2018-08-07 17:18:05 
    页面名称:外观作业履历查询
    文件关联:
        Detial.java
        DetialController.java
        DetialServiceImpl.java
        DetialServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="detial.js.jsp"%>
<script type="text/javascript" src="dict/301,253,302.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="EntDetial_dg_toolbar">
            <form id="Detial_search_form" class="form" >
	            <!-- 质检时间 -->
	            <spring:message code="detial.column.opertime_t" />:
	            <input name="filter[start_opertime_t]" editable="true" id="start_opertime_t"  class="easyui-datetimebox" data-options="label:''" >
	            <!-- 质检时间 -->
	                             到<input name="filter[end_opertime_t]" editable="true" id="end_opertime_t"  class="easyui-datetimebox"  >
	            <!-- 轮胎条码，林治华  修改 -->
	            <spring:message code="detial.column.barcode_s" />:
	            <input name="filter[barcode_s]"  id="barcode_s"style="width:120px" type="text" class="easyui-textbox" data-options="label:''" >
	            
	            <!-- 品号 -->
	            <spring:message code="entdetial.column.speccode_s" />:
	            <input name="filter[itemid_s]" like="true" id="itemid_s" style="width:120px" type="text" class="easyui-textbox" data-options="label:''" >
                
                <!-- 级别 -->
	            <spring:message code="entdetial.column.gradecd_s" />:
	            <input name="filter[gradecd_s]"  id="gradecd_s" style="width:120px" type="text" class="easyui-combotree" data-options="label:'',
						                  labelWidth:'auto',
										 
										  required:false,
										  url:'dict/code/253',
										  method:'get'">
                
                <!-- 质检员 -->
	            <spring:message code="detial.column.operby_s" />:
	            <input name="filter[operby_s]" like="true" id="operby_s" style="width:100px" type="text" class="easyui-textbox" data-options="label:''" >
                <br/>
                <!-- 外观检查工位 -->
	            <spring:message code="detial.column.visualvar_s" />:
	            <input name="filter[visualvar_s]" like="true" id="visualvar_s" style="width:100px" type="text" class="easyui-textbox" data-options="label:''" >
                
                <%-- <spring:message code="detial.column.fanxiu" />:
                <input  name="filter[fanxiu]" id="fanxiu" type="text" class="easyui-combobox" style="width:155px" data-options="label:''" > --%>
                
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="doSearch()"><spring:message code="button.search" /></a>    
                <a class="easyui-linkbutton btn-purple" data-options="iconCls:'icon-search'" onclick="fanxiuSearch()"><spring:message code="detial.column.fanxiu" /></a>            
             <auth:button code="ZJ_ZJLL_WGZYLL_EXPORT"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
			<auth:button code="ZJ_ZJLL_WGZYLL_SEARCHFORM"><a id="condition_button" class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="queryBar()"><spring:message code="button.searchColumn" /></a></auth:button>  
             
             	
             </form> 
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
		        emptyMsg:'<span><spring:message code='tip.noData'/></span>',  
		        striped:true,
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 硫化机台 -->
                    <th data-options="field:'curingmachinecode_s'"><spring:message code="maintyre.column.curingmachinecode_s" /></th>
                    <!-- 硫化工人 -->
                    <th data-options="field:'username_c'"><spring:message code="硫化工人" /></th>
                    <!-- 开模时间 -->
                    <th data-options="field:'curingopenmouldtime_t'"><spring:message code="machinecontrol.column.openmold_time_t" /></th>
                    <!-- 合模时间 -->
                    <th data-options="field:'curingclosemouldtime_t'"><spring:message code="maintyre.column.curingclosemouldtime_t" /></th> 
                    <!-- 成型机台 -->
                    <th data-options="field:'machinecode_s'"><spring:message code="成型机台" /></th>
                    <!-- 成型工人 -->
                    <th data-options="field:'username_b'"><spring:message code="成型工人" /></th>
                    <!-- 成型时间 -->
                    <th data-options="field:'overtime_t'"><spring:message code="成型时间" /></th>
                    <!-- 轮胎条码：MainTyre 表 BARCODE -->
                    <th data-options="field:'barcode_s'"><spring:message code="detial.column.barcode_s" /></th>
                    <!-- 去向 -->
                    <th data-options="field:'go_to_s',formatter:levFormatter"><spring:message code="machinecontrol.column.go_to_s" /></th>
                	<%--  <!-- 当前状态 -->
                    <th data-options="field:'nowstate'"><spring:message code="detial.column.nowstate" /></th> --%>
                    <!-- 判级状态 -->
                    <th data-options="field:'pjstate'"><spring:message code="detial.column.pjstate" /></th> 
                    <!-- 总检查次数 -->
                    <th data-options="field:'totalchecknumber'"><spring:message code="maintyre.column.totalCheckNumber" /></th>
                	<!-- 总返修次数 -->
                    <th data-options="field:'totalreworknum_i'"><spring:message code="maintyre.column.totalreworknum_i" /></th>
                	<!-- 病象描述 -->
                    <th data-options="field:'reas_cn_s'"><spring:message code="detial.column.reas_cn_s" /></th>
                	<!-- 病象类描述 -->
                    <th data-options="field:'collet_code_desc_cn_s'"><spring:message code="reas.column.collet_code_desc_cn_s" /></th>
                	<!-- 品号 -->
                    <th data-options="field:'itemid_s'"><spring:message code="detial.column.itemid_s" /></th>
                	<!-- 规格名称-->
                    <th data-options="field:'materialdesc_s'"><spring:message code="workorderresultprint.column.material_code_s" /></th>
                	<!-- 班组代码 -->
                    <th data-options="field:'groupcd_s',formatter:codeFormatter"><spring:message code="detial.column.groupcd_s" /></th>
                	<!-- 班次代码 -->
                    <th data-options="field:'shiftcd_s',formatter:codeFormatter"><spring:message code="detial.column.shiftcd_s" /></th>
                	<!-- 质检员工号 -->
                    <th data-options="field:'operby',editor:{type:'textbox',options:{required:true}}"><spring:message code="detial.column.operby_s" /></th>
                    <!-- 质检时间 -->
                    <th data-options="field:'opertime_t'"><spring:message code="detial.column.opertime_t" /></th>
                    <!-- 外观检查工位 -->
                    <th data-options="field:'visualvar_s'"><spring:message code="detial.column.visualvar_s" /></th>
                </tr>

            </thead>
        </table>
    </div>
    
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="Detial_search_form" />
		<jsp:param name="datagridId" value="detial_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.finalcheck.excel.DetialExportHandler" />
		<jsp:param name="serviceName" value="DetialServiceImpl" />
	</jsp:include>
</body>
</html>
