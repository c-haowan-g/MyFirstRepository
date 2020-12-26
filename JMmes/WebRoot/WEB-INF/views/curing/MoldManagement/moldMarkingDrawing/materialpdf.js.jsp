<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges="curing/moldmanagement/moldmarkingdrawing/materialpdf/saveChanges";
    
    function showOrHide(){
        if($("#MaterialPDF_search_form").is(":hidden")){
            $("#MaterialPDF_search_form").show();
        }else{
            $("#MaterialPDF_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("materialpdf_dg","MaterialPDF_search_form");
    }
    
    function add() {
    	ext.easyui.grid.appendAndEdit("materialpdf_dg",{
    		is_flag_s: new Calendar().format("0")
		});
    }

    function edit() {
        var rows = $("#materialpdf_dg").datagrid("getSelections");
        if(rows.length != 0){
        	var index = -1;
            for (var i = 0; i < rows.length; i++) {
                index = $("#materialpdf_dg").datagrid("getRowIndex", rows[i]);
                $("#materialpdf_dg").datagrid("beginEdit", index);
            }
        }else{
        	ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
        }
    }

    function remove() {
        var rows = $("#materialpdf_dg").datagrid("getSelections");
        if(rows.length != 0){
        	 var index = -1;
             for (var i = 0; i < rows.length; i++) {
                 index = $("#materialpdf_dg").datagrid("getRowIndex", rows[i]);
                 $("#materialpdf_dg").datagrid("deleteRow", index);
             }
        }else{
             ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
        }
    }

    function save() {
       var dg = $("#materialpdf_dg");

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

		if(inserted.length ==0 && updated.length ==0 && deleted.length ==0){
			
			$("#materialpdf_dg").datagrid("reload");
            ext.tip.error("<spring:message code="tip.nosave" />")
		}else{
	            
			var arysave = new Array(); 
			for(var i=0;i<inserted.length;i++){
				delete inserted[i]["created_by_name"];
				delete inserted[i]["changed_by_name"];
				delete inserted[i]["uploader_s_name"];
				delete inserted[i]["pdf_name_original_s_temp"];
				delete inserted[i]["webpath"];
				if(inserted[i]["is_flag_s"]=="1"){
					arysave[i]=inserted[i]["material_code_s"]+inserted[i]["is_flag_s"];
				}
			}
			var aryupdate = new Array(); 
			for(var i=0;i<updated.length;i++){
				delete updated[i]["created_by_name"];
				delete updated[i]["changed_by_name"];
				delete updated[i]["uploader_s_name"];
				delete updated[i]["pdf_name_original_s_temp"];
				delete updated[i]["webpath"];
				if(updated[i]["is_flag_s"]=="1"){
					aryupdate[i]=updated[i]["material_code_s"]+updated[i]["is_flag_s"];
				}
				
			}
			for(var i=0;i<deleted.length;i++){
				delete deleted[i]["created_by_name"];
				delete deleted[i]["changed_by_name"];
				delete deleted[i]["uploader_s_name"];
				delete deleted[i]["pdf_name_original_s_temp"];
				delete deleted[i]["webpath"];
			}
			var narySave=arysave.sort();  
			var naryUpdate=aryupdate.sort();  
			for(var i=0;i<arysave.length;i++){  
				 if (narySave[i]==narySave[i+1]){  
					ext.tip.error("<spring:message code="tip.error" />");
					return;
				 }
			 } 
			 for(var i=0;i<aryupdate.length;i++){  
				 if (naryUpdate[i]==naryUpdate[i+1]){  
					ext.tip.error("<spring:message code="tip.error" />");
					return; 
				 }
			 } 
			ext.ajax.sendJson(saveChanges, {
		            inserted : inserted,
		            updated : updated,
		            deleted : deleted
		       }, function(data) {
		    	   if (data.code != 0) {
		        		  if(data.code == 1){
		        			  if(data.message=="代码重复"){
		        				$("#materialpdf_dg").datagrid("reload");
		                      ext.tip.error("<spring:message code="tip.repeat" />");
		        			  }else{
		        			   $("#materialpdf_dg").datagrid("reload");
		                       ext.tip.error("<spring:message code="tip.error" />");
		        			  }
		        		  }
		              }else{
		            	  $("#materialpdf_dg").datagrid("reload");
		                  ext.tip.suc("<spring:message code="tip.success" />")
		              }
		        });
		}
    }

    function cancel() {
        $("#materialpdf_dg").datagrid("rejectChanges");
    }
    
    //生成uuid方法
    function getUUID() {
        var s = [];
        var hexDigits = "0123456789abcdef";
        for (var i = 0; i < 36; i++) {
            s[i] = hexDigits.substr(Math.floor(Math.random() * 0x10), 1);
        }
        s[14] = "4";  // bits 12-15 of the time_hi_and_version field to 0010
        s[19] = hexDigits.substr((s[19] & 0x3) | 0x8, 1);  // bits 6-7 of the clock_seq_hi_and_reserved to 01
        s[8] = s[13] = s[18] = s[23] = "-";
     
        var uuid = s.join("");
        return uuid;
    }
	//上传文件
   function upload(nv,ov){
	   //获取一个上传文件的扩展名
	   
	   if(nv.substring(nv.length-3)!="pdf"){
		   ext.tip.error("<spring:message code="tip.errorPdf" />");
	   }else{
		   var _this=this;
		   var fileInputId=$(this).parent("").find("input[type=file]").attr("id");
		   var uuid=getUUID();
		   file.upload(fileInputId,uuid,true,function(data){
			   var index=$(_this).parents("[datagrid-row-index]").attr("datagrid-row-index");
			   var row=$("#materialpdf_dg").datagrid("getRows")[index];//获得选中行的信息
			   row.storage_path_s=uuid;
			   row.pdf_name_original_s=data.data.fileName;
		   }); 
	   }
	   
	   
   }
   //下载文件
   function downloads(){
	   debugger
	   var files = [];
	   var rows = $("#materialpdf_dg").datagrid('getSelections');
	   for(var i=0; i<rows.length; i++){
		   if(rows[i].webpath){
			   files.push(rows[i].storage_path_s);
		   }else{
			   ext.tip.error("<spring:message code="tip.noName" />");
			   return;
		   }
	   }
	   
	   if(rows.length != 0){
		   down(files,0);
	   }else{
		   ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
	   }
	   
   }
   
   
   var downloadTimeout=null;
   
   function down(files,index){
	   ext.tip.suc("正在下载"+(index+1)+"/"+files.length+"个文件");
	   file.downloadDir(files[index]);
	   
	   if(index<files.length-1){
		   c=setTimeout(function(){
			   down(files,++index);
		   },2000);
	   }else{
		   clearTimeout(downloadTimeout);
	   }
	   
	   
   }
   
   //查看文件
   function check(){
	   debugger
	   var selected=$("#materialpdf_dg").datagrid("getSelections")[0];
	   if(selected !=null){
		   var selec=selected.webpath;
		   if(selec != null){
			 //获取路径
			   var pathName=window.document.location.pathname;
			   //截取，得到项目名称
			   var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
			   var paths=path.replace(projectName,"");
			   window.open(paths+"file"+selec);
		   }else{
			   ext.tip.error("<spring:message code="tip.noName" />");
		   }
		   
	   }else{
		   ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
	   }
	   
   }
   //双击查看文件
   $(function () {
       $("#materialpdf_dg").datagrid({
           //双击事件
           onDblClickRow: function (index, row) {
        	   var selected=row.webpath;
        	   //获取路径
        	   var pathName=window.document.location.pathname;
        	   //截取，得到项目名称
        	   var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
        	   var paths=path.replace(projectName,"");
        	   if(selected !=null){
        		   window.open(paths+"file"+selected);
        	   }else{
        		   ext.tip.error("<spring:message code="tip.noName" />");
        	   };
           }
       });
   });

</script>