package filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "UTF-8_Filter")
public class UTF8_Filter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }
    public void destroy() {
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
            request.setCharacterEncoding("utf-8");
            //2.解决post请求中的中文信息乱码问题
            //2.1 设置获取流的编码格式
            response.setCharacterEncoding("utf-8");
            //2.2 告知浏览器我们输出的文件类型以及编码格式
            response.setContentType("text/html;utf-8");
            chain.doFilter(request,response);
        }
}

