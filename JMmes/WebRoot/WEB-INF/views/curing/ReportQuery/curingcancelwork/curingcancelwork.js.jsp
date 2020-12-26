<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"curing/reportQuery/cancelWork/saveChanges";
    
    function showOrHide(){
        if($("#CuringCancelWork_search_form").is(":hidden")){
            $("#CuringCancelWork_search_form").show();
        }else{
            $("#CuringCancelWork_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
        var opts = $("#curingcancelwork_dg").datagrid("options");
        opts.url='curing/reportQuery/cancelWork/datagrid';
        ext.easyui.grid.search("curingcancelwork_dg","CuringCancelWork_search_form");
    }


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
        filter();
    });

    /**
     * 导出
     */
    function ExcelExport() {
        //获取grid 数据
        var node = $("#curingcancelwork_dg").datagrid("getSelections");
        if (node == "") {
            var param=ext.form.getFormAsJson("CuringCancelWork_search_form");
            var param_get="";
            for(var k in param){
                param_get=param_get+"&"+k.replace("filter[","").replace("]","")+"="+param[k];
            }
            $.ajax({
                url : "curing/ReportQuery/curingProductionReport/searchBy?s_factory_s="+factory+"&"+param_get,
                type : 'get',
                dataType : 'json',
                async : false,
                success : function(data) {
                    node = data;
                }
            });
        }
        var totalquantity = 0;
        var gradea = 0;
        var gradea0 = 0;
        var secondlevel = 0;
        var waste = 0;
        var specialwaste = 0;
        var qualitycompletionrate = 0;
        var CheckTotal = false;//检测是否选择合计行，true选中,false未选中
        for (var i = 0; i < node.length; i++) {
            totalquantity += parseFloat(node[i]["totalquantity"]);
            gradea += parseFloat(node[i]["gradea"]);
            gradea0 += parseFloat(node[i]["gradea0"]);
            secondlevel += parseFloat(node[i]["secondlevel"]);
            waste += parseFloat(node[i]["waste"]);
            specialwaste += parseFloat(node[i]["specialwaste"]);
            qualitycompletionrate = Math.floor((gradea/totalquantity/0.996*100)*1000)/1000+"%";
        }
        if (!CheckTotal) {
            //导出添加合计行
            var newJson = {
                atr_key : "",
                username : "",
                equip_code_s : "",
                material_code_s : "",
                material_name_s : '<spring:message code="dynabalancecheresultprint.column.total" />',
                class_id_s: "",
                totalquantity : "" + totalquantity + "",
                gradea : "" + gradea + "",
                gradea0 :"" + gradea0 + "",
                secondlevel : "" + secondlevel + "",
                waste : "" + waste + "",
                specialwaste : "" + specialwaste + "",
                spare1_s:"",
                qualitycompletionrate: "" + qualitycompletionrate + ""
            };
            node.push(newJson);
        }
        var data = JSON.stringify(node);
        if (data == '')
            return;
        var myDate = new Date();
        var time=myDate.toLocaleString( );
        var title=[{username:'操作人员'},{equip_code_s:'机台名称'},{material_code_s:'物料规格'},{material_name_s:'规格描述'},{class_id_s:'硫化班次'}
            ,{totalquantity:'总产量'},{gradea:'A级'},{gradea0:'A0'},{secondlevel:'二级品'},{waste:'废品'}
            ,{specialwaste:'特废'},{curing_openmoulddate:'完成工时'},{curing_closemoulddate:'定额完成率'},{qualitycompletionrate:'质量达成率'}];
        toExcel("硫化结果汇总"+time,data,title);
    }


</script>