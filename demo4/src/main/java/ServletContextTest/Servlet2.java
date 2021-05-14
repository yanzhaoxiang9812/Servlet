package ServletContextTest;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletContextTest.Servlet2", value = "/ServletContextTest.Servlet2")
public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  通过请求对象 索要全局作用域对象
        ServletContext application = request.getServletContext();
        //  获取全局作用域对象指定数据
        String s = (String) application.getAttribute("key1");
        System.out.println(s);
    }
}
