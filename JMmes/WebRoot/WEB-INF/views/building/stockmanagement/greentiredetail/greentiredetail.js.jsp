<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"building/stockmanagement/greentiredetail/saveChanges";
    
    function codeFormatter(v, r, i) {
    	return dictFormat(v);
    }
    
    function showOrHide(){
        if($("#GreentireDetail_search_form").is(":hidden")){
            $("#GreentireDetail_search_form").show();
        }else{
            $("#GreentireDetail_search_form").hide();
        }
    }
    //设定时间初始值从当前时间00:00:00至23:59:59
	$(document).ready(function() {
		$('#begin_created_time').datetimebox({
			value : '3/4/2010 00:00:00',
			required : false,
			showSeconds : true
		});
		$('#end_created_time').datetimebox({
			value : '3/4/2010 23:59:59',
			required : false,
			showSeconds : true
		});
		filter();
	});
    
	/**
	 * [dateAddDays 从某个日期增加n天后的日期]
	 * @param  {[string]} dateStr  [日期字符串]
	 * @param  {[int]} dayCount [增加的天数]
	 * @return {[string]}[增加n天后的日期字符串]
	 */
	function dateAddDays(dateStr,dayCount) {
		if(dayCount == 0){
			dayCount = '3';
		}
	    var tempDate=new Date(dateStr.replace(/-/g,"/"));//把日期字符串转换成日期格式
	    var resultDate=new Date((tempDate/1000+(86400*dayCount))*1000);//增加n天后的日期
	    var resultDateStr=resultDate.getFullYear()+"-"+(resultDate.getMonth()+1)+"-"+(resultDate.getDate())+" "+dateStr.slice(10);//将日期转化为字符串格式 
	     
	    return resultDateStr;
	}
    
	 function dateTimeFormatter(v, r, i) {
			 
			 return dateAddDays(r.productiondate_t,v/24);
		}

    /**
     * 数据校验
     */
      function checktime(){
          var time1=$("#begin_created_time").val();
          var time2=$("#end_created_time").val();
          if(time1>time2){
              return false;
          }
          return true;
      }
    /**
     * 查询方法
     */
    var filter=function(){
    	if(!checktime()){
            ext.tip.error("<spring:message code="tip.date" />");
            return false;
        }
    	var opts = $("#greentiredetail_dg").datagrid("options");
    	opts.url= 'building/stockmanagement/greentiredetail/datagrid';
        ext.easyui.grid.search("greentiredetail_dg","GreentireDetail_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("greentiredetail_dg",{});
    }

    function edit() {
        var rows = $("#greentiredetail_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#greentiredetail_dg").datagrid("getRowIndex", rows[i]);
            $("#greentiredetail_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#greentiredetail_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#greentiredetail_dg").datagrid("getRowIndex", rows[i]);
            $("#greentiredetail_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#greentiredetail_dg");

        var rows = dg.datagrid("getRows");
        var valid = false;
        for (var i = 0; i < rows.length; i++) {
            if (!dg.datagrid("validateRow", i)) {
                ext.tip.error("<spring:message code="tip.invalid" />");
                return;
            }
        }

        var inserted = dg.datagrid("getChanges", "inserted");
        var updated = dg.datagrid("getChanges", "updated");
        var deleted = dg.datagrid("getChanges", "deleted");

        for (var i = 0; i < rows.length; i++) {
            dg.datagrid("endEdit", i);
        }
        ext.ajax.sendJson(saveChanges, {
            inserted : inserted,
            updated : updated,
            deleted : deleted
        }, function(data) {

            if (data.code!=OK) {
                ext.tip.error("<spring:message code="tip.error" />");
                return;
            }
            $("#greentiredetail_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#greentiredetail_dg").datagrid("rejectChanges");
    }


</script>