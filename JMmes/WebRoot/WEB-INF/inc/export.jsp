<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    request.setAttribute("now", System.currentTimeMillis());
%>

<script type="text/javascript">
        function $_export(){
            $("#excel_export_dlg${now }").dialog("open");
            loadLastOptions${now}();
        }
        
        function getFilter(){
            return ext.form.getFormAsJson("<%=request.getParameter("formId") %>");
        }
        
        function loadExportHeaders${now }(){
            var columns=$("#<%=request.getParameter("datagridId") %>").datagrid("getColumnFields");
            var columns_frozen=$("#<%=request.getParameter("datagridId") %>").datagrid("getColumnFields",true);
            columns_frozen=columns_frozen.concat(columns);
            
            var rows=[],title;
            
            Utils.each(columns_frozen,function(i,column){
                title=$("#<%=request.getParameter("datagridId") %>").datagrid("getColumnOption",column).title;
                if(!Utils.isEmpty(title)){
                    rows.push({columnName:column,columnTextName:title});
                }
            });
            
            $("#excel_export_dg${now }").datagrid("loadData",rows);
            
            $("#excel_export_dg${now }").datagrid("enableDnd");
            
            $("#excel_export_dg${now }").datagrid("checkAll");
            
            loadLastOptions();
            
        }
        
        function loadLastOptions${now}(){
        	
        	ext.ajax.get("export/options/?handler=<%=request.getParameter("handlerClass")%>",function(data){
        		
        		if(!data.data){
        			loadExportHeaders${now }();
        			return;
        		}
        		var options=JSON.parse(data.data.options);
        		
        		console.log(options)
        		
        		$("#name${now}").textbox("setValue",options.name);
        		$("#sheet${now}").textbox("setValue",options.sheet);
        		$("#frozenHeader${now}").combobox("setValue",options.frozenHeader);
        		$("#exportScope${now}").combobox("setValue",options.exportScope);
        		
        		
        		var columns=[];
                
                Utils.each(options.columns,function(i,row){
                    columns.push({
                        columnName:row.columnName,
                        columnTextName:row.columnTextName
                    });
                });
                
                $("#excel_export_dg${now }").datagrid("loadData",columns);
                
                $("#excel_export_dg${now }").datagrid("checkAll");
                
                
                
                var _columns=$("#<%=request.getParameter("datagridId") %>").datagrid("getColumnFields");
                var _columns_frozen=$("#<%=request.getParameter("datagridId") %>").datagrid("getColumnFields",true);
                
                _columns_frozen=_columns_frozen.concat(_columns);
                
                
                Utils.each(_columns_frozen,function(i,column){
                	 title=$("#<%=request.getParameter("datagridId") %>").datagrid("getColumnOption",column).title;
                	 var row={columnName:column,columnTextName:title};
                	 var index=$("#excel_export_dg${now }").datagrid("getRowIndex",column);
                	 if(index==-1){
                		 $("#excel_export_dg${now }").datagrid("appendRow",row);
                	 }
                });
                $("#excel_export_dg${now }").datagrid("enableDnd");
        	});
        }
        
        
        function renderPreview${now }(){
            $("#export_dg_preview_header${now }").empty();
            var rows=$("#excel_export_dg${now }").datagrid("getChecked");
            for(var i=0;i<rows.length;i++){
                $("#export_dg_preview_header${now }").append("<th>"+rows[i].columnTextName+"</th>");
            }
        }
        
        function doExport${now}(){
            
            var rows=$("#excel_export_dg${now }").datagrid("getChecked");
            
            if(rows.length==0){
                ext.tip.warn("请选择导出列");
                return;
            }
            
            var valid=$("#options_form${now }").form("validate");
            
            if(!valid){
            	return;
            }
            
            var options={};
            
            var columns=[];
            
            Utils.each(rows,function(i,row){
                columns.push({
                    columnName:row.columnName,
                    columnTextName:row.columnTextName
                });
            }); 
            
            options.columns=columns;
            
            options.name=$("#name${now }").textbox("getValue");
            options.sheet=$("#sheet${now }").textbox("getValue");
            options.frozenHeader="Y";//$("#frozenHeader${now }").combobox("getValue");
            options.exportScope="2"//$("#exportScope${now }").combobox("getValue");
            
            exportOptions={handler:"<%=request.getParameter("handlerClass") %>",serviceName:"<%=request.getParameter("serviceName") %>",options:JSON.stringify(options)};
            
            if(!exportOptions.handler){
            	ext.tip.error("请指定导出处理类");
            	return;
            }
            
            if(!exportOptions.serviceName){
            	ext.tip.error("请指定对应的实体名称");
            	return;
            }
            
            var rows=$("#<%=request.getParameter("datagridId") %>").datagrid("getSelections");
            
            var ids=[];
            
            var idField="<%=request.getParameter("idField") %>";
            
            for(var i=0;i<rows.length;i++){
            	
            	//guess guess the id key
            	
            	var key="";
            	
            	if(rows[i].id){
            		key="id";
            	}else if(rows[i].atr_key){
            		key="atr_key";
            	}else if(rows[i].ID){
            		key="ID";
            	}else if(rows[i].ATR_KEY){
            		key="ATR_KEY";
            	}else{
            		alert("未知的主键列");
            		return;
            	}
            	
            	ids.push(rows[i][key]);
            }
            
            if(options.exportScope=="3"&&ids.length==0){
            	ext.tip.warn(tipSelectAtLeastOne );
            	return;
            }
            
            var filter=getFilter();
            
            var filter2={};
            
            for(var k in filter){
            	filter2[k.replace("filter[","").replace("]","")]=filter[k];
            }
            
            
            
            var get="filter="+$.base64.encode(JSON.stringify(filter2),"utf-8");
            
            var param=Object.assign({},exportOptions,{ids:ids.join(",")});
            
            
            for(var k in param){
                
                get+="&"+k+"="+$.base64.encode(param[k],"utf-8");
                
            }
            
            window.open("excel/export?factory="+factory+"&"+get, "正在导出，请勿刷新");
        }
        </script>
