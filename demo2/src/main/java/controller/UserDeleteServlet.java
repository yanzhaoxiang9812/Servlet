package controller;

import dao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserDeleteServlet", value = "/delete-servlet")
public class UserDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId;
        int result = 0;
        UserDao ud = new UserDao();
        userId = request.getParameter("userId");
        result = ud.delete(userId);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = null;
        pw = response.getWriter();
        if (result == 1){
            pw.print("<html><body><script>\n" +
                    "    window.alert(\"删除成功\");\n" +
                    "window.history.back();"+
                    "</script></body></html>");
        }else {
            pw.print("<html><body><script>\n" +
                    "    window.alert(\"删除失败\");\n" +
                    "window.history.back();"+
                    "</script></body></html>");
        }
    }
}
