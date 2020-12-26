<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"mix/MixCarReport/saveChanges";
    var queryRows;
    var pageNum=1;
    function showOrHide(){
        if($("#MixCarReport_search_form").is(":hidden")){
            $("#MixCarReport_search_form").show();
        }else{
            $("#MixCarReport_search_form").hide();
        }
    }
    /**
     * 查询方法
     */
    var filter=function(){
        var showpage = $('#pageInput').textbox('getValue');
        console.info("showpage"+showpage);
        var starttime =$("#start_time").datetimebox("getValue");
        var endtime=$("#end_time").datetimebox("getValue");
        if(starttime!="" && endtime!=""){
            if(starttime>endtime){
                ext.tip.error("<spring:message code="tip.date" />");
            }else{
                var opts = $("#mixcarreport_dg").datagrid("options");
                opts.url = 'mix/MixCarReport/datagrid';
                ext.easyui.grid.search("mixcarreport_dg","MixCarReport_search_form");
            }
        }else{
            var opts = $("#mixcarreport_dg").datagrid("options");
            opts.url = 'mix/MixCarReport/datagrid';
            ext.easyui.grid.search("mixcarreport_dg","MixProductReport_search_form");
        }

    }
    //最后一车
    var lastName = function(){
        var grid = $('#mixcarreport_dg');
        var options = grid.datagrid('getPager').data("pagination").options;
        var curr = options.pageNumber;
        var total = options.total;
        $('#lastNum').html("["+total+"]");//最后一车
        console.info("值："+total);
    }


    //播放器
    //回到第一行
    var zero = function(){
        pageNum=1;
        $('#lastCar').linkbutton('enable');
        $('#forwardCar').linkbutton('enable');
        $('#firstCar').linkbutton('disable');
        $('#retreatCar').linkbutton('disable');
        $('#pageInput').textbox('setValue',pageNum);
        $('#retreatNum').html(1);//上一车
        $('#forwardNum').html(2);//下一车
        lastName();
        $('#test').html("——当前车次为1");
        filter();
    }
    //后退
    var retreat = function(){
        if(pageNum==1){
            return;
        }
        pageNum=pageNum-1;
        $('#lastCar').linkbutton('enable');
        $('#forwardCar').linkbutton('enable');
        if(1==pageNum){
            $('#firstCar').linkbutton('disable');
            $('#retreatCar').linkbutton('disable');
        }
        if(pageNum!=1){
            $('#retreatNum').html(pageNum-1);//上一车
        }
        $('#forwardNum').html(pageNum+1);//下一车
        $('#pageInput').textbox('setValue',pageNum);
        lastName();
        $('#test').html("——当前车次为"+pageNum);
        filter();
    }
    //前进一行
    var forward = function(){
        var grid = $('#mixcarreport_dg');
        var options = grid.datagrid('getPager').data("pagination").options;
        var curr = options.pageNumber;
        var total = options.total;
        if(total==pageNum){return;}
        pageNum=pageNum+1;
        if(pageNum>1){
            $('#firstCar').linkbutton('enable');
            $('#retreatCar').linkbutton('enable');
        }
        $('#retreatNum').html(pageNum-1);//上一车
        if(total!=pageNum){
            $('#forwardNum').html(pageNum+1);//下一车
        }

        $('#pageInput').textbox('setValue',pageNum);
        if(total==pageNum){
            $('#forwardCar').linkbutton('disable');
            $('#lastCar').linkbutton('disable');
        }
        lastName();
        $('#test').html("——当前车次为"+pageNum);
        filter();
    }
    //跳至最后一行
    var skipLast = function(){
        var grid = $('#mixcarreport_dg');
        var options = grid.datagrid('getPager').data("pagination").options;
        var curr = options.pageNumber;
        var total = options.total;
        if(total==pageNum){return;}
        var max = Math.ceil(total/options.pageSize);
        pageNum=total;
        if(pageNum>1){
            $('#firstCar').linkbutton('enable');
            $('#retreatCar').linkbutton('enable');
        }
        $('#retreatNum').html(pageNum-1);//上一车
        $('#forwardNum').html(pageNum);//下一车
        $('#pageInput').textbox('setValue',pageNum);
        if(total==pageNum){
            $('#forwardCar').linkbutton('disable');
            $('#lastCar').linkbutton('disable');
        }
        lastName();
        $('#test').html("——当前车次为"+pageNum);
        filter();
    }

    function initGridHeight(obj) {
        if (obj != null) {
            $(window).on("resize", function () {
                try {
                    var win_h = $(window).height();
                    var height = Math.floor(win_h * 0.95);
                    var options = $(obj).datagrid('options');
                    if (options != null) {
                        if (options.fit) {
                            $(obj).parents("div.datagrid-wrap:first").css({
                                height: height + 'px'
                            });
                            $(obj).datagrid("resize");
                        }
                    }
                } catch (e) {
                    return false;
                }
            }).trigger("resize");
        }
    }


    //初始化
    $(function(){
        $('#pageInput').textbox('setValue',1);
        $("#pageInput").next().hide();
        $('#firstCar').linkbutton('disable');
        $('#retreatCar').linkbutton('disable');

        $('#firstNum').html(1);//首车
        $('#retreatNum').html(1);//上一车
        $('#forwardNum').html(2);//下一车
        $('#test').html("——当前车次为1");//当前车次
//        $('#carWeight').html("&nbsp;&nbsp;&nbsp;车重：");
        initGridHeight('#drprodimplementcl_dg');
        initGridHeight('#drprodimplementgy_dg');

    })

    var recipecodelist = [];
    var date = new Calendar().format("yyyyMMdd");
    //加载配方名称
    $.ajax({
        url : "mix/report/mixbatchreportall/getrecipecodelist?begindate="
        + date + "&enddate=" + date,
        type : "get",
        dataType : "json",
        async : false,
        success : function(data) {
            recipecodelist = data;
        }
    });
    //设定时间初始值从当前时间00:00:00至23:59:59
    $(document).ready(function(){
        $('#start_time').datebox({
            value: '3/4/2010',
            required: true,
            showSeconds: true
        });
        $('#end_time').datebox({
            value: '3/4/2010',
            required: true,
            showSeconds: true
        });
        hide();
        filter();
    });
    function onLoadSuccess(data) {
        queryRows=[];
        var dg = $("#mixcarreport_dg");
        queryRows = dg.datagrid("getRows");
        if(0==queryRows.length){
            loadfail();
            return;
        }
        $("#lot_no").html(queryRows[0].lot_no_s);//条码号
        $("#wo_no").html(queryRows[0].wo_no_s);//工单
        $("#equip_name_s").html(queryRows[0].equip_name_s);//机台名称
        if("302001"==queryRows[0].shift_code_s){//班次
            $("#shift_code").html("早班");
        }else if("302002"==queryRows[0].shift_code_s){//班次
            $("#shift_code").html("中班");
        }else if("302003"==queryRows[0].shift_code_s){//班次
            $("#shift_code").html("晚班");
        }else{
            $("#shift_code").html(queryRows[0].shift_code_s);
        }
        if("301001"==queryRows[0].group_code_s){//班组
            $("#group_code").html("甲班");
        }else if("301002"==queryRows[0].group_code_s){//班组
            $("#group_code").html("乙班");
        }else if("301003"==queryRows[0].group_code_s){//班组
            $("#group_code").html("丙班");
        }else{
            $("#group_code").html(queryRows[0].group_code_s);
        }
        $("#recipe_name").html(queryRows[0].recipe_name);//配方

        if("001001"==queryRows[0].state_code_s){//配方状态
            $("#state_code").html("合格");
        }else if("001002"==queryRows[0].state_code_s){
            $("#state_code").html("不合格");
        }else if("001003"==queryRows[0].state_code_s){
            $("#state_code").html("待检状态");
        }else if("001004"==queryRows[0].state_code_s){
            $("#state_code").html("封锁");
        }else if("001005"==queryRows[0].state_code_s){
            $("#state_code").html("特殊放行");
        }else{
            $("#state_code").html(queryRows[0].state_code_s);
        }
//        $("#state_code").html(queryRows[0].state_code_s);//配方状态
        $("#start_datetime").html(queryRows[0].start_datetime_s);//开始时间
        $("#product_time").html(queryRows[0].product_time_t);//产出时间
        $("#recipetime_i").html(queryRows[0].recipetime_i);//配方时间
        $("#dischargeenergy").html(queryRows[0].dischargeenergy_f);//排胶能量
        $("#dischargetemp").html(queryRows[0].dischargetemp_f);//排胶温度
        $("#allche").html(queryRows[0].allche_s);//设定车次
        $("#serial_id").html(queryRows[0].serial_id_i);//车次
        //炼胶时间
        $("#mixtime").html(queryRows[0].mixtime_i);
        //加胶时间
        $("#addnrtime").html(queryRows[0].addnrtime_i);
        //加胶炭黑时间
        $("#addcbtime").html(queryRows[0].addcbtime_i);
        //加油时间
        $("#addoiltime").html(queryRows[0].addoiltime_i);
        //间隔时间
        $("#intervals").html(queryRows[0].intervals_i);

        ljqx(queryRows);
    }

    function loadfail(){
        $("#lot_no").html("");//条码号
        $("#wo_no").html("");//工单
        $("#equip_name_s").html("");//机台名称
        $("#shift_code").html("");
        $("#group_code").html("");
        $("#recipe_name").html("");//配方
        $("#state_code").html("");//配方状态
        $("#start_datetime").html("");//开始时间
        $("#product_time").html("");//产出时间
        $("#recipetime_i").html("");//配方时间
        $("#dischargeenergy").html("");//排胶能量
        $("#dischargetemp").html("");//排胶温度
        $("#allche").html("");//设定车次
        $("#serial_id").html("");//车次
        //炼胶时间
        $("#mixtime").html("");
        //加胶时间
        $("#addnrtime").html("");
        //加胶炭黑时间
        $("#addcbtime").html("");
        //加油时间
        $("#addoiltime").html("");
        //间隔时间
        $("#intervals").html("");
        operateFilter();
        $('#forwardCar').linkbutton('disable');
        $('#lastCar').linkbutton('disable');
        $('#test').html("——当前无车次信息");
        console.info("drawLineBasic2D");
        drawLineBasic2D([]);
    }

    function operateFilter(){
        pageNum=1;
        $('#pageInput').textbox('setValue',1);
        $("#pageInput").next().hide();
        $('#firstCar').linkbutton('disable');
        $('#retreatCar').linkbutton('disable');
        $('#forwardCar').linkbutton('enable');
        $('#lastCar').linkbutton('enable');
        $('#firstNum').html(1);//首车
        $('#retreatNum').html(1);//上一车
        $('#forwardNum').html(2);//下一车
        $('#lastNum').html("");//最后一车
        $('#test').html("——当前车次为1");//当前车次

    }

    function ljqx(queryRows){
        var list_map={};
        list_map.equip_code_s=queryRows[0].equip_code_s;//选中行机台编码
        list_map.start_datetime_s=queryRows[0].start_datetime_s;//开始时间
        list_map.plan_no_s=queryRows[0].wo_no_s;//工单号
        list_map.serial_id_i=queryRows[0].serial_id_i;//车次
        list_map.mixtime_i=parseInt(queryRows[0].recipetime_i);//时间
        $.ajax({
            url:'mix/MixCarReport/ljqx',
            type:"post",
            dataType:"json",
            data : JSON.stringify(list_map),
            contentType:'application/json',
            async:false,
            success:function(data){
                drawLineBasic2D(data);
            }
        });
    }


    function hide(){
        document.getElementById("mixcarreport_dg").style.display='none';
    }

    function add() {
        ext.easyui.grid.appendAndEdit("mixcarreport_dg",{});
    }

    function edit() {
        var rows = $("#mixcarreport_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#mixcarreport_dg").datagrid("getRowIndex", rows[i]);
            $("#mixcarreport_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#mixcarreport_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#mixcarreport_dg").datagrid("getRowIndex", rows[i]);
            $("#mixcarreport_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#mixcarreport_dg");

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
            $("#mixcarreport_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#mixcarreport_dg").datagrid("rejectChanges");
    }

    var equiplist=[];
    //加载胶料机台信息
    $.ajax({
        url:"mix/basedata/factorymodel/getMixProductionInfo?plantype="+"051003",
        type:"get",
        dataType:"json",
        async:false,
        success:function(data){
            equiplist=data;
        }
    });

    /**
     * 机台点击获取配方
     */
    var getrecipecodebycode = function() {
        var starttime = $("#start_time").datetimebox("getValue");
        var endtime = $("#end_time").datetimebox("getValue");
        var equipcode = $("#equip_code_s").combobox("getValue");
        operateFilter();
        filter();
        if (starttime != "" && endtime != "") {
            if (starttime > endtime) {
                ext.tip.error("<spring:message code="tip.date" />");
            } else {

                $("#recipe_code_s")
                    .combobox(
                        {
                            url : "mix/MixCarReport/getrecipecodebycodelist?begindate="
                            + starttime + "&enddate=" + endtime+"&equipcode="+equipcode,
                            method : "post",
                            valueField : 'RECIPE_CODE_S',
                            textField : 'SPARE8_S',
                            selected : 'selected'
                        });
            }
        }

    };

    //当前车详细信息
    var CurrentCarDetail = function(){
        //工单，机台编码
        var lot_no = $("#lot_no").html();
        var wo_no_s = $("#wo_no").html();
       /* if(null==lot_no||undefined==lot_no||""==lot_no){
            alter("无详细信息");
            return;
        }*/
        //1、加载子表信息
        ext.ajax.post("mix/productionmanagement/drprodimplement/compositeReal",
            {"filter[lot_no_s]":lot_no,"filter[wo_no_s]":wo_no_s,all:1},
            function(data){
            console.info("得值:"+data);
            //生产班组
                var group_code_s=data.rows[0].group_code_s;
                if("301001"==data.rows[0].group_code_s){
                    group_code_s='甲班';
                }else if("301002"==data.rows[0].group_code_s){
                    group_code_s='乙班';
                }else if("301003"==data.rows[0].group_code_s){
                    group_code_s='丙班';
                }
            $("#group_code_s").html(group_code_s);
            //生产班次
                var shift_code_s=data.rows[0].shift_code_s;
                if("302001"==data.rows[0].shift_code_s){
                    shift_code_s='早班';
                }else if("302002"==data.rows[0].shift_code_s){
                    shift_code_s='中班';
                }else if("302003"==data.rows[0].shift_code_s){
                    shift_code_s='晚班';
                }
            $("#shiftCode").html(shift_code_s);
            //配方名称
            $("#recipe_code_name_s").html($("#recipe_name").html());
            //配方代码recipe_code_s
            $("#recipeCode").html(data.rows[0].recipe_code_s);

            //生产机台
            $("#equipName").html(data.rows[0].equip_name_s);
            //当前车次
            $("#serialId").html(data.rows[0].serial_id_i+"/"+data.rows[0].allche_s);
            //加胶时间(s)
            $("#addnrtime_i").html(data.rows[0].addnrtime_i);
            //工作方式

            //炼胶时间(s)
            $("#mixTime_i").html(data.rows[0].mixtime_i);
            //间隔时间(s)intervals_i
                $("#intervals_i").html(data.rows[0].intervals_i);
            //配方时间(s)
                $("#recipeTime").html(data.rows[0].recipetime_i);
            //排胶温度(℃)dischargetemp_f
                $("#dischargetemp_f").html(data.rows[0].dischargetemp_f);
            //累计能量(KWH)
                $("#dischargeenergy_f").html(data.rows[0].dischargeenergy_f);
            //排胶功率(KW)
                $("#dischargepower_f").html(data.rows[0].dischargepower_f);
            //开始时间 start_datetime_s
                $("#start_datetime_s").html(data.rows[0].start_datetime_s);
            //其他车次
            //补偿温度
                $("#makeup_temp_i").html(data.rows[0].makeup_temp_i);
        });
        //2、称重部分
        ext.ajax.post("mix/productionmanagement/drprodimplementcl/datagrid",
            {"filter[trainprod_id_s]":lot_no,all:1},
            function(data){
            $('#drprodimplementcl_dg').datagrid('loadData', data);
            var real_weight=0;
            for(var i=0;i<data.rows.length;i++){
                real_weight+=parseFloat(data.rows[i].real_weight_s);
            }
                $('#carWeight').html("&nbsp;&nbsp;&nbsp;车重："+real_weight.toFixed(2));
        });

        //3、混炼部分、炼胶部分
        ext.ajax.post("mix/productionmanagement/drprodimplementgy/datagrid",
            {"filter[trainprod_id_s]":lot_no,all:1},function(data){
            $('#drprodimplementgy_dg').datagrid('loadData', data);
        });
        $("#carDetail_dlg").dialog("open");
    }

    /**
     *班次
     */
    function shiftFilter(){
        operateFilter();
        filter();
    }

    /**
     *将数据库得值转换为数据字典与对应值域
     */
    function codeFormatter(v, r, i) {

        return dictFormat(v);
    }

    //获取称量类型数据字典对应关系
    var WeightTypeDict = [];
    ext.ajax.get("common/plm/mixrecipe/getDictFormatter?dictcode=" + "324",
        function(data) {
            WeightTypeDict = data;
        });
    function weightTypeformatter(v, r, i) {
        for (var j = 0; j < WeightTypeDict.length; j++) {
            if (v == WeightTypeDict[j].ERPCODE_S) {
                return v + '-' + WeightTypeDict[j].DICTNAME_S
            }
        }
        return v;
    }

    //获取条件代码数据字典对应关系
    var ConditionDict=[];
    ext.ajax.get("common/plm/mixrecipe/getDictFormatter?dictcode="+"326",function(data){
        ConditionDict=data;
    });

    function conditionformatter(v,r,i){
        for(var j=0;j<ConditionDict.length;j++){
            if(v==ConditionDict[j].ERPCODE_S){
                return v+'-'+ConditionDict[j].DICTNAME_S;
            }else if("0"==v){
                return v+'-'+ConditionDict[j].DICTNAME_S;
            }
        }
        return v;
    }

    //获取动作代码数据字典对应关系
    var ActionDict = [];
    ext.ajax.get("common/plm/mixrecipe/getDictFormatter?dictcode=" + "325",
        function(data) {
            ActionDict = data;
        });

    function actionformatter(v, r, i) {
        for (var j = 0; j < ActionDict.length; j++) {
            if (v == ActionDict[j].ERPCODE_S) {
                return v + '-' + ActionDict[j].DICTNAME_S
            }
        }
        return v;
    }

    /**
     * 配方名称
     */
    function recipeFilter(){
        operateFilter();
        filter();
    }

    function searchProductionLine(q, row) {
        var opts = $(this).combobox('options');
        return row[opts.textField].toUpperCase().indexOf(q.toUpperCase()) >= 0;
    }

    function drawLineBasic2D(ichart){
        var temp=[];
        for(var i=0;i<ichart.length;i++){
            if(ichart[i].temp!=null&&ichart[i].temp!=undefined){
                temp.push(ichart[i].temp);
            }
        }
        var energy=[];
        for(var i=0;i<ichart.length;i++){
            if(ichart[i].energy!=null&&ichart[i].energy!=undefined){
                energy.push(ichart[i].energy);
            }
        }
        var power=[];
        for(var i=0;i<ichart.length;i++){
            if(ichart[i].power!=null&&ichart[i].power!=undefined){
                power.push(ichart[i].power);
            }
        }
        var maxRight = Math.max.apply(null,power);
        var mixRight=200;
        maxRight=parseInt(maxRight);
     /*   if(maxRight>1350){
            if(maxRight>2000){
               maxRight=2400;
               mixRight=200;
            }else{
                if(maxRight>1600){
                    maxRight=2000;
                    mixRight=200;
                }else{
                    maxRight=1500;
                    mixRight=150;
                }
            }
        }else if(maxRight<1350){
            if(maxRight<1000){
                if(maxRight<500){
                    if(maxRight<300){
                        maxRight=300;
                        mixRight=30;
                    }else{
                        maxRight=400;
                        mixRight=40;
                    }
                }else if(maxRight<800){
                    maxRight=800;
                    mixRight=80;
                }else{
                    maxRight=1000;
                    mixRight=100;
                }
            }
        }*/
        maxRight=2400;
        mixRight=480;
        var rotate=[];
        for(var i=0;i<ichart.length;i++){
            if(ichart[i].rotate!=null&&ichart[i].rotate!=undefined){
                rotate.push(ichart[i].rotate);
            }
        }
        var sj=[];
        for(var i=0;i<ichart.length;i++){
            if(ichart[i].date!=null&&ichart[i].date!=undefined){
                if(i%90==0){
                    sj.push(ichart[i].date);
                }
            }
        }
        var press=[];
        for(var i=0;i<ichart.length;i++){
            if(ichart[i].press!=null&&ichart[i].press!=undefined){
                press.push(ichart[i].press);
            }
        }
        var topBoltPosition=[];
        for(var i=0;i<ichart.length;i++){
            if(ichart[i].topBoltPosition!=null&&ichart[i].topBoltPosition!=undefined){
                topBoltPosition.push(ichart[i].topBoltPosition);
            }
        }
        var maxLeft = Math.max.apply(null,topBoltPosition);
        var mixLeft=20;
     /*   maxLeft=parseInt(maxLeft);
        if(maxLeft>240){
            maxLeft=300;
            mixLeft=30;
        }else{*/
            maxLeft=250;
            mixLeft=50;
//        }

        //console.log(sj);
        var data = [
            {
                name : '温度',
                value:temp,
                color:'#c12c44',
                line_width:2
            },
            {
                name : '能量',
                value:energy,
                color:'#2ba5a4',
                line_width:2
            },
            {
                name : '功率',
                value:power,
                scaleAlign:'right',//使用哪个y轴坐标
                color:'#ffaa25',
                line_width:2
            },
            {
                name : '转速',
                value:rotate,
                color:'#00ff00',
                line_width:2
            },
            {
                name : '压力',
                value:press,
                color:'#76a871',
                line_width:2
            },
            {
                name : '上顶拴',
                value:topBoltPosition,
                color:'#BA55D3',
                line_width:2
            }
        ];
        //绑定X坐标时间的值
        var labels=[];
        var o = document.getElementById("ljFrame");
        var w = o.clientWidth||o.offsetWidth;// JS动态获取div的宽度
        var h = o.clientHeight||o.offsetHeight;//JS动态获取div的高度同理：
        var width = w;
        var height = h;
        console.info("宽:"+width+"——高:"+height);
        for(var i=0;i<ichart.length;i++){
            labels.push(ichart[i].date);
        }
        var chart = new iChart.LineBasic2D({
            render : 'canvasDiv',
            data: data,
            align:'center',
            title : {
                text:'炼胶曲线图',
                font : '微软雅黑',
                fontsize:24,
                color:'#b4b4b4'

            },

            width : width,
            height : height,
            shadow:true,//此组件是否启用阴影效果。启用阴影在移动客户端上可能会引起渲染速度变慢。(默认为false)
            shadow_color : '#202020',//此组件阴影的颜色值.(默认为'#666666')
            shadow_blur : 8,//此组件阴影的模糊程度,单位px。(默认为4)
            shadow_offsetx : 0,//此组件阴影的x轴偏移量,单位px。(默认为0)
            shadow_offsety : 0,//此组件阴影的y轴偏移量,单位px。(默认为0)
            background_color:'#2e2e2e',//组件中背景颜色(填充色)的值。(默认为'FEFEFE')
            tip:{
                enable:true,
                shadow:true,
                border:{//设置开启边框。
                    enable:true,
                    radius : 5,
                    width:2,
                    color:'#3f8695'
                },
                showType:'follow',//提示框的类型。(默认为'follow')follow 跟随鼠标;fixed 固定位置
                listeners:{
                    //tip:提示框对象、name:数据名称、value:数据值、text:当前文本、i:数据点的索引
                    parseText:function(tip,name,value,text,i){
                        // console.info("parseText");
                        /*if(name=="压力"){
                         value=value.toFixed(2);
                         }else if(name!="转速"&&name!="压力"){
                         value=value.toFixed(1);
                         }*/
                        var message = "<span style='color:#005268;font-size:20px;'>"+name+"为:"+"</span><span style='color:#005268;font-size:20px;'>"+value;
                        /* if(name=="压力"){
                         message+= "Mpa</span>";
                         }else if(name=="转速")
                         {
                         message+= "</span>";
                         }else{
                         message+= "</span>";
                         }*/
                        return message;
                    }
                }
            },

            tipMocker:function(tips,i){//当有多条线段(数据)时，可以利用tipMocker将tip整合到一起。作为一个iChart.Tip展示出来。tipMocker是个很实用的配置。需要掌握。(默认为null)
                return "<div style='font-weight:600;color:#005268;'>"+labels[i]+"车次曲线参数如下:</div>"+tips.join("<br/>");
            },
            legend : {//图例的配置项.详情请参考 iChart.Legend Note:设置为false表示禁用图例。(默认为false)
                enable : true,
                row:1,//设置在一行上显示，与column配合使用
                column : 'max',//图例的列数。(默认为1) 如果设置为'max',则其依赖配置项row
                valign:'bottom',//图例在图表中垂直对齐方式。(默认为'middle') 'middle' 当配置项align = 'left|right'时生效。'bottom', 'top'
                sign:'square',//图例中小图标的样式。(默认为'square') 'round' 'round-bar' 'square-bar'
                background_color:null,//设置null为透明背景
                color:'#9d987a',
                offsetx:-(width/2)+100,//设置x轴偏移，满足位置需要
                offsety:14,//设置x轴偏移，满足位置需要
                border : false,
                font : '微软雅黑',
                fontweight:600
            },
            crosshair:{
                enable:true,
                line_color:'#ec4646'
            },
            sub_option : {
                smooth : true,
                label:false,
                hollow:false,
                hollow_inside:false,
                point_size:2
            },
            coordinate:{
                width:width-100,
                height:height-100,
                //striped_factor : 0.18,
                grid_color:'#4e4e4e',
                //axis:{
                //color:'#252525',
                //width:[0,0,4,4]
                //},
                scale:[{
                    position:'left',
                    start_scale:0,
                    end_scale:maxLeft,
                    scale_space:mixLeft,
                    scale_size:2,//刻度线的粗细
                    scale_enable : false,
                    label : {color:'#9d987a',font : '微软雅黑',fontsize:11,fontweight:600},
                    scale_color:'#9f9f9f',
                    listeners:{//配置事件
                        parseText:function(t,x,y){//设置解析值轴文本
                            return {text:t}
                        }
                    }
                },{
                    position:'right',
                    start_scale:0,
                    end_scale:maxRight,
                    scale_space:mixRight,
                    scale_size:2,//刻度线的粗细
                    scale_enable : true,//是否显示刻度线
                    scale2grid : false,//是否网格与刻度保持一致
                    scaleAlign:'center',//刻度线相对于坐标轴的对齐方式，。(默认为'center')。当配置项which为'h'(水平)时，
                    //可选值有：@Option 'left'@Option 'center'@Option 'right' 当配置项which为'v'(垂直)时，可选值有：@Option 'top'@Option 'center'@Option 'bottom'
                    label : {color:'#9d987a',font : '微软雅黑',fontsize:11,fontweight:600},
                    scale_color:'#9f9f9f',
                    listeners:{//配置事件
                        parseText:function(t,x,y){//设置解析值轴文本
                            return {text:t}
                        }
                    }
                },
                    {
                        position:'bottom',
                        label : {color:'#9d987a',font : '微软雅黑',fontsize:11,fontweight:600},
                        scale_space:2,
                        scale_enable : true,//是否显示刻度线
                        scale2grid : true,//是否网格与刻度保持一致
                        labels:sj
                    }]
            }
        });
        //利用自定义组件构造左侧说明文本
        chart.plugin(new iChart.Custom({
            drawFn:function(){
                console.info("开始计算");
                //计算位置
                var coo = chart.getCoordinate(),
                    x = coo.get('originx'),
                    y = coo.get('originy'),
                    w = coo.width,
                    h = coo.height;
                //在左上侧的位置，渲染一个单位的文字
                chart.target.textAlign('start')
                    .textBaseline('bottom')
                    .textFont('600 11px 微软雅黑')
                    .fillText('温度(℃)能量(KWH)压力(bar)转速(RPM)',x-40,y-12,false,'#9d987a');
                //在右上侧的位置，渲染一个单位的文字
                chart.target.textAlign('end')
                    .textBaseline('bottom')
                    .textFont('600 11px 微软雅黑')
                    .fillText('温度(度)',x+w+30,y-12,false,'#9d987a');
            }
        }));
        //开始画图
        chart.draw();
    }

    function exportReportTemplet() {
        var o = document.getElementById("ljFrame");
//        var w = o.clientWidth||o.offsetWidth;// JS动态获取div的宽度
        var h1 = o.clientHeight||o.offsetHeight;//JS动态获取div的高度同理：
        var element = $("#ljFrame");    // 这个dom元素是要导出pdf的div容器
        var w = element.width()+element.width()*0.28;    // 获得该容器的宽
        var h = element.height()+element.height()*0.2;    // 获得该容器的高
//        var h = 600;
        var offsetTop = element.offset().top;    // 获得该容器到文档顶部的距离
        var offsetLeft = element.offset().left;    // 获得该容器到文档最左的距离
        var canvas = document.createElement("canvas");
        canvas.width = w * 2;    // 将画布宽&&高放大两倍
        canvas.height = h * 2;
        var context = canvas.getContext("2d");
        var scale = 2;
        context.scale(2, 2);
        //  context.translate(-offsetLeft - abs, -offsetTop);

        var opts = {
            scale: scale,
            canvas: canvas,
            width: w,
            height: h,
            useCORS: true,
            background: '#FFF'
        }

        html2canvas(element, opts).then(function (canvas) {
            allowTaint: false;
            taintTest: false;
            var contentWidth = canvas.width;
            var contentHeight = canvas.height;
            //一页pdf显示html页面生成的canvas高度;
//            var pageHeight = contentWidth / 592.28 * 841.89;
            var pageHeight = contentWidth;
            //未生成pdf的html页面高度
            var leftHeight = contentHeight;
            //页面偏移
            var position = 0;
            //a4纸的尺寸[595.28,841.89]，html页面生成的canvas在pdf中图片的宽高
            var imgWidth = 592.28;
            var imgHeight = 592.28 / contentWidth * contentHeight;

            var pageData = canvas.toDataURL('image/jpeg', 1.0);
            //   var oCanvas = document.getElementById("print");
            // Canvas2Image.saveAsJPEG(oCanvas);
            var pdf = new jsPDF('', 'pt', 'a4');

            //有两个高度需要区分，一个是html页面的实际高度，和生成pdf的页面高度(841.89)
            //当内容未超过pdf一页显示的范围，无需分页
            if (leftHeight < pageHeight) {
                pdf.addImage(pageData, 'JPEG', -65, 0, imgWidth, imgHeight);
            } else {    // 分页
                while (leftHeight > 0) {
                    pdf.addImage(pageData, 'JPEG', -65, position, imgWidth, imgHeight)
                    leftHeight -= pageHeight;
                    position -= 841.89;
                    //避免添加空白页
                    if (leftHeight > 0) {
                        pdf.addPage();
                    }
                }
            }
            pdf.save('炼胶曲线.pdf');
        })

    }


</script>