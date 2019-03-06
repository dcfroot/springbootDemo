package com.dc.mspringboot.listener;


import com.dc.mspringboot.constants.ConstantsBase;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.File;

/**
 * @author Enzo
 * @ClassName WebappListener
 * @Description 监听器，获得webapp根目录
 * @date 2017年5月2日
 */
@WebListener
public class WebappListener implements ServletContextListener {

    /**
     * Default constructor.
     */
    public WebappListener() {
        // TODO Auto-generated constructor stub
    }

    /**
     * 获得web根目录，项目名称，java编译目录
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     * 当应用程序完成初始化并准备提供服务时，容器调用这个方法
     */
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("------进入监听器------");
        String webAppRootKey = sce.getServletContext().getRealPath(File.separator);
        System.setProperty(ConstantsBase.WEBAPP_ROOT, webAppRootKey + File.separator);
        File file = new File(webAppRootKey);
        System.setProperty(ConstantsBase.PROJECT_NAME, file.getName());
        System.setProperty(ConstantsBase.WEBAPP_CLASSES, webAppRootKey + File.separator + "WEB-INF" + File.separator + "classes" + File.separator);
    }

    /**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("------销毁监听器------");
    }

}
