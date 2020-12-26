<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"halfpart/baseData/halfPartMachineCapacity/saveChanges";
    
    /**
    * 获取半部件用物料信息
    */
     var materialGroupList=[];
    $.ajax({
        url:"halfpart/plateinoutrecord/plateinoutrecords/searchMaterielgroup",
        type:"get",
        dataType:"json",
        async:true,
        success:function(data){
        	materialGroupList=data;
        }
    });
     /**
    * 物料组显示转化
    * 2019-05-20
    * ldx
    */
    function materialGroupFormatter(v, r, i){
         for(var i=0;i<materialGroupList.length;i++){
            if (v == materialGroupList[i].DICTCODE_S) {
                return materialGroupList[i].DICTNAME_S;
            }
          }
    } 
    
    /**
    * 获取机台名称信息
    */
    var productLineList=[];
    $.ajax({
        url: "halfpart/basedata/productlinemanager/getHalfPartProductionLine",
        type:"get",
        dataType:"json",
        async:false,
        success:function(data){
        	productLineList=data;
        }
    });
      /**
    * 机台名称显示转化
    * 2019-05-20
    * ldx
    */
    function equipmentcodeFormatter(v, r, i){
         for(var i=0;i<productLineList.length;i++){
            if (v == productLineList[i].P_LINE_NAME) {
                return productLineList[i].DESCRIPTION;
            }
          }
    } 
	  
     var DICT_308=[];
 	
 	$.ajax({
 		url:"dict/code/-308",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			DICT_308=data;
 		}
 	}); 
    function userFormatter(v,r,i){
 		for (var i = 0; i < UserInfo.length; i++) {
 			if(UserInfo[i].USERCODE==v){
 				return UserInfo[i].USERNAME;
 			}
 		}
 	}
  
    function formatter2(date){
    	log(date==null?"":new Calendar(date).format('yyyy-MM-dd HH:mm:ss'));
		return date==null?"":new Calendar(date).format('yyyy-MM-dd HH:mm:ss');
	}
    
   function codeFormatter(v, r, i) {
        if(v==null){
            return "";
        }
          return dictFormat(v);
      }
      function coFormatter(v, r, i) {
       
            return r.materialgroup_s;
      }
    
    function showOrHide(){
        if($("#Equipmentcapacity_search_form").is(":hidden")){
            $("#Equipmentcapacity_search_form").show();
        }else{
            $("#Equipmentcapacity_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
    var opts = $("#equipmentcapacity_dg").datagrid("options");
		opts.url ="halfpart/baseData/halfPartMachineCapacity/datagrid";
        ext.easyui.grid.search("equipmentcapacity_dg","Equipmentcapacity_search_form");
    }
     function add() {
	  var equipmentcode_s=$("#equipmentcode_s").combobox("getValue");  //初始默认获取查询栏选择的机台号
	if(equipmentcode_s==null||equipmentcode_s==""){
		  ext.tip.warn("请选择机台");
			  return ;
	  }
    
    $("#equipmentcapacity_dg").datagrid('insertRow', {
			index: 0,row:{equipmentcode_s:equipmentcode_s}
		});

        $("#equipmentcapacity_dg").datagrid("beginEdit", 0);
    }
    function edit() {
        var rows = $("#equipmentcapacity_dg").datagrid("getSelections");
        if(rows.length<=0){
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
    		return;
		}
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#equipmentcapacity_dg").datagrid("getRowIndex", rows[i]);
            $("#equipmentcapacity_dg").datagrid("beginEdit", index);
            //班产能
				var materialcapacity_f = $("#equipmentcapacity_dg").datagrid('getEditor', {index:index,field:'materialcapacity_f'});
		      	$(materialcapacity_f.target).textbox({disabled: false});//可编辑
        }
    }

    
    function remove() {

        var rows = $("#equipmentcapacity_dg").datagrid("getSelections");
		if(rows.length<=0){
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
    		return;
		}
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#equipmentcapacity_dg").datagrid("getRowIndex", rows[i]);
            $("#equipmentcapacity_dg").datagrid("deleteRow", index);
        }

    }
    
    function save() {
        var dg = $("#equipmentcapacity_dg");

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
			
			//$("#equipmentcapacity_dg").datagrid("reload");
            ext.tip.error("<spring:message code="tip.nosave" />")
		}else{
        
        ext.ajax.sendJson(saveChanges, {
            inserted : inserted,
            updated : updated,
            deleted : deleted
        }, function(data) {
            if (data.message == '代码重复') {
             //$("#equipmentcapacity_dg").datagrid("reload");
                ext.tip.error(data.message);
                $("#equipmentcapacity_dg").datagrid("beginEdit", 0);
            }else{
                $("#equipmentcapacity_dg").datagrid("reload");
                ext.tip.suc("<spring:message code="tip.success" />");
            }

        });
        }
    }
    

 

    function cancel() {
        $("#equipmentcapacity_dg").datagrid("rejectChanges");
    }
 function showhide() {
    	$("#Equipmentcapacity_search_form").toggle();
    }


</script>