package com.ust.Artists.client;

import com.ust.Artists.dto.TalentPost;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "talent-posts-service", url = "http://localhost:5959")
public interface TalentPostClient {

    @GetMapping("/api/talent-posts")
    ResponseEntity<List<TalentPost>> getAllPosts();
}
