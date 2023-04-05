<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>forward跳转到的页面</title>
</head>
<body>
forward跳转到的页面<br/>
<%
	String p1 = request.getParameter("p1");
	String p2 = request.getParameter("p2");
	out.println("获取的参数p1是：" + p1);
	out.println("<br/>获取的参数p2是：" + p2);
%>
</body>
</html>