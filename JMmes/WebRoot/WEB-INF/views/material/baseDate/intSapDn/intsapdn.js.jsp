<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"common/intsapdn/saveChanges";
    
    function showOrHide(){
        if($("#IntSapDn_search_form").is(":hidden")){
            $("#IntSapDn_search_form").show();
        }else{
            $("#IntSapDn_search_form").hide();
        }
    }
  //设定时间初始值从当前时间00:00:00至23:59:59
	/*  $(document).ready(function() {
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
	});  */
	
  
  
	 /**
		 * 日期格式化
		 */
		function dateFormat(date) {
			return new Calendar(date).format("yyyyMMdd");
		}
		/**
		 * 解析指定格式日期
		 */
		function dateParserStart(s) {
			debugger
			if (!s)
				return new Date();
			return new Date(s.substring(0, 4), parseInt(s.substring(4, 6)) - 1, s
					.substring(6, 8));
		}
		/**
		 * 解析指定格式日期
		 */
		function dateParserEnd(s) {
			debugger
			if (!s)
				return new Date();
			return new Date(s.substring(0, 4), parseInt(s.substring(4, 6)) - 1, s
					.substring(6, 8));
		}
		 //表格加载前事件
		function onDgBeforeLoad(param) {
			if ($("#begin_deliverydate_time").datebox("getValue") == "") {
				return false;
			}
			
			param["filter[begin_deliverydate_time]"] = $("#begin_deliverydate_time").datebox(
					"getValue");
			if ($("#end_deliverydate_time").datebox("getValue") == "") {
				return false;
			}
			
			param["filter[end_deliverydate_time]"] = $("#end_deliverydate_time").datebox(
			"getValue");
			
		}
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("intsapdn_dg","IntSapDn_search_form");
    }
    
   

  

</script>