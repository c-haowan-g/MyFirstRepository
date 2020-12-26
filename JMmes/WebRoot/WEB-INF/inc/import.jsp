<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    request.setAttribute("now", System.currentTimeMillis());
%>
<div id="import_dlg${now }" class="easyui-dialog" style="width:500px;height:150px;padding:5px;" title="数据导入" modal="true" closed="true" buttons="#toolbar${now }">
    <input class="easyui-filebox" name="file${now }" id="file${now }" data-options="label:'选择文件',buttonText:'选择文件',width:'100%'">
</div>

<div id="toolbar${now }">
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="doImport${now }()">导入</a> <a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#import_dlg${now }').dialog('close')">取消</a>
</div>
<script type="text/javascript">
function $_import(){
	$("#import_dlg${now }").dialog("open");
}
function doImport${now }(){
	if($("#file${now }").filebox("files").length==0){
        ext.tip.warn("请选择文件");
        return;
    }
    ext.loading.show();
    file.upload($("input[name='file${now }']").attr("id"), "import",false, function(data){
        ext.loading.hide();
        ext.loading.show();
        ext.ajax.get("excel/import?fileId="+data.data.id+"&handlerClass=<%=request.getParameter("handlerClass")%>", function(data){
        	$("#import_dlg${now }").dialog("close");
        	ext.loading.hide();
        	if(data.code!=OK){
        		ext.tip.error(data.message);
        		file.downloadFile(data.data.fileUUIDName);
        	}
        	<%=request.getParameter("callBackFuncName")%>(data);
        });
    });
}
</script>