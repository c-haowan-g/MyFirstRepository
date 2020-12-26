<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"mix/report/mixmonthlyreport/mixmonthlyreport/saveChanges";
    
    function showOrHide(){
        if($("#MixMonthlyReport_search_form").is(":hidden")){
            $("#MixMonthlyReport_search_form").show();
        }else{
            $("#MixMonthlyReport_search_form").hide();
        }
    }
    var plinedata = [];

	$.ajax({
		url:"mix/report/mixmonthlyreport/mixmonthlyreport/getMixProductionInfo?plantype="+"051004",
		type : "get",
		dataType : "json",
		async : false,
		success : function(data) {
			plinedata = data;
		}
	});

	/**
	 * 日期格式化
	 */
	function dateFormat(date) {
		return new Calendar(date).format("yyyyMMdd");
	}

	function dateParser(s) {
		if (!s)
			return new Date();
		return new Date(s.replace("-", ""));
	}

	$(function() {
        $("#spare1_s").textbox('setValue','1');//密炼1，
	    $("#spare1_s").next().hide();

		$('#month_s').datebox(
						{
							//显示日趋选择对象后再触发弹出月份层的事件，初始化时没有生成月份层
							onShowPanel : function() {
								//触发click事件弹出月份层
								span.trigger('click');
								if (!tds)
									//延时触发获取月份对象，因为上面的事件触发和对象生成有时间间隔
									setTimeout(
											function() {
												tds = p.find('div.calendar-menu-month-inner td');
												tds.click(function(e) {
															//禁止冒泡执行easyui给月份绑定的事件
															e.stopPropagation();
															//得到年份
															var year = /\d{4}/.exec(span.html())[0],
															//月份
															//之前是这样的month = parseInt($(this).attr('abbr'), 10) + 1; 
															month = parseInt($(this).attr('abbr'), 10);

															//隐藏日期对象                     
															$('#month_s').datebox('hidePanel')
																	//设置日期的值
																	.datebox('setValue',year + '-' + month);
														});
											}, 0);
							},
							//配置parser，返回选择的日期
							parser : function(s) {
								if (!s)
									return new Date();
								var arr = s.split('-');
								return new Date(parseInt(arr[0], 10), parseInt(arr[1], 10) - 1, 1);
							},
							//配置formatter，只返回年月 之前是这样的d.getFullYear() + '-' +(d.getMonth()); 
							formatter : function(d) {
								var currentMonth = (d.getMonth() + 1);
								var currentMonthStr = currentMonth < 10 ? ('0' + currentMonth)
										: (currentMonth + '');
								return d.getFullYear() + '-' + currentMonthStr;
							}
						});

		//日期选择对象
		var p = $('#month_s').datebox('panel'),
		//日期选择对象中月份
		tds = false,
		//显示月份层的触发控件
		span = p.find('span.calendar-text');
		var curr_time = new Date();

		//设置前当月
		$("#month_s").datebox("setValue", myformatter(curr_time));
	});

	function myformatter(date) {
		//获取年份
		var y = date.getFullYear();
		//获取月份
		var m = date.getMonth() + 1;
		return y + '-' + m;

	}

	var masternamelist = [];
	var date = new Calendar().format("yyyyMM");
	//加载主机手
	
		$.ajax({
				url : "mix/report/mixmonthlyreport/mixmonthlyreport/getmasternamelist?begindate="
						+ date,
				type : "get",
				dataType : "json",
				async : false,
				success : function(data) {
					masternamelist = data;
				}
			});

	var materialspeclist = [];
	//加载物料名称
    date+="_1";
	$.ajax({
		url : "mix/report/mixmonthlyreport/mixmonthlyreport/getmaterialspeclist?begindate="
				+ date,
		type : "get",
		dataType : "json",
		async : false,
		success : function(data) {
			materialspeclist = data;
		}
	});

	/**
	 * 点击获取
	 */
	var getAll = function() {

		var months = $("#month_s").datebox('getValue');
		var month = months.replace("-", "");

		$("#master_name_s")
				.combobox(
						{
							url : "mix/report/mixmonthlyreport/mixmonthlyreport/getmasternamelist?begindate="
									+ month,
							method : "post",
							valueField : 'MASTER_NAME_S',
							textField : 'MASTER_NAME_S',
							selected : 'selected'
						});
        month+="_1";
		$("#materialspec_s")
				.combobox(
						{
							url : "mix/report/mixmonthlyreport/mixmonthlyreport/getmaterialspeclist?begindate="
									+ month,
							method : "post",
							valueField : 'MATERIALSPEC_S',
							textField : 'MATERIALSPEC_S',
							selected : 'selected'
						});

	}

	//表格加载前事件
	function dlg1BeforeLoad(param) {
		var months = $("#month_s").datebox('getValue');
		var month;
		if (months != "") {
			month = months.replace("-", "");
		} else {
			month = new Calendar().format("yyyyMM");
		}
		param["filter[month_s]"] = month;

	}
    /**
     * 查询方法
     */
    var filter=function(){
    	var url = 'mix/report/mixmonthlyreport/mixmonthlyreport/datagrid';
		var opts = $("#mixmonthlyreport_dg").datagrid("options");
		opts.url = url;
        ext.easyui.grid.search("mixmonthlyreport_dg","MixMonthlyReport_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("mixmonthlyreport_dg",{});
    }

    function edit() {
        var rows = $("#mixmonthlyreport_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#mixmonthlyreport_dg").datagrid("getRowIndex", rows[i]);
            $("#mixmonthlyreport_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#mixmonthlyreport_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#mixmonthlyreport_dg").datagrid("getRowIndex", rows[i]);
            $("#mixmonthlyreport_dg").datagrid("deleteRow", index);
        }

    }
	function doExport() {
		/* var param = ext.form.getFormAsJson("MixMonthlyReport_search_form");
		console.log(param)
		var param_get = "";

		for ( var k in param) {
			param_get = param_get + "&"
					+ k.replace("filter[", "").replace("]", "") + "="
					+ param[k];
		}
		window.open(path + "mix/report/mixmonthlyreport/mixmonthlyreport/exportCSV?s_factory_s="
				+ factory + param_get);  */
	//获取grid 数据
	    var node = $("#mixmonthlyreport_dg").datagrid("getSelections");
    	if (node == "") {
    		var param=ext.form.getFormAsJson("MixMonthlyReport_search_form");
        	var param_get="";
        	for(var k in param){
        		param_get=param_get+"&"+k.replace("filter[","").replace("]","")+"="+param[k];
        	}
    		$.ajax({
    			url : "mix/report/mixmonthlyreport/mixmonthlyreport/exportCSV?s_factory_s="+factory + param_get,
    			type : 'get',
    			dataType : 'json',
    			async : false,
    			success : function(data) {
    			     node = data; 
    			}
    		});
		}
        var oneday_train_i = 0;
		var oneday_weight_d = 0;
		var twoday_train_i = 0;
		var twoday_weight_d = 0;
		var threeday_train_i = 0;
		var threeday_weight_d = 0;
		var fourday_train_i = 0;
		var fourday_weight_d = 0;
		var fiveday_train_i = 0;
		var fiveday_weight_d = 0;
		var sixday_train_i = 0;
		var sixday_weight_d = 0;
		var sevenday_train_i = 0;
		var sevenday_weight_d = 0;
		var eightday_train_i = 0;
		var eightday_weight_d = 0;
		var nineday_train_i = 0;
		var nineday_weight_d = 0;
		var tenday_train_i = 0;
		var tenday_weight_d = 0;
		var elevenday_train_i = 0;
		var elevenday_weight_d = 0;
		var twelvenday_train_i = 0;
		var twelvenday_weight_d = 0;
		var thirteenday_train_i = 0;
		var thirteenday_weight_d = 0;
		var fourteenday_train_i = 0;
		var fourteenday_weight_d = 0;
		var fifteenday_train_i = 0;
		var fifteenday_weight_d = 0;
		var sixteenday_train_i = 0;
		var sixteenday_weight_d = 0;
		var seventeenday_train_i = 0;
		var seventeenday_weight_d = 0;
		var eighteenday_train_i = 0;
		var eighteenday_weight_d = 0;
		var ninteenday_train_i = 0;
		var ninteenday_weight_d = 0;
		var twentyday_train_i = 0;
		var twentyday_weight_d = 0;
		var twentyoneday_train_i = 0;
		var twentyoneday_weight_d = 0;
		var twentytwoday_train_i = 0;
		var twentytwoday_weight_d = 0;
		var twentythreeday_train_i = 0;
		var twentythreeday_weight_d = 0;
		var twentyfourday_train_i = 0;
		var twentyfourday_weight_d = 0;
		var twentyfiveday_train_i = 0;
		var twentyfiveday_weight_d = 0;
		var twentysixday_train_i = 0;
		var twentysixday_weight_d = 0;
		var twentysevenday_train_i = 0;
		var twentysevenday_weight_d = 0;
		var twentyeightday_train_i = 0;
		var twentyeightday_weight_d = 0;
		var twentynineday_train_i = 0;
		var twentynineday_weight_d = 0;
		var thirtyday_train_i = 0;
		var thirtyday_weight_d = 0;
		var thirtyoneday_train_i = 0;
		var thirtyoneday_weight_d = 0;
		var total_train_i = 0;
		var total_weight_d = 0;
		var CheckTotal = false;//检测是否选择合计行，true选中,false未选中
		for (var i = 0; i < node.length; i++) {
			oneday_train_i += parseFloat(node[i]["oneday_train_i"]);
			oneday_weight_d += parseFloat(node[i]["oneday_weight_d"]);
			twoday_train_i += parseFloat(node[i]["twoday_train_i"]);
			twoday_weight_d += parseFloat(node[i]["twoday_weight_d"]);
			threeday_train_i += parseFloat(node[i]["threeday_train_i"]);
			threeday_weight_d += parseFloat(node[i]["threeday_weight_d"]);
			fourday_train_i += parseFloat(node[i]["fourday_train_i"]);
			fourday_weight_d += parseFloat(node[i]["fourday_weight_d"]);
			fiveday_train_i += parseFloat(node[i]["fiveday_train_i"]);
			fiveday_weight_d += parseFloat(node[i]["fiveday_weight_d"]);
			sixday_train_i += parseFloat(node[i]["sixday_train_i"]);
			sixday_weight_d += parseFloat(node[i]["sixday_weight_d"]);
			sevenday_train_i += parseFloat(node[i]["sevenday_train_i"]);
			sevenday_weight_d += parseFloat(node[i]["sevenday_weight_d"]);
			eightday_train_i += parseFloat(node[i]["eightday_train_i"]);
			eightday_weight_d += parseFloat(node[i]["eightday_weight_d"]);
			nineday_train_i += parseFloat(node[i]["nineday_train_i"]);
			nineday_weight_d += parseFloat(node[i]["nineday_weight_d"]);
			tenday_train_i += parseFloat(node[i]["tenday_train_i"]);
			tenday_weight_d += parseFloat(node[i]["tenday_weight_d"]);
			elevenday_train_i += parseFloat(node[i]["elevenday_train_i"]);
			elevenday_weight_d += parseFloat(node[i]["elevenday_weight_d"]);
			twelvenday_train_i += parseFloat(node[i]["twelvenday_train_i"]);
			twelvenday_weight_d += parseFloat(node[i]["twelvenday_weight_d"]);
			thirteenday_train_i += parseFloat(node[i]["thirteenday_train_i"]);
			thirteenday_weight_d += parseFloat(node[i]["thirteenday_weight_d"]);
			fourteenday_train_i += parseFloat(node[i]["fourteenday_train_i"]);
			fourteenday_weight_d += parseFloat(node[i]["fourteenday_weight_d"]);
			fifteenday_train_i += parseFloat(node[i]["fifteenday_train_i"]);
			fifteenday_weight_d += parseFloat(node[i]["fifteenday_weight_d"]);
			sixteenday_train_i += parseFloat(node[i]["sixteenday_train_i"]);
			sixteenday_weight_d += parseFloat(node[i]["sixteenday_weight_d"]);
			seventeenday_train_i += parseFloat(node[i]["seventeenday_train_i"]);
			seventeenday_weight_d += parseFloat(node[i]["seventeenday_weight_d"]);
			eighteenday_train_i += parseFloat(node[i]["eighteenday_train_i"]);
			eighteenday_weight_d += parseFloat(node[i]["eighteenday_weight_d"]);
			ninteenday_train_i += parseFloat(node[i]["ninteenday_train_i"]);
			ninteenday_weight_d += parseFloat(node[i]["ninteenday_weight_d"]);
			twentyday_train_i += parseFloat(node[i]["twentyday_train_i"]);
			twentyday_weight_d += parseFloat(node[i]["twentyday_weight_d"]);
			twentyoneday_train_i += parseFloat(node[i]["twentyoneday_train_i"]);
			twentyoneday_weight_d += parseFloat(node[i]["twentyoneday_weight_d"]);
			twentytwoday_train_i += parseFloat(node[i]["twentytwoday_train_i"]);
			twentytwoday_weight_d += parseFloat(node[i]["twentytwoday_weight_d"]);
			twentythreeday_train_i += parseFloat(node[i]["twentythreeday_train_i"]);
			twentythreeday_weight_d += parseFloat(node[i]["twentythreeday_weight_d"]);
			twentyfourday_train_i += parseFloat(node[i]["twentyfourday_train_i"]);
			twentyfourday_weight_d += parseFloat(node[i]["twentyfourday_weight_d"]);
			twentyfiveday_train_i += parseFloat(node[i]["twentyfiveday_train_i"]);
			twentyfiveday_weight_d += parseFloat(node[i]["twentyfiveday_weight_d"]);
			twentysixday_train_i += parseFloat(node[i]["twentysixday_train_i"]);
			twentysixday_weight_d += parseFloat(node[i]["twentysixday_weight_d"]);
			twentysevenday_train_i += parseFloat(node[i]["twentysevenday_train_i"]);
			twentysevenday_weight_d += parseFloat(node[i]["twentysevenday_weight_d"]);
			twentyeightday_train_i += parseFloat(node[i]["twentyeightday_train_i"]);
			twentyeightday_weight_d += parseFloat(node[i]["twentyeightday_weight_d"]);
			twentynineday_train_i += parseFloat(node[i]["twentynineday_train_i"]);
			twentynineday_weight_d += parseFloat(node[i]["twentynineday_weight_d"]);
			thirtyday_train_i += parseFloat(node[i]["thirtyday_train_i"]);
			thirtyday_weight_d += parseFloat(node[i]["thirtyday_weight_d"]);
			thirtyoneday_train_i += parseFloat(node[i]["thirtyoneday_train_i"]);
			thirtyoneday_weight_d += parseFloat(node[i]["thirtyoneday_weight_d"]);
			total_train_i += parseFloat(node[i]["total_train_i"]);
			total_weight_d += parseFloat(node[i]["total_weight_d"]);
			
		
			//qualitycompletionrate = Math.floor((gradea/totalquantity/0.996*100)*1000)/1000+"%";
		}
		if (!CheckTotal) {
			//导出添加合计行
			var newJson = {
					/* equip_name_s : "",
					master_name_s : "",
					materialspec_s : "",
					materialcode_s : '<spring:message code="dynabalancecheresultprint.column.total" />',
					oneday_train_i : "" + oneday_train_i + "",
					oneday_weight_d: "" + oneday_weight_d + "",
					twoday_train_i : "" + twoday_train_i + "",
					twoday_weight_d : "" + twoday_weight_d + "",
					threeday_train_i :"" + threeday_train_i + "",
					threeday_weight_d : "" + threeday_weight_d + "",
					fourday_train_i : "" + fourday_train_i + "",
					fourday_weight_d : "" + fourday_weight_d + "",
					fiveday_train_i : "" + fiveday_train_i + "",
					fiveday_weight_d: "" + fiveday_weight_d + "",
					sixday_train_i : "" + sixday_train_i + "",
					sixday_weight_d : "" + sixday_weight_d + "",
					sevenday_train_i :"" + sevenday_train_i + "",
					sevenday_weight_d : "" + sevenday_weight_d + "",
					eightday_train_i : "" + eightday_train_i + "",
					eightday_weight_d : "" + eightday_weight_d + "",
					nineday_train_i : "" + nineday_train_i + "",
					nineday_weight_d: "" + nineday_weight_d + "",
					tenday_train_i : "" + tenday_train_i + "",
					tenday_weight_d : "" + tenday_weight_d + "",
					elevenday_train_i :"" + elevenday_train_i + "",
					elevenday_weight_d : "" + elevenday_weight_d + "",
					twelvenday_train_i : "" + twelvenday_train_i + "",
					twelvenday_weight_d : "" + twelvenday_weight_d + "",
					thirteenday_train_i : "" + thirteenday_train_i + "",
					thirteenday_weight_d: "" + thirteenday_weight_d + "",
					fourteenday_train_i : "" + fourteenday_train_i + "",
					fourteenday_weight_d : "" + fourteenday_weight_d + "",
					fifteenday_train_i :"" + fifteenday_train_i + "",
					fifteenday_weight_d : "" + fifteenday_weight_d + "",
					sixteenday_train_i : "" + sixteenday_train_i + "",
					sixteenday_weight_d : "" + sixteenday_weight_d + "",
					seventeenday_train_i : "" + seventeenday_train_i + "",
					seventeenday_weight_d: "" + seventeenday_weight_d + "",
					eighteenday_train_i : "" + eighteenday_train_i + "",
					eighteenday_weight_d : "" + eighteenday_weight_d + "",
					ninteenday_train_i :"" + ninteenday_train_i + "",
					ninteenday_weight_d : "" + ninteenday_weight_d + "",
					twentyday_train_i : "" + twentyday_train_i + "",
					twentyday_weight_d : "" + twentyday_weight_d + "",
					twentyoneday_train_i : "" + twentyoneday_train_i + "",
					twentyoneday_weight_d: "" + twentyoneday_weight_d + "",
					twentytwoday_train_i : "" + twentytwoday_train_i + "",
					twentytwoday_weight_d : "" + twentytwoday_weight_d + "",
					twentythreeday_train_i :"" + twentythreeday_train_i + "",
					twentythreeday_weight_d : "" + twentythreeday_weight_d + "",
					twentyfourday_train_i : "" + twentyfourday_train_i + "",
					twentyfourday_weight_d : "" + twentyfourday_weight_d + "",
					twentyfiveday_train_i : "" + twentyfiveday_train_i + "",
					twentyfiveday_weight_d: "" + twentyfiveday_weight_d + "",
					twentysixday_train_i : "" + twentysixday_train_i + "",
					twentysixday_weight_d : "" + twentysixday_weight_d + "",
					twentysevenday_train_i :"" + twentysevenday_train_i + "",
					twentysevenday_weight_d : "" + twentysevenday_weight_d + "",
					twentyeightday_train_i : "" + twentyeightday_train_i + "",
					twentyeightday_weight_d : "" + twentyeightday_weight_d + "",
					twentynineday_train_i : "" + twentynineday_train_i + "",
					twentynineday_weight_d: "" + twentynineday_weight_d + "",
					thirtyday_train_i : "" + thirtyday_train_i + "",
					thirtyday_weight_d : "" + thirtyday_weight_d + "",
					thirtyoneday_train_i :"" + thirtyoneday_train_i + "",
					thirtyoneday_weight_d : "" + thirtyoneday_weight_d + "",
					total_train_i : "" + total_train_i + "",
					total_weight_d : "" + total_weight_d + "", */
			};
			//node.push(newJson);
		} 
	    var data = JSON.stringify(node);
	    if (data == '')
	        return;
	    var myDate = new Date();
	    var time=myDate.toLocaleString( );
	    var title=[{equip_name_s:'机台名称'},{master_name_s:'主机手'},{materialspec_s:'物料名称'},{materialcode_s:'物料编号'},{oneday_train_i:'1日车数'}
	             ,{oneday_weight_d:'1日重量 '},{twoday_train_i:'2日车数'},{twoday_weight_d:'2日重量'},{threeday_train_i:'3日车数'},{threeday_weight_d:'3日重量'}
	             ,{fourday_train_i:'4日车数'},{fourday_weight_d:'4日重量'},{fiveday_train_i:'5日车数'},{fiveday_weight_d:'5日重量'},{sixday_train_i:'6日车数'},{sixday_weight_d:'6日重量'},{sevenday_train_i:'7日车数'},{sevenday_weight_d:'7日重量'}
	             ,{eightday_train_i:'8日车数'},{eightday_weight_d:'8日重量'},{nineday_train_i:'9日车数'},{nineday_weight_d:'9日重量'},{tenday_train_i:'10日车数'},{tenday_weight_d:'10日重量'},{elevenday_train_i:'11日车数'},{elevenday_weight_d:'11日重量'}
	             ,{twelvenday_train_i:'12日车数'},{twelvenday_weight_d:'12日重量'},{thirteenday_train_i:'13日车数 '},{thirteenday_weight_d:'13日重量'},{fourteenday_train_i:'14日车数'},{fourteenday_weight_d:'14日重量'},{fifteenday_train_i:'15日车数'},{fifteenday_weight_d:'15日重量'}
	             ,{sixteenday_train_i:'16日车数'},{sixteenday_weight_d:'16日重量 '},{seventeenday_train_i:'17日车数  '},{seventeenday_weight_d:'17日重量'},{eighteenday_train_i:'18日车数'},{eighteenday_weight_d:'18日重量'},{ninteenday_train_i:'19日车数 '},{ninteenday_weight_d:'19日重量'}
	             ,{twentyday_train_i:'20日车数'},{twentyday_weight_d:'20日重量 '},{twentyoneday_train_i:'21日车数  '},{twentyoneday_weight_d:'21日重量'},{twentytwoday_train_i:'22日车数'},{twentytwoday_weight_d:'22日重量'},{twentythreeday_train_i:'23日车数 '},{twentythreeday_weight_d:'23日重量'}
	             ,{twentyfourday_train_i:'24日车数'},{twentyfourday_weight_d:'24日重量 '},{twentyfiveday_train_i:'25日车数  '},{twentyfiveday_weight_d:'25日重量'},{twentysixday_train_i:'26日车数'},{twentysixday_weight_d:'26日重量'},{twentysevenday_train_i:'27日车数 '},{twentysevenday_weight_d:'27日重量'}
	             ,{twentyeightday_train_i:'28日车数'},{twentyeightday_weight_d:'28日重量 '},{twentynineday_train_i:'29日车数  '},{twentynineday_weight_d:'29日重量'},{thirtyday_train_i:'30日车数'},{thirtyday_weight_d:'30日重量'},{thirtyoneday_train_i:'31日车数 '},{thirtyoneday_weight_d:'31日重量'},{total_train_i:'总车数'},{total_weight_d:'总重量'}]; 
	    toExcel("月报表"+time,data,title); 
	} 
    function save() {
        var dg = $("#mixmonthlyreport_dg");

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
            $("#mixmonthlyreport_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#mixmonthlyreport_dg").datagrid("rejectChanges");
    }

