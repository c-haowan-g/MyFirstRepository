<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

/**
 *数据字典传值
 *
 */
function codeFormatter(v, r, i) {
	return dictFormat(v);
}
function textFomatter(v){
	if(v==1){
		return "是";
	}else{
		return "否";	
	}
}

    
    
 
    
    /**
     * 查询方法
     */
     var filter=function(){
    	var opts = $("#workorderresult_dg").datagrid("options");
 		opts.url = 'curing/report/productionSubsidiaryQuery/searchBy';
     	ext.easyui.grid.search("workorderresult_dg","WorkOrderResult_search_form");
     }
    
    //设定时间初始值从当前时间00:00:00至23:59:59
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
    
    function searchDxyl(){
    	var list_map={};
    	var rows = $("#workorderresult_dg").datagrid('getSelected');
    	if(rows==null){
    		 ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
    		 return;
    	}else{
    		list_map.barcode_s=rows.tyre_barcode_s;//轮胎条码
    		list_map.equip_code_s=rows.equip_code_s;//选中行机台编码
    		list_map.curing_closemoulddate_t=rows.curing_closemoulddate_t;//选中行硫化开始时间
    		list_map.curing_openmoulddate_t=rows.curing_openmoulddate_t;//选中行硫化结束
    		 $.ajax({
    		 		url:'curing/report/productionSubsidiaryQuery/dxyl',
    		 		type:"post",
    		 		dataType:"json",
    		 		data : JSON.stringify(list_map),
    				contentType:'application/json',
    		 		async:false,
    		 		success:function(data){
    		 			drawYlLineBasic2D(data);
    		 		}
    		 });
    	}
    }


