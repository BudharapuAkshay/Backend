package com.ust.Gateway_Service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "authentication-service", url = "http://authentication-service")
public interface AuthenticationServiceClient {

    @GetMapping("/validate-token")
    boolean validateToken(@RequestParam("token") String token);
}

