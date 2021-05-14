package CookieTest;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet4", value = "/Servlet4")
public class Servlet4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  调用请求对象获取游览器返回的Cookie
        Cookie cookielist[] = request.getCookies();
        //  遍历cookie集合
        for (Cookie cookie : cookielist){
            String key = cookie.getName();
            String value = cookie.getValue();
            System.out.println(key+"="+value);
        }
    }
}
