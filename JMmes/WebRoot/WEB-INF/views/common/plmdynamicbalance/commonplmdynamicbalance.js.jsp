<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"common/plm/commonplmdynamicbalance/saveChanges";
	function codeFormatter(v, r, i) {
		return dictFormat(v);
	}
	function clearStatus(){
		$('#send_state_s').combobox('clear');
	}
	function clearcheckStatus(){
		$('#check_state_s').combobox('clear');
	}
	function cellStyler(v, r, i){
		if(v==1){
			return 'background-color:#99FF33;';
		}else{
			return 'background-color:#FFC16B;';
		}
	}
	function recipeStatusCellStyler(v, r, i){
		if(v==323002){
			return 'background-color:#99FF33;';
		}else if(v==323003){
			return 'background-color:#FFC16B;';
		}
	}
    function auditStatusFormatter(v, r, i){
    	if(v==0){
    		return "未审核";
    	}else if(v==1){
    		return "已审核";
    	}else{
    		return "未审核";
    	}
    }
	function letdownformatter(v, r, i){
		if(v==0){
    		return "未下发";
    	}else if(v==1){
    		return "已下发";
    	}else{
    		return "未下发";
    	}
	}
	
    function showOrHide(){
        if($("#CommonPlmDynamicBalance_search_form").is(":hidden")){
            $("#CommonPlmDynamicBalance_search_form").show();
        }else{
            $("#CommonPlmDynamicBalance_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("commonplmdynamicbalance_dg","CommonPlmDynamicBalance_search_form");
    }

    //下发
    function letdown(){
 	   ext.ajax.post("common/plm/commonplmdynamicbalanceedit/letdown",{recipecodelist:getRecipecodelist().toString()},function(data){
 	   		if(data.code==OK){
 	   			showConfirm(data.data);
 	   			return;
 	   		}
 	   		ext.tip.error(data.message);
 	   	});
  }
   //启用
    function startstandard(){
 	   ext.ajax.post("common/plm/commonplmdynamicbalanceedit/startstandard",{recipecodelist:getRecipecodelist().toString()},function(data){
 	   		if(data.code==OK){
 	   			showConfirm(data.data);
 	   			return;
 	   		}
 	   		ext.tip.error(data.message);
 	   	});
    }
    //停用
    function stopstandard(){
 	   ext.ajax.post("common/plm/commonplmdynamicbalanceedit/stopstandard",{recipecodelist:getRecipecodelist().toString()},function(data){
 	   		if(data.code==OK){
 	   			showConfirm(data.data);
 	   			return;
 	   		}
 	   		ext.tip.error(data.message);
 	   	});
    }
  
   
   //显示操作结果
   function showConfirm(msg){
	   $.messager.confirm({
		    width: 700,
		    height: 350,
		    title: '操作结果',
		    msg: msg,
		    fn: function (r) {
		    	  filter();
		        }
		    }
		);
   }
   //获取选择行数据
   function getRecipecodelist(){
	   var rows=getDg().datagrid("getChecked");
	   	if(rows.length==0){
	   		ext.tip.warn(tipSelectAtLeastOne);
	   		return;
	   	}
	   	
	   	var recipecodelist=[];
	   	
	   	for(var i=0;i<rows.length;i++){
/* 	   		if(rows[i].status_s!='218001'){
	   			ext.tip.warn((i+1)+"<spring:message code="tip.row" /><spring:message code="tip.audited" />");
	   			return;
	   		} */
	   		recipecodelist.push(rows[i].recipe_code_s);
	   	}
	   	return recipecodelist;
   }
   function getDg(){
   	return $("#commonplmdynamicbalance_dg");
   }
</script>