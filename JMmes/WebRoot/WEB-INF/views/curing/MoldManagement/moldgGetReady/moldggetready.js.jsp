<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

	/**
	 *数据字典传值
	 *
	 */
	function codeFormatter(v, r, i) {
	
		return dictFormat(v);
	}
	
    //查询栏
    function showOrHide(){
        if($("#MoldgGetReady_search_form").is(":hidden")){
            $("#MoldgGetReady_search_form").show();
        }else{
            $("#MoldgGetReady_search_form").hide();
        }
    }
    
    //设定时间初始值从当前时间00:00:00至23:59:59
    $(function(){
    	$("#start_time").datebox({
    	    value: '3/4/2010',
    	    required: true,
    	    showSeconds: true
    	});
    	$("#end_time").datebox({
    	    value: '3/4/2010',
    	    required: true,
    	    showSeconds: true
    	});
    	filter();
    	
    	//为了初始化页面显示“暂无数据”
    	$("#equip_code_sForm").textbox("setValue","**&&***");
    	ext.easyui.grid.search("moldrecord_dg","moldrecord_dg_search_form");
    	//点击换模计划信息列表，备模履历出现相关信息
    	$('#moldggetready_dg').datagrid({
     		//单击事件   
 			 onClickRow:function(rowIndex,rowData){
 				 var rows = $("#moldggetready_dg").datagrid("getSelections");
 				 var planno_changemold_s=rows[0].planno_changemold_s;
 				 $("#equip_code_sForm").textbox("setValue",planno_changemold_s);
 				 ext.easyui.grid.search("moldrecord_dg","moldrecord_dg_search_form");
 			 }
     	 });
     	 
     	//取消复选框
     	 $("#Moldrecord_dg_one").datagrid({
              onBeforeSelect: function(index,row){
                  var row =$('#Moldrecord_dg_one').datagrid('getSelected');
                  var curRowindex = $('#Moldrecord_dg_one').datagrid('getRowIndex',row);
                  if(curRowindex != index) {return true;}
                  else{ $('#Moldrecord_dg_one').datagrid('unselectRow',index); return false;}
              }
          });
     	//取消复选框
     	 $("#Moldrecord_dg_two").datagrid({
              onBeforeSelect: function(index,row){
                  var row =$('#Moldrecord_dg_two').datagrid('getSelected');
                  var curRowindex = $('#Moldrecord_dg_two').datagrid('getRowIndex',row);
                  if(curRowindex != index) {return true;}
                  else{ $('#Moldrecord_dg_two').datagrid('unselectRow',index); return false;}
              }
          });
     	
        //模态框关闭事件
     	 $("#w").window({
  	       onBeforeClose:function(){ 
  	    	 //刷新
                 $('#Moldrecord_dg_one').datagrid('loadData', { total: 0, rows: [] });               
                 $('#Moldrecord_dg_two').datagrid('loadData', { total: 0, rows: [] });               
  	       }
  	     });
    });
    
    /**
     * 查询方法
     */
    var filter=function(){
    	var start_time=$("#start_time").datetimebox("getValue");
    	var end_time=$("#end_time").datetimebox("getValue");
    	if(start_time>end_time){
    		ext.tip.error("<spring:message code="tip.date" />");
    		return;
    	}
    	var opts = $("#moldggetready_dg").datagrid("options");
		opts.url = 'curing/moldManagement/moldgGetReady/searchBy';
        ext.easyui.grid.search("moldggetready_dg","MoldgGetReady_search_form");
    };
    
 /*根据花纹和规格查询数据*/
 function add(){
    var list_map={};
    var rows = $("#moldggetready_dg").datagrid("getSelections");
    if (rows != "" && rows != null) {
    	if(rows[0].status_s!="1"){
        	if (rows != "" && rows != null) {
                 index = $("#moldggetready_dg").datagrid("getRowIndex", rows[0]);
                 //左规格
                 list_map.speccode_left_s= rows[0].speccode_left_s;
                 //左花纹
                 list_map.flowercode_left_s=rows[0].flowercode_left_s;
                 //机台
                 list_map.equip_code_s=rows[0].equip_code_s;
                 //右规格
                 list_map.speccode_right_s=rows[0].speccode_right_s;
                 //右花纹
                 list_map.flowercode_right_s=rows[0].flowercode_right_s;
                 $("#w").window("open");
                 //校验日计划中计划数量，为零则不展示规格
                 var moldChangePlanno=rows[0].planno_changemold_s;
                 var quantityLeft=0;
                 var quantityRight=0;
		           	  $.ajax({
		      	 		url:"curing/moldManagement/moldgGetReady/getPlanNum?moldchangePlanno="+moldChangePlanno,
		      	 		type:"get",
		      	 		dataType:"json",
		      	 		async:false,
		      	 		success:function(data){
		      	 			quantityLeft=data["0"].QUANTITY_DAYPLAN_LEFT_I;
		      	 			quantityRight=data["0"].QUANTITY_DAYPLAN_RIGHT_I;
		      	 		}
		       	});
		         console.log(quantityLeft);
		         console.log(quantityRight);
		         var leftChanges="curing/moldManagement/moldgGetReady/left";
                 if(quantityLeft!=0){
                	 //ajax改为异步处理增加搜索框(修改人:马健斌)
                     $.ajax({
         		 		url:leftChanges,
         		 		type:"post",
         		 		dataType:"json",
         		 		data : JSON.stringify(list_map),
         				contentType:'application/json',
         		 		async:false,
         		 		success:function(data){
         		 			 for ( var machine =0;machine<data.length;machine++) {
                        		 var row_data = {
                        				 ATR_KEY : data[machine].ATR_KEY,
                        				 MOLD_ID_S : data[machine].MOLD_ID_S,
                        				 MOLD_SPEC_S : data[machine].MOLD_SPEC_S,
                        				 FLOWER_PATTERN_S : data[machine].FLOWER_PATTERN_S,
                        				 STATUES_ID_S : data[machine].STATUES_ID_S,
                        				 MOLD_TYPE_S : data[machine].MOLD_TYPE_S,
        	                		 };
                        		 	$("#Moldrecord_dg_one").datagrid('appendRow',row_data);
                        		 	$("#Moldrecord_dg_one").datagrid('enableFilter');//搜索框
        	                	 };
         		 		}
         		 	});
                 }
                 var rightChanges="curing/moldManagement/moldgGetReady/right";
                 if(quantityRight!=0){
                	//ajax改为异步处理增加搜索框(修改人:马健斌)
                     $.ajax({
                    	url: rightChanges,
          		 		type:"post",
          		 		dataType:"json",
          		 		data : JSON.stringify(list_map),
          				contentType:'application/json',
          		 		async:false,
                  		success:function(data){
                  			for ( var machine =0;machine<data.length;machine++) {
                       		 var row_data = {
                       				 ATR_KEY : data[machine].ATR_KEY,
                       				 MOLD_ID_S : data[machine].MOLD_ID_S,
                       				 MOLD_SPEC_S : data[machine].MOLD_SPEC_S,
                       				 FLOWER_PATTERN_S : data[machine].FLOWER_PATTERN_S,
                       				 STATUES_ID_S : data[machine].STATUES_ID_S,
                       				 MOLD_TYPE_S : data[machine].MOLD_TYPE_S,
       	                		 };
                       			 $("#Moldrecord_dg_two").datagrid('appendRow',row_data);
                       			 $("#Moldrecord_dg_two").datagrid('enableFilter');//搜索框
       	                	 };
                  		}
                  	}); 
                 }
        }else{
        	ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
        }
      }else{
    	    ext.tip.error("<spring:message code="tip.YesMold" />");
      }
    }else{
    	ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
    }
 }
    
