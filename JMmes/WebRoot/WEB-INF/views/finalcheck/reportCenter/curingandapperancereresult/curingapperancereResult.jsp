<!-- 
    作者      :周清玉
    时间      :2018-12-14 08:25:07 
    页面名称:硫化外观合格率报表
    文件关联:
        MainTyre.java
        MainTyreController.java
        MainTyreServiceImpl.java
        MainTyreServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="curingapperancereResult.js.jsp"%>
<script type="text/javascript" src="dict/253,262,302.js"></script>
<style type="text/css">
.columnTitle {
	padding: 6px 10px
}
</style>


<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="curingAndApperanceQualification_dg_toolbar">
            <form id="curingAndApperanceQualification_search_form" class="form" >
            <table class="formTable">
				<tr>
						<!-- 操作时间 -->
						 <spring:message code="maintyre.column.jianchatime" />:
					      <input name="filter[beginTime]" type="text"    id="start_time" class="easyui-datetimebox"  style="width:150px;" data-options="label:''">
				               <spring:message code="tip.to" />
				          <input name="filter[endTime]"    id="end_time" class="easyui-datetimebox"  style="width:150px;">
				         <!-- 产线条码 -->
	                      <spring:message code="productiondayplan.column.production_line_s" />:
	                       <input type="text" name="filter[curingmachinecode_s]" id="curingmachinecode_s" class="easyui-combobox" data-options="data:jtxx,panelHeight:130,editable:true,valueField:'P_LINE_NAME',textField:'P_LINE_NAME',selectOnNavigation:false,limitToList:true" />
		                    <!-- 硫化班次 -->
		                    <spring:message code="workorderresult.column.class_id_s" />:
		                    <input name="filter[class_id_s]" id="class_id_s"  style="width:100px;" type="text" class="easyui-combotree" data-options="label:'',
								                  panelHeight:100,
								                  labelWidth:'auto',
												  required:false,
												  url:'dict/code/302',
												  method:'get'" >	
							
							<!-- 品号 -->
					       <spring:message code="maintype.column.curingspeccode_s" />:
                           <input name="filter[materialcode_s]" id="materialcode_s" style="width:100px;"  like="true" type="text" class="easyui-textbox" data-options="label:''" >
							
							<!-- 硫化人员 -->
					       <spring:message code="maintyres.column.curinguserid_s" />:
                            <input name="filter[curinguserid_s]" id="curinguserid_s" style="width:100px;"  type="text" class="easyui-textbox" data-options="label:''" >
						<a class="easyui-linkbutton btn-yellow"
						data-options="iconCls:'icon-search'" onclick="filter()"><spring:message
						code="button.search" /></a>
					<auth:button code="ZJ_BBZX_DPHJCJGHZ_PRINT">
						<a class="easyui-linkbutton btn-deep-blue"
							data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message
								code="button.export" /></a>
					</auth:button>
				</tr>
			</table>
			</form>
			
			
        </div>
        <table id="curingAndApperanceQualification_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                pagination:true,
                emptyMsg: '<span><spring:message code='tip.noData'/></span>',
                rownumbers: true,
                singleSelect: false,
                toolbar: '#curingAndApperanceQualification_dg_toolbar',
                pageSize: 15,
       			pageList: [15,30,50,100,200],
                striped:true,
                method: 'get'
                ">
            <thead>
                <tr>
                	 <th data-options="field:'atr_key',checkbox:true">ID</th>

                     <!-- 硫化机台 -->
                    <th data-options="field:'curingmachinecode_s',width:30,editor:{type:'textbox',options:{required:true}} " ><spring:message code="maintype.column.curingmachinecode_s" /></th>
                     
                     <!--ERP品号 -->
                    <th data-options="field:'materialcode_s',width:30,editor:{type:'textbox',options:{required:true}} " ><spring:message code="maintype.column.curingspeccode_s" /></th>
                    
                    <!--规格名称 -->
                    <th data-options="field:'materialdesc_s',width:120,editor:{type:'textbox',options:{required:true}} " ><spring:message code="maintype.column.curingspecmater" /></th>
                   

                    <!-- 硫化生产数量 -->
                    <th data-options="field:'curingoutputcount',width:30,editor:{type:'textbox',options:{required:true}} " ><spring:message code="CuringAndFinalQualificationResult.colum.curingOutputCount" /></th>
                    
                    <!--检测总数 -->
                    <th data-options="field:'appearancecheckoutputcount',width:30,editor:{type:'textbox',options:{required:true}} " ><spring:message code="CuringAndFinalQualificationResult.colum.appearancecheckOutPutCount" /></th>
                
                    <!--不良品数量 -->
                    <th data-options="field:'failcount',width:30,editor:{type:'textbox',options:{required:true}} " ><spring:message code="CuringAndFinalQualificationResult.colum.failCount" /></th>
                    
                    <!-- 检测合格率 -->
                    <th data-options="field:'failurerate',width:30,formatter:reworkpreossFormatter,editor:{type:'textbox',options:{required:true}} " ><spring:message code="CuringAndFinalQualificationResult.colum.failUreRate" /></th>
                </tr>
            </thead>
        </table>
    </div>
     <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="materialcode_s" />
		<jsp:param name="formId" value="curingAndApperanceQualification_search_form" />
		<jsp:param name="datagridId" value="curingAndApperanceQualification_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.finalcheck.excel.CuringAndApperanceQualificationExportHandler" />
		<jsp:param name="serviceName" value="MaintypeServiceImpl" />
	</jsp:include>
    
</body>
</html>
