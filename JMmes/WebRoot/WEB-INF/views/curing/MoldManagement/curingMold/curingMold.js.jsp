	<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<script type="text/javascript">
	var change_maxnum_i =null;//水洗最高使用次数
	var clear_maxnum_i=null;//干冰洗最高使用次数
	var mold_wash_i=null;//水洗预警次数
	var mold_icewash_i=null;//干冰洗预警次数
	var datasource = [];//选择规格查询花纹赋值
	var Inventory_locations=[];//库存位置
	//自定义文本框验证
	$.extend($.fn.validatebox.defaults.rules, {
		unique : {
			validator : function(value, param) {
				var result =null;
					 $.ajax({
						url:"curing/moldmanagement/curingmold/CheckMoldCode?mold_code="+value,
						type:"get",
						dataType:"json",
						async:false,
						success:function(flag){
							result=flag==0;
						}
					 });
					 return result;
			},message : '条码已存在'
		},
	  number : {
	      validator : function(value, param) {
	          return /^[0-9]*$/.test(value);
	      },
	      message : "请输入数字"
	  }
	});
	//选择规格，触发花纹查询事件
	var SpecOnChange =function (value){
		 $.ajax({
		 		url:"curing/moldmanagement/curingmold/getPattByspec?thspec_s="+value,
		 		type:"get",
		 		dataType:"json",
		 		async:false,
		 		success:function(data){
		 			datasource=data;
		 		} });
		
		  var k=$(this).parents('[datagrid-row-index]').attr('datagrid-row-index');
	      var td=$('.datagrid-body td[field=\'flower_pattern_s\']')[k];
	      var input = $(td).find('input')[0];
	      $(input).combobox("clear");
		  $(input).combobox("loadData",datasource);
	};
	//选择花纹后触发事件
	var PattOnChange =function (row){
		
		var index = $(this).parents("[datagrid-row-index]").attr(
		"datagrid-row-index");

		var thspecEditor = $("#dg").datagrid('getEditor', {
			index : index,
			field : "mold_spec_s"
		});
		var pattEditor = $("#dg").datagrid('getEditor', {
			index : index,
			field : "flower_pattern_s"
		});
		var thspec = $(thspecEditor.target).textbox("getValue");
		var patt = $(pattEditor.target).textbox("getValue");
		 $.ajax({
		 		url:"curing/moldmanagement/curingmold/getCjBySpecandPatt?thspec_s="+thspec+"&patt="+patt,
		 		type:"get",
		 		dataType:"json",
		 		async:false,
		 		success:function(data){
		 			datasource=data;
		 		} });
		
		  var k=$(this).parents('[datagrid-row-index]').attr('datagrid-row-index');
	   var td=$('.datagrid-body td[field=\'spare1_s\']')[k];
	   var input = $(td).find('input')[0];
	   $(input).combobox("clear");
		  $(input).combobox("loadData",datasource);
	}
	
	
	
	//刷新库存位置
	var Inventory_location=function (){
		 $.ajax({
		 		url:"curing/moldmanagement/curingmold/comboxMoldLocation",
		 		type:"get",
		 		dataType:"json",
		 		async:false,
		 		success:function(data){
		 			Inventory_locations=data;
		 		} });
		
		  var k=$(this).parents('[datagrid-row-index]').attr('datagrid-row-index');
	      var td=$('.datagrid-body td[field=\'inventory_location_s\']')[k];
	      var input = $(td).find('input')[0];
	      $(input).combobox("clear");
		  $(input).combobox("loadData",Inventory_locations);
	}
	
	
	/* <!-- 模具信息维护 --> */
		/**
		 *数据字典传值
		 *
		 */
		function codeFormatter(v, r, i) {
		
			return dictFormat(v);
		}
		
		 
	 
	/*    模具条码行 */
	  var getValue= function (option){
		  var value = option.data.target.value;
			if(value!=null||value!=undefined){
				var k=$(this).parents('[datagrid-row-index]').attr('datagrid-row-index');
		        var td=$('.datagrid-body td[field=\'mold_id_s\']')[k];
		        var input = $(td).find('input')[0];
		        $(input).textbox('setValue',value);
		        CheckMoldCode(value);//验证是否有重复数据
		      /*   moldCode=value; */
			}
			
		}
	  
	/* 	  验证模具条码是否重复 */
	  function CheckMoldCode(moldCode){
			 $.ajax({
					url:"curing/moldmanagement/curingmold/CheckMoldCode?mold_code="+moldCode,
					type:"get",
					dataType:"json",
					async:false,
					success:function(data){
						if(data==-1){
							ext.tip.error("<spring:message code="tip.barcode_repeat" />");
						}
					}
				 });
		}
		
		
	  
	  
		/*   组模状态 */
		var stateText=function (value, rowData, rowIndex){
			if(value==1){
				return "可以";
			}else if(value==0){
				return "不可以";
			}
		}
		
		/**
		*添加事件
		*/
		function add() {
			/* 设置默认值 */
			ext.easyui.grid.appendAndEdit("dg",	
					{after_change_mold_num_i:0,
					use_num_i:0,
					total_number_i:0,
					after_clean_mold_num_i:0,
					wash_state_s:0,
					statues_id_s:"208006",
					repair_state_s:"1",
					purchase_time_s:new Calendar().format("yyyy-MM-dd HH:mm:ss")});
		}
		//选择模具类型，触发的事件
		var onchangeText=function (value,o) {
			   	 if(value!=null||value!=undefined){ 
						var k=$(this).parents('[datagrid-row-index]').attr('datagrid-row-index');
						//水洗最高使用次数
						var change_maxnum_i_td=$('.datagrid-body td[field=\'change_maxnum_i\']')[k];
				        var change_maxnum_i_input = $(change_maxnum_i_td).find('input')[0];
				      	//干冰洗最高使用次数
						var clear_maxnum_i_td=$('.datagrid-body td[field=\'clear_maxnum_i\']')[k];
				        var clear_maxnum_i_input = $(clear_maxnum_i_td).find('input')[0];
				        //水洗预警次数
						var mold_wash_i_td=$('.datagrid-body td[field=\'mold_wash_i\']')[k];
				        var mold_wash_i_input = $(mold_wash_i_td).find('input')[0];
				        //干冰洗预警次数
						var mold_icewash_i_td=$('.datagrid-body td[field=\'mold_icewash_i\']')[k];
				        var mold_icewash_i_input = $(mold_icewash_i_td).find('input')[0];
				        //选择模具类型，自动设置次数
						if(value==205001){
							if(factory==2){
								 change_maxnum_i=229002001;
								 clear_maxnum_i=229001001;
							}else if(factory==1){
								 change_maxnum_i=229008001;
								 clear_maxnum_i=229007001;
							}
							mold_wash_i=229005001;
							 mold_icewash_i=229004001;
				        	ext.ajax.sendJson("curing/moldmanagement/curingmold/getErpCode", change_maxnum_i, function(data) {
								$(change_maxnum_i_input).textbox('setValue',data);
							});
				        	ext.ajax.sendJson("curing/moldmanagement/curingmold/getErpCode", clear_maxnum_i, function(data) {
								$(clear_maxnum_i_input).textbox('setValue',data);
							});
				        	ext.ajax.sendJson("curing/moldmanagement/curingmold/getErpCode", mold_wash_i, function(data) {
								$(mold_wash_i_input).textbox('setValue',data);
							});
				        	ext.ajax.sendJson("curing/moldmanagement/curingmold/getErpCode", mold_icewash_i, function(data) {
								$(mold_icewash_i_input).textbox('setValue',data);
							});
				        }else if(value==205002){
				        	if(factory==2){
								 change_maxnum_i=229002001;
								 clear_maxnum_i=229001001;
							}else if(factory==1){
								 change_maxnum_i=229008001;
								 clear_maxnum_i=229007001;
							}
							 mold_wash_i=229005002;
							 mold_icewash_i=229004002;
				        	ext.ajax.sendJson("curing/moldmanagement/curingmold/getErpCode", change_maxnum_i, function(data) {
								$(change_maxnum_i_input).textbox('setValue',data);
							});
				        	ext.ajax.sendJson("curing/moldmanagement/curingmold/getErpCode", clear_maxnum_i, function(data) {
								$(clear_maxnum_i_input).textbox('setValue',data);
							});
				        	ext.ajax.sendJson("curing/moldmanagement/curingmold/getErpCode", mold_wash_i, function(data) {
								$(mold_wash_i_input).textbox('setValue',data);
							});
				        	ext.ajax.sendJson("curing/moldmanagement/curingmold/getErpCode", mold_icewash_i, function(data) {
								$(mold_icewash_i_input).textbox('setValue',data);
							});
				        }else if(value==205003){
				        	if(factory==2){
								 change_maxnum_i=229002001;
								 clear_maxnum_i=229001001;
							}else if(factory==1){
								 change_maxnum_i=229008001;
								 clear_maxnum_i=229007001;
							}
							 mold_wash_i=229005003;
							 mold_icewash_i=229004003;
				        	ext.ajax.sendJson("curing/moldmanagement/curingmold/getErpCode", change_maxnum_i, function(data) {
								$(change_maxnum_i_input).textbox('setValue',data);
							});
				        	ext.ajax.sendJson("curing/moldmanagement/curingmold/getErpCode", clear_maxnum_i, function(data) {
								$(clear_maxnum_i_input).textbox('setValue',data);
							});
				        	ext.ajax.sendJson("curing/moldmanagement/curingmold/getErpCode", mold_wash_i, function(data) {
								$(mold_wash_i_input).textbox('setValue',data);
							});
				        	ext.ajax.sendJson("curing/moldmanagement/curingmold/getErpCode", mold_icewash_i, function(data) {
								$(mold_icewash_i_input).textbox('setValue',data);
							});
				        }
				        }
			  	} 
		
		//查询栏按钮
		function queryBar() {
			$("#query_bar").toggle(500);
		}
		
		/**
		*修改事件
		*/
		function edit() {
			var rows = $("#dg").datagrid("getSelections");
			var index = -1;
			if (rows == "") {
				ext.tip.error("<spring:message code="tip.edit" />");
			}
			for (var i = 0; i < rows.length; i++) {
				index = $("#dg").datagrid("getRowIndex", rows[i]);
				$("#dg").datagrid("endEdit", index);
			}
			for (var i = 0; i < rows.length; i++) {
				index = $("#dg").datagrid("getRowIndex", rows[i]);
				$("#dg").datagrid("beginEdit", index);
				//判断未入库状态
		    	if(rows[i]["statues_id_s"]=="208006"){
		    		/* 累计值为0，组模状态为可以 */
			    	if(rows[i]["total_number_i"]==0 && rows[i]["repair_state_s"]==1){
			    		
			    	 }else if(rows[i]["total_number_i"]==0 && rows[i]["repair_state_s"]==0){
			    		 //规格
			    		 var mold_spec_s = $("#dg").datagrid('getEditor', {index:index,field:'mold_spec_s'});
			           	 $(mold_spec_s.target).textbox({disabled: true});//不可编辑
			           	 //花纹
			    		 var flower_pattern_s = $("#dg").datagrid('getEditor', {index:index,field:'flower_pattern_s'});
			           	 $(flower_pattern_s.target).textbox({disabled: true});//不可编辑
			        	 //层级
			    		 var spare1_s = $("#dg").datagrid('getEditor', {index:index,field:'spare1_s'});
			           	 $(spare1_s.target).textbox({disabled: true});//不可编辑
			    	 }else{ 
					    	 //规格
				    		 var mold_spec_s = $("#dg").datagrid('getEditor', {index:index,field:'mold_spec_s'});
				           	 $(mold_spec_s.target).textbox({disabled: true});//不可编辑
				           	 //花纹
				    		 var flower_pattern_s = $("#dg").datagrid('getEditor', {index:index,field:'flower_pattern_s'});
				           	 $(flower_pattern_s.target).textbox({disabled: true});//不可编辑
				        	 //层级
				    		 var spare1_s = $("#dg").datagrid('getEditor', {index:index,field:'spare1_s'});
				           	 $(spare1_s.target).textbox({disabled: true});//不可编辑
				           	 //类型
				    		 var mold_type_s = $("#dg").datagrid('getEditor', {index:index,field:'mold_type_s'});
				           	 $(mold_type_s.target).textbox({disabled: true});//不可编辑
				           	 //模具编号
				    		 var mold_id_s = $("#dg").datagrid('getEditor', {index:index,field:'mold_id_s'});
				           	 $(mold_id_s.target).textbox({disabled: true});//不可编辑
				           	 //进厂时间
				    		 var purchase_time_s = $("#dg").datagrid('getEditor', {index:index,field:'purchase_time_s'});
				           	 $(purchase_time_s.target).textbox({disabled: true});//不可编辑
			    	 }
		    		}else if(rows[i]["statues_id_s"]=="208001" || rows[i]["statues_id_s"] == "208004"){//判断已出库状态
		    			//判断组模状态可以1，累计值为0
		    			if(rows[i]["total_number_i"]==0 && rows[i]["repair_state_s"]==1){
		    				//状态
				    		 var statues_id_s = $("#dg").datagrid('getEditor', {index:index,field:'statues_id_s'});
				           	 $(statues_id_s.target).textbox({disabled: true});//不可编辑
					    	//条码
				    		 var mold_code_s = $("#dg").datagrid('getEditor', {index:index,field:'mold_code_s'});
				           	 $(mold_code_s.target).textbox({disabled: true});//不可编辑
				           	 //模具编号
				    		 var mold_id_s = $("#dg").datagrid('getEditor', {index:index,field:'mold_id_s'});
				           	 $(mold_id_s.target).textbox({disabled: true});//不可编辑
				           	 //进厂时间
				    		 var purchase_time_s = $("#dg").datagrid('getEditor', {index:index,field:'purchase_time_s'});
				           	 $(purchase_time_s.target).textbox({disabled: true});//不可编辑
				           	 //库位位置
		    			     var inventory_location_s = $("#dg").datagrid('getEditor', {index:index,field:'inventory_location_s'});
				           	 $(inventory_location_s.target).textbox({disabled: true});//不可编辑
				           	 
		    			}else {
		    				 //规格
				    		 var mold_spec_s = $("#dg").datagrid('getEditor', {index:index,field:'mold_spec_s'});
				           	 $(mold_spec_s.target).textbox({disabled: true});//不可编辑
				           	 //花纹
				    		 var flower_pattern_s = $("#dg").datagrid('getEditor', {index:index,field:'flower_pattern_s'});
				           	 $(flower_pattern_s.target).textbox({disabled: true});//不可编辑
				        	 //层级
				    		 var spare1_s = $("#dg").datagrid('getEditor', {index:index,field:'spare1_s'});
				           	 $(spare1_s.target).textbox({disabled: true});//不可编辑
				           	 //类型
				    		 var mold_type_s = $("#dg").datagrid('getEditor', {index:index,field:'mold_type_s'});
				           	 $(mold_type_s.target).textbox({disabled: true});//不可编辑
		    				//状态
				    		 var statues_id_s = $("#dg").datagrid('getEditor', {index:index,field:'statues_id_s'});
				           	 $(statues_id_s.target).textbox({disabled: true});//不可编辑
					    	//条码
				    		 var mold_code_s = $("#dg").datagrid('getEditor', {index:index,field:'mold_code_s'});
				           	 $(mold_code_s.target).textbox({disabled: true});//不可编辑
				           	 //模具编号
				    		 var mold_id_s = $("#dg").datagrid('getEditor', {index:index,field:'mold_id_s'});
				           	 $(mold_id_s.target).textbox({disabled: true});//不可编辑
				           	 //进厂时间
				    		 var purchase_time_s = $("#dg").datagrid('getEditor', {index:index,field:'purchase_time_s'});
				           	 $(purchase_time_s.target).textbox({disabled: true});//不可编辑
		    			     
				           	 //库位位置
		    			     var inventory_location_s = $("#dg").datagrid('getEditor', {index:index,field:'inventory_location_s'});
				           	 $(inventory_location_s.target).textbox({disabled: true});//不可编辑
		    			}
		    			
		    		}else{
				    	//状态
			    		 var statues_id_s = $("#dg").datagrid('getEditor', {index:index,field:'statues_id_s'});
			           	 $(statues_id_s.target).textbox({disabled: true});//不可编辑
				    	//条码
			    		 var mold_code_s = $("#dg").datagrid('getEditor', {index:index,field:'mold_code_s'});
			           	 $(mold_code_s.target).textbox({disabled: true});//不可编辑
				    	//规格
			    		 var mold_spec_s = $("#dg").datagrid('getEditor', {index:index,field:'mold_spec_s'});
			           	 $(mold_spec_s.target).textbox({disabled: true});//不可编辑
			           	 //花纹
			    		 var flower_pattern_s = $("#dg").datagrid('getEditor', {index:index,field:'flower_pattern_s'});
			           	 $(flower_pattern_s.target).textbox({disabled: true});//不可编辑
			           	 //层级
			    		 var spare1_s = $("#dg").datagrid('getEditor', {index:index,field:'spare1_s'});
			           	 $(spare1_s.target).textbox({disabled: true});//不可编辑
			           	 //类型
			    		 var mold_type_s = $("#dg").datagrid('getEditor', {index:index,field:'mold_type_s'});
			           	 $(mold_type_s.target).textbox({disabled: true});//不可编辑
			           	 //模具编号
			    		 var mold_id_s = $("#dg").datagrid('getEditor', {index:index,field:'mold_id_s'});
			           	 $(mold_id_s.target).textbox({disabled: true});//不可编辑
			           	 //进厂时间
			    		 var purchase_time_s = $("#dg").datagrid('getEditor', {index:index,field:'purchase_time_s'});
			           	 $(purchase_time_s.target).textbox({disabled: true});//不可编辑
		    		}
				//组模出库状态得模具允许修改规格花纹
				if(rows[i]["repair_state_s"]==1){
					//规格
		    		 var mold_spec_s = $("#dg").datagrid('getEditor', {index:index,field:'mold_spec_s'});
		           	 $(mold_spec_s.target).textbox({disabled: false});//可编辑
		           	 //花纹
		    		 var flower_pattern_s = $("#dg").datagrid('getEditor', {index:index,field:'flower_pattern_s'});
		           	 $(flower_pattern_s.target).textbox({disabled: false});//可编辑
		             //层级
		    		 var spare1_s = $("#dg").datagrid('getEditor', {index:index,field:'spare1_s'});
		           	 $(spare1_s.target).textbox({disabled: false});//可编辑
				}	
				
				
				
				
				
				
				
			}
		}
		/**
		*删除事件
		*/
		function remove() {
			
			var rows = $("#dg").datagrid("getSelections");
			var index = -1;
			for(var i=0;i<rows.length;i++){
				if(rows[i]["total_number_i"]>0){
					ext.tip.error("<spring:message code="tip.performance" />");
					return;
				}
			}
			
			if (rows == "") {
				ext.tip.error("<spring:message code="tip.remove" />");
			}else{
		        for (var i = 0; i < rows.length; i++) {
					index = $("#dg").datagrid("getRowIndex", rows[i]);
					$("#dg").datagrid("deleteRow", index);
				}
			}
		}
		/**
		*保存事件
		*/
		function save() {
			
			var dg = $("#dg");
			var rows = dg.datagrid("getRows");
			var valid = true;
			for (var i = 0; i < rows.length; i++) {
				if (!dg.datagrid("validateRow", i)) {
					ext.tip.error("<spring:message code="tip.invalid" />");
					return;
				}
			}
	
			var inserted = dg.datagrid("getChanges", "inserted");
			var updated = dg.datagrid("getChanges", "updated");
			var deleted = dg.datagrid("getChanges", "deleted");
			
			 for (var i = 0; i < rows.length; i++) {
				dg.datagrid("endEdit", i);
			} 
			
			 /*  数据回传，去掉对象中的扩展字段 */
			 for (var i = 0; i < inserted.length; i++) {
				 delete inserted[i]["created_by"];
				 delete inserted[i]["changed_by"];
			 }
			 for (var i = 0; i < updated.length; i++) {
				 delete updated[i]["created_by"];
				 delete	updated[i]["changed_by"];
			 }
			 for (var i = 0; i < deleted.length; i++) {
				 delete deleted[i]["created_by"];
				 delete deleted[i]["changed_by"];
			 }
			 
			 
			 if(inserted.length==0 && updated.length==0 && deleted.length==0){
				 ext.tip.error("<spring:message code="tip.nosave" />");
			 }else{
					 ext.ajax.sendJson("curing/moldmanagement/curingmold/saveAll", {
							inserted:inserted,
							updated:updated,
							deleted:deleted
						}, function(data) {
							if (data.message != "ok") {
								if(data.message == "代码重复"){
									 ext.tip.error("<spring:message code="tip.repeat" />");
								}else{
									 ext.tip.error("<spring:message code="tip.error" />");
								}
								
							}else{
								if(deleted.length>0){
									 //删除模具，更新库位状态为0
									 for (var i = 0; i < deleted.length; i++) {
										 console.log(deleted[i]["inventory_location_s"])
										 UnLockLocation(deleted);
									 }
								}
								 $("#dg").datagrid("reload"); 
								 ext.tip.suc("<spring:message code="tip.success" />");
								 
							}
						});
			 }
		}
		
			
			
		
		/* 新模具入库 */
		function inStock(){
			var flag=true;
			var rows = $("#dg").datagrid("getSelections");
			if (rows == "") {
				ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
			}else{
				for(var i=0;i<rows.length;i++){
					delete rows[i]["created_by"];
					delete rows[i]["changed_by"];
					if(rows[i]["statues_id_s"]!="208006"){
						ext.tip.error( "<spring:message code="tip.noInStock" />");
						return;
					}
				}
				for(var i=0;i<rows.length;i++){
					rows[i]["statues_id_s"]="208002";
					rows[i]["repair_state_s"]=0;
					rows[i]["load_date_t"]=new Calendar().format("yyyy-MM-dd HH:mm:ss");
				}
					/* 更新模具信息表 */
					 ext.ajax.sendJson("curing/moldmanagement/curingmold/saveAll", {
							updated : rows,
						}, function(data) {
							if (data.message != "ok") {
									 ext.tip.error("<spring:message code="tip.error" />");
							}else{
									//入库成功更新库位状态为1锁定
									LockLocation();
								 $("#dg").datagrid("reload"); 
								 ext.tip.suc("<spring:message code="tip.success" />");
							}
						});
				
			}
			
			
		}
		/* 更新模具库位状态 为1*/
		function LockLocation(){
			var rows = $("#dg").datagrid("getSelections");
			
			 /* 模具胶囊库位锁定标志 ,1*/
			var jsonstr="[]";
			var jsonarray=eval('('+jsonstr+')');
		 for(var i=0;i<rows.length;i++){
			 var arr={
						"storage_unit_name":rows[i]["inventory_location_s"],
						"lockflag_s":"1",
						"inventory_materialcode_s":rows[i]["mold_code_s"],
						"inventory_materialname_s":rows[i]["mold_spec_s"]+rows[i]["flower_pattern_s"]
				};
			 jsonarray.push(arr); 
			}
		 /* 更新模具胶囊库位表 ,模具库位锁定状态*/
		 ext.ajax.sendJson("curing/basedata/storageunitmanager/setStorageStatus", {
				updated : jsonarray,
			}, function(data) {
				console.log(data);
			}); 
		}
		/* 更新模具库位状态 为0*/
		function UnLockLocation(deleted){
			 /* 模具胶囊库位锁定标志 ,0*/
			var jsonstr="[]";
			var jsonarray=eval('('+jsonstr+')');
		 for(var i=0;i<deleted.length;i++){
			 var arr={
						"storage_unit_name":deleted[i]["inventory_location_s"],
						"lockflag_s":"0",
						"inventory_materialcode_s":"",
						"inventory_materialname_s":""
				};
			 jsonarray.push(arr); 
			}
		 /* 更新模具胶囊库位表 ,模具库位锁定状态*/
		 ext.ajax.sendJson("curing/basedata/storageunitmanager/setStorageStatus", {
				updated : jsonarray,
			}, function(data) {
			}); 
		}
		
		/**
		*撤销事件
		*/
		function cancel() {
			$("#dg").datagrid("rejectChanges");
			
		}
	
		/**
		*条件查询/查全部
		*/
		function doSearch(){
			ext.easyui.grid.search("dg","condition_form");
		}	
		/* 获取条码，打印 */
		function print(){
			var rows = $("#dg").datagrid("getSelections");
			if(rows.length!=0){
				var array=[];
				 for (var i = 0; i < rows.length; i++) {
					array[i] = new Object();
					array[i].mold_code_s = rows[i]["mold_code_s"];
				} 
				 var params = {
						 barCodeList:array
						 };
				ext.ajax.sendJson("curing/moldmanagement/curingmold/printBarCode",JSON.stringify(params), function(data) {
					if(data==1){
						ext.tip.suc("<spring:message code="tip.print_success" />");
					}else{
						ext.tip.error("<spring:message code="tip.print_error" />");
					}
					
				}); 
			}else{
				ext.tip.error("<spring:message code="tip.print" />");
			}
			
		}
		
		/* 模具条码 */
		var setMold_code_s =function (value){
			if(value!=null||value!=undefined){
				var k=$(this).parents('[datagrid-row-index]').attr('datagrid-row-index');
		        var td=$('.datagrid-body td[field=\'mold_id_s\']')[k];
		        var input = $(td).find('input')[0];
		        $(input).textbox('setValue',value);
			}
			
		};
		/* 模具编码 */
		var setMold_id_s= function(value){
				if(value!=null||value!=undefined){
				var k=$(this).parents('[datagrid-row-index]').attr('datagrid-row-index');
		        var td=$('.datagrid-body td[field=\'mold_code_s\']')[k];
		        var input = $(td).find('input')[0];
		        $(input).textbox('setValue',value);
	        }
		}; 
			
		
		
	
	
	</script>