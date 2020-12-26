<!-- 
    作者      :王超
    时间      :2020-08-08 10:22:36 
    页面名称:密炼投料防错管控
    文件关联:
        FeedSwitch.java
        FeedSwitchController.java
        FeedSwitchServiceImpl.java
        FeedSwitchServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="feedswitch.js.jsp"%>
<script type="text/javascript" src="dict/330.js"></script>
<body class="easyui-layout" fit="true">
	<div data-options="region:'center',split:true,border:false">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'center',split:true,border:false">
				<div id="FeedSwitch_dg_toolbar">
					<form id="FeedSwitch_search_form" class="form">
						<!-- 机台条码 -->
						<spring:message code="feedswitch.column.equip_code_s" />：
						<input name="filter[equip_code_s]" id="equip_code_s" type="text"
							class="easyui-combobox" style="width: 180px"
							data-options="valueField:'p_line_name',
		            			textField:'description',
                                required:false, 
                                data:plinedata,
								method: 'get',
							    editable:'true',
							    limitToList:false,
							    panelHeight:200">
						<!-- 下发标识：0-未下发、1-已下发、2-下发失败 -->
						<spring:message code="feedswitch.column.send_state_s" />：
						<input name="filter[send_state_s]" id="send_state_s" type="text"
							class="easyui-combobox" style="width: 120px"
							data-options="label:'',
                                 textField: 'label',
								 data: [{
									label: '未下发',
									value: '0'
								 },{
									label: '已下发',
									value: '1'
								 },{
									label: '下发失败',
									value: '2'
								 }],
								 editable:true,
								 onChange:filter">
						<a class="easyui-linkbutton btn-yellow"
							data-options="iconCls:'icon-search'" onclick="filter()"><spring:message
								code="button.search" /></a>
						<auth:button code="JM_Mixer_BaseData_feedSwitch_add">
							<a class="easyui-linkbutton btn-green"
								data-options="iconCls:'icon-add'" onclick="add()"><spring:message
									code="button.add" /></a>
						</auth:button>
						<auth:button code="JM_Mixer_BaseData_feedSwitch_saveadd">
							<a class="easyui-linkbutton btn-blue"
								data-options="iconCls:'icon-save'" onclick="save()"><spring:message
									code="button.save" /></a>
						</auth:button>
						<auth:button code="JM_Mixer_BaseData_feedSwitch_cancel">
							<a class="easyui-linkbutton btn-yellow"
								data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message
									code="button.cancel" /></a>
						</auth:button>
					</form>
					<div>
						<auth:button code="JM_Mixer_BaseData_feedSwitch_equalmaterialon">
							<a class="easyui-linkbutton btn-yellow"
								data-options="iconCls:'icon-add'"
								onclick="openOrclose('等同物料打开')"><spring:message
									code="button.openequalmaterial" /></a>
						</auth:button>
						<auth:button code="JM_Mixer_BaseData_feedSwitch_masteroperatoron">
							<a class="easyui-linkbutton btn-yellow"
								data-options="iconCls:'icon-add'"
								onclick="openOrclose('主机手设置打开')"><spring:message
									code="button.openmaster" /></a>
						</auth:button>
						<auth:button code="JM_Mixer_BaseData_feedSwitch_inorderexecon">
							<a class="easyui-linkbutton btn-yellow"
								data-options="iconCls:'icon-add'"
								onclick="openOrclose('顺序执行打开')"><spring:message
									code="button.openinorder" /></a>
						</auth:button>
						<auth:button code="JM_Mixer_BaseData_feedSwitch_carwashcheckon">
							<a class="easyui-linkbutton btn-yellow"
								data-options="iconCls:'icon-add'"
								onclick="openOrclose('洗车校验打开')"><spring:message
									code="button.opencarwash" /></a>
						</auth:button>
						<auth:button code="JM_Mixer_BaseData_feedSwitch_autospcontrolon">
							<a class="easyui-linkbutton btn-yellow"
								data-options="iconCls:'icon-add'"
								onclick="openOrclose('接片控制打开')"><spring:message
									code="button.openautosp" /></a>
						</auth:button>
						<auth:button code="JM_Mixer_BaseData_feedSwitch_send">
							<a class="easyui-linkbutton btn-black"
								data-options="iconCls:'icon-version'" onclick="issue()"><spring:message
									code="button.returnissuedfeed" /></a>
						</auth:button>
						<br>
						<auth:button code="JM_Mixer_BaseData_feedSwitch_equalmaterialoff">
							<a class="easyui-linkbutton btn-yellow"
								data-options="iconCls:'icon-remove'"
								onclick="openOrclose('等同物料关闭')"><spring:message
									code="button.closeequalmaterial" /></a>
						</auth:button>
						<auth:button code="JM_Mixer_BaseData_feedSwitch_masteroperatoroff">
							<a class="easyui-linkbutton btn-yellow"
								data-options="iconCls:'icon-remove'"
								onclick="openOrclose('主机手设置关闭')"><spring:message
									code="button.closemaster" /></a>
						</auth:button>
						<auth:button code="JM_Mixer_BaseData_feedSwitch_inorderexecoff">
							<a class="easyui-linkbutton btn-yellow"
								data-options="iconCls:'icon-remove'"
								onclick="openOrclose('顺序执行关闭')"><spring:message
									code="button.closeinorder" /></a>
						</auth:button>
						<auth:button code="JM_Mixer_BaseData_feedSwitch_carwashcheckoff">
							<a class="easyui-linkbutton btn-yellow"
								data-options="iconCls:'icon-remove'"
								onclick="openOrclose('洗车校验关闭')"><spring:message
									code="button.closecarwash" /></a>
						</auth:button>
						<auth:button code="JM_Mixer_BaseData_feedSwitch_autospcontroloff">
							<a class="easyui-linkbutton btn-yellow"
								data-options="iconCls:'icon-remove'"
								onclick="openOrclose('接片控制关闭')"><spring:message
									code="button.closeautosp" /></a>
						</auth:button>
					</div>
				</div>
				<table id="feedswitch_dg" class="easyui-datagrid" style="width:100%"
					data-options="  
		                fit:true,
		                fitColumns:false,
		                pagination:true,
		                rownumbers: true,
		                singleSelect: false,
		                toolbar: '#FeedSwitch_dg_toolbar',
		                url: 'mix/baseData/feedSwitch/datagrid',
		                striped:true,
		                onSelect:selectrow,
		                method: 'get' 
		                ">
					<thead>
						<tr>
							<th rowspan="2" data-options="field:'atr_key',checkbox:true"></th>
							<th colspan="6">机台信息</th>
							<th colspan="5">开关控制</th>
							<th colspan="6">其它</th>
						</tr>
						<tr>
							<!-- 机台信息 -->
							<!-- 机台名称 -->
							<th
								data-options="field:'equip_code_s',formatter:equipCodeFormatter,width:180,editor:{type:'combobox',options:{
		                 			valueField:'p_line_name',
			            			textField:'description',
		                            required:true,
		                            data:plineadddata,
									method: 'get',
								    editable:'true',
								    limitToList:false,
								    panelHeight:200}}"><spring:message
									code="feedswitch.column.equip_name_s" /></th>
							<!-- 备用字段3：状态：关闭、打开 -->
							<th
								data-options="field:'spare3_s',width:70,formatter:closeOropen,styler:planStatusColorSetting,editor:close"><spring:message
									code="feedswitch.column.spare3_s" /></th>
							<!-- 下发标识：0-未下发、1-已下发、2-下发失败 -->
							<th
								data-options="field:'send_state_s',formatter:sendstatus,editor:close"><spring:message
									code="feedswitch.column.send_state_s" /></th>
							<!-- 备用字段2：备注：例如 MW92007071008[已执行] -->
							<th
								data-options="field:'spare2_s',width:120,editor:close"><spring:message
									code="feedswitch.column.spare2_s" /></th>
							<!-- 备用字段1：父物料类型 -->
							<th
								data-options="field:'spare1_s',width:220,formatter:codeformattermat,editor:{type:'combotree',
			                        options:{panelHeight:150,
			                            editable:true,
							            required:true,
						                url:'dict/code/330',
						                multiple:true}}" /><spring:message
										code="父物料类型" /></th>
							<!-- 防错物料组名称：例如 半成品-母胶,半成品-混炼胶 -->
							<th
								data-options="field:'material_groupname_s',width:220,editor:close"><spring:message
									    code="feedswitch.column.material_groupname_s" /></th>
							<!-- 开关控制 -->
							<th
								data-options="field:'is_equal_switch_s',width:70,formatter:formatOper,styler:planStatusColorSetting">等同物料</th>
							<th
								data-options="field:'is_master_switch_s',width:70,formatter:formatOper,styler:planStatusColorSetting">主机手设置</th>
							<th
								data-options="field:'is_inorder_exec_switch_s',width:70,formatter:formatOper,styler:planStatusColorSetting">顺序执行</th>
							<th
								data-options="field:'is_carwash_switch_s',width:70,formatter:formatOper,styler:planStatusColorSetting">洗车校验</th>
							<th
								data-options="field:'is_autosp_switch_s',width:70,formatter:formatOper,styler:planStatusColorSetting">接片控制</th>

							<!-- 其它 -->
							<!-- 下发人 -->
							<th
								data-options="field:'send_by_s',formatter:toUserName,editor:close"><spring:message
									code="feedswitch.column.send_by_s" /></th>
							<!-- 下发时间 -->
							<th data-options="field:'send_time_t',editor:close"><spring:message
									code="feedswitch.column.send_time_t" /></th>
							<!-- 修改人 -->
							<th
								data-options="field:'changed_by_s',formatter:toUserName,editor:close"><spring:message
									code="feedswitch.column.changed_by_s" /></th>
							<!-- 修改时间 -->
							<th data-options="field:'changed_time_t',editor:close"><spring:message
									code="feedswitch.column.changed_time_t" /></th>
							<!-- 创建人 -->
							<th
								data-options="field:'created_by_s',formatter:toUserName,editor:close"><spring:message
									code="feedswitch.column.created_by_s" /></th>
							<!-- 创建时间 -->
							<th data-options="field:'created_time_t',editor:close"><spring:message
									code="feedswitch.column.created_time_t" /></th>
						</tr>
					</thead>
				</table>
			</div>

			<div data-options="region:'south',split:true" style="height: 200px;">
				<div class="easyui-tabs" id="content_tab"
					data-options="fit:true,tools:'#tab-tools'">
					<div title="接片信息" style="padding: 10px">
						<table border="1px" cellspacing="0" width="100%"
							class="detailtable">
							<tr>
								<td bgcolor="#D1E9E9"><spring:message code="工单号" /></td>
								<td class="detailtd" width="40%"><span id="sp_wo_no_s_sp"></span></td>
								<td bgcolor="#D1E9E9"><spring:message code="通讯心跳" /></td>
								<td class="detailtd" width="10%"><span
									id="sp_netheart_i_sp"></span></td>
								<td bgcolor="#D1E9E9"><spring:message code="胶片移入信号" /></td>
								<td class="detailtd" width="20%"><span
									id="sp_carriermovein_s_sp"></span></td>
							</tr>
							<tr>
								<td bgcolor="#D1E9E9"><spring:message code="胶案条码" /></td>
								<td><span id="spare5_s_sp"></span></td>
								<td bgcolor="#D1E9E9"><spring:message code="架子数" /></td>
								<td><span id="sp_shelf_num_i_sp"></span></td>
								<td bgcolor="#D1E9E9"><spring:message code="胶案移入工位" /></td>
								<td><span id="sp_carriermovein_loc_s_sp"></span></td>
							</tr>
							<tr>
								<td bgcolor="#D1E9E9"><spring:message code="当前动作" /></td>
								<td><span id="sp_curaction_s_sp"></span></td>
								<td bgcolor="#D1E9E9"><spring:message code="标准重量" /></td>
								<td><span id="sp_standweight_d_sp"></span></td>
								<td bgcolor="#D1E9E9"><spring:message code="胶案重量" /></td>
								<td><span id="sp_carrierweight_d_sp"></span></td>
							</tr>
							<tr>
								<td bgcolor="#D1E9E9"><spring:message code="错误描述" /></td>
								<td><span id="spare4_s_sp" class="text-shenglue"> </span></td>
								<td bgcolor="#D1E9E9"><spring:message code="提前值" /></td>
								<td><span id="sp_slowdownweight_d_sp"></span></td>
								<td bgcolor="#D1E9E9"><spring:message code="胶案移出信号" /></td>
								<td><span id="sp_carriermoveout_s_sp"></span></td>
							</tr>
							<tr>
								<td bgcolor="#D1E9E9"><spring:message code="运行模式" /></td>
								<td><span id="sp_runmode_s_sp"></span></td>
								<td bgcolor="#D1E9E9"><spring:message code="误差值" /></td>
								<td><span id="sp_cutpolyweight_d_sp"></span>
								</th>
								<td bgcolor="#D1E9E9"><spring:message code="胶案产出工位" /></td>
								<td><span id="sp_carriermove_loc_s_sp"></span></td>
							</tr>
							<tr>
								<td bgcolor="#D1E9E9"><spring:message code="自动/手动模式" /></td>
								<td><span id="sp_onlineoffline_sp"></span></td>
								<td bgcolor="#D1E9E9"><spring:message code="产出重量" /></td>
								<td><span id="sp_prodweight_d_sp"></span></td>
								<td></td>
								<td></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div data-options="region:'east',iconCls:'icon-proportion'" title="物料组"
		style="width: 28%">
		<!-- <form id="groupname_form" class="form"></form> -->
		<auth:button code="JM_Mixer_BaseData_feedSwitch_save">
			<a class="easyui-linkbutton" data-options="iconCls:'icon-save'"
				onclick="save2()">保存</a>
		</auth:button>
		<table id="groupname_dg" class="easyui-datagrid"
			data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                striped:true,
                method: 'get' ,
                ">
			<thead>
				<tr>
					<th data-options="field:'atr_key',checkbox:true"></th>
					<!-- 物料组 -->
					<th
						data-options="field:'dictname_s',width:150,editor:{type:'textbox'}"><spring:message
							code="物料组" /></th>
					<th data-options="field:'state',width:40,editor:{type:'textbox'}"><spring:message
							code="状态" /></th>
				</tr>
			</thead>
		</table>
	</div>

</body>
</html>