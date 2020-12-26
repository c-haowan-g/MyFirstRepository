<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"building/qualitymanagement/buildquota/saveChanges";
    
    function showOrHide(){
        if($("#BuildQuota_search_form").is(":hidden")){
            $("#BuildQuota_search_form").show();
        }else{
            $("#BuildQuota_search_form").hide();
        }
    }
    
    $(function(){
    	filter();
    })
    
    /**
     * 查询方法
     */
    function filter(){
    	var opts = $("#buildquota_dg").datagrid("options");
		opts.url ='building/qualitymanagement/buildquota/datagrid';
    	ext.easyui.grid.search("buildquota_dg","BuildQuota_search_form");
       // ext.easyui.grid.search("buildquota_dg","BuildQuota_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("buildquota_dg",{});
    }

    function edit() {
        var rows = $("#buildquota_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#buildquota_dg").datagrid("getRowIndex", rows[i]);
            $("#buildquota_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#buildquota_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#buildquota_dg").datagrid("getRowIndex", rows[i]);
            $("#buildquota_dg").datagrid("deleteRow", index);
        }

    }
    function codeFormatter(v, r, i) {
  	  if(v==null){
  		  return "";
  	  }
  	  return dictFormat(v);
  	}
    function save() {
    	debugger;
        var dg = $("#buildquota_dg");
        var rows = dg.datagrid("getRows");
        var valid = false;
        for (var i = 0; i < rows.length; i++) {
            if (!dg.datagrid("validateRow", i)) {
                ext.tip.error("<spring:message code="tip.invalid" />");
                return;
            }
        }
        var inserted = dg.datagrid("getChanges", "inserted");
        var updated = dg.datagrid("getChanges", "updated");
        var deleted = dg.datagrid("getChanges", "deleted");
		$("#tyretype_s")
        for (var i = 0; i < rows.length; i++) {
            dg.datagrid("endEdit", i);
        }
        ext.ajax.sendJson(saveChanges, {
            inserted : inserted,
            updated : updated,
            deleted : deleted
        }, function(data) {

            if (data.code!=OK) {
                ext.tip.error("<spring:message code="tip.error" />");
                return;
            }
            $("#buildquota_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#buildquota_dg").datagrid("rejectChanges");
    }
	
  
	function onMaterialSelect(record){
	    	var index = $(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
			$(getEditor(index, "materialdesc_s").target)
			.textbox("setValue", record.DESCRIPTION);//规格
	        
			var url ="building/qualitymanagement/buildquota/datagrid2?materialcode_s="+record.PART_NUMBER;
			ext.ajax.get(url, function(data) {
				$(getEditor(index, "tyretype_s").target)
		         	.textbox("setValue", data[0]);//规格
			});
			
			var url2="building/qualitymanagement/buildquota/datagrid3?materialcode_s="+record.PART_NUMBER;
			ext.ajax.get(url2, function(data) {
				$(getEditor(index, "materialspec_s").target)
		         	.textbox("setValue", data[0]);//规格
			});
	}
	 
	 function getEditor(index,field){
	        return $("#buildquota_dg").datagrid("getEditor",{index:index,field:field});
	 }
</script>