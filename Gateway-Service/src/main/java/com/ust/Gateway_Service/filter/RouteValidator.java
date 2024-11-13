package com.ust.Gateway_Service.filter;


import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RouteValidator {
    private static final List<String> openApiEndpoints = List.of(
            "/api/auth/register/**",
            "/api/auth/login",
            "/api/auth/validate-token"
    );

    public boolean isSecured(String path) {
        return openApiEndpoints.stream().noneMatch(path::startsWith);
    }
}

