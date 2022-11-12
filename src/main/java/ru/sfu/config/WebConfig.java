package ru.sfu.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/** Spring MVC infrastructure configuration */
@EnableWebMvc
@Configuration
@ComponentScan({"ru.sfu.controller"})
public class WebConfig implements WebMvcConfigurer {
    /** Connecting static resources */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        registry.addResourceHandler("/favicon.ico").addResourceLocations("/resources/favicon.ico");
        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
    }
    /** Searching of views */
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer
            .favorPathExtension(true)
            .ignoreAcceptHeader(false)
            .useJaf(false)
            .defaultContentType(MediaType.TEXT_HTML)
            .mediaTypes(new HashMap<String, MediaType>(){
                {put("json", MediaType.APPLICATION_JSON);
                    put("html", MediaType.TEXT_HTML);}});
    }

//    @Bean
//    @Autowired
//    public ContentNegotiatingViewResolver viewResolver(
//        ContentNegotiationManager cnManager,
//        SpringTemplateEngine templateEngine
//    ) {
//        ContentNegotiatingViewResolver cnResolver = new
//            ContentNegotiatingViewResolver();
//        cnResolver.setContentNegotiationManager(cnManager);
//        ThymeleafViewResolver htmlResolver = new ThymeleafViewResolver();
//        htmlResolver.setTemplateEngine(templateEngine);
//        List<ViewResolver> resolvers = new ArrayList<>();
//        resolvers.add(new ThymeleafViewResolver()
//        {{setTemplateEngine(templateEngine);}});
//        cnResolver.setViewResolvers(resolvers);
//        return cnResolver;
//    }
    private class StudentJsonResolver implements ViewResolver {
        public View resolveViewName(String viewName, Locale locale) throws
            Exception {
            MappingJackson2JsonView view = new MappingJackson2JsonView();
            view.setObjectMapper(new ObjectMapper());
            return view;
        }
    }

}
