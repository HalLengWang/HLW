package com.todorank.hlw.global.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Value("${custom.fileDirPath}")
    private String fileDirPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/file/**")
                .addResourceLocations("file:///" + fileDirPath + "/");
        /*registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:///C:/file_upload/");*/
    }


}
