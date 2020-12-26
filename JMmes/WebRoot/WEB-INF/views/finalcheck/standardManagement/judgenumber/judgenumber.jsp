<!-- 

    作者      :李迺锟+刘朋
    时间      :2018-11-13 13:24:54 
    页面名称:动平衡检测配套标准表
    文件关联:
        JudgeNumber.java
        JudgeNumberController.java
        JudgeNumberServiceImpl.java
        JudgeNumberServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="judgenumber.js.jsp"%>
<script type="text/javascript" src="dict/253,254.js"></script>
<style type="text/css">
.columnTitle {
	padding: 6px 10px
}
</style>
<body class="easyui-layout" fit="true"> 
  <div data-options="region:'north',split:true" style="height:250px;">  
     <div id="JudgeNumber_dg_toolbar">
            <form id="JudgeNumber_search_form" class="form" >
	            <td class="columnTitle">
                 <input name="filter[enttype_s]" id="enttype_s"  type="hidden"  value="254004" data-options="label:''" >
				</td>
				 <td class="columnTitle">
				 <spring:message code="judgenumber.column.judgeno_s" />:
                <!-- 检测标准编号 -->
                <input name="filter[judgeno_s]" id="judgeno_s" type="text" class="easyui-textbox" data-options="label:''" >
                </td>
                 <td class="columnTitle">
                 <spring:message code="judgenumber.column.remark_s" />:
                <!-- 规格备注 -->
                <input name="filter[remark_s]" like="true" id="remark_s" type="text" class="easyui-textbox" data-options="label:''" >
                <spring:message code="materials.column.materialcode_s" />:
                <!-- 物料编码 -->
				<input name="filter[itemid_s]" id="itemid_s"  type="text"  class="easyui-textbox" style="width:100px" data-options="label:''">
                </td>
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="ZJ_BZGL_JCPTBZ_ADD"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="ZJ_BZGL_JCPTBZ_EDIT"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="ZJ_BZGL_JCPTBZ_REMOVE"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            <auth:button code="ZJ_BZGL_JCPTBZ_SAVE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="ZJ_BZGL_JCPTBZ_CANCEL"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
        </div>
        <table id="judgenumber_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                singleSelect: true,
                toolbar: '#JudgeNumber_dg_toolbar',
                url: '',
                onSelect:filterNumberRow,
                striped:true,
                method: 'get',
                idField:'atr_key',
                emptyMsg:'暂无数据'
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 设备类型 -->
                    <th data-options="field:'enttype_s',width:80,formatter:entTypeFormatter"><spring:message code="judgenumber.column.enttype_s" /></th>
                    <!-- 检测标准编号 -->
                    <th data-options="field:'judgeno_s',width:80"><spring:message code="judgenumber.column.judgeno_s" /></th>
                    <!-- 该标准编号下的规格数 -->
                    <th data-options="field:'itemcount_s',width:80"><spring:message code="judgenumber.column.itemcount_s" /></th>
                    <!-- 规格备注 -->
                    <th data-options="field:'remark_s',width:80,editor:{type:'textbox'}"><spring:message code="judgenumber.column.remark_s" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changed_by_s',width:80"><spring:message code="judgenumber.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',width:80"><spring:message code="judgenumber.column.changed_time_t" /></th>
                </tr>
            </thead>
        </table>
     </div>
      <div data-options="region:'center',split:true" >
	      <div class="easyui-layout" fit="true">
	          <div data-options="region:'west',split:true" style="width:30%;">
			        <div id="JudgeNumberGrade_dg_toolbar">
						<form id="JudgeNumberGrade_search_form" class="form" >
						</form> 
						<auth:button code="ZJ_BZGL_JCPTBZGRADE_ADD"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="addgrade()"><spring:message code="button.add" /></a></auth:button>
						<auth:button code="ZJ_BZGL_JCPTBZGRADE_EDIT"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="editgrade()"><spring:message code="button.edit" /></a></auth:button>
						<auth:button code="ZJ_BZGL_JCPTBZGRADE_REMOVE"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="removegrade()"><spring:message code="button.delete" /></a></auth:button>
						<auth:button code="ZJ_BZGL_JCPTBZGRADE_CANCEL"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-no'" onclick="cancelgrade()"><spring:message code="button.cancel" /></a></auth:button>
						<auth:button code="ZJ_BZGL_JCPTBZGRADE_SAVE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="savegrade()"><spring:message code="button.save" /></a></auth:button>
						</div>
					<table id="judgenumbergrade_dg" class="easyui-datagrid" style="width:100%"
						data-options="  
							fit:true,
							fitColumns:true,
							singleSelect: false,
							toolbar: '#JudgeNumberGrade_dg_toolbar',
							url: '',
							striped:true,
							method: 'get',
							emptyMsg:'暂无数据' 
							">
						<thead>
							<tr>
								<th data-options="field:'atr_key',checkbox:true"></th>
								<!-- 动平衡检测结果质量等级-->
								 <th data-options="field:'cegradecode_s',width:80,formatter:codeFormatter,editor:{type:'combobox',options:
	                                {valueField:'GRADECODE_I',
	                                textField:'GRADEDESC_S',
	                                required:true,
	                                method:'get',
	                                url:'finalcheck/reportCenter/JudgeNumberGrade/comboxDynamicGrade'}}"><spring:message code="judgenumbergrade.column.cegradecode_s" /></th>
								<!-- 动平衡机下发等级（1，2，3，4，5..） -->
								<th data-options="field:'machinegradecode_s',width:80,editor:{type:'combobox',options:{valueField:'DBCODE',
	                                textField:'SHOWVALUE',
	                                method:'get',
	                                url:'finalcheck/reportCenter/JudgeNumberGrade/comboxMachineGrade',
	                                required:true}}"><spring:message code="judgenumbergrade.column.machinegradecode_s" /></th>
								</tr>
						</thead>
					</table>  
	          </div> 
	          <div data-options="region:'center',split:true" >
			       	<div id="JudgeNumberItem_dg_toolbar">
					<form id="JudgeNumberItem_search_form" class="form" >
					</form> 
					<auth:button code="ZJ_BZGL_JCPTBZITEM_ADD"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="addItem()"><spring:message code="button.add" /></a></auth:button>
					<auth:button code="ZJ_BZGL_JCPTBZITEM_REMOVE"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="removeItem()"><spring:message code="button.delete" /></a></auth:button>
					<auth:button code="ZJ_BZGL_JCPTBZITEM_SAVE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="saveItem()"><spring:message code="button.save" /></a></auth:button>
					</div>
					<table id="judgenumberitem_dg" class="easyui-datagrid" style="width:100%"
						data-options="  
							fit:true,
							fitColumns:true,
							singleSelect:true,
							toolbar: '#JudgeNumberItem_dg_toolbar',
							url: '',
							striped:true,
							method: 'get',
							emptyMsg:'暂无数据'  
							">
						<thead>
							<tr>
								<th data-options="field:'atr_key',checkbox:true"></th>
								<!-- 配方号 -->
								<th data-options="field:'recipeno_s',width:30,editor:{type:'textbox'}"><spring:message code="judgenumberitem.column.recipeno_s" /></th>
								<!-- 物料编码 -->
								<th data-options="field:'itemid_s',width:40,editor:{type:'textbox'}"><spring:message code="judgenumberitem.column.itemid_s" /></th>
								<!-- 物料描述 -->
								<th data-options="field:'itemdesc_s',width:120,editor:{type:'textbox'}"><spring:message code="judgenumberitem.column.itemdesc_s" /></th>
								</tr>
						</thead>
					</table>  
	         </div> 
	         
	      </div> 
	      
	      	<div id="menu_dlg" class="easyui-dialog" title="新增"
				style="width:65%;height:80%;"
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
		                        saveToItem();
		                    }
		                },{
		                    text:'取消',
		                     iconCls:'icon-cancel',
		                    handler:function(){
		                        cancelToItem();
		                    }
		                }]
		                ">
		                
		        <table id="material_dg" class="easyui-datagrid" style="width:100%">
					<thead>
						<tr>
							<th data-options="field:'ATR_KEY',checkbox:true"></th>
							<!-- 配方号 -->
							<th
								data-options="field:'RECIPENO_S',width:50,editor:{type:'textbox',options:{required:true}}"><spring:message
									code="materials.column.recipe_no_s" /></th>
							<!-- 品号 -->
							<th
								data-options="field:'MATERIALCODE_S',width:80,editor:{type:'textbox',options:{required:true}}"><spring:message
									code="materials.column.materialcode_s" /></th>
							<!-- 物料描述 -->
							<th
								data-options="field:'MATERIALDESC_S',editor:{type:'textbox',options:{required:true}}"><spring:message
									code="materials.column.materialdesc_s" /></th>
							<!-- 花纹 -->
							<th
								data-options="field:'PATTERN_S',width:80,editor:{type:'textbox',options:{required:true}}"><spring:message
									code="materials.column.pattern_s" /></th>
							<!-- 层级 -->
							<th
								data-options="field:'CJ_S',width:50,editor:{type:'textbox',options:{required:true}}"><spring:message
									code="materials.column.cj_s" /></th>
						</tr>
					</thead>
				</table>
			</div>
	
      </div> 
</body>

</html>
