package com.example.initializer;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;

public class ApplicationInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) {
        final AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.scan("com.example");
        context.refresh();

        final DispatcherServlet servlet = new DispatcherServlet(context);
        final javax.servlet.ServletRegistration.Dynamic registration = servletContext.addServlet("app", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}
