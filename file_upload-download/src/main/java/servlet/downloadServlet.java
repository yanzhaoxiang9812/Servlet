package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

@WebServlet(name = "downloadServlet", value = "/downloadServlet")
public class downloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应格式
        response.setContentType("application/x-msdownload");
        //获取下载文件的路径
        String filePath = request.getServletContext().getRealPath("file/1.jpg");
        //设置下载后的文件名
        String fileName = "demo.jpg";
        fileName = URLEncoder.encode(fileName,"UTF-8");//中文名文件需要进行URL编码
        response.setHeader("Content-Disposition","attachment;filename=" + fileName);
        OutputStream outputStream = response.getOutputStream();
        InputStream inputStream = new FileInputStream(filePath);
        int temp = 0 ;
        while ((temp = inputStream.read()) != -1){
            outputStream.write(temp);
        }
        inputStream.close();
        outputStream.close();
        System.out.println("下载成功");
    }

}
