package controller;

import entity.Admin;
import entity.User;
import service.LoginService;
import service.impl.LoginServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private LoginService loginService = new LoginServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String whoisuser = request.getParameter("whoisuser");
            Object object = loginService.Login(username,password,whoisuser);
            if (object != null){
                HttpSession session = request.getSession();
                switch (whoisuser){
                    case "user":
                        User user = (User) object;
                        session .setAttribute("user",user);
                        //user首页

                        break;
                    case  "admin":
                        Admin admin = (Admin) object;
                        session .setAttribute("admin",admin);
                        //admin首页

                        break;
                }
            }else {
                response.sendRedirect("index.jsp");
            }
    }
}

