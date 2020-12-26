<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    
    function showOrHide(){
        if($("#EquipmentStopRecord_search_form").is(":hidden")){
            $("#EquipmentStopRecord_search_form").show();
        }else{
            $("#EquipmentStopRecord_search_form").hide();
        }
    }
    /**
	 *数据字典传值
	 *
	 */
	function codeFormatter(v, r, i) {
	
		return dictFormat(v);
	}
	function clearEquipCode(){
		$('#equip_code_s').combobox('clear');
	}
	//更改行颜色
    function rowStylerChange(index,row){
    	if(row.downtime_status_s=="160003"||row.downtime_status_s=="160004"){
    		return 'background-color:#cef7ae;';
    	}else{
    		return 'background-color:#f5cfda;';
    	}
    }
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("equipmentstoprecord_dg","EquipmentStopRecord_search_form");
    }
    
  //查询栏按时间查询
    $(function(){
    	$("#start_time").datetimebox({
    	    value:'3/4/2010 00:00:00',
    	    required: false,
    	    showSeconds: true
    	});
    	$("#end_time").datetimebox({
    	    value:'3/4/2010 23:59:59',
    	    required: false,
    	    showSeconds: true
    	});
    	var opts = $("#equipmentstoprecord_dg").datagrid("options");
        opts.url = 'building/productionmanagement/equipmentstoprecord/datagrid';
    	filter();
    });






</script>