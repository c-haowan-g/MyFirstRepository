<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"mix/productionManagement/drprodimplement/saveChanges";
    
    function showOrHide(){
        if($("#DrprodImplement_search_form").is(":hidden")){
            $("#DrprodImplement_search_form").show();
        }else{
            $("#DrprodImplement_search_form").hide();
        }
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
	 var equiplist=[];
        //加载胶料机台信息
     $.ajax({
 		url:"mix/report/mixmonthlyreport/mixmonthlyreport/getMixProductionInfo?plantype="+"051003",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			equiplist=data;
 		}
	});
     
    	function searchProductionLine(q, row) {
		var opts = $(this).combobox('options');
		return row[opts.textField].toUpperCase().indexOf(q.toUpperCase()) >= 0;
	}
    /**
     * 查询方法
     */
    var filter=function(){ var starttime =$("#start_time").datetimebox("getValue");
        var endtime=$("#end_time").datetimebox("getValue");
        if(starttime!="" && endtime!=""){
            if(starttime>endtime){
                ext.tip.error("<spring:message code="tip.date" />");
            }else{
                var opts = $("#drprodimplement_dg").datagrid("options");
                opts.url ='mix/productionManagement/drprodimplement/datagrid';
                ext.easyui.grid.search("drprodimplement_dg","DrprodImplement_search_form");
            }
        }else{
            var opts = $("#drprodimplement_dg").datagrid("options");
            opts.url ='mix/productionManagement/drprodimplement/datagrid';
            ext.easyui.grid.search("drprodimplement_dg","DrprodImplement_search_form");
        }
        //ext.easyui.grid.search("drprodimplement_dg","DrprodImplement_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("drprodimplement_dg",{});
    }

    function edit() {
        var rows = $("#drprodimplement_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#drprodimplement_dg").datagrid("getRowIndex", rows[i]);
            $("#drprodimplement_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#drprodimplement_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#drprodimplement_dg").datagrid("getRowIndex", rows[i]);
            $("#drprodimplement_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#drprodimplement_dg");

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
            $("#drprodimplement_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#drprodimplement_dg").datagrid("rejectChanges");
    }

 /**
    *将数据库得值转换为数据字典与对应值域
    */           	
    function codeFormatter(v, r, i) {

    		return dictFormat(v);
    	}
    	
     function isbindtrainFormatter(v,r,i){
        if(v==0){
             return "否";        	 
        }else if(v==1){
       	     return "是";  
        }else{
       	     return v;
        }
   } 
   
     function cuttypeFormatter(v,r,i){
        if(v==1){
             return "手动切胶";        	 
        }else if(v==2){
       	     return "自动切胶";  
        }else{
       	     return v;
        }
   }      	

     function ischeckFormatter(v,r,i){
        if(v==0){
             return "否";        	 
        }else if(v==1){
       	     return "是";  
        }else{
       	     return v;
        }
   }   
   
        function isselfcheckFormatter(v,r,i){
        if(v==0){
             return "合格";        	 
        }else if(v==1){
       	     return "不合格";  
        }else{
       	     return v;
        }
   }   
   
        function rfidisokFormatter(v,r,i){
        if(v==0){
             return "失败";        	 
        }else if(v==1){
       	     return "成功";  
        }else{
       	     return v;
        }
   } 
   
        function recordflagFormatter(v,r,i){
        if(v='A'){
             return "可用";        	 
        }else if(v='D'){
       	     return "删除";  
        }else{
       	     return v;
        }
   }   
   
        function syncflagFormatter(v,r,i){
        if(v='A'){
             return "新增";        	 
        }else if(v='U'){
       	     return "修改";  
        }else if(v='D'){
       	     return "删除";  
        }else{
       	     return v;
        }
   }  
     
        function synchandflagFormatter(v,r,i){
        if(v==0){
             return "未处理";        	 
        }else if(v==1){
       	     return "已处理";  
        }else{
       	     return v;
        }
   }  



   
         function syncflagFormatter(v,r,i){
        if(v==0){
             return "使用";        	 
        }else if(v==U){
       	     return "不使用";  
        }else{
       	     return v;
        }
   }  
   
       
         function ismixedFormatter(v,r,i){
        if(v='Yes'){
             return "掺胶";        	 
        }else if(v='No'){
       	     return "不掺胶";  
        }else{
       	     return v;
        }
   } 
   
        function isuseareatempFormatter(v,r,i){
        if(v==0){
             return "不使用";        	 
        }else if(v==1){
       	     return "使用";  
        }else{
       	     return v;
        }
   } 
   
      function prescriptionstageFormatter(v,r,i){
        if(v='ZC'){
             return "正常";        	 
        }else if(v='SY'){
       	     return "不正常";  
        }else{
       	     return v;
        }
   } 
   


      function datasourceFormatter(v,r,i){
        if(v==0){
             return "PLM原数据";        	 
        }else if(v==1){
       	     return "自动生成";  
        }else{
       	     return v;
        }
   } 

      function datasourcetypeFormatter(v,r,i){
        if(v==0){
             return "上辅机配方";        	 
        }else if(v==1){
       	     return "配料系统配方";  
        }else{
       	     return v;
        }
   } 
   
   
         function  dummy1Formatter(v,r,i){
        if(v='TC'){
             return "投产";        	 
        }else if(v='XS'){
       	     return "小试";  
        }else if(v='ZS'){
       	     return "中试";  
        }else if(v='DS'){
       	     return "大试";  
        }else{
       	     return v;
        }
   } 
   
   
        function recordflagFormatter(v,r,i){
        if(v='A'){
             return "可用";        	 
        }else if(v='D'){
       	     return "删除";  
        }else{
       	     return v;
        }
   } 
 
 
   function sendstateFormatter(v,r,i){
        if(v==0){
             return "未下发";        	 
        }else if(v==1){
       	     return "已下发";  
        }else if(v==2){
       	     return "下发失败";  
        }else{
       	     return v;
        }
   } 
   
      function spare4Formatter(v,r,i){
        if(v==0){
             return "未下发";        	 
        }else if(v==1){
       	     return "已下发";  
        }else{
       	     return v;
        }
   } 
 
        function spare5Formatter(v,r,i){
        if(v==0){
             return "未处理";        	 
        }else if(v==1){
       	     return "已处理";  
        }else if(v==2){
       	     return "处理失败";  
        }else{
       	     return v;
        }
   } 
 
         function syncflagFormatter(v,r,i){
        if(v='A'){
             return "新增";        	 
        }else if(v='U'){
       	     return "修改";  
        }else if(v='D'){
       	     return "删除";  
        }else{
       	     return v;
        }
   } 
   
        function synchandflagflhandFormatter(v,r,i){
        if(v==0){
             return "未处理";        	 
        }else if(v==1){
       	     return "已处理";  
        }else if(v==2){
       	     return "处理失败";  
        }else{
       	     return v;
        }
   } 
   
   
      function checkstateFormatter(v,r,i){
        if(v==0){
             return "未审核";        	 
        }else if(v==1){
       	     return "已审核";  
        }else{
       	     return v;
        }
   } 
      
      function spare2Formatter(v,r,i){
          if(v=="c"){
               return "关闭";        	 
          }else if(v=="b"){
         	     return "打开";  
          }else{
         	     return v;
          }
     } 
    
  	function warningsgn4Formatter(v, r, i) {
		if (v == 0) {
			return "正常";
		} else if (v == 1) {
			return "超上限";
		} else if (v == 2) {
			return "超下限";
		} else {
			return v;
		}
	}
      
      function DischangetimeFormatter(v,r,i){
          if(v==0){
               return "不限制";        	 
          }else if(v==1){
         	     return "限制";  
          }else{
         	     return v;
          }
     } 
		
		//获取条件代码数据字典对应关系
		var ConditionDict = [];
		ext.ajax.get("mix/productionManagement/drprodimplement/getDictFormatter?dictcode=" + "326",
				function(data) {
					ConditionDict = data;
				});
		//获取动作代码数据字典对应关系
		var ActionDict = [];
		ext.ajax.get("mix/productionManagement/drprodimplement/getDictFormatter?dictcode=" + "325",
				function(data) {
					ActionDict = data;
				});

		function conditionformatter(v, r, i) {
			for (var j = 0; j < ConditionDict.length; j++) {
				if (v == ConditionDict[j].ERPCODE_S) {
					return v + '-' + ConditionDict[j].DICTNAME_S
				}
			}
			return v;
		}
		function actionformatter(v, r, i) {
			for (var j = 0; j < ActionDict.length; j++) {
				if (v == ActionDict[j].ERPCODE_S) {
					return v + '-' + ActionDict[j].DICTNAME_S
				}
			}
			return v;
		}
		//获取父物料类型数据字典对应关系
		var ParentMrpDict = [];
		ext.ajax.get("mix/productionManagement/drprodimplement/getDictFormatter?dictcode=" + "330",
				function(data) {
					ParentMrpDict = data;
				});
		function parentMrpformatter(v, r, i) {
			for (var j = 0; j < ParentMrpDict.length; j++) {
				if (v == ParentMrpDict[j].ERPCODE_S) {
					return ParentMrpDict[j].DICTNAME_S;
				}
			}
			return v;
		}
		//获取配方阶段数据字典对应关系
		var RecipeStateDict = [];
		ext.ajax.get("mix/productionManagement/drprodimplement/getDictFormatter?dictcode=" + "332",
				function(data) {
					RecipeStateDict = data;
				});
		function recipeStateformatter(v, r, i) {
			for (var j = 0; j < RecipeStateDict.length; j++) {
				if (v == RecipeStateDict[j].ERPCODE_S) {
					return v + '-' + RecipeStateDict[j].DICTNAME_S;
				}
			}
			return v;
		}
		//获取工艺类型数据字典对应关系
		var ProductTypeDict = [];
		ext.ajax.get("mix/productionManagement/drprodimplement/getDictFormatter?dictcode=" + "321",
				function(data) {
					ProductTypeDict = data;
				});
		function productTypeformatter(v, r, i) {
			for (var j = 0; j < ProductTypeDict.length; j++) {
				if (v == ProductTypeDict[j].ERPCODE_S) {
					return v + '-' + ProductTypeDict[j].DICTNAME_S
				}
			}
			return v;
		}

		//获取称量类型数据字典对应关系
		var WeightTypeDict = [];
		ext.ajax.get("mix/productionManagement/drprodimplement/getDictFormatter?dictcode=" + "324",
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

		//获取是否掺胶数据字典对应关系
		var ISChildMix = [];
		ext.ajax.get("mix/productionManagement/drprodimplement/getDictFormatter?dictcode=" + "333",
				function(data) {
					ISChildMix = data;
				});
		function isChildMixFormatter(v, r, i) {
			for (var j = 0; j < ISChildMix.length; j++) {
				if (v == ISChildMix[j].ERPCODE_S) {
					return v + '-' + ISChildMix[j].DICTNAME_S
				}
			}
			return v;
		}

		//获取接入母胶类型数据字典对应关系
		var INTypeMix = [];
		ext.ajax.get("mix/productionManagement/drprodimplement/getDictFormatter?dictcode=" + "334",
				function(data) {
					INTypeMix = data;
				});
		function isInTypeMixFormatter(v, r, i) {
			for (var j = 0; j < INTypeMix.length; j++) {
				if (v == INTypeMix[j].ERPCODE_S) {
					return v + '-' + INTypeMix[j].DICTNAME_S
				}
			}
			return v;
		}
	
		//获取炭黑回收类型
		var CBRECYCLETYPE = [];
		ext.ajax.get("mix/productionManagement/drprodimplement/getDictFormatter?dictcode=" + "335",
				function(data) {
					CBRECYCLETYPE = data;
				});
		function cbrecycletypeformatter(v, r, i) {
			for (var j = 0; j < CBRECYCLETYPE.length; j++) {
				if (v == CBRECYCLETYPE[j].ERPCODE_S) {
					return v + '-' + CBRECYCLETYPE[j].DICTNAME_S;
				}
			}
			return v;
		}
		//右上方表格行单击事件   
     function selectrow(){
     
      var rows=$("#drprodimplement_dg").datagrid('getSelected');
      var recipe_code_s=rows.recipe_code_s;
      var trainprod_id_s=rows.id_s;
      var sync_wo_no_s=rows.wo_no_s;
      var lot_no_s=rows.lot_no_s;
      //加载子表信息
        ext.ajax.post("mix/productionManagement/mixmrecipeexechis/datagrid",{"filter[recipe_code_s]":recipe_code_s,"filter[sync_wo_no_s]":sync_wo_no_s,all:1},function(data){
    		 $('#mixmrecipeexechis_dg').datagrid('loadData', data);
    	});
    	ext.ajax.post("mix/productionManagement/drprodimplementcl/datagrid",{"filter[trainprod_id_s]":lot_no_s,all:1},function(data){
    		 $('#drprodimplementcl_dg').datagrid('loadData', data);
    	});
    	ext.ajax.post("mix/productionManagement/drprodimplementgy/datagrid",{"filter[trainprod_id_s]":lot_no_s,all:1},function(data){
    		 $('#drprodimplementgy_dg').datagrid('loadData', data);
    	});


    }
    function ccreal(){
        var list_map={};
        var rows=$("#drprodimplement_dg").datagrid('getSelected');
        list_map.equip_code_s=rows.equip_code_s;//选中行机台编码
        list_map.start_datetime_s=rows.start_datetime_s;//开始时间
        list_map.mixtime_i=parseInt(rows.recipetime_i);
        list_map.plan_no_s=rows.wo_no_s;//工单号
        list_map.serial_id_i=rows.serial_id_i;//车次号
        checiClick(list_map);
    }
    /*function checiClick(){
        var list_map={};
        var rows=$("#drprodimplement_dg").datagrid('getSelected');
        list_map.equip_code_s=rows.equip_code_s;//选中行机台编码
        list_map.start_datetime_s=rows.start_datetime_s;//开始时间
        list_map.mixtime_i=parseInt(rows.recipetime_i);
        list_map.plan_no_s=rows.wo_no_s;//工单号
        list_map.serial_id_i=rows.serial_id_i;//车次号
        // list_map.mixtime_i=parseInt(rows.mixtime_i)+parseInt(rows.intervals_i);//产出时间
        //产出时间
       $("#cc_qx").window('open');
      $.ajax({
          url:'mix/productionmanagement/drprodimplement/ccqx',
          type:"post",
          dataType:"json",
          data : JSON.stringify(list_map),
          contentType:'application/json',
          async:false,
          success:function(data){
              drawLineBasic2D(data);
          }
      });
    }*/
    

    //表格加载前事件
	function dlg1BeforeLoad(param) {
    	
		if ($("#start_time").datebox("getValue") == "") {
			return false;
		}

		param["filter[start_time]"] = $("#start_time").datebox("getValue").toString();
		param["filter[end_time]"] = $("#end_time").datebox("getValue").toString();
    	
		if ($("#lot_no_s").textbox("getValue") == "") {
			
		}else{
			param["filter[start_time]"] = null;
			param["filter[end_time]"] = null;
		}
	}
 /*function drawLineBasic2D(ichart){
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
        if(maxRight>1350){
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
        }
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
        maxLeft=parseInt(maxLeft);
        if(maxLeft>240){
            maxLeft=300;
            mixLeft=30;
        }else{
            maxLeft=240;
            mixLeft=20;
        }
    /!*    var trainNo=[];
        for(var i=0;i<ichart.length;i++){
            if(ichart[i].trainNo!=null&&ichart[i].trainNo!=undefined){
                trainNo.push(ichart[i].trainNo);
            }
        }*!/

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
            }/!*,
            {
                name : '车次号',
                value:trainNo,
                color:'#1423d3',
                line_width:2
            }*!/

        ];

        //绑定X坐标时间的值
        var labels=[];
        var rows = $("#drprodimplement_dg").datagrid('getSelected');

        var start_datetime_s =rows.start_datetime_s;

        curing_closesub=start_datetime_s.substring(11);

        var product_time_t =rows.product_time_t;

        curing_opensub=product_time_t.substring(11);


        var startDate = new Date(start_datetime_s);

        var min=startDate.getMinutes();

        startDate.setMinutes(min+6);

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
                text:'车次曲线图',
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
                       // console.info("parseText");
                        /!*if(name=="压力"){
                            value=value.toFixed(2);
                        }else if(name!="转速"&&name!="压力"){
                            value=value.toFixed(1);
                        }*!/
                        var message = "<span style='color:#005268;font-size:20px;'>"+name+"为:"+"</span><span style='color:#005268;font-size:20px;'>"+value;
                       /!* if(name=="压力"){
                            message+= "Mpa</span>";
                        }else if(name=="转速")
                        {
                            message+= "</span>";
                        }else{
                            message+= "</span>";
                        }*!/
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
        console.info("啊它过去了");
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
    }*/
	
</script>