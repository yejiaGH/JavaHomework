<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- JSP声明 -->
	<%!
	String str = "he";
	%>
	<%
		
	out.println(str);
	%>
	<!-- JSP表达式输出 -->
	<%= "shi"%>
	<!-- today is <%=new java.util.Date().toString() %> -->
	<!-- JSP注释，客户端看不到 -->
	<%--
		this is JSP comments, today is <%=new java.util.Date().toString() %>
	 --%>
</body>
</html>