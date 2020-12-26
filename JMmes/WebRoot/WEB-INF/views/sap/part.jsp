<!-- 

    作者      :周清玉
    时间      :2019-06-20 11:14:46 
    页面名称:sap，part基础物料
    文件关联:
        Part.java
        PartController.java
        PartServiceImpl.java
        PartServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../inc/meta.jsp"%>
<%@ include file="part.js.jsp"%>
<script type="text/javascript" src="dict/-304,-308.js"></script>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="Part_dg_toolbar">
            <form id="Part_search_form" class="form" >
                <table class="formTable">
					<tr>
							 <!-- 物料编码（9位） -->
							 <spring:message code="messapproduction.column.material_code_s" />:
               				 <input name="filter[materialcode_s]" like="true" id="materialcode_s" type="text" class="easyui-textbox" data-options="
               				 label:'',
               				 width:'120px'
               				 " >
							 <!-- 物料名称 -->
							 <spring:message code="messapproduction.column.material_name_s" />:
                			 <input name="filter[materialdesc_s]" like="true" id="materialdesc_s" type="text" class="easyui-textbox" data-options="
                			 label:'',
                			  width:'120px'
                			 " >
							  <!-- 规格 -->
							  <spring:message code="messapproduction.column.materialspec" />:
                			  <input name="filter[materialspec_s]" like="true" id="materialspec_s" type="text" class="easyui-textbox" data-options="
                			  label:'',
                			   width:'120px'
                			  " >
					</tr>
					<tr>
							<!--物料类型  -->
							<spring:message code="messapproduction.column.mattype" />:
                			<input name="filter[mattyp_s]" id="mattyp_s"  type="text" class="easyui-combotree" data-options="
                			label:'',
                			width:'120px',
                			required:false,
                			panelHeight:200,
                			url:'dict/code/-304',
                			method:'get'" >
							<!-- 物料组 -->
							<spring:message code="messapproduction.column.matgrp" />:
                			<input name="filter[matgrp_s]" like="true" id="matgrp_s" type="text" class="easyui-combotree" data-options="
                			label:'',
							width:'180px',
							panelHeight:200,
                   		    url:'dict/code/-308',
                    		method:'get'" >
							<!-- 物料组 -->
                			 <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
					</tr>
				</table>
            </form> 
        </div>
        <table id="part_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#Part_dg_toolbar',
                emptyMsg: '<span><spring:message code='tip.noData'/></span>',
                url: 'Part/datagridUDA_Ping',
                striped:true,
                method: 'get' 
                ">
             <thead>
                <tr>
                	<!-- 物料编码（18位） -->
                    <th data-options="field:'part_number' "><spring:message code="messapproduction.column.material_code_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'description' "><spring:message code="messapproduction.column.material_name_s" /></th>
                   	<!-- 物料类型 -->
                    <th data-options="field:'mattyp_s',formatter:codeFormatter,editor:{type:'combotree',options:{
                    			panelHeight:200,
                    			method:'get',
                                url:'dict/code/-304',
                    			required:true}}"><spring:message code="materials.column.mattyp_s" /></th>
                    <!-- 物料组 -->
                    <th data-options="field:'matgrp_s',formatter:codeFormatter, editor:{
							type:'textbox',options:{panelWidth:200,required:true,method:'get',
                                url:'dict/code/-308'}}"><spring:message code="materials.column.matgrp_s" /></th>
                    <!-- 规格 -->
                    <th data-options="field:'materialspec_s' "><spring:message code="materials.column.materialspec_s" /></th>
                    <!-- 花纹 -->
                    <th data-options="field:'pattern_s' "><spring:message code="materials.column.pattern_s" /></th>
                    <!-- 层级 -->
                    <th data-options="field:'cj_s' "><spring:message code="materials.column.cj_s" /></th>
                    <!-- 净重 -->
                    <th data-options="field:'netheavy_f' "><spring:message code="materials.column.netheavy_f" /></th>
                	<!-- 计量单位 -->
                    <th data-options="field:'baseunit_s' "><spring:message code="materials.column.baseunit_s" /></th>
                	<!-- OE OR RE -->
                    <th data-options="field:'isoeorre_s' "><spring:message code="part.column.isoeorre" /></th>
                	<!-- 状态 -->
                    <th data-options="field:'matstatus_s' "><spring:message code="materials.column.matstatus_s" /></th>
                    <!-- 特殊采购类型 -->
                    <th data-options="field:'sobsl_s' "><spring:message code="materials.column.sobsl_s" /></th>
                    <!-- 商品名称 -->
                    <th data-options="field:'spmc_s' "><spring:message code="materials.column.spmc_s" /></th>
                    <!-- 跨工厂物料状态-->
                    <th data-options="field:'status_s' "><spring:message code="materials.column.status_s" /></th>
                    <!-- 更新时间 -->
                    <th data-options="field:'change_time' "><spring:message code="materials.column.changetime_t" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'creation_time' "><spring:message code="materials.column.createtime_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
</body>
</html>
