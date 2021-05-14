package HttpSessionTest;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet5", value = "/Servlet5")
public class Servlet5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  通过请求对象，获取当前用户的HttpSession
        HttpSession session = request.getSession();
        //  通过HttpSession对象添加元素
        session.setAttribute("key1",123);
        session.setAttribute("key2","fuck");
        session.setAttribute("key3",true);
    }
}
