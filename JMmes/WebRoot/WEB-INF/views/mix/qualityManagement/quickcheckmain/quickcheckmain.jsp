<!-- 

    作者      :栾和源
    时间      :2020-12-17 11:12:27 
    页面名称:密炼胶料快检主表
    文件关联:
        QuickCheckMain.java
        QuickCheckMainController.java
        QuickCheckMainServiceImpl.java
        QuickCheckMainServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="quickcheckmain.js.jsp"%>
<script type="text/javascript" src="dict/001,302.js"></script>
<script type="text/javascript" src="resources/libs/ichart.1.1.min.js"></script>

<body class="easyui-layout" fit="true">
<div data-options="region:'center',split:true" style="width:100%;" title="快检实绩Main">
    <%--<div data-options="region:'center',split:true,border:false" >--%>
        <div id="QuickCheckMain_dg_toolbar">
            <form id="QuickCheckMain_search_form" class="form" >

                 生产日期
                <input name="filter[start_time]" id="start_time" type="text"  class="easyui-datebox" style="width:100px"  data-options="onChange:filter,formatter:dateFormat,buttons:[],parser:dateParser,label:''" >
				<spring:message code="tip.to" /> &nbsp;
				 <input name="filter[end_time]" id="end_time" type="text"  class="easyui-datebox" style="width:100px"  data-options="onChange:filter,formatter:dateFormat,buttons:[],parser:dateParser,label:''" >
					<script type="text/javascript">
	                $("#start_time").val(new Calendar().format("yyyyMMdd"));
	                $("#end_time").val(new Calendar().format("yyyyMMdd"));
	            </script>
	            
	            &nbsp; &nbsp; 生产班次
                <input name="filter[prod_shiift_s]" id="prod_shiift_s" type="text" class="easyui-combotree"  style="width: 100px"   data-options="labelWidth:'auto',
                                            panelHeight:100,
										    required:false,
										    editable:false,
										    data:shiftCodeContent,
										    textField:'text',
										    valueField:'code',
										    method:'get'" >
                <!-- 物料编码 -->
                <spring:message code="quickcheckmain.column.material_code_s" />
                <input name="filter[material_code_s]" id="material_code_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!--物料名称material_name_s-->
                物料名称
                <input name="filter[material_name_s]" id="material_name_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!--密炼机-->
                密炼机
                <input name="filter[equip_code_s]" id="equip_code_s" style="width:150px" type="text" class="easyui-combobox" data-options="label:'',
	          		   data:equiplist,
	         		   panelHeight:150,
	         		   editable:true,
	           		   valueField:'p_line_name',
	          		   textField:'description',
	                   selectOnNavigation:false,
	           		   limitToList:true,
	          		   filter:searchProductionLine,
	           		   onChange:filter">
                <!-- 试样号 -->
                <spring:message code="quickcheckmain.column.sampleno_s" />
                <input name="filter[sampleno_s]" id="sampleno_s" type="text" class="easyui-textbox" data-options="label:''" >
                 <!-- 快检检验配方编号 -->
                <spring:message code="quickcheckmain.column.quickcheck_recipe_code_s" />
                <input name="filter[quickcheck_recipe_code_s]" id="quickcheck_recipe_code_s" type="text" class="easyui-textbox" data-options="label:''" >
                 <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form>
            <auth:button code="quickchecjmain_LBWD"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-para'" onclick="ichartML('LBWD')">流变温度曲线</a>  </auth:button>
            <auth:button code="quickchecjmain_LBNJ"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-para'" onclick="ichartML('LBNJ')">流变扭矩曲线</a>  </auth:button>
            <auth:button code="quickchecjmain_MNWD"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-para'" onclick="ichartML('MNWD')">门尼温度曲线</a>  </auth:button>
            <auth:button code="quickchecjmain_MNNJ"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-para'" onclick="ichartML('MNNJ')">门尼扭矩曲线</a>  </auth:button>
        </div>
        <table id="quickcheckmain_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                onSelect:selectrow,
                toolbar: '#QuickCheckMain_dg_toolbar',
                url: 'mix/qualityManagement/quickCheckMain/datagrid',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <%--<!-- 主键ID -->--%>
                    <%--<th data-options="width:80,field:'id_s',editor:{type:'textbox'}"><spring:message code="quickcheckmain.column.id_s" /></th>--%>
                     <!-- 生产日期 -->
                    <th data-options="width:80,field:'prod_date_s',editor:{type:'textbox'}">生产日期</th>
                     <!-- 生产班次 -->
                    <th data-options="width:80,field:'prod_shiift_s',formatter:codeFormatter,editor:{type:'textbox'}">生产班次</th>
                    <!-- 取样试样号：喷码编码 -->
                    <th data-options="width:80,field:'sampleno_s',editor:{type:'textbox'}"><spring:message code="quickcheckmain.column.sampleno_s" /></th>
                    <!-- 取样车次号 -->
                    <th data-options="width:80,field:'train_num_s',editor:{type:'textbox'}"><spring:message code="quickcheckmain.column.train_num_s" /></th>
                    <!-- 最终检测结果 -->
                    <th data-options="width:80,field:'state_code_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="quickcheckmain.column.state_code_s" /></th>
                    <!-- 顺序号 -->
                    <th data-options="width:80,field:'seq_i',editor:{type:'textbox'}"><spring:message code="quickcheckmain.column.seq_i" /></th>
                    <!-- 密炼工单跟踪表，工单号 -->
                    <th data-options="width:80,field:'wo_no_s',editor:{type:'textbox'}"><spring:message code="quickcheckmain.column.wo_no_s" /></th>
                    <!-- 快检班次 -->
                    <th data-options="width:80,field:'shiift_check_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="quickcheckmain.column.shiift_check_s" /></th>
                    <!-- 快检检验配方编号 -->
                    <th data-options="width:80,field:'quickcheck_recipe_code_s',editor:{type:'textbox'}"><spring:message code="quickcheckmain.column.quickcheck_recipe_code_s" /></th>
                    <!-- 生产机台条码 -->
                    <th data-options="width:80,field:'equip_code_s',editor:{type:'textbox'}"><spring:message code="quickcheckmain.column.equip_code_s" /></th>
                    <!-- 生产机台名称 -->
                    <th data-options="width:80,field:'equip_name_s',editor:{type:'textbox'}"><spring:message code="quickcheckmain.column.equip_name_s" /></th>
                    <!-- 硫变仪机台条码 -->
                    <th data-options="width:80,field:'equip_sa_s',formatter:lbformatter,editor:{type:'textbox'}"><spring:message code="quickcheckmain.column.equip_sa_s" /></th>
                    <!-- 门尼机台条码 -->
                    <th data-options="width:80,field:'equip_mi_s',formatter:mnformatter,editor:{type:'textbox'}"><spring:message code="quickcheckmain.column.equip_mi_s" /></th>
                    <!-- 胶料批次号 -->
                    <th data-options="width:80,field:'lot_no_s',editor:{type:'textbox'}"><spring:message code="quickcheckmain.column.lot_no_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="width:80,field:'material_code_s',editor:{type:'textbox'}"><spring:message code="quickcheckmain.column.material_code_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="width:80,field:'material_name_s',editor:{type:'textbox'}"><spring:message code="quickcheckmain.column.material_name_s" /></th>
                    <!-- 产出时间 -->
                    <th data-options="width:80,field:'product_time_s',editor:{type:'textbox'}"><spring:message code="quickcheckmain.column.product_time_s" /></th>
                    <!-- 物料过期日期 -->
                    <th data-options="width:80,field:'expiry_date_s',editor:{type:'textbox'}"><spring:message code="quickcheckmain.column.expiry_date_s" /></th>
                    <!-- 质量备注 -->
                    <th data-options="width:80,field:'qc_mark_s',editor:{type:'textbox'}"><spring:message code="quickcheckmain.column.qc_mark_s" /></th>
                    <!-- 最终检验人员 -->
                    <th data-options="width:80,field:'check_by_s',editor:{type:'textbox'}"><spring:message code="quickcheckmain.column.check_by_s" /></th>
                    <!-- 最终检验人姓名 -->
                    <th data-options="width:80,field:'check_name_s',editor:{type:'textbox'}"><spring:message code="quickcheckmain.column.check_name_s" /></th>
                    <!-- 最终检测日期 -->
                    <th data-options="width:80,field:'check_time_s',editor:{type:'textbox'}"><spring:message code="quickcheckmain.column.check_time_s" /></th>
                   <!-- 是否曲线判：Y-是、N-否 -->
                    <th data-options="width:80,field:'decisionbyline_s',formatter:decisionbyline,editor:{type:'textbox'}"><spring:message code="quickcheckmain.column.decisionbyline_s" /></th>
                    <!-- 是否发送密炼：Y-是、N-否 -->
                    <th data-options="width:80,field:'is_sendmix_s',formatter:isSendmix,editor:{type:'textbox'}"><spring:message code="quickcheckmain.column.is_sendmix_s" /></th>
                     <!--Ts1-->
                    <th data-options="width:80,field:'spare1_s',editor:{type:'textbox'}"><spring:message code="quickcheckmain.column.ts" /></th>
                     <!-- 备用字段3 -->
                 	 <th data-options="field:'spare3_s',editor:{type:'textbox'}">T25S</th>
                    <!-- 接收时间 -->
                    <th data-options="width:80,field:'receive_time_t',editor:{type:'textbox'}"><spring:message code="quickcheckmain.column.receive_time_t" /></th>
                    <!-- 创建人 -->
                    <th data-options="width:80,field:'created_by_s',editor:{type:'textbox'}"><spring:message code="quickcheckmain.column.created_by_s" /></th>
                    <!-- 创建人姓名 -->
                    <th data-options="width:80,field:'created_name_s',editor:{type:'textbox'}"><spring:message code="quickcheckmain.column.created_name_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="width:80,field:'created_time_t',editor:{type:'textbox'}"><spring:message code="quickcheckmain.column.created_time_t" /></th>
                    <!-- 修改人 -->
                    <th data-options="width:80,field:'changed_by_s',editor:{type:'textbox'}"><spring:message code="quickcheckmain.column.changed_by_s" /></th>
                    <!-- 修改人姓名 -->
                    <th data-options="width:80,field:'changed_name_s',editor:{type:'textbox'}"><spring:message code="quickcheckmain.column.changed_name_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="width:80,field:'changed_time_t',editor:{type:'textbox'}"><spring:message code="quickcheckmain.column.changed_time_t" /></th>
                    <!-- 备用字段2 -->
                 	<th data-options="width:80,field:'spare2_s',editor:{type:'textbox'}"><spring:message code="quickcheckmain.column.spare2_s" /></th>
                 	 <!-- 备用字段3 -->
                 	 <th data-options="width:80,field:'spare3_s',editor:{type:'textbox'}"><spring:message code="quickcheckmain.column.spare3_s" /></th>
                  	<!-- 备用字段4 -->
                  	<th data-options="width:80,field:'spare4_s',editor:{type:'textbox'}"><spring:message code="quickcheckmain.column.spare4_s" /></th>
                 	<!-- 备用字段5 -->
                  	<th data-options="width:80,field:'spare5_s',editor:{type:'textbox'}"><spring:message code="quickcheckmain.column.spare5_s" /></th>
