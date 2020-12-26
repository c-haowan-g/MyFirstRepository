<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"common/billofmaterials/saveChanges";
    
    function showOrHide(){
        if($("#BillOfMaterial_search_form").is(":hidden")){
            $("#BillOfMaterial_search_form").show();
        }else{
            $("#BillOfMaterial_search_form").hide();
        }
    }
    
    
   
 
   
    /**
	 *数据字典传值
	 *
	 */
	function codeFormatter(v, r, i) {
		if(v==null){
			  return "";
		}
		return dictFormat(v);
	}
    
   function myLoad(row){
	   if(row.bom_name==null||row.bom_name==''||row.bom_name==undefined){
		   return false;
	   }
       var urlList = "common/billofmaterials/datagridBOMCount?bomkey="+row.bom_name+"/"+row.bom_revision;
    	$("#billofmaterial_dg").treegrid('options').url=urlList; 
    	return true;
   }
   
   function myExpand(){
	   var url='common/billofmaterials/datagridUDA';
	   $("#billofmaterial_dg").treegrid('options').url=url;
   }
 
  
   
   /**
   * 空值转换
   */
   function noneFormatter(value,row){

       if(value==null){
           return "";
       }
       return value;
   }
   /**
    * 成品轮胎以2开头，赋值外胎
    */
    function DescFormatter(value,row){
        if(row.materialtype_s == 'TBR' && row.bomdesc == null && row.bom_name.substr(0,1) == '2'){
            return "全钢外胎";
        }
        if(row.materialtype_s == 'PCR' && row.bomdesc == null && row.bom_name.substr(0,1) == '2'){
            return "半钢外胎";
        }
        return value;
    }
    /**
     * 查询方法
     */
    var filter=function(){
    	var revisionValue=$('#bom_revision').textbox("getValue");
    	if(revisionValue!=''&&revisionValue!=null){
    		var nameValue=$('#bom_name').textbox("getValue");
    		if(nameValue==null||nameValue==''){
    			ext.tip.warn("BOM版本与BOM名称不能为空！");
    			return false;
    		}
    	}
       $('#billofmaterial_dg').treegrid("reload", getFormJson("BillOfMaterial_search_form"));
    }
    function getFormJson(formId){
	    if($("#"+formId).length==0){
	        return {};
	    }
		
	    var formJsonArray=$("#"+formId).serializeArray();
	    
	    var likes=$("#"+formId+" [like=true]");
	    var ins=$("#"+formId+" [in=true]");
	    var beginWith=$("#"+formId+" [beginWith=true]");
	    var endWith=$("#"+formId+" [endWith=true]");
	    
	    var operators={};
	    $.each(likes,function(index,e){
	    	eleName=Utils.isEmpty($(e).attr("textboxname"))?$(e).attr("name"):$(e).attr("textboxname");
	    	operators[eleName]="contains:";
	    });
	    $.each(ins,function(index,e){
	    	eleName=Utils.isEmpty($(e).attr("textboxname"))?$(e).attr("name"):$(e).attr("textboxname");
	    	operators[eleName]="in:";
	    });
	    
	    $.each(beginWith,function(index,e){
	    	eleName=Utils.isEmpty($(e).attr("textboxname"))?$(e).attr("name"):$(e).attr("textboxname");
	    	operators[eleName]="beginWith:";
	    });
	    
	    $.each(endWith,function(index,e){
	    	eleName=Utils.isEmpty($(e).attr("textboxname"))?$(e).attr("name"):$(e).attr("textboxname");
	    	operators[eleName]="endWith:";
	    });
	    
	    
	    var formJson={};
	    
	    Utils.each(formJsonArray,function(i,e){
	        if(Utils.trim(e.value)!=""){
	        	formJson[e.name]=(operators[e.name]==undefined?"":operators[e.name])+Utils.trim(e.value);
	        }
	    });
	    console.log(formJson);
	    return formJson;
    }
    function add() {
        ext.easyui.grid.appendAndEdit("billofmaterial_dg",{});
    }

    function edit() {
        var rows = $("#billofmaterial_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#billofmaterial_dg").datagrid("getRowIndex", rows[i]);
            $("#billofmaterial_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#billofmaterial_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#billofmaterial_dg").datagrid("getRowIndex", rows[i]);
            $("#billofmaterial_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#billofmaterial_dg");

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
            $("#billofmaterial_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#billofmaterial_dg").datagrid("rejectChanges");
    }


</script>