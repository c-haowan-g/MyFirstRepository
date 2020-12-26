<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
   
	$(document).ready(function() {
		$('#planstarttime_t').datetimebox({
			value : '3/4/2010 00:00:00',
			required : false,
			showSeconds : true
		});
		$('#planfinishtime_t').datetimebox({
			value : '3/4/2010 23:59:59',
			required : false,
			showSeconds : true
		});
	    filter();
	});
	
	/**
	 *数据字典传值
	 *
	 */
	function codeFormatter(v, r, i) {
 		return dictFormat(v);
	}
	
    function showOrHide(){
        if($("#ProjectTrack_search_form").is(":hidden")){
            $("#ProjectTrack_search_form").show();
        }else{
            $("#ProjectTrack_search_form").hide();
        }
    }
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
     * 查询方法
     */
    var filter=function(){
    	var opts = $("#projecttrack_dg").datagrid("options");
		opts.url = 'halfpart/productionplan/projecttrack/searchInit';
        ext.easyui.grid.search("projecttrack_dg","ProjectTrack_search_form");
    }
    
	//合并单元格
	function onLoadSuccess(data) {
		var mark = 1; //这里涉及到简单的运算，mark是计算每次需要合并的格子数
		for (var i = 1; i < data.rows.length; i++) { //这里循环表格当前的数据
			if ((data.rows[i]['spare1_s'] == data.rows[i - 1]['spare1_s'])) { //后一行的值与前一行的值做比较，相同就需要合并
				mark += 1;
				$(this).datagrid('mergeCells', { //判断合并复选框
					index : i + 1 - mark,
					field : 'atr_key',
					rowspan : mark
				});
				$(this).datagrid('mergeCells', { //这是判断机台号
					index : i + 1 - mark,
					field : 'spare1_s',
					rowspan : mark
				});
			} else {
				mark = 1;
			}
		}
	} 
    
	//-----------------------------点击选中合并的所有行
	//判断rowIndex是否被选中
	//调用方法：$("#dg").datagrid("isChecked", { rowIndex: rowIndex })
	 $.extend($.fn.datagrid.methods, {
		isChecked : function(dg, param) {
			console.log(dg);
			var flag = false;//是否选中
			var allRows = $(dg).datagrid('getChecked'); //获取所有被选中的行
			$.each(allRows, function(index, item) {
				if (param.rowIndex == $(dg).datagrid('getRowIndex', item)) {
					flag = true;
					return false;//return false终止循环，return true,跳出循环，进入下一次循环，跟函数返回值无关
				}
			});
			return flag;
		}
	});
	
	 var index = "a";//选择合并所有行用到

	function onCheck(rowIndex, rowData) {
		if (index == "a") {
			index = rowIndex;
			var equip_code_s = rowData["equip_code_s"];
			var rows = $("#projecttrack_dg")
					.datagrid("getRows");
			for (var i = 0; i < rows.length; i++) {
				if (rows[i]["equip_code_s"] == equip_code_s) {
					$("#projecttrack_dg")
							.datagrid("checkRow", i);
				}
			}
			index = "a";
		}
	}
	function onUncheck(rowIndex, rowData) {
		if (index == "a") {
			index = rowIndex;
			var equip_code_s = rowData["equip_code_s"];
			var rows = $("#projecttrack_dg")
					.datagrid("getRows");
			for (var i = 0; i < rows.length; i++) {
				if (rows[i]["equip_code_s"] == equip_code_s) {
					$("#projecttrack_dg")
							.datagrid("uncheckRow", i);

				}
			}
			index = "a";
		}
	} 

	
	function progressBar(v,r,i){
		 var htmlstr =null;
		 if(v<=25){
			  htmlstr = "<div class='easyui-progressbar progressbar easyui-fluid' style='width:100px'><div class='progressbar-text' style='width:100px;z-index:100'>"+ v + "%</div> <div class='progressbar-value'  style='width:"+ v + "%;background-color:red'>&nbsp;&nbsp;</div></div>"; 

			 }else if(v>25&&v<=50){
				  htmlstr = "<div class='easyui-progressbar progressbar easyui-fluid' style='width:100px'><div class='progressbar-text' style='width:100px;z-index:100'>"+ v + "%</div> <div class='progressbar-value'  style='width:"+ v + "%;background-color:blue'>&nbsp;&nbsp;</div></div>"; 
			 }else if(v>50&&v<=75){
				  htmlstr = "<div class='easyui-progressbar progressbar easyui-fluid' style='width:100px'><div class='progressbar-text' style='width:100px;z-index:100'>"+ v + "%</div> <div class='progressbar-value'  style='width:"+ v + "%;background-color:orange'>&nbsp;&nbsp;</div></div>"; 
			 }else if(v>75&&v<=100){
				  htmlstr = "<div class='easyui-progressbar progressbar easyui-fluid' style='width:100px'><div class='progressbar-text' style='width:100px;z-index:100'>"+ v + "%</div> <div class='progressbar-value'  style='width:"+ v + "%;background-color:pink'>&nbsp;&nbsp;</div></div>"; 
			 }else{
				  htmlstr = "<div class='easyui-progressbar progressbar easyui-fluid' style='width:100px'><div class='progressbar-text' style='width:100px;z-index:100'>"+ v + "%</div> <div class='progressbar-value'  style='width:"+ v + "%;background-color:yellow'>&nbsp;&nbsp;</div></div>"; 
			 }
		 /* if(v<=50){
		  htmlstr = '<div class="easyui-progressbar progressbar easyui-fluid" style="width: 100%; height: 20px;"><div  style="width: 100%; height: 20px; line-height: 20px;"><div class="progressbar-text" style="background-color:red;width: ' + v +'%'+ '; height: 20px; line-height: 20px;">' + v + '%</div></div></div>';
		 }else if(v>50&&v<=100){
		  htmlstr = '<div class="easyui-progressbar progressbar easyui-fluid" style="width: 100%; height: 20px;"><div  style="width: 100%; height: 20px; line-height: 20px;"><div class="progressbar-text" style="background-color:purple;width: ' + v +'%'+ '; height: 20px; line-height: 20px;">' + v + '%</div></div></div>'; 
		 }else{
		  htmlstr = '<div class="easyui-progressbar progressbar easyui-fluid" style="width: 100%; height: 20px;"><div  style="width: 100%; height: 20px; line-height: 20px;"><div class="progressbar-text" style="background-color:yellow;width: ' + v +'%'+ '; height: 20px; line-height: 20px;">' + v + '%</div></div></div>';  
		 } */
		 return htmlstr;
	}
</script>