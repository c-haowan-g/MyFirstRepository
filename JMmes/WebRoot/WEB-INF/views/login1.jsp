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
            background-image: url(resources/images/111.jpg);
            background-size: 100% 100%;
        }

        .flexCenter {
            text-align: center;
            margin: auto;
        }

        .cms_login_container {
            width: 70%;
            height: 70%;
            display: flex;
            justify-content: center;
        }
        
        

        
        .login_form_block11 {
            width: 40%;
            height: 100%;
            background-color: white;
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
            margin-top: 40px;
        }

        .btn {
            width: 80%;
            height: 60px;
            letter-spacing: 10px;
            font-size: 24px;
            background-color: green;
            border: none;
            outline: none;
            border-radius: 10px;
            color: white;
        }

        .btn:hover {
            background-color: #044468;
            border: none;
            outline: none;
        }
    </style>
</head>

<body>
    <div class="cms_login">
    	
        <div class="cms_login_container flexCenter" style="min-height:390px;">
            <div class="cms_login_image" style="min-width: 560px;">
                <!-- <img src="./leftimg_04.png" alt=""> -->
            </div>
            

            
            <div class="login_form_block11">
		<div class="logo"></div>
		<div>
			<form action="login" method="post">
				<div class="divBox">
					<img class="cms_login_img" src="resources/images/username_mark.png">
					<input placeholder="<spring:message code="login.username" />" type="text" name="code" id="code" prompt="用户名/CODE" autocomplete="off" class=" cms_login_ipt" style="width:100%" >
				</div>
				<div class="divBox">
					<img class="cms_login_img" src="resources/images/password_mark.png">
					<input placeholder="<spring:message code="login.password" />" style="width:100%;" type="password" name="password" id="password" prompt="密码/Password" class=" cms_login_ipt">
				</div>
				
				<div class="divBox">
					<img class="cms_login_img" src="resources/images/verify_mark.png">
					<select class=" cms_login_ipt" style="width:100%;" name="language" id="language"  data-options="label:''">
						<option value="zh">中文</option>
						<option value="en">English</option>
						<option value="th">ไทย</option>
					</select>
					
				</div>
				
				<input type="submit" class="btn divBox margin_top60" value="<spring:message code="button.login" />">
				<div style="text-align: center;color:red;">${error }</div>
				
			</form>
		</div>
		
		<br>
	     <div style="margin:0 auto;width:100%;text-align: center;">
	        <p style="color:blue">Powered By 山东玲珑轮胎股份有限公司</p>
	    </div> 
	</div>

        </div>
    </div>



</body>
</html>