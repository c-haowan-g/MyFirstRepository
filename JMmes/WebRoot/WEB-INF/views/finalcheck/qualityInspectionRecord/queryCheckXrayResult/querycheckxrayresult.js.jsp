<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(function() {
		$("#checktime_start").datetimebox({
			value : '3/4/2010 00:00:00',
			required : false,
			showSeconds : true
		});
		$("#checktime_end").datetimebox({
			value : '3/4/2010 23:59:59',
			required : false,
			showSeconds : true
		});

		filter();
	});

	/**
	 * 查询方法
	 */
	var filter = function() {
		var opts = $("#checkxrayresult_dg").datagrid("options");
		opts.url = 'finalcheck/qualityInspectionRecord/queryCheckXrayResult/datagridUDA';
		ext.easyui.grid.search("checkxrayresult_dg",
				"CheckXrayResult_search_form");
	}

	/* function defec(v,r,i){
	   	 
	var row=$("#checkxrayresult_dg").datagrid("getData").row[i];
	 var count=row.checkseq_i;
	 var value="";
	$.ajax({
	url:"finalcheck/qualityInspectionRecord/queryCheckXrayResult/SearchDefectName",
	type:"get",
	dataType:"json",
	data:{
		//病象编号：v
		defectid_s:v,
		checkseq_i:count
	},
	async:true,
	success:function(data){
		//循环拼接字段
		for(var a = 0;a <= data.length;a++){
			value+=data[a].defectid_s;
			
		}
	}
	});
	return value;
	}
	
	 */

	function defec(v, r, i) {
		var row = $("#checkxrayresult_dg").datagrid("getData").rows[i];
		var count = row.checkseq_i;
		if (row.gradeid_s == "253001") {

			return "";

		}
		var code = row.tyrebarcode_s;
		var starttime = $('#checktime_start').val();
		var endtime = $('#checktime_end').val();
		var val = "";
		/* console.log(count);
		console.log(barcode);
		console.log(starttime);
		console.log(endtime);  */
		$
				.ajax({
					url : "finalcheck/qualityInspectionRecord/queryCheckXrayResult/SearchDefectName",
					type : "get",
					dataType : "json",
					data : {
						count : count,
						code : code,
						starttime : starttime,
						endtime : endtime
					},
					async : false,
					success : function(data) {
						//console.log(data);
						if (data.length > 0) {
							val = data[0];

							//$(getEditor(index, "defectid_s").target).textbox('setValue',data[0]);
						}
					}
				});
		return val;
	}
	var entCodeName = [];
	$.ajax({
		url : "finalcheck/baseData/entmodel/SearchEnt?equip_type=254003",
		type : "get",
		dataType : "json",
		async : true,
		success : function(data) {
			entCodeName = data;
		}
	});

	function entCodeFormatter(v, r, i) {
		for (var i = 0; i < entCodeName.length; i++) {
			if (v == entCodeName[i].EQUIP_NAME) {
				return entCodeName[i].DESCRIPTION;
			}
		}
	}

	/* function defectFormatter(v,r,i){
		for(var i=0;i<defectCodeName.length;i++){
			if(v==""){
				return "";
			}
			var defect=v.split(",");
			for(var j=0;j<defect.length;j++){
				 if(defect[j]==defectCodeName[i].REAS_CODE_S){
		    			return defectCodeName[i].REAS_CN_S;
		    	 }
			}
		}
	}    */

	/////////浏览器视口的宽度
	function windowWidth() {
		var num = 20;
		var myWidth = 0;
		if (typeof (window.innerWidth) == 'number') {
			//Non-IE
			myWidth = window.innerWidth - num;
		} else if (document.documentElement
				&& (document.documentElement.clientWidth)) {
			//IE 6+ in 'standards compliant mode'
			myWidth = document.documentElement.clientWidth - num;
		} else if (document.body && (document.body.clientWidth)) {
			//IE 4 compatible
			myWidth = document.body.clientWidth - num;
		}
		return myWidth;
	}

	////////浏览器视口的高度
	function windowHeight() {
		var num = 40;
		var myHeight = 0;
		if (typeof (window.innerHeight) == 'number') {
			//Non-IE
			myHeight = window.innerHeight - num;
		} else if (document.documentElement
				&& (document.documentElement.clientHeight)) {
			//IE 6+ in 'standards compliant mode'
			myHeight = document.documentElement.clientHeight - num;
		} else if (document.body && (document.body.clientHeight)) {
			//IE 4 compatible
			myHeight = document.body.clientHeight - num;
		}
		return myHeight;
	}

	function openXgpic() {
		var rows = $("#checkxrayresult_dg").datagrid('getSelected');
		var rowslength = $("#checkxrayresult_dg").datagrid('getSelections');
		if (rows == null) {
			ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
			return;
		} else if (rowslength.length != 1) {
			ext.tip.error("<spring:message code="maintyre.column.xgtp" />");
			return;
		} else {
			$("#xgtp").html("");//清空div
			$
					.ajax({
						url : "finalcheck/qualityInspectionRecord/queryCheckXrayResult/getFtpImage?filepath="
								+ rows.imagesavepath_s
								+ "&title="
								+ rows.imagename_s,
						type : "get",
						dataType : "text",
						async : true,
						success : function(data) {
							if (data.indexOf("请检查") > -1) {
								ext.tip.error(data);
							} else {
								$("#xgtp").window('open');
								$("#xgtp").panel({
									title : rows.imagename_s
								});
								$("#xgtp")
										.append(
												"<img src='finalcheck/qualityInspectionRecord/queryCheckXrayResult/getFtpImage?filepath="
														+ rows.imagesavepath_s
														+ "&title="
														+ rows.imagename_s
														+ "'  title='"
														+ rows.imagename_s
														+ "'/>");
							}
						}
					});
		}
	}

	function codeFormatter(val) {
		return dictFormat(val)
	}
</script>