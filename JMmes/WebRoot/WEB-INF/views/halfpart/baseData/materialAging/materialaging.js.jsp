<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"halfpart/baseData/materialAging/saveChanges";
    
    function showOrHide(){
        if($("#MaterialsPlus_search_form").is(":hidden")){
            $("#MaterialsPlus_search_form").show();
        }else{
            $("#MaterialsPlus_search_form").hide();
        }
    }
    
    function showOrHide1(){
        if($("#MaterialsPlus_search_form1").is(":hidden")){
            $("#MaterialsPlus_search_form1").show();
        }else{
            $("#MaterialsPlus_search_form1").hide();
        }
    }
    
    function singlemaintain() {
        // 获取选中行的Index的值
        var index = $('#materialsplus_dg1').datagrid('getRowIndex', $('#materialsplus_dg1').datagrid('getSelected'));
        if (index < 0) {
            ext.tip.warn("请选择一个物料");
            return;
        }
        var rowData = $('#materialsplus_dg1').datagrid('getSelected');
        if (rowData == null) {
            ext.tip.warn("请选择一个物料");
            return;
        }
        var materialcode = rowData.part_number;
        $("#singlematerialmanager_dg").dialog("open");
        var url = 'halfpart/baseData/materialAging/getInfoByCode?materialcode=' + materialcode;
        ext.ajax.get(url, function (data) {
            $('#singlematerial_dg').datagrid('loadData', data);
        });
        /* ext.ajax.get(url, function (data1) {
            ext.ajax.get(url, function (data2) {
                $('#halfpart_storageunit_dg').datagrid('loadData', data2);
            });
        }); */

    }
    
    /**
     * 查询方法
     */
    var filter=function(){
    	var opts = $("#materialsplus_dg").datagrid("options");
		opts.url = 'halfpart/baseData/materialAging/datagridGroup';
        ext.easyui.grid.search("materialsplus_dg","MaterialsPlus_search_form");
    };
    
    var filter1=function(){
    	var opts = $("#materialsplus_dg1").datagrid("options");
		opts.url = 'halfpart/baseData/materialAging/datagrid';
        ext.easyui.grid.search("materialsplus_dg1","MaterialsPlus_search_form1");
        setTimeout(LoadView, 200);
    };
    
    /* 加载详细视图 */
    function LoadView() {
        var total = $("#materialsplus_dg1").length;
        //验证当有数据的时候才加载详细视图
        if (total > 0) {
            $('#materialsplus_dg1').datagrid({
                view: detailview,
                /* loadFilter: pagerFilter, */
                singleSelect: true,
                fitColumns: true,//允许表格自动缩放，以适应父容器
                pagination: true,
                rownumbers: true,
                detailFormatter: function (index, row) {
                    return '<div style="padding:2px"><table class="ddv"></table></div>';
                },
                onExpandRow: function (index, row) {
                    var ddv = $(this).datagrid('getRowDetail', index).find('table.ddv');
                    if(row.materialgroup_s == "半成品-全钢-钢压大卷" || row.materialgroup_s == "半成品-半钢-钢压大卷") {
                    	ddv.datagrid({
	                        url: 'halfpart/baseData/materialAging/getInfoByCode?materialcode=' + row.part_number,
	                        fitColumns: true,
	                        singleSelect: true,
	                        rownumbers: true,
	                        loadMsg: '加载中...',
	                        height: 'auto',
	                        columns: [[
	                            {field: 'materialcode_s', title: '物料编码 ', width: 120},
	                            {field: 'spare4_s', title: '钢丝压延垫布层数',formatter:exchangetow,width: 120},
	                            {field: 'spare7_s', title: '最小存放时间', width: 100},
	                            {field: 'spare8_s', title: '最大存放时间', width: 120}
	                        ]],
	                        onResize: function () {
	                            $('#materialsplus_dg1').datagrid('fixDetailRowHeight', index);
	                        },
	                        onLoadSuccess:
	                            function () {
	                                setTimeout(function () {
	                                    $('#materialsplus_dg1').datagrid('fixDetailRowHeight', index);
	                                }, 0);
	                            }
	                    });
                    }/* else {
                    	ddv.datagrid({
	                        url: 'halfpart/baseData/materialAging/getInfoByCode?materialcode=' + row.part_number,
	                        fitColumns: true,
	                        singleSelect: true,
	                        rownumbers: true,
	                        loadMsg: '加载中...',
	                        height: 'auto',
	                        columns: [[
	                            {field: 'materialcode_s', title: '物料编码 ', width: 120},
	                            {field: 'spare4_s', title: '钢丝压延垫布层数', formatter:exchangenull, width: 120},
	                            {field: 'spare3_s', title: '最小存放时间', formatter:exchangenull, width: 100},
	                            {field: 'spare2_s', title: '最大存放时间', formatter:exchangenull, width: 120}
	                        ]],
	                        onResize: function () {
	                            $('#materialsplus_dg1').datagrid('fixDetailRowHeight', index);
	                        },
	                        onLoadSuccess:
	                            function () {
	                                setTimeout(function () {
	                                    $('#materialsplus_dg1').datagrid('fixDetailRowHeight', index);
	                                }, 0);
	                            }
	                    });
                    } */
                    $('#materialsplus_dg1').datagrid('fixDetailRowHeight', index);
                }
            });
        }
    }
    
    function edit() {
        var rows = $("#materialsplus_dg").datagrid("getSelections");
        if(rows.length<=0){
            ext.tip.warn("请选择一个物料组");
            return;
        }
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
			index = $("#materialsplus_dg").datagrid("getRowIndex", rows[i]);
			$("#dg").datagrid("endEdit", index);
			var tt=$('#materialsplus_dg').datagrid('getColumnOption', 'spare1_s');
	        var ttt=$('#materialsplus_dg').datagrid('getColumnOption', 'spare2_s');
	        tt.editor=close;
	        ttt.editor=close;
		}
        for (var i = 0; i < rows.length; i++) {
            index = $("#materialsplus_dg").datagrid("getRowIndex", rows[i]);
            if(rows[i].materialgroup_s == "半成品-全钢-钢压大卷" || rows[i].materialgroup_s == "半成品-半钢-钢压大卷") {
            	var tt=$('#materialsplus_dg').datagrid('getColumnOption', 'spare1_s'); //通过列名获得此列
            	var ttt=$('#materialsplus_dg').datagrid('getColumnOption', 'spare2_s'); //通过列名获得此列
                tt.editor={type:'numberbox',options:{
          				    required:true,
          					editable:true,
          					precision:0,
          					min:0
          				  }};
          		ttt.editor={type:'numberbox',options:{
          				    required:true,
          					editable:true,
          					precision:0,
          					min:0
          				  }};
            }
            $("#materialsplus_dg").datagrid("beginEdit", index);
        }
    }
    
    function edit1() {
        var rows = $("#singlematerial_dg").datagrid("getSelections");
        if(rows.length<=0){
            ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
            return;
        }
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#singlematerial_dg").datagrid("getRowIndex", rows[i]);
            if(rows[i].materialgroup_s == "半成品-全钢-钢压大卷" || rows[i].materialgroup_s == "半成品-半钢-钢压大卷") {
            	var tt=$('#singlematerial_dg').datagrid('getColumnOption', 'spare7_s'); //通过列名获得此列
            	var ttt=$('#singlematerial_dg').datagrid('getColumnOption', 'spare8_s'); //通过列名获得此列
                tt.editor={type:'numberbox',options:{
          				    required:true,
          					editable:true,
          					precision:0,
          					min:0
          				  }};
          		ttt.editor={type:'numberbox',options:{
          				    required:true,
          					editable:true,
          					precision:0,
          					min:0
          				  }};
            }
            $("#singlematerial_dg").datagrid("beginEdit", index);
        }
    }
     
     function setSameAging(){
     	 var dg = $("#materialsplus_dg");
     	 var rows = dg.datagrid("getRows");
     	 for (var i = 0; i < rows.length; i++) {
            if (!dg.datagrid("validateRow", i)) {
                ext.tip.error("<spring:message code="tip.invalid" />");
                return;
            }
         }
     	 for (var i = 0; i < rows.length; i++) {
             dg.datagrid("endEdit", i);
         }
    	 var updated = dg.datagrid("getChanges", "updated");
    	 if(updated.length <= 0){
             ext.tip.warn("没有需要保存的信息");
             return;
         }
         for (var i = 0; i < updated.length; i++) {
         	 index = dg.datagrid("getRowIndex", updated[i]);
             var row = dg.datagrid('getData').rows[index];
             var url='halfpart/baseData/materialAging/setSameAgingByCode';
	    	 $.ajax({
	    		 url:url,
	    		 type:'get',
	    		 dataType:'json',
	    		 async:false,
	    		 data: {
	    		 	materialgroup: row.materialgroup_s,
	    		 	smalltime: row.smalltime_f,
	    		 	overtime: row.overtime_f,
	    		 	spare1_s: row.spare1_s,
	    		 	spare2_s: row.spare2_s
	    		 },
	    		 success:function(data){
					 dg.datagrid("reload");
	                 ext.tip.suc("共"+data+"条数据被修改");   		 
				 }
	    	 });
             
         }
     };
     
     function setSameAging1(){
     	 var dg = $("#materialsplus_dg1");
     	 var rows = dg.datagrid("getRows");
     	 for (var i = 0; i < rows.length; i++) {
            if (!dg.datagrid("validateRow", i)) {
                ext.tip.error("<spring:message code="tip.invalid" />");
                return;
            }
         }
     	 for (var i = 0; i < rows.length; i++) {
             dg.datagrid("endEdit", i);
         }
    	 var updated = dg.datagrid("getChanges", "updated");
    	 if(updated.length <= 0){
             ext.tip.warn("未修改任何时效数据");
             return;
         }
         for (var i = 0; i < updated.length; i++) {
         	 index = dg.datagrid("getRowIndex", updated[i]);
             var row = dg.datagrid('getData').rows[index];
             var url='halfpart/baseData/materialAging/setSameAgingByCode';
	    	 $.ajax({
	    		 url:url,
	    		 type:'get',
	    		 dataType:'json',
	    		 async:false,
	    		 data: {
	    		 	materialgroup: row.materialgroup_s,
	    		 	smalltime: row.smalltime_f,
	    		 	overtime: row.overtime_f,
	    		 	spare: row.spare1_s
	    		 },
	    		 success:function(data){
					 dg.datagrid("reload");
	                 ext.tip.suc("共"+data+"条数据被修改");   		 
				 }
	    	 });
             
         }
     };

    function save() {
        var dg = $("#materialsplus_dg");

        var rows = dg.datagrid("getRows");
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
         if(inserted.length ==0 && updated.length ==0 && deleted.length ==0){
			
			$("#materialsplus_dg").datagrid("reload");
            ext.tip.error("<spring:message code="tip.nosave" />");
		}else{
	            
			var arysave = new Array(); 
			var aryupdate = new Array(); 
			
			var narySave=arysave.sort();  
			var naryUpdate=aryupdate.sort();  
			for(var i=0;i<arysave.length;i++){  
				 if (narySave[i]==narySave[i+1]){  
					ext.tip.error("<spring:message code="tip.error" />");
					return;
				 }
			 } 
			 for(var i=0;i<aryupdate.length;i++){  
				 if (naryUpdate[i]==naryUpdate[i+1]){  
					ext.tip.error("<spring:message code="tip.error" />");
					return; 
				 }
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
	            $("#materialsplus_dg").datagrid("reload");
	            ext.tip.suc("<spring:message code="tip.success" />");
	
	        });
		}
    }
    
    function save1() {
        var dg = $("#singlematerial_dg");

        var rows = dg.datagrid("getRows");
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
        if(inserted.length ==0 && updated.length ==0 && deleted.length ==0){
			
			$("#singlematerial_dg").datagrid("reload");
            ext.tip.error("<spring:message code="tip.nosave" />");
		}else{
	            
			var arysave = new Array(); 
			var aryupdate = new Array(); 
			
			var narySave=arysave.sort();  
			var naryUpdate=aryupdate.sort();  
			for(var i=0;i<arysave.length;i++){  
				 if (narySave[i]==narySave[i+1]){  
					ext.tip.error("<spring:message code="tip.error" />");
					return;
				 }
			 } 
			 for(var i=0;i<aryupdate.length;i++){  
				 if (naryUpdate[i]==naryUpdate[i+1]){  
					ext.tip.error("<spring:message code="tip.error" />");
					return; 
				 }
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
	            $("#materialsplus_dg1").datagrid("reload");
	            ext.tip.suc("<spring:message code="tip.success" />");
	
	        });
		}
    }
    
    function exchange(v, r, i) {
    	return "单层";
    }
    
    function exchangetow(v, r, i) {
		return "双层";
    }
    
    function exchangenull(v, r, i) {
		return "";
    }
    
    function toUserName(v, r, i) {
    	if(v == null) {
    		return v;
    	}
		$.ajax({
			url : 'halfpart/baseData/materialAging/toUserName',
			type : 'get',
			dataType : 'json',
			data: {
				usercode: v
			},
			async : false,
			success : function(data) {
				if(data.length == 0) {
					return v;
				}
				v = data[0].username;
			}
		});
		return v;
	}	
	
	function toDC(v, r, i) {
		return "单层";
	}
	
	function toSC(v, r, i) {
		var row=$("#materialsplus_dg").datagrid("getData").rows[i];
		if(row.materialgroup_s == "半成品-全钢-钢压大卷" || row.materialgroup_s == "半成品-半钢-钢压大卷") {
			return "双层";
		}
		row.spare1_s = "";
		row.spare2_s = "";
		return "";
	}
	
	function toSCC(v, r, i) {
		var row=$("#singlematerial_dg").datagrid("getData").rows[i];
		if(row.materialgroup_s == "半成品-全钢-钢压大卷" || row.materialgroup_s == "半成品-半钢-钢压大卷") {
			return "双层";
		}
		row.spare3_s = "";
		row.spare2_s = "";
		return "";
	}

    function cancel() {
        $("#materialsplus_dg").datagrid("rejectChanges");
        var tt=$('#materialsplus_dg').datagrid('getColumnOption', 'spare1_s');
        var ttt=$('#materialsplus_dg').datagrid('getColumnOption', 'spare2_s');
        tt.editor=close;
        ttt.editor=close;
    }
    
    function cancel1() {
        $("#singlematerial_dg").datagrid("rejectChanges");
        var tt=$('#singlematerial_dg').datagrid('getColumnOption', 'spare7_s');
        var ttt=$('#singlematerial_dg').datagrid('getColumnOption', 'spare8_s');
        tt.editor=close;
        ttt.editor=close;
    }

	function singleclose() {
		var tt=$('#singlematerial_dg').datagrid('getColumnOption', 'spare7_s');
        var ttt=$('#singlematerial_dg').datagrid('getColumnOption', 'spare8_s');
        tt.editor=close;
        ttt.editor=close;
	}

</script>