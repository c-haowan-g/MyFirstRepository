<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"finalcheck/dynabalancecheresult/balandproresult/saveChanges";
    
    function showOrHide(){
        if($("#Balandproresult_search_form").is(":hidden")){
            $("#Balandproresult_search_form").show();
        }else{
            $("#Balandproresult_search_form").hide();
        }
    }
    function codeFormatter(v, r, i) {
		return dictFormat(v);
	}
    
    //导出
	function exportExcel(){
		//获取grid 数据
	    var node = $("#balandproresult_dg").datagrid("getSelections");
	 	
	 	if (node != "") {
	 		 var data = JSON.stringify(node);
			    if (data == ''){
			        return;
			    }
			    var myDate = new Date();
			    var time=myDate.toLocaleString();
				var  title=[{machinebar_s:'动平衡机台'},{barcode_s:'轮胎条码'},{curingspeccode_s:'物料编码'},{description:'物料描述'},{created_time_t:'检测时间'},
				            {buildinmachinecode_s:'成型机台'},{buildintime_t:'成型时间'},{curingmachinecode_s:'硫化机台'},{curingtime_t:'硫化时间'},
				            {grade_code_s:'轮胎总等级'},{balance_total_rank_s:'动平衡总等级'},{ro_total_rank_s:'跳动度总等级'},
				            {upper_unbalance_g_s:'动平衡上量'},{upper_unbalance_deg_s:'动平衡上量角度'},{upper_unbalance_rank_s:'动平衡上量等级'},
				            {lower_unbalance_g_s:'动平衡下量'},{lower_unbalance_deg_s:'动平衡下量角度'},{lower_unbalance_rank_s:'动平衡下量等级'},
				            {up_low_unbalance_g_s:'动平衡上量+下量'},{up_low_unbalance_rank_s:'动平衡上量+下量等级'},
				            {static_unbalance_g_s:'静平衡量'},{static_unbalance_deg_s:'静平衡量角度'},{static_unbalance_rank_s:'静平衡量等级'},
				            {couple_unbalance_g_s:'力偶'},{couple_unbalance_deg_s:'力偶角度'},{couple_unbalance_rank_s:'力偶等级'},
				            {lt_oa_mm_s:'上侧侧向跳动值1'},{lt_oa_deg_s:'上侧侧向跳动角度1'},{lt_oa_rank_s:'上侧侧向跳动等级1'},
				            {lt_oa2_mm_s:'上侧侧向跳动值2'},{lt_oa2_deg_s:'上侧侧向跳动角度2'},{lt_oa2_rank_s:'上侧侧向跳动等级2'},
				            {lt_oa3_mm_s:'上侧侧向跳动值3'},{lt_oa3_deg_s:'上侧侧向跳动角度3'},{lt_oa3_rank_s:'上侧侧向跳动等级3'},
				            {lb_oa_mm_s:'下侧侧向跳动值1'},{lb_oa_deg_s:'下侧侧向跳动角度1'},{lb_oa_rank_s:'下侧侧向跳动等级1'},
				            {lb_oa2_mm_s:'下侧侧向跳动值2'},{lb_oa2_deg_s:'下侧侧向跳动角度2'},{lb_oa2_rank_s:'下侧侧向跳动等级2'},
				            {lb_oa3_mm_s:'下侧侧向跳动值3'},{lb_oa3_deg_s:'下侧侧向跳动角度3'},{lb_oa3_rank_s:'下侧侧向跳动等级3'},
				            {rt_oa_mm_s:'上侧径向跳动值'},{rt_oa_deg_s:'上侧径向跳动角度'},{rt_oa_rank_s:'上侧径向跳动等级'},
				            {rc_oa_mm_s:'径向跳动值'},{rc_oa_deg_s:'径向跳动角度'},{rc_oa_rank_s:'径向跳动等级'},
				            {rb_oa_mm_s:'下侧径向跳动值'},{rb_oa_deg_s:'下侧径向跳动角度'},{rb_oa_rank_s:'下侧径向跳动等级'},
				            {lt_oa_1h_mm_s:'上侧侧向跳动一次谐波值1'},{lt_oa_1h_deg_s:'上侧侧向跳动一次谐波角度1'},{lt_oa_1h_rank_s:'上侧侧向跳动一次谐波等级1'},
				            {lt_oa2_1h_mm_s:'上侧侧向跳动一次谐波值2'},{lt_oa2_1h_deg_s:'上侧侧向跳动一次谐波角度2'},{lt_oa2_1h_rank_s:'上侧侧向跳动一次谐波等级2'},
				            {lt_oa3_1h_mm_s:'上侧侧向跳动一次谐波值3'},{lt_oa3_1h_deg_s:'上侧侧向跳动一次谐波角度3'},{lt_oa3_1h_rank_s:'上侧侧向跳动一次谐波等级3'},
				            {lb_oa_1h_mm_s:'下侧侧向跳动一次谐波值1'},{lb_oa_1h_deg_s:'下侧侧向跳动一次谐波角度1'},{lb_oa_1h_rank_s:'下侧侧向跳动一次谐波等级1'},
				            {lb_oa2_1h_mm_s:'下侧侧向跳动一次谐波值2'},{lb_oa2_1h_deg_s:'下侧侧向跳动一次谐波角度2'},{lb_oa2_1h_rank_s:'下侧侧向跳动一次谐波等级2'},
				            {lb_oa3_1h_mm_s:'下侧侧向跳动一次谐波值3'},{lb_oa3_1h_deg_s:'下侧侧向跳动一次谐波角度3'},{lb_oa3_1h_rank_s:'下侧侧向跳动一次谐波等级3'},
				            {rt_oa_1h_mm_s:'上侧径向跳动一次谐波值'},{rt_oa_1h_deg_s:'上侧径向跳动一次谐波角度'},{rt_oa_1h_rank_s:'上侧径向跳动一次谐波等级'},
				            {rc_oa_1h_mm_s:'径向跳动一次谐波值'},{rc_oa_1h_deg_s:'径向跳动一次谐波角度'},{rc_oa_1h_rank_s:'径向跳动一次谐波等级'},
				            {rb_oa_1h_mm_s:'下侧径向跳动一次谐波值'},{rb_oa_1h_deg_s:'下侧径向跳动一次谐波角度'},{rb_oa_1h_rank_s:'下侧径向跳动一次谐波等级'},
				            {lro_t1_nth_mm_s:'上侧侧向跳动N次谐波值1'},{lro_t1_nth_deg_s:'上侧侧向跳动N次谐波角度1'},{lro_t1_nth_rank_s:'上侧侧向跳动N次谐波等级1'},
				            {lro_t2_nth_mm_s:'上侧侧向跳动N次谐波值2'},{lro_t2_nth_deg_s:'上侧侧向跳动N次谐波角度2'},{lro_t2_nth_rank_s:'上侧侧向跳动N次谐波等级2'},
				            {lro_t3_nth_mm_s:'上侧侧向跳动N次谐波值3'},{lro_t3_nth_deg_s:'上侧侧向跳动N次谐波角度3'},{lro_t3_nth_rank_s:'上侧侧向跳动N次谐波等级3'},
				            {lro_b1_nth_mm_s:'下侧侧向跳动N次谐波值1'},{lro_b1_nth_deg_s:'下侧侧向跳动N次谐波角度1'},{lro_b1_nth_rank_s:'下侧侧向跳动N次谐波等级1'},
				            {lro_b2_nth_mm_s:'下侧侧向跳动N次谐波值2'},{lro_b2_nth_deg_s:'下侧侧向跳动N次谐波角度2'},{lro_b2_nth_rank_s:'下侧侧向跳动N次谐波等级2'},
				            {lro_b3_nth_mm_s:'下侧侧向跳动N次谐波值3'},{lro_b3_nth_deg_s:'下侧侧向跳动N次谐波角度3'},{lro_b3_nth_rank_s:'下侧侧向跳动N次谐波等级3'},
				            {rro_t_nth_mm_s:'上侧径向跳动一次谐波值'},{rro_t_nth_deg_s:'上侧径向跳动一次谐波角度'},{rro_t_nth_rank_s:'上侧径向跳动一次谐波等级'},
				            {rro_c_nth_mm_s:'径向跳动一次谐波值'},{rro_c_nth_deg_s:'径向跳动一次谐波角度'},{rro_c_nth_rank_s:'径向跳动一次谐波等级'},
				            {rro_b_nth_mm_s:'下侧径向跳动一次谐波值'},{rro_b_nth_deg_s:'下侧径向跳动一次谐波角度'},{rro_b_nth_rank_s:'下侧径向跳动一次谐波等级'},
				            {lt_bulging_mm_s:'上侧侧向凸值1'},{lt_bulging_deg_s:'上侧侧向凸角度1'},{lt_bulging_rank_s:'上侧侧向凸等级1'},
				            {lt_bulging2_mm_s:'上侧侧向凸值2'},{lt_bulging2_deg_s:'上侧侧向凸角度2'},{lt_bulging2_rank_s:'上侧侧向凸等级2'},
				            {lt_bulging3_mm_s:'上侧侧向凸值3'},{lt_bulging3_deg_s:'上侧侧向凸角度3'},{lt_bulging3_rank_s:'上侧侧向凸等级3'},
				            {lb_bulging_mm_s:'下侧侧向凸值1'},{lb_bulging_deg_s:'下侧侧向凸角度1'},{lb_bulging_rank_s:'下侧侧向凸等级1'},
				            {lb_bulging2_mm_s:'下侧侧向凸值2'},{lb_bulging2_deg_s:'下侧侧向凸角度2'},{lb_bulging2_rank_s:'下侧侧向凸等级2'},
				            {lb_bulging3_mm_s:'下侧侧向凸值3'},{lb_bulging3_deg_s:'下侧侧向凸角度3'},{lb_bulging3_rank_s:'下侧侧向凸等级3'},
				            {lt_dent_mm_s:'上侧侧向凹值1'},{lt_dent_deg_s:'上侧侧向凹角度1'},{lt_dent_rank_s:'上侧侧向凹等级1'},
				            {lt_dent2_mm_s:'上侧侧向凹值2'},{lt_dent2_deg_s:'上侧侧向凹角度2'},{lt_dent2_rank_s:'上侧侧向凹等级2'},
				            {lt_dent3_mm_s:'上侧侧向凹值3'},{lt_dent3_deg_s:'上侧侧向凹角度3'},{lt_dent3_rank_s:'上侧侧向凹等级3'},
				            {lb_dent_mm_s:'下侧侧向凹值1'},{lb_dent_deg_s:'下侧侧向凹角度1'},{lb_dent_rank_s:'下侧侧向凹等级1'},
				            {lb_dent2_mm_s:'下侧侧向凹值2'},{lb_dent2_deg_s:'下侧侧向凹角度2'},{lb_dent2_rank_s:'下侧侧向凹等级2'},
				            {lb_dent3_mm_s:'下侧侧向凹值3'},{lb_dent3_deg_s:'下侧侧向凹角度3'},{lb_dent3_rank_s:'下侧侧向凹等级3'},
				            {created_by:'创建人'}];
					
					
					"动平衡机台,轮胎条码,物料编码,物料描述,检测时间,成型机台,成型时间,硫化机台,硫化时间,轮胎总等级,动平衡总等级,跳动度总等级,动平衡上量,动平衡上量角度,动平衡上量等级,动平衡下量,动平衡下量角度,动平衡下量等级,动平衡上量+下量,动平衡上量+下量等级,静平衡量,静平衡量角度,静平衡量等级,力偶,力偶角度,力偶等级,上侧侧向跳动值1,上侧侧向跳动角度1,上侧侧向跳动等级1,上侧侧向跳动值2,上侧侧向跳动角度2,上侧侧向跳动等级2,上侧侧向跳动值3,上侧侧向跳动角度3,上侧侧向跳动等级3,下侧侧向跳动值1,下侧侧向跳动角度1,下侧侧向跳动等级1,下侧侧向跳动值2,下侧侧向跳动角度2,下侧侧向跳动等级2,下侧侧向跳动值3,下侧侧向跳动角度3,下侧侧向跳动等级3,上侧径向跳动值,上侧径向跳动角度,上侧径向跳动等级,径向跳动值,径向跳动角度,径向跳动等级,下侧径向跳动值,下侧径向跳动角度,下侧径向跳动等级,上侧侧向跳动一次谐波值1,上侧侧向跳动一次谐波角度1,上侧侧向跳动一次谐波等级1,上侧侧向跳动一次谐波值2,上侧侧向跳动一次谐波角度2,上侧侧向跳动一次谐波等级2,上侧侧向跳动一次谐波值3,上侧侧向跳动一次谐波角度3,上侧侧向跳动一次谐波等级3,下侧侧向跳动一次谐波值1,下侧侧向跳动一次谐波角度1,下侧侧向跳动一次谐波等级1,下侧侧向跳动一次谐波值2,下侧侧向跳动一次谐波角度2,下侧侧向跳动一次谐波等级2,下侧侧向跳动一次谐波值3,下侧侧向跳动一次谐波角度3,下侧侧向跳动一次谐波等级3,上侧径向跳动一次谐波值,上侧径向跳动一次谐波角度,上侧径向跳动一次谐波等级,径向跳动一次谐波值,径向跳动一次谐波角度,径向跳动一次谐波等级,下侧径向跳动一次谐波值,下侧径向跳动一次谐波角度,下侧径向跳动一次谐波等级,上侧侧向跳动N次谐波值1,上侧侧向跳动N次谐波角度1,上侧侧向跳动N次谐波等级1,上侧侧向跳动N次谐波值2,上侧侧向跳动N次谐波角度2,上侧侧向跳动N次谐波等级2,上侧侧向跳动N次谐波值3,上侧侧向跳动N次谐波角度3,上侧侧向跳动N次谐波等级3,下侧侧向跳动N次谐波值1,下侧侧向跳动N次谐波角度1,下侧侧向跳动N次谐波等级1,下侧侧向跳动N次谐波值2,下侧侧向跳动N次谐波角度2,下侧侧向跳动N次谐波等级2,下侧侧向跳动N次谐波值3,下侧侧向跳动N次谐波角度3,下侧侧向跳动N次谐波等级3,上侧径向跳动N次谐波值,上侧径向跳动N次谐波角度,上侧径向跳动N次谐波等级,径向跳动N次谐波值,径向跳动N次谐波角度,径向跳动N次谐波等级,下侧径向跳动N次谐波值,下侧径向跳动N次谐波角度,下侧径向跳动N次谐波等级,上侧侧向凸值1,上侧侧向凸角度1,上侧侧向凸等级1,上侧侧向凸值2,上侧侧向凸角度2,上侧侧向凸等级2,上侧侧向凸值3,上侧侧向凸角度3,上侧侧向凸等级3,下侧侧向凸值1,下侧侧向凸角度1,下侧侧向凸等级1,下侧侧向凸值2,下侧侧向凸角度2,下侧侧向凸等级2,下侧侧向凸值3,下侧侧向凸角度3,下侧侧向凸等级3,上侧侧向凹值1,上侧侧向凹角度1,上侧侧向凹等级1,上侧侧向凹值2,上侧侧向凹角度2,上侧侧向凹等级2,上侧侧向凹值3,上侧侧向凹角度3,上侧侧向凹等级3,下侧侧向凹值1,下侧侧向凹角度1,下侧侧向凹等级1,下侧侧向凹值2,下侧侧向凹角度2,下侧侧向凹等级2,下侧侧向凹值3,下侧侧向凹角度3,下侧侧向凹等级3,创建人";
			toExcel("动平衡检测履历（全钢）"+time,data,title);
	 	}else{
	 		var param=ext.form.getFormAsJson("Balandproresult_search_form");
	    	var param_get="";
	    	for(var k in param){
	    		param_get=param_get+"&"+k.replace("filter[","").replace("]","")+"="+param[k];
	    	}
	    	window.open(path+"finalcheck/dynabalancecheresult/balandproresult/export?s_factory_s="+factory+"&"+param_get);
	 	}
    }
    
    //FileName 生成的Excel文件名称
    function toExcel(FileName, JSONData, ShowLabel) {  
        //先转化json  
        var arrData = typeof JSONData != 'object' ? JSON.parse(JSONData) : JSONData;  
        var excel = '<table>';      
        //设置表头  
        var row = "<tr align='left'>";//设置Excel的左居中
        for (var i = 0, l = ShowLabel.length; i < l; i++) {  
            for (var key in ShowLabel[i]) {
                row += "<td style='font-weight:bold;font-size:17px;border-bottom:1px solid black;'>" + ShowLabel[i][key] + '</td>';  
            }
        }
        //换行  
        excel += row + "</tr>";  
          
        //设置数据  
        for (var i = 0; i < arrData.length; i++) {  
            var rowData = "<tr align='left'>"; 

            for (var y = 0; y < ShowLabel.length; y++) {
                for(var k in ShowLabel[y]){
                	//alert(arrData[i]['CONTROLSTATUS_S']);
                    if (ShowLabel[y].hasOwnProperty(k)) {
                    	 
                    	
                    	 if(k=="grade_code_s"){
                    		 rowData+="<td style='vnd.ms-excel.numberformat:@'>" + (arrData[i][k]==null? "" : dictFormat(arrData[i][k])) + "</td>";
                    		 continue;
                    	 }
                         rowData += "<td style='vnd.ms-excel.numberformat:@'>" + (arrData[i][k]==null? "" : arrData[i][k]) + "</td>";
                         //vnd.ms-excel.numberformat:@ 输出为文本
                    }
                }
            }
            excel += rowData + "</tr>";  
        }  
        excel += "</table>";  

        var excelFile = "<html xmlns:o='urn:schemas-microsoft-com:office:office' xmlns:x='urn:schemas-microsoft-com:office:excel' xmlns='http://www.w3.org/TR/REC-html40'>";  
        excelFile += '<meta http-equiv="content-type" content="application/vnd.ms-excel; charset=UTF-8">';  
        excelFile += '<meta http-equiv="content-type" content="application/vnd.ms-excel';  
        excelFile += '; charset=UTF-8">';  
        excelFile += "<head>";  
        excelFile += "<!--[if gte mso 9]>";  
        excelFile += "<xml>";  
        excelFile += "<x:ExcelWorkbook>";  
        excelFile += "<x:ExcelWorksheets>";  
        excelFile += "<x:ExcelWorksheet>";  
        excelFile += "<x:Name>";  
        excelFile += "动平衡检测履历（全钢）";  
        excelFile += "</x:Name>";  
        excelFile += "<x:WorksheetOptions>";  
        excelFile += "<x:DisplayGridlines/>";  
        excelFile += "</x:WorksheetOptions>";  
        excelFile += "</x:ExcelWorksheet>";  
        excelFile += "</x:ExcelWorksheets>";  
        excelFile += "</x:ExcelWorkbook>";  
        excelFile += "</xml>";  
        excelFile += "<![endif]-->";  
        excelFile += "</head>";  
        excelFile += "<body>";  
        excelFile += excel;  
        excelFile += "</body>";  
        excelFile += "</html>";  

        var uri = 'data:application/vnd.ms-excel;charset=utf-8,' + encodeURIComponent(excelFile);  
        var link = document.createElement("a");      
        link.href = uri;  
          
        link.style = "visibility:hidden";  
        link.download = FileName + ".xls";  
          
        document.body.appendChild(link);  
        link.click();  
        document.body.removeChild(link);  
    } 

	  var entCodeName=[];
		$.ajax({
	 		url:"finalcheck/baseData/entmodel/SearchEnt?equip_type=254004",
	 		type:"get",
	 		dataType:"json",
	 		async:true,
	 		success:function(data){
	 			entCodeName=data;
	 		}
	 	});
	    
	    function entCodeFormatter(v,r,i){
	    	for(var i=0;i<entCodeName.length;i++){
	    		if(v==entCodeName[i].EQUIP_NAME){
	    			return entCodeName[i].DESCRIPTION;
	    		}
	    	}
	    }
    
    
    /**
     * 查询方法
     */
    var filter=function(){
    	var startTime= $('#begin_created_time').datebox("getValue");
	    var endTime= $('#end_created_time').datebox("getValue");
	    if((startTime!=""&&endTime=="")||(startTime==""&&endTime!="")){
	    	ext.tip.error("时间输入范围不完整");
	    	return;
	    }
    	var opts = $("#balandproresult_dg").datagrid("options");
        opts.url = 'finalcheck/dynabalancecheresult/balandproresult/datagrid';
        ext.easyui.grid.search("balandproresult_dg","Balandproresult_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("balandproresult_dg",{});
    }

    function edit() {
        var rows = $("#balandproresult_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#balandproresult_dg").datagrid("getRowIndex", rows[i]);
            $("#balandproresult_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#balandproresult_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#balandproresult_dg").datagrid("getRowIndex", rows[i]);
            $("#balandproresult_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#balandproresult_dg");

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
            $("#balandproresult_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }
    //格式化精度
    function testmodeFormatter(v){
 		if(v==0){
 			return "正常测试";
 		}else if(v==1){
 			return "精度测试";
 		}else{
 			return v;
 		}
 	}
    function cancel() {
        $("#balandproresult_dg").datagrid("rejectChanges");
    }
  //隐藏查询栏
    function searchBar()
	{
		$("#Balandproresult_search_form").toggle();
	}
  //设定时间初始值从当前时间00:00:00至23:59:59
    $(document).ready(function(){
    	$('#begin_created_time').datetimebox({
    	    value: '3/4/2010 00:00:00',
    	    required: true,
    	    showSeconds: true
    	});
    	$('#end_created_time').datetimebox({
    	    value: '3/4/2010 23:59:59',
    	    required: true,
    	    showSeconds: true
    	});
    		filter();
    	});
</script>