<!-- 
    作者      :王超
    时间      :2020-08-03 10:16:32 
    页面名称:工厂模型管理
    文件关联:
        RockWellFactoryModel.java
        RockWellFactoryModelController.java
        RockWellFactoryModelServiceImpl.java
        RockWellFactoryModelServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="rockwellfactorymodel.js.jsp"%>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true" style="width:100%">
	    <div class="easyui-layout" fit="true">
	        <div data-options="region:'west',split:true" style="width:40%;height:100%">
	            <%-- <form id="RockWellFactoryModel_search_form" class="form" >
	                <!-- 名称 -->
	                <spring:message code="rockwellfactorymodel.column.name" />：
	                <input name="filter[name]" id="name" type="text" class="easyui-textbox" data-options="label:''" >
	                <br>
	                <!-- 描述 -->
	                <spring:message code="rockwellfactorymodel.column.description" />：
	                <input name="filter[description]" id="description" type="text" class="easyui-textbox" data-options="label:''" >
	            </form> --%>
	            <auth:button code="rockwellfactorymodel.add"><a class="easyui-linkbutton btn-green" style="margin-top:8px;margin-left:8px;" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
	            <auth:button code="rockwellfactorymodel.edit"><a class="easyui-linkbutton btn-red" style="margin-top:8px;" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
	            <auth:button code="rockwellfactorymodel.remove"><a class="easyui-linkbutton btn-black" style="margin-top:8px;" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
	            <a class="easyui-linkbutton btn-yellow" style="margin-top:8px;" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
			    <hr style="height:1px;border:none;border-top:1px dashed #0066CC;" />
			    <div id="tree" style="width:100%">
					<ul id="tree_model" class="easyui-tree" data-options="
						onClick: clicktree,
						onSelect: selecttree,
						url:'mix/baseData/rockWellFactoryModel/factorymodeltree'">
					</ul>
	            </div>
	        </div>
	        <div data-options="region:'center',split:true" style="width:50%;">
		        <div class="easyui-layout" fit="true">
		            <div data-options="region:'north'" style="height:100%" title="节点信息" style="width:30%">
			            <div id="p" class="easyui-panel" style="width:100%;height:10%;padding:10px;background:#fafafa;" data-options="">   
						           名称 :<input  id="Infoname" type="text" class="easyui-textbox"  style="width:200px"  data-options="label:''" >
						           描述 :<input  id="Infodescription" type="text" class="easyui-textbox" style="width:200px" data-options="label:''" >
						    <auth:button code="rockwellfactorymodel.save1"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="savenamedescription()"><spring:message code="button.save" /></a></auth:button>
						</div>
					    <ul id="infoTypeList" class="easyui-datalist" title="节点类型" style="width:100%;height:85%"
						    data-options="checkbox:true">
		                    <li value="listroot">工厂</li>
		                    <li value="listsite">区域</li>
		                    <li value="listarea">工段</li>
		                    <li value="listproduction">产线</li>
		                    <li value="listworkcenter">工作中心</li>
		                    <li value="listfactherequipment">父设备</li>
		                    <li value="listchildequipment">子设备</li>
			            </ul>
					</div>
	            </div>
	        </div>
	    </div>
	    <div id="main_dlg" class="easyui-dialog" title="添加信息" style="width:400px;height:250px;"
	        data-options="
		        iconCls: 'icon-window',
		        buttons:'#main_dlg_btn',
		        onOpen:maindlgOpen,
		        closed:true">
	        <form class="form" id="user_form" action="user/save" method="post">
	            <input type="hidden" name="id" id="id">
	            <div class="form-row">
	                <input class="easyui-textbox" name="modelName" id="modelName" style="width:100%" data-options="label:'名称',required:true,validType:'length[1,80]'">
	            </div>
	            <div class="form-row">
	                <input class="easyui-textbox" name="modelDescription" id="modelDescription" style="width:100%" data-options="label:'描述',validType:'length[1,80]'">
	            </div>
	        </form>
	    </div>
	    <div id="main_dlg_btn">
	        <auth:button code="rockwellfactorymodel.save2"><a class="easyui-linkbutton btn-blue" iconCls="icon-ok"  onclick="addsave()">保存</a></auth:button>
	        <auth:button code="rockwellfactorymodel.cancel1"><a class="easyui-linkbutton btn-black" iconCls="icon-remove" onclick="addcancel()">取消</a></auth:button>
	    </div>
	    <div id="mainedit_dlg" class="easyui-dialog" title="编辑信息" style="width:400px;height:250px;"
	        data-options="
	            iconCls: 'icon-window',
	            buttons:'#mainedit_dlg_btn',
	            onOpen:maineditdlgOpen,
	            closed:true"> 
	        <form class="form" id="maineditdlg_form" action="user/save" method="post">
	            <input type="hidden" name="id" id="id">
	            <div class="form-row">
	                <input class="easyui-textbox" name="modelEditName" id="modelEditName" style="width:100%" data-options="label:'名称',required:true,validType:'length[1,80]'">
	            </div>
	            <div class="form-row">
	                <input class="easyui-textbox" name="modelEditDescription" id="modelEditDescription" style="width:100%" data-options="label:'描述',validType:'length[1,80]'">
	            </div>
	        </form>
	    </div>
	    <div id="mainedit_dlg_btn">
	        <auth:button code="rockwellfactorymodel.save3"><a class="easyui-linkbutton btn-blue" iconCls="icon-ok"  onclick="editsave()">保存</a></auth:button>
	        <auth:button code="rockwellfactorymodel.cancel2"><a class="easyui-linkbutton btn-black" iconCls="icon-remove" onclick="editcancel()">取消</a></auth:button>
	    </div>
	    <div id="w" class="easyui-window" title="确认提示" data-options="iconCls:'icon-save'" style="width:200px;height:150px;padding:5px;">
			<div class="easyui-layout" data-options="fit:true">
				<div data-options="region:'center'" style="padding:10px;">
					确定删除该节点吗？
				</div>
				<div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
					<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="removeconfirm()" style="width:80px">Ok</a>
					<a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="$('#w').window('close')" style="width:80px">Cancel</a>
				</div>
			</div>
		</div>
    </div>
</body>
</html>