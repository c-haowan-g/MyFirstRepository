<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../inc/meta.jsp"%>
<%@ include file="main.js.jsp"%>
<style>
.logo {
	display: inline-block;
	background: url(resources/images/logo.png);
	width: 255px;
	height: 33px;
	background-repeat: no-repeat;
	background-position: 50% 50%;
	background-size: 100% 100%;
	/* border-right: 1px solid #95b8e7; */
}

.l-btn:hover {
	background: none;
	border: none;
}

.bbm {
	display: inline-block;
	width: 600px;
	height: 30px;
	line-height: 30px;
	position: fixed;
	right: 2px;
	text-align: right;
}

.tabs {
	height: 28px !important;
}

@
keyframes changed { 0% {
	background: white;
}

50%
{
background


:


#95B8E7


;
}
100%
{
background


:white


;
}
}
.tabs li.tabs-selected a.tabs-inner {
	height: 27px !important;
	/* animation:changed 5s infinite; */
}

.accordion .accordion-header-selected {
	background: #e0ecff;
}

.tree-node-selected {
	background: #dceaff;
	color: #000000;
}

.tabs-inner {
	height: 27px !important;
}

.tabs li a.tabs-inner {
	border-radius: 3px 3px 0 0;
}

#mm1 {
	width: 90px !important;
}

.textbox {
	border: none;
}

.icon {
	display: inline-block;
	height: 32px;
	line-height: 32px;
	margin-top: 10px;
}

.image {
	display: inline-block;
	width: 32px;
	height: 32px;
	margin: 0;
}

.text {
	display: inline-block;
	height: 32px;
	line-height: 32px;
	margin: 0;
}

.textbox .textbox-bgicon {
	background-position: 3px center !important;
}
</style>
<body>
	<div class="easyui-layout" fit="true">
		<div data-options="region:'west',iconCls:'icon-func',border:true,title:'<spring:message code="functionarea" />'" id="func-block" style="width:261px;">
			<div class="easyui-accordion" fit="true" id="sys_menu" data-options="onAdd:initSubMenu" style="border:none;">
				<div data-options="collapsed:false,collapsible:false,border:false">
					<input class="easyui-combobox" id="fn_search" prompt="<spring:message code="searchMenu" />" style="width:100%;border:none;" editable="true"
						data-options="valueField:'id',
										textField:'text',
										hasDownArrow:false,
										border:false,
										filter:search,
										selectOnNavigation:false,
										onSelect:onSelect,
										panelHeight:200,
										icons:[
										   {iconCls:'icon-eraser',
										   handler:function(){
										       $('#fn_search').combobox('clear');
					    					   }
										   }
										]">
				</div>
			</div>
		</div>
		<div data-options="region:'north',border:false" style="height:40px;background: rgb(224, 236, 255);padding:3px;">
			<div class="logo"></div>
			<div class="bbm">
				<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-user'">${LOGIN_USER_NAME }</a> 
				<!--  <a href="#" id="isQORB" class="easyui-linkbutton" data-options="plain:true"></a>-->
				<a href="#" class="easyui-linkbutton" onclick="logout()" data-options="plain:true,iconCls:'icon-logout'">注销</a> 
				<a href="#" class="easyui-linkbutton" onclick="modifypassword()" data-options="plain:true,iconCls:'icon-password'">修改密码</a> 
					<input class="easyui-combobox" id="myShortcuts" style="width:250px;background:#e0ecff;"
					data-options="
	                    method:'get',
	                    valueField:'text',
	                    textField:'text',
	                    panelHeight:'auto',
	                    showItemIcon:true,
	                    onClick:openWin2,
	                    icons:[{
                            iconCls:'icon-more',
                            handler:function(){
                                openShortcutMgr();
                            }
	                    }],
	                    label: '<spring:message code="shutcut" />'
                    ">
			</div>
		</div>
		<div data-options="region:'center',border:false">
			<div class="easyui-tabs" id="content_tab" data-options="fit:true,tools:'#tab-tools',onContextMenu:showContextMenu">
				<div title="系统首页" style="padding:10px">系统首页</div>
			</div>
		</div>
		<div data-options="region:'south',border:false" style="height:20px;text-align: center;background: rgb(224, 236, 255);color: #29576d;"></div>
 		<div data-options="region:'south',border:false" style="height:20px;text-align: center;background: rgb(224, 236, 255);color: #29576d;">Powered By 山东玲珑轮胎股份有限公司</div>
 	</div>
	<div id="tab-tools">
		<a href="javascript:void(0)" title="刷新当前页" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-refresh'" onclick="refresh()"></a> <a href="javascript:void(0)" title="关闭当前页" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-no-black'" onclick="closeWindow()"></a>
		<!-- <a href="javascript:void(0)" title="新窗口打开" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-new-window'" onclick="newWindow()"></a> -->
		<a href="javascript:void(0)" title="全屏显示" id="fullScreenBtn" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-full-screen'" onclick="fullScreen()"></a> <a href="javascript:void(0)" title="查看帮助文档" id="fullScreenBtn" class="easyui-linkbutton"
			data-options="plain:true,iconCls:'icon-helper'" onclick="fullScreen()"></a>
	</div>
	<!-- icon-helper -->

	<!-- TAB右键点击菜单 -->
	<div id="mm" class="easyui-menu" oncontextmenu="return false;" style="width:150px;">
		<div id="mm-tabupdate" iconCls="icon-refresh" onclick="refresh(1)">刷新</div>
		<div class="menu-sep"></div>
		<div id="mm-tabclose" iconCls="icon-no" onclick="closeWindow(1)">关闭</div>
		<div id="mm-tabcloseall" iconCls="icon-close-all" onclick="closeAll()">全部关闭</div>
		<div id="mm-tabcloseother" iconCls="icon-close-others" onclick="closeOthers()">关闭其他</div>
		<div id="mm-tabcloseright" onclick="closeRight()">关闭右侧</div>
		<div id="mm-tabcloseleft" onclick="closeLeft()">关闭左侧</div>
		<div class="menu-sep"></div>
		<div id="mm-exit" iconCls="icon-new-window" onclick="newWindow(1)">新窗口打开</div>
	</div>
	<!-- 菜单树节点右击 -->
	<div id="mm2" class="easyui-menu" style="width:150px;">
		<div onclick="doAddToShortCut()" data-options="iconCls:'icon-gen'">
			<spring:message code="addToShortCut" />
		</div>
	</div>

	<div id="dlg" class="easyui-dialog" title="<spring:message code="modifypassword" />" style="width:400px;height:270px;padding:10px"
		data-options="
                closed:true,
                iconCls: 'icon-password',
                buttons: [{
                    iconCls:'icon-ok',
                    handler:function(){
                       doModifyPassword();
                    }
                },{
                   iconCls:'icon-cancel',
                   handler:function(){
                       $('#dlg').dialog('close');
                    }
                }]
            ">
		<form id="passwordform">
			<div style="margin-bottom:20px">
				<input class="easyui-passwordbox" id="old" name="old" style="width:100%" data-options="label:'<spring:message code="oldPassword" />',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-passwordbox" id="newPass" name="newPass" style="width:100%" data-options="label:'<spring:message code="newPassword" />',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-passwordbox" id="newPass_confirm" name="newPass_confirm" style="width:100%" data-options="label:'<spring:message code="confirmNewPassword" />',required:true">
			</div>
		</form>
	</div>

</body>
</html>