<div id="excel_export_dlg${now }" class="easyui-dialog" style="width:1000px;height:90%;padding:5px;" title="数据导出选项" modal="true" closed="true" buttons="#toolbar${now }">
	<div class="easyui-layout" fit="true" border="false">
		<div data-options="region:'north',title:'表头预览',split:true,collapsible:false" style="height:80px;padding:5px;">
			<table width="100%" border=1 bordercolor=#000000 style="border-collapse:collapse;background:white;" id="export_dg_preview${now }">
				<tr id="export_dg_preview_header${now }"></tr>
			</table>
		</div>
		<div data-options="region:'west',title:'选择导出列（拖动排序）',split:true" style="width:350px;">
			<table class="easyui-datagrid" style="width:100%" border="false" id="excel_export_dg${now }" idField="columnName"
				data-options="
                          fit:true,
                          fitColumns:true,
                          pagination:false,
                          rownumbers:false,
                          singleSelect:false,
                          method:'get',
                          emptyMsg:'暂无数据',
                          striped:true,
                          onCheck:renderPreview${now },
                          onUncheckAll:renderPreview${now },
                          onCheckAll:renderPreview${now },
                          onUncheck:renderPreview${now }
                          ">
				<thead>
					<tr>
						<th data-options="field:'columnName',checkbox:true"></th>
						<th data-options="field:'columnTextName',width:80">列名</th>
					</tr>
				</thead>
			</table>
		</div>
		<div data-options="region:'center'" style="background:#eee;" border="false">
			<div class="easyui-layout" fit="true" border="false">
				<div data-options="region:'center',title:'Excel选项'" style="padding-top:10px;text-align: center;">
					<form id="options_form${now }">
						<input type="text" name="name${now }" id="name${now }" class="easyui-textbox" data-options="label:'Excel名称',required:true,width:300,validType:['specialChar','length[1,50]']"> 
						<input type="text" name="sheet${now }" id="sheet${now }" class="easyui-textbox" data-options="label:'Sheet名称',required:true,width:300,validType:['specialChar','length[1,50]']"> 
						<br>
						<br> 
					<%-- 	<input type="text" name="frozenHeader${now }" id="frozenHeader${now }" class="easyui-combobox" value="Y" data-options="label:'冻结表头',required:true,width:300,data:[{value:'N',text:'否'},{value:'Y',text:'是'}]"> 
						<input type="text" name="exportScope${now }" id="exportScope${now }" class="easyui-combobox" value="1" data-options="label:'导出范围',required:true,width:300,data:[{value:'1',text:'全部'},{value:'2',text:'当前页'},{value:'3',text:'选中行'}]">
				    	 --%> 
				    </form>
				</div>
			</div>
		</div>
	</div>
</div>

<div id="toolbar${now }">
	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="doExport${now}()">导出</a> <a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#excel_export_dlg${now }').dialog('close')">取消</a>
</div>
