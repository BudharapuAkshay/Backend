package com.ust.Directors.client;

import com.ust.Directors.dto.Application;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "Applications", url = "http://localhost:8989")
public interface ApplicationClient {

    @GetMapping("/api/applications/{postId}/applicants")
    List<Application> getApplicationsByPostId(@PathVariable("postId") String postId);

    @GetMapping("/api/applications/{postId}/shortlisted")
    List<Application> getShortlistedApplicationsByPostId(@PathVariable("postId") String postId);

    @PutMapping("/api/applications/{applicationId}/shortlist")
    Application shortlistApplication(@PathVariable("applicationId") String applicationId);

    @PostMapping("/api/applications/{postId}/notify-shortlisted")
    String notifyShortlistedArtists(@PathVariable("postId") String postId);

}