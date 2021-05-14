<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

</h1>
<br>
<br>
<center>
    <h1><%= "四种数据共享方案" %>
    <h3 style="color: red">ServletContext接口</h3><br><a href="Servlet1">ServletContext</a><br>
    <h3 style="color: red">Cookie类</h3><br><a href="Servlet3">Cookie1</a><br><a href="Servlet4">Cookie2</a><br>
    <h3 style="color: red">HttpSession接口</h3><br><a href="Servlet5">HttpSessionTest1</a><br><a href="Servlet6">HttpSessionTest2</a><br>
    <h3 style="color: red">HttpServletRequest接口</h3><br><a href="Servlet7">HttpServletRequestTest1</a><br>
</center>
</body>
</html>