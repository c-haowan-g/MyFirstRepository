<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"material/qualityManagement/testtaskpush/saveChanges";
    
    function showOrHide(){
        if($("#TestTaskPush_search_form").is(":hidden")){
            $("#TestTaskPush_search_form").show();
        }else{
            $("#TestTaskPush_search_form").hide();
        }
    }
    
     /**
     * 查询方法
     */
    /* var filter=function(){
        ext.easyui.grid.search("testtaskpush_dg","TestTaskPush_search_form");
    } */
    
    

    
 
    
    
    
    
    /**
     * 查询方法
     */
    var filter=function(){
         var value = $('input[name="dummy5_s"]:checked').val();

        if("created_time"==value){
            $('#created_time_t').datetimebox({
                value: '3/4/2010 00:00:00',
                required: true,
                showSeconds: true
            });
        }
        if("sync_hand_time"==value){
            $('#sync_hand_time_t').datetimebox({
                value: '3/4/2010 00:00:00',
                required: true,
                showSeconds: true
            });
        }
        //如果是选择质检日期check_time
        if("result_receive_time"==value){
            $('#result_receive_time_t').datetimebox({
                value: '3/4/2010 00:00:00',
                required: true,
                showSeconds: true
            });
        }
        var starttime =$("#start_time").datetimebox("getValue");
        var endtime=$("#end_time").datetimebox("getValue");
        console.info("starttime"+starttime);
        console.info("endtime"+endtime);
        if(starttime!="" && endtime!=""){
            if(starttime>endtime){
                ext.tip.error("<spring:message code="tip.date" />");
            }else{
                var opts = $("#testtaskpush_dg").datagrid("options");
                opts.url = 'material/qualityManagement/testtaskpush/datagrid';
                ext.easyui.grid.search("testtaskpush_dg","TestTaskPush_search_form");
            }
        }else{
            var opts = $("#testtaskpush_dg").datagrid("options");
            opts.url = 'material/qualityManagement/testtaskpush/datagrid';
            ext.easyui.grid.search("testtaskpush_dg","TestTaskPush_search_form");
        } 

      /*  ext.easyui.grid.search("testtaskpush_dg","TestTaskPush_search_form");  */
    }
    
   

    
    function data_check_flag_s(v, r, i) {

        if (v == '0') {
            return "待处理";
        }else if(v == '1'){
            return "已处理";
        }else if(v=='2'){
            return"已拒绝";
        }
        return "";
    }
    $(function () {
        $("#testtaskpush_dg").datagrid({
            //单击事件
            onClickRow: function (index, row) {
                var mesbusinesscode_s = row.mesbusinesscode_s;//获取当前点击行的Mes业务主键
                $("#base_mesbusinesscode_s").textbox("setValue",mesbusinesscode_s);
                //提交获取的胶囊条码，查询对应的胶囊使用履历
                $("#baselist_dg").datagrid("options").url="material/qualityManagement/testtaskpush/datagrid";
                ext.easyui.grid.search("baselist_dg","TestTaskPush_searchbase_form");//第一个参数后台访问路径，第二个参数查询条件
                $("#baselist_dg").datagrid("reload");
            }
        });

        $('input:radio[name="dummy5_s"]').change(function(){
                var value = $('input[name="dummy5_s"]:checked').val();
                //如果是选择生产日期product_time
                $('#created_time_t').datetimebox({
                    value: null,
                    required: false,
                    showSeconds: true
                });
                $('#sync_hand_time_t').datetimebox({
                    value: null,
                    required: false,
                    showSeconds: true
                });
                $('#result_receive_time_t').datetimebox({
                    value: null,
                    required: false,
                    showSeconds: true
                });
                if("created_time"==value){
                    $('#created_time_t').datetimebox({
                        value: '3/4/2010 00:00:00',
                        required: true,
                        showSeconds: true
                    });
                }
              //如果是选择送检日期check_time
                if("sync_hand_time"==value){
                    $('#sync_hand_time_t').datetimebox({
                        value: '3/4/2010 00:00:00',
                        required: true,
                        showSeconds: true
                    });
                }
                //如果是选择质检日期check_time
                if("result_receive_time"==value){
                    $('#result_receive_time_t').datetimebox({
                        value: '3/4/2010 00:00:00',
                        required: true,
                        showSeconds: true
                    });
                }
            }
        )

        $("#created_time_t").next().hide();
        $("#sync_hand_time_t").next().hide();
        $("#result_receive_time_t").next().hide();
    });

    var filter1=function(){
        var value = $('input[name="dummy5_s"]:checked').val();

        if("created_time"==value){
            $('#created_time_t').datetimebox({
                value: '3/4/2010 00:00:00',
                required: true,
                showSeconds: true
            });
        }
    }

    function selectrow(){
        var rows=$("#testtaskpush_dg").datagrid('getSelected');
        $("#dtmesbusinesscode_s").html(rows.mesbusinesscode_s);
        $("#dtvenderbatch_s").html(rows.venderbatch_s);
        $("#dtdummy1_s").html(isQualified(null,rows,null));

        $("#dtdata_check_flag_s").html(checkFlagdetail(rows,null,null));
        var outofdateflag_s=rows.outofdateflag_s;
        $("#dtoutofdateflag_s").html(isOutDate(null,outofdateflag_s,null));
        $("#dtdummy2_s").html(rows.dummy2_s);
        $("#dtrefusereason_s").html(rows.refusereason_s);
        $("#dtdummy3_s").html(rows.dummy3_s);
        $("#dtresult_s").html(rows.result_s);
        $("#dtdummy4_s").html(rows.dummy4_s);
        $("#dtsync_hand_time_t").html(rows.sync_hand_time_t);
        
        $("#dtsync_hand_flag_s").html(isDispose(null,rows,null));
        
        $("#dtsync_hand_msg_s").html(rows.sync_hand_msg_s);
        
        $("#dtproducername_custom_s").html(rows.producername_custom_s);
        $("#dtdummy5_s").html(rows.dummy5_s);
        $("#dtsapcode_s").html(rows.sapcode_s);
        $("#dtrefuse_receive_time_t").html(rows.refuse_receive_time_t);
        $("#dtcreated_by_s").html(rows.created_by_name);
        $("#dtsamplename_s").html(rows.samplename_s);
        $("#dtresult_receive_time_t").html(rows.result_receive_time_t);
        $("#dtcreated_time_t").html(rows.created_time_t);
        $("#dtsamplebatch_s").html(rows.samplebatch_s);
        $("#dttdmgroupid_s").html(rows.tdmgroupid_s);
        $("#dtchanged_by_s").html(rows.changed_by_name);
        $("#dtsuppliername_s").html(rows.suppliername_s);
        $("#dts_factory_s").html(rows.s_factory_s);
        $("#dtchanged_time_t").html(rows.changed_time_t);
        $("#dtstocknum_s").html(rows.stocknum_s);
        $("#dtagenc_no_s").html(pushAgenc(null,rows,null));
        var mesbusinesscode_s=rows.mesbusinesscode_s;
/*        if(undefined!=mesbusinesscode_s){
            var url ="mix/TestTaskPush/datagrid2?mesbusinesscode="+mesbusinesscode_s;
            ext.ajax.get(url, function(data) {
                console.info(data);
//                $('#deviceparameter_dg').datagrid('loadData',data);
            });
        }else{
            alert("无mes主键无法形成关联");
            return;
        }*/
        //加载称量信息
         ext.ajax.post("material/testtaskdenial/datagrid",{"filter[mesbusinesscode_s]":mesbusinesscode_s,all:1},function(data){
            $('#reject_dg').datagrid('loadData', data);
        });
         //加载工艺信息
        ext.ajax.post("material/testtaskdetial/datagrid",{"filter[mesbusinesscode_s]":mesbusinesscode_s,all:1},function(data){
            $('#result_dg').datagrid('loadData', data);
        }); 
 

    }

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

    function codeFormatter(v, r, i) {

        return dictFormat(v);
    }

    function pushFactory(v,r,i){
        if(1==r.s_factory_s){
            return "全钢";
        }else if(2==r.s_factory_s){
            return "半钢";
        }else{
            return "";
        }
    }

    function isOutDate(v,r,i){
        if(0==r){
            return "正常状态";
        }else if(1==r){
            return "超期";
        }else{
            return "";
        }
    }

    function checkFlagdetail(v,r,i){
        if(0==v.data_check_flag_s){
            return "待处理";
        }else if(1==v.data_check_flag_s){
            return "已处理";
        }else if(2==v.data_check_flag_s){
            return "已拒绝";
        }else{
            return "";
        }
    }

    /* function factoryTab(a,b,c){
        if(1==a.s_factory_s){
            return "全钢";
        }else if(2==a.s_factory_s){
           return "半钢";
        }else{
            return "";
        }
    }
 */
    function isOutdate(v,r,i){
        if("0"==r.outofdateflag_s){
            return "正常状态";
        }else if("1"==r.outofdateflag_s){
            return "超期";
        }else{
            return "";
        }
    }
    function isDispose(v,r,i){
        if("0"==r.sync_hand_flag_s){
            return "未处理";
        }else if("1"==r.sync_hand_flag_s){
            return "已处理";
        }else if("2"==r.sync_hand_flag_s){
            return "处理失败";
        }else{
        	return "";
        }
    }

    function pushAgenc(v,r,i){
        if("8000"==r.agenc_no_s){
            return "招远";
        }else if("8002"==r.agenc_no_s){
            return "德州";
        }else if("8003"==r.agenc_no_s){
            return "柳州";
        }else if("8004"==r.agenc_no_s){
            return "泰国";
        }else{
            return "";
        }
    }

    function tdmgroupid(v,r,i){
        if("114"==r.tdmgroupid_s){
            return "招远";
        }else if("115"==r.tdmgroupid_s){
            return "德州";
        }else if("8003"==r.tdmgroupid_s){
            return "柳州";
        }else if("8004"==r.tdmgroupid_s){
            return "泰国";
        }else{
            return "";
        }
    }
    
    function isQualified(v,r,i){
        if("0"==r.dummy1_s){
            return "无DQW检测项";
        }else if("1"==r.dummy1_s){
            return "合格";
        }else if("2"==r.dummy1_s){
            return "不合格";
        }else{
            return "";
        }
    }

    //
    function exportExcel(){
        var node = $('#testtaskpush_dg').datagrid("getSelected");
        if(node==null){
            return ext.tip.error("<spring:message code="tip.selectJudgeNum" />");
        }else{
        	
            var mesbusinesscode_s = node.mesbusinesscode_s;
            var url = path+"material/qualityManagement/testtaskpush/export?mesbusinesscode_s="+mesbusinesscode_s;
            
            window.location.href=url;
        }

    }

</script>