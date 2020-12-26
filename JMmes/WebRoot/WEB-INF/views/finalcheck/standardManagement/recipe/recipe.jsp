<!-- 

    作者      :司乔靖+刘朋
    时间      :2018-08-01 10:00:25 
    页面名称:配方标准维护
    文件关联:
        Recipe.java
        RecipeController.java
        RecipeServiceImpl.java
        RecipeServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="recipe.js.jsp"%>
<script type="text/javascript" src="dict/254.js"></script>
<style type="text/css">
.columnTitle {
	padding: 6px 10px
}
</style>
<body>
	<div class="easyui-layout" fit="true"style="width:40%;height:350px;">
		<div data-options="region:'west',split:true" style="width:50%;">
			<div id="Recipe_dg_toolbar">
				<form id="Recipe_search_form" class="form">
				<table class="formTable">
				<tr>
						<spring:message code="ent.column.enttype_i" />:
						<!-- 设备类-->
		                <input name="filter[enttype_i]" id="enttype_i" type="text" class="easyui-combobox" style="width:110px" data-options="label:'', 
                              required:true,
                              textField: 'label',
						      valueField: 'value',
						      data: [{label:'动平衡',value:'254004'},
						             {label:'均匀性',value:'254005'}],
                              method:'get'">
						<!-- <input name="filter[enttype_i]" id="enttype_i" type="text"
							class="easyui-combotree" style="width:120px"
							data-options="label:'', 
	                             width:'150px',
	                            required:true,
	                          	data:DICT_254,
	                             method:'get'" > -->
	                   <spring:message code="recipe.column.recipeno_s" />:
					   <!-- 配方号 -->
					   <input name="filter[recipeno_s]" id="recipeno_s" type="text" class="easyui-textbox" style="width:80px" data-options="label:''">
					   <spring:message code="materials.column.materialcode_s" />:
					   <!-- 物料编码 -->
					   <input name="filter[itemid_s]" id="itemid_s"  like="true" type="text" like="true" class="easyui-textbox" style="width:100px" data-options="label:''">
					   <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
					 
				</tr>
			</table>	
				</form>
				<auth:button code="ZJ_JCGL_PFBZ_ADD"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a>
				</auth:button>
				<auth:button code="ZJ_JCGL_PFBZ_EDIT">
					<a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a>
				</auth:button>
				<auth:button code="ZJ_JCGL_PFBZ_REMOVE">
					<a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a>
				</auth:button>
				<auth:button code="ZJ_JCGL_PFBZ_SAVE">
					<a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a>
				</auth:button>
				<auth:button code="ZJ_JCGL_PFBZ_CANCEL">
					<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>
				</auth:button>
				<auth:button code="ZJ_JCGL_PFBZ_EXPORT1">
					<a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a>
				</auth:button>
				<a class="easyui-linkbutton btn-green"
					data-options="iconCls:'icon-hide'" onclick="showhide()"><spring:message code="查询栏" /></a>
			</div>
			<table id="recipe_dg" class="easyui-datagrid" style="width:40%"
				data-options="  
                fit:true,
                fitColumns:true,
                emptyMsg: '<span><spring:message code='tip.noData'/></span>',
                pagination:false,
                rownumbers: true,
                singleSelect: true,
                toolbar: '#Recipe_dg_toolbar',
                clientPaging:false,
                remoteFilter:true,
                remoteSort:false,
                url: '',
                striped:true,
                onSelect:showDetial,
                method: 'get' ,
                idField:'atr_key'
                ">
				<thead>
					<tr>
						<th data-options="field:'atr_key',checkbox:true">ID</th>
						<!--设备类-->
						<th data-options="field:'enttype_i',formatter:codeFormatter,width:60,sortable:true,editor:{type:'combotree',options:
                                {
                                method:'get',
                                url:'dict/code/254',
                                required:true}}"><spring:message
								code="recipe.column.enttype_i" /></th>
						<!-- 配方号 -->
						<th data-options="field:'recipeno_s',sortable:true,width:20,editor:{type:'textbox',options:
                                {
                                required:true}}"><spring:message code="recipe.column.recipeno_s" /></th>
						
						<!-- 规格数 -->
						<th data-options="field:'num_i',sortable:true,width:20,formatter:numformatter"><spring:message code="recipe.column.num_i" /></th>
					</tr>
				</thead>
			</table>
		</div>



   <div data-options="region:'center',split:true" title="配方信息">
         <div class="easyui-layout" fit="true">
			<div data-options="region:'north',iconCls:'icon-ok'"style="height:60%" title="已选规格" >
	         <div id="Recipe_dg_toolbar2">
				<a class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="add2()">新增</a> 
				<a class="easyui-linkbutton"data-options="iconCls:'icon-remove'" onclick="remove2()">删除</a> 
			    <a class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="save2()">保存</a>
	         </div>
			<table id="recipe_dg2" class="easyui-datagrid" style="height:50%">
				<thead>
					<tr>
						<th data-options="field:'atr_key',checkbox:true"></th>
						<!-- D_BS_Recipe 表 ID -->
						<th data-options="field:'recipeid_i',width:30,hidden:'true',editor:{type:'textbox',options:{required:true}}"><spring:message code="recipeitem.column.recipeid_i" /></th>
						<!-- 品号 -->
						<th data-options="field:'itemid_s',width:20,editor:{type:'textbox',options:{required:true}}"><spring:message code="materials.column.materialcode_s" /></th>
						<!-- 规格 -->
						<th data-options="field:'materialspec_s',width:80,editor:{type:'textbox',options:{required:true}}"><spring:message code="materials.column.materialspec_s" /></th>
					</tr>
				</thead>
			</table>
		</div>
		
	  <div data-options="region:'south',iconCls:'icon-ok'" style="height:40%" title="PLM动平衡参数查询"style="width:30%">
	   <div id="dynamicbalance_dg_toolbar2">
   			 <auth:button code="ZJ_BZGL_RKFJ_EDIT"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-edit'" onclick="showplmdlg()"><spring:message code="button.edit" /></a></auth:button>
   		</div>
   			  	<table id="dynamicbalance_dg" class="easyui-datagrid" style="width:100%"
				            data-options="  
				                fit:true,
				                fitColumns:false,
				                singleSelect: true,
				                url: '',
				                striped:true,
				                toolbar:dynamicbalance_dg_toolbar2,
				                method: 'get' 
				                ">
				            <thead>
				            	<tr>
				            	    <!--<th data-options="field:'atr_key',checkbox:true" rowspan="2"></th>-->
				            	    <!-- 类别：TBROE、TBRRE -->
				                    <th data-options="field:'category_s',editor:{type:'textbox'}" rowspan="2"><spring:message code="dynamicbalance.column.category_s" /></th>
				            		<th colspan="3">规格及品种</th>
				            		<!-- 花纹 -->
				                    <th data-options="field:'pattern_s',editor:{type:'textbox'}" rowspan="2"><spring:message code="dynamicbalance.column.pattern_s" /></th>
				                    <!-- SAP号 -->
				                    <th data-options="field:'sapcode_s',editor:{type:'textbox'}" rowspan="2"><spring:message code="dynamicbalance.column.sapcode_s" /></th>
				                    <th colspan="2">实验</th>
				                    <!-- 等级 -->
				                    <th data-options="field:'grade_s',editor:{type:'textbox'}" rowspan="2"><spring:message code="dynamicbalance.column.grade_s" /></th>
				                    <th colspan="2">动平衡</th>
				                    <!-- 静平衡 -->
				                    <th data-options="field:'staticbalance_s',editor:{type:'textbox'}" rowspan="2"><spring:message code="dynamicbalance.column.staticbalance_s" /></th>
				                    <!-- 凹凸度 -->
				                    <th data-options="field:'camber_s',editor:{type:'textbox'}" rowspan="2"><spring:message code="dynamicbalance.column.camber_s" /></th>
				                    <!-- 径向跳动 -->
				                    <th data-options="field:'runout_s',editor:{type:'textbox'}" rowspan="2"><spring:message code="dynamicbalance.column.runout_s" /></th>
				                    <!-- 侧向跳动 -->
				                    <th data-options="field:'lateralbeating_s',editor:{type:'textbox'}" rowspan="2"><spring:message code="dynamicbalance.column.lateralbeating_s" /></th>
				                    <th colspan="4">均匀性</th>
				                    <!-- 打标特殊要求 -->
				                    <th data-options="field:'specialrequire_s',editor:{type:'textbox'}" rowspan="2"><spring:message code="dynamicbalance.column.specialrequire_s" /></th>
				                    <!-- 备注 -->
				                    <th data-options="field:'comment_s',editor:{type:'textbox'}" rowspan="2"><spring:message code="dynamicbalance.column.comment_s" /></th>  
				            	</tr>
				                <tr>
				                	<!-- 规格 -->
				                    <th data-options="field:'specification_s',editor:{type:'textbox'}"><spring:message code="dynamicbalance.column.specification_s" /></th>
				                    <!-- 层级 -->
				                    <th data-options="field:'hierarchy_s',editor:{type:'textbox'}"><spring:message code="dynamicbalance.column.hierarchy_s" /></th>
				                    <!-- 描述 -->
				                    <th data-options="field:'description_s',editor:{type:'textbox'}"><spring:message code="dynamicbalance.column.description_s" /></th>
				                    <!-- 气压 -->
				                    <th data-options="field:'pressure_s',editor:{type:'textbox'}"><spring:message code="dynamicbalance.column.pressure_s" /></th>
				                    <!-- 负荷 -->
				                    <th data-options="field:'load_s',editor:{type:'textbox'}"><spring:message code="dynamicbalance.column.load_s" /></th>
				                    <!-- Up/Low -->
				                    <th data-options="field:'uplow_s',editor:{type:'textbox'}"><spring:message code="dynamicbalance.column.uplow_s" /></th>
				                    <!-- Total -->
				                    <th data-options="field:'total_s',editor:{type:'textbox'}"><spring:message code="dynamicbalance.column.total_s" /></th>
				                    <!-- RFV -->
				                    <th data-options="field:'rfv_s',editor:{type:'textbox'}"><spring:message code="dynamicbalance.column.rfv_s" /></th>
				                    <!-- RIH -->
				                    <th data-options="field:'rih_s',editor:{type:'textbox'}"><spring:message code="dynamicbalance.column.rih_s" /></th>
				                    <!-- LFV -->
				                    <th data-options="field:'lfv_s',editor:{type:'textbox'}"><spring:message code="dynamicbalance.column.lfv_s" /></th>
				                    <!-- CON -->
				                    <th data-options="field:'con_s',editor:{type:'textbox'}"><spring:message code="dynamicbalance.column.con_s" /></th>
				                   </tr>
				            </thead>
         </table>
   	 </div>
   </div>	 
   </div>	
 </div>

