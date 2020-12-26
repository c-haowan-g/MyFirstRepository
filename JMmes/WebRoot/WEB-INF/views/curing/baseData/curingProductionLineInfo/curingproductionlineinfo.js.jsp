<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"curing/baseData/curingProductionLineInfo/saveChanges";
    
    function showOrHide(){
        if($("#CuringProductionLineInfo_search_form").is(":hidden")){
            $("#CuringProductionLineInfo_search_form").show();
        }else{
            $("#CuringProductionLineInfo_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("curingproductionlineinfo_dg","CuringProductionLineInfo_search_form");
    }
    
    function codeFormatter(v, r, i) {
		return dictFormat(v);
	}
    
    //隐藏显示查询栏
	function queryBar() {
		$("#CuringProductionLineInfo_search_form").toggle(500);
	}
	
	var setProdutionLineInfo = function(value) {
		if (value != null && value != "" && value != undefined) {
			var k = $(this).parents('[datagrid-row-index]').attr(
					'datagrid-row-index');
			var td = $('.datagrid-body td[field=\'p_line_name\']')[k];
			var input = $(td).find('input')[0];
			
			var plinekey = $("#curingproductionlineinfo_dg").datagrid("getEditor",{index:k,field:"p_line_key"});
			var aa = $('.datagrid-body td[field=\'p_line_key\']')[k];
			var input1 = $(aa).find('input')[0];
			var plinekey1 = $(input1).val();
			
			var ff = CheckRule(plinekey1,value);
			if (ff == 0) {
				$(input).textbox('setValue', '');
			}else{
				var thspecEditor = $("#curingproductionlineinfo_dg").datagrid('getEditor', {
					index : k,
					field : "description"
				});
				var group = value.substring(3, 6);
				var side = value.substring(6, 7);
				$(thspecEditor.target).textbox("setValue",group+((side=="L")?"左":"右"));
				var thspecEditor = $("#curingproductionlineinfo_dg").datagrid('getEditor', {
					index : k,
					field : "machinegroup_s"
				});
				$(thspecEditor.target).textbox("setValue",group);
				
			}
		}
	}
	
    //获取url上的参数(获取工厂字段)
	function getQueryString(name) {
	    var result = window.location.search.match(new RegExp("[\?\&]" + name + "=([^\&]+)", "i"));
	    if (result == null || result.length < 1) {
	        return "";
	    }
	    return result[1];
	}
    
    //校验机台编码规则
    function CheckRule(plinekey,value) {
		var s_factory_s = getQueryString("factory");
		var flag = 1;
		//验证编码规则
		if (value != null && value != "") {
			var factory_class = value.substring(0, 1);
			var area_type = value.substring(1, 3);
			var group = value.substring(3, 6);
			var side = value.substring(6, 7);
			var standardCode = /^[A-Z]{1}(?!00)\d{2}$/;
			if ((factory_class != "E"&&s_factory_s=='1') || (factory_class != "9"&&s_factory_s=="2")) {
				ext.tip.error("<spring:message code="p_line_name.rule" />");
				flag = 0;
			} else if (area_type != "CS") {
				ext.tip.error("<spring:message code="p_line_name.rule" />");
				flag = 0;
			} else if (!standardCode.test(group)) {
				ext.tip.error("<spring:message code="p_line_name.rule" />");
			} else if (side != "L"&&side != "R") {
				ext.tip.error("<spring:message code="p_line_name.rule" />");
				flag = 0;
			}
			//校验重复性
			if(!(plinekey!=null&&plinekey!='')){
				$.ajax({
			        url:"curing/baseData/curingProductionLineInfo/checkPLineName?plinename="+value+"&plinekey="+plinekey,
			        type:'get',
			        dataType:'json',
			        async:false,
			        success:function(data){
			        	if(data == 0){
			        		ext.tip.error("<spring:message code="p_line_name.existRule" />");
			        		flag = 0;
			        	}
			        }
				});
			}
			return flag;
		}
	}
    
    function add() {
        ext.easyui.grid.appendAndEdit("curingproductionlineinfo_dg", {
        	category : "211003",
        	status_s : "214001"  
		});
    }

    function edit() {
        var rows = $("#curingproductionlineinfo_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#curingproductionlineinfo_dg").datagrid("getRowIndex", rows[i]);
            $("#curingproductionlineinfo_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#curingproductionlineinfo_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#curingproductionlineinfo_dg").datagrid("getRowIndex", rows[i]);
            $("#curingproductionlineinfo_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#curingproductionlineinfo_dg");

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
            $("#curingproductionlineinfo_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#curingproductionlineinfo_dg").datagrid("rejectChanges");
    }


</script>