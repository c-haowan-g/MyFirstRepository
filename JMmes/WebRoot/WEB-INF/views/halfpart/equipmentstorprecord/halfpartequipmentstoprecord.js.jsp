<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"halfpart/equipmentStoprecord/saveChanges";
    
    function showOrHide(){
        if($("#HalfpartEquipmentStoprecord_search_form").is(":hidden")){
            $("#HalfpartEquipmentStoprecord_search_form").show();
        }else{
            $("#HalfpartEquipmentStoprecord_search_form").hide();
        }
    }
    function showControlStatus(value,row,index){
		  if((value=="1")){
	      		return "是";
	      	}else if((value=="0")){
	      		return "否";
	      	}
	  }
    /**
     * 加载机台信息
     * 2020年3月7日13:30:583
    */
    var productLineList=[];
    $.ajax({
        url:"halfpart/basedata/productlinemanager/getProductline",
        type:"get",
        dataType:"json",
        async:false,
        success:function(data){
        	productLineList=data;
        }
    });
  //查询栏按时间查询
    $(function(){
    	$("#start_time").datetimebox({
    	    value:'3/4/2010 00:00:00',
    	    required: false,
    	    showSeconds: true
    	});
    	$("#end_time").datetimebox({
    	    value:'3/4/2010 23:59:59',
    	    required: false,
    	    showSeconds: true
    	});
    	var opts = $("#halfpartequipmentstoprecord_dg").datagrid("options");
        opts.url = 'halfpart/equipmentStoprecord/datagridUDA';
    	filter();
    });
    /**
	 *数据字典传值
	 *
	 */
	function codeFormatter(v, r, i) {
	
		return dictFormat(v);
	}
    
	
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("halfpartequipmentstoprecord_dg","HalfpartEquipmentStoprecord_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("halfpartequipmentstoprecord_dg",{});
    }

    function edit() {
        var rows = $("#halfpartequipmentstoprecord_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#halfpartequipmentstoprecord_dg").datagrid("getRowIndex", rows[i]);
            $("#halfpartequipmentstoprecord_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#halfpartequipmentstoprecord_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#halfpartequipmentstoprecord_dg").datagrid("getRowIndex", rows[i]);
            $("#halfpartequipmentstoprecord_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#halfpartequipmentstoprecord_dg");

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
            $("#halfpartequipmentstoprecord_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#halfpartequipmentstoprecord_dg").datagrid("rejectChanges");
    }


</script>