<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"building/productionManagement/buildingOverDateSearch/saveChanges";
     //设定时间初始值从当前时间00:00:00至23:59:59
	$(document).ready(function() {
		$('#start_time').datetimebox({
			value : '3/4/2010 00:00:00',
			required : true,
			showSeconds : true
		});
		$('#end_time').datetimebox({
			value : '3/4/2010 23:59:59',
			required : true,
			showSeconds : true
		});
		filter();
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
	function worker1Formatter(v, r, i) {
		if(v == null ){
			return "";
		}
	  	
 		if(r.worker1_id_s==null){
 		r.worker1_id_s=""+r.worker1_name_s;
 		}else if(r.worker1_name_s==null){
 		r.worker1_id_s=r.worker1_id_s+"";
 		}else if(r.worker1_id_s && r.worker1_name_s!=null){
 		r.worker1_id_s=r.worker1_id_s+"|"+r.worker1_name_s;
 		}
 		return r.worker1_id_s;
	}
	function worker2Formatter(v, r, i) {
		if(v == null ){
			return "";
		}
	  if(r.worker2_id_s==null){
 		r.worker2_id_s=""+r.worker1_name_s;
 		}else if(r.worker1_name_s==null){
 		r.worker2_id_s=r.worker2_id_s+"";
 		}else if(r.worker2_id_s && r.worker2_name_s!=null){
 		r.worker2_id_s=r.worker2_id_s+"|"+r.worker2_name_s;
 		}
 		return r.worker2_id_s;
	}
	function worker3Formatter(v, r, i) {
		if(v == null ){
			return "";
		}
 	 if(r.worker3_id_s==null){
 		r.worker3_id_s=""+r.worker3_name_s;
 		}else if(r.worker3_name_s==null){
 		r.worker3_id_s=r.worker3_id_s+"";
 		}else if(r.worker3_id_s && r.worker3_name_s!=null){
 		r.worker3_id_s=r.worker3_id_s+"|"+r.worker3_name_s;
 		}
 		return r.worker3_id_s;
	}
    function showOrHide(){
        if($("#Workorderresult_search_form").is(":hidden")){
            $("#Workorderresult_search_form").show();
        }else{
            $("#Workorderresult_search_form").hide();
        }
    }
    /**
     * 查询方法
     */
    var filter=function(){
        
        var opts = $("#workerorderresult_dg").datagrid("options");
		opts.url ='building/buildingOverDateSearch/buildingoverdatesearch/datagrid';
    	ext.easyui.grid.search("workerorderresult_dg","Workerorderresult_search_form");
    }
    </script>