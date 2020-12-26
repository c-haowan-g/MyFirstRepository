<!-- 

    作者      :李昂
    时间      :2020-09-25 16:35:58 
    页面名称:原材料领料计划主表
    文件关联:
        RmMaterialApply.java
        RmMaterialApplyController.java
        RmMaterialApplyServiceImpl.java
        RmMaterialApplyServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="rmmaterialapply.js.jsp"%>
<script type="text/javascript" src="dict/005.js"></script>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="RmMaterialApply_dg_toolbar">
            <form id="RmMaterialApply_search_form" class="form" >
               <!-- 物料编码 -->
               <spring:message code="rmmaterialapply.column.material_code_s"/>
               &nbsp;&nbsp;
                <input name="filter[material_code_s]" id="material_code_s" type="text" class="easyui-textbox" data-options="label:''" >&nbsp;&nbsp;
               
                <!-- 用料生产日期 -->
                <spring:message code="rmmaterialapply.column.prod_date_s"/>
                &nbsp;&nbsp;
                <input name="filter[prod_date_s]" id="prod_date_s" type="text" class="easyui-datebox" data-options="onChange:filter,buttons:[],formatter:dateFormat,parser:dateParserStart,width:100,label:''" >
                
                <!-- 物料编码 -->
               <spring:message code="rmmaterialapply.column.s_factory_s"/>
               &nbsp;&nbsp;
                <input name="filter[s_factory_s]" id="s_factory_s" type="text" class="easyui-combobox" data-options="label:'',width:100,
                                                   textField: 'label',
                                                   onLoadSuccess : function(){
			                     					$('#s_factory_s').combobox('setValue','2');
			                 								},
														data: [{
																label: '半钢',
																value: '2'
															},{
                                                          	label: '全钢',
																value: '1'
															}
															]" >&nbsp;&nbsp;
                
                <script type="text/javascript">
                $("#prod_date_s").val(new Calendar().format("yyyyMMdd"));
				
                </script>
                
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="RAW_Plans_MaterialApply_Create"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="create()">生成计划</a></auth:button>
            <auth:button code="RAW_Plans_MaterialApply_Add"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="RAW_Plans_MaterialApply_Edit"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="RAW_Plans_MaterialApply_Del"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            　		<auth:button code="RAW_Plans_MaterialApply_Save"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="RAW_Plans_MaterialApply_Can"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            　
           
        </div>
        <table id="rmmaterialapply_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#RmMaterialApply_dg_toolbar',
                url: 'material/plans/materialApply/rmMaterial/datagridUDA',
                emptyMsg: '<span><spring:message code='tip.noData'/></span>',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',align:'center',width:70,editor:{type:'textbox'}"><spring:message code="rmmaterialapply.column.material_code_s" /></th>
                   <!-- 物料名称 -->
                    <th data-options="field:'material_name_s',align:'center',width:70,editor:{type:'textbox'}"><spring:message code="rmmaterialapply.column.material_name_s" /></th>
                    <!-- 用料生产日期 -->
                    <th data-options="field:'prod_date_s',align:'center',width:70,editor:{type:'textbox',options:{disabled:true}}"><spring:message code="rmmaterialapply.column.prod_date_s" /></th>
                   <%--  <!-- 用料生产班次：302001-早班、302002-中班、302003-晚班 -->
                    <th data-options="field:'prod_shift_s',editor:{type:'textbox'}"><spring:message code="rmmaterialapply.column.prod_shift_s" /></th> --%>
                    <!-- 发料库区 -->
                    <th data-options="field:'spare1_s',align:'center',width:70,formatter:codeFormatter,editor:{type:'combotree',
                            options:{panelHeight:160,
                            editable:false,
				            required:true,
			                url:'dict/code/005'}}"><spring:message code="rmmaterialapply.column.spare1_s" /></th>
                    
                    <!-- 计划重量 -->
                    <th data-options="field:'qty_apply_f',align:'center',width:70,editor:{type:'numberbox',options:{
                    					required:true,
                    					editable:true,
                    					precision:0,
                    					min:0
                    					}}"><spring:message code="rmmaterialapply.column.qty_apply_f" /></th>
                    <!-- 接受重量 -->
                    <th data-options="field:'qty_receive_f',align:'center',width:70,editor:{type:'textbox',options:{disabled:true}}"><spring:message code="rmmaterialapply.column.qty_receive_f" /></th>
                    <!-- 接受库区 -->
                    <th data-options="field:'store_type_s',align:'center',width:70,editor:{type:'textbox',options:{disabled:true}}"><spring:message code="rmmaterialapply.column.store_type_s" /></th>
                    <!-- 接受库区编码 -->
                    <th data-options="field:'spare2_s',align:'center',width:70,editor:{type:'combotree',
                            options:{panelHeight:160,
                            editable:false,
				            required:true,
			                url:'dict/code/012',
			                onChange:areaCodechanged}}">接收库区编码</th>
                    <!-- 工厂：1-全钢，2-半钢 -->
                    <th data-options="field:'s_factory_s',align:'center',formatter:is_factory,width:70,editor:{type:'combobox',options:{
										  required:true,
										  editable:false,
										  disabled:false,
					                      data:[{text:'半钢',value:'2'},
					                            {text:'全钢',value:'1'}],
					                      textField:'text',
					                      valueField:'value'
					                      }}"><spring:message code="rmmaterialapply.column.s_factory_s" /></th>
                	
                    <!-- 创建人姓名 -->
                    <th data-options="field:'created_by_s',align:'center',width:70,editor:{type:'textbox',options:{disabled:true}}"><spring:message code="rmmaterialapply.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',align:'center',width:70,editor:{type:'textbox',options:{disabled:true}}"><spring:message code="rmmaterialapply.column.created_time_t" /></th>
                
                </tr>
            </thead>
        </table>
    </div>
</body>
</html>
