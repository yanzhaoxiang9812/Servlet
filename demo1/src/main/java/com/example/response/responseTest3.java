package com.example.response;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

public class responseTest3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("http://www.baidu.com");
        //  .sendRedirect将一个请求地址赋值给location控制游览器向指定服务器发送请求。
    }
}
