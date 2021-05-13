package controller;

import dao.UserDao;
import entity.Users;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/add-servlet")
public class UserAddServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String userName,password,sex,email;
        userName = request.getParameter("userName");
        password  = request.getParameter("password");
        sex = request.getParameter("sex");
        email = request.getParameter("email");
        //  调用UserDao类将用户信息填充到INSERT命令中借助JDBC执行SQL命令
        UserDao ud = new UserDao();
        Users users = new Users(null,userName,password,sex,email);
        int result = 0;
        result = ud.add(users);
        //  调用想用对象将处理结果写入到响应题中。
        PrintWriter pw = null;
        response.setContentType("text/html;charset=utf-8");
        pw = response.getWriter();
        if (result == 1){
            pw.print("<html><body><script>\n" +
                    "    window.alert(\"注册成功\");\n" +
                    "window.history.back();"+
                    "</script></body></html>");
        }else {
            pw.print("<html><body><script type=\"text/javascript\">\n" +
                    "    window.alert(\"注册失败\");\n" +
                    "window.history.back();"+
                    "</script></body></html>");
        }
    }
}