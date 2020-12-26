<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
    /**
     * 查询方法
     */
    function filter(){
        ext.easyui.grid.search("sapreturnresult_dg","SapReturnResult_search_form");
    }
    function codeFormatter(v, r, i) {
		return dictFormat(v);
	}
    //设定时间初始值从当前时间00:00:00至23:59:59
    $(function(){
    	$("#start_time").datetimebox({
    	    value: '3/4/2010 00:00:00',
    	    required: true,
    	    showSeconds: true
    	});
    	
    	$("#end_time").datetimebox({
    	    value: '3/4/2010 23:59:59',
    	    required: true,
    	    showSeconds: true
    	});
    	var opts = $("#sapreturnresult_dg").datagrid("options");
		opts.url = 'curing/ProductionManagement/sap_return_result/searchReplenishData';
    	ext.easyui.grid.search("sapreturnresult_dg","SapReturnResult_search_form");
    });
    //固化按钮
    function curing(){
    	var rows=$("#sapreturnresult_dg").datagrid("getChecked");
          
        if(rows.length==0){
            ext.tip.warn(tipSelectAtLeastOne);
            return;
        }
        
    	var beginTime,endTime;//起止时间
    	beginTime= $('#start_time').datetimebox('getValue');
    	endTime=$('#end_time').datetimebox('getValue');
    	debugger
    	ext.ajax.sendJson("curing/ProductionManagement/sap_return_result/guhua",{
    		selectedrows : rows,
			begintime : beginTime,
			endtime : endTime
    	}, function(data){
            /* if(data.code==OK){
            	var index = -1;
        		for (var i = 0; i < rows.length; i++) {
        			index = $("#sapreturnresult_dg").datagrid("getRowIndex", rows[i]);
        			$("#sapreturnresult_dg").datagrid("deleteRow", index);
        		}
        		ext.tip.suc();
            }
            if(data.code==ERROR){
            	ext.tip.error("固化失败");
            } */
            
    		if(data.message!="操作成功"){
            	ext.tip.error(data.message);
            }else{
            	var index = -1;
        		for (var i = 0; i < rows.length; i++) {
        			index = $("#sapreturnresult_dg").datagrid("getRowIndex", rows[i]);
        			$("#sapreturnresult_dg").datagrid("deleteRow", index);
        		}
        		ext.tip.suc();
            }
        });
    }
    
  //明细按钮
    function productionDetail(){
    	var selectrows=$("#sapreturnresult_dg").datagrid("getChecked");
        
        if(selectrows.length==0){
            ext.tip.warn(tipSelectAtLeastOne);
            return;
        }
        if(selectrows.length>1){
            ext.tip.error("<spring:message code="tip.OneSelectedToDetail" />");
            return;
        }
    	//弹出明细窗口
    	$("#workorderresult_detail_dg").dialog("open");
        var beginTime,endTime;//硫化开模起止时间
    	beginTime= $('#start_time').datetimebox('getValue');
    	endTime=$('#end_time').datetimebox('getValue');
    	ext.ajax.sendJson("curing/ProductionManagement/sap_return_result/productionDetail",{
    		   begintime:beginTime,
    		   endtime:endTime,
    		   selectedrows:selectrows
    	}, function(data){
    		  $('#detail_dg').datagrid('loadData', data);
    	}); 
    }
    function testTyreFormatter(v) {
        if(v == 1){
            return "是";
        }else if(v == 0){
            return '否';
        }
    }
</script>