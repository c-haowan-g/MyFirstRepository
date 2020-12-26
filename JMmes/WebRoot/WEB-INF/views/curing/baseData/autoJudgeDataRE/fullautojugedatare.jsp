<!-- 

    作者      :李迺锟
    时间      :2018-09-28 08:03:29 
    页面名称:硫化报警参数（零售）
    文件关联:/mes/WebRoot/WEB-INF/views/lh/jcgl/lhbjcs/fullautojugedatare.jsp
        AutoJudgeData.java
        AutoJudgeDataController.java
        AutoJudgeDataServiceImpl.java
        AutoJudgeDataServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="fullautojugedatare.js.jsp"%>
<script type="text/javascript" src="dict/201.js"></script>
<body class="easyui-layout" fit="true">
		<div  data-options="region:'north',split:true,border:false"   style="height:8%"id="AutoJudgeData_dg_toolbar">
			<auth:button code="autojudgedata.save">
				<a class="easyui-linkbutton btn-blue"
					data-options="iconCls:'icon-save'" onclick="save()"><spring:message
						code="button.save" /></a>
			</auth:button>
		</div>
	<div data-options="region:'center',split:true,border:false" style="height:92%">
		<div style="float:left;height:40%;width:50%" id="rbDiv">
			<fieldset style="height:100%;margin: 0 1 0 1;padding: 0 1 0 1">
				<legend>热板温度  </legend>
				<table style="width:100%;margin: 0 0 0 0;padding: 0 0 0 0">
					<tr><td>测量值差值(低)度</td><td>测量值差值(高)度</td><td>持续时间(秒)</td><td>报警处置</td></tr>
					<tr>
						<td><input type="text" id="EMC1011a"  style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC1011b" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC1011rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC1011_JUDGE_1011"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC1012a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC1012b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC1012rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC1012_JUDGE_1012"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC1013a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC1013b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC1013rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC1013_JUDGE_1013"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC1014a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC1014b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC1014rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC1014_JUDGE_1014"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC1015a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC1015b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC1015rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC1015_JUDGE_1015"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
				</table>
			</fieldset>
		</div>
		<div style="float:left;height:40%;width:50%" id="rhDiv">
			<fieldset style="height:100%;" >
				<legend>热环温度 </legend>
					<table style="width:100%;margin: 0 0 0 0;padding: 0 0 0 0">
					<tr><td>测量值差值(低)度</td><td>测量值差值(高)度</td><td>持续时间(秒)</td><td>报警处置</td></tr>
					<tr>
						<td><input type="text" id="EMC2012a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC2012b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC2012rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC2012_JUDGE_2012"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC2013a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC2013b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC2013rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC2013_JUDGE_2013"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC2014a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC2014b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC2014rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC2014_JUDGE_2014"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC2015a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC2015b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC2015rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC2015_JUDGE_2015"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC2016a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC2016b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC2016rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC2016_JUDGE_2016"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
				</table>
			</fieldset>
		</div>
		<div style="float:left;height:46%;width:50%;padding:20px 0 0 0 " id="nywDiv">
			<fieldset style="height:100%;" >
				<legend>内压温度  步序2开始:<input type="text" id="EMC3011yc" style="width:80px" class="easyui-textbox" data-options="" >S后</legend>
				<table style="word-wrap: break-word; word-break: break-all;">
					<tr><td>测量值(低)度</td><td>测量值(高)度</td><td>持续时间(秒)</td><td>报警处置</td></tr>
					<tr>
						<td><input type="text" id="EMC3011a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC3011b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC3011rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC3011_JUDGE_3011"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC3012a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC3012b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC3012rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC3012_JUDGE_3012"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC3013a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC3013b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC3013rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC3013_JUDGE_3013"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC3014a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC3014b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC3014rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC3014_JUDGE_3014"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC3015a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC3015b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC3015rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC3015_JUDGE_3015"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC3016a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC3016b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC3016rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC3016_JUDGE_3016"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
			    </table>
				
				
			</fieldset>
		</div>
		<div style="float:left;height:350%;width:100%;padding:20px 0 0 0 " id="nyyDiv" >
			<fieldset style="height:100%;" >
				<legend>内压压力 步序2到步序6开始:<input type="text" id="EMC4011yc" style="width:80px" class="easyui-textbox" data-options="" >S后</legend>
						<table style="width:50%">
						<tr><td>测量值(低)MPA</td><td>测量值(高)MPA</td><td>持续时间(秒)</td><td>报警处置</td></tr>
						<tr>
							<td><input type="text" id="EMC4011a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
							<td><input type="text" id="EMC4011b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
							<td><input type="text" id="EMC4011rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
							<td><input  id="EMC4011_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:200,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
						</tr>
						<tr>
							<td><input type="text" id="EMC4012a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
							<td><input type="text" id="EMC4012b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
							<td><input type="text" id="EMC4012rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
							<td><input  id="EMC4012_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:200,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
						</tr>
						<tr>
							<td><input type="text" id="EMC4013a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
							<td><input type="text" id="EMC4013b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
							<td><input type="text" id="EMC4013rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
							<td><input  id="EMC4013_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:200,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
						</tr>
						<tr>
							<td><input type="text" id="EMC4014a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
							<td><input type="text" id="EMC4014b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
							<td><input type="text" id="EMC4014rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
							<td><input  id="EMC4014_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:200,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
						</tr>
						<tr>
							<td><input type="text" id="EMC4015a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
							<td><input type="text" id="EMC4015b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
							<td><input type="text" id="EMC4015rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
							<td><input  id="EMC4015_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:200,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
						</tr>
					</table>
				<legend>内压压力 步序2开始:<input type="text" id="EMC4021yc" style="width:80px" class="easyui-textbox" data-options="" >S后</legend>
					<table style="width:50%">
					<tr><td>测量值(低)MPA</td><td>测量值(高)MPA</td><td>持续时间(秒)</td><td>报警处置</td></tr>
					<tr>
						<td><input type="text" id="EMC4021a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4021b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4021rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4021_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4022a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4022b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4022rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4022_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4023a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4023b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4023rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4023_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4024a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4024b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4024rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4024_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4025a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4025b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4025rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4025_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
				</table>
			<legend>内压压力  步序3开始:<input type="text" id="EMC4031yc" style="width:80px" class="easyui-textbox" data-options="" >S后</legend>
					<table style="width:50%">
					<tr><td>测量值(低)MPA</td><td>测量值(高)MPA</td><td>持续时间(秒)</td><td>报警处置</td></tr>
					<tr>
						<td><input type="text" id="EMC4030a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4030b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4030rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4030_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4031a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4031b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4031rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4031_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4032a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4032b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4032rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4032_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4033a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4033a" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4033rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4033_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4034a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4034b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4034rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4034_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
				</table>
				<legend>内压压力 步序4开始:<input type="text" id="EMC4041yc" style="width:80px" class="easyui-textbox" data-options="" >S后</legend>
					<table style="width:50%">
					<tr><td>测量值(低)MPA</td><td>测量值(高)MPA</td><td>持续时间(秒)</td><td>报警处置</td></tr>
					<tr>
						<td><input type="text" id="EMC4040a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4040b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4040rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4040_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4041a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4041b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4041rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4041_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4042a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4042b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4042rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4042_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4043a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4043b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4043rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4043_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4044a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4044b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4044rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4044_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
				</table>
				<legend>内压压力  步序5开始:<input type="text" id="EMC4051yc" style="width:80px" class="easyui-textbox" data-options="" >S后</legend>
						<table style="width:50%">
					<tr><td>测量值(低)MPA</td><td>测量值(高)MPA</td><td>持续时间(秒)</td><td>报警处置</td></tr>
					<tr>
						<td><input type="text" id="EMC4050a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4050b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4050rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4050_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4051a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4051b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4051rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4051_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4052a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4052b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4052rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4052_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4053a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4053b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4053rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4053_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4054a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4054b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4054rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4054_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
				</table>
				<legend>内压压力 步序6开始:<input type="text" id="EMC4061yc" style="width:80px" class="easyui-textbox" data-options="" >S后</legend>
					<table style="width:50%">
					<tr><td>测量值(低)MPA</td><td>测量值(高)MPA</td><td>持续时间(秒)</td><td>报警处置</td></tr>
					<tr>
						<td><input type="text" id="EMC4060a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4060b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4060rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4060_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4061a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4061b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4061rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4061_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4062a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4062b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4062rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4062_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4063a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4063b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4063rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4063_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4064a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4064b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4064rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4064_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
				</table>
				<legend>内压压力 步序7到步序11开始:<input type="text" id="EMC4711yc" style="width:80px" class="easyui-textbox" data-options="" >S后</legend>
						<table style="width:50%">
						<tr><td>测量值(低)MPA</td><td>测量值(高)MPA</td><td>持续时间(秒)</td><td>报警处置</td></tr>
						<tr>
							<td><input type="text" id="EMC4711a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
							<td><input type="text" id="EMC4711b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
							<td><input type="text" id="EMC4711rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
							<td><input  id="EMC4711_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:200,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
						</tr>
						<tr>
							<td><input type="text" id="EMC4712a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
							<td><input type="text" id="EMC4712b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
							<td><input type="text" id="EMC4712rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
							<td><input  id="EMC4712_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:200,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
						</tr>
						<tr>
							<td><input type="text" id="EMC4713a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
							<td><input type="text" id="EMC4713b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
							<td><input type="text" id="EMC4713rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
							<td><input  id="EMC4713_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:200,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
						</tr>
						<tr>
							<td><input type="text" id="EMC4714a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
							<td><input type="text" id="EMC4714b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
							<td><input type="text" id="EMC4714rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
							<td><input  id="EMC4714_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:200,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
						</tr>
						<tr>
							<td><input type="text" id="EMC4715a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
							<td><input type="text" id="EMC4715b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
							<td><input type="text" id="EMC4715rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
							<td><input  id="EMC4715_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:200,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
						</tr>
					</table>
				<legend>内压压力  步序7开始:<input type="text" id="EMC4071yc" style="width:80px" class="easyui-textbox" data-options="" >S后</legend>
						<table style="width:50%">
					<tr><td>测量值(低)MPA</td><td>测量值(高)MPA</td><td>持续时间(秒)</td><td>报警处置</td></tr>
					<tr>
						<td><input type="text" id="EMC4070a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4070b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4070rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4070_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4071a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4071b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4071rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4071_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4072a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4072b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4072rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4072_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4073a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4073b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4073rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4073_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4074a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4074b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4074rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4074_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
				</table>
				<legend>内压压力  步序8开始:<input type="text" id="EMC4081yc" style="width:80px" class="easyui-textbox" data-options="" >S后</legend>
						<table style="width:50%">
					<tr><td>测量值(低)MPA</td><td>测量值(高)MPA</td><td>持续时间(秒)</td><td>报警处置</td></tr>
					<tr>
						<td><input type="text" id="EMC4081a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4081b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4081rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4081_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4082a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4082b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4082rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4082_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4083a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4083b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4083rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4083_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4084a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4084b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4084rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4084_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
				</table>
				<legend>内压压力  步序9开始:<input type="text" id="EMC4091yc" style="width:80px" class="easyui-textbox" data-options="" >S后</legend>
						<table style="width:50%">
					<tr><td>测量值(低)MPA</td><td>测量值(高)MPA</td><td>持续时间(秒)</td><td>报警处置</td></tr>
					<tr>
						<td><input type="text" id="EMC4091a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4091b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4091rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4091_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4092a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4092b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4092rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4092_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4093a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4093b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4093rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4093_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4094a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4094b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4094rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4094_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
				</table>
				<legend>内压压力  步序10开始:<input type="text" id="EMC4101yc" style="width:80px" class="easyui-textbox" data-options="" >S后</legend>
						<table style="width:50%">
					<tr><td>测量值(低)MPA</td><td>测量值(高)MPA</td><td>持续时间(秒)</td><td>报警处置</td></tr>
					<tr>
						<td><input type="text" id="EMC4101a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4101b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4101rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4101_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4102a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4102b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4102rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4102_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4103a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4103b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4103rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4103_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4104a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4104b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4104rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4104_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td>压差</td>
						<td style="width:110px"><input type="text" id="EMC4105l" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td style="width:110px">MPA以上</td>
						<td><input  id="EMC4105_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
						  panelHeight:200,
						  required:false,
						  data:DICT_201,
						  method:'get'" ></td>
						<td style="width:110px"><input type="text" id="EMC4106l" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td style="width:130px">MPA以上</td>
						<td><input  id="EMC4106_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
						  panelHeight:200,
						  required:false,
						  data:DICT_201,
						  method:'get'" ></td>
					</tr>
				</table>
				<legend>内压压力  步序11开始:<input type="text" id="EMC4111yc" style="width:80px" class="easyui-textbox" data-options="" >S后</legend>
				<table style="width:50%">
					<tr><td>测量值(低)MPA</td><td>测量值(高)MPA</td><td>持续时间(秒)</td><td>报警处置</td></tr>
					<tr>
						<td><input type="text" id="EMC4111a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4111b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4111rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4111_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4112a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4112b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4112rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4112_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4113a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4113b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4113rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4113_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4114a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4114b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4114rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4114_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
				</table>
				<legend>内压压力  步序12开始:<input type="text" id="EMC4121yc" style="width:80px" class="easyui-textbox" data-options="" >S后</legend>
				<table style="width:50%">
					<tr><td>测量值(低)MPA</td><td>测量值(高)MPA</td><td>持续时间(秒)</td><td>报警处置</td></tr>
					<tr>
						<td><input type="text" id="EMC4121a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4121b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4121rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4121_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4122a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4122b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4122rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4122_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4123a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4123b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4123rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4123_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4124a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4124b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4124rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4124_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
				</table>
				<legend>内压压力  步序13开始:<input type="text" id="EMC4131yc" style="width:80px" class="easyui-textbox" data-options="" >S后</legend>
				<table style="width:50%">
					<tr><td>测量值(低)MPA</td><td>测量值(高)MPA</td><td>持续时间(秒)</td><td>报警处置</td></tr>
					<tr>
						<td><input type="text" id="EMC4131a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4131b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4131rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4131_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4132a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4132b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4132rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4132_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4133a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4133b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4133rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4133_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4134a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4134b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4134rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4134_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
				</table>
				<legend>内压压力  步序14开始:<input type="text" id="EMC4141yc" style="width:80px" class="easyui-textbox" data-options="" >S后</legend>
				<table style="width:50%">
					<tr><td>测量值(低)MPA</td><td>测量值(高)MPA</td><td>持续时间(秒)</td><td>报警处置</td></tr>
					<tr>
						<td><input type="text" id="EMC4141a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4141b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4141rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4141_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4142a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4142b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4142rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4142_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4143a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4143b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4143rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4143_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4144a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4144b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4144rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4144_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
				</table>
				<legend>内压压力  步序15开始:<input type="text" id="EMC4151yc" style="width:80px" class="easyui-textbox" data-options="" >S后</legend>
				<table style="width:50%">
					<tr><td>测量值(低)MPA</td><td>测量值(高)MPA</td><td>持续时间(秒)</td><td>报警处置</td></tr>
					<tr>
						<td><input type="text" id="EMC4151a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4151b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4151rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4151_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4152a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4152b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4152rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4152_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4153a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4153b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4153rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4153_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td><input type="text" id="EMC4154a" oldvalue='1' style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4154b" oldvalue='1'style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input type="text" id="EMC4154rTime" style="width:80px" class="easyui-textbox" data-options="" ></td>
						<td><input  id="EMC4154_JUDGE"   style=" margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:200,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
				</table>
			</fieldset>
		</div>
	
	</div>
</body>
	<style>
        table,table tr th, table tr td { border:1px solid #0094ff;width:100%;}
        table { line-height: 20px; text-align: center; border-collapse: collapse;}   
    </style>
</html>
