<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"mix/MixSiloMaterialExec/saveChanges";
    
    function showOrHide(){
        if($("#MixSiloMaterialExec_search_form").is(":hidden")){
            $("#MixSiloMaterialExec_search_form").show();
        }else{
            $("#MixSiloMaterialExec_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
    	var value = $('input[name="dummy4_s"]:checked').val();
    	var url='mix/MixSiloMaterialExec/datagrid2';
    	if("real_time"==value){
    		url='mix/MixSiloMaterialExec/datagrid2';
    	}else if("his_time"==value){
    		url='mix/MixSiloMaterialExec/datagridHis';
    	}
    	var starttime=$("#start_time").datetimebox("getValue");
    	var endtime=$("#end_time").datetimebox("getValue");
    	if(starttime!="" && endtime!=""){
    		if(starttime>endtime){
    			ext.tip.error("<spring:message code="tip.date"/>");
    		}else{
    			var opts = $("#mixsilomaterialexec_dg").datagrid("options");
                opts.url = url;
                ext.easyui.grid.search("mixsilomaterialexec_dg","MixSiloMaterialExec_search_form");
    		}
    	}else{
    		var opts = $("#mixsilomaterialexec_dg").datagrid("options");
            opts.url = url;
            ext.easyui.grid.search("mixsilomaterialexec_dg","MixSiloMaterialExec_search_form");
         }
        	//ext.easyui.grid.search("mixsilomaterialexec_dg","MixSiloMaterialExec_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("mixsilomaterialexec_dg",{});
    }

    function edit() {
        var rows = $("#mixsilomaterialexec_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#mixsilomaterialexec_dg").datagrid("getRowIndex", rows[i]);
            $("#mixsilomaterialexec_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#mixsilomaterialexec_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#mixsilomaterialexec_dg").datagrid("getRowIndex", rows[i]);
            $("#mixsilomaterialexec_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#mixsilomaterialexec_dg");

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
            $("#mixsilomaterialexec_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#mixsilomaterialexec_dg").datagrid("rejectChanges");
    }

//设定时间初始值从当前时间00:00:00至23:59:59
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

    function syncHandFlag(v,r,i){
        if("0"==r.sync_hand_flag_s){
            return "未处理";
        }else if("1"==r.sync_hand_flag_s){
            return "已处理";
        }
    }

    function syncHandFlagPoly1(v,r,i){
        if("0"==r.sync_hand_flag_poly1_s){
            return "未处理";
        }else if("1"==r.sync_hand_flag_poly1_s){
            return "已处理";
        }else if("2"==r.sync_hand_flag_poly1_s){
            return "处理失败";
        }else{
            return r.sync_hand_flag_poly1_s;
        }
    }
    function syncHandFlagPoly2(v,r,i){
        if("0"==r.sync_hand_flag_poly2_s){
            return "未处理";
        }else if("1"==r.sync_hand_flag_poly2_s){
            return "已处理";
        }else if("3"==r.sync_hand_flag_poly2_s){
            return "处理失败";
        }else{
            return r.sync_hand_flag_poly2_s;
        }
    }

    function syncHandFlagPoly3(v,r,i){
        if("0"==r.sync_hand_flag_poly3_s){
            return "未处理";
        }else if("1"==r.sync_hand_flag_poly3_s){
            return "已处理";
        }else if("4"==r.sync_hand_flag_poly3_s){
            return "处理失败";
        }else{
            return r.sync_hand_flag_poly3_s;
        }
    }

    function syncHandFlagPoly4(v,r,i){
        if("0"==r.sync_hand_flag_poly4_s){
            return "未处理";
        }else if("1"==r.sync_hand_flag_poly4_s){
            return "已处理";
        }else if("5"==r.sync_hand_flag_poly4_s){
            return "处理失败";
        }else{
            return r.sync_hand_flag_poly4_s;
        }
    }

    function syncHandFlagPoly5(v,r,i){
        if("0"==r.sync_hand_flag_poly5_s){
            return "未处理";
        }else if("1"==r.sync_hand_flag_poly5_s){
            return "已处理";
        }else if("6"==r.sync_hand_flag_poly5_s){
            return "处理失败";
        }else{
            return r.sync_hand_flag_poly5_s;
        }
    }

    function syncHandFlagFlauto1(v,r,i){
        if("0"==r.sync_hand_flag_flauto1_s){
            return "未处理";
        }else if("1"==r.sync_hand_flag_flauto1_s){
            return "已处理";
        }else if("2"==r.sync_hand_flag_flauto1_s){
            return "处理失败";
        }else{
            return r.sync_hand_flag_flauto1_s;
        }
    }

    function syncHandFlagFlauto2(v,r,i){
        if("0"==r.sync_hand_flag_flauto2_s){
            return "未处理";
        }else if("1"==r.sync_hand_flag_flauto2_s){
            return "已处理";
        }else if("3"==r.sync_hand_flag_flauto2_s){
            return "处理失败";
        }else{
            return r.sync_hand_flag_flauto2_s;
        }
    }

    function syncHandFlagFlauto3(v,r,i){
        if("0"==r.sync_hand_flag_flauto3_s){
            return "未处理";
        }else if("1"==r.sync_hand_flag_flauto3_s){
            return "已处理";
        }else if("4"==r.sync_hand_flag_flauto3_s){
            return "处理失败";
        }else{
            return r.sync_hand_flag_flauto3_s;
        }
    }

    function syncHandFlagCb1(v,r,i){
        if("0"==r.sync_hand_flag_cb1_s){
            return "未处理";
        }else if("1"==r.sync_hand_flag_cb1_s){
            return "已处理";
        }else if("2"==r.sync_hand_flag_cb1_s){
            return "处理失败";
        }else{
            return r.sync_hand_flag_cb1_s;
        }
    }

    function syncHandFlagCb2(v,r,i){
        if("0"==r.sync_hand_flag_cb2_s){
            return "未处理";
        }else if("1"==r.sync_hand_flag_cb2_s){
            return "已处理";
        }else if("3"==r.sync_hand_flag_cb2_s){
            return "处理失败";
        }else{
            return r.sync_hand_flag_cb2_s;
        }
    }

    function syncHandFlagCb3(v,r,i){
        if("0"==r.sync_hand_flag_cb3_s){
            return "未处理";
        }else if("1"==r.sync_hand_flag_cb3_s){
            return "已处理";
        }else if("4"==r.sync_hand_flag_cb3_s){
            return "处理失败";
        }else{
            return r.sync_hand_flag_cb3_s;
        }
    }

    function syncHandFlagOil1(v,r,i){
        if("0"==r.sync_hand_flag_oil1_s){
            return "未处理";
        }else if("1"==r.sync_hand_flag_oil1_s){
            return "已处理";
        }else if("2"==r.sync_hand_flag_oil1_s){
            return "处理失败";
        }else{
            return r.sync_hand_flag_oil1_s;
        }
    }

    function syncHandFlagOil2(v,r,i){
        if("0"==r.sync_hand_flag_oil2_s){
            return "未处理";
        }else if("1"==r.sync_hand_flag_oil2_s){
            return "已处理";
        }else if("3"==r.sync_hand_flag_oil2_s){
            return "处理失败";
        }else{
            return r.sync_hand_flag_oil2_s;
        }
    }

    function syncHandFlagOil3(v,r,i){
        if("0"==r.sync_hand_flag_oil3_s){
            return "未处理";
        }else if("1"==r.sync_hand_flag_oil3_s){
            return "已处理";
        }else if("4"==r.sync_hand_flag_oil3_s){
            return "处理失败";
        }else{
            return r.sync_hand_flag_oil3_s;
        }
    }

    /**
     *数据字典传值
     *
     */
    function codeFormatter(v, r, i) {

        return dictFormat(v);
    }

    function syncFlag(v,r,i){
        if("A"==r.sync_flag_s){
            return "新增";
        }else if("U"==r.sync_flag_s){
            return "修改";
        }else if("D"==r.sync_flag_s){
            return "删除";
        }else{
            return r.sync_flag_s;
        }
    }

    /**
     * 获取产线
     */
     var MixpipelineList=[];
     $.ajax({
         url:"mix/basicdata/mixsilomaterials/getSilono",
         type:"get",
         dataType:"json",
         async:false,
         success:function(data){
         	MixpipelineList=data;
         }
     });
     
          //加载产线显示
 	 function Mixpipelineformatter(v,r,i){
 		 for(var i=0;i<MixpipelineList.length;i++){
 			 if(v==MixpipelineList[i].EQUIP_NAME){
 				 return MixpipelineList[i].CHILD_DESC;
 			 }
 		 }  
 	} ;

    //加载密炼机台信息
    var equiplist=[];
    $.ajax({
        url:"mix/basedata/factorymodel/getMixProductionInfo?plantype="+"051",
        type:"get",
        dataType:"json",
        async:false,
        success:function(data){
            equiplist=data;
        }
    });

    //加载胶料密炼机台信息
    var equiplist1=[];
    $.ajax({
        url:"mix/report/mixmonthlyreport/mixmonthlyreport/getMixProductionInfo?plantype="+"051004",
        type:"get",
        dataType:"json",
        async:false,
        success:function(data){
            equiplist1=data;
        }
    });

    function searchProductionLine(q, row) {
        var opts = $(this).combobox('options');
        return row[opts.textField].toUpperCase().indexOf(q.toUpperCase()) >= 0;
    }

    function equipcodeformatter(v,r,i){
        for(var i=0;i<equiplist.length;i++){
            if(v==equiplist[i].p_line_name){
                return equiplist[i].description;
            }
        }
    } ;

</script>