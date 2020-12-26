<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"curing/report/qualitydegrade/saveChanges";
    
    function showOrHide(){
        if($("#QualityDegrade_search_form").is(":hidden")){
            $("#QualityDegrade_search_form").show();
        }else{
            $("#QualityDegrade_search_form").hide();
        }
    }
  //加载产线信息
	var jtxx = [];
	$.ajax({
		url : 'curing/baseData/curingProductionLine/searchDescription',
		type : 'get',
		dataType : 'json',
		async : false,
		success : function(data) {
			jtxx = data;
		}
	});
      /**
     * 查询方法
     */
    var filter=function(){
    	var opts = $("#qualitydegrade_dg").datagrid("options");
 		opts.url = 'curing/report/qualitydegrade/datagridUDA';
 		ext.easyui.grid.search("qualitydegrade_dg","QualityDegrade_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("qualitydegrade_dg",{});
    }

    function edit() {
        var rows = $("#qualitydegrade_dg").datagrid("getSelections");
        if(rows==null||rows==""){
   		 ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
   		 return;
   	 	}
	   	 if(rows[0].pro_type_s!=1){
	   		 ext.tip.error("<spring:message code="tip.uncuringtype" />");
	   		 return;
	   	 }
	   	 if(rows[0].auditing_status_s!=1){
	   		 ext.tip.error("<spring:message code="tip.unautingstatus" />");
	   		 return;
	   	 }
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#qualitydegrade_dg").datagrid("getRowIndex", rows[i]);
            $("#qualitydegrade_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#qualitydegrade_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#qualitydegrade_dg").datagrid("getRowIndex", rows[i]);
            $("#qualitydegrade_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#qualitydegrade_dg");

        var rows = dg.datagrid("getRows");
        var valid = false;
        for (var i = 0; i < rows.length; i++) {
            if (!dg.datagrid("validateRow", i)) {
                ext.tip.error("<spring:message code="tip.invalid" />");
                return;
            }
        }
        var updated = dg.datagrid("getChanges", "updated");
        for (var i = 0; i < rows.length; i++) {
            dg.datagrid("endEdit", i);
        }
    }

    function cancel() {
        $("#qualitydegrade_dg").datagrid("rejectChanges");
    }

    function sourceFormatter(v,r,i){
    	if(v==1){
    		return "报警";
    	}else if(v==2)
    		return "检测";
    	else if(v==3)
    		return "改判";
    }

    function codeFormatter(v, r, i) {
    	return dictFormat(v);
    }
    
    function proFormatter(v,r,i){
    	if(v==1)
    		return "硫化报警";
    	else if(v==2)
    		return "动平衡";
    	else if(v==3)
    		return "外观判级";
    	else if(v==4)
    		return "X光";
    }
    
    //是否审核
    function isauditing(v,r,i){
    	if(v=="2"||v==null)
    		return "已审核";
    	else if(v=="1")
    		return "未审核";
    }
    //审核
    function auditingOperate(){
    	 //var rows = $("#qualitydegrade_dg").datagrid("getSelections");
    	
    	 debugger;
         var rows = $("#qualitydegrade_dg").datagrid("getSelections");
         var list_map={};
      	 if(rows==null||rows==""){
    		 ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
    		 return;
    	 }
    	 if(rows[0].pro_type_s!=1){
    		 ext.tip.error("<spring:message code="tip.uncuringtype" />");
    		 return;
    	 }
    	 if(rows[0].auditing_status_s!=1){
    		 ext.tip.error("<spring:message code="tip.unautingstatus" />");
    		 return;
    	 }
    	 save();
    	 list_map.atr_key=rows[0].atr_key;
         list_map.barcode_s=rows[0].barcode_s;
      	 list_map.gradecode=rows[0].curinggrade;
         $.ajax({
  	 		url:'curing/report/qualitydegrade/isAuding',
  	 		type:"post",
  	 		dataType:"json",
  			contentType:'application/json',
  	 		async:false,
  	 		data:JSON.stringify(list_map),
  	 		success:function(data){
  	 			if(data.code==OK){
  	    			ext.tip.suc();
  	    			filter();
  	    			return;
  	    		}
  	    		ext.tip.error(data.message);
  	 		}
  		 });
    } 
    //撤销审核
    function unauditingOperate(){
    	var rows = $("#qualitydegrade_dg").datagrid("getSelections");
    	if(rows==null||rows==""){
   		    ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
   		    return;
   	 	}
    	if(rows[0].pro_type_s!=1){
    		ext.tip.error("<spring:message code="tip.uncuringtype" />");
    		return;
    	}
    	if(rows[0].auditing_status_s!=2&&rows[0].auditing_status_s!=null){
    		ext.tip.error("<spring:message code="tip.autingstatus" />");
    		return;
    	}
    	//var ids=rows[0].barcode_s;
    	var list_map={};
    	list_map.atr_key=rows[0].atr_key;
    	//alert(rows[0].atr_key);
    	list_map.gradecode="";
    	list_map.barcode_s=rows[0].barcode_s;
		$.ajax({
	 		url:'curing/report/qualitydegrade/forced',
	 		type:"post",
	 		dataType:"json",
			contentType:'application/json',
	 		async:false,
	 		data:JSON.stringify(list_map),
	 		success:function(data){
	 			if(data.code==OK){
	    			ext.tip.suc();
	    			filter();
	    			return;
	    		}
	    		ext.tip.error(data.message);
	 			//$('#plandhheeader_dgTwo').datagrid('loadData', data);
	 			//ext.easyui.grid.search("plandhheeader_dgTwo","PlandhHeeader_search_formTwo");
	 		}
		 });
    }
    
    var entCodeName=[];
		$.ajax({
	 		url:"common/combox_entcode",
	 		type:"get",
	 		dataType:"json",
	 		async:true,
	 		success:function(data){
	 			entCodeName=data;
	 		}
	 	});
	    
	    function entCodeFormatter(v,r,i){
	    	for(var i=0;i<entCodeName.length;i++){
	    		if(v==entCodeName[i].ENTBARCODE_S){
	    			return entCodeName[i].ENTNAME_S;
	    		}
	    	}
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
  	
  	//查看明细
 	 function productionDetail(){
 		 
 		  var rows = $("#qualitydegrade_dg").datagrid("getSelections");
 		  if (rows != "" && rows != null) {
 			  debugger;
 			  var list_map={};
			  list_map.barcode_s=rows[0].barcode_s;
 			  if(rows[0].pro_type_s==1){
	 			  list_map.type=rows[0].pro_type_s;
	 			  $("#productionDetail").window("open");
	 			  $.ajax({
	 		 		url:'curing/report/qualitydegrade/searchDetail',
	 		 		type:"post",
	 		 		dataType:"json",
	 				contentType:'application/json',
	 		 		async:false,
	 		 		data:JSON.stringify(list_map),
	 		 		success:function(data){
	 		 			$('#plandhheeader_dgTwo').datagrid('loadData', data);
	 		 			//ext.easyui.grid.search("plandhheeader_dgTwo","PlandhHeeader_search_formTwo");
	 		 		}
	 			 });
 			  }else if(rows[0].pro_type_s==2){
 				  $("#dynaDetail").window("open");
	 			  $.ajax({
	 		 		url:'curing/report/qualitydegrade/searchDynabakanceByCode',
	 		 		type:"post",
	 		 		dataType:"json",
	 				contentType:'application/json',
	 		 		async:false,
	 		 		data:JSON.stringify(list_map),
	 		 		success:function(data){
	 		 			$('#dyna_dgDetail').datagrid('loadData', data);
	 		 			//ext.easyui.grid.search("plandhheeader_dgTwo","PlandhHeeader_search_formTwo");
	 		 		}
	 			 });
 			  }else if(rows[0].pro_type_s==3){
 				  $("#detialDetail").window("open");
	 			  $.ajax({
	 		 		url:'curing/report/qualitydegrade/searchDetialByCode',
	 		 		type:"post",
	 		 		dataType:"json",
	 				contentType:'application/json',
	 		 		async:false,
	 		 		data:JSON.stringify(list_map),
	 		 		success:function(data){
	 		 			$('#detial_dgDetail').datagrid('loadData', data);
	 		 			//ext.easyui.grid.search("plandhheeader_dgTwo","PlandhHeeader_search_formTwo");
	 		 		}
	 			 });
 			  }
 		  }else{
 	      	ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
 	      }      	
 	  }  
  	
 	//弹出硫化曲线图
    function onDblClickRow(){
    	var rows = $("#qualitydegrade_dg").datagrid('getSelected');
    	if(rows.pro_type_s!="1"){
            ext.tip.error("<spring:message code="非硫化数据无硫化曲线" />");
    		return;
    	}
    	var list_map={};
    	list_map.tyreCode=rows.barcode_s;
    	$("#lh_qx").window('open');
    	//url:'curing/report/qualitydegrade/wirteHx',原有地址
    	 $.ajax({
		 		url:'curing/report/qualitydegrade/wirteHx',
		 		type:"post",
		 		dataType:"json",
				contentType:'application/json',
		 		async:false,
		 		data:JSON.stringify(list_map),
		 		success:function(data){
		 			drawLineBasic2D(data);
		 		}
			 }); 
    }

    function onDblClickRowDetail(){
    	var rows = $("#plandhheeader_dgTwo").datagrid('getSelected');
    	if(rows.pro_type_s!="1"){
    		return;
    	}
    	var list_map={};
    	list_map.tyreCode=rows.TYRE_BARCODE_S;
    	$("#lh_qx").window('open');
    	$.ajax({
		 		url:'curing/report/qualitydegrade/wirteHx',
		 		type:"post",
		 		dataType:"json",
				contentType:'application/json',
		 		async:false,
		 		data:JSON.stringify(list_map),
		 		success:function(data){
		 			drawLineBasic2D(data);
		 		}
			 });
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
		debugger;
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

			var list_map=ichart[0].list;
			//var rows = $("#qualitydegradedetail_dg").datagrid('getSelected');

			/*var curing_closemoulddate_t =list_map.curingclosemouldtime_t;

			curing_closesub=curing_closemoulddate_t.substring(11);

		    var curing_openmoulddate_t =list_map.curingopenmouldtime_t;

		    curing_opensub=curing_openmoulddate_t.substring(11);*/


		/*var closedate = new Date(curing_closemoulddate_t);

		var min=closedate.getMinutes();
		var sec=closedate.getMinutes();

		closedate.setMinutes(min+6);

		var datas=[curing_closesub,closedate,curing_opensub];*/
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
</script>