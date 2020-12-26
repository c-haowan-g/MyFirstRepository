<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"common/halfPartProcess/halfpartprocess/saveChanges";
    
    function showOrHide(){
        if($("#HalfPartProcess_search_form").is(":hidden")){
            $("#HalfPartProcess_search_form").show();
        }else{
            $("#HalfPartProcess_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("halfpartprocess_dg","HalfPartProcess_search_form");
    }
    
    function selectrow(){
		var rows=$("#halfpartprocess_dg").datagrid('getSelected');
		
		var ids=rows.id_s;
		$("#id_s").textbox("setValue", ids);
		var url ="common/halfPartProcess/halfpartprocess/datagrid2?ids="+ids;
		ext.ajax.get(url, function(data) {
			console.log(data);
			$('#halfpartparameter_dg').datagrid('loadData',data);
		});
	}

    function cancel() {
        $("#halfpartprocess_dg").datagrid("rejectChanges");
    }


</script>