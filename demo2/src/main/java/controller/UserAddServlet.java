package controller;

import dao.UserDao;
import entity.User;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserAddServlet", value = "/UserAddServlet")
public class UserAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName,password,sex,email;
        userName = request.getParameter("userName");
        password  = request.getParameter("password");
        sex = request.getParameter("sex");
        email = request.getParameter("eamil");
        int result = 0;
        UserDao ud = new UserDao();
        User user = new User(null,userName,password,sex,email);
        result = ud.add(user);
        PrintWriter pw = null;
        response.setContentType("text/html");
        pw = response.getWriter();
        if (result == 1){
            pw.print("<font style='color: red;font-size: 12px'>注册成功</font>");
        }else {
            pw.print("<font style='color: red;font-size: 12px'>注册失败</font>");
        }
    }
}
