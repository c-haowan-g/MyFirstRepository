<!-- 

    作者      :陈国强
    时间      :2020-08-21 08:25:16 
    页面名称:密炼月产量表
    文件关联:
        MixMonthlyReport.java
        MixMonthlyReportController.java
        MixMonthlyReportServiceImpl.java
        MixMonthlyReportServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="mixmonthlyreport.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="MixMonthlyReport_dg_toolbar">
            <form id="MixMonthlyReport_search_form" class="form" >
                <!-- 月产量报表类型：1-密炼、2-半部件、3-成型 -->
                <input name="filter[spare1_s]" id="spare1_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 月份 年+月->201808 -->
                <spring:message code="mixmonthlyreport.column.month_s" />
                <input name="filter[month_s]" id="month_s" type="text" style="width: width:5%"  class="easyui-datebox" 
                data-options="label:'',onChange:getAll" >
                <!-- 机台编码 -->
                &nbsp;&nbsp;
                <spring:message code="mixmonthlyreport.column.equip_code_s" />
                <input name="filter[equip_code_s]" id="equip_code_s" type="text" style="width: 10%" class="easyui-combobox" 
                data-options="label:'',
                						required:false, 
                                        data:plinedata,
		                                method: 'get',
		                                panelHeight:'200',
		                                valueField:'p_line_name',
		                                textField:'description',
										onChange:filter" >
                <!-- 主机手姓名 -->
                &nbsp;&nbsp;
                <spring:message code="mixmonthlyreport.column.master_name_s" />
                <input name="filter[master_name_s]" id="master_name_s" type="text" class="easyui-combobox" 
                	data-options="label:'',
                          			data:masternamelist,
	         		           		panelHeight:150,
	         		           		editable:true,
	           		           		valueField:'MASTER_NAME_S',
	          		            	textField:'MASTER_NAME_S',
	                           		selectOnNavigation:false,
	           		           		limitToList:true,
	           		           		onChange:filter" >
                <!-- 物料名称 -->
                &nbsp;&nbsp;
                <spring:message code="mixmonthlyreport.column.materialname_s" />
                <input name="filter[materialspec_s]" id="materialspec_s" type="text" class="easyui-combobox"
                 	data-options="label:'',
                 	          			data:materialspeclist,
	         		          			panelHeight:150,
	         		          			editable:true,
	           		          			valueField:'MATERIALSPEC_S',
	          		           			textField:'MATERIALSPEC_S',
	                          			selectOnNavigation:false,
	           		          			limitToList:true,
	           		          			onChange:filter" >
                <!-- 物料编号 -->
                &nbsp;&nbsp;
                <spring:message code="mixmonthlyreport.column.materialcode_s" />
                <input name="filter[materialcode_s]" id="materialcode_s" type="text" style="width: 100px" class="easyui-textbox" data-options="label:''" >
                
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
                <a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="doExport()"><spring:message code="button.export" /></a>
            </form> 
            <auth:button code="XXX">
				
			</auth:button>
            <%-- <auth:button code="XXX"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            　
            <auth:button code="XXX"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            　
            <auth:button code="XXX"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="export()"><spring:message code="button.export" /></a></auth:button> --%>
        </div>
        <table id="mixmonthlyreport_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: false,
                singleSelect: true,
                toolbar: '#MixMonthlyReport_dg_toolbar',
                emptyMsg: '<span><spring:message code='tip.noData'/></span>',
                url: 'mix/report/mixmonthlyreport/mixmonthlyreport/datagrid',
                onLoadSuccess:onLoadSuccess,
               	onBeforeLoad:dlg1BeforeLoad,
                striped:true,
                method: 'get' 
                ">
            <thead>
            <tr>
					<th width="225" colspan="4"><strong>基本信息</strong></th>
					<th width="60" colspan="2"><strong>1号</strong></th>
					<th width="60" colspan="2"><strong>2号</strong></th>
					<th width="60" colspan="2"><strong>3号</strong></th>
					<th width="60" colspan="2"><strong>4号</strong></th>
					<th width="60" colspan="2"><strong>5号</strong></th>
					<th width="60" colspan="2"><strong>6号</strong></th>
					<th width="60" colspan="2"><strong>7号</strong></th>
					<th width="60" colspan="2"><strong>8号</strong></th>
					<th width="60" colspan="2"><strong>9号</strong></th>
					<th width="60" colspan="2"><strong>10号</strong></th>
					<th width="60" colspan="2"><strong>11号</strong></th>
					<th width="60" colspan="2"><strong>12号</strong></th>
					<th width="60" colspan="2"><strong>13号</strong></th>
					<th width="60" colspan="2"><strong>14号</strong></th>
					<th width="60" colspan="2"><strong>15号</strong></th>
					<th width="60" colspan="2"><strong>16号</strong></th>
					<th width="60" colspan="2"><strong>17号</strong></th>
					<th width="60" colspan="2"><strong>18号</strong></th>
					<th width="60" colspan="2"><strong>19号</strong></th>
					<th width="60" colspan="2"><strong>20号</strong></th>
					<th width="60" colspan="2"><strong>21号</strong></th>
					<th width="60" colspan="2"><strong>22号</strong></th>
					<th width="60" colspan="2"><strong>23号</strong></th>
					<th width="60" colspan="2"><strong>24号</strong></th>
					<th width="60" colspan="2"><strong>25号</strong></th>
					<th width="60" colspan="2"><strong>26号</strong></th>
					<th width="60" colspan="2"><strong>27号</strong></th>
					<th width="60" colspan="2"><strong>28号</strong></th>
					<th width="60" colspan="2"><strong>29号</strong></th>
					<th width="60" colspan="2"><strong>30号</strong></th>
					<th width="60" colspan="2"><strong>31号</strong></th>
					<th width="60" colspan="2"><strong>合计</strong></th>

				</tr>
                <tr>
                    
                    <!-- 机台名称 -->
                    <th data-options="field:'equip_name_s'"><spring:message code="mixmonthlyreport.column.equip_name_s" /></th>
                    <!-- 主机手 -->
                    <th  data-options="field:'master_name_s'"><spring:message code="主机手" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'materialspec_s'"><spring:message code="mixmonthlyreport.column.materialname_s" /></th>
                    <!-- 物料编号 -->
                    <th data-options="field:'materialcode_s'"><spring:message code="mixmonthlyreport.column.materialcode_s" /></th>
                    <!-- 1日车数 -->
                    <th data-options="field:'oneday_train_i'"><spring:message code="mixmonthlyreport.column.oneday_train_i" /></th>
                    <!-- 1日重量 -->
                    <th data-options="field:'oneday_weight_d'"><spring:message code="mixmonthlyreport.column.oneday_weight_d" /></th>
                    <!-- 2日车数 -->
                    <th data-options="field:'twoday_train_i'"><spring:message code="mixmonthlyreport.column.twoday_train_i" /></th>
                    <!-- 2日重量 -->
                    <th data-options="field:'twoday_weight_d'"><spring:message code="mixmonthlyreport.column.twoday_weight_d" /></th>
                    <!-- 3日车数 -->
                    <th data-options="field:'threeday_train_i'"><spring:message code="mixmonthlyreport.column.threeday_train_i" /></th>
                    <!-- 3日重量 -->
                    <th data-options="field:'threeday_weight_d'"><spring:message code="mixmonthlyreport.column.threeday_weight_d" /></th>
                    <!-- 4日车数 -->
                    <th data-options="field:'fourday_train_i'"><spring:message code="mixmonthlyreport.column.fourday_train_i" /></th>
                    <!-- 4日重量 -->
                    <th data-options="field:'fourday_weight_d'"><spring:message code="mixmonthlyreport.column.fourday_weight_d" /></th>
                    <!-- 5日车数 -->
                    <th data-options="field:'fiveday_train_i'"><spring:message code="mixmonthlyreport.column.fiveday_train_i" /></th>
                    <!-- 5日重量 -->
                    <th data-options="field:'fiveday_weight_d'"><spring:message code="mixmonthlyreport.column.fiveday_weight_d" /></th>
                    <!-- 6日车数 -->
                    <th data-options="field:'sixday_train_i'"><spring:message code="mixmonthlyreport.column.sixday_train_i" /></th>
                    <!-- 6日重量 -->
                    <th data-options="field:'sixday_weight_d'"><spring:message code="mixmonthlyreport.column.sixday_weight_d" /></th>
                    <!-- 7日车数 -->
                    <th data-options="field:'sevenday_train_i'"><spring:message code="mixmonthlyreport.column.sevenday_train_i" /></th>
                    <!-- 7日重量 -->
                    <th data-options="field:'sevenday_weight_d'"><spring:message code="mixmonthlyreport.column.sevenday_weight_d" /></th>
                    <!-- 8日车数 -->
                    <th data-options="field:'eightday_train_i'"><spring:message code="mixmonthlyreport.column.eightday_train_i" /></th>
                    <!-- 8日重量 -->
                    <th data-options="field:'eightday_weight_d'"><spring:message code="mixmonthlyreport.column.eightday_weight_d" /></th>
                    <!-- 9日车数 -->
                    <th data-options="field:'nineday_train_i'"><spring:message code="mixmonthlyreport.column.nineday_train_i" /></th>
                    <!-- 9日重量 -->
                    <th data-options="field:'nineday_weight_d'"><spring:message code="mixmonthlyreport.column.nineday_weight_d" /></th>
                    <!-- 10日车数 -->
                    <th data-options="field:'tenday_train_i'"><spring:message code="mixmonthlyreport.column.tenday_train_i" /></th>
                    <!-- 10日重量 -->
                    <th data-options="field:'tenday_weight_d'"><spring:message code="mixmonthlyreport.column.tenday_weight_d" /></th>
                    <!-- 11日车数 -->
                    <th data-options="field:'elevenday_train_i'"><spring:message code="mixmonthlyreport.column.elevenday_train_i" /></th>
                    <!-- 11日重量 -->
                    <th data-options="field:'elevenday_weight_d'"><spring:message code="mixmonthlyreport.column.elevenday_weight_d" /></th>
                    <!-- 12日车数 -->
                    <th data-options="field:'twelvenday_train_i'"><spring:message code="mixmonthlyreport.column.twelvenday_train_i" /></th>
                    <!-- 12日重量 -->
                    <th data-options="field:'twelvenday_weight_d'"><spring:message code="mixmonthlyreport.column.twelvenday_weight_d" /></th>
                    <!-- 13日车数 -->
                    <th data-options="field:'thirteenday_train_i'"><spring:message code="mixmonthlyreport.column.thirteenday_train_i" /></th>
                    <!-- 13日重量 -->
                    <th data-options="field:'thirteenday_weight_d'"><spring:message code="mixmonthlyreport.column.thirteenday_weight_d" /></th>
                    <!-- 14日车数 -->
                    <th data-options="field:'fourteenday_train_i'"><spring:message code="mixmonthlyreport.column.fourteenday_train_i" /></th>
                    <!-- 14日重量 -->
                    <th data-options="field:'fourteenday_weight_d'"><spring:message code="mixmonthlyreport.column.fourteenday_weight_d" /></th>
                    <!-- 15日车数 -->
                    <th data-options="field:'fifteenday_train_i'"><spring:message code="mixmonthlyreport.column.fifteenday_train_i" /></th>
                    <!-- 15日重量 -->
                    <th data-options="field:'fifteenday_weight_d'"><spring:message code="mixmonthlyreport.column.fifteenday_weight_d" /></th>
                    <!-- 16日车数 -->
                    <th data-options="field:'sixteenday_train_i'"><spring:message code="mixmonthlyreport.column.sixteenday_train_i" /></th>
                    <!-- 16日重量 -->
                    <th data-options="field:'sixteenday_weight_d'"><spring:message code="mixmonthlyreport.column.sixteenday_weight_d" /></th>
                    <!-- 17日车数 -->
                    <th data-options="field:'seventeenday_train_i'"><spring:message code="mixmonthlyreport.column.seventeenday_train_i" /></th>
                    <!-- 17日重量 -->
                    <th data-options="field:'seventeenday_weight_d'"><spring:message code="mixmonthlyreport.column.seventeenday_weight_d" /></th>
                    <!-- 18日车数 -->
                    <th data-options="field:'eighteenday_train_i'"><spring:message code="mixmonthlyreport.column.eighteenday_train_i" /></th>
                    <!-- 18日重量 -->
                    <th data-options="field:'eighteenday_weight_d'"><spring:message code="mixmonthlyreport.column.eighteenday_weight_d" /></th>
                    <!-- 19日车数 -->
                    <th data-options="field:'ninteenday_train_i'"><spring:message code="mixmonthlyreport.column.ninteenday_train_i" /></th>
                    <!-- 19日重量 -->
                    <th data-options="field:'ninteenday_weight_d'"><spring:message code="mixmonthlyreport.column.ninteenday_weight_d" /></th>
                    <!-- 20日车数 -->
                    <th data-options="field:'twentyday_train_i'"><spring:message code="mixmonthlyreport.column.twentyday_train_i" /></th>
                    <!-- 20日重量 -->
                    <th data-options="field:'twentyday_weight_d'"><spring:message code="mixmonthlyreport.column.twentyday_weight_d" /></th>
                    <!-- 21日车数 -->
                    <th data-options="field:'twentyoneday_train_i'"><spring:message code="mixmonthlyreport.column.twentyoneday_train_i" /></th>
                    <!-- 21日重量 -->
                    <th data-options="field:'twentyoneday_weight_d'"><spring:message code="mixmonthlyreport.column.twentyoneday_weight_d" /></th>
                    <!-- 22日车数 -->
                    <th data-options="field:'twentytwoday_train_i'"><spring:message code="mixmonthlyreport.column.twentytwoday_train_i" /></th>
                    <!-- 22日重量 -->
                    <th data-options="field:'twentytwoday_weight_d'"><spring:message code="mixmonthlyreport.column.twentytwoday_weight_d" /></th>
                    <!-- 23日车数 -->
                    <th data-options="field:'twentythreeday_train_i'"><spring:message code="mixmonthlyreport.column.twentythreeday_train_i" /></th>
                    <!-- 23日重量 -->
                    <th data-options="field:'twentythreeday_weight_d'"><spring:message code="mixmonthlyreport.column.twentythreeday_weight_d" /></th>
                    <!-- 24日车数 -->
                    <th data-options="field:'twentyfourday_train_i'"><spring:message code="mixmonthlyreport.column.twentyfourday_train_i" /></th>
                    <!-- 24日重量 -->
                    <th data-options="field:'twentyfourday_weight_d'"><spring:message code="mixmonthlyreport.column.twentyfourday_weight_d" /></th>
                    <!-- 25日车数 -->
                    <th data-options="field:'twentyfiveday_train_i'"><spring:message code="mixmonthlyreport.column.twentyfiveday_train_i" /></th>
                    <!-- 25日重量 -->
                    <th data-options="field:'twentyfiveday_weight_d'"><spring:message code="mixmonthlyreport.column.twentyfiveday_weight_d" /></th>
                    <!-- 26日车数 -->
                    <th data-options="field:'twentysixday_train_i'"><spring:message code="mixmonthlyreport.column.twentysixday_train_i" /></th>
                    <!-- 26日重量 -->
                    <th data-options="field:'twentysixday_weight_d'"><spring:message code="mixmonthlyreport.column.twentysixday_weight_d" /></th>
                    <!-- 27日车数 -->
                    <th data-options="field:'twentysevenday_train_i'"><spring:message code="mixmonthlyreport.column.twentysevenday_train_i" /></th>
                    <!-- 27日重量 -->
                    <th data-options="field:'twentysevenday_weight_d'"><spring:message code="mixmonthlyreport.column.twentysevenday_weight_d" /></th>
                    <!-- 28日车数 -->
                    <th data-options="field:'twentyeightday_train_i'"><spring:message code="mixmonthlyreport.column.twentyeightday_train_i" /></th>
                    <!-- 28日重量 -->
                    <th data-options="field:'twentyeightday_weight_d'"><spring:message code="mixmonthlyreport.column.twentyeightday_weight_d" /></th>
                    <!-- 29日车数 -->
                    <th data-options="field:'twentynineday_train_i'"><spring:message code="mixmonthlyreport.column.twentynineday_train_i" /></th>
                    <!-- 29日重量 -->
                    <th data-options="field:'twentynineday_weight_d'"><spring:message code="mixmonthlyreport.column.twentynineday_weight_d" /></th>
                    <!-- 30日车数 -->
                    <th data-options="field:'thirtyday_train_i'"><spring:message code="mixmonthlyreport.column.thirtyday_train_i" /></th>
                    <!-- 30日重量 -->
                    <th data-options="field:'thirtyday_weight_d'"><spring:message code="mixmonthlyreport.column.thirtyday_weight_d" /></th>
                    <!-- 31日车数 -->
                    <th data-options="field:'thirtyoneday_train_i'"><spring:message code="mixmonthlyreport.column.thirtyoneday_train_i" /></th>
                    <!-- 31日重量 -->
                    <th data-options="field:'thirtyoneday_weight_d'"><spring:message code="mixmonthlyreport.column.thirtyoneday_weight_d" /></th>
                    <!--总车数-->
					<th width="60" data-options="field:'total_train_i'"><spring:message code="总车数" /></th>
					<!--总重量-->
					<th width="60" data-options="field:'total_weight_d'"><spring:message code="总重量" /></th>
                    <%-- <!-- 机构编号： 柳州 8003 -->
                    <th data-options="field:'agenc_no_s'"><spring:message code="mixmonthlyreport.column.agenc_no_s" /></th>
                    <!-- 归档标记 -->
                    <th data-options="field:'arch_flag_s'"><spring:message code="mixmonthlyreport.column.arch_flag_s" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_s'"><spring:message code="mixmonthlyreport.column.created_by_s" /></th>
                    <!-- 创建人姓名 -->
                    <th data-options="field:'created_name_s'"><spring:message code="mixmonthlyreport.column.created_name_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t'"><spring:message code="mixmonthlyreport.column.created_time_t" /></th>
                    <!-- 机台编码 -->
                    <th data-options="field:'equip_code_s'"><spring:message code="mixmonthlyreport.column.equip_code_s" /></th>
                    <!-- 主键ID -->
                    <th data-options="field:'id_s'"><spring:message code="mixmonthlyreport.column.id_s" /></th>
                    <!-- 主机手姓名 -->
                    <th data-options="field:'master_name_s'"><spring:message code="mixmonthlyreport.column.master_name_s" /></th>
                    <!-- 物料组 -->
                    <th data-options="field:'materialgroup_s'"><spring:message code="mixmonthlyreport.column.materialgroup_s" /></th>
                    <!-- 物料规格 -->
                    <th data-options="field:'materialspec_s'"><spring:message code="mixmonthlyreport.column.materialspec_s" /></th>
                    <!-- 月份 年+月->201808 -->
                    <th data-options="field:'month_s'"><spring:message code="mixmonthlyreport.column.month_s" /></th>
                    <!-- 配方编号 -->
                    <th data-options="field:'recipe_code_s'"><spring:message code="mixmonthlyreport.column.recipe_code_s" /></th>
                    <!-- 配方名称 -->
                    <th data-options="field:'recipe_name_s'"><spring:message code="mixmonthlyreport.column.recipe_name_s" /></th>
                    <!-- 记录标志，A可用，D删除 -->
                    <th data-options="field:'record_flag_s'"><spring:message code="mixmonthlyreport.column.record_flag_s" /></th>
                    <!-- 月产量报表类型：1-密炼、2-半部件、3-成型 -->
                    <th data-options="field:'spare1_s'"><spring:message code="mixmonthlyreport.column.spare1_s" /></th>
                    <!-- 备用字段2 -->
                    <th data-options="field:'spare2_s'"><spring:message code="mixmonthlyreport.column.spare2_s" /></th>
                    <!-- 备用字段3 -->
                    <th data-options="field:'spare3_s'"><spring:message code="mixmonthlyreport.column.spare3_s" /></th>
                    <!-- 备用字段4 -->
                    <th data-options="field:'spare4_s'"><spring:message code="mixmonthlyreport.column.spare4_s" /></th>
                    <!-- 备用字段5 -->
                    <th data-options="field:'spare5_s'"><spring:message code="mixmonthlyreport.column.spare5_s" /></th>
                    <!-- 工厂：1-全钢、2-半钢 -->
                    <th data-options="field:'s_factory_s'"><spring:message code="mixmonthlyreport.column.s_factory_s" /></th> --%>
                    
                    
                </tr>
            </thead>
        </table>
    </div>
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="MixMonthlyReport_search_form" />
		<jsp:param name="datagridId" value="mixmonthlyreport_dg" />
		<jsp:param name="handlerClass"
			value="com.bluebirdme.mes.linglong.mix.export.MixMonthlyReportExportHandler" />
		<jsp:param name="serviceName" value="MixMonthlyReportServiceImpl" />
	</jsp:include>
</body>
</html>
