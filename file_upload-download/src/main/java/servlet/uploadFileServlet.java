package servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

@WebServlet(name = "uploadServlet", value = "/uploadServlet")
public class uploadFileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("uploadFileServlet");
        try {
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
            List<FileItem> list = servletFileUpload.parseRequest(request);
            for (FileItem fileItem : list){
                if (fileItem.isFormField()){
                    //普通表单提交内容
                    System.out.println(fileItem.getFieldName()+":"+fileItem.getString("UTF-8"));
                }else {
                    //文件
                    String fileName = fileItem.getName();
                    long size = fileItem.getSize();
                    System.out.println(fileName +":"
                            + size+"byte" );
                    //保存
                    InputStream inputStream = fileItem.getInputStream();
                    String path = request.getServletContext().getRealPath(fileName);
                    System.out.println(path);
                    OutputStream outputStream = new FileOutputStream(path);
                    int temp = 0;
                    while ( (temp = inputStream.read()) != -1){
                        outputStream.write(temp);
                    }
                    outputStream.close();
                    inputStream.close();
                    System.out.println("上传成功");
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }
}

