package com.example.apigetway2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;

@Configuration
public class SpringCloudConfig {

    @Value("${app.angular}")
    private String frontend;

    @Value("${app.Stage6}")
    private String apiStage6;

    @Value("${app.user2}")
    private String apiUser;

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("dashboardsModule", r -> r.path("/dashboards/**").uri(apiStage6))
                .route("chartsModule", r -> r.path("/charts/**").uri(apiStage6))
                .route("datasourcesModule", r -> r.path("/datasources/**").uri(apiStage6))
                .route("portletsModule", r -> r.path("/portlets/**").uri(apiStage6))
                .route("user2Module", r -> r.path("/user2/**").uri(apiUser))
                .route("authModule", r -> r.path("/api/auth/**").uri(apiUser))
                .route("testModule", r -> r.path("/api/test/**").uri(apiUser))
                .route("angular", r -> r.path("/**").uri(frontend))
                .build();
    }

    @Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:4200");  // Replace with your frontend URL
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsWebFilter(source);
    }
}
