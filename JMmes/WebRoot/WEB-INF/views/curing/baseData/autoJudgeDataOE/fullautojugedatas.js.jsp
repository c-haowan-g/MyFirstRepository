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
		var searchBy = "curing/baseData/autoJudgeDataOE/searchByREorOE?type=OE";
		ext.ajax.sendJson(searchBy, {},
				function(data) {
					for (var i = 0; i < data.length; i++) {
						console.log(data[i].CREATED_BY_S);
						if (data[i].PLC_POINTDESC_S == "热板温度") {
							if (data[i].ALARM_DEAL_CODE_S == "EMC1011") {
								$("#EMC1011a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC1011b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC1011rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC1011_JUDGE_1011").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC1012") {
								$("#EMC1012a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC1012b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC1012rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC1012_JUDGE_1012").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC1013") {
								$("#EMC1013a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC1013b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC1013rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC1013_JUDGE_1013").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC1014") {
								$("#EMC1014a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC1014b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC1014rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC1014_JUDGE_1014").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC1015") {
								$("#EMC1015a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC1015b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC1015rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC1015_JUDGE_1015").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
						}
						
						if (data[i].PLC_POINTDESC_S == "热环温度") {
							if (data[i].ALARM_DEAL_CODE_S == "EMC2012") {
								$("#EMC2012a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC2012b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC2012rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC2012_JUDGE_2012").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC2013") {
								$("#EMC2013a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC2013b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC2013rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC2013_JUDGE_2013").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC2014") {
								$("#EMC2014a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC2014b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC2014rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC2014_JUDGE_2014").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC2015") {
								$("#EMC2015a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC2015b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC2015rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC2015_JUDGE_2015").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC2016") {
								$("#EMC2016a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC2016b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC2016rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC2016_JUDGE_2016").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
						}
						
						if (data[i].PLC_POINTDESC_S == "内压温度") {
							if (data[i].ALARM_DEAL_CODE_S == "EMC3011") {
								$("#EMC3011rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC3011a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC3011b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC3011_JUDGE_3011").combotree('setValue',data[i].JUDGE_LEVER_S);
								$("#EMC3011yc").textbox('setValue',data[i].VALUE_TWO_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC3012") {
								$("#EMC3012rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC3012a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC3012b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC3012_JUDGE_3012").combotree('setValue',data[i].JUDGE_LEVER_S);
								$("#EMC3011yc").textbox('setValue',data[i].VALUE_TWO_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC3013") {
								$("#EMC3013rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC3013a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC3013b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC3013_JUDGE_3013").combotree('setValue',data[i].JUDGE_LEVER_S);
								$("#EMC3011yc").textbox('setValue',data[i].VALUE_TWO_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC3014") {
								$("#EMC3014rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC3014a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC3014b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC3014_JUDGE_3014").combotree('setValue',data[i].JUDGE_LEVER_S);
								$("#EMC3011yc").textbox('setValue',data[i].VALUE_TWO_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC3015") {
								$("#EMC3015rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC3015a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC3015b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC3015_JUDGE_3015").combotree('setValue',data[i].JUDGE_LEVER_S);
								$("#EMC3011yc").textbox('setValue',data[i].VALUE_TWO_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC3016") {
								$("#EMC3016rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC3016a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC3016b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC3016_JUDGE_3016").combotree('setValue',data[i].JUDGE_LEVER_S);
								$("#EMC3011yc").textbox('setValue',data[i].VALUE_TWO_S);
							}
						}
						if (data[i].PLC_POINTDESC_S == "内压压力") {
							//步骤2-6
							if (data[i].ALARM_DEAL_CODE_S == "EMC4011") {
								$("#EMC4011rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4011a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4011b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4011_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
								$("#EMC4011yc").textbox('setValue',data[i].VALUE_TWO_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4012") {
								$("#EMC4012rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4012a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4012b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4012_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
								$("#EMC4011yc").textbox('setValue',data[i].VALUE_TWO_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4013") {
								$("#EMC4013rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4013a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4013b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4013_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
								$("#EMC4011yc").textbox('setValue',data[i].VALUE_TWO_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4014") {
								$("#EMC4014rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4014a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4014b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4014_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
								$("#EMC4011yc").textbox('setValue',data[i].VALUE_TWO_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4015") {
								$("#EMC4015rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4015a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4015b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4015_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
								$("#EMC4011yc").textbox('setValue',data[i].VALUE_TWO_S);
							}
							//步骤2
							if (data[i].ALARM_DEAL_CODE_S == "EMC4021") {
								$("#EMC4021rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4021a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4021b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4021_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
								$("#EMC4021yc").textbox('setValue',data[i].VALUE_TWO_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4022") {
								$("#EMC4022rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4022a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4022b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4022_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
								$("#EMC4021yc").textbox('setValue',data[i].VALUE_TWO_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4023") {
								$("#EMC4023rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4023a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4023b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4023_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
								$("#EMC4021yc").textbox('setValue',data[i].VALUE_TWO_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4024") {
								$("#EMC4024rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4024a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4024b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4024_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
								$("#EMC4021yc").textbox('setValue',data[i].VALUE_TWO_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4025") {
								$("#EMC4025rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4025a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4025b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4025_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
								$("#EMC4021yc").textbox('setValue',data[i].VALUE_TWO_S);
							}

							//步骤3
							if (data[i].ALARM_DEAL_CODE_S == "EMC4030") {
								$("#EMC4030rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4030a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4030b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4030_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
								$("#EMC4031yc").textbox('setValue',data[i].VALUE_TWO_S);
								
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4031") {
								$("#EMC4031rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4031a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4031b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4031_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
								$("#EMC4031yc").textbox('setValue',data[i].VALUE_TWO_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4032") {
								$("#EMC4032rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4032a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4032b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4032_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
								$("#EMC4031yc").textbox('setValue',data[i].VALUE_TWO_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4033") {
								$("#EMC4033rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4033a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4033b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4033_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
								$("#EMC4031yc").textbox('setValue',data[i].VALUE_TWO_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4034") {
								$("#EMC4034rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4034a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4034b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4034_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
								$("#EMC4031yc").textbox('setValue',data[i].VALUE_TWO_S);
							}

							//步骤4
							if (data[i].ALARM_DEAL_CODE_S == "EMC4040") {
								$("#EMC4040rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4041yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4040a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4040b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4040_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4041") {
								$("#EMC4041rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4041yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4041a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4041b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4041_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4042") {
								$("#EMC4042rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4041yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4042a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4042b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4042_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4043") {
								$("#EMC4043rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4041yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4043a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4043b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4043_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4044") {
								$("#EMC4044rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4041yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4044a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4044b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4044_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							//步骤5
							if (data[i].ALARM_DEAL_CODE_S == "EMC4050") {
								$("#EMC4050rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4051yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4050a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4050b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4050_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4051") {
								$("#EMC4051rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4051yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4051a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4051b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4051_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4052") {
								$("#EMC4052rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4051yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4052a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4052b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4052_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4053") {
								$("#EMC4053rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4051yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4053a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4053b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4053_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4054") {
								$("#EMC4054rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4051yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4054a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4054b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4054_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							//步骤6
							if (data[i].ALARM_DEAL_CODE_S == "EMC4060") {
								$("#EMC4060rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4061yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4060a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4060b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4060_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4061") {
								$("#EMC4061rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4061yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4061a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4061b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4061_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4062") {
								$("#EMC4062rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4061yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4062a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4062b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4062_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4063") {
								$("#EMC4063rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4061yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4063a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4063b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4063_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4064") {
								$("#EMC4064rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4061yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4064a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4064b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4064_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							//步骤7-11
							if (data[i].ALARM_DEAL_CODE_S == "EMC4711") {
								$("#EMC4711rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4711yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4711a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4711b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4711_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4712") {
								$("#EMC4712rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4711yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4712a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4712b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4712_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4713") {
								$("#EMC4713rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4711yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4713a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4713b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4713_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4714") {
								$("#EMC4714rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4711yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4714a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4714b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4714_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4715") {
								$("#EMC4715rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4711yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4715a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4715b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4715_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							//步骤7
							if (data[i].ALARM_DEAL_CODE_S == "EMC4070") {
								$("#EMC4070rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4071yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4070a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4070b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4070_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4071") {
								$("#EMC4071rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4071yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4071a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4071b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4071_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4072") {
								$("#EMC4072rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4071yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4072a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4072b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4072_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4073") {
								$("#EMC4073rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4071yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4073a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4073b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4073_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4074") {
								$("#EMC4074rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4071yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4074a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4074b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4074_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}

							//步骤8
							if (data[i].ALARM_DEAL_CODE_S == "EMC4081") {
								$("#EMC4081rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4081yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4081a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4081b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4081_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4082") {
								$("#EMC4082rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4081yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4082a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4082b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4082_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4083") {
								$("#EMC4083rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4081yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4083a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4083b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4083_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4084") {
								$("#EMC4084rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4081yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4084a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4084b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4084_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							//步骤9
							if (data[i].ALARM_DEAL_CODE_S == "EMC4091") {
								$("#EMC4091rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4091yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4091a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4091b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4091_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4092") {
								$("#EMC4092rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4091yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4092a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4092b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4092_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4093") {
								$("#EMC4093rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4091yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4093a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4093b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4093_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4094") {
								$("#EMC4094rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4091yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4094a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4094b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4094_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							
							//步骤10
							if (data[i].ALARM_DEAL_CODE_S == "EMC4101") {
								$("#EMC4101rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4101yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4101a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4101b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4101_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4102") {
								$("#EMC4102rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4101yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4102a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4102b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4102_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4103") {
								$("#EMC4103rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4101yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4103a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4103b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4103_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4104") {
								$("#EMC4104rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4101yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4104a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4104b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4104_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							//压差
							if (data[i].ALARM_DEAL_CODE_S == "EMC4105") {
								$("#EMC4105l").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4105_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4106") {
								$("#EMC4106l").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4106_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							
							
							//步骤11
							if (data[i].ALARM_DEAL_CODE_S == "EMC4111") {
								$("#EMC4111rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4111yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4111a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4111b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4111_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4112") {
								$("#EMC4112rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4111yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4112a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4112b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4112_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4113") {
								$("#EMC4113rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4111yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4113a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4113b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4113_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4114") {
								$("#EMC4114rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4111yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4114a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4114b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4114_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							//步骤12
							if (data[i].ALARM_DEAL_CODE_S == "EMC4121") {
								$("#EMC4121rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4121yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4121a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4121b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4121_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4122") {
								$("#EMC4122rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4121yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4122a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4122b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4122_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4123") {
								$("#EMC4123rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4121yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4123a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4123b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4123_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4124") {
								$("#EMC4124rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4121yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4124a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4124b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4124_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							//步骤13
							if (data[i].ALARM_DEAL_CODE_S == "EMC4131") {
								$("#EMC4131rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4131yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4131a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4131b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4131_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4132") {
								$("#EMC4132rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4131yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4132a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4132b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4132_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4133") {
								$("#EMC4133rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4131yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4133a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4133b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4133_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4134") {
								$("#EMC4134rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4131yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4134a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4134b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4134_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							//步骤14
							if (data[i].ALARM_DEAL_CODE_S == "EMC4141") {
								$("#EMC4141rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4141yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4141a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4141b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4141_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4142") {
								$("#EMC4142rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4141yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4142a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4142b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4142_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4143") {
								$("#EMC4143rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4141yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4143a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4143b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4143_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4144") {
								$("#EMC4144rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4141yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4144a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4144b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4144_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							//步骤15
							if (data[i].ALARM_DEAL_CODE_S == "EMC4151") {
								$("#EMC4151rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4151yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4151a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4151b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4151_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4152") {
								$("#EMC4152rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4151yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4152a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4152b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4152_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4153") {
								$("#EMC4153rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4151yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4153a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4153b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4153_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
							if (data[i].ALARM_DEAL_CODE_S == "EMC4154") {
								$("#EMC4154rTime").textbox('setValue',data[i].VALID_DELAY_S);
								$("#EMC4151yc").textbox('setValue',data[i].VALUE_TWO_S);
								$("#EMC4154a").textbox('setValue',data[i].LIMIT_LOWER_S);
								$("#EMC4154b").textbox('setValue',data[i].LIMIT_UPPER_S);
								$("#EMC4154_JUDGE").combotree('setValue',data[i].JUDGE_LEVER_S);
							}
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

	var saveChanges = path+"curing/baseData/autoJudgeDataOE/updateQRb?type=OE";

	function save() {
		var whether =nons();
		if(whether){
			rbFunction();
			rhFunction();
			nywFunction();
			nyyFunction(); 	
		}
		ext.tip.suc("<spring:message code="tip.success" />");
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
		debugger;
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
			ext.tip.suc("<spring:message code="tip.success" />");
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
					var ak =$("#"+aKey[k]).textbox("getValue");
					var bh =$("#"+bKey[h]).textbox("getValue");
					if(ak==""&&bh!=""){
						continue;
					}else if(ak!=""&&bh==""){
						continue;
					}else if(ak*10>bh*10&&bh!=""){
					//if(ak>bh&&bh!=""){
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