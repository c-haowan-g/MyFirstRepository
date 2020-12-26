<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"lh/reworkprocess/saveChanges";
    
    function showOrHide(){
        if($("#Maintype_search_form").is(":hidden")){
            $("#Maintype_search_form").show();
        }else{
            $("#Maintype_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
    	var opts = $("#maintype_dg").datagrid("options");
		opts.url = 'curing/reworkprocess/Maintype/datagrid';
        ext.easyui.grid.search("maintype_dg","Maintype_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("maintype_dg",{});
    }

    function edit() {
        var rows = $("#maintype_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#maintype_dg").datagrid("getRowIndex", rows[i]);
            $("#maintype_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#maintype_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#maintype_dg").datagrid("getRowIndex", rows[i]);
            $("#maintype_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#maintype_dg");

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
            $("#maintype_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#maintype_dg").datagrid("rejectChanges");
    }

  //加载产线信息
	var jtxx = [];
	$.ajax({
		url : 'curing/baseData/curingProductionLineInfo/comboxProductlineEqu',
		type : 'get',
		dataType : 'json',
		async : false,
		success : function(data) {
			jtxx = data;
		}
	});

	//设定时间初始值从当前时间00:00:00至23:59:59
	$(document).ready(function() {
		$('#begin_created_time').datetimebox({
			value : '3/4/2010 00:00:00',
			required : true,
			showSeconds : true
		});
		$('#end_created_time').datetimebox({
			value : '3/4/2010 23:59:59',
			required : true,
			showSeconds : true
		});
		//filter();
	});
	
	function reworkpreossFormatter(v,r,i){
		if(r.unqualifiedcount==0){
			return "100.00%";
		}else{
			var rate=(r.reworkpreosscount-r.unqualifiedcount)/r.reworkpreosscount*100;
			return rate.toFixed(2)+"%";
		}
	}
	
	var length=0;//定义数据行数，用于
	function onLoadSuccess(data) {
		debugger;
		if (data.rows.length > 0) {
			length=data.rows;
			//添加“合计”列
			var reworkpreosscount=0;
			var unqualifiedcount=0;
			for(var i=0;i<data.rows.length;i++){
				reworkpreosscount=(reworkpreosscount*10+data.rows[i].reworkpreosscount*10)/10;
				unqualifiedcount=(unqualifiedcount*10+data.rows[i].unqualifiedcount*10)/10;
			}
			$('#maintype_dg')
					.datagrid('appendRow',{
								curingmachinecode_s : "",
								curingspeccode_s : "",
								curingspecmater : '<spring:message code="dynabalancecheresultprint.column.total" />',
								reworkpreosscount : reworkpreosscount,
								unqualifiedcount: unqualifiedcount,
								spare1_s:""
							});
		}
	}
	//根据条件设置表格行背景颜色
	function setRowBgColor(index, row) {
		 if (row.curingspeccode_s == "" && row.curingmachinecode_s == "") {
			return 'background-color:yellow;color:black;font-weight: bold;';
		} 
	}
	
</script>