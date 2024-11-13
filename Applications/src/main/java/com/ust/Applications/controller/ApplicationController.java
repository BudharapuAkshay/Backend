package com.ust.Applications.controller;

import com.ust.Applications.model.Application;
import com.ust.Applications.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    // Apply to a specific talent post (Artist only)
    @PostMapping("/{postId}/apply")
    public Application applyToPost(@PathVariable String postId, @RequestBody Application application) {
        application.setPostId(postId);
        return applicationService.createApplication(application);
    }

    // View all applications for a specific post (Director only)
    @GetMapping("/{postId}/applicants")
    public List<Application> getApplicationsByPostId(@PathVariable String postId) {
        return applicationService.getApplicationsByPostId(postId);
    }

    // View shortlisted applicants for a specific post (Director only)
    @GetMapping("/{postId}/shortlisted")
    public List<Application> getShortlistedApplications(@PathVariable String postId) {
        return applicationService.getShortlistedApplicationsByPostId(postId);
    }

    // Mark an application as shortlisted (Director only)
    @PutMapping("/{applicationId}/shortlist")
    public Application shortlistApplication(@PathVariable String applicationId) {
        return applicationService.updateShortlistStatus(applicationId);
    }

    @PostMapping("/{postId}/notify-shortlisted")
    public ResponseEntity<String> notifyShortlistedArtists(@PathVariable String postId) {
        applicationService.emailShortlistedArtists(postId);
        return ResponseEntity.ok("Emails sent to all shortlisted artists for post ID: " + postId);
    }

    // Delete an application (Admin or Director privileges)
    @DeleteMapping("/{applicationId}")
    public void deleteApplication(@PathVariable String applicationId) {
        applicationService.deleteApplication(applicationId);
    }

    // Endpoint to fetch applications by artist ID
    @GetMapping("/artist/{artistId}")
    public ResponseEntity<List<Application>> getApplicationsByArtistId(@PathVariable String artistId) {
        return ResponseEntity.ok(applicationService.getApplicationsByArtistId(artistId));
    }
}


