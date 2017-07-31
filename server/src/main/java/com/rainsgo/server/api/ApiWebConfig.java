package com.rainsgo.server.api;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Rain on 17-8-1.
 */
@Configuration
public class ApiWebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
        ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet);
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
        return registration;
    }
}
