<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    function showOrHide(){
        if($("#Checkuniformlog_search_form").is(":hidden")){
            $("#Checkuniformlog_search_form").show();
        }else{
            $("#Checkuniformlog_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
    	var opts = $("#checkuniformlog_dg").datagrid("options");
        opts.url = 'finalcheck/qualityInspectionRecord/checkuniformlog/datagrid';
        ext.easyui.grid.search("checkuniformlog_dg","Checkuniformlog_search_form");
    }
    
    
    function codeFormatter(v, r, i) {
		return dictFormat(v);
	}
    
	var entCodeName = [];
	$.ajax({
		url : "finalcheck/baseData/entmodel/SearchEnt?equip_type=254005",
		type : "get",
		dataType : "json",
		async : true,
		success : function(data) {
			entCodeName = data;
		}
	});

	function entCodeFormatter(v, r, i) {
		for (var i = 0; i < entCodeName.length; i++) {
			if (v == entCodeName[i].EQUIP_NAME) {
				return entCodeName[i].DESCRIPTION;
			}
		}
	}

	//设定时间初始值从当前时间00:00:00至23:59:59
	$(document).ready(function() {
		$('#begin_created_time').datetimebox({
			value : '3/4/2010 00:00:00',
			required : true,
			showSeconds : true
		});
		$('#end_created_time').datetimebox({
			value : '3/4/2010 23:59:59',
			required : true,
			showSeconds : true
		});
		filter();
	});
	
	   
    function doExport(){
    	var param=ext.form.getFormAsJson("Checkuniformlog_search_form");
    	var param_get="";
    	
    	for(var k in param){
    		param_get=param_get+"&"+k.replace("filter[","").replace("]","")+"="+param[k];
    	}
    	window.open(path+"finalcheck/qualityInspectionRecord/checkuniformlog/exportCSV?s_factory_s="+factory+param_get);
    }
</script>