<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
    var saveChanges=path+"finalcheck/baseData/entmodel/saveChanges";
    /**
     * 接收combox数据
     */
     var DICT_254=[];
 	
 	$.ajax({
 		url:"dict/code/254",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			DICT_254=data;
 		}
 	});
 	  /**
     * 接收combox数据
     */
     var DICT_260=[];
 	
 	$.ajax({   
 		url:"dict/code/260",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			DICT_260=data;
 		}
 	});
    /**
     * 接收combox数据
     */
     var DICT_255=[];
 	
 	$.ajax({
 		url:"dict/code/255",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			DICT_255=data;
 		}
 	});
    
    function showOrHide(){
        if($("#Ent_search_form").is(":hidden")){
            $("#Ent_search_form").show();
        }else{
            $("#Ent_search_form").hide();
        }
    }
    function codeFormatter(v,r,i){
    	
    	return dictFormat(v);
    }
    
    /* function spareFormatter(v,r,i){
    	if(v=="0")
    		return "否";
    	else if(v=="1")
    		return "是";
    	else 
    		return "";
    } */
    
   
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("ent_dg","Ent_search_form");
    }
    
    function add() {
        $("#ent_dg").datagrid('insertRow', {
			index: 0,row:{}
		});
        $("#ent_dg").datagrid("beginEdit", 0);
    }

    function edit() {
        var rows = $("#ent_dg").datagrid("getSelections");
        if(rows.length<=0){
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
    		return;
		}
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#ent_dg").datagrid("getRowIndex", rows[i]);
            $("#ent_dg").datagrid("beginEdit", index);
            //设备条码不可编辑
            /* var equip_name = $("#ent_dg").datagrid('getEditor', {index:index,field:'equip_name'});
            $(equip_name.target).textbox({disabled: true}); */
            if(rows[i]["equip_type_s"]!="254002"){
            	 //规格
	    		 var device_valid_s = $("#ent_dg").datagrid('getEditor', {index:index,field:'device_valid_s'});
            	 $(device_valid_s.target).textbox('clear');
	           	 $(device_valid_s.target).textbox({disabled: true});//不可编辑
            }
        }
    }

    function remove() {
        var rows = $("#ent_dg").datagrid("getSelections");
		if(rows.length<=0){
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
    		return;
		}
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#ent_dg").datagrid("getRowIndex", rows[i]);
            $("#ent_dg").datagrid("deleteRow", index);
        }
    }

    //校验机台编码规则
    function CheckRule(value,equip_type) {
	      
		//验证编码规则
		if (value != null && value != "") {
			var factory_class = value.substring(0, 1);
			//设备类不同编码规则不同：割毛254001 GM,外观254002 WG,X光254003 XG,动平衡254004 DPH,均匀性254005 JYX
			var eq_type1 = value.substring(1, 3);
			var eq_type2 = value.substring(1, 4);
			var number=value.substring(value.length-2);//截取后2位
			var numberRule= /^\d{2}$/;
			if(equip_type!=null && equip_type != ""){
				if(equip_type=="254001"){
					if(factory==1){
						if(factory_class!="F" || eq_type1!="GM"){
							return ext.tip.error("割毛设备编码规则:FGM+设备编号（2位）");
						}else if(value.length!=5){
							return ext.tip.error("割毛设备编码规则:FGM+设备编号（2位）");
						}else if(!numberRule.test(number)){
							return ext.tip.error("割毛设备编码规则:FGM+设备编号（2位）");
						}
					}else{
						if(factory_class!="H" || eq_type1!="GM"){
							return ext.tip.error("割毛设备编码规则:HGM+设备编号（2位）");
						}else if(value.length!=5){
							return ext.tip.error("割毛设备编码规则:HGM+设备编号（2位）");
						}else if(!numberRule.test(number)){
							return ext.tip.error("割毛设备编码规则:HGM+设备编号（2位）");
						}
					}
				}else if(equip_type=="254002"){
					if(factory==1){
						if(factory_class!="F" || eq_type1!="WG"){
							return ext.tip.error("外观设备编码规则:FWG+设备编号（2位）");
						}else if(value.length!=5){
							return ext.tip.error("外观设备编码规则:FWG+设备编号（2位）");
						}else if(!numberRule.test(number)){
							return ext.tip.error("外观设备编码规则:FWG+设备编号（2位）");
						}
					}else{
						if(factory_class!="H" || eq_type1!="WG"){
							return ext.tip.error("外观设备编码规则:HWG+设备编号（2位）");
						}else if(value.length!=5){
							return ext.tip.error("外观设备编码规则:HWG+设备编号（2位）");
						}else if(!numberRule.test(number)){
							return ext.tip.error("外观设备编码规则:HWG+设备编号（2位）");
						}
					}
				}else if(equip_type=="254003"){
					if(factory==1){
						if(factory_class!="F" || eq_type1!="XG"){
							return ext.tip.error("X光设备编码规则:FXG+设备编号（2位）");
						}else if(value.length!=5){
							return ext.tip.error("X光设备编码规则:FXG+设备编号（2位）");
						}else if(!numberRule.test(number)){
							return ext.tip.error("X光设备编码规则:FXG+设备编号（2位）");
						}
					}else{
						if(factory_class!="H" || eq_type1!="XG"){
							return ext.tip.error("X光设备编码规则:HXG+设备编号（2位）");
						}else if(value.length!=5){
							return ext.tip.error("X光设备编码规则:HXG+设备编号（2位）");
						}else if(!numberRule.test(number)){
							return ext.tip.error("X光设备编码规则:HXG+设备编号（2位）");
						}
					}
				}else if(equip_type=="254004"){
					if(factory==1){
						if(factory_class!="F" || eq_type2!="DPH"){
							return ext.tip.error("动平衡设备编码规则:FDPH+设备编号（2位）");
						}else if(value.length!=6){
							return ext.tip.error("动平衡设备编码规则:FDPH+设备编号（2位）");
						}else if(!numberRule.test(number)){
							return ext.tip.error("动平衡设备编码规则:FDPH+设备编号（2位）");
						}
					}else{
						if(factory_class!="H" || eq_type2!="DPH"){
							return ext.tip.error("动平衡设备编码规则:FDPH+设备编号（2位）");
						}else if(value.length!=6){
							return ext.tip.error("动平衡设备编码规则:FDPH+设备编号（2位）");
						}else if(!numberRule.test(number)){
							return ext.tip.error("动平衡设备编码规则:FDPH+设备编号（2位）");
						}
					}
				}else if(equip_type=="254005"){
					if(factory==1){
						if(factory_class!="F" || eq_type2!="JYX"){
							return ext.tip.error("均匀性设备编码规则:FJYX+设备编号（2位）");
						}else if(value.length!=5){
							return ext.tip.error("均匀性设备编码规则:FJYX+设备编号（2位）");
						}else if(!numberRule.test(number)){
							return ext.tip.error("均匀性设备编码规则:FJYX+设备编号（2位）");
						}
					}else{
						if(factory_class!="H" || eq_type2!="JYX"){
							return ext.tip.error("均匀性设备编码规则:HJYX+设备编号（2位）");
						}else if(value.length!=5){
							return ext.tip.error("均匀性设备编码规则:HJYX+设备编号（2位）");
						}else if(!numberRule.test(number)){
							return ext.tip.error("均匀性设备编码规则:HJYX+设备编号（2位）");
						}
					}
				}
			}
		}
    }
    
    
  var exitEntbarcode= function (value,o){
		  var  entBarcode =value;
    	var rows = $("#ent_dg").datagrid("getSelections");
    	for(var i=0;i<rows.length;i++){
    		if(rows[i].equip_name==entBarcode){
    			return;
    		}
    	}
    	var index = $(this).parents("[datagrid-row-index]").attr(
		"datagrid-row-index");
		var equip_typeEditor = $("#ent_dg").datagrid('getEditor', {
			index : index,
			field : "equip_type_s"
		});
		var equip_type = $(equip_typeEditor.target).combobox("getValue");
    	CheckRule(value,equip_type);
    		$.ajax({
          		url:"finalcheck/baseData/entmodel/entBarcodeExit?entBarcode="+entBarcode,
          		type:"get",
          		dataType:"json",
          		async:false,
          		success:function(data){
          			if(data[0].COUNT!=0){
          				ext.tip.error(entBarcode+"机台条码已经存在");
          			}
          			else{
          				
          			};
          			
          		}
    		
          	});
    }
    
    
    function save() {
    	//表名是：AT_D_EM_Ent
        var dg = $("#ent_dg");
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
        var isPause1=false;
        var flag=0;
        for(var i=0;i<updated.length;i++){
       	 for(var k=0;k<updated.length;k++){
       		 if(updated[i].entbarcode_s==updated[k].entbarcode_s){
       			flag=flag+1;
       			if(flag>1){
       				ext.tip.error("编辑的机台存在条码重复，请检查");
       				isPause1=true;
       			 }
              };
            }
       	 flag=0;
       }
        var isPause2=false;
        var iflag=0;
        for(var i=0;i<inserted.length;i++){
          	 for(var k=0;k<inserted.length;k++){
          		 if(inserted[i].entbarcode_s==inserted[k].entbarcode_s){
          			iflag=iflag+1;
          			if(iflag>1){
          				ext.tip.error("新增的机台存在条码重复，请检查");
          				isPause2=true;
          			 }
                 };
               }
          }
        if(isPause1||isPause2){
        	 setTimeout(function(){
            	 ext.ajax.sendJson(saveChanges, {
                     inserted : inserted,
                     updated : updated,
                     deleted : deleted
                 }, function(data) {
                     if (data.code!=OK) {
                         ext.tip.error("<spring:message code="tip.error" />");
                     }
                     $("#ent_dg").datagrid("reload");
                     ext.tip.suc("<spring:message code="tip.success" />");
                 });
            	},2000);
        }
        else{
        	ext.ajax.sendJson(saveChanges, {
                inserted : inserted,
                updated : updated,
                deleted : deleted
            }, function(data) {
                if (data.code!=OK) {
                    ext.tip.error("<spring:message code="tip.error" />");
                }
                $("#ent_dg").datagrid("reload");
                ext.tip.suc("<spring:message code="tip.success" />");
            });
        }
        
        
       
    }

    function cancel() {
        $("#ent_dg").datagrid("rejectChanges");
    }
    
    function showhide() {
    	$("#Ent_search_form").toggle();
    }
    //强制开关按钮
    /* function on_off(buttontype){
    	var rows=$("#ent_dg").datagrid("getChecked");
    	if(rows.length==0){
    		ext.tip.warn(tipSelectAtLeastOne);
    		return;
    	}
    	//获取界面选择的ID
    	var ids=[];
    	for(var i=0;i<rows.length;i++){
    		log(rows[i].equip_type_s)
    		if(rows[i].equip_type_s=="254002"){
    			ids.push(rows[i].object_key);
    		}
    	}
    	if(ids.length==0){
    		ext.tip.error("<spring:message code="tip.invalidMachines" />");
    		return;
    	}
    	ext.ajax.post("finalcheck/baseData/entmodel/forced",{ids:ids.toString(),foreType:buttontype},function(data){
    		if(data.code==OK){
    			ext.tip.suc();
    			filter();
    			return;
    		}
    		ext.tip.error(data.message);
    	});
    } */

</script>