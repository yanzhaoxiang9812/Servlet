package controller;

import dao.UserDao;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LogInServlet", value = "/login-servlet")
public class LogInServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName,password;
        UserDao userDao = new UserDao();
        int result = 0;
        request.setCharacterEncoding("utf-8");
        userName = request.getParameter("userName");
        password = request.getParameter("password");
        result = userDao.login(userName,password,request);
        if (result == 1){


            //              登录成功 给令牌
            request.getSession();


            response.sendRedirect("user.html");
        }else {
            response.sendRedirect("login_error.html");
        }
    }
}
