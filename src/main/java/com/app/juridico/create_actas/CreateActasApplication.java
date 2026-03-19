package com.app.juridico.create_actas;

import com.app.juridico.create_actas.domain.services.GeminiService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CreateActasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreateActasApplication.class, args);
	}

	@Bean
	CommandLineRunner logConnectionUrls() {
		return args -> {
			// URL del frontend que autorizamos por CORS.
			// Se recomienda: FRONTEND_URL=https://tu-frontend.railway.app
			String frontendUrl = System.getenv("FRONTEND_URL");
			if (frontendUrl == null || frontendUrl.trim().isEmpty()) {
				frontendUrl = "http://localhost:5173";
			}
			frontendUrl = frontendUrl.trim();

			// Railway suele inyectar alguna de estas variables.
			String railwayBaseUrl = null;
			String[] possibleFullUrlKeys = {
					"RAILWAY_STATIC_URL",
					"RAILWAY_PUBLIC_URL",
					"RAILWAY_URL",
					"APP_URL",
					"PUBLIC_URL"
			};

			for (String key : possibleFullUrlKeys) {
				String value = System.getenv(key);
				if (value != null && !value.trim().isEmpty()) {
					railwayBaseUrl = value.trim();
					break;
				}
			}

			// Si no hay URL completa, intentamos con el "domain" público.
			if (railwayBaseUrl == null) {
				String railwayPublicDomain = System.getenv("RAILWAY_PUBLIC_DOMAIN");
				if (railwayPublicDomain != null && !railwayPublicDomain.trim().isEmpty()) {
					String domain = railwayPublicDomain.trim();
					railwayBaseUrl = domain.contains("://") ? domain : ("https://" + domain);
				}
			}

			// Fallback local si no existe información de Railway.
			if (railwayBaseUrl == null) {
				String port = System.getenv("PORT");
				if (port == null || port.trim().isEmpty()) {
					port = System.getenv("SERVER_PORT");
				}
				if (port == null || port.trim().isEmpty()) {
					port = "8080";
				}
				railwayBaseUrl = "http://localhost:" + port.trim();
			}

			if (railwayBaseUrl.endsWith("/")) {
				railwayBaseUrl = railwayBaseUrl.substring(0, railwayBaseUrl.length() - 1);
			}

			String apiUrlForFrontend = railwayBaseUrl + "/api/document-process";

			System.out.println();
			System.out.println("--- URLS DE CONEXION (startup) ---");
			System.out.println("FRONTEND_URL (CORS): " + frontendUrl);
			System.out.println("RAILWAY_BASE_URL: " + railwayBaseUrl);
			System.out.println("API_URL para el frontend: " + apiUrlForFrontend);
			System.out.println("------------------------------------");
			System.out.println();
		};
	}

	// Esta es la forma correcta de probar algo al iniciar en Spring Boot
	@Bean
	CommandLineRunner testGemini(GeminiService gemini) {
		return args -> {
			System.out.println("--- PROBANDO GEMINI ---");
			String respuesta = gemini.askQuestion("Dame una definición corta de qué es un acta jurídica.");
			System.out.println("Respuesta de Gemini: " + respuesta);
		};
	}
}