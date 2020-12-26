<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    function showOrHide(){
        if($("#QuickCheck_search_form").is(":hidden")){
            $("#QuickCheck_search_form").show();
        }else{
            $("#QuickCheck_search_form").hide();
        }
    }
    var storageType=[];
    $.ajax({
			url:'dict/code/227',
			type : "get",
			dataType : "json",
			async:false,
			success : function(data){
				storageType=data;
			}
    });
    function storageTypeFormatter(v, r, i){
        for(var i=0;i<storageType.length;i++){
           if (v == storageType[i].code) {
               return storageType[i].text;
           }
         }
   };
   var qualityStatus=[];
   $.ajax({
			url:'dict/code/106',
			type : "get",
			dataType : "json",
			async:false,
			success : function(data){
				qualityStatus=data;
			}
   });
   function qualityStatusFormatter(v, r, i){
       for(var i=0;i<qualityStatus.length;i++){
          if (v == qualityStatus[i].code) {
              return qualityStatus[i].text;
          }
        }
  };
  
  
  var mlList=[];
  //加载门尼硫变机台信息
  $.ajax({
      url:"mix/baseData/rockWellFactoryModel/getMixProductionInfo?plantype="+"908907",
      type:"get",
      dataType:"json",
      async:false,
      success:function(data){
          mlList=data;
      }
  });
  function lbformatter(v,r,i){
      for( var i1=0;i1<mlList.length;i1++){
          if(r.EQUIP_SA_S==mlList[i1].p_line_name){
              return mlList[i1].description;
          }
      }
  }
  function mnformatter(v,r,i){
      for( var i1=0;i1<mlList.length;i1++){
          if(r.EQUIP_MI_S==mlList[i1].p_line_name){
              return mlList[i1].description;
          }
      }
  }
  
	  var classList=[];
	  $.ajax({
				url:'dict/code/302',
				type : "get",
				dataType : "json",
				async:false,
				success : function(data){
					classList=data;
				}
	  });
	  function classListFormatter(v, r, i){
	      for(var i=0;i<classList.length;i++){
	         if (v == classList[i].code) {
	             return classList[i].text;
	         }
	       }
	 };
	 var groupList=[];
	 $.ajax({
				url:'dict/code/301',
				type : "get",
				dataType : "json",
				async:false,
				success : function(data){
					groupList=data;
				}
	 });
	 function groupListFormatter(v, r, i){
	     for(var i=0;i<groupList.length;i++){
	        if (v == groupList[i].code) {
	            return groupList[i].text;
	        }
	      }
	};
  /**
   * 获取半部件用物料信息
   * 2019/08/26
   * 兰颖慧
   */
   var materialList=[];
   $.ajax({
       url:"sap/materials/getMaterialList",
       type:"get",
       dataType:"json",
       async:false,
       success:function(data){
       	materialList=data;
       }
       });
   var productLineList=[];
   $.ajax({
       url:"halfpart/basedata/productlinemanager/getHalfPartProductionLine",
       type:"get",
       dataType:"json",
       async:false,
       success:function(data){
       	productLineList=data;
       }
       });
	$(document).ready(function() {
		$('#start_time_t').datetimebox({
			value : '3/4/2010 00:00:00',
			required : false,
			showSeconds : true
		});
		$('#end_time_t').datetimebox({
			value : '3/4/2010 23:59:59',
			required : false,
			showSeconds : true
		});
	});
    /**
     * 查询方法
     */
    function filter(){
    	var startTime= $('#start_time_t').datebox("getValue");
	    var endTime= $('#end_time_t').datebox("getValue");
	    if((startTime!=""&&endTime=="")||(startTime==""&&endTime!="")){
	    	ext.tip.error("时间输入范围不完整");
	    	return;
	    }
    	var opts = $("#quickcheck_dg").datagrid("options");
        opts.url = 'common/quickcheck/filter';
    	ext.easyui.grid.search("quickcheck_dg","QuickCheck_search_form");
    }
    
    function doExport(){
    	var param=ext.form.getFormAsJson("QuickCheck_search_form");
    	var param_get="";
    	for(var k in param){
    		param_get=param_get+"&"+k.replace("filter[","").replace("]","")+"="+param[k];
    	}
    	window.open(path+"common/quickcheck/exportCSV?s_factory_s="+factory+param_get);
    }
    


	function codeFormatter(v, r, i) {
    		return dictFormat(v);
    }
	

    function cancel() {
        $("#quickcheck_dg").datagrid("rejectChanges");
    }
    
    
  //弹出ML曲线图
    function  ichartML(type){
    	var list_map={};
    	var starttime =$("#start_time_t").datetimebox("getValue");
        var endtime=$("#end_time_t").datetimebox("getValue");
        var materialname=$("#material_name_s").textbox("getValue");
        var typename=type;
       
		if(materialname==null||materialname=="")
			ext.tip.error("请指定物料名称");
		else{
			$("#ml_qx").window('open');
			 list_map.starttime=starttime;//开始时间
			 list_map.endtime=endtime;//结束时间
			 list_map.materialname=materialname;//物料名称
			 list_map.typename=typename;
			 $.ajax({
  		 		url:'common/quickcheck/kjqx',
  		 		type:"post",
  		 		dataType:"json",
  		 		data : JSON.stringify(list_map),
  				contentType:'application/json',
  		 		async:false,
  		 		success:function(data){
  		 			if(data!=null){
  		 				if(type=='ML'){
  		 					drawLineML(data);
  		 				}else if(type=='MH'){
  		 					drawLineMH(data);
  		 				}else if(type=='T30'){
  		 					drawLineTSL(data);
  		 				}else if(type=='T60'){
  		 					drawLineTLL(data);
  		 				}else if(type=='T25'){
  		 					drawLineTEW(data);
  		 				}else if(type=='ML(1+4)'){
  		 					drawLineND(data);
  		 				}else if(type=='T5'){
  		 					drawLineJS(data);
  		 				}else if(type=='硬度'){
  		 					drawLineYD(data);
  		 				}else if(type=='比重'){
  		 					drawLineBZ(data);
  		 				}
  		 				console.log(data);
  		 				
  		 			}else{
  		 				ext.tip.error("数据有误");
  		 			}
  		 			
  		 		}
			 });
		}
    }
  
  //获取BZ曲线
    function drawLineBZ(ichart){
    	var bz=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].bz!=null&&ichart[i].bz!=undefined){
				bz.push(ichart[i].bz);
			}
		}
		var valuemax=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].valuemaxs!=null&&ichart[i].valuemaxs!=undefined){
				valuemax.push(ichart[i].valuemaxs);
			}
		}
		
		var valuemin=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].valuemins!=null&&ichart[i].valuemins!=undefined){
				valuemin.push(ichart[i].valuemins);
			}
		}
		var valueavg=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].valueavg!=null&&ichart[i].valueavg!=undefined){
				valueavg.push(ichart[i].valueavg);
			}
		}
		var train_num=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].trainnums!=null&&ichart[i].trainnums!=undefined){
				train_num.push(ichart[i].trainnums);
			}
		}
		var data = [
		         	{
		         		name : '比重',
		         		value:bz,
		         		color:'#2ba5a4',
		         		line_width:1
		         	},
		         	{
		         		name : '最大值',
		         		value:valuemax,
		         		color:'#CDCD00',
		         		line_width:1
		         	},
		         	{
		         		name : '平均值',
		         		value:valueavg,
		         		color:'#1E90FF',
		         		line_width:1
		         	},
		         	{
		         		name : '最小值',
		         		value:valuemin,
		         		color:'#FF0000',
		         		line_width:1
		         	}

		         ];
		
        //绑定X坐标时间的值
		var labels=[]; 
		var maxMlV = Math.max.apply(null, bz);
		var maxMlV_st = Math.max.apply(null, valuemax);
		var minMlv= Math.min.apply(null, bz);
		var minMlv_st= Math.min.apply(null, valuemin);
		var maxV = maxMlV >maxMlV_st?maxMlV:maxMlV_st;
		var minV = minMlv < minMlv_st?minMlv:minMlv_st;
		var width = $(window).width() < 800 ? 800 : $(window).width();
		var height = $(window).height() < 500 ? 500 : $(window).height();
		for(var i=0;i<ichart.length;i++){
    		labels.push(ichart[i].trainnums);
		}
		var chart = new iChart.LineBasic2D({
			render : 'canvasDiv',
			data: data,
			align:'center',
			title : {
				text:'检验结果比重曲线图',
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
						var message = "<span style='color:#005268;font-size:12px;'>"+name+"值为:"+"</span><span style='color:#005268;font-size:16px;'>"+value;
						message+= "</span>";
						return message;
					}
				}
			},
			
			tipMocker:function(tips,i){//当有多条线段(数据)时，可以利用tipMocker将tip整合到一起。作为一个iChart.Tip展示出来。tipMocker是个很实用的配置。需要掌握。(默认为null)
				return "<div style='font-weight:600;color:#005268;'>"+labels[i]+"车检验结果比重曲线参数如下:</div>"+tips.join("<br/>");
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
				smooth : false,
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
					 start_scale:20,
					 end_scale:40,
					 scale_space:5,
					 scale_size:2,//刻度线的粗细
					 scale_enable : false,
					 scale2grid : true,//是否网格与刻度保持一致
					 label : {color:'#9d987a',font : '微软雅黑',fontsize:11,fontweight:600},
					 scale_color:'#9f9f9f',
					 listeners:{//配置事件
							parseText:function(t,x,y){//设置解析值轴文本
								return {text:t};
							}
					 }
				},
				{
					 position:'bottom',	
					 label : {color:'#9d987a',font : '微软雅黑',fontsize:11,fontweight:1000},
					 scale_enable : false,//是否显示刻度线
					 scale2grid : true,//是否网格与刻度保持一致
					 labels:labels
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
					.fillText('比重值',x-40,y-12,false,'#9d987a')
					.textBaseline('left')
					.fillText('时间',x+w,y+h,false,'#9d987a');
				}
		}));
	//开始画图
	chart.draw();
    }
  
  
  //获取YD曲线
    function drawLineYD(ichart){
    	var yd=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].yd!=null&&ichart[i].yd!=undefined){
				yd.push(ichart[i].yd);
			}
		}
		var valuemax=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].valuemaxs!=null&&ichart[i].valuemaxs!=undefined){
				valuemax.push(ichart[i].valuemaxs);
			}
		}
		
		var valuemin=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].valuemins!=null&&ichart[i].valuemins!=undefined){
				valuemin.push(ichart[i].valuemins);
			}
		}
		var valueavg=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].valueavg!=null&&ichart[i].valueavg!=undefined){
				valueavg.push(ichart[i].valueavg);
			}
		}
		var train_num=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].trainnums!=null&&ichart[i].trainnums!=undefined){
				train_num.push(ichart[i].trainnums);
			}
		}
		var data = [
		         	{
		         		name : '硬度',
		         		value:yd,
		         		color:'#2ba5a4',
		         		line_width:1
		         	},
		         	{
		         		name : '最大值',
		         		value:valuemax,
		         		color:'#CDCD00',
		         		line_width:1
		         	},
		         	{
		         		name : '平均值',
		         		value:valueavg,
		         		color:'#1E90FF',
		         		line_width:1
		         	},
		         	{
		         		name : '最小值',
		         		value:valuemin,
		         		color:'#FF0000',
		         		line_width:1
		         	}

		         ];
		
        //绑定X坐标时间的值
		var labels=[]; 
		var maxMlV = Math.max.apply(null, yd);
		var maxMlV_st = Math.max.apply(null, valuemax);
		var minMlv= Math.min.apply(null, yd);
		var minMlv_st= Math.min.apply(null, valuemin);
		var maxV = maxMlV >maxMlV_st?maxMlV:maxMlV_st;
		var minV = minMlv < minMlv_st?minMlv:minMlv_st;
		var width = $(window).width() < 800 ? 800 : $(window).width();
		var height = $(window).height() < 500 ? 500 : $(window).height();
		for(var i=0;i<ichart.length;i++){
    		labels.push(ichart[i].trainnums);
		}
		var chart = new iChart.LineBasic2D({
			render : 'canvasDiv',
			data: data,
			align:'center',
			title : {
				text:'检验结果硬度曲线图',
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
						var message = "<span style='color:#005268;font-size:12px;'>"+name+"值为:"+"</span><span style='color:#005268;font-size:16px;'>"+value;
						message+= "</span>";
						return message;
					}
				}
			},
			
			tipMocker:function(tips,i){//当有多条线段(数据)时，可以利用tipMocker将tip整合到一起。作为一个iChart.Tip展示出来。tipMocker是个很实用的配置。需要掌握。(默认为null)
				return "<div style='font-weight:600;color:#005268;'>"+labels[i]+"车检验结果硬度曲线参数如下:</div>"+tips.join("<br/>");
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
				smooth : false,
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
					 start_scale:minV*0.9,
					 end_scale:maxV*1.1,
					 scale_space:((maxV-minV)/10).toFixed(2),
					 scale_size:2,//刻度线的粗细
					 scale_enable : false,
					 scale2grid : true,//是否网格与刻度保持一致
					 label : {color:'#9d987a',font : '微软雅黑',fontsize:11,fontweight:600},
					 scale_color:'#9f9f9f',
					 listeners:{//配置事件
							parseText:function(t,x,y){//设置解析值轴文本
								return {text:t};
							}
					 }
				},
				{
					 position:'bottom',	
					 label : {color:'#9d987a',font : '微软雅黑',fontsize:11,fontweight:1000},
					 scale_enable : false,//是否显示刻度线
					 scale2grid : true,//是否网格与刻度保持一致
					 labels:labels
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
					.fillText('硬度值',x-40,y-12,false,'#9d987a')
					.textBaseline('left')
					.fillText('时间',x+w,y+h,false,'#9d987a');
				}
		}));
	//开始画图
	chart.draw();
    }
  
  
  //获取JS曲线
    function drawLineJS(ichart){
    	var js=[];
		for(var i=0;i<ichart.length;i++){
				if(ichart[i].js!=undefined){
					js.push(ichart[i].js);
				}else{
					js.push(ichart[i].valueavg);
				}
				
			}
		var valuemax=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].valuemaxs!=null&&ichart[i].valuemaxs!=undefined){
				valuemax.push(ichart[i].valuemaxs);
			}
		}
		
		var valuemin=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].valuemins!=null&&ichart[i].valuemins!=undefined){
				valuemin.push(ichart[i].valuemins);
			}
		}
		var valueavg=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].valueavg!=null&&ichart[i].valueavg!=undefined){
				valueavg.push(ichart[i].valueavg);
			}
		}
		var train_num=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].trainnums!=null&&ichart[i].trainnums!=undefined){
				train_num.push(ichart[i].trainnums);
			}
		}
		var data = [
		         	{
		         		name : '焦烧',
		         		value:js,
		         		color:'#2ba5a4',
		         		line_width:1
		         	},
		         	{
		         		name : '最大值',
		         		value:valuemax,
		         		color:'#CDCD00',
		         		line_width:1
		         	},
		         	{
		         		name : '平均值',
		         		value:valueavg,
		         		color:'#1E90FF',
		         		line_width:1
		         	},
		         	{
		         		name : '最小值',
		         		value:valuemin,
		         		color:'#FF0000',
		         		line_width:1
		         	}

		         ];
		
        //绑定X坐标时间的值
		var labels=[]; 
		var maxMlV = Math.max.apply(null, js);
		var maxMlV_st = Math.max.apply(null, valuemax);
		var minMlv= Math.min.apply(null, js);
		var minMlv_st= Math.min.apply(null, valuemin);
		var maxV = maxMlV >maxMlV_st?maxMlV:maxMlV_st;
		var minV = minMlv < minMlv_st?minMlv:minMlv_st;
		var width = $(window).width() < 800 ? 800 : $(window).width();
		var height = $(window).height() < 500 ? 500 : $(window).height();
		for(var i=0;i<ichart.length;i++){
    		labels.push(ichart[i].trainnums);
		}
		var chart = new iChart.LineBasic2D({
			render : 'canvasDiv',
			data: data,
			align:'center',
			title : {
				text:'检验结果焦烧曲线图',
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
						var message = "<span style='color:#005268;font-size:12px;'>"+name+"值为:"+"</span><span style='color:#005268;font-size:16px;'>"+value;
						message+= "</span>";
						return message;
					}
				}
			},
			
			tipMocker:function(tips,i){//当有多条线段(数据)时，可以利用tipMocker将tip整合到一起。作为一个iChart.Tip展示出来。tipMocker是个很实用的配置。需要掌握。(默认为null)
				return "<div style='font-weight:600;color:#005268;'>"+labels[i]+"车检验结果焦烧曲线参数如下:</div>"+tips.join("<br/>");
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
				smooth : false,
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
					 start_scale:minV*0.9,
					 end_scale:maxV*1.1,
					 scale_space:((maxV-minV)/10).toFixed(2),
					 scale_size:2,//刻度线的粗细
					 scale_enable : false,
					 scale2grid : true,//是否网格与刻度保持一致
					 label : {color:'#9d987a',font : '微软雅黑',fontsize:11,fontweight:600},
					 scale_color:'#9f9f9f',
					 listeners:{//配置事件
							parseText:function(t,x,y){//设置解析值轴文本
								return {text:t};
							}
					 }
				},
				{
					 position:'bottom',	
					 label : {color:'#9d987a',font : '微软雅黑',fontsize:11,fontweight:1000},
					 scale_enable : false,//是否显示刻度线
					 scale2grid : true,//是否网格与刻度保持一致
					 labels:labels
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
					.fillText('焦烧值',x-40,y-12,false,'#9d987a')
					.textBaseline('left')
					.fillText('时间',x+w,y+h,false,'#9d987a');
				}
		}));
	//开始画图
	chart.draw();
    }
  
  
  //获取ND曲线
    function drawLineND(ichart){
    	var nd=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].nd!=null&&ichart[i].nd!=undefined){
				nd.push(ichart[i].nd);
			}
		}
		var valuemax=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].valuemaxs!=null&&ichart[i].valuemaxs!=undefined){
				valuemax.push(ichart[i].valuemaxs);
			}
		}
		
		var valuemin=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].valuemins!=null&&ichart[i].valuemins!=undefined){
				valuemin.push(ichart[i].valuemins);
			}
		}
		var valueavg=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].valueavg!=null&&ichart[i].valueavg!=undefined){
				valueavg.push(ichart[i].valueavg);
			}
		}
		var train_num=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].trainnums!=null&&ichart[i].trainnums!=undefined){
				train_num.push(ichart[i].trainnums);
			}
		}
		var data = [
		         	{
		         		name : '粘度',
		         		value:nd,
		         		color:'#2ba5a4',
		         		line_width:1
		         	},
		         	{
		         		name : '最大值',
		         		value:valuemax,
		         		color:'#CDCD00',
		         		line_width:1
		         	},
		         	{
		         		name : '平均值',
		         		value:valueavg,
		         		color:'#1E90FF',
		         		line_width:1
		         	},
		         	{
		         		name : '最小值',
		         		value:valuemin,
		         		color:'#FF0000',
		         		line_width:1
		         	}

		         ];
		
        //绑定X坐标时间的值
		var labels=[]; 
		var maxMlV = Math.max.apply(null, nd);
		var maxMlV_st = Math.max.apply(null, valuemax);
		var minMlv= Math.min.apply(null, nd);
		var minMlv_st= Math.min.apply(null, valuemin);
		var maxV = maxMlV >maxMlV_st?maxMlV:maxMlV_st;
		var minV = minMlv < minMlv_st?minMlv:minMlv_st;
		var width = $(window).width() < 800 ? 800 : $(window).width();
		var height = $(window).height() < 500 ? 500 : $(window).height();
		for(var i=0;i<ichart.length;i++){
    		labels.push(ichart[i].trainnums);
		}
		var chart = new iChart.LineBasic2D({
			render : 'canvasDiv',
			data: data,
			align:'center',
			title : {
				text:'检验结果粘度曲线图',
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
						var message = "<span style='color:#005268;font-size:12px;'>"+name+"值为:"+"</span><span style='color:#005268;font-size:16px;'>"+value;
						message+= "</span>";
						return message;
					}
				}
			},
			
			tipMocker:function(tips,i){//当有多条线段(数据)时，可以利用tipMocker将tip整合到一起。作为一个iChart.Tip展示出来。tipMocker是个很实用的配置。需要掌握。(默认为null)
				return "<div style='font-weight:600;color:#005268;'>"+labels[i]+"车检验结果粘度曲线参数如下:</div>"+tips.join("<br/>");
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
				smooth : false,
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
					 start_scale:minV*0.9,
					 end_scale:maxV*1.1,
					 scale_space:((maxV-minV)/10).toFixed(2),
					 scale_size:2,//刻度线的粗细
					 scale_enable : false,
					 scale2grid : true,//是否网格与刻度保持一致
					 label : {color:'#9d987a',font : '微软雅黑',fontsize:11,fontweight:600},
					 scale_color:'#9f9f9f',
					 listeners:{//配置事件
							parseText:function(t,x,y){//设置解析值轴文本
								return {text:t};
							}
					 }
				},
				{
					 position:'bottom',	
					 label : {color:'#9d987a',font : '微软雅黑',fontsize:11,fontweight:1000},
					 scale_enable : false,//是否显示刻度线
					 scale2grid : true,//是否网格与刻度保持一致
					 labels:labels
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
					.fillText('粘度值',x-40,y-12,false,'#9d987a')
					.textBaseline('left')
					.fillText('时间',x+w,y+h,false,'#9d987a');
				}
		}));
	//开始画图
	chart.draw();
    }
  
  
  
  
    
  
  
  //获取T25曲线
    function drawLineTEW(ichart){
    	var t25=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].t25!=null&&ichart[i].t25!=undefined){
				t25.push(ichart[i].t25);
			}
		}
		var valuemax=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].valuemaxs!=null&&ichart[i].valuemaxs!=undefined){
				valuemax.push(ichart[i].valuemaxs);
			}
		}
		
		var valuemin=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].valuemins!=null&&ichart[i].valuemins!=undefined){
				valuemin.push(ichart[i].valuemins);
			}
		}
		var valueavg=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].valueavg!=null&&ichart[i].valueavg!=undefined){
				valueavg.push(ichart[i].valueavg);
			}
		}
		var train_num=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].trainnums!=null&&ichart[i].trainnums!=undefined){
				train_num.push(ichart[i].trainnums);
			}
		}
		var data = [
		         	{
		         		name : 'T25',
		         		value:t25,
		         		color:'#2ba5a4',
		         		line_width:1
		         	},
		         	{
		         		name : '最大值',
		         		value:valuemax,
		         		color:'#CDCD00',
		         		line_width:1
		         	},
		         	{
		         		name : '平均值',
		         		value:valueavg,
		         		color:'#1E90FF',
		         		line_width:1
		         	},
		         	{
		         		name : '最小值',
		         		value:valuemin,
		         		color:'#FF0000',
		         		line_width:1
		         	}

		         ];
		
        //绑定X坐标时间的值
		var labels=[]; 
		var maxMlV = Math.max.apply(null, t25);
		var maxMlV_st = Math.max.apply(null, valuemax);
		var minMlv= Math.min.apply(null, t25);
		var minMlv_st= Math.min.apply(null, valuemin);
		var maxV = maxMlV >maxMlV_st?maxMlV:maxMlV_st;
		var minV = minMlv < minMlv_st?minMlv:minMlv_st;
		var width = $(window).width() < 800 ? 800 : $(window).width();
		var height = $(window).height() < 500 ? 500 : $(window).height();
		for(var i=0;i<ichart.length;i++){
    		labels.push(ichart[i].trainnums);
		}
		var chart = new iChart.LineBasic2D({
			render : 'canvasDiv',
			data: data,
			align:'center',
			title : {
				text:'检验结果T25曲线图',
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
						var message = "<span style='color:#005268;font-size:12px;'>"+name+"值为:"+"</span><span style='color:#005268;font-size:16px;'>"+value;
						message+= "</span>";
						return message;
					}
				}
			},
			
			tipMocker:function(tips,i){//当有多条线段(数据)时，可以利用tipMocker将tip整合到一起。作为一个iChart.Tip展示出来。tipMocker是个很实用的配置。需要掌握。(默认为null)
				return "<div style='font-weight:600;color:#005268;'>"+labels[i]+"车检验结果T25曲线参数如下:</div>"+tips.join("<br/>");
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
				smooth : false,
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
					 start_scale:minV*0.9,
					 end_scale:maxV*1.1,
					 scale_space:((maxV-minV)/10).toFixed(2),
					 scale_size:2,//刻度线的粗细
					 scale_enable : false,
					 scale2grid : true,//是否网格与刻度保持一致
					 label : {color:'#9d987a',font : '微软雅黑',fontsize:11,fontweight:600},
					 scale_color:'#9f9f9f',
					 listeners:{//配置事件
							parseText:function(t,x,y){//设置解析值轴文本
								return {text:t};
							}
					 }
				},
				{
					 position:'bottom',	
					 label : {color:'#9d987a',font : '微软雅黑',fontsize:11,fontweight:1000},
					 scale_enable : false,//是否显示刻度线
					 scale2grid : true,//是否网格与刻度保持一致
					 labels:labels
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
					.fillText('T25值',x-40,y-12,false,'#9d987a')
					.textBaseline('left')
					.fillText('时间',x+w,y+h,false,'#9d987a');
				}
		}));
	//开始画图
	chart.draw();
    }
  
  
    //获取T60曲线
    function drawLineTLL(ichart){
    	var t60=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].t60!=null&&ichart[i].t60!=undefined){
				t60.push(ichart[i].t60);
			}
		}
		var valuemax=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].valuemaxs!=null&&ichart[i].valuemaxs!=undefined){
				valuemax.push(ichart[i].valuemaxs);
			}
		}
		
		var valuemin=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].valuemins!=null&&ichart[i].valuemins!=undefined){
				valuemin.push(ichart[i].valuemins);
			}
		}
		var valueavg=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].valueavg!=null&&ichart[i].valueavg!=undefined){
				valueavg.push(ichart[i].valueavg);
			}
		}
		var train_num=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].trainnums!=null&&ichart[i].trainnums!=undefined){
				train_num.push(ichart[i].trainnums);
			}
		}
		var data = [
		         	{
		         		name : 'T60',
		         		value:t60,
		         		color:'#2ba5a4',
		         		line_width:1
		         	},
		         	{
		         		name : '最大值',
		         		value:valuemax,
		         		color:'#CDCD00',
		         		line_width:1
		         	},
		         	{
		         		name : '平均值',
		         		value:valueavg,
		         		color:'#1E90FF',
		         		line_width:1
		         	},
		         	{
		         		name : '最小值',
		         		value:valuemin,
		         		color:'#FF0000',
		         		line_width:1
		         	}

		         ];
		
        //绑定X坐标时间的值
		var labels=[]; 
		var maxMlV = Math.max.apply(null, t60);
		var maxMlV_st = Math.max.apply(null, valuemax);
		var minMlv= Math.min.apply(null, t60);
		var minMlv_st= Math.min.apply(null, valuemin);
		var maxV = maxMlV >maxMlV_st?maxMlV:maxMlV_st;
		var minV = minMlv < minMlv_st?minMlv:minMlv_st;
		var width = $(window).width() < 800 ? 800 : $(window).width();
		var height = $(window).height() < 500 ? 500 : $(window).height();
		for(var i=0;i<ichart.length;i++){
    		labels.push(ichart[i].trainnums);
		}
		var chart = new iChart.LineBasic2D({
			render : 'canvasDiv',
			data: data,
			align:'center',
			title : {
				text:'检验结果T60曲线图',
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
						var message = "<span style='color:#005268;font-size:12px;'>"+name+"值为:"+"</span><span style='color:#005268;font-size:16px;'>"+value;
						message+= "</span>";
						return message;
					}
				}
			},
			
			tipMocker:function(tips,i){//当有多条线段(数据)时，可以利用tipMocker将tip整合到一起。作为一个iChart.Tip展示出来。tipMocker是个很实用的配置。需要掌握。(默认为null)
				return "<div style='font-weight:600;color:#005268;'>"+labels[i]+"车检验结果T60曲线参数如下:</div>"+tips.join("<br/>");
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
				smooth : false,
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
					 start_scale:minV*0.9,
					 end_scale:maxV*1.1,
					 scale_space:((maxV-minV)/10).toFixed(2),
					 scale_size:2,//刻度线的粗细
					 scale_enable : false,
					 scale2grid : true,//是否网格与刻度保持一致
					 label : {color:'#9d987a',font : '微软雅黑',fontsize:11,fontweight:600},
					 scale_color:'#9f9f9f',
					 listeners:{//配置事件
							parseText:function(t,x,y){//设置解析值轴文本
								return {text:t};
							}
					 }
				},
				{
					 position:'bottom',	
					 label : {color:'#9d987a',font : '微软雅黑',fontsize:11,fontweight:1000},
					 scale_enable : false,//是否显示刻度线
					 scale2grid : true,//是否网格与刻度保持一致
					 labels:labels
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
					.fillText('T60值',x-40,y-12,false,'#9d987a')
					.textBaseline('left')
					.fillText('时间',x+w,y+h,false,'#9d987a');
				}
		}));
	//开始画图
	chart.draw();
    }
  
    //获取T30曲线
    function drawLineTSL(ichart){
    	var t30=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].t30!=null&&ichart[i].t30!=undefined){
				t30.push(ichart[i].t30);
			}
		}
		var valuemax=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].valuemaxs!=null&&ichart[i].valuemaxs!=undefined){
				valuemax.push(ichart[i].valuemaxs);
			}
		}
		
		var valuemin=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].valuemins!=null&&ichart[i].valuemins!=undefined){
				valuemin.push(ichart[i].valuemins);
			}
		}
		var valueavg=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].valueavg!=null&&ichart[i].valueavg!=undefined){
				valueavg.push(ichart[i].valueavg);
			}
		}
		var train_num=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].trainnums!=null&&ichart[i].trainnums!=undefined){
				train_num.push(ichart[i].trainnums);
			}
		}
		var data = [
		         	{
		         		name : 'T30',
		         		value:t30,
		         		color:'#2ba5a4',
		         		line_width:1
		         	},
		         	{
		         		name : '最大值',
		         		value:valuemax,
		         		color:'#CDCD00',
		         		line_width:1
		         	},
		         	{
		         		name : '平均值',
		         		value:valueavg,
		         		color:'#1E90FF',
		         		line_width:1
		         	},
		         	{
		         		name : '最小值',
		         		value:valuemin,
		         		color:'#FF0000',
		         		line_width:1
		         	}

		         ];
		
        //绑定X坐标时间的值
		var labels=[]; 
		var maxMlV = Math.max.apply(null, t30);
		var maxMlV_st = Math.max.apply(null, valuemax);
		var minMlv= Math.min.apply(null, t30);
		var minMlv_st= Math.min.apply(null, valuemin);
		var maxV = maxMlV >maxMlV_st?maxMlV:maxMlV_st;
		var minV = minMlv < minMlv_st?minMlv:minMlv_st;
		var width = $(window).width() < 800 ? 800 : $(window).width();
		var height = $(window).height() < 500 ? 500 : $(window).height();
		for(var i=0;i<ichart.length;i++){
    		labels.push(ichart[i].trainnums);
		}
    	//var labelsq = ["00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24"];
		var chart = new iChart.LineBasic2D({
			render : 'canvasDiv',
			data: data,
			align:'center',
			title : {
				text:'检验结果T30曲线图',
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
						var message = "<span style='color:#005268;font-size:12px;'>"+name+"值为:"+"</span><span style='color:#005268;font-size:16px;'>"+value;
						message+= "</span>";
						return message;
					}
				}
			},
			
			tipMocker:function(tips,i){//当有多条线段(数据)时，可以利用tipMocker将tip整合到一起。作为一个iChart.Tip展示出来。tipMocker是个很实用的配置。需要掌握。(默认为null)
				return "<div style='font-weight:600;color:#005268;'>"+labels[i]+"车检验结果T30曲线参数如下:</div>"+tips.join("<br/>");
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
				smooth : false,
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
					 start_scale:minV*0.9,
					 end_scale:maxV*1.1,
					 scale_space:((maxV-minV)/10).toFixed(2),
					 scale_size:2,//刻度线的粗细
					 scale_enable : false,
					 scale2grid : true,//是否网格与刻度保持一致
					 label : {color:'#9d987a',font : '微软雅黑',fontsize:11,fontweight:600},
					 scale_color:'#9f9f9f',
					 listeners:{//配置事件
							parseText:function(t,x,y){//设置解析值轴文本
								return {text:t};
							}
					 }
				},
				{
					 position:'bottom',	
					 label : {color:'#9d987a',font : '微软雅黑',fontsize:11,fontweight:1000},
					 scale_enable : false,//是否显示刻度线
					 scale2grid : true,//是否网格与刻度保持一致
					 labels:labels
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
					.fillText('T30值',x-40,y-12,false,'#9d987a')
					.textBaseline('left')
					.fillText('时间',x+w,y+h,false,'#9d987a');
				}
		}));
	//开始画图
	chart.draw();
    }
    
    //获取MH曲线
    function drawLineMH(ichart){
    	var mh=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].mh!=null&&ichart[i].mh!=undefined){
				mh.push(ichart[i].mh);
			}
		}
		console.log(ichart.length);
		var valuemax=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].valuemaxs!=null&&ichart[i].valuemaxs!=undefined){
				valuemax.push(ichart[i].valuemaxs);
			}
		}
		
		var valuemin=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].valuemins!=null&&ichart[i].valuemins!=undefined){
				valuemin.push(ichart[i].valuemins);
			}
		}
		var valueavg=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].valueavg!=null&&ichart[i].valueavg!=undefined){
				valueavg.push(ichart[i].valueavg);
			}
		}
		var train_num=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].trainnums!=null&&ichart[i].trainnums!=undefined){
				train_num.push(ichart[i].trainnums);
			}
		}
		var data = [
		         	{
		         		name : 'MH',
		         		value:mh,
		         		color:'#2ba5a4',
		         		line_width:1
		         	},
		         	{
		         		name : '最大值',
		         		value:valuemax,
		         		color:'#CDCD00',
		         		line_width:1
		         	},
		         	{
		         		name : '平均值',
		         		value:valueavg,
		         		color:'#1E90FF',
		         		line_width:1
		         	},
		         	{
		         		name : '最小值',
		         		value:valuemin,
		         		color:'#FF0000',
		         		line_width:1
		         	}

		         ];
		
        //绑定X坐标时间的值
		var labels=[]; 
		var maxMlV = Math.max.apply(null, mh);
		var maxMlV_st = Math.max.apply(null, valuemax);
		var minMlv= Math.min.apply(null, mh);
		var minMlv_st= Math.min.apply(null, valuemin);
		var maxV = maxMlV >maxMlV_st?maxMlV:maxMlV_st;
		var minV = minMlv < minMlv_st?minMlv:minMlv_st;
		var width = $(window).width() < 800 ? 800 : $(window).width();
		var height = $(window).height() < 500 ? 500 : $(window).height();
		for(var i=0;i<ichart.length;i++){
    		labels.push(ichart[i].trainnums);
		}
    	//var labelsq = ["00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24"];
		var chart = new iChart.LineBasic2D({
			render : 'canvasDiv',
			data: data,
			align:'center',
			title : {
				text:'检验结果MH曲线图',
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
						var message = "<span style='color:#005268;font-size:12px;'>"+name+"值为:"+"</span><span style='color:#005268;font-size:16px;'>"+value;
						message+= "</span>";
						return message;
					}
				}
			},
			
			tipMocker:function(tips,i){//当有多条线段(数据)时，可以利用tipMocker将tip整合到一起。作为一个iChart.Tip展示出来。tipMocker是个很实用的配置。需要掌握。(默认为null)
				return "<div style='font-weight:600;color:#005268;'>"+labels[i]+"车检验结果MH曲线参数如下:</div>"+tips.join("<br/>");
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
				smooth : false,
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
					 start_scale:minV*0.9,
					 end_scale:maxV*1.1,
					 scale_space:((maxV-minV)/10).toFixed(2),
					 scale_size:2,//刻度线的粗细
					 scale_enable : false,
					 scale2grid : true,//是否网格与刻度保持一致
					 label : {color:'#9d987a',font : '微软雅黑',fontsize:11,fontweight:600},
					 scale_color:'#9f9f9f',
					 listeners:{//配置事件
							parseText:function(t,x,y){//设置解析值轴文本
								return {text:t};
							}
					 }
				},
				{
					 position:'bottom',	
					 label : {color:'#9d987a',font : '微软雅黑',fontsize:11,fontweight:1000},
					 scale_enable : false,//是否显示刻度线
					 scale2grid : true,//是否网格与刻度保持一致
					 labels:labels
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
					.fillText('MH值',x-40,y-12,false,'#9d987a')
					.textBaseline('left')
					.fillText('时间',x+w,y+h,false,'#9d987a');
				}
		}));
	//开始画图
	chart.draw();
    }
  
  
    //获取ML曲线
    function drawLineML(ichart){
    	var ml=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].ml!=null&&ichart[i].ml!=undefined){
				ml.push(ichart[i].ml);
			}
		}
		var valuemax=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].valuemaxs!=null&&ichart[i].valuemaxs!=undefined){
				valuemax.push(ichart[i].valuemaxs);
			}
		}
		
		var valuemin=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].valuemins!=null&&ichart[i].valuemins!=undefined){
				valuemin.push(ichart[i].valuemins);
			}
		}
		var valueavg=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].valueavg!=null&&ichart[i].valueavg!=undefined){
				valueavg.push(ichart[i].valueavg);
			}
		}
		var train_num=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].trainnums!=null&&ichart[i].trainnums!=undefined){
				train_num.push(ichart[i].trainnums);
			}
		}
		var data = [
		         	{
		         		name : 'ML',
		         		value:ml,
		         		color:'#2ba5a4',
		         		line_width:1
		         	},
		         	{
		         		name : '最大值',
		         		value:valuemax,
		         		color:'#CDCD00',
		         		line_width:1
		         	},
		         	{
		         		name : '平均值',
		         		value:valueavg,
		         		color:'#1E90FF',
		         		line_width:1
		         	},
		         	{
		         		name : '最小值',
		         		value:valuemin,
		         		color:'#FF0000',
		         		line_width:1
		         	}

		         ];
		
        //绑定X坐标时间的值
		var labels=[]; 
		var maxMlV = Math.max.apply(null, ml);
		var maxMlV_st = Math.max.apply(null, valuemax);
		var minMlv= Math.min.apply(null, ml);
		var minMlv_st= Math.min.apply(null, valuemin);
		var maxV = maxMlV >maxMlV_st?maxMlV:maxMlV_st;
		var minV = minMlv < minMlv_st?minMlv:minMlv_st;
		
		var width = $(window).width() < 800 ? 800 : $(window).width();
		var height = $(window).height() < 500 ? 500 : $(window).height();
    	for(var i=0;i<ichart.length;i++){
    		labels.push(ichart[i].trainnums);
		}
		var chart = new iChart.LineBasic2D({
			render : 'canvasDiv',
			data: data,
			align:'center',
			title : {
				text:'检验结果ML曲线图',
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
						var message = "<span style='color:#005268;font-size:12px;'>"+name+"值为:"+"</span><span style='color:#005268;font-size:16px;'>"+value;
						message+= "</span>";
						return message;
					}
				}
			},
			
			tipMocker:function(tips,i){//当有多条线段(数据)时，可以利用tipMocker将tip整合到一起。作为一个iChart.Tip展示出来。tipMocker是个很实用的配置。需要掌握。(默认为null)
				return "<div style='font-weight:600;color:#005268;'>"+labels[i]+"车检验结果ML曲线参数如下:</div>"+tips.join("<br/>");
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
				smooth : false,
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
					 start_scale:minV*0.9,
					 end_scale:maxV*1.1,
					 scale_space:((maxV-minV)/10).toFixed(2),
					 scale_size:2,//刻度线的粗细
					 scale_enable : false,
					 scale2grid : true,//是否网格与刻度保持一致
					 label : {color:'#9d987a',font : '微软雅黑',fontsize:11,fontweight:600},
					 scale_color:'#9f9f9f',
					 listeners:{//配置事件
							parseText:function(t,x,y){//设置解析值轴文本
								return {text:t};
							}
					 }
				},
				{
					 position:'bottom',	
					 label : {color:'#9d987a',font : '微软雅黑',fontsize:11,fontweight:1000},
					 scale_enable : false,//是否显示刻度线
					 scale2grid : true,//是否网格与刻度保持一致
					 labels:labels
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
					.fillText('ML值',x-40,y-12,false,'#9d987a')
					.textBaseline('left')
					.fillText('车次号',x+w,y+h,false,'#9d987a');
				}
		}));
	//开始画图
	chart.draw();
    }
</script>