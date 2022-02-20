package servlet;

import Config.HibernateConfiguration;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(value = "/", loadOnStartup = 1)
public class Startup_Servlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) {
        HibernateConfiguration.prepareHibernate();


    }
}


