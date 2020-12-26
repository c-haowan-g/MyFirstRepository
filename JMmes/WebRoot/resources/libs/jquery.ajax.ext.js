(function($){
    //备份jquery的ajax方法
    var _ajax=$.ajax;
     
    //重写jquery的ajax方法
    $.ajax=function(opt){
        //备份opt中error和success方法
        var fn = {
            error:function(XMLHttpRequest, textStatus, errorThrown){},
            success:function(data, textStatus){}
        }
        if(opt.error){
            fn.error=opt.error;
        }
        if(opt.success){
            fn.success=opt.success;
        }
         
        //扩展错误和成功的回调
        var _opt = $.extend(opt,{
            error:function(data, textStatus, errorThrown){
            	ext.loading.hide();
                //错误方法增强处理
                if(data.readyState==0){
            		ext.tip.error(shutdown);
            		return;
            	}
            	fn.error(XMLHttpRequest, textStatus, errorThrown);
            },
            success:function(data, textStatus){
            	ext.loading.hide();
            	//会话过期
            	try {
            		if(data.code==EXPIRED){
            			ext.tip.error(expired);
                		setTimeout(function(){
            				top.location.href=path;
            			}, 1000);
            		}
				} catch (e) {}
								
				try {
					fn.success(data,textStatus);
				} catch (e) {}
				
            },
            beforeSend:function(XHR){
                //提交前回调方法
            	XHR.setRequestHeader("factory:'"+factory+"'");
            	
            },
            headers:{'factory':factory},
            complete:function(XHR, TS){
                //请求完成后回调函数 (请求成功或失败之后均调用)
            }
        });
        _ajax(_opt);
    };
})(jQuery);