<!-- 弹出的选择规格的页面 -->
	<div id="menu_dlg" class="easyui-dialog" title="新增"
		style="width:90%;height:80%;"
		data-options="
                resizable:true,
    			modal:true,
                iconCls:'icon-window',
                closed:true,
                onOpen:load,
                buttons: [{
                    text:'保存',
                    iconCls:'icon-ok',
                    handler:function(){
                        saveToDetial();
                    }
                },{
                    text:'取消',
                     iconCls:'icon-cancel',
                    handler:function(){
                        cancelToDetial();
                    }
                }]
                ">
        <table id="material_dg" class="easyui-datagrid" style="width:100%">
			<thead>
				<tr>
					<th data-options="field:'atr_key',checkbox:true"></th>
					<!-- 品号 -->
					<th data-options="field:'part_number',width:'10%',editor:{type:'textbox',options:{required:true}}"><spring:message code="materials.column.materialcode_s" /></th>
					<!-- 物料描述 -->
					<th data-options="field:'description',width:'35%',editor:{type:'textbox',options:{required:true}}"><spring:message code="materials.column.materialdesc_s" /></th>
					<!-- 规格 -->
					<th data-options="field:'materialspec_s',width:'35%',editor:{type:'textbox',options:{required:true}}"><spring:message code="materials.column.materialspec_s" /></th>
					<!-- 花纹 -->
					<th data-options="field:'pattern_s',width:'10%',editor:{type:'textbox',options:{required:true}}"><spring:message code="materials.column.pattern_s" /></th>
					<!-- 层级 -->
					<th data-options="field:'cj_s',width:'10%',editor:{type:'textbox',options:{required:true}}"><spring:message code="materials.column.cj_s" /></th>
				</tr>
			</thead>
		</table>
	</div>



  <!-- 弹出的选择PLM参数的页面 -->
    <div id="plm_dlg" class="easyui-dialog" title="动平衡参数列表"
			style="width:80%;height:70%;"
			data-options="
	                resizable:true,
	    			modal:true,
	                iconCls:'icon-window',
	                closed:true,
	                buttons: [{
	                    text:'保存',
	                    iconCls:'icon-ok',
	                    handler:function(){
	                        dosaveToPLM();
	                    }
	                },{
	                    text:'取消',
	                     iconCls:'icon-cancel',
	                    handler:function(){
	                        cancelSelectPLM();
	                    }
	                }]
	                ">
		            <table id="dynamicbalance_add_dg" class="easyui-datagrid" style="width:100%"
				            data-options="  
				                fit:true,
				                fitColumns:false,
				                pagination:true,
				                rownumbers: true,
				                singleSelect: true,
				                url: 'finalcheck/standarManagement/dynamicbalance/datagrid',
				                striped:true,
				                method: 'get' 
				                ">
				            <thead>
				            	<tr>
				            	    <!--<th data-options="field:'atr_key',checkbox:true" rowspan="2"></th>-->
				            	    <!-- 类别：TBROE、TBRRE -->
				                    <th data-options="field:'category_s',width:80,editor:{type:'textbox'}" rowspan="2"><spring:message code="dynamicbalance.column.category_s" /></th>
				            		<th colspan="3">规格及品种</th>
				            		<!-- 花纹 -->
				                    <th data-options="field:'pattern_s',width:80,editor:{type:'textbox'}" rowspan="2"><spring:message code="dynamicbalance.column.pattern_s" /></th>
				                    <!-- SAP号 -->
				                    <th data-options="field:'sapcode_s',width:80,editor:{type:'textbox'}" rowspan="2"><spring:message code="dynamicbalance.column.sapcode_s" /></th>
				                    <th colspan="2">实验</th>
				                    <!-- 等级 -->
				                    <th data-options="field:'grade_s',width:80,editor:{type:'textbox'}" rowspan="2"><spring:message code="dynamicbalance.column.grade_s" /></th>
				                    <th colspan="2">动平衡</th>
				                    <!-- 静平衡 -->
				                    <th data-options="field:'staticbalance_s',width:80,editor:{type:'textbox'}" rowspan="2"><spring:message code="dynamicbalance.column.staticbalance_s" /></th>
				                    <!-- 凹凸度 -->
				                    <th data-options="field:'camber_s',width:80,editor:{type:'textbox'}" rowspan="2"><spring:message code="dynamicbalance.column.camber_s" /></th>
				                    <!-- 径向跳动 -->
				                    <th data-options="field:'runout_s',width:80,editor:{type:'textbox'}" rowspan="2"><spring:message code="dynamicbalance.column.runout_s" /></th>
				                    <!-- 侧向跳动 -->
				                    <th data-options="field:'lateralbeating_s',width:80,editor:{type:'textbox'}" rowspan="2"><spring:message code="dynamicbalance.column.lateralbeating_s" /></th>
				                    <th colspan="4">均匀性</th>
				                    <!-- 打标特殊要求 -->
				                    <th data-options="field:'specialrequire_s',width:80,editor:{type:'textbox'}" rowspan="2"><spring:message code="dynamicbalance.column.specialrequire_s" /></th>
				                    <!-- 备注 -->
				                    <th data-options="field:'comment_s',width:80,editor:{type:'textbox'}" rowspan="2"><spring:message code="dynamicbalance.column.comment_s" /></th>  
				            	</tr>
				                <tr>
				                	<!-- 规格 -->
				                    <th data-options="field:'specification_s',width:80,editor:{type:'textbox'}"><spring:message code="dynamicbalance.column.specification_s" /></th>
				                    <!-- 层级 -->
				                    <th data-options="field:'hierarchy_s',width:80,editor:{type:'textbox'}"><spring:message code="dynamicbalance.column.hierarchy_s" /></th>
				                    <!-- 描述 -->
				                    <th data-options="field:'description_s',width:80,editor:{type:'textbox'}"><spring:message code="dynamicbalance.column.description_s" /></th>
				                    <!-- 气压 -->
				                    <th data-options="field:'pressure_s',width:80,editor:{type:'textbox'}"><spring:message code="dynamicbalance.column.pressure_s" /></th>
				                    <!-- 负荷 -->
				                    <th data-options="field:'load_s',width:80,editor:{type:'textbox'}"><spring:message code="dynamicbalance.column.load_s" /></th>
				                    <!-- Up/Low -->
				                    <th data-options="field:'uplow_s',width:80,editor:{type:'textbox'}"><spring:message code="dynamicbalance.column.uplow_s" /></th>
				                    <!-- Total -->
				                    <th data-options="field:'total_s',width:80,editor:{type:'textbox'}"><spring:message code="dynamicbalance.column.total_s" /></th>
				                    <!-- RFV -->
				                    <th data-options="field:'rfv_s',width:80,editor:{type:'textbox'}"><spring:message code="dynamicbalance.column.rfv_s" /></th>
				                    <!-- RIH -->
				                    <th data-options="field:'rih_s',width:80,editor:{type:'textbox'}"><spring:message code="dynamicbalance.column.rih_s" /></th>
				                    <!-- LFV -->
				                    <th data-options="field:'lfv_s',width:80,editor:{type:'textbox'}"><spring:message code="dynamicbalance.column.lfv_s" /></th>
				                    <!-- CON -->
				                    <th data-options="field:'con_s',width:80,editor:{type:'textbox'}"><spring:message code="dynamicbalance.column.con_s" /></th>
				                   </tr>
				            </thead>
                </table>
	</div>

	<jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="Recipe_search_form" />
		<jsp:param name="datagridId" value="recipe_dg" />
		<jsp:param name="handlerClass"
			value="com.bluebirdme.mes.linglong.finalcheck.excel.RecipeExportHandler" />
		<jsp:param name="serviceName" value="RecipeItemServiceImpl" />
	</jsp:include>
</body>
</html>

