package ServletContextTest;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet1", value = "/Servlet1")
public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  通过请求对象 索要全局作用域对象
        ServletContext application = request.getServletContext();
        //  将数据写入到全局作用域对象
        application.setAttribute("key1","fuck");
        //  使用请求转发 完成servlet多个调用
        RequestDispatcher report = request.getRequestDispatcher("/ServletContextTest.Servlet2");
        report.forward(request,response);
    }
}
