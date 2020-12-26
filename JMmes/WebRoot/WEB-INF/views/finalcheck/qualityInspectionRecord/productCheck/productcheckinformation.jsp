<!-- 

    作者      :whl
    时间      :2019-02-10 13:37:36 
    页面名称:成品质检信息
    文件关联:
        ProductCheckInformation.java
        ProductCheckInformationController.java
        ProductCheckInformationServiceImpl.java
        ProductCheckInformationServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="productcheckinformation.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="ProductCheckInformation_dg_toolbar">
            <form id="ProductCheckInformation_search_form" class="form" >
            	<!-- 硫化物料编码 -->
            	<spring:message code="productcheckinformation.column.curingspeccode_s" />:
                <input name="filter[curingspeccode_s]" id="curingspeccode_s" type="text" like="true" class="easyui-textbox" data-options="label:'',width:'150px'" >
				<!-- 规格描述 -->
				<spring:message code="productcheckinformation.column.materialspec_s" />:
                <input name="filter[materialspec_s]" id="materialspec_s" type="text" like="true" class="easyui-textbox" data-options="label:'',width:'150px'" >
				<!-- 硫化开始时间 -->
				<spring:message code="productcheckinformation.column.start_time" />:
				<input name="filter[start_time]" id="start_time" type="text" class="easyui-datetimebox" data-options="label:''">
				<!-- 硫化结束时间 -->
				<spring:message code="productcheckinformation.column.end_time" />:
				<input name="filter[end_time]" id="end_time" type="text" class="easyui-datetimebox" data-options="label:''">
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
        </div>
        <table id="productcheckinformation_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#ProductCheckInformation_dg_toolbar',
                striped:true,
                method: 'get',
                emptyMsg:'暂无数据'
                
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'materialcode_s',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.materialcode_s" /></th>
                    <!-- 规格描述 -->
                    <th data-options="field:'materialspec_s',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.materialspec_s" /></th>
                    <!-- 检查数量 -->
                    <th data-options="field:'total_count',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.total_count" /></th>
                    <!-- 一级品A -->
                    <th data-options="field:'one_a_count',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.one_a_count" /></th>
                    <!-- 一级品B -->
                    <th data-options="field:'one_b_count',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.one_b_count" /></th>
                    <!-- 二级品 -->
                    <th data-options="field:'two_count',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.two_count" /></th>
                    <!-- 废品 -->
                    <th data-options="field:'waste_count',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.waste_count" /></th>
                    <!-- 特废品 -->
                    <th data-options="field:'special_waste_count',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.special_waste_count" /></th>
                    <!-- 合格品 -->
                    <th data-options="field:'qualified_count',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.qualified_count" /></th>
                    <!-- 一级品率 -->
                    <th data-options="field:'one_rate',editor:{type:'numberbox'}"><spring:message code="productcheckinformation.column.one_rate" /></th>
                    <!-- 合格品率 -->
                    <th data-options="field:'qualified_rate',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.qualified_rate" /></th>
                    
                    <!-- 胎趾出边  -->
                    <th data-options="field:'reas_a',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_ga" /></th>
                    <!-- 胎圈瘦小 -->
                    <th data-options="field:'reas_b',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gb" /></th>
                    <!-- 胎圈变形 -->
                    <th data-options="field:'reas_c',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gc" /></th>
                    <!-- 胎趾圆角 -->
                    <th data-options="field:'reas_d',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gd" /></th>
                    <!-- 胶囊破裂 -->
                    <th data-options="field:'reas_e',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_ge" /></th>
                    <!-- 胎里露帘线 -->
                    <th data-options="field:'reas_f',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gf" /></th>
                    <!-- 胎里凹凸不平 -->
                    <th data-options="field:'reas_g',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gg" /></th>
                    <!-- 硫化胶囊和胎里之间窝 -->
                    <th data-options="field:'reas_h',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gh" /></th>
                    <!-- 胎里周向裂口  -->
                    <th data-options="field:'reas_i',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gi" /></th>
                    <!-- 胎侧裂口 -->
                    <th data-options="field:'reas_j',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gj" /></th>
                    <!-- 胎侧气泡、脱层 -->
                    <th data-options="field:'reas_k',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gk" /></th>
                    <!-- 胎肩裂口、裂纹 -->
                    <th data-options="field:'reas_l',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gl" /></th>
                    <!-- 胎肩气泡 -->
                    <th data-options="field:'reas_m',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gm" /></th>
                    <!-- 胎冠（肩）露线 -->
                    <th data-options="field:'reas_n',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gn" /></th>
                    <!-- 胎圈气泡、脱层 -->
                    <th data-options="field:'reas_o',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_go" /></th>
                    <!-- 胎圈撕裂 -->
                    <th data-options="field:'reas_p',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gp" /></th>
                    <!-- 胎里帘线裂缝 -->
                    <th data-options="field:'reas_q',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gq" /></th>
                    <!-- 胶囊打折 -->
                    <th data-options="field:'reas_r',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gr" /></th>
                    <!-- 胶囊老化 -->
                    <th data-options="field:'reas_s',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gs" /></th>
                    <!-- 胎圈露线 -->
                    <th data-options="field:'reas_t',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gt" /></th>
                    <!-- 胎里接头缺陷 -->
                    <th data-options="field:'reas_u',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gu" /></th>
                    <!-- 胎里脱层 -->
                    <th data-options="field:'reas_v',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gv" /></th>
                    <!-- 胎圈缺胶 -->
                    <th data-options="field:'reas_w',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gw" /></th>
                    <!-- 胎冠标示线模糊（掉沟 -->
                    <th data-options="field:'reas_x',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gx" /></th>
                    <!-- 带束层贴合缺陷 -->
                    <th data-options="field:'reas_y',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gy" /></th>
                    <!-- 欠硫 -->
                    <%-- <th data-options="field:'reas_z',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gz" /></th> --%>
                    <!-- 胎冠花纹崩花 -->
                    <th data-options="field:'reas_aa',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gaa" /></th>
                    <!-- 胎冠、胎肩溢胶  -->
                    <th data-options="field:'reas_ab',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gab" /></th>
                    <!-- 胎圈胶边 -->
                    <th data-options="field:'reas_ac',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gac" /></th>
                    <!-- 白边、白色字体处露黑 -->
                    <%-- <th data-options="field:'reas_ad',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gad" /></th> --%>
                    <!-- 胎冠气泡、脱层 -->
                    <th data-options="field:'reas_ae',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gae" /></th>
                    <!-- 年周号、字体活块缺陷 -->
                    <th data-options="field:'reas_af',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gaf" /></th>
                    <!-- 硫化机故障缺陷 -->
                    <%-- <th data-options="field:'reas_ag',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gag" /></th> --%>
                    <!-- 割毛不净、割毛损伤 -->
                    <th data-options="field:'reas_ah',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gah" /></th>
                    <!-- 轮胎杂物 -->
                    <th data-options="field:'reas_ai',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gai" /></th>
                    <!-- 模具脏 -->
                    <th data-options="field:'reas_aj',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gaj" /></th>
                    <!-- 模具损伤 -->
                    <th data-options="field:'reas_ak',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gak" /></th>
                    <!-- 外观判A0病象 -->
                    <%-- <th data-options="field:'reas_al',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gal" /></th> --%>
                    <!-- 模缝错位（两半模） -->
                    <th data-options="field:'reas_am',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gam" /></th>
                    <!-- OE轮胎返工、返修  -->
                    <%-- <th data-options="field:'reas_an',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gan" /></th> --%>
                    <!-- 条形码贴合缺陷 -->
                    <th data-options="field:'reas_ao',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gao" /></th>
                    <!-- 内衬层气泡 -->
                    <th data-options="field:'reas_ap',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gap" /></th>
                    <!-- 胎侧缺胶 -->
                    <th data-options="field:'reas_aq',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gaq" /></th>
                    <!-- 运输损伤 -->
                    <th data-options="field:'reas_ar',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gar" /></th>
                    <!-- 胎冠凹凸不平 -->
                    <th data-options="field:'reas_as',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gas" /></th>
                    <!-- 胎冠（肩）圆角 -->
                    <th data-options="field:'reas_at',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gat" /></th>
                    <!-- 白胎侧轮胎打磨缺陷 -->
                    <th data-options="field:'reas_au',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gau" /></th>
                    <!-- 防护液涂刷不良 -->
                   <%--  <th data-options="field:'reas_av',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gav" /></th>
                    <!-- 胎胚错装 -->
                    <th data-options="field:'reas_aw',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gaw" /></th> --%>
                    <!-- 胎冠缺胶、裂口 -->
                    <th data-options="field:'reas_ax',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gax" /></th>
                    <!-- 胶毛、弹簧气套溢胶  -->
                    <th data-options="field:'reas_ay',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gay" /></th>
                    <!-- 模缝错位（活络模  -->
                    <th data-options="field:'reas_az',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gaz" /></th>
                    <!-- 修补不良  -->
                  <%--   <th data-options="field:'reas_ba',editor:{type:'textbox'}"><spring:message code="productcheckinformation.column.reas_gba" /></th> --%>
                    
                </tr>
            </thead>
        </table>
    </div>
</body>
</html>
