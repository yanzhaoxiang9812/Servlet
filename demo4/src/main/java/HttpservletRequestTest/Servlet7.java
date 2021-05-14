package HttpservletRequestTest;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet7", value = "/Servlet7")
public class Servlet7 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //将数据添加到请求作用域对象中
        request.setAttribute("key1","123");
        request.setAttribute("key2",123);
        //请求转发
        request.getRequestDispatcher("/Servlet8").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
