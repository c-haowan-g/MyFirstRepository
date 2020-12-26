<!-- 

    作者      :刘朋
    时间      :2019-09-04
    页面名称:质量降级汇总表
    文件关联:
        QualityDegrade.java
        QualityDegradeController.java
        QualityDegradeServiceImpl.java
        QualityDegradeServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="qualitydegrade.js.jsp"%>
<script type="text/javascript" src="dict/253,201.js"></script>
<script type="text/javascript" src="resources/libs/ichart.1.1.min.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="QualityDegrade_dg_toolbar">
            <form id="QualityDegrade_search_form" class="form" >
                <spring:message code="qualitydegrade.column.operator_time_t" />:
             	<input name="filter[begin_created_time]" editable="true" id="begin_created_time"
							type="text" class="easyui-datetimebox" style="width:170px"
							data-options="label:''">
						到 <input name="filter[end_created_time]" editable="true" id="end_created_time"
							class="easyui-datetimebox" style="width:170px">
                
                <!-- 轮胎条码 -->
                <spring:message code="qualitydegrade.column.barcode_s" />:
                <input name="filter[barcode_s]" id="barcode_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 硫化机台 -->
                <spring:message code="qualitydegrade.column.curingequip_code_s" />:
                <input name="filter[curingequip_code_s]" like="true" id="curingequip_code_s" type="text" class="easyui-combobox" data-options="data:jtxx,
                panelHeight:150,
                editable:true,
                valueField:'P_LINE_NAME',
                textField:'P_LINE_NAME',
                selectOnNavigation:false,
                limitToList:true" >
              <!--   <input name="filter[curingequip_code_s]" id="curingequip_code_s" like="true" style="width:120px;" class="easyui-combobox" data-options="label:'',
										  panelHeight:200,
										  required:false,
										  editable:true,
										  limitToList:false,
										  url:'lh/scgl/scmxcx/searchByEquipCode',
										  valueField: 'EQUIP_CODE_S',
                              			  textField: 'EQUIP_CODE_S',
										  method:'get'"> -->
				<%-- <!-- 成型机台 -->
                <spring:message code="qualitydegrade.column.buildinmachinecode_s" />:
                <input name="filter[buildinmachinecode_s]" id="buildinmachinecode_s" type="text" like="true" class="easyui-textbox" data-options="label:''" >
             --%>
               
                <br/><br/>
                 <!-- 品号 -->
                <spring:message code="qualitydegrade.column.item_s" />:
                <input name="filter[item_s]" id="item_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 项目分类 -->
                <spring:message code="qualitydegrade.column.pro_type_s" />:
                <input  name="filter[pro_type_s]" id="pro_type_s" type="text" class="easyui-combobox" style="width:155px" data-options="label:'',
                                        required:false, 
                                       	 data: [{
											text: '请选择',
											value: ''
										},{
											text: '硫化报警',
											value: '1'
										},{
											text: '动平衡',
											value: '2'
										},{
											text: '外观判级',
											value: '3'
										},{
											text: 'X光',
											value: '4'
										}],
			                             method: 'get'"> 
			    <!-- 硫化等级 -->
				<spring:message code="workorderresultprint.column.spare5_s" />:
				<input name="filter[curinggrade]" id="curinggrade" like="true" style="width:110px;" type="text" class="easyui-combotree" data-options="label:'',
						                  labelWidth:'auto',
										  panelHeight:150,
										  required:false,
										  url:'dict/code/253',
										  method:'get'">
                <%-- <!-- 病象 -->
                <input name="filter[reascode_s_s]" id="reascode_s_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="qualitydegrade.column.reascode_s_s" />'" >
                <!-- 硫化时间 -->
                <input name="filter[curingtime_t]" id="curingtime_t" type="text" class="easyui-textbox" data-options="label:'<spring:message code="qualitydegrade.column.curingtime_t" />'" >
                <!-- 动平衡等级 -->
                <input name="filter[dynamicbalancegradecode_s]" id="dynamicbalancegradecode_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="qualitydegrade.column.dynamicbalancegradecode_s" />'" >
                
                <!-- 来源  1-报警;2-检测;3-改判 -->
                <input name="filter[source_s]" id="source_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="qualitydegrade.column.source_s" />'" >
                 --%><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="productionDetails"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-log'" onclick="productionDetail()"><spring:message code="button.searchDetail" /></a></auth:button>
            <auth:button code="lh_bb_jj_sh"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-edit'" onclick="auditingOperate()"><spring:message code="button.auditing" /></a></auth:button>
            <auth:button code="lh_bb_zjjj_cxsh"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="unauditingOperate()"><spring:message code="button.unauditing" /></a></auth:button>
            <auth:button code="lh_bb_zjjj_edit"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
         
         	<%--  <auth:button code="LH_BB_LHCLBB_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
		  --%>            
            <auth:button code="LH_SCJH_YJHCANCEL">
				<a class="easyui-linkbutton btn-yellow"
					data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message
						code="button.cancel" /></a>
			</auth:button>
        </div>
        <table id="qualitydegrade_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
              	fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: true,
                toolbar: '#QualityDegrade_dg_toolbar',
                url: '',
                onDblClickRow:onDblClickRow,
                striped:true,
                emptyMsg:'暂无数据' ,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 审核状态 -->
                    <th data-options="field:'auditing_status_s',formatter:isauditing,editor:{type:'textbox',options:{editable:false,icons:[],disabled:true}}"><spring:message code="qualitydegrade.column.auditing_status_s" /></th>
                    <!-- 来源  1-报警;2-检测;3-改判 -->
                    <th data-options="field:'source_s',formatter:sourceFormatter,editor:{type:'textbox',options:{editable:false,icons:[],disabled:true}}"><spring:message code="qualitydegrade.column.source_s" /></th>
                    <!-- 轮胎条码 -->
                    <th data-options="field:'barcode_s',editor:{type:'textbox',required:true,options:{editable:false,icons:[],disabled:true}}"><spring:message code="qualitydegrade.column.barcode_s" /></th>
                   <%--  <!-- 成型机台 -->
                    <th data-options="field:'buildinmachinecode_s',editor:{type:'textbox',options:{editable:false,icons:[],disabled:true}}"><spring:message code="qualitydegrade.column.buildinmachinecode_s" /></th>
                     --%><!-- 硫化机台 -->
                    <th data-options="field:'curingequip_code_s',editor:{type:'textbox',options:{editable:false,icons:[],disabled:true}}"><spring:message code="qualitydegrade.column.curingequip_code_s" /></th>
                    <!-- 硫化时间 -->
                    <th data-options="field:'curingtime_t',editor:{type:'textbox',options:{editable:false,icons:[],disabled:true}}"><spring:message code="qualitydegrade.column.curingtime_t" /></th>
                    <!-- 硫化工人-->
                    <th data-options="field:'curinguserid_s',editor:{type:'textbox',options:{editable:false,icons:[],disabled:true}}"><spring:message code="c_mm_workorderresult.column.curing_worker_s" /></th>
                    <!-- 判定级别 -->
                    <th	data-options="field:'gradecode',formatter:codeFormatter,sortable:true,editor:{type:'combobox',options:{editable:false,icons:[],disabled:true}}"><spring:message code="qualitydegrade.column.judge_grade_s" /></th>
                    <!-- 硫化等级等级 -->
                    <th data-options="field:'curinggrade',formatter:codeFormatter,
	                    editor:{type:'combobox',options:{
	                    	required:true,
	                    	url:'curing/report/qualitydegrade/getlist',
	                    	valueField: 'GRADECODE_I',
	                    	textField: 'GRADEDESC_S',
	                    	limitToList:true,
	                    	labelPosition: 'top',
	                    	panelHeight:130,
	                    	editable:true
	                    }}">
                    <spring:message code="c_mm_workorderresult.column.spare5_s" /></th>
                   <%--  <!-- 动平衡等级 -->
                    <th data-options="field:'dynamicbalancegradecode_s',formatter:codeFormatter,editor:{type:'textbox',options:{editable:false,icons:[],disabled:true}}"><spring:message code="qualitydegrade.column.dynamicbalancegradecode_s" /></th>
                     --%>
					<%-- <th data-options="field:'gradecode',formatter:codeFormatter,editor:{type:'textbox'}"></th>
                     --%><!-- 项目分类 -->
                    <th data-options="field:'pro_type_s',formatter:proFormatter,editor:{type:'textbox',options:{editable:false,icons:[],disabled:true}}"><spring:message code="qualitydegrade.column.pro_type_s" /></th>
                    <!-- 操作员 -->
                    <th data-options="field:'operator',editor:{type:'textbox',options:{editable:false,icons:[],disabled:true}}"><spring:message code="qualitydegrade.column.operator_s" /></th>
                    <!-- 操作时间 -->
                    <th data-options="field:'operator_time_t',editor:{type:'textbox',options:{editable:false,icons:[],disabled:true}}"><spring:message code="qualitydegrade.column.operator_time_t" /></th>
                    <!-- 品号 -->
                    <th data-options="field:'item_s',editor:{type:'textbox',options:{editable:false,icons:[],disabled:true}}"><spring:message code="qualitydegrade.column.item_s" /></th>
                    <!-- 规格名称 -->
                    <th data-options="field:'specname_s',editor:{type:'textbox',options:{editable:false,icons:[],disabled:true}}"><spring:message code="qualitydegrade.column.specname_s" /></th>
                    <!-- 病象 -->
                    <th data-options="field:'reascode_s_s',editor:{type:'textbox',options:{editable:false,icons:[],disabled:true}}"><spring:message code="qualitydegrade.column.reascode_s_s" /></th>
                    <!-- 判定人 -->
                    <th data-options="field:'judge_userid',editor:{type:'textbox',options:{editable:false,icons:[],disabled:true}}"><spring:message code="qualitydegrade.column.judge_userid_s" /></th>
                    <!-- 判定人时间 -->
                    <th data-options="field:'judge_time_t',editor:{type:'textbox',options:{editable:false,icons:[],disabled:true}}"><spring:message code="qualitydegrade.column.judge_time_t" /></th>
                    <!-- 审核人ID -->
                    <th data-options="field:'auditing_userid',editor:{type:'textbox',options:{editable:false,icons:[],disabled:true}}"><spring:message code="qualitydegrade.column.auditing_userid_s" /></th>
                    <!-- 审核时间 -->
                    <th data-options="field:'auditing_time_t',editor:{type:'textbox',options:{editable:false,icons:[],disabled:true}}"><spring:message code="qualitydegrade.column.auditing_time_t" /></th>
                    <!-- 审核意见 -->
                    <th data-options="field:'auditing_opinion_s',editor:{type:'textbox',options:{editable:false,icons:[],disabled:true}}"><spring:message code="qualitydegrade.column.auditing_opinion_s" /></th>
                    
                </tr>
            </thead>
        </table>
        <div id="productionDetail" class="easyui-window" title="<spring:message code="button.curingAlarmDetail" />" data-options="modal:true,closed:true,iconCls:'icon-log',tools:'#tt'" style="width:90%;height:90%;padding:10px;">
	       <div id="PlandhHeeader_dg_toolbarTwo">
	            <%-- <form id="PlandhHeeader_search_formTwo" class="form" >
	                <spring:message code="qualitydegrade.column.barcode_s" />
                	<input name="filter[barcode]" id="barcode" type="text" class="easyui-textbox" data-options="label:''" >
                	<!-- 轮胎编码-->
	                <spring:message code="actualamountitem.column.barcode_s" />
	                <input name="filter[barcode_s]" id="barcode_s" like="true" type="text" class="easyui-textbox" data-options="label:''" >
	                <!-- 物料编码-->
	                <spring:message code="plandnitem.column.materialcode_s" />
	                <input name="filter[materialcode_s]" id="materialcode_sTwo" like="true" type="text" like="true" class="easyui-textbox" data-options="label:''" >
	                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filterTwo()"><spring:message code="button.search" /></a>
	               </form>  --%>
	        </div>
        <table id="plandhheeader_dgTwo" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:false,
                fitColumns:false,
                singleSelect: false,
                toolbar: '#PlandhHeeader_dg_toolbarTwo',
                striped:true,
                url:'',
                method: 'get',
                onDblClickRow:onDblClickRowDetail,
                emptyMsg:'<span><spring:message code='tip.noData'/></span>'
                ">
            <thead>
                <tr>
                    <th data-options="field:'ATR_KEY',checkbox:true"></th>
                    <!-- 硫化机台 -->
                    <th data-options="field:'CURINGMACHINECODE_S',editor:{type:'textbox'}"><spring:message code="qualitydegrade.column.curingequip_code_s" /></th>
              		<!-- 轮胎条码 -->
                    <th data-options="field:'TYRE_BARCODE_S',editor:{type:'textbox'}"><spring:message code="qualitydegrade.column.barcode_s" /></th>
                    <!-- 报警时间 -->
					<th data-options="field:'ALERT_TIME_S',editor:{type:'textbox'}"><spring:message code="alertsrecord.column.alert_time_s" /></th>
					<!-- 报警代码 -->
					<th data-options="field:'ALERT_CODE_S',editor:{type:'textbox'}"><spring:message code="alertsrecord.column.alert_code_s" /></th>
					<!-- 报警来源 -->
					<th data-options="field:'ALARM_FROM_S',editor:{type:'textbox'}"><spring:message code="alertsrecord.column.alarm_from_s" /></th>
					<!-- 报警内容 -->
					<th data-options="width:200,field:'ALERT_CONTENT_S',editor:{type:'textbox'}"><spring:message code="alertsrecord.column.alert_content_s" /></th>
					<!-- 步序号 -->
					<th data-options="field:'SPARE1_S',editor:{type:'textbox'}"><spring:message code="alertsrecord.column.spare1_s" /></th>
					<!-- 持续时间-->
					<th data-options="field:'SPARE2_S',editor:{type:'textbox'}"><spring:message code="alertsrecord.column.spare2_s" /></th>
					<!-- 报警次数 -->
					<th data-options="field:'ALARM_NUMBER_I',editor:{type:'textbox'}"><spring:message code="alertsrecord.column.alarm_number_i" /></th>
					<!-- 报警值 -->
					<th data-options="field:'ALERT_VALUE_S',editor:{type:'textbox'}"><spring:message code="alertsrecord.column.alert_value_s" /></th>
					<!-- 报警等级 -->
					<th data-options="field:'ALERT_LEVEL_S',formatter:codeFormatter,editor:{type:'combotree',options:{
	        			method:'get',
	                    url:'dict/code/201',
	        			required:true}}">
					<spring:message code="alertsrecord.column.alert_level_s" /></th>
					
					<!-- 报警处理状态基础数据234  1未处理 2已下发 3已放行 4已恢复 -->
					<th data-options="field:'ALERT_STATUS_S',formatter:codeFormatter,editor:{type:'combotree',options:{
	        			method:'get',
	                    url:'dict/code/234',
	        			required:true}}">
					<spring:message code="alertsrecord.column.alert_status_s" /></th>
					<!-- 操作人 -->
					<th data-options="field:'OPERATOR',editor:{type:'textbox'}"><spring:message code="alertsrecord.column.operator_s" /></th>
					<!-- 恢复时间 -->
					<th data-options="field:'RECOVERY_TIME_S',editor:{type:'textbox'}"><spring:message code="alertsrecord.column.recovery_time_s" /></th>
					<!-- 恢复值 -->
					<th data-options="field:'RECOVERY_VALUE_S',editor:{type:'textbox'}"><spring:message code="alertsrecord.column.recovery_value_s" /></th>
					<!-- 确认质量 -->
					<th data-options="field:'QUALITY_S',editor:{type:'textbox'}"><spring:message code="alertsrecord.column.quality_s" /></th>
					<!-- 质量确认人 -->
					<th data-options="field:'QUALITY_CONFIRMOR',editor:{type:'textbox'}"><spring:message code="alertsrecord.column.quality_confirmor_s" /></th>
					<!-- 质量确认时间 -->
					<th data-options="field:'QUALITY_CONFIRMTIME_T',editor:{type:'textbox'}"><spring:message code="alertsrecord.column.quality_confirmtime_t" /></th>
               </tr>
            </thead>
        </table>
      </div>
		<div id="dynaDetail" class="easyui-window"
			title="<spring:message code="button.dynabalancelDetail" />"
			data-options="modal:true,closed:true,iconCls:'icon-log',tools:'#tt'"
			style="width:90%;height:90%;padding:10px;">
			<div id="dyna_dg_toolbarDetail"></div>
			<table id="dyna_dgDetail" class="easyui-datagrid"
				style="width:100%"
				data-options="  
                fit:true,
                fitColumns:true,
                singleSelect: false,
                toolbar: '#dyna_dg_toolbarDetail',
                striped:true,
                method: 'get',
                emptyMsg:'<span><spring:message code='tip.noData'/></span>'
                ">
				<thead>
					<tr>
						<th data-options="field:'ATR_KEY',checkbox:true"></th>
						<!-- 动平衡机台条码：D_EM_Ent 表 ENTBARCODE -->
						<th data-options="field:'MACHINEBAR_S',formatter:entCodeFormatter"><spring:message
								code="dynabalancecheresult.column.machinebar_s" /></th>
						<!-- 轮胎条码：MainTyre 表 BARCODE -->
						<th data-options="field:'BARCODE_S'"><spring:message
								code="dynabalancecheresult.column.barcode_s" /></th>
						<!-- 物料编码 -->
						<th data-options="field:'CURINGSPECCODE_S'"><spring:message
								code="hhhh.column.material_code_s" /></th>
						<!-- 物料描述 -->
						<th width="230" data-options="field:'MATERIALDESC_S'"><spring:message
								code="hhhh.column.material_name_s" /></th>
						<!-- 测试时间 -->
						<th width="130" data-options="field:'OUTPUTTIME_T'"><spring:message
								code="dynabalancecheresult.column.outputtime_t" /></th>
						<!-- 轮胎总等级 -->
						<th
							data-options="field:'TIRE_TOTAL_RATINGS_S',formatter:codeFormatter"><spring:message
								code="dynabalancecheresult.column.tire_total_ratings_s" /></th>
						<!-- 动平衡总等级 -->
						<th data-options="field:'BALANCETOTAL_RANK_S'"><spring:message
								code="dynabalancecheresult.column.balancetotal_rank_s" /></th>
						<!-- 跳动度总等级 -->
						<th data-options="field:'ROTOTAL_RANK_S'"><spring:message
								code="dynabalancecheresult.column.rototal_rank_s" /></th>
						<!-- 均匀性总等级 -->
						<th data-options="field:'UFM_TOTALRANK_S'"><spring:message
								code="dynabalancecheresult.column.ufm_totalrank_s" /></th>
					</tr>
				</thead>
			</table>
		</div>
		<div id="detialDetail" class="easyui-window"
			title="<spring:message code="button.dynabalancelDetail" />"
			data-options="modal:true,closed:true,iconCls:'icon-log',tools:'#tt'"
			style="width:90%;height:90%;padding:10px;">
			<div id="detial_dg_toolbarDetail"></div>
			<table id="detial_dgDetail" class="easyui-datagrid"
				style="width:100%"
				data-options="  
                fit:true,
                fitColumns:true,
                singleSelect: false,
                toolbar: '#detial_dg_toolbarDetail',
                striped:true,
                method: 'get',
                emptyMsg:'<span><spring:message code='tip.noData'/></span>'
                ">
				<thead>
					<tr>
						<th data-options="field:'ATR_KEY',checkbox:true"></th>
						<!-- 硫化机台 -->
	                    <th data-options="field:'CURINGMACHINECODE_S'"><spring:message code="detial.column.curingmachinecode_s" /></th>
	                    <!-- 轮胎条码：MainTyre 表 BARCODE -->
	                    <th data-options="field:'BARCODE_S'"><spring:message code="detial.column.barcode_s" /></th>
	                	<!-- 当前状态 -->
	                    <th data-options="field:'NOWSTATE'"><spring:message code="detial.column.nowstate" /></th>
	                    <!-- 判级状态 -->
	                    <th data-options="field:'PJSTATE'"><spring:message code="detial.column.pjstate" /></th> 
	                	<!-- 总返修次数 -->
	                    <th data-options="field:'TOTALREWORKNUM_I'"><spring:message code="maintyre.column.totalreworknum_i" /></th>
	                	<!-- 病象描述 -->
	                    <th data-options="field:'REAS_CN_S'"><spring:message code="detial.column.reas_cn_s" /></th>
	                	<!-- 病象类描述 -->
	                    <th data-options="field:'COLLET_CODE_DESC_CN_S'"><spring:message code="reas.column.collet_code_desc_cn_s" /></th>
	                	<!-- 品号 -->
	                    <th data-options="field:'ITEMID_S'"><spring:message code="detial.column.itemid_s" /></th>
	                	<!-- 规格名称-->
	                    <th data-options="field:'MATERIALDESC_S'"><spring:message code="workorderresultprint.column.material_code_s" /></th>
	                	<!-- 质检员工号 -->
	                    <th data-options="field:'OPERBY_S',editor:{type:'textbox',options:{required:true}}"><spring:message code="detial.column.operby_s" /></th>
	                    <!-- 质检时间 -->
	                    <th data-options="field:'OPERTIME_T'"><spring:message code="detial.column.opertime_t" /></th>
	                    <!-- 外观检查工位 -->
	                    <th data-options="field:'APPEARANCEMBAR_S'"><spring:message code="detial.column.appearancembar_s" /></th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
  <div id="lh_qx" class="easyui-window" title="查看硫化曲线"  maximized="true"  style="width:1200px;height:700px" closed="true">
         	
  <div id='canvasDiv'  ></div>
  
    </div>
</body>
</html>
