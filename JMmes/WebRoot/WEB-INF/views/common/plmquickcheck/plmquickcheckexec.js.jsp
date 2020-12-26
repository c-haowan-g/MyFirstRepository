<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"quickcheck/baseData/plmexec/saveChanges";
    
    function showOrHide(){
        if($("#plmquickcheckexec_search_form").is(":hidden")){
            $("#plmquickcheckexec_search_form").show();
        }else{
            $("#plmquickcheckexec_search_form").hide();
        }
    }
  
    var recipeStatus=[];
    $.ajax({
        url:"dict/code/323",
        type:"get",
        dataType:"json",
        async:false,
        success:function(data){
            recipeStatus=data;
        }
    });

    //设定时间初始值从当前时间00:00:00至23:59:59
      $(document).ready(function(){
          $('#start_time').datetimebox({
              value: '3/4/2010 00:00:00',
              required: true,
              showSeconds: true
          });
          $('#end_time').datetimebox({
              value: '3/4/2010 23:59:59',
              required: true,
              showSeconds: true
          });
          filter();
      });
    /*数据同步处理*/
    function syncFormatter(v,r,i){
		if(v=="A")
			return "新增"
		else if(v=="U")
			return "修改"
		else if(v=="D")
			return "删除"
		else
			return v;
	}
    /*数据同步处理标记*/
    function flagFormatter(v,r,i){
		if(v==0){
			return "未处理";
		}else if(v==1)
			return "已处理";
		else 
			return  v;
	}
    
    /*配方状态显示转换*/
	var codeFormatter=function (value, rowData, rowIndex){
		if(value=="323001"){
			return "待用";
		}else if(value=="323002"){
			return "正用";
		}else if(value=="323003"){
			return "停用";
		}
	};
	//配方阶段,转换有问题
    /* function stageFormatter(v,r,y){
    	if(v=="ZC")
    		return "正常";
    	else if(v=="SY")
    		return "不正常";
    	else
    		return v;
    } */
    /*检验类型显示转换*/
	function typeformatter(value, rowData, rowIndex){
		if(value=="327001"){
			return "考核标准";
		}else if(value=="327002"){
			return "检验标准";
		}
	};
	//审核状态
    function stateFormatter(v,r,i){
    	if(v=="0"){
    		return "未审核";
    	}else if(v=="1"){
    		return "已审核";
    	}else{
    		return v;
    	}
    }
	/*下发标识*/
	function sendFormatter(v,r,y){
		if(v==0){
			return "未下发";
		}else if(v==1){
			return "已下发";
		}else 
			return v;		
	}
	/*检验类型显示转换*/
	var typeforText=function (value, rowData, rowIndex){
		if(value=="329001"){
			return "门尼类";
		}else if(value=="329002"){
			return "硫变类";
		}else if(value=="329003"){
			return "硬度类";
		}else if(value=="329004"){
			return "比重类";
		}else if(value=="329005"){
			return "物性";
		}else if(value=="329006"){
			return "VMA";
		}else if(value=="329007"){
			return "其他";
		}
	};
	/*上下限值符号显示转换*/
	var limitforText=function (value, rowData, rowIndex){
		if(value=="0"){
			return "不包含";
		}else if(value=="1"){
			return "包含";
		}
	};
//点击左边一行时，展示右边数据
    
	var ISOneRow = 1;//判断是否是 datagrid的一行被触发  1表示是一行被点击，0表示超链接被点击
	$(function() {
		$("#plmquickcheck_dg").datagrid({
			//单击事件
			onClickRow : function(index, row) {
				if (ISOneRow == 1) {
					ClikRow(row.recipe_code_s);
				} else {
					ISOneRow = 1;
				}
			}
		});

	});
    
	//点击行方法
	function ClikRow(value) {
		$("#recipe_code_s").textbox("setValue", value);
        
        var urlDetail="quickcheck/para/datagrid";
        
		$("#para_dg").datagrid("options").url = urlDetail;
		ext.easyui.grid.search("para_dg",
				"para_search_form");
		$("#para_dg").datagrid("reload");
	}
    /**
     * 查询方法
     */
     var filter=function(){
         var value = $('input[name="dummy4_s"]:checked').val();
         var url='quickcheck/plmexec/datagrid';
         //如果是实时的
         if("real_time"==value){
             url='quickcheck/plmexec/datagrid2';
             //如果是历史数据
         }else if("his_time"==value){
             url='quickcheck/plmexec/datagridhis';
         }
         var opts = $("#plmquickcheck_dg").datagrid("options");
         opts.url = url;
         ext.easyui.grid.search("plmquickcheck_dg","plmquickcheckexec_search_form");
     }
    
    
    function cancel() {
        $("#plmquickcheckexec_dg").datagrid("rejectChanges");
    }


   
</script>