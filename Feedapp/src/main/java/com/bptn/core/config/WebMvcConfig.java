package com.bptn.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                //open to all
                registry.addMapping("/**");

                //for specific configuration
//                registry.addMapping("/api/**")
//        		.allowedOrigins("http://domain2.com")
//        		.allowedMethods("PUT", "DELETE")
//        			.allowedHeaders("header1", "header2", "header3")
//        		.exposedHeaders("header1", "header2")
//        		.allowCredentials(false).maxAge(3600);
            }
        };
    }
}
