package listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class TwoListener implements ServletContextAttributeListener {
    @Override
    //全局作用域的对象添加共享数据时运行该方法
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("添加成功");
    }

    @Override
    //全局作用域对象删除共享数据时运行该方法
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("删除成功");
    }

    @Override
    //全局作用域对象更更新共享数据时运行该方法
    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("更新成功");
    }
}
