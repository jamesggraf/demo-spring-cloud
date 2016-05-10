package com.demo.template;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.data.rest.webmvc.support.DefaultedPageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import java.util.List;

@EnableAutoConfiguration
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = { "com.demo.template" })
public class Application extends RepositoryRestMvcConfiguration {

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected void configureRepositoryRestConfiguration(final RepositoryRestConfiguration config) {
        // Register domain models
        // config.exposeIdsFor(Something.class);
    }

    @Override
    public void addArgumentResolvers(final List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new DefaultedPageableHandlerMethodArgumentResolver(pageableResolver()));
    }

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        // Register request interceptors here
    }

    @Override
    protected void configureJacksonObjectMapper(final ObjectMapper objectMapper) {
        // Serialize enums with friendlier value
        objectMapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
        // Deserialize enums with friendlier value
        objectMapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
        // accept empty strings as null
        objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        // turn off pretty-printing
        objectMapper.disable(SerializationFeature.INDENT_OUTPUT);
    }
}

