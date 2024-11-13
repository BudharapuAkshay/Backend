package com.ust.Talent_Post.controller;


import com.ust.Talent_Post.model.TalentPost;
import com.ust.Talent_Post.service.TalentPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/talent-posts")
@CrossOrigin
public class TalentPostController {

    @Autowired
    private TalentPostService service;

    @PostMapping
    public ResponseEntity<TalentPost> createPost(@RequestBody TalentPost post) {
        return ResponseEntity.ok(service.createPost(post));
    }

    @GetMapping("/{postId}")
    public ResponseEntity<TalentPost> getPost(@PathVariable String postId) {
        return service.getPostById(postId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<TalentPost>> getAllPosts() {
        return ResponseEntity.ok(service.getAllPosts());
    }

    @PutMapping("/{postId}")
    public ResponseEntity<TalentPost> updatePost(@PathVariable String postId, @RequestBody TalentPost post) {
        return ResponseEntity.ok(service.updatePost(postId, post));
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable String postId) {
        service.deletePost(postId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/director/{directorId}")
    public ResponseEntity<List<TalentPost>> getPostsByDirector(@PathVariable String directorId) {
        return ResponseEntity.ok(service.getPostsByDirector(directorId));
    }
}