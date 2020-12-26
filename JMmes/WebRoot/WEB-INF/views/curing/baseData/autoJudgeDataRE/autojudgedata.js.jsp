<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	
	var DICT_201=[];
	
	$.ajax({
		url:"dict/code/201",
		type:"get",
		dataType:"json",
		async:false,
		success:function(data){
			log(data);
			DICT_201=data;
		}
	});
	
	/**
	 *加载js后将数据查询出来并赋值
	 */
	$(function() {
		var searchBy = "curing/baseData/autoJudgeDataRE/searchBy";
		ext.ajax.sendJson(searchBy, {},
				function(data) {
					for (var i = 0; i < data.length; i++) {
						console.log(data[i].CREATED_BY_S);
						if (data[i].PLC_POINTDESC_S == "热板温度") {
							if (data[i].ALARM_DEAL_CODE_S == "EMC1011") {
								$("#EMC1011l").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC1011_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC1012") {
								$("#EMC1012a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC1012b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC1012_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC1013") {
								$("#EMC1013p").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC1013_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC1021") {
								$("#EMC1021l").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC1021_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC1024") {
								$("#EMC1024a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC1024b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC1024_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							$("#rbTime").textbox('setValue',data[i].VALID_DELAY_S);
						}
						
						
						
						if (data[i].PLC_POINTDESC_S == "热环温度") {
							if (data[i].ALARM_DEAL_CODE_S == "EMC2012") {
								$("#EMC2012l").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC2012_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC2013") {
								$("#EMC2013a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC2013b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC2013_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC2014") {
								$("#EMC2014p").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC2014_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC2021") {
								$("#EMC2021a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC2021b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC2021_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC2022") {
								$("#EMC2022l").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC2022_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							$("#rhTime").textbox('setValue',data[i].VALID_DELAY_S);
						}
						if (data[i].PLC_POINTDESC_S == "内压温度") {
							if (data[i].ALARM_DEAL_CODE_S == "EMC3011") {
								$("#EMC3011t").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC3011a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC3011b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC3011_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);

							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC3012") {
								$("#EMC3012p").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC3012_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC3013") {
								$("#EMC3013a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC3013b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC3013_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC3014") {
								$("#EMC3014p").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC3014_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC3015") {
								$("#EMC3015a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC3015b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC3015_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC3016") {
								$("#EMC3016l").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC3016_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							$("#nwTime").textbox('setValue',data[i].VALID_DELAY_S);

						}
						if (data[i].PLC_POINTDESC_S == "内压压力") {
							//步骤2
							if (data[i].ALARM_DEAL_CODE_S == "EMC4021") {
								$("#EMC4021t").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4021a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4021b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4021_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4022") {
								$("#EMC4022p").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4022_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4023") {
								$("#EMC4023a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4023b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4023_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4024") {
								$("#EMC4024p").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4024_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4025") {
								$("#EMC4025l").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4025_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}

							//步骤3
							if (data[i].ALARM_DEAL_CODE_S == "EMC4030") {
								$("#EMC4030t").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4030a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4030b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4030_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4031") {
								$("#EMC4031p").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4031_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4032") {
								$("#EMC4032a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4032b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4032_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4033") {
								$("#EMC4033p").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4033_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4034") {
								$("#EMC4034l").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4034_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}

							//步骤4
							if (data[i].ALARM_DEAL_CODE_S == "EMC4040") {
								$("#EMC4040t").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4040a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4040b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4040_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4041") {
								$("#EMC4041p").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4041_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4042") {
								$("#EMC4042a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4042b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4042_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4043") {
								$("#EMC4043p").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4043_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4044") {
								$("#EMC4044l").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4044_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							//步骤5
							if (data[i].ALARM_DEAL_CODE_S == "EMC4050") {
								$("#EMC4050t").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4050a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4050b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4050_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4051") {
								$("#EMC4051p").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4051_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4052") {
								$("#EMC4052a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4052b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4052_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4053") {
								$("#EMC4053p").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4053_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4054") {
								$("#EMC4054l").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4054_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							//步骤6
							if (data[i].ALARM_DEAL_CODE_S == "EMC4060") {
								$("#EMC4060t").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4060a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4060b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4060_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4063") {
								$("#EMC4063p").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4063_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4064") {
								$("#EMC4064a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4064b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4064_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4065") {
								$("#EMC4065p").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4065_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4066") {
								$("#EMC4066l").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4066_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							//步骤6压差
							if (data[i].ALARM_DEAL_CODE_S == "EMC4061") {
								$("#EMC4061l").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4061_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4062") {
								$("#EMC4062l").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4062_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							//步骤7
							if (data[i].ALARM_DEAL_CODE_S == "EMC4070") {
								$("#EMC4070t").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4070a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4070b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4070_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4071") {
								$("#EMC4071p").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4071_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4072") {
								$("#EMC4072a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4072b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4072_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4073") {
								$("#EMC4073p").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4073_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4074") {
								$("#EMC4074l").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4074_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}

							//步骤8
							if (data[i].ALARM_DEAL_CODE_S == "EMC4081") {
								$("#EMC4081t").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4081a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4081b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4081_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4082") {
								$("#EMC4082p").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4082_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4083") {
								$("#EMC4083a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4083b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4083_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4084") {
								$("#EMC4084p").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4084_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							//步骤9
							if (data[i].ALARM_DEAL_CODE_S == "EMC4091") {
								$("#EMC4091t").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4091a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4091b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4091_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4092") {
								$("#EMC4092p").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4092_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4093") {
								$("#EMC4093a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4093b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4093_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4094") {
								$("#EMC4094p").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4094_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							//步骤10
							if (data[i].ALARM_DEAL_CODE_S == "EMC4101") {
								$("#EMC4101t").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4101a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4101b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4101_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4092") {
								$("#EMC4102p").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4102_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4103") {
								$("#EMC4103a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4103b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4103_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4104") {
								$("#EMC4104p").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4104_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}

							$("#nyTime").textbox('setValue',data[i].VALID_DELAY_S);
						}
					}
				});

	})

	/**
	 *数据字典传值
	 *
	 */
	function codeFormatter(v, r, i) {

		return dictFormat(v);
	}

	var saveChanges = path+"curing/baseData/autoJudgeDataRE/updateRb";

	function save() {
		
		var whether =nons();
		if(whether){
			rbFunction();
			rhFunction();
			nywFunction();
			nyyFunction(); 	
			ext.tip.suc("<spring:message code="tip.success" />");
		}
	}
	
	/**
	*
	*热板温度
	*/
	function rbFunction(){
		
		var rbDiv = document.getElementById("rbDiv");
		var rbDivinputs = rbDiv.getElementsByTagName('input');
		
		var rbtn = [];
		var rbtnvalue = [];
		for (var i = 0; i < rbDivinputs.length; i++) {
			//判断
			if (rbDivinputs[i].id.indexOf("EMC") != -1 || rbDivinputs[i].id.indexOf("Time") != -1) {
				rbtn[rbtn.length] = rbDivinputs[i].id;
			}
		}
		
		for (var j = 0; j < rbtn.length; j++) {
			rbtnvalue[j] = document.getElementById(rbtn[j]).value;
		}
		var list_map = new Array();
		var pair={};
		for (var h=0; h< rbtnvalue.length; h++) {
			pair[rbtn[h]]=rbtnvalue[h];
			list_map.push(pair);
		}
		list_map.push({DIV:"rbDiv"});
		ext.ajax.sendJson(saveChanges, list_map, function(data) {

		});
		return list_map;
	}
	/**
	*
	*热环温度
	*/
	function rhFunction(){
		
		var rhDiv = document.getElementById("rhDiv");
		var rhDivinputs = rhDiv.getElementsByTagName('input');
		
		var rhtn = [];
		var rhtnvalue = [];
		for (var i = 0; i < rhDivinputs.length; i++) {
			//判断
			if (rhDivinputs[i].id.indexOf("EMC") != -1|| rhDivinputs[i].id.indexOf("Time") != -1) {
				rhtn[rhtn.length] = rhDivinputs[i].id;
			}
		}
		for (var j = 0; j < rhtn.length; j++) {
			rhtnvalue[j] = document.getElementById(rhtn[j]).value;
		}
		var list_map = new Array();
		var pair={};
		for (var h=0; h < rhtnvalue.length; h++) {
			pair[rhtn[h]]=rhtnvalue[h];
			list_map.push(pair);
		}
		list_map.push({DIV:"rhDiv"});
		ext.ajax.sendJson(saveChanges, list_map, function(data) {

		});
		return list_map;
	}
	/**
	*
	*内压温度
	*/
	function nywFunction(){
		
		var rDiv = document.getElementById("nywDiv");
		var rDivinputs = rDiv.getElementsByTagName('input');
		var rtn = [];
		var rtnvalue = [];
		for (var i = 0; i < rDivinputs.length; i++) {
			//判断
			if (rDivinputs[i].id.indexOf("EMC") != -1|| rDivinputs[i].id.indexOf("Time") != -1) {
				rtn[rtn.length] = rDivinputs[i].id;
			}
		}
		for (var j = 0; j < rtn.length; j++) {
			rtnvalue[j] = document.getElementById(rtn[j]).value;
		}
		
		var list_map = new Array();
		var pair={};
		for (var h=0; h < rtnvalue.length; h++) {
			pair[rtn[h]]=rtnvalue[h];
			list_map.push(pair);
		}
		list_map.push({DIV:"nywDiv"});
		ext.ajax.sendJson(saveChanges, list_map, function(data) {
		});
		return list_map;
	}
	/**
	*
	*内压压力
	*/
	function nyyFunction(){
		
		var rDiv = document.getElementById("nyyDiv");
		var rDivinputs = rDiv.getElementsByTagName('input');
		var rtn = [];
		var rtnvalue = [];
		for (var i = 0; i < rDivinputs.length; i++) {
			//判断
			if (rDivinputs[i].id.indexOf("EMC") != -1|| rDivinputs[i].id.indexOf("Time") != -1) {
				rtn[rtn.length] = rDivinputs[i].id;
			}
		}
		for (var j = 0; j < rtn.length; j++) {
			rtnvalue[j] = document.getElementById(rtn[j]).value;
		}
		
		var list_map = new Array();
		var pair={};
		for (var h=0; h < rtnvalue.length; h++) {
			pair[rtn[h]]=rtnvalue[h];
			list_map.push(pair);
		}
		list_map.push({DIV:"nyyDiv"});
		ext.ajax.sendJson(saveChanges, list_map, function(data) {
		});
		return list_map;
	}
	
	function nons(){
		var aKey=[]; 
		var bKey=[];
		var controls = document.getElementsByTagName('input');
		var j=0;
		var l=0;
		for (var i = 0; i < controls.length; i++) {
			//判断
			if (controls[i].id.indexOf("EMC") != -1) {
				if(controls[i].id.indexOf("a") != -1){
					var keya =controls[i].id;
					aKey[j]=controls[i].id;
					j++;
				}
				if(controls[i].id.indexOf("b") != -1){
					var keyb =controls[i].id;
					bKey[l]=controls[i].id;
					l++;
				}
			}
		}
		
		var p=0;
		for(var k =0;k<aKey.length;k++){
			var a =aKey[k].substr(0,7);
			for(var h=0;h<bKey.length;h++){
				var b =bKey[h].substr(0,7);
				if(a!=b){
				}else{
					var ak = $("#"+aKey[k]).textbox("getValue");
					var bh = $("#"+bKey[h]).textbox("getValue");
					if(ak>bh){
						log(ak);
						p++;
					}
				}
			}
		}
		if(p!=0){
			ext.tip.error("<spring:message code="tip.abKey" />");
			return false;
		}else{
			return true;
		}
	}
	
	
	var defaultNum="";
	//获取焦点事件
	function jjks(event){
		var e=window.event;  
		var obj=e.srcElement;  
		var num=obj.value;
		defaultNum=num;
	}
	//失去焦点事件
	function ischeckNum(event){
		var e=window.event;  
		var obj=e.srcElement;  
		var num=obj.value;
    	var id=e.target.id;
		log(num);
		var regu = /^(\-|\+)?\d+(\.\d+)?$/;
        if (num != "") {
             if (!regu.test(num)) {
            	 ext.tip.error("<spring:message code="tip.abKey" />");
            	 $("#"+id).val(defaultNum);
             } 
         }else{
        	 return true;
         }
	}
</script>