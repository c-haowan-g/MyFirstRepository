<!-- 

    作者      :葛迎祥
    时间      :2019-01-14 08:28:08 
    页面名称:库区库位平面展示图
    文件关联:
        HalfPartUnitController.java
        HalfPartUnitServiceImpl.java
        HalfPartUnitServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/meta.jsp"%>
<%@ include file="halfpartstoragepicture.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'west',split:true" style="width:30%;" title="<spring:message code="" />" >
        <div id="HalfPartProcess_dg_toolbar">
            <form id="HalfPartProcess_search_form" class="form" >
            	 <!-- 库区条码 -->
		         <spring:message code="库区条码"/>
		         :&emsp;<input name="filter[STORAGE_ZONE_NAME]" id="storage_zone_name" type="text" like=true class="easyui-combobox" 
		          data-options="label:'',
		                        labelWidth:'auto',
		                        panelHeight:200,
		                        editable:true,
		                        required:false,
		                        url:'halfpart/basedata/storagezonemanager/searchZoneName',
		                        valueField:'STORAGE_ZONE_NAME',
		          			    textField:'STORAGE_ZONE_NAME',
		                        method:'get'">
		         <br/>
		         <!-- 库区名称 （name-AT）-->            
		         <spring:message code="库区名称"/>
		         :&emsp;<input name="filter[description]" id="description" type="text" like=true class="easyui-combobox" 
		          data-options="label:'',
		                        labelWidth:'auto',
		                        panelHeight:200,
		                        editable:true,
		                        required:false,
		                        url:'halfpart/basedata/storagezonemanager/searchZoneName',
		                        valueField:'DESCRIPTION',
		          			    textField:'DESCRIPTION',
		                        method:'get'">
		
		         <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
		 
            </form> 
        </div>
        <table id="halfpartprocess_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: true,
                toolbar: '#HalfPartProcess_dg_toolbar',
                onSelect:selectrow,
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                	  <!-- 库区主键 -->
			          <th data-options="field:'storage_zone_key',checkbox:true"></th>
			          <!-- 库区条码-->
			          <th data-options="field:'storage_zone_name',sortable:true,width:60">库区条码</th>
			          <!-- 库区名称 -->
			          <th data-options="field:'description',sortable:true,width:110">库区名称</th>    
                </tr>
            </thead>
        </table>
    </div>
	<div data-options="region:'center',split:true"
		title="<spring:message code="" />">
		<div id="testDiv">
			<!-- <div>
				<svg width="1400" height="60" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
					<text xml:space="preserve" text-anchor="start" font-family="'Times New Roman', Times, serif" font-size="12"
						y="20" x="10" stroke-width="0" stroke="#000" fill="#000000">9AKB01_001</text>
					<text xml:space="preserve" text-anchor="start" font-family="'Times New Roman', Times, serif" font-size="12"
							y="35" x="10" stroke-width="0" stroke="#000" fill="#000000">PCR eco CCF HNL505</text>
					<text xml:space="preserve" text-anchor="start" font-family="'Times New Roman', Times, serif" font-size="12"
							y="50" x="10" stroke-width="0" stroke="#000" fill="#000000">228</text>
					<g>
						<title>批次号：302000033200409D02002</title>
						<image id="0" xlink:href="resources/images/redcar.png" x="150" y="30" height="30" width="40"
							onclick="alert('302000033200409D02002')"></image>  </g>
					<text font-weight="bold" xml:space="preserve" text-anchor="start" font-family="'Times New Roman', Times, serif" font-size="12"
							y="10" x="150" stroke-width="0" stroke="#000" fill="#bf0000">B01,135920</text>
					<text font-weight="bold" xml:space="preserve" text-anchor="start" font-family="'Times New Roman', Times, serif" font-size="12"
							y="20" x="150" stroke-width="0" stroke="#000" fill="#bf0000">2549,2503</text>
					<g>
						<title>批次号：302000033200409D02002</title>
						<image id="0" xlink:href="resources/images/redcar.png" x="220" y="30" height="30" width="40"
							onclick="alert('302000033200409D02002')"></image>  </g>
					<text font-weight="bold" xml:space="preserve" text-anchor="start" font-family="'Times New Roman', Times, serif" font-size="12"
							y="10" x="220" stroke-width="0" stroke="#000" fill="#bf0000">B01,135920</text>
					<text font-weight="bold" xml:space="preserve" text-anchor="start" font-family="'Times New Roman', Times, serif" font-size="12"
							y="20" x="220" stroke-width="0" stroke="#000" fill="#bf0000">2549,2503</text>
							
					<line id="a" y2="60" x2="150" y1="60" x1="1400" stroke-width="2.5" stroke="#000" fill="none"></line>
				</svg>
			</div> -->
		</div>
	</div>
</body>
</html>
