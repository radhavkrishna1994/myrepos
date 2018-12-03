package com.jpmc.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.jpmc.dao.classes.DbConnection;
public class DbListener implements ServletContextListener {
    
    public void contextDestroyed(ServletContextEvent event)  { 
    	System.out.println("Context destroyed..");
    	   }
	    public void contextInitialized(ServletContextEvent event)  { 
       System.out.println("Context Initialized..");
       String driverClass = event.getServletContext().getInitParameter("DriverClass");
       String dbUrl = event.getServletContext().getInitParameter("DbUrl");
       String username = event.getServletContext().getInitParameter("username");
       String password = event.getServletContext().getInitParameter("password");
       DbConnection.setConnection(driverClass, dbUrl, username, password);
    }
	
}
