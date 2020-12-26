<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"mix/qualityManagement/quickCheckMain/saveChanges";
    
    function showOrHide(){
        if($("#QuickCheckMain_search_form").is(":hidden")){
            $("#QuickCheckMain_search_form").show();
        }else{
            $("#QuickCheckMain_search_form").hide();
        }
    }
    
    //弹出ML曲线图
    function  ichartML(type){
    	var ids = [];
    	var rows = $('#quickcheckmain_dg').datagrid('getSelections');//获取选中所有行的数据
    	if(rows.length<=0){
    		ext.tip.error("请最少选择一行数据");
    	}
		else{
			for(var i=0; i<rows.length; i++){
	    	    ids.push(rows[i].sampleno_s);
	    	}
			$("#lh_qx").window('open');
			 $.ajax({
  		 		url:'mix/QuickCheckMain/kjqx?type='+type,
  		 		type:"post",
  		 		dataType:"json",
  		 		data : JSON.stringify(ids),
  				contentType:'application/json',
  		 		async:false,
  		 		success:function(data){
  		 			if(data!=null){
  		 				if(type=='LBWD'){
  		 					drawLineBasiclbwd2D(data);
  		 				}else if(type=='LBNJ'){
  		 					drawLineBasiclbnj2D(data);
  		 				}else if(type=='MNWD'){
  		 					drawLineBasicmnwd2D(data);
  		 				}else if(type=='MNNJ'){
  		 					drawLineBasicmnnj2D(data);
  		 				}
  		 			}else{
  		 				ext.tip.error("数据有误");
  		 			}
  		 			
  		 		}
			 });
		}
    }
    
  //随机生成十六进制颜色
    function randomHexColor() {
    	 return '#' + ('00000' + (Math.random() * 0x1000000 << 0).toString(16)).substr(-6);
    	}
    
    function drawLineBasiclbwd2D(ichart){
    	var syh=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].syh!=null&&ichart[i].syh!=undefined){
				syh.push(ichart[i].syh);
			}
		}
		var smwd=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].smwd!=null&&ichart[i].smwd!=undefined){
				smwd.push(ichart[i].smwd);
			}
		}
		var xmwd=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].xmwd!=null&&ichart[i].xmwd!=undefined){
				xmwd.push(ichart[i].xmwd);
			}
		}
		var ds=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].ds!=null&&ichart[i].ds!=undefined){
				if(i%20==0){
				ds.push(ichart[i].ds);
				}
			}
		}
		var data = [
		         	{
		         		name : '上模温度',
		         		value:smwd,
		         		color:'#c12c44',
		         		line_width:2
		         	},
		         	{
		         		name : '下模温度',
		         		value:xmwd,
		         		color:'#2ba5a4',
		         		line_width:2
		         	}
		         ];
        //绑定X坐标时间的值
       var labels=[]; 
        
		var smwdmax = Math.max.apply(null, smwd);
		var xmwdmax= Math.max.apply(null, xmwd);
		var maxMIV=[smwdmax,xmwdmax];
		
		var smwdmin = Math.min.apply(null, smwd);
		var xmwdmin= Math.min.apply(null, xmwd);
		var minMIV=[smwdmin,xmwdmin];
		
		var max=Math.max.apply(null, maxMIV);//取上模与下模温度的最大值
		var min=Math.min.apply(null,minMIV);//取上模与下模温度的最小值
		
		
		
		var width = $(window).width() < 800 ? 800 : $(window).width();
		var height = $(window).height() < 500 ? 500 : $(window).height();
    	for(var i=0;i<ichart.length;i++){
    		labels.push(ichart[i].ds);
		}
    	
		var chart = new iChart.LineBasic2D({
			render : 'canvasDiv',
			data: data,
			align:'center',
			title : {
				text:'快检流变实时温度',
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
				return "<div style='font-weight:600;color:#005268;'>"+labels[i]+"快检流变实时温度曲线参数如下:</div>"+tips.join("<br/>");
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
					 start_scale:max*0.9,
					 end_scale:min*1.1,
					 scale_space:((max-min)/2).toFixed(2),
					 scale_size:2,//刻度线的粗细
					 scale_enable : false,
					 label : {color:'#9d987a',font : '微软雅黑',fontsize:11,fontweight:600},
					 scale_color:'#9f9f9f',
					 listeners:{//配置事件
							parseText:function(t,x,y){//设置解析值轴文本
								return {text:t+'℃'}
							}
					 }
				},
				{
					 position:'bottom',	
					 label : {color:'#9d987a',font : '微软雅黑',fontsize:11,fontweight:600},
					 scale_space:2,
					 scale_enable : true,//是否显示刻度线
					 scale2grid : true,//是否网格与刻度保持一致
					 labels:ds
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
					.fillText('温度',x-40,y-12,false,'#9d987a');
						
					
				}
		}));
	//开始画图
	chart.draw();
    }
    
    
    function drawLineBasicmnwd2D(ichart){
    	console.log(ichart);
    	var syh=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].syh!=null&&ichart[i].syh!=undefined){
				syh.push(ichart[i].syh);
			}
		}
		var smwd=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].smwd!=null&&ichart[i].smwd!=undefined){
				smwd.push(ichart[i].smwd);
			}
		}
		var xmwd=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].xmwd!=null&&ichart[i].xmwd!=undefined){
				xmwd.push(ichart[i].xmwd);
			}
		}
		var ds=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].ds!=null&&ichart[i].ds!=undefined){
				if(i%20==0){
				ds.push(ichart[i].ds);
				}
			}
		}
		var data = [
		         	{
		         		name : '上模温度',
		         		value:smwd,
		         		color:'#c12c44',
		         		line_width:2
		         	},
		         	{
		         		name : '下模温度',
		         		value:xmwd,
		         		color:'#2ba5a4',
		         		line_width:2
		         	}
		         ];
		
        //绑定X坐标时间的值
		var labels=[]; 
		var smwdmax = Math.max.apply(null, smwd);
		var xmwdmax= Math.max.apply(null, xmwd);
		var maxMIV=[smwdmax,xmwdmax];
		
		var smwdmin = Math.min.apply(null, smwd);
		var xmwdmin= Math.min.apply(null, xmwd);
		var minMIV=[smwdmin,xmwdmin];
		
		var max=Math.max.apply(null, maxMIV);//取上模与下模温度的最大值
		var min=Math.min.apply(null,minMIV);//取上模与下模温度的最小值
		var width = $(window).width() < 800 ? 800 : $(window).width();
		var height = $(window).height() < 500 ? 500 : $(window).height();
    	for(var i=0;i<ichart.length;i++){
    		labels.push(ichart[i].ds);
		}
    	
		var chart = new iChart.LineBasic2D({
			render : 'canvasDiv',
			data: data,
			align:'center',
			title : {
				text:'快检门尼实时温度',
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
				return "<div style='font-weight:600;color:#005268;'>"+labels[i]+"门尼快检实时温度曲线参数如下:</div>"+tips.join("<br/>");
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
					 start_scale:max*0.9,
					 end_scale:min*1.1,
					 scale_space:((max-min)/2).toFixed(2),
					 scale_size:2,//刻度线的粗细
					 scale_enable : false,
					 label : {color:'#9d987a',font : '微软雅黑',fontsize:11,fontweight:600},
					 scale_color:'#9f9f9f',
					 listeners:{//配置事件
							parseText:function(t,x,y){//设置解析值轴文本
								return {text:t+'℃'}
							}
					 }
				},
				{
					 position:'bottom',	
					 label : {color:'#9d987a',font : '微软雅黑',fontsize:11,fontweight:600},
					 scale_space:2,
					 scale_enable : true,//是否显示刻度线
					 scale2grid : true,//是否网格与刻度保持一致
					 labels:ds
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
					.fillText('温度',x-40,y-12,false,'#9d987a');
						
					
				}
		}));
	//开始画图
	chart.draw();
    }
    
    function drawLineBasiclbnj2D(ichart){
    	console.log(ichart);
    	var syh=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].syh!=null&&ichart[i].syh!=undefined){
				syh.push(ichart[i].syh);
			}
		}
		var nj=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].nj!=null&&ichart[i].nj!=undefined){
				nj.push(ichart[i].nj);
			}
		}
		var ds=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].ds!=null&&ichart[i].ds!=undefined){
				if(i%20==0){
				ds.push(ichart[i].ds);
				}
			}
		}
		var data = [
		         	{
		         		name : '扭矩',
		         		value:nj,
		         		color:'#c12c44',
		         		line_width:2
		         	}
		         ];
		
        //绑定X坐标时间的值
		var labels=[]; 
		var max=Math.max.apply(null, nj);//取上模与下模温度的最大值
		var min=Math.min.apply(null,nj);//取上模与下模温度的最小值
		var width = $(window).width() < 800 ? 800 : $(window).width();
		var height = $(window).height() < 500 ? 500 : $(window).height();
    	for(var i=0;i<ichart.length;i++){
    		labels.push(ichart[i].ds);
		}
    	
		var chart = new iChart.LineBasic2D({
			render : 'canvasDiv',
			data: data,
			align:'center',
			title : {
				text:'快检流变实时扭矩曲线图',
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
						}
						var message = "<span style='color:#005268;font-size:20px;'>"+name+"为:"+"</span><span style='color:#005268;font-size:20px;'>"+value;
						if(name=="内压"){
							message+= "Mpa</span>";
						}else if(name=="步序")
						{
							message+= "</span>";
						}else{
							message+= "</span>";
						}
						return message;
					}
				}
			},
			
			tipMocker:function(tips,i){//当有多条线段(数据)时，可以利用tipMocker将tip整合到一起。作为一个iChart.Tip展示出来。tipMocker是个很实用的配置。需要掌握。(默认为null)
				return "<div style='font-weight:600;color:#005268;'>"+labels[i]+"流变快检实时扭矩曲线图参数如下:</div>"+tips.join("<br/>");
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
					 start_scale:min*0.9,
					 end_scale:max*1.1,
					 scale_space:((max-min)/2).toFixed(2),
					 scale_size:2,//刻度线的粗细
					 scale_enable : false,
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
					 labels:ds
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
					.fillText('扭矩',x-40,y-12,false,'#9d987a');
						
					
				}
		}));
	//开始画图
	chart.draw();
    }
    
    function drawLineBasicmnnj2D(ichart){
    	console.log(ichart);
    	var syh=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].syh!=null&&ichart[i].syh!=undefined){
				syh.push(ichart[i].syh);
			}
		}
		var nj=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].nj!=null&&ichart[i].nj!=undefined){
				nj.push(ichart[i].nj);
			}
		}
		var ds=[];
		for(var i=0;i<ichart.length;i++){
			if(ichart[i].ds!=null&&ichart[i].ds!=undefined){
				if(i%20==0){
				ds.push(ichart[i].ds);
				}
			}
		}
		var data = [
		         	{
		         		name : '扭矩',
		         		value:nj,
		         		color:'#c12c44',
		         		line_width:2
		         	}
		         ];
		
        //绑定X坐标时间的值
		var labels=[]; 
		
		var max=Math.max.apply(null, nj);//取上模与下模温度的最大值
		var min=Math.min.apply(null,nj);//取上模与下模温度的最小值
		var width = $(window).width() < 800 ? 800 : $(window).width();
		var height = $(window).height() < 500 ? 500 : $(window).height();
    	for(var i=0;i<ichart.length;i++){
    		labels.push(ichart[i].ds);
		}
    	
		var chart = new iChart.LineBasic2D({
			render : 'canvasDiv',
			data: data,
			align:'center',
			title : {
				text:'门尼快检实时扭矩曲线图',
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
						}
						var message = "<span style='color:#005268;font-size:20px;'>"+name+"为:"+"</span><span style='color:#005268;font-size:20px;'>"+value;
						if(name=="内压"){
							message+= "Mpa</span>";
						}else if(name=="步序")
						{
							message+= "</span>";
						}else{
							message+= "</span>";
						}
						return message;
					}
				}
			},
			
			tipMocker:function(tips,i){//当有多条线段(数据)时，可以利用tipMocker将tip整合到一起。作为一个iChart.Tip展示出来。tipMocker是个很实用的配置。需要掌握。(默认为null)
				return "<div style='font-weight:600;color:#005268;'>"+labels[i]+"门尼快检实时扭矩曲线图参数如下:</div>"+tips.join("<br/>");
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
					 start_scale:min*0.9,
					 end_scale:max*1.1,
					 scale_space:((max-min)/10).toFixed(2),
					 scale_size:2,//刻度线的粗细
					 scale_enable : false,
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
					 labels:ds
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
					.fillText('扭矩',x-40,y-12,false,'#9d987a');
						
					
				}
		}));
	//开始画图
	chart.draw();
    }
    
    
    /**
     * 查询方法
     */
    var filter=function(){
        var starttime =$("#start_time").datetimebox("getValue");
        var endtime=$("#end_time").datetimebox("getValue");
        console.info("starttime"+starttime);
        console.info("endtime"+endtime);
        var opts = $("#quickcheckmain_dg").datagrid("options");
        opts.url = 'mix/qualityManagement/quickCheckMain/datagrid3';
        ext.easyui.grid.search("quickcheckmain_dg","QuickCheckMain_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("quickcheckmain_dg",{});
    }

    function edit() {
        var rows = $("#quickcheckmain_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#quickcheckmain_dg").datagrid("getRowIndex", rows[i]);
            $("#quickcheckmain_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#quickcheckmain_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#quickcheckmain_dg").datagrid("getRowIndex", rows[i]);
            $("#quickcheckmain_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#quickcheckmain_dg");

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
            $("#quickcheckmain_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#quickcheckmain_dg").datagrid("rejectChanges");
    }
    function decisionbyline(v,r,i){
        if("Y"==r.decisionbyline_s){
            return "是";
        }else if("N"==r.decisionbyline_s){
            return "否";
        }else{
            return "";
        }
    }

    /**
     *数据字典传值
     *
     */
    function codeFormatter(v, r, i) {

        return dictFormat(v);
    }

    function selectrow(){
        var rows=$("#quickcheckmain_dg").datagrid('getSelected');
        var id=rows.sampleno_s;
        var url ="mix/qualityManagement/quickCheckMain/datagrid2?id="+id;
        ext.ajax.get(url, function(data) {
            $('#quickcheckdetail_dg').datagrid('loadData',data);
        });
    }
    
    var shiftCodeContent=[];
    $.ajax({
        url:"dict/code/302",
        type:"get",
        dataType:"json",
        async:false,
        success:function(data){
            shiftCodeContent=data;
        }
    });


    function isSendmix(v,r,i){
        if("Y"==r.is_sendmix_s){
            return "是";
        }else if("N"==r.is_sendmix_s){
            return "否";
        }else{
            return "";
        }
    }

    function recordFlag(v,r,i){
        if("A"==r.record_flag_s){
            return "可用";
        }else if("D"==r.record_flag_s){
            return "删除";
        }else{
            return "";
        }
    }

    function recordFlag1(v,r,i){
        if("A"==r.RECORD_FLAG_S){
            return "可用";
        }else if("D"==r.RECORD_FLAG_S){
            return "删除";
        }else{
            return "";
        }
    }


    function checkResult(v,r,i){
        if("Y"==r.RESULT_S){
            return "合格";
        }else if("N"==r.RESULT_S){
            return "不合格";
        }else{
            return "";
        }
    }
    
    function testmethod(v,r,i){
        if("Y"==r.TESTMETHOD_S){
            return "是";
        }else{
            return "否";
        }
    }
    
    function valuemaxsign(v,r,i){
        if(0==r.VALUEMAXSIGN_S){
            return "不包含";
        }else if(1==r.VALUEMAXSIGN_S){
            return "包含";
        }else{
            return "";
        }
    }


    function valueminsign(v,r,i){
        if(0==r.VALUEMINSIGN_S){
            return "不包含";
        }else if(1==r.VALUEMINSIGN_S){
            return "包含";
        }else{
            return "";
        }
    }

    function factorydetail(v,r,i){
        if(1==r.S_FACTORY_S){
            return "全钢";
        }else if(2==r.S_FACTORY_S){
            return "半钢";
        }else{
            return "";
        }
    }

    function factorymain(v,r,i){
        if(1==r.s_factory_s){
            return "全钢";
        }else if(2==r.s_factory_s){
            return "半钢";
        }else{
            return "";
        }
    }

    var equiplist=[];
    //加载胶料机台信息
    $.ajax({
        url:"mix/baseData/rockWellFactoryModel/getMixProductionInfo?plantype="+"051003",
        type:"get",
        dataType:"json",
        async:false,
        success:function(data){
            equiplist=data;
        }
    });

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
            if(r.equip_sa_s==mlList[i1].p_line_name){
                return mlList[i1].description;
            }
        }
    }
    function mnformatter(v,r,i){
        for( var i1=0;i1<mlList.length;i1++){
            if(r.equip_mi_s==mlList[i1].p_line_name){
                return mlList[i1].description;
            }
        }
    }

    function searchProductionLine(q, row) {
        var opts = $(this).combobox('options');
        return row[opts.textField].toUpperCase().indexOf(q.toUpperCase()) >= 0;
    }
    
    /**
	 * 日期格式化
	 */
	function dateFormat(date) {
		return new Calendar(date).format("yyyyMMdd");
	}
	/**
	 * 解析指定格式日期
	 */
	function dateParser(s) {
		if (!s)
			return new Date();
		return new Date(s.substring(0, 4), parseInt(s.substring(4, 6)) - 1, s
				.substring(6, 8));
	}

  
</script>