<%@ page language="java" import="java.util.*,com.bluebirdme.core.system.web.LanguageProvider" pageEncoding="UTF-8"%>
<%@ taglib prefix="auth" uri="http://www.bluebirdme.com/javaee/tags/auth"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">


<link href="resources/min/min.css" rel="stylesheet" type="text/css">
<link href="resources/styles/icon.css?_=${rnd}" rel="stylesheet" type="text/css">

<script type="text/javascript" src="resources/min/min.js"></script>
<script type="text/javascript" src="resources/libs/easyui/jquery.easyui.extentions.js"></script>
<script type="text/javascript" src="time.js"></script>
<script type="text/javascript" src="resources/libs/easyui/locale/easyui-lang-<%=LanguageProvider.getLanguage() %>.js?_=${rnd }"></script>

<script type="text/javascript">
    //JS中的项目根路径
    const path="<%=basePath%>";
    //文件服务器地址，一般文件服务器地址和项目地址不同
    const file_server="${applicationScope.SYS_CONFIG_KEY.FILE_SERVER}";
    
    //不区分：0 全钢：1  半钢：2
    const factory="${factory}";
    //const factory="1";

    const tipSelectOnlyOne = "<spring:message code="tip.onlyOneSelected" />";
    const tipSelectAtLeastOne = "<spring:message code="tip.atLeastOneSelected" />";
    const shutdown="<spring:message code="tip.shutdown" />";
    const expired="<spring:message code="tip.expired" />";
    const successTip="<spring:message code="tip.success" />";
    const errorTip="<spring:message code="tip.error" />";
    //当前用户使用的语言
    const language="<%=LanguageProvider.getLanguage()%>"||"zh";
    
    //获取语言
    const getLanguage=function(){
        return language=="zh"?"":language;
    }
    
    //获取语言后缀，如：zh返回"",en返回"_en"，th返回"_th"
    const getLanguageSuffix=function(){
        return language=="zh"?"":("_"+language);
    }
    
    function log(){
    	for(var i=0;i<arguments.length;i++){
    		console.log(arguments[i]);
    	}
    }
    const OK="0",EXPIRED="-1",ERROR="1";
</script>
</head>
<%@ include file="loading.jsp" %>