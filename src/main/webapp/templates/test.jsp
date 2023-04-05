<%@ page
        language="java"
        contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Rate</title>
</head>
<body>
<form method="post" >
    请输入美元：<input type="text" value="" name="dollar" />
    <input type="submit" value="提交" />
</form>

<%
    String s = request.getParameter("dollar");
    if(s!=null && s.length()>0){
        double n = Double.parseDouble(s);
        double result  = n * 7.8;
        out.print(s + "美远 = " + result + "人民币");
    }

%>
</body>
</html>