package com.app.juridico.create_actas;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        String frontendUrl = System.getenv("FRONTEND_URL");
        if (frontendUrl == null || frontendUrl.trim().isEmpty()) {
            frontendUrl = "https://documento-judicial-frontend-lyeh3m01n.vercel.app";
        }

        registry.addMapping("/**")
                .allowedOrigins(frontendUrl.trim(), "http://localhost:5173") // Permite Vercel y tu pruebas locales
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}