<!-- 

    作者      :陈国强
    时间      :2020-09-17 17:04:06 
    页面名称:密炼胶料产出称量实绩表
    文件关联:
        PolyWeight.java
        PolyWeightController.java
        PolyWeightServiceImpl.java
        PolyWeightServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="polyweight.js.jsp"%>
<script type="text/javascript" src="dict/-324,302.js"></script>
<body class="easyui-layout" fit="true"> 
<div class="easyui-tabs" id="content_tab" border="false"style="width: 100%; height: 100%">
<div title="<spring:message code='称量记录'/>" style="padding: 1px">
  <div id=PolyWeight_dg_toolbar >
            <form id="PolyWeight_search_form" class="form" style="padding:5px">
                 &nbsp;生产时间:&nbsp;
                 <input name="filter[receive_time_t]" id="receive_time_t" type="text"  class="easyui-datebox" style="width:100px"  data-options="onChange:filter,formatter:dateFormat,buttons:[],parser:dateParser,label:''" >
				&nbsp;<spring:message code="tip.to" /> &nbsp;
				 <input name="filter[end_time_t]" id="end_time_t" type="text"  class="easyui-datebox" style="width:100px"  data-options="onChange:filter,formatter:dateFormat,buttons:[],parser:dateParser,label:''" >
					<script type="text/javascript">
	                $("#receive_time_t").val(new Calendar().format("yyyyMMdd"));
	                $("#end_time_t").val(new Calendar().format("yyyyMMdd"));
	            </script>
            	 &nbsp; &nbsp; 班次
                <input name="filter[shift_code_s]" id="shift_code_s" type="text" class="easyui-combotree"  style="width: 100px"   data-options="labelWidth:'auto',
                                            panelHeight:100,
										    required:false,
										    editable:false,
										    data:shiftCodeContent,
										    textField:'text',
										    valueField:'code',
										    method:'get'" >
               	 机台名称&nbsp; &nbsp;
                <input name="filter[equip_code_s]" id="equip_code_s" style="width:200px" type="text" class="easyui-combobox"    data-options="label:'',
	          		   data:equiplist,
	         		   panelHeight:150,
	         		   editable:true,
	           		   valueField:'p_line_name',
	          		   textField:'description',
	                   selectOnNavigation:false,
	           		   limitToList:true,
	          		   filter:searchProductionLine,
	           		   onChange:filter">
            	
            	  &nbsp; &nbsp;称量类型&nbsp;&nbsp;
                <input name="filter[wweight_type_s]" id="wweight_type_s" type="text" class="easyui-combotree"  style="width: 150px"   data-options="labelWidth:'auto',
                                            panelHeight:100,
										    required:false,
										    editable:false,
										    data:wweightCodeContent,
										    textField:'text',
										    valueField:'code',
										    method:'get'" >					    
				是否超差
				<input name="filter[warning_sgn_s]" id="warning_sgn_s" type="text" style="width: 100px" class="easyui-combobox"
							data-options="label:'',
                                                           textField: 'label',
														data: [{
																label: '否',
																value: '0'
															},{
																label: '是',
																value: '1'
																}]">
				生产方式
				<input name="filter[prodtype]" id="prodtype" type="text" style="width: 100px" class="easyui-combobox"
							data-options="label:'',
                                                           textField: 'label',
														data: [{
																label: '自动',
																value: '自动'
															},{
																label: '手动',
																value: '手动'
																}]">
				<spring:message code="polyweight.column.material_name_s" />:&nbsp; &nbsp;
                <input name="filter[material_name_s]" id="material_name_s" type="text" class="easyui-textbox" data-options="label:''" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            	<a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="exportExcel()"><spring:message code="button.export" /></a>
            </form> 
            <%-- <auth:button code="XXX"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            　
            <auth:button code="XXX"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button> --%>
            　
            
        </div>
    

        <table id="polyweight_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                pageSize: 100,
                toolbar: '#PolyWeight_dg_toolbar',
                url: '',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
					<th colspan="6"><strong>车次产出信息</strong></th>
					<th colspan="9"><strong>车次称量信息</strong></th>
				</tr>
                <tr>
                    <!-- 生产日期 -->
                    <th data-options="field:'prod_date_s'">生产日期</th>
                    <!-- 班次 -->
                    <th data-options="field:'shift_code_s',formatter:codeFormatter">班次</th>
                    <!-- 机台 -->
                    <th data-options="field:'equip_name_s'">机台</th>
                    <!-- 总车数 -->
                    <th data-options="field:'qty_complete_i'">总车数</th>
                    <!-- 车数 -->
                    <th data-options="field:'serial_id_i'">车数</th>
                    <!-- 配方名称 -->
                    <th data-options="field:'recipe_name'">配方名称</th>
                    <!-- 是否超差-->
                    <th data-options="field:'warning_sgn_s'">是否超差</th>
                    <!-- 称量时间 -->
                    <th data-options="field:'weight_time_s'">称量时间</th>
                    <!-- 物料名称-->
                    <th data-options="field:'material_name_s'">物料名称</th>
                    <!-- 设定重量 -->
                    <th data-options="field:'set_weight_s'">设定重量</th>
                    <!-- 实际重量-->
                    <th data-options="field:'real_weight_s'">实际重量</th>
                    <!-- 设定误差 -->
                    <th data-options="field:'error_allow_s'">设定误差</th>
                    <!-- 实际误差-->
                    <th data-options="field:'error_out_s'">实际误差</th>
                    <!-- 称量类型 -->
                    <th data-options="field:'dictname_s'">称量类型</th>
                    <!-- 生产方式 -->
                    <th data-options="field:'prodtype'">生产方式</th>
                </tr>
            </thead>
        </table>
    </div>
    <div title="<spring:message code='称量合格'/>" style="padding: 1px">
    <%-- <div id=PolyWeight_dg_toolbar3 >
            <form id="PolyWeight_search_form1" class="form" style="padding:5px">
                 &nbsp;生产时间:&nbsp;
                 <input name="filter[receive_time_t]" id="receive_time_t1" type="text"  class="easyui-datebox" style="width:100px"  data-options="onChange:filter,formatter:dateFormat,buttons:[],parser:dateParser,label:''" >
				&nbsp;<spring:message code="tip.to" /> &nbsp;
				 <input name="filter[end_time_t]" id="end_time_t1" type="text"  class="easyui-datebox" style="width:100px"  data-options="onChange:filter,formatter:dateFormat,buttons:[],parser:dateParser,label:''" >
					<script type="text/javascript">
	                $("#receive_time_t1").val(new Calendar().format("yyyyMMdd"));
	                $("#end_time_t1").val(new Calendar().format("yyyyMMdd"));
	            </script>
            	 &nbsp; &nbsp; 班次
                <input name="filter[shift_code_s]" id="shift_code_s" type="text" class="easyui-combotree"  style="width: 100px"   data-options="labelWidth:'auto',
                                            panelHeight:100,
										    required:false,
										    editable:false,
										    data:shiftCodeContent,
										    textField:'text',
										    valueField:'code',
										    method:'get'" >
               	 机台名称&nbsp; &nbsp;
                <input name="filter[equip_code_s]" id="equip_code_s" style="width:200px" type="text" class="easyui-combobox"    data-options="label:'',
	          		   data:equiplist,
	         		   panelHeight:150,
	         		   editable:true,
	           		   valueField:'p_line_name',
	          		   textField:'description',
	                   selectOnNavigation:false,
	           		   limitToList:true,
	          		   filter:searchProductionLine,
	           		   onChange:filter">
            	
            	  &nbsp; &nbsp;称量类型&nbsp;&nbsp;
                <input name="filter[wweight_type_s]" id="wweight_type_s" type="text" class="easyui-combotree"  style="width: 150px"   data-options="labelWidth:'auto',
                                            panelHeight:100,
										    required:false,
										    editable:false,
										    data:wweightCodeContent,
										    textField:'text',
										    valueField:'code',
										    method:'get'" >					    
				是否超差
				<input name="filter[warning_sgn_s]" id="warning_sgn_s" type="text" style="width: 100px" class="easyui-combobox"
							data-options="label:'',
                                                           textField: 'label',
														data: [{
																label: '否',
																value: '0'
															},{
																label: '是',
																value: '1'
																}]">
				生产方式
				<input name="filter[prodtype]" id="prodtype" type="text" style="width: 100px" class="easyui-combobox"
							data-options="label:'',
                                                           textField: 'label',
														data: [{
																label: '自动',
																value: '自动'
															},{
																label: '手动',
																value: '手动'
																}]">
				<spring:message code="polyweight.column.material_name_s" />:&nbsp; &nbsp;
                <input name="filter[material_name_s]" id="material_name_s" type="text" class="easyui-textbox" data-options="label:''" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            	<a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="exportExcel()"><spring:message code="button.export" /></a>
            </form> 
            <auth:button code="XXX"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            　
            <auth:button code="XXX"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            　
            
        </div> --%>
		<table id="polyweight_dg3" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                pageSize: 100,
                rownumbers: true,
                singleSelect: false,
                toolbar: 'PolyWeight_dg_toolbar3',
                url: '',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                     <!-- 物料名称 -->
                    <th data-options="field:'material_name_s'">物料名称</th>
                     <!-- 称量类型 -->
                    <th data-options="field:'dictname_s'">称量类型</th>
                    <!-- 总车数 -->
                    <th data-options="field:'qty_complete_i'">总车数</th>
                     <!-- 合格数 -->
                    <th data-options="field:'goodtotal'">合格数</th>
                     <!--不合格数 -->
                    <th data-options="field:'badtotal'">不合格数</th>
                     <!-- 合格率 -->
                    <th data-options="field:'goodp'">合格率</th>
                     <!-- 超上限-->
                    <th data-options="field:'up'">超上限</th>
                     <!-- 超下限 -->
                    <th data-options="field:'down'">超下限</th>
                </tr>
            </thead>
        </table>
	</div>
	</div>
	
	
</body>
</html>