<%--                    <!-- 数据来源：075001-全钢-万向、075002-全钢-北院、075003-半钢-软控、075004-半钢-万向、075005-人工配料、075006-快检 -->--%>
<%--                    <th data-options="width:80,field:'datasource_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="quickcheckmain.column.datasource_s" /></th>--%>
<%--                    <!-- 工厂 -->--%>
<%--                    <th data-options="width:80,field:'s_factory_s',formatter:factorymain,editor:{type:'textbox'}"><spring:message code="quickcheckmain.column.s_factory_s" /></th>--%>
<%--                    <!-- 机构编号 -->--%>
<%--                    <th data-options="width:80,field:'agenc_no_s',editor:{type:'textbox'}"><spring:message code="quickcheckmain.column.agenc_no_s" /></th>--%>
<%--                    <!-- 归档标记 -->--%>
<%--                    <th data-options="width:80,field:'arch_flag_s',editor:{type:'textbox'}"><spring:message code="quickcheckmain.column.arch_flag_s" /></th>--%>
<%--                         <!-- 记录标志，A可用，D删除 -->--%>
<%--                    <th data-options="width:80,field:'record_flag_s',formatter:recordFlag,editor:{type:'textbox'}"><spring:message code="quickcheckmain.column.record_flag_s" /></th>--%>
                </tr>
            </thead>
        </table>
    </div>
    <div data-options="region:'south',split:true" title="快检实绩Detail" style="height:200px;">
        <table id="quickcheckdetail_dg" class="easyui-datagrid" style="width:100%"
               data-options="
                 fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                striped:true,
                method: 'get'
                ">
            <thead>
            <tr>
                <%--<th data-options="width:80,field:'atr_key',checkbox:true"></th>--%>
                <!-- 检验项目类型 -->
                <th data-options="width:80,field:'INSPECTIONITEMNAME_S',width:80,editor:{type:'textbox'}"><spring:message code="quickcheckpart.column.inspectionitemname_s" /></th>
                <!-- 检测方法 -->
                <th data-options="width:80,field:'TESTMETHOD_S',width:80,editor:{type:'textbox'}"><spring:message code="quickcheckpart.column.testmethod_s" /></th>
                <!-- 上限值符号：0-不包含、1-包含 -->
                <th data-options="width:80,field:'VALUEMAXSIGN_S',formatter:valuemaxsign,width:80,editor:{type:'textbox'}"><spring:message code="quickcheckpart.column.valuemaxsign_s" /></th>
                <!-- 上限值 -->
                <th data-options="width:80,field:'VALUEMAX_S',width:80,editor:{type:'textbox'}"><spring:message code="quickcheckpart.column.valuemax_s" /></th>
                <!-- 下限值符号：0-不包含、1-包含 -->
                <th data-options="width:80,field:'VALUEMINSIGN_S',formatter:valueminsign,width:80,editor:{type:'textbox'}"><spring:message code="quickcheckpart.column.valueminsign_s" /></th>
                <!-- 下限值 -->
                <th data-options="width:80,field:'VALUEMIN_S',width:80,editor:{type:'textbox'}"><spring:message code="quickcheckpart.column.valuemin_s" /></th>
                <!-- 标准值 -->
                <th data-options="width:80,field:'VALUE_S',width:80,editor:{type:'textbox'}"><spring:message code="quickcheckpart.column.value_s" /></th>
                <%--<!-- 机构编号 -->--%>
                <%--<th data-options="width:80,field:'AGENC_NO_S',width:80,editor:{type:'textbox'}"><spring:message code="quickcheckpart.column.agenc_no_s" /></th>--%>
                <%--<!-- 主键ID -->--%>
                <%--<th data-options="width:80,field:'ID_S',width:80,editor:{type:'textbox'}"><spring:message code="quickcheckpart.column.id_s" /></th>--%>
                 <%--<!-- 密炼胶料快检主表ID -->--%>
                <%--<th data-options="width:80,field:'QUICKCHECKMAIN_ID_S',width:80,editor:{type:'textbox'}"><spring:message code="quickcheckpart.column.quickcheckmain_id_s" /></th>--%>
                <!-- 接收时间 -->
                <th data-options="width:80,field:'RECEIVE_TIME_T',width:80,editor:{type:'textbox'}"><spring:message code="quickcheckpart.column.receive_time_t" /></th>
                <%--<!-- 记录标志，A可用，D删除 -->--%>
                <%--<th data-options="width:80,field:'RECORD_FLAG_S',formatter:recordFlag1,width:80,editor:{type:'textbox'}"><spring:message code="quickcheckpart.column.record_flag_s" /></th>--%>
                <!-- 检查结果：Y-合格、N-不合格 -->
                <th data-options="width:80,field:'RESULT_S',formatter:checkResult,width:80,editor:{type:'textbox'}"><spring:message code="quickcheckpart.column.result_s" /></th>
                <%--<!-- 工厂：1-全钢、2-半钢 -->--%>
                <%--<th data-options="width:80,field:'S_FACTORY_S',formatter:factorydetail,width:80,editor:{type:'textbox'}"><spring:message code="quickcheckpart.column.s_factory_s" /></th>--%>
                        <%--<!-- 修改人 -->--%>
                <%--<th data-options="width:80,field:'CHANGED_BY_S',width:80,editor:{type:'textbox'}"><spring:message code="quickcheckpart.column.changed_by_s" /></th>--%>
                <%--<!-- 修改人姓名 -->--%>
                <%--<th data-options="width:80,field:'CHANGED_NAME_S',width:80,editor:{type:'textbox'}"><spring:message code="quickcheckpart.column.changed_name_s" /></th>--%>
                <%--<!-- 修改时间 -->--%>
                <%--<th data-options="width:80,field:'CHANGED_TIME_T',width:80,editor:{type:'textbox'}"><spring:message code="quickcheckpart.column.changed_time_t" /></th>--%>
                <%--<!-- 创建人 -->--%>
                <%--<th data-options="width:80,field:'CREATED_BY_S',width:80,editor:{type:'textbox'}"><spring:message code="quickcheckpart.column.created_by_s" /></th>--%>
                <%--<!-- 创建人姓名 -->--%>
                <%--<th data-options="width:80,field:'CREATED_NAME_S',width:80,editor:{type:'textbox'}"><spring:message code="quickcheckpart.column.created_name_s" /></th>--%>
                <%--<!-- 创建时间 -->--%>
                <%--<th data-options="width:80,field:'CREATED_TIME_T',width:80,editor:{type:'textbox'}"><spring:message code="quickcheckpart.column.created_time_t" /></th>--%>
                <!-- 预留1 -->
                <th data-options="width:80,field:'DUMMY1_S',width:140,editor:{type:'textbox'}"><spring:message code="quickcheckpart.column.dummy1_s" /></th>
                <!-- 预留2 -->
                <th data-options="width:80,field:'DUMMY2_S',width:80,formatter:testmethod,editor:{type:'textbox'}"><spring:message code="quickcheckpart.column.dummy2_s" /></th>
                <!-- 预留3 -->
                <th data-options="width:80,field:'DUMMY3_S',width:80,editor:{type:'textbox'}"><spring:message code="quickcheckpart.column.dummy3_s" /></th>
                <!-- 预留4 -->
                <th data-options="width:80,field:'DUMMY4_S',width:80,editor:{type:'textbox'}"><spring:message code="quickcheckpart.column.dummy4_s" /></th>
                <!-- 预留5 -->
                <th data-options="width:80,field:'DUMMY5_S',width:80,editor:{type:'textbox'}"><spring:message code="quickcheckpart.column.dummy5_s" /></th>
                <%--<!-- 归档标记 -->--%>
                <%--<th data-options="width:80,field:'ARCH_FLAG_S',width:80,editor:{type:'textbox'}"><spring:message code="quickcheckpart.column.arch_flag_s" /></th>--%>
            </tr>
            </thead>
        </table>
    </div>
     <div id="lh_qx" class="easyui-window" title="查看快检实时曲线"  maximized="true"  style="width:1200px;height:700px" closed="true">
         	
		  <div id='canvasDiv'  ></div>
    </div>
    
</body>
</html>
