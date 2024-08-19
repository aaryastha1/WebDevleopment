package com.example.plant_ghar.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static java.lang.invoke.VarHandle.AccessMode.GET;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
         .allowedOrigins("http://localhost:5173") // Allow specific origins
         .allowedMethods("GET","POST","PUT","DELETE","OPTIONS") // Allow specific methods
         .allowedHeaders("*") // Allow specific headers
         .allowCredentials(true); // Allow credentials
         }}