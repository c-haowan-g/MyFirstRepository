<!-- 

    作者      :李迺锟
    时间      :2018-10-12 10:21:29 
    页面名称:质检动平衡翻转维护
    文件关联:
        Dynabalancereversal.java
        DynabalancereversalController.java
        DynabalancereversalServiceImpl.java
        DynabalancereversalServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="dynabalancereversal.js.jsp"%>
<script type="text/javascript" src="dict/267.js"></script>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="Dynabalancereversal_dg_toolbar">
            <form id="Dynabalancereversal_search_form" class="form" >
                <!-- 物料编号80位 -->
                <spring:message code="dynabalancereversal.column.materialcode_s" />:
                <input name="filter[materialcode_s]" style="width:150px;" id="materialcode_s" like="true"   type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 物料描述 -->
                <spring:message code="dynabalancereversal.column.materialdesc_s" />:
                <input name="filter[materialdesc_s]" style="width:150px;" id="materialdesc_s" like="true"  type="text" class="easyui-textbox" data-options="label:''" >
                <spring:message code="dynabalancereversal.column.reversalvalue_s" />:
				<input name="filter[reversalvalue_s]" id="reversalvalue_s" like="true" style="width:170px;" type="text" class="easyui-combotree" data-options="label:'',
						                  labelWidth:'auto',
										  panelHeight:120,
										  required:false,
										  url:'dict/code/267',
										  method:'get'">
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
             <auth:button code="ZJ_JCGL_DPHFZWH_ADD"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="ZJ_JCGL_DPHFZWH_EDIT"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="ZJ_JCGL_DPHFZWH_REMOVE"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            <auth:button code="ZJ_JCGL_DPHFZWH_SAVE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="ZJ_JCGL_DPHFZWH_CANCEL"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
        </div>
        <table id="dynabalancereversal_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#Dynabalancereversal_dg_toolbar',
                url: 'finalcheck/standardmagement/dynabalancereversal/datagrid',
                striped:true,
                method: 'get', 
                onBeforeLoad:onDgBeforeLoad
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 物料编号 -->
                    <th data-options="field:'materialcode_s',width:120,editor:{type:'combobox',options:
	                	{
	                	valueField:'MATERIALCODE_S',
			            textField:'MATERIALCODE_S',
			            editable:'true',
			            limitToList:'false',
			            panelHeight:300,
			            panelWidth:200,
			            method:'get',
			            url:'finalcheck/reportcenter/sortstorageitem/datagrid_material_factory',
			            required:true,
			            filter: function(q, row){  
					        var opts = $(this).combobox('options');  
					        return row[opts.textField].indexOf(q) >= 0;//这里改成>=即可在任意地方匹配  
					    }, 
					    onSelect:onMaterialSelect,
	                    }}">
                    <spring:message
							code="dynabalancereversal.column.materialcode_s" /></th>
                    <!-- 物料描述 -->
                    <th data-options="field:'materialdesc_s',width:300,editor:{type:'textbox',options:{editable:false,icons:[],disabled:true}}"><spring:message code="dynabalancereversal.column.materialdesc_s" /></th>
                     <!-- 控制翻转 -->
                    <th data-options="field:'reversalvalue_s',width:80,formatter:codeFormatter,editor:{type:'combotree',options:{panelWidth:200,method:'get',
                                data:DICT_267, required:true,}}"><spring:message code="dynabalancereversal.column.reversalvalue_s" /></th>
                     <!-- 创建人 -->
                    <th data-options="field:'created_username',width:80"><spring:message code="dynabalancereversal.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',width:80"><spring:message code="dynabalancereversal.column.created_time_t" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changed_username',width:80"><spring:message code="dynabalancereversal.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',width:80"><spring:message code="dynabalancereversal.column.changed_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
    
</body>
</html>
