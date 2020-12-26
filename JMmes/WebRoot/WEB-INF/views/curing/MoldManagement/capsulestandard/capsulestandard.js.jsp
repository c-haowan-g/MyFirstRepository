<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
/**
 *数据字典传值
 *
 */
function codeFormatter(v, r, i) {

	return dictFormat(v);
}

/* 胶囊规格属性 */
$(function(){
	var material_capsulecode_s = $("#capsulestandard_dg").datagrid('getColumnOption', 'material_capsulecode_s');
	//var capsule_factory_s_name = $("#capsulestandard_dg").datagrid('getColumnOption', 'capsule_factory_s_name');
	material_capsulecode_s.editor={type:'combobox',
		options:{valueField:'MATERIALCODE_S',
            textField:'MATERIALCODE_S',
            limitToList:'false',
            panelHeight:300,
            editable:true,
            method:'get',
            url:'curing/moldmanagement/CapsuleStandard/searchByMaterial',
            filter: function(q, row){  
		        var opts = $(this).combobox('options');  
		        return row[opts.textField].indexOf(q) >= 0;//这里改成>=即可在任意地方匹配  
		    },  
            required:true,
            onChange:function (value,o) {
            	/* 选择规格带出物料编码、校验码 */
    	 	if(value!=null||value!=undefined){ 
				var k=$(this).parents('[datagrid-row-index]').attr('datagrid-row-index');
		        var capsule_spec_s_td=$('.datagrid-body td[field=\'capsule_spec_s\']')[k];
		        var capsule_spec_s_input = $(capsule_spec_s_td).find('input')[0];
		        ext.ajax.sendJson("curing/moldmanagement/CapsuleStandard/searchBycapsule", value, function(data) {
		        	if(data == null) {
		        		$(capsule_spec_s_input).textbox('disable');
		        	    ext.tip.error("PLM未维护该物料信息，请联系技术人员维护");
		        	    return;
		        	}
		        	$(capsule_spec_s_input).textbox('setValue',data);
		        	$(capsule_spec_s_input).textbox('disable');
				});
		        var parity_code_s_td=$('.datagrid-body td[field=\'parity_code_s\']')[k];
		        var parity_code_s_input = $(parity_code_s_td).find('input')[0];
		        ext.ajax.sendJson("curing/moldmanagement/CapsuleStandard/searchCodeByMaterial", value, function(data) {
		        	$(parity_code_s_input).textbox('setValue',"");
		        	$(parity_code_s_input).textbox('enable');
		        	if(data!=null){
		        	$(parity_code_s_input).textbox('setValue',data);
		        	$(parity_code_s_input).textbox('disable');
		        	}
				});
		   }
     	}
      }
	};
	/* capsule_factory_s_name.editor={type:'combobox',
		options:{valueField:'SUPPLIERCODE_S',
            textField:'SUPPLIERNAME_S',
            panelHeight:300,
            editable:true,
            method:'get',
            url:'/searchByVendor',
            filter: function(q, row){  
		        var opts = $(this).combobox('options');  
		        return row[opts.textField].indexOf(q) >= 0;//这里改成>=即可在任意地方匹配  
		    },  
		    required:true,
      }
	} */
});

    var saveChanges="curing/moldmanagement/CapsuleStandard/saveChanges";
    
    /**
	*查询栏，隐藏，显示
	*
	*/
    function showOrHide(){
        if($("#CapsuleStandard_search_form").is(":hidden")){
            $("#CapsuleStandard_search_form").show();
        }else{
            $("#CapsuleStandard_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
     var filter=function(){
        ext.easyui.grid.search("capsulestandard_dg","CapsuleStandard_search_form");
    }
    /**
	*添加事件
	*/
    function add() {
        ext.easyui.grid.appendAndEdit("capsulestandard_dg",{
        	max_limit_i: new Calendar().format("0"),
        	alarm_number_i: new Calendar().format("0"),
        	//over_limit_i: new Calendar().format("10"),
		});
    }

    /**
	*修改事件
	*/
    function edit() {
        var rows = $("#capsulestandard_dg").datagrid("getSelections");
        if(rows.length !=0){
        	 var index = -1;
             for (var i = 0; i < rows.length; i++) {
                 index = $("#capsulestandard_dg").datagrid("getRowIndex", rows[i]);
                 $("#capsulestandard_dg").datagrid("beginEdit", index);
             }
        }else{
        	ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
        }
    }

    /**
	*删除事件
	*/
    function remove() {
        var rows = $("#capsulestandard_dg").datagrid("getSelections");
        if(rows.length !=0){
        	var index = -1;
            for (var i = 0; i < rows.length; i++) {
                index = $("#capsulestandard_dg").datagrid("getRowIndex", rows[i]);
                $("#capsulestandard_dg").datagrid("deleteRow", index);
            }

        }else{
        	ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
        }
        
    }

    /**
	*保存事件
	*/
    function save() {
        var dg = $("#capsulestandard_dg");

        var rows = dg.datagrid("getRows");
        var valid = false;
        for (var i = 0; i < rows.length; i++) {
            if (!dg.datagrid("validateRow", i)) {
            	ext.tip.error("<spring:message code="tip.error" />");
                return;
            }
        }

        var inserted = dg.datagrid("getChanges", "inserted");
        var updated = dg.datagrid("getChanges", "updated");
        var deleted = dg.datagrid("getChanges", "deleted");
       
        for (var i = 0; i < rows.length; i++) {
            dg.datagrid("endEdit", i);
        }
        
	if(inserted.length ==0 && updated.length ==0 && deleted.length ==0){
			
			$("#materialpdf_dg").datagrid("reload");
            ext.tip.error("<spring:message code="tip.nosave" />");
	}else{
		for(var i=0;i<inserted.length;i++){
        	delete inserted[i]["created_by_name"];
        	delete inserted[i]["changed_by_name"];
		}
		for(var i=0;i<updated.length;i++){
			delete updated[i]["created_by_name"];
			delete updated[i]["changed_by_name"];
		}
		for(var i=0;i<deleted.length;i++){
			delete deleted[i]["created_by_name"];
			delete deleted[i]["changed_by_name"];
		}
		
        ext.ajax.sendJson(saveChanges, {
            inserted : inserted,
            updated : updated,
            deleted : deleted
        }, function(data) {
        	if (data.code != 0) {
        		  if(data.code == 1){
        			  if(data.message=="代码重复"){
        				$("#capsulestandard_dg").datagrid("reload");
                      ext.tip.error("<spring:message code="tip.repeat" />");
        			  }else{
        				 $("#capsulestandard_dg").datagrid("reload");
                       ext.tip.error("<spring:message code="tip.error" />");
        			  }
        		  }
              }else{
            	  $("#capsulestandard_dg").datagrid("reload");
                  ext.tip.suc("<spring:message code="tip.success" />")
              }
              
        });
	}
        
    }

    /**
	*撤销事件
	*/
    function cancel() {
        $("#capsulestandard_dg").datagrid("rejectChanges");
    }

    
    /**
	*查询栏，隐藏，显示
	*
	*/
	function hide(){
		  $("#CapsuleStandard_search_form").toggle(50);
	}

	/**
	 *数据字典传值
	 *
	 */
	function codeFormatter(v, r, i) {

		return dictFormat(v);
	}
</script>