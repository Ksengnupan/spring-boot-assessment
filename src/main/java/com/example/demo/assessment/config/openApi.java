package com.example.demo.assessment.config;


// import io.swagger.v3.oas.models.ExternalDocumentation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class openApi {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Railway Management System API")
                        .description("REST API for managing trains, stations, and tickets")
                        .version("v1.0")
                        .contact(new Contact()
                                .name("Seng Nu Pan Kumgyi")
                                .email("sengnupan.kumgyi@gmail.com"))
                                
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")))
                        .externalDocs(new ExternalDocumentation()
                        .description("Project Documentation")
                        .url("https://github.com/Ksengnupan/spring-boot-assessment.git"));
    }
}
