<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	var menus, pages;

	//半钢全钢判断
	function isBOrQ(value)
	{
		$("#isQORB").css({"vertical-align":"center","line-height":"20px"});
		if(value == "1")
		{
			$("#isQORB").text("(全钢)");
		}
		else if(value == "2")
		{
			$("#isQORB").text("(半钢)");
		}
	}
	//添加选项卡
	function addTab(title, url, iconCls) {
		setTimeout(function(){
			if ($('#content_tab').tabs('exists', title)) {
	            $('#content_tab').tabs('select', title);
	        } else {
	            var content = '<iframe scrolling="auto" frameborder="0"  src="'
	                    + url + '" style="width:100%;height:100%;"></iframe>';
	            $('#content_tab').tabs('add', {
	                title : title,
	                content : content,
	                iconCls : iconCls
	            });
	        }
		},0);
	}

	var isFullScreen = 0;

	function fullScreen() {
		if (isFullScreen == 1) {
			exitFullScreen();
			return;
		}
		var elem = document.body;
		if (elem.webkitRequestFullScreen) {
			elem.webkitRequestFullScreen();
		} else if (elem.mozRequestFullScreen) {
			elem.mozRequestFullScreen();
		} else if (elem.requestFullScreen) {
			elem.requestFullscreen();
		} else {
			notice
					.notice_show("浏览器不支持全屏API或已被禁用", null, null, null, true,
							true);
		}
		isFullScreen = 1;
	}
	function exitFullScreen() {
		var elem = document;
		if (elem.webkitCancelFullScreen) {
			elem.webkitCancelFullScreen();
		} else if (elem.mozCancelFullScreen) {
			elem.mozCancelFullScreen();
		} else if (elem.cancelFullScreen) {
			elem.cancelFullScreen();
		} else if (elem.exitFullscreen) {
			elem.exitFullscreen();
		} else {
			notice
					.notice_show("浏览器不支持全屏API或已被禁用", null, null, null, true,
							true);
		}
		isFullScreen = 0;
	}

	function showContextMenu(e, title, index) {
		e.preventDefault();
		if (index > 0) {
			$('#mm').menu('show', {
				left : e.pageX,
				top : e.pageY
			}).data("tabIndex", index);
		}
	}
	
	function toTree(array,idKey,textKey,parentKey,state){
	    
	    function getChildren(data, idValue) {
	        var children = [];
	        for (var i = 0; i < data.length; i++) {
	            if (data[i][parentKey] == idValue) {
	                data[i].text = data[i][textKey];
	                data[i].id = data[i][idKey];
	                if(data[i].type==1){
	                	data[i].state ="closed";
	                }
	                data[i].children = getChildren(data, data[i][idKey]);
	                children.push(data[i]);
	            }
	        }
	        return children;
	    }
	    
	    return getChildren(array, null);
	}

	function permission() {
		ext.ajax.get("permission", function(data) {
			menus = toTree(data.data, "id", "name" + getLanguageSuffix(),
					"pid", "open");
			pages = [];
			Utils.each(data.data, function(i, obj) {
				if (obj.type == 2) {
					pages.push({
						id : obj.id,
						text : obj["name" + getLanguageSuffix()],
						url : obj.url,
						index : obj.pinYinIndex
					});
				}
			});
			$("#fn_search").combobox("loadData", pages);
			Utils.each(menus, function(i, e) {
				$("#sys_menu").accordion("add", {
					title : e["name" + getLanguageSuffix()],
					content : '',
					iconCls : e.iconCls,
					selected : false
				});
			});
			$("#sys_menu").accordion("select", 1);
		});
	}

	function initSubMenu(title, index) {
		var tree = $("<ul id='sub_tree_"+index+"'></ul>");
		$("#sys_menu")
				.accordion("getPanel", index)
				.panel("body")
				.append(
						"<ul class='easyui-tree' data-options='onClick:openWin,animate:true,lines:false,onContextMenu:addToShortCut' id='sub_tree_"+index+"'></ul>");
		$("#sub_tree_" + index).tree({
			data : menus[index - 1].children
		});
	}

	function addToShortCut(e, node) {
		e.preventDefault();
		if (node.type != 2) {
			return false;
		}
		$('#mm2').menu('show', {
			left : e.pageX,
			top : e.pageY
		}).data("mid", node.id);
	}

	function doAddToShortCut() {

		var mid = $("#mm2").data("mid");

		var setting = {};
		setting.settingType = "SHORT_CUT";
		setting.settingKey = "SHORT_CUT";
		setting.settingValue = mid;

		ext.ajax.post("user/settings/shortcut", setting, function(data) {
			$("#mm2").menu("close");
		});

	}

	function openWin(node) {
		if (node.type == 2) {
			addTab(node.text, node.url, node.iconCls);
		}else{
			$(this).tree("toggle",node.target)
		}
	}
	function openWin2(node) {
        addTab(node.text, node.url, node.iconCls);
    }

	$(document).ready(function() {
		permission();
		loadShortcuts();
		isBOrQ(${FACTORY});
	});

	function openShortcutMgr() {

		addTab("<spring:message code="shortcut" />",
				"view?page=common/shortcut", "icon-more");

	}

	function loadShortcuts() {
		log(123)
		ext.ajax.get("user/settings/shortcut", function(data) {
			if (data.code == OK) {
				var list = [];
				Utils.each(data.data, function(i, d) {
					list.push({
						text : d["name" + getLanguageSuffix()],
						url : d["url"],
						iconCls : d["iconCls"]
					});
				})
				$("#myShortcuts").combobox("loadData", list);

			}
		});
	}

	function refresh(action) {

		var tab, title;

		if (action == 1) {
			tab = $("#content_tab").tabs("getTab", $('#mm').data("tabIndex"));
		} else {
			tab = $("#content_tab").tabs("getSelected");
		}

		title = tab.panel('options').tab.text();

		if ("系统首页" != title) {
			var url = $(tab.panel('options').content).attr('src');
			$('#content_tab')
					.tabs(
							'update',
							{
								tab : tab,
								options : {
									content : '<iframe scrolling="auto" frameborder="0"  src="'
											+ url
											+ '" style="width:100%;height:100%;"></iframe>'
								}
							});
		}
	}

	function newWindow(action) {
		var tab, title;

		if (action == 1) {
			tab = $("#content_tab").tabs("getTab", $('#mm').data("tabIndex"));
		} else {
			tab = $("#content_tab").tabs("getSelected");
		}

		title = tab.panel('options').tab.text();

		if ("系统首页" != title) {
			var url = $(tab.panel('options').content).attr('src');
			window.open(url);
		}
	}

	function closeWindow(action) {

		if (action == 1) {
			$("#content_tab").tabs("close", $('#mm').data("tabIndex"));
			return;
		}

		var tab = $("#content_tab").tabs("getSelected");
		index = $("#content_tab").tabs("getTabIndex", tab);

		$("#content_tab").tabs("close", index);

	}

	function closeOthers() {
		closeRight();
		closeLeft();
	}

	function closeAll() {

		var tabs = $("#content_tab").tabs("tabs");
		var currentIndex = $('#mm').data("tabIndex");
		for (var i = tabs.length - 1; i > 0; i--) {
			$("#content_tab").tabs("close", i);
		}

	}

	function closeLeft() {
		var currentIndex = $('#mm').data("tabIndex");
		for (var i = currentIndex - 1; i >= 1; i--) {
			$("#content_tab").tabs("close", i);
		}
	}

	function closeRight() {
		var tabs = $("#content_tab").tabs("tabs");
		var currentIndex = $('#mm').data("tabIndex");
		for (var i = tabs.length - 1; i > currentIndex; i--) {
			$("#content_tab").tabs("close", i);
		}
	}

	function search(q, row) {

		return row.text.indexOf(q) >= 0
				|| row.index.toUpperCase().indexOf(q.toUpperCase()) >= 0;

	}

	function onSelect(record) {
		addTab(record.text, record.url);
	}

	function logout() {
		$.messager.confirm('注销提示', '确认注销？', function(r) {
			if (r) {
				location.href = "login/out";
			}
		});
	}

	function modifypassword() {
		$("#dlg").dialog("open");
		$("#passwordform").form("clear");
	}

	function doModifyPassword() {

		if (!$("#passwordform").form("validate")) {
			return;
		}

		var old = $("#old").passwordbox("getValue");
		var newPass = $("#newPass").passwordbox("getValue");
		var newPass_confirm = $("#newPass_confirm").passwordbox("getValue");

		if (newPass != newPass_confirm) {
			ext.tip.warn("<spring:message code="newPasswordIsNotCorrect" />");
			return;
		}

		ext.ajax.get("user/modifyPassword?oldPassword=" + old + "&newPassword="
				+ newPass, function(data) {

			if (data.code != OK) {
				ext.tip.error(data.message);
				return;
			}

			ext.tip.suc();

			$("#dlg").dialog("close");
			$("#passwordform").form("clear");
		});

	}
</script>