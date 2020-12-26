
<!--     作者      :时永良
    时间      :2019-07-30 10:51:23 
    页面名称:工厂模型表
    文件关联:
        RockWellFactoryModel.java
        RockWellFactoryModelController.java
        RockWellFactoryModelServiceImpl.java
        RockWellFactoryModelServiceImpl.xml -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/meta.jsp"%>
<%@ include file="rockwellfactorymodel.js.jsp"%>

<body class="easyui-layout" fit="true"> 
   <div data-options="region:'center',split:true" style="width:100%">
    <div class="easyui-layout" fit="true">
         <div data-options="region:'west',split:true" style="width:40%;height:100%">
	            <div id="RockWellFactoryModel_search_form" class="form" >
		            <auth:button code="rockwellfactorymodel_add"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
		            <auth:button code="rockwellfactorymodel_edit"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
		            <auth:button code="rockwellfactorymodel_delete"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
	            </div> 
			    <hr style="height:1px;border:none;border-top:1px dashed #0066CC;" />
			    <div id="tree" style="width:100%">
					<ul id="tree_model" class="easyui-tree" data-options="
						onClick: clicktree,
						onSelect:selecttree,
						url:'common/basedata/factorymodel/factorymodeltree'">
					</ul>
				</div>  

         </div>
          <div data-options="region:'center',split:true" style="width:50%;">
           <div class="easyui-layout" fit="true">
           <div data-options="region:'north'" style="height:100%" title="节点信息"style="width:30%">
           
             <div id="p" class="easyui-panel"     
			        style="width:100%;height:10%;padding:10px;background:#fafafa;"   
			        data-options="">   
			           名称 :<input  id="Infoname" type="text" class="easyui-textbox"  style="width:200px"  data-options="label:''" >
			           描述 :<input  id="Infodescription" type="text" class="easyui-textbox" style="width:300px" data-options="label:''" >
				 <auth:button code="rockwellfactorymodel_save"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="savenamedescription()"><spring:message code="button.save" /></a></auth:button>
			 </div>
			      <ul id="infoTypeList" class="easyui-datalist"  style="width:100%;height:85%"
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
                closed:true
            ">
            
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
        <a class="easyui-linkbutton btn-blue" iconCls="icon-ok"  onclick="addsave()">保存</a>
        <a class="easyui-linkbutton btn-black" iconCls="icon-remove" onclick="addcancel()">取消</a>
    </div>
    
    
        <div id="mainedit_dlg" class="easyui-dialog" title="编辑信息" style="width:400px;height:250px;"
            data-options="
                iconCls: 'icon-window',
                buttons:'#mainedit_dlg_btn',
                onOpen:maineditdlgOpen,
                closed:true
            ">
            
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
        <a class="easyui-linkbutton btn-blue" iconCls="icon-ok"  onclick="editsave()">保存</a>
        <a class="easyui-linkbutton btn-black" iconCls="icon-remove" onclick="editcancel()">取消</a>
    </div>
    
    
  </div>
</body>
</html>
