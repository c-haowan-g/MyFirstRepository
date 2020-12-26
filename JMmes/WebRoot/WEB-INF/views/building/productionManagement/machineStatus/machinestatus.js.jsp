<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    $('#materialcode_s').combobox({
		filter: function(q, row){
			var opts = $(this).combobox('options');
			return row[opts.textField].indexOf(q) != -1;
		}
	});
  $('#machinebarcode_s').combobox({
		filter: function(q, row){
			var opts = $(this).combobox('options');
			return row[opts.textField].indexOf(q) != -1;
		}
	});
  
    var enttypeList=[];
	$.ajax({
		url:"building/productionManagement/machineStatus/getcxEquipcodetype",
		type:"get",
		dataType:"json",
		async:false,
		success:function(data){
			debugger;
			enttypeList=data;
		}
	});
  
  
	/**
	 * 基础数据text显示
	 */
	function codeFormatter(v, r, i) {
	  if(v==null){
		  return "";
	  }
		return dictFormat(v);
	}
    function autohandFormatter(v,r,i){
    	if(v==0){
		   return "手动";
		 }else if(v==1){
			return "自动";
		} else{
			return "未知";
		 }
    }
    function producttypeFormatter(v,r,i){
    	if(v==0){
		   return "单条";
		 }else if(v==1){
			return "批量";
		} else{
			return "未知";
		 }
    }
	/**
	 * 接收combtree数据
	 */
	var DICT_189=[];
	
	$.ajax({
		url:"dict/code/189",
		type:"get",
		dataType:"json",
		async:false,
		success:function(data){
			DICT_189=data;
		}
	});
	/**
	 * 接收combtree数据
	 */
	var DICT_101=[];
	
	$.ajax({
		url:"dict/code/101",
		type:"get",
		dataType:"json",
		async:false,
		success:function(data){
			DICT_101=data;
		}
	});
    function showOrHide(){
        if($("#MachineStatus_search_form").is(":hidden")){
            $("#MachineStatus_search_form").show();
        }else{
            $("#MachineStatus_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("machinestatus_dg","MachineStatus_search_form");
    }
    
	function clearMaterial(){
		$('#materialcode_s').combobox('clear');
	}
</script>