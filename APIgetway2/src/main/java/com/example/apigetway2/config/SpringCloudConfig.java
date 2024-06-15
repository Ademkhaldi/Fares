package com.example.apigetway2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.CorsConfigurationSource;

@Configuration
public class SpringCloudConfig {
    @Value("${app.angular}")
    private String frontend = "";

    @Value("${app.Stage6}")
    private String apiStage6 = "";

    @Value("${app.user2}")
    private String apiUser = "";
/*
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("dashboardsModule", r -> r.path("/dashboards/**")
                        .uri(apiStage6))
                .route("ChartsModule", r -> r.path("/Charts/**")
                        .uri(apiStage6))
                .route("datasourcesModule", r -> r.path("/datasources/**")
                        .uri(apiStage6))
                .route("portletsModule", r -> r.path("/portlets/**")
                        .uri(apiStage6))
                .route("user2Module", r -> r.path("/user2/**")
                        .uri(apiUser))
                .route("AuthModule", r -> r.path("/api/auth/**")
                        .uri(apiUser))
                .route("TestModule", r -> r.path("/api/test/**")
                        .uri(apiUser))
                .route("angular", r -> r.path("/**").uri(frontend))
                .build();
    }

*/
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("dashboardsModule", r -> r.path("/dashboards/**").uri("http://localhost:8099"))
                .route("chartsModule", r -> r.path("/charts/**").uri("http://localhost:8099"))
                .route("datasourcesModule", r -> r.path("/datasources/**").uri("http://localhost:8099"))
                .route("portletsModule", r -> r.path("/portlets/**").uri("http://localhost:8099"))
                .route("user2Module", r -> r.path("/user2/**").uri(apiUser))
                .route("authModule", r -> r.path("/api/auth/**").uri(apiUser))
                .route("testModule", r -> r.path("/api/test/**").uri(apiUser))
                .route("angular", r -> r.path("/**").uri("http://localhost:4200"))
                .build();
    }

    @Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:4200");  // Remove the wildcard if credentials are set to true
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsWebFilter(source);
    }


}
