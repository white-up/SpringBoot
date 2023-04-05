<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>scriptlet</title>
</head>
<body>
<%!
	int x1=100,a[]=new int[6];
	static double x2;
	String str=null;
%>
<%!
   int add(int n) { 	//定义add()方法计算1+2+...+n
	    int sum=0;
	    for(int i=1;i<=n;i++)
	          sum=sum+i;
	    return sum;
   }
%>
<%
	int n = 100, sum = 0;
	String str = "结果 = ";
%>
<%
	for(int i = 0; i <= n; i++)
		sum = sum + i;
%>
<br />
<%=str + sum  %>
</body>
</html>