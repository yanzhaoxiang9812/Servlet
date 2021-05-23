package listener;

import util.DBUilt;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class OneListener implements ServletContextListener {
    @Override
    // Http服务器启动时运行该方法
    public void contextInitialized(ServletContextEvent sce) {
        //  在Http服务器启动时创建50个Connection
        DBUilt dbUilt = new DBUilt();
        Map conMap = new HashMap();
        for (int i = 0 ; i < 50 ; i++){
            Connection con = dbUilt.getConnection();
            System.out.println("在Http服务器启动时创建了"+con);
            conMap.put(con,true);//因为Map中key不能重复，所以用过con作为key，true作为判断con是否被别用户所用大的标记。

        }
        //将con的map集合保存到全局作用域对象中，可保证服务器启动到结束，这个con的map集合都可以使用。
        ServletContext application =  sce.getServletContext();
        application.setAttribute("cons",conMap);
    }
    @Override
    // Http服务器关闭时运行该方法
    public void contextDestroyed(ServletContextEvent sce) {
            //将全局作用域对象的cons销毁
        ServletContext application = sce.getServletContext();
        Map delConsMap = (Map) application.getAttribute("cons");
        //通过迭代器取出
        Iterator iterator = delConsMap.keySet().iterator();
        while (iterator.hasNext()){
            Connection con = (Connection) iterator.next();
            if(con != null){
                System.out.println(con+"已被销毁");
            }
        }
    }
}
