<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    
    var jtxx=[];
    //加载产线信息
    $.ajax({
    	url:'curing/reportQuery/scheduleReport/reportOfPlanSchedule/searchByProductLine',
    	type:'get',
    	dataType:'json',
    	async:false,
    	success:function(data){
    		jtxx=data;
    	}
    });
    function searchProductionLine(q, row){
    	var opts = $(this).combobox('options');
        return row[opts.textField].toUpperCase().indexOf(q.toUpperCase()) >= 0;
    }
    /**
     * 日期格式化
     */
    function dateFormat(date){
    	return new Calendar(date).format("yyyyMMdd");
    }
    
    /**
     * 解析指定格式日期
     */
    function dateParser(s){
    	if(!s)return new Date();
    	return new Date(s.substring(0,4),parseInt(s.substring(4,6))-1,s.substring(6,8));
    }
    
    
    /**
     * 设置datagrid进度条
     */
    function progressFormatter(value,rowData,rowIndex){
    	//完成进度(左)
    	if(this.field=="qty_dayproduct_left_bl"){
    		if(rowData.qty_dayproduct_left_i=="0"||rowData.quantity_dayplan_left_i=="0"){
        		value=0;
        	}else{
        	   value=rowData.qty_dayproduct_left_i/rowData.quantity_dayplan_left_i;
        	}
    		
    	}
    	//完成进度(右)
    	if(this.field=="qty_dayproduct_right_bl"){
    		if(rowData.qty_dayproduct_right_i=="0"||rowData.quantity_dayplan_right_i=="0"){
        		value=0;
        	}else{
        	   value=rowData.qty_dayproduct_right_i/rowData.quantity_dayplan_right_i;
        	}
    		
    	}
    	//早班完成量(左)
    	if(this.field=="qty_dayproduct_left_zbwcbfb"){
    		if(rowData.output_morclass_left_i=="0"||rowData.planamount_mor_left_i=="0"){
        		value=0;
        	}else{
        	   value=rowData.output_morclass_left_i/rowData.planamount_mor_left_i;
        	}
    		
    	}
    	//中班完成量(左)
    	if(this.field=="qty_dayproduct_left_zwbwcbfb"){
    		if(rowData.output_midclass_left_i=="0"||rowData.planamount_mid_left_i=="0"){
        		value=0;
        	}else{
        	   value=rowData.output_midclass_left_i/rowData.planamount_mid_left_i;
        	}
    		
    	}
    	//晚班完成量(左)
    	if(this.field=="qty_dayproduct_left_wbwcbfb"){
    		if(rowData.output_nigclass_left_i=="0"||rowData.planamount_nig_left_i=="0"){
        		value=0;
        	}else{
        	   value=rowData.output_nigclass_left_i/rowData.planamount_nig_left_i;
        	}
    		
    	}
    	//早班完成量(右)
    	if(this.field=="qty_dayproduct_right_wbwcbfb"){
    		if(rowData.output_morclass_right_i=="0"||rowData.planamount_mor_right_i=="0"){
        		value=0;
        	}else{
        	   value=rowData.output_morclass_right_i/rowData.planamount_mor_right_i;
        	}
    		
    	}
    	//中班完成量(右)
    	if(this.field=="qty_dayproduct_right_zwcbfb"){
    		if(rowData.output_midclass_right_i=="0"||rowData.planamount_mid_right_i=="0"){
        		value=0;
        	}else{
        	   value=rowData.output_midclass_right_i/rowData.planamount_mid_right_i;
        	}
    		
    	}
    	//晚班完成量(右)
    	if(this.field=="qty_dayproduct_right_wcbwcbfb"){
    		if(rowData.output_nigclass_right_i=="0"||rowData.planamount_nig_right_i=="0"){
        		value=0;
        	}else{
        	   value=rowData.output_nigclass_right_i/rowData.planamount_nig_right_i;
        	}
    		
    	}
    	return "<div class='easyui-progressbar progressbar easyui-fluid' style='width:100px'><div class='progressbar-text' style='width:100px;z-index:100'>"+ (value*100).toFixed(2) + "%</div> <div class='progressbar-value'  style='width:"+ (value*100).toFixed(2) + "%;background-color:#00FF99'>&nbsp;&nbsp;</div></div>"; 
    	
    }
    
    function showOrHide(){
        if($("#ReportOfPlanSchedule_search_form").is(":hidden")){
            $("#ReportOfPlanSchedule_search_form").show();
        }else{
            $("#ReportOfPlanSchedule_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
    	var opts = $("#reportofplanschedule_dg").datagrid("options");
        opts.url = 'curing/reportQuery/scheduleReport/reportOfPlanSchedule/datagrid';
        ext.easyui.grid.search("reportofplanschedule_dg","ReportOfPlanSchedule_search_form");
    }

</script>