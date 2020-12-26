<!-- 

    作者      :陈国强
    时间      :2020-09-07 16:14:36 
    页面名称:PLM密炼配方洗车规则表
    文件关联:
        CarWash.java
        CarWashController.java
        CarWashServiceImpl.java
        CarWashServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/meta.jsp"%>
<%@ include file="carwash.js.jsp"%>
<script type="text/javascript" src="dict/-342.js"></script>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="CarWash_dg_toolbar">
            <form id="CarWash_search_form" class="form" >
                <!-- 生产配方编号 -->
                <spring:message code="carwash.column.recipe_name_s" />
                <input name="filter[recipe_code_s]" id="recipe_name_s" type="text" class="easyui-combobox"
                 data-options="label:'',
                       				required:false,
                      		 		data:recipeName,
		               				method: 'get',
		               				panelHeight:'200',
		               				valueField:'RECIPE_CODE_S',
		               				textField:'RECIPE_CODE_NAME_S'">
                <!-- 洗车配方编号，操作符0时清空 -->
                <spring:message code="carwash.column.recipe_name_carwash_s" />
                <input name="filter[recipe_code_carwash_s]" id="recipe_name_carwash_s" type="text" class="easyui-combobox" 
                data-options="label:'',
                      				required:false,
                                    data:recipeName,
		                            method: 'get',
		                            panelHeight:'200',
		                            valueField:'RECIPE_CODE_NAME_S',
		                            textField:'RECIPE_CODE_NAME_S'">
                <!-- 生产配方编号 -->
                <spring:message code="carwash.column.recipe_code_s" />
                <input name="filter[recipe_code_s]" id="recipe_code_s" type="text" class="easyui-textbox" data-options="label:''" ><br>
                <!-- 洗车配方编号，操作符0时清空 -->
                <spring:message code="carwash.column.recipe_code_carwash_s" />
                <input name="filter[recipe_code_carwash_s]" id="recipe_code_carwash_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 操作符：0-无洗车要求、1-后洗车、2-前洗车 -->
                <spring:message code="carwash.column.sign_s" />
                <input name="filter[sign_s]" id="sign_s" type="text" class="easyui-combobox" 
                data-options="labelWidth:'auto',
                                            panelHeight:100,
										    required:false,
										    editable:false,
										    data:[
										    {text:'无洗车要求',value:'0'},
					                         {text:'后洗车',value:'1'},
					                         {text:'前洗车',value:'2'}
					                         ],
										    textField:'text',
										    valueField:'value',
										    method:'get'">
                
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="SYS_JCSJWH_PLMCARWASH_ADD"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="SYS_JCSJWH_PLMCARWASH_EDIT"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="SYS_JCSJWH_PLMCARWASH_REMOVE"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            　
            <auth:button code="SYS_JCSJWH_PLMCARWASH_SAVE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="SYS_JCSJWH_PLMCARWASH_CANCEL"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            　
            <auth:button code="SYS_JCSJWH_PLMCARWASH_START"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-shenhe'" onclick="start()">启用</a></auth:button>
			<auth:button code="SYS_JCSJWH_PLMCARWASH_STOP"><a class="easyui-linkbutton btn-red"data-options="iconCls:'icon-fanshenhe'" onclick="stop()">停用</a></auth:button>
        </div>
        <table id="carwash_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#CarWash_dg_toolbar',
                url: 'common/plm/CarWash/datagridUDA',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 是否启用：0-启用、1-停用 -->
                    <th data-options="field:'carwash_status_s',formatter:sendstateFormatter"><spring:message code="carwash.column.carwash_status_s" /></th>
                    <!-- 生产配方名称 -->
                    <th data-options="field:'recipe_name_s',editor:{type:'combobox',options:{
										  required:true,
										  editable:false,
										  panelHeight:100,
										  disabled:false,
					                      data:recipeName,
					                      textField:'RECIPE_CODE_NAME_S',
					                      valueField:'RECIPE_CODE_NAME_S',
					                      onSelect:onRecipeName
					                      }}" style="width: 100px;"><spring:message code="carwash.column.recipe_name_s" /></th>
                    <!-- 操作符：0-无洗车要求、1-后洗车、2-前洗车 -->
                    <th data-options="field:'sign_s',formatter:codeFormatter,
                    					editor:{type:'combobox',options:{
										required:true,
										editable:false,
										disabled:false,
					                    data:[{text:'无洗车要求',value:'0'},
					                         {text:'后洗车',value:'1'},
					                         {text:'前洗车',value:'2'}
					                         ],
					                    textField:'text',
					                    valueField:'value',
					                    onSelect:onCarWash
					                      }}" style="width: 100px;"><spring:message code="carwash.column.sign_s" /></th>
                    <!-- 洗车配方名称，操作符0时清空 -->
                    <th data-options="field:'recipe_name_carwash_s',
                    						editor:{type:'combobox',options:{
										  	required:true,
										  	editable:false,
										  	panelHeight:100,
										  	disabled:false,
					                      	data:recipeName,
					                      	textField:'RECIPE_CODE_NAME_S',
					                      	valueField:'RECIPE_CODE_NAME_S',
					                      	onSelect:onWashRecipeName
					                      }}" style="width: 100px;"><spring:message code="carwash.column.recipe_name_carwash_s" /></th>
                    <!-- 洗车数：必须大于或等于2，操作符0时清空 -->
                    <th data-options="field:'carwash_num_i',editor:{type:'textbox'}"><spring:message code="carwash.column.carwash_num_i" /></th>
                    <!-- 生产配方编号 -->
                    <th data-options="field:'recipe_code_s',editor:{type:'textbox'}"><spring:message code="carwash.column.recipe_code_s" /></th>
                    <!-- 洗车配方编号，操作符0时清空 -->
                    <th data-options="field:'recipe_code_carwash_s',editor:{type:'textbox'}"><spring:message code="carwash.column.recipe_code_carwash_s" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_s'"><spring:message code="carwash.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t'"><spring:message code="carwash.column.created_time_t" /></th>
                    <!-- 修改人姓名 -->
                    <th data-options="field:'changed_name_s'"><spring:message code="carwash.column.changed_name_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t'"><spring:message code="carwash.column.changed_time_t" /></th>
                    <!-- 备用1 -->
                    <th data-options="field:'dummy1_s',editor:{type:'textbox'}"><spring:message code="carwash.column.dummy1_s" /></th>
                    <!-- 备用2 -->
                    <th data-options="field:'dummy2_s',editor:{type:'textbox'}"><spring:message code="carwash.column.dummy2_s" /></th>
                    <!-- 备用3 -->
                    <th data-options="field:'dummy3_s',editor:{type:'textbox'}"><spring:message code="carwash.column.dummy3_s" /></th>
                    <!-- 备用4 -->
                    <th data-options="field:'dummy4_s',editor:{type:'textbox'}"><spring:message code="carwash.column.dummy4_s" /></th>
                    <!-- 备用5 -->
                    <th data-options="field:'dummy5_s',editor:{type:'textbox'}"><spring:message code="carwash.column.dummy5_s" /></th>
                    
                </tr>
            </thead>
        </table>
    </div>
</body>
</html>
