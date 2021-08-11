package com.revature.util;

import com.revature.services.CalculationService;
import com.revature.servlets.CalculatorServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class CustomServletContextListener implements ServletContextListener {

    /**
     * This method is executes when the web application is starting up, specifically after the servlet context
     * has been initialized. Using this method we can programmatically initialize and register our servlet
     * classes with the context (particularly useful if your servlets have dependencies injected through
     * their constructor).
     *
     * @param sce The servlet context associated with this web application.
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        // Perform any required dependency injection
        CalculationService calculationService = new CalculationService();
        CalculatorServlet calculatorServlet = new CalculatorServlet(calculationService);

        // Register the servlet(s) with the context and associate a mapping
        ServletContext context = sce.getServletContext();
        context.addServlet("CalculatorServlet", calculatorServlet).addMapping("/calculator");

    }

    /**
     *  This method is executes when the web application is shutting down. Using this method we can properly
     *  close any resources that may still be open.
     *
     * @param sce The servlet context associated with this web application.
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        // Close any open resources (e.g. database connections, file connections, etc.)

    }

}
