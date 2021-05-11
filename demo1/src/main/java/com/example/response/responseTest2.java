package com.example.response;

import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class responseTest2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        response.setContentType("text/html; charset=UTF-8");
        //  setContentType设置游览器使用对应的编辑器
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> 操 </h1>");
        out.println("</body></html>");
        System.out.println("doGet");
    }
}