function drawYlLineBasic2D(ichart){
    if(ichart==null){
        ext.tip.error("<spring:message code="tip.nodxyl" />");
        return;
    }

    $("#yl_qx").window('open');
    var yl=[];
    for(var i=0;i<ichart.length;i++){
        if(ichart[i].yl!=null&&ichart[i].yl!=undefined){
            yl.push(ichart[i].yl);
        }
    }
    var showtime=[];
    for(var i=0;i<ichart.length;i++){
        if(ichart[i].dates!=null&&ichart[i].dates!=undefined){
            showtime.push(ichart[i].dates);
        }
    }
    var sj=[];
    for(var i=0;i<ichart.length;i++){
        if(ichart[i].date!=null&&ichart[i].date!=undefined){
            sj.push(ichart[i].date);
        }
    }
    //SimpleDateFormat smf = new SimpleDateFormat("yyyy-mm-dd hh:mi:ss");
    var starttime=new Date(sj[0]);
    var endtime=new Date(sj[1]);
    var time=Math.floor(endtime-starttime)/1000;
    var shousj=[];
    shousj.push(sj[0]);
    for(var i=1;i<time;i++){
        if(time/(i*20)>1){
            debugger;
            var sdate =new Date((starttime.setSeconds(starttime.getSeconds()+10)));
            shousj.push(sdate.getHours()+":"+sdate.getMinutes()+":"+sdate.getSeconds());
        }
    }
    shousj.push(sj[1]);
    debugger;
    console.log(showtime[0]+"--"+showtime[1]);
    var data = [
        {
            name : '定型压力',
            value:yl,
            color:'#c12c44',
            line_width:2
        },{
            name : '时间',
            value:showtime,
            color:'#2ba5a4',
            line_width:2
        }
    ];

    //绑定X坐标时间的值
    var labels=[];
    var rows = $("#workorderresult_dg").datagrid('getSelected');
    var curing_closemoulddate_t =rows.curing_closemoulddate_t;
    curing_closesub=curing_closemoulddate_t.substring(11);
    var curing_openmoulddate_t =rows.curing_openmoulddate_t;
    curing_opensub=curing_openmoulddate_t.substring(11);
    var closedate = new Date(curing_closemoulddate_t);
    var min=closedate.getMinutes();
    var sec=closedate.getMinutes();
    closedate.setMinutes(min+6);
    var datas=[curing_closesub,closedate,curing_opensub];
    var width = $(window).width() < 800 ? 800 : $(window).width();
    var height = $(window).height() < 500 ? 500 : $(window).height();
    for(var i=0;i<ichart.length;i++){
        labels.push(ichart[i].dates);
    }
    debugger;
    var chart = new iChart.LineBasic2D({
        render : 'dxylDiv',
        data: data,
        align:'center',
        title : {
            text:'定型压力图',
            font : '微软雅黑',
            fontsize:24,
            color:'#b4b4b4'

        },

        width : width-2,
        height : height-85,
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
                    if(name!="时间"){
                        var message = "<span style='color:#005268;font-size:20px;'>"+name+"为:"+"</span><span style='color:#005268;font-size:20px;'>"+value;
                        message+="Mpa</span>";
                        return message;
                    }
                }
            }
        },

        tipMocker:function(tips,i){//当有多条线段(数据)时，可以利用tipMocker将tip整合到一起。作为一个iChart.Tip展示出来。tipMocker是个很实用的配置。需要掌握。(默认为null)
            return "<div style='font-weight:600;color:#005268;'>"+labels[i]+"定型压力参数如下:</div>"+tips.join("<br/>");
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
                position:'right',
                start_scale:0,
                end_scale:0.2,
                scale_space:0.04,
                scale_size:2,//刻度线的粗细
                scale_enable : true,//是否显示刻度线
                scale2grid : false,//是否网格与刻度保持一致
                scaleAlign:'center',//刻度线相对于坐标轴的对齐方式，。(默认为'center')。当配置项which为'h'(水平)时，
                //可选值有：@Option 'left'@Option 'center'@Option 'right' 当配置项which为'v'(垂直)时，可选值有：@Option 'top'@Option 'center'@Option 'bottom'
                label : {color:'#9d987a',font : '微软雅黑',fontsize:11,fontweight:600},
                scale_color:'#9f9f9f',
                listeners:{//配置事件
                    parseText:function(t,x,y){//设置解析值轴文本
                        return {text:t+" Mpa"}
                    }
                }
            },
                {
                    position:'bottom',
                    label : {color:'#9d987a',font : '微软雅黑',fontsize:11,fontweight:600},
                    scale_space:2,
                    scale_enable : true,//是否显示刻度线
                    scale2grid : true,//是否网格与刻度保持一致
                    labels:shousj
                }]
        }
    });
    //利用自定义组件构造左侧说明文本
    chart.plugin(new iChart.Custom({
        drawFn:function(){
            //计算位置
            var coo = chart.getCoordinate(),
                x = coo.get('originx'),
                y = coo.get('originy'),
                w = coo.width,
                h = coo.height;

            //在右上侧的位置，渲染一个单位的文字
            chart.target.textAlign('end')
                .textBaseline('bottom')
                .textFont('600 11px 微软雅黑')
                .fillText('压力(Mpa)',x+w+30,y-12,false,'#9d987a');
        }
    }));
    //开始画图
    chart.draw();
}
    
    
    //弹出硫化曲线图
    function  onDblClickRow(){
    	var list_map={};
    	var rows = $("#workorderresult_dg").datagrid('getSelected');
		if(rows.curing_openmoulddate_t==null)
			ext.tip.error("模具未开模，请等待!");
		else{
			$("#lh_qx").window('open');
			 list_map.equip_code_s=rows.equip_code_s;//选中行机台编码
			 list_map.curing_closemoulddate_t=rows.curing_closemoulddate_t;//选中行硫化开始时间
			 list_map.curing_openmoulddate_t=rows.curing_openmoulddate_t;//选中行硫化结束
			 $.ajax({
  		 		url:'curing/report/productionSubsidiaryQuery/lhqx',
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
    }

function drawLineBasic2D(ichart){
    var rbwd=[];
    debugger;
    for(var i=0;i<ichart.length;i++){
        if(ichart[i].rbwd!=null&&ichart[i].rbwd!=undefined){
            rbwd.push(ichart[i].rbwd);
        }
    }
    var rhwd=[];
    for(var i=0;i<ichart.length;i++){
        if(ichart[i].rhwd!=null&&ichart[i].rhwd!=undefined){
            rhwd.push(ichart[i].rhwd);
        }
    }
    var nw=[];
    for(var i=0;i<ichart.length;i++){
        if(ichart[i].nw!=null&&ichart[i].nw!=undefined){
            nw.push(ichart[i].nw);
        }
    }
    var ny=[];
    for(var i=0;i<ichart.length;i++){
        if(ichart[i].ny!=null&&ichart[i].ny!=undefined){
            ny.push(ichart[i].ny);
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
    var bx=[];
    for(var i=0;i<ichart.length;i++){
        if(ichart[i].bx!=null&&ichart[i].bx!=undefined){
            bx.push(ichart[i].bx);
        }
    }
    //console.log(sj);
    var data = [
        {
            name : '热板温度',
            value:rbwd,
            color:'#c12c44',
            line_width:2
        },
        {
            name : '热环温度',
            value:rhwd,
            color:'#2ba5a4',
            line_width:2
        },
        {
            name : '内温',
            value:nw,
            color:'#ffaa25',
            line_width:2
        },
        {
            name : '步序',
            value:bx,
            color:'#00ff00',
            line_width:2
        },
        {
            name : '内压',
            value:ny,
            scaleAlign:'right',//使用哪个y轴坐标
            color:'#76a871',
            line_width:2
        }

    ];

    //绑定X坐标时间的值
    var labels=[];
    var rows = $("#workorderresult_dg").datagrid('getSelected');

    var curing_closemoulddate_t =rows.curing_closemoulddate_t;

    curing_closesub=curing_closemoulddate_t.substring(11);

    var curing_openmoulddate_t =rows.curing_openmoulddate_t;

    curing_opensub=curing_openmoulddate_t.substring(11);


    var closedate = new Date(curing_closemoulddate_t);

    var min=closedate.getMinutes();

    closedate.setMinutes(min+6);

    var width = $(window).width() < 800 ? 800 : $(window).width();
    var height = $(window).height() < 500 ? 500 : $(window).height();
    for(var i=0;i<ichart.length;i++){
        labels.push(ichart[i].date);
    }

    var chart = new iChart.LineBasic2D({
        render : 'canvasDiv',
        data: data,
        align:'center',
        title : {
            text:'硫化曲线图',
            font : '微软雅黑',
            fontsize:24,
            color:'#b4b4b4'

        },

        width : width-2,
        height : height-85,
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
                    if(name=="内压"){
                        value=value.toFixed(2);
                    }else if(name!="步序"&&name!="内压"){
                        value=value.toFixed(1);
                    }else if(name =="步序"&&name!="内压"){
                        value=value.toFixed(0);
                    }
                    var message = "<span style='color:#005268;font-size:20px;'>"+name+"为:"+"</span><span style='color:#005268;font-size:20px;'>"+value;
                    if(name=="内压"){
                        message+= "Mpa</span>";
                    }else if(name=="步序")
                    {
                        message+= "</span>";
                    }else{
                        message+= "℃</span>";
                    }
                    return message;
                }
            }
        },

        tipMocker:function(tips,i){//当有多条线段(数据)时，可以利用tipMocker将tip整合到一起。作为一个iChart.Tip展示出来。tipMocker是个很实用的配置。需要掌握。(默认为null)
            return "<div style='font-weight:600;color:#005268;'>"+labels[i]+"硫化曲线参数如下:</div>"+tips.join("<br/>");
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
                end_scale:225,
                scale_space:25,
                scale_size:2,//刻度线的粗细
                scale_enable : false,
                label : {color:'#9d987a',font : '微软雅黑',fontsize:11,fontweight:600},
                scale_color:'#9f9f9f',
                listeners:{//配置事件
                    parseText:function(t,x,y){//设置解析值轴文本
                        return {text:t+'℃'}
                    }
                }
            },{
                position:'right',
                start_scale:0,
                end_scale:4.0,
                scale_space:0.5,
                scale_size:2,//刻度线的粗细
                scale_enable : true,//是否显示刻度线
                scale2grid : false,//是否网格与刻度保持一致
                scaleAlign:'center',//刻度线相对于坐标轴的对齐方式，。(默认为'center')。当配置项which为'h'(水平)时，
                //可选值有：@Option 'left'@Option 'center'@Option 'right' 当配置项which为'v'(垂直)时，可选值有：@Option 'top'@Option 'center'@Option 'bottom'
                label : {color:'#9d987a',font : '微软雅黑',fontsize:11,fontweight:600},
                scale_color:'#9f9f9f',
                listeners:{//配置事件
                    parseText:function(t,x,y){//设置解析值轴文本
                        return {text:t+" Mpa"}
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
                .fillText('内温(℃)',x-40,y-12,false,'#9d987a');


            //在右上侧的位置，渲染一个单位的文字
            chart.target.textAlign('end')
                .textBaseline('bottom')
                .textFont('600 11px 微软雅黑')
                .fillText('内压(Mpa)',x+w+30,y-12,false,'#9d987a');
        }
    }));
    //开始画图
    chart.draw();
     
}

    function istestFormatter(v, r, i) {
        if(v == null) {
	        return v;
		}
		if(v == "1" ){
			return "是"; 
		}
		if(v == "0"){
			return "否"; 
		}
	}

</script>