<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../inc/meta.jsp"%>
<head>
<link href="resources/styles/login.css" rel="stylesheet" type="text/css">
   <script type="text/javascript">
        if(self!=top){
            top.location.href="<%=basePath%>";
       
		}
       
	</script>
    <title></title>
    <style>
        * {
            padding: 0;
            margin: 0;
        }

        html,
        body {
            width: 100%;
            height: 100%;
        }
    
        .cms_login {
            width: 100%;
            height: 100%;
            display: flex;
            justify-content: center;
            background-repeat: no-repeat;
            background-image: url(resources/images/hongqinew.jpg);
            background-size: 100% 100%;
        }

        .flexCenter {
            text-align: center;
            margin: auto;
        }

        .cms_login_container {
            width: 100%;
            height: 70%;
            display: flex;
            justify-content: center;
        }
        
        

        
        .login_form_block11 {
            width: 35%;
            height: 100%;
            background-color:rgb((13,144,191));
            border-radius: 10px;
            box-shadow: 0px 0px 10px #ccc;
        }

        /* .cms_login_container {
            width: 30%;
            height: 70%;
            border: 1px solid red;
        } */

        img {
            width: 100%;
            height: 100%;
        }

        .divBox {
            display: flex;
            justify-content: center;
            width: 80%;
            height: 46px;
            margin-top: 20px;
            margin-left: 10%;
            position: relative;
        }

        .cms_login_logo {
            display: flex;
            justify-content: center;
            width: 80%;
            height: 60px;
            /* border: 1px solid green; */
            margin-left: 10%;
            margin-bottom: 22px;
            margin-top: 25px;
        }

        .cms_login_img {
            width: 44px;
            height: 44px;
            position: absolute;
            top: 1px;
            left: 1px;
        }

        .cms_login_ipt {
            width: 100%;
            outline: none;
            padding-left: 50px;
        }
        .cms_login_ipt:hover {
            background-color: #B3E9F7;
            border:medium;
            outline: blue;
        }

        .cms_login_ipt60 {
            width: 60%;
            outline: none;
            padding-left: 50px;
        }

        .cms_login_ver {
            width: 30%;
            outline: none;
            margin-left: 8%;
            border: 1px solid #c32c2c;
            background-color: #bd7070;
            line-height: 46px;
            letter-spacing: 4px;
            border-radius: 4px;
            cursor: default;
            color: white;
        }

        .margin_top60 {
            margin-top: 30px;
        }

        .btn {
            width: 80%;
            height: 40px;
            letter-spacing:5px;
            font-size: 22px;
            background-color:gray;
            border: none;
            outline: none;
            border-radius: 10px;
            color: white;
        }

        .btn:hover {
            background-color: #1691d9;
            border: none;
            outline: none;
        }
        
#roll {
	height: 200px;
	width: 200px;
	position: fixed; /*fixed实现绝对定位*/
	cursor:pointer;
	
}
#roll img{
	height: 200px;
	width: 200px;
	
}
    </style>
</head>

<body>

<div id="roll">
      <img src="resources/images/timg.jpg">
