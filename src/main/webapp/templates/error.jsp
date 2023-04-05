<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"
        isErrorPage="true"%>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Error page</title>
</head>
<body>
<%
//exception = (Throwable) session.getAttribute("error");
//out.print(exception);
if(exception!=null) {
    StackTraceElement[] a = exception.getStackTrace();
    out.print("出错原因：" + exception + "<br>");
    out.print("出错的文件：" + a[0].getFileName() + "<br>");
    out.print("出错的方法名：" + a[0].getMethodName() + "<br>");
    out.print("出错的行号：" + a[0].getLineNumber() + "<br>");
}

%>
</body>
</html>