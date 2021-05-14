package HttpSessionTest;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet6", value = "/Servlet6")
public class Servlet6 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession s =  request.getSession();
        System.out.println(s.getAttribute("key1"));
        System.out.println(s.getAttribute("key2"));
        System.out.println(s.getAttribute("key3"));

    }
}
