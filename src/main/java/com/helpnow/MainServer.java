package com.helpnow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAutoConfiguration
@EnableSwagger2
@EnableJpaRepositories(basePackages = "com.helpnow.repository")
@EntityScan("com.helpnow.entity")
@ComponentScan(basePackages = "com.helpnow")
public class MainServer extends SpringBootServletInitializer {

    public static void main(String[] args) {
        try {
            System.setProperty("server.servlet.context-path", "/server");
            SpringApplication.run(MainServer.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MainServer.class);
    }

}
