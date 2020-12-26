<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../inc/meta.jsp" %>
<%@ include file="devtools.js.jsp" %>
 <body class="easyui-layout" fit="true">
	   <div data-options="region:'west',split:true" title="数据库表名" style="width:500px;">
	        <div id="devtools_tables_dg_toolbar" style="padding:2px;">
                <a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-gen'" onclick="add()">生成代码</a>
            </div>
	        <table class="easyui-datagrid" id="devtools_tables_dg" style="width:50%"
	            data-options="
	                singleSelect:true,
	                fitColumns:true,
	                pagination:false,
	                toolbar:'#devtools_dg_toolbar',
	                animate:true,
	                fit:true,
	                url: 'devtools/db',
	                method: 'get',
	                rownumbers: true,
	                onClickRow:function(index,row){
	                   $('#devtools_columns_dg').datagrid('reload');
	                },
	                onLoadSuccess:function(data){
	                   $(this).datagrid('enableFilter');
	                }
	            ">
		        <thead>
		            <tr>
		                <!-- <th data-options="field:'at_key'" checkbox="true"></th> -->
		                <th data-options="field:'name'" width="80">表名</th>
		                <th data-options="field:'memo'" width="50" >描述</th>
		            </tr>
		        </thead>
		    </table>
	   </div>
        <div data-options="region:'center',title:'数据列'">
	        <table class="easyui-datagrid" id="devtools_columns_dg"
	            data-options="singleSelect:true,collapsible:true,url:'devtools/db',method:'get',fit:true,onBeforeLoad:onBeforeLoad">
		        <thead>
		            <tr>
		                <th data-options="field:'name',width:80">列名</th>
		                <th data-options="field:'type',width:80">数据类型</th>
		                <th data-options="field:'nullable',width:50">可为空</th>
		                <th data-options="field:'dataLength',width:50">长度</th>
		                <th data-options="field:'precision',width:50">比例</th>
		                <th data-options="field:'memo',width:100">描述</th>
		            </tr>
		        </thead>
		    </table>
     </div>
     <div id="devtools_dlg" class="easyui-dialog" title="请输入基本信息<font color=red>（注意类名、不要全大写）</font>" style="width:600px;height:450px;"
            data-options="
                iconCls: 'icon-window',
                buttons:'#devtools_dlg_btn',
                closed:true
            ">
            
            <form class="form" id="devtools_form" action="devtools/gen" method="get">
                <input type="hidden" name="tblName" id="tblName">
                <div class="form-row">
                    <input class="easyui-textbox" name="entityName" id="entityName" style="width:100%" data-options="label:'实体类名',required:true,validType:'length[2,100]'">
                </div>
                <div class="form-row">
                    <input class="easyui-textbox" name="tableName" id="tableName" style="width:100%" data-options="label:'数据库表名',required:true,validType:'length[2,100]'">
                </div>
                <div class="form-row">
                    <input class="easyui-textbox" name="author" id="author" value="${LOGIN_USER_NAME }" style="width:100%" data-options="label:'开发者姓名',required:true,validType:'length[2,30]'">
                </div>
                <div class="form-row">
                    <input class="easyui-textbox" name="comment" id="comment" style="width:100%" data-options="label:'注释',required:true,validType:'length[2,100]'">
                </div>
                <div class="form-row">
                    <input class="easyui-textbox" name="packageName" id="packageName" style="width:100%" value="com.bluebirdme.mes.linglong.<模块名称>" data-options="label:'模块包名',required:true,validType:'length[2,150]'">
                </div>
                <div class="form-row">
                    <input class="easyui-textbox" name="url" id="url" value="" style="width:100%" data-options="label:'URL路径',required:true,validType:'length[2,150]'">
                </div>
                <div class="form-row">
                    <input class="easyui-textbox" name="logCode" id="logCode" style="width:100%" data-options="label:'日志代码',required:true,validType:'length[2,150]'">
                </div>
                <div class="form-row">
                    <input class="easyui-textbox" name="logName" id="logName" style="width:100%" data-options="label:'日志名称',required:true,validType:'length[2,150]'">
                </div>
            </form>
    </div>
    <div id="devtools_dlg_btn">
        <a class="easyui-linkbutton btn-green" iconCls="icon-ok"  onclick="save()">点击生成代码</a>
        <a class="easyui-linkbutton btn-black" iconCls="icon-remove" onclick="cancel()">取消</a>
    </div>
  </body>
</html>
