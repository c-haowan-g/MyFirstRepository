<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

/**
 * 接收设备数据
 */
 var EquipInfo=[];
	
	$.ajax({
		url:"common/devicelist/getEquipcodeAndName",
		type:"get",
		dataType:"json",
		async:false,
		success:function(data){
			EquipInfo=data;
		}
	});
function equipFormatter(v,r,i){
		for (var i = 0; i < EquipInfo.length; i++) {
			if(EquipInfo[i].CODE==v){
				return EquipInfo[i].NAME;
			}
		}
		return "PLM设备表未维护";
	}
    
    function showOrHide(){
        if($("#BuilDingProcess_search_form").is(":hidden")){
            $("#BuilDingProcess_search_form").show();
        }else{
            $("#BuilDingProcess_search_form").hide();
        }
    }
    
	function selectrow(){
		var rows=$("#buildingprocess_dg").datagrid('getSelected');
		var key=rows.route_name;
		var url ="building/quailtyManageMent/buildingProcess/datagrid2?key="+key;
		ext.ajax.get(url, function(data) {
			 $('#buildingprocess_dg2').datagrid('loadData',data);
	});
	}
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("buildingprocess_dg","BuilDingProcess_search_form");
    	$('#buildingprocess_dg2').datagrid('loadData',[]);
    }
    
    function codeFormatter(v, r, i) {
		return dictFormat(v);
	}


    function cancel() {
        $("#buildingprocess_dg").datagrid("rejectChanges");
    }
    function flag(v, r, i) {

		if (v == 'A') {
			return "是";
		}
		return "否";
	}
    
    function valuemax(v, r, i) {
		if (v == '1') {
			return "包含";
		}
		return "不包含";
	}
    //隐藏查询栏
    function searchBar()
	{
		$("#BuilDingProcess_search_form").toggle();
	}

    /**
     * 接收色标线数据
     */
     var colorLineInfo=[];
 	
 	$.ajax({
 		url:"building/quailtyManageMent/buildingProcess/colorMarkingLine",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			colorLineInfo=data;
 		}
 	});
	//色标线转换
	function colorMarkingLineFormatter(v,r,i){
		if(r.PARMNAME_S.indexOf("色标")!=-1){
			debugger;
			for(var i=0;i<colorLineInfo.length;i++){
				if(r.VALUE_S==colorLineInfo[i].ERPCODE_S){
					return colorLineInfo[i].DICTNAME_S;
				}
			}
		}
		else{
			return v;
		}
	}

</script>