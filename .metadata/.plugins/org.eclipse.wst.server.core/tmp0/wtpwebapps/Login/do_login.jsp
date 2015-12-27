<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>已登录</title>
</head>
<body>
<%request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="user" class="com.yejia.entity.UserEntity"></jsp:useBean>
<jsp:setProperty property="userName" name="user"/>
<jsp:setProperty property="password" name="user"/>
用户名：
<jsp:getProperty property="userName" name="user"/>
<br/>
密码：
<jsp:getProperty property="password" name="user"/>
</body>
</html>