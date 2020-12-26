<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"halfpart/feedrecord/feedrecord/saveChanges";
    $(document).ready(function() {
		$('#start_time').datetimebox({
			value : '3/4/2010 00:00:00',
			required : false,
			showSeconds : true
		});
		$('#end_time').datetimebox({
			value : '3/4/2010 23:59:59',
			required : false,
			showSeconds : true
		});
	    filter();
	});
    function showOrHide(){
        if($("#Feedrecord_search_form").is(":hidden")){
            $("#Feedrecord_search_form").show();
        }else{
            $("#Feedrecord_search_form").hide();
        }
    }

   
  
	/**
	 *数据字典传值
	 *
	 */
	function codeFormatter(v, r, i) {
 		return dictFormat(v);
	}
	
	
	function getNameByGroupCode(v, r, i) {
		$.ajax({
			url : 'halfpart/feedrecord/feedrecord/getNameByGroupCode',
			type : 'get',
			dataType : 'json',
			data: {
				materialgroup_s: v
			},
			async : false,
			success : function(data) {
				v = data[0].dictname_s;
			}
		});
		return v;
	}
	
	  function isprimary_material(v, r, i) {
			if(v == "0" ){
				return "是"; 
			}else {
				return "否"; 
			}
		}
	  
	  function toEquipName(v, r, i) {
	    	if(v == null) {
	    		return v;
	    	}
			$.ajax({
				url : 'halfpart/feedrecord/feedrecord/toEquipName',
				type : 'get',
				dataType : 'json',
				data: {
					equipcode: v
				},
				async : false,
				success : function(data) {
					if(data.length == 0) {
						return v;
					}
					v = data[0].equipname;
				}
			});
			return v;
		}	
	  
	  
	function toUserName(v, r, i) {
	 	if(v == null) {
    		return v;
    	}
		$.ajax({
			url : 'halfpart/feedrecord/feedrecord/toUserName',
			type : 'get',
			dataType : 'json',
			data: {
				usercode: v
			},
			async : false,
			success : function(data) {
				if(data.length == 0) {
					return v;
				}
				v = data[0].username;
			}
		});
		return v;
	}
	
