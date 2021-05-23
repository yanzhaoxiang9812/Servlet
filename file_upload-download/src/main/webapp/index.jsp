<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<br/>
<center>
    <h2>文件上传</h2>
    <form action="uploadServlet" enctype="multipart/form-data" method="post">
        选择文件：<input type="file" name="file">
        <input type="submit" value="确认">
    </form>
    <hr>
    <h2>文件下载</h2>
    <img src="file/1.jpg" width="64" height="64" ><br>
    <a href="downloadServlet" >下载</a>
</center>
</body>
</html>