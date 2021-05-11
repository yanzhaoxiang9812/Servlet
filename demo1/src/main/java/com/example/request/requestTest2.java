package com.example.request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestTest2", value = "/requestTest2")
public class requestTest2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //   .getParameterNames()   通过请求对象获得请求头中所有的请求参数。
        Enumeration enumeration = request.getParameterNames();
        while (enumeration.hasMoreElements()) {
            String np = (String) enumeration.nextElement();
            //     .getParameter()   通过请求对象获得请求头中所有的请求参数的值。（String）
            String value = request.getParameter(np);
            System.out.println("请求传参数名：" + np+"         请求参数值："+value);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
