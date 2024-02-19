package com.apress.demo.springblog;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addRedirectViewController("/", "/posts");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //Add additional interceptors here
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/").addResourceLocations
            ("/resources/assets/");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        // Do Nothing
    }
    @Override
    public void addFormatters(FormatterRegistry registry) {
        //Add additional formatters here
    }
}
