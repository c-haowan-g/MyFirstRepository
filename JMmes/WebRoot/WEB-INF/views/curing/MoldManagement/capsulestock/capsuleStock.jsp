<!-- 

    作者      :刘朋
    时间      :2018-08-01 17:56:14 
    页面名称:胶囊库存管理
    文件关联:
        CapsuleStock.java
        CapsuleStockController.java
        CapsuleStockServiceImpl.java
        CapsuleStockServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="capsuleStock.js.jsp"%>
<!-- 下拉框引入 -->
<script type="text/javascript" src="dict/204.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="query_bar">
	        <form id="CapsuleStock_form" class="form"  >
                <!-- 厂商 -->
                <spring:message code="capsulestock.column.capsule_factory_s" />：
                <input name="filter[capsule_factory_s]" id="capsule_factory_s" style="width:180px" type="text" class="easyui-combotree" data-options="label:'',
                  labelWidth:'auto',
                  editable:'true',
				  panelWidth:'180',
				  required:false,
				  url:'dict/code/204',
				  method:'get',
				  label:''" >
				<!-- 胶囊规格 -->
				<spring:message code="capsulestockq.column.capsule_code_s" />：
                <input name="filter[capsule_code_s]" id="capsule_code_s" type="text" class="easyui-combobox"
					data-options="valueField:'CAPSULE_SPEC_S',
            			textField:'CAPSULE_SPEC_S',
                        required:false, 
                        url:'lh/kcgl/jnkc/comboxCapsule_spec',
						method: 'get',
					    editable:'true',
					    limitToList:false,
					    panelHeight:200">
                <!-- 物料编码 -->
                <spring:message code="capsulestockq.column.material_code_s" />：
                <input name="filter[material_code_s]" id="material_code_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 胶囊校验位码 -->
                <spring:message code="capsulestockq.column.parity_code_s" />：
                <input name="filter[parity_code_s]" id="parity_code_s" type="text" class="easyui-textbox" data-options="label:''" >
	        </form> 
        </div>
        <div style="border:none,padding:2px,margin:3px">
		   <div id="dg_toolbar" style="padding:2px">
	          <auth:button code="LH_KCGL_JNKCGL_ADD"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
	          <auth:button code="LH_KCGL_JNKCGL_EDIT"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
	          <auth:button code="LH_KCGL_JNKCGL_DELETE"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
	          <auth:button code="LH_KCGL_JNKCGL_SAVE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
	          <auth:button code="LH_KCGL_JNKCGL_CANCEL"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a> </auth:button> 
    	      <%-- <auth:button code="LH_KCGL_JNKCGL_IMPORT"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-excel'" onclick="$_import()"><spring:message code="button.import" /></a></auth:button> --%>
	          <auth:button code="LH_KCGL_JNKCGL_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
	          <auth:button code="LH_KCGL_JNKCGL_STOCK"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-search'" onclick="countStock()"><spring:message code="button.stock" /></a></auth:button>
	          <auth:button code="LH_KCGL_JNKCGL_SEARCH"><a id="condition_button" class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="queryBar()"><spring:message code="button.searchColumn" /></a></auth:button> 
	          <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="doSearch()"><spring:message code="button.search" /></a>
	        </div>
		</div>
       <table class="easyui-datagrid" style="width:80%" id="dg"
		data-options="
	          fit:true,
	          fitColumns:false,
	          pagination:true,
	          rownumbers:true,
	          singleSelect:false,
              url: 'lh/kcgl/jnkc/getCapsuleStock',
              striped:true,
              method: 'get',
               emptyMsg:'<span><spring:message code='tip.noData'/></span>',
           	  striped:true,
              toolbar:'#dg_toolbar,#query_bar',
                ">
            <thead>
                <tr>
                	<!-- atr_key唯一性编码 -->
                	<th data-options="field:'atr_key',checkbox:true">ID</th>
                	 <!-- 胶囊规格 -->
                    <th data-options="field:'capsule_code_s',width:150"><spring:message code="capsulestock.column.capsule_code_s" /></th>			
                    <!-- 厂商 -->
                   <th data-options="field:'capsule_factory_s',width:120,formatter:codeFormatter,editor:{type:'combotree',options:{
                    			method:'get',
                                url:'dict/code/204',
                                editable:'true',
                                panelWidth:'300',
                    			required:true,
                    			}}"><spring:message code="capsulestock.column.capsule_factory_s" /></th>
                    <!-- 胶囊批次号 -->
                    <th data-options="field:'capsule_id_s',editor:{type:'textbox'}"><spring:message code="capsulestock.column.capsule_id_s" /></th>			
                    
                    <!-- 物料编号 -->
                    <th data-options="field:'material_code_s',editor:{type:'textbox'}"><spring:message code="capsulestock.column.material_code_s" /></th>
                    <!-- 胶囊校验位码 -->
                    <th data-options="field:'parity_code_s',editor:{type:'textbox'}"><spring:message code="capsulestock.column.parity_code_s" /></th>
                    <!-- 入库数量 -->
                    <th data-options="field:'num_purchase_i',width:80,editor:{type:'numberbox',options:{precision:0,required:true,
	                    onChange:function(value){
	                    var k=$(this).parents('[datagrid-row-index]').attr('datagrid-row-index');
				        var td=$('.datagrid-body td[field=\'num_surplus_i\']')[k];
				        var input = $(td).find('input')[0];
				        $(input).textbox('setValue',value);
                    }
                    }}"><spring:message code="capsulestock.column.num_purchase_i" /></th>
                    <!-- 剩余数量 -->
                    <th data-options="field:'num_surplus_i',width:80,editor:{type:'numberbox',options:{precision:0,disabled:true}}"><spring:message code="capsulestock.column.num_surplus_i" /></th>
                    <!-- 存放位置 -->
                    <th data-options="field:'store_place_s',width:120,editor:{type:'combobox',
                    			options:
                                {required:true,
                                valueField:'INVENTORY_BARCODE_S',
                                textField:'INVENTORY_BARCODE_S',
                                editable:'true',	
                                panelHeight:300,
                                limitToList:'false',
                                panelWidth:300,
                                method:'get',
                                url:'lh/kcgl/jnkc/CapsuleLocation',
                                filter: function(q, row){  
							        var opts = $(this).combobox('options');  
							        return row[opts.textField].indexOf(q) >= 0;//这里改成>=即可在任意地方匹配  
							    },  
                               }}"><spring:message code="capsulestock.column.store_place_s" /></th>
                    
                    <!-- 入库时间 -->
                    <th data-options="field:'use_time_t',editor:{}"><spring:message code="capsulestock.column.use_time_t" /></th>
                    <!-- 入库人 -->
                    <th data-options="field:'created_by',editor:{}"><spring:message code="capsulestock.column.user_id_s" /></th>
                    <!-- 更新人 -->
                    <th data-options="field:'changed_by'"><spring:message code="capsulestock.column.changed_by_s" /></th>
                    <!-- 更新时间 -->
                    <th data-options="field:'changed_time_t'"><spring:message code="capsulestock.column.changed_time_t" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by'"><spring:message code="capsulestock.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t'"><spring:message code="capsulestock.column.created_time_t" /></th>
                </tr> 
            </thead>
        </table>
    </div>
	<!--导入 -->
    <jsp:include page="../../../../inc/import.jsp">
        <jsp:param name="callBackFuncName" value="importCallback"/>
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.lh.ExcelHandler.CapsuleStockImportHandler" />
	</jsp:include>
	<!-- 导出 -->
     <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="CapsuleStock_form" />
		<jsp:param name="datagridId" value="dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.lh.ExcelHandler.CapsuleStockExportHandler" />
		<jsp:param name="serviceName" value="CapsuleStockServiceImpl" />
	</jsp:include>
	
	<div id="w" class="easyui-window" title="胶囊即时库存查询" data-options="modal:true,closed:true,iconCls:'icon-search'" style="width:80%;height:60%;padding:10px;">
    <table id="stock_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                rownumbers: true,
                singleSelect: false,
                url: 'lh/kcgl/jnkc/countStock',
                striped:true,
                method: 'get', 
                emptyMsg:'暂无数据',
                onLoadSuccess : function(data) {
				$('#stock_dg').datagrid('enableFilter');
			}
                ">
            <thead>
                <tr>
                    <!-- 厂商 -->
                   <th data-options="field:'CAPSULE_FACTORY_S',width:150,formatter:codeFormatter,editor:{type:'combotree',options:{
                    			method:'get',
                    			editable:'true',
                                url:'dict/code/204',
                    			required:true}}"><spring:message code="capsulestock.column.capsule_factory_s" /></th>
                   <!-- 胶囊校验位码 -->
                   <th data-options="field:'PARITY_CODE_S',width:100"><spring:message code="capsulestock.column.parity_code_s" /></th>
                    <!-- 胶囊规格 -->
                   <th data-options="field:'CAPSULE_CODE_S',width:260"><spring:message code="capsulestock.column.capsule_code_s" /></th>			
                   <!-- 入库数量 -->
                    <th data-options="field:'COUNT_NUM',width:100"><spring:message code="capsulestock.column.count_num" /></th>
                </tr>
            </thead>
        </table>
        </div>
</body>
</html>
