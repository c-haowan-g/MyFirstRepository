<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../inc/meta.jsp"%>
<%@ include file="dict.js.jsp"%>
<body class="easyui-layout" fit="true">
	<div data-options="region:'west',split:true" title="字典树" style="width:300px;">
		<ul class="easyui-tree" id="dictTree" data-options="animate : true,
                onSelect : onSelect,
                formatter : formatter,
                url:'dict/tree'">
		</ul>
	</div>
	<div data-options="region:'center',title:'字典表'">
	   <div id="dict_dg_toolbar" style="padding:3px;">
	        
	        <form id="CoreDictionary_search_form" class="form" >
	        <!-- 代码 -->
	        <spring:message code="coredictionary.column.dictcode_s" />
            :&emsp;<input name="filter[dictcode_s]" like="true" id="dictcode_s" type="text" class="easyui-textbox" data-options="label:''" >
            <!-- 中文名称 -->
            <spring:message code="coredictionary.column.dictname_s" />
            :&emsp;<input name="filter[dictname_s]" like="true" id="dictname_s" type="text" class="easyui-textbox" data-options="label:''" >
	        
	        <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
	   
			<auth:button code="dict.add">
            <a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()">添加</a>
			</auth:button>
			<auth:button code="dict.edit">
            <a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-edit'" onclick="edit()">修改</a>
			</auth:button>
			<auth:button code="dict.delete">
            <a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-remove'" onclick="remove()">删除</a>
            </auth:button>
			<auth:button code="dict.save">
            <a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()">保存</a>
			</auth:button>
			<auth:button code="dict.cancel">
            <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()">撤销</a> 
			</auth:button>
			
        </div>
        <table class="easyui-datagrid" style="width:200%" id="dict_dg" border="false">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <th data-options="field:'deleted_i',width:100,formatter:deleted,editor:{type:'combobox',options:
	                                {valueField:'value',
	                                textField:'text',
	                                method:'get',
	                                data: [{
											text: '<spring:message code='tip.yes'/>',
											value: 0
										},{
											text: '<spring:message code='tip.no'/>',
											value: 1
										}],
	                                required:true}}">是否有效</th>
                    <th data-options="field:'dictcode_s',width:100,editor:{type:'textbox',options:{required:true,validType:'length[1,100]'}}">代码</th>
                    <th data-options="field:'dictname_s',width:100,editor:{type:'textbox',options:{required:true,validType:'length[1,100]'}}">中文名称</th>
                    <th data-options="field:'dictname_en_s',width:100,editor:{type:'textbox',options:{required:true,validType:'length[1,100]'}}">英文名称</th>
                    <th data-options="field:'dictname_th_s',width:100,editor:{type:'textbox',options:{required:true,validType:'length[1,100]'}}">泰文名称</th>                    
                    <th data-options="field:'erpcode_s',width:100,editor:{type:'textbox',options:{validType:'length[1,100]'}}">代码值</th>
                    <th data-options="field:'dictdesc_s',width:100,editor:{type:'textbox',options:{validType:'length[1,100]'}}">代码值2</th>
                    <th data-options="field:'sortno_i',width:100,editor:{type:'numberbox',options:{precision:0,validType:'length[1,100]'}}">排序号</th>
                    <!-- 更新人 -->
                    <th data-options="field:'changed_by_s',width:80"><spring:message code="coredictionary.column.changed_by_s" /></th>
                    <!-- 更新时间 -->
                    <th data-options="field:'changed_time_t',width:120"><spring:message code="coredictionary.column.changed_time_t" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_s',width:80"><spring:message code="coredictionary.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',width:120"><spring:message code="coredictionary.column.created_time_t" /></th>
                    
                </tr>
            </thead>
        </table>
	</div>
</body>
</html>