var DICT_308=[];
	
	$.ajax({
		url:"dict/code/308",
		type:"get",
		dataType:"json",
		async:false,
		success:function(data){
			DICT_308=data;
		}
	});
     
	
	
	var DICT_118=[];
		
		$.ajax({
			url:"dict/code/118",
			type:"get",
			dataType:"json",
			async:false,
			success:function(data){
				DICT_118=data;
			}
		});
    
	function materialFormatter(v, r, i) {
		$.ajax({
			url:"halfpart/feedrecord/feedrecord/materialGroupSearch",
			type:"get",
			dataType:"json",
			async:false,
			data:{
				data:v
			},
			success:function(data){
				console.log(data);
				v= data[0].DICTNAME_S;
			}
			
		});
		return v;
	}
	function machineFormatter(v, r, i) {
		return dictFormat(v);
	}
	function plannoFormatter(v, r, i) {
		return dictFormat(v);
	}
	/**
	    * 获取半部件用物料信息
	    */
	    var materialGroupList=[];
	    $.ajax({
	        url:"halfpart/feedrecord/feedrecord/materialGroupList",
	        type:"get",
	        dataType:"json",
	        async:true,
	        success:function(data){
	        	materialGroupList=data;
	        }
	    }); 
		function classFormatter(v,r,i){
			if(v=='302001')
				return '早班'
			else if(v=='302002')
				return '中班'
			else if(v=='302003')
				return '晚班'
			else
				return ''
		}
		
		  var productLineList=[];
		    $.ajax({
		        url:"halfpart/feedrecord/feedrecord/getHalfPartProductionLine",
		        type:"get",
		        dataType:"json",
		        async:false,
		        success:function(data){
		        	productLineList=data;
		        }
		    });
		    function machineFormatter(v, r, i) {
		        for(i=0;i<productLineList.length;i++){
		     	   if(v==productLineList[i].P_LINE_NAME){
		     		   return productLineList[i].DESCRIPTION;
		     	   }
		        }    
		     }
		
		    var getPlanno=[];
		    $.ajax({
		        url:"halfpart/feedrecord/feedrecord/getPlanno",
		        type:"get",
		        dataType:"json",
		        async:true,
		        success:function(data){
		        	getPlanno=data;
		        }
		    });
		
		    function machineeeFormatter(v, r, i) {
		        for(i=0;i<getPlanno.length;i++){
		     	   if(v==getPlanno[i].PLANNO_S){
		     		   return getPlanno[i].PLANNO_S;
		     	   }
		        }    
		     } 
		
		
		
		
    /**
     * 查询方法
     */
    var filter=function(){
    	var opts=$("#feedrecord_dg").datagrid("options");
    	opts.url='halfpart/feedrecord/feedrecord/datagridUDA'; 
        ext.easyui.grid.search("feedrecord_dg","Feedrecord_search_form");
    }
    /**
     * 查询方法
     */
    var filter1=function(){
    	var opts = $("#equipmentmaterial_dg").datagrid("options");
		opts.url = 'halfpart/basedata/equipmentMaterial/datagrid';
        ext.easyui.grid.search("equipmentmaterial_dg","EquipmentMaterial_search_form");
    };
    function add() {
        ext.easyui.grid.appendAndEdit("feedrecord_dg",{
        	inputtime_t:new Calendar().format("yyyy-MM-dd HH:mm:ss")
        });
    }

    function edit() {
        var rows = $("#feedrecord_dg").datagrid("getSelections");
		if(rows.length !=0){
			var index = -1;
	        for (var i = 0; i < rows.length; i++) {
	            index = $("#feedrecord_dg").datagrid("getRowIndex", rows[i]);
	            $("#feedrecord_dg").datagrid("beginEdit", index);
	        }
		}else{
			ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
		}
        
    }
      /*   var rows = $("#feedrecord_dg").datagrid("getSelections");
        if(rows.length !=0){
			var index = -1;
	        for (var i = 0; i < rows.length; i++) {
            index = $("#feedrecord_dg").datagrid("getRowIndex", rows[i]);
            $("#feedrecord_dg").datagrid("beginEdit", index);
	        }
		}else{
			ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
		}
    }
 */
    function remove() {
	   /* var rows = $("#feedrecord_dg").datagrid("getSelections");
       if(rows.length<=0){
           ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
           return;
       }
       var index = -1;
       for (var i = 0; i < rows.length; i++) {
           index = $("#feedrecord_dg").datagrid("getRowIndex", rows[i]);
           $("#feedrecord_dg").datagrid("deleteRow", index);
       }

   } */
         var rows = $("#feedrecord_dg").datagrid("getSelections");
        if(rows.length !=0){
            var index = -1;
            for (var i = 0; i < rows.length; i++) {
            index = $("#feedrecord_dg").datagrid("getRowIndex", rows[i]);
            $("#feedrecord_dg").datagrid("deleteRow", index);
            }
    	}else{
    		ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
    	}
    } 


    function save() {
        var dg = $("#feedrecord_dg");

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
 
 /*  if(inserted.length ==0 && updated.length ==0 && deleted.length ==0){
			
			$("#feedrecord_dg").datagrid("reload");
            ext.tip.error("<spring:message code="tip.nosave" />");
		}else{
			for (var i = 0; i < updated.length; i++) {
	            updated[i].materialcode_s = updated[i].materialcode_s;
	        }
	        for (var i = 0; i < inserted.length; i++) {
	            inserted[i]['materialcode_s'] = inserted[i].materialcode_s;
            	inserted[i]['machinecode_s'] = inserted[i].machinecode_s;
	            
	        }
			var arysave = new Array(); 
			var aryupdate = new Array(); 
			
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
		} */
        
			 ext.ajax.sendJson(saveChanges, {
		            inserted : inserted,
		            updated : updated,
		            deleted : deleted
		        },function(data) {
		        	
		        	if (data.code != 0) {
		        		  if(data.code == 1){
		        			  if(data.message=="代码重复"){
		        				$("#feedrecord_dg").datagrid("reload");
		                      ext.tip.error("<spring:message code="tip.repeat" />");
		        			  }else{
		        				 $("#feedrecord_dg").datagrid("reload");
		                       ext.tip.error("<spring:message code="tip.error" />");
		        			  }
		        		  }
		              }else{
		            	  $("#feedrecord_dg").datagrid("reload");
		                  ext.tip.suc("<spring:message code="tip.success" />");
		              }
		
		        	});
		   		}
	     

 /* function(data) {
				
	            if (data.code!=OK) {
	                ext.tip.error("<spring:message code="tip.error" />");
	                return;
	            }
	            var opts = $("#feedrecord_dg").datagrid("options");
				opts.url = 'halfpart/feedrecord/feedrecord/datagridUDA';
		        ext.easyui.grid.search("feedrecord_dg","Feedrecord_search_form");
	            ext.tip.suc("<spring:message code="tip.success" />");
	
	        });
		}*/
    function save1() {
    	/* var eqname = $('#equipmentcode_s').combobox('getValue');
    	if(eqname == "") {
    		ext.tip.warn("请选择机台");
    		return;
    	} */
        var rows1=$("#equipmentmaterial_dg").datagrid("getSelections");
        if(rows1.length == 0){
            ext.tip.warn("请选择");
            return;
		}else{
			//fu---zi
			var inserted = [];
            for(var i = 0; i < rows1.length; i++) {
            	var item = {};
            	item['materialcode_s'] = rows1[i].materialgroup_s;
            	//item['equipmentcode_s'] = eqname;
            	item['machinecode_s'] = rows1[i].equipmentcode_s;
            	item['isprimary_s'] = "0";
            	item['inputtime_t'] = new Calendar().format("yyyy-MM-dd HH:mm:ss");
            	inserted.push(item);
            }
            ext.ajax.sendJson(saveChanges, {
	            inserted : inserted
	        }, function(data) {
	            if (data.code!=OK) {
	                ext.tip.error("<spring:message code="tip.error" />");
	                return;
	            }
	            $("#Machine_dg").dialog("close");
	            $("#feedrecord_dg").datagrid("reload");
	            ext.tip.suc("<spring:message code="tip.success" />");
	        });
		}
    }
 
 
    function cancel() {
        $("#feedrecord_dg").datagrid("rejectChanges");
    }

    
    var  machinesearch=function(){
    	$("#Machine_dg").dialog("open");
    	
    	 ext.easyui.grid.search("equipmentmaterial_dg","EquipmentMaterial_search_form");
    }

</script>