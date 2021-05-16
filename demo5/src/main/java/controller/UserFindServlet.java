package controller;



import dao.UserDao;
import entity.Users;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet(name = "FindAllServlet", value = "/FindAll-servlet")
public class UserFindServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserDao ud = new UserDao();
        PrintWriter out = null;
        List<Users> users = ud.findAll();
        response.setContentType("text/html;charset=utf-8");
        out = response.getWriter();
        out.print("<table border='2' align='center'>");
        out.print("<tr>");
        out.print("<td>用户编号：</td>");
        out.print("<td>用户名：</td>");
        out.print("<td>用户密码：</td>");
        out.print("<td>用户性别：</td>");
        out.print("<td>用户邮箱：</td>");
        out.print("<td>删除用户</td>");
        out.print("</tr>");
        for (Users users1 : users){
            out.print("<tr>");
            out.print("<td>"+ users1.getUserId()+"</td>");
            out.print("<td>"+ users1.getUserName()+"</td>");
            out.print("<td>"+ users1.getPassword()+"</td>");
            out.print("<td>"+ users1.getSex()+"</td>");
            out.print("<td>"+ users1.getEmail()+"</td>");
            out.print("<td>" +
                    "<a href='delete-servlet?userId=" +users1.getUserId()+
                    "'>删除</a></td>");
            out.print("</tr>");
        }
        out.print("</table>");
    }
}
