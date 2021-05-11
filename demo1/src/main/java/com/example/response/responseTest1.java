package com.example.response;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
/*
 Response:响应对象
            HttpservletResponse接口负责将docet/doPost方法执行结果写入到【响应体】交给浏览器开

作用
1）将执行结果以二进制形式写入到【响应体】
2）设置响应头中[content-type]属性值，从而控制浏览器使用对应编译器将响应体二进制数据编译为【文字，图片，视频，命令】
3）设置响应头中【location】属性，将一个请求地址赋值给location.从而控制浏览器向指定服务器发送请求


 */
public class responseTest1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.write("fuck");
        System.out.println("demo2 run.......");
    }
}
