package 请求转发;

import javax.imageio.spi.RegisterableService;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "OneServlet2", value = "/OneServlet2")
public class OneServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("OneServlet2 run....");
        RequestDispatcher report = request.getRequestDispatcher("/TwoServlet2");
        report.forward(request,response);
    }
}
