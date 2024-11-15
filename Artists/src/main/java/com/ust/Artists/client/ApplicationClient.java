package com.ust.Artists.client;

import com.ust.Artists.dto.Application;
import com.ust.Artists.dto.ApplicationWithPostResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "application-service", url = "http://localhost:8989")
public interface ApplicationClient {

    @PostMapping("/{artistId}/{postId}/apply")
    ApplicationWithPostResponse applyToPost(@PathVariable("postId") String postId, @PathVariable String artistId, @RequestBody Application application);

    @GetMapping("/api/applications/artist/{artistId}")
    ResponseEntity<List<ApplicationWithPostResponse>> getApplicationsByArtistId(@PathVariable String artistId);
}
