package com.example.demorabbit;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("pro.axenix_innovation.axenapi.controller")
public class OpenApiConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("App API").version("snapshot"));
    }
    @Bean
    GroupedOpenApi rabbitApis() {
        return GroupedOpenApi.builder().group("rabbit")
                .pathsToMatch("/**/rabbit/**").build();
    }

}
