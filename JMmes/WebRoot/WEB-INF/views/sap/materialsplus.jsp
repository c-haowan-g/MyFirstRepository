<!-- 

    作者      :周清玉
    时间      :2018-11-15 16:51:18 
    页面名称:物料信息扩展表
    文件关联:
        MaterialsPlus.java
        MaterialsPlusController.java
        MaterialsPlusServiceImpl.java
        MaterialsPlusServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../inc/meta.jsp"%>
<%@ include file="materialsplus.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="MaterialsPlus_dg_toolbar">
            <form id="MaterialsPlus_search_form" class="form" >
            	<!-- 物料编号80位 -->
                <spring:message code="materialsplus.column.materialcode_s" />:
                <input name="filter[materialcode_s]" id="materialcode_s" like="true" type="text" class="easyui-textbox" data-options="label:'',width:130" >
            	<!-- 物料名称 -->
                <spring:message code="materialsplus.column.materialdesc_s" />:
                <input name="filter[materialdesc_s]" id="materialdesc_s" like="true" type="text" class="easyui-textbox" data-options="label:'',width:260" >
               <%--  <!-- 内径 -->
                <spring:message code="materialsplus.column.innerdia_d" />:
                <input name="filter[innerdia_d]" id="innerdia_d" type="text" like="true" class="easyui-textbox" data-options="label:'',width:130" >
               	<!-- 截面高 -->
                <spring:message code="materialsplus.column.tyreheight_d" />
                <input name="filter[tyreheight_d]" id="tyreheight_d" type="text" like="true" class="easyui-textbox" data-options="label:'',width:130" >
                <!-- 外径 -->
                <spring:message code="materialsplus.column.outerdia_d" />
                <input name="filter[outerdia_d]" id="outerdia_d" type="text" class="easyui-textbox" like="true" data-options="label:'',width:130" > --%>
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="MaterialsPlus.edit"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="MaterialsPlus.save"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="MaterialsPlus.cancel"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            <auth:button code="Shutdownset.showOrHide"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="showOrHide()"><spring:message code="button.searchColumn" /></a></auth:button>
        </div>
        <table id="materialsplus_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#MaterialsPlus_dg_toolbar',
                url: 'sap/materialsPlus/searchBy',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                  <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 物料编号 -->
                    <th data-options="field:'amaterialcode_s'"><spring:message code="materialsplus.column.materialcode_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'amaterialdesc_s'"><spring:message code="messapproduction.column.material_name_s" /></th>
                     <!-- 内径 -->
                    <th data-options="field:'innerdia_d',width:60,editor:{type:'numberbox',options:{precision:0,required:true}}"><spring:message code="materialsplus.column.innerdia_d" /></th>
                    <!-- 外径 -->
                    <th data-options="field:'outerdia_d',width:60,editor:{type:'numberbox',options:{precision:0,required:true}}"><spring:message code="materialsplus.column.outerdia_d" /></th> 
                    <%-- <!-- 截面高 -->
                    <th data-options="field:'tyreheight_d',width:60,editor:{type:'numberbox',options:{required:true,precision:0}}"><spring:message code="materialsplus.column.tyreheight_d" /></th> --%>
                    <!--断面宽-->
                    <th data-options="field:'tyrewidth_d',width:60,editor:{type:'numberbox',options:{precision:0,required:true}}"><spring:message code="materialsplus.column.tyrewidth_d" /></th>
                    <!--子口宽-->
                    <th data-options="field:'beadwidth_d',width:60,editor:{type:'numberbox',options:{precision:0,required:true}}"><spring:message code="materialsplus.column.beadwidth_d" /></th>
                    
                    <!-- 最小存放时间 -->
                    <th data-options="field:'smalltime_f',editor:{type:'numberbox',options:{precision:0,required:true}}"><spring:message code="materialsplus.column.smalltime_f" /></th>
                    <!-- 最大存放时间 -->
                    <th data-options="field:'overtime_f',editor:{type:'numberbox',options:{precision:0,required:true}}"><spring:message code="materialsplus.column.overtime_f" /></th>
                    <!-- 库存是否报警：0-否、1-是 -->
                    <th data-options="field:'stockalarm_s',
                                         	formatter:function(value,row,index){
				                  				if(value=='1'){return '是'}
				                  				else if(value=='0'){return '否'}},
                    editor:{type:'combobox',options:{valueField: 'value',textField: 'label',
                    						data: [{
												label: '是',
												value: '1'
											},{
												label: '否',
												value: '0'
											}],
                    validType:'length[1,100]'}}"><spring:message code="materialsplus.column.stockalarm_s" /></th>
                    <!-- 最大库存 -->
                    <th data-options="field:'maximumstock_f',editor:{type:'numberbox',options:{precision:0,required:true}}"><spring:message code="materialsplus.column.maximumstock_f" /></th>
                    <!-- 最小库存 -->
                    <th data-options="field:'minimumstock_f',editor:{type:'numberbox',options:{precision:0,required:true}}"><spring:message code="materialsplus.column.minimumstock_f" /></th>
					<!-- 钢丝压延垫布层数 -->
                    <th data-options="field:'spare1_s',editor:{type:'numberbox',options:{precision:0}}"><spring:message code="materialsplus.column.spare1_s" /></th>
                    <!-- 打印卡片最大数量 -->
                    <th data-options="field:'spare2_s',editor:{type:'numberbox',options:{precision:0}}"><spring:message code="materialsplus.column.spare2_s" /></th>
                    <!-- 加温是否管控：0-否、1-是 -->
                    <th data-options="field:'spare3_s',
                                         	formatter:function(value,row,index){
				                  				if(value=='1'){return '是'}
				                  				else if(value=='0'){return '否'}},
                    editor:{type:'combobox',options:{valueField: 'value',textField: 'label',
                    						data: [{
												label: '是',
												value: '1'
											},{
												label: '否',
												value: '0'
											}],
                    validType:'length[1,100]'}}"><spring:message code="materialsplus.column.spare3_s" /></th>
                    
                    <!-- 最短加温时间 -->
                    <th data-options="field:'spare4_s',editor:{type:'numberbox',options:{precision:0}}"><spring:message code="materialsplus.column.spare4_s" /></th>
                    <!-- 最长加温时间 -->
                    <th data-options="field:'spare5_s',editor:{type:'numberbox',options:{precision:0}}"><spring:message code="materialsplus.column.spare5_s" /></th>
                    <!-- 有效期是否管控：0-否、1-是 -->
                    <th data-options="field:'spare6_s',
                                         	formatter:function(value,row,index){
				                  				if(value=='1'){return '是'}
				                  				else if(value=='0'){return '否'}},
                    editor:{type:'combobox',options:{valueField: 'value',textField: 'label',
                    						data: [{
												label: '是',
												value: '1'
											},{
												label: '否',
												value: '0'
											}],
                    validType:'length[1,100]'}}"><spring:message code="materialsplus.column.spare6_s" /></th>
                    <!-- 备用字段7 -->
                    <th data-options="field:'spare7_s',editor:{type:'numberbox',options:{precision:0}}"><spring:message code="materialsplus.column.spare7_s" /></th>
                    <!-- 备用字段8 -->
                    <th data-options="field:'spare8_s',editor:{type:'numberbox',options:{precision:0}}"><spring:message code="materialsplus.column.spare8_s" /></th>
                    <!-- 备用字段9 -->
                    <th data-options="field:'spare9_s',editor:{type:'numberbox',options:{precision:0}}"><spring:message code="materialsplus.column.spare9_s" /></th>
                    <!-- 备用字段10 -->
                    <th data-options="field:'spare10_s',editor:{type:'numberbox',options:{precision:0}}"><spring:message code="materialsplus.column.spare10_s" /></th>
                    <!-- 备用字段11 -->
                    <th data-options="field:'spare11_s',editor:{type:'numberbox',options:{precision:0}}"><spring:message code="materialsplus.column.spare11_s" /></th>
                    <!-- 备用字段12 -->
                    <th data-options="field:'spare12_s',editor:{type:'numberbox',options:{precision:0}}"><spring:message code="materialsplus.column.spare12_s" /></th>
                    <!-- 备用字段13 -->
                    <th data-options="field:'spare13_s',editor:{type:'numberbox',options:{precision:0}}"><spring:message code="materialsplus.column.spare13_s" /></th>
                    <!-- 备用字段14 -->
                    <th data-options="field:'spare14_s',editor:{type:'numberbox',options:{precision:0}}"><spring:message code="materialsplus.column.spare14_s" /></th>
                    <!-- 备用字段15 -->
                    <th data-options="field:'spare15_s',editor:{type:'numberbox',options:{precision:0}}"><spring:message code="materialsplus.column.spare15_s" /></th>
                    <!-- 备用字段16 -->
                    <th data-options="field:'spare16_s',editor:{type:'numberbox',options:{precision:0}}"><spring:message code="materialsplus.column.spare16_s" /></th>
                    <!-- 备用字段17 -->
                    <th data-options="field:'spare17_s',editor:{type:'numberbox',options:{precision:0}}"><spring:message code="materialsplus.column.spare17_s" /></th>
                    <!-- 备用字段18 -->
                    <th data-options="field:'spare18_s',editor:{type:'numberbox',options:{precision:0}}"><spring:message code="materialsplus.column.spare18_s" /></th>
                    <!-- 备用字段19 -->
                    <th data-options="field:'spare19_s',editor:{type:'numberbox',options:{precision:0}}"><spring:message code="materialsplus.column.spare19_s" /></th>
                    <!-- 备用字段20 -->
                    <th data-options="field:'spare20_s',editor:{type:'numberbox',options:{precision:0}}"><spring:message code="materialsplus.column.spare20_s" /></th>
                   
                    <!-- 操作人 -->
                    <th data-options="field:'changed_by_name'"><spring:message code="materialsplus.column.changed_by_s" /></th>
                    <!-- 操作时间 -->
                    <th data-options="field:'changed_time_t'"><spring:message code="materialsplus.column.changed_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
</body>
</html>
