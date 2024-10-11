package com.nagarro.dispatcherConfig;

import com.nagarro.databaseContext.AppContext;
import com.nagarro.databaseContext.MVCConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class RequestHandlerInitializer
        extends AbstractAnnotationConfigDispatcherServletInitializer{

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{
            AppContext.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { RequestHandler.class, MVCConfiguration.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

}
