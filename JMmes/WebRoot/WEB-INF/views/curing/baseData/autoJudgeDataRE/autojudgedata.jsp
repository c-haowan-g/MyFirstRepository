<!-- 

    作者      :时永良
    时间      :2019年7月19日08:04:49
    页面名称:硫化报警参数（零售）
    文件关联:
        AutoJudgeData.java
        AutoJudgeDataController.java
        AutoJudgeDataServiceImpl.java
        AutoJudgeDataServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="autojudgedata.js.jsp"%>
<script type="text/javascript" src="dict/201.js"></script>
<body class="easyui-layout" fit="true">
<div  data-options="region:'north',split:true,border:false"   style="height:8%"id="AutoJudgeData_dg_toolbar">			<auth:button code="autojudgedatas.save">
				<a class="easyui-linkbutton btn-blue"
					data-options="iconCls:'icon-save'" onclick="save()"><spring:message
						code="button.save" /></a>
			</auth:button>
		</div>
	<div data-options="region:'center',split:true,border:false" style="height:92%">
		<div style="float:left;height:40%;width:50%" id="rbDiv">
			<fieldset style="height:100%;margin: 0 1 0 1;padding: 0 1 0 1">
				<legend>热板温度</legend>
				<table  style="width:100%;margin: 0 0 0 0;padding: 0 0 0 0">
					<tr><th style='width: 20%'>测量项</th><th colspan="4">测量值</th><th>报警处置</th></tr>
					<tr>
						<td style='width: 10%'>温度</td>
						<td style='width: 25%;align:left'><input style="width:80%;" type="text"  oldvalue='1' class="easyui-textbox" data-options="events:{blur:ischeckNum,focus:jjks}" id="EMC1011l"></td>
						<td style='width: 20%;'>高°C度以上</td>
						<td style='width: 25%;'></td>
						<td style='width: 20%;'></td>
						<td ><input  id="EMC1011_JUDGE" style=" height: 25px;width:130px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:150,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td style='width: 20%'></td>
						<td style='width: 25%;align:left'><input style="width:80%;" type="text" class="easyui-textbox" data-options="events:{blur:ischeckNum,focus:jjks}" id="EMC1012a"></td>
						<td style='width: 20%;'>(低低)</td>
						<td style='width: 25%;align:left'><input style="width:80%;" type="text" class="easyui-textbox" data-options="events:{blur:ischeckNum,focus:jjks}" id="EMC1012b"></td>
						<td style='width: 20%;'>(低)°C</td>
						<td ><input  id="EMC1012_JUDGE" style=" height: 25px;width:130px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:150,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td style='width: 20%'></td>
						<td style='width: 25%;align:left'><input style="width:80%;" type="text" class="easyui-textbox" data-options="events:{blur:ischeckNum,focus:jjks}" id="EMC1013p"></td>
						<td style='width: 20%;'>°C度以下</td>
						<td style='width: 25%;align:left'></td>
						<td style='width: 20%;'></td>
						<td ><input  id="EMC1013_JUDGE" style=" height: 25px;width:130px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:150,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td style='width: 20%'>温差</td>
						<td style='width: 25%;align:left'><input style="width:80%;" type="text" class="easyui-textbox" data-options="events:{blur:ischeckNum,focus:jjks}" id="EMC1024a"></td>
						<td style='width: 20%;'>~~</td>
						<td style='width: 25%;align:left'><input style="width:80%;" type="text" class="easyui-textbox" data-options="events:{blur:ischeckNum,focus:jjks}" id="EMC1024b"></td>
						<td style='width: 20%;'></td>
						<td ><input  id="EMC1024_JUDGE" style=" height: 25px;width:130px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:150,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td style='width: 20%'></td>
						<td style='width: 25%;align:left'><input style="width:80%;" type="text" class="easyui-textbox" data-options="events:{blur:ischeckNum,focus:jjks}" id="EMC1021l"></td>
						<td style='width: 20%;'>°C度以上</td>
						<td style='width: 25%;align:left'></td>
						<td style='width: 20%;'></td>
						<td ><input  id="EMC1021_JUDGE" style=" height: 25px;width:130px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
										  panelHeight:150,
										  required:false,
										  data:DICT_201,
										  method:'get'" ></td>
					</tr>
					<tr>
						<td style='width: 20%'>延时报警</td>
						<td style='width: 25%;align:left'><input style="width:80%;" type="text" class="easyui-textbox" data-options="events:{blur:ischeckNum,focus:jjks}" id="rbTime"></td>
						<td style='width: 20%;'>°C度以上</td>
						<td style='width: 25%;align:left'></td>
						<td style='width: 20%;'></td>
						<td ></td>
					</tr>
				</table>
			</fieldset>
		</div>
		<div style="float:left;height:40%;width:50%" id="rhDiv">
			<fieldset style="height:100%;" >
				<legend>热环温度</legend>
				<table style="width:100%;margin: 0 0 0 0;padding: 0 0 0 0">
					<tr><th style='width: 20%'>测量项</th><th colspan="4">测量值</th><th>报警处置</th></tr>
						<tr>
							<td style='width: 10%'>温度</td>
							<td style='width: 25%;align:left'><input style="width:80%;" type="text"  oldvalue='1' class="easyui-textbox" data-options="events:{blur:ischeckNum,focus:jjks}" id="EMC2012l"></td>
							<td style='width: 20%;'>高°C度以上</td>
							<td style='width: 25%;'></td>
							<td style='width: 20%;'></td>
							<td ><input  id="EMC2012_JUDGE" style=" height: 25px;width:130px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
						</tr>
						<tr>
							<td style='width: 20%'></td>
							<td style='width: 25%;align:left'><input style="width:80%;" type="text" class="easyui-textbox" data-options="events:{blur:ischeckNum,focus:jjks}" id="EMC2013a"></td>
							<td style='width: 20%;'>(低低)</td>
							<td style='width: 25%;align:left'><input style="width:80%;" type="text" class="easyui-textbox" data-options="events:{blur:ischeckNum,focus:jjks}" id="EMC2013b"></td>
							<td style='width: 20%;'>(低)°C</td>
							<td ><input  id="EMC2013_JUDGE" style=" height: 25px;width:130px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
						</tr>
						<tr>
							<td style='width: 20%'></td>
							<td style='width: 25%;align:left'><input style="width:80%;" type="text" class="easyui-textbox" data-options="events:{blur:ischeckNum,focus:jjks}" id="EMC2014p"></td>
							<td style='width: 20%;'>°C度以下</td>
							<td style='width: 25%;align:left'></td>
							<td style='width: 20%;'></td>
							<td ><input  id="EMC2014_JUDGE" style=" height: 25px;width:130px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
						</tr>
						<tr>
							<td style='width: 20%'>温差</td>
							<td style='width: 25%;align:left'><input style="width:80%;" type="text" class="easyui-textbox" data-options="events:{blur:ischeckNum,focus:jjks}" id="EMC2021a"></td>
							<td style='width: 20%;'>~~</td>
							<td style='width: 25%;align:left'><input style="width:80%;" type="text" class="easyui-textbox" data-options="events:{blur:ischeckNum,focus:jjks}" id="EMC2021b"></td>
							<td style='width: 20%;'></td>
							<td ><input  id="EMC2021_JUDGE" style=" height: 25px;width:130px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
						</tr>
						<tr>
							<td style='width: 20%'></td>
							<td style='width: 25%;align:left'><input style="width:80%;" type="text" class="easyui-textbox" data-options="events:{blur:ischeckNum,focus:jjks}" id="EMC2022l"></td>
							<td style='width: 20%;'>°C度以上</td>
							<td style='width: 25%;align:left'></td>
							<td style='width: 20%;'></td>
							<td ><input  id="EMC2022_JUDGE" style=" height: 25px;width:130px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
						</tr>
						<tr>
							<td style='width: 20%'>延时报警</td>
							<td style='width: 25%;align:left'><input style="width:80%;" type="text" class="easyui-textbox" data-options="events:{blur:ischeckNum,focus:jjks}" id="rhTime"></td>
							<td style='width: 20%;'>°C度以上</td>
							<td style='width: 25%;align:left'></td>
							<td style='width: 20%;'></td>
							<td ></td>
						</tr>
				</table>
			</fieldset>
		</div>
		<div style="float:left;height:25%;width:100%;padding:20px 0 0 0 " id="nywDiv">
			<fieldset style="height:100%;" >
				<legend>内压温度</legend>
				<table style="word-wrap: break-word; word-break: break-all;">
					<tr>
						<td style="width: 10%">
							步2:
						</td>
						<td align="left">
							<samp>&emsp;
								[<input type="text" class="easyui-textbox" data-options="events:{blur:ischeckNum,focus:jjks}"  style="width:70px; height: 25px" id="EMC3011t">s后
								 <input type="text" class="easyui-textbox" data-options="events:{blur:ischeckNum,focus:jjks}"  style="width:70px; height: 25px" id="EMC3011a">(低低)--&emsp;
								 <input type="text" class="easyui-textbox" data-options="events:{blur:ischeckNum,focus:jjks}"  style="width:70px; height: 25px" id="EMC3011b">(低)°C</samp>
								 <input  id="EMC3011_JUDGE"   style="height: 20px;margin: 0 0 0 0;padding: 0 0 0 0 " class="easyui-combotree" data-options="
												  required:false,
												  data:DICT_201,
												  method:'get'" >
							<samp>&emsp;
								<input type="text" class="easyui-textbox" data-options="events:{blur:ischeckNum,focus:jjks}"  style="width:70px; height: 25px" id="EMC3012p">以下</samp>
								<input  id="EMC3012_JUDGE"  style="height: 20px;margin: 0 0 0 0;padding: 0 0 0 0 " class="easyui-combotree" data-options="
										  required:false,
										  data:DICT_201,
										  method:'get'" >]
							<br>
							<samp>&emsp;
								[<input type="text" class="easyui-textbox" data-options="events:{blur:ischeckNum,focus:jjks}" style="width:70px; height: 25px" id="EMC3013a">~~
								 <input type="text" class="easyui-textbox" data-options="events:{blur:ischeckNum,focus:jjks}" style="width:70px; height: 25px" id="EMC3013b"></samp>
								 <input  id="EMC3013_JUDGE"   style="height: 20px;margin: 0 0 0 0;padding: 0 0 0 0 " class="easyui-combotree" data-options="
										  required:false,
										  data:DICT_201,
										  method:'get'" >
							<samp><input type="text"  class="easyui-textbox" data-options="events:{blur:ischeckNum,focus:jjks}" style="width:70px; height: 25px" id="EMC3014p">以下</samp>
								  <input  id="EMC3014_JUDGE"  style="height: 20px;margin: 0 0 0 0;padding: 0 0 0 0 " class="easyui-combotree" data-options="
											  required:false,
											  data:DICT_201,
											  method:'get'" >]
							<br>
							<samp>&emsp;
								[<input type="text" class="easyui-textbox" data-options="events:{blur:ischeckNum,focus:jjks}" style="width:70px; height: 25px" id="EMC3015a">~~
								 <input type="text" class="easyui-textbox" data-options="events:{blur:ischeckNum,focus:jjks}" style="width:70px; height: 25px" id="EMC3015b"></samp>
								 <input  id="EMC3015_JUDGE"   style="height: 20px;margin: 0 0 0 0;padding: 0 0 0 0 " class="easyui-combotree" data-options="
										  required:false,
										  data:DICT_201,
										  method:'get'" >
							<samp><input type="text" class="easyui-textbox" data-options="events:{blur:ischeckNum,focus:jjks}" style="width:70px; height: 25px" id="EMC3016l">以上</samp>
								  <input  id="EMC3016_JUDGE"  style="height: 20px;margin: 0 0 0 0;padding: 0 0 0 0 " class="easyui-combotree" data-options="
										  required:false,
										  data:DICT_201,
										  method:'get'" >]
					
						</td>
			    	</tr>
			    	<tr>
			    		<td style="width: 10%">持续时间</td>
						<td align="left">&emsp;&ensp; <input id="nwTime" type="text" class="easyui-textbox" data-options="events:{blur:ischeckNum,focus:jjks}" style="width:70px; height: 25px">s</td>
			    	</tr>
			    </table>
				
				
			</fieldset>
		</div>
		<div style="float:left;height:auto;width:100%;padding:20px 0 0 0 " id="nyyDiv" >
			<fieldset style="height:100%;" >
				<legend>内压压力</legend>
				<table   id ="nyylTable" style="word-wrap: break-word; word-break: break-all;">
					<tr><th rowspan="7" style="width: 10%">步2:</th></tr>
					<tr>
						<td style='width:25%'><input id="EMC4021t" type="text" class="easyui-textbox" data-options="events:{blur:ischeckNum,focus:jjks}" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>s后</td>
						<td style='width:25%'></td>
						<td style='width:20%'></td>
						<td ></td>
					</tr>
					<tr>
						<td style='width:25%'><input id="EMC4021a" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>(低低)--</td>
						<td style='width:25%'><input id="EMC4021b" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>-(低)MPa</td>
						<td ><input  id="EMC4021_JUDGE" style=" height: 25px;width:200px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
					</tr>
					<tr>
						<td style='width:25%'><input id="EMC4022p" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>MPa以下</td>
						<td style='width:25%'></td>
						<td style='width:20%'></td>
						<td ><input  id="EMC4022_JUDGE" style=" height: 25px;width:200px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
					</tr>
					<tr>
						<td style='width:25%'><input id="EMC4023a" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>--</td>
						<td style='width:25%'><input id="EMC4023b"type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'></td>
						<td ><input  id="EMC4023_JUDGE" style=" height: 25px;width:200px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
					</tr>
					<tr>
						<td style='width:25%'><input id="EMC4024p"type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>Map以下</td>
						<td style='width:25%'></td>
						<td style='width:20%'></td>
						<td ><input  id="EMC4024_JUDGE" style=" height: 25px;width:200px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
					</tr>
					<tr>
						<td style='width:25%'><input id="EMC4025l"type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>Map以上</td>
						<td style='width:25%'></td>
						<td style='width:20%'></td>
						<td ><input  id="EMC4025_JUDGE" style=" height: 25px;width:200px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
					</tr>
					<tr><th rowspan="7" style="width: 10%">步3:</th></tr>
					<tr>
						<td style='width:25%'><input id="EMC4030t" type="text" class="easyui-textbox" data-options="events:{blur:ischeckNum,focus:jjks}" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>s后</td>
						<td style='width:25%'></td>
						<td style='width:20%'></td>
						<td ></td>
					</tr>
					<tr>
						<td style='width:25%'><input id="EMC4030a" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>(低低)--</td>
						<td style='width:25%'><input id="EMC4030b" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>-(低)MPa</td>
						<td ><input  id="EMC4030_JUDGE" style=" height: 25px;width:200px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
					</tr>
					<tr>
						<td style='width:25%'><input id="EMC4031p" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>MPa以下</td>
						<td style='width:25%'></td>
						<td style='width:20%'></td>
						<td ><input  id="EMC4031_JUDGE" style=" height: 25px;width:200px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
					</tr>
					<tr>
						<td style='width:25%'><input id="EMC4032a" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>--</td>
						<td style='width:25%'><input id="EMC4032b" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'></td>
						<td ><input  id="EMC4032_JUDGE" style=" height: 25px;width:200px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
					</tr>
					<tr>
						<td style='width:25%'><input id="EMC4033p" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>Map以下</td>
						<td style='width:25%'></td>
						<td style='width:20%'></td>
						<td ><input  id="EMC4033_JUDGE" style=" height: 25px;width:200px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
					</tr>
					<tr>
						<td style='width:25%'><input id="EMC4034l" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>Map以上</td>
						<td style='width:25%'></td>
						<td style='width:20%'></td>
						<td ><input  id="EMC4034_JUDGE" style=" height: 25px;width:200px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
					</tr>
					<tr><th rowspan="7" style="width: 10%">步4:</th></tr>
					<tr>
						<td style='width:25%'><input id="EMC4040t" type="text" class="easyui-textbox" data-options="events:{blur:ischeckNum,focus:jjks}" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>s后</td>
						<td style='width:25%'></td>
						<td style='width:20%'></td>
						<td ></td>
					</tr>
					<tr>
						<td style='width:25%'><input id="EMC4040a" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>(低低)--</td>
						<td style='width:25%'><input id="EMC4040b" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>-(低)MPa</td>
						<td ><input  id="EMC4040_JUDGE" style=" height: 25px;width:200px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
					</tr>
					<tr>
						<td style='width:25%'><input id="EMC4041p" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>MPa以下</td>
						<td style='width:25%'></td>
						<td style='width:20%'></td>
						<td ><input  id="EMC4041_JUDGE" style=" height: 25px;width:200px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
					</tr>
					<tr>
						<td style='width:25%'><input id="EMC4042a" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>--</td>
						<td style='width:25%'><input id="EMC4042b" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'></td>
						<td ><input  id="EMC4042_JUDGE" style=" height: 25px;width:200px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
					</tr>
					<tr>
						<td style='width:25%'><input id="EMC4043p" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>Map以下</td>
						<td style='width:25%'></td>
						<td style='width:20%'></td>
						<td ><input  id="EMC4043_JUDGE" style=" height: 25px;width:200px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
					</tr>
					<tr>
						<td style='width:25%'><input id="EMC4044l" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>Map以上</td>
						<td style='width:25%'></td>
						<td style='width:20%'></td>
						<td ><input  id="EMC4044_JUDGE" style=" height: 25px;width:200px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
					</tr>
					<tr><th rowspan="7" style="width: 10%">步5:</th></tr>
					<tr>
						<td style='width:25%'><input id="EMC4050t" type="text" class="easyui-textbox" data-options="events:{blur:ischeckNum,focus:jjks}" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>s后</td>
						<td style='width:25%'></td>
						<td style='width:20%'></td>
						<td ></td>
					</tr>
					<tr>
						<td style='width:25%'><input id="EMC4050a" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>(低低)--</td>
						<td style='width:25%'><input id="EMC4050b" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>-(低)MPa</td>
						<td ><input  id="EMC4050_JUDGE" style=" height: 25px;width:200px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
					</tr>
					<tr>
						<td style='width:25%'><input id="EMC4051p" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>MPa以下</td>
						<td style='width:25%'></td>
						<td style='width:20%'></td>
						<td ><input  id="EMC4051_JUDGE" style=" height: 25px;width:200px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
					</tr>
					<tr>
						<td style='width:25%'><input id="EMC4052a" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>--</td>
						<td style='width:25%'><input id="EMC4052b" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'></td>
						<td ><input  id="EMC4052_JUDGE" style=" height: 25px;width:200px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
					</tr>
					<tr>
						<td style='width:25%'><input id="EMC4053p" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>Map以下</td>
						<td style='width:25%'></td>
						<td style='width:20%'></td>
						<td ><input  id="EMC4053_JUDGE" style=" height: 25px;width:200px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
					</tr>
					<tr>
						<td style='width:25%'><input id="EMC4054l" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>Map以上</td>
						<td style='width:25%'></td>
						<td style='width:20%'></td>
						<td ><input  id="EMC4054_JUDGE" style=" height: 25px;width:200px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
					</tr>
					<tr><th rowspan="7" style="width: 10%">步6:</th></tr>
					<tr>
						<td style='width:25%'><input id="EMC4060t" type="text" class="easyui-textbox" data-options="events:{blur:ischeckNum,focus:jjks}" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>s后</td>
						<td style='width:25%'></td>
						<td style='width:20%'></td>
						<td ></td>
					</tr>
					<tr>
						<td style='width:25%'><input id="EMC4060a" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>(低低)--</td>
						<td style='width:25%'><input id="EMC4060b" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>-(低)MPa</td>
						<td ><input  id="EMC4060_JUDGE" style=" height: 25px;width:200px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
					</tr>
					<tr>
						<td style='width:25%'><input id="EMC4063p" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>MPa以下</td>
						<td style='width:25%'></td>
						<td style='width:20%'></td>
						<td ><input  id="EMC4063_JUDGE" style=" height: 25px;width:200px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
					</tr>
					<tr>
						<td style='width:25%'><input id="EMC4064a" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>--</td>
						<td style='width:25%'><input id="EMC4064b" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'></td>
						<td ><input  id="EMC4064_JUDGE" style=" height: 25px;width:200px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
					</tr>
					<tr>
						<td style='width:25%'><input id="EMC4065p" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>Map以下</td>
						<td style='width:25%'></td>
						<td style='width:20%'></td>
						<td ><input  id="EMC4065_JUDGE" style=" height: 25px;width:200px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
					</tr>
					<tr>
						<td style='width:25%'><input id="EMC4066l" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>Map以上</td>
						<td style='width:25%'></td>
						<td style='width:20%'></td>
						<td ><input  id="EMC4066_JUDGE" style=" height: 25px;width:200px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
					</tr>
					
					<tr><th rowspan="2" style="width: 10%">步6:&emsp;压差</th></tr>
					<tr>
						<td style='width:25%'><input id="EMC4061l" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>MPa以上</td>
						<td ><input  id="EMC4061_JUDGE" style=" height: 25px;width:200px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
						<td style='width:20%'><input id="EMC4062l" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>以上</td>
						<td ><input  id="EMC4062_JUDGE" style=" height: 25px;width:200px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
					</tr>
					
					<tr><th rowspan="7" style="width: 10%">步7:</th></tr>
					<tr>
						<td style='width:25%'><input id="EMC4070t" type="text" class="easyui-textbox" data-options="events:{blur:ischeckNum,focus:jjks}" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>s后</td>
						<td style='width:25%'></td>
						<td style='width:20%'></td>
						<td ></td>
					</tr>
					<tr>
						<td style='width:25%'><input id="EMC4070a" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>(低低)--</td>
						<td style='width:25%'><input id="EMC4070b" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>-(低)MPa</td>
						<td ><input  id="EMC4070_JUDGE" style=" height: 25px;width:200px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
					</tr>
					<tr>
						<td style='width:25%'><input id="EMC4071p" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>MPa以下</td>
						<td style='width:25%'></td>
						<td style='width:20%'></td>
						<td ><input  id="EMC4071_JUDGE" style=" height: 25px;width:200px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
					</tr>
					<tr>
						<td style='width:25%'><input id="EMC4072a" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>--</td>
						<td style='width:25%'><input id="EMC4072b" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'></td>
						<td ><input  id="EMC4072_JUDGE" style=" height: 25px;width:200px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
					</tr>
					<tr>
						<td style='width:25%'><input id="EMC4073p" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>Map以下</td>
						<td style='width:25%'></td>
						<td style='width:20%'></td>
						<td ><input  id="EMC4073_JUDGE" style=" height: 25px;width:200px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
					</tr>
					<tr>
						<td style='width:25%'><input id="EMC4074l" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>Map以上</td>
						<td style='width:25%'></td>
						<td style='width:20%'></td>
						<td ><input  id="EMC4074_JUDGE" style=" height: 25px;width:200px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
					</tr>
					
					<tr><th rowspan="6" style="width: 10%">步8:</th></tr>
					<tr>
						<td style='width:25%'><input id="EMC4081t" type="text" class="easyui-textbox" data-options="events:{blur:ischeckNum,focus:jjks}" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>s后</td>
						<td style='width:25%'></td>
						<td style='width:20%'></td>
						<td ></td>
					</tr>
					<tr>
						<td style='width:25%'><input id="EMC4081a" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>(低低)--</td>
						<td style='width:25%'><input id="EMC4081b" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>-(低)MPa</td>
						<td ><input  id="EMC4081_JUDGE" style=" height: 25px;width:200px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
					</tr>
					<tr>
						<td style='width:25%'><input id="EMC4082p" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>MPa以下</td>
						<td style='width:25%'></td>
						<td style='width:20%'></td>
						<td ><input  id="EMC4082_JUDGE" style=" height: 25px;width:200px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
					</tr>
					<tr>
						<td style='width:25%'><input id="EMC4083a" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>--</td>
						<td style='width:25%'><input id="EMC4083b" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'></td>
						<td ><input  id="EMC4083_JUDGE" style=" height: 25px;width:200px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
					</tr>
					<tr>
						<td style='width:25%'><input id="EMC4084p" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>Map以下</td>
						<td style='width:25%'></td>
						<td style='width:20%'></td>
						<td ><input  id="EMC4084_JUDGE" style=" height: 25px;width:200px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
					</tr>
					<tr><th rowspan="6" style="width: 10%">步9:</th></tr>
					<tr>
						<td style='width:25%'><input id="EMC4091t" type="text" class="easyui-textbox" data-options="events:{blur:ischeckNum,focus:jjks}" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>s后</td>
						<td style='width:25%'></td>
						<td style='width:20%'></td>
						<td ></td>
					</tr>
					<tr>
						<td style='width:25%'><input id="EMC4091a" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>(低低)--</td>
						<td style='width:25%'><input id="EMC4091b" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>-(低)MPa</td>
						<td ><input  id="EMC4091_JUDGE" style=" height: 25px;width:200px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
					</tr>
					<tr>
						<td style='width:25%'><input id="EMC4092p" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>MPa以下</td>
						<td style='width:25%'></td>
						<td style='width:20%'></td>
						<td ><input  id="EMC4092_JUDGE" style=" height: 25px;width:200px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
					</tr>
					<tr>
						<td style='width:25%'><input id="EMC4093a" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>--</td>
						<td style='width:25%'><input id="EMC4093b" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'></td>
						<td ><input  id="EMC4093_JUDGE" style=" height: 25px;width:200px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
					</tr>
					<tr>
						<td style='width:25%'><input id="EMC4094p" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>Map以下</td>
						<td style='width:25%'></td>
						<td style='width:20%'></td>
						<td ><input  id="EMC4094_JUDGE" style=" height: 25px;width:200px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
					</tr>
					<tr><th rowspan="6" style="width: 10%">步10:</th></tr>
					<tr>
						<td style='width:25%'><input id="EMC4101t" type="text" class="easyui-textbox" data-options="events:{blur:ischeckNum,focus:jjks}" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>s后</td>
						<td style='width:25%'></td>
						<td style='width:20%'></td>
						<td ></td>
					</tr>
					<tr>
						<td style='width:25%'><input id="EMC4101a" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>(低低)--</td>
						<td style='width:25%'><input id="EMC4101b" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>-(低)MPa</td>
						<td ><input  id="EMC4101_JUDGE" style=" height: 25px;width:200px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
					</tr>
					<tr>
						<td style='width:25%'><input id="EMC4102p" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>MPa以下</td>
						<td style='width:25%'></td>
						<td style='width:20%'></td>
						<td ><input  id="EMC4102_JUDGE" style=" height: 25px;width:200px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
					</tr>
					<tr>
						<td style='width:25%'><input id="EMC4103a" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>--</td>
						<td style='width:25%'><input id="EMC4103b" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'></td>
						<td ><input  id="EMC4103_JUDGE" style=" height: 25px;width:200px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
					</tr>
					<tr>
						<td style='width:25%'><input id="EMC4104p" type="text"  class="easyui-textbox" onkeyup="this.value=this.value.replace(/[^\-?\d.]/g,'')" style="width:100px; height: 20px" ></td>
						<td style='width:20%'>Map以下</td>
						<td style='width:25%'></td>
						<td style='width:20%'></td>
						<td ><input  id="EMC4104_JUDGE" style=" height: 25px;width:200px;margin: 0 0 0 0;padding: 0 0 0 0 " type="text" class="easyui-combotree" data-options="
											  panelHeight:150,
											  required:false,
											  data:DICT_201,
											  method:'get'" ></td>
					</tr>
					<tr><th rowspan="2" style="width: 20%">持续时间:</th></tr>
					<tr>
						<td style='width:25%'><input id="nyTime" type="text" class="easyui-textbox" data-options="events:{blur:ischeckNum,focus:jjks}" style="width:100px; height: 20px">s</td>
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
