<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	/**
	 *数据字典传值
	 *
	 */
	function codeFormatter(v, r, i) {
	
		return dictFormat(v);
	}
    
/*    查询栏 */
    function queryBar() {
		$("#Scheduling_dg_toolbar").toggle(500);
	}
	
	$(function(){
		var day=new Calendar().format("yyyy-MM-dd");
		 $("#product_date_s").textbox("setValue",day);
		 var starttime = new Date(Date.parse("00:00:00"));
		 console.log(starttime)
		 /* if(starttime<day<endtime){
			 $("#class_id_s").textbox("setValue","302001");
		 } */
		 $("#scheduling_dg").datagrid("options").url= 'curing/productionManagement/shiftQuery/getScheduling';
			
		 		 filter();
	})
    
    /**
     * 查询方法
     */
	function filter(){
        ext.easyui.grid.search("scheduling_dg","Scheduling_search_form");
    }

    /* 打开未领用机台窗口 */
	function equWin(){
		 $("#equ_dg").datagrid("reload");
		$('#w').window('open');
	}
</script>