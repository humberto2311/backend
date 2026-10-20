package com.app.juridico.create_actas;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Obtenemos la misma variable que lees en tu CommandLineRunner o permitimos todo para pruebas
        String frontendUrl = System.getenv("FRONTEND_URL");
        if (frontendUrl == null || frontendUrl.trim().isEmpty()) {
            frontendUrl = "http://localhost:5173";
        }

        registry.addMapping("/**")
                .allowedOrigins(frontendUrl, "http://localhost:5173") // Permite Vercel y local
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}