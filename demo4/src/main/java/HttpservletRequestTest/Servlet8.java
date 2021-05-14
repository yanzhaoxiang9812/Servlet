package HttpservletRequestTest;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet8", value = "/Servlet8")
public class Servlet8 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object o =  request.getAttribute("key1");
        System.out.println(o);
    }
}
