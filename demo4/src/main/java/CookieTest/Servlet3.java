package CookieTest;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet3", value = "/Servlet3")
public class Servlet3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  创建cookie对象，保存共享数据
        Cookie cookie1 = new Cookie("key1","fuck you");
        Cookie cookie2 = new Cookie("key2","123");
        //  将cookie写入到响应头，交给浏览器
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        System.out.println(cookie1.toString());
        System.out.println(cookie2.toString());
    }
}
