package com.app.juridico.create_actas.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // Railway debe inyectar esta variable con el origen del frontend.
                // Ej: FRONTEND_URL=https://mi-frontend.railway.app
                String frontendUrl = System.getenv("FRONTEND_URL");
                if (frontendUrl == null || frontendUrl.trim().isEmpty()) {
                    // Default para desarrollo local (cuando no hay envs).
                    frontendUrl = "http://localhost:5173";
                }

                // Soportamos lista separada por comas si quieres permitir mas de un origen.
                String[] origins = frontendUrl.split("\\s*,\\s*");

                // Nota: si usamos '*' NO podemos permitir credenciales en navegadores.
                boolean allowCredentials = !(origins.length == 1 && origins[0].equals("*"));

                registry.addMapping("/api/**") // Aplica a todos los endpoints de la API
                        .allowedOrigins(origins)
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(allowCredentials);
            }
        };


    }

}