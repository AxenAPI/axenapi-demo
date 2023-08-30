package com.example.demo;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components().addSecuritySchemes("Public-Bearer-Jwt",
                        new SecurityScheme().type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                                .in(SecurityScheme.In.HEADER))
                        .addSecuritySchemes("Internal-Token",
                                new SecurityScheme().type(SecurityScheme.Type.APIKEY)
                                        .bearerFormat("JWT")
                                        .in(SecurityScheme.In.HEADER)
                                        .name("SERVICE_ACCESS_TOKEN"))
                )
                .info(new Info().title("App API").version("snapshot"));
    }
    @Bean
    GroupedOpenApi kafkaApis() {
        return GroupedOpenApi.builder().group("kafka")
                .pathsToMatch("/**/kafka/**").build();
    }

    @Bean
    GroupedOpenApi restApis() {
        return GroupedOpenApi.builder().group("rest")
                .pathsToMatch("/**/users/**").build();
    }
}
