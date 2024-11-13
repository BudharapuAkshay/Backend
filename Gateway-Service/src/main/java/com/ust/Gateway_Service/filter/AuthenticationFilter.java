package com.ust.Gateway_Service.filter;

import com.ust.Gateway_Service.client.AuthenticationServiceClient;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {

    private final String SECRET_KEY = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";

    @Autowired
    private AuthenticationServiceClient authServiceClient;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws IOException {

        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        // Check if Authorization header is present and starts with "Bearer "
        if (Objects.isNull(authHeader) || !authHeader.startsWith("Bearer ")) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Authorization header is missing or invalid");
            return;
        }

        String token = authHeader.substring(7); // Remove "Bearer " prefix

        try {
            // Call authentication service to validate the token using Feign client
            boolean isValidToken = authServiceClient.validateToken(token);

            if (isValidToken) {
                // If token is valid, continue with the request
                filterChain.doFilter(request, response);
            } else {
                // If token is invalid, return Unauthorized response
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Invalid or expired token");
            }
        } catch (Exception e) {
            // Handle errors in calling the authentication service or token validation
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Authentication service is unavailable or token is invalid");
        }
    }
}

