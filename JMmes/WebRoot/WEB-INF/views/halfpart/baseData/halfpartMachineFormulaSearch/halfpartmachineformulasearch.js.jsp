<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"halfpart/baseData/halfpartMachineFormulaSearch/saveChanges";
    
    function showOrHide(){
        if($("#halfpartMachineFormulaSearch_search_form").is(":hidden")){
            $("#halfpartMachineFormulaSearch_search_form").show();
        }else{
            $("#halfpartMachineFormulaSearch_search_form").hide();
        }
    }
    
     /**
    * 获取机台名称信息
    */
    var productLineList=[];
    $.ajax({
         url:"halfpart/halfpartMachineFormulaSearch/halfpartmachineformulasearch/searchEquip_code_s",
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
	  
	  /**
    * 获取半部件用物料信息
    */
     var materialGroupList=[];
    $.ajax({
        url:"halfpart/halfpartMachineFormulaSearch/halfpartmachineformulasearch/searchMaterial_code_s",
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
    * 获取半部件产品阶段信息
    */
     var production_step_sList=[];
    $.ajax({
        url:"halfpart/halfpartMachineFormulaSearch/halfpartmachineformulasearch/searchProduction_step_s",
        type:"get",
        dataType:"json",
        async:true,
        success:function(data){
        	production_step_sList=data;
        }
    });
     /**
    * 产品阶段显示转化
    * 2019-05-20
    * ldx
    */
    function production_step_sFormatter(v, r, i){
         for(var i=0;i<production_step_sList.length;i++){
            if (v == production_step_sList[i].DICTCODE_S) {
                return production_step_sList[i].DICTNAME_S;
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
 	 var DICT_307=[];
 	$.ajax({
 		url:"dict/code/-307",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			DICT_307=data;
 		}
 	}); 
    /**
     * 查询方法
     */
    var filter=function(){
    
        ext.easyui.grid.search("halfpartmachineformulasearch_dg","halfpartMachineFormulaSearch_search_form");
    }
    
    

</script>