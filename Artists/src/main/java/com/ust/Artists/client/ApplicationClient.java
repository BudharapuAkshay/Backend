package com.ust.Artists.client;

import com.ust.Artists.dto.Application;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "application-service", url = "http://localhost:8989")
public interface ApplicationClient {

    @GetMapping("/api/applications/artist/{artistId}")
    ResponseEntity<List<Application>> getApplicationsByArtistId(@PathVariable String artistId);
}
