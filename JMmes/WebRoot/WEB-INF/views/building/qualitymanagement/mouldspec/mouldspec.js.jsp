
<script type="text/javascript">

    var saveChanges=path+"cx/zlgl/mouldspec/saveChanges";
    
    function showOrHide(){
        if($("#MouldSpec_search_form").is(":hidden")){
            $("#MouldSpec_search_form").show();
        }else{
            $("#MouldSpec_search_form").hide();
        }
    }
    
  

    /**
     *子页面查询和保存按钮
     */
    var filter=function(){
        ext.easyui.grid.search("mouldspec_dg","MouldSpec_search_form");
    }
    
    var filter2=function(){
        ext.easyui.grid.search("mouldspec_dg2","MouldSpec_search_form2");
    }
    
    var filter3=function(){
        var op = $("#mouldspec_dg3").datagrid("options");//获取 option设置对象
        op.url = "cx/zlgl/mouldspec/searchByMaterial";//设置url
        $("#mouldspec_dg3").datagrid("reload", ext.form.getFormAsJson("MouldSpec_search_form3"));

    }
    
    
    function add() {
        ext.easyui.grid.appendAndEdit("mouldspec_dg",{});
    }

    function edit() {
        var rows = $("#mouldspec_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#mouldspec_dg").datagrid("getRowIndex", rows[i]);
            $("#mouldspec_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {
        var rows = $("#mouldspec_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#mouldspec_dg").datagrid("getRowIndex", rows[i]);
            $("#mouldspec_dg").datagrid("deleteRow", index);
        }

    }
	
	function plsave(){
		var datag = $("#mouldspec_dg2");
		var datag1 = $("#mouldspec_dg3");
		
		var sl = datag.datagrid("getSelections");
		var sl1 = datag1.datagrid("getSelections");
		
		log(sl1);
		var lowe =0;
		var mouldspec = [];

		for (var i = 0 ;i< sl.length;i++){
			for (var j = 0 ;j< sl1.length;j++){
				
				sl[i].material_code_s=sl1[j].MATERIALCODE_S;
				sl[i].spare1_s = sl[i].status_s;
				sl[i].spare2_s = sl1[j].OLDMATCODE_S;
				
				log(sl1[j].STATUS_S);
				/**
                 * 批量保存中去除多余数据
                 */
				var a = copy(sl[i]);
				log('------'+sl[i].material_code_s)
				delete a.created_by_name; 
				delete a.alarm_number_s;
				delete a.capsule_factory_s;
				delete a.capsule_id_s;
				delete a.in_time_t;
				delete a.parity_code_s;
				delete a.purchaser_s;
				delete a.put_time_t;
				delete a.replaced_time_t;
				delete a.status_s;
				delete a.store_area_s;
				delete a.store_location_s;
				delete a.suppliers_no_s;
				delete a.total_number_s;
				delete a.user_id_s;
				delete a.use_time_t;
				mouldspec[lowe] = a;
				lowe++;
			}
		}
		
		var inserted = mouldspec;
		
		ext.ajax.sendJson(saveChanges, {
            inserted : inserted,
        }, function(data) {
            if (data.code!= OK ) {
            	$("#mouldspec_dg").datagrid("reload");
                ext.tip.error("<spring:message code="tip.error" />");
                return;
            }else{
            	$("#mouldspec_dg").datagrid("reload");
            	ext.tip.suc("<spring:message code="tip.success" />")
			}
        });
		
	}

	function copy(obj){
		var newobj = {};
		for ( var attr in obj) {
			newobj[attr] = obj[attr];
		}
		return newobj;
	}


    function save() {
        var dg = $("#mouldspec_dg");

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
        
        if(inserted.length ==0 && updated.length ==0 && deleted.length ==0){
			
			$("#mouldspec_dg").datagrid("reload");
            ext.tip.error("<spring:message code="tip.nosave" />")
		}else{
	            /**
                 * 去除多余数据
                 */
			var arysave = new Array(); 
			for(var i=0;i<inserted.length;i++){
				delete inserted[i]["create_name_bycode"];
			}
			var aryupdate = new Array(); 
			for(var i=0;i<updated.length;i++){
				delete updated[i]["create_name_bycode"];
			}
			for(var i=0;i<deleted.length;i++){
				delete deleted[i]["create_name_bycode"];
			}
			var narySave=arysave.sort();  
			var naryUpdate=aryupdate.sort();  
			for(var i=0;i<arysave.length;i++){  
				 if (narySave[i]==narySave[i+1]){  
					ext.tip.error("<spring:message code="tip.error" />");
					return;
				 }
			 } 
			 for(var i=0;i<aryupdate.length;i++){  
				 if (naryUpdate[i]==naryUpdate[i+1]){  
					ext.tip.error("<spring:message code="tip.error" />");
					return; 
				 }
			 } 
			ext.ajax.sendJson(saveChanges, {
		            inserted : inserted,
		            updated : updated,
		            deleted : deleted
		       }, function(data) {

			            if (data.code!= OK ) {
			                ext.tip.error("<spring:message code="tip.error" />");
			                return;
			            }else{
			            	$("#mouldspec_dg").datagrid("reload");
			            	ext.tip.suc("<spring:message code="tip.success" />")
						}
			        });
		}
        
    }
    
     /**
     * 防止出现对象不断覆盖
     */
    function clearFieldValue(index,field){
    	
    	try{
    		$(getEditor(index, field).target).combobox("clear")
    	}catch (e) {}
    	try{
            $(getEditor(index, field).target).numberspinner("clear")
        }catch (e) {}
        try{
            $(getEditor(index, field).target).textbox("clear")
        }catch (e) {}
        try{
            $(getEditor(index, field).target).combobox("clear")
        }catch (e) {}
    	
    }
    

	function selee(record){
		var index=$(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
    	var fields=[
				"capsule_name_s",
				"capsule_specification_s",
				"capsule_type_s"
				];
    	
    	 for(var k in fields){
            clearFieldValue(index, fields[k]);
        }
    	
    				var k=$(this).parents('[datagrid-row-index]').attr('datagrid-row-index');
			        
			        var td=$('.datagrid-body td[field=\'capsule_name_s\']')[index];
			        var input = $(td).find('input')[0];
			        
			        var td2=$('.datagrid-body td[field=\'capsule_specification_s\']')[index];
			        var input2 = $(td2).find('input')[0];
			        
			        var td3=$('.datagrid-body td[field=\'capsule_type_s\']')[index];
			        var input3 = $(td3).find('input')[0];
			        
			        var td4=$('.datagrid-body td[field=\'spare1_s\']')[index];
			        var input4 = $(td4).find('input')[0];
			        
    				ext.ajax.get("cx/zlgl/mouldspec/searchByCapsulel2?capsulel="+record.CAPSULE_CODE_S,function(data){
    				log(data[0].STATUS_S);
					log(data[0])
					
			        
		        	$(input).textbox('setValue',data[0].CAPSULE_NAME_S);
		        	$(input).textbox('disable');
		        	
		        	$(input2).textbox('setValue',data[0].CAPSULE_SPECIFICATION_S);
		        	$(input2).textbox('disable');
		        	
		        	$(input3).combotree('setValue',data[0].CAPSULE_TYPE_S);
		        	$(input3).textbox('disable');
		        	
		        	$(input4).combotree('setValue',data[0].STATUS_S);
		        	$(input4).textbox('disable');
					
					
					$(getEditor(0,"capsule_name_s").target).textbox("setValue",record.capsule_name_s);
					//$(getEditor(index,"capsule_specification_s").target).textbox("setValue",data[0].CAPSULE_NAME_S);
					//$(getEditor(index,"capsule_type_s").target).combotree("setValue",data[0].CAPSULE_NAME_S);
		});
	}
	
	
	function selectmater(record){
		var index=$(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
    	var fields=[
				"oldmatcode_s"
				];
    	
    	 for(var k in fields){
            clearFieldValue(index, fields[k]);
        }
    	
    				var k=$(this).parents('[datagrid-row-index]').attr('datagrid-row-index');
			        var td=$('.datagrid-body td[field=\'spare2_s\']')[index];
			        var input = $(td).find('input')[0];
			        
    				ext.ajax.get("cx/zlgl/mouldspec/searchByMaterial2?capsulel="+record.MATERIALCODE_S,function(data){
    				log(data[0].OLDMATCODE_S);
					log(data[0])
					
			        
		        	$(input).textbox('setValue',data[0].OLDMATCODE_S);
		        	$(input).textbox('disable');
					
					
					$(getEditor(0,"capsule_name_s").target).textbox("setValue",record.capsule_name_s);
		});
	}
	
    function cancel() {
        $("#mouldspec_dg").datagrid("rejectChanges");
    }

    /**
     * 数据字典转换方法
     */
     var DICT_153=[];
     var DICT_154=[];
   
    	$.ajax({
    		url:"dict/code/153",
    		type:"get",
    		dataType:"json",
    		async:false,
    		success:function(data){
    			DICT_153=data;
    		}
    	});
    	
    	$.ajax({
    		url:"dict/code/154",
    		type:"get",
    		dataType:"json",
    		async:false,
    		success:function(data){
    			DICT_154=data;
    		}
    	});
    	
    	function codeFormatter(v, r, i) {

    		return dictFormat(v);
    	}
    	
    /**
     *批量保存功能
     */
	function piliang()
	{
		$("#menu_dlg").dialog("open");
	}

</script>