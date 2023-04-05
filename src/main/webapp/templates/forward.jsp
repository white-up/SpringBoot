<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP动作元素forward</title>
</head>
<body>
forward之前的内容<br/>
<jsp:forward page="tmp2.jsp">
	<jsp:param value="123456" name="p1"/>
	<jsp:param value="333456" name="p2"/>
</jsp:forward>
forward之后的内容<br/>
</body>
</html>