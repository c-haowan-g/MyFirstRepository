<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"halfpart/report/calibRationRecord/calibRationRecord/saveChanges";
    /**
     * 加载机台信息
     * 时永良 
     * 2020年3月7日13:30:583
    */
    var productLineList=[];
    $.ajax({
        url:"halfpart/basedata/productlinemanager/getHalfPartProductionLine",
        type:"get",
        dataType:"json",
        async:false,
        success:function(data){
        	productLineList=data;
        }
    });
    
    /**
     * 班次显示转化
     * 兰颖慧
     * 2019-08-01
     */
    var classList=[];
    $.ajax({
        url:"dict/code/118",
        type:"get",
        dataType:"json",
        async:false,
        success:function(data){
        	classList=data;
        }
    });
    
    
    /**
     * 班次显示转化
     * 时永良
     * 2019-08-01
     */
    var classteamList=[];
    $.ajax({
        url:"dict/code/118",
        type:"get",
        dataType:"json",
        async:false,
        success:function(data){
        	classteamList=data;
        }
    });
    
    
    /**
     * 班组显示转化
     * 时永良
     * 2019-08-01
     */
    var classcodeList=[];
    $.ajax({
        url:"dict/code/301",
        type:"get",
        dataType:"json",
        async:false,
        success:function(data){
        	classcodeList=data;
        }
    });
    /**
     * 查询方法
     */
    var filter=function(){
    	var opts = $("#calibrationrecord_dg").datagrid("options");
 		opts.url = 'halfpart/report/calibRationRecord/calibrationrecord/datagrid';
        ext.easyui.grid.search("calibrationrecord_dg","CalibRationRecord_search_form");
    }
    
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

</script>