<!-- 

    作者      :陈国强
    时间      :2020-08-25 08:21:09 
    页面名称:PLM密炼物料表
    文件关联:
        MixRfridScanningrate.java
        MixRfridScanningrateController.java
        MixRfridScanningrateServiceImpl.java
        MixRfridScanningrateServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="mixrfridscanningrate.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="MixRfridScanningrate_dg_toolbar">
            <form id="MixRfridScanningrate_search_form" class="form" >
                <!-- 日期 -->
                 &nbsp;&nbsp;<spring:message code="时间" />
              <input name="filter[start_time]" editable="true" style="width:150px" id="start_time" type="text" class="easyui-datetimebox" data-options="" >
                &nbsp;<strong>到</strong>&nbsp;
              <input name="filter[end_time]"   editable="true" style="width:150px"  id="end_time" type="text" class="easyui-datetimebox" data-options="" >   
                <!-- 机台 -->
                <spring:message code="机台名称" />
                <input name="filter[equip_name_s]" id="equip_name_s" type="text" class="easyui-combobox" data-options="label:'',
	          		   data:equiplist2,
	         		   panelHeight:150,
	         		   editable:true,
	           		   valueField:'description',
	          		   textField:'description',
	                   selectOnNavigation:false,	           		
	           		   onChange:filter" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
           <%--  <auth:button code="XXX"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            　
            <auth:button code="XXX"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            　
            <auth:button code="XXX"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="export()"><spring:message code="button.export" /></a></auth:button> --%>
        </div>
        <table id="mixrfridscanningrate_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#MixRfridScanningrate_dg_toolbar',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <!-- 日期 -->
                    <th data-options="field:'PRODUCT_TIME_T',width:250,styler:planStatusColorSetting,editor:{type:'textbox'}"><spring:message code="日期" /></th>
                    <!-- 机台名称 -->
                    <th data-options="field:'EQUIP_NAME_S',width:250,styler:planStatusColorSetting,editor:{type:'textbox'}"><spring:message code="机台名称" /></th>
                    <!-- 扫描率 -->
                    <th data-options="field:'S_P',width:250,formatter:spFormatter,styler:planStatusColorSetting,editor:{type:'textbox'}"><spring:message code="扫描率" /></th>
                </tr>
            </thead>
        </table>
    </div>
</body>
</html>
