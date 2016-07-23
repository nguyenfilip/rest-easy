package net.nguyen.interceptors;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.jboss.resteasy.spi.ResteasyProviderFactory;

@WebListener
public class HibernateWebListener implements ServletContextListener{

	  public void contextInitialized(ServletContextEvent event) {
	    //do on application init
		  event.getServletContext().setAttribute("test", "VAL");
		  
	  }

	  public void contextDestroyed(ServletContextEvent event) {
	    //do on application destroy
	  }
}
