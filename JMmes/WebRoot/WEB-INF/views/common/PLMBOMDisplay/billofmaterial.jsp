<!-- 

    作者      :王海霖
    时间      :2019-06-24 15:06:48 
    页面名称:bom_uda
    文件关联:
        BillOfMaterial.java
        BillOfMaterialController.java
        BillOfMaterialServiceImpl.java
        BillOfMaterialServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/meta.jsp"%>
<%@ include file="billofmaterial.js.jsp"%>
<script type="text/javascript" src="dict/152,-307,-306,328.js"></script>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="BillOfMaterial_dg_toolbar">
            <form id="BillOfMaterial_search_form" class="form" >
                <!-- BOM名称-->
                <spring:message code="billofmaterial.column.bom_name" />：
                <input name="filter[bom_name]" id="bom_name" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- BOM版本 -->
                <spring:message code="billofmaterial.column.bom_revision" />：
                <input name="filter[bom_revision]" id="bom_revision" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- BOM类型 -->
				<spring:message code="bom.column.bomtype_s" />:
                <input name="filter[bomtype_s]" id="bomtype_s" type="text" class="easyui-combotree" data-options="label:'',
                 			labelWidth:'auto',
                  		required:false,
                  		url:'dict/code/-306',
                  		method:'get'">
                <!-- 子物料 --><br/>
                <spring:message code="billofmaterial.column.subItem_s" />：
                 <!-- 子物料 -->
                <input name="filter[subItem]" id="subItem" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 废止/正常 -->
				<spring:message code="bom.column.bomflag_i" />:
                <input name="filter[bomflag_i]" id="bomflag_i" type="text" class="easyui-combobox" data-options="label:'',
                 			labelWidth:'auto',
                  		    required:false,
                  		    valueField:'value',
	                        textField:'text',
                  		    data:[{'value':'1','text':'全部','selected':'true'},{'value':'2','text':'正常'},{'value':'3','text':'废止'}]
                  		">
                <!-- 物料描述-->
                <spring:message code="billofmaterial.column.description" />：
                <input name="filter[description]" id="description" type="text" class="easyui-textbox" data-options="label:''" >
               
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            
        </div>
        <table id="billofmaterial_dg" class="easyui-treegrid" style="width:100%"
            data-options="  
               fit:true,
                toolbar: '#BillOfMaterial_dg_toolbar',
                url:'common/billofmaterials/datagridUDA',
       			pagination:true,
                striped:true,
                method: 'get',
                rownumbers: false,
       			animate: true,
        		fitColumns: false,
        	    onBeforeExpand: myLoad,
        	    onExpand: myExpand,
                idField: 'ids',
                treeField: 'bom_name',
                onBeforeLoad: function(row,param){
					if (!row) {	
						param.id = 0;	
					}
				}
                ">
            <thead>
                <tr>
                    <th data-options="field:'bom_key'">序号</th>
                    <!-- 物料编号 -->
                    <th data-options="field:'bom_name',formatter:noneFormatter,width:210,editor:{type:'textbox'}"><spring:message code="billofmaterial.column.bom_name" /></th>
                    <!-- 物料版本 -->
                    <th data-options="field:'bom_revision',width:80,editor:{type:'textbox'}"><spring:message code="billofmaterial.column.bom_revision" /></th>
                    <!--子物料 -->
                    <th data-options="field:'part_number',width:110,editor:{type:'textbox'}"><spring:message code="billofmaterial.column.partnumber" /></th>
                    <!--物料名称-->
                    <th data-options="field:'bomdesc',formatter:DescFormatter,width:120,editor:{type:'textbox'}"><spring:message code="billofmaterial.column.bomDesc" /></th>
                    <!--子物料 版本-->
                    <th data-options="field:'part_revision',width:80,editor:{type:'textbox'}"><spring:message code="billofmaterial.column.partrevision" /></th>
                    <!--物料描述-->
                    <th data-options="field:'description',width:120,editor:{type:'textbox'}"><spring:message code="billofmaterial.column.description" /></th>
                    <!-- 数量 -->
                    <th data-options="field:'basenum_s',width:80,editor:{type:'textbox'}"><spring:message code="billofmaterial.column.basenum" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'createddate_s',width:80,editor:{type:'textbox'}"><spring:message code="billofmaterial.column.createddate" /></th>
                    <!-- 失效时间，首次为空值，试制不为空 -->
                    <th data-options="field:'expireddate_s',width:80,editor:{type:'textbox'}"><spring:message code="billofmaterial.column.exipreddate" /></th>
                    <!-- 层级：半钢-胎体(1|2|3)，全钢、半钢：带束层(1|2|3|4) -->
                    <th data-options="field:'layer_number_s',width:80,editor:{type:'textbox'}"><spring:message code="billofmaterial.column.layer_number" /></th>
                    <!-- 子件用量 -->
                    <th data-options="field:'quantity',width:80,editor:{type:'textbox'}"><spring:message code="billofmaterial.column.makeuse" /></th>
                    <!-- 子件单位 -->
                    <th data-options="field:'unit_of_measure',width:80,editor:{type:'textbox'}"><spring:message code="billofmaterial.column.unit" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'createuser_s',width:80,editor:{type:'textbox'}"><spring:message code="billofmaterial.column.createuser" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'modifier_s',width:80,editor:{type:'textbox'}"><spring:message code="billofmaterial.column.modifier" /></th>
                    <!-- 接收时间 -->
                    <th data-options="field:'receive_time_t',width:80,editor:{type:'textbox'}"><spring:message code="billofmaterial.column.receive_time" /></th>
                    <!-- 空值，终炼胶类型 -->
                    <th data-options="field:'recipetype_s',width:80,editor:{type:'textbox'}"><spring:message code="billofmaterial.column.recipetype" /></th>
                    <!-- 父项SAP物料号 -->
                    <th data-options="field:'mastersap_temp_s',width:80,editor:{type:'textbox'}"><spring:message code="billofmaterial.column.mastersap_temp" /></th>
                    <!-- 工厂 柳州 8003 -->
                    <th data-options="field:'werks_s',width:80,editor:{type:'textbox'}"><spring:message code="billofmaterial.column.werks" /></th>
                    <!-- 所属产品阶段 试制 01 试产 02 投产03 -->
                    <th data-options="field:'prophase_s',formatter:codeFormatter,width:80,editor:{type:'textbox'}"><spring:message code="billofmaterial.column.prophase" /></th>
                    <!-- BOM替代号 -->
                    <th data-options="field:'replacebom_s',width:80,editor:{type:'textbox'}"><spring:message code="billofmaterial.column.replacebom" /></th>
                    <!-- 物料类型 PCR TBR -->
                    <th data-options="field:'materialtype_s',width:80,editor:{type:'textbox'}"><spring:message code="billofmaterial.column.materialtype" /></th>
                    <!-- BOM类型：外胎MBOM(CoverTireMBOM)胎胚MBOM(GreenTireMBOM)半部件MBOM(SemiPartMBOM) -->
                    <th data-options="field:'bommold_s',formatter:codeFormatter,width:80,editor:{type:'textbox'}"><spring:message code="billofmaterial.column.bommold" /></th>
                    <!-- 分厂 半钢 G1 全钢 G3 胎胚一次法 G1 胎胚二次法 G3 -->
                    <th data-options="field:'factory_s',width:80,editor:{type:'textbox'}"><spring:message code="billofmaterial.column.factory" /></th>
                </tr>
            </thead>
        </table>
    </div>
</body>
</html>
