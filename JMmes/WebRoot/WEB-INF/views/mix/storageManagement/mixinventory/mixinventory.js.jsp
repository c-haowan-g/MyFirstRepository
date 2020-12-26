<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"mix/storageManagement/mixInventory/saveChanges";
    
    function showOrHide(){
        if($("#MixInventory_search_form").is(":hidden")){
            $("#MixInventory_search_form").show();
        }else{
            $("#MixInventory_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
 	var value = $('input[name="spare10_s"]:checked').val(); 

        if("product_time"==value){
           $('#product_time_t').datetimebox({
                value: '3/4/2010 00:00:00',
                required: true,
                showSeconds: true 
            });    
        }
        //如果是选择入库日期in_time
        if("in_time"==value){
            $('#in_time_t').datetimebox({
                value: '3/4/2010 00:00:00',
                required: true,
                showSeconds: true 
            });       
        }
        //如果是选择质检日期check_time
        if("check_time"==value){
           $('#check_time_t').datetimebox({
               value: '3/4/2010 00:00:00',
                required: true,
                showSeconds: true 
            });       
        } 
        var starttime =$("#start_time").datetimebox("getValue");
    	var endtime=$("#end_time").datetimebox("getValue");
    	if((starttime!=""&&endtime=="")||(starttime==""&&endtime!="")){
    		ext.tip.error("时间输入范围不完整");
    		return;
    	}
    	if(starttime!="" && endtime!=""){
    		if(starttime>endtime){
    			ext.tip.error("<spring:message code="tip.date" />");
    		}else{
    			var opts = $("#mixinventory_dg").datagrid("options");
        		opts.url = 'mix/storageManagement/mixInventory/datagrid';  
        		ext.easyui.grid.search("mixinventory_dg","MixInventory_search_form");
    		}
    	}else{
    		var opts = $("#mixinventory_dg").datagrid("options");
        	opts.url = 'mix/storageManagement/mixInventory/datagrid';  
        	ext.easyui.grid.search("mixinventory_dg","MixInventory_search_form");
    	}
	/* var opts = $("#mixinventory_dg").datagrid("options");
        opts.url = 'mix/storageManagement/mixInventory/datagrid';  
        ext.easyui.grid.search("mixinventory_dg","MixInventory_search_form"); */
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("mixinventory_dg",{});
    }

    function edit() {
        var rows = $("#mixinventory_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#mixinventory_dg").datagrid("getRowIndex", rows[i]);
            $("#mixinventory_dg").datagrid("beginEdit", index);
        }
    }
    //特殊放行
	function specialRelease(){
        var dg = $("#mixinventory_dg");
        var rows=dg.datagrid("getSelections");
        //var index = -1;
        for (var i = 0; i < rows.length; i++) {
            rows[i]["reas_code_s"]="067001";
            rows[i]["self_flag_s"]="0";
        	}  
        
       if(rows.length==0 ){
			 ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
		 }else{
		  
			ext.ajax.sendJson("mix/storageManagement/mixInventory/saveChanges", {
				updated:rows
			}, function(data) {
				if (data.message != 'ok') {
					 ext.tip.error("<spring:message code="tip.error" />");
				}else{
					 $("#mixinventory_dg").datagrid("reload"); 
					 ext.tip.suc("<spring:message code="tip.success" />");
				}
	
			});
		 }
    }
    //超期处理
    function overdueDispose(){
    var rows = $("#mixinventory_dg").datagrid("getSelections");
        //var index = -1;
        for (var i = 0; i < rows.length; i++) {
            rows[i]["reas_code_s"]="067002";
            rows[i]["self_flag_s"]="0";
            //index=Integer.parseInt(rows[i]["expiry_hand_count_i"])+1;
            rows[i]["outofdateflag_s"]="0";
            //rows[i]["expiry_hand_count_i"]=Integer.toString(index);
            rows[i]["expiry_hand_count_i"]=rows[i]["expiry_hand_count_i"]+1;
        }
       if(rows.length==0 ){
			 ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
		 }else{
			ext.ajax.sendJson("mix/storageManagement/mixInventory/saveChanges", {
				updated:rows
			}, function(data) {
				if (data.message != 'ok') {
					 ext.tip.error("<spring:message code="tip.error" />");
				}else{
					 $("#mixinventory_dg").datagrid("reload"); 
					 ext.tip.suc("<spring:message code="tip.success" />");
				}
	
			});
		 }
    
    }
    function remove() {

        var rows = $("#mixinventory_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#mixinventory_dg").datagrid("getRowIndex", rows[i]);
            $("#mixinventory_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#mixinventory_dg");

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
            $("#mixinventory_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }
	//显示操作结果
	 function showConfirm(msg){
		   $.messager.confirm({
			    width: 700,
			    height: 350,
			    title: '提示',
			    msg: msg,
			    fn: function (r) {
			        }
			    }
			);
	} 
	
     
    function cancel() {
        $("#mixinventory_dg").datagrid("rejectChanges");
    }

 /**
     *将数据库得值转换为数据字典与对应值域
     */
    function codeFormatter(v, r, i) {

        return dictFormat(v);
    }

    function isTestmatFlag(v,r,i){
        if("0"==r.testmat_flag_s){
            return "否";
        }else if("1"==r.testmat_flag_s){
            return "是";
        }else{
            return "";
        }
    }

    function isPrioritymatFlag(v,r,i){
        if("0"==r.prioritymat_flag_s){
            return "否";
        }else if("1"==r.prioritymat_flag_s){
            return "是";
        }else{
            return "";
        }
    }

    function selfFlag(v,r,i){
        if("0"==r.self_flag_s){
            return "合格";
        }else if("1"==r.self_flag_s){
            return "不合格";
        }else{
            return "";
        }
    }

    function reasCodeFormatter(v,r,i){
        if("067002"==r.reas_code_s){
            return "超期处理";
        }else if("067001"==r.reas_code_s){
            return "特殊放行";
        }else{
            return r.reas_code_s;
        }
    }

    function isOutofdateflag(v,r,i){
        if("0"==r.outofdateflag_s){
            return "正常状态";
        }else if("1"==r.outofdateflag_s){
            return "超期";
        }else{
            return "";
        }
    }

  $(function(){
        $('input:radio[name="spare10_s"]').change(function(){
                var value = $('input[name="spare10_s"]:checked').val();
                //如果是选择生产日期product_time
                $('#product_time_t').datetimebox({
                    value: null,
                    required: false,
                    showSeconds: true
                });
                $('#in_time_t').datetimebox({
                    value: null,
                    required: false,
                    showSeconds: true
                });
                $('#check_time_t').datetimebox({
                    value: null,
                    required: false,
                    showSeconds: true
                });
            if("product_time"==value){
                $('#product_time_t').datetimebox({
                    value: '3/4/2010 00:00:00',
                    required: true,
                    showSeconds: true
                });
            }
                //如果是选择入库日期in_time
                if("in_time"==value){
                    $('#in_time_t').datetimebox({
                        value: '3/4/2010 00:00:00',
                        required: true,
                        showSeconds: true
                    });
                }
                //如果是选择质检日期check_time
                if("check_time"==value){
                    $('#check_time_t').datetimebox({
                        value: '3/4/2010 00:00:00',
                        required: true,
                        showSeconds: true
                    });
                }
            }
        ) 
        $("#in_time_t").next().hide();
        $("#check_time_t").next().hide();
        $("#product_time_t").next().hide(); 

    }) 

     $(document).ready(function(){
        $('#start_time').datetimebox({
            value: '3/4/2010 00:00:00',
            required: true,
            showSeconds: true
        });
        $('#end_time').datetimebox({
            value: '3/4/2010 23:59:59',
            required: true,
            showSeconds: true
        });
        filter();
    });

    function qtyLeft(v,r,i){
        if(null!=r.qty_left_f && ""!=r.qty_left_f){
            var qtyLeft=r.qty_left_f;
            if("."==qtyLeft.substring(0,1)){
                qtyLeft ="0"+qtyLeft;
                return qtyLeft;
            }else{
                return qtyLeft;
            }
        } 
   }
   
 function printFlag(v,r,i){
        if("0"==r.is_print_s){
            return "未打印";
        }else if("1"==r.is_print_s){
            return "已打印";
        }else if("2"==r.is_print_s){
            return "补充打印";
        }else{
            return "";
        }
    }

</script>