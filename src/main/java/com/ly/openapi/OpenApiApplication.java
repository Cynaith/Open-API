package com.ly.openapi;

import com.ly.openapi.cache.BloomFilters;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class OpenApiApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(OpenApiApplication.class, args);
        new BloomFilters().init();
    }

    @Override//为了打包springboot项目 
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }
}
