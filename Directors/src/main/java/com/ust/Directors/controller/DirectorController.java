package com.ust.Directors.controller;

import com.ust.Directors.client.ApplicationClient;
import com.ust.Directors.client.TalentPostClient;
import com.ust.Directors.dto.Application;
import com.ust.Directors.dto.TalentPost;
import com.ust.Directors.model.Director;
import com.ust.Directors.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/directors")
@CrossOrigin
public class DirectorController {

    @Autowired
    private DirectorService directorService;

    @Autowired
    private ApplicationClient applicationClient;

    @Autowired
    private TalentPostClient talentPostClient;

    // Director endpoints
    @GetMapping
    public List<Director> getAllDirectors() {
        return directorService.getAllDirectors();
    }

    @GetMapping("/{directorId}")
    public Director getDirectorById(@PathVariable String directorId) {
        return directorService.getDirectorById(directorId);
    }

    @PostMapping("/{directorId}")
    public Director addDirector(@PathVariable String directorId, @RequestBody Director director) {
        return directorService.addDirector(directorId, director);
    }

    @PutMapping("/{directorId}")
    public Director updateDirector(@PathVariable String directorId, @RequestBody Director director) {
        return directorService.updateDirector(directorId, director);
    }

    @DeleteMapping("/{directorId}")
    public void deleteDirector(@PathVariable String directorId) {
        directorService.deleteDirector(directorId);
    }

    // Application service endpoints
    @GetMapping("/applications/{postId}/applicants")
    public List<Application> getApplicationsByPostId(@PathVariable String postId) {
        return applicationClient.getApplicationsByPostId(postId);
    }

    @GetMapping("/applications/{postId}/shortlisted")
    public List<Application> getShortlistedApplicationsByPostId(@PathVariable String postId) {
        return applicationClient.getShortlistedApplicationsByPostId(postId);
    }

    @PutMapping("/applications/{applicationId}/shortlist")
    public Application shortlistApplication(@PathVariable String applicationId) {
        return applicationClient.shortlistApplication(applicationId);
    }

    @PostMapping("/applications/{postId}/notify-shortlisted")
    public String notifyShortlistedArtists(@PathVariable String postId) {
        return applicationClient.notifyShortlistedArtists(postId);
    }

    //talent post endpoints
    @PostMapping("/{directorId}/posts")
    public ResponseEntity<TalentPost> createPost(@PathVariable String directorId, @RequestBody TalentPost post) {
        post.setDirectorId(directorId);
        return talentPostClient.createPost(post);
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<TalentPost> getPost(@PathVariable String postId) {
        return talentPostClient.getPost(postId);
    }

    @PutMapping("/posts/{postId}")
    public ResponseEntity<TalentPost> updatePost(@PathVariable String postId, @RequestBody TalentPost post) {
        return talentPostClient.updatePost(postId, post);
    }

    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable String postId) {
        return talentPostClient.deletePost(postId);
    }

    @GetMapping("/{directorId}/posts")
    public ResponseEntity<List<TalentPost>> getPostsByDirector(@PathVariable String directorId) {
        return talentPostClient.getPostsByDirector(directorId);
    }

}
