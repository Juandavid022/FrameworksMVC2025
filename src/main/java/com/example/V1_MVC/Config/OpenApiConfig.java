package com.example.V1_MVC.Config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Speed Rollers")
                        .version("1.0.0")
                        .description("Documentación de la API para gestión de la empresa Speed Rollers")
                        .contact(new Contact()
                                .name("Juan David Garzon Ramirez")
                                .email("correo@ejemplo.com")
                                .url("https://www.linkedin.com/in/juan-david-gn-rz/"))
                        .license(new License()
                                .name("MIT")
                                .url("https://opensource.org/licenses/MIT"))
                )
                .externalDocs(new ExternalDocumentation()
                        .description("Repositorio GitHub")
                        .url("https://github.com/Juandavid022/FrameworksMVC2025"));
    }
}
