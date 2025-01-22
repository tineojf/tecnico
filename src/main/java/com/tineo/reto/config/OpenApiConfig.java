package com.tineo.reto.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Reto Tecnico",
                version = "1.0",
                description = "API para el reto tecnico de una casa de cambio digital",
                contact = @Contact(
                        name = "Tineo - Backend Developer",
                        url = "https://github.com/tineojf"
                )
        ),
        servers = {
                @Server(
                        url = "http://localhost:8080",
                        description = "Local server"
                )
        }
)
public class OpenApiConfig {
}
