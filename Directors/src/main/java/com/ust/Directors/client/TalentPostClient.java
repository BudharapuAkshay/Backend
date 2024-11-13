package com.ust.Directors.client;

import com.ust.Directors.dto.TalentPost;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@FeignClient(name = "talent-posts-service", url = "http://localhost:5959")
public interface TalentPostClient {

    @PostMapping("/api/talent-posts")
    ResponseEntity<TalentPost> createPost(@RequestBody TalentPost post);

    @GetMapping("/api/talent-posts/{postId}")
    ResponseEntity<TalentPost> getPost(@PathVariable String postId);

    @PutMapping("/api/talent-posts/{postId}")
    ResponseEntity<TalentPost> updatePost(@PathVariable String postId, @RequestBody TalentPost post);

    @DeleteMapping("/api/talent-posts/{postId}")
    ResponseEntity<Void> deletePost(@PathVariable String postId);

    @GetMapping("/api/talent-posts/director/{directorId}")
    ResponseEntity<List<TalentPost>> getPostsByDirector(@PathVariable String directorId);
}
