package com.example.request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestTest3", value = "/requestTest3")
public class requestTest3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration enumeration = request.getParameterNames();
        while (enumeration.hasMoreElements()) {
            String np = (String) enumeration.nextElement();
            String value = request.getParameter(np);
            System.out.println("请求传参数名：" + np+"         请求参数值："+value);
        }
        System.out.println("=====================================================");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //  指定request对象使用utf-8解码数据。
        Enumeration enumeration = request.getParameterNames();
        while (enumeration.hasMoreElements()) {
            String np = (String) enumeration.nextElement();
            String value = request.getParameter(np);
            System.out.println("请求传参数名：" + np+"         请求参数值："+value);
        }
    }
}