var saveChanges=path+"curing/moldManagement/moldgGetReady/moldSave";
    //备模的保存方法
function MoldSave(){
    	var rowsLfte = $("#Moldrecord_dg_one").datagrid("getSelections");
    	var rowsRight = $("#Moldrecord_dg_two").datagrid("getSelections");
    	var rows =$("#moldggetready_dg").datagrid("getSelections");
    	console.log(rows[0].mold_barcode_left_s);
    	console.log(rows[0].moldbarcode_right_s);
    	var ifrow =$("#moldggetready_dg").datagrid("getSelections");
    	var Lfte_MODLE_SORT_S="";
    	var Right_MODLE_SORT_S="";
    	console.log(rows);
    	if(rowsLfte.length !=0 ){
    		 rows[0].mold_barcode_left_s=rowsLfte[0].MOLD_ID_S;
    		 Lfte_MODLE_SORT_S=rowsLfte[0].MOLD_TYPE_S;
    	}
    	if(rowsRight !=0){
    		 rows[0].moldbarcode_right_s=rowsRight[0].MOLD_ID_S;
    		 Right_MODLE_SORT_S=rowsRight[0].MOLD_TYPE_S;
    	}
    	 
    	if(Lfte_MODLE_SORT_S!=""&&Right_MODLE_SORT_S!=""){
    		rows[0].modle_sort_s=rowsLfte[0].MOLD_TYPE_S;
    	}else if(Right_MODLE_SORT_S!=""){
    		rows[0].modle_sort_s=Right_MODLE_SORT_S;
    	}else if(Lfte_MODLE_SORT_S!=""){
    		rows[0].modle_sort_s=Lfte_MODLE_SORT_S;
    	} 
    	
    	//判断有没有需要保存的信息
    	if(rows[0].mold_barcode_left_s==null && rows[0].moldbarcode_right_s==null){
    		 ext.tip.error("<spring:message code="tip.nosave" />");
        }else{
        	//初始判断备模计划左右规格是否都不为空
        	if(ifrow[0].speccode_left_s!=null && ifrow[0].speccode_left_s!=null){
        		 //模态框选择的模具条码是否一样
        		 if(rows[0].mold_barcode_left_s==rows[0].moldbarcode_right_s){
        			 $("#Moldrecord_dg_one").datagrid("reload");
        	   	     $("#Moldrecord_dg_two").datagrid("reload");
        			 ext.tip.error("<spring:message code="tip.mold.repeat" />");
        		//判断备模计划左右物料是否都不为空
        		}else if(rows[0].mold_barcode_left_s!=null||rows[0].moldbarcode_right_s!=null){
        				if(rows[0].material_code_right_s==null){
        					rows[0].speccode_right_s=null;
        				}
        				if(rows[0].material_code_left_s==null){
        					rows[0].speccode_left_s=null;
        				}
        			rows[0].status_s="1";
        			Utils.each(rows, function(i, d) {
        				delete d.capsule;
        				delete d.lineColor;
        			});
        		    ext.ajax.sendJson(saveChanges, {
        		        updated : rows,
        		    }, function(data) {
        		    	$("#moldggetready_dg").datagrid("reload");
        		    	$("#moldrecord_dg").datagrid("reload");
        		    	$("#Moldrecord_dg_one").datagrid("reload");
        		    	$("#Moldrecord_dg_two").datagrid("reload");
        		    });
        			$("#w").window('close'); 
        		}else{
        			ext.tip.error("<spring:message code="tip.mold.dData" />");
        		}
        	}else{
	        		rows[0].status_s="1";
	    		    ext.ajax.sendJson(saveChanges, {
	    		        updated : rows,
	    		    }, function(data) {
	    		    	$("#moldggetready_dg").datagrid("reload");
	    		    	$("#moldrecord_dg").datagrid("reload");
	    		    	$("#Moldrecord_dg_one").datagrid("reload");
	    		    	$("#Moldrecord_dg_two").datagrid("reload");
	    		    });
	    			$("#w").window('close');
        	}
        }
 }
    
    //剔除
    function MoldDelete(){
    	var rows = $("#moldggetready_dg").datagrid("getSelections");
    	if (rows != "" && rows != null) {
    		if(rows[0].status_s !="0"){
    			var bool=false;
    			//验证换模计划，换模计划如果不是已审核，不允许进行删除
	    	    $.ajax({
	    	    		url:"curing/moldManagement/moldgGetReady/validMoldChangePlan?planno_s="+rows[0].planno_changemold_s,
	    	    		type:"post",
		      	 		dataType:"json",
		      	 		async:false,
		      	 		success:function(data){
			    	    	if(data.data==false){
			                	//ext.tip.error("换模计划状态不是已审核，不允许剔除");
			                	bool=true;
			                	return;
		      	 		        }
	            }});
    			debugger;
    			if(bool){
    				ext.tip.error("换模计划状态不是已审核，不允许剔除");
    				return;
    			}
    			rows[0].status_s="0";
    			Utils.each(rows, function(i, d) {
    				delete d.capsule;
    				delete d.lineColor;
    			});
    			ext.ajax.sendJson(saveChanges, {
	 	            deleted : rows,
	 	         }, function(data) {
	 	        	 if (data.code != 0) {
		        		  if(data.code == 1){
		        			  if(data.message=="已完成"){
		        				  $("#moldggetready_dg").datagrid("reload");
		      	 	        	  $("#moldrecord_dg").datagrid("reload");
		                          ext.tip.error("<spring:message code="tip.accomplish" />");
		        			  }else{
		        				  $("#moldggetready_dg").datagrid("reload");
		      	 	        	  $("#moldrecord_dg").datagrid("reload");
		                          ext.tip.error("<spring:message code="tip.error" />");
		        			  }
		        		  }
		              }else{
		            	  $("#moldggetready_dg").datagrid("reload");
			 	          $("#moldrecord_dg").datagrid("reload");
		                  ext.tip.suc("<spring:message code="tip.success" />");
		              }
	 	         }); 
    		}else{
    			ext.tip.error("<spring:message code="tip.MoldDelete.status" />");
    		};
    	}else{
    		ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
    	}
    }
</script>