//合并单元格
	function onLoadSuccess(data) {
		$("#mixmonthlyreport_dg")
				.datagrid("autoMergeCells", [ 'EQUIP_NAME_S' ]);
		$("#mixmonthlyreport_dg").datagrid("autoMergeCells",
				[ 'MASTER_NAME_S' ]);

	}
		 //FileName 生成的Excel文件名称
    function toExcel(FileName, JSONData, ShowLabel) {  
        //先转化json  
        var arrData = typeof JSONData != 'object' ? JSON.parse(JSONData) : JSONData;  
        var excel = '<table>';      
        //设置表头  
        var row = "<tr align='left'>";//设置Excel的左居中
        for (var i = 0, l = ShowLabel.length; i < l; i++) {  
            for (var key in ShowLabel[i]) {
                row += "<td>" + ShowLabel[i][key] + '</td>';  
            }
        }
        //换行  
        excel += row + "</tr>";  
          
        //设置数据  
        for (var i = 0; i < arrData.length; i++) {  
            var rowData = "<tr align='left'>"; 
            
            for (var y = 0; y < ShowLabel.length; y++) {
                for(var k in ShowLabel[y]){
                    if (ShowLabel[y].hasOwnProperty(k)) {
                    	 /* if(k=="curing_openmoulddate"){
                    		 rowData+="<td style='vnd.ms-excel.numberformat:@'>" + (arrData[i][k]===null? "" : finishhours1(arrData[i].spare1_s,arrData[i].totalquantity)) + "</td>";
                    		 continue;
                    	 }
                    	 if(k=="curing_closemoulddate"){					
                    		 rowData+="<td style='vnd.ms-excel.numberformat:@'>" + (arrData[i][k]===null? "" : adequatecompletionrate1(arrData[i].spare1_s,arrData[i].totalquantity)) + "</td>";
                    		 continue;
                    	 } 
                    	 if(k=="qualitycompletionrate"){
                    		 rowData+="<td style='vnd.ms-excel.numberformat:@'>" + Math.floor(arrData[i]['gradea']/arrData[i]['totalquantity']/0.996*100*1000)/1000+'%'; + "</td>";
                    		 continue;
                    	 }
                    	 if(k=="class_id_s"){
                    		 if(arrData[i][k]==="302001"){
                    			 rowData += "<td style='vnd.ms-excel.numberformat:@'>" + ('早班') + "</td>";
                    		 }
                    		 else if(arrData[i][k]==="302002"){
                    			 rowData += "<td style='vnd.ms-excel.numberformat:@'>" + ('中班') + "</td>";
                    		 }
                    		 else if(arrData[i][k]==="302003"){
                    			 rowData += "<td style='vnd.ms-excel.numberformat:@'>" + ('晚班') + "</td>";
                    		 }
                    		 else{
                    			 rowData += "<td style='vnd.ms-excel.numberformat:@'>" + ('') + "</td>";	 
                    		 } 	 
                    		 continue;
                    	 } */
                         rowData += "<td style='vnd.ms-excel.numberformat:@'>" + (arrData[i][k]===null? "" : arrData[i][k]) + "</td>";
                         //vnd.ms-excel.numberformat:@ 输出为文本
                    }
                }
            }
            excel += rowData + "</tr>";  
        }  
        excel += "</table>";  

        var excelFile = "<html xmlns:o='urn:schemas-microsoft-com:office:office' xmlns:x='urn:schemas-microsoft-com:office:excel' xmlns='http://www.w3.org/TR/REC-html40'>";  
        excelFile += '<meta http-equiv="content-type" content="application/vnd.ms-excel; charset=UTF-8">';  
        excelFile += '<meta http-equiv="content-type" content="application/vnd.ms-excel';  
        excelFile += '; charset=UTF-8">';  
        excelFile += "<head>";  
        excelFile += "<!--[if gte mso 9]>";  
        excelFile += "<xml>";  
        excelFile += "<x:ExcelWorkbook>";  
        excelFile += "<x:ExcelWorksheets>";  
        excelFile += "<x:ExcelWorksheet>";  
        excelFile += "<x:Name>";  
        excelFile += "月报表";  
        excelFile += "</x:Name>";  
        excelFile += "<x:WorksheetOptions>";  
        excelFile += "<x:DisplayGridlines/>";  
        excelFile += "</x:WorksheetOptions>";  
        excelFile += "</x:ExcelWorksheet>";  
        excelFile += "</x:ExcelWorksheets>";  
        excelFile += "</x:ExcelWorkbook>";  
        excelFile += "</xml>";  
        excelFile += "<![endif]-->";  
        excelFile += "</head>";  
        excelFile += "<body>";  
        excelFile += excel;  
        excelFile += "</body>";  
        excelFile += "</html>";  

        var uri = 'data:application/vnd.ms-excel;charset=utf-8,' + encodeURIComponent(excelFile);  
        var link = document.createElement("a");      
        link.href = uri;  
          
        link.style = "visibility:hidden";  
        link.download = FileName + ".xls";  
          
        document.body.appendChild(link);  
        link.click();  
        document.body.removeChild(link);  
    } 
</script>