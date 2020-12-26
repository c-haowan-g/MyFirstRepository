<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    function stepFormatter(v,r,i){
    	if(v=="01"){
    		return "试制";
    	}else if(v=="02"){
    		return "试产";
    	}else{
    		return "投产";
    	}
    }
    
    function showOrHide(){
        if($("#WorkOrder_search_form").is(":hidden")){
            $("#WorkOrder_search_form").show();
        }else{
            $("#WorkOrder_search_form").hide();
        }
    }
    /**
	 * 解析指定格式日期
	 */
	function dateParser(s) {
		if (!s)
			return new Date();
		return new Date(s.substring(0, 4), parseInt(s.substring(4, 6)) - 1, s
				.substring(6, 8));
	}
    /**
	 * 日期格式化
	 */
	function dateFormat(date) {
		return new Calendar(date).format("yyyyMMdd");
	}
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("workorder_dg","WorkOrder_search_form");
    }
    
    function codeFormatter(v,r,i) {
		return dictFormat(v);
	}
    //时间判断 如果开始时间为空，结束时间也为空
    function timeFormatter(v,r,i) {
		if(r.start_time_t == null){
			return "";
		}
		return v;
	}

    
    /**
    *下拉框清除
    *
    */
	function clearMaterial(){
		$('#material_code_s').combobox('clear');
	}
	function clearOrder(){
		$('#order_code_s').combobox('clear');
	}
	function clearPlan(){
		$('#plan_no_s').combobox('clear');
	}
	function clearEquip(){
		$('#equip_code_s').combobox('clear');
	}
</script>