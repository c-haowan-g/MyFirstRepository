<!-- 

    作者      :边朝会
    时间      :2020-08-07 10:19:11 
    页面名称:密炼退料登记表
    文件关联:
        ReturnPolyRecord.java
        ReturnPolyRecordController.java
        ReturnPolyRecordServiceImpl.java
        ReturnPolyRecordServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="returnpolyrecord.js.jsp"%>
<script type="text/javascript" src="dict/252.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="ReturnPolyRecord_dg_toolbar">
            <form id="ReturnPolyRecord_search_form" class="form" >
                
                <table class="formTable">
					<tr>
						<td class="columnData">
							  生产日期:<input name="filter[prod_time_t]" id="prod_time_t" editable="true" class="easyui-datebox" data-options="label:''" >
                           <script type="text/javascript">
				            	$("#prod_time_t").val(new Calendar().format("yyyyMMdd"));
				            </script>
						</td>
						<td class="columnData">
			                       <!-- 物料编码 -->
                                                  物料编码: <input name="filter[material_code_s]" id="material_code_s" type="text" class="easyui-textbox" data-options="label:''" >
						</td>
						<td class="columnData">
			                       <!-- 物料编码 -->
                                                  胶料条码: <input name="filter[lot_no_s]" id="lot_no_s" type="text" class="easyui-textbox" data-options="label:''" >
						</td>
						<td class="columnTitle">
							<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
							<auth:button code="LH_BB_LHSCFX_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
						</td>
						</tr>
				</table>
                
            </form> 
           </div>
        <table id="returnpolyrecord_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#ReturnPolyRecord_dg_toolbar',
                url: 'view/mix/productionManagement/datagrid',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',editor:{type:'textbox'}">物料编码</th>
                    <!-- 物料名称 -->
                    <th data-options="field:'material_name_s',editor:{type:'textbox'}">物料名称</th>
                    
                     <!-- 重量 -->
                    <th data-options="field:'net_weight_f',editor:{type:'textbox'}">重量</th>
                    <!-- 生产日期 -->
                    <th data-options="field:'prod_time_t',editor:{type:'textbox'}">生产日期</th>
                    <!-- 批次号 -->
                    <th data-options="field:'lot_no_s',editor:{type:'textbox'}">胶料条码</th>
                    <!-- 机构编号-->
                    <th data-options="field:'agenc_no_s',editor:{type:'textbox'}">机构编号</th>
                    <!-- 物料过期日期 -->
                    <th data-options="field:'expiry_date_t',editor:{type:'textbox'}">有效期</th>
                    <!-- 主机手 -->
                    <th data-options="field:'master_by_s',editor:{type:'textbox'}">主机手</th>
                    <!-- 班次：302001-早班、302002-中班、302003-晚班 -->
                    <th data-options="field:'shift_code_s',editor:{type:'textbox'}">班次</th>
                    <!-- 班组：301001-甲班、301002-乙班、301003-丙班 -->
                    <th data-options="field:'group_code_s',editor:{type:'textbox'}">班组</th>
                     <!-- 皮重 -->
                    <th data-options="field:'tare_weight_f',editor:{type:'textbox'}">皮重</th>
                      <!-- 退回工区：077001-密炼、077002-半部件、077003-成型 -->
                    <th data-options="field:'workarea_s',editor:{type:'textbox'}">工区</th>
                     <!-- 是否存在杂物：0-否、1-是 -->
                    <th data-options="field:'is_impurity_s',editor:{type:'textbox'}">是否有杂物</th>
                    <!-- 是否色标与胶号一样：0-否、1-是 -->
                    <th data-options="field:'is_colorcode_s',editor:{type:'textbox'}">色标与胶号是否一致</th>
                     <!-- 创建人姓名 -->
                    <th data-options="field:'created_name_s',editor:{type:'textbox'}">创建人</th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',editor:{type:'textbox'}">创建时间</th>
                    
                    
                  
                </tr>
            </thead>
        </table>
    </div>
</body>
</html>
