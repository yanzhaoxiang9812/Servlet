package com.example.request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
/*
request请求对象
            HttpServletRequest接口负责在doget/doPost方法运行时读取http请求协议包中信息

作用:
1)可以读取Http请求协议包中【请求行】信息
2)可以读取保存在ftp请求协议包中【请求头】或则【请求体】中请求参数信息
3)可以代替浏览器向Http服务器申请资源文件调用

 */
@WebServlet(name = "requestTest1", value = "/requestTest1")
public class requestTest1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  通过请求对象读取请求行中url信息
        String s1 = req.getRequestURL().toString();
        //  通过通过请求对象读取请求行中method信息
        String s2 = req.getMethod();
        //  通过通过请求对象读取请求行中rui信息(精准定位)
        String s3 = req.getRequestURI();
        System.out.println("url="+s1);
        System.out.println("method="+s2);
        System.out.println("uri="+s3);
    }
}
