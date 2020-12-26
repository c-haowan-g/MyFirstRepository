<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"building/productionplan/changemould/saveChanges";
    
    function showOrHide(){
        if($("#ChangeMould_search_form").is(":hidden")){
            $("#ChangeMould_search_form").show();
        }else{
            $("#ChangeMould_search_form").hide();
        }
    }
    /**
	 * 日期格式化
	 * 兰颖慧-2019/03/12
	 */
	function dateFormat(date) {
		return new Calendar(date).format("yyyyMMdd");
	}
    /**
	 * 解析指定格式日期
	 * 兰颖慧-2019/03/12
	 */
	function dateParser(s) {
		if (!s)
			return new Date();
		return new Date(s.substring(0, 4), parseInt(s.substring(4, 6)) - 1, s.substring(6, 8));
	}
    
    /**
     * 查询方法
     */
    var filter=function(){
    	var opts = $("#changemould_dg").datagrid("options");
    	opts.url = 'building/productionplan/changemould/datagrid';
        ext.easyui.grid.search("changemould_dg","ChangeMould_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("changemould_dg",{});
    }

/*     function edit() {
        var rows = $("#changemould_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {

        }
    }
 */
    function edit() {
    	var rows = $("#changemould_dg").datagrid("getSelections");//返回选中的复选框
    	var index = -1;
        if(rows.length==0){
        	ext.tip.warn(tipSelectAtLeastOne);
        	return;
        }
        for(var i=0;i<rows.length;i++){
        	if(rows[i].plan_status_s=='170001'){
                index = $("#changemould_dg").datagrid("getRowIndex", rows[i]);
                $("#changemould_dg").datagrid("beginEdit", index);
        	}
        	else{
        		ext.tip.warn("<spring:message code="tip.notAllowToEdit" />");
        	}
        }
    }
        	
        	
    function remove() {

        var rows = $("#changemould_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#changemould_dg").datagrid("getRowIndex", rows[i]);
            $("#changemould_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#changemould_dg");

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
        
        Utils.each(updated, function(i, d) {
			delete d.auditbyname;
			delete d.changebyname;
		});
        Utils.each(deleted, function(i, d) {
			delete d.auditbyname;
			delete d.changebyname;
		});
        
        
        ext.ajax.sendJson(saveChanges, {
            inserted : inserted,
            updated : updated,
            deleted : deleted
        }, function(data) {

            if (data.data!="操作成功") {
                ext.tip.error(data.data);
                return;
            }
            ext.tip.suc(data.data);
            $("#changemould_dg").datagrid("reload");

        });
    }

    function cancel() {
        $("#changemould_dg").datagrid("rejectChanges");
    }
    //按时间查询
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
    	filter();
    });

    /**
     *换工装计划审核
     *兰颖慧-2019/03/12
     */
    function getDg(){
     	return $("#changemould_dg");  //$("#a_dg"):获取并返回选中的标签页
    }
    function audit(){
    	var rows=getDg().datagrid("getChecked");//getChecked:返回复选框中选中的所有行
    	if(rows.length==0){
    		ext.tip.warn(tipSelectAtLeastOne);
    		return;
    	}
    	var ids=[]; //声明数组
    	for(var i=0;i<rows.length;i++){
    		if(rows[i].plan_status_s!='170001'){
    			ext.tip.warn("<spring:message code="tip.audited" />");
    			return;
    		}
    		ids.push(rows[i].atr_key);
    	}
    	
    	ext.ajax.post("building/productionplan/changemould/audit",{ids:ids.toString()},
                      function(data){ //ext.ajax.post:用于客户端向服务端传输数据
    		                         if(data.code==OK){
    			                     ext.tip.suc();
    		                         filter();
    			                     return;
    		                        }
    		ext.tip.error(data.message);
    	});
    }
    /**
     *换工装计划取消审核
     *兰颖慧-2019/03/12
     *
     */
    function cancelAudit(){
        var rows=getDg().datagrid("getChecked");
        if(rows.length==0){
            ext.tip.warn(tipSelectAtLeastOne);
            return;
        }
        var ids=[];
        for(var i=0;i<rows.length;i++){
    	    if(rows[i].plan_status_s!='170002'){
    			ext.tip.warn("<spring:message code="tip.unaudited" />");
    			return;
    		}
    	    if(rows[i].excute_begintime_t!=null){
    	    	ext.tip.warn("<spring:message code="tip.unaudited" />");
    			return;
    	    }
            ids.push(rows[i].atr_key);
        }
        
            ext.ajax.post("building/productionplan/changemould/cancelAudit",{ids:ids.toString()},function(data){
            if(data.code!=OK){
            	//ext.tip.error(data.message);
            	return;
            }
            ext.tip.suc();
            filter();
        });
    }
    /**
     *换工装计划关闭
     *兰颖慧-2019/03/12
     *
     */
    function offPlan(){
        var rows=getDg().datagrid("getChecked");
        if(rows.length==0){
            ext.tip.warn(tipSelectAtLeastOne);
            return;
        }
        var ids=[];
        for(var i=0;i<rows.length;i++){
    		if(rows[i].plan_status_s=='170004'){
    			ext.tip.warn("<spring:message code="tip.close" />");
    			continue;
    		}
            ids.push(rows[i].atr_key);
        }
        ext.ajax.post("building/productionplan/changemould/close",{ids:ids.toString()},
        		function(data){
                           if(data.code!=OK){
            	                //ext.tip.error(data.message);
            	           return;
                }
                ext.tip.suc();
                filter();
        });
    }
    
    /**
     *code转化
     *兰颖慧-2019/03/12
     */
    function codeFormatter(v,r,i) {
		return dictFormat(v);
	}
   
     function getEditor(index,field){
         return $("#changemould_dg").datagrid("getEditor",{index:index,field:field});
     }
     //设备修改时，根据上方下拉框的时间+机台编码，查询已审核，执行中的日计划号
     function onMoldDaliyCodeSelect(record){
     	var index = $(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
        var changemoulddate=$("#changetime_s").datebox("getValue"); 
        var newurl='building/basedata/productline/searchDayplannoByEquipCodeAndPlanDate?equipCode='+record.p_line_name+"&productDate="+changemoulddate;
	    $(getEditor(index, "production_plan_no_s").target).combobox("reload",newurl);
     }
      //计划号修改时带出
     function onPlanNoSelect(record){
    	  var index = $(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
    	  var isPlanExitUrl='building/productionplan/changemould/isCxDayPlanExitInChangePlan?planno='+record.PLAN_NO_S;
          var isExit=false;
    	  $.ajax({
       		url:isPlanExitUrl,
       		type:"get",
       		dataType:"json",
       		async:false,
       		success:function(data){
       			if(data==true){
       				isExit=true;
       			    return;
       			}
       		}
       	}); 
          
         if(isExit==true){
        	 ext.tip.error("该日计划已经做了换工作计划");
        	 $(getEditor(index, "material_code_s").target).textbox("setValue",'');
			 $(getEditor(index, "material_name_s").target).textbox("setValue",'');
        	  return;
          }
          var firstUrl='building/productionplan/changemould/searchMaterialInfoByPlanNo?planno='+record.PLAN_NO_S;
       	  ext.ajax.get(
      			firstUrl,
				function(data) {
					$(getEditor(index, "material_code_s").target).textbox("setValue",data[0].MATERIAL_CODE_S);
					$(getEditor(index, "material_name_s").target).textbox("setValue",data[0].MATERIAL_DESC_S);
				}
          )
      }

        /**
        *下拉框清除
        *
        */
    	function clearMaterial(){
    		$('#material_code_s').combobox('clear');
    	}
    	function clearPlan(){
    		$('#production_plan_no_s').combobox('clear');
    	}
    	function clearEquip(){
    		$('#equip_code_s').combobox('clear');
    	}
</script>