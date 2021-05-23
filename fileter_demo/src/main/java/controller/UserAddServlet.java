package controller;

import dao.UserDao;
import entity.Users;

import java.io.*;
import java.util.Date;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/add-servlet")
public class UserAddServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userName,password,sex,email;
        userName = request.getParameter("userName");
        password  = request.getParameter("password");
        sex = request.getParameter("sex");
        email = request.getParameter("email");
        UserDao ud = new UserDao();
        Users users = new Users(null,userName,password,sex,email);
        int result = 0;
        /*
                    测试添加一个用户到数据库所需要的时间
         */
        Date starTime = new Date();
        result = ud.add(users,request);
        Date endTime = new Date();
        System.out.println("所用时间为："+(endTime.getTime() - starTime.getTime())+"毫秒");
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