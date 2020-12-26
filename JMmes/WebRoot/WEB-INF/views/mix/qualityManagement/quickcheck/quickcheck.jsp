<!-- 
    作者      :栾和源	
    时间      :2020-12-16 13:10:51 
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="quickcheck.js.jsp"%>
<script type="text/javascript" src="resources/libs/ichart.1.1.min.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="QuickCheck_dg_toolbar">
            <form id="QuickCheck_search_form" class="form" >
                <!-- 实验时间 -->
                &emsp;<spring:message code="quickcheck.column.check_time_s" />:&nbsp;
                <input name="filter[start_time_t]" type="text" editable="true" id="start_time_t" class="easyui-datetimebox">
				&nbsp;<spring:message code="tip.to" /> &nbsp;
				 <input name="filter[end_time_t]" editable="true" id="end_time_t" class="easyui-datetimebox"> 
				 <!-- 物料编码 -->
                <spring:message code="quickcheckmain.column.material_code_s" />
                <input name="filter[material_code_s]" id="material_code_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!--物料名称material_name_s-->
                物料名称
                <input name="filter[material_name_s]" id="material_name_s" type="text" class="easyui-textbox" data-options="label:''" >
				 <!-- 快检检验配方编号 -->
                <spring:message code="quickcheckmain.column.quickcheck_recipe_code_s" />
                &nbsp;<input name="filter[quickcheck_recipe_code_s]" id="quickcheck_recipe_code_s" type="text" class="easyui-textbox" data-options="label:''" >
                &emsp;<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
                &emsp;<auth:button code="quickcheck_export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="doExport()"><spring:message code="button.export" /></a></auth:button>
            </form> 
            <auth:button code="quickcheck_ML"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-para'" onclick="ichartML('ML')">ML曲线</a>  </auth:button>
            <auth:button code="quickcheck_MH"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-para'" onclick="ichartML('MH')">MH曲线</a>  </auth:button>
            <auth:button code="quickcheck_T30"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-para'" onclick="ichartML('T30')">T30</a>  </auth:button>
            <auth:button code="quickcheck_T60"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-para'" onclick="ichartML('T60')">T60</a>  </auth:button>
            <auth:button code="quickcheck_T25"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-para'" onclick="ichartML('T25')">T25</a>  </auth:button>
            <auth:button code="quickcheck_ND"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-para'" onclick="ichartML('ML(1+4)')">粘度</a>  </auth:button>
            <auth:button code="quickcheck_JS"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-para'" onclick="ichartML('T5')">焦烧</a>  </auth:button>
            <auth:button code="quickcheck_YD"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-para'" onclick="ichartML('硬度')">硬度</a>  </auth:button>
            <auth:button code="quickcheck_BZ"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-para'" onclick="ichartML('比重')">比重</a>  </auth:button>
        </div>
        <table id="quickcheck_dg" class="easyui-datagrid" style="width:100%" 
					data-options="  fit:true,
									fitColumns:true,
									singleSelect: false,
	                                pagination:true,
			                        rownumbers: true,
									toolbar: '#QuickCheck_dg_toolbar',
									emptyMsg: '<span><spring:message code='tip.noData'/></span>',
									striped:true,
									url:'',
									method:'get'">
            <thead>
                <tr>
                    <th data-options="field:'ATR_KEY',checkbox:true"></th>
                    <!-- 取样试样号：喷码编码 -->
                    <th data-options="field:'SAMPLENO_S'"><spring:message code="quickcheckmain.column.sampleno_s" /></th>
                    <!-- 取样车次号 -->
                    <th data-options="field:'TRAIN_NUM_S'"><spring:message code="quickcheckmain.column.train_num_s" /></th>
                    <!-- 最终检测结果 -->
                    <th data-options="field:'STATE_CODE_S'"><spring:message code="quickcheckmain.column.state_code_s" /></th>
                    <!-- 顺序号 -->
                    <th data-options="field:'SEQ_I'"><spring:message code="quickcheckmain.column.seq_i" /></th>
                    <!-- 密炼工单跟踪表，工单号 -->
                    <th data-options="field:'WO_NO_S'"><spring:message code="quickcheckmain.column.wo_no_s" /></th>
                    <!-- 快检班次 -->
                    <th data-options="field:'SHIIFT_CHECK_S'"><spring:message code="quickcheckmain.column.shiift_check_s" /></th>
                    <!-- 快检检验配方编号 -->
                    <th data-options="field:'QUICKCHECK_RECIPE_CODE_S'"><spring:message code="quickcheckmain.column.quickcheck_recipe_code_s" /></th>
                    <!-- 生产机台条码 -->
                    <th data-options="field:'EQUIP_CODE_S'"><spring:message code="quickcheckmain.column.equip_code_s" /></th>
                    <!-- 生产机台名称 -->
                    <th data-options="field:'EQUIP_NAME_S'"><spring:message code="quickcheckmain.column.equip_name_s" /></th>
                    <!-- 硫变仪机台条码 -->
                    <th data-options="field:'EQUIP_SA_S',formatter:lbformatter"><spring:message code="quickcheckmain.column.equip_sa_s" /></th>
                    <!-- 门尼机台条码 -->
                    <th data-options="field:'EQUIP_MI_S',formatter:mnformatter "><spring:message code="quickcheckmain.column.equip_mi_s" /></th>
                    <!-- 胶料批次号 -->
                    <th data-options="field:'LOT_NO_S'"><spring:message code="quickcheckmain.column.lot_no_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'MATERIAL_CODE_S'"><spring:message code="quickcheckmain.column.material_code_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'MATERIAL_NAME_S'"><spring:message code="quickcheckmain.column.material_name_s" /></th>
                    <!-- ML -->
                    <th data-options="field:'ML',sortable:true"><spring:message code="quickcheck.column.ML" /></th>
                    <!-- MH -->
                    <th data-options="field:'MH',sortable:true"><spring:message code="quickcheck.column.MH" /></th>
                     <!-- Ts1-->
                    <th data-options="field:'SPARE1_S',sortable:true">Ts1</th>
                    <!-- T30 -->
                    <th data-options="field:'T30',sortable:true"><spring:message code="quickcheck.column.T30" /></th>
                    <!-- T60 -->
                    <th data-options="field:'T60',sortable:true"><spring:message code="quickcheck.column.T60" /></th>
                    <!-- T25 -->
                    <th data-options="field:'T25',sortable:true"><spring:message code="quickcheck.column.T25" /></th>
                    
                    <!-- 粘度 -->
                    <th data-options="field:'ND',sortable:true"><spring:message code="quickcheck.column.ND" /></th>
                    <!-- 焦烧 -->
                    <th data-options="field:'JS',sortable:true"><spring:message code="quickcheck.column.JS" /></th>
                    <!-- 比重 -->
                    <th data-options="field:'BZ',sortable:true"><spring:message code="quickcheck.column.BJ" /></th>
                    <!-- 硬度 -->
                    <th data-options="field:'YD',sortable:true"><spring:message code="quickcheck.column.YD" /></th>
                    <!-- T25S -->
                    <th data-options="field:'SPARE3_S',sortable:true"><spring:message code="quickcheck.column.T25S" /></th>
                    <th data-options="field:'LJNAME'">炼胶人</th>
                    <th data-options="field:'BEGINTIME'">炼胶时间</th>
                      <!-- 创建人姓名 -->
                    <th data-options="field:'CREATED_NAME_S'"><spring:message code="quickcheckmain.column.created_name_s" /></th>
                    <!-- 创建时间 -->
                        <th data-options="field:'CREATED_TIME_T'"><spring:message code="quickcheckmain.column.created_time_t" /></th>
                  </tr>
            </thead>
        </table>
    </div>
     <div id="ml_qx" class="easyui-window" title="查看快检曲线"  maximized="true"  style="width:1200px;height:700px" closed="true">
         	
		  <div id='canvasDiv'  ></div>
    </div>
</body>
</html>
