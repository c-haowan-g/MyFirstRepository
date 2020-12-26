<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"finalcheck/reportcenter/sortstorageitem/saveChanges";
    var saveChangesInfo=path+"finalcheck/reportcenter/sortstorageitem/saveInfo";
   
	  /**
     * 接收机台信息
     */
     var EntNameData=[];
 	
 	$.ajax({
 		url:"finalcheck/reportcenter/sortstorageitem/combox_entcode",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			EntNameData=data;
 		}
 	});
 	
	  /**
     * 接收物料信息
     */
     var GradeData=[];
 	
 	$.ajax({
 		url:"finalcheck/reportcenter/sortstorageitem/datagrid_material_factory",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			GradeData=data;
 		}
 	});
 	//显示物料描述
 	function materialdescFormatter(v,r,i){
 		for(var i=0;i<GradeData.length;i++){
 			if(r.itemid_s==GradeData[i].MATERIALCODE_S){
 				return GradeData[i].MATERIALDESC_S;
 			}
 		}
 	}
 	
 	
    
    function showEntNameFormatter(v,r,i){
    	for(var i=0;i<EntNameData.length;i++){
    		if(EntNameData[i].ENTBARCODE_S==v){
    			return EntNameData[i].ENTNAME_S;
    		}
    	}
    }
    
    function showOrHide(){
        if($("#SortStoragItem_search_form").is(":hidden")){
            $("#SortStoragItem_search_form").show();
        }else{
            $("#SortStoragItem_search_form").hide();
        }
    }
    
    function codeFormatter(v, r, i) {

		return dictFormat(v);
	}

    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("sortstoragitem_dg","SortStoragItem_search_form");
    }
    
    function add() {
        $("#sortstoragitem_dg").datagrid("appendRow", {});
        var rows = $("#sortstoragitem_dg").datagrid("getRows");
        $("#sortstoragitem_dg").datagrid("beginEdit", rows.length - 1);
    }

    function edit() {
        var rows = $("#sortstoragitem_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#sortstoragitem_dg").datagrid("getRowIndex", rows[i]);
            $("#sortstoragitem_dg").datagrid("beginEdit", index);
        }
    }
    
    function afterLoad(){
   	 $("#material_dg").datagrid('enableFilter');
   	 
   }

    function remove() {

        var rows = $("#sortstoragitem_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#sortstoragitem_dg").datagrid("getRowIndex", rows[i]);
            $("#sortstoragitem_dg").datagrid("deleteRow", index);
        }
       // save()
    }

    function save() {
        var dg = $("#sortstoragitem_dg");

        var rows = dg.datagrid("getRows");
        var valid = false;
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
        ext.ajax.sendJson(saveChanges, {
            inserted : inserted,
            updated : updated,
            deleted : deleted
        }, function(data) {

            if (data.code!=OK) {
                ext.tip.error("<spring:message code="tip.error" />");
            }
            $("#sortstoragitem_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />");
        

        });
    }

    function cancel() {
        $("#sortstoragitem_dg").datagrid("rejectChanges");
    }
    
    //隐藏查询栏
    function searchBar()
	{
		$("#SortStoragItem_search_form").toggle();
	}
   //维护tab页->物料栏行选择事件
   function selectmaterialrow() {
		var rows = $("#material_dg").datagrid('getSelected');
		var selectMaterialCode = rows.MATERIALCODE_S;
		var url = "finalcheck/reportcenter/sortstorageitem/exitMaterialCode?materialCode=" + selectMaterialCode;
		ext.ajax.get(url, function(data) {
			$('#grade_dg').datagrid('loadData', data);
			$('#track_dg').datagrid('loadData', []);
		});
	}
	//维护tab页->等级栏行选择事件
   function selectgraderow() {
	    var materialrow = $("#material_dg").datagrid('getSelected');
	    if(materialrow==null){
	    	ext.tip.error("<spring:message code='tip.selectsortstoragematerial'/>");
 			return;
	    }
		var graderow = $("#grade_dg").datagrid('getSelected');
		if(graderow==null){
			ext.tip.error("<spring:message code='tip.selectsortstoragegrade'/>");
 			return;
		}
		var selectMaterialCode = materialrow.MATERIALCODE_S;
		var selectGradeCode= graderow.GRADECODE_I;
		var url = "finalcheck/reportcenter/sortstorageitem/exitEntCode?materialCode=" + selectMaterialCode+"&gradeCode="+selectGradeCode;
		ext.ajax.get(url, function(data) {
			$('#track_dg').datagrid('loadData', data);
		});
	}
    //选择机台信息
    function onEntCodeSelect(){
    	var ed;
    	//
        editIndex=$(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
        ed = $("#sapproductionplan_dg").datagrid("getEditor", {index:editIndex,field:"specification_s"});
        $(ed.target).textbox("setValue", r.materialspec_s);
    }
    //显示规格menudlg
    function showgrademenudlg(){
    	var materialrow = $("#material_dg").datagrid('getSelected');
 	    if(materialrow==null){
 	    	ext.tip.error("<spring:message code='tip.selectsortstoragematerial'/>");
  			return;
 	    }
    	$("#menu_dlg").dialog("open");
    }
    //加载弹出等级页面得数据
    function loadnoselectgrade(){
    	var materialrow = $("#material_dg").datagrid('getSelected');
 	    if(materialrow==null){
 	    	ext.tip.error("<spring:message code='tip.selectsortstoragematerial'/>");
  			return;
 	    }
    	var selectMaterialCode = materialrow.MATERIALCODE_S;
 	    var url = "finalcheck/reportcenter/sortstorageitem/noSelectGradeCode?itemid_s=" + selectMaterialCode;
 	    ext.ajax.get(url, function(data) {
			$('#addgrade_dg').datagrid('loadData', data);
		});
    }
    //关闭弹出的待选项页面
    function cancelselectgrade(){
    	$("#menu_dlg").dialog("close");
    }
    //将选择得等级信息添加到中间的表格里
    function dosaveToGradeDlg() {
		var rows = $("#addgrade_dg").datagrid('getSelections');//新选的项
		if (rows.length == 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		for (var i = 0; i < rows.length; i++) {
			$('#grade_dg').datagrid('appendRow', {
				GRADECODE_I : rows[i].GRADECODE_I
			});
			
		}
		//关闭弹出界面
		cancelselectgrade();
	}

    //显示设备menudlg
    function showtrackmenudlg(){
    	var materialrow = $("#material_dg").datagrid('getSelected');
 	    if(materialrow==null){
 	    	ext.tip.error("<spring:message code='tip.selectsortstoragematerial'/>");
  			return;
 	    }
 	   var graderow = $("#grade_dg").datagrid('getSelected');
		if(graderow==null){
			ext.tip.error("<spring:message code='tip.selectsortstoragegrade'/>");
			return;
		}
    	$("#menutrack_dlg").dialog("open");
    }
    //关闭弹出的选择设备窗口
    function cancelselecttrackno(){
    	$("#menutrack_dlg").dialog("close");
    }
    
    //初始化弹出设备数据窗口
    function loadnoselecttrack(){
    	var materialrow = $("#material_dg").datagrid('getSelected');
 	    if(materialrow==null){
 	    	ext.tip.error("<spring:message code='tip.selectsortstoragematerial'/>");
  			return;
 	    }
 	    var graderow = $("#grade_dg").datagrid('getSelected');
		if(graderow==null){
			ext.tip.error("<spring:message code='tip.selectsortstoragegrade'/>");
			return;
		}
    	var selectMaterialCode = materialrow.MATERIALCODE_S;//选择的物料编码
    	var selectGradeCode=graderow.GRADECODE_I;//选择的等级编码
 	    var url = "finalcheck/reportcenter/sortstorageitem/noSelectTracknoCode?itemid_s=" + selectMaterialCode+"&gradecode="+selectGradeCode;;
 	    ext.ajax.get(url, function(data) {
			$('#addtrack_dg').datagrid('loadData', data);
		});
    }
    
    //将选择得设备信息添加到右边的列表上
    function dosaveToTracknoDlg() {
		var tracknoaddrows = $("#addtrack_dg").datagrid('getSelections');//新选的项
		if (tracknoaddrows.length == 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		for (var i = 0; i < tracknoaddrows.length; i++) {
			$('#track_dg').datagrid('appendRow', {
				ENTBARCODE_S : tracknoaddrows[i].ENTBARCODE_S,
				TRACKNO_I : tracknoaddrows[i].TRACKNO_I
			});
			
		}
		//保存到数据库-判断左侧两个数据库是否选中数据
		var materialrow = $("#material_dg").datagrid('getSelected');
 	    if(materialrow==null){
 	    	ext.tip.error("<spring:message code='tip.selectsortstoragematerial'/>");
  			return;
 	    }
 	    var graderow = $("#grade_dg").datagrid('getSelected');
		if(graderow==null){
			ext.tip.error("<spring:message code='tip.selectsortstoragegrade'/>");
			return;
		}
    	var selectMaterialCode = materialrow.MATERIALCODE_S;//选择的物料编码
    	var selectGradeCode=graderow.GRADECODE_I;//选择的等级编码
    	var saveInfo = [];
    	//保存到数据库-循环获取新插入的数据->调用保存方法
    	for(var i=0;i<tracknoaddrows.length;i++){
    		saveInfo.push(selectMaterialCode);
    		saveInfo.push(selectGradeCode);
    		saveInfo.push(tracknoaddrows[i].ENTBARCODE_S);
    		saveInfo.push(tracknoaddrows[i].TRACKNO_I);
    	}
    	console.log(saveInfo);
		ext.ajax.post(saveChangesInfo, {list:saveInfo.toString(),type:1}, function(data) {
			 if (data.code!=OK) {
	                ext.tip.error("<spring:message code="tip.error" />");
	            }
	            ext.tip.suc("<spring:message code="tip.success" />");
		});
		//关闭弹出界面
		cancelselecttrackno();
	}
    //删除数据
    function removeStorageItem(){
		//保存到数据库-判断左侧两个数据库是否选中数据
		var materialrow = $("#material_dg").datagrid('getSelected');
 	    if(materialrow==null){
 	    	ext.tip.error("<spring:message code='tip.selectsortstoragematerial'/>");
  			return;
 	    }
 	    var graderow = $("#grade_dg").datagrid('getSelected');
		if(graderow==null){
			ext.tip.error("<spring:message code='tip.selectsortstoragegrade'/>");
			return;
		}
		var tracknorows = $("#track_dg").datagrid('getSelections');//新选的项
		if (tracknorows.length == 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
    	var selectMaterialCode = materialrow.MATERIALCODE_S;//选择的物料编码
    	var selectGradeCode=graderow.GRADECODE_I;//选择的等级编码
    	var deleteInfo = [];
    	//保存到数据库-循环获取新插入的数据->调用保存方法
    	for(var i=0;i<tracknorows.length;i++){
    		deleteInfo.push(selectMaterialCode);
    		deleteInfo.push(selectGradeCode);
    		deleteInfo.push(tracknorows[i].ENTBARCODE_S);
    		deleteInfo.push(tracknorows[i].TRACKNO_I);
    	}
		ext.ajax.post(saveChangesInfo, {list:deleteInfo.toString(),type:0}, function(data) {
			 if (data.code!=OK) {
	                ext.tip.error("<spring:message code="tip.error" />");
	            }
	            ext.tip.suc("<spring:message code="tip.success" />");
	            var rows = $("#track_dg").datagrid("getSelections");
	            var index = -1;
	            for (var i = 0; i < rows.length; i++) {
	                index = $("#track_dg").datagrid("getRowIndex", rows[i]);
	                $("#track_dg").datagrid("deleteRow", index);
	            }
	            
	            var rows2 = $("#grade_dg").datagrid("getSelections");
	            var index2 = -1;
	            for (var i = 0; i < rows2.length; i++) {
	                index2 = $("#grade_dg").datagrid("getRowIndex", rows2[i]);
	                $("#grade_dg").datagrid("deleteRow", index2);
	            }
		});
    }

</script>