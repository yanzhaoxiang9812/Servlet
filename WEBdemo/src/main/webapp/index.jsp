<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>WEB demo</title>
</head>
<body>
<br/>
<center>
  <h1 style="color: darkmagenta"><%= "WEB demo" %></h1>
  <form action="LoginServlet" method="post">
    <table border="2">
      <tr>
        <td align="center">
          用户名：<input  type="text" name="username"><br>
        </td>
      </tr>
      <tr>
        <td align="center">
          密码：<input  type="password" name="password"><br>
        </td>
      </tr>
      <tr>
        <td align="center">
          <input  type="radio" name="whoisuser" value="admin">管理员
          <input  type="radio" name="whoisuser" value="user" checked>用户
        </td>
      </tr>
      <tr>
        <td align="center">
         <input  type="submit" value="登录"><br>
        </td>
      </tr>
    </table>
  </form>
</center>
</body>
</html>