<!-- 

    作者      :李迺锟
    时间      :2018-08-15 09:28:58 
    页面名称:分拣规则维护
    文件关联:
        Sortltem.java
        SortltemController.java
        SortltemServiceImpl.java
        SortltemServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="sortltem.js.jsp"%>
<script type="text/javascript" src="dict/252,253,260.js"></script>
<style type="text/css">
.columnTitle {
	padding: 6px 10px
}
</style>
<body class="easyui-layout" fit="true"> 
    <div class="easyui-tabs" fit="true" border="false" style="width:700px;height:250px">
		<div title="<spring:message code='tip.ruleQuery'/>" style="padding:10px">
		        <div id="Sortltem_dg_toolbar">
		            <form id="Sortltem_search_form" class="form" >
		            <table class="formTable">
					<tr>
						<spring:message code="sortltem.column.station_i" />:
		                <!-- 分拣点-->
		                <input name="filter[station_i]" id="station_i" type="text" class="easyui-combotree" style="width:150px" data-options="label:'', 
                              required:true,
                              data:DICT_260,
                              method:'get',onChange: stationFormatter">
						<spring:message code="sortltem.column.entbarcode_s" />:
		                <!-- 机台 -->
		                <input name="filter[entbarcode_s]" id="entbarcode_s" type="text" class="easyui-combobox" style="width:150px" data-options="label:'',
                                        required:true, 
                                        panelHeight:200,
                                        icons:[{iconCls:'icon-clear',handler:function(e){$(e.data.target).combobox('clear')}}],
			                             method: 'get',
			                             valueField:'EQUIP_NAME',
		                                 textField:'DESCRIPTION'"> 
						<spring:message code="sortltem.column.itemid_s" />:
		                <!-- 品号 -->
		                <input name="filter[itemid_s]" id="itemid_s" like="true" type="text" class="easyui-textbox" style="width:140px" data-options="label:''" >
						
						  <spring:message code="materials.column.materialdesc_s" />:
		                  <!-- 物料描述 -->
					     <input name="filter[materialdesc_s]" id="materialdesc_s" like="true" type="text" class="easyui-textbox"style="width:200px" data-options="label:''">
								 <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
					</tr>
				   </table>
		            </form> 
		            <auth:button code="ZJ_BZGL_FJGZ_REMOVE"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
		            <auth:button code="ZJ_BZGL_FJGZ_CANCEL"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
		            <auth:button code="ZJ_BZGL_FJGZ_SAVE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
		            <auth:button code="ZJ_BZGL_FJGZ_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
		            | <a class="easyui-linkbutton btn-green"
					data-options="iconCls:'icon-hide'" onclick="showOrHide()"><spring:message code="查询栏" /></a>
		        </div>
		        <table id="sortltem_dg" class="easyui-datagrid" style="width:100%"
		            data-options="  
		                fit:true,
		                fitColumns:true,
		               emptyMsg: '<span><spring:message code='tip.noData'/></span>',
		                pagination:true,
		                rownumbers: true,
		                singleSelect: false,
		                toolbar: '#Sortltem_dg_toolbar',
		                clientPaging:false,
                        remoteFilter:true,
		                url: '',
		                striped:true,
		                method: 'get' 
		                ">
		            <thead>
		                <tr>
		                 <th data-options="field:'atr_key',checkbox:true">ID</th>
		                    <!-- 分拣点 -->
		                    <th data-options="field:'station_i',formatter:codeFormatter,editor:{type:'combotree',options:
                                {
                                method:'get',
                                 data:DICT_260,
                                required:true}}"><spring:message code="sortltem.column.station_i" /></th>
		                    <!-- 机台-->
		                     <th data-options="field:'entname_s',editor:{type:'textbox'}"><spring:message code="sortltem.column.entbarcode_s" /></th>
		                    <!-- 抽检比例：0-免检，1-全检 -->
		                    <th data-options="field:'num_i',editor:{type:'textbox'}"><spring:message code="sortltem.column.num_i" /></th>
		                     <!-- 配方号 -->
		                    <th data-options="field:'recipeno_s',editor:{type:'textbox'}"><spring:message code="recipe.column.recipeno_s" /></th>
		                     <!-- 品号 -->
		                    <th data-options="field:'itemid_s',editor:{type:'textbox'}"><spring:message code="sortltem.column.itemid_s" /></th>
		                    <!-- 物料描述 -->
							<th data-options="field:'materialdesc_s',editor:{type:'textbox',options:{required:true}}"><spring:message code="materials.column.materialdesc_s" /></th>
							 <!-- 修改人 -->
		                    <th data-options="field:'changebyname',editor:{type:'textbox'}"><spring:message code="sortltem.column.changed_by_s" /></th>
		                    <!-- 修改时间 -->
		                    <th data-options="field:'changed_time_t',editor:{type:'textbox'}"><spring:message code="sortltem.column.changed_time_t" /></th>
		                     <!-- 创建人 -->
		                    <th data-options="field:'createdname',editor:{type:'textbox'}"><spring:message code="sortltem.column.created_by_s" /></th>
		                    <!-- 创建时间 -->
		                    <th data-options="field:'created_time_t',editor:{type:'textbox'}"><spring:message code="sortltem.column.created_time_t" /></th>
		                </tr>
		            </thead>
		        </table>
       </div>
     
     
	    <div title="<spring:message code='tip.gradeMaintenance'/>" style="padding:10px">
	        <div class="easyui-layout" fit="true" border="false" style="width:700px;height:350px;">
			    <div data-options="region:'north'" style="height:50px">
				   <div id="Grade_dg_toolbar">
						<form id="Grade_search_form" class="form">
						<table class="formTable">
							<tr>
								<td class="columnTitle">
								<!-- 分拣点-->
									<spring:message code="sortltem.column.station_i" />
					                 <input name="filter[station_i]" id="station_i2" type="text" class="easyui-combotree" style="width:150px" data-options="label:'', 
			                       	  required:false,
		                               data:DICT_260,
		                              method:'get',
		                              required:true">
								</td>
								<td class="columnTitle">
								  <a class="easyui-linkbutton btn-yellow"data-options="iconCls:'icon-search'" onclick="filter2()"><spring:message code="button.search" /></a>
								</td>
							</tr>
						</table>   
					</form>
				  </div>   
			    </div>
			    <div data-options="region:'west',split:true" title="<spring:message code='tip.options'/>" style="width:600px;">
					<div class="easyui-panel" fit="true" border="false">
						<div class="easyui-layout" data-options="fit:true">
							<div data-options="region:'east'" style="width:30px">
							    <br>
							    
							    <br/>
							    <!-- 全部向右 -->
								<a  class="easyui-linkbutton"  data-options="iconCls:'icon-allforward'"onclick="clickallforward()"></a>
								<!-- 向右一个 -->
								<a  class="easyui-linkbutton"  data-options="iconCls:'icon-forwardone'"onclick="clickforwardone()"></a>
								<!-- 向左一个 -->
								<a  class="easyui-linkbutton" data-options="iconCls:'icon-backone'"onclick="clickbackone()"></a>
								<!-- 全部向左 -->
								<a  class="easyui-linkbutton" data-options="iconCls:'icon-allback'"onclick="clickallback()"></a>
								<!-- 编辑右侧按钮 -->
								<a  class="easyui-linkbutton" data-options="iconCls:'icon-edit'"onclick="editsortgrade()"></a>
								<!-- 保存界面更改情况 -->
								<a  class="easyui-linkbutton" data-options="iconCls:'icon-save'"onclick="saveSortGrade()"></a>
							</div>
							<div data-options="region:'center'" style="width:10px;">
							
							  <table id="processgrade_dg" class="easyui-datagrid" style="width:100%"
							            data-options="  
							                fit:true,
							                fitColumns:true,
							                emptyMsg: '<span><spring:message code='tip.noData'/></span>',
							                pagination:true,
							                rownumbers: true,
							                singleSelect: false,
							                singleSelect: false,
			                                clientPaging:false,
                          			        remoteFilter:true,
							                url: '',
							                striped:true,
							                method: 'get'">
							            <thead>
							                <tr>
							                    <th data-options="field:'atr_key',checkbox:true"></th>
			                   					 <!-- 工序 -->
			                   					<th data-options="field:'proess_i',width:10,formatter:codeFormatter,editor:{type:'combotree',options: {method:'get',required:true}}"><spring:message code="sortgrade.column.proess_i" /></th>
			                  					  <!-- 质量等级编码 -->
			                  					  <th data-options="field:'gradecode_i',width:20,formatter:codeFormatter,editor:{type:'combotree',options: {method:'get',required:true}}"><spring:message code="sortgrade.column.gradecd_i" /></th>
			                   
							                </tr>
							            </thead>
							    </table>
							</div>
						</div>
					</div>
				 </div>	
			    
			    <div data-options="region:'center',iconCls:'icon-ok'" title="<spring:message code='tip.alreadyoptions'/>">
				    <table id="sortgrade_dg" class="easyui-datagrid" style="width:100%"
			            data-options="  
			                fit:true,
			                fitColumns:true,
			                emptyMsg: '<span><spring:message code='tip.noData'/></span>',
			                pagination:true,
			                rownumbers: true,
			                singleSelect: false,
			                clientPaging:false,
                            remoteFilter:true,
			                url: '',
			                striped:true,
			                method: 'get'">
			            <thead>
			                 <tr>
			                    <th data-options="field:'atr_key',checkbox:true"></th>
			                    <!-- 工序 -->
			                    <th data-options="field:'proess_i',width:10,formatter:codeFormatter"><spring:message code="sortgrade.column.proess_i" /></th>
			                    <!-- 质量等级编码 -->
			                    <th data-options="field:'gradecd_i',width:20,formatter:codeFormatter"><spring:message code="sortgrade.column.gradecd_i" /></th>
			                    <!-- 下工序处理：0-允许，1-不允许 -->
			                    <th data-options="field:'ischeck_i',width:20,formatter:isCheckFormatter,editor:{type:'combobox',options:
	                                {valueField:'value',
	                                textField:'text',
	                                method:'get',
	                                data: [{
											text: '<spring:message code='tip.notallow'/>',
											value: 0
										},{
											text: '<spring:message code='tip.allow'/>',
											value: 1
										}],
	                                required:true}}"><spring:message code="sortgrade.column.ischeck_i" /></th>
			                    
			                 </tr>
			              </thead>
	        		  </table>
			    
			    </div> 
			</div>
	    </div><!-- 等级维护终止位置 -->
    
    
        <div title="<spring:message code='tip.specificationMaintenance'/>" style="padding:10px">
         	<div class="easyui-layout" fit="true" border="false" style="width:700px;height:350px;">
			    <div data-options="region:'north'" style="height:50px">
				   <div id="Sortltem_dg_toolbar3">
						<form id="Sortltem_search_form3" class="form">
						
						    <table class="formTable">
								<tr>
									<td class="columnTitle">
									 <spring:message code="sortltem.column.station_i" />
		                             <!-- 分拣点-->
					                 <input name="filter[station_i]" id="station_i3" type="text" class="easyui-combotree" style="width:150px" data-options="label:'', 
	                              required:true,
	                               data:DICT_260,
	                              method:'get',
	                              required:true,onChange: stationFormatter2">
									</td>
									<td class="columnTitle">
									<spring:message code="sortltem.column.entbarcode_s" />
	                         <!-- 机台 -->
		                     <input name="filter[entbarcode_s]" id="entbarcode_s3" type="text" class="easyui-combobox" style="width:150px" data-options="label:'',
                                  required:false, 
                                  icons:[{iconCls:'icon-clear',handler:function(e){$(e.data.target).combobox('clear')}}],
                                  required:true,
		                          method: 'get',
		                          valueField:'EQUIP_NAME',
		                          textField:'DESCRIPTION'"> 
									</td>
									<td class="columnTitle">
									 <a class="easyui-linkbutton btn-yellow"data-options="iconCls:'icon-search'" onclick="filter3()"><spring:message code="button.search" /></a>
									</td>
								</tr>
							</table>
                        </form>
                   </div>
                </div>
                
                <div data-options="region:'west',split:true" title="<spring:message code='tip.options'/>" style="width:600px;">
					<div class="easyui-panel" fit="true" border="false">
						<div class="easyui-layout" data-options="fit:true">
							<div data-options="region:'east'" style="width:30px">
							    <br>
							    
							    <br/>
							    <!-- 全部向右 -->
								<a  class="easyui-linkbutton"  data-options="iconCls:'icon-allforward'"onclick="clickallforward3()"></a>
								<!-- 向右一个 -->
								<a  class="easyui-linkbutton"  data-options="iconCls:'icon-forwardone'"onclick="clickforwardone3()"></a>
								<!-- 向左一个 -->
								<a  class="easyui-linkbutton" data-options="iconCls:'icon-backone'"onclick="clickbackone3()"></a>
								<!-- 全部向左 -->
								<a  class="easyui-linkbutton" data-options="iconCls:'icon-allback'"onclick="clickallback3()"></a>
								
								<!-- 保存界面更改情况 -->
								<a  class="easyui-linkbutton" data-options="iconCls:'icon-save'"onclick="save3()"></a>
							</div>
				<div data-options="region:'center'" style="width:10px;">
						<table id="recipeItem_dg" class="easyui-datagrid"
									style="width:100%"
									data-options="  
									fit:true,
									fitColumns:true,
								    emptyMsg: '<span><spring:message code='tip.noData'/></span>',
									pagination:true,
									rownumbers: true,
									singleSelect: false,
									clientPaging:false,
                                    remoteFilter:true,
									url: '',
									striped:true,
									method: 'get',
									onLoadSuccess:function(data){
									   $(this).datagrid('enableFilter');
									}">
						<thead>
							<tr>
							   <th data-options="field:'atr_key',checkbox:true"></th>
							   <!-- 配方号 -->
								<th data-options="field:'recipeno_s',editor:{type:'textbox',options:{required:true}}"><spring:message code="recipe.column.recipeno_s" /></th>
								<!-- 品号 -->
								<th data-options="field:'itemid_s',editor:{type:'textbox',options:{required:true}}"><spring:message code="materials.column.materialcode_s" /></th>
								<!-- 物料描述 -->
								<th data-options="field:'materialdesc_s',editor:{type:'textbox',options:{required:true}}"><spring:message code="materials.column.materialdesc_s" /></th>
							</tr>
						</thead>
					  </table>
				</div>
			</div>
		</div>
	</div>
              
                <div data-options="region:'center',iconCls:'icon-ok'" title="<spring:message code='tip.alreadyoptions'/>">
					<table id="sortItem_dg3" class="easyui-datagrid"
						style="width:100%"
						data-options="  fit:true,
										fitColumns:true,
										emptyMsg: '<span><spring:message code='tip.noData'/></span>',
										pagination:true,
										rownumbers: true,
										singleSelect: false,
										clientPaging:false,
                                        remoteFilter:true,
										url: '',
										striped:true,
										method: 'get',
										onLoadSuccess:function(data){
										   $(this).datagrid('enableFilter');
										}">
						<thead>
							<tr>
							    <th data-options="field:'atr_key',checkbox:true"></th>
							    <!-- 抽检比例：0-免检，100-全检 -->
		                        <th data-options="field:'num_i',editor:{type:'textbox'}"><spring:message code="sortltem.column.num_i" /></th>
								<!-- 配方号 -->
								<th data-options="field:'recipeno_s',editor:{type:'textbox',options:{required:true}}"><spring:message code="recipe.column.recipeno_s" /></th>
								<!-- 品号 -->
								<th data-options="field:'itemid_s',editor:{type:'textbox',options:{required:true}}"><spring:message code="materials.column.materialcode_s" /></th>
								<!-- 物料描述 -->
								<th data-options="field:'materialdesc_s',editor:{type:'textbox',options:{required:true}}"><spring:message code="materials.column.materialdesc_s" /></th>
							</tr>
						</thead>
					</table>
				</div>  
            </div><!-- layout终止位置 -->
        </div><!-- 规格维护终止位置 -->
    
    
       <div title="<spring:message code='tip.casualInspection'/>" style="padding:10px">
        <div id="Sortltem_dg_toolbar4">
		            <form id="Sortltem_search_form4" class="form" >
		            <table class="formTable">
						<tr>
							<td class="columnTitle">
							<spring:message code="sortltem.column.station_i" />
		                <!-- 分拣点-->
		                <input name="filter[station_i]" id="station_i4" type="text" class="easyui-combobox" style="width:150px" data-options="label:'', 
                              required:true,
                              textField: 'label',
						      valueField: 'value',
						      data: [{label:'动平衡前',value:'260005'},
						             {label:'均匀机前',value:'260007'},
						              {label:'X光机前',value:'260008'}],
                              method:'get'">
							</td>
							<td class="columnTitle">
							 <spring:message code="sortltem.column.itemid_s" />
			                <!-- 品号 -->
			                <input name="filter[itemid_s]" id="itemid_s" like="true" type="text" class="easyui-textbox" data-options="label:''" >
							</td>
						
							<td class="columnTitle">
							 <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter4()"><spring:message code="button.search" /></a>
							</td>
						</tr>
					</table>  
		            </form> 
		            <a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit4()"><spring:message code="button.edit" /></a>
		            <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel4()"><spring:message code="button.cancel" /></a>
		            <a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save4()"><spring:message code="button.save" /></a>
		            <a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-hide'" onclick="showOrHide4()"><spring:message code="查询栏" /></a>
		        </div>
		        <table id="sortltem_dg4" class="easyui-datagrid" style="width:100%"
		            data-options="  
		                fit:true,
		                fitColumns:true,
		                emptyMsg: '<span><spring:message code='tip.noData'/></span>',
		                pagination:true,
		                rownumbers: true,
		                singleSelect: false,
		                toolbar: '#Sortltem_dg_toolbar4',
		                clientPaging:false,
                        remoteFilter:true,
		                url: '',
		                striped:true,
		                method: 'get' 
		                ">
		            <thead>
		                <tr>
		                 <th data-options="field:'atr_key',checkbox:true"></th>
		                    <!-- 抽检比例：0-免检，100-全检 -->
		                    <th data-options="field:'num_i',width:80,editor:{type:'numberbox',options:{required:true,min:0,max:100,precision:0}}"><spring:message code="sortltem.column.num_i" /></th>
		                     <!-- 品号 -->
		                    <th data-options="field:'itemid_s',width:80"><spring:message code="sortltem.column.itemid_s" /></th>
		                    <!-- 物料描述 -->
							<th data-options="field:'materialdesc_s',width:80"><spring:message code="materials.column.materialdesc_s" /></th>
     	                </tr>
		            </thead>
		        </table>
    
    
    
       </div><!-- 抽检维护终止位置 -->
    
      
      
      <!--第五个页面：备胎维护 -->
      <div title="<spring:message code='tip.btInspection'/>" style="padding:10px">
        <div id="Sortltem_dg_toolbar5">
		            <form id="Sortltem_search_form5" class="form" >
		            <table class="formTable">
						<tr>
							
							<td class="columnTitle">
							 <spring:message code="sortltem.column.itemid_s" />
			                <!-- 品号 -->
			                <input name="filter[itemid_s]" id="itemid_s" like="true" type="text" class="easyui-textbox" data-options="label:''" >
							</td>
						<td class="columnTitle">
							 <spring:message code="sortltem.column.numbeitai" />
			                <!-- 备胎查询 -->
			                <input name="filter[spare3_s]" id="num_i5"  type="text" class="easyui-combobox" style="width:110px" data-options="label:'', 
                             
                              textField: 'label',
						      valueField: 'value',
						     data:[{label:'正常胎',value:'1'},
						             {label:'备胎',value:'0'}],
                              method:'get'">
							</td>
							<td class="columnTitle">
							 <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter5()"><spring:message code="button.search" /></a>
							</td>
						</tr>
					</table>  
		            </form> 
		            <a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit5()"><spring:message code="button.edit" /></a>
		            <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel5()"><spring:message code="button.cancel" /></a>
		            <a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save5()"><spring:message code="button.save" /></a>
		            <a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-hide'" onclick="showOrHide5()"><spring:message code="查询栏" /></a>
		        </div>
		        <table id="sortltem_dg5" class="easyui-datagrid" style="width:100%"
		            data-options="  
		                fit:true,
		                fitColumns:true,
		                emptyMsg: '<span><spring:message code='tip.noData'/></span>',
		                pagination:true,
		                rownumbers: true,
		                singleSelect: false,
		                toolbar: '#Sortltem_dg_toolbar5',
		                clientPaging:false,
                        remoteFilter:true,
		                url: '',
		                striped:true,
		                method: 'get' 
		                ">
		            <thead>
		                <tr>
		                 <th data-options="field:'atr_key',checkbox:true"></th>
		                    <!-- 备胎-->
		                    <th data-options="field:'spare3_s',formatter:classFormatter,width:80,editor:{type:'combobox',options:{required:true,
		                    		 textField: 'label',
						      		 valueField: 'value',
		                    		 data:[{label:'正常胎',value:'1'},
						             {label:'备胎',value:'0'}],
						             min:0,max:100,precision:0}}"><spring:message code="sortltem.column.beitai" /></th>
		                     <!-- 品号 -->
		                    <th data-options="field:'itemid_s',width:80"><spring:message code="sortltem.column.itemid_s" /></th>
		                    <!-- 物料描述 -->
							<th data-options="field:'materialdesc_s',width:80"><spring:message code="materials.column.materialdesc_s" /></th>
     	                </tr>
		            </thead>
		        </table>
    
    
    
       </div><!-- 抽检维护终止位置 -->
      
      
      
      
      
      
      
      
      
     </div>
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="Sortltem_search_form" />
		<jsp:param name="datagridId" value="sortltem_dg" />
		<jsp:param name="handlerClass"
			value="com.bluebirdme.mes.linglong.finalcheck.excel.SortltemExportHandler" />
		<jsp:param name="serviceName" value="SortltemServiceImpl" />
	</jsp:include>
 </body>
</html>
