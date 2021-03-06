<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../inc/meta.jsp"%>
<link href="resources/styles/login.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
        if(self!=top){
            top.location.href="<%=basePath%>";
	}
</script>
<body style="min-height: 650px;">



	<div class="login_form_block">
		<div class="logo"></div>
		<div>
			<form name="loginForm" action="" method="post">
				<div class="inputRow">
					<input placeholder="<spring:message code="login.username" />" type="text" name="code" id="code" prompt="用户名/CODE" class="easyui-textbox" style="width:100%" data-options="label:'<spring:message code="login.username" />'">
				</div>
				<div class="inputRow">
					<input placeholder="<spring:message code="login.password" />" style="width:100%;" type="text" name="password" id="password" prompt="密码/Password" class="easyui-passwordbox"data-options="label:'<spring:message code="login.password" />'">
				</div>
				<div class="inputRow">
					 <select class="easyui-combobox" style="width:100%;" name="factory" id="factory"  data-options="label:'<spring:message code="factory" />'">
						<option value="2"><spring:message code="bangang" /></option>
						<option value="1"><spring:message code="quangang" /></option>
					</select>
				</div>
				<div class="inputRow">
					<select class="easyui-combobox" style="width:100%;" name="language" id="language"  data-options="label:'<spring:message code="login.language" />'">
						<option value="zh">中文</option>
						<option value="en">English</option>
						<option value="th">ไทย</option>
					</select>
					<script type="text/javascript">
					
						$(document).ready(function(){
							 var ip_addr = document.location.hostname;
							 console.log(ip_addr)
							$("#language").combobox("setValue",language);
						});
						 function submit1(){
							var factory =$("#factory").combobox("getValue");
							 if(factory=="2"){
							document.loginForm.action = "http://192.168.86.9/JMmes/login";
							document.loginForm.submit();
							}else if(factory=="1"){
							document.loginForm.action = "http://192.168.86.4/JMmes/login";
							document.loginForm.submit();
							} 
						}
					</script>
				</div>
				<input  type="button" onclick="submit1()" class="btn" value="<spring:message code="button.login" />">
				<div style="text-align: center;color:red;">${error}</div>
				<div style="text-align: center;color:blue;">
					<a href="login?language=zh">中文</a> <a href="login?language=en">English</a> <a href="login?language=th">ไทย</a>
				</div>
			</form>
		</div>
		
		<br><br>
	    <div style="margin:0 auto;width:100%;text-align: center;">
	        Powered By 山东玲珑轮胎股份有限公司
	    </div> 
	</div>
</body>
</html>
