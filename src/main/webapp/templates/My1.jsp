<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
  My1.jsp的include之前内容<br/>
    <jsp:include page="My2.jsp" flush="true">
    	<jsp:param value="123456" name="p"/>
    </jsp:include>
    <br/>
  My1.jsp的include之后内容<br/>
  </body>
</html>