</div>
<div  class="login_title"> </div>
    <div class="cms_login">
    	


        <div class="cms_login_container flexCenter" style="min-height:390px;">
       
         <div class="cms_login_image" style="min-width: 900px;">
         </div>
        <div class="login_form_block11">
            
		<div class="logo"> </div>
		
		<div>
			<form name="loginForm" action="" method="post">
				<div class="divBox">
					<img class="cms_login_img" src="resources/images/username_mark.png" >
					<input placeholder="<spring:message code="login.username" />" type="text" name="code" id="code" prompt="用户名/CODE" autocomplete="off" class=" cms_login_ipt" style="width:100%" >
				</div>
				<div class="divBox">
					<img class="cms_login_img" src="resources/images/password_mark.png">
					<input placeholder="<spring:message code="login.password" />" style="width:100%;" type="password" name="password" id="password" prompt="密码/Password" class=" cms_login_ipt">
				</div>
				<div class="divBox">
					<img class="cms_login_img" src="resources/images/verify_mark.png">
					<select class="cms_login_ipt" style="width:100%;" name="factory" id="factory"    data-options="label:''">
						<option value="1">全钢</option>
						<option value="2">半钢</option>
						
					</select>
					
				</div>
				<div class="divBox">
					<img class="cms_login_img" src="resources/images/verify_mark.png">
					<select class="cms_login_ipt" style="width:100%;" name="language" id="language"  data-options="label:''">
						<option value="zh">中文</option>
						<option value="en">English</option>
						<option value="th">ไทย</option>
					</select>
					<script type="text/javascript">
					
						$(document).ready(function(){
							 var ip_addr = document.location.hostname;
							 console.log(ip_addr)
							$("#language").val(language);
						});
						 function submitLogin(){
							 var ip_addr = document.location.hostname;
							 var ip_addr_host = document.location.host;
							 var qg_addr="192.168.86.4"
							 var bg_addr="192.168.86.9"
							var factory =$("#factory").val();
							if(ip_addr==qg_addr||ip_addr==bg_addr){
								if(factory=="2"){
									document.loginForm.action = "http://192.168.86.9/JMmes/login";
									document.loginForm.submit();
								}else if(factory=="1"){
									document.loginForm.action = "http://192.168.86.4/JMmes/login";
									document.loginForm.submit();
								} 
							}else{
								document.loginForm.action = "http://"+ip_addr_host+"/JMmes/login";
								document.loginForm.submit();
							}
						}
					</script>
				</div>
				
				
				<input type="submit" onclick="submitLogin()" class="btn divBox margin_top60" value="<spring:message code="button.login" />">
				<div style="text-align: center;color:red;font-size:large; ">${error }</div>
				
			</form>
		</div>
		
		
	</div>

        </div>
        <br>
	     <div style="margin:0 auto;position:absolute;right:0px;bottom:0px;width:100%;text-align: center;">
	        <p style="color:black;">Powered By 山东玲珑轮胎股份有限公司</p>
	    </div> 
    </div>

<script type="text/javascript">
var ggRoll={                                     //创建对象直接量
		  roll:document.getElementById("roll"),          //获取id属性为roll的对象
		  speed:20,                                      //飘动速度，即为定时器函数多长时间执行一次
		  statusX:1,                                     //规定每执行一次函数，left属性值变化的幅度
		  statusY:1,                                     //规定每执行一次函数，top属性值变化的幅度
		  x:100,                                         //规定初始状态下left属性的值
		  y:300,                                         //规定初始状态下top属性的值
		  //差值用来测算left属性值的极限
		  winW:document.documentElement.clientWidth-document.getElementById("roll").offsetWidth, 
		  //差值用来测算top属性值的极限
		  winH:document.documentElement.clientHeight-document.getElementById("roll").offsetHeight, 
		  //声明函数
		  Go: function () {                                                               
		       //设置div的left属性值
		       this.roll.style.left = this.x + 'px';                                      
		       //设置div的top属性值
		       this.roll.style.top = this.y + 'px';                                       
		       //如果statusX=1则每次减少1px,否则减少1px
		       this.x = this.x + (this.statusX ? -1 : 1)                                  
		       //如果left属性值小于0，也就是div要超出左边界了，就将statusX设置为0
		       if (this.x < 0) { this.statusX = 0 }                                       
		       //如果top属性值大于winW，也就是div要超出右边界了，就将statusX设置为1
		       if (this.x > this.winW) { this.statusX = 1 }                               
		 
		       this.y = this.y + (this.statusY ? -1 : 1)
		       if (this.y < 0) { this.statusY = 0 }
		       if (this.y > this.winH) { this.statusY = 1 }
		 
		     }

		  };
		 
		var interval=setInterval("ggRoll.Go()",ggRoll.speed);
		ggRoll.roll.οnmοuseοver=function(){clearInterval(interval)};  
	    //onmouseover属性：鼠标移动到元素上时触发
		ggRoll.roll.οnmοuseοut=function(){this.interval=setInterval("ggRoll.Go()",ggRoll.speed)};
		//onmouseout属性:鼠标离开元素时触发

		</script>

</body>
</html>