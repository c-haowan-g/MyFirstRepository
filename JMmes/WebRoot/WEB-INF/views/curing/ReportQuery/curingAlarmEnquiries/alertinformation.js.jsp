<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	/**
	 *数据字典传值
	 *
	 */
	function codeFormatter(v, r, i) {

		return dictFormat(v);
	}
	function spearFormater(v, r, i){
		if(v == "") {
			return "";
		}
		var row=$("#alertinformation_dg").datagrid("getData").rows[i];
		var url='curing/ReportQuery/curingAlarmEnquiries/getReasNameByCode';
		if(row.alert_code_s != "235007") {
			if(v=="1"){
				return "质检员通过";
			}else if(v=="0"){
				return "质检员不通过";
			}else if(v=="2"){
				return "操作工放行";
			}else if(v=="3"){
				return "操作工不通过";
			}else{
				return v;
			}
		}else {
	    	$.ajax({
	    		url:url,
	    		type:'get',
	    		dataType:'json',
	    		async:false,
	    		data: {
	    		    reas_code: v
	    		},
	    		success:function(data){
	    		 	if(data.length > 0) {
					    v = data[0].reas_cn_s;
				    }
				}
	    	});
	    	return v;
		}
	}
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
	 * 查询方法
	 */
	var filter = function() {
		var starttime = $("#start_time").datetimebox("getValue");
		var endtime = $("#end_time").datetimebox("getValue");
		if (starttime != "" && endtime != "") {
			if (starttime > endtime) {
				ext.tip.error("<spring:message code="tip.date" />");
			} else {
				$("#alertinformation_dg").datagrid("options").url = "curing/ReportQuery/curingAlarmEnquiries/getAlertinformation";
				ext.easyui.grid.search("alertinformation_dg",
						"Alertinformation_search_form");
			}
		} else {
			$("#alertinformation_dg").datagrid("options").url = "curing/ReportQuery/curingAlarmEnquiries/getAlertinformation";
			ext.easyui.grid.search("alertinformation_dg",
					"Alertinformation_search_form");
		}
	}
	//参数修改报警信息，机台编码显示产线，部分L,R
	//20200917区分左右
	/* function equipFormatter(v,r){
		if(r.alert_code_s=="235003"){
			data=v.substring(0,6);
			return data;
		}else{
			return v;
		}
		
	} */
</script>