package ru.sfu;

import javax.servlet.ServletRegistration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import ru.sfu.config.AppConfig;
import ru.sfu.config.WebConfig;

/** Entry point of MVC Spring */
public class DispatcherConfig
        extends AbstractAnnotationConfigDispatcherServletInitializer {
    /** Getting non-web infrastructure configuration */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { AppConfig.class };
    }

    /** Getting Spring MVC infrastructure configuration */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ WebConfig.class };
    }

    /** Getting the servlet mapping(s) for the DispatcherServlet */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /** Additional registration customization. Error handling */
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        boolean done = registration.setInitParameter(
            "throwExceptionIfNoHandlerFound", "true");
        if(!done) throw new RuntimeException();
    }
}
