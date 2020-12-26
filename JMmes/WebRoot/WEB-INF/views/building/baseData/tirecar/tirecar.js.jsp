<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"building/basedata/checktirecar/saveChanges";
    
    function showOrHide(){
        if($("#TireCar_search_form").is(":hidden")){
            $("#TireCar_search_form").show();
        }else{
            $("#TireCar_search_form").hide();
        }
    }
    //查询    
    var filter=function(){
        ext.easyui.grid.search("tirecar_dg","TireCar_search_form");
    };
    //添加
    function add() {
        ext.easyui.grid.appendAndEdit("tirecar_dg",{tire_shelf_code_s: "H"+new Calendar().format("BG0000")});
    }
    //编辑
    function edit() {
        var rows = $("#tirecar_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#tirecar_dg").datagrid("getRowIndex", rows[i]);
            $("#tirecar_dg").datagrid("beginEdit", index);
        }
    }
    //删除
    function remove() {

        var rows = $("#tirecar_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#tirecar_dg").datagrid("getRowIndex", rows[i]);
            $("#tirecar_dg").datagrid("deleteRow", index);
        }
    }
    //数据字典格式转化
    function codeFormatter(v,r,i) {
		return dictFormat(v);
	}
    //保存
    function save() {
        var dg = $("#tirecar_dg");
        var rows = dg.datagrid("getRows");
        for (var i = 0; i < rows.length; i++) {
            if (!dg.datagrid("validateRow", i)) {
                ext.tip.error("<spring:message code="tip.invalid" />");
                return;
            }
        }
        var inserted = dg.datagrid("getChanges", "inserted");
        var updated  = dg.datagrid("getChanges", "updated");
        var deleted  = dg.datagrid("getChanges", "deleted");
        for (var i = 0; i < rows.length; i++) {
            dg.datagrid("endEdit", i);
        }
    	Utils.each(updated, function(i, d) {
			delete d.createdname;
		});
		Utils.each(deleted, function(i, d) {
			delete d.createdname;
		});
        ext.ajax.sendJson(saveChanges,{inserted : inserted,updated : updated,deleted : deleted}, 
        		          function(data) {
                                      if(data.data!="操作成功"){
                                            $.messager.confirm("提示", data.data, function (data) {
                                      			
                                  			});
                                            saveFliter();
                                            return;
                                      }
            	                      ext.tip.suc(data.data);
            	                      saveFliter();
            	                      $("#tirecar_dg").datagrid("reload");//重新加载界面数据
                                      });
    }

    function cancel() {
        $("#tirecar_dg").datagrid("rejectChanges");
    }
   /////Add by Lanyinghui
      //查询栏按时间查询
     $(function(){
    	$("#start_time").datetimebox({
    	    value: '3/4/2010 00:00:00',
    	    required: false,
    	    showSeconds: true
    	});
    	$("#end_time").datetimebox({
    	    value: '3/4/2010 23:59:59',
    	    required: false,
    	    showSeconds: true
    	}); 

     	//var opts = $("#tirecar_dg").datagrid("options");
	    //opts.url='cx/basedata/checktirecar/searchBy';   
    	//ext.easyui.grid.search("tirecar_dg","TireCar_search_form");
    	saveFliter();
    });
    function saveFliter(){
    	var opts = $("#tirecar_dg").datagrid("options");
	    opts.url='building/basedata/checktirecar/searchBy';   
    	ext.easyui.grid.search("tirecar_dg","TireCar_search_form");
    }
 	function clearCar(){
		$('#tire_shelf_code_s').combobox('clear');
	}
 	
   /*
 	* 胎胚车编码预先导入
 	*
 	*/
 	//批量导入弹出框打开
    function BatchAdd() {
		$("#Batch_dg").dialog("open");
	}
	//批量导入弹出框关闭
	function BatchCancel() {
		$("#Batch_dg").dialog("close");
	}
	
	function tireCarStartCodeChange(newValue, oldValue){
		var isnum = /^\d+$/.test(newValue);
  	    if (isnum==false&&newValue!="") {
  	    	ext.tip.error("起始编码位置出现了字符,请检查");
  	    	$('#tireCarStartCode').textbox("clear");
  	    	return;
  	   }
	}
	function batchnumCodeChange(newValue, oldValue){
		var isnum = /^\d+$/.test(newValue);
  	    if (isnum==false&&newValue!="") {
  	    	ext.tip.error("数量出现了字符,请检查");
  	    	$('#tireCarStartCode').textbox("clear");
  	    	return;
  	   }
	}
	
	//批量导入弹出框传数据到后台
	function BatchSave(){
    	//var startCode= $('#startcode').textbox("getValue");
    	var loadNum= $('#loadnum').textbox("getValue");
    	var batchNum=$('#batchnum').textbox("getValue");
    	var tireCarStartCode=$('#tireCarStartCode').textbox("getValue");
    	if(loadNum==""||batchNum==""||tireCarStartCode==""){
    		ext.tip.error("输入信息不完整,请检查");
    		return;
    	}
    	var isnum = /^\d+$/.test(tireCarStartCode);
  	    if (isnum==false&&tireCarStartCode!="") {
  	    	ext.tip.error("起始编码位置出现了字符,请检查");
  	    	$('#tireCarStartCode').textbox("clear");
  	    	return;
  	   }
    	
    	  $.ajax({
	 		url:"building/basedata/checktirecar/BatchAdd?startCode="+tireCarStartCode+"&loadNum="+loadNum+"&batchNum="+batchNum,
	 		//url:"cx/basedata/checktirecar/BatchAdd?loadNum="+loadNum+"&batchNum="+batchNum,
	 	    type:"get",
	 		dataType:"json",
	 		async:false,
	 		success:function(data){
	 			if(data.data=="批量导入条码成功"){
             	      ext.tip.suc(data.data);
             	     $("#Batch_dg").dialog("close");
                }
                else{
                	$.messager.confirm("提示", data.data, function (data) {
              			
          			});
                }
                $("#tirecar_dg").datagrid("reload");//重新加载界面数据
	 		}
        });
    	  
  } 
</script>