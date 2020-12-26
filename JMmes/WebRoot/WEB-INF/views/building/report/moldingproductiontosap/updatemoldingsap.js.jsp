<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("UpdateMoldingSap_dg","UpdateMoldingSap_search_form");
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
    	});debugger
    	var opts = $("#UpdateMoldingSap_dg").datagrid("options"); //options-返回选项对象
		opts.url = 'building/productionManagement/workOrderResult/searchUpdateData';  //url-从远程站点请求数据
    	ext.easyui.grid.search("UpdateMoldingSap_dg","UpdateMoldingSap_search_form");//封装函数，根据查询条件自动加载页面数据
    });
    //冲产按钮
    function updatesolid(){
    	var selectrows=$("#UpdateMoldingSap_dg").datagrid("getChecked"); //getchecked-返回复选框选中的全部行
          
        if(selectrows.length==0){
            ext.tip.warn(tipSelectAtLeastOne);
            return;
        }
    	var beginTime,endTime;//起止时间
    	beginTime= $('#start_time').datetimebox('getValue');//获取当前值
    	endTime=$('#end_time').datetimebox('getValue');
    	ext.ajax.sendJson("building/productionManagement/workOrderResult/updatesolid",{
    		   begintime:beginTime,
    		   endtime:endTime,
    		   selectedrows:selectrows    //selectedrows为在DTO实体层定义的List<WorkOrderResultReport>对象
    	}, function(data){
            if(data.code==OK){
            	var index = -1;
        		for (var i = 0; i < selectrows.length; i++) {
        			index = $("#UpdateMoldingSap_dg").datagrid("getRowIndex", selectrows[i]); //返回指定行的索引,row参数可为一个行记录或者一个ID字段的值
        			$("#UpdateMoldingSap_dg").datagrid("deleteRow", index);
        		}
        		ext.tip.suc();  //页面提示冲产成功
            }
            if(data.code==ERROR){
            	ext.tip.error("冲产失败");  //页面提示冲产失败
            }
        });
    }
</script>