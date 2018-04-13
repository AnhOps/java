package com.opsbin.springconfigsecurity.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * Load database and spring security configuration
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { AppConfig.class, SecurityConfig.class };
    }

    /**
     * Load spring web configuration
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { MvcConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

}
