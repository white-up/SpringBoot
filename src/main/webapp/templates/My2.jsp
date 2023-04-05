<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
    <%   out.println("调用成功");
    	String p = request.getParameter("p");
    	out.println("<br/>");
    	out.println("参数是：" + p);
    %>
  </body>
</html>